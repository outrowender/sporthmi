/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

public interface AcknowledgeWatchdog {
    public void activate();

    public void deactivate();

    public void setListener(AcknowledgeWatchdogListener var1);

    public static interface AcknowledgeWatchdogListener {
        public void acknowledgeMissing();
    }
}

