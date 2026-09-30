/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.oti.crypto.Key;
import com.ibm.oti.crypto.Provider;
import java.io.IOException;

public class NullProvider
extends Provider {
    public NullProvider() throws IOException {
        super(6, 0);
    }

    void destroyKey(Key key) {
    }

    void cryptInit(Key key, int n, int n2, byte[] byArray) throws IOException {
    }

    byte[] cryptUpdate(Key key, byte[] byArray, int n, int n2, boolean bl) throws IOException {
        byte[] byArray2 = new byte[n2];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        return byArray2;
    }
}

