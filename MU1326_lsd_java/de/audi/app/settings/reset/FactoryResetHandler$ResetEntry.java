/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.reset;

import de.audi.app.settings.reset.FactoryResetHandler;
import de.audi.app.settings.reset.FactoryResetHandler$1;
import de.esolutions.fw.util.commons.Buffer;

public class FactoryResetHandler$ResetEntry {
    private int messageID;
    private int textID;
    private int checked;
    private int enabled;
    private String description;
    private final /* synthetic */ FactoryResetHandler this$0;

    private FactoryResetHandler$ResetEntry(FactoryResetHandler factoryResetHandler, int n, int n2, String string) {
        this.this$0 = factoryResetHandler;
        this.messageID = n2;
        this.textID = n;
        this.checked = 0;
        this.enabled = 1;
        this.description = string;
    }

    protected int getMessageID() {
        return this.messageID;
    }

    protected int getTextID() {
        return this.textID;
    }

    public int getEnabled() {
        return this.enabled;
    }

    protected int getChecked() {
        return this.checked;
    }

    protected String getDescription() {
        return this.description;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ResetEntry[textID='").append(this.textID).append("',");
        buffer.append("messageID='").append(this.messageID).append("',");
        buffer.append("checked='").append(this.checked).append("',");
        buffer.append("enabled='").append(this.enabled).append("',");
        buffer.append("description='").append(this.description).append("']");
        return buffer.toString();
    }

    /* synthetic */ FactoryResetHandler$ResetEntry(FactoryResetHandler factoryResetHandler, int n, int n2, String string, FactoryResetHandler$1 factoryResetHandler$1) {
        this(factoryResetHandler, n, n2, string);
    }

    static /* synthetic */ int access$102(FactoryResetHandler$ResetEntry factoryResetHandler$ResetEntry, int n) {
        factoryResetHandler$ResetEntry.enabled = n;
        return factoryResetHandler$ResetEntry.enabled;
    }

    static /* synthetic */ int access$202(FactoryResetHandler$ResetEntry factoryResetHandler$ResetEntry, int n) {
        factoryResetHandler$ResetEntry.checked = n;
        return factoryResetHandler$ResetEntry.checked;
    }

    static /* synthetic */ int access$200(FactoryResetHandler$ResetEntry factoryResetHandler$ResetEntry) {
        return factoryResetHandler$ResetEntry.checked;
    }
}

