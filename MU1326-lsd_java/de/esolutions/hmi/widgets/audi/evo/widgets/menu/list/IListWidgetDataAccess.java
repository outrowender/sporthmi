/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;

public interface IListWidgetDataAccess {
    default public void setModel(HMIModelGUI hMIModelGUI) {
    }

    default public void setListWidgetIndex(int n) {
    }

    default public void setListWidgetVisible(boolean bl) {
    }

    default public void connect(InitializationContext initializationContext) {
    }

    default public void disconnect() {
    }

    default public int getLength() {
    }

    default public Object getRow(int n) {
    }

    default public Object getCell(Object object, int n) {
    }

    default public long getRowId(Object object) {
    }

    default public int getItemIndexForUniqueID(long l) {
    }

    default public Long getUniqueIDForItemIndex(int n) {
    }

    default public int getSelectedIndex() {
    }

    default public void itemSelected(long l, int n) {
    }

    default public void itemReleased(long l, int n) {
    }

    default public void viewportChanged(MenuViewport menuViewport) {
    }

    default public void rendered(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
    }

    default public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }
}

