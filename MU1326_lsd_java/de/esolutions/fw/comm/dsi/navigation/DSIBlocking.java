/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation;

public interface DSIBlocking {
    public static final String IPL_COMM_UUID = "7e8d9639-93b7-5bee-ad23-11aa5a778dfa";
    public static final String IPL_COMM_INTERFACE_KEY = "945c1bc3-5e89-5c88-b7e6-91bec707b2ec";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.71";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.71";

    public static interface Consts {
        public static final String VERSION = "2.11.71";
        public static final int BLOCKREQUESTRESULTCODE_OK = 0;
        public static final int BLOCKREQUESTRESULTCODE_FAILED = 1;
        public static final int BLOCKREQUESTRESULTCODE_FAILEDOUTOFMEMORY = 2;
        public static final int BLOCKINGELEMENTTYPE_RECTANGULARAREA = 0;
        public static final int BLOCKINGELEMENTTYPE_ROUTE_SEGMENT = 1;
        public static final int BLOCKINGELEMENTTYPE_ROAD_SEGMENT = 2;
        public static final int BLOCKINGELEMENTTYPE_ROUTEBASESONLENGTH = 3;
        public static final int NAVICOREAVAILABLETOSETBLOCKS_READYTOBLOCK = 0;
        public static final int NAVICOREAVAILABLETOSETBLOCKS_BUSY = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

