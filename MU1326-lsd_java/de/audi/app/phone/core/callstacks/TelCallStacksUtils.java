/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.phone.core.callstacks.TelCallStacksUtils$1;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class TelCallStacksUtils {
    public static CallStackEntry[] createCombinedCallStack(CallStackEntry[] callStackEntryArray, CallStackEntry[] callStackEntryArray2, CallStackEntry[] callStackEntryArray3) {
        CallStackEntry[] callStackEntryArray4 = callStackEntryArray2 != null ? callStackEntryArray2 : new CallStackEntry[]{};
        CallStackEntry[] callStackEntryArray5 = callStackEntryArray3 != null ? callStackEntryArray3 : new CallStackEntry[]{};
        CallStackEntry[] callStackEntryArray6 = callStackEntryArray != null ? callStackEntryArray : new CallStackEntry[]{};
        Object[] objectArray = new CallStackEntry[callStackEntryArray4.length + callStackEntryArray6.length + callStackEntryArray5.length];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (n4 < objectArray.length) {
            if (n < callStackEntryArray4.length) {
                objectArray[n4++] = callStackEntryArray4[n++];
            }
            if (n2 < callStackEntryArray5.length) {
                objectArray[n4++] = callStackEntryArray5[n2++];
            }
            if (n3 >= callStackEntryArray6.length) continue;
            objectArray[n4++] = callStackEntryArray6[n3++];
        }
        TelCallStacksUtils$1 telCallStacksUtils$1 = new TelCallStacksUtils$1();
        Arrays.sort(objectArray, telCallStacksUtils$1);
        return objectArray;
    }

    public static boolean hasValidTimestamp(CallStackEntry callStackEntry) {
        return callStackEntry != null && (callStackEntry.getClYear() != 0 || callStackEntry.getClMonth() != 0 || callStackEntry.getClDay() != 0 || callStackEntry.getClHour() != 0 || callStackEntry.getClMinute() != 0 || callStackEntry.getClSecond() != 0);
    }

    public static Date getDate(CallStackEntry callStackEntry) {
        return new GregorianCalendar(callStackEntry.getClYear(), callStackEntry.getClMonth() - 1, callStackEntry.getClDay(), callStackEntry.getClHour(), callStackEntry.getClMinute(), callStackEntry.getClSecond()).getTime();
    }

    public static CallStackEntry getCallStackEntry(CallStackEntry[] callStackEntryArray, int n) {
        if (callStackEntryArray != null) {
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                CallStackEntry callStackEntry = callStackEntryArray[i2];
                if (callStackEntry == null || callStackEntry.getClEntryID() != n) continue;
                return callStackEntry;
            }
        }
        return null;
    }
}

