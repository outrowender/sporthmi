/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.city;

import de.audi.app.navi.evo.addressinput.AbstractEvoMatchspellerModelAccess;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.addressinput.city.CityStreetHistoryListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.CityHistory$HistoryForCurrentInput;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class CityZipInputModelAccess
extends AbstractEvoMatchspellerModelAccess {
    protected final CityHistory cityHistory;
    protected final LogChannel logChannel;
    protected final CityStreetHistoryListRowBuilder historyListRowBuilder;

    public CityZipInputModelAccess(NavigationEnv navigationEnv, int n, int n2, CityHistory cityHistory, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.cityHistory = cityHistory;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.historyListRowBuilder = new CityStreetHistoryListRowBuilder();
    }

    protected CityHistory$HistoryForCurrentInput getMatchingHistoryEntries(String string) {
        return new CityHistory$HistoryForCurrentInput(this.cityHistory.getMatchingLastCities(string));
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        int n3;
        EvoListRow[] evoListRowArray;
        int n4 = Util.isEmpty(string) ? 0 : 1;
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
            evoListRowArray[n3 + n6] = new AddressInputLIValueListElementListRow(lIValueListElementArray[n3], 160082217, new int[0]);
        }
        this.logChannel.log(-2137614336, "CityZipInputModelAccess#onUpdateResultList - updating Row-Length from %1 to %2", (long)this.previewListModelApp.getLength(), (long)((int)l + n5));
        this.previewListModelApp.setLength((int)l + n5);
        this.logChannel.log(-2137614336, "CityZipInputModelAccess#onUpdateResultList the TiledList will be updated with requestID = %1, startingIndex = %2", (long)n, (long)n2);
        this.previewListModelApp.setRows(n, n2, evoListRowArray);
        this.matchSpellerModelApp.setMatchCount((int)l, n4);
    }
}

