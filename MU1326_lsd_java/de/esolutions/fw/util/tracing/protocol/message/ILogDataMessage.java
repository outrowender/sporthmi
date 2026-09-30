/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

public interface ILogDataMessage {
    public long getTimeStamp();

    public short getLevel();

    public short getModifiers();

    public int getChannelID();

    public int getSourceID();

    public short getLogType();

    public byte[] getLogData();
}

