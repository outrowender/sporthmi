/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.dv.util;

import org.apache.xerces.xs.XSException;
import org.apache.xerces.xs.datatypes.ByteList;

public class ByteListImpl
implements ByteList {
    protected final byte[] data;
    protected String canonical;

    public ByteListImpl(byte[] byArray) {
        this.data = byArray;
    }

    public int getLength() {
        return this.data.length;
    }

    public boolean contains(byte by) {
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            if (this.data[i2] != by) continue;
            return true;
        }
        return false;
    }

    public byte item(int n) throws XSException {
        if (n < 0 || n > this.data.length - 1) {
            throw new XSException(2, null);
        }
        return this.data[n];
    }
}

