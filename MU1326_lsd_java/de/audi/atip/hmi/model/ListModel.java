/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ModelException;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;

public class ListModel
extends AbstractModel
implements ListModelApp,
ListModelGUI {
    private int maxRows = 10;
    private int overallCols = 1;
    private int selected = -1;
    volatile ListListener listListener = DUMMY_LISTENER;
    private final ArrayList list = new ArrayList(0);

    public ListModel(int n) {
        this(n, 0);
    }

    public ListModel(int n, int n2) {
        super(n, n2);
    }

    @Override
    public void resetListener() {
        this.listListener = DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(1000);
        buffer.append(super.dumpContent());
        Object object = this.mutex;
        synchronized (object) {
            buffer.append("\nmaxRows: ");
            buffer.append(this.maxRows);
            buffer.append("\noverallCols: ");
            buffer.append(this.overallCols);
            buffer.append("\nselected: ");
            buffer.append(this.selected);
            buffer.append("\nListListener: ");
            buffer.append(this.listListener);
            int n = this.list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append("\n[");
                buffer.append(i2);
                buffer.append("]: ");
                buffer.append(this.list.get(i2));
            }
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        Object object = this.mutex;
        synchronized (object) {
            ListModel listModel = (ListModel)abstractModel;
            this.selected = listModel.selected;
            this.overallCols = listModel.overallCols;
            this.maxRows = listModel.maxRows;
            this.listListener = listModel.listListener;
            this.list.clear();
            this.list.addAll(listModel.list);
            super.copy(listModel);
        }
    }

    @Override
    public int getModelType() {
        return 4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.isEmpty();
        }
    }

    @Override
    public Class getColumnType(int n) {
        return ListRow.getColumnType(super.getClass());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getLength() {
        Object object = this.mutex;
        synchronized (object) {
            return this.list.size();
        }
    }

    @Override
    public int getLengthOnTransaction() {
        throw new IllegalStateException();
    }

    @Override
    public ListCell getCell(int n, int n2) {
        return this.getRow(n).getCell(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getMaxColumns() {
        Object object = this.mutex;
        synchronized (object) {
            return this.overallCols;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getMaxRows() {
        Object object = this.mutex;
        synchronized (object) {
            return this.maxRows;
        }
    }

    @Override
    public boolean getRow(int n, ListCell[] listCellArray) {
        BaseListRow baseListRow = null;
        try {
            baseListRow = this.getRow(n);
        }
        catch (Exception exception) {
            this.lc.log(1078071040, "(%1) [ListModel.getRow] %2", (long)this.id, (Throwable)exception);
            return false;
        }
        try {
            if (baseListRow.getColumnCount() != listCellArray.length) {
                throw new ModelException((HMIModel)this, "Column count mismatch!");
            }
            System.arraycopy((Object)baseListRow.getCells(), 0, (Object)listCellArray, 0, listCellArray.length);
            return true;
        }
        catch (Exception exception) {
            this.logException("getRow", new Buffer().append("index:").append(n), exception);
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BaseListRow getRow(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n < 0 || n >= this.list.size()) {
                throw new ModelException((HMIModel)this, new StringBuffer().append(" Given index ").append(n).append(" is out of range!").toString());
            }
            return (BaseListRow)this.list.get(n);
        }
    }

    @Override
    public BaseListRow getRowOnTransaction(int n) {
        throw new IllegalStateException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getSelected() {
        Object object = this.mutex;
        synchronized (object) {
            return this.selected;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setCell(int n, int n2, ListCell listCell) {
        Object object = this.mutex;
        synchronized (object) {
            BaseListRow baseListRow = this.getRow(n);
            baseListRow.setCell(n2, listCell);
        }
        this.fireModelUpdateEvent(10, n, n2);
    }

    @Override
    public void setListListener(ListListener listListener) {
        this.listListener = listListener != null ? listListener : DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void setMaxColumns(int n) {
        if (n <= 0) {
            throw new ModelException((HMIModel)this, new StringBuffer().append("Max columns can't be set to ").append(n).toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.overallCols = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void setMaxRows(int n) {
        if (n < 0) {
            throw new ModelException((HMIModel)this, new StringBuffer().append("Max rows can't be set to ").append(n).toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.list.ensureCapacity(n);
            this.maxRows = n;
        }
        this.fireModelUpdateEvent(5, n);
    }

    @Override
    public void setRow(int n, ListCell listCell) {
        this.setRow(n, new ListCell[]{listCell});
    }

    @Override
    public void setRow(int n, ListCell[] listCellArray) {
        this.setRow(n, new BaseListRow(listCellArray));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setRow(int n, BaseListRow baseListRow) {
        this.checkColumnCount(baseListRow);
        Object object = this.mutex;
        synchronized (object) {
            if (n < 0 || n >= this.list.size()) {
                throw new ModelException((HMIModel)this, new StringBuffer().append("Invalid row ").append(n).toString());
            }
            this.list.set(n, baseListRow);
            this.stateChanged();
        }
        this.fireModelUpdateEvent(8, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelected(int n) {
        if (n < -1) {
            throw new ModelException((HMIModel)this, new StringBuffer().append("Invalid selection ").append(n).toString());
        }
        Object object = this.mutex;
        synchronized (object) {
            this.selected = n;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1, n);
    }

    @Override
    public void addRow(ListCell listCell) {
        this.addRow(new ListCell[]{listCell});
    }

    @Override
    public void addRow(ListCell[] listCellArray) {
        this.addRow(new BaseListRow(listCellArray));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addRow(BaseListRow baseListRow) {
        int n;
        this.checkColumnCount(baseListRow);
        Object object = this.mutex;
        synchronized (object) {
            n = this.list.size();
            this.list.add(baseListRow);
            this.stateChanged();
        }
        this.fireModelUpdateEvent(7, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.list.clear();
            this.stateChanged();
        }
        this.fireModelUpdateEvent(6);
    }

    @Override
    public void insertRow(int n, ListCell listCell) {
        this.insertRow(n, new ListCell[]{listCell});
    }

    @Override
    public void insertRow(int n, ListCell[] listCellArray) {
        this.insertRow(n, new BaseListRow(listCellArray));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void insertRow(int n, BaseListRow baseListRow) {
        this.checkColumnCount(baseListRow);
        Object object = this.mutex;
        synchronized (object) {
            if (n < 0 || n > this.list.size()) {
                throw new ModelException((HMIModel)this, new StringBuffer().append("Invalid index ").append(n).toString());
            }
            this.list.add(n, baseListRow);
            this.stateChanged();
        }
        this.fireModelUpdateEvent(7, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeRow(int n) {
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            if (n >= 0 && n < this.list.size()) {
                this.list.remove(n);
                bl = true;
                this.stateChanged();
            }
        }
        if (bl) {
            this.fireModelUpdateEvent(9, n);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3) {
        if (n >= -1 && n < this.getLength()) {
            try {
                this.listListener.itemFocused(this.id, n, n2, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3) {
        if (n >= 0 && n < this.getLength()) {
            try {
                this.listListener.itemSelected(this.id, n, n2, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    @Override
    public void itemReleased(int n, int n2, int n3) {
        if (n >= 0 && n < this.getLength()) {
            try {
                this.listListener.itemReleased(this.id, n, n2, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    private void checkColumnCount(BaseListRow baseListRow) {
        if (this.overallCols != baseListRow.getColumnCount()) {
            throw new ModelException((HMIModel)this, new StringBuffer().append(baseListRow).append(" doesn't match #expectedCols:").append(baseListRow.getColumnCount()).toString());
        }
    }
}

