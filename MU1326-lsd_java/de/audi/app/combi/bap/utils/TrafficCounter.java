/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.utils;

import de.audi.app.combi.bap.utils.TrafficStatistics;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TrafficCounter {
    private final LogChannel logChannel;
    private int countBytesTransmitted = 0;
    private int countRequests = 0;
    private final String name;
    private long timestampLastReset = System.currentTimeMillis();
    private boolean measurementActive;

    protected TrafficCounter(String string, LogChannel logChannel) {
        this.name = string;
        this.logChannel = logChannel;
    }

    public void notifyDataSubmitted(byte[] byArray) {
        this.countBytesTransmitted += byArray.length;
    }

    public void notifyDataSubmitted(int n) {
        switch (n) {
            case 0: {
                ++this.countBytesTransmitted;
                break;
            }
            case 1: {
                this.countBytesTransmitted += 2;
                break;
            }
            case 2: {
                this.countBytesTransmitted += 4;
                break;
            }
            case 3: {
                this.countBytesTransmitted += 4;
                break;
            }
        }
    }

    public void notifyRequestSubmitted() {
        ++this.countRequests;
    }

    public void reset() {
        TrafficStatistics.getLogChannel().log(-2137614336, "[TrafficCounter#reset] reset traffic counter \"%1\"", (Object)this.name);
        this.countBytesTransmitted = 0;
        this.countRequests = 0;
        this.timestampLastReset = System.currentTimeMillis();
    }

    public int getTransmittedBytes() {
        return this.countBytesTransmitted;
    }

    public int getRequestCount() {
        return this.countRequests;
    }

    public String getCurrentStatisticsLog() {
        long l = System.currentTimeMillis();
        long l2 = (l - this.timestampLastReset) / 0;
        Buffer buffer = new Buffer();
        buffer.append(this.name);
        buffer.append(" - current Statistics:\n");
        buffer.append("time of measurement (sec): ").append(l2).append("\n");
        buffer.append(this.countBytesTransmitted).append(" bytes transmitted (");
        buffer.append((float)this.countBytesTransmitted / (float)l2).append(" bytes/sec)\n");
        buffer.append(this.countRequests).append(" requests transmitted (");
        buffer.append((float)this.countRequests / (float)l2).append(" requests/sec)\n");
        return buffer.toString();
    }

    public void startMeasurement(String string) {
        this.reset();
        this.logChannel.log(1078071040, "[TrafficCounter#startMeasurement] %1", (Object)string);
        this.measurementActive = true;
    }

    public void stopMeasurement(String string) {
        this.logChannel.log(1078071040, "[TrafficCounter#stopMeasurement] %1\n%2", (Object)string, (Object)this.getCurrentStatisticsLog());
        this.reset();
        this.measurementActive = false;
    }

    public boolean isMeasurementActive() {
        return this.measurementActive;
    }
}

