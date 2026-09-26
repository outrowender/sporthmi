/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.modelaccess.FolderListModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.modelaccess.SlidingListModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;

public class OldListModelAccess
implements IListWidgetDataAccess,
IWidgetLogChannel,
WidgetConstants {
    private ListModelGUI model;
    private int idColumn;
    private InitializationContext context;

    @Override
    public void setModel(HMIModelGUI hMIModelGUI) {
        if (hMIModelGUI instanceof ListModelGUI) {
            this.model = (ListModelGUI)hMIModelGUI;
        } else {
            listLogCh.log(10000, "OldListModelAccess#setModel: model does not implement ListModelGUI: %1", (Object)hMIModelGUI);
        }
    }

    @Override
    public void setListWidgetIndex(int n) {
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        this.context = initializationContext;
    }

    @Override
    public void disconnect() {
    }

    @Override
    public int getLength() {
        if (this.model instanceof SlidingListModelGUI) {
            return ((SlidingListModelGUI)this.model).getListLength();
        }
        if (this.model != null) {
            return this.model.getLength();
        }
        listLogCh.log(10000, "OldListModelAccess#getModelSize: no valid model set");
        return 0;
    }

    @Override
    public Object getRow(int n) {
        if (this.model != null) {
            ListCell[] listCellArray = new ListCell[this.model.getMaxColumns()];
            boolean bl = this.model.getRow(n, listCellArray);
            if (bl) {
                return listCellArray;
            }
            listLogCh.log(-1601830656, "OldListModelAccess#getRow: model row %1 doesn't exist. model length: %2", (long)n, (long)this.model.getLength());
            return null;
        }
        listLogCh.log(10000, "OldListModelAccess#getRow: no valid model set");
        return null;
    }

    @Override
    public Object getCell(Object object, int n) {
        ListCell[] listCellArray = (ListCell[])object;
        if (listCellArray == null) {
            listLogCh.log(10000, "OldListModelAccess#getCell: row is null");
            return null;
        }
        if (n < 0) {
            listLogCh.log(10000, "OldListModelAccess#getCell: invalid column: %1", (long)n);
            return null;
        }
        if (n >= this.model.getMaxColumns()) {
            listLogCh.log(10000, "OldListModelAccess#getCell: invalid column: %1, max columns: %2", (long)n, (long)this.model.getMaxColumns());
            return null;
        }
        return listCellArray[n];
    }

    @Override
    public long getRowId(Object object) {
        ListCell[] listCellArray = (ListCell[])object;
        if (listCellArray == null) {
            listLogCh.log(10000, "OldListModelAccess#getRowId: row is null");
            return -1L;
        }
        int n = this.idColumn;
        if (n == -1 && this.model instanceof FolderListModelGUI) {
            n = 0;
        }
        if (n < 0) {
            listLogCh.log(-2137614336, "OldListModelAccess#getRowId: invalid idColumn: %1", (long)n);
            return -1L;
        }
        if (n >= this.model.getMaxColumns()) {
            listLogCh.log(10000, "OldListModelAccess#getRowId: invalid idColumn: %1, max columns: %2", (long)n, (long)this.model.getMaxColumns());
            return -1L;
        }
        ListCell listCell = listCellArray[n];
        if (listCell == null) {
            listLogCh.log(10000, "OldListModelAccess#getRowId: cell in column %1 is null.", (long)n);
            return -1L;
        }
        if (listCell instanceof IntegerListCell) {
            return ((IntegerListCell)listCell).getValue();
        }
        if (listCell instanceof LongListCell) {
            return ((LongListCell)listCell).getValue();
        }
        listLogCh.log(10000, "OldListModelAccess#getRowId: invalid content at column %2: %1", (Object)listCell, (long)n);
        return -1L;
    }

    @Override
    public int getItemIndexForUniqueID(long l) {
        int n = this.getLength();
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = this.getRow(i2);
            if (object == null || this.getRowId(object) != l) continue;
            return i2;
        }
        listLogCh.log(-1601830656, "OldListModelAccess#getItemIndexForUniqueID: uniqueID %1 not found", l);
        return -1;
    }

    @Override
    public Long getUniqueIDForItemIndex(int n) {
        Object object = this.getRow(n);
        if (object != null) {
            return Util.createLong(this.getRowId(object));
        }
        return null;
    }

    @Override
    public int getSelectedIndex() {
        if (this.model != null) {
            return this.model.getSelected();
        }
        listLogCh.log(10000, "OldListModelAccess#getSelectedIndex: no valid model set");
        return -1;
    }

    @Override
    public void itemSelected(long l, int n) {
        if (this.model != null) {
            listLogCh.log(-2137614336, "OldListModelAccess#itemSelected: call itemSelected. model: %1, row: %2", (long)this.model.getID(), (long)n);
            this.model.itemSelected(n, 0, this.context.getTerminalID());
        } else {
            listLogCh.log(10000, "OldListModelAccess#getSelectedIndex: no valid model set");
        }
    }

    @Override
    public void itemReleased(long l, int n) {
        if (this.model != null) {
            listLogCh.log(-2137614336, "OldListModelAccess#itemReleased: call itemReleased. model: %1, row: %2", (long)this.model.getID(), (long)n);
            this.model.itemReleased(n, 0, this.context.getTerminalID());
        } else {
            listLogCh.log(10000, "OldListModelAccess#getSelectedIndex: no valid model set");
        }
    }

    @Override
    public void viewportChanged(MenuViewport menuViewport) {
        listLogCh.log(-2137614336, "OldListModelAccess#viewportChanged: new viewport: %1", (Object)menuViewport);
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    @Override
    public void rendered(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        listLogCh.log(-2137614336, "OldListModelAccess#rendered: first: %1, last: %2", (Object)menuItemIndex, (Object)menuItemIndex2);
    }

    public int getIdColumn() {
        return this.idColumn;
    }

    public void setIdColumn(int n) {
        this.idColumn = n;
    }

    @Override
    public void setListWidgetVisible(boolean bl) {
    }
}

