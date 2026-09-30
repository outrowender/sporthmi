/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.BufferedAbstractModel;
import de.audi.atip.hmi.model.DynamicListModel;
import de.audi.atip.hmi.model.DynamicListModelListener;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ListRowComparator;
import de.audi.atip.hmi.modelaccess.DynamicListModelApp;
import de.audi.atip.hmi.modelaccess.SlidingListModelGUI;

public class BufferedDynamicListModel
extends BufferedAbstractModel
implements DynamicListModelApp,
SlidingListModelGUI {
    private final DynamicListModel mainModel;
    private final DynamicListModel tmpModel;
    private DynamicListModel activeModel;

    public BufferedDynamicListModel(int n, int n2) {
        super(new DynamicListModel(n, n2), new DynamicListModel(n, n2));
        this.mainModel = (DynamicListModel)this.mainAbstractModel;
        this.tmpModel = (DynamicListModel)this.tmpAbstractModel;
        this.activeModel = this.mainModel;
    }

    public BufferedDynamicListModel(int n) {
        super(new DynamicListModel(n, 10), new DynamicListModel(n, 10));
        this.mainModel = (DynamicListModel)this.mainAbstractModel;
        this.tmpModel = (DynamicListModel)this.tmpAbstractModel;
        this.activeModel = this.mainModel;
    }

    public BufferedDynamicListModel(int n, int n2, int n3) {
        super(new DynamicListModel(n, n2, n3), new DynamicListModel(n, n2, n3));
        this.mainModel = (DynamicListModel)this.mainAbstractModel;
        this.tmpModel = (DynamicListModel)this.tmpAbstractModel;
        this.activeModel = this.mainModel;
    }

    public int getLowerThreshold() {
        return this.activeModel.getLowerThreshold();
    }

    public int getUpperThreshold() {
        return this.activeModel.getUpperThreshold();
    }

    public void beginTransaction() throws IllegalStateException {
        super.beginTransaction();
        this.activeModel = this.tmpModel;
    }

    public void abortTransaction() {
        super.abortTransaction();
        this.tmpModel.clear();
        this.activeModel = this.mainModel;
    }

    public void endTransaction() {
        super.endTransaction();
        this.activeModel = this.mainModel;
        this.mainModel.fireModelUpdateEvent(12);
        this.tmpModel.clear();
    }

    public void setRowsPerScreen(int n) {
        this.activeModel.setRowsPerScreen(n);
        this.tmpModel.setRowsPerScreen(n);
    }

    public void clear() {
        this.activeModel.clear();
    }

    public void enableFastScrolling(boolean bl) {
        this.activeModel.enableFastScrolling(bl);
    }

    public void setMaxColumns(int n) {
        this.activeModel.setMaxColumns(n);
    }

    public void fill(ListRow[] listRowArray, int n) {
        this.activeModel.fill(listRowArray, n);
    }

    public int getVisibleRowsCount() {
        return this.activeModel.getVisibleRowsCount();
    }

    public ListRow getRow(ListRowComparator listRowComparator) {
        return this.activeModel.getRow(listRowComparator);
    }

    public ListRow[] getRows(ListRowComparator listRowComparator) {
        return this.activeModel.getRows(listRowComparator);
    }

    public boolean setFocusedCursorPosition(ListRow listRow, int n) {
        return this.activeModel.setFocusedCursorPosition(listRow, n);
    }

    public void setListLength(int n) {
        this.activeModel.setListLength(n);
    }

    public ListRow getFirstRow() {
        return this.activeModel.getFirstRow();
    }

    public ListRow getLastRow() {
        return this.activeModel.getLastRow();
    }

    public ListRow getNextRow(ListRow listRow) {
        return this.activeModel.getNextRow(listRow);
    }

    public ListRow getPreviousRow(ListRow listRow) {
        return this.activeModel.getPreviousRow(listRow);
    }

    public ListRow getVisibleRow(int n) {
        return this.activeModel.getVisibleRow(n);
    }

    public void setListListener(DynamicListModelListener dynamicListModelListener) {
        this.mainModel.setListListener(dynamicListModelListener);
        this.tmpModel.setListListener(dynamicListModelListener);
    }

    public void setSelected(ListRow listRow) {
        this.activeModel.setSelected(listRow);
    }

    public void setThreshold(int n, int n2) {
        this.activeModel.setThreshold(n, n2);
    }

    public void jumpToEndOfListSupported(boolean bl) {
        this.activeModel.jumpToEndOfListSupported(bl);
    }

    public void jumpToStartOfListSupported(boolean bl) {
        this.activeModel.jumpToStartOfListSupported(bl);
    }

    public boolean contains(ListRow listRow) {
        return this.activeModel.contains(listRow);
    }

    public boolean updateRow(ListRow listRow) {
        return this.activeModel.updateRow(listRow);
    }

    public ListCell getCell(int n, int n2) {
        return this.mainModel.getCell(n, n2);
    }

    public Class getColumnType(int n) {
        return this.mainModel.getColumnType(n);
    }

    public int getLength() {
        return this.mainModel.getLength();
    }

    public int getMaxColumns() {
        return this.mainModel.getMaxColumns();
    }

    public int getMaxRows() {
        return this.mainModel.getMaxRows();
    }

    public boolean getRow(int n, ListCell[] listCellArray) {
        return this.mainModel.getRow(n, listCellArray);
    }

    public int getSelected() {
        return this.mainModel.getSelected();
    }

    public void itemFocused(int n, int n2, int n3) {
        this.mainModel.itemFocused(n, n2, n3);
    }

    public void itemSelected(int n, int n2, int n3) {
        this.mainModel.itemSelected(n, n2, n3);
    }

    public void itemReleased(int n, int n2, int n3) {
        this.mainModel.itemReleased(n, n2, n3);
    }

    public void setFocusOffset(int n) {
        this.mainModel.setFocusOffset(n);
    }

    public int getFocusedCursorPosition() {
        return this.mainModel.getFocusedCursorPosition();
    }

    public boolean isFastScrollingEnabled() {
        return this.mainModel.isFastScrollingEnabled();
    }

    public int getRowsAvailable(int n) {
        return this.mainModel.getRowsAvailable(n);
    }

    public boolean isCursorPositionReset() {
        return this.mainModel.isCursorPositionReset();
    }

    public boolean isEndOfList(int n) {
        return this.mainModel.isEndOfList(n);
    }

    public int getEndOfListState(int n) {
        return this.mainModel.getEndOfListState(n);
    }

    public boolean isJumpingToEndOfListSupported() {
        return this.mainModel.isJumpingToEndOfListSupported();
    }

    public boolean isJumpingToStartOfListSupported() {
        return this.mainModel.isJumpingToStartOfListSupported();
    }

    public void jumpToEndOfList(int n) {
        this.mainModel.jumpToEndOfList(n);
    }

    public void jumpToStartOfList(int n) {
        this.mainModel.jumpToStartOfList(n);
    }

    public void moveContext(int n) throws IllegalArgumentException {
        this.mainModel.moveContext(n);
    }

    public void setVisibleRows(int n) {
        this.mainModel.setVisibleRows(n);
    }

    public void setFirstScreenOffset(int n) {
        this.mainModel.setFirstScreenOffset(n);
    }

    public void scrollingActive(boolean bl, int n) {
        this.activeModel.scrollingActive(bl, n);
    }

    public boolean getRowFromNextContext(int n, ListCell[] listCellArray) {
        return this.activeModel.getRowFromNextContext(n, listCellArray);
    }

    public boolean getRowFromPreviousContext(int n, ListCell[] listCellArray) {
        return this.activeModel.getRowFromPreviousContext(n, listCellArray);
    }

    public int getListLength() {
        return this.activeModel.getListLength();
    }

    public int getLineNumber() {
        return this.activeModel.getLineNumber();
    }

    public int getFocusedCursorPositionOffset() {
        return this.activeModel.getFocusedCursorPositionOffset();
    }
}

