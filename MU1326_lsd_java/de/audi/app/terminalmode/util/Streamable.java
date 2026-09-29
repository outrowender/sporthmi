/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.util;

import java.io.DataOutputStream;

public interface Streamable {
    default public void writeToStream(DataOutputStream dataOutputStream) {
    }
}

