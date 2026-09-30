/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import org.dsi.ifc.search.Suggestion;
import org.dsi.ifc.search.Token;

public interface ISearchListener {
    public void triggerApplySearchFilter(int var1, Token[] var2);

    public void handleSuggestion(Suggestion var1, String var2);
}

