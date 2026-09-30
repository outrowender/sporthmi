/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth;

import de.esolutions.fw.comm.core.method.MethodException;

public interface PairingCodeValidatorReply {
    public static final String IPL_COMM_UUID = "66f43e33-18c7-4244-bb8e-c0ecce462f56";
    public static final String IPL_COMM_INTERFACE_KEY = "2097acb3-6a38-515a-af63-e947eb363c44";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void validatePairingCodeResult(boolean var1, String var2, String var3, int var4, int var5) throws MethodException;

    public void resetPairingCode(String var1, String var2) throws MethodException;
}

