/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class NullDSIRadioData
extends NullDSIService
implements DSIRadioData {
    public NullDSIRadioData(LogChannel logChannel) {
        super(logChannel, "DSIRadioData");
    }

    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        this.log();
    }

    public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        this.log();
    }

    public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        this.log();
    }

    public void requestCountryListUpdate(int n) {
        this.log();
    }

    public void requestDatabaseVersionInfo(int n) {
        this.log();
    }

    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        this.log();
    }

    public void requestCountryRegionData(int n) {
        this.log();
    }

    public void requestCountryRegionTranslationData(int n, String string, int n2) {
        this.log();
    }

    public void profileChange(int n) {
        this.log();
    }

    public void profileCopy(int n, int n2) {
        this.log();
    }

    public void profileReset(int n) {
        this.log();
    }

    public void profileResetAll() {
        this.log();
    }
}

