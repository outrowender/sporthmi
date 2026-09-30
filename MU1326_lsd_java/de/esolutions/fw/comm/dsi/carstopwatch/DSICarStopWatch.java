/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch;

public interface DSICarStopWatch {
    public static final String IPL_COMM_UUID = "584611ca-824a-5095-926b-c7c6c33c89aa";
    public static final String IPL_COMM_INTERFACE_KEY = "0abc5c31-c9dc-54c0-ab3d-316f61979c15";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public static interface Consts {
        public static final String VERSION = "2.11.3";
        public static final int STOPWATCHLAPRATING_NOT_ACTIVE = 0;
        public static final int STOPWATCHLAPRATING_SLOWER = 1;
        public static final int STOPWATCHLAPRATING_SAME_PACE = 2;
        public static final int STOPWATCHLAPRATING_FASTER = 3;
        public static final int STOPWATCHLAPRATING_INIT = 14;
        public static final int STOPWATCHLAPRATING_NOT_SUPPORTED = 15;
        public static final int STOPWATCHCOMMAND_INIT = 0;
        public static final int STOPWATCHCOMMAND_START = 1;
        public static final int STOPWATCHCOMMAND_START_MOVING_VEHICLE = 2;
        public static final int STOPWATCHCOMMAND_STOP = 3;
        public static final int STOPWATCHCOMMAND_CONTINUE = 4;
        public static final int STOPWATCHCOMMAND_RESET = 5;
        public static final int STOPWATCHCOMMAND_SPLITTIME = 6;
        public static final int STOPWATCHCOMMAND_LAPTIME = 7;
        public static final int STOPWATCHSTATE_INIT = 0;
        public static final int STOPWATCHSTATE_RUNNING = 1;
        public static final int STOPWATCHSTATE_NOT_RUNNING = 2;
        public static final int STOPWATCHSTATE_NOT_RUNNING_RESET = 3;
        public static final int STOPWATCHSTATE_NOT_RUNNING_NO_RESET = 4;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

