/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.ChoiceModelHandlerAdapter;
import de.audi.app.car.core.charisma.CharismaIndivEntryBusinessConfig;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData;
import de.audi.app.car.core.charisma.CharismaIndividualEventBusiness;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;

public class CharismaIndividualChoiceModelHandler
extends ChoiceModelHandlerAdapter {
    private CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping optionMapping;

    public CharismaIndividualChoiceModelHandler(ChoiceModelApp choiceModelApp, LogChannel logChannel) {
        super(choiceModelApp, logChannel);
    }

    public void updateOnItemSelected(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaIndividualChoiceModelHandler#updateOnItemSelected] modelID='%1' , itemID='%2'", (long)this.getHandledModelID(), (long)n);
        }
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processItemSelected(this.createTransactionData(n), (ChoiceModelHandler)this);
        }
    }

    public void updateOnKeyPressed(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[CharismaIndividualChoiceModelHandler#updateOnKeyPressed] modelID='%1' , keyID='%2'", (long)this.getHandledModelID(), (long)n);
        }
        if (this.getBusiness() != null) {
            this.getChoiceModelBusiness().processKeyPressed(this.createTransactionData(n), (ButtonModelHandler)this);
        }
    }

    protected CharismaIndividualEntryTransactionData createTransactionData(int n) {
        CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData = new CharismaIndividualEntryTransactionData(this.getOptionMapping());
        charismaIndividualEntryTransactionData.setData(n, this);
        return charismaIndividualEntryTransactionData;
    }

    public void setBusiness(CharismaIndividualEventBusiness charismaIndividualEventBusiness, CharismaIndivEntryBusinessConfig charismaIndivEntryBusinessConfig) {
        super.setBusiness(charismaIndividualEventBusiness);
        this.setOptionMapping(charismaIndivEntryBusinessConfig.getOptionMapping());
        charismaIndividualEventBusiness.init(this, charismaIndivEntryBusinessConfig);
    }

    public void updateOnItemFocused(int n) {
    }

    protected void setHintsToConfigureEntriesInComboBox(CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData) {
        this.getChoiceModel().resetHints();
        this.getChoiceModel().addHint(charismaIndividualEntryTransactionData.getHint());
        this.getChoiceModel().forceUpdate(true);
        this.getChoiceModel().setValue(this.getChoiceModel().getValue());
    }

    public void updateDSIOption(CharismaIndividualEntryTransactionData charismaIndividualEntryTransactionData) {
        this.getChoiceModel().setValue(charismaIndividualEntryTransactionData.getDataID(this));
    }

    private CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping getOptionMapping() {
        return this.optionMapping;
    }

    private void setOptionMapping(CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping charismaIndivOptionMapping) {
        this.optionMapping = charismaIndivOptionMapping;
    }
}

