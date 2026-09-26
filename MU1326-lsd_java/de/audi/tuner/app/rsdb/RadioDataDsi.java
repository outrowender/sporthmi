/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.util.NullDSIRadioData;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class RadioDataDsi {
    private final LogChannel lc;
    private DSIRadioData dsi;

    public RadioDataDsi(TunerBasics tunerBasics) {
        this.lc = tunerBasics.getLogger().rsdb;
        this.dsi = new NullDSIRadioData(this.lc);
    }

    public boolean isDsiFound() {
        return !(this.dsi instanceof NullDSIRadioData);
    }

    public void setDeviceService(DSIRadioData dSIRadioData) {
        this.dsi = dSIRadioData != null ? dSIRadioData : new NullDSIRadioData(this.lc);
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.lc.log(1078071040, "[RadioDataDsi.setNotification] %1", (Object)nArray);
        this.dsi.setNotification(nArray, dSIListener);
    }

    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        this.lc.log(1078071040, "[RadioDataDsi.requestRadioStationData]: size:%1 session:%2", (long)radioStationDataRequestArray.length, (long)n);
        if (this.lc.isDebug2()) {
            Buffer buffer = new Buffer(radioStationDataRequestArray.length * 100);
            buffer.append('\n');
            for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
                buffer.append(i2).append(':').append(Utilities.toString(radioStationDataRequestArray[i2])).append('\n');
            }
            this.lc.log(14808325, "%1", (Object)buffer);
        }
        this.dsi.requestRadioStationData(radioStationDataRequestArray, n);
    }

    public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        this.lc.log(1078071040, "[RadioDataDsi.requestRadioStationLogos]: size:%1 session:%2", (long)radioStationLogoRequestArray.length, (long)n);
        if (this.lc.isDebug2()) {
            Buffer buffer = new Buffer(radioStationLogoRequestArray.length * 100);
            buffer.append('\n');
            for (int i2 = 0; i2 < radioStationLogoRequestArray.length; ++i2) {
                buffer.append(i2).append(':').append(Utilities.toString(radioStationLogoRequestArray[i2])).append('\n');
            }
            this.lc.log(14808325, "%1", (Object)buffer);
        }
        this.dsi.requestRadioStationLogos(radioStationLogoRequestArray, n);
    }

    public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        this.dsi.requestDynamicDatabaseAlteration(radioStationData, resourceLocator, n, n2);
    }

    public void requestCountryListUpdate(int n) {
        this.dsi.requestCountryListUpdate(n);
    }

    public void requestDatabaseVersionInfo(int n) {
        this.dsi.requestDatabaseVersionInfo(n);
    }

    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        this.dsi.requestPersistStationLogos(radioStationDataArray, resourceLocatorArray, n, n2);
    }

    public void requestCountryRegionData(int n) {
        this.lc.log(14808325, "[RadioDataDsi.requestCountryRegionData]");
        this.dsi.requestCountryRegionData(n);
    }

    public void requestCountryRegionTranslationData(int n, String string, int n2) {
        this.lc.log(14808325, "[RadioDataDsi.requestCountryRegionTranslationData] %1", (Object)string);
        this.dsi.requestCountryRegionTranslationData(n, string, n2);
    }
}

