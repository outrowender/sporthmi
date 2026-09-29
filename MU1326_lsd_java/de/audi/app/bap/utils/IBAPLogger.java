/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.audi.atip.log.LogChannel;

public interface IBAPLogger {
    default public LogChannel getMainLog() {
    }

    default public LogChannel getDSILog() {
    }

    default public LogChannel getDiagLog() {
    }

    default public LogChannel getLog(int n) {
    }

    default public LogChannel getLogBAPData(int n) {
    }
}

