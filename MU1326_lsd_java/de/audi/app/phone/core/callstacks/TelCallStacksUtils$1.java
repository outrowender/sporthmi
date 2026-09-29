/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import java.util.Comparator;
import org.dsi.ifc.telephoneng.CallStackEntry;

final class TelCallStacksUtils$1
implements Comparator {
    private static final int NO_TIMESTAMP_AVAILABLE;
    private static final int SORT_GREATER;
    private static final int SORT_LESS;
    private static final int SORT_EQUAL;

    TelCallStacksUtils$1() {
    }

    @Override
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
}

