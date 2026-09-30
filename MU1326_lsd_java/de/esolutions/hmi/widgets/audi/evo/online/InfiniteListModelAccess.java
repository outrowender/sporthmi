/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListData;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListListener;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.online.GridListModel;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.IInfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.InfiniteListStatistics;
import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;
import de.esolutions.hmi.widgets.audi.evo.online.WidgetUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuViewport;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.BaseListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.List;

public class InfiniteListModelAccess
extends BaseListModelAccess
implements IInfiniteListModelAccess {
    protected static final LogChannel log = AbstractWidget.framework.getLogChannel("App.Online.RemoteHMI.Grid");
    protected final int terminalId;
    private int currentFirstVisibleIndex = -1;
    private int currentLastVisibleIndex = -1;
    private int targetFirstVisibleIndex = -1;
    private int targetLastVisibleIndex = -1;
    private int currentStartIndex;
    private int totalListLength;
    private int initialListLength = -1;
    private int proxyRange;
    private int overlapSize;
    private int requestedRowsCount;
    boolean hasArtificialRowAtBeginning;
    boolean hasArtificialRowAtEnd;
    public static final int REQUEST_NONE = 1;
    public static final int REQUEST_NEXT = 2;
    public static final int REQUEST_PREVIOUS = 4;
    public static final int REQUEST_ALL = Integer.MAX_VALUE;
    private int isWaitingFor = 1;
    private int triggerRequestFor = 1;
    private int triggerResetFor = 1;
    private ListController listController;
    private boolean ignoringIndexChanges;
    private boolean resolvingRows;
    private boolean resetting;
    boolean firstTimeAfterUpdate = true;
    private ScrollbarController scrollbar1;
    private ScrollbarController scrollbar2;
    private InfiniteListStatistics statistics = new InfiniteListStatistics();
    static /* synthetic */ Class class$de$esolutions$hmi$widgets$audi$evo$online$InfiniteListModelAccess;

    public InfiniteListModelAccess(ScrollbarController scrollbarController, ScrollbarController scrollbarController2, int n, int n2) {
        this.terminalId = n2;
        this.scrollbar1 = scrollbarController;
        this.scrollbar2 = scrollbarController2;
        this.requestedRowsCount = n;
    }

    public void viewportChanged(MenuViewport menuViewport) {
        int n = this.targetFirstVisibleIndex;
        int n2 = this.targetLastVisibleIndex;
        this.targetFirstVisibleIndex = menuViewport.start.widgetPart;
        this.targetLastVisibleIndex = menuViewport.end.widgetPart;
        if (this.targetFirstVisibleIndex != n || this.targetLastVisibleIndex != n2) {
            log.log(10000000, "InfiniteListModelAccess#viewportChanged: old target: firstVisible=%1, lastVisible=%2", (long)n, (long)n2);
            log.log(10000000, "InfiniteListModelAccess#viewportChanged  new target: firstVisible=%1, lastVisible=%2, length=%3", (long)this.targetFirstVisibleIndex, (long)this.targetLastVisibleIndex, (long)this.getCurrentListLength());
        }
        if (this.ignoringIndexChanges) {
            log.log(10000000, "InfiniteListModelAccess#viewportChanged: changes are ignored!");
            return;
        }
        if (n == -1) {
            return;
        }
        boolean bl = this.targetFirstVisibleIndex < n && this.targetLastVisibleIndex < n2;
        boolean bl2 = this.targetFirstVisibleIndex > n && this.targetLastVisibleIndex > n2;
        log.log(10000000, "InfiniteListModelAccess#viewportChanged: hasScrolledUp=%1, hasScrolledDown=%2.", bl, bl2);
        if (bl && this.triggerRequestFor == 2) {
            this.triggerRequestFor = 1;
            log.log(1000000, "InfiniteListModelAccess#viewportChanged: next entry request was aborted.");
        }
        if (bl2 && this.triggerRequestFor == 4) {
            this.triggerRequestFor = 1;
            log.log(1000000, "InfiniteListModelAccess#viewportChanged: previous entry request was aborted.");
        }
        boolean bl3 = !this.isInsideProxyRange(n, true) && !this.isInsideProxyRange(n2, false);
        this.checkForSettingRequestTrigger(bl3);
    }

    public void checkForSettingRequestTrigger(boolean bl) {
        log.log(1000000, "InfiniteListModelAccess#checkForSettingRequestTrigger: resolvingRows=%1, resetting=%2, firstTimeAfterUpdate=%3.", this.resolvingRows, this.resetting, this.firstTimeAfterUpdate);
        if (this.resolvingRows || this.resetting) {
            return;
        }
        if (this.firstTimeAfterUpdate) {
            this.firstTimeAfterUpdate = false;
            return;
        }
        if (this.triggerRequestFor != 4 && this.isWaitingFor != 4 && (this.isBeginningArtificialRowShown() || bl && this.isInsideProxyRange(this.targetFirstVisibleIndex, true))) {
            this.triggerRequestFor = 4;
            log.log(1000000, "InfiniteListModelAccess#checkForSettingRequestTrigger: trigger for previous entry request is set.");
        }
        if (this.triggerRequestFor != 2 && this.isWaitingFor != 2 && (this.isEndArtificialRowShown() || bl && this.isInsideProxyRange(this.targetLastVisibleIndex, false))) {
            this.triggerRequestFor = 2;
            log.log(1000000, "InfiniteListModelAccess#checkForSettingRequestTrigger: trigger for next entry request is set.");
        }
    }

    public void rendered(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        try {
            this.renderedWork(menuItemIndex, menuItemIndex2);
        }
        catch (Throwable throwable) {
            log.log(10000, "InfiniteListModelAccess#renderedWork: unexpected error happened. New rows may not show up.", throwable);
        }
    }

    private void renderedWork(MenuItemIndex menuItemIndex, MenuItemIndex menuItemIndex2) {
        boolean bl;
        if (menuItemIndex == null || menuItemIndex2 == null) {
            return;
        }
        int n = this.currentFirstVisibleIndex;
        int n2 = this.currentLastVisibleIndex;
        this.currentFirstVisibleIndex = menuItemIndex.widgetPart;
        this.currentLastVisibleIndex = menuItemIndex2.widgetPart;
        boolean bl2 = bl = n != this.currentFirstVisibleIndex || n2 != this.currentLastVisibleIndex;
        if (bl) {
            log.log(10000000, "InfiniteListModelAccess#renderedWork: old firstVisible=%1, lastVisible=%2", (long)n, (long)n2);
            log.log(10000000, "InfiniteListModelAccess#renderedWork: new firstVisible=%1, lastVisible=%2", (long)this.currentFirstVisibleIndex, (long)this.currentLastVisibleIndex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean resolveRows(boolean bl) {
        int n;
        int n2;
        if (this.resolvingRows) {
            return false;
        }
        if (this.currentFirstVisibleIndex == -1 || this.currentLastVisibleIndex == -1) {
            return false;
        }
        int n3 = this.getCurrentListLength();
        if (n3 == 0 || this.currentLastVisibleIndex < this.currentFirstVisibleIndex || n3 <= this.currentLastVisibleIndex) {
            log.log(100000, "InfiniteListModelAccess#resolveRows: inconsistent values: no subrows were resolved: currentFirstVisibleIndex=%1, currentLastVisibleIndex=%2, length=%3", (long)this.currentFirstVisibleIndex, (long)this.currentLastVisibleIndex, (long)n3);
            return false;
        }
        if (this.isScrollAnimationRunning()) {
            log.log(10000000, "InfiniteListModelAccess#resolveRows: animation still running: no subrows were resolved: firstVisible=%1, lastVisible=%2, length=%3", (long)this.currentFirstVisibleIndex, (long)this.currentLastVisibleIndex, (long)n3);
            return false;
        }
        if (bl) {
            n2 = this.currentFirstVisibleIndex;
            n = this.currentLastVisibleIndex;
        } else {
            n2 = -1;
            n = -1;
        }
        try {
            this.resolvingRows = true;
            this.resolveRowsWork(n2, n);
        }
        finally {
            this.resolvingRows = false;
        }
        if (!this.resetting) {
            GridListModel gridListModel = (GridListModel)this.model;
            gridListModel.notifyResolvingRowsAndResettingFinished();
        }
        return true;
    }

    private void resolveRowsWork(int n, int n2) {
        int n3 = this.getCurrentListLength();
        log.log(1000000, "InfiniteListModelAccess#resolveRowsWork: firstVisible=%1, lastVisible=%2, length=%3", (long)n, (long)n2, (long)n3);
        int n4 = n3 - 1;
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = n4; i2 >= 0; --i2) {
            boolean bl3;
            boolean bl4;
            if (i2 >= n && i2 < n2) continue;
            GridListModel gridListModel = (GridListModel)this.model;
            GridListRow gridListRow = (GridListRow)gridListModel.getGuiRow(i2);
            boolean bl5 = i2 == n2;
            List list = gridListRow.getRowsToInsertIfOffscreen();
            int n5 = list.size();
            List list2 = list.subList(bl5 && gridListRow.hasReplacement() ? 1 : 0, n5);
            int n6 = list2.size();
            boolean bl6 = bl4 = n6 > 0;
            if (bl4) {
                log.log(1000000, "InfiniteListModelAccess#resolveRowsWork: inserting %1 rows after index=%2.", (long)n6, (long)i2);
                this.insertRowsAfter(i2, list2);
                bl2 = true;
                list2.clear();
                if (i2 == n4) {
                    bl = true;
                }
            }
            boolean bl7 = n2 != -1 && (i2 == n - 1 || i2 == n2 + 1);
            boolean bl8 = bl3 = bl7 && !bl4;
            if (!gridListRow.isDeletableIfOffscreen() || bl5 || bl3) continue;
            log.log(1000000, "InfiniteListModelAccess#resolveRowsWork: deleting row with gridId='%1'.", (Object)gridListRow.getGridId());
            this.removeRows(i2, 1);
            bl2 = true;
            if (i2 != 0 && i2 != n4) continue;
            bl = true;
        }
        if (bl) {
            this.changeAllRowsToArtificialOrOriginal();
        }
        if (this.statistics.isDirty()) {
            this.statistics.update((GridListModel)this.model, this.isWaitingFor);
        }
    }

    public void startRequestIfTriggered() {
        if (this.isWaitingFor != 1) {
            return;
        }
        if (this.triggerRequestFor == 1) {
            return;
        }
        if (this.isVisibleAreaOverlappingForbiddenArea()) {
            return;
        }
        this.markAllNonOverlappingRowsAsDeleted();
        this.resolveRows(true);
        if (this.triggerRequestFor != 1) {
            this.requestEntries(this.triggerRequestFor);
        }
    }

    public boolean isVisibleAreaOverlappingForbiddenArea() {
        int n;
        int n2;
        if (this.triggerRequestFor == 1) {
            return false;
        }
        if (this.triggerRequestFor == 2) {
            n2 = this.statistics.getModelIndex(0);
            n = this.statistics.getModelIndex(7);
        } else {
            n2 = this.statistics.getModelIndex(4);
            n = this.statistics.getModelIndex(1);
        }
        return this.currentFirstVisibleIndex <= n && this.currentLastVisibleIndex >= n2;
    }

    public void updateInfiniteListData(IInfiniteListData iInfiniteListData, GridListRow[] gridListRowArray) {
        this.firstTimeAfterUpdate = true;
        this.totalListLength = iInfiniteListData.getTotalLength();
        this.proxyRange = iInfiniteListData.getProxyRange();
        this.overlapSize = iInfiniteListData.getOverlapSize();
        this.initialListLength = gridListRowArray.length;
        int n = this.isWaitingFor;
        this.isWaitingFor = 1;
        this.statistics.updateIdByNewList(gridListRowArray, this.proxyRange, this.overlapSize);
        this.statistics.update((GridListModel)this.model, 1);
        int n2 = this.currentStartIndex;
        this.currentStartIndex = this.getAbsoluteIndexOfRow(gridListRowArray[0]);
        log.log(10000000, "InfiniteListModelAccess#updateInfiniteListData: startIndex: old=%1, current=%2", (long)n2, (long)this.currentStartIndex);
        this.resolveRows(true);
        this.changeAllRowsToArtificialOrOriginal();
        this.triggerResetFor = this.checkForReset(n);
        boolean bl = this.resetIfTriggered();
        if (bl) {
            return;
        }
        this.startRequestIfTriggered();
    }

    public long getFirstVisibleRowId() {
        return this.getRowIdByIndex(this.currentFirstVisibleIndex);
    }

    public long getLastVisibleRowId() {
        return this.getRowIdByIndex(this.currentLastVisibleIndex);
    }

    private long getRowIdByIndex(int n) {
        if (n < 0 || n >= this.getCurrentListLength()) {
            return -1L;
        }
        return (int)this.model.getGuiRow(n).getUniqueID();
    }

    private void requestEntries(int n) {
        int n2;
        String string;
        GridListRow gridListRow = this.statistics.getRow(0);
        GridListRow gridListRow2 = this.statistics.getRow(1);
        if (n == 2) {
            string = "next";
            n2 = this.getAbsoluteIndexOfRow(gridListRow);
        } else {
            string = "previous";
            n2 = Math.max(0, this.getAbsoluteIndexOfRow(gridListRow2) - this.requestedRowsCount + 1);
        }
        this.requestEntries(n2, this.requestedRowsCount, string, gridListRow, gridListRow2);
        this.isWaitingFor = n;
        this.triggerRequestFor = 1;
    }

    private void requestEntries(int n, int n2, String string, GridListRow gridListRow, GridListRow gridListRow2) {
        log.log(1000000, "InfiniteListModelAccess#requestEntries: requesting %1 %2 entries: startIndex=%3", (Object)string, (long)n2, (long)n);
        String string2 = gridListRow.getGridId();
        String string3 = gridListRow2.getGridId();
        long l = this.getAbsoluteIndexOfRow(gridListRow);
        long l2 = this.getAbsoluteIndexOfRow(gridListRow2);
        this.getInfiniteListListener().requestItems(n, n2, string, this.overlapSize, string2, string3, (int)l, (int)l2);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
    }

    private int getCurrentListLength() {
        return this.model.getLength();
    }

    private void changeBeginningToArtificialRow() {
        this.makeRowArtificial(0, true);
        this.hasArtificialRowAtBeginning = true;
    }

    private void changeEndToArtificialRow() {
        this.makeRowArtificial(this.getCurrentListLength() - 1, true);
        this.hasArtificialRowAtEnd = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void makeRowArtificial(int n, boolean bl) {
        ListController listController = this.getListController();
        if (!(this.model instanceof GridListModel)) {
            log.log(10000, "InfiniteListModelAccess#makeRowArtificial: model is not a GridListModel, but model=%1", (Object)this.model);
            return;
        }
        GridListModel gridListModel = (GridListModel)this.model;
        GridListRow gridListRow = (GridListRow)gridListModel.getGuiRow(n);
        if (gridListRow.isArtificial() == bl) {
            return;
        }
        GridListRow gridListRow2 = (GridListRow)gridListModel.getRow(n);
        IGrid iGrid = gridListRow2.getGrid();
        iGrid.setArtificial(bl);
        int n2 = bl ? 3 : 0;
        gridListRow2.setGridAndLayout(iGrid, n2);
        gridListModel.setRow(n, gridListRow2);
        boolean bl2 = this.ignoringIndexChanges;
        try {
            this.ignoringIndexChanges = true;
            listController.setRecordSetCacheIgnored(true);
            WidgetUtilities.notifyChangedRowsImmediately(n, 1, listController, this.terminalId);
        }
        finally {
            this.ignoringIndexChanges = bl2;
            listController.setRecordSetCacheIgnored(false);
        }
    }

    public void changeAllRowsToArtificialOrOriginal() {
        boolean bl;
        boolean bl2;
        GridListModel gridListModel = (GridListModel)this.model;
        this.hasArtificialRowAtBeginning = false;
        this.hasArtificialRowAtEnd = false;
        boolean bl3 = bl2 = this.getAbsoluteIndexOfRow(0) > 0;
        if (bl2) {
            this.changeBeginningToArtificialRow();
        }
        boolean bl4 = bl = this.getAbsoluteIndexOfRow(gridListModel.getLastRowInfo().getRow()) < this.totalListLength - 1;
        if (bl) {
            this.changeEndToArtificialRow();
        }
        ListController listController = this.getListController();
        int n = this.getFocusedIndex(listController);
        int n2 = this.getCurrentListLength() - 1;
        for (int i2 = 1; i2 < n2; ++i2) {
            GridListRow gridListRow = (GridListRow)gridListModel.getGuiRow(i2);
            if (!gridListRow.isArtificial()) continue;
            this.makeRowArtificial(i2, false);
            if (i2 != n) continue;
            GridListRow gridListRow2 = (GridListRow)gridListModel.getGuiRow(i2);
            log.log(1000000, "InfiniteListModelAccess#changeAllRowsToArtificialOrOriginal: itemFocused will be sent for rowIndex=%1, offset by startIndex=%2", (long)i2, (long)this.currentStartIndex);
            this.getBaseListListener().itemFocused(gridListRow2, gridListModel.getID(), i2, 0, this.terminalId);
        }
    }

    private int getFocusedIndex(ListController listController) {
        MenuController menuController = (MenuController)listController.getParent();
        MenuItemIndex menuItemIndex = menuController.getFocusedIndex();
        if (menuItemIndex == null) {
            return -1;
        }
        return menuItemIndex.widgetPart;
    }

    private void markAllNonOverlappingRowsAsDeleted() {
        RowInfo rowInfo;
        RowInfo rowInfo2;
        if (this.triggerRequestFor == 1) {
            log.log(10000000, "InfiniteListModelAccess#markAllNonOverlappingRowsAsDeleted: no request is running!");
            return;
        }
        GridListModel gridListModel = (GridListModel)this.model;
        if (this.triggerRequestFor == 2) {
            rowInfo2 = this.statistics.getRowInfo(6);
            rowInfo = this.statistics.getRowInfo(1);
        } else {
            rowInfo2 = this.statistics.getRowInfo(0);
            rowInfo = this.statistics.getRowInfo(5);
        }
        GridListModel.RowSubrowIterator rowSubrowIterator = gridListModel.rowSubrowIterator();
        while (rowSubrowIterator.hasNext()) {
            GridListRow gridListRow = (GridListRow)rowSubrowIterator.next();
            RowInfo rowInfo3 = rowSubrowIterator.previousRowInfo();
            if (!rowInfo3.isBefore(rowInfo2) && !rowInfo3.isAfter(rowInfo)) continue;
            gridListRow.setDeletableIfOffscreen(true);
        }
        this.statistics.correctForDeletedBoundaries(this.triggerRequestFor);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removeRows(int n, int n2) {
        log.log(10000000, "InfiniteListModelAccess#removeRows: start removing %1 rows, starting at index %2 ...", (long)n2, (long)n);
        boolean bl = this.ignoringIndexChanges;
        boolean bl2 = this.resolvingRows;
        ListController listController = this.getListController();
        try {
            this.ignoringIndexChanges = true;
            this.resolvingRows = true;
            WidgetUtilities.removeEvoListRowsImmediately(n, n2, listController, this.terminalId);
        }
        finally {
            this.ignoringIndexChanges = bl;
            this.resolvingRows = bl2;
        }
        log.log(1000000, "InfiniteListModelAccess#removeRows: ... %1 rows removed, starting at index %2.", (long)n2, (long)n);
        if (this.scrollbar1 != null) {
            this.scrollbar1.setEntireMax(this.initialListLength);
            if (n == 0) {
                this.scrollbar1.setEntireValue(n2);
            }
        }
        if (this.scrollbar2 != null) {
            this.scrollbar2.setEntireMax(this.initialListLength);
            if (n == 0) {
                this.scrollbar2.setEntireValue(n2);
            }
        }
        this.statistics.setDirty(true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void insertRowsAfter(int n, List list) {
        String string;
        GridListRow gridListRow;
        boolean bl;
        int n2 = list.size();
        log.log(10000000, "InfiniteListModelAccess#insertRowsAfter: start adding %1 rows after index %2 ...", (long)n2, (long)n);
        log.log(10000000, "InfiniteListModelAccess#insertRowsAfter: rows = %1", (Object)list);
        EvoListRow[] evoListRowArray = (EvoListRow[])list.toArray(new EvoListRow[n2]);
        boolean bl2 = this.ignoringIndexChanges;
        boolean bl3 = this.resolvingRows;
        ListController listController = this.getListController();
        boolean bl4 = bl = n < 0;
        if (bl) {
            gridListRow = (GridListRow)this.model.getGuiRow(0);
            string = "before";
        } else {
            gridListRow = (GridListRow)this.model.getGuiRow(n);
            string = "after";
        }
        long l = gridListRow.getUniqueID();
        try {
            this.ignoringIndexChanges = true;
            this.resolvingRows = true;
            if (bl) {
                WidgetUtilities.insertBeforeEvoListRowsImmediately(l, evoListRowArray, listController, this.terminalId);
            } else {
                WidgetUtilities.insertAfterEvoListRowsImmediately(l, evoListRowArray, listController, this.terminalId);
            }
        }
        finally {
            this.ignoringIndexChanges = bl2;
            this.resolvingRows = bl3;
        }
        log.log(1000000, "InfiniteListModelAccess#insertRowsAfter: ... %3 rows added %1 row with gridId=%2", (Object)string, (Object)gridListRow.getGridId(), (long)n2);
        this.statistics.setDirty(true);
    }

    public ListController getListController() {
        if (this.listController == null) {
            throw new IllegalStateException(new StringBuffer().append("List controller is null. You must set it before you can use ").append(class$de$esolutions$hmi$widgets$audi$evo$online$InfiniteListModelAccess == null ? (class$de$esolutions$hmi$widgets$audi$evo$online$InfiniteListModelAccess = InfiniteListModelAccess.class$("de.esolutions.hmi.widgets.audi.evo.online.InfiniteListModelAccess")) : class$de$esolutions$hmi$widgets$audi$evo$online$InfiniteListModelAccess).toString());
        }
        return this.listController;
    }

    public void setListController(ListController listController) {
        this.listController = listController;
    }

    private boolean isInsideProxyRange(int n, boolean bl) {
        if (bl) {
            return this.hasArtificialRowAtBeginning && n <= this.statistics.getModelIndex(2);
        }
        return this.hasArtificialRowAtEnd && n >= this.statistics.getModelIndex(3);
    }

    public IInfiniteListListener getInfiniteListListener() {
        return (IInfiniteListListener)((Object)this.getBaseListListener());
    }

    public BaseListModelListener getBaseListListener() {
        GridListModel gridListModel = (GridListModel)this.model;
        return gridListModel.getListener();
    }

    private int getAbsoluteIndexOfRow(GridListRow gridListRow) {
        GridListModel gridListModel = (GridListModel)this.model;
        return gridListModel.getAbsoluteIndexOfRow(gridListRow);
    }

    private int getAbsoluteIndexOfRow(int n) {
        if (n < 0 || n >= this.model.getLength()) {
            return -1;
        }
        return this.getAbsoluteIndexOfRow((GridListRow)this.model.getGuiRow(n));
    }

    private int checkForReset(int n) {
        if (n == 4 && this.isBeginningArtificialRowShown()) {
            log.log(1000000, "InfiniteListModelAccess#checkForReset: trigger resetting view because no new data provided at beginning.");
            return 4;
        }
        if (n == 2 && this.isEndArtificialRowShown()) {
            log.log(1000000, "InfiniteListModelAccess#checkForReset: trigger resetting view because no new data provided at end.");
            return 2;
        }
        return 1;
    }

    private boolean isBeginningArtificialRowShown() {
        return this.hasArtificialRowAtBeginning && this.currentFirstVisibleIndex == 0;
    }

    private boolean isEndArtificialRowShown() {
        return this.hasArtificialRowAtEnd && this.currentLastVisibleIndex == this.getCurrentListLength() - 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean resetIfTriggered() {
        if (this.triggerResetFor == 1 || this.resolvingRows || this.resetting) {
            return false;
        }
        try {
            this.resetting = true;
            boolean bl = this.resetWork(this.triggerResetFor);
            return bl;
        }
        finally {
            this.resetting = false;
        }
    }

    private boolean resetWork(int n) {
        FocusAdvice focusAdvice;
        int n2;
        String string = this.triggerResetFor == 4 ? "top" : "bottom";
        log.log(1000000, "InfiniteListModelAccess#resetWork: start trying to resolve rows for reset to %1 of list.", (Object)string);
        boolean bl = this.resolveRows(false);
        if (!bl) {
            log.log(1000000, "InfiniteListModelAccess#resetWork: running animation delays reset to %1 of list.", (Object)string);
            return false;
        }
        int n3 = this.getCurrentListLength();
        if (n3 < this.overlapSize || this.overlapSize < 2) {
            throw new IllegalStateException(new StringBuffer().append("InfiniteListModelAccess#resetWork: List structure was modified unexpectedly. length should be more than ").append(Math.max(this.overlapSize, 2)).append(", but it is ").append(n3).toString());
        }
        this.firstTimeAfterUpdate = true;
        ListController listController = this.getListController();
        MenuController menuController = (MenuController)listController.getParent();
        int n4 = menuController.getChildIndexForWidgetId(listController.getWidgetID());
        GridListModel gridListModel = (GridListModel)this.model;
        gridListModel.clearCacheForFocusedItem();
        if (n == 4) {
            n2 = 1;
            focusAdvice = FocusAdvice.VIEWPORT_FIRST_POSITION;
        } else {
            n2 = n3 - 2;
            focusAdvice = FocusAdvice.VIEWPORT_LAST_POSITION;
        }
        log.log(1000000, "InfiniteListModelAccess#resetWork: setting focused item to list index %1", (long)n2);
        menuController.focusItemImmediately(new MenuItemIndex(n4, n2), focusAdvice);
        log.log(1000000, "InfiniteListModelAccess#resetWork: focused item to list index %1 was set!", (long)n2);
        this.triggerResetFor = 1;
        this.triggerRequestFor = 1;
        gridListModel.notifyResolvingRowsAndResettingFinished();
        return true;
    }

    private boolean isScrollAnimationRunning() {
        ListController listController = this.getListController();
        MenuController menuController = (MenuController)listController.getParent();
        return menuController.getAnimationManager().isScrollAnimationRunning();
    }

    public boolean isResolvingRows() {
        return this.resolvingRows;
    }

    public boolean isResetting() {
        return this.resetting;
    }

    public void checkDelayedTasks() {
        boolean bl = this.resetIfTriggered();
        if (bl) {
            return;
        }
        this.resolveRows(true);
        this.checkForSettingRequestTrigger(false);
        this.startRequestIfTriggered();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

