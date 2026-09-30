/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.tv.app.truffles.ISearchGUI;

public interface ITVSearch {
    public void init();

    public void deinit();

    public void setActiveGuiSearchHandler(AbstractGuiSearchHandler var1);

    public void setActiveGuiSearchHandler(ISearchGUI var1);

    public void cancelQuerry();

    public void setIgnoreSearchIsActive(boolean var1);
}

