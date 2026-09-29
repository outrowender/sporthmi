/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class ADBUtils {
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

    public static void checkAndFixADBEntry(AdbEntry adbEntry, IFrameworkAccess iFrameworkAccess) {
        ADBUtils.checkAndFixADBEntry(adbEntry, NullLogChannel.getInstance(), iFrameworkAccess);
    }

    public static void checkAndFixADBEntry(AdbEntry adbEntry, LogChannel logChannel, IFrameworkAccess iFrameworkAccess) {
        logChannel.log(-2137614336, "ADBUtils#checkAndFixADBEntry(): entry: %1", (Object)adbEntry);
        ADBUtils.checkAndFixPhoneData(adbEntry);
        ADBUtils.checkAndFixEmailData(adbEntry);
        ADBAddressUtils.checkAndFixAddressData(adbEntry, iFrameworkAccess);
    }

    private static void checkAndFixPhoneData(AdbEntry adbEntry) {
        boolean bl = true;
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            if (adbEntry.phoneData[i2] != null) continue;
            bl = false;
            break;
        }
        if (adbEntry.phoneData.length == 5 && bl) {
            return;
        }
        PhoneData[] phoneDataArray = adbEntry.phoneData;
        adbEntry.phoneData = new PhoneData[5];
        int n = 0;
        for (int i3 = 0; i3 < 5; ++i3) {
            PhoneData phoneData = new PhoneData("", 10, -1);
            while (phoneDataArray.length > n) {
                if (ADBUtils.isEmpty(phoneDataArray[n].number)) {
                    ++n;
                    continue;
                }
                phoneData = phoneDataArray[n];
                ++n;
                break;
            }
            adbEntry.phoneData[i3] = phoneData;
        }
    }

    private static void checkAndFixEmailData(AdbEntry adbEntry) {
        int n;
        if (adbEntry.emailData != null) {
            boolean bl = true;
            for (n = 0; n < adbEntry.emailData.length; ++n) {
                if (adbEntry.emailData[n] != null) continue;
                bl = false;
                break;
            }
            if (adbEntry.emailData.length == 3 && bl) {
                return;
            }
        }
        EmailData[] emailDataArray = adbEntry.emailData == null ? new EmailData[]{} : adbEntry.emailData;
        adbEntry.emailData = new EmailData[3];
        n = 0;
        for (int i2 = 0; i2 < 3; ++i2) {
            EmailData emailData = new EmailData(false, 0, "");
            while (n < emailDataArray.length) {
                if (ADBUtils.isEmpty(emailDataArray[n].emailAddr)) {
                    ++n;
                    continue;
                }
                emailData = emailDataArray[n];
                ++n;
                break;
            }
            adbEntry.emailData[i2] = emailData;
        }
    }

    public static boolean isLocalEntry(AdbEntry adbEntry) {
        switch (adbEntry.entryType) {
            case 0: 
            case 4: {
                return true;
            }
        }
        return false;
    }

    public static AdbEntry createNewAdbEntry() {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.entryId = 0L;
        adbEntry.entryType = 4;
        adbEntry.preferredNumberIdx = -1;
        adbEntry.voiceTagId = -1;
        adbEntry.personalData = new PersonalData("", "", "", "", null, "", "", new ResourceLocator());
        adbEntry.phoneData = new PhoneData[0];
        adbEntry.addressData = new AddressData[0];
        adbEntry.emailData = new EmailData[0];
        return adbEntry;
    }

    public static int countPhoneNumbers(AdbEntry adbEntry) {
        if (adbEntry == null || adbEntry.phoneData == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            if (!ADBUtils.isValidPhoneNumber(adbEntry.phoneData[i2])) continue;
            ++n;
        }
        return n;
    }

    public static int countEmailAddresses(AdbEntry adbEntry) {
        if (adbEntry == null || adbEntry.emailData == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < adbEntry.emailData.length; ++i2) {
            if (!ADBUtils.isValidEmailAddress(adbEntry.emailData[i2])) continue;
            ++n;
        }
        return n;
    }

    public static boolean isValidPhoneNumber(PhoneData phoneData) {
        return !ADBUtils.isEmpty(phoneData.getNumber());
    }

    public static boolean isSpeedDial(AdbEntry adbEntry) {
        boolean bl = false;
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            if (adbEntry.phoneData[i2].getSpeedDialKey() == -1) continue;
            bl = true;
            break;
        }
        return bl;
    }

    public static boolean isValidEmailAddress(EmailData emailData) {
        return !ADBUtils.isEmpty(emailData.getEmailAddr());
    }

    public static void cleanupEntryForSavingAsCopy(AdbEntry adbEntry) {
        adbEntry.entryId = 0L;
        adbEntry.voiceTagId = -1;
        for (int i2 = 0; i2 < adbEntry.phoneData.length; ++i2) {
            adbEntry.phoneData[i2].speedDialKey = -1;
        }
    }

    public static boolean isPictureAvailable(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            return false;
        }
        if (resourceLocator.isIntResource()) {
            return resourceLocator.getId() != -1;
        }
        return resourceLocator.getUrl() != null && resourceLocator.getUrl().length() > 0;
    }

    public static boolean hasRelevantData(DataSet dataSet, int n) {
        switch (n) {
            case 0: {
                return dataSet.getPhoneCount() > 0;
            }
            case 1: {
                return dataSet.getProbNavigable() > 0 || dataSet.getNavigable() > 0;
            }
            case 2: {
                return dataSet.getEmailCount() > 0;
            }
        }
        return false;
    }

    public static boolean isDownloadStateActive(int n) {
        return n == 1 || n == 2 || n == 3;
    }
}

