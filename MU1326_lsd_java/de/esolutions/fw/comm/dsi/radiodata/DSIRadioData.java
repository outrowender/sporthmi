/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata;

public interface DSIRadioData {
    public static final String IPL_COMM_UUID = "4ed4ac19-0c6c-5830-a2bc-a1134fa4522a";
    public static final String IPL_COMM_INTERFACE_KEY = "11df929b-d035-513f-a3d3-7c4eced78564";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.4";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.4";

    public static interface Consts {
        public static final String VERSION = "2.11.4";
        public static final int DATABASESTATE_DB_DOES_NOT_EXISTS = 0;
        public static final int DATABASESTATE_DB_NOT_AVAILABLE = 1;
        public static final int DATABASESTATE_DB_AVAILABLE = 2;
        public static final int DATABASESTATE_DB_VERSION_UPDATE = 3;
        public static final int DATABASEALTERATION_DELETE_STATION = 0;
        public static final int DATABASEALTERATION_DELETE_LOGO = 1;
        public static final int DATABASEALTERATION_DELETE_STATION_AND_LOGO = 2;
        public static final int DATABASEALTERATION_ADD_STATION = 3;
        public static final int DATABASEALTERATION_ADD_LOGO = 4;
        public static final int DATABASEALTERATION_ADD_STATION_AND_LOGO = 5;
        public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION = 0;
        public static final int DATABASEALTERATIONRESPONSE_DELETE_LOGO = 1;
        public static final int DATABASEALTERATIONRESPONSE_DELETE_STATION_AND_LOGO = 2;
        public static final int DATABASEALTERATIONRESPONSE_ADD_STATION = 3;
        public static final int DATABASEALTERATIONRESPONSE_ADD_LOGO = 4;
        public static final int DATABASEALTERATIONRESPONSE_ADD_STATION_AND_LOGO = 5;
        public static final int DATABASEALTERATIONRESPONSE_DB_DOES_NOT_EXISTS = 6;
        public static final int DATABASEALTERATIONRESPONSE_DB_NOT_AVAILABLE = 7;
        public static final int DATABASEALTERATIONRESPONSE_DB_VERSION_UPDATE = 8;
        public static final int LOGOPRIORITY_MANUAL_LOGO = 0;
        public static final int LOGOPRIORITY_NEWEST_LOGO = 1;
        public static final int LOGOPRIORITY_STATIC_LOGO = 2;
        public static final int LOGOPRIORITY_ALL_LOGOS = 3;
        public static final int LOGOPRIORITY_GENERIC_LOGO = 4;
        public static final int REQUESTPERSISTSTALOGOS_REQUEST_PROCESSED = 0;
        public static final int REQUESTPERSISTSTALOGOS_REQUEST_FAILED = 1;
        public static final int PERSISTSTATIONLOGOSTYPE_PRESETS = 0;
        public static final int PERSISTSTATIONLOGOSTYPE_CURRENT_STATION = 1;
        public static final int PERSISTSTATIONLOGOSTYPE_STATION_LIST = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

