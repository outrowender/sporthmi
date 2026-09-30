/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public interface DSIAsiaTrafficInfoMenuReply {
    public static final String IPL_COMM_UUID = "2866c45a-497d-5824-a58a-0208be5c1860";
    public static final String IPL_COMM_INTERFACE_KEY = "a672f7a9-52b8-5ec5-bf7e-506497f89558";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void updateActiveInterrupts(Interrupt[] var1, int var2) throws MethodException;

    public void updateTrafficType(TrafficInformation[] var1, int var2) throws MethodException;

    public void updatePrefecture(String var1, int var2) throws MethodException;

    public void updateProbeDataSetting(boolean var1, int var2) throws MethodException;

    public void updateFrequency(int var1, int var2) throws MethodException;

    public void updateReceptionStatus(int var1, int var2) throws MethodException;

    public void updateReceptionDate(DateTime var1, int var2) throws MethodException;

    public void requestResourceInformationResponse(int var1, ResourceInformation var2) throws MethodException;

    public void requestTrafficInformationDetailsResponse(int var1, TrafficInformationDetails[] var2) throws MethodException;

    public void updateReceivableStations(TunerData[] var1, int var2) throws MethodException;

    public void setLanguageResponse(boolean var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

