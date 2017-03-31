package com.db.prisma.droolspoc.validatexsd;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import java.io.IOException;

/**
 * Created by demoth on 31.03.2017.
 */
public class XsdValidator {
    private Schema schema;

    public void validate(Source source) throws IOException, SAXException {
        Validator validator = schema.newValidator();
        validator.validate(source);
    }
}
