/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import java.util.Arrays;
import java.util.Comparator;
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
        Comparator comparator = new Comparator(){
            private static final int NO_TIMESTAMP_AVAILABLE = 0;
            private static final int SORT_GREATER = 1;
            private static final int SORT_LESS = -1;
            private static final int SORT_EQUAL = 0;

            public int compare(Object object, Object object2) {
                CallStackEntry callStackEntry = (CallStackEntry)object;
                CallStackEntry callStackEntry2 = (CallStackEntry)object2;
                long l = this.getTimestamp(callStackEntry);
                long l2 = this.getTimestamp(callStackEntry2);
                int n = 0;
                n = l == l2 ? 0 : (l2 == 0L ? -1 : (l == 0L ? 1 : (l > l2 ? -1 : 1)));
                return n;
            }

            private long getTimestamp(CallStackEntry callStackEntry) {
                if (!TelCallStacksUtils.hasValidTimestamp(callStackEntry)) {
                    return 0L;
                }
                return TelCallStacksUtils.getDate(callStackEntry).getTime();
            }
        };
        Arrays.sort(objectArray, comparator);
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

