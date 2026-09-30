/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyListener;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface PlaceholderMenuItem
extends KeyListener {
    public int getSubItemCount();

    public boolean isVisible();

    public boolean isMultiItem();

    public boolean isSubItem();

    public boolean isSelected();

    public boolean isSubSelection();

    public String getLabelText();

    public void itemFocused();

    public Object getIconData(int var1);

    public int[] getColorIndices();

    public boolean isEnabled();

    public AbstractWidgetController getWidget();

    public int getSdsItemSelectedAction();

    public int getSdsCommand();

    public int getInternalID();

    public int getWidgetID();

    public boolean isLockable();
}

