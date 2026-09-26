/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.navi.app.search.LastDestCacheSearchHandler$1;
import de.audi.tghu.navi.app.search.LastDestSearch;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class LastDestCacheSearchHandler
extends AbstractGuiSearchHandler {
    private final DispatcherBase dispatcher;

    public LastDestCacheSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, DispatcherBase dispatcherBase, AbstractSearchResultFormatter abstractSearchResultFormatter) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch);
        this.dispatcher = dispatcherBase;
        this.registryFormatter.put(new Integer(4), abstractSearchResultFormatter);
    }

    public void activate() {
        this.lc.log(1078071040, "LastDestGuiSearchHandler#activate() [%1]", (Object)super.getClass().getName());
        this.performQuery("");
    }

    @Override
    public void searchEnded() {
        super.searchEnded();
        this.lc.log(1078071040, "%1#searchEnded()", (Object)super.getClass().getName());
        ((LastDestSearch)this.appSearch).onSearchEnded();
        this.dispatcher.execute(new LastDestCacheSearchHandler$1(this));
    }

    @Override
    protected void performQuery(String string) {
        this.lc.log(1078071040, "%1#performQuery()", (Object)super.getClass().getName());
        ((LastDestSearch)this.appSearch).clearCache();
        super.performQuery(string);
    }

    @Override
    public void refreshQuery() {
        this.performQuery("");
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    @Override
    public void release() {
        super.release();
        this.registryFormatter.clear();
    }

    static /* synthetic */ AbstractSearch access$000(LastDestCacheSearchHandler lastDestCacheSearchHandler) {
        return lastDestCacheSearchHandler.appSearch;
    }
}

