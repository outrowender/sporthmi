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
    public void setModel(HMIModelGUI var1);

    public void setListWidgetIndex(int var1);

    public void setListWidgetVisible(boolean var1);

    public void connect(InitializationContext var1);

    public void disconnect();

    public int getLength();

    public Object getRow(int var1);

    public Object getCell(Object var1, int var2);

    public long getRowId(Object var1);

    public int getItemIndexForUniqueID(long var1);

    public Long getUniqueIDForItemIndex(int var1);

    public int getSelectedIndex();

    public void itemSelected(long var1, int var3);

    public void itemReleased(long var1, int var3);

    public void viewportChanged(MenuViewport var1);

    public void rendered(MenuItemIndex var1, MenuItemIndex var2);

    public void processModelUpdateEvent(ModelUpdateEvent var1);
}

