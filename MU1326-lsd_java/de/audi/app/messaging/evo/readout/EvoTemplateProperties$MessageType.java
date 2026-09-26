/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

final class EvoTemplateProperties$MessageType {
    static final EvoTemplateProperties$MessageType IRRELEVANT = new EvoTemplateProperties$MessageType("IRRELEVANT");
    static final EvoTemplateProperties$MessageType SMS = new EvoTemplateProperties$MessageType("SMS");
    static final EvoTemplateProperties$MessageType EMAIL = new EvoTemplateProperties$MessageType("EMAIL");
    private final String name;

    private EvoTemplateProperties$MessageType(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

