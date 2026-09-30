/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public interface DSIRadioDataListener
extends DSIListener {
    public void responseRadioStationData(RadioStationDataResponse[] var1, int var2);

    public void responseRadioStationLogos(RadioStationLogoResponse[] var1, int var2);

    public void responseDynamicDatabaseAlteration(int var1, int var2);

    public void responseCountryList(int[] var1, int var2);

    public void responseDatabaseVersionInfo(int var1, int var2, int var3, String var4, int var5, int var6, int var7);

    public void updateDatabaseState(int var1, int var2);

    public void responsePersistStationLogos(int var1, int var2);

    public void updateRadioStationLogos(RadioStationLogoResponse[] var1, int var2);

    public void responseCountryRegionData(CountryRegionData[] var1, int var2);

    public void responseCountryRegionTranslationData(CountryRegionTranslationData[] var1, int var2);

    public void responsePersistStationLogosWithChangedUrls(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4);

    public void updatePersistStationLogosWithChangedUrls(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

