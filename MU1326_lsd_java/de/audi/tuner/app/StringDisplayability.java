/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.StringDisplayability$Result;

public class StringDisplayability {
    private final int[] charArr = new int[2048];

    public void addLookupTable(int[] nArray) {
        if (nArray.length != this.charArr.length) {
            throw new IllegalArgumentException("[StringDisplayability.addLookupTable] wrong length");
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = i2;
            this.charArr[n] = this.charArr[n] | nArray[i2];
        }
    }

    public StringDisplayability$Result check(String string) {
        int n = 0;
        int n2 = 0;
        char[] cArray = string.toCharArray();
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            int n3 = cArray[i2] / 32;
            int n4 = cArray[i2] % 32;
            if ((this.charArr[n3] & 1 << n4) != 0) {
                ++n;
                continue;
            }
            ++n2;
        }
        return new StringDisplayability$Result(cArray.length, n, n2, null);
    }
}

