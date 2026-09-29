/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.navlocationextractor;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationExctractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SyncNavLocationExtractorAdapter;

public class SearchResultNavLocationExtractor
extends SyncNavLocationExtractorAdapter
implements NavLocationExctractor {
    public SearchResultNavLocationExtractor(ICommandListFactory iCommandListFactory, NaviFavoriteHandler naviFavoriteHandler) {
        super(new SearchResultAsyncNavLocationExtractor(iCommandListFactory, naviFavoriteHandler));
    }

    public SearchResultNavLocationExtractor(SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor) {
        super(searchResultAsyncNavLocationExtractor);
    }
}

