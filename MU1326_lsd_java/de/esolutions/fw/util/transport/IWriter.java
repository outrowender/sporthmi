/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.exception.TransportException;

public interface IWriter {
    public int size();

    public void write(IWriteable var1) throws TransportException;

    public void setDebugTag(Object var1);

    public Object getDebugTag();
}

