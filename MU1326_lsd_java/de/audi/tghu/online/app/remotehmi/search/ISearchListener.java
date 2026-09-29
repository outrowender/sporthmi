/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public interface ISearchListener {
    default public void triggerApplySearchFilter(int n, Token[] tokenArray) {
    }

    default public void handleSuggestion(Suggestion suggestion, String string) {
    }
}

