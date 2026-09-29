/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.atip.search.AbstractGuiSearchHandler;

public interface IRadioSearch {
    default public void init() {
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

