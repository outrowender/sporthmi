/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.util;

import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public final class DurationUtil {
    private DurationUtil() {
        throw new UnsupportedOperationException("this is a static utility class!");
    }

    public static final class Timer {
        private final long created;
        private final List measurements;
        private boolean enabled;
        private final long thresholdMillis;
        private static final long THRESHOLD_MILLIS = -1L;
        private String finalized;

        public Timer() {
            this(true);
        }

        public Timer(boolean bl) {
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
                long l3 = l = this.measurements.isEmpty() ? this.created : ((Measurement)this.measurements.get(this.measurements.size() - 1)).getEnd();
                if (l2 - l > this.thresholdMillis) {
                    this.measurements.add(new Measurement(l, l2, string));
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
            long l2 = ((Measurement)this.measurements.get(this.measurements.size() - 1)).end - this.created;
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

        private static final class Measurement {
            private final long start;
            private final long end;
            private final String name;

            private Measurement(long l, long l2, String string) {
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
        }
    }
}

