/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig;
import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping;

public class CharismaIndivEntryBusinessConfig {
    private final CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping optionMapping;
    private final CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig eventProcessingConfig;
    private final boolean enforceProfileIndivActivation;
    private int availableModelID = -1;

    public CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping charismaIndividualEntryTransactionData$CharismaIndivOptionMapping, CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig, boolean bl) {
        this.optionMapping = charismaIndividualEntryTransactionData$CharismaIndivOptionMapping;
        this.eventProcessingConfig = charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig != null ? charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig : CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
        this.enforceProfileIndivActivation = bl;
    }

    public CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping charismaIndividualEntryTransactionData$CharismaIndivOptionMapping, CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig, boolean bl, int n) {
        this.optionMapping = charismaIndividualEntryTransactionData$CharismaIndivOptionMapping;
        this.eventProcessingConfig = charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig != null ? charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig : CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
        this.enforceProfileIndivActivation = bl;
        this.availableModelID = n;
    }

    public CharismaIndividualEntryTransactionData$CharismaIndivOptionMapping getOptionMapping() {
        return this.optionMapping;
    }

    public CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig getEventProcessingConfig() {
        return this.eventProcessingConfig;
    }

    public int getAvailableModelID() {
        return this.availableModelID;
    }

    public boolean enforceProfileIndivActivation() {
        return this.enforceProfileIndivActivation;
    }
}

