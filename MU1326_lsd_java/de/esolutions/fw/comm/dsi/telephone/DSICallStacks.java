/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

public interface DSICallStacks {
    public static final String IPL_COMM_UUID = "522bd084-744b-51e6-bb34-50a944d5b9c7";
    public static final String IPL_COMM_INTERFACE_KEY = "1cd44d0c-2198-5191-8878-a1b0b6a01276";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public static interface Consts {
        public static final String VERSION = "2.11.27";
        public static final int CALLSTACKS_LD = 0;
        public static final int CALLSTACKS_RC = 1;
        public static final int CALLSTACKS_MC = 2;
        public static final int CALLSTACKS_ALL = 3;
        public static final int DATAVALIDITY_DATAVALID = 0;
        public static final int DATAVALIDITY_DATAINVALID = 1;
        public static final int CALLSTACKORIGIN_ME = 0;
        public static final int CALLSTACKORIGIN_MU = 1;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

