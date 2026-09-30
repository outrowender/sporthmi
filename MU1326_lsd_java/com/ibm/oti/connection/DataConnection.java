/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.InputConnection;
import javax.microedition.io.OutputConnection;

public abstract class DataConnection
implements InputConnection,
OutputConnection {
    public abstract void close() throws IOException;

    public abstract InputStream openInputStream() throws IOException;

    public abstract OutputStream openOutputStream() throws IOException;

    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(this.openInputStream());
    }

    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(this.openOutputStream());
    }
}

