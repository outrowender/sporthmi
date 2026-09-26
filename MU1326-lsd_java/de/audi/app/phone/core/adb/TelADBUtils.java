/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.EmailData;

public class TelADBUtils {
    public static boolean hasEmailAddress(AdbEntry adbEntry) {
        EmailData[] emailDataArray;
        EmailData[] emailDataArray2 = emailDataArray = adbEntry != null ? adbEntry.getEmailData() : null;
        if (emailDataArray != null) {
            for (int i2 = 0; i2 < emailDataArray.length; ++i2) {
                if (emailDataArray[i2] == null || emailDataArray[i2].getEmailAddr() == null || emailDataArray[i2].getEmailAddr().length() <= 0) continue;
                return true;
            }
        }
        return false;
    }
}

