/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import java.io.Serializable;
import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class AlphanumericGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID = 20060120L;
    private boolean wrapping = true;
    private char[] count = null;
    private static final char Z_CHAR = 'z';
    private static final char NINE_CHAR = '9';

    public AlphanumericGenerator(boolean bl) {
        this(bl, 15);
    }

    public AlphanumericGenerator(boolean bl, int n) {
        this.wrapping = bl;
        if (n < 1) {
            throw new IllegalArgumentException("The size must be at least one");
        }
        this.count = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.count[i2] = 48;
        }
    }

    public AlphanumericGenerator(boolean bl, String string) {
        this.wrapping = bl;
        this.count = string.toCharArray();
        for (int i2 = 0; i2 < this.count.length; ++i2) {
            char c2 = this.count[i2];
            if (c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z') continue;
            throw new IllegalArgumentException("character " + this.count[i2] + " is not valid");
        }
    }

    public long maxLength() {
        return this.count.length;
    }

    public long minLength() {
        return this.count.length;
    }

    public boolean isWrap() {
        return this.wrapping;
    }

    public void setWrap(boolean bl) {
        this.wrapping = bl;
    }

    public int getSize() {
        return this.count.length;
    }

    public synchronized String nextStringIdentifier() {
        block4: for (int i2 = this.count.length - 1; i2 >= 0; --i2) {
            switch (this.count[i2]) {
                case 'z': {
                    if (i2 == 0 && !this.wrapping) {
                        throw new IllegalStateException("The maximum number of identifiers has been reached");
                    }
                    this.count[i2] = 48;
                    continue block4;
                }
                case '9': {
                    this.count[i2] = 97;
                    i2 = -1;
                    continue block4;
                }
                default: {
                    int n = i2;
                    this.count[n] = (char)(this.count[n] + '\u0001');
                    i2 = -1;
                }
            }
        }
        return new String(this.count);
    }
}

