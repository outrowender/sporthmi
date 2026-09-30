/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.minimap;

import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public abstract class DSIAsiaTrafficInfoMenuListenerAdapter
implements DSIAsiaTrafficInfoMenuListener {
    public void asyncException(int n, String string, int n2) {
    }

    public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
    }

    public void updateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
    }

    public void updatePrefecture(String string, int n) {
    }

    public void updateProbeDataSetting(boolean bl, int n) {
    }

    public void updateFrequency(int n, int n2) {
    }

    public void updateReceptionStatus(int n, int n2) {
    }

    public void updateReceptionDate(DateTime dateTime, int n) {
    }

    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
    }

    public void requestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
    }

    public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
    }

    public void setLanguageResponse(boolean bl) {
    }
}

