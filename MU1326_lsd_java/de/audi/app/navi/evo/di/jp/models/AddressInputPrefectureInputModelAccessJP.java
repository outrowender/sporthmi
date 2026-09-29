/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.models;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.city.CityStreetHistoryListRowBuilder;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.models.AddressInputModelAccessJP;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.CityHistory$HistoryForCurrentInput;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputPrefectureInputModelAccessJP
extends AddressInputModelAccessJP {
    private final CityHistory cityHistory;
    private final CityStreetHistoryListRowBuilder historyListRowBuilder;
    private final int nationWideButtonModelId = DIScreensEvo.getDiJpPrefectureScreenNationWideButtonModel();
    private final ButtonModelApp buttonModel;

    public AddressInputPrefectureInputModelAccessJP(NavigationEnv navigationEnv, int n, int n2, CityHistory cityHistory, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.cityHistory = cityHistory;
        this.historyListRowBuilder = new CityStreetHistoryListRowBuilder();
        this.buttonModel = navigationEnv.getButtonModel(this.nationWideButtonModelId);
    }

    @Override
    public void onStart(NavLocation navLocation) {
        super.onStart(navLocation);
        if (AddressInputUtilEvo.isInPOIRelatedContext(this.env)) {
            this.buttonModel.setStatus(0);
        } else {
            this.buttonModel.setStatus(1);
        }
    }

    private CityHistory$HistoryForCurrentInput getMatchingHistoryEntries(String string) {
        return new CityHistory$HistoryForCurrentInput(this.cityHistory.getMatchingLastStates(string));
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        super.onUpdateSpeller(string, string2, bl, bl2);
        if (!Util.isEmpty(string2) || AddressInputUtilEvo.isInPOIRelatedContext(this.env)) {
            this.logChannel.log(-2137614336, "#onUpdateSpeller set nation wide button to invisible", (Object)this.CLASS_NAME);
            this.buttonModel.setStatus(0);
        } else {
            this.logChannel.log(-2137614336, "#onUpdateSpeller set nation wide button to visible", (Object)this.CLASS_NAME);
            this.buttonModel.setStatus(1);
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
        this.logChannel.log(-2137614336, "AddressInputPrefectureInputModelAccessJP#onUpdateResultList - updating Row-Length from %1 to %2", (long)this.previewListModelApp.getLength(), (long)n3);
        this.previewListModelApp.setLength(n3);
        this.logChannel.log(-2137614336, "AddressInputPrefectureInputModelAccessJP#onUpdateResultList the TiledList will be updated with requestID = %1, startingIndex = %2", (long)n, (long)n2);
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        if (n3 > 0 && n3 <= 5) {
            this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateResultList automatically select first item when the amount of result list is less than 5").toString());
            int n6 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpellerModelApp.setMatchCount((int)l, n6);
        }
    }
}

