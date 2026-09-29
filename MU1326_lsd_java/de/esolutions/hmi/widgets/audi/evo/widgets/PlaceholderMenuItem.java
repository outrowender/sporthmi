/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.KeyListener;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;

public interface PlaceholderMenuItem
extends KeyListener {
    default public int getSubItemCount() {
    }

    default public boolean isVisible() {
    }

    default public boolean isMultiItem() {
    }

    default public boolean isSubItem() {
    }

    default public boolean isSelected() {
    }

    default public boolean isSubSelection() {
    }

    default public String getLabelText() {
    }

    default public void itemFocused() {
    }

    default public Object getIconData(int n) {
    }

    default public int[] getColorIndices() {
    }

    default public boolean isEnabled() {
    }

    default public AbstractWidgetController getWidget() {
    }

    default public int getSdsItemSelectedAction() {
    }

    default public int getSdsCommand() {
    }

    default public int getInternalID() {
    }

    default public int getWidgetID() {
    }

    default public boolean isLockable() {
    }
}

