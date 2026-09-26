/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

public abstract class Commands$AbstractContextPayload {
    private final String contextName;

    protected Commands$AbstractContextPayload(String string) {
        this.contextName = string;
    }

    public final String getContextName() {
        return this.contextName;
    }
}

