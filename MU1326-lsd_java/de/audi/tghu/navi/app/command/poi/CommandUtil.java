/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi;

import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class CommandUtil {
    public static int getIndexForCriteria(int n, LIValueList lIValueList) {
        int n2 = -1;
        if (lIValueList != null && lIValueList.getList() != null) {
            LIValueListElement[] lIValueListElementArray = lIValueList.getList();
            for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                if (lIValueListElementArray[i2].criteriaNumber != n) continue;
                n2 = i2;
                break;
            }
        }
        return n2;
    }
}

