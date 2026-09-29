/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModel;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicListModel
extends AbstractListModel
implements DynamicListModelApp,
SlidingListModelGUI {
    private int lowerThreshold = -1;
    private int upperThreshold = -1;
    private int lastUpdatedIndex = -1;
    private int selectedListIndex = -1;
    private boolean runningOutOfDataCalled;

    public DynamicListModel(int n) {
        super(n, new ArrayList(0), 5);
    }

    DynamicListModel(int n, int n2) {
        super(n, new ArrayList(0), n2);
    }

    DynamicListModel(int n, int n2, int n3) {
        super(n, n2, new ArrayList(0), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(1000);
        Object object = this.mutex;
        synchronized (object) {
            buffer.append(super.dumpContent());
            buffer.append("\nlowerThreshold: ");
            buffer.append(this.lowerThreshold);
            buffer.append("\nupperThreshold: ");
            buffer.append(this.upperThreshold);
            buffer.append("\nlastUpdatedIndex: ");
            buffer.append(this.lastUpdatedIndex);
            buffer.append("\nselectedListIndex: ");
            buffer.append(this.selectedListIndex);
            buffer.append("\nrunningOutOfDataCalled: ");
            buffer.append(this.runningOutOfDataCalled);
            buffer.append("\nDynamicListModelListener: ");
            buffer.append(this.listener);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        this.lc.log(-2137614336, "(%1) [DLM.clear]", (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.selectedListIndex = -1;
            this.lastUpdatedIndex = -1;
            this.runningOutOfDataCalled = false;
            super.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fill(ListRow[] listRowArray, int n) {
        this.lc.log(-2137614336, "(%1) [DLM.fill] length:%2", (long)this.id, (long)listRowArray.length);
        Object object = this.mutex;
        synchronized (object) {
            this.clear();
            for (int i2 = 0; i2 < listRowArray.length; ++i2) {
                listRowArray[i2].index = i2;
            }
            this.list.addAll(Arrays.asList(listRowArray));
            this.listCursor = 0;
            this.lineNumber = n;
            this.lastUpdatedIndex = 0;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(12);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setThreshold(int n, int n2) {
        this.lc.log(-2137614336, "(%1) [DLM.setThreshold] lower:%2 upper:%3", (long)this.id, (long)n, (long)n2);
        Object object = this.mutex;
        synchronized (object) {
            this.lowerThreshold = n;
            this.upperThreshold = n2;
            this.containsStartOfList = this.lowerThreshold == -1;
            this.containsEndOfList = this.upperThreshold == -1;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelected(ListRow listRow) {
        this.lc.log(-2137614336, "(%2) [DLM.setSelected] %1", (Object)listRow, (long)this.id);
        int n = -1;
        Object object = this.mutex;
        synchronized (object) {
            if (listRow == null) {
                this.selectedListIndex = -1;
            } else {
                this.selectedListIndex = this.list.indexOf(listRow);
                if (this.isVisible(this.selectedListIndex)) {
                    n = this.selectedListIndex - this.listCursor;
                }
            }
        }
        this.fireModelUpdateEvent(1, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getSelected() {
        int n = this.selectedListIndex;
        Object object = this.mutex;
        synchronized (object) {
            n = this.selectedListIndex == -1 ? -1 : (this.isVisible(this.selectedListIndex) ? this.selectedListIndex - this.listCursor : -1);
        }
        this.lc.log(-2137614336, "(%2) [DLM.getSelected] %1 ", (long)n, (long)this.id);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean updateRow(ListRow listRow) {
        boolean bl = false;
        int n = -1;
        Object object = this.mutex;
        synchronized (object) {
            ListRow listRow2 = this.get(this.lastUpdatedIndex);
            if (listRow2 != null && listRow2.equals(listRow)) {
                bl = true;
            } else {
                int n2 = this.list.indexOf(listRow);
                if (n2 != -1) {
                    this.lastUpdatedIndex = n2;
                    bl = true;
                } else {
                    this.lc.log(-2137614336, "(%2) [DLM.updateRow] Given row not found: %1", (Object)listRow, (long)this.id);
                }
            }
            if (bl) {
                this.lc.log(-2137614336, "(%2) [DLM.updateRow] Updated index %3 with given row: %1", (Object)listRow, (long)this.id, (long)this.lastUpdatedIndex);
                this.list.set(this.lastUpdatedIndex, listRow);
                this.stateChanged();
                n = this.lastUpdatedIndex - this.listCursor;
            }
        }
        this.fireModelUpdateEvent(8, n);
        return bl;
    }

    @Override
    public boolean setFocusedCursorPosition(ListRow listRow, int n) {
        boolean bl = super.setFocusedCursorPosition(listRow, n);
        if (bl) {
            this.callRunningOutOfData(listRow, n, this.getTerminalID());
        }
        return bl;
    }

    @Override
    public void setListListener(DynamicListModelListener dynamicListModelListener) {
        this.listener = dynamicListModelListener != null ? dynamicListModelListener : DUMMY_LISTENER;
    }

    public int getEndOfListState(int n) {
        throw new UnsupportedOperationException("DynamicListModel.getEndOfListState(int) not implemented!");
    }

    @Override
    public boolean isEndOfList(int n) {
        Object object = this.mutex;
        synchronized (object) {
            switch (n) {
                case 1: {
                    return this.isNextContextEndOfList();
                }
                case -1: {
                    return this.isPreviousContextEndOfList();
                }
                case 0: {
                    return this.isCurrentContextEndOfList();
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("(").append(this.id).append(") DynamicListModel.isEndOfList( ").append(n).append(" ) Unknown context!").toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, int n3) {
        int n4;
        ListRow listRow;
        Object object = this.mutex;
        synchronized (object) {
            super.itemFocused(n, n2, n3);
            if (n == -1) {
                listRow = null;
            } else {
                int n5 = this.listCursor + n;
                listRow = this.get(n5);
            }
            n4 = this.getFocusedCursorPosition();
        }
        try {
            this.listener.itemFocused(this.id, listRow, n4, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
        this.callRunningOutOfData(listRow, n, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(int n, int n2, int n3) {
        ListRow listRow;
        Object object = this.mutex;
        synchronized (object) {
            int n4 = this.listCursor + n;
            listRow = this.get(n4);
        }
        this.lc.log(-2137614336, "(%2) DynamicListModel.itemSelected( %3 ) = %1 ", (Object)listRow, (long)this.id, (long)n);
        if (listRow != null) {
            try {
                this.listener.itemSelected(this.id, listRow, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemReleased(int n, int n2, int n3) {
        ListRow listRow;
        Object object = this.mutex;
        synchronized (object) {
            int n4 = this.listCursor + n;
            listRow = this.get(n4);
        }
        this.lc.log(-2137614336, "(%2) DynamicListModel.itemReleased( %3 ) = %1 ", (Object)listRow, (long)this.id, (long)n);
        if (listRow != null) {
            try {
                ((DynamicListModelListener)this.listener).itemReleased(this.id, listRow, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                DynamicListModel dynamicListModel = (DynamicListModel)abstractModel;
                this.list = (List)((ArrayList)dynamicListModel.list).clone();
                this.lowerThreshold = dynamicListModel.lowerThreshold;
                this.upperThreshold = dynamicListModel.upperThreshold;
                this.lastUpdatedIndex = dynamicListModel.lastUpdatedIndex;
                this.selectedListIndex = dynamicListModel.selectedListIndex;
                this.runningOutOfDataCalled = dynamicListModel.runningOutOfDataCalled;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) DynamicListModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    int getLowerThreshold() {
        return this.lowerThreshold;
    }

    int getUpperThreshold() {
        return this.upperThreshold;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void callRunningOutOfData(ListRow listRow, int n, int n2) {
        int n3 = -1;
        Object object = this.mutex;
        synchronized (object) {
            int n4 = this.listCursor + n;
            this.lc.log(-2137614336, "DynamicListModel.callRunningOutOfData(): listCursor:%1, cursorPos:%2 ", (long)this.listCursor, (long)n);
            if (!this.runningOutOfDataCalled && this.list.size() > 0) {
                if (this.upperThreshold >= 0 && n4 > this.upperThreshold) {
                    this.runningOutOfDataCalled = true;
                    n3 = 1;
                } else if (this.lowerThreshold >= 0 && n4 < this.lowerThreshold) {
                    this.runningOutOfDataCalled = true;
                    n3 = 0;
                }
            }
        }
        if (n3 != -1) {
            try {
                ((DynamicListModelListener)this.listener).runningOutOfData(this.id, listRow, n3, n2);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    private boolean isCurrentContextEndOfList() {
        boolean bl = false;
        boolean bl2 = false;
        if (this.lowerThreshold == -1 || this.lowerThreshold < 0) {
            boolean bl3 = bl = this.listCursor <= 0;
        }
        if (this.upperThreshold == -1 || this.upperThreshold < 0) {
            bl2 = this.listCursor + this.getVisibleRowsCount() >= this.list.size();
        }
        boolean bl4 = bl || bl2;
        this.lc.log(-2137614336, "(%2) DynamicListModel.isEndOfList( CONTEXT_CURRENT ) = %1 ", bl4, (long)this.id);
        return bl4;
    }

    private boolean isNextContextEndOfList() {
        boolean bl = false;
        if (this.upperThreshold == -1) {
            bl = this.listCursor + 2 * this.getVisibleRowsCount() >= this.list.size();
        }
        this.lc.log(-2137614336, "(%2) DynamicListModel.isEndOfList( CONTEXT_NEXT ) = %1 ", bl, (long)this.id);
        return bl;
    }

    private boolean isPreviousContextEndOfList() {
        boolean bl = false;
        if (this.lowerThreshold == -1) {
            bl = this.listCursor - this.getVisibleRowsCount() <= 0;
        }
        this.lc.log(-2137614336, "(%2) DynamicListModel.isEndOfList( CONTEXT_PREVIOUS ) = %1 ", bl, (long)this.id);
        return bl;
    }
}

