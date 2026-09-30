/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import org.dsi.ifc.navigation.Category;

public interface IPoiWarningModelAccess {
    public void updatePois(Category[] var1, boolean var2);

    public void setPoiSelection(int var1, boolean var2);

    public void setSettings(int var1, int var2);

    public void toggleApproachHint();

    public void toggleSpeachHint();

    public void showPoiWarningMaxPopUp();

    public void showPpoiWarningMaxPopUp();

    public void showPoiApproachPopUp();

    public void setMaxSelectableCategories(int var1);

    public void setPersonalCategoriesVisible(boolean var1);

    public void setPoiApproachValues(String var1, float var2, int var3, int var4);

    public void hideWarningPopUp();
}

