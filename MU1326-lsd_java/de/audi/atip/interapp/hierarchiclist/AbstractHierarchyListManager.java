/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.hierarchiclist;

import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.interapp.hierarchiclist.AbstractHierarchyListManager$DefaultComparator;
import de.audi.atip.interapp.hierarchiclist.AbstractHierarchyListRow;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHierarchyListManager {
    public static final int PREVIOUS_ROWS;
    public static final int NEXT_ROWS;
    public static final int UPPER_BORDER_REACHED;
    public static final int LOWER_BORDER_REACHED;
    public static final int WAITING_JUMP_TO_FOLLOWUP;
    public static final int WAITING_STAY_IN_SCREEN;
    private LogChannel logCh;
    private long openedAnchorId;
    private ListRow focusedRow;
    private int cursorPosition;
    private DynamicListModelApp listModel;
    private ChoiceModelApp listAvailableModel;
    private ChoiceModelApp waitingModel;
    private int windowId;
    private AbstractHierarchyListManager$DefaultComparator dfltComparator;

    public AbstractHierarchyListManager(LogChannel logChannel, DynamicListModelApp dynamicListModelApp, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, int n) {
        this.logCh = logChannel;
        this.windowId = n;
        this.listModel = dynamicListModelApp;
        this.listAvailableModel = choiceModelApp;
        this.waitingModel = choiceModelApp2;
        this.dfltComparator = new AbstractHierarchyListManager$DefaultComparator(null);
        this.initValues();
        this.resetModels();
    }

    public final ListRow getFocusedRow() {
        return this.focusedRow;
    }

    protected final void setFocusedRow(ListRow listRow) {
        this.focusedRow = listRow;
    }

    public final int getCursorPosition() {
        return this.cursorPosition;
    }

    protected final void setCursorPosition(int n) {
        this.cursorPosition = n;
    }

    public final long getOpenedAnchorId() {
        return this.openedAnchorId;
    }

    public final void setOpenedAnchorId(long l) {
        this.openedAnchorId = l;
    }

    public final int getWindowId() {
        return this.windowId;
    }

    public final void setWindowId(int n) {
        this.windowId = n;
    }

    public final LogChannel getLogChannel() {
        return this.logCh;
    }

    public final DynamicListModelApp getListModel() {
        return this.listModel;
    }

    public final ChoiceModelApp getListAvailableModel() {
        return this.listAvailableModel;
    }

    protected final void initValues() {
        this.setFocusedRow(null);
        this.setCursorPosition(0);
        this.setOpenedAnchorId(this.getInitAnchorId());
    }

    public void itemSelected(HMIModelApp hMIModelApp, ListRow listRow, int n, boolean bl) {
        this.getLogChannel().log(-2137614336, "AbstractHierarchyListManager#itemSelected(%1)", (Object)listRow);
        AbstractHierarchyListRow abstractHierarchyListRow = (AbstractHierarchyListRow)listRow;
        if (abstractHierarchyListRow.isHasChildren()) {
            if (abstractHierarchyListRow.getUid() == this.getOpenedAnchorId()) {
                this.setOpenedAnchorId(this.getInitAnchorId());
            } else {
                this.setOpenedAnchorId(abstractHierarchyListRow.getUid());
            }
            this.requestWindow(abstractHierarchyListRow, bl);
            if (this.waitingModel != null) {
                this.setWaitingModelTo(1);
                hMIModelApp.fireEvent(n);
            }
        } else if (abstractHierarchyListRow.isHasDetails()) {
            abstractHierarchyListRow.queryDetails();
            this.setWaitingModelTo(0);
            hMIModelApp.fireEvent(n);
        }
    }

    protected void signalListCalculating() {
        this.getLogChannel().log(-2137614336, "AbstractHierarchyListManager#signalListCalculating()");
        if (this.listAvailableModel != null) {
            this.listAvailableModel.setValue(-1);
            this.listAvailableModel.setStatus(0);
        }
    }

    protected void signalListAvailable() {
        this.getLogChannel().log(-2137614336, "AbstractHierarchyListManager#signalListAvailable()");
        if (this.listAvailableModel != null) {
            this.listAvailableModel.setValue(1);
            this.listAvailableModel.setStatus(1);
        }
    }

    protected final void signalListNotAvailable() {
        this.getLogChannel().log(-2137614336, "AbstractHierarchyListManager#signalListNotAvailable()");
        if (this.listAvailableModel != null) {
            this.listAvailableModel.setValue(-1);
            this.listAvailableModel.setStatus(1);
        }
    }

    protected final void setWaitingModelTo(int n) {
        if (this.waitingModel != null) {
            this.getLogChannel().log(-2137614336, "AbstractHierarchyListManager#setWaitingModelTo( %1 )", (long)n);
            this.waitingModel.setValue(n);
        }
    }

    public final void resetModels() {
        this.signalListNotAvailable();
        this.listModel.beginTransaction();
        this.listModel.clear();
        this.listModel.endTransaction();
    }

    protected void getRowsAroundFocusedRow(ListRow listRow, List list, int n, int n2) {
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Find out possible Ids for requesting new window, row: %1", (Object)listRow);
        ListRow listRow2 = listRow;
        int n3 = 0;
        while (n3 != n2) {
            ListRow listRow3 = null;
            if (n == -1) {
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Asking for previous row...");
                listRow3 = this.listModel.getPreviousRow(listRow2);
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Previous row: %1", (Object)listRow3);
            } else {
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Asking for next row...");
                listRow3 = this.listModel.getNextRow(listRow2);
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Next row: %1 ", (Object)listRow3);
            }
            if (listRow3 != null) {
                listRow2 = listRow3;
                list.add(listRow3);
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - Row with ID '%1' found, counter: %2", ((AbstractHierarchyListRow)listRow3).getUid(), (long)(++n3));
                continue;
            }
            this.logCh.log(-2137614336, "AbstractHierarchyListManager#getRowsAroundFocusedRow() - No next rows available!");
            break;
        }
    }

    private long[] getAnchorIdList(ListRow listRow) {
        ArrayList arrayList = new ArrayList(4);
        this.getRowsAroundFocusedRow(listRow, arrayList, 1, 2);
        this.getRowsAroundFocusedRow(listRow, arrayList, -1, 2);
        int n = arrayList.size();
        long[] lArray = new long[n + 1];
        Buffer buffer = new Buffer(50);
        lArray[0] = ((AbstractHierarchyListRow)listRow).getUid();
        buffer.append(lArray[0]);
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(", ");
            lArray[i2 + 1] = ((AbstractHierarchyListRow)arrayList.get(i2)).getUid();
            buffer.append(lArray[i2 + 1]);
        }
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#getAnchorIdList() - anchor IDs: %1", (Object)buffer);
        return lArray;
    }

    public void requestWindow(ListRow listRow, boolean bl) {
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#requestWindow()");
        if (listRow == null) {
            ListRow listRow2 = this.getFocusedRow();
            if (listRow2 == null) {
                this.logCh.log(-2137614336, "AbstractHierarchyListManager#requestWindow() - request initial window");
                this.requestInitialWindow();
                return;
            }
            this.logCh.log(-2137614336, "AbstractHierarchyListManager#requestWindow() - request window for row %1", (Object)listRow2);
            listRow = listRow2;
        }
        if (bl) {
            this.requestWindow(this.getAnchorIdList(listRow), this.openedAnchorId);
        } else {
            this.requestWindow(((AbstractHierarchyListRow)listRow).getUid(), this.openedAnchorId);
        }
    }

    protected void removeElements() {
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#removeElements()");
        ListRow[] listRowArray = this.listModel.getRows(this.dfltComparator);
        int n = 0;
        for (int i2 = 0; i2 < listRowArray.length; ++i2) {
            if (!((AbstractHierarchyListRow)listRowArray[i2]).isEntryPassed()) continue;
            ++n;
        }
        if (n > 0) {
            int n2;
            ListRow listRow = this.getFocusedRow();
            int n3 = this.getCursorPosition();
            int n4 = -1;
            boolean bl = ((AbstractHierarchyListRow)this.listModel.getFirstRow()).isBorder();
            boolean bl2 = ((AbstractHierarchyListRow)this.listModel.getLastRow()).isBorder();
            int n5 = this.listModel.getListLength();
            this.listModel.clear();
            ListRow[] listRowArray2 = new ListRow[listRowArray.length - n];
            int n6 = 0;
            for (n2 = 0; n2 < listRowArray.length; ++n2) {
                if (listRowArray[n2] == listRow) {
                    n4 = n6;
                }
                if (((AbstractHierarchyListRow)listRowArray[n2]).isEntryPassed()) continue;
                listRowArray2[n6++] = listRowArray[n2];
            }
            this.listModel.fill(listRowArray2, 0);
            this.listModel.setListLength(n5 - n);
            n2 = 0;
            if (bl) {
                n2 |= 1;
            }
            if (bl2) {
                n2 |= 2;
            }
            this.setListThresholds(this.listModel, listRowArray2.length, n2);
            if (n4 != -1) {
                n4 = Math.min(n4, listRowArray2.length - 1);
                this.listModel.setFocusedCursorPosition(listRowArray2[n4], n3);
            }
        }
    }

    protected ListRow[] getListModelRows() {
        return this.listModel.getRows(this.dfltComparator);
    }

    AbstractHierarchyListRow getRowForID(long l) {
        ListRow[] listRowArray = this.getListModelRows();
        for (int i2 = 0; i2 < listRowArray.length; ++i2) {
            if (((AbstractHierarchyListRow)listRowArray[i2]).getUid() != l) continue;
            return (AbstractHierarchyListRow)listRowArray[i2];
        }
        return null;
    }

    protected int getRowIndexForID(long l) {
        ListRow[] listRowArray = this.getListModelRows();
        for (int i2 = 0; i2 < listRowArray.length; ++i2) {
            if (((AbstractHierarchyListRow)listRowArray[i2]).getUid() != l) continue;
            return i2;
        }
        return -1;
    }

    protected void setListThresholds(DynamicListModelApp dynamicListModelApp, int n, int n2) {
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#setListThresholds()");
        int n3 = n / 3;
        int n4 = n - n3;
        if ((n2 & 1) != 0) {
            n3 = -1;
        }
        if ((n2 & 2) != 0) {
            n4 = -1;
        }
        this.logCh.log(-2137614336, "AbstractHierarchyListManager#setListThresholds() - setting thresholds %1, %2", (long)n3, (long)n4);
        dynamicListModelApp.setThreshold(n3, n4);
    }

    protected abstract long getInitAnchorId() {
    }

    protected abstract void requestInitialWindow() {
    }

    protected abstract void requestWindow(long l, long l2) {
    }

    protected abstract void requestWindow(long[] lArray, long l) {
    }
}

