/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ZeroEmissionEntry;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarZeroEmissionReply {
    public static final String IPL_COMM_UUID = "83464154-9032-473d-b4c8-2dac866dcb2a";
    public static final String IPL_COMM_INTERFACE_KEY = "49028b78-c4f4-5526-896b-c466f65870bd";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateZEVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateZeroEmissionValues(ZeroEmissionEntry[] var1, boolean var2) throws MethodException;

    public void updateCurrentZeroEmissionValue(ZeroEmissionEntry var1, boolean var2) throws MethodException;
}

