/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.truffles;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.TextLineList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class ADBTruffleSearchUtils {
    public static long getEntryId(SearchResult searchResult) {
        return searchResult == null ? 0L : searchResult.getDataId();
    }

    public static String getCombinedName(SearchResult searchResult) {
        return ADBTruffleSearchUtils.getCombinedNameListCell(searchResult).getText();
    }

    public static TextListCellHighlightText getCombinedNameListCell(SearchResult searchResult) {
        Token[] tokenArray = searchResult.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 5);
        TextLineList textLineList = new TextLineList();
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            textLineList.addToken(token);
        }
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    public static ResourceLocator getContactPicture(SearchResult searchResult) {
        Token[] tokenArray = searchResult.getTokens();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 14);
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            return new ResourceLocator(token.getToken());
        }
        return new ResourceLocator();
    }

    public static int getPhoneCount(SearchResult searchResult) {
        return searchResult.getEntryFlags() & 7;
    }

    public static boolean hasEmail(SearchResult searchResult) {
        return (searchResult.getEntryFlags() & 8) > 0;
    }

    public static boolean isProbablyNavigable(SearchResult searchResult) {
        return (searchResult.getEntryFlags() & 0x30) > 0;
    }

    public static boolean hasBusinessNavDest(SearchResult searchResult) {
        return (searchResult.getEntryFlags() & 0x40) > 0;
    }

    public static boolean hasPrivateNavDest(SearchResult searchResult) {
        return (searchResult.getEntryFlags() & 0x80) > 0;
    }

    public static int getEntryTypeModelValue(SearchResult searchResult) {
        return ADBModelUtils.getEntryTypeModelValue(ADBTruffleSearchUtils.getDsiEntryType(searchResult));
    }

    public static int getDsiEntryType(SearchResult searchResult) {
        switch (searchResult.getEntryType()) {
            case 256: {
                return 0;
            }
            case 257: {
                return 1;
            }
            case 258: {
                return 2;
            }
            case 259: {
                return 3;
            }
            case 260: {
                return 4;
            }
        }
        return 1;
    }

    public static boolean hasRelevantData(SearchResult searchResult, int n) {
        switch (n) {
            case 0: {
                return ADBTruffleSearchUtils.getPhoneCount(searchResult) > 0;
            }
            case 1: {
                return ADBTruffleSearchUtils.isProbablyNavigable(searchResult) || ADBTruffleSearchUtils.hasBusinessNavDest(searchResult) || ADBTruffleSearchUtils.hasPrivateNavDest(searchResult);
            }
            case 2: {
                return ADBTruffleSearchUtils.hasEmail(searchResult);
            }
        }
        return false;
    }
}

