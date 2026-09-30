/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncMasterControlReply {
    public static final String IPL_COMM_UUID = "02954bb2-63fb-44a0-b50d-cb235060c4b6";
    public static final String IPL_COMM_INTERFACE_KEY = "e4f36342-c71e-54be-b822-4a56b5d0a9a1";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.01";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void factoryReset() throws MethodException;

    public void enterAppContext(int var1, String var2) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateHUVersion(String var1, boolean var2) throws MethodException;

    public void updateVIN(String var1, boolean var2) throws MethodException;

    public void updateLockState(int var1, boolean var2) throws MethodException;

    public void updateBlockState(int var1, boolean var2) throws MethodException;
}

