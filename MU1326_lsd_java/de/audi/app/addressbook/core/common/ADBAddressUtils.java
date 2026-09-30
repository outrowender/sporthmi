/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.Buffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class ADBAddressUtils {
    static DecimalFormat geoPosFormatter = new DecimalFormat("########0.000000");
    private static final String SPACE = " ";

    public static boolean hasValidPostalAddress(AddressData addressData) {
        return addressData.locality != null && addressData.locality.length() != 0 || addressData.postalCode != null && addressData.postalCode.length() != 0 || addressData.street != null && addressData.street.length() != 0;
    }

    public static String getFirstDisplayLineOfPostalAddress(AddressData addressData, int n) {
        String string = ADBUtils.isEmpty(addressData.street) ? "" : addressData.street;
        String string2 = ADBUtils.isEmpty(addressData.region) ? "" : addressData.region;
        String string3 = ADBUtils.isEmpty(addressData.locality) ? "" : addressData.locality;
        String string4 = ADBUtils.isEmpty(addressData.postalCode) ? "" : addressData.postalCode;
        switch (n) {
            case 0: {
                return string;
            }
            case 1: {
                return string;
            }
            case 2: {
                return ADBModelUtils.concatenate(string2, string3, SPACE);
            }
            case 3: {
                return ADBModelUtils.concatenate(ADBModelUtils.concatenate(string4, string2, SPACE), string3, SPACE);
            }
            case 4: {
                return ADBModelUtils.concatenate(ADBModelUtils.concatenate(string4, string2, SPACE), string3, SPACE);
            }
            case 5: {
                return ADBModelUtils.concatenate(string4, string3, SPACE);
            }
        }
        return string;
    }

    public static String getSecondDisplayLineOfPostalAddress(AddressData addressData, int n) {
        String string = ADBUtils.isEmpty(addressData.street) ? "" : addressData.street;
        String string2 = ADBUtils.isEmpty(addressData.region) ? "" : addressData.region;
        String string3 = ADBUtils.isEmpty(addressData.locality) ? "" : addressData.locality;
        String string4 = ADBUtils.isEmpty(addressData.postalCode) ? "" : addressData.postalCode;
        switch (n) {
            case 0: {
                return ADBModelUtils.concatenate(string4, string3, SPACE);
            }
            case 1: {
                return ADBModelUtils.concatenate(ADBModelUtils.concatenate(string3, string2, SPACE), string4, SPACE);
            }
            case 2: {
                return ADBModelUtils.concatenate(string, string4, SPACE);
            }
            case 3: {
                return string;
            }
            case 4: {
                return string;
            }
            case 5: {
                return string;
            }
        }
        return ADBModelUtils.concatenate(string4, string3, SPACE);
    }

    public static void checkAndFixAddressData(AdbEntry adbEntry, IFrameworkAccess iFrameworkAccess) {
        Object object;
        if (adbEntry.addressData.length != 2) {
            object = adbEntry.addressData;
            (adbEntry.addressData = new AddressData[2])[0] = ((AddressData[])object).length > 0 ? object[0] : new AddressData(1, "", "", "", "", "", "", false, "", 0, null, new ResourceLocator());
            AddressData addressData = adbEntry.addressData[1] = ((AddressData[])object).length > 1 ? object[1] : new AddressData(2, "", "", "", "", "", "", false, "", 0, null, new ResourceLocator());
        }
        if (adbEntry.addressData[0].addressType == 2 && adbEntry.addressData[1].addressType != 2) {
            object = adbEntry.addressData[0];
            adbEntry.addressData[0] = adbEntry.addressData[1];
            adbEntry.addressData[1] = object;
        } else if (adbEntry.addressData[1].addressType == 1 && adbEntry.addressData[0].addressType != 1) {
            object = adbEntry.addressData[0];
            adbEntry.addressData[0] = adbEntry.addressData[1];
            adbEntry.addressData[1] = object;
        }
        adbEntry.addressData[0].addressType = 1;
        adbEntry.addressData[1].addressType = 2;
        if (iFrameworkAccess.getSysConst(442) == 2 || iFrameworkAccess.getSysConst(442) == 4) {
            adbEntry.addressData[0].geoPosition = "";
            adbEntry.addressData[1].geoPosition = "";
        }
    }

    public static boolean hasAddress(AdbEntry adbEntry) {
        if (adbEntry == null || adbEntry.addressData == null || adbEntry.addressData.length == 0) {
            return false;
        }
        if (ADBAddressUtils.hasValidPostalAddress(adbEntry.addressData[0]) || adbEntry.addressData.length > 1 && ADBAddressUtils.hasValidPostalAddress(adbEntry.addressData[1])) {
            return true;
        }
        if (!ADBAddressUtils.isEmptyLocation(adbEntry.addressData[0].navLocation) || adbEntry.addressData.length > 1 && !ADBAddressUtils.isEmptyLocation(adbEntry.addressData[1].navLocation)) {
            return true;
        }
        return ADBAddressUtils.isValidGeoPos(adbEntry.addressData[0].geoPosition) || adbEntry.addressData.length > 1 && ADBAddressUtils.isValidGeoPos(adbEntry.addressData[1].geoPosition);
    }

    public static boolean isEmptyLocation(byte[] byArray) {
        return byArray == null || byArray.length == 0;
    }

    public static boolean isEmptyFormattedLocation(String[] stringArray) {
        return stringArray == null || stringArray.length != 2 || stringArray[0] == null || stringArray[1] == null || stringArray[0].length() == 0;
    }

    public static boolean isValidGeoPos(String string) {
        return string != null && !ADBUtils.isEmpty(string) && string.indexOf(59) > 0 && string.indexOf(59) < string.length();
    }

    public static String[] vCardGeoPosToDegrees(String string) {
        if (ADBAddressUtils.isValidGeoPos(string)) {
            String[] stringArray = new String[]{string.substring(0, string.indexOf(59)), string.substring(string.indexOf(59) + 1)};
            return stringArray;
        }
        return new String[0];
    }

    public static String degreesGeoPosToVCardFormat(double d2, double d3) {
        Buffer buffer = new Buffer(geoPosFormatter.format(d2));
        buffer.append(';');
        buffer.append(geoPosFormatter.format(d3));
        return buffer.toString();
    }

    public static boolean hasNavLocation(AdbEntry adbEntry) {
        if (adbEntry == null || adbEntry.addressData == null || adbEntry.addressData.length == 0) {
            return false;
        }
        return !ADBAddressUtils.isEmptyLocation(adbEntry.addressData[0].navLocation) || adbEntry.addressData.length > 1 && !ADBAddressUtils.isEmptyLocation(adbEntry.addressData[1].navLocation);
    }

    static {
        DecimalFormatSymbols decimalFormatSymbols = geoPosFormatter.getDecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        geoPosFormatter.setDecimalFormatSymbols(decimalFormatSymbols);
    }
}

