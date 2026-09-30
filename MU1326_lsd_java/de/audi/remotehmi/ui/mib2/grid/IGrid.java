/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2.grid;

import de.audi.remotehmi.textconstants.ITextConstantsConverter;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IBackgroundImages;
import de.audi.remotehmi.ui.mib2.grid.IGeoLocatable;
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
import de.audi.remotehmi.util.EnumHelper;
import de.audi.remotehmi.util.EnumParser;
import de.audi.remotehmi.util.PreparedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IGrid
extends IGeoLocatable,
List,
DeepCloneable {
    public static final int STYLETYPE_UNKNOWN = -1;
    public static final int MEDIA_TITLE_CELL = 0;
    public static final int MEDIA_TIME_CELL = 1;
    public static final int MEDIA_ARTIST_AND_ALBUM_CELL = 2;
    public static final int MEDIA_ALBUM_CELL = 3;
    public static final int MEDIA_CELL_COUNT = 4;
    public static final int SEPARATOR_NONE = 0;
    public static final int SEPARATOR_TOP = 1;
    public static final int SEPARATOR_BOTTOM = 2;
    public static final int SEPARATOR_BOTH = 3;
    public static final Map separatorOptions = new HashMap(){
        private static final long serialVersionUID = -2334177256358173042L;
        {
            this.put("none", new Integer(0));
            this.put("top", new Integer(1));
            this.put("bottom", new Integer(2));
            this.put("both", new Integer(3));
            this.put("true", new Integer(1));
        }
    };
    public static final int LOG_MODE_DEFAULT = 0;
    public static final int LOG_MODE_COMPACT = 1;

    public boolean isFocusable();

    public void setFocusable(boolean var1);

    public List getDrawerTypes();

    public void setDrawerTypes(List var1);

    public String getId();

    public void setId(String var1);

    public String getDecoratorImageUrl();

    public void setDecoratorImageUrl(String var1);

    public String getDecoratorImageUrlAlways();

    public void setDecoratorImageUrlAlways(String var1);

    public PreparedImage getDecoratorImage();

    public void setDecoratorImage(PreparedImage var1);

    public boolean isMapDecoratorEnabled();

    public void setMapDecoratorEnabled(boolean var1);

    public GeoPosition getMapDecoratorGeoPosition();

    public void setMapDecoratorGeoPosition(GeoPosition var1);

    public IGridFactory getGridFactory();

    public void setGridFactory(IGridFactory var1);

    public int getMapDecoratorStyle();

    public void setMapDecoratorStyle(int var1);

    public boolean isVisible();

    public void setVisible(boolean var1);

    public boolean isInitiallyVisible();

    public void setInitiallyVisible(boolean var1);

    public int getDisplayedRow();

    public void setDisplayedRow(int var1);

    public int getXmlSourceRow();

    public void setXmlSourceRow(int var1);

    public Object getData();

    public void setData(Object var1);

    public void setTextRendering(int var1);

    public void setEnabled(boolean var1);

    public void makeAllEmptyCellsInvisible();

    public void convertRelativeToAbsoluteGridCoordinates();

    public boolean containsText(String var1);

    public boolean containsAnyInputCells();

    public IGridCell getFirstInputCell();

    public IGridCell getFirstCell(int var1);

    public int getRenderedCellCount();

    public int getRowCount();

    public int getColumnCount();

    public void deleteHighlight();

    public void replaceTextConstants(String var1, ITextConstantsConverter var2);

    public String getInfoText();

    public void setInfoText(String var1);

    public int getSeparator();

    public void setSeparator(int var1);

    public IGrid getDetail();

    public void setDetail(IGrid var1);

    public boolean isExpanded();

    public void setExpanded(boolean var1);

    public IGridList getExpandedList();

    public void setExpandedList(IGridList var1);

    public void applySearchFilter(ArrayList var1);

    public List getRows();

    public void addRow(IGridRow var1);

    public List getColumns();

    public void addColumn(IGridColumn var1);

    public boolean hasVisibleExpandableListEntries();

    public IGrid getCloneForMediaList();

    public IGridCell[] getMediaCells();

    public void checkAndCorrectSpanValues();

    public void correctWidthMode(IGridFactory var1);

    public boolean isFollowedBySeparator();

    public void setFollowedBySeparator(boolean var1);

    public void insertLeftColumn(IGridCell var1, IGridFactory var2);

    public boolean isArtificial();

    public void setArtificial(boolean var1);

    public boolean isUpdatePreservesHeight();

    public void setUpdatePreservesHeight(boolean var1);

    public GeoPosition getGeoPosition();

    public void setGeoPosition(GeoPosition var1);

    public void insertRow(boolean var1, int var2, IGridRow var3, List var4);

    public boolean hasRRDItems();

    public IGridColumn getColumnAndCreateMissing(int var1, IGridFactory var2);

    public void applyBackgroundImages(IBackgroundImages var1, IGridFactory var2);

    public boolean containsCellType(int var1);

    public boolean isLineNumberSpeakableDefault();

    public void setLineNumberSpeakable(boolean var1);

    public boolean isLineNumberSpeakable();

    public int forEachCell(IGridCellAction var1, int var2);

    public int forEachGrid(IGridAction var1, int var2);

    public int forEachList(IGridListAction var1, int var2);

    public void hideAllCells();

    public void restoreAllCellVisibility();

    public IGrid getArtificialClone();

    public void setPlaytimeVisible(boolean var1);

    public void clearDynamicContent();

    public Object getLogObject(int var1);

    public void setPreview(IPreviewContainer var1);

    public IPreviewContainer getPreview();

    public boolean mediaCellValuesEqual(String var1, String var2);

    public void setMediaCells(IGridCell[] var1);

    public boolean isEnabled();

    public boolean isBlocking();

    public void setBlocking(boolean var1);

    public String getBlockingText();

    public void setBlockingText(String var1);

    public boolean isMedia();

    public void setMedia(boolean var1);

    public String getDefaultInfoText();

    public void setDisplayText(String var1);

    public static final class ExpandMode {
        private static final EnumHelper enumHelper = new EnumHelper();
        public static final ExpandMode GROW = new ExpandMode("grow", false, true);
        public static final ExpandMode SHRINK = new ExpandMode("shrink", true, false);
        public static final ExpandMode DYNAMIC = new ExpandMode("dynamic", true, true);
        public static final ExpandMode FIXED = new ExpandMode("fixed", false, false);
        private final String name;
        private final boolean isShrinkable;
        private final boolean isGrowable;

        private ExpandMode(String string, boolean bl, boolean bl2) {
            this.name = string;
            this.isShrinkable = bl;
            this.isGrowable = bl2;
            enumHelper.addInstance(string, this);
        }

        public static final List values() {
            return enumHelper.values();
        }

        public static final ExpandMode valueOf(String string) {
            return (ExpandMode)enumHelper.valueOf(string);
        }

        public String toString() {
            return this.name;
        }

        public static final EnumParser getParser() {
            return enumHelper.getParser();
        }

        public boolean isShrinkable() {
            return this.isShrinkable;
        }

        public boolean isGrowable() {
            return this.isGrowable;
        }

        public static ExpandMode fromWeights(int n, int n2) {
            if (n == -1 && n2 == -1) {
                return null;
            }
            if (n > 0) {
                return n2 > 0 ? DYNAMIC : SHRINK;
            }
            if (n2 > 0) {
                return GROW;
            }
            return FIXED;
        }
    }
}

