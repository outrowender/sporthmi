/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarClimateReply {
    public static final String IPL_COMM_UUID = "5ffc8a82-9fd6-4d5f-9e5b-b7d05d798bc3";
    public static final String IPL_COMM_INTERFACE_KEY = "b433dc69-1912-5b9a-900b-83fe40f977cc";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateAirconTempZone1(IntBaseType var1, boolean var2) throws MethodException;

    public void updateAirconTempZone2(IntBaseType var1, boolean var2) throws MethodException;

    public void updateAirconMaxAC(boolean var1, boolean var2) throws MethodException;
}

