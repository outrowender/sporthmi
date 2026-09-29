/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.ITelSearchRequestSuggestionListener;
import org.dsi.ifc.search.SearchResult;

public interface ITelSearchQueryListener
extends ITelSearchRequestSuggestionListener {
    default public void searchStarted(int n) {
    }

    default public void searchEnded(int n) {
    }

    default public void searchCanceled(int n) {
    }

    default public void updateSearchResult(int n, SearchResult searchResult) {
    }

    default public void dataInvalidated(int n, int[] nArray) {
    }
}

