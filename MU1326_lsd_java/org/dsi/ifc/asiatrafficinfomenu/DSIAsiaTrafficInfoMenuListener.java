/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiatrafficinfomenu;

import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.DateTime;

public interface DSIAsiaTrafficInfoMenuListener
extends DSIListener {
    public void updateActiveInterrupts(Interrupt[] var1, int var2);

    public void updateTrafficType(TrafficInformation[] var1, int var2);

    public void updatePrefecture(String var1, int var2);

    public void updateProbeDataSetting(boolean var1, int var2);

    public void updateFrequency(int var1, int var2);

    public void updateReceptionStatus(int var1, int var2);

    public void updateReceptionDate(DateTime var1, int var2);

    public void requestResourceInformationResponse(int var1, ResourceInformation var2);

    public void requestTrafficInformationDetailsResponse(int var1, TrafficInformationDetails[] var2);

    public void updateReceivableStations(TunerData[] var1, int var2);

    public void setLanguageResponse(boolean var1);
}

