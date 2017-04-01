package com.db.prisma.droolspoc;

import com.db.prisma.droolspoc.generation.Pain00100108Generator;
import com.db.prisma.droolspoc.pain001.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static int sleep = 1;

    public static void main(String[] args) throws IOException, SAXException, JAXBException {
        final AtomicLong instructionsTotal = new AtomicLong();
        final AtomicLong generatedTotal = new AtomicLong();
        final AtomicLong marshalledTotal = new AtomicLong();
        final AtomicLong validatedTotal = new AtomicLong();
        long startTime = new Date().getTime();

        final ConcurrentLinkedQueue<Document> generated = new ConcurrentLinkedQueue<>();
        final ConcurrentLinkedQueue<String> marshalled = new ConcurrentLinkedQueue<>();
        Thread generatorThread = new Thread(new Runnable() {
            Pain00100108Generator generator;

            {
                generator = new Pain00100108Generator();
                generator.maxInBatch = 5;
                generator.batchMax = 5;
            }

            @Override
            public void run() {
                Thread.currentThread().setName("Generator thread");
                while (true) {
                    Document pain = generator.generate();
                    instructionsTotal.addAndGet(Long.parseLong(pain.getCstmrCdtTrfInitn().getGrpHdr().getNbOfTxs()));
                    generated.add(pain);
                    generatedTotal.incrementAndGet();
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        System.out.println("Generator thread exiting");
                    }
                }
            }
        });
        Thread marshallerThread = new Thread(new Runnable() {
            JAXBContext jc = JAXBContext.newInstance("com.db.prisma.droolspoc.pain001");
            Marshaller marshaller = jc.createMarshaller();

            @Override
            public void run() {
                Thread.currentThread().setName("Marshaller thread");
                while (true) {
                    try {
                        Document poll = generated.poll();
                        if (poll != null) {
                            StringWriter xml = new StringWriter();
                            marshaller.marshal(poll, xml);
                            marshalled.add(xml.toString());
                            marshalledTotal.incrementAndGet();
                        }
                        Thread.sleep(sleep);
                    } catch (Exception e) {
                        System.out.println("Marshaller thread exiting");
                    }

                }
            }
        });
        Thread validatorThread = new Thread(new Runnable() {
            Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new StreamSource(new File("xsd/pain.001.001.08.xsd")));

            Validator validator = schema.newValidator();


            @Override
            public void run() {
                Thread.currentThread().setName("Validator thread");
                while (true) {
                    try {
                        String poll = marshalled.poll();
                        if (poll != null) {
                            validator.validate(new StreamSource(new StringReader(poll)));
                            validatedTotal.incrementAndGet();
                        }
                        Thread.sleep(sleep);
                    } catch (Exception e) {
                        System.out.println("Validator thread exiting");
                    }

                }
            }
        });
        Thread infoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Info thread");
                while (true) {
                    try {
                        System.out.println();
                        System.out.println("Time passed:" + (new Date().getTime() - startTime) / 60000.0 + " min");
                        System.out.println("Generated queue size:" + generated.size());
                        System.out.println("Marshalled queue size:" + marshalled.size());
                        System.out.println("generatedTotal = " + generatedTotal.get());
                        System.out.println("marshalledTotal = " + marshalledTotal.get());
                        System.out.println("validatedTotal = " + validatedTotal.get());
                        System.out.println("instructionsTota = " + instructionsTotal.get());
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("Info thread exiting");
                    }
                }
            }
        });

        generatorThread.start();
        marshallerThread.start();
        validatorThread.start();
        infoThread.start();
    }
}
