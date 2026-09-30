/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncHeadUnitReply {
    public static final String IPL_COMM_UUID = "00c7b221-4634-4004-97dd-03531d5bc83c";
    public static final String IPL_COMM_INTERFACE_KEY = "d70a28c6-c507-5f9a-8920-21d1424b355a";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.2.00";

    public void resetLanguage(int var1, String var2) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateClockTime(ClockTime var1, boolean var2) throws MethodException;

    public void updateClockDate(ClockDate var1, boolean var2) throws MethodException;

    public void updateLanguage1(int var1, boolean var2) throws MethodException;

    public void updateLanguage2(String var1, boolean var2) throws MethodException;

    public void updateTemperatureUnit(int var1, boolean var2) throws MethodException;

    public void updateSpeedUnit(int var1, boolean var2) throws MethodException;

    public void updateDistanceUnit(int var1, boolean var2) throws MethodException;

    public void updatePressureUnit(int var1, boolean var2) throws MethodException;

    public void updateCarConfiguration(CarConfiguration var1, boolean var2) throws MethodException;

    public void updateRegion(int var1, boolean var2) throws MethodException;

    public void updateExtCarConfiguration(int[] var1, boolean var2) throws MethodException;

    public void updateSplashScreenCoding(short var1, boolean var2) throws MethodException;
}

