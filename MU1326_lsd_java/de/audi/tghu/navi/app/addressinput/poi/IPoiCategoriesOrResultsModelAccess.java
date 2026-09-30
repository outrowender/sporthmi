/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;

public interface IPoiCategoriesOrResultsModelAccess {
    public IPoiSpellerModelAccess getCategoriesScreen();

    public IPoiSpellerModelAccess getResultsScreen();
}

