/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.DurationUtil$1;
import de.esolutions.fw.util.commons.Buffer;

final class DurationUtil$Timer$Measurement {
    private final long start;
    private final long end;
    private final String name;

    private DurationUtil$Timer$Measurement(long l, long l2, String string) {
        this.start = l;
        this.end = l2;
        this.name = string;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        String string = Long.toString(this.getEnd() - this.getStart());
        Buffer buffer = new Buffer(this.getName().length() + ": ".length() + "ms".length() + string.length());
        buffer.append(this.getName());
        buffer.append(": ");
        buffer.append(string);
        buffer.append("ms");
        return buffer.toString();
    }

    /* synthetic */ DurationUtil$Timer$Measurement(long l, long l2, String string, DurationUtil$1 durationUtil$1) {
        this(l, l2, string);
    }

    static /* synthetic */ long access$100(DurationUtil$Timer$Measurement durationUtil$Timer$Measurement) {
        return durationUtil$Timer$Measurement.end;
    }
}

