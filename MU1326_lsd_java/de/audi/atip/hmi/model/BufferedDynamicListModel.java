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

    @Override
    public void beginTransaction() {
        super.beginTransaction();
        this.activeModel = this.tmpModel;
    }

    @Override
    public void abortTransaction() {
        super.abortTransaction();
        this.tmpModel.clear();
        this.activeModel = this.mainModel;
    }

    @Override
    public void endTransaction() {
        super.endTransaction();
        this.activeModel = this.mainModel;
        this.mainModel.fireModelUpdateEvent(12);
        this.tmpModel.clear();
    }

    @Override
    public void setRowsPerScreen(int n) {
        this.activeModel.setRowsPerScreen(n);
        this.tmpModel.setRowsPerScreen(n);
    }

    @Override
    public void clear() {
        this.activeModel.clear();
    }

    @Override
    public void enableFastScrolling(boolean bl) {
        this.activeModel.enableFastScrolling(bl);
    }

    @Override
    public void setMaxColumns(int n) {
        this.activeModel.setMaxColumns(n);
    }

    @Override
    public void fill(ListRow[] listRowArray, int n) {
        this.activeModel.fill(listRowArray, n);
    }

    @Override
    public int getVisibleRowsCount() {
        return this.activeModel.getVisibleRowsCount();
    }

    @Override
    public ListRow getRow(ListRowComparator listRowComparator) {
        return this.activeModel.getRow(listRowComparator);
    }

    @Override
    public ListRow[] getRows(ListRowComparator listRowComparator) {
        return this.activeModel.getRows(listRowComparator);
    }

    @Override
    public boolean setFocusedCursorPosition(ListRow listRow, int n) {
        return this.activeModel.setFocusedCursorPosition(listRow, n);
    }

    @Override
    public void setListLength(int n) {
        this.activeModel.setListLength(n);
    }

    @Override
    public ListRow getFirstRow() {
        return this.activeModel.getFirstRow();
    }

    @Override
    public ListRow getLastRow() {
        return this.activeModel.getLastRow();
    }

    @Override
    public ListRow getNextRow(ListRow listRow) {
        return this.activeModel.getNextRow(listRow);
    }

    @Override
    public ListRow getPreviousRow(ListRow listRow) {
        return this.activeModel.getPreviousRow(listRow);
    }

    @Override
    public ListRow getVisibleRow(int n) {
        return this.activeModel.getVisibleRow(n);
    }

    @Override
    public void setListListener(DynamicListModelListener dynamicListModelListener) {
        this.mainModel.setListListener(dynamicListModelListener);
        this.tmpModel.setListListener(dynamicListModelListener);
    }

    @Override
    public void setSelected(ListRow listRow) {
        this.activeModel.setSelected(listRow);
    }

    @Override
    public void setThreshold(int n, int n2) {
        this.activeModel.setThreshold(n, n2);
    }

    @Override
    public void jumpToEndOfListSupported(boolean bl) {
        this.activeModel.jumpToEndOfListSupported(bl);
    }

    @Override
    public void jumpToStartOfListSupported(boolean bl) {
        this.activeModel.jumpToStartOfListSupported(bl);
    }

    @Override
    public boolean contains(ListRow listRow) {
        return this.activeModel.contains(listRow);
    }

    @Override
    public boolean updateRow(ListRow listRow) {
        return this.activeModel.updateRow(listRow);
    }

    @Override
    public ListCell getCell(int n, int n2) {
        return this.mainModel.getCell(n, n2);
    }

    @Override
    public Class getColumnType(int n) {
        return this.mainModel.getColumnType(n);
    }

    @Override
    public int getLength() {
        return this.mainModel.getLength();
    }

    @Override
    public int getMaxColumns() {
        return this.mainModel.getMaxColumns();
    }

    @Override
    public int getMaxRows() {
        return this.mainModel.getMaxRows();
    }

    @Override
    public boolean getRow(int n, ListCell[] listCellArray) {
        return this.mainModel.getRow(n, listCellArray);
    }

    @Override
    public int getSelected() {
        return this.mainModel.getSelected();
    }

    @Override
    public void itemFocused(int n, int n2, int n3) {
        this.mainModel.itemFocused(n, n2, n3);
    }

    @Override
    public void itemSelected(int n, int n2, int n3) {
        this.mainModel.itemSelected(n, n2, n3);
    }

    @Override
    public void itemReleased(int n, int n2, int n3) {
        this.mainModel.itemReleased(n, n2, n3);
    }

    @Override
    public void setFocusOffset(int n) {
        this.mainModel.setFocusOffset(n);
    }

    @Override
    public int getFocusedCursorPosition() {
        return this.mainModel.getFocusedCursorPosition();
    }

    @Override
    public boolean isFastScrollingEnabled() {
        return this.mainModel.isFastScrollingEnabled();
    }

    @Override
    public int getRowsAvailable(int n) {
        return this.mainModel.getRowsAvailable(n);
    }

    @Override
    public boolean isCursorPositionReset() {
        return this.mainModel.isCursorPositionReset();
    }

    @Override
    public boolean isEndOfList(int n) {
        return this.mainModel.isEndOfList(n);
    }

    public int getEndOfListState(int n) {
        return this.mainModel.getEndOfListState(n);
    }

    @Override
    public boolean isJumpingToEndOfListSupported() {
        return this.mainModel.isJumpingToEndOfListSupported();
    }

    @Override
    public boolean isJumpingToStartOfListSupported() {
        return this.mainModel.isJumpingToStartOfListSupported();
    }

    @Override
    public void jumpToEndOfList(int n) {
        this.mainModel.jumpToEndOfList(n);
    }

    @Override
    public void jumpToStartOfList(int n) {
        this.mainModel.jumpToStartOfList(n);
    }

    @Override
    public void moveContext(int n) {
        this.mainModel.moveContext(n);
    }

    @Override
    public void setVisibleRows(int n) {
        this.mainModel.setVisibleRows(n);
    }

    @Override
    public void setFirstScreenOffset(int n) {
        this.mainModel.setFirstScreenOffset(n);
    }

    @Override
    public void scrollingActive(boolean bl, int n) {
        this.activeModel.scrollingActive(bl, n);
    }

    @Override
    public boolean getRowFromNextContext(int n, ListCell[] listCellArray) {
        return this.activeModel.getRowFromNextContext(n, listCellArray);
    }

    @Override
    public boolean getRowFromPreviousContext(int n, ListCell[] listCellArray) {
        return this.activeModel.getRowFromPreviousContext(n, listCellArray);
    }

    @Override
    public int getListLength() {
        return this.activeModel.getListLength();
    }

    @Override
    public int getLineNumber() {
        return this.activeModel.getLineNumber();
    }

    @Override
    public int getFocusedCursorPositionOffset() {
        return this.activeModel.getFocusedCursorPositionOffset();
    }
}

