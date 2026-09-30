/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.CachedListItemLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListLayoutCacheKey;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListLayoutCalculationData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.VisibleMenuListItem;
import java.util.HashMap;
import java.util.Map;

public class ListLayoutCalculator
implements WidgetConstants,
IWidgetLogChannel {
    public static final int LAYOUTSIZE_HEIGHT_EXPANDED = 1;
    public static final int LAYOUTSIZE_HEIGHT_NOT_EXPANDED = 2;
    public static final int LAYOUTSIZE_GLASPLATE_INSETS = 4;
    public static final int LAYOUTSIZE_MARGIN = 8;
    private final ListController listWidget;
    private Map cachedItemLayouts = new HashMap(4);
    private boolean cacheItemHeights = true;
    private boolean cacheItemMargins = true;
    private int[] heightCacheKeyColumns;

    public ListLayoutCalculator(ListController listController) {
        this.listWidget = listController;
    }

    public int getPreferredMenuItemHeight(int n, boolean bl) {
        int n2 = bl ? 1 : 2;
        return this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, n), this.getCalculationFields(n2)).getHeight(bl);
    }

    public int getPreferredMenuItemHeight(VisibleMenuListItem visibleMenuListItem, boolean bl) {
        int n = bl ? 1 : 2;
        CachedListItemLayout cachedListItemLayout = this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, visibleMenuListItem), this.getCalculationFields(n));
        return cachedListItemLayout.getHeight(bl);
    }

    public int getMargin(int n, boolean bl) {
        CachedListItemLayout cachedListItemLayout = this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, n), this.getCalculationFields(8));
        return bl ? cachedListItemLayout.marginTop : cachedListItemLayout.marginBottom;
    }

    public int getGlassplateInsets(int n, boolean bl) {
        CachedListItemLayout cachedListItemLayout = this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, n), this.getCalculationFields(4));
        return bl ? cachedListItemLayout.glassplateInsetsTop : cachedListItemLayout.glassplateInsetsBottom;
    }

    public int getMargin(VisibleMenuListItem visibleMenuListItem, boolean bl) {
        CachedListItemLayout cachedListItemLayout = this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, visibleMenuListItem), this.getCalculationFields(8));
        return bl ? cachedListItemLayout.marginTop : cachedListItemLayout.marginBottom;
    }

    public int getGlassplateInsets(VisibleMenuListItem visibleMenuListItem, boolean bl) {
        CachedListItemLayout cachedListItemLayout = this.getListItemLayout(new ListLayoutCalculationData(this.listWidget, visibleMenuListItem), this.getCalculationFields(4));
        return bl ? cachedListItemLayout.glassplateInsetsTop : cachedListItemLayout.glassplateInsetsBottom;
    }

    private int getCalculationFields(int n) {
        if (this.cacheItemMargins && this.canCache(n)) {
            return n | 8 | 4;
        }
        return n;
    }

    private CachedListItemLayout getListItemLayout(ListLayoutCalculationData listLayoutCalculationData, int n) {
        if (!this.canCache(n)) {
            CachedListItemLayout cachedListItemLayout = new CachedListItemLayout();
            this.setupRequiredData(cachedListItemLayout, n, listLayoutCalculationData);
            return cachedListItemLayout;
        }
        Object object = this.createCacheKey(listLayoutCalculationData);
        CachedListItemLayout cachedListItemLayout = (CachedListItemLayout)this.cachedItemLayouts.get(object);
        if (cachedListItemLayout == null) {
            cachedListItemLayout = new CachedListItemLayout();
            this.cachedItemLayouts.put(object, cachedListItemLayout);
        }
        this.setupRequiredData(cachedListItemLayout, n, listLayoutCalculationData);
        return cachedListItemLayout;
    }

    private Object createCacheKey(ListLayoutCalculationData listLayoutCalculationData) {
        if (listLayoutCalculationData.item != null) {
            return listLayoutCalculationData.item.listLayoutCacheKey;
        }
        Object object = listLayoutCalculationData.getRowData();
        return this.createCacheKeyForRowData(object);
    }

    public Object createCacheKeyForRowData(Object object) {
        if (object == null) {
            return null;
        }
        if (this.heightCacheKeyColumns == null || this.heightCacheKeyColumns.length == 0) {
            int n = this.listWidget.getRecordSetForRow(object);
            return Util.createInteger(n);
        }
        int[] nArray = new int[this.heightCacheKeyColumns.length + 1];
        for (int i2 = 0; i2 < this.heightCacheKeyColumns.length; ++i2) {
            nArray[i2] = this.listWidget.getIntegerListCellValue(object, this.heightCacheKeyColumns[i2], -1, "heightCacheKey");
        }
        nArray[nArray.length - 1] = this.listWidget.getRecordSetForRow(object);
        return new ListLayoutCacheKey(nArray);
    }

    private void setupRequiredData(CachedListItemLayout cachedListItemLayout, int n, ListLayoutCalculationData listLayoutCalculationData) {
        int n2;
        int n3;
        if (this.needsCalculation(cachedListItemLayout, n, 1)) {
            cachedListItemLayout.setHeight(this.calculateHeight(true, listLayoutCalculationData), true);
        }
        if (this.needsCalculation(cachedListItemLayout, n, 2)) {
            cachedListItemLayout.setHeight(this.calculateHeight(false, listLayoutCalculationData), false);
        }
        if (this.needsCalculation(cachedListItemLayout, n, 8)) {
            n3 = this.calculateMargin(true, listLayoutCalculationData);
            n2 = this.calculateMargin(false, listLayoutCalculationData);
            cachedListItemLayout.setMargin(n3, n2);
        }
        if (this.needsCalculation(cachedListItemLayout, n, 4)) {
            n3 = this.calculateGlassplateInsets(true, listLayoutCalculationData);
            n2 = this.calculateGlassplateInsets(false, listLayoutCalculationData);
            cachedListItemLayout.setGlasplateInsets(n3, n2);
        }
        this.cleanupCalculationData(listLayoutCalculationData);
    }

    private void cleanupCalculationData(ListLayoutCalculationData listLayoutCalculationData) {
        if (listLayoutCalculationData.item != null && listLayoutCalculationData.item.isRealized() && !listLayoutCalculationData.itemWasRealized) {
            this.listWidget.remove(listLayoutCalculationData.item.widget);
            listLayoutCalculationData.item.widget = null;
        }
    }

    private boolean needsCalculation(CachedListItemLayout cachedListItemLayout, int n, int n2) {
        return ListLayoutCalculator.hasFlag(n, n2) && !ListLayoutCalculator.hasFlag(cachedListItemLayout.cachedSizes, n2);
    }

    private boolean canCache(int n) {
        boolean bl;
        boolean bl2;
        boolean bl3 = bl2 = ListLayoutCalculator.hasFlag(n, 1) || ListLayoutCalculator.hasFlag(n, 2);
        if (bl2 && !this.cacheItemHeights) {
            return false;
        }
        boolean bl4 = bl = ListLayoutCalculator.hasFlag(n, 8) || ListLayoutCalculator.hasFlag(n, 4);
        return !bl || this.cacheItemMargins;
    }

    private void ensureRealized(ListLayoutCalculationData listLayoutCalculationData) {
        this.ensureListItemCreated(listLayoutCalculationData);
        if (listLayoutCalculationData.item.isRealized()) {
            return;
        }
        this.listWidget.realizeInternal(listLayoutCalculationData.item, listLayoutCalculationData.rowIndex, listLayoutCalculationData.getRowData());
        if (listLayoutCalculationData.item.isRealized()) {
            listLayoutCalculationData.item.widget.setOnScreen(false);
        }
    }

    private void ensureListItemCreated(ListLayoutCalculationData listLayoutCalculationData) {
        if (listLayoutCalculationData.item != null) {
            return;
        }
        listLayoutCalculationData.item = this.listWidget.createListItemInternal(listLayoutCalculationData.getRowData());
    }

    private int calculateMargin(boolean bl, ListLayoutCalculationData listLayoutCalculationData) {
        this.ensureRealized(listLayoutCalculationData);
        if (listLayoutCalculationData.item.widget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)listLayoutCalculationData.item.widget)).getMargin(bl);
        }
        return 0;
    }

    private int calculateGlassplateInsets(boolean bl, ListLayoutCalculationData listLayoutCalculationData) {
        this.ensureRealized(listLayoutCalculationData);
        if (listLayoutCalculationData.item.widget instanceof IMenuItemSingle) {
            return ((IMenuItemSingle)((Object)listLayoutCalculationData.item.widget)).getGlassplateInsets(bl);
        }
        return 0;
    }

    private int calculateHeight(boolean bl, ListLayoutCalculationData listLayoutCalculationData) {
        this.ensureRealized(listLayoutCalculationData);
        if (listLayoutCalculationData.item.widget instanceof IMenuItemSingle) {
            IMenuItemSingle iMenuItemSingle = (IMenuItemSingle)((Object)listLayoutCalculationData.item.widget);
            iMenuItemSingle.setOptionsIconSpace(this.listWidget.getMenuRightOptionsIconSpace());
            return iMenuItemSingle.getPreferredHeight(bl, this.listWidget.getMenuContentWidth());
        }
        return listLayoutCalculationData.item.widget.getPreferredHeight();
    }

    public void clearCache() {
        this.cachedItemLayouts.clear();
    }

    private static boolean hasFlag(int n, int n2) {
        return (n & n2) == n2;
    }

    public boolean isCacheItemHeights() {
        return this.cacheItemHeights;
    }

    public void setCacheItemHeights(boolean bl) {
        this.cacheItemHeights = bl;
    }

    public boolean isCacheItemMargins() {
        return this.cacheItemMargins;
    }

    public void setCacheItemMargins(boolean bl) {
        this.cacheItemMargins = bl;
    }

    public int[] getHeightCacheKeyColumns() {
        return this.heightCacheKeyColumns;
    }

    public void setHeightCacheKeyColumns(int[] nArray) {
        this.heightCacheKeyColumns = nArray;
    }
}

