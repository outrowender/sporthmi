/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public interface DSITrafficRegulationReply {
    public static final String IPL_COMM_UUID = "6901e511-3231-50d4-b201-4f6cac639de8";
    public static final String IPL_COMM_INTERFACE_KEY = "f1dc0de3-ddd5-522b-83a1-8a345754745f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public void updateCountrySpeedInformation(RoadClassSpeedInfo[] var1, int var2) throws MethodException;

    public void updateCurrentTrafficSign(TrafficSignInformation var1, int var2) throws MethodException;

    public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] var1, int var2) throws MethodException;

    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] var1, int var2) throws MethodException;

    public void updateTrailerStatus(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

