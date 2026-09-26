/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMulti;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;

public interface IMenuItemMultiItem
extends IMenuItemMulti {
    default public void updateSubItemCount() {
    }

    default public int getItemIndexForUniqueID(long l) {
    }

    default public Long getUniqueIDForItemIndex(int n) {
    }

    default public MenuItemMetaData createMenuItem(int n) {
    }

    default public void destroyMenuItem(MenuItemMetaData menuItemMetaData) {
    }

    default public boolean realizeMenuItem(MenuItemMetaData menuItemMetaData) {
    }

    default public boolean updateMenuItem(MenuItemMetaData menuItemMetaData) {
    }

    default public void showExtended(boolean bl, int n) {
    }

    default public int getSelectedIndex() {
    }

    default public void keyPressed(KeyEvent keyEvent, int n) {
    }

    default public void keyReleased(KeyEvent keyEvent, int n) {
    }

    default public void itemFocused(int n) {
    }

    default public IFocusedPropertyObject getPropertiesForLine(int n) {
    }

    default public IPresetPopupData getPresetPopupData(int n) {
    }

    default public int getSdsItemSelectedAction(int n) {
    }

    default public boolean hasInfolineText(int n) {
    }

    default public String getInfolineText(int n) {
    }

    default public boolean isEnabled(int n) {
    }

    default public boolean isNowPlayingModeEnabled(int n) {
    }

    default public int getPreferredMenuItemHeight(int n, boolean bl) {
    }

    default public int getMargin(int n, boolean bl) {
    }

    default public int getGlassplateInsets(int n, boolean bl) {
    }

    default public int getPreferredMenuItemHeight(MenuItemMetaData menuItemMetaData, boolean bl) {
    }

    default public int getMargin(MenuItemMetaData menuItemMetaData, boolean bl) {
    }

    default public int getGlassplateInsets(MenuItemMetaData menuItemMetaData, boolean bl) {
    }

    default public int getNoCursorArea(int n, boolean bl) {
    }

    default public int getNoCursorArea(MenuItemMetaData menuItemMetaData, boolean bl) {
    }

    default public boolean isFocusable(int n) {
    }

    default public void setFocusedCursorBeforeMerge(int n) {
    }
}

