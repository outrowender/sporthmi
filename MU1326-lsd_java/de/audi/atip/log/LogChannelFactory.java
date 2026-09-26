/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.log;

import de.audi.atip.log.LogChannel;

public interface LogChannelFactory {
    default public LogChannel getLogChannel(String string) {
    }
}

