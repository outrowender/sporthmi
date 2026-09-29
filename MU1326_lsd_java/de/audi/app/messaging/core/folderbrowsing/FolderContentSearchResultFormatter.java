/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.folderbrowsing.FolderContentSearchListRow;
import de.audi.app.messaging.core.folderbrowsing.IEntryPropertyFactory;
import de.audi.app.messaging.core.guide.ITextLookup;
import de.audi.app.messaging.core.util.Times;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

final class FolderContentSearchResultFormatter
extends AbstractSearchResultFormatter {
    private final AbstractMsgApplication msgApp;
    private final IEntryPropertyFactory entryPropertyFactory;
    private final ITextLookup textLookup;

    public FolderContentSearchResultFormatter(AbstractMsgApplication abstractMsgApplication, IEntryPropertyFactory iEntryPropertyFactory, ITextLookup iTextLookup) {
        this.msgApp = abstractMsgApplication;
        this.entryPropertyFactory = iEntryPropertyFactory;
        this.textLookup = iTextLookup;
    }

    @Override
    public SearchResultListRow formatResult(SearchResult searchResult) {
        return FolderContentSearchListRow.create(searchResult, this.entryPropertyFactory, this.msgApp.getEntryListRowDataFactory(), searchResult.getListPosition(), Times.getCurrentTime(this.msgApp.getFramework()), this.textLookup);
    }
}

