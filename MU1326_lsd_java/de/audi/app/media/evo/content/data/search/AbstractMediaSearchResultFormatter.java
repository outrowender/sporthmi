/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.AbstractSearchResultFormatter;

public abstract class AbstractMediaSearchResultFormatter
extends AbstractSearchResultFormatter {
    private static final String LOGCLASS;
    public static final int COUNT_FORMATTER_TYPES;
    public static final int FORMATTER_TYPE_TITLE;
    public static final int FORMATTER_TYPE_ARTIST;
    public static final int FORMATTER_TYPE_ALBUM;
    public static final int FORMATTER_TYPE_GENRE;
    public static final int FORMATTER_TYPE_VIDEO;
    public static final int FORMATTER_TYPE_PLAYLIST;
    public static final int FORMATTER_TYPE_PHYSICAL;
    public static final int FORMATTER_TYPE_COMPOSERS;
    public static final int FORMATTER_TYPE_AUDIOBOOKS;
    public static final int FORMATTER_TYPE_PODCASTS;
    public static final int FORMATTER_TYPE_FAVORITES;
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
        this.logger.log(1078071040, "[%1.setFormatterType] %2", (Object)"AbstractMediaSearchResultFormatter", (long)n);
        this.formatterType = n;
    }

    protected int getFormatterType() {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.getFormatterType] type='%2'", (Object)"AbstractMediaSearchResultFormatter", (Object)AbstractMediaSearchResultFormatter.getFormatterType(this.formatterType));
        }
        return this.formatterType;
    }

    public abstract void setLayout(int n) {
    }

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

