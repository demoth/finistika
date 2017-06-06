package com.db.prisma.droolspoc.model;

import com.db.prisma.droolspoc.model.enums.AmountType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by daniil on 6/6/17.
 */
@Data
public class Amount {
    private String originalCcy;
    private String targetCcy;
    private BigDecimal amount;
    private AmountType type;
}
