/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.navi.evo.search.NaviAdbEntryListRow;
import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.util.NaviCellPropsContainer;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.metrics.GeoMetric;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class SearchResultFormatterADB
extends AbstractSearchResultFormatter {
    private final ADBInterAppService interAppService;
    private NavigationEnv env;
    private int[] adbType = new int[]{0, 1, 2, 3, 4, 5};
    private static final String[] EMPTY_FORMATTED_LOCATION_STRINGS = new String[]{"", ""};

    public SearchResultFormatterADB(ADBInterAppService aDBInterAppService, NavigationEnv navigationEnv) {
        this.interAppService = aDBInterAppService;
        this.env = navigationEnv;
    }

    @Override
    public SearchResultListRow formatResult(SearchResult searchResult) {
        NaviSearchResultListRow naviSearchResultListRow = new NaviSearchResultListRow(searchResult);
        naviSearchResultListRow.setNodeType(1);
        TextLineList textLineList = new TextLineList(5);
        Token token = SearchResultFormatterADB.getTokenForType(searchResult.tokens, 5);
        textLineList.addToken(token);
        TextListCellHighlightText textListCellHighlightText = new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
        naviSearchResultListRow.setLayout(3);
        naviSearchResultListRow.setTextLine1Column(textListCellHighlightText);
        this.setPropertyCell(naviSearchResultListRow);
        return naviSearchResultListRow;
    }

    protected void setPropertyCell(NaviSearchResultListRow naviSearchResultListRow) {
        NaviCellPropsContainer naviCellPropsContainer = new NaviCellPropsContainer();
        naviCellPropsContainer.setCategory(-598085509);
        naviSearchResultListRow.setPropertiesColumn(new PropertyListCell(naviCellPropsContainer.getCategory(), naviCellPropsContainer.getProperties()));
    }

    public NaviAdbEntryListRow[] formatADBEntry(AdbEntry adbEntry) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.adbType.length; ++i2) {
            int n = this.adbType[i2] == 0 || this.adbType[i2] == 2 || this.adbType[i2] == 4 ? 0 : 1;
            String string = this.getAddressDisplayText(adbEntry.addressData[n], this.adbType[i2]);
            if (string == null) continue;
            NaviAdbEntryListRow naviAdbEntryListRow = new NaviAdbEntryListRow(adbEntry, string, this.adbType[i2], this.createPropertyListCell(this.adbType[i2]));
            arrayList.add(naviAdbEntryListRow);
        }
        Object[] objectArray = arrayList.toArray();
        NaviAdbEntryListRow[] naviAdbEntryListRowArray = new NaviAdbEntryListRow[objectArray.length];
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            naviAdbEntryListRowArray[i3] = (NaviAdbEntryListRow)objectArray[i3];
        }
        return naviAdbEntryListRowArray;
    }

    protected PropertyListCell createPropertyListCell(int n) {
        if (n == 0 || n == 1) {
            return new PropertyListCell(1925581802, new int[0]);
        }
        if (n == 2 || n == 3) {
            return new PropertyListCell(160082217, new int[0]);
        }
        if (n == 4 || n == 5) {
            return new PropertyListCell(-33240568, new int[0]);
        }
        return null;
    }

    private String getAddressDisplayText(AddressData addressData, int n) {
        String string = "";
        if (n == 0 || n == 1) {
            if (!ADBAddressUtils.hasValidPostalAddress(addressData)) {
                return null;
            }
            int n2 = this.env.getFramework().getSysConst(442);
            string = new StringBuffer().append(ADBAddressUtils.getFirstDisplayLineOfPostalAddress(addressData, n2)).append(" ").append(ADBAddressUtils.getSecondDisplayLineOfPostalAddress(addressData, n2)).toString();
        } else if (n == 2 || n == 3) {
            string = this.getLocationNameSingleLine(addressData.navLocation);
            if (Util.isEmpty(string)) {
                return null;
            }
        } else if (n == 4 || n == 5) {
            String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(addressData.geoPosition);
            if (stringArray == null || stringArray.length != 2) {
                return null;
            }
            int n3 = Util.degreeStringToWgs84(stringArray[1]);
            int n4 = Util.degreeStringToWgs84(stringArray[0]);
            GeoMetric geoMetric = new GeoMetric(n4, n3);
            string = new StringBuffer().append(geoMetric.formatLatitude()).append(", ").append(geoMetric.formatLongitude()).toString();
        } else {
            return null;
        }
        return string;
    }

    private String[] getLocationName(byte[] byArray) {
        if (ADBAddressUtils.isEmptyLocation(byArray)) {
            return EMPTY_FORMATTED_LOCATION_STRINGS;
        }
        if (this.interAppService == null) {
            return EMPTY_FORMATTED_LOCATION_STRINGS;
        }
        return this.interAppService.getLocationName(byArray);
    }

    private String getLocationNameSingleLine(byte[] byArray) {
        if (ADBAddressUtils.isEmptyLocation(byArray)) {
            return EMPTY_FORMATTED_LOCATION_STRINGS[0];
        }
        if (this.interAppService == null) {
            return EMPTY_FORMATTED_LOCATION_STRINGS[0];
        }
        return this.interAppService.getLocationNameSingleLine(byArray);
    }
}

