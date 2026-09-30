/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.atip.search.AbstractGuiSearchHandler;

public interface IRadioSearch {
    public void init();

    public void setActiveGuiSearchHandler(AbstractGuiSearchHandler var1);

    public void setActiveGuiSearchHandler(ISearchGUI var1);

    public void cancelQuerry();

    public void setIgnoreSearchIsActive(boolean var1);
}

