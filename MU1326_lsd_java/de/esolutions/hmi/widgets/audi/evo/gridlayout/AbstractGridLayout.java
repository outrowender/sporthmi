/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractGridLayout
implements WidgetConstants {
    public static final int HUGE_SIZE = 1000000;
    private static final int[] EMPTY_ARRAY = new int[0];
    private static final int ARRAY_ELEMENTS_PER_TABULATOR = 2;
    public static final int HIDEMODE_INVISIBLE_WIDGETS_LEAVE_CELL_EMPTY = 0;
    public static final int HIDEMODE_USE_PREFERRED_SIZE = 1;
    public static final int HIDEMODE_INVISIBLE_OR_EMPTY_WIDGETS_LEAVE_CELL_EMPTY = 2;
    protected IAxisConstraints columnConstraints;
    protected IAxisConstraints rowConstraints;
    protected Object[] widgets;
    protected IGridLayoutHints[] widgetConstraints;
    private LayoutData[] cachedLayouts;
    private Boolean cachedHasDynamicHeight;
    private int[] tabulators = EMPTY_ARRAY;
    protected int state = 2;

    private int[] getAxisBounds(boolean bl, LayoutData layoutData) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AxisPreferredSizes axisPreferredSizes = bl ? layoutData.columnsPref : layoutData.rowsPref;
        AxisActualSizes axisActualSizes = bl ? layoutData.columnsActual : layoutData.rowsActual;
        int[] nArray = new int[iAxisConstraints.getLength() * 2];
        int n = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            nArray[i2 * 2] = n += AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints);
            nArray[i2 * 2 + 1] = (n += axisActualSizes.actual[i2]) - 1;
        }
        return nArray;
    }

    protected int[][] setChildrenBounds(LayoutData layoutData, boolean bl, boolean bl2) {
        ArrayList arrayList = null;
        if (bl) {
            arrayList = new ArrayList(this.widgets.length);
        }
        for (int i2 = 0; i2 < this.widgets.length; ++i2) {
            IGridLayoutHints iGridLayoutHints = this.widgetConstraints[i2];
            if (this.shouldSetChildrenBounds(this.widgets[i2], iGridLayoutHints, layoutData.state, bl)) {
                this.setChildBounds(this.widgets[i2], iGridLayoutHints, layoutData, arrayList, bl2);
                continue;
            }
            this.hideWidget(this.widgets[i2], arrayList);
        }
        if (arrayList != null) {
            return (int[][])arrayList.toArray((Object[])new int[arrayList.size()][]);
        }
        return null;
    }

    boolean shouldSetChildrenBounds(Object object, IGridLayoutHints iGridLayoutHints, int n, boolean bl) {
        if (!this.shouldShowForState(iGridLayoutHints, n)) {
            return false;
        }
        if (bl) {
            return true;
        }
        return this.shouldShowForHidemode(object, iGridLayoutHints, true) && this.shouldShowForHidemode(object, iGridLayoutHints, false);
    }

    protected void hideWidget(Object object, List list) {
        if (list != null) {
            this.simulateHideWidgets(object, list);
        } else {
            this.hideWidget(object);
        }
    }

    private void setChildBounds(Object object, IGridLayoutHints iGridLayoutHints, LayoutData layoutData, List list, boolean bl) {
        int n = this.getChildAreaX(iGridLayoutHints, layoutData);
        int n2 = this.getChildAreaWidth(iGridLayoutHints, layoutData);
        int n3 = this.getChildAreaY(iGridLayoutHints, layoutData);
        int n4 = this.getChildAreaHeight(iGridLayoutHints, layoutData);
        int n5 = this.getChildAlignment(iGridLayoutHints.getAlignmentHoriz(), iGridLayoutHints.getColumn(), this.columnConstraints);
        int n6 = this.getChildAlignment(iGridLayoutHints.getAlignmentVert(), iGridLayoutHints.getRow(), this.rowConstraints);
        this.setChildBoundsInCell(object, n, n3, n2, n4, n5, n6, iGridLayoutHints, layoutData, list, bl);
    }

    private void setChildBoundsInCell(Object object, int n, int n2, int n3, int n4, int n5, int n6, IGridLayoutHints iGridLayoutHints, LayoutData layoutData, List list, boolean bl) {
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        int n12 = n;
        int n13 = n2;
        switch (n5) {
            case 1: {
                n11 = this.getPreferredWidth(object);
                n10 = Math.min(n11, n3);
                break;
            }
            case 3: {
                n9 = this.getPreferredWidth(object);
                n10 = Math.min(n9, n3);
                n12 += n3 - n10;
                break;
            }
            case 2: {
                n8 = this.getPreferredWidth(object);
                n10 = Math.min(n8, n3);
                n12 += (n3 - n10) / 2;
                break;
            }
            case -1: 
            case 8: {
                n10 = n3;
                break;
            }
            default: {
                this.log(10000, "AbstractGridLayout#setChildBoundsInCell: unknown horizontal alignment: %1", n5);
                n10 = n3;
            }
        }
        switch (n6) {
            case 4: {
                n11 = this.getPreferredHeight(object, n10);
                n7 = Math.min(n11, n4);
                break;
            }
            case 6: {
                n9 = this.getPreferredHeight(object, n10);
                n7 = Math.min(n9, n4);
                n13 += n4 - n7;
                break;
            }
            case 5: {
                n8 = this.getPreferredHeight(object, n10);
                n7 = Math.min(n8, n4);
                n13 += (n4 - n7) / 2;
                break;
            }
            case -1: 
            case 9: {
                n7 = n4;
                break;
            }
            case 7: {
                int n14;
                int n15;
                if (iGridLayoutHints.getRowSpan() == 1) {
                    n15 = layoutData.rowsPref.baseline[iGridLayoutHints.getRow()];
                    n14 = this.getBaseline(object);
                    n13 += n15 - n14;
                } else {
                    this.log(100000, "AbstractGridLayout#setChildBoundsInCell: baseline layout is not supported for spanning widgets. Cell: %1 / %2, row span: %3", iGridLayoutHints.getRow(), iGridLayoutHints.getColumn(), iGridLayoutHints.getRowSpan());
                }
                n15 = this.getPreferredHeight(object, n10);
                n7 = Math.min(n15, n4);
                if (n13 + n7 <= n2 + n4) break;
                n14 = n13 + n7 - (n2 + n4);
                this.log(100000, "AbstractGridLayout#setChildBoundsInCell: widget descent extends row height. Cell: %1 / %2, out of cell: %3", iGridLayoutHints.getRow(), iGridLayoutHints.getColumn(), n14);
                break;
            }
            default: {
                this.log(10000, "AbstractGridLayout#setChildBoundsInCell: unknown vertical alignment: %1", n6);
                n7 = n4;
            }
        }
        n12 += iGridLayoutHints.getAdditionalXOffset();
        n13 += iGridLayoutHints.getAdditionalYOffset();
        n10 += iGridLayoutHints.getAdditionalWidthOffset();
        n7 += iGridLayoutHints.getAdditionalHeightOffset();
        if (list != null) {
            this.simulateSetBounds(object, n12, n13, n10, n7, list, bl);
        } else {
            this.setBounds(object, n12, n13, n10, n7);
        }
    }

    private int getChildAlignment(int n, int n2, IAxisConstraints iAxisConstraints) {
        if (n != -1) {
            return n;
        }
        return iAxisConstraints.getAlignment(n2);
    }

    private int getChildAreaX(IGridLayoutHints iGridLayoutHints, LayoutData layoutData) {
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getColumn(); ++i2) {
            n += layoutData.columnsActual.actual[i2] + AbstractGridLayout.getGap(i2, layoutData.columnsPref, this.columnConstraints);
        }
        if (!this.hasFlag(iGridLayoutHints.getOverlapGaps(), 4)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn(), layoutData.columnsPref, this.columnConstraints);
        }
        return n;
    }

    private int getChildAreaY(IGridLayoutHints iGridLayoutHints, LayoutData layoutData) {
        if (layoutData.rowsActual.actual == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getRow(); ++i2) {
            n += layoutData.rowsActual.actual[i2] + AbstractGridLayout.getGap(i2, layoutData.rowsPref, this.rowConstraints);
        }
        if (!this.hasFlag(iGridLayoutHints.getOverlapGaps(), 1)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow(), layoutData.rowsPref, this.rowConstraints);
        }
        return n;
    }

    private int getChildAreaWidth(IGridLayoutHints iGridLayoutHints, LayoutData layoutData) {
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getColumnSpan(); ++i2) {
            int n2 = iGridLayoutHints.getColumn() + i2;
            n += layoutData.columnsActual.actual[n2];
            if (i2 <= 0) continue;
            n += AbstractGridLayout.getGap(n2, layoutData.columnsPref, this.columnConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 4)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn(), layoutData.columnsPref, this.columnConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 8)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn() + iGridLayoutHints.getColumnSpan(), layoutData.columnsPref, this.columnConstraints);
        }
        if (iGridLayoutHints.getWidthMax() != -1) {
            n = Math.min(n, iGridLayoutHints.getWidthMax());
        }
        if (iGridLayoutHints.getWidthMin() != -1) {
            n = Math.max(n, iGridLayoutHints.getWidthMin());
        }
        return n;
    }

    private int getChildAreaHeight(IGridLayoutHints iGridLayoutHints, LayoutData layoutData) {
        if (layoutData.rowsActual.actual == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getRowSpan(); ++i2) {
            int n2 = iGridLayoutHints.getRow() + i2;
            n += layoutData.rowsActual.actual[n2];
            if (i2 <= 0) continue;
            n += AbstractGridLayout.getGap(n2, layoutData.rowsPref, this.rowConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 1)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow(), layoutData.rowsPref, this.rowConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 2)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow() + iGridLayoutHints.getRowSpan(), layoutData.rowsPref, this.rowConstraints);
        }
        if (iGridLayoutHints.getHeightMax() != -1) {
            n = Math.min(n, iGridLayoutHints.getHeightMax());
        }
        if (iGridLayoutHints.getHeightMin() != -1) {
            n = Math.max(n, iGridLayoutHints.getHeightMin());
        }
        return n;
    }

    protected int[] calculatePreferredSizeFromCachedData(LayoutData layoutData) {
        int n;
        int n2 = 0;
        for (n = 0; n < this.columnConstraints.getLength(); ++n) {
            n2 += layoutData.columnsPref.pref[n] + AbstractGridLayout.getGap(n, layoutData.columnsPref, this.columnConstraints);
        }
        if (this.columnConstraints.getLength() > 0) {
            n2 += AbstractGridLayout.getGap(this.columnConstraints.getLength(), layoutData.columnsPref, this.columnConstraints);
        }
        n = 0;
        for (int i2 = 0; i2 < this.rowConstraints.getLength(); ++i2) {
            n += layoutData.rowsPref.pref[i2] + AbstractGridLayout.getGap(i2, layoutData.rowsPref, this.rowConstraints);
        }
        if (this.rowConstraints.getLength() > 0) {
            n += AbstractGridLayout.getGap(this.rowConstraints.getLength(), layoutData.rowsPref, this.rowConstraints);
        }
        return new int[]{n2, n};
    }

    protected int calculateTabulatorFromCachedData(int n, LayoutData layoutData) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.columnConstraints.getLength() + 1; ++i2) {
            n2 += AbstractGridLayout.getGap(i2, layoutData.columnsPref, this.columnConstraints);
            if (this.columnConstraints.getTabulatorID(i2) == n) {
                return n2;
            }
            if (i2 >= this.columnConstraints.getLength()) continue;
            n2 += layoutData.columnsActual.actualWithoutTabulator[i2];
        }
        this.log(100000, "AbstractGridLayout#calculateTabulator: tabulator %1 not defined", n);
        return -1;
    }

    public boolean setTabulator(int n, int n2) {
        if (!this.columnConstraints.hasTabulatorWithID(n)) {
            return false;
        }
        int n3 = this.storeTabulatorValue(n, n2);
        if (n2 != n3) {
            this.flushCache();
            return true;
        }
        return false;
    }

    private int storeTabulatorValue(int n, int n2) {
        int n3 = this.findTabulatorIndex(n);
        if (n2 != -1) {
            if (n3 != -1) {
                int n4 = this.tabulators[n3 + 1];
                this.tabulators[n3 + 1] = n2;
                return n4;
            }
            int[] nArray = new int[this.tabulators.length + 2];
            System.arraycopy((Object)this.tabulators, 0, (Object)nArray, 0, this.tabulators.length);
            nArray[this.tabulators.length] = n;
            nArray[this.tabulators.length + 1] = n2;
            this.tabulators = nArray;
            return -1;
        }
        if (n3 != -1) {
            int n5 = this.tabulators[n3 + 1];
            int n6 = this.tabulators.length - 2;
            if (n6 == 0) {
                this.tabulators = EMPTY_ARRAY;
            } else {
                int[] nArray = new int[n6];
                System.arraycopy((Object)this.tabulators, 0, (Object)nArray, 0, n3);
                System.arraycopy((Object)this.tabulators, n3 + 2, (Object)nArray, n3, n6 - n3);
                this.tabulators = nArray;
            }
            return n5;
        }
        return -1;
    }

    public int getTabulator(int n) {
        int n2 = this.findTabulatorIndex(n);
        if (n2 != -1) {
            return this.tabulators[n2 + 1];
        }
        return -1;
    }

    private int findTabulatorIndex(int n) {
        for (int i2 = 0; i2 < this.tabulators.length; i2 += 2) {
            if (this.tabulators[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    public boolean hasTabulators() {
        return this.tabulators.length > 0;
    }

    public int[] getTabulatorIDs() {
        return this.columnConstraints.getTabulatorIDs();
    }

    protected void layoutInternal(int n, int n2) {
        LayoutData layoutData = this.checkCacheActualSize(n, n2, true, this.state);
        this.setChildrenBounds(layoutData, false, false);
    }

    protected int[][] simulateLayoutInternal(int n, int n2, boolean bl) {
        LayoutData layoutData = this.getLayoutData(this.state, n);
        if (!this.isCachedPreferredSize(layoutData)) {
            this.calculatePreferredSize(layoutData);
        }
        LayoutData layoutData2 = new LayoutData(this.state, n);
        layoutData2.columnsPref = layoutData.columnsPref;
        layoutData2.rowsPref = layoutData.rowsPref;
        layoutData2.columnsActual = new AxisActualSizes(n);
        layoutData2.rowsActual = new AxisActualSizes(n2);
        this.calculateActualSizeGrid(n, n2, true, layoutData2);
        return this.setChildrenBounds(layoutData2, true, bl);
    }

    protected int[] calculateRows(int n, int n2) {
        LayoutData layoutData = this.checkCacheActualSize(n, n2, true, this.state);
        return this.getAxisBounds(false, layoutData);
    }

    protected int[] calculateColumns(int n, int n2) {
        LayoutData layoutData = this.checkCacheActualSize(n, n2, true, this.state);
        return this.getAxisBounds(true, layoutData);
    }

    protected int[] calculateSizeInternal(int n, int n2) {
        LayoutData layoutData = this.checkCachePreferredSize(n, n2);
        return this.calculatePreferredSizeFromCachedData(layoutData);
    }

    protected int calculateTabulatorInternal(int n, int n2, int n3) {
        if (!this.columnConstraints.hasTabulatorIDs()) {
            this.log(100000, "AbstractGridLayout#calculateTabulator: no tabulators defined. tabulatorID: %1", n3);
            return -1;
        }
        LayoutData layoutData = this.checkCacheActualSize(n, n2, false, this.state);
        return this.calculateTabulatorFromCachedData(n3, layoutData);
    }

    protected LayoutData checkCachePreferredSize(int n, int n2) {
        LayoutData layoutData = this.getLayoutData(n, n2);
        if (!this.isCachedPreferredSize(layoutData)) {
            this.calculatePreferredSize(layoutData);
        }
        return layoutData;
    }

    protected LayoutData checkCacheActualSize(int n, int n2, boolean bl, int n3) {
        LayoutData layoutData = this.getLayoutData(n3, n);
        if (!this.isCachedPreferredSize(layoutData)) {
            this.calculatePreferredSize(layoutData);
        }
        if (!this.isCachedActualSize(layoutData, n, n2, bl)) {
            layoutData.columnsActual = new AxisActualSizes(n);
            layoutData.rowsActual = new AxisActualSizes(n2);
            this.calculateActualSizeGrid(n, n2, bl, layoutData);
        }
        return layoutData;
    }

    private LayoutData getLayoutData(int n, int n2) {
        LayoutData layoutData;
        int n3 = this.cachedLayouts == null ? 0 : this.cachedLayouts.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            layoutData = this.cachedLayouts[i2];
            if (!this.isCachedForState(layoutData, n, n2)) continue;
            return layoutData;
        }
        LayoutData[] layoutDataArray = new LayoutData[n3 + 1];
        if (this.cachedLayouts != null) {
            System.arraycopy((Object)this.cachedLayouts, 0, (Object)layoutDataArray, 0, n3);
        }
        layoutDataArray[n3] = layoutData = new LayoutData(n, n2);
        this.cachedLayouts = layoutDataArray;
        return layoutData;
    }

    private boolean isCachedForState(LayoutData layoutData, int n, int n2) {
        if (layoutData.state != n) {
            return false;
        }
        if (this.hasDynamicHeight()) {
            return layoutData.widthHint == n2;
        }
        return true;
    }

    private boolean isCachedPreferredSize(LayoutData layoutData) {
        if (!layoutData.hasPreferredSizes()) {
            return false;
        }
        return layoutData.columnsPref.pref != null;
    }

    private boolean isCachedActualSize(LayoutData layoutData, int n, int n2, boolean bl) {
        if (!layoutData.hasActualSizes()) {
            return false;
        }
        if (layoutData.columnsActual.containerSize != n || layoutData.rowsActual.containerSize != n2) {
            return false;
        }
        int[] nArray = bl ? layoutData.columnsActual.actual : layoutData.columnsActual.actualWithoutTabulator;
        return nArray != null;
    }

    public void flushCache() {
        this.cachedLayouts = null;
        this.cachedHasDynamicHeight = null;
    }

    protected void calculateActualSizeGrid(int n, int n2, boolean bl, LayoutData layoutData) {
        this.calculateActualSizeAxis(n, true, bl, layoutData);
        this.calculateActualSizeAxis(n2, false, bl, layoutData);
    }

    protected void calculateActualSizeAxis(int n, boolean bl, boolean bl2, LayoutData layoutData) {
        AxisActualSizes axisActualSizes;
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AxisPreferredSizes axisPreferredSizes = bl ? layoutData.columnsPref : layoutData.rowsPref;
        AxisActualSizes axisActualSizes2 = axisActualSizes = bl ? layoutData.columnsActual : layoutData.rowsActual;
        if (bl && bl2 && this.hasTabulators() && iAxisConstraints.hasTabulatorIDs()) {
            this.applyTabulators(axisPreferredSizes, axisActualSizes, iAxisConstraints);
        } else {
            this.applyShrinkGrow(axisPreferredSizes, axisActualSizes, iAxisConstraints, n, bl2);
        }
        this.clonePrefToActual(axisPreferredSizes, axisActualSizes, bl2);
    }

    protected void calculatePreferredSize(LayoutData layoutData) {
        layoutData.columnsPref = this.createAxisLayoutData(this.columnConstraints);
        layoutData.rowsPref = this.createAxisLayoutData(this.rowConstraints);
        this.calculatePreferredAxisSize(layoutData, true, null);
        int[][] nArray = null;
        if (this.hasDynamicHeight() && layoutData.widthHint != -1) {
            LayoutData layoutData2 = new LayoutData(this.state, layoutData.widthHint);
            layoutData2.columnsPref = layoutData.columnsPref;
            layoutData2.rowsPref = this.createAxisLayoutData(this.rowConstraints);
            layoutData2.rowsPref.baseline = new int[this.rowConstraints.getLength()];
            layoutData2.columnsActual = new AxisActualSizes(layoutData.widthHint);
            layoutData2.rowsActual = new AxisActualSizes(0);
            this.calculateActualSizeAxis(layoutData2.widthHint, true, true, layoutData2);
            nArray = this.setChildrenBounds(layoutData2, true, false);
        }
        this.calculatePreferredAxisSize(layoutData, false, nArray);
    }

    public boolean hasDynamicHeight() {
        if (this.cachedHasDynamicHeight == null) {
            this.cachedHasDynamicHeight = this.calculateHasDynamicHeight();
        }
        return this.cachedHasDynamicHeight;
    }

    private boolean calculateHasDynamicHeight() {
        for (int i2 = 0; i2 < this.widgets.length; ++i2) {
            if (!this.hasDynamicHeight(this.widgets[i2])) continue;
            return true;
        }
        return false;
    }

    private AxisPreferredSizes createAxisLayoutData(IAxisConstraints iAxisConstraints) {
        AxisPreferredSizes axisPreferredSizes = new AxisPreferredSizes(iAxisConstraints.getLength());
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            int n = iAxisConstraints.getSize(i2);
            int n2 = iAxisConstraints.getMin(i2);
            int n3 = iAxisConstraints.getMax(i2);
            axisPreferredSizes.pref[i2] = n != -1 ? n : 0;
            axisPreferredSizes.min[i2] = n2 != -1 ? n2 : 0;
            axisPreferredSizes.max[i2] = n3 != -1 ? n3 : 1000000;
        }
        return axisPreferredSizes;
    }

    protected void calculatePreferredAxisSize(LayoutData layoutData, boolean bl, int[][] nArray) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AxisPreferredSizes axisPreferredSizes = bl ? layoutData.columnsPref : layoutData.rowsPref;
        boolean[] blArray = new boolean[iAxisConstraints.getLength()];
        this.collectWidgetSizes(layoutData, blArray, bl, nArray);
        this.collectGaps(axisPreferredSizes, iAxisConstraints, blArray);
        this.applyMinMax(axisPreferredSizes, iAxisConstraints);
        this.applySpanData(axisPreferredSizes, iAxisConstraints);
    }

    private void collectWidgetSizes(LayoutData layoutData, boolean[] blArray, boolean bl, int[][] nArray) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AxisPreferredSizes axisPreferredSizes = bl ? layoutData.columnsPref : layoutData.rowsPref;
        for (int i2 = 0; i2 < this.widgetConstraints.length; ++i2) {
            int n;
            int n2;
            IGridLayoutHints iGridLayoutHints = this.widgetConstraints[i2];
            Object object = this.widgets[i2];
            if (iGridLayoutHints.isIgnoreForCellSizes() || !this.shouldShowForState(iGridLayoutHints, layoutData.state)) continue;
            int n3 = bl ? iGridLayoutHints.getColumn() : iGridLayoutHints.getRow();
            int n4 = bl ? iGridLayoutHints.getColumnSpan() : iGridLayoutHints.getRowSpan();
            int n5 = bl ? iGridLayoutHints.getWidthMin() : iGridLayoutHints.getHeightMin();
            int n6 = n2 = bl ? iGridLayoutHints.getWidthMax() : iGridLayoutHints.getHeightMax();
            if (bl) {
                n = this.getPreferredWidth(object);
            } else if (nArray != null) {
                int n7 = nArray[i2][2];
                n = this.getPreferredHeight(object, n7);
            } else {
                n = this.getPreferredHeight(object);
            }
            if (this.shouldShowForHidemode(object, iGridLayoutHints, bl)) {
                this.collectWidgetSize(axisPreferredSizes, iAxisConstraints, blArray, n3, n4, n, n5, n2);
            }
            if (bl) continue;
            this.collectBaseline(object, iGridLayoutHints, axisPreferredSizes);
        }
    }

    private void collectBaseline(Object object, IGridLayoutHints iGridLayoutHints, AxisPreferredSizes axisPreferredSizes) {
        boolean bl;
        if (iGridLayoutHints.getRowSpan() != 1) {
            return;
        }
        int n = iGridLayoutHints.getRow();
        boolean bl2 = this.rowConstraints.hasAlignment(n) && this.rowConstraints.getAlignment(n) == 7;
        boolean bl3 = bl = iGridLayoutHints.getAlignmentVert() == 7;
        if (bl2 || bl) {
            if (axisPreferredSizes.baseline == null) {
                axisPreferredSizes.baseline = new int[this.rowConstraints.getLength()];
            }
            int n2 = this.getBaseline(object);
            axisPreferredSizes.baseline[n] = Math.max(axisPreferredSizes.baseline[n], n2);
        }
    }

    private void collectGaps(AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints, boolean[] blArray) {
        int n;
        boolean bl = true;
        int n2 = -1;
        int n3 = -1;
        for (n = 0; n < blArray.length; ++n) {
            bl &= blArray[n];
            if (!blArray[n]) continue;
            if (n2 == -1) {
                n2 = n;
            }
            n3 = n;
        }
        if (bl) {
            return;
        }
        axisPreferredSizes.gaps = new int[iAxisConstraints.getLength() + 1];
        n = 0;
        boolean bl2 = true;
        for (int i2 = 0; i2 < iAxisConstraints.getLength() + 1; ++i2) {
            boolean bl3 = i2 == iAxisConstraints.getLength() || blArray[i2];
            int n4 = iAxisConstraints.getGap(i2);
            if (i2 == 0 || i2 == iAxisConstraints.getLength()) {
                axisPreferredSizes.gaps[i2] = n4;
                continue;
            }
            if (n2 >= i2 || i2 > n3) continue;
            if (bl2 || bl3) {
                int n5;
                axisPreferredSizes.gaps[i2] = n5 = bl2 ? n4 : Math.max(n4, n) - n;
                n = n5;
            }
            bl2 = bl3;
        }
    }

    boolean shouldShowForState(IGridLayoutHints iGridLayoutHints, int n) {
        return iGridLayoutHints.shouldShow(n);
    }

    boolean shouldShowForHidemode(Object object, IGridLayoutHints iGridLayoutHints, boolean bl) {
        int n = this.getHidemode(iGridLayoutHints, bl);
        if (this.isWidgetVisible(object)) {
            if (n == 2) {
                return this.widgetHasContent(object);
            }
            return true;
        }
        return n == 1;
    }

    private int getHidemode(IGridLayoutHints iGridLayoutHints, boolean bl) {
        if (iGridLayoutHints.getHidemode() != -1) {
            return iGridLayoutHints.getHidemode();
        }
        return bl ? this.columnConstraints.getHidemode(iGridLayoutHints.getColumn()) : this.rowConstraints.getHidemode(iGridLayoutHints.getRow());
    }

    private void collectWidgetSize(AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints, boolean[] blArray, int n, int n2, int n3, int n4, int n5) {
        if (n2 == 1) {
            if (!iAxisConstraints.hasFixedSize(n)) {
                if (n3 == -1) {
                    n3 = axisPreferredSizes.pref[n];
                }
                if (n5 != -1) {
                    n3 = Math.min(n3, n5);
                }
                if (n4 != -1) {
                    n3 = Math.max(n3, n4);
                }
                axisPreferredSizes.pref[n] = Math.max(axisPreferredSizes.pref[n], n3);
            }
        } else {
            SpanData spanData = axisPreferredSizes.createSpanData();
            spanData.start = n;
            spanData.span = n2;
            spanData.pref = n3;
            spanData.min = n4 != -1 ? n4 : 0;
            spanData.max = n5 != -1 ? n5 : 1000000;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            blArray[n + i2] = true;
        }
    }

    private void applyMinMax(AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n;
        for (n = 0; n < iAxisConstraints.getLength(); ++n) {
            if (iAxisConstraints.hasFixedSize(n)) continue;
            axisPreferredSizes.pref[n] = Math.min(axisPreferredSizes.pref[n], axisPreferredSizes.max[n]);
        }
        for (n = 0; n < iAxisConstraints.getLength(); ++n) {
            if (iAxisConstraints.hasFixedSize(n)) continue;
            axisPreferredSizes.pref[n] = Math.max(axisPreferredSizes.pref[n], axisPreferredSizes.min[n]);
        }
    }

    private void applySpanData(AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        axisPreferredSizes.sortSpanData();
        Iterator iterator = axisPreferredSizes.spanData.iterator();
        while (iterator.hasNext()) {
            SpanData spanData = (SpanData)iterator.next();
            this.applySpanData(spanData, axisPreferredSizes, iAxisConstraints);
        }
    }

    private void applySpanData(SpanData spanData, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n = this.calculateRequiredSpanAdjustment(spanData, axisPreferredSizes, iAxisConstraints);
        if (n <= 0) {
            return;
        }
        int[] nArray = this.calculateTabulatorsInSpanArea(spanData, axisPreferredSizes, iAxisConstraints);
        int n2 = spanData.start;
        for (int i2 = 0; i2 < nArray.length; i2 += 2) {
            int n3 = nArray[i2] - 1;
            int n4 = nArray[i2 + 1];
            if (n4 > 0) {
                int n5 = Math.min(n, n4);
                n -= this.adjustSizeShrinkGrow(n2, n3, n5, true, axisPreferredSizes.pref, axisPreferredSizes, iAxisConstraints);
                if ((n -= this.adjustSize(n2, n3, n5, true, axisPreferredSizes.pref, axisPreferredSizes, iAxisConstraints)) == 0) {
                    return;
                }
            }
            n2 = n3;
        }
        n -= this.adjustSizeShrinkGrow(n2, spanData.getEnd(), n, true, axisPreferredSizes.pref, axisPreferredSizes, iAxisConstraints);
        n -= this.adjustSize(n2, spanData.getEnd(), n, true, axisPreferredSizes.pref, axisPreferredSizes, iAxisConstraints);
    }

    private int adjustSize(int n, int n2, int n3, boolean bl, int[] nArray, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (n3 == 0) {
            return 0;
        }
        int n4 = n3;
        for (int i2 = n2; i2 >= n; --i2) {
            if (iAxisConstraints.hasFixedSize(i2)) continue;
            int n5 = this.getCellChange(i2, nArray[i2], n4, bl, axisPreferredSizes);
            int n6 = i2;
            nArray[n6] = nArray[n6] + n5;
            if ((n4 -= n5) <= 0) break;
        }
        return n3 - n4;
    }

    private int[] calculateTabulatorsInSpanArea(SpanData spanData, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (!this.hasTabulators() || !iAxisConstraints.hasTabulatorIDs()) {
            return EMPTY_ARRAY;
        }
        int[] nArray = new int[this.tabulators.length / 2 * 2];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 <= spanData.getEnd(); ++i2) {
            int n4;
            n3 += AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints);
            if (iAxisConstraints.getTabulatorID(i2) != -1 && (n4 = this.getTabulator(iAxisConstraints.getTabulatorID(i2))) != -1) {
                if (i2 > spanData.start) {
                    int n5;
                    nArray[n] = i2;
                    nArray[n + 1] = n5 = n4 - n3;
                    n += 2;
                    ++n2;
                }
                n3 = n4;
            }
            n3 += axisPreferredSizes.pref[i2];
        }
        int[] nArray2 = new int[n2 * 2];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray2.length);
        return nArray2;
    }

    private int calculateRequiredSpanAdjustment(SpanData spanData, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n = Math.max(spanData.min, spanData.pref);
        int n2 = n = Math.min(spanData.max, n);
        for (int i2 = spanData.start; i2 <= spanData.getEnd(); ++i2) {
            n2 -= axisPreferredSizes.pref[i2];
            if (i2 <= spanData.start) continue;
            n2 -= AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints);
        }
        return n2;
    }

    private void applyTabulators(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints) {
        if (!iAxisConstraints.hasTabulatorIDs()) {
            return;
        }
        int n = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength() + 1; ++i2) {
            int n3 = this.applyTabulator(axisPreferredSizes, axisActualSizes, iAxisConstraints, n2, i2, n += AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints));
            n += n3;
            if (i2 < iAxisConstraints.getLength()) {
                n += this.getCellSizeBeforeGrowShrink(axisPreferredSizes, axisActualSizes, i2, true);
            }
            if (iAxisConstraints.getTabulatorID(i2) == -1) continue;
            n2 = i2;
        }
    }

    private int applyTabulator(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints, int n, int n2, int n3) {
        int n4;
        int n5 = this.getTabulatorOffset(iAxisConstraints, n2, n3);
        if (n5 == 0) {
            return 0;
        }
        if ((n5 -= (n4 = this.adjustColumnsForTabulator(axisPreferredSizes, axisActualSizes, iAxisConstraints, n, n2, n5, true))) != 0) {
            this.log(100000, "AbstractGridLayout#applyTabulator: must break min/max constraints for tabulator %1, remaining space: %2", iAxisConstraints.getTabulatorID(n2), n5);
            n4 += this.adjustColumnsForTabulator(axisPreferredSizes, axisActualSizes, iAxisConstraints, n, n2, n5, false);
        }
        if (n4 != 0) {
            this.adaptSpanAfterTabulator(axisPreferredSizes, axisActualSizes, iAxisConstraints, n2);
        }
        return n4;
    }

    private void adaptSpanAfterTabulator(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints, int n) {
        Iterator iterator = axisPreferredSizes.spanData.iterator();
        while (iterator.hasNext()) {
            int n2;
            SpanData spanData = (SpanData)iterator.next();
            if (!spanData.contains(n)) continue;
            int n3 = 0;
            for (n2 = spanData.start; n2 <= spanData.getEnd(); ++n2) {
                int n4 = axisPreferredSizes.pref[n2] - axisActualSizes.actual[n2];
                n3 += n4;
            }
            n2 = this.adjustSizeShrinkGrow(n, spanData.getEnd(), n3, true, axisActualSizes.actual, axisPreferredSizes, iAxisConstraints);
            n3 -= n2;
            n2 += this.adjustSize(n, spanData.getEnd(), n3, true, axisActualSizes.actual, axisPreferredSizes, iAxisConstraints);
        }
    }

    private int adjustColumnsForTabulator(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints, int n, int n2, int n3, boolean bl) {
        this.initializeActualSizes(axisPreferredSizes, axisActualSizes, true);
        int n4 = this.adjustSizeShrinkGrow(n, n2 - 1, n3, bl, axisActualSizes.actual, axisPreferredSizes, iAxisConstraints);
        n3 -= n4;
        return n4 += this.adjustSize(n, n2 - 1, n3, bl, axisActualSizes.actual, axisPreferredSizes, iAxisConstraints);
    }

    private int getCellChange(int n, int n2, int n3, boolean bl, AxisPreferredSizes axisPreferredSizes) {
        if (n3 > 0) {
            int n4 = bl ? axisPreferredSizes.max[n] : 1000000;
            int n5 = n4 - n2;
            return Math.min(n5, n3);
        }
        int n6 = bl ? axisPreferredSizes.min[n] : 0;
        int n7 = n6 - n2;
        return Math.max(n7, n3);
    }

    private int getTabulatorOffset(IAxisConstraints iAxisConstraints, int n, int n2) {
        int n3 = iAxisConstraints.getTabulatorID(n);
        if (n3 == -1) {
            return 0;
        }
        int n4 = this.getTabulator(n3);
        if (n4 == -1) {
            return 0;
        }
        if (n == 0) {
            this.log(100000, "AbstractGridLayout#applyTabulators: can not set tabulator for first column. tabID: %1, value: %2", n3, n4);
            return 0;
        }
        return n4 - n2;
    }

    private int adjustSizeShrinkGrow(int n, int n2, int n3, boolean bl, int[] nArray, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (n3 == 0) {
            return 0;
        }
        boolean bl2 = n3 > 0;
        float f2 = this.sumWeights(iAxisConstraints, bl2, n, n2);
        if (f2 == 0.0f) {
            return 0;
        }
        int n4 = n2 - n + 1;
        boolean[] blArray = new boolean[n4];
        int n5 = 0;
        int n6 = n4;
        float f3 = 0.0f;
        int[] nArray2 = null;
        for (int i2 = 0; i2 < n6; ++i2) {
            int n7;
            int n8;
            int n9 = 0;
            f3 = 0.0f;
            if (!bl2) {
                float f4 = Float.MIN_VALUE;
                for (n8 = n; n8 <= n2; ++n8) {
                    if (!((float)nArray[n8] > f4) || !(iAxisConstraints.getShrinkWeight(n8) > 0.0f)) continue;
                    f4 = nArray[n8];
                }
                float f5 = 0.0f;
                float f6 = Float.MAX_VALUE;
                for (n7 = n; n7 <= n2; ++n7) {
                    float f7 = f4 - (float)nArray[n7];
                    if (!(f7 > 0.0f) || !(f7 < f6) || !(iAxisConstraints.getShrinkWeight(n7) > 0.0f)) continue;
                    f6 = f7;
                    f5 = nArray[n7];
                }
                nArray2 = this.calculatSizeForShrinkedCells(n, n2, n3, nArray, f5, iAxisConstraints, bl);
            } else {
                nArray2 = this.calculateAdjustShrinkGrowBeforeMinMax(n, n2, n3, f2, blArray, iAxisConstraints);
            }
            boolean bl3 = false;
            for (n8 = 0; n8 < nArray2.length; ++n8) {
                if (nArray2[n8] == 0) continue;
                bl3 = true;
                break;
            }
            if (!bl3) {
                return n5;
            }
            for (n8 = 0; n8 < nArray2.length; ++n8) {
                int n10 = nArray2[n8];
                n7 = n8 + n;
                if (n10 != 0 && n3 != 0) {
                    int n11 = this.getCellChange(n7, nArray[n7], n10, bl, axisPreferredSizes);
                    int n12 = n7;
                    nArray[n12] = nArray[n12] + n11;
                    n5 += n11;
                    if (!bl2) {
                        n3 -= n11;
                    }
                    if (n11 == n10) {
                        float f8 = iAxisConstraints.getResizeWeight(bl2, n7);
                        f3 += f8;
                        continue;
                    }
                    int n13 = n10 - n11;
                    n9 += n13;
                    blArray[n8] = true;
                    continue;
                }
                if (blArray[n8]) continue;
                float f9 = iAxisConstraints.getResizeWeight(bl2, n7);
                f3 += f9;
            }
            if (!bl2) {
                n8 = 1;
                for (int i3 = n; i3 <= n2; ++i3) {
                    if (nArray[i3] == 0 || !(iAxisConstraints.getShrinkWeight(i3) > 0.0f)) continue;
                    n8 = 0;
                    break;
                }
                if (n3 == 0 || n8 != 0) {
                    if (n8 != 0) {
                        this.log(100000, "AbstractGridLayout#adjustSizeShrinkGrow: No more space to shrink cells, remainingAdditionalSpace: %1 ", n9);
                    }
                    return n5;
                }
            } else if (n9 == 0) {
                return n5;
            }
            if (f3 == 0.0f) {
                this.log(100000, "AbstractGridLayout#adjustSizeShrinkGrow: Can't distribute all the required space due to min/max constraints. From: %1, To: %2, remainingAdditionalSpace: %3 ", n, n2, n9);
                return n5;
            }
            if (bl2) {
                n3 = n9;
            }
            f2 = f3;
        }
        this.log(10000, "AbstractGridLayout#adjustSizeShrinkGrow: can't find stable grow/shrink weights. This should not happen. From: %1, To: %2, weightSum: %3", (double)n, (double)n2, f2);
        return n5;
    }

    private boolean[] calcShrinkCells(int n, int n2, int[] nArray, float f2, IAxisConstraints iAxisConstraints, boolean bl) {
        int n3 = n2 - n + 1;
        boolean[] blArray = new boolean[n3];
        int n4 = 0;
        for (int i2 = n; i2 <= n2; ++i2) {
            if ((float)nArray[i2] > f2 && iAxisConstraints.getShrinkWeight(i2) > 0.0f) {
                if (bl && iAxisConstraints.getMin(i2) > 0) {
                    if (iAxisConstraints.getMin(i2) < nArray[i2]) {
                        blArray[n4] = true;
                    }
                } else {
                    blArray[n4] = true;
                }
            }
            ++n4;
        }
        return blArray;
    }

    private int[] calculatSizeForShrinkedCells(int n, int n2, float f2, int[] nArray, float f3, IAxisConstraints iAxisConstraints, boolean bl) {
        boolean[] blArray = this.calcShrinkCells(n, n2, nArray, f3, iAxisConstraints, bl);
        int n3 = n2 - n + 1;
        int[] nArray2 = new int[n3];
        float f4 = 0.0f;
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (!blArray[i2]) continue;
            f4 += 1.0f;
        }
        float f5 = f2 / f4;
        for (int i3 = n; i3 <= n2; ++i3) {
            if (blArray[i3 - n]) {
                float f6 = f3 - (float)nArray[i3];
                f6 = bl && iAxisConstraints.getMin(i3) > 0 ? (float)(iAxisConstraints.getMin(i3) - nArray[i3]) : f3 - (float)nArray[i3];
                if (f6 < f5) {
                    f6 = f5;
                }
                if (Math.abs(f5) < 1.0f) {
                    nArray2[i3 - n] = (int)(f6 - 1.0f);
                    continue;
                }
                nArray2[i3 - n] = (int)f6;
                continue;
            }
            nArray2[i3 - n] = 0;
        }
        return nArray2;
    }

    private int[] calculateAdjustShrinkGrowBeforeMinMax(int n, int n2, int n3, float f2, boolean[] blArray, IAxisConstraints iAxisConstraints) {
        int n4;
        boolean bl = n3 > 0;
        int n5 = n2 - n + 1;
        int[] nArray = new int[n5];
        float[] fArray = null;
        float f3 = 0.0f;
        for (n4 = n; n4 <= n2; ++n4) {
            float f4;
            int n6 = n4 - n;
            if (blArray[n6] || !((f4 = iAxisConstraints.getResizeWeight(bl, n4)) > 0.0f)) continue;
            float f5 = f4 / f2;
            float f6 = (float)n3 * f5;
            int n7 = (int)f6;
            float f7 = f6 - (float)n7;
            if (f7 != 0.0f) {
                if (fArray == null) {
                    fArray = new float[n5];
                }
                fArray[n6] = f7;
                f3 += f7;
            }
            nArray[n6] = n7;
        }
        n4 = Math.round(f3);
        this.distributePartialPixels(nArray, fArray, n4);
        return nArray;
    }

    private void distributePartialPixels(int[] nArray, float[] fArray, int n) {
        int n2;
        if (n == 0) {
            return;
        }
        float[] fArray2 = (float[])fArray.clone();
        Arrays.sort(fArray2, 0, fArray2.length);
        if (n > 0) {
            for (n2 = 0; n2 < fArray2.length / 2; ++n2) {
                int n3 = fArray2.length - 1 - n2;
                float f2 = fArray2[n2];
                fArray2[n2] = fArray2[n3];
                fArray2[n3] = f2;
            }
        }
        n2 = n > 0 ? 1 : -1;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < fArray2.length; ++i2) {
            float f4 = fArray2[i2];
            if (f4 == f3 || f4 == 0.0f) continue;
            f3 = f4;
            for (int i3 = 0; i3 < fArray.length; ++i3) {
                if (fArray[i3] != f4) continue;
                int n4 = i3;
                nArray[n4] = nArray[n4] + n2;
                if ((n -= n2) != 0) continue;
                return;
            }
        }
    }

    private void applyShrinkGrow(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints, int n, boolean bl) {
        int n2 = this.getShrinkGrowSpace(axisPreferredSizes, axisActualSizes, iAxisConstraints, n, bl);
        if (n2 == 0) {
            return;
        }
        int[] nArray = this.initializeActualSizes(axisPreferredSizes, axisActualSizes, bl);
        this.adjustSizeShrinkGrow(0, iAxisConstraints.getLength() - 1, n2, true, nArray, axisPreferredSizes, iAxisConstraints);
    }

    private int getShrinkGrowSpace(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, IAxisConstraints iAxisConstraints, int n, boolean bl) {
        int n2 = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            int n3 = this.getCellSizeBeforeGrowShrink(axisPreferredSizes, axisActualSizes, i2, bl);
            n2 += n3 + AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints);
        }
        return n - (n2 += AbstractGridLayout.getGap(iAxisConstraints.getLength(), axisPreferredSizes, iAxisConstraints));
    }

    public static int getGap(int n, AxisPreferredSizes axisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (axisPreferredSizes.gaps != null) {
            return axisPreferredSizes.gaps[n];
        }
        return iAxisConstraints.getGap(n);
    }

    private int getCellSizeBeforeGrowShrink(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, int n, boolean bl) {
        if (bl && axisActualSizes.actual != null) {
            return axisActualSizes.actual[n];
        }
        return axisPreferredSizes.pref[n];
    }

    private int[] initializeActualSizes(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, boolean bl) {
        int[] nArray;
        int[] nArray2 = nArray = bl ? axisActualSizes.actual : axisActualSizes.actualWithoutTabulator;
        if (nArray != null) {
            return nArray;
        }
        int[] nArray3 = new int[axisPreferredSizes.pref.length];
        System.arraycopy((Object)axisPreferredSizes.pref, 0, (Object)nArray3, 0, axisPreferredSizes.pref.length);
        if (bl) {
            axisActualSizes.actual = nArray3;
            return axisActualSizes.actual;
        }
        axisActualSizes.actualWithoutTabulator = nArray3;
        return axisActualSizes.actualWithoutTabulator;
    }

    private void clonePrefToActual(AxisPreferredSizes axisPreferredSizes, AxisActualSizes axisActualSizes, boolean bl) {
        if (bl) {
            if (axisActualSizes.actual != null) {
                return;
            }
            axisActualSizes.actual = axisPreferredSizes.pref;
        } else {
            if (axisActualSizes.actualWithoutTabulator != null) {
                return;
            }
            axisActualSizes.actualWithoutTabulator = axisPreferredSizes.pref;
        }
    }

    private float sumWeights(IAxisConstraints iAxisConstraints, boolean bl, int n, int n2) {
        if (!iAxisConstraints.hasResizeWeights(bl)) {
            int n3 = bl ? 0 : 1;
            return n3 * (n2 - n + 1);
        }
        float f2 = 0.0f;
        for (int i2 = n; i2 <= n2; ++i2) {
            float f3 = iAxisConstraints.getResizeWeight(bl, i2);
            if (!(f3 > 0.0f)) continue;
            f2 += f3;
        }
        return f2;
    }

    private boolean hasFlag(int n, int n2) {
        return (n & n2) == n2;
    }

    public IAxisConstraints getColumnConstraints() {
        return this.columnConstraints;
    }

    public IGridLayoutHints[] getWidgetConstraints() {
        return this.widgetConstraints;
    }

    public void setColumnConstraints(IAxisConstraints iAxisConstraints) {
        this.columnConstraints = iAxisConstraints;
    }

    public IAxisConstraints getRowConstraints() {
        return this.rowConstraints;
    }

    public void setRowConstraints(IAxisConstraints iAxisConstraints) {
        this.rowConstraints = iAxisConstraints;
    }

    public void setState(int n) {
        this.state = n;
    }

    public int getState() {
        return this.state;
    }

    protected abstract int getPreferredWidth(Object var1);

    protected abstract int getPreferredHeight(Object var1);

    protected abstract boolean hasDynamicHeight(Object var1);

    protected abstract int getPreferredHeight(Object var1, int var2);

    protected abstract int getBaseline(Object var1);

    protected abstract boolean isWidgetVisible(Object var1);

    protected abstract boolean widgetHasContent(Object var1);

    protected abstract void setBounds(Object var1, int var2, int var3, int var4, int var5);

    protected abstract void simulateSetBounds(Object var1, int var2, int var3, int var4, int var5, List var6, boolean var7);

    protected abstract void hideWidget(Object var1);

    protected abstract void simulateHideWidgets(Object var1, List var2);

    protected void log(int n, String string, double d2, double d3, double d4) {
        IWidgetLogChannel.logLayout.log(n, string, d2, d3, d4);
    }

    protected void log(int n, String string, int n2, int n3, int n4) {
        IWidgetLogChannel.logLayout.log(n, string, (long)n2, (long)n3, (long)n4);
    }

    protected void log(int n, String string, long l, long l2) {
        IWidgetLogChannel.logLayout.log(n, string, l, l2);
    }

    protected void log(int n, String string, long l) {
        IWidgetLogChannel.logLayout.log(n, string, l);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.toStringAxis("Columns", this.columnConstraints)).append(",   ");
        stringBuffer.append(this.toStringAxis("Rows", this.rowConstraints));
        return stringBuffer.toString();
    }

    private String toStringAxis(String string, IAxisConstraints iAxisConstraints) {
        if (iAxisConstraints == null) {
            return string + ": null";
        }
        return iAxisConstraints.getLength() + " " + string + ": \"" + iAxisConstraints + "\"";
    }

    public static class SpanData {
        public int start;
        public int span;
        public int pref;
        public int min;
        public int max;

        public int getEnd() {
            return this.start + this.span - 1;
        }

        public boolean contains(int n) {
            return this.start <= n && this.getEnd() >= n;
        }
    }

    public static class LayoutData {
        public int state;
        public int widthHint = -1;
        public AxisPreferredSizes columnsPref;
        public AxisPreferredSizes rowsPref;
        public AxisActualSizes columnsActual;
        public AxisActualSizes rowsActual;

        public LayoutData(int n, int n2) {
            this.state = n;
            this.widthHint = n2;
        }

        public boolean hasPreferredSizes() {
            return this.columnsPref != null && this.rowsPref != null;
        }

        public boolean hasActualSizes() {
            return this.columnsActual != null && this.rowsActual != null;
        }
    }

    public static class AxisActualSizes {
        public int containerSize = -1;
        public int[] actual;
        public int[] actualWithoutTabulator;

        public AxisActualSizes(int n) {
            this.containerSize = n;
        }
    }

    public static class AxisPreferredSizes {
        public int[] pref;
        public int[] min;
        public int[] max;
        public int[] gaps;
        public List spanData = Collections.EMPTY_LIST;
        public int[] baseline;

        public AxisPreferredSizes(int n) {
            this.pref = new int[n];
            this.min = new int[n];
            this.max = new int[n];
        }

        public boolean hasMax() {
            if (this.max == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.max.length; ++i2) {
                if (this.max[i2] >= 1000000) continue;
                return true;
            }
            return false;
        }

        public boolean hasMin() {
            if (this.min == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.min.length; ++i2) {
                if (this.min[i2] <= 0) continue;
                return true;
            }
            return false;
        }

        public SpanData createSpanData() {
            if (this.spanData.isEmpty()) {
                this.spanData = new ArrayList(3);
            }
            SpanData spanData = new SpanData();
            this.spanData.add(spanData);
            return spanData;
        }

        public void sortSpanData() {
            if (this.spanData.isEmpty()) {
                return;
            }
            Collections.sort(this.spanData, new Comparator(){

                public int compare(Object object, Object object2) {
                    SpanData spanData = (SpanData)object;
                    SpanData spanData2 = (SpanData)object2;
                    return spanData.span - spanData2.span;
                }
            });
        }
    }
}

