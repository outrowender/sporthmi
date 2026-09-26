/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.models;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.city.CityZipInputModelAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityScreenModelAccessKR
extends CityZipInputModelAccess {
    private static final int CITY_NEEDS_WARD;

    public AddressInputCityScreenModelAccessKR(NavigationEnv navigationEnv, int n, int n2, CityHistory cityHistory, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, cityHistory, iAddressInputFormModelAccessHelper);
    }

    @Override
    public void onStart(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "%1#onStart was called with NavLocation %2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        this.previewListModelApp.removeAll();
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        if (this.env.getContainer().selectionCriterionAvailable(152) && this.env.getContainer().refinementCriterionAvailable(152)) {
            this.env.getAddressInputLogChannel().log(-2137614336, "%1#onElementSelected - env.getChoiceModel(cityNeedsWard).setValue(WARD_AVAILABLE)", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-1641806336).setValue(1);
        } else {
            this.env.getAddressInputLogChannel().log(-2137614336, "%1#onElementSelected - env.getChoiceModel(cityNeedsWard).setValue(WARD_UNAVAILABLE)", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-1641806336).setValue(0);
        }
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        int n3;
        int n4;
        EvoListRow[] evoListRowArray;
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateResultList with matchCount = %1, currentInput = %2, valueList = %3").toString(), (Object)Long.toString(l), (Object)string, (Object)lIValueList);
        if (Util.isEmpty(string)) {
            this.matchSpellerModelApp.setCompletionText("");
        }
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        EvoListRow[] evoListRowArray2 = this.getMatchingHistoryEntries(string).getEntriesForList(this.logChannel, this.historyListRowBuilder);
        int n5 = 0;
        if (n2 == 0) {
            if (evoListRowArray2 != null) {
                evoListRowArray = new EvoListRow[evoListRowArray2.length + lIValueListElementArray.length];
                for (n4 = 0; n4 < evoListRowArray2.length; ++n4) {
                    evoListRowArray[n4] = evoListRowArray2[n4];
                    ++n5;
                }
            } else {
                evoListRowArray = new EvoListRow[lIValueListElementArray.length];
            }
        } else {
            evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        }
        n4 = n2 == 0 ? n5 : 0;
        for (n3 = 0; n3 < lIValueListElementArray.length; ++n3) {
            evoListRowArray[n3 + n4] = new AddressInputLIValueListElementListRow(lIValueListElementArray[n3], 160082217, new int[0]);
        }
        n3 = 0;
        n3 = evoListRowArray2 != null ? (int)l + evoListRowArray2.length : (int)l;
        this.logChannel.log(-2137614336, "%3#onUpdateResultList - updating Row-Length from %1 to %2", (Object)Integer.toString(this.previewListModelApp.getLength()), (Object)Integer.toString(n3), (Object)this.CLASS_NAME);
        this.previewListModelApp.setLength(n3);
        this.logChannel.log(-2137614336, "%3#onUpdateResultList the TiledList will be updated with requestID = %1, startingIndex = %2", (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)this.CLASS_NAME);
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        if (n3 > 0 && n3 <= 5) {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateResultList automatically select first item when the amount of result list is less than 5").toString());
            int n6 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpellerModelApp.setMatchCount((int)l, n6);
        }
    }
}

