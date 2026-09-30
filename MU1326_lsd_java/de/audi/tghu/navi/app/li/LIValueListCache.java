/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class LIValueListCache {
    private static final int PATCH_MAX_SIZE = 50;
    private LogChannel logChannel;
    private LIValueList cachedList;

    public LIValueListCache(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public LIValueList getCachedList() {
        return this.cachedList;
    }

    private void dumpList(LIValueList lIValueList) {
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            this.logChannel.log(10000000, "LIValueListCache#dumpList() - index: %2, entry: %1", (Object)lIValueListElementArray[i2].getData(), (long)lIValueListElementArray[i2].getListIndex());
        }
    }

    public void updateCache(LIValueList lIValueList, boolean bl) {
        if (!Util.isListValid(lIValueList)) {
            this.cachedList = null;
            return;
        }
        if (!Util.isListValid(this.cachedList)) {
            this.cachedList = lIValueList;
            return;
        }
        this.dumpList(this.cachedList);
        this.dumpList(lIValueList);
        int n = this.cachedList.getList().length;
        int n2 = lIValueList.getList().length;
        LIValueListElement[] lIValueListElementArray = null;
        if (bl) {
            int n3;
            int n4 = lIValueList.getList()[0].getListIndex();
            int n5 = Util.getLIValueListElement(this.logChannel, this.cachedList, n4);
            if (n5 < 0) {
                n5 = n;
            }
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - downwards, found anchor in list at %1", (long)n5);
            int n6 = Math.max(0, n2 + n5 - 50);
            int n7 = Math.min(50, n2 + n5);
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - list sizes %1 / %2", (long)n, (long)n2);
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - old list segment [%1 / %2), complete new length %3", (long)n6, (long)n5, (long)n7);
            lIValueListElementArray = new LIValueListElement[n7];
            int n8 = 0;
            for (n3 = n6; n3 < n5; ++n3) {
                lIValueListElementArray[n8++] = this.cachedList.getList()[n3];
            }
            for (n3 = 0; n3 < n2; ++n3) {
                lIValueListElementArray[n8++] = lIValueList.getList()[n3];
            }
        } else {
            int n9;
            int n10 = lIValueList.getList()[n2 - 1].getListIndex();
            int n11 = Util.getLIValueListElement(this.logChannel, this.cachedList, n10) + 1;
            if (n11 < 0) {
                n11 = 0;
            }
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - upwards, found anchor in list at %1", (long)n11);
            int n12 = 50 + n11 - n2;
            int n13 = Math.min(50, n2 + n - n11);
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - list sizes %1 / %2", (long)n, (long)n2);
            this.logChannel.log(10000000, "LIValueListCache#updateListPatch() - old list segment [%1 / %2), complete new length %3", (long)n11, (long)n12, (long)n13);
            lIValueListElementArray = new LIValueListElement[n13];
            int n14 = 0;
            for (n9 = 0; n9 < n2; ++n9) {
                lIValueListElementArray[n14++] = lIValueList.getList()[n9];
            }
            for (n9 = n11; n9 < n12; ++n9) {
                lIValueListElementArray[n14++] = this.cachedList.getList()[n9];
            }
        }
        this.cachedList = new LIValueList(lIValueListElementArray, false, false);
        this.dumpList(this.cachedList);
    }
}

