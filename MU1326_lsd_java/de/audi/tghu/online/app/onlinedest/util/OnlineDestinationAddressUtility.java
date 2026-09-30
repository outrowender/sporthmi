/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest.util;

import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.PortalADBEntry;
import org.dsi.ifc.online.PortalAddressData;
import org.dsi.ifc.online.PortalLocation;
import org.dsi.ifc.online.PortalNavigationData;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public final class OnlineDestinationAddressUtility {
    private static LogChannel log;
    private static final int MAX_COLUMNS = 6;
    public static final int PHONE_ICON_ISDN = 0;
    public static final int PHONE_ICON_ISDN_PRIVATE = 1;
    public static final int PHONE_ICON_ISDN_BUSINESS = 2;
    public static final int PHONE_ICON_MOBILE = 3;
    public static final int PHONE_ICON_MOBILE_PRIVATE = 4;
    public static final int PHONE_ICON_MOBILE_BUSINESS = 5;
    public static final int PHONE_ICON_FAX = 6;
    public static final int PHONE_ICON_FAX_PRIVATE = 7;
    public static final int PHONE_ICON_FAX_BUSINESS = 8;
    public static final int PHONE_ICON_NONE = 9;
    public static final int PHONE_ICON_PRIVATE = 10;
    public static final int PHONE_ICON_BUSINESS = 11;
    public static final int PHONETYPES_ALL_CATS_PATTERN = 8184;
    public static final int PHONETYPES_ALL_TYPES_PATTERN = 6;

    private OnlineDestinationAddressUtility() {
    }

    public static void setLogChannel(LogChannel logChannel) {
        log = logChannel;
    }

    public static OnlineAdbEntry convertPortalEntryToOnlineAdbEntry(PortalADBEntry portalADBEntry, NaviADBService naviADBService) {
        int n;
        AddressData[] addressDataArray;
        int n2;
        log.log(10000000, "OnlineDestinationAddressUtility#convertPortalEntryToAdbEntry(): portalEntry: %1", (Object)portalADBEntry);
        AdbEntry adbEntry = new AdbEntry();
        OnlineAdbEntry onlineAdbEntry = new OnlineAdbEntry(adbEntry, portalADBEntry.additionalDescription);
        adbEntry.entryId = portalADBEntry.entryID;
        adbEntry.combinedName = portalADBEntry.generalDescription;
        adbEntry.personalData = OnlineDestinationAddressUtility.copyPersonalData(portalADBEntry);
        PhoneData[] phoneDataArray = new PhoneData[portalADBEntry.phoneData.length];
        for (n2 = 0; n2 < portalADBEntry.phoneData.length; ++n2) {
            addressDataArray = new PhoneData();
            addressDataArray.number = portalADBEntry.phoneData[n2].number;
            addressDataArray.numberType = (int)portalADBEntry.phoneData[n2].type;
            phoneDataArray[n2] = addressDataArray;
        }
        adbEntry.phoneData = phoneDataArray;
        adbEntry.preferredNumberIdx = portalADBEntry.preferedNumber;
        if (portalADBEntry.messagingData != null && portalADBEntry.messagingData.length > 0) {
            adbEntry.emailData = new EmailData[]{new EmailData(false, 0, portalADBEntry.messagingData[0].email)};
            adbEntry.urlData = new String[]{portalADBEntry.messagingData[0].url};
        }
        n2 = portalADBEntry.addressData.length < 2 ? portalADBEntry.addressData.length : 2;
        addressDataArray = new AddressData[n2];
        for (n = 0; n < n2; ++n) {
            AddressData addressData;
            addressDataArray[n] = addressData = OnlineDestinationAddressUtility.copyPostalAddress(portalADBEntry.addressData[n]);
        }
        adbEntry.addressData = addressDataArray;
        if (portalADBEntry.navigationData != null) {
            n = Math.min(2, portalADBEntry.navigationData.length);
            for (int i2 = 0; i2 < n; ++i2) {
                int n3 = portalADBEntry.navigationData[i2].naviType == 0L ? 0 : 1;
                AddressData addressData = OnlineDestinationAddressUtility.getAddressData(n3, adbEntry.addressData);
                if (addressData == null) {
                    log.log(100000, "OnlineDestinationAddressUtility#convertPortalEntryToAdbEntry(): portalEntry: %1", (Object)portalADBEntry);
                    continue;
                }
                OnlineDestinationAddressUtility.copyNavData(addressData, portalADBEntry.navigationData[i2], naviADBService);
                onlineAdbEntry.addAdressData(OnlineDestinationAddressUtility.getFullAdressAndNavigationData(addressData, portalADBEntry.navigationData[i2]));
            }
        }
        log.log(10000000, "OnlineDestinationAddressUtility#convertPortalEntryToAdbEntry(): converstion done, returning AdbEntry: %1", (Object)adbEntry);
        return onlineAdbEntry;
    }

    private static AddressData getAddressData(int n, AddressData[] addressDataArray) {
        int n2;
        for (n2 = n; n2 >= addressDataArray.length; --n2) {
        }
        return n2 >= 0 ? addressDataArray[n2] : null;
    }

    public static OnlineAdbEntry[] convertPortalEntriesToOnlineAdbEntry(PortalADBEntry[] portalADBEntryArray, NaviADBService naviADBService) {
        int n = portalADBEntryArray.length;
        OnlineAdbEntry[] onlineAdbEntryArray = new OnlineAdbEntry[n];
        for (int i2 = 0; i2 < n; ++i2) {
            onlineAdbEntryArray[i2] = OnlineDestinationAddressUtility.convertPortalEntryToOnlineAdbEntry(portalADBEntryArray[i2], naviADBService);
        }
        return onlineAdbEntryArray;
    }

    private static PersonalData copyPersonalData(PortalADBEntry portalADBEntry) {
        PersonalData personalData = new PersonalData();
        personalData.lastName = portalADBEntry.personalData.lastName;
        personalData.lastNameSound = portalADBEntry.personalData.lastNameSnd;
        personalData.firstName = portalADBEntry.personalData.firstName;
        personalData.firstNameSound = portalADBEntry.personalData.firstNameSnd;
        personalData.organization = portalADBEntry.personalData.organizationName;
        return personalData;
    }

    private static AddressData copyPostalAddress(PortalAddressData portalAddressData) {
        log.log(1000000, "OnlineDestinationAddressUtility#copyPostalAddress()");
        AddressData addressData = new AddressData();
        addressData.addressType = (int)portalAddressData.addressType;
        addressData.country = portalAddressData.country;
        addressData.locality = portalAddressData.locality;
        addressData.street = portalAddressData.street;
        addressData.region = portalAddressData.region;
        addressData.postalCode = portalAddressData.postalCode;
        return addressData;
    }

    private static void copyNavData(AddressData addressData, PortalNavigationData portalNavigationData, NaviADBService naviADBService) {
        log.log(1000000, "OnlineDestinationAddressUtility#copyNavData()");
        addressData.geoPosition = portalNavigationData.geoPosition;
        addressData.topDestination = portalNavigationData.topDestination;
        addressData.navLocation = naviADBService.resolveGeoCoords(portalNavigationData.naviLocation.longitude, portalNavigationData.naviLocation.latitude, "");
    }

    private static OnlineAdbEntry.FullAdressData getFullAdressAndNavigationData(AddressData addressData, PortalNavigationData portalNavigationData) {
        NavLocationWgs84 navLocationWgs84;
        OnlineAdbEntry.FullAdressData fullAdressData = new OnlineAdbEntry.FullAdressData();
        fullAdressData.adress = addressData;
        PortalLocation portalLocation = portalNavigationData.naviLocation;
        log.log(1000000, "OnlineDestinationAddressUtility#getFullAdressAndnavigation matching adress %1 to navLocation %2", (Object)addressData, (Object)portalLocation);
        fullAdressData.navLocation = navLocationWgs84 = new NavLocationWgs84(portalLocation.longitude, portalLocation.latitude);
        return fullAdressData;
    }

    public static boolean hasPostalAddressForDisplayInAdrDetailScreen(AddressData addressData) {
        log.log(1000000, "OnlineDestinationAddressUtility#hasPostalAddressForDisplayInAdrDetailScreen()");
        return addressData.locality != null && addressData.locality.length() != 0 || addressData.street != null && addressData.street.length() != 0 || addressData.postalCode != null && addressData.postalCode.length() != 0;
    }

    public static String getFirstDisplayLineOfPostalAddress(AddressData addressData) {
        log.log(1000000, "OnlineDestinationAddressUtility#getFirstDisplayLineOfPostalAddress()");
        return OnlineDestinationAddressUtility.isEmpty(addressData.street) ? "" : addressData.street;
    }

    public static String getSecondDisplayLineOfPostalAddress(AddressData addressData, boolean bl) {
        log.log(1000000, "OnlineDestinationAddressUtility#getSecondDisplayLineOfPostalAddress()");
        Buffer buffer = new Buffer();
        if (bl) {
            if (!OnlineDestinationAddressUtility.isEmpty(addressData.locality)) {
                buffer.append(addressData.locality);
                if (!OnlineDestinationAddressUtility.isEmpty(addressData.region) || !OnlineDestinationAddressUtility.isEmpty(addressData.postalCode)) {
                    buffer.append(", ");
                }
            }
            if (!OnlineDestinationAddressUtility.isEmpty(addressData.region)) {
                buffer.append(addressData.region);
                buffer.append(' ');
            }
            if (!OnlineDestinationAddressUtility.isEmpty(addressData.postalCode)) {
                buffer.append(addressData.postalCode);
            }
        } else {
            if (!OnlineDestinationAddressUtility.isEmpty(addressData.postalCode)) {
                buffer.append(addressData.postalCode);
                buffer.append(' ');
            }
            if (!OnlineDestinationAddressUtility.isEmpty(addressData.locality)) {
                buffer.append(addressData.locality);
            }
        }
        return buffer.toString();
    }

    public static boolean isEmpty(String string) {
        log.log(1000000, "OnlineDestinationAddressUtility#isEmpty()");
        if (string == null) {
            return true;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (Character.isWhitespace(string.charAt(i2))) continue;
            return false;
        }
        return true;
    }

    public static void fillTelNumberList(AdbEntry adbEntry, ListModelApp listModelApp) {
        log.log(1000000, "OnlineDestinationAddressUtility#fillTelNumberList()");
        listModelApp.clear();
        listModelApp.setMaxColumns(6);
        if (adbEntry.phoneData != null) {
            for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
                if (adbEntry.phoneData[i2].number == null || adbEntry.phoneData[i2].number.trim().length() == 0) continue;
                listModelApp.addRow(new ListCell[]{IntegerListCell.create(OnlineDestinationAddressUtility.getIconTypeForPhoneNumber(adbEntry.phoneData[i2].numberType)), new TextListCell(adbEntry.phoneData[i2].number), IntegerListCell.create(adbEntry.phoneData[i2].numberType), IntegerListCell.create(adbEntry.entryType), new TextListCell(adbEntry.combinedName), IntegerListCell.create(adbEntry.preferredNumberIdx == i2 ? 1 : 0)});
            }
        }
    }

    public static int getIconTypeForPhoneNumber(int n) {
        log.log(1000000, "OnlineDestinationAddressUtility#getIconTypeForPhoneNumber()");
        int n2 = n & 0x1FF8;
        int n3 = n & 6;
        int n4 = 9;
        block0 : switch (n2) {
            case 1096: {
                switch (n3) {
                    case 4: {
                        n4 = 4;
                        break block0;
                    }
                    case 2: {
                        n4 = 5;
                        break block0;
                    }
                }
                n4 = 3;
                break;
            }
            case 3080: {
                switch (n3) {
                    case 4: {
                        n4 = 1;
                        break block0;
                    }
                    case 2: {
                        n4 = 2;
                        break block0;
                    }
                }
                n4 = 0;
                break;
            }
            case 3160: {
                switch (n3) {
                    case 4: {
                        n4 = 7;
                        break block0;
                    }
                    case 2: {
                        n4 = 8;
                        break block0;
                    }
                }
                n4 = 6;
                break;
            }
            default: {
                switch (n3) {
                    case 4: {
                        n4 = 10;
                        break block0;
                    }
                    case 2: {
                        n4 = 11;
                        break block0;
                    }
                }
                n4 = 9;
            }
        }
        return n4;
    }

    public static OnlineAdbEntry[] setOnlineAdbEntryImportState(OnlineAdbEntry[] onlineAdbEntryArray, PortalADBEntry[] portalADBEntryArray) {
        block0: for (int i2 = 0; i2 < onlineAdbEntryArray.length; ++i2) {
            for (int i3 = 0; i3 < portalADBEntryArray.length; ++i3) {
                if (onlineAdbEntryArray[i2].getAdbEntry().getEntryId() != portalADBEntryArray[i3].entryID) continue;
                onlineAdbEntryArray[i2].setImport(true);
                continue block0;
            }
        }
        return onlineAdbEntryArray;
    }
}

