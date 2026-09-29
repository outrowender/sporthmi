/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.gridlayout;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisActualSizes;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$AxisPreferredSizes;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$LayoutData;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AbstractGridLayout$SpanData;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IAxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractGridLayout
implements WidgetConstants {
    public static final int HUGE_SIZE;
    private static final int[] EMPTY_ARRAY;
    private static final int ARRAY_ELEMENTS_PER_TABULATOR;
    public static final int HIDEMODE_INVISIBLE_WIDGETS_LEAVE_CELL_EMPTY;
    public static final int HIDEMODE_USE_PREFERRED_SIZE;
    public static final int HIDEMODE_INVISIBLE_OR_EMPTY_WIDGETS_LEAVE_CELL_EMPTY;
    protected IAxisConstraints columnConstraints;
    protected IAxisConstraints rowConstraints;
    protected Object[] widgets;
    protected IGridLayoutHints[] widgetConstraints;
    private AbstractGridLayout$LayoutData[] cachedLayouts;
    private Boolean cachedHasDynamicHeight;
    private int[] tabulators = EMPTY_ARRAY;
    protected int state = 2;

    private int[] getAxisBounds(boolean bl, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AbstractGridLayout$AxisPreferredSizes axisPreferredSizes = bl ? abstractGridLayout$LayoutData.columnsPref : abstractGridLayout$LayoutData.rowsPref;
        AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes = bl ? abstractGridLayout$LayoutData.columnsActual : abstractGridLayout$LayoutData.rowsActual;
        int[] nArray = new int[iAxisConstraints.getLength() * 2];
        int n = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            nArray[i2 * 2] = n += AbstractGridLayout.getGap(i2, axisPreferredSizes, iAxisConstraints);
            nArray[i2 * 2 + 1] = (n += abstractGridLayout$AxisActualSizes.actual[i2]) - 1;
        }
        return nArray;
    }

    protected int[][] setChildrenBounds(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, boolean bl, boolean bl2) {
        ArrayList arrayList = null;
        if (bl) {
            arrayList = new ArrayList(this.widgets.length);
        }
        for (int i2 = 0; i2 < this.widgets.length; ++i2) {
            IGridLayoutHints iGridLayoutHints = this.widgetConstraints[i2];
            if (this.shouldSetChildrenBounds(this.widgets[i2], iGridLayoutHints, abstractGridLayout$LayoutData.state, bl)) {
                this.setChildBounds(this.widgets[i2], iGridLayoutHints, abstractGridLayout$LayoutData, arrayList, bl2);
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

    private void setChildBounds(Object object, IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, List list, boolean bl) {
        int n = this.getChildAreaX(iGridLayoutHints, abstractGridLayout$LayoutData);
        int n2 = this.getChildAreaWidth(iGridLayoutHints, abstractGridLayout$LayoutData);
        int n3 = this.getChildAreaY(iGridLayoutHints, abstractGridLayout$LayoutData);
        int n4 = this.getChildAreaHeight(iGridLayoutHints, abstractGridLayout$LayoutData);
        int n5 = this.getChildAlignment(iGridLayoutHints.getAlignmentHoriz(), iGridLayoutHints.getColumn(), this.columnConstraints);
        int n6 = this.getChildAlignment(iGridLayoutHints.getAlignmentVert(), iGridLayoutHints.getRow(), this.rowConstraints);
        this.setChildBoundsInCell(object, n, n3, n2, n4, n5, n6, iGridLayoutHints, abstractGridLayout$LayoutData, list, bl);
    }

    private void setChildBoundsInCell(Object object, int n, int n2, int n3, int n4, int n5, int n6, IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, List list, boolean bl) {
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
                    n15 = abstractGridLayout$LayoutData.rowsPref.baseline[iGridLayoutHints.getRow()];
                    n14 = this.getBaseline(object);
                    n13 += n15 - n14;
                } else {
                    this.log(-1601830656, "AbstractGridLayout#setChildBoundsInCell: baseline layout is not supported for spanning widgets. Cell: %1 / %2, row span: %3", iGridLayoutHints.getRow(), iGridLayoutHints.getColumn(), iGridLayoutHints.getRowSpan());
                }
                n15 = this.getPreferredHeight(object, n10);
                n7 = Math.min(n15, n4);
                if (n13 + n7 <= n2 + n4) break;
                n14 = n13 + n7 - (n2 + n4);
                this.log(-1601830656, "AbstractGridLayout#setChildBoundsInCell: widget descent extends row height. Cell: %1 / %2, out of cell: %3", iGridLayoutHints.getRow(), iGridLayoutHints.getColumn(), n14);
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

    private int getChildAreaX(IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getColumn(); ++i2) {
            n += abstractGridLayout$LayoutData.columnsActual.actual[i2] + AbstractGridLayout.getGap(i2, abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        if (!this.hasFlag(iGridLayoutHints.getOverlapGaps(), 4)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn(), abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        return n;
    }

    private int getChildAreaY(IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        if (abstractGridLayout$LayoutData.rowsActual.actual == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getRow(); ++i2) {
            n += abstractGridLayout$LayoutData.rowsActual.actual[i2] + AbstractGridLayout.getGap(i2, abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        if (!this.hasFlag(iGridLayoutHints.getOverlapGaps(), 1)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow(), abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        return n;
    }

    private int getChildAreaWidth(IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getColumnSpan(); ++i2) {
            int n2 = iGridLayoutHints.getColumn() + i2;
            n += abstractGridLayout$LayoutData.columnsActual.actual[n2];
            if (i2 <= 0) continue;
            n += AbstractGridLayout.getGap(n2, abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 4)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn(), abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 8)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getColumn() + iGridLayoutHints.getColumnSpan(), abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        if (iGridLayoutHints.getWidthMax() != -1) {
            n = Math.min(n, iGridLayoutHints.getWidthMax());
        }
        if (iGridLayoutHints.getWidthMin() != -1) {
            n = Math.max(n, iGridLayoutHints.getWidthMin());
        }
        return n;
    }

    private int getChildAreaHeight(IGridLayoutHints iGridLayoutHints, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        if (abstractGridLayout$LayoutData.rowsActual.actual == null) {
            return 0;
        }
        int n = 0;
        for (int i2 = 0; i2 < iGridLayoutHints.getRowSpan(); ++i2) {
            int n2 = iGridLayoutHints.getRow() + i2;
            n += abstractGridLayout$LayoutData.rowsActual.actual[n2];
            if (i2 <= 0) continue;
            n += AbstractGridLayout.getGap(n2, abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 1)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow(), abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        if (this.hasFlag(iGridLayoutHints.getOverlapGaps(), 2)) {
            n += AbstractGridLayout.getGap(iGridLayoutHints.getRow() + iGridLayoutHints.getRowSpan(), abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        if (iGridLayoutHints.getHeightMax() != -1) {
            n = Math.min(n, iGridLayoutHints.getHeightMax());
        }
        if (iGridLayoutHints.getHeightMin() != -1) {
            n = Math.max(n, iGridLayoutHints.getHeightMin());
        }
        return n;
    }

    protected int[] calculatePreferredSizeFromCachedData(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        int n;
        int n2 = 0;
        for (n = 0; n < this.columnConstraints.getLength(); ++n) {
            n2 += abstractGridLayout$LayoutData.columnsPref.pref[n] + AbstractGridLayout.getGap(n, abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        if (this.columnConstraints.getLength() > 0) {
            n2 += AbstractGridLayout.getGap(this.columnConstraints.getLength(), abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
        }
        n = 0;
        for (int i2 = 0; i2 < this.rowConstraints.getLength(); ++i2) {
            n += abstractGridLayout$LayoutData.rowsPref.pref[i2] + AbstractGridLayout.getGap(i2, abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        if (this.rowConstraints.getLength() > 0) {
            n += AbstractGridLayout.getGap(this.rowConstraints.getLength(), abstractGridLayout$LayoutData.rowsPref, this.rowConstraints);
        }
        return new int[]{n2, n};
    }

    protected int calculateTabulatorFromCachedData(int n, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        int n2 = 0;
        for (int i2 = 0; i2 < this.columnConstraints.getLength() + 1; ++i2) {
            n2 += AbstractGridLayout.getGap(i2, abstractGridLayout$LayoutData.columnsPref, this.columnConstraints);
            if (this.columnConstraints.getTabulatorID(i2) == n) {
                return n2;
            }
            if (i2 >= this.columnConstraints.getLength()) continue;
            n2 += abstractGridLayout$LayoutData.columnsActual.actualWithoutTabulator[i2];
        }
        this.log(-1601830656, "AbstractGridLayout#calculateTabulator: tabulator %1 not defined", n);
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
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.checkCacheActualSize(n, n2, true, this.state);
        this.setChildrenBounds(abstractGridLayout$LayoutData, false, false);
    }

    protected int[][] simulateLayoutInternal(int n, int n2, boolean bl) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.getLayoutData(this.state, n);
        if (!this.isCachedPreferredSize(abstractGridLayout$LayoutData)) {
            this.calculatePreferredSize(abstractGridLayout$LayoutData);
        }
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData2 = new AbstractGridLayout$LayoutData(this.state, n);
        abstractGridLayout$LayoutData2.columnsPref = abstractGridLayout$LayoutData.columnsPref;
        abstractGridLayout$LayoutData2.rowsPref = abstractGridLayout$LayoutData.rowsPref;
        abstractGridLayout$LayoutData2.columnsActual = new AbstractGridLayout$AxisActualSizes(n);
        abstractGridLayout$LayoutData2.rowsActual = new AbstractGridLayout$AxisActualSizes(n2);
        this.calculateActualSizeGrid(n, n2, true, abstractGridLayout$LayoutData2);
        return this.setChildrenBounds(abstractGridLayout$LayoutData2, true, bl);
    }

    protected int[] calculateRows(int n, int n2) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.checkCacheActualSize(n, n2, true, this.state);
        return this.getAxisBounds(false, abstractGridLayout$LayoutData);
    }

    protected int[] calculateColumns(int n, int n2) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.checkCacheActualSize(n, n2, true, this.state);
        return this.getAxisBounds(true, abstractGridLayout$LayoutData);
    }

    protected int[] calculateSizeInternal(int n, int n2) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.checkCachePreferredSize(n, n2);
        return this.calculatePreferredSizeFromCachedData(abstractGridLayout$LayoutData);
    }

    protected int calculateTabulatorInternal(int n, int n2, int n3) {
        if (!this.columnConstraints.hasTabulatorIDs()) {
            this.log(-1601830656, "AbstractGridLayout#calculateTabulator: no tabulators defined. tabulatorID: %1", n3);
            return -1;
        }
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.checkCacheActualSize(n, n2, false, this.state);
        return this.calculateTabulatorFromCachedData(n3, abstractGridLayout$LayoutData);
    }

    protected AbstractGridLayout$LayoutData checkCachePreferredSize(int n, int n2) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.getLayoutData(n, n2);
        if (!this.isCachedPreferredSize(abstractGridLayout$LayoutData)) {
            this.calculatePreferredSize(abstractGridLayout$LayoutData);
        }
        return abstractGridLayout$LayoutData;
    }

    protected AbstractGridLayout$LayoutData checkCacheActualSize(int n, int n2, boolean bl, int n3) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData = this.getLayoutData(n3, n);
        if (!this.isCachedPreferredSize(abstractGridLayout$LayoutData)) {
            this.calculatePreferredSize(abstractGridLayout$LayoutData);
        }
        if (!this.isCachedActualSize(abstractGridLayout$LayoutData, n, n2, bl)) {
            abstractGridLayout$LayoutData.columnsActual = new AbstractGridLayout$AxisActualSizes(n);
            abstractGridLayout$LayoutData.rowsActual = new AbstractGridLayout$AxisActualSizes(n2);
            this.calculateActualSizeGrid(n, n2, bl, abstractGridLayout$LayoutData);
        }
        return abstractGridLayout$LayoutData;
    }

    private AbstractGridLayout$LayoutData getLayoutData(int n, int n2) {
        AbstractGridLayout$LayoutData abstractGridLayout$LayoutData;
        int n3 = this.cachedLayouts == null ? 0 : this.cachedLayouts.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            abstractGridLayout$LayoutData = this.cachedLayouts[i2];
            if (!this.isCachedForState(abstractGridLayout$LayoutData, n, n2)) continue;
            return abstractGridLayout$LayoutData;
        }
        AbstractGridLayout$LayoutData[] abstractGridLayout$LayoutDataArray = new AbstractGridLayout$LayoutData[n3 + 1];
        if (this.cachedLayouts != null) {
            System.arraycopy((Object)this.cachedLayouts, 0, (Object)abstractGridLayout$LayoutDataArray, 0, n3);
        }
        abstractGridLayout$LayoutDataArray[n3] = abstractGridLayout$LayoutData = new AbstractGridLayout$LayoutData(n, n2);
        this.cachedLayouts = abstractGridLayout$LayoutDataArray;
        return abstractGridLayout$LayoutData;
    }

    private boolean isCachedForState(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, int n, int n2) {
        if (abstractGridLayout$LayoutData.state != n) {
            return false;
        }
        if (this.hasDynamicHeight()) {
            return abstractGridLayout$LayoutData.widthHint == n2;
        }
        return true;
    }

    private boolean isCachedPreferredSize(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        if (!abstractGridLayout$LayoutData.hasPreferredSizes()) {
            return false;
        }
        return abstractGridLayout$LayoutData.columnsPref.pref != null;
    }

    private boolean isCachedActualSize(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, int n, int n2, boolean bl) {
        if (!abstractGridLayout$LayoutData.hasActualSizes()) {
            return false;
        }
        if (abstractGridLayout$LayoutData.columnsActual.containerSize != n || abstractGridLayout$LayoutData.rowsActual.containerSize != n2) {
            return false;
        }
        int[] nArray = bl ? abstractGridLayout$LayoutData.columnsActual.actual : abstractGridLayout$LayoutData.columnsActual.actualWithoutTabulator;
        return nArray != null;
    }

    public void flushCache() {
        this.cachedLayouts = null;
        this.cachedHasDynamicHeight = null;
    }

    protected void calculateActualSizeGrid(int n, int n2, boolean bl, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        this.calculateActualSizeAxis(n, true, bl, abstractGridLayout$LayoutData);
        this.calculateActualSizeAxis(n2, false, bl, abstractGridLayout$LayoutData);
    }

    protected void calculateActualSizeAxis(int n, boolean bl, boolean bl2, AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes;
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes = bl ? abstractGridLayout$LayoutData.columnsPref : abstractGridLayout$LayoutData.rowsPref;
        AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes2 = abstractGridLayout$AxisActualSizes = bl ? abstractGridLayout$LayoutData.columnsActual : abstractGridLayout$LayoutData.rowsActual;
        if (bl && bl2 && this.hasTabulators() && iAxisConstraints.hasTabulatorIDs()) {
            this.applyTabulators(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints);
        } else {
            this.applyShrinkGrow(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n, bl2);
        }
        this.clonePrefToActual(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, bl2);
    }

    protected void calculatePreferredSize(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData) {
        abstractGridLayout$LayoutData.columnsPref = this.createAxisLayoutData(this.columnConstraints);
        abstractGridLayout$LayoutData.rowsPref = this.createAxisLayoutData(this.rowConstraints);
        this.calculatePreferredAxisSize(abstractGridLayout$LayoutData, true, null);
        int[][] nArray = null;
        if (this.hasDynamicHeight() && abstractGridLayout$LayoutData.widthHint != -1) {
            AbstractGridLayout$LayoutData abstractGridLayout$LayoutData2 = new AbstractGridLayout$LayoutData(this.state, abstractGridLayout$LayoutData.widthHint);
            abstractGridLayout$LayoutData2.columnsPref = abstractGridLayout$LayoutData.columnsPref;
            abstractGridLayout$LayoutData2.rowsPref = this.createAxisLayoutData(this.rowConstraints);
            abstractGridLayout$LayoutData2.rowsPref.baseline = new int[this.rowConstraints.getLength()];
            abstractGridLayout$LayoutData2.columnsActual = new AbstractGridLayout$AxisActualSizes(abstractGridLayout$LayoutData.widthHint);
            abstractGridLayout$LayoutData2.rowsActual = new AbstractGridLayout$AxisActualSizes(0);
            this.calculateActualSizeAxis(abstractGridLayout$LayoutData2.widthHint, true, true, abstractGridLayout$LayoutData2);
            nArray = this.setChildrenBounds(abstractGridLayout$LayoutData2, true, false);
        }
        this.calculatePreferredAxisSize(abstractGridLayout$LayoutData, false, nArray);
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

    private AbstractGridLayout$AxisPreferredSizes createAxisLayoutData(IAxisConstraints iAxisConstraints) {
        AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes = new AbstractGridLayout$AxisPreferredSizes(iAxisConstraints.getLength());
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            int n = iAxisConstraints.getSize(i2);
            int n2 = iAxisConstraints.getMin(i2);
            int n3 = iAxisConstraints.getMax(i2);
            abstractGridLayout$AxisPreferredSizes.pref[i2] = n != -1 ? n : 0;
            abstractGridLayout$AxisPreferredSizes.min[i2] = n2 != -1 ? n2 : 0;
            abstractGridLayout$AxisPreferredSizes.max[i2] = n3 != -1 ? n3 : 1078071040;
        }
        return abstractGridLayout$AxisPreferredSizes;
    }

    protected void calculatePreferredAxisSize(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, boolean bl, int[][] nArray) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes = bl ? abstractGridLayout$LayoutData.columnsPref : abstractGridLayout$LayoutData.rowsPref;
        boolean[] blArray = new boolean[iAxisConstraints.getLength()];
        this.collectWidgetSizes(abstractGridLayout$LayoutData, blArray, bl, nArray);
        this.collectGaps(abstractGridLayout$AxisPreferredSizes, iAxisConstraints, blArray);
        this.applyMinMax(abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        this.applySpanData(abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
    }

    private void collectWidgetSizes(AbstractGridLayout$LayoutData abstractGridLayout$LayoutData, boolean[] blArray, boolean bl, int[][] nArray) {
        IAxisConstraints iAxisConstraints = bl ? this.columnConstraints : this.rowConstraints;
        AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes = bl ? abstractGridLayout$LayoutData.columnsPref : abstractGridLayout$LayoutData.rowsPref;
        for (int i2 = 0; i2 < this.widgetConstraints.length; ++i2) {
            int n;
            int n2;
            IGridLayoutHints iGridLayoutHints = this.widgetConstraints[i2];
            Object object = this.widgets[i2];
            if (iGridLayoutHints.isIgnoreForCellSizes() || !this.shouldShowForState(iGridLayoutHints, abstractGridLayout$LayoutData.state)) continue;
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
                this.collectWidgetSize(abstractGridLayout$AxisPreferredSizes, iAxisConstraints, blArray, n3, n4, n, n5, n2);
            }
            if (bl) continue;
            this.collectBaseline(object, iGridLayoutHints, abstractGridLayout$AxisPreferredSizes);
        }
    }

    private void collectBaseline(Object object, IGridLayoutHints iGridLayoutHints, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes) {
        boolean bl;
        if (iGridLayoutHints.getRowSpan() != 1) {
            return;
        }
        int n = iGridLayoutHints.getRow();
        boolean bl2 = this.rowConstraints.hasAlignment(n) && this.rowConstraints.getAlignment(n) == 7;
        boolean bl3 = bl = iGridLayoutHints.getAlignmentVert() == 7;
        if (bl2 || bl) {
            if (abstractGridLayout$AxisPreferredSizes.baseline == null) {
                abstractGridLayout$AxisPreferredSizes.baseline = new int[this.rowConstraints.getLength()];
            }
            int n2 = this.getBaseline(object);
            abstractGridLayout$AxisPreferredSizes.baseline[n] = Math.max(abstractGridLayout$AxisPreferredSizes.baseline[n], n2);
        }
    }

    private void collectGaps(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints, boolean[] blArray) {
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
        abstractGridLayout$AxisPreferredSizes.gaps = new int[iAxisConstraints.getLength() + 1];
        n = 0;
        boolean bl2 = true;
        for (int i2 = 0; i2 < iAxisConstraints.getLength() + 1; ++i2) {
            boolean bl3 = i2 == iAxisConstraints.getLength() || blArray[i2];
            int n4 = iAxisConstraints.getGap(i2);
            if (i2 == 0 || i2 == iAxisConstraints.getLength()) {
                abstractGridLayout$AxisPreferredSizes.gaps[i2] = n4;
                continue;
            }
            if (n2 >= i2 || i2 > n3) continue;
            if (bl2 || bl3) {
                int n5;
                abstractGridLayout$AxisPreferredSizes.gaps[i2] = n5 = bl2 ? n4 : Math.max(n4, n) - n;
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

    private void collectWidgetSize(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints, boolean[] blArray, int n, int n2, int n3, int n4, int n5) {
        if (n2 == 1) {
            if (!iAxisConstraints.hasFixedSize(n)) {
                if (n3 == -1) {
                    n3 = abstractGridLayout$AxisPreferredSizes.pref[n];
                }
                if (n5 != -1) {
                    n3 = Math.min(n3, n5);
                }
                if (n4 != -1) {
                    n3 = Math.max(n3, n4);
                }
                abstractGridLayout$AxisPreferredSizes.pref[n] = Math.max(abstractGridLayout$AxisPreferredSizes.pref[n], n3);
            }
        } else {
            AbstractGridLayout$SpanData abstractGridLayout$SpanData = abstractGridLayout$AxisPreferredSizes.createSpanData();
            abstractGridLayout$SpanData.start = n;
            abstractGridLayout$SpanData.span = n2;
            abstractGridLayout$SpanData.pref = n3;
            abstractGridLayout$SpanData.min = n4 != -1 ? n4 : 0;
            abstractGridLayout$SpanData.max = n5 != -1 ? n5 : 1078071040;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            blArray[n + i2] = true;
        }
    }

    private void applyMinMax(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n;
        for (n = 0; n < iAxisConstraints.getLength(); ++n) {
            if (iAxisConstraints.hasFixedSize(n)) continue;
            abstractGridLayout$AxisPreferredSizes.pref[n] = Math.min(abstractGridLayout$AxisPreferredSizes.pref[n], abstractGridLayout$AxisPreferredSizes.max[n]);
        }
        for (n = 0; n < iAxisConstraints.getLength(); ++n) {
            if (iAxisConstraints.hasFixedSize(n)) continue;
            abstractGridLayout$AxisPreferredSizes.pref[n] = Math.max(abstractGridLayout$AxisPreferredSizes.pref[n], abstractGridLayout$AxisPreferredSizes.min[n]);
        }
    }

    private void applySpanData(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        abstractGridLayout$AxisPreferredSizes.sortSpanData();
        Iterator iterator = abstractGridLayout$AxisPreferredSizes.spanData.iterator();
        while (iterator.hasNext()) {
            AbstractGridLayout$SpanData abstractGridLayout$SpanData = (AbstractGridLayout$SpanData)iterator.next();
            this.applySpanData(abstractGridLayout$SpanData, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        }
    }

    private void applySpanData(AbstractGridLayout$SpanData abstractGridLayout$SpanData, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n = this.calculateRequiredSpanAdjustment(abstractGridLayout$SpanData, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        if (n <= 0) {
            return;
        }
        int[] nArray = this.calculateTabulatorsInSpanArea(abstractGridLayout$SpanData, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        int n2 = abstractGridLayout$SpanData.start;
        for (int i2 = 0; i2 < nArray.length; i2 += 2) {
            int n3 = nArray[i2] - 1;
            int n4 = nArray[i2 + 1];
            if (n4 > 0) {
                int n5 = Math.min(n, n4);
                n -= this.adjustSizeShrinkGrow(n2, n3, n5, true, abstractGridLayout$AxisPreferredSizes.pref, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
                if ((n -= this.adjustSize(n2, n3, n5, true, abstractGridLayout$AxisPreferredSizes.pref, abstractGridLayout$AxisPreferredSizes, iAxisConstraints)) == 0) {
                    return;
                }
            }
            n2 = n3;
        }
        n -= this.adjustSizeShrinkGrow(n2, abstractGridLayout$SpanData.getEnd(), n, true, abstractGridLayout$AxisPreferredSizes.pref, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        n -= this.adjustSize(n2, abstractGridLayout$SpanData.getEnd(), n, true, abstractGridLayout$AxisPreferredSizes.pref, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
    }

    private int adjustSize(int n, int n2, int n3, boolean bl, int[] nArray, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (n3 == 0) {
            return 0;
        }
        int n4 = n3;
        for (int i2 = n2; i2 >= n; --i2) {
            if (iAxisConstraints.hasFixedSize(i2)) continue;
            int n5 = this.getCellChange(i2, nArray[i2], n4, bl, abstractGridLayout$AxisPreferredSizes);
            int n6 = i2;
            nArray[n6] = nArray[n6] + n5;
            if ((n4 -= n5) <= 0) break;
        }
        return n3 - n4;
    }

    private int[] calculateTabulatorsInSpanArea(AbstractGridLayout$SpanData abstractGridLayout$SpanData, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (!this.hasTabulators() || !iAxisConstraints.hasTabulatorIDs()) {
            return EMPTY_ARRAY;
        }
        int[] nArray = new int[this.tabulators.length / 2 * 2];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 <= abstractGridLayout$SpanData.getEnd(); ++i2) {
            int n4;
            n3 += AbstractGridLayout.getGap(i2, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
            if (iAxisConstraints.getTabulatorID(i2) != -1 && (n4 = this.getTabulator(iAxisConstraints.getTabulatorID(i2))) != -1) {
                if (i2 > abstractGridLayout$SpanData.start) {
                    int n5;
                    nArray[n] = i2;
                    nArray[n + 1] = n5 = n4 - n3;
                    n += 2;
                    ++n2;
                }
                n3 = n4;
            }
            n3 += abstractGridLayout$AxisPreferredSizes.pref[i2];
        }
        int[] nArray2 = new int[n2 * 2];
        System.arraycopy((Object)nArray, 0, (Object)nArray2, 0, nArray2.length);
        return nArray2;
    }

    private int calculateRequiredSpanAdjustment(AbstractGridLayout$SpanData abstractGridLayout$SpanData, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        int n = Math.max(abstractGridLayout$SpanData.min, abstractGridLayout$SpanData.pref);
        int n2 = n = Math.min(abstractGridLayout$SpanData.max, n);
        for (int i2 = abstractGridLayout$SpanData.start; i2 <= abstractGridLayout$SpanData.getEnd(); ++i2) {
            n2 -= abstractGridLayout$AxisPreferredSizes.pref[i2];
            if (i2 <= abstractGridLayout$SpanData.start) continue;
            n2 -= AbstractGridLayout.getGap(i2, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        }
        return n2;
    }

    private void applyTabulators(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints) {
        if (!iAxisConstraints.hasTabulatorIDs()) {
            return;
        }
        int n = 0;
        int n2 = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength() + 1; ++i2) {
            int n3 = this.applyTabulator(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n2, i2, n += AbstractGridLayout.getGap(i2, abstractGridLayout$AxisPreferredSizes, iAxisConstraints));
            n += n3;
            if (i2 < iAxisConstraints.getLength()) {
                n += this.getCellSizeBeforeGrowShrink(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, i2, true);
            }
            if (iAxisConstraints.getTabulatorID(i2) == -1) continue;
            n2 = i2;
        }
    }

    private int applyTabulator(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints, int n, int n2, int n3) {
        int n4;
        int n5 = this.getTabulatorOffset(iAxisConstraints, n2, n3);
        if (n5 == 0) {
            return 0;
        }
        if ((n5 -= (n4 = this.adjustColumnsForTabulator(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n, n2, n5, true))) != 0) {
            this.log(-1601830656, "AbstractGridLayout#applyTabulator: must break min/max constraints for tabulator %1, remaining space: %2", iAxisConstraints.getTabulatorID(n2), n5);
            n4 += this.adjustColumnsForTabulator(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n, n2, n5, false);
        }
        if (n4 != 0) {
            this.adaptSpanAfterTabulator(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n2);
        }
        return n4;
    }

    private void adaptSpanAfterTabulator(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints, int n) {
        Iterator iterator = abstractGridLayout$AxisPreferredSizes.spanData.iterator();
        while (iterator.hasNext()) {
            int n2;
            AbstractGridLayout$SpanData abstractGridLayout$SpanData = (AbstractGridLayout$SpanData)iterator.next();
            if (!abstractGridLayout$SpanData.contains(n)) continue;
            int n3 = 0;
            for (n2 = abstractGridLayout$SpanData.start; n2 <= abstractGridLayout$SpanData.getEnd(); ++n2) {
                int n4 = abstractGridLayout$AxisPreferredSizes.pref[n2] - abstractGridLayout$AxisActualSizes.actual[n2];
                n3 += n4;
            }
            n2 = this.adjustSizeShrinkGrow(n, abstractGridLayout$SpanData.getEnd(), n3, true, abstractGridLayout$AxisActualSizes.actual, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
            n3 -= n2;
            n2 += this.adjustSize(n, abstractGridLayout$SpanData.getEnd(), n3, true, abstractGridLayout$AxisActualSizes.actual, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        }
    }

    private int adjustColumnsForTabulator(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints, int n, int n2, int n3, boolean bl) {
        this.initializeActualSizes(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, true);
        int n4 = this.adjustSizeShrinkGrow(n, n2 - 1, n3, bl, abstractGridLayout$AxisActualSizes.actual, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        n3 -= n4;
        return n4 += this.adjustSize(n, n2 - 1, n3, bl, abstractGridLayout$AxisActualSizes.actual, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
    }

    private int getCellChange(int n, int n2, int n3, boolean bl, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes) {
        if (n3 > 0) {
            int n4 = bl ? abstractGridLayout$AxisPreferredSizes.max[n] : 1078071040;
            int n5 = n4 - n2;
            return Math.min(n5, n3);
        }
        int n6 = bl ? abstractGridLayout$AxisPreferredSizes.min[n] : 0;
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
            this.log(-1601830656, "AbstractGridLayout#applyTabulators: can not set tabulator for first column. tabID: %1, value: %2", n3, n4);
            return 0;
        }
        return n4 - n2;
    }

    private int adjustSizeShrinkGrow(int n, int n2, int n3, boolean bl, int[] nArray, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
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
                int n10 = 0x1000000;
                for (n8 = n; n8 <= n2; ++n8) {
                    if (!((float)nArray[n8] > n10) || !(iAxisConstraints.getShrinkWeight(n8) > 0.0f)) continue;
                    n10 = (int)((float)nArray[n8]);
                }
                float f4 = 0.0f;
                int n11 = -32897;
                for (n7 = n; n7 <= n2; ++n7) {
                    int n12 = n10 - (float)nArray[n7];
                    if (!(n12 > 0.0f) || !(n12 < n11) || !(iAxisConstraints.getShrinkWeight(n7) > 0.0f)) continue;
                    n11 = n12;
                    f4 = nArray[n7];
                }
                nArray2 = this.calculatSizeForShrinkedCells(n, n2, n3, nArray, f4, iAxisConstraints, bl);
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
                int n13 = nArray2[n8];
                n7 = n8 + n;
                if (n13 != 0 && n3 != 0) {
                    int n14 = this.getCellChange(n7, nArray[n7], n13, bl, abstractGridLayout$AxisPreferredSizes);
                    int n15 = n7;
                    nArray[n15] = nArray[n15] + n14;
                    n5 += n14;
                    if (!bl2) {
                        n3 -= n14;
                    }
                    if (n14 == n13) {
                        float f5 = iAxisConstraints.getResizeWeight(bl2, n7);
                        f3 += f5;
                        continue;
                    }
                    int n16 = n13 - n14;
                    n9 += n16;
                    blArray[n8] = true;
                    continue;
                }
                if (blArray[n8]) continue;
                float f6 = iAxisConstraints.getResizeWeight(bl2, n7);
                f3 += f6;
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
                        this.log(-1601830656, "AbstractGridLayout#adjustSizeShrinkGrow: No more space to shrink cells, remainingAdditionalSpace: %1 ", n9);
                    }
                    return n5;
                }
            } else if (n9 == 0) {
                return n5;
            }
            if (f3 == 0.0f) {
                this.log(-1601830656, "AbstractGridLayout#adjustSizeShrinkGrow: Can't distribute all the required space due to min/max constraints. From: %1, To: %2, remainingAdditionalSpace: %3 ", n, n2, n9);
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

    private void applyShrinkGrow(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints, int n, boolean bl) {
        int n2 = this.getShrinkGrowSpace(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, iAxisConstraints, n, bl);
        if (n2 == 0) {
            return;
        }
        int[] nArray = this.initializeActualSizes(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, bl);
        this.adjustSizeShrinkGrow(0, iAxisConstraints.getLength() - 1, n2, true, nArray, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
    }

    private int getShrinkGrowSpace(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, IAxisConstraints iAxisConstraints, int n, boolean bl) {
        int n2 = 0;
        for (int i2 = 0; i2 < iAxisConstraints.getLength(); ++i2) {
            int n3 = this.getCellSizeBeforeGrowShrink(abstractGridLayout$AxisPreferredSizes, abstractGridLayout$AxisActualSizes, i2, bl);
            n2 += n3 + AbstractGridLayout.getGap(i2, abstractGridLayout$AxisPreferredSizes, iAxisConstraints);
        }
        return n - (n2 += AbstractGridLayout.getGap(iAxisConstraints.getLength(), abstractGridLayout$AxisPreferredSizes, iAxisConstraints));
    }

    public static int getGap(int n, AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, IAxisConstraints iAxisConstraints) {
        if (abstractGridLayout$AxisPreferredSizes.gaps != null) {
            return abstractGridLayout$AxisPreferredSizes.gaps[n];
        }
        return iAxisConstraints.getGap(n);
    }

    private int getCellSizeBeforeGrowShrink(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, int n, boolean bl) {
        if (bl && abstractGridLayout$AxisActualSizes.actual != null) {
            return abstractGridLayout$AxisActualSizes.actual[n];
        }
        return abstractGridLayout$AxisPreferredSizes.pref[n];
    }

    private int[] initializeActualSizes(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, boolean bl) {
        int[] nArray;
        int[] nArray2 = nArray = bl ? abstractGridLayout$AxisActualSizes.actual : abstractGridLayout$AxisActualSizes.actualWithoutTabulator;
        if (nArray != null) {
            return nArray;
        }
        int[] nArray3 = new int[abstractGridLayout$AxisPreferredSizes.pref.length];
        System.arraycopy((Object)abstractGridLayout$AxisPreferredSizes.pref, 0, (Object)nArray3, 0, abstractGridLayout$AxisPreferredSizes.pref.length);
        if (bl) {
            abstractGridLayout$AxisActualSizes.actual = nArray3;
            return abstractGridLayout$AxisActualSizes.actual;
        }
        abstractGridLayout$AxisActualSizes.actualWithoutTabulator = nArray3;
        return abstractGridLayout$AxisActualSizes.actualWithoutTabulator;
    }

    private void clonePrefToActual(AbstractGridLayout$AxisPreferredSizes abstractGridLayout$AxisPreferredSizes, AbstractGridLayout$AxisActualSizes abstractGridLayout$AxisActualSizes, boolean bl) {
        if (bl) {
            if (abstractGridLayout$AxisActualSizes.actual != null) {
                return;
            }
            abstractGridLayout$AxisActualSizes.actual = abstractGridLayout$AxisPreferredSizes.pref;
        } else {
            if (abstractGridLayout$AxisActualSizes.actualWithoutTabulator != null) {
                return;
            }
            abstractGridLayout$AxisActualSizes.actualWithoutTabulator = abstractGridLayout$AxisPreferredSizes.pref;
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

    protected abstract int getPreferredWidth(Object object) {
    }

    protected abstract int getPreferredHeight(Object object) {
    }

    protected abstract boolean hasDynamicHeight(Object object) {
    }

    protected abstract int getPreferredHeight(Object object, int n) {
    }

    protected abstract int getBaseline(Object object) {
    }

    protected abstract boolean isWidgetVisible(Object object) {
    }

    protected abstract boolean widgetHasContent(Object object) {
    }

    protected abstract void setBounds(Object object, int n, int n2, int n3, int n4) {
    }

    protected abstract void simulateSetBounds(Object object, int n, int n2, int n3, int n4, List list, boolean bl) {
    }

    protected abstract void hideWidget(Object object) {
    }

    protected abstract void simulateHideWidgets(Object object, List list) {
    }

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
            return new StringBuffer().append(string).append(": null").toString();
        }
        return new StringBuffer().append(iAxisConstraints.getLength()).append(" ").append(string).append(": \"").append(iAxisConstraints).append("\"").toString();
    }

    static {
        EMPTY_ARRAY = new int[0];
    }
}

