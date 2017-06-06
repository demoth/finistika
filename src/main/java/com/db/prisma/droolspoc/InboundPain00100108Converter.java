package com.db.prisma.droolspoc;

import com.db.prisma.droolspoc.model.Amount;
import com.db.prisma.droolspoc.model.Directive;
import com.db.prisma.droolspoc.model.Instruction;
import com.db.prisma.droolspoc.model.InstructionGroup;
import com.db.prisma.droolspoc.model.enums.DirectiveType;
import com.db.prisma.droolspoc.pain001.*;

/**
 * Created by daniil on 6/6/17.
 */
public class InboundPain00100108Converter {
     InstructionGroup convert(Document inbound) {
         InstructionGroup instructionGroup = new InstructionGroup();
         GroupHeader48 grpHdr = inbound.getCstmrCdtTrfInitn().getGrpHdr();
         instructionGroup.setGroupId(grpHdr.getMsgId());
         for (PaymentInstruction22 inbountInstr : inbound.getCstmrCdtTrfInitn().getPmtInf()) {
             for (CreditTransferTransaction26 creditTransferTx : inbountInstr.getCdtTrfTxInf()) {
                 Instruction ins = new Instruction();
                 AmountType4Choice amt = creditTransferTx.getAmt();
                 Amount amount = new Amount();
                 EquivalentAmount2 eqvtAmt = amt.getEqvtAmt();
                 ActiveOrHistoricCurrencyAndAmount instdAmt = amt.getInstdAmt();
                 if (eqvtAmt != null) {
                     amount.setAmount(eqvtAmt.getAmt().getValue());
                     amount.setOriginalCcy(eqvtAmt.getCcyOfTrf());
                     amount.setTargetCcy(eqvtAmt.getAmt().getCcy());
                 } else if (instdAmt != null) {
                     amount.setTargetCcy(instdAmt.getCcy());
                     amount.setOriginalCcy(instdAmt.getCcy());
                     amount.setAmount(instdAmt.getValue());
                 }
                 ins.setAmount(amount);
                 Purpose2Choice purp = creditTransferTx.getPurp();
                 if (purp != null) {
                     if (purp.getCd() != null) {
                         ins.getDirectives().add(new Directive(
                                 DirectiveType.PURPOSE_CODE,
                                 purp.getCd()));
                     }
                     if (purp.getPrtry() != null) {
                         ins.getDirectives().add(new Directive(
                                 DirectiveType.PURPOSE_PRTRY,
                                 purp.getPrtry()));
                     }
                 }
             }
         }
         return instructionGroup;
     }
}
