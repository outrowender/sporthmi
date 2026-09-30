/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

import de.audi.app.car.core.charisma.CharismaIndividualEntryTransactionData;

public class CharismaIndivEntryBusinessConfig {
    private final CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping optionMapping;
    private final BusinessEventProcessingConfig eventProcessingConfig;
    private final boolean enforceProfileIndivActivation;
    private int availableModelID = -1;

    public CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping charismaIndivOptionMapping, BusinessEventProcessingConfig businessEventProcessingConfig, boolean bl) {
        this.optionMapping = charismaIndivOptionMapping;
        this.eventProcessingConfig = businessEventProcessingConfig != null ? businessEventProcessingConfig : BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
        this.enforceProfileIndivActivation = bl;
    }

    public CharismaIndivEntryBusinessConfig(CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping charismaIndivOptionMapping, BusinessEventProcessingConfig businessEventProcessingConfig, boolean bl, int n) {
        this.optionMapping = charismaIndivOptionMapping;
        this.eventProcessingConfig = businessEventProcessingConfig != null ? businessEventProcessingConfig : BusinessEventProcessingConfig.EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
        this.enforceProfileIndivActivation = bl;
        this.availableModelID = n;
    }

    public CharismaIndividualEntryTransactionData.CharismaIndivOptionMapping getOptionMapping() {
        return this.optionMapping;
    }

    public BusinessEventProcessingConfig getEventProcessingConfig() {
        return this.eventProcessingConfig;
    }

    public int getAvailableModelID() {
        return this.availableModelID;
    }

    public boolean enforceProfileIndivActivation() {
        return this.enforceProfileIndivActivation;
    }

    public static class BusinessEventProcessingConfig {
        private static final int PROCESS_ITEM_SELECTED_ONLY = 0;
        private static final int PROCESS_KEY_PRESSED_ONLY = 1;
        private final int eventProcessConfigID;
        private final String eventProcessConfigName;
        public static final BusinessEventProcessingConfig EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY = new BusinessEventProcessingConfig("PROCESS_ITEM_SELECTED_ONLY", 0);
        public static final BusinessEventProcessingConfig EVENT_PROCESS_CONFIG_KEY_PRESSED_ONLY = new BusinessEventProcessingConfig("PROCESS_KEY_PRESSED_ONLY", 1);

        private BusinessEventProcessingConfig(String string, int n) {
            this.eventProcessConfigName = string;
            this.eventProcessConfigID = n;
        }

        public int getEventProcessConfigID() {
            return this.eventProcessConfigID;
        }

        public String getEventProcessConfigName() {
            return this.eventProcessConfigName;
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + this.eventProcessConfigID;
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            BusinessEventProcessingConfig businessEventProcessingConfig = (BusinessEventProcessingConfig)object;
            return this.eventProcessConfigID == businessEventProcessingConfig.eventProcessConfigID;
        }

        public boolean equalsConfig(BusinessEventProcessingConfig businessEventProcessingConfig) {
            return this.getEventProcessConfigID() == businessEventProcessingConfig.getEventProcessConfigID();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(70);
            stringBuffer.append(this.getEventProcessConfigName()).append("('").append(this.getEventProcessConfigID()).append("')");
            return stringBuffer.toString();
        }
    }
}

