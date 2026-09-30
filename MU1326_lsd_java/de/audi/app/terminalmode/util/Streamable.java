/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface Streamable {
    public void writeToStream(DataOutputStream var1) throws IOException;

    public static interface Creator {
        public Object readFromStream(DataInputStream var1) throws IOException, IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException;
    }
}

