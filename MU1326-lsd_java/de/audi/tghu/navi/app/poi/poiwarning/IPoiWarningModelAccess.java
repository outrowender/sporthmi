/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.poiwarning;

import org.dsi.ifc.navigation.Category;

public interface IPoiWarningModelAccess {
    default public void updatePois(Category[] categoryArray, boolean bl) {
    }

    default public void setPoiSelection(int n, boolean bl) {
    }

    default public void setSettings(int n, int n2) {
    }

    default public void toggleApproachHint() {
    }

    default public void toggleSpeachHint() {
    }

    default public void showPoiWarningMaxPopUp() {
    }

    default public void showPpoiWarningMaxPopUp() {
    }

    default public void showPoiApproachPopUp() {
    }

    default public void setMaxSelectableCategories(int n) {
    }

    default public void setPersonalCategoriesVisible(boolean bl) {
    }

    default public void setPoiApproachValues(String string, float f2, int n, int n2) {
    }

    default public void hideWarningPopUp() {
    }
}

