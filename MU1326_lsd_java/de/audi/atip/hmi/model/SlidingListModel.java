/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractListModel;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.SlidingListModelListener;
import de.audi.atip.hmi.modelaccess.SlidingListModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelGUI;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SlidingListModel
extends AbstractListModel
implements SlidingListModelApp,
SlidingListModelGUI {
    private boolean hmiWaitsForNextData;
    private boolean hmiWaitsForPreviousData;
    private boolean waitingForDataAtEnd;
    private boolean waitingForDataAtStart;
    private int minBufferSize;
    private int minOffset;
    private int missingAtEnd;
    private int missingAtStart;
    private int visibleIndex = -1;
    private boolean resetCursorPos;

    public SlidingListModel(int n) {
        super(n, 0, new LinkedList(), 5);
        this.init(5);
    }

    public SlidingListModel(int n, int n2) {
        super(n, 0, new LinkedList(), n2);
        this.init(n2);
    }

    public SlidingListModel(int n, int n2, int n3) {
        super(n, n2, new LinkedList(), n3);
        this.init(n3);
    }

    @Override
    public void setRowsPerScreen(int n) {
        super.setRowsPerScreen(n);
        this.init(n);
    }

    private void init(int n) {
        this.minOffset = 2 * n;
        this.setBufferSize(5 * n);
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
            buffer.append("\ncontainsEndOfList: ");
            buffer.append(this.containsEndOfList);
            buffer.append("\ncontainsStartOfList: ");
            buffer.append(this.containsStartOfList);
            buffer.append("\nhmiWaitsForNextData: ");
            buffer.append(this.hmiWaitsForNextData);
            buffer.append("\nhmiWaitsForPreviousData: ");
            buffer.append(this.hmiWaitsForPreviousData);
            buffer.append("\nwaitingForDataAtEnd: ");
            buffer.append(this.waitingForDataAtEnd);
            buffer.append("\nwaitingForDataAtStart: ");
            buffer.append(this.waitingForDataAtStart);
            buffer.append("\nminBufferSize: ");
            buffer.append(this.minBufferSize);
            buffer.append("\nminOffset: ");
            buffer.append(this.minOffset);
            buffer.append("\nmissingAtEnd: ");
            buffer.append(this.missingAtEnd);
            buffer.append("\nmissingAtStart: ");
            buffer.append(this.missingAtStart);
            buffer.append("\nvisibleIndex: ");
            buffer.append(this.visibleIndex);
            buffer.append("\nresetCursorPos: ");
            buffer.append(this.resetCursorPos);
            buffer.append("\nSlidingListModelListener: ");
            buffer.append(this.listener);
        }
        return buffer.toString();
    }

    @Override
    public void setListListener(SlidingListModelListener slidingListModelListener) {
        this.listener = slidingListModelListener != null ? slidingListModelListener : DUMMY_LISTENER;
    }

    @Override
    protected void copy(AbstractModel abstractModel) {
        throw new UnsupportedOperationException("SlidingListModel is not buffered!");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void appendAtEnd(ListRow[] listRowArray, boolean bl) {
        if (listRowArray == null) {
            this.lc.log(10000, "(%1) SlidingListModel.appendAtEnd() Parameter rows is null! ", (long)this.id);
            return;
        }
        this.lc.log(-2137614336, "(%3) SlidingListModel.appendAtEnd( %2, %1 ) ", (Object)bl, (long)listRowArray.length, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            if (this.missingAtEnd == 0) {
                this.lc.log(-1601830656, "(%1) SlidingListModel.appendAtEnd() Not waiting for new list elements - rejecting new elements. ", (long)this.id);
                return;
            }
            this.missingAtEnd -= listRowArray.length;
            if (this.missingAtEnd < 0 || bl) {
                this.missingAtEnd = 0;
            }
            this.list.addAll(Arrays.asList(listRowArray));
            this.containsEndOfList = bl;
            this.trimAtStart();
            this.hmiWaitsForNextData = false;
            this.waitingForDataAtEnd = false;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(12);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void appendAtStart(ListRow[] listRowArray, boolean bl) {
        if (listRowArray == null) {
            this.lc.log(10000, "(%1) SlidingListModel.appendAtStart() Parameter rows is null! ", (long)this.id);
            return;
        }
        this.lc.log(-2137614336, "(%3) SlidingListModel.appendAtStart( %2, %1 ) ", (Object)bl, (long)listRowArray.length, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            if (this.missingAtStart == 0) {
                this.lc.log(-1601830656, "(%1) SlidingListModel.appendAtStart() Not waiting for new list elements - rejecting new elements. ", (long)this.id);
                return;
            }
            this.missingAtStart -= listRowArray.length;
            if (this.missingAtStart < 0 || bl) {
                this.missingAtStart = 0;
            }
            this.list.addAll(0, Arrays.asList(listRowArray));
            this.containsStartOfList = bl;
            this.listCursor += listRowArray.length;
            this.trimAtEnd();
            this.hmiWaitsForPreviousData = false;
            this.waitingForDataAtStart = false;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(12);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        this.lc.log(-2137614336, "(%1) SlidingListModel.clear() ", (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.visibleIndex = -1;
            this.missingAtStart = 0;
            this.missingAtEnd = 0;
            this.waitingForDataAtStart = false;
            this.waitingForDataAtEnd = false;
            super.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remove(ListRow listRow) {
        boolean bl;
        this.lc.log(-2137614336, "(%2) SlidingListModel.remove( %1 ) ", (Object)listRow, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            int n = this.list.indexOf(listRow);
            if (n < 0) {
                this.lc.log(-2137614336, "(%2) SlidingListModel.remove( %1 ) Row to be removed not found. ", (Object)listRow, (long)this.id);
                return;
            }
            this.list.remove(n);
            if (n > this.listCursor + this.getVisibleRowsCount()) {
                bl = false;
            } else if (n < this.listCursor) {
                --this.listCursor;
                bl = false;
            } else {
                bl = true;
            }
            this.stateChanged();
        }
        if (bl) {
            this.fireModelUpdateEvent(12);
        }
    }

    @Override
    public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, byte by, int n2) {
        int n3;
        if (this.lc.isDebug()) {
            Buffer buffer = new Buffer(100);
            buffer.append("rows:").append(listRowArray.length);
            buffer.append(" startOfList:").append(bl);
            buffer.append(" endOfList:").append(bl2);
            buffer.append(" bufferSize:").append(n);
            buffer.append(" visibleContext:").append(by);
            buffer.append(" line:").append(n2);
            this.lc.log(-2137614336, "(%2) [SlidingListModel.set] %1", (Object)buffer, (long)this.id);
        }
        this.fill(listRowArray, bl, bl2, n);
        this.lineNumber = n2;
        if (by == 1 && (n3 = listRowArray.length - this.getVisibleRowsCount()) > 0) {
            this.moveContext(n3);
        }
        this.fillFinished();
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    @Override
    public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, byte by, int n2, ListRow listRow, int n3) {
        int n4;
        if (this.lc.isDebug()) {
            Buffer buffer = new Buffer(100);
            buffer.append("rows:").append(listRowArray.length);
            buffer.append(" startOfList:").append(bl);
            buffer.append(" endOfList:").append(bl2);
            buffer.append(" bufferSize:").append(n);
            buffer.append(" visibleContext:").append(by);
            buffer.append(" line:").append(n2);
            buffer.append(" focusedRow:").append(listRow);
            buffer.append(" focusedIndex:").append(n3);
            this.lc.log(-2137614336, "(%2) [SlidingListModel.set] %1", (Object)buffer, (long)this.id);
        }
        this.fill(listRowArray, bl, bl2, n);
        this.lineNumber = n2;
        if (by == 1 && (n4 = listRowArray.length - this.getVisibleRowsCount()) > 0) {
            this.moveContext(n4);
        }
        this.fillFinished();
        this.setFocusedCursorPosition(listRow, n3);
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    @Override
    public void set(ListRow[] listRowArray, boolean bl, boolean bl2, int n, int n2) {
        if (this.lc.isDebug()) {
            Buffer buffer = new Buffer(100);
            buffer.append("rows:").append(listRowArray.length);
            buffer.append(" startOfList:").append(bl);
            buffer.append(" endOfList:").append(bl2);
            buffer.append(" bufferSize:").append(n);
            buffer.append(" line:").append(n2);
            this.lc.log(-2137614336, "(%2) [SlidingListModel.set] %1", (Object)buffer, (long)this.id);
        }
        this.fill(listRowArray, bl, bl2, n);
        this.lineNumber = n2;
        this.fillFinished();
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    @Override
    public void setListEnd(boolean bl, boolean bl2) {
        this.containsStartOfList = bl;
        this.containsEndOfList = bl2;
        this.fillFinished();
        this.stateChanged();
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    @Override
    public void setListEnd2(boolean bl, boolean bl2) {
        if (bl) {
            this.containsStartOfList = bl2;
        } else {
            this.containsEndOfList = bl2;
        }
        this.fillFinished();
        this.stateChanged();
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRows(ListRow[] listRowArray) {
        boolean bl = false;
        ArrayList arrayList = new ArrayList(Arrays.asList(listRowArray));
        Object object = this.mutex;
        synchronized (object) {
            int n = this.list.size();
            block3: for (int i2 = 0; i2 < n; ++i2) {
                ListRow listRow = (ListRow)this.list.get(i2);
                if (arrayList.isEmpty()) break;
                int n2 = arrayList.size();
                for (int i3 = 0; i3 < n2; ++i3) {
                    ListRow listRow2 = (ListRow)arrayList.get(i3);
                    if (!listRow.equals(listRow2)) continue;
                    this.list.set(i2, listRow2);
                    arrayList.remove(i3);
                    if (i2 >= this.listCursor && i2 < this.listCursor + this.getVisibleRowsCount()) {
                        bl = true;
                    }
                    this.stateChanged();
                    continue block3;
                }
            }
        }
        if (bl) {
            this.fireModelUpdateEvent(12);
        }
    }

    @Override
    public void resetCursorPosition(boolean bl) {
        this.resetCursorPos = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getSelected() {
        Object object = this.mutex;
        synchronized (object) {
            return this.visibleIndex;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, int n3) {
        ListRow listRow;
        int n4;
        Object object = this.mutex;
        synchronized (object) {
            super.itemFocused(n, n2, n3);
            n4 = this.focusOffset + n;
            listRow = this.getFocusedRow();
        }
        this.lc.log(-2137614336, "(%3) SlidingListModel.itemFocused( %2 ) = %1 ", (Object)listRow, (long)n, (long)this.id);
        try {
            this.listener.itemFocused(this.id, listRow, n4, n3);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(int n, int n2, int n3) {
        ListRow listRow;
        Object object = this.mutex;
        synchronized (object) {
            this.visibleIndex = n;
            listRow = n == -1 ? null : this.get(this.listCursor + n);
        }
        this.lc.log(-2137614336, "(%3) SlidingListModel.itemSelected( %2 ) = %1 ", (Object)listRow, (long)n, (long)this.id);
        if (listRow != null) {
            try {
                this.listener.itemSelected(this.id, listRow, n3);
            }
            catch (Exception exception) {
                this.handleListenerException(exception);
            }
        }
    }

    @Override
    public boolean isEndOfList(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.containsStartOfList && !this.containsEndOfList) {
                this.lc.log(-2137614336, "(%2) SlidingListModel.isEndOfList( %1 ) = false ", (long)n, (long)this.id);
                return false;
            }
            int n2 = this.getRowsAvailable(n);
            switch (n) {
                case -1: {
                    return this.isPreviousContextEndOfList(n2);
                }
                case 0: {
                    return this.isCurrentContextEndOfList(n2);
                }
                case 1: {
                    return this.isNextContextEndOfList(n2);
                }
            }
            throw new IllegalArgumentException(new StringBuffer().append("(").append(this.id).append(") SlidingListModel.isEndOfList( ").append(n).append(" ) Unknown context!").toString());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void moveContext(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.listCursor + n < 0) {
                throw new IllegalArgumentException(new StringBuffer().append("Moving context by ").append(n).append(" not allowed!").toString());
            }
            if (this.listCursor + n > this.list.size()) {
                throw new IllegalArgumentException(new StringBuffer().append("Moving context by ").append(n).append(" not allowed!").toString());
            }
            super.moveContext(n);
            this.visibleIndex = 0;
            int n2 = this.getRowsAvailable(1);
            if (!this.containsEndOfList && n2 < this.getVisibleRowsCount()) {
                this.hmiWaitsForNextData = true;
            }
            int n3 = this.getRowsAvailable(-1);
            if (!this.containsStartOfList && n3 < this.getVisibleRowsCount()) {
                this.hmiWaitsForPreviousData = true;
            }
        }
        this.requestRowsAtStart();
        this.requestRowsAtEnd();
    }

    @Override
    public boolean isCursorPositionReset() {
        if (this.resetCursorPos) {
            this.resetCursorPos = false;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void fill(ListRow[] listRowArray, boolean bl, boolean bl2, int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.clear();
            this.setBufferSize(n);
            this.list.addAll(Arrays.asList(listRowArray));
            this.containsStartOfList = bl;
            this.containsEndOfList = bl2;
            this.listCursor = 0;
            this.visibleIndex = 0;
            this.stateChanged();
        }
    }

    private void fillFinished() {
        this.fireModelUpdateEvent(12);
        this.setStatus(1);
    }

    private boolean isNextContextEndOfList(int n) {
        boolean bl = false;
        if (this.containsEndOfList) {
            if (n < this.getVisibleRowsCount()) {
                bl = true;
            } else if (this.listCursor + 2 * this.getVisibleRowsCount() - 1 == this.list.size() - 1) {
                bl = true;
            }
        }
        this.lc.log(-2137614336, "(%2) SlidingListModel.isEndOfList( CONTEXT_NEXT ) = %1 ", bl, (long)this.id);
        return bl;
    }

    private boolean isPreviousContextEndOfList(int n) {
        boolean bl = false;
        if (this.containsStartOfList) {
            if (n < this.getVisibleRowsCount()) {
                bl = true;
            } else if (this.listCursor - this.getVisibleRowsCount() == 0) {
                bl = true;
            }
        }
        this.lc.log(-2137614336, "(%2) SlidingListModel.isEndOfList( CONTEXT_PREVIOUS ) = %1 ", bl, (long)this.id);
        return bl;
    }

    private boolean isCurrentContextEndOfList(int n) {
        boolean bl = false;
        if (n < this.getVisibleRowsCount()) {
            bl = true;
        } else if (this.containsStartOfList && this.listCursor == 0) {
            bl = true;
        } else if (this.containsEndOfList && this.listCursor + this.getVisibleRowsCount() - 1 == this.list.size() - 1) {
            bl = true;
        }
        this.lc.log(-2137614336, "(%2) SlidingListModel.isEndOfList( CONTEXT_CURRENT ) = %1 ", bl, (long)this.id);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestRowsAtEnd() {
        ListRow listRow;
        int n;
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForDataAtEnd) {
                return;
            }
            if (this.containsEndOfList) {
                return;
            }
            if (this.missingAtEnd > 0) {
                return;
            }
            int n2 = this.list.size() - this.listCursor;
            if (n2 >= this.minOffset) {
                return;
            }
            this.missingAtEnd = this.minOffset - n2;
            this.waitingForDataAtEnd = true;
            n = this.missingAtEnd;
            listRow = this.getLastRow();
        }
        try {
            ((SlidingListModelListener)this.listener).requestRowsAfter(this.id, listRow, n, this.getTerminalID());
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void requestRowsAtStart() {
        ListRow listRow;
        int n;
        Object object = this.mutex;
        synchronized (object) {
            if (this.waitingForDataAtStart) {
                return;
            }
            if (this.list.size() == 0) {
                return;
            }
            if (this.containsStartOfList) {
                return;
            }
            if (this.listCursor >= this.minOffset) {
                return;
            }
            this.missingAtStart = this.minOffset - this.listCursor;
            this.waitingForDataAtStart = true;
            n = this.missingAtStart;
            listRow = this.getFirstRow();
        }
        try {
            ((SlidingListModelListener)this.listener).requestRowsBefore(this.id, listRow, n, this.getTerminalID());
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void setBufferSize(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n > this.list.size()) {
                this.minBufferSize = n;
            }
        }
    }

    private void trimAtStart() {
        if (this.list.size() < 2 * this.minBufferSize) {
            return;
        }
        if (this.missingAtStart > 0) {
            return;
        }
        int n = this.listCursor - this.minOffset;
        if (n <= 0) {
            return;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            this.list.remove(0);
        }
        this.listCursor -= n;
        this.containsStartOfList = false;
    }

    private void trimAtEnd() {
        if (this.list.size() < 2 * this.minBufferSize) {
            return;
        }
        if (this.missingAtEnd > 0) {
            return;
        }
        int n = this.listCursor + this.getVisibleRowsCount() + this.minOffset;
        if (n >= this.list.size()) {
            return;
        }
        int n2 = this.list.size() - n;
        for (int i2 = 0; i2 < n2; ++i2) {
            this.list.remove(this.list.size() - 1);
        }
        this.containsEndOfList = false;
    }
}

