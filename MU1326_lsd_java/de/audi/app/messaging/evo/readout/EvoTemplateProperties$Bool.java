/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

final class EvoTemplateProperties$Bool {
    static final EvoTemplateProperties$Bool IRRELEVANT = new EvoTemplateProperties$Bool("IRRELEVANT");
    static final EvoTemplateProperties$Bool FALSE = new EvoTemplateProperties$Bool("FALSE");
    static final EvoTemplateProperties$Bool TRUE = new EvoTemplateProperties$Bool("TRUE");
    private final String name;

    private EvoTemplateProperties$Bool(String string) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }
}

