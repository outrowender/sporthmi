/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.common.search;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBUtils;
import de.audi.app.addressbook.core.common.search.truffles.ADBTruffleSearchUtils;
import java.util.ArrayList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.search.SearchResult;

public class ADBFocusPropertiesHelper {
    public static int[] getFocusProperties(DataSet dataSet) {
        if (dataSet != null) {
            boolean bl = dataSet.getPhoneCount() > 0;
            boolean bl2 = (dataSet.getNavigable() & 1) == 1;
            boolean bl3 = (dataSet.getNavigable() & 2) == 2;
            boolean bl4 = dataSet.getProbNavigable() > 0 || bl2 || bl3;
            boolean bl5 = dataSet.getEmailCount() > 0;
            return ADBFocusPropertiesHelper.getFocusProperties(bl4, bl, bl5, bl2, bl3);
        }
        return ADBFocusPropertiesHelper.getFocusProperties(false, false, false, false, false);
    }

    public static int[] getFocusProperties(SearchResult searchResult) {
        if (searchResult != null) {
            boolean bl = ADBTruffleSearchUtils.getPhoneCount(searchResult) > 0;
            boolean bl2 = ADBTruffleSearchUtils.hasBusinessNavDest(searchResult);
            boolean bl3 = ADBTruffleSearchUtils.hasPrivateNavDest(searchResult);
            boolean bl4 = ADBTruffleSearchUtils.isProbablyNavigable(searchResult) || bl2 || bl3;
            boolean bl5 = ADBTruffleSearchUtils.hasEmail(searchResult);
            return ADBFocusPropertiesHelper.getFocusProperties(bl4, bl, bl5, bl2, bl3);
        }
        return ADBFocusPropertiesHelper.getFocusProperties(false, false, false, false, false);
    }

    public static int[] getFocusProperties(AdbEntry adbEntry) {
        if (adbEntry != null) {
            boolean bl = ADBUtils.countPhoneNumbers(adbEntry) > 0;
            boolean bl2 = !ADBAddressUtils.isEmptyLocation(adbEntry.addressData[0].navLocation);
            boolean bl3 = !ADBAddressUtils.isEmptyLocation(adbEntry.addressData[1].navLocation);
            boolean bl4 = ADBAddressUtils.hasAddress(adbEntry);
            boolean bl5 = ADBUtils.countEmailAddresses(adbEntry) > 0;
            return ADBFocusPropertiesHelper.getFocusProperties(bl4, bl, bl5, bl2, bl3);
        }
        return ADBFocusPropertiesHelper.getFocusProperties(false, false, false, false, false);
    }

    private static int[] getFocusProperties(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ArrayList arrayList = new ArrayList();
        if (bl) {
            arrayList.add(new Integer(-1661899299));
        }
        if (bl2) {
            arrayList.add(new Integer(343280564));
        }
        if (bl3) {
            arrayList.add(new Integer(-2127465198));
        }
        if (bl4) {
            arrayList.add(new Integer(-938763321));
            arrayList.add(new Integer(-450441313));
        }
        if (bl5) {
            arrayList.add(new Integer(899238176));
            arrayList.add(new Integer(1256532290));
        }
        int[] nArray = new int[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            nArray[i2] = (Integer)arrayList.get(i2);
        }
        return nArray;
    }
}

