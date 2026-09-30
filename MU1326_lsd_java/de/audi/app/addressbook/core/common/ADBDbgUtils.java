/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public class ADBDbgUtils {
    public static String dbg(AdbEntry adbEntry) {
        if (adbEntry != null) {
            return adbEntry.toString();
        }
        return "adbEntry == null";
    }

    public static String dbgShort(AdbEntry adbEntry) {
        if (adbEntry == null) {
            return "adbEntry == null";
        }
        Buffer buffer = new Buffer(150);
        buffer.append("AdbEntry( ");
        buffer.append("combinedName=\"").append(adbEntry.combinedName).append("\", ");
        buffer.append("entryId=").append(adbEntry.entryId).append(", ");
        buffer.append("entryType=").append(ADBDbgUtils.dbgEntryType(adbEntry.entryType)).append(" )");
        return buffer.toString();
    }

    public static String dbg(AdbEntry[] adbEntryArray) {
        if (adbEntryArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        buffer.append("AdbEntry[");
        buffer.append(adbEntryArray.length);
        buffer.append("] = { ");
        for (int i2 = 0; i2 < adbEntryArray.length; ++i2) {
            buffer.append(adbEntryArray[i2].getCombinedName());
            if (i2 >= adbEntryArray.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append(" }");
        return buffer.toString();
    }

    public static String dbg(DataSet[] dataSetArray) {
        if (dataSetArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        buffer.append("DataSet[");
        buffer.append(dataSetArray.length);
        buffer.append("] = \n");
        for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
            buffer.append("    { ");
            buffer.append(dataSetArray[i2].toString());
            buffer.append(" }");
            if (i2 >= dataSetArray.length - 1) continue;
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public static String dbg(long[] lArray) {
        Buffer buffer = new Buffer(150);
        buffer.append("{ ");
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            buffer.append(lArray[i2]);
            if (i2 >= lArray.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append(" }");
        return buffer.toString();
    }

    public static String dbg(int[] nArray) {
        Buffer buffer = new Buffer(150);
        buffer.append("{ ");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append(nArray[i2]);
            if (i2 >= nArray.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append(" }");
        return buffer.toString();
    }

    public static String dbg(ProfileInfo[] profileInfoArray) {
        if (profileInfoArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        buffer.append("ProfileInfo[");
        buffer.append(profileInfoArray.length);
        buffer.append("] = { ");
        for (int i2 = 0; i2 < profileInfoArray.length; ++i2) {
            buffer.append(profileInfoArray[i2] == null ? "<null>" : profileInfoArray[i2].toString());
            if (i2 >= profileInfoArray.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append(" }");
        return buffer.toString();
    }

    public static String dbg(ProfileInfo[] profileInfoArray, int n) {
        if (profileInfoArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        for (int i2 = 0; i2 < profileInfoArray.length; ++i2) {
            if (profileInfoArray[i2] == null) {
                buffer.append("<null>");
                if (i2 >= profileInfoArray.length - 1) continue;
                buffer.append(", ");
                continue;
            }
            if (i2 == n) {
                buffer.append("--> ");
            }
            buffer.append("\"").append(profileInfoArray[i2].name).append("\"");
            buffer.append(" (num=").append(profileInfoArray[i2].num).append(")");
            if (i2 == n) {
                buffer.append(" <--");
            }
            if (i2 >= profileInfoArray.length - 1) continue;
            buffer.append(", ");
        }
        return buffer.toString();
    }

    public static String dbgValidFlag(int n) {
        switch (n) {
            case 1: {
                return n + " (valid)";
            }
            case 2: {
                return n + " (invalid)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgSuccessFlag(int n) {
        switch (n) {
            case 0: {
                return n + " (OK)";
            }
            case 1: {
                return n + " (Internal Error)";
            }
            case 2: {
                return n + " (Wrong Parameter)";
            }
            case 3: {
                return n + " (Wrong State)";
            }
            case 4: {
                return n + " (Function Unavailable)";
            }
            case 5: {
                return n + " (Full Entries)";
            }
            case 6: {
                return n + " (Full Mem)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgAdbState(int n) {
        switch (n) {
            case 1: {
                return n + " (init)";
            }
            case 2: {
                return n + " (ready)";
            }
            case 3: {
                return n + " (shutdown)";
            }
            case 0: {
                return n + " (undefined)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgEntryType(int n) {
        switch (n) {
            case 0: {
                return n + " (LOC)";
            }
            case 1: {
                return n + " (ME)";
            }
            case 2: {
                return n + " (SIM)";
            }
            case 3: {
                return n + " (OPP)";
            }
            case 4: {
                return n + " (COM)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgInvalidDataReason(int n) {
        switch (n) {
            case 4: {
                return n + " (new filter)";
            }
            case 3: {
                return n + " (new sort order)";
            }
            case 5: {
                return n + " (opp finished)";
            }
            case 2: {
                return n + " (download complete)";
            }
            case 1: {
                return n + " (profile switch)";
            }
            case 0: {
                return n + " (unspecific)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbg(EntryMeter[] entryMeterArray) {
        if (entryMeterArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        for (int i2 = 0; i2 < entryMeterArray.length; ++i2) {
            buffer.append(entryMeterArray[i2] == null ? "<null>" : entryMeterArray[i2].toString());
            if (i2 >= entryMeterArray.length - 1) continue;
            buffer.append(", ");
        }
        return buffer.toString();
    }

    public static String dbgMovement(int n) {
        switch (n) {
            case 0: {
                return n + " (current page)";
            }
            case 3: {
                return n + " (current plus previous page)";
            }
            case 4: {
                return n + " (first page)";
            }
            case 6: {
                return n + " (goto position)";
            }
            case 5: {
                return n + " (last page)";
            }
            case 1: {
                return n + " (next page)";
            }
            case 2: {
                return n + " (previous page)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgViewType(int n) {
        switch (n) {
            case 0: {
                return n + " (all)";
            }
            case 6: {
                return n + " (com)";
            }
            case 7: {
                return n + " (loc)";
            }
            case 8: {
                return n + " (me)";
            }
            case 2: {
                return n + " (navi)";
            }
            case 10: {
                return n + " (opp)";
            }
            case 1: {
                return n + " (phone)";
            }
            case 9: {
                return n + " (sim)";
            }
            case 4: {
                return n + " (speed dials)";
            }
            case 3: {
                return n + " (top destinations)";
            }
            case 5: {
                return n + " (vt)";
            }
            case 12: {
                return n + " (sd card 1)";
            }
            case 13: {
                return n + " (sd card 2)";
            }
            case 11: {
                return n + " (usb stick)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgStartupState(int n) {
        switch (n) {
            case 1: {
                return n + " (DSIAdbList available)";
            }
            case 4: {
                return n + " (profile info received)";
            }
            case 8: {
                return n + " (DSIAdbInit available)";
            }
            case 16: {
                return n + " (adb state init received)";
            }
            case 32: {
                return n + " (adb state ready received)";
            }
            case 64: {
                return n + " (DSIAdbEdit available)";
            }
            case 128: {
                return n + " (DSIAdbSetup available)";
            }
            case 256: {
                return n + " (DSIAdbVCardExchange available)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbg(ResourceLocator[] resourceLocatorArray) {
        if (resourceLocatorArray == null) {
            return "<null>";
        }
        Buffer buffer = new Buffer(150);
        buffer.append("ResourceLocator[");
        buffer.append(resourceLocatorArray.length);
        buffer.append("] = \n");
        for (int i2 = 0; i2 < resourceLocatorArray.length && i2 < 10; ++i2) {
            buffer.append("  { ");
            buffer.append(resourceLocatorArray[i2] == null ? "<null>" : resourceLocatorArray[i2].toString());
            buffer.append(" }");
            if (i2 >= resourceLocatorArray.length - 1) continue;
            buffer.append("\n");
        }
        if (resourceLocatorArray.length > 10) {
            buffer.append("...");
        }
        return buffer.toString();
    }

    public static String dbgFailureReason(int n) {
        switch (n) {
            case 0: {
                return n + " (OK)";
            }
            case 1: {
                return n + " (adb full entries)";
            }
            case 2: {
                return n + " (adb full mem)";
            }
            case 3: {
                return n + " (media removed)";
            }
            case 4: {
                return n + " (media readonly)";
            }
            case 5: {
                return n + " (wrong format)";
            }
            case 6: {
                return n + " (duplicates)";
            }
            case 7: {
                return n + " (invalid location)";
            }
            case 8: {
                return n + " (bt lost)";
            }
        }
        return n + " (unknown)";
    }

    public static int getLLDbg(int n) {
        return n == 1 ? 10000000 : 100000000;
    }

    public static int getLLInfo(int n) {
        return n == 1 ? 1000000 : 100000000;
    }

    public static String dbgAdbMode(int n) {
        switch (n) {
            case 0: {
                return n + " (tel)";
            }
            case 1: {
                return n + " (nav)";
            }
            case 2: {
                return n + " (mail)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgSortOrder(int n) {
        switch (n) {
            case 0: {
                return n + " (default, not to be used!)";
            }
            case 2: {
                return n + " (firstname lastname)";
            }
            case 3: {
                return n + " (lastname, firstname)";
            }
            case 1: {
                return n + " (name firstname)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgDownloadState(int n) {
        switch (n) {
            case 0: {
                return n + " (pending)";
            }
            case 1: {
                return n + " (active all)";
            }
            case 2: {
                return n + " (active contacts first)";
            }
            case 3: {
                return n + " (active pictures)";
            }
            case 4: {
                return n + " (finished new data)";
            }
            case 5: {
                return n + " (finished unchanged)";
            }
            case 6: {
                return n + " (unfinished)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgAdbSDSServiceResultCode(int n) {
        switch (n) {
            case 0: {
                return n + " (RESULT_OK)";
            }
            case 1: {
                return n + " (RESULT_ERROR)";
            }
        }
        return n + " (unknown)";
    }

    public static String dbgCombiPbState(int n) {
        switch (n) {
            case 0: {
                return n + " (DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE)";
            }
            case 1: {
                return n + " (DOWNLOAD_STATE_CURRENTLY_BEING_LOADED)";
            }
            case 2: {
                return n + " (DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_UHV)";
            }
            case 3: {
                return n + " (DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE)";
            }
            case 4: {
                return n + " (DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION)";
            }
        }
        return n + " (unknown)";
    }
}

