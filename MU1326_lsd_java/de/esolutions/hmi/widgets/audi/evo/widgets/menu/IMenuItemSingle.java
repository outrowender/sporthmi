/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu;

import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;

public interface IMenuItemSingle
extends IMenuItem {
    public void showExtended(boolean var1);

    public int getPreferredHeight(boolean var1, int var2);

    public IFocusedPropertyObject getProperty();

    public boolean isSelected();

    public int getMargin(boolean var1);

    public int getGlassplateInsets(boolean var1);

    public int getNoCursorArea(boolean var1);

    public IPresetPopupData getPresetPopupData();

    public int getSdsItemSelectedAction();

    public boolean hasInfolineText();

    public String getInfolineText();

    public boolean isFocusable();

    public int getOptionIconYOffset();

    public void setOptionsIconSpace(int var1);
}

