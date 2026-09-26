/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;

public interface IMenuItemSingle
extends IMenuItem {
    default public void showExtended(boolean bl) {
    }

    default public int getPreferredHeight(boolean bl, int n) {
    }

    default public IFocusedPropertyObject getProperty() {
    }

    default public boolean isSelected() {
    }

    default public int getMargin(boolean bl) {
    }

    default public int getGlassplateInsets(boolean bl) {
    }

    default public int getNoCursorArea(boolean bl) {
    }

    default public IPresetPopupData getPresetPopupData() {
    }

    default public int getSdsItemSelectedAction() {
    }

    default public boolean hasInfolineText() {
    }

    default public String getInfolineText() {
    }

    default public boolean isFocusable() {
    }

    default public int getOptionIconYOffset() {
    }

    default public void setOptionsIconSpace(int n) {
    }
}

