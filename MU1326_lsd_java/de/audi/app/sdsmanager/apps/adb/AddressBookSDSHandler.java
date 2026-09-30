/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.atip.interapp.ADBSDSService;
import de.audi.atip.interapp.NaviService;
import org.dsi.ifc.global.ResourceLocator;

public interface AddressBookSDSHandler
extends ISDSApplication {
    public void setADBService(ADBSDSService var1);

    public ADBSDSService getADBService();

    public void unsetADBService();

    public void setNaviService(NaviService var1);

    public void unsetNaviService();

    public int getProfileID();

    public long getCurrentEntryID();

    public void setPhoneNumberTypes(int var1);

    public int getPhoneNumberTypes();

    public TelNumberInfo getTelNumberInfo();

    public long getADBID(int var1);

    public void setCurrentEntryID(long var1);

    public long getSelectedEntryID();

    public void setSelectedEntryID(long var1);

    public void setNavLocations(int[] var1);

    public long[] getEntryIDs();

    public void setEntryIDs(long[] var1);

    public void handleItemSelectionInAdbList(int var1, int var2);

    public long getADBEntrySelectionInterruptID();

    public void setADBEntrySelectionInterruptID(long var1);

    public void setTelNumberDetails(ADBSDSService.TelNumberDetails var1);

    public int getNavLocationSize();

    public int getNavLocationType(int var1);

    public int getNavLocationTypeByCategory(int var1);

    public void responseGetEntryNames(String[] var1);

    public ADBSDSService.TelNumberDetails getTelNumberDetails(int var1);

    public void updateTelNumberInfo(int var1, int var2, String var3);

    public static class TelNumberInfo {
        private ADBSDSService.TelNumberDetails telNumDetails = null;
        private int phoneNumberIndex = 0;
        private int phoneNumCount = 0;
        private ResourceLocator adbPic = null;

        public void setTelNumDetails(ADBSDSService.TelNumberDetails telNumberDetails) {
            this.telNumDetails = telNumberDetails;
        }

        public void setPhoneNumCount(int n) {
            this.phoneNumCount = n;
        }

        public void setResourceLocator(ResourceLocator resourceLocator) {
            this.adbPic = resourceLocator;
        }

        public ADBSDSService.TelNumberDetails getTelNumDetails() {
            return this.telNumDetails;
        }

        public int getPhoneNumCount() {
            return this.phoneNumCount;
        }

        public ResourceLocator getResourceLocator() {
            return this.adbPic;
        }

        public int getPhoneNumberIndex() {
            return this.phoneNumberIndex;
        }

        public void setPhoneNumberIndex(int n) {
            this.phoneNumberIndex = n;
        }
    }
}

