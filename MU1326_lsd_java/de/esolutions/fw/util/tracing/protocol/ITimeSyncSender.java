/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol;

import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public interface ITimeSyncSender {
    public void sendTimeSync(long var1, byte var3, byte var4) throws TransportException, IOException, InterruptedException;
}

