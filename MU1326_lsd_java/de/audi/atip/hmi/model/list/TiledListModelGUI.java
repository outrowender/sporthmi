/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface TiledListModelGUI
extends HMIModelGUI {
    public int getLength();

    public int getMaxColumns();

    public GuiListRow getGuiRow(int var1);

    public SelectedItem getSelected();

    public int getIndexForUniqueID(long var1);

    public void requestItems(int var1, int var2, int var3, int var4);

    public void unrequestItems(int var1, int var2, int var3);

    public void itemSelected(long var1, int var3, int var4);

    public void itemLongSelected(long var1, int var3, int var4);

    public void itemReleased(long var1, int var3, int var4);
}

