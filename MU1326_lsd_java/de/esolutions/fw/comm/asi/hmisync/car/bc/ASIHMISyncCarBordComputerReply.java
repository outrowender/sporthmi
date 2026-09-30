/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarBordComputerReply {
    public static final String IPL_COMM_UUID = "6d65ca53-0148-4329-8b3c-e8cd1fbade7a";
    public static final String IPL_COMM_INTERFACE_KEY = "d1b91a1b-f081-5c4c-bc68-8c00a93879a4";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateBCShortTermAverageConsumption1Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCShortTermAverageConsumption1(FloatBaseType var1, boolean var2) throws MethodException;

    public void updateBCShortTermAverageConsumption2Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCShortTermAverageConsumption2(FloatBaseType var1, boolean var2) throws MethodException;

    public void updateBCLongTermAverageConsumption1Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCLongTermAverageConsumption1(FloatBaseType var1, boolean var2) throws MethodException;

    public void updateBCLongTermAverageConsumption2Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCLongTermAverageConsumption2(FloatBaseType var1, boolean var2) throws MethodException;

    public void updateBCCurrentRange1Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCCurrentRange1(IntBaseType var1, boolean var2) throws MethodException;

    public void updateBCCurrentRange2Visibility(int var1, boolean var2) throws MethodException;

    public void updateBCCurrentRange2(IntBaseType var1, boolean var2) throws MethodException;

    public void updateBCShortTermGeneralVisibility(int var1, boolean var2) throws MethodException;

    public void updateBCShortTermGeneral(BCTermGeneralData var1, boolean var2) throws MethodException;

    public void updateBCLongTermGeneralVisibility(int var1, boolean var2) throws MethodException;

    public void updateBCLongTermGeneral(BCTermGeneralData var1, boolean var2) throws MethodException;
}

