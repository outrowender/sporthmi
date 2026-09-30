/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore;

public interface DSIPictureStore {
    public static final String IPL_COMM_UUID = "6547a393-25c0-5a7f-ab18-fa7875d3e6aa";
    public static final String IPL_COMM_INTERFACE_KEY = "2ef96885-7e80-5628-938a-ba87647a92d5";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public static interface Consts {
        public static final String VERSION = "2.11.11";
        public static final int IMPORTRESULT_SUCCESS = 0;
        public static final int IMPORTRESULT_NOSLOTAVAILABLE = 1;
        public static final int IMPORTRESULT_IOERROR = 2;
        public static final int IMPORTRESULT_PICTURENOTFOUND = 3;
        public static final int IMPORTRESULT_INTERNALERROR = 4;
        public static final int IMPORTRESULT_WRONG_PARAMETER = 5;
        public static final int IMPORTSOURCE_UNDEFINED = 1;
        public static final int IMPORTSOURCE_USB = 2;
        public static final int IMPORTSOURCE_SDCARD = 4;
        public static final int IMPORTSOURCE_ONLINE = 8;
        public static final int IMPORTSOURCE_STREETVIEW = 16;
        public static final int IMPORTSOURCE_CD = 32;
        public static final int IMPORTSOURCE_DVD = 64;
        public static final int TIMEINTERVALFILTERTYPE_CREATED_ON = 1;
        public static final int TIMEINTERVALFILTERTYPE_IMPORTED_ON = 2;
        public static final int FILETYPE_DEFAULT = 0;
        public static final int FILETYPE_PNG = 1;
        public static final int FILETYPE_JPEG = 2;
        public static final int FILTERSETID_EMPTY = -1;
        public static final int INVALIDDATATYPE_UNSPECIFIC = 0;
        public static final int INVALIDDATATYPE_STARTED = 1;
        public static final int INVALIDDATATYPE_RESET = 2;
        public static final int INVALIDDATATYPE_PICS_CHANGED = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

