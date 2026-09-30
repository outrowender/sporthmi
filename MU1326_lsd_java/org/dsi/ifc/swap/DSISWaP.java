/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

import org.dsi.ifc.base.DSIBase;

public interface DSISWaP
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int ATTR_SOFTWAREENABLING = 1;
    public static final int ATTR_ILLEGALFSCS = 2;
    public static final int ATTR_AREFSCSSIGNED = 3;
    public static final int ATTR_LIMITEDLIFETIME = 4;
    public static final int ATTR_CONFIGCHECK = 5;
    public static final int ATTR_CONFIGPREPARE = 6;
    public static final int ATTR_CONFIGFINALIZE = 7;
    public static final int ATTR_FSCLIST = 8;
    public static final int CRYPTERR_NOT_INITIALIZED = 0;
    public static final int CRYPTERR_OK = 1;
    public static final int CRYPTERR_READ_ERROR = 2;
    public static final int CRYPTERR_WRITE_ERROR = 3;
    public static final int CRYPTERR_CRYPTO_ERROR = 4;
    public static final int CRYPTERR_ALGORITHM_UNKNOWN = 5;
    public static final int CRYPTERR_WRONG_KEY_SIZE = 6;
    public static final int CRYPTERR_OUT_OF_MEMORY = 7;
    public static final int FSC_NOT_INITIALIZED = -1;
    public static final int FSC_OK = 0;
    public static final int FSC_INVALID_SIZE = 2;
    public static final int FSC_INVALID_FORMAT = 3;
    public static final int FSC_INVALID_CONTENT = 4;
    public static final int FSC_INVALID_SIGNATURE = 5;
    public static final int FSC_OTP_SWID_MISMATCH = 6;
    public static final int FSC_VIN_MISMATCH = 7;
    public static final int FSCSTATE_STATE_NOT_INITIALIZED = -1;
    public static final int FSCSTATE_LEGAL = 0;
    public static final int FSCSTATE_ILLEGAL = 1;
    public static final int FSCSTATE_SUPPORTED = 2;
    public static final int FSCSTATE_TEMP = 3;
    public static final int FSCSTATE_PERM = 4;
    public static final int MEDIUM_NOT_INITIALIZED = 0;
    public static final int MEDIUM_NFS = 1;
    public static final int MEDIUM_INTERNAL_DRIVE = 2;
    public static final int MEDIUM_USB_FS = 3;
    public static final int MEDIUM_SD_1 = 4;
    public static final int MEDIUM_SD_2 = 5;
    public static final int MEDIUM_CIFS = 6;
    public static final int MEDIUM_OTA = 7;
    public static final int MEDIUM_FS = 8;
    public static final int RT_ENCRYPTFILE = 1022;
    public static final int RT_CHECKSIGNATURE = 1023;
    public static final int RT_GETPUBLICKEY = 1024;
    public static final int RT_CHECKSINGLEFSC = 1025;
    public static final int RT_DECRYPTFILE = 1027;
    public static final int RT_GETFSCDETAILS = 1032;
    public static final int RT_TRIGGERSOFTWAREENABLING = 1033;
    public static final int RT_GETHISTORY = 1034;
    public static final int RT_EXPORTCCD = 1035;
    public static final int RT_IMPORTFSCS = 1036;
    public static final int RP_ENCRYPTFILE = 2009;
    public static final int RP_CHECKSIGNATURE = 2010;
    public static final int RP_GETPUBLICKEY = 2011;
    public static final int RP_CHECKSINGLEFSC = 2012;
    public static final int RP_DECRYPTFILE = 2013;
    public static final int RP_GETFSCDETAIL = 2019;
    public static final int RP_IMPORTFSCS = 2020;
    public static final int RP_EXPORTCCD = 2021;
    public static final int RP_GETHISTORY = 2022;
    public static final int RP_IMPORTFSCSLIST = 2023;
    public static final int RP_GETHISTORYLIST = 2024;

    public void encryptFile(String var1, String var2, byte[] var3);

    public void checkSignature(String var1, short[] var2, int var3, long var4);

    public void getPublicKey();

    public void checkSingleFsc(int var1);

    public void decryptFile(String var1, String var2, byte[] var3);

    public void getFscDetails(int var1, int var2, int var3);

    public void triggerSoftwareEnabling();

    public void importFSCs(int var1);

    public void exportCCD(int var1);

    public void getHistory();
}

