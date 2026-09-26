/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.audi.remotehmi.util.DurationUtil$Timer$Measurement;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public final class DurationUtil$Timer {
    private final long created;
    private final List measurements;
    private boolean enabled;
    private final long thresholdMillis;
    private static final long THRESHOLD_MILLIS;
    private String finalized;

    public DurationUtil$Timer() {
        this(true);
    }

    public DurationUtil$Timer(boolean bl) {
        this.enabled = bl;
        this.measurements = bl ? new ArrayList(10) : null;
        this.created = bl ? System.currentTimeMillis() : -1L;
        this.thresholdMillis = -1L;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void takeMeasurement(String string) {
        if (this.enabled) {
            long l;
            long l2 = System.currentTimeMillis();
            long l3 = l = this.measurements.isEmpty() ? this.created : ((DurationUtil$Timer$Measurement)this.measurements.get(this.measurements.size() - 1)).getEnd();
            if (l2 - l > this.thresholdMillis) {
                this.measurements.add(new DurationUtil$Timer$Measurement(l, l2, string, null));
            }
        }
    }

    public String toString() {
        if (!this.enabled) {
            return this.finalized != null ? this.finalized : "measurements disabled";
        }
        if (this.measurements.isEmpty()) {
            return "no measurements";
        }
        if (this.finalized != null) {
            return this.finalized;
        }
        long l = System.currentTimeMillis();
        if (l - this.created > this.thresholdMillis) {
            this.takeMeasurement("<done>");
        }
        long l2 = DurationUtil$Timer$Measurement.access$100((DurationUtil$Timer$Measurement)this.measurements.get(this.measurements.size() - 1)) - this.created;
        String string = this.measurements.toString();
        Buffer buffer = new Buffer(50 + string.length());
        buffer.append("total: ");
        buffer.append(l2);
        buffer.append("ms ");
        buffer.append(string);
        if (this.thresholdMillis >= 0L) {
            buffer.append(" (threshold: ");
            buffer.append(this.thresholdMillis);
            buffer.append("ms)");
        }
        this.finalized = buffer.toString();
        this.enabled = false;
        return this.finalized;
    }
}

