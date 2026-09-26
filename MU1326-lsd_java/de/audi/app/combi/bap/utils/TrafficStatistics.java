/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.utils;

import de.audi.app.combi.bap.utils.CombiLogger;
import de.audi.app.combi.bap.utils.TrafficCounter;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class TrafficStatistics {
    private static TrafficCounter trafficCounterAudio = new TrafficCounter("Audio", TrafficStatistics.getLogChannel());
    private static TrafficCounter trafficCounterTelephone = new TrafficCounter("Telephone", TrafficStatistics.getLogChannel());
    private static TrafficCounter trafficCounterTelephone2 = new TrafficCounter("Telephone2", TrafficStatistics.getLogChannel());
    private static TrafficCounter trafficCounterNavi = new TrafficCounter("Navigation", TrafficStatistics.getLogChannel());
    private static TrafficCounter trafficCounterMFL = new TrafficCounter("MFL", TrafficStatistics.getLogChannel());

    public static TrafficCounter getTrafficCounter(int n) {
        switch (n) {
            case 49: {
                return trafficCounterAudio;
            }
            case 40: {
                return trafficCounterTelephone;
            }
            case 41: {
                return trafficCounterTelephone2;
            }
            case 50: {
                return trafficCounterNavi;
            }
            case 52: {
                return trafficCounterMFL;
            }
        }
        return null;
    }

    public static Object getStatisticsLog() {
        Buffer buffer = new Buffer();
        buffer.append("Traffic Statistics\n");
        buffer.append(trafficCounterAudio.getCurrentStatisticsLog());
        buffer.append("\n");
        buffer.append(trafficCounterTelephone.getCurrentStatisticsLog());
        buffer.append("\n");
        buffer.append(trafficCounterTelephone2.getCurrentStatisticsLog());
        buffer.append("\n");
        buffer.append(trafficCounterNavi.getCurrentStatisticsLog());
        buffer.append("\n");
        buffer.append(trafficCounterMFL.getCurrentStatisticsLog());
        return buffer.toString();
    }

    protected static LogChannel getLogChannel() {
        return CombiLogger.getStatisticsLog();
    }

    public static void resetAll() {
        TrafficStatistics.getLogChannel().log(-2137614336, "[TrafficStatistics#resetAll] reset all traffic counters");
        trafficCounterAudio.reset();
        trafficCounterTelephone.reset();
        trafficCounterTelephone2.reset();
        trafficCounterNavi.reset();
        trafficCounterMFL.reset();
    }
}

