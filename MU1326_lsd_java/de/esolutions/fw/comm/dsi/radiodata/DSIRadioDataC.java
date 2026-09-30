/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public interface DSIRadioDataC {
    public void requestRadioStationData(RadioStationDataRequest[] var1, int var2) throws MethodException;

    public void requestRadioStationLogos(RadioStationLogoRequest[] var1, int var2) throws MethodException;

    public void requestDynamicDatabaseAlteration(RadioStationData var1, ResourceLocator var2, int var3, int var4) throws MethodException;

    public void requestCountryListUpdate(int var1) throws MethodException;

    public void requestDatabaseVersionInfo(int var1) throws MethodException;

    public void requestPersistStationLogos(RadioStationData[] var1, ResourceLocator[] var2, int var3, int var4) throws MethodException;

    public void requestCountryRegionData(int var1) throws MethodException;

    public void requestCountryRegionTranslationData(int var1, String var2, int var3) throws MethodException;

    public void profileChange(int var1) throws MethodException;

    public void profileCopy(int var1, int var2) throws MethodException;

    public void profileReset(int var1) throws MethodException;

    public void profileResetAll() throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

