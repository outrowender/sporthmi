/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.TextLineList;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class IntellicallFavoriteSearchResultRow
extends AbstractIntellicallSearchResultRow {
    private final int phoneNumberType;

    public IntellicallFavoriteSearchResultRow(SearchResult searchResult, LogChannel logChannel) {
        super(searchResult, logChannel);
        this.phoneNumberType = this.getPhoneNumberTypeFromToken(searchResult);
        this.setRecordSetColumn(4);
        this.setHighlightTextCell(3, this.getNameCell(searchResult));
        this.setHighlightTextCell(4, this.getNumberCell(searchResult));
        this.setInteger(8, ADBModelUtils.getIconTypeForPhoneNumber(this.phoneNumberType));
        this.setPropertyCell(7, PropertyListCell.create(-1635178174, new int[]{1052831299, -2040561860}));
    }

    private int getPhoneNumberTypeFromToken(SearchResult searchResult) {
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 22);
        return Integer.parseInt(token.getToken());
    }

    public int getPhoneNumberType() {
        return this.phoneNumberType;
    }

    private TextListCellHighlightText getNumberCell(SearchResult searchResult) {
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 11);
        TextLineList textLineList = new TextLineList();
        textLineList.addToken(token);
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    private TextListCellHighlightText getNameCell(SearchResult searchResult) {
        TextLineList textLineList = new TextLineList();
        if (searchResult == null) {
            this.log.log(10000, "[TextListCellHighlightText#getNameCell] searchResult is null.");
            return new TextListCellHighlightText(null, null);
        }
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResult.getTokens(), 5);
        textLineList.addToken(token);
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    @Override
    public EvoListRow copy() {
        return new IntellicallFavoriteSearchResultRow(this.getSearchResult(), this.log);
    }
}

