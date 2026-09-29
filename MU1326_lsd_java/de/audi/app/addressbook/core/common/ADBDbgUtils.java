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
                return new StringBuffer().append(n).append(" (valid)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (invalid)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgSuccessFlag(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (OK)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (Internal Error)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (Wrong Parameter)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (Wrong State)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (Function Unavailable)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (Full Entries)").toString();
            }
            case 6: {
                return new StringBuffer().append(n).append(" (Full Mem)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgAdbState(int n) {
        switch (n) {
            case 1: {
                return new StringBuffer().append(n).append(" (init)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (ready)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (shutdown)").toString();
            }
            case 0: {
                return new StringBuffer().append(n).append(" (undefined)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgEntryType(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (LOC)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (ME)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (SIM)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (OPP)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (COM)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgInvalidDataReason(int n) {
        switch (n) {
            case 4: {
                return new StringBuffer().append(n).append(" (new filter)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (new sort order)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (opp finished)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (download complete)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (profile switch)").toString();
            }
            case 0: {
                return new StringBuffer().append(n).append(" (unspecific)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
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
                return new StringBuffer().append(n).append(" (current page)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (current plus previous page)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (first page)").toString();
            }
            case 6: {
                return new StringBuffer().append(n).append(" (goto position)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (last page)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (next page)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (previous page)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgViewType(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (all)").toString();
            }
            case 6: {
                return new StringBuffer().append(n).append(" (com)").toString();
            }
            case 7: {
                return new StringBuffer().append(n).append(" (loc)").toString();
            }
            case 8: {
                return new StringBuffer().append(n).append(" (me)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (navi)").toString();
            }
            case 10: {
                return new StringBuffer().append(n).append(" (opp)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (phone)").toString();
            }
            case 9: {
                return new StringBuffer().append(n).append(" (sim)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (speed dials)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (top destinations)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (vt)").toString();
            }
            case 12: {
                return new StringBuffer().append(n).append(" (sd card 1)").toString();
            }
            case 13: {
                return new StringBuffer().append(n).append(" (sd card 2)").toString();
            }
            case 11: {
                return new StringBuffer().append(n).append(" (usb stick)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgStartupState(int n) {
        switch (n) {
            case 1: {
                return new StringBuffer().append(n).append(" (DSIAdbList available)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (profile info received)").toString();
            }
            case 8: {
                return new StringBuffer().append(n).append(" (DSIAdbInit available)").toString();
            }
            case 16: {
                return new StringBuffer().append(n).append(" (adb state init received)").toString();
            }
            case 32: {
                return new StringBuffer().append(n).append(" (adb state ready received)").toString();
            }
            case 64: {
                return new StringBuffer().append(n).append(" (DSIAdbEdit available)").toString();
            }
            case 128: {
                return new StringBuffer().append(n).append(" (DSIAdbSetup available)").toString();
            }
            case 256: {
                return new StringBuffer().append(n).append(" (DSIAdbVCardExchange available)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
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
                return new StringBuffer().append(n).append(" (OK)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (adb full entries)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (adb full mem)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (media removed)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (media readonly)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (wrong format)").toString();
            }
            case 6: {
                return new StringBuffer().append(n).append(" (duplicates)").toString();
            }
            case 7: {
                return new StringBuffer().append(n).append(" (invalid location)").toString();
            }
            case 8: {
                return new StringBuffer().append(n).append(" (bt lost)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static int getLLDbg(int n) {
        return n == 1 ? -2137614336 : 14808325;
    }

    public static int getLLInfo(int n) {
        return n == 1 ? 1078071040 : 14808325;
    }

    public static String dbgAdbMode(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (tel)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (nav)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (mail)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgSortOrder(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (default, not to be used!)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (firstname lastname)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (lastname, firstname)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (name firstname)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgDownloadState(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (pending)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (active all)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (active contacts first)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (active pictures)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (finished new data)").toString();
            }
            case 5: {
                return new StringBuffer().append(n).append(" (finished unchanged)").toString();
            }
            case 6: {
                return new StringBuffer().append(n).append(" (unfinished)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgAdbSDSServiceResultCode(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (RESULT_OK)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (RESULT_ERROR)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }

    public static String dbgCombiPbState(int n) {
        switch (n) {
            case 0: {
                return new StringBuffer().append(n).append(" (DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE)").toString();
            }
            case 1: {
                return new StringBuffer().append(n).append(" (DOWNLOAD_STATE_CURRENTLY_BEING_LOADED)").toString();
            }
            case 2: {
                return new StringBuffer().append(n).append(" (DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_UHV)").toString();
            }
            case 3: {
                return new StringBuffer().append(n).append(" (DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE)").toString();
            }
            case 4: {
                return new StringBuffer().append(n).append(" (DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION)").toString();
            }
        }
        return new StringBuffer().append(n).append(" (unknown)").toString();
    }
}

