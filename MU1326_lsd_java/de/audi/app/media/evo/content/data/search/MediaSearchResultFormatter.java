/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search;

import de.audi.app.media.evo.content.data.search.AbstractMediaSearchResultFormatter;
import de.audi.app.media.evo.content.data.search.AlbumSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.ArtistSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.AudioBookSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.ComposerSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.GenreSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.IMediaSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.MediaSearchListRow;
import de.audi.app.media.evo.content.data.search.PhysicalSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.PlaylistSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.PodcastSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.TitleSearchResultLayouter;
import de.audi.app.media.evo.content.data.search.VideoSearchResultLayouter;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class MediaSearchResultFormatter
extends AbstractMediaSearchResultFormatter {
    private static final String LOGCLASS = "MediaSearchResultFormatter";
    private final IMediaSearchResultLayouter[] layouter = new IMediaSearchResultLayouter[11];

    public MediaSearchResultFormatter(LogChannel logChannel, int n, int n2) {
        super(logChannel, n);
        this.layouter[0] = new TitleSearchResultLayouter(logChannel);
        this.layouter[1] = new ArtistSearchResultLayouter(logChannel);
        this.layouter[2] = new AlbumSearchResultLayouter(logChannel);
        this.layouter[3] = new GenreSearchResultLayouter(logChannel);
        this.layouter[4] = new VideoSearchResultLayouter(logChannel);
        this.layouter[5] = new PlaylistSearchResultLayouter(logChannel);
        this.layouter[6] = new PhysicalSearchResultLayouter(logChannel);
        this.layouter[7] = new ComposerSearchResultLayouter(logChannel);
        this.layouter[8] = new AudioBookSearchResultLayouter(logChannel);
        this.layouter[9] = new PodcastSearchResultLayouter(logChannel);
        this.layouter[10] = new TitleSearchResultLayouter(logChannel);
        for (int i2 = 0; i2 < 11; ++i2) {
            this.layouter[i2].setLayout(n2);
        }
    }

    public void setLayout(int n) {
        this.logger.log(1000000, "[%1.setLayout]", (Object)LOGCLASS);
        for (int i2 = 0; i2 < 11; ++i2) {
            this.layouter[i2].setLayout(n);
        }
    }

    public SearchResultListRow formatResult(SearchResult searchResult) {
        this.logger.log(1000000, "[%1.formatResult] '%2'", (Object)LOGCLASS, (Object)searchResult);
        return new MediaSearchListRow(searchResult, this.layouter[this.getFormatterType()], this.getCoverArtResource(searchResult));
    }

    protected void setLayoutForFormatType(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.setLayoutForFormatType]", (Object)LOGCLASS);
        }
        this.layouter[n].setLayout(n2);
    }

    private String getCoverArtResource(SearchResult searchResult) {
        Token[] tokenArray;
        Token token;
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.getCoverArtResource]", (Object)LOGCLASS);
        }
        if (null == (token = MediaSearchResultFormatter.getTokenForType(tokenArray = searchResult.getTokens(), 22))) {
            return null;
        }
        return token.getToken();
    }
}

