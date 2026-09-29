/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface TiledListModelGUI
extends HMIModelGUI {
    default public int getLength() {
    }

    default public int getMaxColumns() {
    }

    default public GuiListRow getGuiRow(int n) {
    }

    default public SelectedItem getSelected() {
    }

    default public int getIndexForUniqueID(long l) {
    }

    default public void requestItems(int n, int n2, int n3, int n4) {
    }

    default public void unrequestItems(int n, int n2, int n3) {
    }

    default public void itemSelected(long l, int n, int n2) {
    }

    default public void itemLongSelected(long l, int n, int n2) {
    }

    default public void itemReleased(long l, int n, int n2) {
    }
}

