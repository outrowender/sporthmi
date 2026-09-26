/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.list.TiledListModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;

public abstract class AbstractTiledListModelAccess
implements IListWidgetDataAccess,
IWidgetLogChannel,
WidgetConstants {
    protected TiledListModelGUI model;
    protected int listWidgetIndex;
    protected boolean listWidgetVisible;
    protected InitializationContext context;

    @Override
    public void setModel(HMIModelGUI hMIModelGUI) {
        if (hMIModelGUI instanceof TiledListModelGUI) {
            this.model = (TiledListModelGUI)hMIModelGUI;
        } else {
            listLogCh.log(10000, "AbstractTiledListModelAccess#setModel: model does not implement TiledListModelGUI: %1", (Object)hMIModelGUI);
        }
    }

    @Override
    public void setListWidgetIndex(int n) {
        this.listWidgetIndex = n;
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
        if (this.model != null) {
            return this.model.getLength();
        }
        listLogCh.log(10000, "AbstractTiledListModelAccess#getLength: no valid model set");
        return 0;
    }

    @Override
    public Object getRow(int n) {
        if (this.model != null) {
            GuiListRow guiListRow = this.model.getGuiRow(n);
            if (guiListRow == null) {
                listLogCh.log(14808325, "AbstractTiledListModelAccess#getRow: model row is null for index: %1, model length: %2", (long)n, (long)this.model.getLength());
            }
            return guiListRow;
        }
        listLogCh.log(10000, "AbstractTiledListModelAccess#getRow: no valid model set");
        return null;
    }

    @Override
    public Object getCell(Object object, int n) {
        GuiListRow guiListRow = (GuiListRow)object;
        int n2 = guiListRow.getColumnCount();
        if (n >= n2) {
            listLogCh.log(10000, "AbstractTiledListModelAccess#getCell: try to access listmodel column %2, but row has only %3 columns. model: %1", (Object)this.model, (long)n, (long)n2);
            return null;
        }
        return guiListRow.getCell(n);
    }

    @Override
    public long getRowId(Object object) {
        GuiListRow guiListRow = (GuiListRow)object;
        return guiListRow.getUniqueID();
    }

    @Override
    public int getItemIndexForUniqueID(long l) {
        if (this.model != null) {
            int n = this.model.getIndexForUniqueID(l);
            if (n == -1) {
                listLogCh.log(-1601830656, "AbstractTiledListModelAccess#getItemIndexForUniqueID: model does not contain uniqueID %1", l);
            }
            return n;
        }
        listLogCh.log(10000, "AbstractTiledListModelAccess#getItemIndexForUniqueID: no valid model set");
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
            SelectedItem selectedItem = this.model.getSelected();
            if (selectedItem == null) {
                return -1;
            }
            int n = selectedItem.getIndex();
            long l = selectedItem.getUniqueID();
            if (this.isExpectedIdForIndex(l, n)) {
                return n;
            }
            return this.getItemIndexForUniqueID(l);
        }
        listLogCh.log(10000, "AbstractTiledListModelAccess#getSelectedIndex: no valid model set");
        return -1;
    }

    protected boolean isExpectedIdForIndex(long l, int n) {
        Object object = this.getRow(n);
        if (object == null) {
            return false;
        }
        long l2 = this.getRowId(object);
        return l == l2;
    }

    @Override
    public void itemSelected(long l, int n) {
        if (this.model != null) {
            listLogCh.log(-2137614336, "AbstractTiledListModelAccess#itemSelected: call itemSelected. model: %1, row: %2, rowID: %3", (long)this.model.getID(), (long)n, l);
            this.model.itemSelected(l, 0, this.context.getTerminalID());
        } else {
            listLogCh.log(10000, "AbstractTiledListModelAccess#itemSelected: no valid model set");
        }
    }

    @Override
    public void itemReleased(long l, int n) {
        if (this.model != null) {
            listLogCh.log(-2137614336, "AbstractTiledListModelAccess#itemReleased: call itemReleased. model: %1, row: %2, rowID: %3", (long)this.model.getID(), (long)n, l);
            this.model.itemReleased(l, 0, this.context.getTerminalID());
        } else {
            listLogCh.log(10000, "AbstractTiledListModelAccess#itemReleased: no valid model set");
        }
    }

    public TiledListModelGUI getModel() {
        return this.model;
    }

    public int getListWidgetIndex() {
        return this.listWidgetIndex;
    }

    public boolean isListWidgetVisible() {
        return this.listWidgetVisible;
    }

    @Override
    public void setListWidgetVisible(boolean bl) {
        this.listWidgetVisible = bl;
    }
}

