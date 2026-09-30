/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.models;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.city.CityStreetHistoryListRowBuilder;
import de.audi.app.navi.evo.addressinput.street.StreetInputModelAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputStreetModelAccessNAR
extends StreetInputModelAccess {
    private final CityHistory cityHistory;
    private final CityStreetHistoryListRowBuilder historyListRowBuilder;
    private final SpellerStack spellerStack;

    public AddressInputStreetModelAccessNAR(NavigationEnv navigationEnv, int n, int n2, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper, CityHistory cityHistory, SpellerStack spellerStack) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.cityHistory = cityHistory;
        this.spellerStack = spellerStack;
        this.historyListRowBuilder = new CityStreetHistoryListRowBuilder();
    }

    public void onElementSelected(NavLocation navLocation) {
        super.onElementSelected(navLocation);
        this.env.getChoiceModel(400314).setValue(0);
        this.env.getChoiceModel(401801).setValue(0);
    }

    public void onAmbiguousElementSelected() {
        this.env.getChoiceModel(400314).setValue(1);
        this.env.getChoiceModel(401801).setValue(1);
    }

    protected CityHistory.HistoryForCurrentInput getMatchingHistoryEntries(String string) {
        return new CityHistory.HistoryForCurrentInput(this.cityHistory.getMatchingLastStreets(string));
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        int n3;
        EvoListRow[] evoListRowArray;
        if (!this.spellerStack.containsContextID(65)) {
            super.onUpdateResultList(lIValueList, l, string, bl, n, n2);
            return;
        }
        int n4 = Util.isEmpty(string) ? 0 : 1;
        this.matchSpellerModelApp.setMatchCount((int)l, n4);
        LIValueListElement[] lIValueListElementArray = Util.isListValid(lIValueList) ? lIValueList.getList() : new LIValueListElement[]{};
        this.matchSpellerModelApp.setCompletionText("");
        int n5 = 0;
        if (n2 == 0) {
            EvoListRow[] evoListRowArray2 = this.getMatchingHistoryEntries(string).getEntriesForList(this.logChannel, this.historyListRowBuilder);
            if (evoListRowArray2 != null) {
                evoListRowArray = new EvoListRow[evoListRowArray2.length + lIValueListElementArray.length];
                for (n3 = 0; n3 < evoListRowArray2.length; ++n3) {
                    evoListRowArray[n3] = evoListRowArray2[n3];
                    ++n5;
                }
            } else {
                evoListRowArray = new EvoListRow[lIValueListElementArray.length];
            }
        } else {
            evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        }
        int n6 = n2 == 0 ? n5 : 0;
        for (n3 = 0; n3 < lIValueListElementArray.length; ++n3) {
            evoListRowArray[n3 + n6] = new AddressInputLIValueListElementListRow(lIValueListElementArray[n3], 698976777);
        }
        this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateResultList - updating Row-Length from %1 to %2", (long)this.previewListModelApp.getLength(), (long)((int)l + n5));
        this.previewListModelApp.setLength((int)l + n5);
        this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateResultList the TiledList will be updated with requestID = %1, startingIndex = %2", (long)n, (long)n2);
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
    }
}

