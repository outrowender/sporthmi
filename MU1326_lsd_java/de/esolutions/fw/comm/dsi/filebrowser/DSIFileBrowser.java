/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.filebrowser;

public interface DSIFileBrowser {
    public static final String IPL_COMM_UUID = "e1b9905a-3ec2-50f2-b8bb-d4618323e5f7";
    public static final String IPL_COMM_INTERFACE_KEY = "15467468-4d56-5ad0-902a-52b28a2f5d26";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public static interface Consts {
        public static final String VERSION = "2.11.9";
        public static final int FILETYPE_UNKNOWNFILE = 2;
        public static final int FILETYPE_FOLDER = 3;
        public static final int FILETYPE_AUDIO = 4;
        public static final int FILETYPE_VIDEO = 5;
        public static final int FILETYPE_IMAGE = 6;
        public static final int FILETYPE_VCARD = 7;
        public static final int FILETYPE_PLAYLIST = 8;
        public static final int SELECTIONTYPE_ALL = 0;
        public static final int SELECTIONTYPE_NONE = 1;
        public static final int SELECTIONTYPE_INVERT = 2;
        public static final int RESULTTYPE_OK = 0;
        public static final int RESULTTYPE_ERROR = 1;
        public static final int RESULTTYPE_ERROR_TOO_MANY_SELECTED_FILES = 2;
        public static final int FILETYPEFILTER_ALLFILES = 1;
        public static final int FILETYPEFILTER_FOLDER = 2;
        public static final int FILETYPEFILTER_AUDIO = 4;
        public static final int FILETYPEFILTER_VIDEO = 8;
        public static final int FILETYPEFILTER_IMAGE = 16;
        public static final int FILETYPEFILTER_VCARD = 32;
        public static final int FILETYPEFILTER_PLAYLIST = 64;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

