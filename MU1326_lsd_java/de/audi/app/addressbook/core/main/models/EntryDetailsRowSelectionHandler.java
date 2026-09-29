/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.models;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.interapp.MessagingGateway;
import de.audi.app.addressbook.core.main.interapp.NaviGateway;
import org.dsi.ifc.organizer.AdbEntry;

public class EntryDetailsRowSelectionHandler {
    static final int ACTION_DIAL;
    static final int ACTION_PREPARE;
    static final int ACTION_DIAL_PORSCHE;
    static final int ACTION_PREPARE_PORSCHE;

    public static boolean entryDetailsRowSelected(AbstractAddressBookApplication abstractAddressBookApplication, ADBEntryDetailsListRow aDBEntryDetailsListRow) {
        return EntryDetailsRowSelectionHandler.entryDetailsRowSelected(abstractAddressBookApplication, aDBEntryDetailsListRow, 0);
    }

    public static boolean entryDetailsRowSelected(AbstractAddressBookApplication abstractAddressBookApplication, ADBEntryDetailsListRow aDBEntryDetailsListRow, int n) {
        return EntryDetailsRowSelectionHandler.entryDetailsRowSelected(abstractAddressBookApplication, aDBEntryDetailsListRow, n, false);
    }

    public static boolean entryDetailsRowSelected(AbstractAddressBookApplication abstractAddressBookApplication, ADBEntryDetailsListRow aDBEntryDetailsListRow, int n, boolean bl) {
        AdbEntry adbEntry = aDBEntryDetailsListRow.getEntry();
        int n2 = aDBEntryDetailsListRow.getDataIndex();
        int n3 = aDBEntryDetailsListRow.getDataType();
        switch (n3) {
            case 0: {
                EntryDetailsRowSelectionHandler.phoneNumberRowSelected(abstractAddressBookApplication, adbEntry, n2, n, bl);
                return false;
            }
            case 1: {
                NaviGateway naviGateway = abstractAddressBookApplication.getNaviGateway();
                if (naviGateway.isNaviReady()) {
                    return EntryDetailsRowSelectionHandler.setNavLocation(adbEntry, n2, naviGateway);
                }
                abstractAddressBookApplication.getLog().log(10000, "EntryDetailsRowSelectionHandler#entryDetailsRowSelected(): navi service not available or navi not ready!");
                return false;
            }
            case 2: {
                MessagingGateway messagingGateway = abstractAddressBookApplication.getMessagingGateway();
                if (messagingGateway.isSendEmailReady()) {
                    if (adbEntry.entryId != 0L) {
                        messagingGateway.sendMessageTo(adbEntry.entryId, 1, n2, ADBUtils.isSpeedDial(adbEntry) ? 4 : 0);
                    } else {
                        messagingGateway.sendMessageTo(adbEntry.emailData[n2].emailAddr, 1);
                    }
                    return true;
                }
                abstractAddressBookApplication.getLog().log(1078071040, "EntryDetailsRowSelectionHandler#entryDetailsRowSelected(): messaging service not available or messaging (email) not ready!");
                return false;
            }
            case 3: 
            case 4: 
            case 5: {
                return false;
            }
        }
        abstractAddressBookApplication.getLog().log(10000, "EntryDetailsRowSelectionHandler#entryDetailsRowSelected(): unknown dataType: %1", (long)n3);
        return false;
    }

    private static void phoneNumberRowSelected(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n, int n2, boolean bl) {
        if (abstractAddressBookApplication.getFramework().getSysConst(4168) == 7 || abstractAddressBookApplication.getFramework().getSysConst(4168) == 5) {
            EntryDetailsRowSelectionHandler.proceedActionForPorsche(abstractAddressBookApplication, adbEntry, n, n2, bl);
        } else {
            EntryDetailsRowSelectionHandler.proceedActionForAudi(abstractAddressBookApplication, adbEntry, n, n2, bl);
        }
    }

    private static void proceedActionForPorsche(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n, int n2, boolean bl) {
        if (n2 == 1) {
            EntryDetailsRowSelectionHandler.dialAction(abstractAddressBookApplication, adbEntry, n, bl);
        } else if (n2 == 0) {
            EntryDetailsRowSelectionHandler.prepareAction(abstractAddressBookApplication, adbEntry, n);
        }
    }

    private static void proceedActionForAudi(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n, int n2, boolean bl) {
        if (n2 == 0) {
            EntryDetailsRowSelectionHandler.dialAction(abstractAddressBookApplication, adbEntry, n, bl);
        } else if (n2 == 1) {
            EntryDetailsRowSelectionHandler.prepareAction(abstractAddressBookApplication, adbEntry, n);
        }
    }

    private static void dialAction(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n, boolean bl) {
        if (adbEntry.entryId != 0L) {
            abstractAddressBookApplication.getPhoneGateway().dialNumber(adbEntry.getCombinedName(), adbEntry.phoneData[n].number, adbEntry.phoneData[n].numberType, adbEntry.entryType, adbEntry.entryId, adbEntry.personalData.contactPicture, n, ADBUtils.countPhoneNumbers(adbEntry), bl);
        } else {
            abstractAddressBookApplication.getPhoneGateway().dialNumber(adbEntry.phoneData[n].number, bl);
        }
    }

    private static void prepareAction(AbstractAddressBookApplication abstractAddressBookApplication, AdbEntry adbEntry, int n) {
        if (adbEntry.entryId != 0L) {
            abstractAddressBookApplication.getPhoneGateway().prepareDialing(adbEntry.getCombinedName(), adbEntry.phoneData[n].number, adbEntry.phoneData[n].numberType, adbEntry.entryType, adbEntry.entryId, adbEntry.personalData.contactPicture, n, ADBUtils.countPhoneNumbers(adbEntry));
        } else {
            abstractAddressBookApplication.getPhoneGateway().prepareDialing(adbEntry.phoneData[n].number);
        }
    }

    private static boolean setNavLocation(AdbEntry adbEntry, int n, NaviGateway naviGateway) {
        boolean bl = true;
        switch (n) {
            case 0: {
                naviGateway.setDestination(adbEntry, 0, adbEntry.combinedName);
                break;
            }
            case 1: {
                naviGateway.setDestination(adbEntry, 1, adbEntry.combinedName);
                break;
            }
            case 2: {
                naviGateway.setDestination(adbEntry.addressData[0].navLocation, adbEntry.combinedName);
                break;
            }
            case 3: {
                naviGateway.setDestination(adbEntry.addressData[1].navLocation, adbEntry.combinedName);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    bl = false;
                }
                naviGateway.setDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    bl = false;
                }
                naviGateway.setDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public static void entryDetailsRowFocused(AbstractAddressBookApplication abstractAddressBookApplication, ADBEntryDetailsListRow aDBEntryDetailsListRow) {
        AdbEntry adbEntry = aDBEntryDetailsListRow.getEntry();
        int n = aDBEntryDetailsListRow.getDataIndex();
        int n2 = aDBEntryDetailsListRow.getDataType();
        switch (n2) {
            case 1: {
                EntryDetailsRowSelectionHandler.setPreviewMapAdbLocation(adbEntry, n, abstractAddressBookApplication.getNaviGateway(), abstractAddressBookApplication);
                return;
            }
        }
        abstractAddressBookApplication.getNaviGateway().showPreviewMap(false);
    }

    public static void entryDetailsRowDefocused(AbstractAddressBookApplication abstractAddressBookApplication) {
        abstractAddressBookApplication.getNaviGateway().showPreviewMap(false);
    }

    private static void setPreviewMapAdbLocation(AdbEntry adbEntry, int n, NaviGateway naviGateway, AbstractAddressBookApplication abstractAddressBookApplication) {
        switch (n) {
            case 2: {
                naviGateway.focusPreviewMap(adbEntry.addressData[0].navLocation);
                break;
            }
            case 3: {
                naviGateway.focusPreviewMap(adbEntry.addressData[1].navLocation);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    return;
                }
                naviGateway.focusPreviewMap(stringArray[1], stringArray[0]);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    return;
                }
                naviGateway.focusPreviewMap(stringArray[1], stringArray[0]);
                break;
            }
            case 0: {
                naviGateway.focusPreviewMap(adbEntry, n);
                break;
            }
            case 1: {
                naviGateway.focusPreviewMap(adbEntry, n);
                break;
            }
            default: {
                abstractAddressBookApplication.getLog().log(10000, "EntryDetailsRowSelectionHandler#setPreviewMapAdbLocation(): unknown address type: %1", (long)n);
                return;
            }
        }
    }
}

