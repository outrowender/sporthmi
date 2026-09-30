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
    public static final int NONE = -1;
    public static final int FOR_MAIN = 1;
    public static final int FOR_HEADER = 2;
    public static final int FOR_DETAIL = 4;
    public static final int FOR_EXPANDED = 8;
    public static final int FOR_SUBGRID = 16;
    public static final int FOR_SUBLIST = 32;
    public static final int FOR_MEDIA = 64;
    public static final int FOR_ARTIFICIAL_CLONE = 128;
    public static final int FOR_ALL = Integer.MAX_VALUE;
    public static final int FOR_ALL_DECORATORS = 205;
    public static final int SOURCE_UNKNOWN = 0;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_MAIN = 1;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_DRAWER = 2;
    public static final int SOURCE_TRUFFLE = 3;
    public static final int SOURCE_MEDIA_UPDATE = 4;
    public static final int SOURCE_RRD = 5;
    public static final int SOURCE_PREVIEW = 6;
    public static final int SOURCE_DIAGNOSIS = 7;
    public static final int SOURCE_ITEM_FOCUSED = 8;
    public static final int SOURCE_AUTH_STATE_CHANGED = 9;
    public static final int SOURCE_HMI_VIEWGRID_LISTENER_FAST_RESOURCES = 10;
    public static final int SOURCE_CONTEXT_CHANGE = 11;
    public static final String[] sourceDescription = new String[]{"unknown source", "hmiViewGridListener-MainGridList", "hmiViewGridListener-DrawersList", "truffle-search", "mediaUpdate", "RRD", "Preview", "DiagnosisUI", "item-focused", "authentication-changed", "fast-resource-update", "context-change"};
    public static final int LOG_MODE_DEFAULT = 0;
    public static final int UPDATE_NONE = 0;
    public static final int UPDATE_OPTIONS_ICON_ONLY = 1;
    public static final int UPDATE_CURSOR_ONLY = 2;
    public static final int UPDATE_VALUES_ONLY = 3;
    public static final int UPDATE_GRID_STRUCTURE_AND_VALUES = 4;
    public static final int UPDATE_MENU_STRUCTURE_AND_VALUES = 5;
    public static final String[] updateDescription = new String[]{"none", "optionsIconOnly", "cursorOnly", "valuesOnly", "gridStructureAndValues", "menuStructureAndValues"};
    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_MEDIA = 1;
    public static final int VIEW_TYPE_INFINITE = 2;
    public static final int VIEW_TYPE_MEDIA_SINGLE_NPS = 3;
    public static final int VIEW_TYPE_BANK_PAGE = 4;
    public static final String[] viewTypeDescription = new String[]{"normal", "media", "infinite", "singleNPS", "bankPage"};
    public static final int MODEL_RANGE_MAX_INFINITE_LIST = 5000;

    public ICursor getCurrentCursor();

    public void setCurrentCursor(ICursor var1);

    public ICursor getInitialCursor();

    public void setInitialCursor(ICursor var1);

    public void setCurrentFocusWith(int var1, int var2, String var3, String var4);

    public void setCurrentFocus(ICursorComponent var1);

    public void setCurrentSelection(int var1, int var2, String var3, String var4);

    public void setCurrentSelection(ICursorComponent var1);

    public int getIdRangeStart();

    public int getIdRangeSize();

    public void setIdRange(int var1, int var2);

    public IGrid getParentGrid();

    public void setParentGrid(IGrid var1);

    public int getUpdateMode();

    public void setUpdateMode(int var1);

    public int getAndClearUpdateMode();

    public int addUpdateMode(int var1);

    public boolean isSelectionEnabled();

    public void setSelectionEnabled(boolean var1);

    public boolean isRendered();

    public void setRendered(boolean var1);

    public boolean isDirty();

    public void setDirty(boolean var1);

    public Object getListener();

    public void setListener(Object var1);

    public boolean isEventListening();

    public void setEventListening(boolean var1);

    public IRangeCounter getRangeCounter();

    public void setRangeCounter(IRangeCounter var1);

    public void setUpdateSource(int var1);

    public int getUpdateSource();

    public void setNewIdRange(IRangeCounter var1);

    public void setNewIdRange(IRangeCounter var1, int var2);

    public void setContentRightOffset(int var1);

    public int getContentRightOffset();

    public void correctCurrentCursor();

    public ICursorComponent getCorrectedFocus(ICursorComponent var1);

    public ICursorComponent getCorrectedSelection(ICursorComponent var1);

    public int findCorrectFocusedIndex(int var1, String var2);

    public int findCorrectSelectedIndex(int var1, String var2);

    public void makeAllEmptyCellsInvisible();

    public int findIndexOfFirstGridId(String var1, int var2);

    public void setGridsVisible(boolean var1);

    public void restoreInitialGridVisibility();

    public void deleteGridHighlight();

    public IGrid getGridOfModelRow(int var1);

    public int getIndexOfModelRow(int var1);

    public void replaceTextConstants(String var1, ITextConstantsConverter var2);

    public IGrid getGridOfWidgetId(int var1);

    public int getIndexWithinList(int var1);

    public int getIndexWithinRange(int var1);

    public int getIndexFromId(int var1);

    public IGridList getHeader();

    public void setHeader(IGridList var1);

    public void applySearchFilter(int var1, ArrayList var2);

    public List getAllGridCells(int var1);

    public List getTabIds();

    public void setViewType(int var1);

    public int getViewType();

    public IInfiniteListData getInfiniteListData();

    public int[] getTabIdArray();

    public IGridFactory getGridFactory();

    public ISpeller getSpeller();

    public void setSpeller(ISpeller var1);

    public int getVisibleGridCount();

    public int artificialElementCount();

    public IGrid replaceGridNode(String var1, IGrid var2);

    public void setMediaGridValues(IMediaValues var1);

    public void copyIdRangeFrom(IGridList var1);

    public int updateAllCellImages(List var1);

    public boolean updateAllDecoratorImages(List var1);

    public int forEachCell(IGridCellAction var1, int var2);

    public int forEachGrid(IGridAction var1, int var2);

    public int forEachList(IGridListAction var1, int var2);

    public void setReferencePoint(IReferencePoint var1);

    public IReferencePoint getReferencePoint();

    public void calculateDisplayedRows();

    public void calculateAllDisplayedRows();

    public void correctCursorOfInfiniteList();

    public boolean isRightDrawerAvailable();

    public void setRightDrawerAvailable(boolean var1);

    public boolean hasDetailGridsForNonExpandableEntries();

    public Object getLogObject(int var1);

    public int calculateUniqueId(int var1, int var2);

    public void setRestoreHistoryDataActive(boolean var1);

    public boolean isRestoreHistoryDataActive();

    public int getUpdateCounter();

    public int getNextUpdateCounter();

    public int getRenderId();

    public void setRenderId(int var1);

    public String getSender();

    public void addSender(String var1);

    public int addButtonSelectionId(String var1);

    public Map getButtonSelectionIds();

    public int getIndexBeforeLastPageOfInfiniteList();

    public boolean equalsRoughly(IGridList var1);

    public int replaceEmptyDecorator(PreparedImage var1);
}

