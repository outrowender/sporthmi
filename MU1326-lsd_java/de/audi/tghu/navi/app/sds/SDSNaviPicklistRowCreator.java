/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.search.SearchResult;

public class SDSNaviPicklistRowCreator {
    private static final int COL_TEXT;
    private static final int COL_CHILDCOUNT;
    private static final int COL_LAYOUT;
    private static final int COL_EXTRATEXT;
    private static final int COL_MAPCODE_ROADSEGMENT;
    private static final int COL_COUNT;
    private static final int LAYOUT_DEFAULT;
    private static final int LAYOUT_CHILDREN;
    private static final int LAYOUT_LASTDEST;

    public static EvoListRow createNaviPickList(SDSListEntry sDSListEntry, int n) {
        String string = sDSListEntry.getName();
        int n2 = sDSListEntry.getChildren();
        int n3 = n2 > 0 ? 1 : 0;
        String string2 = new Buffer().append('(').append(n2).append(')').toString();
        EvoListRow evoListRow = new EvoListRow(n, 5);
        evoListRow.setText(0, string);
        evoListRow.setText(1, string2);
        evoListRow.setInteger(2, n3);
        return evoListRow;
    }

    public static EvoListRow createLastDestinationPickList(SDSListEntry sDSListEntry, int n, ILastDestHandler iLastDestHandler, NavigationEnv navigationEnv) {
        long l = sDSListEntry.getId();
        SearchResult searchResult = iLastDestHandler.getLastDest(l);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(searchResult, navigationEnv);
        EvoListRow evoListRow = new EvoListRow(n, 5);
        evoListRow.setText(0, locationFormattingResponse != null ? locationFormattingResponse.getFirstLineAsText() : "");
        evoListRow.setText(3, locationFormattingResponse != null ? locationFormattingResponse.getSecondLineAsText() : "");
        evoListRow.setInteger(2, 2);
        return evoListRow;
    }

    public static EvoListRow createNaviFavoritePickList(SDSListEntry sDSListEntry, int n, INaviFavoriteHandler iNaviFavoriteHandler) {
        long l = sDSListEntry.getId();
        String string = iNaviFavoriteHandler.getFavoriteAddress(l);
        EvoListRow evoListRow = new EvoListRow(n, 5);
        evoListRow.setText(3, string);
        evoListRow.setText(0, sDSListEntry.getName());
        evoListRow.setInteger(2, 2);
        return evoListRow;
    }

    public static EvoListRow createPickListRowByIndexAndName(int n, String string) {
        EvoListRow evoListRow = new EvoListRow(n, 5);
        evoListRow.setText(0, string);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    public static EvoListRow createPickListRowByIndexAndNameForMapCode(int n, String string, int n2) {
        EvoListRow evoListRow = SDSNaviPicklistRowCreator.createPickListRowByIndexAndName(n, string);
        evoListRow.setInteger(4, n2);
        return evoListRow;
    }
}

