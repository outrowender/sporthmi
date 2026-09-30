/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.models;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.AbstractADBEntryDetailsListRowBuilder;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.atip.metrics.GeoMetric;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class AddressBookEntryDetailsListRowBuilder
extends AbstractADBEntryDetailsListRowBuilder {
    private AbstractAddressBookApplication appAdr;

    public AddressBookEntryDetailsListRowBuilder(AbstractAddressBookApplication abstractAddressBookApplication) {
        this.appAdr = abstractAddressBookApplication;
    }

    public ADBEntryDetailsListRow createAddressDetailsRow(AdbEntry adbEntry, int n) {
        int n2 = n == 0 || n == 2 || n == 4 ? 0 : 1;
        String[] stringArray = this.getAddressDisplayText(adbEntry.addressData[n2], n);
        String string = this.getAddressDisplayTextSingleLine(adbEntry.addressData[n2].navLocation);
        this.appAdr.getLog().log(10000000, "AddressBookEntryDetailsListRowBuilder#createAddressDetailsRow(): displayTexts for addressData %1 and addressType %3 are: %2", (Object)adbEntry.addressData[n2], (Object)stringArray, (long)n);
        if (stringArray == null) {
            return null;
        }
        return new ADBEntryDetailsListRow(adbEntry, n, stringArray[0], stringArray[1], string, null, null);
    }

    protected String[] getAddressDisplayText(AddressData addressData, int n) {
        String[] stringArray;
        if (n == 0 || n == 1) {
            if (!ADBAddressUtils.hasValidPostalAddress(addressData)) {
                this.appAdr.getLog().log(1000000, "AddressBookEntryDetailsListRowBuilder#getAddressDisplayText(): invalid address: %1 ", (Object)addressData.toString());
                return null;
            }
            int n2 = this.appAdr.getFramework().getSysConst(442);
            stringArray = new String[]{ADBAddressUtils.getFirstDisplayLineOfPostalAddress(addressData, n2), ADBAddressUtils.getSecondDisplayLineOfPostalAddress(addressData, n2)};
        } else if (n == 2 || n == 3) {
            String[] stringArray2 = this.appAdr.getNaviGateway().getLocationName(addressData.navLocation);
            if (ADBAddressUtils.isEmptyFormattedLocation(stringArray2)) {
                return null;
            }
            stringArray = new String[]{stringArray2[0], stringArray2[1]};
        } else if (n == 4 || n == 5) {
            String[] stringArray3 = ADBAddressUtils.vCardGeoPosToDegrees(addressData.geoPosition);
            if (stringArray3 == null || stringArray3.length != 2) {
                return null;
            }
            GeoMetric geoMetric = this.appAdr.getNaviGateway().convertDecimalsToGeoMetric(stringArray3[1], stringArray3[0]);
            if (geoMetric == null) {
                return null;
            }
            stringArray = new String[]{geoMetric.formatLatitude() + ", " + geoMetric.formatLongitude(), ""};
        } else {
            return null;
        }
        return stringArray;
    }

    protected String getAddressDisplayTextSingleLine(byte[] byArray) {
        return this.appAdr.getNaviGateway().getLocationNameSingleline(byArray);
    }
}

