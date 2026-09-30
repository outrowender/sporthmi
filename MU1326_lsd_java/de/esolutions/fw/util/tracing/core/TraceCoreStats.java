/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TraceCoreStats {
    private final HashMap keyStatsMap = new HashMap();
    private final ArrayList keys = new ArrayList();
    private long seqNum;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_AVERAGE = 1;
    public static final int FLAG_INCREMENT = 2;
    public static final int FLAG_RESET = 4;
    public static final int FLAG_MAX = 8;

    public synchronized void registerKey(String string, int n) {
        Stats stats = new Stats(n);
        this.keyStatsMap.put(string, stats);
        this.keys.add(string);
    }

    public synchronized void updateKey(String string, int n) {
        Stats stats = (Stats)this.keyStatsMap.get(string);
        if (stats != null) {
            stats.update(n);
        }
    }

    public synchronized String readValues() {
        Buffer buffer = new Buffer(80);
        ++this.seqNum;
        buffer.append("seq=");
        buffer.append(this.seqNum);
        Iterator iterator = this.keys.iterator();
        while (iterator.hasNext()) {
            buffer.append(";");
            String string = (String)iterator.next();
            buffer.append(string);
            buffer.append("=");
            Stats stats = (Stats)this.keyStatsMap.get(string);
            if (stats != null) {
                int n = stats.read();
                buffer.append(n);
                continue;
            }
            buffer.append("n/a");
        }
        buffer.append(";");
        return buffer.toString();
    }

    private class Stats {
        int count;
        int value;
        final int flags;

        public Stats(int n) {
            this.flags = n;
        }

        public void update(int n) {
            ++this.count;
            if ((this.flags & 3) != 0) {
                this.value += n;
            } else if ((this.flags & 8) != 0) {
                if (n > this.value) {
                    this.value = n;
                }
            } else {
                this.value = n;
            }
        }

        public int read() {
            int n = 0;
            if ((this.flags & 1) != 0) {
                if (this.count > 0) {
                    n = this.value / this.count;
                }
            } else {
                n = this.value;
            }
            if ((this.flags & 4) != 0) {
                this.count = 0;
                this.value = 0;
            }
            return n;
        }
    }
}

