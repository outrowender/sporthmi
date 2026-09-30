/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.app.online.evo.search.OnlineSearchResultFormatter;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import org.dsi.ifc.search.SearchResult;

public class OnlineSearchGUIImpl
extends AbstractGuiSearchHandler {
    private LogChannel logChannel;

    public OnlineSearchGUIImpl(LogChannel logChannel, AbstractSearch abstractSearch, SpellerModelApp spellerModelApp, boolean bl) {
        int[] nArray;
        if (bl) {
            int[] nArray2 = new int[2];
            nArray2[0] = 9;
            nArray = nArray2;
            nArray2[1] = 3;
        } else {
            int[] nArray3 = new int[1];
            nArray = nArray3;
            nArray3[0] = 9;
        }
        super(nArray, null, null, null, logChannel, abstractSearch);
        this.logChannel = logChannel;
        this.registryFormatter.put(new Integer(9), new OnlineSearchResultFormatter(this.lc));
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.logChannel.log(100000, "OnlineSearchGuiImpl#searchResultSelected: called from modelID: %1 but shouldn't be called ...", (long)n2);
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        this.logChannel.log(100000, "OnlineSearchGuiImpl#childNodeSelected: called from modelID: %1 but shouldn't be called ...", (long)n2);
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.logChannel.log(100000, "OnlineSearchGuiImpl#requestChildrenNodes: called, but shouldn't be called ...");
    }

    public synchronized boolean setListRow(int n, SearchResult searchResult) {
        this.logChannel.log(100000, "OnlineSearchGuiImpl#setListRow: called from row: %1 but shouldn't be called ...", (long)n);
        return true;
    }

    public int getMaxColumns() {
        this.logChannel.log(100000, "OnlineSearchGuiImpl#getMaxColumns: called, but shouldn't be called ...");
        return 0;
    }

    public String extractSuggestionFromQueryField(String string) {
        this.logChannel.log(1000000, "OnlineSearchGuiImpl#extractSuggestionFromQueryField(%1): called, but shouldn't be called", (Object)string);
        return null;
    }
}

