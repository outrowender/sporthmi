/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model.list;

import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import java.util.List;

public interface BaseListModelApp
extends HMIModelApp {
    public static final int INDEX_NO_SELECTION = -1;

    public void trigger(ModelTrigger var1);

    public MenuModelApp getMenu();

    public void setLength(int var1);

    public int getLength();

    public int getIndexForUniqueID(long var1);

    public boolean contains(long var1);

    public EvoListRow getRow(int var1);

    public EvoListRow getRowByUniqueID(long var1);

    public void setRow(int var1, EvoListRow var2);

    public void setRows(int var1, int var2, EvoListRow[] var3);

    public void clearRows(int var1, int var2);

    public void clearRow(int var1);

    public void clearAll();

    public void setSelectedIndex(int var1);

    public boolean setSelectedUniqueID(long var1);

    public SelectedItem getSelected();

    public void insertBefore(long var1, EvoListRow var3);

    public void insertBefore(long var1, EvoListRow[] var3);

    public void insertAfter(long var1, EvoListRow var3);

    public void insertAfter(long var1, EvoListRow[] var3);

    public void insertAfterAndOpen(long var1, EvoListRow[] var3);

    public void append(EvoListRow var1);

    public void append(EvoListRow[] var1);

    public void remove(EvoListRow var1);

    public void remove(long var1);

    public void remove(EvoListRow[] var1);

    public void remove(long[] var1);

    public void removeByIndex(int var1);

    public void removeAndClose(long var1, int var3);

    public void removeAll();

    public BaseListModelApp getCopy();

    public BaseListModelApp getEmptyCopy();

    public BaseListModelApp getEmptyCopyWithoutEvents();

    public void update(BaseListModelApp var1);

    public void updateModelWithPendingEvents(BaseListModelApp var1);

    public void setListener(BaseListModelListener var1);

    public List asList();

    public void setRowsWithoutEvent(int var1, int var2, EvoListRow[] var3);
}

