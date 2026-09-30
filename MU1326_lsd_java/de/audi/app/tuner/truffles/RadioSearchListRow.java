/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.search.util.TextLineList;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.ifc.ISimpleTuner;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class RadioSearchListRow
extends SearchResultListRow {
    static final int MAX_COLUMNS = 7;
    private static final int LLD_TWO_COLS_EU = 0;
    private static final int LLD_TWO_COLS_ASIA = 1;
    private static final int LLD_TWO_COLS_NAR = 2;
    private static final int LLD_THREE_COLS = 3;
    private static final int INDEX_RS = 0;
    private static final int INDEX_FAVORITE = 1;
    private static final int INDEX_COLUMN1 = 2;
    private static final int INDEX_BAND = 3;
    private static final int INDEX_COLUMN2 = 4;
    private static final int INDEX_IMAGE = 5;
    private static final int INDEX_COLUMN3 = 6;
    private static final TokenComparator TOKEN_COMPARATOR = new TokenComparator();

    RadioSearchListRow(SearchResult searchResult) {
        super(searchResult, 7, searchResult.dataId);
        int n = 0;
        if (RadioObjectIds.isFavorite(searchResult.dataId)) {
            n = Utilities.isNARBuild() ? (int)(searchResult.dataId >> 8 & 0xFFFFFFFFFFFFFFFFL) : 51;
        }
        this.setInteger(1, n);
        long l = searchResult.getDataId();
        Object[] objectArray = searchResult.getTokens() != null ? searchResult.getTokens() : new Token[]{};
        Arrays.sort(objectArray, TOKEN_COMPARATOR);
        if (Utilities.isSinglePiMode()) {
            this.setInteger(0, 0);
            this.setHighlightTextCell(2, RadioSearchListRow.formatLine((Token[])objectArray, new int[]{22, 23}));
            this.setHighlightTextCell(4, RadioSearchListRow.formatLine((Token[])objectArray, new int[]{24}));
        } else {
            this.setHighlightTextCell(2, RadioSearchListRow.formatLine((Token[])objectArray, new int[]{24}));
            int n2 = 1;
            int[] nArray = new int[]{22, 23};
            TextListCellHighlightText textListCellHighlightText = new TextListCellHighlightText("", new int[0]);
            if (Utilities.isNARBuild()) {
                n2 = 2;
                int n3 = RadioObjectIds.getBandComponent(l);
                if (n3 == 7) {
                    n2 = 3;
                    nArray = new int[]{22};
                    textListCellHighlightText = RadioSearchListRow.formatLine((Token[])objectArray, new int[]{23});
                }
            }
            this.setHighlightTextCell(4, RadioSearchListRow.formatLine((Token[])objectArray, nArray));
            this.setHighlightTextCell(6, textListCellHighlightText);
            this.setInteger(0, n2);
        }
        this.setInteger(3, RadioObjectIds.getBandComponent(searchResult.dataId));
        this.setHMIResourceLocator(5, ISimpleTuner.EMPTY_RL);
    }

    public RadioSearchListRow(RadioSearchListRow radioSearchListRow) {
        super(radioSearchListRow);
    }

    public RadioSearchListRow(String string, int n, long l) {
        super(new SearchResult(0, 0, 0, 0, 0, 0, 0, null, 0, l, null, null, null, null), 7, n);
        String string2 = "";
        if (Utilities.isShowFreqUnit()) {
            switch (n) {
                case 1: {
                    string2 = " MHz";
                    break;
                }
                case 4: {
                    string2 = " kHz";
                    break;
                }
                default: {
                    string2 = "";
                }
            }
        }
        this.setInteger(0, 0);
        this.setInteger(1, 0);
        this.setHighlightTextCell(2, new TextListCellHighlightText(string + string2, new int[0]));
        this.setInteger(3, n);
        this.setHMIResourceLocator(5, ISimpleTuner.EMPTY_RL);
    }

    public EvoListRow copy() {
        return new RadioSearchListRow(this);
    }

    private static TextListCellHighlightText formatLine(Token[] tokenArray, int[] nArray) {
        Token token;
        int n;
        TextLineList textLineList = new TextLineList();
        for (n = 0; n < tokenArray.length; ++n) {
            token = tokenArray[n];
            if (!RadioSearchListRow.doesTokenWordTypeMatchAny(token, nArray) || token.highlights.length == 0) continue;
            textLineList.addToken(tokenArray[n]);
            break;
        }
        if (textLineList.size() == 0) {
            for (n = 0; n < tokenArray.length; ++n) {
                token = tokenArray[n];
                if (!RadioSearchListRow.doesTokenWordTypeMatchAny(token, nArray) || Utilities.isEmpty(tokenArray[n].token)) continue;
                textLineList.addToken(tokenArray[n]);
                break;
            }
        }
        if (textLineList.size() == 0) {
            return new TextListCellHighlightText("", new int[0]);
        }
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    private static boolean doesTokenWordTypeMatchAny(Token token, int[] nArray) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (token.wordType != nArray[i2]) continue;
            return true;
        }
        return false;
    }

    public int getBand() {
        return this.getInteger(3);
    }

    private static class TokenComparator
    implements Comparator,
    Serializable {
        private static final long serialVersionUID = -6077009587972727353L;

        private TokenComparator() {
        }

        public int compare(Object object, Object object2) {
            Token token = (Token)object;
            Token token2 = (Token)object2;
            if (token.wordType == token2.wordType) {
                return 0;
            }
            if (token.wordType == 22 || token.wordType == 23 && token2.wordType == 24) {
                return -1;
            }
            return 1;
        }
    }
}

