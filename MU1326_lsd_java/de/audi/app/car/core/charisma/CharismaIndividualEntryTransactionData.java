/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.core.charisma.CharismaIndivOption;
import de.audi.app.car.core.charisma.CharismaIndividualChoiceModelHandler;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;

public class CharismaIndividualEntryTransactionData
implements HandlerTransactionData {
    private int hint;
    private CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping mapper;
    private CharismaIndivOption option;
    public static final CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping DEFAULT_MAPPER = CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping.DDB_TO_DSI_PROFILE_MAPPER;

    public CharismaIndividualEntryTransactionData() {
        this.mapper = DEFAULT_MAPPER;
        this.option = this.mapper.getDefaultOption();
    }

    public CharismaIndividualEntryTransactionData(CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping charismaIndividualEntryTransactionData$CharismaIndivOptionMapping) {
        this.mapper = charismaIndividualEntryTransactionData$CharismaIndivOptionMapping != null ? charismaIndividualEntryTransactionData$CharismaIndivOptionMapping : DEFAULT_MAPPER;
        this.option = this.mapper.getDefaultOption();
    }

    private CharismaIndivOption getOption() {
        return this.option;
    }

    protected void setOption(CharismaIndivOption charismaIndivOption) {
        this.option = charismaIndivOption;
    }

    public void setData(int n, CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        this.setOption(this.mapper.getOptionByDsiID(n));
    }

    public void setData(int n, CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler) {
        this.setOption(this.mapper.getOptionByID(n));
    }

    public int getDataID(CharismaIndividualEventBusiness charismaIndividualEventBusiness) {
        return this.getOption().getDsiOption();
    }

    public int getDataID(CharismaIndividualChoiceModelHandler charismaIndividualChoiceModelHandler) {
        return this.getOption().getOptionID();
    }

    public void setHint(int n) {
        this.hint = this.mapper.getHintsForMask(n);
    }

    public int getHint() {
        return this.hint;
    }
}

