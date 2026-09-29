/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;

public class NaviMyAudiImportUtil {
    public static final int PHONE_ICON_ISDN;
    public static final int PHONE_ICON_ISDN_PRIVATE;
    public static final int PHONE_ICON_ISDN_BUSINESS;
    public static final int PHONE_ICON_MOBILE;
    public static final int PHONE_ICON_MOBILE_PRIVATE;
    public static final int PHONE_ICON_MOBILE_BUSINESS;
    public static final int PHONE_ICON_FAX;
    public static final int PHONE_ICON_FAX_PRIVATE;
    public static final int PHONE_ICON_FAX_BUSINESS;
    public static final int PHONE_ICON_NONE;
    public static final int PHONE_ICON_PRIVATE;
    public static final int PHONE_ICON_BUSINESS;
    public static final int PHONETYPES_ALL_CATS_PATTERN;
    public static final int PHONETYPES_ALL_TYPES_PATTERN;

    public static boolean hasPostalAddressForDisplayInAdrDetailScreen(AddressData addressData, LogChannel logChannel) {
        logChannel.log(1078071040, "NaviMyAudiImportUtil#hasPostalAddressForDisplayInAdrDetailScreen()");
        return addressData.locality != null && addressData.locality.length() != 0 || addressData.street != null && addressData.street.length() != 0 || addressData.postalCode != null && addressData.postalCode.length() != 0;
    }

    public static String getFirstDisplayLineOfPostalAddress(AddressData addressData, LogChannel logChannel) {
        logChannel.log(1078071040, "NaviMyAudiImportUtil#getFirstDisplayLineOfPostalAddress()");
        return NaviMyAudiImportUtil.isEmpty(addressData.street) ? "" : addressData.street;
    }

    public static String getSecondDisplayLineOfPostalAddress(AddressData addressData, boolean bl, LogChannel logChannel) {
        logChannel.log(1078071040, "NaviMyAudiImportUtil#getSecondDisplayLineOfPostalAddress()");
        Buffer buffer = new Buffer();
        if (bl) {
            if (!NaviMyAudiImportUtil.isEmpty(addressData.locality)) {
                buffer.append(addressData.locality);
                if (!NaviMyAudiImportUtil.isEmpty(addressData.region) || !NaviMyAudiImportUtil.isEmpty(addressData.postalCode)) {
                    buffer.append(", ");
                }
            }
            if (!NaviMyAudiImportUtil.isEmpty(addressData.region)) {
                buffer.append(addressData.region);
                buffer.append(' ');
            }
            if (!NaviMyAudiImportUtil.isEmpty(addressData.postalCode)) {
                buffer.append(addressData.postalCode);
            }
        } else {
            if (!NaviMyAudiImportUtil.isEmpty(addressData.postalCode)) {
                buffer.append(addressData.postalCode);
                buffer.append(' ');
            }
            if (!NaviMyAudiImportUtil.isEmpty(addressData.locality)) {
                buffer.append(addressData.locality);
            }
        }
        return buffer.toString();
    }

    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static void fillTelNumberList(AdbEntry adbEntry, ListModelApp listModelApp, LogChannel logChannel) {
        logChannel.log(1078071040, "OnlineDestinationAddressUtility#fillTelNumberList()");
        listModelApp.clear();
        listModelApp.setMaxColumns(6);
        if (adbEntry.phoneData != null) {
            for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
                if (adbEntry.phoneData[i2].number == null || adbEntry.phoneData[i2].number.trim().length() == 0) continue;
                listModelApp.addRow(new ListCell[]{IntegerListCell.create(NaviMyAudiImportUtil.getIconTypeForPhoneNumber(adbEntry.phoneData[i2].numberType, logChannel)), new TextListCell(adbEntry.phoneData[i2].number), IntegerListCell.create(adbEntry.phoneData[i2].numberType), IntegerListCell.create(adbEntry.entryType), new TextListCell(adbEntry.combinedName), IntegerListCell.create(adbEntry.preferredNumberIdx == i2 ? 1 : 0)});
            }
        }
    }

    public static int getIconTypeForPhoneNumber(int n, LogChannel logChannel) {
        int n2;
        logChannel.log(1078071040, "OnlineDestinationAddressUtility#getIconTypeForPhoneNumber()");
        int n3 = n & 0x1FF8;
        int n4 = n & 6;
        switch (n3) {
            case 64: {
                n2 = NaviMyAudiImportUtil.getPhoneIconMobile(n4);
                break;
            }
            case 1088: {
                n2 = NaviMyAudiImportUtil.getPhoneIconMobile(n4);
                break;
            }
            case 72: {
                n2 = NaviMyAudiImportUtil.getPhoneIconMobile(n4);
                break;
            }
            case 1096: {
                n2 = NaviMyAudiImportUtil.getPhoneIconMobile(n4);
                break;
            }
            case 2048: {
                n2 = NaviMyAudiImportUtil.getPhoneIconISDN(n4);
                break;
            }
            case 8: {
                n2 = NaviMyAudiImportUtil.getPhoneIconISDN(n4);
                break;
            }
            case 1032: {
                n2 = NaviMyAudiImportUtil.getPhoneIconISDN(n4);
                break;
            }
            case 2056: {
                n2 = NaviMyAudiImportUtil.getPhoneIconISDN(n4);
                break;
            }
            case 16: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 1040: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 80: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 1104: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 24: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 1048: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 2064: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            case 2072: {
                n2 = NaviMyAudiImportUtil.getPhoneIconFax(n4);
                break;
            }
            default: {
                n2 = NaviMyAudiImportUtil.getPhoneIcon(n4);
            }
        }
        return n2;
    }

    private static int getPhoneIcon(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 10;
                break;
            }
            case 2: {
                n2 = 11;
                break;
            }
            default: {
                n2 = 9;
            }
        }
        return n2;
    }

    private static int getPhoneIconFax(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 6;
            }
        }
        return n2;
    }

    private static int getPhoneIconISDN(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int getPhoneIconMobile(int n) {
        int n2;
        switch (n) {
            case 4: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 5;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }
}

