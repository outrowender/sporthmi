/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IBackgroundImages;
import de.audi.remotehmi.ui.mib2.grid.IGeoLocatable;
import de.audi.remotehmi.ui.mib2.grid.IGrid$1;
import de.audi.remotehmi.ui.mib2.grid.IGridAction;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridCellAction;
import de.audi.remotehmi.ui.mib2.grid.IGridColumn;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IGridListAction;
import de.audi.remotehmi.ui.mib2.grid.IGridRow;
import de.audi.remotehmi.ui.pag.IPreviewContainer;
import de.audi.remotehmi.util.DeepCloneable;
import de.audi.remotehmi.util.PreparedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IGrid
extends IGeoLocatable,
List,
DeepCloneable {
    public static final int STYLETYPE_UNKNOWN;
    public static final int MEDIA_TITLE_CELL;
    public static final int MEDIA_TIME_CELL;
    public static final int MEDIA_ARTIST_AND_ALBUM_CELL;
    public static final int MEDIA_ALBUM_CELL;
    public static final int MEDIA_CELL_COUNT;
    public static final int SEPARATOR_NONE;
    public static final int SEPARATOR_TOP;
    public static final int SEPARATOR_BOTTOM;
    public static final int SEPARATOR_BOTH;
    public static final Map separatorOptions;
    public static final int LOG_MODE_DEFAULT;
    public static final int LOG_MODE_COMPACT;

    default public boolean isFocusable() {
    }

    default public void setFocusable(boolean bl) {
    }

    default public List getDrawerTypes() {
    }

    default public void setDrawerTypes(List list) {
    }

    default public String getId() {
    }

    default public void setId(String string) {
    }

    default public String getDecoratorImageUrl() {
    }

    default public void setDecoratorImageUrl(String string) {
    }

    default public String getDecoratorImageUrlAlways() {
    }

    default public void setDecoratorImageUrlAlways(String string) {
    }

    default public PreparedImage getDecoratorImage() {
    }

    default public void setDecoratorImage(PreparedImage preparedImage) {
    }

    default public boolean isMapDecoratorEnabled() {
    }

    default public void setMapDecoratorEnabled(boolean bl) {
    }

    default public GeoPosition getMapDecoratorGeoPosition() {
    }

    default public void setMapDecoratorGeoPosition(GeoPosition geoPosition) {
    }

    default public IGridFactory getGridFactory() {
    }

    default public void setGridFactory(IGridFactory iGridFactory) {
    }

    default public int getMapDecoratorStyle() {
    }

    default public void setMapDecoratorStyle(int n) {
    }

    default public boolean isVisible() {
    }

    default public void setVisible(boolean bl) {
    }

    default public boolean isInitiallyVisible() {
    }

    default public void setInitiallyVisible(boolean bl) {
    }

    default public int getDisplayedRow() {
    }

    default public void setDisplayedRow(int n) {
    }

    default public int getXmlSourceRow() {
    }

    default public void setXmlSourceRow(int n) {
    }

    default public Object getData() {
    }

    default public void setData(Object object) {
    }

    default public void setTextRendering(int n) {
    }

    default public void setEnabled(boolean bl) {
    }

    default public void makeAllEmptyCellsInvisible() {
    }

    default public void convertRelativeToAbsoluteGridCoordinates() {
    }

    default public boolean containsText(String string) {
    }

    default public boolean containsAnyInputCells() {
    }

    default public IGridCell getFirstInputCell() {
    }

    default public IGridCell getFirstCell(int n) {
    }

    default public int getRenderedCellCount() {
    }

    default public int getRowCount() {
    }

    default public int getColumnCount() {
    }

    default public void deleteHighlight() {
    }

    default public void replaceTextConstants(String string, ITextConstantsConverter iTextConstantsConverter) {
    }

    default public String getInfoText() {
    }

    default public void setInfoText(String string) {
    }

    default public int getSeparator() {
    }

    default public void setSeparator(int n) {
    }

    default public IGrid getDetail() {
    }

    default public void setDetail(IGrid iGrid) {
    }

    default public boolean isExpanded() {
    }

    default public void setExpanded(boolean bl) {
    }

    default public IGridList getExpandedList() {
    }

    default public void setExpandedList(IGridList iGridList) {
    }

    default public void applySearchFilter(ArrayList arrayList) {
    }

    default public List getRows() {
    }

    default public void addRow(IGridRow iGridRow) {
    }

    default public List getColumns() {
    }

    default public void addColumn(IGridColumn iGridColumn) {
    }

    default public boolean hasVisibleExpandableListEntries() {
    }

    default public IGrid getCloneForMediaList() {
    }

    default public IGridCell[] getMediaCells() {
    }

    default public void checkAndCorrectSpanValues() {
    }

    default public void correctWidthMode(IGridFactory iGridFactory) {
    }

    default public boolean isFollowedBySeparator() {
    }

    default public void setFollowedBySeparator(boolean bl) {
    }

    default public void insertLeftColumn(IGridCell iGridCell, IGridFactory iGridFactory) {
    }

    default public boolean isArtificial() {
    }

    default public void setArtificial(boolean bl) {
    }

    default public boolean isUpdatePreservesHeight() {
    }

    default public void setUpdatePreservesHeight(boolean bl) {
    }

    @Override
    default public GeoPosition getGeoPosition() {
    }

    @Override
    default public void setGeoPosition(GeoPosition geoPosition) {
    }

    default public void insertRow(boolean bl, int n, IGridRow iGridRow, List list) {
    }

    default public boolean hasRRDItems() {
    }

    default public IGridColumn getColumnAndCreateMissing(int n, IGridFactory iGridFactory) {
    }

    default public void applyBackgroundImages(IBackgroundImages iBackgroundImages, IGridFactory iGridFactory) {
    }

    default public boolean containsCellType(int n) {
    }

    default public boolean isLineNumberSpeakableDefault() {
    }

    default public void setLineNumberSpeakable(boolean bl) {
    }

    default public boolean isLineNumberSpeakable() {
    }

    default public int forEachCell(IGridCellAction iGridCellAction, int n) {
    }

    default public int forEachGrid(IGridAction iGridAction, int n) {
    }

    default public int forEachList(IGridListAction iGridListAction, int n) {
    }

    default public void hideAllCells() {
    }

    default public void restoreAllCellVisibility() {
    }

    default public IGrid getArtificialClone() {
    }

    default public void setPlaytimeVisible(boolean bl) {
    }

    default public void clearDynamicContent() {
    }

    default public Object getLogObject(int n) {
    }

    default public void setPreview(IPreviewContainer iPreviewContainer) {
    }

    default public IPreviewContainer getPreview() {
    }

    default public boolean mediaCellValuesEqual(String string, String string2) {
    }

    default public void setMediaCells(IGridCell[] iGridCellArray) {
    }

    default public boolean isEnabled() {
    }

    default public boolean isBlocking() {
    }

    default public void setBlocking(boolean bl) {
    }

    default public String getBlockingText() {
    }

    default public void setBlockingText(String string) {
    }

    default public boolean isMedia() {
    }

    default public void setMedia(boolean bl) {
    }

    default public String getDefaultInfoText() {
    }

    default public void setDisplayText(String string) {
    }

    static {
        separatorOptions = new IGrid$1();
    }
}

