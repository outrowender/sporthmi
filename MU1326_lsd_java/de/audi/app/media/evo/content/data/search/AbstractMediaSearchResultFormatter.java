/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;

public abstract class AbstractMediaSearchResultFormatter
extends AbstractSearchResultFormatter {
    private static final String LOGCLASS = "AbstractMediaSearchResultFormatter";
    public static final int COUNT_FORMATTER_TYPES = 11;
    public static final int FORMATTER_TYPE_TITLE = 0;
    public static final int FORMATTER_TYPE_ARTIST = 1;
    public static final int FORMATTER_TYPE_ALBUM = 2;
    public static final int FORMATTER_TYPE_GENRE = 3;
    public static final int FORMATTER_TYPE_VIDEO = 4;
    public static final int FORMATTER_TYPE_PLAYLIST = 5;
    public static final int FORMATTER_TYPE_PHYSICAL = 6;
    public static final int FORMATTER_TYPE_COMPOSERS = 7;
    public static final int FORMATTER_TYPE_AUDIOBOOKS = 8;
    public static final int FORMATTER_TYPE_PODCASTS = 9;
    public static final int FORMATTER_TYPE_FAVORITES = 10;
    protected final LogChannel logger;
    private volatile int formatterType;

    public AbstractMediaSearchResultFormatter(LogChannel logChannel, int n) {
        this.logger = logChannel;
        this.formatterType = n;
    }

    protected void setFormatterType(int n) {
        if (n == this.formatterType) {
            return;
        }
        this.logger.log(1000000, "[%1.setFormatterType] %2", (Object)LOGCLASS, (long)n);
        this.formatterType = n;
    }

    protected int getFormatterType() {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getFormatterType] type='%2'", (Object)LOGCLASS, (Object)AbstractMediaSearchResultFormatter.getFormatterType(this.formatterType));
        }
        return this.formatterType;
    }

    public abstract void setLayout(int var1);

    private static String getFormatterType(int n) {
        switch (n) {
            case 0: {
                return "FORMATTER_TYPE_TITLE";
            }
            case 1: {
                return "FORMATTER_TYPE_ARTIST";
            }
            case 2: {
                return "FORMATTER_TYPE_ALBUM";
            }
            case 3: {
                return "FORMATTER_TYPE_GENRE";
            }
            case 4: {
                return "FORMATTER_TYPE_VIDEO";
            }
            case 5: {
                return "FORMATTER_TYPE_PLAYLIST";
            }
            case 6: {
                return "FORMATTER_TYPE_PHYSICAL";
            }
            case 7: {
                return "FORMATTER_TYPE_COMPOSERS";
            }
            case 8: {
                return "FORMATTER_TYPE_AUDIOBOOKS";
            }
            case 9: {
                return "FORMATTER_TYPE_PODCASTS";
            }
            case 10: {
                return "FORMATTER_TYPE_FAVORITES";
            }
        }
        return "FORMATTER_TYPE_UNKNOWN";
    }
}

