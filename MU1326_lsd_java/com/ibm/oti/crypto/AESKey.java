/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.j9.bluez.crypto.AESCipher;
import com.ibm.oti.crypto.CL3BasedKey;
import com.ibm.oti.crypto.Provider;
import java.io.IOException;

public final class AESKey
extends CL3BasedKey {
    public static final int KEY_LENGTH_BYTES = 16;

    public AESKey(Provider provider, byte[] byArray) throws IOException {
        super(provider, byArray);
        this.workingKey = AESCipher.aesKey(byArray, 0, byArray.length, 16);
    }

    public int getMinimumKeyLength() {
        return 16;
    }
}

