/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public interface DSIRadioDataReply {
    public static final String IPL_COMM_UUID = "33a6fa68-c4fd-555f-9b16-c2504d731c26";
    public static final String IPL_COMM_INTERFACE_KEY = "d5d3a20b-9acf-575b-8821-250c27f4e1be";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.4";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.4";

    public void responseRadioStationData(RadioStationDataResponse[] var1, int var2) throws MethodException;

    public void responseRadioStationLogos(RadioStationLogoResponse[] var1, int var2) throws MethodException;

    public void responseDynamicDatabaseAlteration(int var1, int var2) throws MethodException;

    public void responseCountryList(int[] var1, int var2) throws MethodException;

    public void responseDatabaseVersionInfo(int var1, int var2, int var3, String var4, int var5, int var6, int var7) throws MethodException;

    public void updateDatabaseState(int var1, int var2) throws MethodException;

    public void responsePersistStationLogos(int var1, int var2) throws MethodException;

    public void updateRadioStationLogos(RadioStationLogoResponse[] var1, int var2) throws MethodException;

    public void responseCountryRegionData(CountryRegionData[] var1, int var2) throws MethodException;

    public void responseCountryRegionTranslationData(CountryRegionTranslationData[] var1, int var2) throws MethodException;

    public void responsePersistStationLogosWithChangedUrls(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4) throws MethodException;

    public void updatePersistStationLogosWithChangedUrls(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

