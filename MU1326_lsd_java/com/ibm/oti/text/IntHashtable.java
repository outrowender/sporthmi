/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.text;

import com.ibm.oti.util.Msg;

public final class IntHashtable {
    private int defaultValue = 0;
    private int primeIndex;
    private static final float HIGH_WATER_FACTOR = 0.4f;
    private int highWaterMark;
    private static final float LOW_WATER_FACTOR = 0.0f;
    private int lowWaterMark;
    private int count;
    private int[] values;
    private int[] keyList;
    private static final int EMPTY = Integer.MIN_VALUE;
    private static final int DELETED = -2147483647;
    private static final int MAX_UNUSED = -2147483647;
    private static final int[] PRIMES = new int[]{17, 37, 67, 131, 257, 521, 1031, 2053, 4099, 8209, 16411, 32771, 65537, 131101, 262147, 524309, 0x100007, 0x200011, 0x40000F, 0x800009, 16777259, 0x2000023, 0x400000F, 134217757, 0x10000003, 0x2000000B, 0x40000003, Integer.MAX_VALUE};

    public IntHashtable() {
        this.initialize(3);
    }

    public IntHashtable(int n) {
        this.initialize(IntHashtable.leastGreaterPrimeIndex((int)((float)n / 0.4f)));
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void put(int n, int n2) {
        int n3;
        if (this.count > this.highWaterMark) {
            this.rehash();
        }
        if (this.keyList[n3 = this.find(n)] <= -2147483647) {
            this.keyList[n3] = n;
            ++this.count;
        }
        this.values[n3] = n2;
    }

    public int get(int n) {
        return this.values[this.find(n)];
    }

    public void remove(int n) {
        int n2 = this.find(n);
        if (this.keyList[n2] > -2147483647) {
            this.keyList[n2] = -2147483647;
            this.values[n2] = this.defaultValue;
            --this.count;
            if (this.count < this.lowWaterMark) {
                this.rehash();
            }
        }
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(int n) {
        this.defaultValue = n;
        this.rehash();
    }

    public boolean equals(Object object) {
        if (object.getClass() != this.getClass()) {
            return false;
        }
        IntHashtable intHashtable = (IntHashtable)object;
        if (intHashtable.size() != this.count || intHashtable.defaultValue != this.defaultValue) {
            return false;
        }
        int n = 0;
        while (n < this.keyList.length) {
            int n2 = this.keyList[n];
            if (n2 > -2147483647 && intHashtable.get(n2) != this.values[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        int n = 465;
        int n2 = 1362796821;
        int n3 = 0;
        while (n3 < this.keyList.length) {
            n = n * n2 + 1;
            n += this.keyList[n3];
            ++n3;
        }
        n3 = 0;
        while (n3 < this.values.length) {
            n = n * n2 + 1;
            n += this.values[n3];
            ++n3;
        }
        return n;
    }

    public Object clone() throws CloneNotSupportedException {
        IntHashtable intHashtable = (IntHashtable)super.clone();
        intHashtable.values = (int[])this.values.clone();
        intHashtable.keyList = (int[])this.keyList.clone();
        return intHashtable;
    }

    private void initialize(int n) {
        if (n < 0) {
            n = 0;
        } else if (n >= PRIMES.length) {
            n = PRIMES.length - 1;
        }
        this.primeIndex = n;
        int n2 = PRIMES[n];
        this.values = new int[n2];
        this.keyList = new int[n2];
        int n3 = 0;
        while (n3 < n2) {
            this.keyList[n3] = Integer.MIN_VALUE;
            this.values[n3] = this.defaultValue;
            ++n3;
        }
        this.count = 0;
        this.lowWaterMark = (int)((float)n2 * 0.0f);
        this.highWaterMark = (int)((float)n2 * 0.4f);
    }

    private void rehash() {
        int[] nArray = this.values;
        int[] nArray2 = this.keyList;
        int n = this.primeIndex;
        if (this.count > this.highWaterMark) {
            ++n;
        } else if (this.count < this.lowWaterMark) {
            n -= 2;
        }
        this.initialize(n);
        int n2 = nArray.length - 1;
        while (n2 >= 0) {
            int n3 = nArray2[n2];
            if (n3 > -2147483647) {
                this.putInternal(n3, nArray[n2]);
            }
            --n2;
        }
    }

    public void putInternal(int n, int n2) {
        int n3 = this.find(n);
        if (this.keyList[n3] < -2147483647) {
            this.keyList[n3] = n;
            ++this.count;
        }
        this.values[n3] = n2;
    }

    private int find(int n) {
        if (n <= -2147483647) {
            throw new IllegalArgumentException(Msg.getString("K01a9"));
        }
        int n2 = -1;
        int n3 = (n ^ 0x4000000) % this.keyList.length;
        if (n3 < 0) {
            n3 = -n3;
        }
        int n4 = 0;
        do {
            int n5;
            if ((n5 = this.keyList[n3]) == n) {
                return n3;
            }
            if (n5 <= -2147483647) {
                if (n5 == Integer.MIN_VALUE) {
                    if (n2 >= 0) {
                        n3 = n2;
                    }
                    return n3;
                }
                if (n2 < 0) {
                    n2 = n3;
                }
            }
            if (n4 != 0) continue;
            n4 = n % (this.keyList.length - 1);
            if (n4 < 0) {
                n4 = -n4;
            }
            ++n4;
        } while ((n3 = (n3 + n4) % this.keyList.length) != n2);
        return n3;
    }

    private static int leastGreaterPrimeIndex(int n) {
        int n2 = 0;
        while (n2 < PRIMES.length) {
            if (n < PRIMES[n2]) break;
            ++n2;
        }
        return n2 == 0 ? 0 : n2 - 1;
    }
}

