/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.tv.app.truffles.ISearchGUI;

public interface ITVSearch {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void setActiveGuiSearchHandler(AbstractGuiSearchHandler abstractGuiSearchHandler) {
    }

    default public void setActiveGuiSearchHandler(ISearchGUI iSearchGUI) {
    }

    default public void cancelQuerry() {
    }

    default public void setIgnoreSearchIsActive(boolean bl) {
    }
}

