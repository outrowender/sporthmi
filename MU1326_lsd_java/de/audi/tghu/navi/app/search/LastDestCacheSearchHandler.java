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
        this.lc.log(1000000, "LastDestGuiSearchHandler#activate() [%1]", (Object)this.getClass().getName());
        this.performQuery("");
    }

    public void searchEnded() {
        super.searchEnded();
        this.lc.log(1000000, "%1#searchEnded()", (Object)this.getClass().getName());
        ((LastDestSearch)this.appSearch).onSearchEnded();
        this.dispatcher.execute(new Runnable(){

            public void run() {
                ((LastDestSearch)LastDestCacheSearchHandler.this.appSearch).notifyObservers();
            }
        });
    }

    protected void performQuery(String string) {
        this.lc.log(1000000, "%1#performQuery()", (Object)this.getClass().getName());
        ((LastDestSearch)this.appSearch).clearCache();
        super.performQuery(string);
    }

    public void refreshQuery() {
        this.performQuery("");
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    public void release() {
        super.release();
        this.registryFormatter.clear();
    }
}

