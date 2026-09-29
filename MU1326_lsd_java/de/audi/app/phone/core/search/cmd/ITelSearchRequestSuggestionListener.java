/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import org.dsi.ifc.search.Suggestion;

public interface ITelSearchRequestSuggestionListener {
    default public void updateSuggestion(Suggestion[] suggestionArray) {
    }
}

