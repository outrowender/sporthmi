/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Speed;
import de.esolutions.fw.util.commons.Buffer;

public abstract class RemoteHMICalculationHelper {
    private static Distance distanceMetric = new Distance(0.0f, 1);
    private static Speed speedMetric = new Speed(0.0f, 1);
    private static final int MSEC_MINUTES = 60000;
    private static final int MSEC_HOURS = 3600000;

    public static String calculateDistance(long l) {
        if (l > 0L) {
            distanceMetric.setValue((float)l / 1000.0f);
            return distanceMetric.formatByMode(1);
        }
        return "";
    }

    public static String calculateTime(long l) {
        long l2 = l / 3600000L;
        long l3 = (l -= l2 * 3600000L) / 60000L;
        l -= l3 * 60000L;
        Buffer buffer = new Buffer(30);
        if (l2 > 0L) {
            buffer.append(l2);
            buffer.append(" h ");
        }
        if (l3 > 0L) {
            buffer.append(l3);
            buffer.append(" min");
        }
        return buffer.toString();
    }

    static String calculateSpeed(long l) {
        speedMetric.setValue(l);
        return speedMetric.format();
    }
}

