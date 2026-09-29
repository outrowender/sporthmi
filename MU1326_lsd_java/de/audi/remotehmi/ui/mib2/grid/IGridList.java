/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.media.IMediaValues;
import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridListAction;
import de.audi.remotehmi.ui.mib2.grid.IInfiniteListData;
import de.audi.remotehmi.ui.mib2.grid.IRangeCounter;
import de.audi.remotehmi.ui.mib2.grid.IReferencePoint;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.audi.remotehmi.util.DeepCloneable;
import de.audi.remotehmi.util.PreparedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IGridList
extends List,
DeepCloneable {
    public static final int NONE;
    public static final int FOR_MAIN;
    public static final int FOR_HEADER;
    public static final int FOR_DETAIL;
    public static final int FOR_EXPANDED;
    public static final int FOR_SUBGRID;
    public static final int FOR_SUBLIST;
    public static final int FOR_MEDIA;
    public static final int FOR_ARTIFICIAL_CLONE;
    public static final int FOR_ALL;
    public static final int FOR_ALL_DECORATORS;
    public static final int SOURCE_UNKNOWN;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_MAIN;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_DRAWER;
    public static final int SOURCE_TRUFFLE;
    public static final int SOURCE_MEDIA_UPDATE;
    public static final int SOURCE_RRD;
    public static final int SOURCE_PREVIEW;
    public static final int SOURCE_DIAGNOSIS;
    public static final int SOURCE_ITEM_FOCUSED;
    public static final int SOURCE_AUTH_STATE_CHANGED;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_FAST_RESOURCES;
    public static final int SOURCE_CONTEXT_CHANGE;
    public static final String[] sourceDescription;
    public static final int LOG_MODE_DEFAULT;
    public static final int UPDATE_NONE;
    public static final int UPDATE_OPTIONS_ICON_ONLY;
    public static final int UPDATE_CURSOR_ONLY;
    public static final int UPDATE_VALUES_ONLY;
    public static final int UPDATE_GRID_STRUCTURE_AND_VALUES;
    public static final int UPDATE_MENU_STRUCTURE_AND_VALUES;
    public static final String[] updateDescription;
    public static final int VIEW_TYPE_NORMAL;
    public static final int VIEW_TYPE_MEDIA;
    public static final int VIEW_TYPE_INFINITE;
    public static final int VIEW_TYPE_MEDIA_SINGLE_NPS;
    public static final int VIEW_TYPE_BANK_PAGE;
    public static final String[] viewTypeDescription;
    public static final int MODEL_RANGE_MAX_INFINITE_LIST;

    default public ICursor getCurrentCursor() {
    }

    default public void setCurrentCursor(ICursor iCursor) {
    }

    default public ICursor getInitialCursor() {
    }

    default public void setInitialCursor(ICursor iCursor) {
    }

    default public void setCurrentFocusWith(int n, int n2, String string, String string2) {
    }

    default public void setCurrentFocus(ICursorComponent iCursorComponent) {
    }

    default public void setCurrentSelection(int n, int n2, String string, String string2) {
    }

    default public void setCurrentSelection(ICursorComponent iCursorComponent) {
    }

    default public int getIdRangeStart() {
    }

    default public int getIdRangeSize() {
    }

    default public void setIdRange(int n, int n2) {
    }

    default public IGrid getParentGrid() {
    }

    default public void setParentGrid(IGrid iGrid) {
    }

    default public int getUpdateMode() {
    }

    default public void setUpdateMode(int n) {
    }

    default public int getAndClearUpdateMode() {
    }

    default public int addUpdateMode(int n) {
    }

    default public boolean isSelectionEnabled() {
    }

    default public void setSelectionEnabled(boolean bl) {
    }

    default public boolean isRendered() {
    }

    default public void setRendered(boolean bl) {
    }

    default public boolean isDirty() {
    }

    default public void setDirty(boolean bl) {
    }

    default public Object getListener() {
    }

    default public void setListener(Object object) {
    }

    default public boolean isEventListening() {
    }

    default public void setEventListening(boolean bl) {
    }

    default public IRangeCounter getRangeCounter() {
    }

    default public void setRangeCounter(IRangeCounter iRangeCounter) {
    }

    default public void setUpdateSource(int n) {
    }

    default public int getUpdateSource() {
    }

    default public void setNewIdRange(IRangeCounter iRangeCounter) {
    }

    default public void setNewIdRange(IRangeCounter iRangeCounter, int n) {
    }

    default public void setContentRightOffset(int n) {
    }

    default public int getContentRightOffset() {
    }

    default public void correctCurrentCursor() {
    }

    default public ICursorComponent getCorrectedFocus(ICursorComponent iCursorComponent) {
    }

    default public ICursorComponent getCorrectedSelection(ICursorComponent iCursorComponent) {
    }

    default public int findCorrectFocusedIndex(int n, String string) {
    }

    default public int findCorrectSelectedIndex(int n, String string) {
    }

    default public void makeAllEmptyCellsInvisible() {
    }

    default public int findIndexOfFirstGridId(String string, int n) {
    }

    default public void setGridsVisible(boolean bl) {
    }

    default public void restoreInitialGridVisibility() {
    }

    default public void deleteGridHighlight() {
    }

    default public IGrid getGridOfModelRow(int n) {
    }

    default public int getIndexOfModelRow(int n) {
    }

    default public void replaceTextConstants(String string, ITextConstantsConverter iTextConstantsConverter) {
    }

    default public IGrid getGridOfWidgetId(int n) {
    }

    default public int getIndexWithinList(int n) {
    }

    default public int getIndexWithinRange(int n) {
    }

    default public int getIndexFromId(int n) {
    }

    default public IGridList getHeader() {
    }

    default public void setHeader(IGridList iGridList) {
    }

    default public void applySearchFilter(int n, ArrayList arrayList) {
    }

    default public List getAllGridCells(int n) {
    }

    default public List getTabIds() {
    }

    default public void setViewType(int n) {
    }

    default public int getViewType() {
    }

    default public IInfiniteListData getInfiniteListData() {
    }

    default public int[] getTabIdArray() {
    }

    default public IGridFactory getGridFactory() {
    }

    default public ISpeller getSpeller() {
    }

    default public void setSpeller(ISpeller iSpeller) {
    }

    default public int getVisibleGridCount() {
    }

    default public int artificialElementCount() {
    }

    default public IGrid replaceGridNode(String string, IGrid iGrid) {
    }

    default public void setMediaGridValues(IMediaValues iMediaValues) {
    }

    default public void copyIdRangeFrom(IGridList iGridList) {
    }

    default public int updateAllCellImages(List list) {
    }

    default public boolean updateAllDecoratorImages(List list) {
    }

    default public int forEachCell(IGridCellAction iGridCellAction, int n) {
    }

    default public int forEachGrid(IGridAction iGridAction, int n) {
    }

    default public int forEachList(IGridListAction iGridListAction, int n) {
    }

    default public void setReferencePoint(IReferencePoint iReferencePoint) {
    }

    default public IReferencePoint getReferencePoint() {
    }

    default public void calculateDisplayedRows() {
    }

    default public void calculateAllDisplayedRows() {
    }

    default public void correctCursorOfInfiniteList() {
    }

    default public boolean isRightDrawerAvailable() {
    }

    default public void setRightDrawerAvailable(boolean bl) {
    }

    default public boolean hasDetailGridsForNonExpandableEntries() {
    }

    default public Object getLogObject(int n) {
    }

    default public int calculateUniqueId(int n, int n2) {
    }

    default public void setRestoreHistoryDataActive(boolean bl) {
    }

    default public boolean isRestoreHistoryDataActive() {
    }

    default public int getUpdateCounter() {
    }

    default public int getNextUpdateCounter() {
    }

    default public int getRenderId() {
    }

    default public void setRenderId(int n) {
    }

    default public String getSender() {
    }

    default public void addSender(String string) {
    }

    default public int addButtonSelectionId(String string) {
    }

    default public Map getButtonSelectionIds() {
    }

    default public int getIndexBeforeLastPageOfInfiniteList() {
    }

    default public boolean equalsRoughly(IGridList iGridList) {
    }

    default public int replaceEmptyDecorator(PreparedImage preparedImage) {
    }

    static {
        sourceDescription = new String[]{"unknown source", "hmiViewGridListener-MainGridList", "hmiViewGridListener-DrawersList", "truffle-search", "mediaUpdate", "RRD", "Preview", "DiagnosisUI", "item-focused", "authentication-changed", "fast-resource-update", "context-change"};
        updateDescription = new String[]{"none", "optionsIconOnly", "cursorOnly", "valuesOnly", "gridStructureAndValues", "menuStructureAndValues"};
        viewTypeDescription = new String[]{"normal", "media", "infinite", "singleNPS", "bankPage"};
    }
}

