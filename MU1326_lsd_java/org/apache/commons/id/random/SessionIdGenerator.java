/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.random;

import java.io.Serializable;
import java.util.Random;
import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class SessionIdGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID = 20060118L;
    private static final long MAX_RANDOM_LEN = 2176782336L;
    private static final long MAX_TIME_SECTION_LEN = 46656L;
    private static final long TIC_DIFFERENCE = 2000L;
    private static final int RANDOM_LENGTH = 6;
    private static final int TIME_LENGTH = 3;
    private int counter = 0;
    private long lastTimeValue = 0L;
    private static Random randomizer = new Random();

    public long maxLength() {
        return 9 + AbstractStringIdentifierGenerator.MAX_INT_ALPHANUMERIC_VALUE_LENGTH;
    }

    public long minLength() {
        return 10L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String nextStringIdentifier() {
        long l = randomizer.nextLong();
        if (l < 0L) {
            l = -l;
        }
        l %= 2176782336L;
        l += 2176782336L;
        long l2 = 0L;
        int n = 0;
        Serializable serializable = this;
        synchronized (serializable) {
            l2 = System.currentTimeMillis() / 2000L;
            l2 %= 46656L;
            if (this.lastTimeValue != (l2 += 46656L)) {
                this.lastTimeValue = l2;
                this.counter = 0;
            }
            n = this.counter++;
        }
        serializable = new StringBuffer(15);
        ((StringBuffer)serializable).append(Long.toString(l, 36).substring(1));
        ((StringBuffer)serializable).append(Long.toString(l2, 36).substring(1));
        ((StringBuffer)serializable).append(Long.toString(n, 36));
        return ((StringBuffer)serializable).toString();
    }
}

