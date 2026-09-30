/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.WriteableWindow;
import de.esolutions.fw.util.transport.exception.TransportBufferException;

public interface IWriteable {
    public int size();

    public void setData(byte[] var1) throws TransportBufferException;

    public void setData(int var1, byte[] var2) throws TransportBufferException;

    public void setData(int var1, byte[] var2, int var3) throws TransportBufferException;

    public WriteableWindow setWindow(WriteableWindow var1) throws TransportBufferException;

    public WriteableWindow setLocalWindow(int var1, int var2) throws TransportBufferException;

    public void resetWindow();

    public byte[] getDirectData();

    public int getDirectOffset();
}

