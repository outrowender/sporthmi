/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite.search;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.search.AbstractTelSearchResultRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class TelFavoriteSearchResultRow
extends AbstractTelSearchResultRow {
    static final int MAX_COLUMNS = 4;
    private static final int COL_NAME = 0;
    private static final int COL_NUMBER = 1;
    private static final int COL_PROPERTIES = 2;
    private static final int COL_PHONE_NUMBER_TYPE = 3;
    private final int phoneNumberType;

    public TelFavoriteSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, 4, searchResult.getListPosition(), logChannel);
        this.phoneNumberType = this.getPhoneNumberType(searchResult);
        this.setHighlightTextCell(0, this.getHighlightedNameCell());
        this.setHighlightTextCell(1, this.getHighlightedNumberCell());
        this.setInteger(3, ADBModelUtils.getIconTypeForPhoneNumber(this.phoneNumberType));
        this.setPropertyCell(2, PropertyListCell.create(1110018462, new int[]{1139720254, 1014980486}));
    }

    private int getPhoneNumberType(SearchResult searchResult) {
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 22);
        return Integer.parseInt(token.getToken());
    }

    public int getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public long getDataID() {
        return this.getSearchResult().getDataId();
    }

    public EvoListRow copy() {
        return new TelFavoriteSearchResultRow(this.getSearchResult(), this.log);
    }

    public void updateName(String string) {
        this.updateSearchResultToken(5, string);
    }

    private void updateSearchResultToken(int n, String string) {
        Token[] tokenArray = this.getSearchResult().getTokens();
        for (int i2 = 0; i2 < tokenArray.length; ++i2) {
            if (tokenArray[i2].wordType != n) continue;
            tokenArray[i2].token = string;
            break;
        }
    }
}

