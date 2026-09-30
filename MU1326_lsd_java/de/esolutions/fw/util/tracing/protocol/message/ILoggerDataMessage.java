/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

public interface ILoggerDataMessage {
    public long getLoggerTimeStamp();

    public short getLoggerDataType();

    public short getLoggerMessageType();

    public byte[] getLoggerMessageData();
}

