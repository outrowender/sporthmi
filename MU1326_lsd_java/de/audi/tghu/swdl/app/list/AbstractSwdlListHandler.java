/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.list;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListItemNull;

abstract class AbstractSwdlListHandler
implements ListListener {
    private ListModelApp list = null;
    private int listId = 0;
    private int nrCol = 0;
    private ISwdlListItem base = null;
    private final SwdlEnv swdlEnv;

    public AbstractSwdlListHandler(SwdlEnv swdlEnv, ListModelApp listModelApp, int n, int n2) {
        this.swdlEnv = swdlEnv;
        this.listId = n;
        this.setNrCol(n2);
        this.setList(listModelApp);
        this.base = new SwdlListItemNull("[AbstractSwdlListHandler][SwdlListItemNull]");
    }

    final int getListId() {
        return this.listId;
    }

    final ISwdlListItem getBase() {
        return this.base;
    }

    public final void setBase(ISwdlListItem iSwdlListItem) {
        this.base = iSwdlListItem;
    }

    public final ListModelApp getList() {
        return this.list;
    }

    private void setList(ListModelApp listModelApp) {
        if (this.getList() != null) {
            this.getList().setListListener(null);
        }
        this.list = listModelApp;
        if (listModelApp != null) {
            this.getList().setListListener(this);
            this.getList().setMaxColumns(this.getNrCol());
        }
    }

    public final void reset() {
        this.adjustListLength(0);
        this.getList().setMaxColumns(this.getNrCol());
    }

    final int getNrCol() {
        return this.nrCol;
    }

    private void setNrCol(int n) {
        this.nrCol = n;
        if (this.getList() != null) {
            this.getList().setMaxColumns(n);
        }
    }

    public ISwdlListItem[] getEntries() {
        ISwdlListItem[] iSwdlListItemArray = new ISwdlListItem[]{};
        ISwdlListItem iSwdlListItem = this.getBase();
        if (iSwdlListItem != null && iSwdlListItem.getChildren() != null) {
            iSwdlListItemArray = iSwdlListItem.getChildren();
        }
        return iSwdlListItemArray;
    }

    public ISwdlListItem getEntry(int n) {
        ISwdlListItem iSwdlListItem = null;
        if (n < this.getEntries().length && n >= 0) {
            iSwdlListItem = this.getEntries()[n];
        }
        return iSwdlListItem;
    }

    void setEntries(ISwdlListItem[] iSwdlListItemArray) {
        ISwdlListItem iSwdlListItem = this.getBase();
        if (iSwdlListItem != null) {
            iSwdlListItem.setChildren(iSwdlListItemArray);
        }
    }

    public void setSelectedEntry(int n) {
        this.list.setSelected(n);
    }

    public abstract ListCell[] getNewRow();

    public void itemFocused(int n, int n2, int n3, int n4) {
        if (this.getListId() != n) {
            this.getLogHMI().log(100000, "[AbstractSwdlListHandler] itemFocused called at wrong handler! modelID %1 expected ModelID %2 ", (long)n, (long)this.getListId());
        }
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
        if (this.getListId() != n) {
            this.getLogHMI().log(100000, "[AbstractSwdlListHandler] itemReleased called at wrong handler! modelID %1 expected ModelID %2 ", (long)n, (long)this.getListId());
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.getListId() == n) {
            ISwdlListItem iSwdlListItem = this.getEntry(n2);
            if (iSwdlListItem != null && iSwdlListItem.getSelectable()) {
                iSwdlListItem.select(n2);
                this.getList().fireEvent(n4);
            }
        } else {
            this.getLogHMI().log(100000, "[AbstractSwdlListHandler] itemSelected called at wrong handler! modelID %1 expected ModelID %2 ", (long)n, (long)this.getListId());
        }
    }

    void logList(String string, String[] stringArray) {
        if (this.getLogHMI().isDebug()) {
            this.getLogHMI().log(10000000, "[AbstractSwdlListHandler] New %1 list received.", (Object)string);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.getLogHMI().log(10000000, "[AbstractSwdlListHandler] %1 %2 ", (Object)string, (Object)stringArray[i2]);
            }
        }
    }

    void adjustListLength(int n) {
        int n2 = this.getList().getLength();
        if (this.getList().getMaxRows() < n) {
            this.getList().setMaxRows(n + 1);
        }
        while (n2 < n) {
            ++n2;
            this.getList().addRow(this.getNewRow());
        }
        while (n2 > n) {
            this.getList().removeRow(--n2);
        }
    }

    public void updateList() {
        ISwdlListItem[] iSwdlListItemArray;
        if (this.getBase() != null && (iSwdlListItemArray = this.getEntries()) != null) {
            this.adjustListLength(iSwdlListItemArray.length);
            for (int i2 = 0; i2 < iSwdlListItemArray.length; ++i2) {
                BaseListRow baseListRow = this.getList().getRow(i2);
                iSwdlListItemArray[i2].updateListRow(baseListRow);
                this.getList().setRow(i2, baseListRow);
            }
        }
    }

    public boolean checkBase() {
        if (this.getBase() == null) {
            this.getLogHMI().log(100000, "[AbstractSwdlListHandler] getBase() is NULL.");
        }
        return this.getBase() != null;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    protected final LogChannel getLogHMI() {
        return this.getSwdlEnv().getLogHMI();
    }
}

