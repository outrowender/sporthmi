/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModelListener;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ListRowComparator;
import de.audi.atip.hmi.modelaccess.SlidingListModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractListModel
extends AbstractModel
implements SlidingListModelGUI {
    static final int UNDEFINED;
    List list;
    private int visibleRows;
    int listCursor = -1;
    int focusOffset;
    int listCursorOffset = 0;
    boolean containsEndOfList = true;
    boolean containsStartOfList = true;
    protected volatile AbstractListModelListener listener = DUMMY_LISTENER;
    private int maxColumns = -1;
    private int focusedCursorPosition;
    private boolean jumpingToStartOfListSupported;
    private boolean jumpingToEndOfListSupported;
    private int firstScreenOffset;
    private boolean fastScrollingActive;
    private int listLength;
    protected int lineNumber;

    AbstractListModel(int n, List list, int n2) {
        super(n, 0);
        this.list = list;
        this.visibleRows = n2;
    }

    AbstractListModel(int n, int n2, List list, int n3) {
        super(n, n2);
        this.list = list;
        this.visibleRows = n3;
    }

    @Override
    public void resetListener() {
        this.listener = DUMMY_LISTENER;
    }

    public void setRowsPerScreen(int n) {
        this.lc.log(-2137614336, "(%1) AbstractListModel.setRowsPerScreen( %2 )", (long)this.id, (long)n);
        this.visibleRows = n;
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
            if (this.list == null) {
                buffer.append("\nlist: null");
            } else {
                int n = this.list.size();
                buffer.append("\nlist.size(): ");
                buffer.append(n);
                for (int i2 = 0; i2 < n; ++i2) {
                    buffer.append("\nlist[");
                    buffer.append(i2);
                    buffer.append("]: ");
                    buffer.append(this.list.get(i2));
                }
            }
            buffer.append("\nvisibleRows: ");
            buffer.append(this.visibleRows);
            buffer.append("\nlistCursor: ");
            buffer.append(this.listCursor);
            buffer.append("\nfocusOffset: ");
            buffer.append(this.focusOffset);
            buffer.append("\nmaxColumns: ");
            buffer.append(this.maxColumns);
            buffer.append("\nfocusedCursorPosition: ");
            buffer.append(this.focusedCursorPosition);
            buffer.append("\njumpingToStartOfListSupported: ");
            buffer.append(this.jumpingToStartOfListSupported);
            buffer.append("\njumpingToEndOfListSupported: ");
            buffer.append(this.jumpingToEndOfListSupported);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow getVisibleRow(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.get(this.listCursor + n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ListRow get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n >= 0 && n < this.list.size()) {
                return (ListRow)this.list.get(n);
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    int getListIndex(ListRow listRow) {
        boolean bl;
        int n;
        if (listRow == null) {
            throw new IllegalArgumentException("Parameter 'ListRow' is null!");
        }
        Object object = this.mutex;
        synchronized (object) {
            if (listRow.index < 0 || listRow.index >= this.list.size() || !listRow.equals(this.list.get(listRow.index))) {
                n = this.list.indexOf(listRow);
                bl = true;
            } else {
                bl = false;
                n = listRow.index;
            }
        }
        if (bl) {
            this.lc.log(1078071040, "AbstractListModel.getListIndex(): List index stored in given ListRow is not valid! ");
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isVisible(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return n >= this.listCursor && n < this.listCursor + this.getVisibleRowsCount();
        }
    }

    public int getVisibleRowsCount() {
        if (this.visibleRows <= 0) {
            this.lc.log(-1601830656, "(%2) AbstractListModel.getVisibleRowsCount(): Invalid number of visible rows %1! ", (long)this.visibleRows, (long)this.id);
        }
        return this.visibleRows;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    List getVisibleRows() {
        try {
            Object object = this.mutex;
            synchronized (object) {
                return this.list.subList(this.listCursor, this.listCursor + this.getVisibleRowsCount());
            }
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ListRow getFocusedRow() {
        Object object = this.mutex;
        synchronized (object) {
            return this.get(this.listCursor + this.focusedCursorPosition - this.focusOffset);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.containsStartOfList = true;
            this.containsEndOfList = true;
            this.listCursor = -1;
            this.lineNumber = -1;
            this.focusedCursorPosition = 0;
            this.list.clear();
            this.stateChanged();
        }
    }

    public void jumpToStartOfListSupported(boolean bl) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.jumpToStartOfListSupported( %1 ) ", bl, (long)this.id);
        this.jumpingToStartOfListSupported = bl;
    }

    public void jumpToEndOfListSupported(boolean bl) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.jumpToEndOfListSupported( %1 ) ", bl, (long)this.id);
        this.jumpingToEndOfListSupported = bl;
    }

    public void setMaxColumns(int n) {
        this.maxColumns = n;
    }

    public void enableFastScrolling(boolean bl) {
        this.fastScrollingActive = bl;
    }

    @Override
    public boolean isFastScrollingEnabled() {
        return this.fastScrollingActive;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setFocusedCursorPosition(ListRow listRow, int n) {
        int n2;
        this.lc.log(-2137614336, "(%3) AbstractListModel.setFocusedCursorPosition( %1, %2 ) ", (Object)listRow, (long)n, (long)this.id);
        boolean bl = false;
        if (listRow == null) {
            this.lc.log(-1601830656, "(%3) AbstractListModel.setFocusedCursorPosition( %1, %2 ): Row to be focused is null! ", (Object)listRow, (long)n, (long)this.id);
            return false;
        }
        if (n < 0 || n >= this.getVisibleRowsCount()) {
            if (this.lc.isDebug()) {
                Buffer buffer = new Buffer(200).append("AbstractListModel.setFocusedCursorPosition( ").append(listRow).append(", ").append(n).append(" ): Given cursor position is out of range! cursorPos:").append(n).append(", visibleRowsCount:").append(this.getVisibleRowsCount());
                this.lc.log(-2137614336, "(%2) %1", (Object)buffer, (long)this.id);
            }
            return false;
        }
        Object object = this.mutex;
        synchronized (object) {
            n2 = this.list.indexOf(listRow);
            if (n2 != -1) {
                this.focusedCursorPosition = n;
                this.lineNumber -= this.listCursor;
                this.listCursor = n2 - n;
                if (this.listCursor < 0) {
                    this.focusedCursorPosition = n + this.listCursor;
                    this.listCursor = 0;
                }
                if (this.containsStartOfList) {
                    if (this.firstScreenOffset > 0 && n2 < this.getVisibleRowsCount()) {
                        this.focusedCursorPosition = n;
                        this.lc.log(-2137614336, "(%3) AbstractListModel.setFocusedCursorPosition visibleIndex(before): %1 listCursor(before): %2 ", (long)n, (long)this.listCursor, (long)this.id);
                        if (n - n2 > this.firstScreenOffset) {
                            bl = true;
                        } else {
                            this.focusedCursorPosition = n;
                            this.listCursorOffset = n2 - n;
                        }
                        this.lc.log(-2137614336, "(%3) AbstractListModel.setFocusedCursorPosition start of list, firstScreenOffset > 0 focusedCursorPosition: %1 listCursor: %2", (long)this.focusedCursorPosition, (long)this.listCursor, (long)this.id);
                    }
                } else {
                    this.listCursorOffset = 0;
                }
                this.lineNumber += this.listCursor;
            } else {
                this.lc.log(-2137614336, "(%3) AbstractListModel.setFocusedCursorPosition( %1, %2 ): Row to be focused not found in list! ", (Object)listRow, (long)n, (long)this.id);
                return false;
            }
        }
        if (bl) {
            this.lc.log(-2137614336, "(%1) AbstractListModel.setFocusedCursorPosition(): Correcting focused screen position to %2 ", (long)this.id, (long)this.focusedCursorPosition);
        }
        if (n2 != -1) {
            this.fireModelUpdateEvent(12, n);
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean contains(ListRow listRow) {
        boolean bl = false;
        if (listRow != null) {
            Object object = this.mutex;
            synchronized (object) {
                int n = this.list.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (!listRow.equals(this.list.get(i2))) continue;
                    bl = true;
                    break;
                }
            }
        }
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, new StringBuffer().append("(%2) AbstractListModel.contains( %1 ) = ").append(bl).toString(), (Object)listRow, (long)this.id);
        }
        return bl;
    }

    public ListRow getFirstRow() {
        return this.get(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow getLastRow() {
        Object object = this.mutex;
        synchronized (object) {
            return this.get(this.list.size() - 1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow getNextRow(ListRow listRow) {
        Object object = this.mutex;
        synchronized (object) {
            int n = this.getListIndex(listRow);
            if (n == -1) {
                return null;
            }
            int n2 = n + 1;
            if (n2 >= this.list.size()) {
                return null;
            }
            return this.get(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow getPreviousRow(ListRow listRow) {
        Object object = this.mutex;
        synchronized (object) {
            int n = this.getListIndex(listRow);
            if (n == -1) {
                return null;
            }
            int n2 = n - 1;
            if (n2 < 0) {
                return null;
            }
            return this.get(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow getRow(ListRowComparator listRowComparator) {
        Object object = this.mutex;
        synchronized (object) {
            int n = this.list.size();
            for (int i2 = 0; i2 < n; ++i2) {
                ListRow listRow = (ListRow)this.list.get(i2);
                if (!listRowComparator.equalsRow(listRow)) continue;
                return listRow;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListRow[] getRows(ListRowComparator listRowComparator) {
        ArrayList arrayList;
        Object object = this.mutex;
        synchronized (object) {
            int n = this.list.size();
            arrayList = new ArrayList(n);
            for (int i2 = 0; i2 < n; ++i2) {
                ListRow listRow = (ListRow)this.list.get(i2);
                if (!listRowComparator.equalsRow(listRow)) continue;
                arrayList.add(listRow);
            }
        }
        return (ListRow[])arrayList.toArray(new ListRow[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                AbstractListModel abstractListModel = (AbstractListModel)abstractModel;
                this.setStatus(abstractListModel.getStatus());
                this.listCursor = abstractListModel.listCursor;
                this.focusOffset = abstractListModel.focusOffset;
                this.containsEndOfList = abstractListModel.containsEndOfList;
                this.containsStartOfList = abstractListModel.containsStartOfList;
                this.maxColumns = abstractListModel.maxColumns;
                this.focusedCursorPosition = abstractListModel.focusedCursorPosition;
                this.listCursorOffset = abstractListModel.listCursorOffset;
                this.listLength = abstractListModel.listLength;
                this.lineNumber = abstractListModel.lineNumber;
                this.jumpingToStartOfListSupported = abstractListModel.jumpingToStartOfListSupported;
                this.jumpingToEndOfListSupported = abstractListModel.jumpingToEndOfListSupported;
                this.firstScreenOffset = abstractListModel.firstScreenOffset;
                this.fastScrollingActive = abstractListModel.fastScrollingActive;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) AbstractListModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    @Override
    public int getModelType() {
        return 10;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        boolean bl;
        Object object = this.mutex;
        synchronized (object) {
            bl = this.list.size() == 0;
        }
        this.lc.log(-2137614336, "(%2) AbstractListModel.isEmpty() = %1 ", bl, (long)this.id);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ListCell getCell(int n, int n2) {
        ListRow listRow;
        Object object = this.mutex;
        synchronized (object) {
            int n3 = this.listCursor + n;
            listRow = this.get(n3);
        }
        if (listRow != null) {
            return listRow.getCell(n2);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Class getColumnType(int n) {
        Object object = this.mutex;
        synchronized (object) {
            try {
                return this.get(0).getColumnType(n);
            }
            catch (Exception exception) {
                this.lc.log(-1601830656, "(%2) AbstractListModel.getColumnType( %1 ) Column not found or list empty! ", (long)n, (long)this.id);
                return null;
            }
        }
    }

    @Override
    public int getLength() {
        return this.getVisibleRowsCount();
    }

    @Override
    public int getMaxColumns() {
        return this.maxColumns;
    }

    @Override
    public int getMaxRows() {
        return this.getVisibleRowsCount();
    }

    @Override
    public boolean getRow(int n, ListCell[] listCellArray) {
        return this.getRow(this.listCursor, n, listCellArray);
    }

    @Override
    public boolean getRowFromPreviousContext(int n, ListCell[] listCellArray) {
        int n2 = this.listCursor - this.getVisibleRowsCount();
        return this.getRow(n2, n, listCellArray);
    }

    @Override
    public boolean getRowFromNextContext(int n, ListCell[] listCellArray) {
        int n2 = this.listCursor + this.getVisibleRowsCount();
        return this.getRow(n2, n, listCellArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean getRow(int n, int n2, ListCell[] listCellArray) {
        try {
            ListCell[] listCellArray2;
            Object object = this.mutex;
            synchronized (object) {
                int n3 = n + n2;
                listCellArray2 = this.get(n3).getCells();
            }
            System.arraycopy((Object)listCellArray2, 0, (Object)listCellArray, 0, listCellArray2.length);
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public abstract int getSelected() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setFocusOffset(int n) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.setFocusOffset( %1 ) ", (long)n, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.focusOffset = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, int n3) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.itemFocused( %1 ) ", (long)n, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.focusedCursorPosition = n + this.focusOffset;
            this.listCursorOffset = -this.focusOffset;
        }
    }

    @Override
    public abstract void itemSelected(int n, int n2, int n3) {
    }

    @Override
    public void itemReleased(int n, int n2, int n3) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getFocusedCursorPosition() {
        this.lc.log(-2137614336, "(%2) AbstractListModel.getFocusedCursorPosition() = %1 ", (long)this.focusedCursorPosition, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            return this.focusedCursorPosition;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getFocusedCursorPositionOffset() {
        this.lc.log(-2137614336, "(%2) getFocusedCursorPositionOffset() = %1 ", (long)this.listCursorOffset, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            return this.listCursorOffset;
        }
    }

    @Override
    public int getRowsAvailable(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.listCursor == -1) {
                return 0;
            }
            switch (n) {
                case 1: {
                    return this.getAvailableRowsInNextContext();
                }
                case -1: {
                    return this.getAvailableRowsInPreviousContext();
                }
                case 0: {
                    return this.getAvailableRowsInCurrentContext();
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("(").append(this.id).append(") AbstractListModel.getRowsAvailable( ").append(n).append(") Unknown context!").toString());
        }
    }

    @Override
    public boolean isCursorPositionReset() {
        return false;
    }

    @Override
    public abstract boolean isEndOfList(int n) {
    }

    @Override
    public boolean isJumpingToEndOfListSupported() {
        this.lc.log(-2137614336, "(%2) AbstractListModel.isJumpingToEndOfListSupported() = %1 ", this.jumpingToEndOfListSupported, (long)this.id);
        return this.jumpingToEndOfListSupported;
    }

    @Override
    public boolean isJumpingToStartOfListSupported() {
        this.lc.log(-2137614336, "(%2) AbstractListModel.isJumpingToStartOfListSupported() = %1 ", this.jumpingToStartOfListSupported, (long)this.id);
        return this.jumpingToStartOfListSupported;
    }

    @Override
    public void jumpToEndOfList(int n) {
        if (!this.jumpingToEndOfListSupported) {
            this.lc.log(-2137614336, "(%1) AbstractListModel.jumpToEndOfList() Not supported by application. ", (long)this.id);
            this.setStatus(1);
            return;
        }
        this.lc.log(-2137614336, "(%1) AbstractListModel.jumpToEndOfList() ==> Calling rebuildListFromEnd() ", (long)this.id);
        try {
            this.listener.rebuildListFromEnd(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    @Override
    public void jumpToStartOfList(int n) {
        if (!this.jumpingToStartOfListSupported) {
            this.lc.log(-2137614336, "(%1) AbstractListModel.jumpToStartOfList() Not supported by application. ", (long)this.id);
            this.setStatus(1);
            return;
        }
        this.lc.log(-2137614336, "(%1) AbstractListModel.jumpToEndOfList() ==> Calling rebuildListFromStart() ", (long)this.id);
        try {
            this.listener.rebuildListFromStart(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void moveContext(int n) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.moveContext( %1 ) ", (long)n, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.listCursor += n;
            this.lineNumber += n;
        }
    }

    @Override
    public void setVisibleRows(int n) {
        this.lc.log(1078071040, "(%2) AbstractListModel.setVisibleRows( %1 ) --> DEPRECATED ", (long)n, (long)this.id);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setFirstScreenOffset(int n) {
        this.lc.log(-2137614336, "(%2) AbstractListModel.setFirstScreenOffset( %1 ) ", (long)n, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.firstScreenOffset = n;
        }
    }

    @Override
    public void scrollingActive(boolean bl, int n) {
        try {
            this.listener.scrollingActive(this.id, bl, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    private int getAvailableRowsInPreviousContext() {
        int n = this.listCursor - this.getVisibleRowsCount();
        int n2 = n < 0 ? this.getVisibleRowsCount() + n : this.getVisibleRowsCount();
        this.lc.log(-2137614336, "(%2) AbstractListModel.getRowsAvailable( CONTEXT_PREVIOUS ) = %1 ", (long)n2, (long)this.id);
        return n2;
    }

    private int getAvailableRowsInNextContext() {
        int n;
        int n2 = this.listCursor + 2 * this.getVisibleRowsCount() - 1;
        int n3 = n2 >= this.list.size() ? ((n = this.list.size() + this.getVisibleRowsCount() - n2 - 1) > 0 ? n : 0) : this.getVisibleRowsCount();
        this.lc.log(-2137614336, "(%2) AbstractListModel.getRowsAvailable( CONTEXT_NEXT ) = %1 ", (long)n3, (long)this.id);
        return n3;
    }

    private int getAvailableRowsInCurrentContext() {
        int n = this.listCursor + this.getVisibleRowsCount() - 1;
        int n2 = n > this.list.size() ? this.list.size() + this.getVisibleRowsCount() - n - 1 : (n == this.list.size() ? n - this.listCursor : this.getVisibleRowsCount());
        this.lc.log(-2137614336, "(%2) AbstractListModel.getRowsAvailable( CONTEXT_CURRENT ) = %1 ", (long)n2, (long)this.id);
        return n2;
    }

    public void setListLength(int n) {
        this.listLength = n;
    }

    @Override
    public int getListLength() {
        return this.listLength;
    }

    @Override
    public int getLineNumber() {
        return this.lineNumber;
    }
}

