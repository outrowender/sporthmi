/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.nio;

public interface BufferUtil {
    public boolean isDirect();

    public int getDirectPointer();

    public boolean hasArray();
}

