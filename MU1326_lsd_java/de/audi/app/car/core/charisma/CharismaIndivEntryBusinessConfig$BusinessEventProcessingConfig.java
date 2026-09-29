/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.charisma;

public class CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig {
    private static final int PROCESS_ITEM_SELECTED_ONLY;
    private static final int PROCESS_KEY_PRESSED_ONLY;
    private final int eventProcessConfigID;
    private final String eventProcessConfigName;
    public static final CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY;
    public static final CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig EVENT_PROCESS_CONFIG_KEY_PRESSED_ONLY;

    private CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig(String string, int n) {
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
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig = (CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig)object;
        return this.eventProcessConfigID == charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig.eventProcessConfigID;
    }

    public boolean equalsConfig(CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig) {
        return this.getEventProcessConfigID() == charismaIndivEntryBusinessConfig$BusinessEventProcessingConfig.getEventProcessConfigID();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(70);
        stringBuffer.append(this.getEventProcessConfigName()).append("('").append(this.getEventProcessConfigID()).append("')");
        return stringBuffer.toString();
    }

    static {
        EVENT_PROCESS_CONFIG_ITEM_SELECTED_ONLY = new CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig("PROCESS_ITEM_SELECTED_ONLY", 0);
        EVENT_PROCESS_CONFIG_KEY_PRESSED_ONLY = new CharismaIndivEntryBusinessConfig$BusinessEventProcessingConfig("PROCESS_KEY_PRESSED_ONLY", 1);
    }
}

