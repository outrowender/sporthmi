/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.ITelSearchRequestSuggestionListener;
import org.dsi.ifc.search.SearchResult;

public interface ITelSearchQueryListener
extends ITelSearchRequestSuggestionListener {
    public void searchStarted(int var1);

    public void searchEnded(int var1);

    public void searchCanceled(int var1);

    public void updateSearchResult(int var1, SearchResult var2);

    public void dataInvalidated(int var1, int[] var2);
}

