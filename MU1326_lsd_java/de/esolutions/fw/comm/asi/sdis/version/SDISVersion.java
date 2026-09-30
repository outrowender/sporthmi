/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdis.version;

public interface SDISVersion {
    public static final String IPL_COMM_UUID = "9f423a8a-9d3b-11e3-8d05-425861b86ab6";
    public static final String IPL_COMM_INTERFACE_KEY = "e18d49e8-df08-5653-82f0-9f73b0153623";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public static interface Consts {
    }

    public static interface AttributesIDs {
        public static final long ASIVersion = 6L;
        public static final long SDISInterfaceVersion = 10L;
        public static final long MMXSWVersion = 8L;
        public static final long MMXSKUVersion = 7L;
        public static final long MUDetailedVersion = 9L;
    }
}

