package com.db.prisma.droolspoc.model;

import lombok.Data;

import java.util.List;

/**
 * Created by daniil on 6/6/17.
 */
@Data
public class InstructionGroup {
    private String groupId;
    private List<Instruction> instructions;
}
