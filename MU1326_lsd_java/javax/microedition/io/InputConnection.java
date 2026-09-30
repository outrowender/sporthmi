/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.io.Connection;

public interface InputConnection
extends Connection {
    public DataInputStream openDataInputStream() throws IOException;

    public InputStream openInputStream() throws IOException;
}

