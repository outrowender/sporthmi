/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.TunerData;

public interface DSINavServicesAPIListener
extends DSIListener {
    public void initiatePhoneCallToADBEntry(String var1, String var2);

    public void updateLanguage(String var1, int var2);

    public void updateAvailableLanguages(String[] var1, int var2);

    public void updateIconDirectory(String var1, int var2);

    public void updateReceivableStations(TunerData[] var1, int var2);

    public void updateNavigationState(int var1, int var2);

    public void phoneDialNumber(String var1, String var2);

    public void audioRequest(boolean var1);

    public void createExportFile(int var1, boolean var2);

    public void importFile(int var1, boolean var2);

    public void resetToFactorySettingsResult();

    public void deleteCustomerDataResult();

    public void setBrowserURL(String var1);

    public void prepareAndPlayTTS2Announcement(String var1);

    public void abortTTS2Announcement();

    public void updateCurrentPosition(float var1, float var2, int var3);

    public void efiLinkSelectedResult(boolean var1);

    public void selectRemoteSearchLocationResult(AddressData[] var1);

    public void checkLicense(int var1);

    public void checkDataConnection();

    public void requestRrdForLocationDataResult(int var1, String[] var2, int[] var3);
}

