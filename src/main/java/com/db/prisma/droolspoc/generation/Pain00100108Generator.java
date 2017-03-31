package com.db.prisma.droolspoc.generation;

import com.db.prisma.droolspoc.pain001.*;
import com.mifmif.common.regex.Generex;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.iban4j.Iban;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Pain00100108Generator {
    Random random;
    private List<String> words;
    private List<String> companies;
    private List<String> ccy;
    private List<String> countries;
    private Generex generexBICFI;
    private Generex generexCd;
    private XMLGregorianCalendarImpl today;


    public Pain00100108Generator() throws IOException {
        random = new SecureRandom();
        words = Files.readAllLines(Paths.get("samples", "words.txt"));
        companies = Files.readAllLines(Paths.get("samples", "companies.txt"));
        ccy = Files.readAllLines(Paths.get("samples", "ccy.txt"));
        countries = Files.readAllLines(Paths.get("samples", "coutries.txt"));
        today = new XMLGregorianCalendarImpl(new GregorianCalendar());
        generexBICFI = new Generex("[A-Z]{6,6}[A-Z2-9][A-NP-Z0-9]([A-Z0-9]{3,3}){0,1}");
        generexCd = new Generex("[A-Z0-9]{1,5}");
    }

    public Document generate(int batchMax) {
        BigDecimal ctrlSum = new BigDecimal(0);
        int instrCount = 0;
        Document document = new Document();
        {
            CustomerCreditTransferInitiationV08 cstmrCdtTrfInitn = new CustomerCreditTransferInitiationV08();
            {
                GroupHeader48 grpHdr = new GroupHeader48();
                {
                    grpHdr.setInitgPty(createParty());
                    grpHdr.setMsgId(getId());
                    grpHdr.setCreDtTm(today);
                }
                cstmrCdtTrfInitn.setGrpHdr(grpHdr);
                for (int batch = 0; batch < batchMax; batch++) {
                    PaymentInstruction22 instruction = new PaymentInstruction22();
                    {
                        instruction.setBtchBookg(random.nextBoolean());
                        instruction.setPmtInfId(getId());
                        switch (random.nextInt(3)) {
                            case 0:
                                instruction.setPmtMtd(PaymentMethod3Code.CHK);
                                break;
                            case 1:
                                instruction.setPmtMtd(PaymentMethod3Code.TRA);
                                break;
                            default:
                                instruction.setPmtMtd(PaymentMethod3Code.TRF);
                        }
                        int instrInBatch = random.nextInt(200);
                        if (random.nextBoolean())
                            instruction.setNbOfTxs(String.valueOf(instrInBatch));
                        {
                            DateAndDateTimeChoice reqdExctnDt = new DateAndDateTimeChoice();
                            reqdExctnDt.setDtTm(today);
                            instruction.setReqdExctnDt(reqdExctnDt);
                        }
                        instruction.setDbtr(createParty());
                        instruction.setDbtrAcct(createAccount());
                        instruction.setDbtrAgt(crateAgent());
                        if (random.nextBoolean())
                            instruction.setDbtrAgtAcct(createAccount());
                        if (random.nextBoolean())
                            instruction.setChrgsAcct(createAccount());
                        if (random.nextBoolean()) {
                            switch (random.nextInt(4)) {
                                case 0:
                                    instruction.setChrgBr(ChargeBearerType1Code.CRED);
                                    break;
                                case 1:
                                    instruction.setChrgBr(ChargeBearerType1Code.DEBT);
                                    break;
                                case 2:
                                    instruction.setChrgBr(ChargeBearerType1Code.SHAR);
                                    break;
                                default:
                                    instruction.setChrgBr(ChargeBearerType1Code.SLEV);
                                    break;
                            }
                        }
                        for (int i = 0; i < instrInBatch; i++) {
                            CreditTransferTransaction26 transfer = new CreditTransferTransaction26();
                            {
                                AmountType4Choice value = new AmountType4Choice();
                                ActiveOrHistoricCurrencyAndAmount amt = new ActiveOrHistoricCurrencyAndAmount();
                                amt.setValue(new BigDecimal(Math.max(10, random.nextInt())));
                                amt.setCcy(getWord(ccy));
                                ctrlSum = ctrlSum.add(amt.getValue());
                                if (random.nextBoolean()) {
                                    EquivalentAmount2 eqvtAmt = new EquivalentAmount2();
                                    eqvtAmt.setCcyOfTrf(getWord(ccy)); // no fx =)
                                    eqvtAmt.setAmt(amt);
                                    value.setEqvtAmt(eqvtAmt);
                                } else {
                                    value.setInstdAmt(amt);
                                }
                                transfer.setAmt(value);
                            }
                            {
                                PaymentIdentification1 pmtId = new PaymentIdentification1();
                                pmtId.setEndToEndId(getId());
                                pmtId.setInstrId(getId());
                                transfer.setPmtId(pmtId);
                            }

                            transfer.setCdtr(createParty());
                            transfer.setCdtrAcct(createAccount());
                            transfer.setCdtrAgt(crateAgent());
                            instruction.getCdtTrfTxInf().add(transfer);
                            instrCount++;
                        }
                    }
                    cstmrCdtTrfInitn.getPmtInf().add(instruction);
                }
                grpHdr.setNbOfTxs(String.valueOf(instrCount));
                grpHdr.setCtrlSum(ctrlSum);
            }
            document.setCstmrCdtTrfInitn(cstmrCdtTrfInitn);
        }
        return document;
    }

    private BranchAndFinancialInstitutionIdentification5 crateAgent() {
        BranchAndFinancialInstitutionIdentification5 dbtrAgt = new BranchAndFinancialInstitutionIdentification5();
        FinancialInstitutionIdentification8 finInstnId = new FinancialInstitutionIdentification8();
        if (random.nextBoolean()) {
            finInstnId.setBICFI(generexBICFI.random());
        }
        if (random.nextBoolean()) {
            ClearingSystemMemberIdentification2 clrSysMmbId = new ClearingSystemMemberIdentification2();
            clrSysMmbId.setMmbId(getWord(words));
            ClearingSystemIdentification2Choice clrSysId = new ClearingSystemIdentification2Choice();
            clrSysId.setCd(generexCd.random());
            clrSysMmbId.setClrSysId(clrSysId);
            finInstnId.setClrSysMmbId(clrSysMmbId);
        }
        if (random.nextBoolean())
            finInstnId.setNm(getWord(words));
        dbtrAgt.setFinInstnId(finInstnId);
        return dbtrAgt;
    }

    private CashAccount24 createAccount() {
        CashAccount24 dbtrAcct = new CashAccount24();
        if (random.nextBoolean())
            dbtrAcct.setCcy(getWord(ccy));
        if (random.nextBoolean())
            dbtrAcct.setNm(getWord(words));
        if (random.nextBoolean()) {
            CashAccountType2Choice tp = new CashAccountType2Choice();
            tp.setPrtry(getWord(words));
            dbtrAcct.setTp(tp);
        }
        AccountIdentification4Choice id = new AccountIdentification4Choice();
        id.setIBAN(Iban.random().toString());
        dbtrAcct.setId(id);
        return dbtrAcct;
    }

    private String getId() {
        return UUID.randomUUID().toString().substring(0, 35);
    }

    private PartyIdentification43 createParty() {
        PartyIdentification43 initgPty = new PartyIdentification43();
        {
            if (random.nextFloat() > 0.05f)
                initgPty.setNm(getTitle());
            if (random.nextFloat() > 0.05f)
                initgPty.setCtryOfRes(getWord(countries));
            Party11Choice id = new Party11Choice();
            OrganisationIdentification8 orgId = new OrganisationIdentification8();
            if (random.nextFloat() > 0.05f)
                orgId.setAnyBIC(generexBICFI.random());
            GenericOrganisationIdentification1 genericOrganisationIdentification1 = new GenericOrganisationIdentification1();
            genericOrganisationIdentification1.setId(getId());
            orgId.getOthr().add(genericOrganisationIdentification1);
            id.setOrgId(orgId);
            initgPty.setId(id);
        }
        return initgPty;
    }

    private String getTitle() {
        return getWord(words) + " " + getWord(companies);
    }

    private String getWord(List<String> words) {
        return words.get(random.nextInt(words.size()));
    }
}
