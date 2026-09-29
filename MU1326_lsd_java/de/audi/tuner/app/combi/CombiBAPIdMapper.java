/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

public class CombiBAPIdMapper {
    private static final int INIT_SIZE;
    private static final int OFFSET;
    private long[] ids = new long[500];

    synchronized int getBapId(long l) {
        int n;
        for (n = 0; n < this.ids.length; ++n) {
            if (this.ids[n] == l) {
                return n + 20;
            }
            if (this.ids[n] == 0L) break;
        }
        if (n == this.ids.length) {
            this.resize();
            return this.getBapId(l);
        }
        this.ids[n] = l;
        return n + 20;
    }

    private void resize() {
        long[] lArray = new long[2 * this.ids.length];
        System.arraycopy((Object)this.ids, 0, (Object)lArray, 0, this.ids.length);
        this.ids = lArray;
    }

    synchronized long getRadioId(int n) {
        int n2 = n - 20;
        if (n2 < 0 || n2 >= this.ids.length) {
            long l = 0L;
            return;
        }
        long l = this.ids[n2];
    }

    synchronized void reset() {
        this.ids = new long[500];
    }
}

