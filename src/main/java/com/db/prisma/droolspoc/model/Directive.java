package com.db.prisma.droolspoc.model;

import com.db.prisma.droolspoc.model.enums.DirectiveType;
import lombok.Value;

/**
 * Created by daniil on 6/6/17.
 */
@Value
public class Directive {
    DirectiveType type;
    String value;
}
