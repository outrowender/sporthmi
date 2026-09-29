/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

public final class HMITerminalHelper {
    private static String[] labels = new String[8];

    public static String toString(int n) {
        try {
            return labels[n];
        }
        catch (Exception exception) {
            return Integer.toString(n);
        }
    }

    static {
        HMITerminalHelper.labels[1] = "CLUSTER";
        HMITerminalHelper.labels[2] = "FRONT_PASSENGER";
        HMITerminalHelper.labels[0] = "MAIN";
        HMITerminalHelper.labels[5] = "REAR_JOINT";
        HMITerminalHelper.labels[3] = "REAR_LEFT";
        HMITerminalHelper.labels[4] = "REAR_RIGHT";
    }
}

