/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.menu.list;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.GuiListRow;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.ListModelGUI;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.preset.Preset;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.IDrawerFocusManagerEvo;
import de.audi.tghu.hmi.evo.IFocusedPropertyObject;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.FocusedPropertyObject;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.IViewSizeAnimatable;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultiLayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuCallback;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemMultiItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItemSingle;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemMetaData;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuUpdateDelta;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidgetCache;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListLayoutCalculator;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListSeparatingLinesController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.OldListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.VisibleMenuListItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListController
extends AbstractWidgetController
implements IMenuItemMultiItem,
IMenuCallback,
IViewSizeAnimatable {
    private ListItemFactory itemFactory;
    private ListManager listManager;
    private IListWidgetDataAccess dataAccess;
    private ListModelRowMapper rowIndexMapper;
    ListLayoutCalculator layoutCalculator = new ListLayoutCalculator(this);
    private ListItemWidgetCache itemsCache = new ListItemWidgetCache();
    private int modelSize;
    private int idColumn = -1;
    private int recordSetColumn = -1;
    private int propertyColumn = -1;
    private int enabledColumn = -1;
    private int focusableColumn = -1;
    private int separatingLineColumn = -1;
    private int extendedMenuItem = -1;
    private int widgetID = -1;
    protected boolean autoLayoutSetup = true;
    private int sdsItemSelectedAction = 0;
    private int[] infolineTextIdsEnabled = null;
    private int[] infolineTextIdsDisabled = null;
    private int infolineTextEnabledColumn = -1;
    private int infolineTextDisabledColumn = -1;
    private int sdsActionColumn = -1;
    private int nowPlayingModeEnabledColumn = -1;
    private int[] noCursorAreasTop = null;
    private int[] noCursorAreasBottom = null;
    private int[] glassplateInsetsTop = null;
    private int[] glassplateInsetsBottom = null;
    private int menuContentWidth;
    private int menuRightOptionsIconSpace;
    private boolean isRecordSetCacheIgnored;
    private boolean cacheWidgetsPerRecordSet = true;
    private boolean isKeyPressed;
    private int expandableItemColumn = -1;
    private int focusedIndexBeforeMerge;

    protected void initializeWidget() {
        super.initializeWidget();
        if (this.dataAccess == null) {
            this.dataAccess = this.createDefaultDataAccess();
            this.initializeDataAccess();
            listLogCh.log(10000000, "ListController#initializeWidget: create default DataAccess: %1", (Object)this.dataAccess);
        }
        if (this.dataAccess != null) {
            this.dataAccess.connect(this.initContext);
        }
        this.updateDataAccessVisibility();
        this.updateSubItemCount();
        if (this.separatingLineColumn != -1) {
            this.ensureMenuHasSeparatingLineWidget();
        }
    }

    private void ensureMenuHasSeparatingLineWidget() {
        Iterator iterator = this.parent.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
            if (!(abstractWidget instanceof ListSeparatingLinesController)) continue;
            return;
        }
        ((MenuController)this.parent).add(new ListSeparatingLinesController(), 7);
    }

    private OldListModelAccess createDefaultDataAccess() {
        if (this.model instanceof ListModelGUI) {
            return new OldListModelAccess();
        }
        return null;
    }

    public void disconnecting() {
        if (this.dataAccess != null) {
            this.dataAccess.disconnect();
        }
        this.clearCache();
        super.disconnecting();
    }

    private void clearCache() {
        this.clearHeightCache();
        this.clearItemsCache();
    }

    private void clearHeightCache() {
        this.layoutCalculator.clearCache();
    }

    private void clearItemsCache() {
        Map map = this.itemsCache.clear();
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()) {
            List list = (List)iterator.next();
            Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)iterator2.next();
                this.remove(abstractWidget);
            }
        }
        if (this.getChildrenSize() != 0) {
            listLogCh.log(100000, "ListController#clearItemsCache: list widget has still children: %1", (Object)this.getChildren());
        }
    }

    public void setViewSizeAnimation(float f2, float[] fArray, float[] fArray2, boolean bl) {
        if (bl) {
            this.clearHeightCache();
        }
    }

    public void setViewSizeAnimationFinished(float[] fArray, boolean bl) {
        if (bl) {
            this.clearHeightCache();
        }
    }

    public void viewSizeTargetChanged(float[] fArray, float[] fArray2, boolean bl) {
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        listLogCh.log(10000000, "ListController#processModelUpdateEvent: received model update. event: %1", (Object)modelUpdateEvent);
        this.propagateEventToDataAccess(modelUpdateEvent);
        if (this.shouldIgnoreEvent(modelUpdateEvent)) {
            return;
        }
        this.updateSubItemCount();
        if (this.shouldRender()) {
            this.propagateEventToListManager(modelUpdateEvent);
        } else {
            listLogCh.log(10000000, "ListController#processModelUpdateEvent: list widget is invisible, don't process event in menu. event: %1", (Object)modelUpdateEvent);
        }
        this.setCompositesDirty(true);
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private boolean shouldIgnoreEvent(ModelUpdateEvent modelUpdateEvent) {
        switch (modelUpdateEvent.getUpdateType()) {
            case 2: {
                listLogCh.log(1000000, "ListController#shouldIgnoreEvent: ignore StatusChanged event");
                return true;
            }
            case 8: {
                ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
                if (modelUpdateData != null && modelUpdateData.contains(ModelUpdateData.Key.COUNT) && modelUpdateData.getInt(ModelUpdateData.Key.COUNT) == 0) {
                    listLogCh.log(1000000, "ListController#shouldIgnoreEvent: ignore RowChanged event with count=0. Client");
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void propagateEventToDataAccess(ModelUpdateEvent modelUpdateEvent) {
        if (this.dataAccess != null) {
            if (modelUpdateEvent.getModelType() == 100) {
                ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
                for (int i2 = 0; i2 < modelUpdateEventArray.length; ++i2) {
                    ModelUpdateEvent modelUpdateEvent2 = modelUpdateEventArray[i2];
                    if (modelUpdateEvent2.getModelId() != this.modelID) continue;
                    this.dataAccess.processModelUpdateEvent(modelUpdateEvent2);
                }
            } else {
                this.dataAccess.processModelUpdateEvent(modelUpdateEvent);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void propagateEventToListManager(ModelUpdateEvent modelUpdateEvent) {
        if (modelUpdateEvent.getModelType() == 100) {
            this.rowIndexMapper = new ListModelRowMapper(modelUpdateEvent.getNestedEvents());
        }
        try {
            this.listManager.listModelChanged(this, modelUpdateEvent);
        }
        finally {
            this.rowIndexMapper = null;
        }
    }

    public boolean canProcessModelGroupEvent() {
        return true;
    }

    public void setCurrentProcessedNestedEvent(int n) {
        if (this.rowIndexMapper != null) {
            this.rowIndexMapper.currentHandledEvent = n;
        } else {
            listLogCh.log(100000, "ListController#setCurrentProcessedNestedEvent: rowMapper is null. current processed event: %1", (long)n);
        }
    }

    public boolean updateMenuItem(MenuItemMetaData menuItemMetaData) {
        VisibleMenuListItem visibleMenuListItem = (VisibleMenuListItem)menuItemMetaData;
        int n = menuItemMetaData.index.widgetPart;
        Object object = this.getModelRow(n);
        if (!this.isRecordSetCacheIgnored && this.isModelRowValidForItem(visibleMenuListItem, object)) {
            if (menuItemMetaData.isRealized()) {
                if (listLogCh.isDebug()) {
                    listLogCh.log(10000000, "ListController#updateMenuItem: update menu item %1. old item: '%2'", (Object)menuItemMetaData.index, (Object)menuItemMetaData.widget.getDiagnosisText());
                }
                this.updateListItemWidget(visibleMenuListItem, object, n);
                if (listLogCh.isDebug()) {
                    listLogCh.log(10000000, "ListController#updateMenuItem: update menu item %1. new item: '%2'", (Object)menuItemMetaData.index, (Object)menuItemMetaData.widget.getDiagnosisText());
                }
            }
            visibleMenuListItem.listLayoutCacheKey = this.layoutCalculator.createCacheKeyForRowData(object);
            return true;
        }
        listLogCh.log(100000, "ListController#updateMenuItem: can not update item: %1", (Object)menuItemMetaData.index);
        return false;
    }

    private boolean isModelRowValidForItem(VisibleMenuListItem visibleMenuListItem, Object object) {
        int n = this.getRecordSetForRow(object);
        if (visibleMenuListItem.recordSet != n) {
            listLogCh.log(100000, "ListController#isModelRowValidForItem: RecordSet has changed in row %1. Expected RecordSet: %2, actual: %3", object, (long)visibleMenuListItem.recordSet, (long)n);
            return false;
        }
        return true;
    }

    public void updateSubItemCount() {
        int n = this.getLengthFromModel();
        if (n != this.modelSize) {
            listLogCh.log(1000000, "ListController#updateSubItemCount: listModel %1 length changed from %2 to %3", (long)this.getModelID(), (long)this.modelSize, (long)n);
        }
        this.modelSize = n;
    }

    protected int getLengthFromModel() {
        if (this.dataAccess != null) {
            return this.dataAccess.getLength();
        }
        listLogCh.log(10000, "ListController#getLengthFromModel: no data access set. Model: %1", this.model);
        return 0;
    }

    public int getSelectedIndex() {
        if (this.dataAccess != null) {
            return this.dataAccess.getSelectedIndex();
        }
        listLogCh.log(10000, "ListController#getSelectedIndex: no data access set. Model: %1", this.model);
        return -1;
    }

    protected Object getModelRow(int n) {
        if (this.dataAccess != null) {
            if (this.rowIndexMapper != null) {
                int n2 = this.rowIndexMapper.map(n);
                if (n2 != n) {
                    listLogCh.log(10000000, "ListController#getModelRow: map row index %2 to %3 for nested events. %1", (Object)this.rowIndexMapper, (long)n, (long)n2);
                }
                n = n2;
            }
            return this.dataAccess.getRow(n);
        }
        listLogCh.log(10000, "ListController#getModelRow: no data access set. Model: %1", this.model);
        return null;
    }

    int getRecordSetForRow(Object object) {
        if (object == null) {
            return -1;
        }
        if (this.recordSetColumn == -1) {
            return 0;
        }
        return this.getIntegerListCellValue(object, this.recordSetColumn, -1, "record set");
    }

    public int getSubItemCount() {
        return this.modelSize;
    }

    public int getPreferredMenuItemHeight(int n, boolean bl) {
        return this.layoutCalculator.getPreferredMenuItemHeight(n, bl);
    }

    public int getPreferredMenuItemHeight(MenuItemMetaData menuItemMetaData, boolean bl) {
        return this.layoutCalculator.getPreferredMenuItemHeight((VisibleMenuListItem)menuItemMetaData, bl);
    }

    public int getMargin(int n, boolean bl) {
        return this.layoutCalculator.getMargin(n, bl);
    }

    public int getGlassplateInsets(int n, boolean bl) {
        int n2 = this.getRecordSetForGlassplateInsetsArray(n, bl);
        if (n2 != -1) {
            int[] nArray = bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
            return nArray[n2];
        }
        return this.layoutCalculator.getGlassplateInsets(n, bl);
    }

    private int getRecordSetForGlassplateInsetsArray(int n, boolean bl) {
        int[] nArray;
        int[] nArray2 = nArray = bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
        if (nArray == null || nArray.length == 0) {
            return -1;
        }
        Object object = this.getModelRow(n);
        int n2 = this.getRecordSetForRow(object);
        if (n2 < 0 || n2 >= nArray.length) {
            return -1;
        }
        return n2;
    }

    public int getMargin(MenuItemMetaData menuItemMetaData, boolean bl) {
        return this.layoutCalculator.getMargin((VisibleMenuListItem)menuItemMetaData, bl);
    }

    public int getGlassplateInsets(MenuItemMetaData menuItemMetaData, boolean bl) {
        int n = this.getRecordSetForGlassplateInsetsArray(menuItemMetaData.index.widgetPart, bl);
        if (n != -1) {
            int[] nArray = bl ? this.glassplateInsetsTop : this.glassplateInsetsBottom;
            return nArray[n];
        }
        return this.layoutCalculator.getGlassplateInsets((VisibleMenuListItem)menuItemMetaData, bl);
    }

    public int getNoCursorArea(MenuItemMetaData menuItemMetaData, boolean bl) {
        return this.getNoCursorArea(menuItemMetaData.index.widgetPart, bl);
    }

    public int getNoCursorArea(int n, boolean bl) {
        int[] nArray;
        int[] nArray2 = nArray = bl ? this.noCursorAreasTop : this.noCursorAreasBottom;
        if (nArray == null || nArray.length == 0) {
            return 0;
        }
        Object object = this.getModelRow(n);
        int n2 = this.getRecordSetForRow(object);
        if (n2 < 0 || n2 >= nArray.length) {
            return 0;
        }
        return nArray[n2];
    }

    public IRenderer getRenderer() {
        return null;
    }

    public ListItemFactory getItemFactory() {
        return this.itemFactory;
    }

    public void setItemFactory(ListItemFactory listItemFactory) {
        this.itemFactory = listItemFactory;
    }

    public ListManager getListManager() {
        return this.listManager;
    }

    public void setListManager(ListManager listManager) {
        this.listManager = listManager;
    }

    public MenuItemMetaData createMenuItem(int n) {
        return this.createListItemInternal(this.getModelRow(n));
    }

    VisibleMenuListItem createListItemInternal(Object object) {
        int n = this.getRecordSetForRow(object);
        VisibleMenuListItem visibleMenuListItem = new VisibleMenuListItem();
        visibleMenuListItem.recordSet = n;
        visibleMenuListItem.listLayoutCacheKey = this.layoutCalculator.createCacheKeyForRowData(object);
        this.updateSeparatingLines(visibleMenuListItem, object);
        return visibleMenuListItem;
    }

    public boolean realizeMenuItem(MenuItemMetaData menuItemMetaData) {
        if (menuItemMetaData.isRealized()) {
            listLogCh.log(100000, "ListController#realizeMenuItem: item is already realized: %1", (Object)menuItemMetaData.index);
            return true;
        }
        VisibleMenuListItem visibleMenuListItem = (VisibleMenuListItem)menuItemMetaData;
        int n = menuItemMetaData.index.widgetPart;
        Object object = this.getModelRow(n);
        if (!this.isModelRowValidForItem(visibleMenuListItem, object)) {
            listLogCh.log(100000, "ListController#realizeMenuItem: can not realize item: %1", (Object)menuItemMetaData.index);
            return false;
        }
        this.realizeInternal(visibleMenuListItem, n, object);
        if (listLogCh.isDebug()) {
            listLogCh.log(10000000, "ListController#realizeMenuItem: create widget for item: %1, '%2'", (Object)menuItemMetaData.index, (Object)menuItemMetaData.widget.getDiagnosisText());
        }
        return true;
    }

    protected void realizeInternal(VisibleMenuListItem visibleMenuListItem, int n, Object object) {
        AbstractWidgetController abstractWidgetController = this.createListItemWidget(visibleMenuListItem, object);
        this.initializeListItemWidget(abstractWidgetController);
        visibleMenuListItem.widget = abstractWidgetController;
        this.analyseModelsIDs(visibleMenuListItem);
        this.updateListItemWidget(visibleMenuListItem, object, n);
        if (abstractWidgetController.getParent() == null) {
            this.add(abstractWidgetController);
        }
        this.propagateExpansion(visibleMenuListItem, n);
        InitializationContext initializationContext = this.getInitContext();
        if (initializationContext == null) {
            listLogCh.log(10000000, "ListController#realizeInternal: InitContext is null! Cannot set current viewsize on widget!");
            return;
        }
        Screen screen = initializationContext.getScreen();
        if (screen instanceof ScreenWidgetEVO) {
            ((ScreenWidgetEVO)screen).setCurrentViewSizeOnWidget(abstractWidgetController);
        }
    }

    private void initializeListItemWidget(AbstractWidgetController abstractWidgetController) {
        MultiLayoutContainerController multiLayoutContainerController;
        abstractWidgetController.setOnScreen(false);
        if (abstractWidgetController instanceof LayoutContainerController) {
            ((LayoutContainerController)abstractWidgetController).setAutoLayoutSetup(this.autoLayoutSetup);
        }
        if (abstractWidgetController instanceof MultiLayoutContainerController && (multiLayoutContainerController = (MultiLayoutContainerController)abstractWidgetController).hasMultipleLayouts()) {
            multiLayoutContainerController.selectLayoutManager(0);
        }
    }

    private AbstractWidgetController createListItemWidget(VisibleMenuListItem visibleMenuListItem, Object object) {
        AbstractWidgetController abstractWidgetController;
        if (this.itemFactory == null) {
            listLogCh.log(10000, "ListController#createListItemWidget: no itemFactory defined. Model-ID: %2, listItem: %1", (Object)visibleMenuListItem.index, (long)this.getModelID());
            return this.createDummyListItemWidget();
        }
        AbstractWidgetController abstractWidgetController2 = this.itemsCache.get(visibleMenuListItem.recordSet);
        if (abstractWidgetController2 != null) {
            listLogCh.log(10000000, "ListController#createListItemWidget: get widget from listItemsCache for index %2, record set: %3: %1", (Object)abstractWidgetController2, (Object)visibleMenuListItem.index, (long)visibleMenuListItem.recordSet);
            return abstractWidgetController2;
        }
        if (visibleMenuListItem.recordSet == -1) {
            abstractWidgetController = this.itemFactory.createListItemNoData();
        } else {
            ListCell[] listCellArray = null;
            if (object instanceof ListCell[]) {
                listCellArray = (ListCell[])object;
            } else if (object instanceof GuiListRow) {
                listCellArray = new ListCell[]{new ObjectListCell(object)};
            }
            abstractWidgetController = this.itemFactory.createListItem(visibleMenuListItem.recordSet, listCellArray);
        }
        if (abstractWidgetController != null) {
            listLogCh.log(10000000, "ListController#createListItemWidget: realize menu item %2, record set: %3: %1", (Object)abstractWidgetController, (Object)visibleMenuListItem.index, (long)visibleMenuListItem.recordSet);
            return abstractWidgetController;
        }
        listLogCh.log(10000, "ListController#createListItemWidget: itemFactory returned null for item: %2, recordSet: %3, itemfactory: %1", (Object)this.itemFactory, (Object)visibleMenuListItem.index, (long)visibleMenuListItem.recordSet);
        return this.createDummyListItemWidget();
    }

    private MenuItemController createDummyListItemWidget() {
        MenuItemController menuItemController = new MenuItemController();
        menuItemController.setType(1);
        return menuItemController;
    }

    private void updateSeparatingLines(MenuItemMetaData menuItemMetaData, Object object) {
        if (this.separatingLineColumn != -1) {
            if (object instanceof GuiListRow) {
                GuiListRow guiListRow = (GuiListRow)object;
                menuItemMetaData.separatingLineType = guiListRow.getInteger(this.separatingLineColumn);
            }
        } else {
            menuItemMetaData.separatingLineType = 0;
        }
    }

    private void analyseModelsIDs(VisibleMenuListItem visibleMenuListItem) {
        ArrayList arrayList = new ArrayList(5);
        ArrayList arrayList2 = new ArrayList(5);
        this.collectListItemModelColumns(visibleMenuListItem.widget, arrayList, arrayList2);
        AbstractWidgetController[] abstractWidgetControllerArray = (AbstractWidgetController[])arrayList.toArray(new AbstractWidgetController[arrayList.size()]);
        int[] nArray = new int[arrayList2.size()];
        int n = 0;
        Iterator iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            nArray[n] = (Integer)iterator.next();
            ++n;
        }
        visibleMenuListItem.modelWidgets = abstractWidgetControllerArray;
        visibleMenuListItem.modelColumns = nArray;
    }

    private void updateListItemWidget(VisibleMenuListItem visibleMenuListItem, Object object, int n) {
        if (object != null) {
            for (int i2 = 0; i2 < visibleMenuListItem.modelWidgets.length; ++i2) {
                int n2 = visibleMenuListItem.modelColumns[i2];
                AbstractWidgetController abstractWidgetController = visibleMenuListItem.modelWidgets[i2];
                this.setModelToItemWidget(abstractWidgetController, object, n2);
            }
            this.updateSeparatingLines(visibleMenuListItem, object);
        }
        this.propagateExpansion(visibleMenuListItem, n);
        visibleMenuListItem.widget.setEnabled(this.isEnabled(object));
        visibleMenuListItem.widget.setCompositesDirty(true);
        if (visibleMenuListItem.widget instanceof MenuItemController) {
            ((MenuItemController)visibleMenuListItem.widget).setFocusable(this.isFocusable(object));
        }
    }

    private void propagateExpansion(VisibleMenuListItem visibleMenuListItem, int n) {
        if (visibleMenuListItem.widget instanceof IMenuItemSingle) {
            IMenuItemSingle iMenuItemSingle = (IMenuItemSingle)((Object)visibleMenuListItem.widget);
            boolean bl = this.isExpanded(n);
            iMenuItemSingle.showExtended(bl);
        }
    }

    private void setModelToItemWidget(AbstractWidgetController abstractWidgetController, Object object, int n) {
        Object object2;
        Object object3 = abstractWidgetController.getModel();
        if (!Util.equals(object3, object2 = this.dataAccess.getCell(object, n))) {
            abstractWidgetController.setModel(object2);
            if (abstractWidgetController.isConnected()) {
                abstractWidgetController.processModelUpdateEvent(new ModelUpdateEvent(null, 10301, -1, -1, 1, -1, -1));
                abstractWidgetController.setCompositesDirty(true);
            }
        }
    }

    private boolean isExpanded(int n) {
        return this.extendedMenuItem == n;
    }

    private void collectListItemModelColumns(AbstractWidget abstractWidget, List list, List list2) {
        int n;
        if (abstractWidget instanceof ListItemWidget && (n = ((ListItemWidget)((Object)abstractWidget)).getModelColumn()) != -1) {
            list.add(abstractWidget);
            list2.add(Util.createInteger(n));
        }
        Iterator iterator = abstractWidget.getChildren().iterator();
        while (iterator.hasNext()) {
            AbstractWidgetController abstractWidgetController = (AbstractWidgetController)iterator.next();
            this.collectListItemModelColumns(abstractWidgetController, list, list2);
        }
    }

    public void destroyMenuItem(MenuItemMetaData menuItemMetaData) {
        int n;
        boolean bl;
        if (!menuItemMetaData.isRealized()) {
            return;
        }
        if (listLogCh.isDebug()) {
            listLogCh.log(10000000, "ListController#destroyMenuItem: destroy menu item %1: '%2'", (Object)menuItemMetaData.index, (Object)menuItemMetaData.widget.getDiagnosisText());
        }
        if (bl = this.putItemWidgetInCache(n = ((VisibleMenuListItem)menuItemMetaData).recordSet, menuItemMetaData.widget)) {
            menuItemMetaData.widget.setOnScreen(false);
        } else {
            this.remove(menuItemMetaData.widget);
        }
        menuItemMetaData.widget = null;
    }

    private boolean putItemWidgetInCache(int n, AbstractWidgetController abstractWidgetController) {
        if (this.isRecordSetCacheIgnored || !this.cacheWidgetsPerRecordSet) {
            listLogCh.log(10000000, "ListController#destroyMenuItem: don't cache menu items");
            return false;
        }
        if (!this.isConnected()) {
            return false;
        }
        boolean bl = this.itemsCache.add(n, abstractWidgetController);
        if (bl) {
            listLogCh.log(10000000, "ListController#destroyMenuItem: add widget to listItemsCache for recordSet %2: %1", (Object)abstractWidgetController, (long)n);
        } else {
            listLogCh.log(100000, "ListController#destroyMenuItem: can not add item to listItemsCache for recordSet %2: %1", (Object)abstractWidgetController, (long)n);
        }
        return bl;
    }

    public void setParent(AbstractWidget abstractWidget) {
        super.setParent(abstractWidget);
        if (abstractWidget instanceof ListManager) {
            this.listManager = (ListManager)((Object)abstractWidget);
        } else {
            listLogCh.log(10000, "ListController#setParent: parent is not a listManager: %1, current listManager: %2", (Object)this.parent, (Object)this.listManager);
        }
        this.initializeDataAccess();
    }

    public int getIdColumn() {
        return this.idColumn;
    }

    public void setIdColumn(int n) {
        this.idColumn = n;
        this.initializeDataAccess();
    }

    public int getRecordSetColumn() {
        return this.recordSetColumn;
    }

    public void setRecordSetColumn(int n) {
        this.recordSetColumn = n;
    }

    public void keyPressed(KeyEvent keyEvent, int n) {
        this.isKeyPressed = true;
        if (keyEvent.getKeyCode() != 17) {
            return;
        }
        if (this.dataAccess != null) {
            Long l = this.getUniqueIDForItemIndex(n);
            if (l != null) {
                this.dataAccess.itemSelected(l, n);
            } else {
                listLogCh.log(100000, "ListController#keyPressed: no ID defined for row %1", (long)n);
            }
            keyEvent.consume();
        } else {
            listLogCh.log(10000, "ListController#keyPressed: no data access set. Model: %1", this.model);
        }
    }

    public void keyReleased(KeyEvent keyEvent, int n) {
        Object object;
        this.isKeyPressed = false;
        if (keyEvent.getKeyCode() != 17) {
            return;
        }
        if (this.dataAccess != null) {
            object = this.getUniqueIDForItemIndex(n);
            if (object != null) {
                this.dataAccess.itemReleased((Long)object, n);
            } else {
                listLogCh.log(100000, "ListController#keyReleased: no ID defined for row %1", (long)n);
            }
        } else {
            listLogCh.log(10000, "ListController#keyReleased: no data access set. Model: %1", this.model);
        }
        if (this.expandableItemColumn == -1 || this.focusedIndexBeforeMerge == -1) {
            this.closeDrawersIfFastscrollInactive();
        } else if (this.model instanceof BaseListModel && ((BaseListModel)(object = (BaseListModel)this.model)).getRow(this.focusedIndexBeforeMerge) != null && ((BaseListModel)object).getRow(this.focusedIndexBeforeMerge).getCell(this.expandableItemColumn) != null) {
            try {
                int n2 = ((BaseListModel)object).getRow(this.focusedIndexBeforeMerge).getInteger(this.expandableItemColumn);
                if (n2 < 1) {
                    this.closeDrawersIfFastscrollInactive();
                }
            }
            catch (ClassCastException classCastException) {
                listLogCh.log(10000, "ListController#keyReleased: ClassCastException -> value of cell is no Integer");
            }
        }
    }

    public void itemFocused(int n) {
        if (this.model instanceof ListModelGUI) {
            ListModelGUI listModelGUI = (ListModelGUI)this.model;
            listLogCh.log(10000000, "ListController#itemFocused: call itemFocused. model: %1, row: %2", (long)listModelGUI.getID(), (long)n);
            listModelGUI.itemFocused(n, 0, this.terminal.getTerminalID());
        }
    }

    public IFocusedPropertyObject getPropertiesForLine(int n) {
        if (this.propertyColumn == -1) {
            return null;
        }
        if (this.dataAccess != null) {
            Object object = this.getModelRow(n);
            if (object == null) {
                return null;
            }
            Object object2 = this.dataAccess.getCell(object, this.propertyColumn);
            if (object2 instanceof PropertyListCell) {
                PropertyListCell propertyListCell = (PropertyListCell)object2;
                FocusedPropertyObject focusedPropertyObject = new FocusedPropertyObject();
                focusedPropertyObject.setPropertyListCell(propertyListCell, this.modelID, n);
                return focusedPropertyObject;
            }
            if (object2 != null) {
                listLogCh.log(10000, "ListController#getPropertiesForLine: invalid content for column %2: %1", object2, (long)this.propertyColumn);
            }
            return null;
        }
        listLogCh.log(10000, "ListController#getPropertiesForLine: no data access set. Model: %1", this.model);
        return null;
    }

    public boolean isEnabled(int n) {
        if (!this.isEnabled()) {
            return false;
        }
        Object object = this.getModelRow(n);
        return this.isEnabled(object);
    }

    private boolean isEnabled(Object object) {
        if (!this.isEnabled()) {
            return false;
        }
        if (this.enabledColumn == -1) {
            return true;
        }
        return this.getIntegerListCellValue(object, this.enabledColumn, 1, "enabledColumn") > 0;
    }

    public void setEnabled(boolean bl) {
        if (this.isEnabled() == bl) {
            return;
        }
        super.setEnabled(bl);
        if (this.isConnected()) {
            ModelUpdateEvent modelUpdateEvent = hmiService.getModelUpdateEvent(this.getTerminal().getTerminalID());
            modelUpdateEvent.setModelId(this.modelID);
            modelUpdateEvent.setUpdateType(6);
            this.propagateEventToListManager(modelUpdateEvent);
        }
    }

    public boolean isNowPlayingModeEnabled(int n) {
        if (this.nowPlayingModeEnabledColumn == -1) {
            return true;
        }
        Object object = this.getModelRow(n);
        return this.getIntegerListCellValue(object, this.nowPlayingModeEnabledColumn, 1, "nowPlayingModeEnabledColumn") > 0;
    }

    int getIntegerListCellValue(Object object, int n, int n2, String string) {
        if (object == null) {
            return n2;
        }
        if (this.dataAccess != null) {
            Object object2 = this.dataAccess.getCell(object, n);
            if (object2 instanceof IntegerListCell) {
                return ((IntegerListCell)object2).getValue();
            }
            if (object2 instanceof Integer) {
                return (Integer)object2;
            }
            listLogCh.log(10000, "ListController#getIntegerListCell: (%1): column %3 contains invalid cell: %2", (Object)string, object2, (long)n);
            return n2;
        }
        listLogCh.log(10000, "ListController#getIntegerListCell: (%2) no data access set. Model: %1", this.model, (Object)string);
        return n2;
    }

    public void setVisible(boolean bl) {
        super.setVisible(bl);
        this.updateDataAccessVisibility();
    }

    public void setVisibleOnCurrentStage(boolean bl) {
        super.setVisibleOnCurrentStage(bl);
        this.updateDataAccessVisibility();
    }

    private void updateDataAccessVisibility() {
        if (this.dataAccess != null) {
            boolean bl = this.shouldRender();
            this.dataAccess.setListWidgetVisible(bl);
        }
    }

    public int getSizeForTabulator(int n) {
        listLogCh.log(100000, "ListController#getSizeForTabulator: tabulators are not supported in list. tabulatorType: %1", (long)n);
        return -1;
    }

    public void showExtended(boolean bl, int n) {
        if (bl) {
            if (this.extendedMenuItem != -1 && this.extendedMenuItem != n) {
                listLogCh.log(100000, "ListController#showExtended: already another item expanded: %1, new expanded index: %2", (long)this.extendedMenuItem, (long)n);
            }
            this.extendedMenuItem = n;
        } else if (this.extendedMenuItem != n) {
            listLogCh.log(100000, "ListController#showExtended: collapsed index %2 was not stored as expanded (%1)", (long)this.extendedMenuItem, (long)n);
        } else {
            this.extendedMenuItem = -1;
        }
    }

    public int getExtendedMenuItem() {
        return this.extendedMenuItem;
    }

    public int getPropertyColumn() {
        return this.propertyColumn;
    }

    public void setPropertyColumn(int n) {
        this.propertyColumn = n;
    }

    private void closeDrawers() {
        IDrawerFocusManagerEvo iDrawerFocusManagerEvo = this.terminal.getDrawerFocusManager();
        if (iDrawerFocusManagerEvo != null) {
            if (iDrawerFocusManagerEvo.getDrawerState() != 16) {
                this.terminal.getIAnimationController().setDrawerWasClosed(true);
            }
            iDrawerFocusManagerEvo.requestDrawerState(16);
        }
    }

    private void closeDrawersIfFastscrollInactive() {
        MenuController menuController;
        boolean bl;
        if (this.parent instanceof MenuController && !(bl = (menuController = (MenuController)this.parent).getAnimationManager().isFastViewportScrollingRunning())) {
            this.closeDrawers();
        }
    }

    public int getEnabledColumn() {
        return this.enabledColumn;
    }

    public void setEnabledColumn(int n) {
        this.enabledColumn = n;
    }

    public IPresetPopupData getPresetPopupData(int n) {
        int n2 = -1;
        try {
            int[] nArray = null;
            AbstractWidget abstractWidget = ((MenuController)this.parent).getChildOfRole(1);
            nArray = abstractWidget.getColorIndices();
            n2 = this.initContext.getScreen().getCurrentColorPalette()[nArray[1]];
        }
        catch (NullPointerException nullPointerException) {
            logPreset.log(10000, "ListController#getPresetPopupData null pointer exception occured while cursor color evaluation - cursor color might be wrong", (Throwable)nullPointerException);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            logPreset.log(10000, "ListController#getPresetPopupData array out of bounds exception occured while cursor color evaluation - cursor color might be wrong", (Throwable)arrayIndexOutOfBoundsException);
        }
        return new PresetPopupData(0, n2, new Preset(1, this.modelID, 0, null, null, 99), null, null, n, null);
    }

    public int getWidgetID() {
        return this.widgetID;
    }

    public void setWidgetID(int n) {
        this.widgetID = n;
    }

    public int getItemIndexForUniqueID(long l) {
        if (this.dataAccess != null) {
            return this.dataAccess.getItemIndexForUniqueID(l);
        }
        listLogCh.log(10000, "ListController#getItemIndexForUniqueID: no data access set. Model: %1", this.model);
        return -1;
    }

    public Long getUniqueIDForItemIndex(int n) {
        if (this.dataAccess != null) {
            return this.dataAccess.getUniqueIDForItemIndex(n);
        }
        listLogCh.log(10000, "ListController#getUniqueIDForItemIndex: no data access set. Model: %1", this.model);
        return null;
    }

    public IListWidgetDataAccess getDataAccess() {
        return this.dataAccess;
    }

    public void setDataAccess(IListWidgetDataAccess iListWidgetDataAccess) {
        this.dataAccess = iListWidgetDataAccess;
        this.initializeDataAccess();
    }

    private void initializeDataAccess() {
        if (this.dataAccess == null) {
            return;
        }
        if (this.model instanceof HMIModelGUI) {
            this.dataAccess.setModel((HMIModel)this.model);
        }
        if (this.parent != null) {
            int n = this.parent.getChildren().indexOf(this);
            if (n == -1) {
                n = this.parent.getChildren().size();
            }
            this.dataAccess.setListWidgetIndex(n);
        }
        if (this.dataAccess instanceof OldListModelAccess) {
            ((OldListModelAccess)this.dataAccess).setIdColumn(this.idColumn);
        }
    }

    public void setModel(Object object) {
        super.setModel(object);
        this.initializeDataAccess();
    }

    public void setModel(HMIModelGUI hMIModelGUI) {
        super.setModel(hMIModelGUI);
        this.initializeDataAccess();
    }

    public void menuLayouted() {
        if (this.dataAccess != null) {
            MenuController menuController = (MenuController)this.parent;
            MenuItemIndex menuItemIndex = this.getLayoutItemIndex(menuController.getLayout().getFirstVisibleItem());
            MenuItemIndex menuItemIndex2 = this.getLayoutItemIndex(menuController.getLayout().getLastVisibleItem());
            this.dataAccess.rendered(menuItemIndex, menuItemIndex2);
        }
    }

    private MenuItemIndex getLayoutItemIndex(int n) {
        if (n == -1) {
            return null;
        }
        MenuController menuController = (MenuController)this.parent;
        List list = menuController.getAnimationManager().getLayoutItems();
        MenuItemMetaData menuItemMetaData = (MenuItemMetaData)list.get(n);
        return menuItemMetaData.index;
    }

    public void viewportUpdated(boolean bl) {
        if (this.dataAccess != null && bl) {
            MenuController menuController = (MenuController)this.parent;
            this.dataAccess.viewportChanged(menuController.getViewport());
        }
    }

    public boolean isAutoLayoutSetup() {
        return this.autoLayoutSetup;
    }

    public void setAutoLayoutSetup(boolean bl) {
        this.autoLayoutSetup = bl;
    }

    public void menuFocusChanged(MenuItemIndex menuItemIndex) {
    }

    public void menuSelectionChanged(MenuItemIndex menuItemIndex, Long l, MenuUpdateDelta menuUpdateDelta) {
    }

    public void menuFocusChangeFinished() {
    }

    public void setActiveMenuController(MenuController menuController) {
    }

    public void setHideOverlayDecoratorDuringScrolling(boolean bl) {
    }

    public int getSdsItemSelectedAction() {
        return this.sdsItemSelectedAction;
    }

    public void setSdsItemSelectedAction(int n) {
        this.sdsItemSelectedAction = n;
    }

    public int getSdsItemSelectedAction(int n) {
        Object object = this.getModelRow(n);
        if (object != null && this.sdsActionColumn != -1) {
            return this.getIntegerListCellValue(object, this.sdsActionColumn, 0, "sdsActionColumn");
        }
        return this.sdsItemSelectedAction;
    }

    public boolean hasInfolineText(int n) {
        return this.getInfolineText(n) != null;
    }

    public String getInfolineText(int n) {
        int n2;
        int[] nArray;
        int n3;
        Object object = this.getModelRow(n);
        if (object == null) {
            return null;
        }
        boolean bl = this.isEnabled(object);
        if (bl) {
            n3 = this.infolineTextEnabledColumn;
            nArray = this.infolineTextIdsEnabled;
        } else {
            n3 = this.infolineTextDisabledColumn;
            nArray = this.infolineTextIdsDisabled;
        }
        if (nArray == null || nArray.length == 0) {
            if (n3 != -1 && this.dataAccess != null) {
                Object object2 = this.dataAccess.getCell(object, n3);
                if (object2 instanceof TextListCell) {
                    object2 = ((TextListCell)object2).getText();
                }
                if (object2 instanceof String) {
                    if (((String)object2).length() > 0) {
                        return (String)object2;
                    }
                    return null;
                }
            }
            return null;
        }
        if (n3 == -1) {
            n3 = this.recordSetColumn;
        }
        if ((n2 = this.getIntegerListCellValue(object, n3, -1, "infoline")) == -1) {
            return null;
        }
        if (n2 < 0 || n2 >= nArray.length) {
            listLogCh.log(100000, "ListController#getInfolineText: model value for infoline is invalid: %1, texts.length: %2, item enabled: %3", (long)n2, (long)nArray.length, bl);
            return null;
        }
        int n4 = nArray[n2];
        return this.getTextForID(n4);
    }

    protected String getTextForID(int n) {
        AbstractScreenFactory abstractScreenFactory = this.getInitContext().getScreenFactory();
        if (abstractScreenFactory != null) {
            if (this.terminal != null && this.terminal.getViewSizeManager() != null) {
                return abstractScreenFactory.getText(n, this.terminal.getViewSizeManager().getCurrentViewSize());
            }
            return abstractScreenFactory.getText(n);
        }
        listLogCh.log(100000, "ListController#getInfolineText: screen factory is null. textID: %1", (long)n);
        return null;
    }

    public boolean isFocusable(int n) {
        if (this.focusableColumn == -1) {
            return true;
        }
        Object object = this.getModelRow(n);
        return this.isFocusable(object);
    }

    private boolean isFocusable(Object object) {
        if (this.focusableColumn == -1) {
            return true;
        }
        return this.getIntegerListCellValue(object, this.focusableColumn, 1, "focusableColumn") > 0;
    }

    public int[] getInfolineTextIdsEnabled() {
        return this.infolineTextIdsEnabled;
    }

    public void setInfolineTextIdsEnabled(int[] nArray) {
        this.infolineTextIdsEnabled = nArray;
    }

    public int[] getInfolineTextIdsDisabled() {
        return this.infolineTextIdsDisabled;
    }

    public void setInfolineTextIdsDisabled(int[] nArray) {
        this.infolineTextIdsDisabled = nArray;
    }

    public int getInfolineTextEnabledColumn() {
        return this.infolineTextEnabledColumn;
    }

    public void setInfolineTextEnabledColumn(int n) {
        this.infolineTextEnabledColumn = n;
    }

    public int getInfolineTextDisabledColumn() {
        return this.infolineTextDisabledColumn;
    }

    public void setInfolineTextDisabledColumn(int n) {
        this.infolineTextDisabledColumn = n;
    }

    public int getMenuContentWidth() {
        return this.menuContentWidth;
    }

    public int getMenuRightOptionsIconSpace() {
        return this.menuRightOptionsIconSpace;
    }

    public void setMenuSize(int n, int n2, int n3) {
        this.menuContentWidth = n;
        this.menuRightOptionsIconSpace = n3;
    }

    public int getFocusableColumn() {
        return this.focusableColumn;
    }

    public void setFocusableColumn(int n) {
        this.focusableColumn = n;
    }

    public void setSeparatingLineColumn(int n) {
        this.separatingLineColumn = n;
    }

    public ListLayoutCalculator getLayoutCalculator() {
        return this.layoutCalculator;
    }

    public boolean isRecordSetCacheIgnored() {
        return this.isRecordSetCacheIgnored;
    }

    public void setRecordSetCacheIgnored(boolean bl) {
        this.isRecordSetCacheIgnored = bl;
    }

    public boolean isCacheWidgetsPerRecordSet() {
        return this.cacheWidgetsPerRecordSet;
    }

    public void setCacheWidgetsPerRecordSet(boolean bl) {
        this.cacheWidgetsPerRecordSet = bl;
    }

    public void viewSizeAnimationStarted(float f2, float[] fArray, float[] fArray2) {
    }

    public int getSdsActionColumn() {
        return this.sdsActionColumn;
    }

    public void setSdsActionColumn(int n) {
        this.sdsActionColumn = n;
    }

    public boolean isKeyPressed() {
        return this.isKeyPressed;
    }

    public int getNowPlayingModeEnabledColumn() {
        return this.nowPlayingModeEnabledColumn;
    }

    public void setNowPlayingModeEnabledColumn(int n) {
        this.nowPlayingModeEnabledColumn = n;
    }

    public void setNoFocusAreaTopColumn(int n) {
    }

    public void setNoFocusAreaBottomColumn(int n) {
    }

    public int[] getNoCursorAreasTop() {
        return this.noCursorAreasTop;
    }

    public void setNoFocusAreasTop(int[] nArray) {
        this.noCursorAreasTop = nArray;
    }

    public int[] getNoCursorAreasBottom() {
        return this.noCursorAreasBottom;
    }

    public void setNoFocusAreasBottom(int[] nArray) {
        this.noCursorAreasBottom = nArray;
    }

    public int[] getGlassplateInsetsTop() {
        return this.glassplateInsetsTop;
    }

    public void setGlassplateInsetsTop(int[] nArray) {
        this.glassplateInsetsTop = nArray;
    }

    public int[] getGlassplateInsetsBottom() {
        return this.glassplateInsetsBottom;
    }

    public void setGlassplateInsetsBottom(int[] nArray) {
        this.glassplateInsetsBottom = nArray;
    }

    public void setExpandableItemColumn(int n) {
        this.expandableItemColumn = n;
    }

    public int getExpandableItemColumn() {
        return this.expandableItemColumn;
    }

    public void setFocusedCursorBeforeMerge(int n) {
        this.focusedIndexBeforeMerge = n;
    }

    public class ListModelRowMapper {
        private ModelUpdateEvent[] nestedEvents;
        int currentHandledEvent = 0;

        public ListModelRowMapper(ModelUpdateEvent[] modelUpdateEventArray) {
            this.nestedEvents = modelUpdateEventArray;
        }

        public int map(int n) {
            for (int i2 = this.currentHandledEvent + 1; i2 < this.nestedEvents.length; ++i2) {
                ModelUpdateEvent modelUpdateEvent = this.nestedEvents[i2];
                if (modelUpdateEvent.getModelId() != ListController.this.getModelID()) continue;
                n = this.map(n, modelUpdateEvent);
            }
            return n;
        }

        private int map(int n, ModelUpdateEvent modelUpdateEvent) {
            int n2 = modelUpdateEvent.getUpdateType();
            if (n2 == 9) {
                int n3;
                ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
                int n4 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData.Key.INDEX) : modelUpdateEvent.getClientData1();
                int n5 = n3 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData.Key.COUNT) : 1;
                if (n4 <= n) {
                    n -= n3;
                    n = Math.max(n4, n);
                }
            } else if (n2 == 7) {
                int n6;
                ModelUpdateData modelUpdateData = modelUpdateEvent.getClientData3();
                int n7 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData.Key.INDEX) : modelUpdateEvent.getClientData1();
                int n8 = n6 = modelUpdateData != null ? modelUpdateData.getInt(ModelUpdateData.Key.COUNT) : 1;
                if (n7 <= n) {
                    n += n6;
                }
            }
            return n;
        }

        public String toString() {
            return new Buffer().append("ListRowMapper[current event: ").append(this.currentHandledEvent).append(", max: ").append(this.nestedEvents.length - 1).append("]").toString();
        }
    }
}

