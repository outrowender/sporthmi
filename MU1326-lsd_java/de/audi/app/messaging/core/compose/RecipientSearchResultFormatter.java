/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.RecipientSearchListRow;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

final class RecipientSearchResultFormatter
extends AbstractSearchResultFormatter {
    RecipientSearchResultFormatter() {
    }

    @Override
    public SearchResultListRow formatResult(SearchResult searchResult) {
        return new RecipientSearchListRow(searchResult);
    }
}

