package com.db.prisma.droolspoc.generation;

import com.db.prisma.droolspoc.pain001.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Random;

class Pain00100108GeneratorTest {
    Pain00100108Generator generator;
    private Schema schema;


    @BeforeEach
    void setup() throws Exception {
        generator = new Pain00100108Generator();
        generator.random = new Random(42);
        schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                .newSchema(new StreamSource(new File("xsd/pain.001.001.08.xsd")));
    }

    @Test
    void generate() throws IOException, org.xml.sax.SAXException, JAXBException {
        Document result = generator.generate(200);
        StringWriter xml = new StringWriter();
        JAXBContext jc = JAXBContext.newInstance("com.db.prisma.droolspoc.pain001");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(result, xml);
        System.out.println("Marshall - ok!");
        validate(new StreamSource(new StringReader(xml.toString())));
        System.out.println("Validate - ok!");
    }

    private void validate(Source source) throws IOException, SAXException {
        Validator validator = schema.newValidator();
        validator.validate(source);

    }

    @Test
    public void validatePain() throws IOException, SAXException {
        validate(new StreamSource(new File("sample.xml")));
    }
}