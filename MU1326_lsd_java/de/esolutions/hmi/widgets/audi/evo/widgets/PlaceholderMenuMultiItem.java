/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuListManager;

public interface PlaceholderMenuMultiItem
extends PlaceholderMenuItem {
    public int getMultiItemCount();

    public boolean isSelected(int var1, int var2);

    public boolean isVisible(int var1, int var2);

    public boolean isEnabled(int var1, int var2);

    public int getMainSelection();

    public int getSubSelection();

    public void itemSelected(int var1, int var2);

    public String getLabelText(int var1, int var2);

    public Object getIconData(int var1, int var2, int var3);

    public void setListManager(PlaceholderMenuListManager var1);

    public boolean hasSubList();

    public PlaceholderMenuMultiItem getSubMenuMultiItem();
}

