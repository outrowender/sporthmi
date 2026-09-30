/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.IMediaSearchResultLayouter;
import de.audi.atip.hmi.model.TextListCellHighlightText;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.TextLineList;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public abstract class AbstractSearchResultLayouter
implements IMediaSearchResultLayouter {
    private static final String LOGCLASS = "AbstractSearchResultLayouter";
    protected static final int NO_SYMBOL = -1;
    protected static final int SYMBOL_TITLE = 0;
    protected static final int SYMBOL_ALBUM = 1;
    protected static final int SYMBOL_ARTIST = 2;
    protected static final int SYMBOL_VIDEO = 3;
    protected static final int SYMBOL_GENRE = 4;
    protected static final int SYMBOL_PLAYLIST = 5;
    protected static final int SYMBOL_FOLDER = 6;
    protected static final int SYMBOL_COMPOSER = 7;
    protected static final int SYMBOL_PODCAST = 8;
    protected static final int SYMBOL_AUDIOBOOK = 9;
    public static final int EF_MEDIA_NOT_INTERNATIONALIZED = 0;
    public static final int EF_MEDIA_UNKNOWN_TITLE = 1;
    public static final int EF_MEDIA_UNKNOWN_ARTIST = 2;
    public static final int EF_MEDIA_VARIOUS_ARTISTS = 4;
    public static final int EF_MEDIA_UNKNOWN_ALBUM = 8;
    public static final int EF_MEDIA_UNKNOWN_GENRE = 16;
    public static final int EF_MEDIA_CDDA_TRACK = 32;
    public static final int EF_MEDIA_UNKNOWN_COMPOSER = 64;
    public static final int EF_MEDIA_UNKNOWN_COMPOSERS = 128;
    public static final int I18N_NO_VALUE = 99;
    protected final LogChannel logger;
    protected volatile int layout;

    public AbstractSearchResultLayouter(LogChannel logChannel, int n) {
        this.logger = logChannel;
        this.layout = n;
    }

    public void setLayout(int n) {
        this.layout = n;
    }

    public int getRecordSet(int n) {
        int n2;
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getRecordSet]", (Object)LOGCLASS);
        }
        switch (this.layout) {
            case 1: {
                if (7 == n || 11 == n) {
                    n2 = 3;
                    break;
                }
                n2 = 0;
                break;
            }
            case 2: {
                if (7 == n || 11 == n) {
                    n2 = 5;
                    break;
                }
                n2 = 2;
                break;
            }
            default: {
                n2 = 7 == n || 11 == n ? 4 : 1;
            }
        }
        return n2;
    }

    protected boolean isLineRelevant(int n) {
        boolean bl;
        switch (this.layout) {
            case 1: {
                bl = n == 1;
                break;
            }
            case 3: {
                bl = true;
                break;
            }
            case 2: {
                bl = n == 1 || n == 2;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    protected TextListCellHighlightText getListCellForWordtype(SearchResult searchResult, int n) {
        Token[] tokenArray;
        Token token;
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getListCellForWordtype] type='%2'", (Object)LOGCLASS, (Object)AbstractSearchResultLayouter.getWordTypeString(n));
        }
        if (AbstractSearchResultFormatter.isEmpty(token = AbstractSearchResultFormatter.getTokenForType(tokenArray = searchResult.getTokens(), n))) {
            return null;
        }
        TextLineList textLineList = new TextLineList();
        textLineList.addToken(token);
        return new TextListCellHighlightText(textLineList.getText(), textLineList.getTextHighlightIndices());
    }

    public static int getI18NKey(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 45;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 30;
                break;
            }
            case 8: {
                n2 = 6;
                break;
            }
            case 16: {
                n2 = 9;
                break;
            }
            case 64: {
                n2 = 50;
                break;
            }
            case 128: {
                n2 = 51;
                break;
            }
            case 32: {
                n2 = 40;
                break;
            }
            default: {
                n2 = 99;
            }
        }
        return n2;
    }

    public static String getWordTypeString(int n) {
        String string;
        switch (n) {
            case 5: {
                string = "WORDTYPEMEDIA_NAME";
                break;
            }
            case 16: {
                string = "WORDTYPEMEDIA_ARTIST";
                break;
            }
            case 15: {
                string = "WORDTYPEMEDIA_ALBUM";
                break;
            }
            case 14: {
                string = "WORDTYPEMEDIA_GENRE";
                break;
            }
            case 22: {
                string = "WORDTYPEMEDIA_COVERFILE";
                break;
            }
            default: {
                string = "NOT A MEDIA WORDTYPE: " + n;
            }
        }
        return string;
    }
}

