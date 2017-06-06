package com.db.prisma.droolspoc.model;

import com.db.prisma.droolspoc.model.enums.InstructionType;
import lombok.Data;

import java.util.List;

/**
 * Created by daniil on 6/6/17.
 */
@Data
public class Instruction {
    private String txReference;
    private Amount amount;
    private List<Party> involvedParties;
    private InstructionType type;
    private List<Directive> directives;
}
