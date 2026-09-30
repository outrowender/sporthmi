/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.MediaSearchResultFormatter;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class MediaGlobalSearchResultFormatter
extends MediaSearchResultFormatter {
    private static final String LOGCLASS = "MediaGlobalSearchResultFormatter";

    public MediaGlobalSearchResultFormatter(LogChannel logChannel) {
        super(logChannel, 0, 1);
        this.setLayoutForFormatType(0, 3);
        this.setLayoutForFormatType(1, 1);
        this.setLayoutForFormatType(2, 2);
        this.setLayoutForFormatType(3, 1);
        this.setLayoutForFormatType(5, 1);
        this.setLayoutForFormatType(4, 1);
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.formatResult]", (Object)LOGCLASS);
        }
        switch (searchResult.getEntryType()) {
            case 5: {
                this.setFormatterType(1);
                break;
            }
            case 6: {
                this.setFormatterType(2);
                break;
            }
            case 7: {
                this.setFormatterType(0);
                break;
            }
            case 11: {
                this.setFormatterType(4);
                break;
            }
            case 9: {
                this.setFormatterType(3);
                break;
            }
            case 10: {
                this.setFormatterType(5);
                break;
            }
        }
        return super.formatResult(searchResult);
    }

    public void setLayout(int n) {
    }
}

