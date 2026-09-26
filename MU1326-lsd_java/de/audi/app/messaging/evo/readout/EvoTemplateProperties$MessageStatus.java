/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

final class EvoTemplateProperties$MessageStatus {
    static final EvoTemplateProperties$MessageStatus IRRELEVANT = new EvoTemplateProperties$MessageStatus("IRRELEVANT");
    static final EvoTemplateProperties$MessageStatus RECEIVED = new EvoTemplateProperties$MessageStatus("RECEIVED");
    static final EvoTemplateProperties$MessageStatus SENT = new EvoTemplateProperties$MessageStatus("SENT");
    static final EvoTemplateProperties$MessageStatus DRAFT = new EvoTemplateProperties$MessageStatus("DRAFT");
    static final EvoTemplateProperties$MessageStatus OUTBOX = new EvoTemplateProperties$MessageStatus("OUTBOX");
    private final String name;

    private EvoTemplateProperties$MessageStatus(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

