/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

import de.audi.app.bap.fw.functiontypes.AcknowledgeWatchdog$AcknowledgeWatchdogListener;

public interface AcknowledgeWatchdog {
    default public void activate() {
    }

    default public void deactivate() {
    }

    default public void setListener(AcknowledgeWatchdog$AcknowledgeWatchdogListener acknowledgeWatchdog$AcknowledgeWatchdogListener) {
    }
}

