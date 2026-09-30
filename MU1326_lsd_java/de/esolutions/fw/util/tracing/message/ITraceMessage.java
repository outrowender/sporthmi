/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

public interface ITraceMessage {
    public long getTimeStamp();

    public short getLevel();

    public short getModifiers();

    public int getChannelID();

    public int getThreadID();

    public short getMessageType();

    public String[] getDecodedMessage();

    public String getMessageString();

    public int getMessageSize();

    public byte[] getMessageData();

    public void setEpoch(int var1);

    public int getEpoch();

    public void setSeqNum(int var1);

    public int getSeqNum();

    public void expandNow();

    public void setChannelID(int var1);

    public void setThreadID(int var1);

    public void setDecodedMessage(String[] var1);

    public void setTimeStamp(long var1);
}

