/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler;

public interface DSICarAuxHeaterCooler {
    public static final String IPL_COMM_UUID = "b8841165-76a0-5918-9127-09550decc09b";
    public static final String IPL_COMM_INTERFACE_KEY = "4b52ea2b-e87d-526f-bc2b-ce1fcada6f92";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public static interface Consts {
        public static final String VERSION = "2.11.11";
        public static final int TIMERMODE_STARTTIMER = 0;
        public static final int TIMERMODE_GOALTIMER = 1;
        public static final int AUXHEATERCOOLERSTATE_OFF = 0;
        public static final int AUXHEATERCOOLERSTATE_HEATING = 1;
        public static final int AUXHEATERCOOLERSTATE_VENTILATION = 2;
        public static final int AUXHEATERCOOLERHEATERSTATE_OK = 0;
        public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOW = 1;
        public static final int AUXHEATERCOOLERHEATERSTATE_BATTERYLOW = 2;
        public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOWBATTERYLOW = 3;
        public static final int AUXHEATERCOOLERHEATERSTATE_HEATERDEFECT = 4;
        public static final int AUXHEATERCOOLERACTIVETIMER_NONE = 0;
        public static final int AUXHEATERCOOLERACTIVETIMER_TIMER1 = 1;
        public static final int AUXHEATERCOOLERACTIVETIMER_TIMER2 = 2;
        public static final int AUXHEATERCOOLERACTIVETIMER_TIMER3 = 3;
        public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_VENTILATION = 1;
        public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_HEATING = 2;
        public static final int AUXHEATERCOOLERDATEMODE_ABSOLUTEDATE = 0;
        public static final int AUXHEATERCOOLERDATEMODE_RELATIVEDATE = 1;
        public static final int AUXHEATERCOOLERDATEMODE_WEEKDATE = 2;
        public static final int AUXHEATERCOOLERDATEMODE_NEXTOCCURENCE = 3;
        public static final int AUXHEATERCOOLERMODE_ECONOMY = 0;
        public static final int AUXHEATERCOOLERMODE_NORMAL = 1;
        public static final int AUXHEATERCOOLERMODE_COMFORT = 2;
        public static final int AUXHEATERCOOLERREASON_NOREASON = 0;
        public static final int AUXHEATERCOOLERREASON_IMMEDIATESTARTUP = 1;
        public static final int AUXHEATERCOOLERREASON_TIMER1 = 2;
        public static final int AUXHEATERCOOLERREASON_TIMER2 = 3;
        public static final int AUXHEATERCOOLERREASON_TIMER3 = 4;
        public static final int AUXHEATERCOOLERPOPUP_NONE = 0;
        public static final int AUXHEATERCOOLERPOPUP_CHANGEAUXHEATERTIMERORSTARTAUXHEATER = 1;
        public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_OFF = 0;
        public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_ON = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

