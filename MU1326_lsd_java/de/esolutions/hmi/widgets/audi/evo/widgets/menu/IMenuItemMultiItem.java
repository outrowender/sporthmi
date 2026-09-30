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
    public void updateSubItemCount();

    public int getItemIndexForUniqueID(long var1);

    public Long getUniqueIDForItemIndex(int var1);

    public MenuItemMetaData createMenuItem(int var1);

    public void destroyMenuItem(MenuItemMetaData var1);

    public boolean realizeMenuItem(MenuItemMetaData var1);

    public boolean updateMenuItem(MenuItemMetaData var1);

    public void showExtended(boolean var1, int var2);

    public int getSelectedIndex();

    public void keyPressed(KeyEvent var1, int var2);

    public void keyReleased(KeyEvent var1, int var2);

    public void itemFocused(int var1);

    public IFocusedPropertyObject getPropertiesForLine(int var1);

    public IPresetPopupData getPresetPopupData(int var1);

    public int getSdsItemSelectedAction(int var1);

    public boolean hasInfolineText(int var1);

    public String getInfolineText(int var1);

    public boolean isEnabled(int var1);

    public boolean isNowPlayingModeEnabled(int var1);

    public int getPreferredMenuItemHeight(int var1, boolean var2);

    public int getMargin(int var1, boolean var2);

    public int getGlassplateInsets(int var1, boolean var2);

    public int getPreferredMenuItemHeight(MenuItemMetaData var1, boolean var2);

    public int getMargin(MenuItemMetaData var1, boolean var2);

    public int getGlassplateInsets(MenuItemMetaData var1, boolean var2);

    public int getNoCursorArea(int var1, boolean var2);

    public int getNoCursorArea(MenuItemMetaData var1, boolean var2);

    public boolean isFocusable(int var1);

    public void setFocusedCursorBeforeMerge(int var1);
}

