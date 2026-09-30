/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.DES;
import com.ibm.oti.crypto.CL3BasedKey;
import com.ibm.oti.crypto.Provider;
import java.io.IOException;

public final class TripleDESKey
extends CL3BasedKey {
    public static final int KEY_LENGTH_BYTES = 24;

    public TripleDESKey(Provider provider, byte[] byArray) throws IOException {
        super(provider, byArray);
        this.workingKey = DES.desKey(byArray, 0, byArray.length);
    }

    public int getMinimumKeyLength() {
        return 24;
    }
}

