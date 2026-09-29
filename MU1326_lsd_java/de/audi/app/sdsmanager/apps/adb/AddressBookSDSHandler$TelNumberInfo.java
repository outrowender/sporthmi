/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

import de.audi.atip.interapp.ADBSDSService$TelNumberDetails;
import org.dsi.ifc.global.ResourceLocator;

public class AddressBookSDSHandler$TelNumberInfo {
    private ADBSDSService$TelNumberDetails telNumDetails = null;
    private int phoneNumberIndex = 0;
    private int phoneNumCount = 0;
    private ResourceLocator adbPic = null;

    public void setTelNumDetails(ADBSDSService$TelNumberDetails aDBSDSService$TelNumberDetails) {
        this.telNumDetails = aDBSDSService$TelNumberDetails;
    }

    public void setPhoneNumCount(int n) {
        this.phoneNumCount = n;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this.adbPic = resourceLocator;
    }

    public ADBSDSService$TelNumberDetails getTelNumDetails() {
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

