/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.PlaceholderMenuListManager;

public interface PlaceholderMenuMultiItem
extends PlaceholderMenuItem {
    default public int getMultiItemCount() {
    }

    default public boolean isSelected(int n, int n2) {
    }

    default public boolean isVisible(int n, int n2) {
    }

    default public boolean isEnabled(int n, int n2) {
    }

    default public int getMainSelection() {
    }

    default public int getSubSelection() {
    }

    default public void itemSelected(int n, int n2) {
    }

    default public String getLabelText(int n, int n2) {
    }

    default public Object getIconData(int n, int n2, int n3) {
    }

    default public void setListManager(PlaceholderMenuListManager placeholderMenuListManager) {
    }

    default public boolean hasSubList() {
    }

    default public PlaceholderMenuMultiItem getSubMenuMultiItem() {
    }
}

