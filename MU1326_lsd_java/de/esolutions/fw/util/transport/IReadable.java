/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.exception.TransportBufferException;

public interface IReadable {
    public int size();

    public byte[] getData() throws TransportBufferException;

    public byte[] getData(int var1, int var2) throws TransportBufferException;

    public byte[] getDirectData();

    public int getDirectOffset();

    public IReadable createSubBuffer(int var1, int var2) throws TransportBufferException;

    public void setDebugTag(Object var1);

    public Object getDebugTag();
}

