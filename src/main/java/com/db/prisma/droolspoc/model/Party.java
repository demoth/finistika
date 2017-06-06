package com.db.prisma.droolspoc.model;

import com.db.prisma.droolspoc.model.enums.PartyType;
import lombok.Data;

/**
 * Created by daniil on 6/6/17.
 */
@Data
public class Party {
    private String id;
    private PartyType type;
}