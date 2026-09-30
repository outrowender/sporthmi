/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.OnlineAdbEntry;

public interface NaviMyAudiImport {
    public void storeAddressList(OnlineAdbEntry[] var1, int var2, IMyAudiImportResultListener var3);

    public void downloadStarted();

    public static interface DownloadStates {
        public static final int DOWNLOAD_INIT = 0;
        public static final int DOWNLOAD_OK = 1;
        public static final int DOWNLOAD_ERROR_GEN = 2;
        public static final int DOWNLOAD_WAITING = 3;
        public static final int DOWNLOAD_ERROR_DOWNLOAD = 4;
        public static final int DOWNLOAD_NOCONTACTS = 5;
        public static final int DOWNLOAD_MEMFULL = 6;
        public static final int DOWNLOAD_WRONGFORMAT = 7;
        public static final int DOWNLOAD_DUPLICATE = 8;
        public static final int DOWNLOAD_OK_NEW_CONTACTS_AVAILABLE = 9;
    }

    public static interface IMyAudiImportResultListener {
        public void myAudiAdbImportResult(long[] var1, long[] var2);
    }
}

