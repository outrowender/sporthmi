/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.SFecImportStatus;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecManagerReply {
    public static final String IPL_COMM_UUID = "7b2f491d-eea1-4197-9124-469efe2453d2";
    public static final String IPL_COMM_INTERFACE_KEY = "8db34658-32cf-5a16-a3fd-9571af38a1d3";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.5";

    public void checkDataSignature(String var1, boolean var2) throws MethodException;

    public void fecDetails(SFecDetails var1) throws MethodException;

    public void importFecs(int var1, SFecImportStatus[] var2) throws MethodException;

    public void exportCCD(int var1) throws MethodException;

    public void getHistory(SFecHistory[] var1) throws MethodException;

    public void encryptFile(String var1, int var2) throws MethodException;

    public void decryptFile(String var1, int var2) throws MethodException;
}

