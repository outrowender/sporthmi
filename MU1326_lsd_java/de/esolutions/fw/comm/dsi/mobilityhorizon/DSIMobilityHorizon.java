/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon;

public interface DSIMobilityHorizon {
    public static final String IPL_COMM_UUID = "10a21fa2-845e-5f9f-8283-ef042ff3cd6c";
    public static final String IPL_COMM_INTERFACE_KEY = "5c4cdaf2-76e9-5a4d-980c-50fd93963747";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.8";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.8";

    public static interface Consts {
        public static final String VERSION = "2.11.8";
        public static final int UNIT_UNKNOWN = 0;
        public static final int UNIT_LITER = 1;
        public static final int UNIT_KILOGRAM = 2;
        public static final int UNIT_KILOWATT_HOUR = 3;
        public static final int LOCATIONTYPE_NONE = 0;
        public static final int LOCATIONTYPE_ONEWAY = 1;
        public static final int LOCATIONTYPE_HOME = 2;
        public static final int LOCATIONTYPE_USERDEFINED = 3;
        public static final int DRIVETRAINMODE_PRIMARY = 0;
        public static final int DRIVETRAINMODE_SECONDARY = 1;
        public static final int DRIVETRAINMODE_COMBINED = 2;
        public static final int MOBILITYHORIZONSTATUS_SYSTEMNOTREADY = 0;
        public static final int MOBILITYHORIZONSTATUS_SYSTEMREADY = 1;
        public static final int MOBILITYHORIZONSTATUS_NODATABASEFOUND = 2;
        public static final int MOBILITYHORIZONSTATUS_DATABASEDEFECT = 3;
        public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_1 = 4;
        public static final int MOBILITYHORIZONSTATUS_CRITICALENERGYLEVEL_2 = 5;
        public static final int MOBILITYHORIZONSTATUS_NOTENOUGHENERGY = 6;
        public static final int MOBILITYHORIZONSTATUS_OTHERFAILURE = 99;
        public static final int LOCATIONRANGETYPE_TARGET = 0;
        public static final int LOCATIONRANGETYPE_HOME = 1;
        public static final int LOCATIONRANGETYPE_USERDEFINED = 2;
        public static final int LOCATIONRANGELEVEL_UNDEFINED = 0;
        public static final int LOCATIONRANGELEVEL_INRANGE = 1;
        public static final int LOCATIONRANGELEVEL_CRITICAL = 2;
        public static final int LOCATIONRANGELEVEL_OUTOFRANGE = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

