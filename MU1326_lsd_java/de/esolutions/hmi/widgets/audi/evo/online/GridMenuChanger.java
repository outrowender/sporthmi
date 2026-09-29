/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.online;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.RangeModel;
import de.audi.atip.hmi.model.ResourceLocatorModel;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.MenuModel;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.model.menu.focus.WidgetFocusAdvice;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.atip.hmi.model.update.ModelUpdateData;
import de.audi.atip.hmi.model.update.ModelUpdateData$Key;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.mmicombi.IViewSizeManager;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridCell;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IRangeCounter;
import de.audi.remotehmi.ui.mib2.grid.ISpeller;
import de.audi.remotehmi.util.DurationUtil$Timer;
import de.audi.remotehmi.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.LayoutManager;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.online.Dimensions;
import de.esolutions.hmi.widgets.audi.evo.online.GridListModel;
import de.esolutions.hmi.widgets.audi.evo.online.GridListModel$RowSubrowIterator;
import de.esolutions.hmi.widgets.audi.evo.online.GridListRow;
import de.esolutions.hmi.widgets.audi.evo.online.GridMenuChanger$MenuChildrenData;
import de.esolutions.hmi.widgets.audi.evo.online.GridWidgetFactory;
import de.esolutions.hmi.widgets.audi.evo.online.IGridImageLocker;
import de.esolutions.hmi.widgets.audi.evo.online.IInfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.InfiniteListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.online.MenuChangeController;
import de.esolutions.hmi.widgets.audi.evo.online.MenuChangeFactory;
import de.esolutions.hmi.widgets.audi.evo.online.RowInfo;
import de.esolutions.hmi.widgets.audi.evo.online.WidgetUtilities;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MultiLayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchController;
import de.esolutions.hmi.widgets.audi.evo.widgets.WaitAnimController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.IMenuItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuAnimationManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemIndex;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuLayout;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLineController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.SeparatingLines;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.BaseListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.IListWidgetDataAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class GridMenuChanger
extends GridWidgetFactory
implements MenuChangeFactory {
    private static final int APPROXIMATE_AVERAGE_LINE_HEIGHT;
    private static final int APPROXIMATE_VERTICAL_SPACE;
    private static final int MENU_BORDER_THICKNESS;
    private final MenuChangeController menuChangeController;
    private DurationUtil$Timer timer;

    public GridMenuChanger(MenuChangeController menuChangeController, int n, AbstractScreenFactory abstractScreenFactory) {
        super(n, abstractScreenFactory);
        if (menuChangeController == null) {
            throw new IllegalArgumentException("GridMenuChanger.Constructor(): Argument menuChangeController is not allowed to be null!");
        }
        this.menuChangeController = menuChangeController;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void changeMenu(Object object) {
        log.log(-2137614336, "GridMenuChanger#changeMenu: starting menu-change (and debug time) ...");
        if (!(object instanceof IGridList)) {
            throw new IllegalArgumentException(new StringBuffer().append("GridMenuChanger#changeMenu: Cannot draw new screen. layout data is not of type IGridList! layoutInfo=").append(object).toString());
        }
        IGridList iGridList = (IGridList)object;
        Object object2 = iGridList.getListener();
        if (!(object2 instanceof MenuModelListener)) {
            throw new IllegalArgumentException(new StringBuffer().append("GridMenuChanger#changeMenu: Cannot draw new screen. Listener data is not of type MenuModelListener! viewGridListener=").append(object2).toString());
        }
        IGridList iGridList2 = iGridList;
        synchronized (iGridList2) {
            try {
                this.changeMenuWork(iGridList, object2);
            }
            catch (RuntimeException runtimeException) {
                log.log(10000, "GridMenuChanger#changeMenu:  Cursor: %1!, ViewGridListener: %2, GridList %3,", (Object)iGridList.getCurrentCursor(), object2, (Object)iGridList);
                throw runtimeException;
            }
        }
    }

    private void changeMenuWork(IGridList iGridList, Object object) {
        int n;
        this.timer = new DurationUtil$Timer();
        log.log(-2137614336, "GridMenuChanger#changeMenu: new grid list = %1", iGridList.getLogObject(0));
        int n2 = iGridList.getUpdateSource();
        String string = new StringBuffer(IGridList.sourceDescription[n2]).append(" (idRangeStart: ").append(iGridList.getIdRangeStart()).append(")").toString();
        MenuController menuController = this.menuChangeController.getMainMenu();
        int n3 = n = iGridList.getAndClearUpdateMode();
        if (n < 0 || n >= IGridList.updateDescription.length) {
            log.log(10000, "GridMenuChanger#changeMenu: updateSource=%1 undefined update mode given (%1)! No update will be done.", (Object)string, (long)n);
            return;
        }
        String string2 = IGridList.updateDescription[n];
        log.log(1078071040, "GridMenuChanger#changeMenu: updateSource=%1 updateMode=%2 begin", (Object)string, (Object)string2);
        if (n != 5 && this.isMenuEmpty(menuController, iGridList)) {
            n = 5;
            log.log(1078071040, "GridMenuChanger#changeMenu: updateSource=%1 escalated from %2 to %3 because menu is empty.", (Object)string, (Object)IGridList.updateDescription[n3], (Object)IGridList.updateDescription[n]);
        } else if (!iGridList.isRendered() && n != 5) {
            n = 5;
            log.log(1078071040, "GridMenuChanger#changeMenu: updateSource=%1 escalated from %2 to %3 because grid list rendered flag is false.", (Object)string, (Object)IGridList.updateDescription[n3], (Object)IGridList.updateDescription[n]);
        } else if (iGridList.isDirty() && n != 5 && n != 4) {
            n = 4;
            log.log(1078071040, "GridMenuChanger#changeMenu: updateSource=%1 escalated from %2 to %3 because grid list dirty flag is true.", (Object)string, (Object)IGridList.updateDescription[n3], (Object)IGridList.updateDescription[n]);
        }
        if (n == 0) {
            log.log(1078071040, "GridMenuChanger#changeMenu: updateSource=%1 ... no menu-change needed!", (Object)string);
            return;
        }
        this.timer.takeMeasurement("prelim");
        this.updateOptionsIcon(iGridList.isRightDrawerAvailable(), this.menuChangeController.getFocusCursorController());
        this.timer.takeMeasurement("options-icon-only");
        if (n != 2) {
            iGridList.calculateAllDisplayedRows();
            this.timer.takeMeasurement("calc-displayed-rows");
        }
        MenuController menuController2 = this.menuChangeController.getHeaderMenu();
        if (n == 2) {
            this.updateCursorOnly(iGridList, menuController);
            this.timer.takeMeasurement("update-cursor-only");
        } else if (n == 3) {
            boolean bl;
            boolean bl2 = false;
            MenuAnimationManager menuAnimationManager = menuController.getAnimationManager();
            if (menuAnimationManager != null) {
                bl2 = menuAnimationManager.isScrollAnimationRunning();
            }
            boolean bl3 = bl = iGridList.getUpdateSource() == 4 && bl2;
            if (!bl) {
                this.updateValuesOnly(iGridList, menuController, menuController2);
                this.timer.takeMeasurement("values-only");
            }
        } else if (n == 4) {
            this.updateGridStructureAndValues(iGridList, menuController, menuController2, object);
            this.timer.takeMeasurement("grid-structure");
            if (iGridList.isDirty()) {
                iGridList.setDirty(false);
            }
        } else if (n == 5) {
            this.updateMenuStructureAndValues(iGridList, menuController, menuController2, object);
            this.timer.takeMeasurement("menu-structure");
            if (iGridList.isDirty()) {
                iGridList.setDirty(false);
            }
        } else if (n == 1) {
            log.log(1078071040, "GridMenuChanger#changeMenu: Doing nothing, option icon already updated. updateSource=%1, updateMode=%2", (Object)string, (Object)string2);
        } else {
            log.log(10000, "GridMenuChanger#changeMenu: unknown update mode encountered. Please correct code. updateSource=%1, updateMode=%2", (Object)string, (long)n);
            return;
        }
        if (!iGridList.isRendered()) {
            log.log(10000, "GridMenuChanger#changeMenu: gridList remains unrendered! updateSource=%1, updateMode=%2", (Object)string, (Object)string2);
        }
        if (iGridList.isDirty()) {
            log.log(10000, "GridMenuChanger#changeMenu: gridList remains dirty! updateSource=%1, updateMode=%2", (Object)string, (Object)string2);
        }
        log.log(1078071040, "GridMenuChanger#changeMenu: rendering completed! updateSource=%1 updateMode=%2, timing: %3", (Object)string, (Object)string2, (Object)this.timer);
    }

    private boolean isMenuEmpty(MenuController menuController, IGridList iGridList) {
        List list = menuController.getChildren();
        boolean bl = iGridList.getViewType() == 2;
        int n = iGridList.getIdRangeStart();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!(abstractWidget instanceof IMenuItem)) continue;
            IMenuItem iMenuItem = (IMenuItem)((Object)abstractWidget);
            boolean bl2 = iMenuItem instanceof MenuItemController;
            boolean bl3 = iMenuItem instanceof ListController;
            if (!bl2 && !bl3) continue;
            int n3 = iMenuItem.getWidgetID();
            if (bl && n3 != n || !bl && iGridList.getIndexFromId(n3) == -1) continue;
            return false;
        }
        return true;
    }

    private void updateMenuStructureAndValues(IGridList iGridList, MenuController menuController, MenuController menuController2, Object object) {
        boolean bl;
        Object object2;
        AbstractWidgetController abstractWidgetController;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        log.log(1078071040, "GridMenuChanger#updateMenuStructureAndValues: new grid list = %1", iGridList.getLogObject(0));
        if (this.lockController != null) {
            this.lockController.clearMenuImages();
        }
        int n = iGridList.getContentRightOffset();
        log.log(1078071040, "GridMenuChanger#updateMenuStructureAndValues: rightOffset=%1", (long)n);
        MenuLayout menuLayout = menuController.getLayout();
        if (n != -1) {
            menuLayout.setContentRightOffset(n);
            menuLayout.setContentRightOffsetSmallStage(n);
            if (menuController2 != null) {
                object6 = menuController2.getLayout();
                ((MenuLayout)object6).setContentRightOffset(n);
                menuLayout.setContentRightOffsetSmallStage(n);
            }
        }
        this.setTabIds(menuController, iGridList);
        object6 = iGridList.getHeader();
        if (menuController2 != null && object6 != null) {
            this.setTabIds(menuController2, (IGridList)object6);
        }
        ScrollbarController scrollbarController = this.menuChangeController.getMainScrollbar1();
        ScrollbarController scrollbarController2 = this.menuChangeController.getMainScrollbar2();
        if (menuController2 != null) {
            int n2;
            if (object6 != null) {
                this.updateMenu((IGridList)object6, menuController2, null, null);
            }
            if (object6 == null || object6.size() == 0) {
                n2 = 0;
            } else {
                menuController2.setCalculatePreferredSize(true);
                menuController2.updatePreferredSize();
                n2 = menuController2.getPreferredHeight();
            }
            GlassplateController glassplateController = this.menuChangeController.getGlassPlate();
            int[] nArray = this.menuChangeController.getMainMenuInitialDimensions();
            object5 = this.menuChangeController.getMainScrollbar1InitialDimensions();
            object4 = this.menuChangeController.getMainScrollbar2InitialDimensions();
            object3 = this.resizeHeaderAndMainMenu(menuController2, menuController, scrollbarController, scrollbarController2, glassplateController, n2, nArray, (int[])object5, (int[])object4);
            abstractWidgetController = this.menuChangeController.getImageDecorator();
            object2 = abstractWidgetController == null || !abstractWidgetController.isVisible() ? null : abstractWidgetController;
            int[] nArray2 = this.menuChangeController.getImageDecoratorInitialDimensions();
            this.resizeDecorator((AbstractWidgetController)object2, nArray2, n2, menuController, (int[])object3);
        }
        ListController listController = this.findOldInfiniteListController(menuController);
        boolean bl2 = iGridList.getViewType() == 2;
        boolean bl3 = bl = listController != null && bl2 && listController.getWidgetID() == iGridList.getIdRangeStart();
        if (listController != null && scrollbarController != null) {
            scrollbarController.setEntireMax(0);
            scrollbarController.setEntireValue(0);
        }
        if (listController != null && scrollbarController2 != null) {
            scrollbarController2.setEntireMax(0);
            scrollbarController2.setEntireValue(0);
        }
        object5 = (MenuModel)menuController.getModel();
        object4 = bl2 ? null : ((MenuModel)object5).getAdvice();
        log.log(1078071040, "GridMenuChanger#updateMenuStructureAndValues: oldAdvice=%1", object4);
        if (listController != null && !bl) {
            object3 = (GridListModel)listController.getModel();
            ((BaseListModel)object3).setListener(null);
        }
        ((MenuModel)object5).setListener(null);
        object3 = this.updateMenu(iGridList, menuController, object, bl ? listController : null);
        ((MenuModel)object5).setListener((MenuModelListener)object);
        abstractWidgetController = (TouchController)menuController.getChildOfRole(5);
        if (abstractWidgetController != null) {
            object2 = iGridList.getSpeller();
            ((TouchController)abstractWidgetController).setInitialText(object2.getInitialText());
            ((TouchController)abstractWidgetController).setInfoLineText(object2.getInfoText());
            ((TouchController)abstractWidgetController).setTouchpadMode(object2.getType() == 0 ? 48 : 32);
        }
        iGridList.setRendered(true);
        if (!bl) {
            this.updateFocus(menuController, iGridList, (List)object3, (WidgetFocusAdvice)object4);
        }
    }

    private void resizeDecorator(AbstractWidgetController abstractWidgetController, int[] nArray, int n, MenuController menuController, int[] nArray2) {
        int n2;
        int[] nArray3;
        int n3;
        int n4;
        if (abstractWidgetController == null) {
            return;
        }
        int n5 = n4 = nArray2 == null ? 0 : nArray2.length;
        if (n4 != Dimensions.DIMENSIONS_SIZE) {
            log.log(10000, "GridMenuChanger#resizeDecorators: menuDimensionsLength length must be %1, but length=%2", (long)Dimensions.DIMENSIONS_SIZE, (long)n4);
            return;
        }
        int n6 = n3 = nArray == null ? 0 : nArray.length;
        if (n3 != Dimensions.DIMENSIONS_SIZE) {
            log.log(10000, "GridMenuChanger#resizeDecorators: imageDecoratorInitialDimensions length must be %1, but length=%2", (long)Dimensions.DIMENSIONS_SIZE, (long)n3);
            return;
        }
        if (n == 0) {
            nArray3 = abstractWidgetController == null ? null : nArray;
        } else {
            nArray3 = abstractWidgetController == null ? null : Dimensions.getAll(abstractWidgetController);
            for (n2 = 0; n2 < Dimensions.STAGE_OFFSETS.length; ++n2) {
                int n7 = Dimensions.STAGE_OFFSETS[n2];
                int n8 = nArray2[n7 + 3];
                this.changeDecoratorHeightAndYPosForStage(n7, nArray3, nArray, n8, n);
            }
        }
        n2 = this.determineStage(menuController);
        Dimensions.setAll(abstractWidgetController, nArray3, n2);
    }

    private void changeDecoratorHeightAndYPosForStage(int n, int[] nArray, int[] nArray2, int n2, int n3) {
        int n4;
        int n5 = nArray2[n + 3];
        int n6 = nArray2[n + 1];
        int n7 = Math.max(0, n2 - 20);
        int n8 = Math.max(0, n5 - n7);
        int n9 = (n3 + n8) / 2;
        int n10 = n6 + n9;
        nArray[n + 3] = n4 = Math.min(n7, n5);
        nArray[n + 1] = n10;
    }

    private void setTabIds(MenuController menuController, IGridList iGridList) {
        menuController.setAutoConfigureTabulators(false);
        int[] nArray = iGridList.getTabIdArray();
        MenuLayout menuLayout = menuController.getLayout();
        menuLayout.setTabulatorIDs(nArray);
        int[] nArray2 = new int[nArray.length];
        Arrays.fill(nArray2, 3);
        menuLayout.setTabulatorAlignments(nArray2);
    }

    private int[] resizeHeaderAndMainMenu(MenuController menuController, MenuController menuController2, ScrollbarController scrollbarController, ScrollbarController scrollbarController2, GlassplateController glassplateController, int n, int[] nArray, int[] nArray2, int[] nArray3) {
        int n2;
        int n3;
        int n4;
        if (menuController == null || menuController2 == null) {
            log.log(10000, "GridMenuChanger#resizeHeaderAndMainMenu: menus must not be null, but headerMenu=%1, mainMenu=%2", (Object)menuController, (Object)menuController2);
            return nArray;
        }
        int n5 = n4 = nArray == null ? 0 : nArray.length;
        if (n4 != Dimensions.DIMENSIONS_SIZE) {
            log.log(10000, "GridMenuChanger#resizeHeaderAndMainMenu: mainMenuInitialDimensions length must be %1, but length=%2", (long)Dimensions.DIMENSIONS_SIZE, (long)n4);
            return nArray;
        }
        int n6 = n3 = nArray2 == null ? 0 : nArray2.length;
        if (n3 != Dimensions.DIMENSIONS_SIZE) {
            log.log(10000, "GridMenuChanger#resizeHeaderAndMainMenu: mainScrollbar1InitialDimensions length must be %1, but length=%2", (long)Dimensions.DIMENSIONS_SIZE, (long)n3);
            return nArray;
        }
        if (scrollbarController2 != null) {
            int n7;
            int n8 = n7 = nArray3 == null ? 0 : nArray3.length;
            if (n7 != Dimensions.DIMENSIONS_SIZE) {
                log.log(10000, "GridMenuChanger#resizeHeaderAndMainMenu: mainScrollbar2InitialDimensions length must be %1, but length=%2", (long)Dimensions.DIMENSIONS_SIZE, (long)n7);
                return nArray;
            }
        }
        int[] nArray4 = Dimensions.getAll(menuController2);
        int[] nArray5 = Dimensions.getAll(scrollbarController);
        int[] nArray6 = scrollbarController2 == null ? null : Dimensions.getAll(scrollbarController2);
        int[] nArray7 = Dimensions.getAll(menuController);
        for (n2 = 0; n2 < Dimensions.STAGE_OFFSETS.length; ++n2) {
            int n9 = Dimensions.STAGE_OFFSETS[n2];
            int n10 = nArray7[n9 + 1] + n;
            int n11 = Math.max(0, nArray[n9 + 3] - n);
            int n12 = Math.max(0, nArray2[n9 + 3] - n);
            int n13 = scrollbarController2 == null ? 0 : Math.max(0, nArray3[n9 + 3] - n);
            nArray7[n9 + 3] = n;
            nArray5[n9 + 3] = n12;
            if (scrollbarController2 != null) {
                nArray6[n9 + 3] = n13;
            }
            nArray4[n9 + 3] = n11;
            nArray4[n9 + 1] = n10;
        }
        n2 = this.determineStage(menuController2);
        Dimensions.setAll(menuController2, nArray4, n2);
        Dimensions.setAll(scrollbarController, nArray5, n2);
        if (scrollbarController2 != null) {
            Dimensions.setAll(scrollbarController2, nArray6, n2);
        }
        if (glassplateController != null) {
            glassplateController.setSeparatorYPosition(n);
            glassplateController.setSeparatorVisible(n != 0);
        }
        if (n == 0) {
            menuController.setVisible(false);
        } else {
            Dimensions.setAll(menuController, nArray7, n2);
        }
        return nArray4;
    }

    private int determineStage(MenuController menuController) {
        HMITerminalImpl hMITerminalImpl = menuController.getTerminalImpl();
        if (hMITerminalImpl == null) {
            return Dimensions.STAGE_LARGE;
        }
        IViewSizeManager iViewSizeManager = hMITerminalImpl.getViewSizeManager();
        if (iViewSizeManager == null) {
            return Dimensions.STAGE_LARGE;
        }
        if (iViewSizeManager.getCurrentViewSize() != 1) {
            return Dimensions.STAGE_LARGE;
        }
        InitializationContext initializationContext = menuController.getInitContext();
        if (initializationContext == null) {
            return Dimensions.STAGE_SMALL;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)((Object)initializationContext.getScreen());
        if (!(abstractWidgetController instanceof AbstractScreenWidget)) {
            return Dimensions.STAGE_SMALL;
        }
        AbstractScreenWidget abstractScreenWidget = (AbstractScreenWidget)abstractWidgetController;
        if (abstractScreenWidget.getSmallStageType() == 3) {
            return Dimensions.STAGE_LARGE;
        }
        return Dimensions.STAGE_SMALL;
    }

    private ListController findOldInfiniteListController(MenuController menuController) {
        ListController listController = null;
        ListIterator listIterator = menuController.getChildren().listIterator();
        while (listIterator.hasNext()) {
            AbstractWidget abstractWidget = (AbstractWidget)listIterator.next();
            if (abstractWidget instanceof ListController) {
                listController = (ListController)abstractWidget;
                break;
            }
            if (!(abstractWidget instanceof MenuItemController)) continue;
            break;
        }
        return listController == null || !(listController.getDataAccess() instanceof IInfiniteListModelAccess) ? null : listController;
    }

    private void updateFocus(MenuController menuController, IGridList iGridList, List list, WidgetFocusAdvice widgetFocusAdvice) {
        ICursorComponent iCursorComponent = iGridList.getCurrentCursor().getFocus();
        int n = iCursorComponent.getIndex();
        int n2 = iCursorComponent.getSubindex();
        log.log(1078071040, "GridMenuChanger#updateFocus: new focus = %1 (list idRangeStart=%2)", (Object)iCursorComponent, (long)iGridList.getIdRangeStart());
        int n3 = iGridList.getIndexBeforeLastPageOfInfiniteList();
        int[] nArray = this.getFocusedWidgetIds(iGridList, list, n, n2);
        FocusAdvice focusAdvice = this.getFocusAdvice(n, n3, widgetFocusAdvice);
        if (menuController.isConnected()) {
            this.setCurrentMenuFocus(menuController, nArray, focusAdvice);
        }
        int n4 = nArray == null ? 0 : nArray.length;
        int n5 = n4 >= 1 ? nArray[0] : -1;
        int n6 = n4 == 2 ? nArray[1] : -1;
        MenuModel menuModel = (MenuModel)menuController.getModel();
        menuModel.setFocusedItem(n5, focusAdvice, n6);
        menuController.getInitialization().setInitialAvoidPartiallyEmptyViewport(n5 == -1);
    }

    private FocusAdvice getFocusAdvice(int n, int n2, WidgetFocusAdvice widgetFocusAdvice) {
        FocusAdvice focusAdvice = n <= 0 ? FocusAdvice.VIEWPORT_FIRST_POSITION : (n > n2 && n2 != -1 ? FocusAdvice.VIEWPORT_LAST_POSITION : (widgetFocusAdvice != null ? widgetFocusAdvice : FocusAdvice.KEEP_POSITION));
        return focusAdvice;
    }

    private void updateCursorOnly(IGridList iGridList, MenuController menuController) {
        ICursor iCursor = iGridList.getCurrentCursor();
        ICursorComponent iCursorComponent = iCursor.getSelection();
        int n = iGridList.isSelectionEnabled() ? iCursorComponent.getIndex() : -1;
        int n2 = iGridList.isSelectionEnabled() ? iCursorComponent.getSubindex() : -1;
        ICursorComponent iCursorComponent2 = iCursor.getFocus();
        int n3 = iCursorComponent2.getIndex();
        int n4 = iCursorComponent2.getSubindex();
        List list = menuController.getChildren();
        int n5 = iGridList.getViewType();
        boolean bl = n5 == 2;
        int n6 = bl ? iGridList.getInfiniteListData().getStartIndex() : 0;
        int n7 = iGridList.getIdRangeStart();
        int n8 = list.size();
        for (int i2 = 0; i2 < n8; ++i2) {
            boolean bl2;
            boolean bl3;
            IGrid iGrid;
            int n9;
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!(abstractWidget instanceof IMenuItem)) continue;
            IMenuItem iMenuItem = (IMenuItem)((Object)abstractWidget);
            boolean bl4 = iMenuItem instanceof MenuItemController;
            boolean bl5 = iMenuItem instanceof ListController;
            if (!bl4 && !bl5) continue;
            int n10 = iMenuItem.getWidgetID();
            if (bl) {
                if (n10 != n7) {
                    log.log(1078071040, "GridMenuChanger#updateCursorOnly: menu child with id=%1 is not an infinite list controller", (long)n10);
                    continue;
                }
                n9 = -1;
                iGrid = null;
            } else {
                n9 = iGridList.getIndexFromId(n10);
                if (n9 == -1) {
                    log.log(1078071040, "GridMenuChanger#updateCursorOnly: menu child with id=%1 is not a grid list element", (long)n10);
                    continue;
                }
                iGrid = (IGrid)iGridList.get(n9);
            }
            boolean bl6 = bl ? true : (bl3 = n == n9);
            boolean bl7 = bl ? true : (bl2 = n3 == n9);
            if (bl4) {
                this.updateCursorForMenuItem((MenuItemController)iMenuItem, iGrid, bl2, bl3);
                continue;
            }
            int n11 = bl ? n3 : n4;
            int n12 = bl ? n : n2;
            this.updateCursorForList((ListController)iMenuItem, iGrid, bl2, bl3, n11, n12, bl, n6);
        }
    }

    private void updateCursorForList(ListController listController, IGrid iGrid, boolean bl, boolean bl2, int n, int n2, boolean bl3, int n3) {
        long l;
        if (bl && !bl3) {
            this.checkAndExpandOrCollapse(listController, iGrid);
        }
        this.checkAndChangeLayout(listController, bl, n);
        if (bl3) {
            GridListModel gridListModel = (GridListModel)listController.getModel();
            l = gridListModel.findUniqueIdAmongDisplayedRows(n2, n3);
        } else {
            l = n2;
        }
        this.checkAndChangeSelection(listController, bl2, l);
    }

    private void updateCursorForMenuItem(MenuItemController menuItemController, IGrid iGrid, boolean bl, boolean bl2) {
        int n;
        Object object;
        LayoutManager[] layoutManagerArray = menuItemController.getLayoutChoices();
        LayoutManager layoutManager = menuItemController.getLayoutManager();
        int n2 = this.calculateLayout(iGrid, bl);
        if (layoutManagerArray[n2] != layoutManager) {
            menuItemController.selectLayoutManager(n2);
            object = GridWidgetFactory.calculateInfoText(iGrid, n2);
            menuItemController.setInfolineTextDisabled((String)object);
            menuItemController.setInfolineTextEnabled((String)object);
        }
        object = (ChoiceModel)menuItemController.getModel();
        int n3 = n = bl2 ? menuItemController.getWidgetID() : -1;
        if (n != ((ChoiceModel)object).getValue()) {
            ((ChoiceModel)object).setValue(n);
            menuItemController.updateFromModel();
        }
    }

    private void updateOptionsIcon(boolean bl, FocusCursorController focusCursorController) {
        log.log(1078071040, "GridMenuChanger#updateOptionsIcon: focusCursorController '%1' and isRightDrawerAvailable '%2'", (Object)focusCursorController, (Object)bl);
        if (focusCursorController != null) {
            focusCursorController.setOptionsIconVisibleForOnline(bl);
        }
    }

    private void checkAndChangeSelection(ListController listController, boolean bl, long l) {
        long l2;
        GridListModel gridListModel = (GridListModel)listController.getModel();
        SelectedItem selectedItem = gridListModel.getSelected();
        int n = selectedItem == null ? -1 : (int)selectedItem.getUniqueID();
        long l3 = l2 = bl ? l : -1L;
        if ((long)n != l2) {
            if (l2 == -1L) {
                gridListModel.setSelectedIndex(-1);
            } else {
                gridListModel.setSelectedUniqueID(l2);
            }
            WidgetUtilities.updateListControllerDirectly(listController, 22, null, this.terminalId);
        }
    }

    private void checkAndChangeLayout(ListController listController, boolean bl, int n) {
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n2 = gridListModel.getLength();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            GridListRow gridListRow = (GridListRow)gridListModel.getGuiRow(i2);
            long l = gridListRow.getUniqueID();
            int n4 = this.calculateLayout(gridListRow.getGrid(), bl && (long)n == l);
            if (n4 == (n3 = gridListRow.getLayoutType())) continue;
            GridListRow gridListRow2 = (GridListRow)gridListModel.getRow(i2);
            gridListRow2.setGridAndLayout(gridListRow2.getGrid(), n4);
            gridListModel.setRow(i2, gridListRow2);
            WidgetUtilities.notifyChangedRowsImmediately(i2, 1, listController, this.terminalId);
        }
    }

    private void checkAndExpandOrCollapse(ListController listController, IGrid iGrid) {
        ModelTrigger modelTrigger;
        int n;
        long l;
        int n2;
        Object object;
        boolean bl;
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n3 = gridListModel.getLength();
        if (n3 == 0) {
            log.log(10000, "GridMenuChanger#expandOrCollapseIfNeeded: Expandable list item model has no subitems! Grid=%1", (Object)iGrid);
            return;
        }
        boolean bl2 = n3 > 1;
        if (bl2 == (bl = iGrid.isExpanded())) {
            return;
        }
        GridListRow gridListRow = (GridListRow)gridListModel.getGuiRow(0);
        long l2 = gridListRow.getUniqueID();
        if (bl) {
            object = iGrid.getExpandedList();
            EvoListRow[] evoListRowArray = this.createGridListRows((IGridList)object, 0, -1);
            n2 = evoListRowArray.length;
            if (n2 == 0) {
                log.log(10000, "GridMenuChanger#expandOrCollapseIfNeeded: Expandable list item has no visible subitems! Grid=%1", (Object)iGrid);
                return;
            }
            gridListModel.insertAfterAndOpen(-1L, evoListRowArray);
            GridListRow gridListRow2 = (GridListRow)gridListModel.getGuiRow(1);
            l = gridListRow2.getUniqueID();
            n = 7;
            modelTrigger = ModelTrigger.OPEN_FOLDER;
        } else {
            object = (GridListRow)gridListModel.getGuiRow(1);
            l = ((EvoListRow)object).getUniqueID();
            n2 = n3 - 1;
            gridListModel.removeAndClose(-1L, n2);
            n = 9;
            modelTrigger = ModelTrigger.CLOSE_FOLDER;
        }
        gridListRow.getGrid().setExpanded(bl);
        object = ModelUpdateData.obtain(n).put(ModelUpdateData$Key.INDEX, 1).put(ModelUpdateData$Key.UNIQUEID, l).put(ModelUpdateData$Key.COUNT, n2).put(ModelUpdateData$Key.PARENT_UNIQUEID, l2).put(ModelUpdateData$Key.TRIGGER, modelTrigger);
        WidgetUtilities.updateListControllerDirectly(listController, n, (ModelUpdateData)object, this.terminalId);
    }

    private int[] getFocusedWidgetIds(IGridList iGridList, List list, int n, int n2) {
        int[] nArray;
        if (n == -1) {
            log.log(-2137614336, "GridMenuChanger#getFocusedWidgetIds: no item is focused.");
            return null;
        }
        if (iGridList.getViewType() == 2) {
            int n3 = iGridList.calculateUniqueId(n, 0);
            int n4 = iGridList.getIdRangeStart();
            int[] nArray2 = new int[]{n4, n3};
            log.log(-2137614336, "GridMenuChanger#getFocusedWidgetIds: infinite list focused widget id=%1, subid=%2", (long)n4, (long)n3);
            return nArray2;
        }
        IGrid iGrid = (IGrid)iGridList.get(n);
        int n5 = iGrid.getDisplayedRow();
        int n6 = list.size();
        if (n5 < 0 || n5 >= n6) {
            log.log(10000, "GridMenuChanger#getFocusedWidgetIds: menuItemList should contain an entry for each row! list size=%1, row=%2", (long)n6, (long)n5);
            return null;
        }
        AbstractWidgetController abstractWidgetController = (AbstractWidgetController)list.get(n5);
        if (abstractWidgetController instanceof MenuItemController) {
            MenuItemController menuItemController = (MenuItemController)abstractWidgetController;
            int n7 = menuItemController.getWidgetID();
            nArray = new int[]{n7};
            log.log(-2137614336, "GridMenuChanger#getFocusedWidgetIds: menu item focused widget id=%1", (long)n7);
        } else if (abstractWidgetController instanceof ListController) {
            ListController listController = (ListController)abstractWidgetController;
            int n8 = listController.getWidgetID();
            nArray = new int[]{n8, n2};
            log.log(-2137614336, "GridMenuChanger#getFocusedWidgetIds: list item focused widget id=%1, subid=%2", (long)n8, (long)n2);
        } else {
            log.log(10000, new StringBuffer().append("GridMenuChanger#getFocusedWidgetIds: Menu contains an unsupported item type. item=%1, displayedRow=%2").append(abstractWidgetController).toString(), (long)n5);
            return null;
        }
        return nArray;
    }

    private void setCurrentMenuFocus(MenuController menuController, int[] nArray, FocusAdvice focusAdvice) {
        int n;
        MenuItemIndex menuItemIndex = null;
        int n2 = n = nArray == null ? 0 : nArray.length;
        if (n > 0) {
            int n3 = nArray[0];
            ListIterator listIterator = menuController.getChildren().listIterator();
            while (listIterator.hasNext()) {
                int n4;
                AbstractWidgetController abstractWidgetController;
                AbstractWidget abstractWidget = (AbstractWidget)listIterator.next();
                int n5 = listIterator.previousIndex();
                if (abstractWidget instanceof MenuItemController) {
                    abstractWidgetController = (MenuItemController)abstractWidget;
                    n4 = ((MenuItemController)abstractWidgetController).getWidgetID();
                    log.log(-2137614336, "GridMenuChanger#setCurrentMenuFocus: loop step %1: menuItemController id=%2", (long)n5, (long)n4);
                    if (n3 != n4) continue;
                    menuItemIndex = new MenuItemIndex(n5, 0);
                    log.log(1078071040, "GridMenuChanger#setCurrentMenuFocus: loop step %1: found MenuItemController focusedMenuItemIndex=%2", (Object)Util.createInteger(n5), (Object)menuItemIndex);
                    break;
                }
                if (abstractWidget instanceof ListController && n == 2) {
                    abstractWidgetController = (ListController)abstractWidget;
                    n4 = ((ListController)abstractWidgetController).getWidgetID();
                    log.log(-2137614336, "GridMenuChanger#setCurrentMenuFocus: loop step %1: ListController id=%2", (long)n5, (long)n4);
                    if (n3 != n4) continue;
                    int n6 = nArray[1];
                    menuItemIndex = new MenuItemIndex(n5, ((ListController)abstractWidgetController).getItemIndexForUniqueID(n6));
                    log.log(1078071040, "GridMenuChanger#setCurrentMenuFocus: loop step %1: found ListController focusedMenuItemIndex=%2", (Object)Util.createInteger(n5), (Object)menuItemIndex);
                    break;
                }
                log.log(-2137614336, "GridMenuChanger#setCurrentMenuFocus: loop step %1: class=%2", (Object)Util.createInteger(n5), (Object)abstractWidget.getClassName());
            }
        }
        if (menuItemIndex == null) {
            menuItemIndex = menuController.getFirstMenuItem();
            log.log(1078071040, "GridMenuChanger#setCurrentMenuFocus: Speller focusedMenuItemIndex=%2", (Object)menuItemIndex);
        }
        log.log(-2137614336, "GridMenuChanger#setCurrentMenuFocus: focussing advice=%1, MenuItemIndex=%2", (Object)focusAdvice, (Object)menuItemIndex);
        menuController.focusItemImmediately(menuItemIndex, focusAdvice);
    }

    private List updateMenu(IGridList iGridList, MenuController menuController, Object object, ListController listController) {
        GridMenuChanger$MenuChildrenData gridMenuChanger$MenuChildrenData;
        GridListRow[] gridListRowArray;
        SeparatingLines separatingLines = (SeparatingLines)menuController.getChildOfRole(8);
        if (separatingLines != null && separatingLines.isAuto()) {
            separatingLines.setManual();
        }
        ICursor iCursor = iGridList.getCurrentCursor();
        ICursorComponent iCursorComponent = iCursor.getFocus();
        int n = iCursorComponent.getIndex();
        MenuModel menuModel = (MenuModel)menuController.getModel();
        if (iGridList.getViewType() == 2) {
            int n2;
            if (listController == null) {
                n2 = 0;
            } else {
                GridListModel gridListModel = (GridListModel)listController.getModel();
                n2 = gridListModel.nextUpdate();
            }
            gridListRowArray = this.createGridListRows(iGridList, n2, n);
            gridMenuChanger$MenuChildrenData = new GridMenuChanger$MenuChildrenData(new ArrayList(0), new ArrayList(0));
        } else {
            ICursorComponent iCursorComponent2 = iCursor.getSelection();
            int n3 = iGridList.isSelectionEnabled() ? iCursorComponent2.getIndex() : -1;
            gridListRowArray = null;
            int n4 = menuController.getWidth() - iGridList.getContentRightOffset();
            gridMenuChanger$MenuChildrenData = this.createMenuChildrenList(iGridList, object, menuModel, n4, separatingLines, n3, iCursorComponent2.getSubindex(), n, iCursorComponent.getSubindex());
        }
        this.timer.takeMeasurement("created-widgets");
        this.redrawScreen(menuController, iGridList, gridMenuChanger$MenuChildrenData, listController, gridListRowArray, object);
        return gridMenuChanger$MenuChildrenData.menuItemList;
    }

    private GridMenuChanger$MenuChildrenData createMenuChildrenList(IGridList iGridList, Object object, MenuModel menuModel, int n, SeparatingLines separatingLines, int n2, int n3, int n4, int n5) {
        ISpeller iSpeller = iGridList.getSpeller();
        SpellerListener spellerListener = iSpeller == null ? null : (SpellerListener)iSpeller.getSpellerListener();
        int n6 = iGridList.getIdRangeStart();
        boolean bl = iGridList.getViewType() == 1;
        ArrayList arrayList = new ArrayList(iGridList.size());
        ArrayList arrayList2 = new ArrayList(iGridList.size());
        IGrid iGrid = null;
        AbstractWidgetController abstractWidgetController = null;
        ListIterator listIterator = iGridList.listIterator();
        while (listIterator.hasNext()) {
            SeparatingLineController separatingLineController;
            IGrid iGrid2 = (IGrid)listIterator.next();
            if (!iGrid2.isVisible()) continue;
            int n7 = listIterator.previousIndex();
            boolean bl2 = n2 == n7 && n2 != -1;
            boolean bl3 = n4 == n7 && n4 != -1;
            int n8 = bl3 ? n5 : -1;
            int n9 = bl2 ? n3 : -1;
            int n10 = n6 + n7;
            AbstractWidgetController abstractWidgetController2 = iGrid2.hasVisibleExpandableListEntries() ? this.createListAndFill(iGrid2, object, n10, bl2, n9, bl3, n8, menuModel) : this.createMenuItemWithLayouts(iGrid2, object, spellerListener, n10, bl, bl2, bl3, true);
            if (separatingLines != null && abstractWidgetController != null && iGrid != null && iGrid.isFollowedBySeparator() && (separatingLineController = separatingLines.addSeparator(abstractWidgetController, abstractWidgetController2)) != null) {
                separatingLineController.setWidth(n);
                IconRenderer iconRenderer = (IconRenderer)separatingLineController.getRenderer();
                iconRenderer.setScaleMode(3);
                iconRenderer.setAlignment(8, 5);
                arrayList2.add(separatingLineController);
            }
            arrayList.add(abstractWidgetController2);
            abstractWidgetController = abstractWidgetController2;
            iGrid = iGrid2;
        }
        return new GridMenuChanger$MenuChildrenData(arrayList, arrayList2);
    }

    private void redrawScreen(MenuController menuController, IGridList iGridList, GridMenuChanger$MenuChildrenData gridMenuChanger$MenuChildrenData, ListController listController, GridListRow[] gridListRowArray, Object object) {
        int n;
        Object object2;
        Object object3;
        Object object4;
        if (listController == null) {
            menuController.setVisible(false);
            if (menuController.isConnected() && object != null) {
                this.setCurrentMenuFocus(menuController, null, null);
            }
            menuController.prepareForRemove();
        }
        MenuModel menuModel = (MenuModel)menuController.getModel();
        if (listController == null) {
            IRangeCounter iRangeCounter = iGridList.getRangeCounter();
            object4 = gridMenuChanger$MenuChildrenData.separatingLinesAdded;
            object3 = menuController.getChildren();
            for (int i2 = object3.size() - 1; i2 >= 0; --i2) {
                boolean bl;
                object2 = (AbstractWidget)object3.get(i2);
                n = object2 instanceof SeparatingLineController;
                boolean bl2 = object2 instanceof MenuItemController;
                boolean bl3 = object2 instanceof ListController;
                if (!bl2 && !bl3 && n == 0) continue;
                int n2 = object2 instanceof IMenuItem ? ((IMenuItem)object2).getWidgetID() : -1;
                boolean bl4 = bl = n != 0 && !object4.contains(object2);
                if (!iRangeCounter.isInsideRangeBoundary(n2) && !bl) continue;
                menuController.remove((AbstractWidget)object2);
                if (!(object2 instanceof ListController)) continue;
                ListController listController2 = (ListController)object2;
                AbstractModel abstractModel = (AbstractModel)listController2.getModel();
                menuModel.unregisterMenuItem(abstractModel.getID());
            }
        }
        this.timer.takeMeasurement("remove-old-menu-items");
        int n3 = iGridList.getIdRangeStart();
        if (iGridList.getViewType() == 2) {
            if (listController == null) {
                object4 = new InfiniteListModelAccess(this.menuChangeController.getMainScrollbar1(), this.menuChangeController.getMainScrollbar2(), iGridList.size(), this.terminalId);
                object3 = this.createInfiniteListControllerModel(n3, object, (MenuModel)menuController.getModel(), gridListRowArray);
                ((GridListModel)object3).setModelAccess((IInfiniteListModelAccess)object4);
                ListController listController3 = this.createList(n3, (BaseListModel)object3, (IListWidgetDataAccess)object4);
                listController3.setCacheWidgetsPerRecordSet(false);
                object2 = iGridList.getCurrentCursor().getSelection();
                int n4 = n = iGridList.isSelectionEnabled() ? object2.getIndex() : -1;
                if (n == -1) {
                    ((BaseListModel)object3).setSelectedIndex(-1);
                } else {
                    ((BaseListModel)object3).setSelectedUniqueID(iGridList.calculateUniqueId(n, 0));
                }
                menuController.add(listController3);
            } else {
                object4 = (InfiniteListModelAccess)listController.getDataAccess();
                this.mergeOldAndNewListRows(listController, gridListRowArray);
            }
            object4.updateInfiniteListData(iGridList.getInfiniteListData(), gridListRowArray);
        } else {
            int n5 = menuController.getChildrenSize();
            object3 = gridMenuChanger$MenuChildrenData.menuItemList.listIterator();
            while (object3.hasNext()) {
                AbstractWidget abstractWidget = (AbstractWidget)object3.next();
                menuController.addWithPosition(abstractWidget, n5 + object3.previousIndex());
            }
        }
        this.timer.takeMeasurement("add-menu-items");
        if (listController == null) {
            menuController.setVisible(true);
        }
    }

    private void mergeOldAndNewListRows(ListController listController, GridListRow[] gridListRowArray) {
        List list;
        int n;
        if (gridListRowArray == null || gridListRowArray.length == 0) {
            log.log(10000, "GridMenuChanger#mergeOldAndNewListRows: new list has no entries which is not allowed. Update cancelled!");
            return;
        }
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n2 = n = gridListModel == null ? 0 : gridListModel.getLength();
        if (n == 0) {
            log.log(10000, "GridMenuChanger#mergeOldAndNewListRows: current list has no entries which is not allowed. Update cancelled!");
            return;
        }
        Map map = GridMenuChanger.analyseIds(gridListModel, gridListRowArray);
        if (map.isEmpty()) {
            log.log(1078071040, "GridMenuChanger#mergeOldAndNewListRows: Matching by index");
            list = GridMenuChanger.matchByIndex(listController, gridListRowArray);
        } else {
            log.log(1078071040, "GridMenuChanger#mergeOldAndNewListRows: Matching by ID");
            list = GridMenuChanger.matchById(listController, gridListRowArray, map);
        }
        GridMenuChanger.flattenInfiniteList(gridListModel);
        if (list.size() != 0) {
            IInfiniteListModelAccess iInfiniteListModelAccess = (IInfiniteListModelAccess)listController.getDataAccess();
            iInfiniteListModelAccess.insertRowsAfter(-1, list);
        }
    }

    private ListController createListAndFill(IGrid iGrid, Object object, int n, boolean bl, int n2, boolean bl2, int n3, MenuModel menuModel) {
        GridListModel gridListModel = new GridListModel(n, menuModel);
        gridListModel.setListener((BaseListModelListener)object);
        ListController listController = this.createList(n, gridListModel, new BaseListModelAccess());
        GridListRow gridListRow = new GridListRow(-1L);
        int n4 = this.calculateLayout(iGrid, bl2 && n3 == -1);
        gridListRow.setGridAndLayout(iGrid, n4);
        gridListModel.append(gridListRow);
        if (iGrid.isExpanded()) {
            EvoListRow[] evoListRowArray = this.createGridListRows(iGrid.getExpandedList(), 0, bl2 ? n3 : -1);
            gridListModel.setLength(evoListRowArray.length + 1);
            gridListModel.setRows(-1, 1, evoListRowArray);
        }
        if (bl) {
            if (n2 == -1) {
                gridListModel.setSelectedIndex(-1);
            } else {
                gridListModel.setSelectedUniqueID(n2);
            }
        }
        return listController;
    }

    private int calculateLayout(IGrid iGrid, boolean bl) {
        if (iGrid.isArtificial()) {
            return 3;
        }
        if (iGrid.getDetail() == null) {
            return 0;
        }
        if (iGrid.getExpandedList() != null) {
            return iGrid.isExpanded() ? 2 : 0;
        }
        return bl ? 2 : 0;
    }

    private GridListRow[] createGridListRows(IGridList iGridList, int n, int n2) {
        int n3 = iGridList.size();
        ArrayList arrayList = new ArrayList(n3);
        GridListRow[] gridListRowArray = iGridList.listIterator();
        while (gridListRowArray.hasNext()) {
            IGrid iGrid = (IGrid)gridListRowArray.next();
            if (!iGrid.isVisible()) continue;
            int n4 = gridListRowArray.previousIndex();
            int n5 = iGridList.calculateUniqueId(n4, n);
            GridListRow gridListRow = new GridListRow(n5);
            int n6 = this.calculateLayout(iGrid, n2 == n4);
            gridListRow.setGridAndLayout(iGrid, n6);
            arrayList.add(gridListRow);
        }
        gridListRowArray = (GridListRow[])arrayList.toArray(new GridListRow[arrayList.size()]);
        return gridListRowArray;
    }

    private MenuItemController createMenuItemWithLayouts(IGrid iGrid, Object object, SpellerListener spellerListener, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        MenuItemController menuItemController = this.createMenuItem(n);
        ChoiceModel choiceModel = new ChoiceModel(n);
        choiceModel.setChoiceListener((ChoiceListener)object);
        choiceModel.setValue(bl2 ? n : -1);
        menuItemController.setModel(choiceModel);
        menuItemController.setKeyHandler(0);
        menuItemController.setAutoConfigureChaining(false);
        menuItemController.setFocusable(iGrid.isFocusable());
        int n2 = iGrid.isLineNumberSpeakable() ? 2 : 0;
        menuItemController.setSdsItemSelectedAction(n2);
        menuItemController.setScrollType(2);
        menuItemController.setScrollLineHeight(50);
        LayoutManager[] layoutManagerArray = this.createAllLayouts(menuItemController, iGrid, n, bl, object, spellerListener, bl4);
        menuItemController.setLayoutChoices(layoutManagerArray);
        int n3 = this.calculateLayout(iGrid, bl3);
        menuItemController.selectLayoutManager(n3);
        String string = GridWidgetFactory.calculateInfoText(iGrid, n3);
        menuItemController.setInfolineTextDisabled(string);
        menuItemController.setInfolineTextEnabled(string);
        menuItemController.setEnabled(iGrid.isEnabled());
        log.log(-2137614336, "GridListItemFactory#createMenuItemWithLayouts: menuitem: %1, enabled: %2, grid enalbed: %3", (Object)iGrid.getId(), (Object)Boolean.toString(menuItemController.isEnabled()), (Object)Boolean.toString(iGrid.isEnabled()));
        return menuItemController;
    }

    private LayoutManager[] createAllLayouts(MenuItemController menuItemController, IGrid iGrid, int n, boolean bl, Object object, SpellerListener spellerListener, boolean bl2) {
        GridLayout gridLayout;
        LayoutManager[] layoutManagerArray;
        IGrid iGrid2 = bl ? iGrid.getCloneForMediaList() : iGrid;
        GridLayout gridLayout2 = this.createLayoutWithWidgets(iGrid2, object, menuItemController, n, spellerListener, bl2);
        LayoutManager[] layoutManagerArray2 = iGrid.getDetail();
        if (layoutManagerArray2 != null) {
            layoutManagerArray = bl ? layoutManagerArray2.getCloneForMediaList() : layoutManagerArray2;
            gridLayout = this.createLayoutWithWidgets((IGrid)layoutManagerArray, object, menuItemController, n, spellerListener, bl2);
        } else {
            gridLayout = gridLayout2;
        }
        layoutManagerArray = new LayoutManager[4];
        layoutManagerArray[0] = gridLayout2;
        layoutManagerArray[2] = gridLayout;
        return layoutManagerArray;
    }

    private GridListModel createInfiniteListControllerModel(int n, Object object, MenuModel menuModel, GridListRow[] gridListRowArray) {
        GridListModel gridListModel = new GridListModel(n, menuModel);
        gridListModel.setListener((BaseListModelListener)object);
        int n2 = gridListRowArray.length;
        if (n2 > 0) {
            gridListModel.setLength(n2);
            gridListModel.setRows(128, 0, gridListRowArray);
        }
        return gridListModel;
    }

    private void updateValuesOnly(IGridList iGridList, MenuController menuController, MenuController menuController2) {
        Object object;
        if (this.lockController != null) {
            this.lockController.clearMenuImages();
        }
        if (menuController2 != null && (object = iGridList.getHeader()) != null) {
            this.updateValuesOnly((IGridList)object, menuController2, null);
        }
        object = iGridList.getCurrentCursor().getFocus();
        int n = object.getIndex();
        int n2 = object.getSubindex();
        List list = menuController.getChildren();
        int n3 = iGridList.getViewType();
        boolean bl = n3 == 1;
        boolean bl2 = n3 == 2;
        int n4 = bl2 ? iGridList.getInfiniteListData().getStartIndex() : -1;
        int n5 = iGridList.getIdRangeStart();
        int n6 = list.size();
        for (int i2 = 0; i2 < n6; ++i2) {
            AbstractWidgetController abstractWidgetController;
            IGrid iGrid;
            int n7;
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!(abstractWidget instanceof IMenuItem)) continue;
            IMenuItem iMenuItem = (IMenuItem)((Object)abstractWidget);
            boolean bl3 = iMenuItem instanceof MenuItemController;
            boolean bl4 = iMenuItem instanceof ListController;
            if (!bl3 && !bl4) continue;
            int n8 = iMenuItem.getWidgetID();
            if (bl2) {
                if (n8 != n5) {
                    log.log(1078071040, "GridMenuChanger#updateValuesOnly: menu child with id=%1 is not an infinite list controller", (long)n8);
                    continue;
                }
                n7 = -1;
                iGrid = null;
            } else {
                n7 = iGridList.getIndexFromId(n8);
                if (n7 == -1) {
                    log.log(1078071040, "GridMenuChanger#updateValuesOnly: menu child with id=%1 is not a grid list element", (long)n8);
                    continue;
                }
                iGrid = (IGrid)iGridList.get(n7);
            }
            if (bl3) {
                Object object2;
                abstractWidgetController = (MenuItemController)iMenuItem;
                LayoutManager[] layoutManagerArray = ((MultiLayoutContainerController)abstractWidgetController).getLayoutChoices();
                GridLayout gridLayout = (GridLayout)layoutManagerArray[0];
                IGrid iGrid2 = bl ? iGrid.getCloneForMediaList() : iGrid;
                this.updateModelValuesForMenuItem(gridLayout.getCells(), iGrid2);
                IGrid iGrid3 = iGrid.getDetail();
                if (iGrid3 != null) {
                    object2 = bl ? iGrid3.getCloneForMediaList() : iGrid3;
                    GridLayout gridLayout2 = (GridLayout)layoutManagerArray[2];
                    this.updateModelValuesForMenuItem(gridLayout2.getCells(), (IGrid)object2);
                }
                object2 = iGrid.getInfoText();
                ((MenuItemController)abstractWidgetController).setInfolineTextEnabled((String)object2);
                ((MenuItemController)abstractWidgetController).setInfolineTextDisabled((String)object2);
                continue;
            }
            abstractWidgetController = (ListController)iMenuItem;
            if (bl2) {
                this.updateModelValuesForList((ListController)abstractWidgetController, null, iGridList, bl2, true, n + n4);
                continue;
            }
            boolean bl5 = n == n7;
            this.updateModelValuesForList((ListController)abstractWidgetController, iGrid, iGrid.getExpandedList(), bl2, bl5, n2);
        }
    }

    private void updateModelValuesForMenuItem(Object[] objectArray, IGrid iGrid) {
        int n = objectArray.length;
        int n2 = iGrid.getRenderedCellCount();
        if (n != n2) {
            log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: menu controller has different number of children (=%1) than the corresponding grid (=%2).", (long)n, (long)n2);
            log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: current grid=%1", (Object)iGrid);
            log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: widgetChildren=%1", (Object)objectArray);
            return;
        }
        int n3 = 0;
        int n4 = n;
        for (int i2 = 0; i2 < n4; ++i2) {
            Object object;
            IGridCell iGridCell;
            Object object2 = objectArray[i2];
            while (!(iGridCell = (IGridCell)iGrid.get(n3++)).isRendered()) {
            }
            if (object2 instanceof GridLayout) {
                if (iGridCell.getType() != 12) {
                    log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: current cell is a subgrid, but matching widget is not a GridLayout. Cell index=%1, widget=%2, cell=%3", (Object)new Integer(i2), object2, (Object)iGridCell);
                    log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: current grid=%1", (Object)iGrid);
                    log.log(10000, "GridMenuChanger#updateModelValuesForMenuItem: widgetChildren=%1", (Object)objectArray);
                    continue;
                }
                object = iGridCell.getGridValue();
                GridLayout gridLayout = (GridLayout)object2;
                this.updateModelValuesForMenuItem(gridLayout.getCells(), (IGrid)object);
                continue;
            }
            object = this.updateModelValueForWidget((AbstractWidgetController)object2, iGridCell);
            if (object == null) continue;
            ((AbstractWidget)object).processModelUpdateEvent(new ModelUpdateEvent(null, 10301, 0, 0, 1, 0, 0));
        }
    }

    private AbstractWidgetController updateModelValueForWidget(AbstractWidgetController abstractWidgetController, IGridCell iGridCell) {
        int n = iGridCell.getType();
        String string = iGridCell.getStringValue();
        int n2 = iGridCell.getIntValue();
        if (abstractWidgetController instanceof LabelController) {
            boolean bl;
            LabelController labelController = (LabelController)abstractWidgetController;
            if (n != 0 && n != 10) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a LabelController, but matching cell is not a text.");
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            Object object = labelController.getModel();
            if (!(object instanceof TextListCell)) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: LabelController model is not an instance of TextListCell. Model=%1", object);
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            if (labelController.isEnabled() != iGridCell.isEnabled()) {
                bl = true;
                labelController.setEnabled(iGridCell.isEnabled());
            } else {
                bl = false;
            }
            TextListCell textListCell = (TextListCell)object;
            if (!StringUtilities.equals(textListCell.getText(), string)) {
                bl = true;
                labelController.setModel(TextListCell.create(string));
            }
            return bl ? abstractWidgetController : null;
        }
        if (abstractWidgetController instanceof IconController) {
            IconController iconController = (IconController)abstractWidgetController;
            if (n == 11) {
                if (iconController.getModelValue() == n2) {
                    return null;
                }
                iconController.setModel(IntegerListCell.create(n2));
                return abstractWidgetController;
            }
            if (n == 1) {
                return null;
            }
            if (n == 13 || n == 7 || n == 16) {
                return null;
            }
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is an IconController, but matching cell is not an image.");
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
            return null;
        }
        if (abstractWidgetController instanceof WaitAnimController) {
            if (n == 8) {
                return null;
            }
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is an WaitAnimController, but matching cell is not an updating icon.");
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
            return null;
        }
        if (abstractWidgetController instanceof LayoutContainerController) {
            LayoutContainerController layoutContainerController = (LayoutContainerController)abstractWidgetController;
            if (n == 1) {
                int n3 = layoutContainerController.getChildrenSize();
                if (n3 != 1) {
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a LayoutContainerController that must contain exactly 1 IconController, but it contains %1 children.", (long)n3);
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                    return null;
                }
                AbstractWidget abstractWidget = layoutContainerController.getChild(0);
                if (!(abstractWidget instanceof IconController)) {
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a LayoutContainerController containing exactly 1 IconController, but it contains a %1", (Object)abstractWidget);
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                    return null;
                }
                IconController iconController = (IconController)abstractWidget;
                Object object = iconController.getModel();
                if (!(object instanceof ResourceLocatorModel)) {
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is an IconController inside a LayoutContainerController, but its model is not a ResourceLocatorModel, but a %1", object);
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                    return null;
                }
                ResourceLocatorModel resourceLocatorModel = (ResourceLocatorModel)object;
                HMIResourceLocator hMIResourceLocator = resourceLocatorModel.getResourceLocator();
                if (hMIResourceLocator == null) {
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is an IconController inside a LayoutContainerController, but its model.getResourceLocator() returned null.");
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                    return null;
                }
                if (StringUtilities.equals(hMIResourceLocator.getResourceURI(), string)) {
                    return null;
                }
                resourceLocatorModel.setResourceLocatorWithoutEvent(-1, string);
                if (iGridCell.isBlocking() && this.lockController != null) {
                    this.lockController.addLockImage(iconController);
                }
                return iconController;
            }
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a LayoutContainerController that contains an image controller, but matching cell is not an image.");
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
            return null;
        }
        if (abstractWidgetController instanceof ProgressBarController) {
            ProgressBarController progressBarController = (ProgressBarController)abstractWidgetController;
            if (n == 2) {
                Object object = progressBarController.getModel();
                if (!(object instanceof RangeModel)) {
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a ProgressBarController that must have a RangeModel, but it has a %1", object);
                    log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                    return null;
                }
                RangeModel rangeModel = (RangeModel)object;
                if (rangeModel.getValue() == n2) {
                    return null;
                }
                rangeModel.setValue(n2);
                return progressBarController;
            }
            throw new IllegalArgumentException("GridMenuChanger#checkStructureAndUpdateModelValues: ProgressBarController type mismatch. Widget has different children than the corresponding grid");
        }
        if (abstractWidgetController instanceof ComboBoxController) {
            boolean bl;
            Object object;
            Object object2;
            int n4;
            ComboBoxController comboBoxController = (ComboBoxController)abstractWidgetController;
            if (n != 4) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a ComboBoxController, but matching cell is not a drop down list.");
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            IGridList iGridList = iGridCell.getListValue();
            int n5 = iGridList.getCurrentCursor().getSelection().getIndex();
            if (n5 == -1) {
                n4 = 0;
            } else {
                object2 = (IGrid)iGridList.get(n5);
                n4 = object2.getDisplayedRow();
            }
            object2 = comboBoxController.getModel();
            if (!(object2 instanceof ChoiceModel)) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: ComboBoxController model is not an instance of ChoiceModel. Model=%1", object2);
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            LabelController[] labelControllerArray = comboBoxController.getLabelControllers();
            IGridList iGridList2 = iGridCell.getListValue();
            int n6 = 0;
            Object object3 = iGridList2.iterator();
            while (object3.hasNext()) {
                IGrid iGrid = (IGrid)object3.next();
                if (iGrid == null || iGrid.size() == 0 || !iGrid.isVisible() || (object = (IGridCell)iGrid.get(0)) == null || object.getType() != 0) continue;
                AbstractWidgetController abstractWidgetController2 = this.updateModelValueForWidget(labelControllerArray[n6], (IGridCell)object);
                if (abstractWidgetController2 != null) {
                    abstractWidgetController2.processModelUpdateEvent(new ModelUpdateEvent(null, 10301, 0, 0, 1, 0, 0));
                }
                ++n6;
            }
            object3 = comboBoxController.getLabel();
            if (((AbstractWidget)object3).isEnabled() != iGridCell.isEnabled()) {
                bl = true;
                ((LabelController)object3).setEnabled(iGridCell.isEnabled());
            } else {
                bl = false;
            }
            object = (ChoiceModel)object2;
            if (((ChoiceModel)object).getValue() != n4) {
                ((ChoiceModel)object).setValue(n4);
                bl = true;
            }
            return bl ? comboBoxController : null;
        }
        if (abstractWidgetController instanceof CheckboxController) {
            int n7;
            CheckboxController checkboxController = (CheckboxController)abstractWidgetController;
            if (n != 5) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a CheckboxController, but matching cell is not a checkbox.");
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            Object object = checkboxController.getModel();
            if (!(object instanceof ChoiceModel)) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: CheckboxController model is not an instance of ChoiceModel. Model=%1", object);
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            ChoiceModel choiceModel = (ChoiceModel)object;
            if (iGridCell.isEnabled()) {
                n7 = iGridCell.getBooleanValue() ? 1 : 0;
            } else {
                int n8 = n7 = iGridCell.getBooleanValue() ? 128 : 0;
            }
            if (choiceModel.getValue() == n7) {
                return null;
            }
            choiceModel.setValue(n7);
            return checkboxController;
        }
        if (abstractWidgetController instanceof RadioButtonController) {
            int n9;
            RadioButtonController radioButtonController = (RadioButtonController)abstractWidgetController;
            if (n != 6) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a RadioButtonController, but matching cell is not a radio button.");
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            Object object = radioButtonController.getModel();
            if (!(object instanceof ChoiceModel)) {
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: CheckboxController model is not an instance of ChoiceModel. Model=%1", object);
                log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
                return null;
            }
            ChoiceModel choiceModel = (ChoiceModel)object;
            int n10 = n9 = iGridCell.getBooleanValue() ? 1 : 0;
            if (choiceModel.getValue() == n9) {
                return null;
            }
            choiceModel.setValue(n9);
            return radioButtonController;
        }
        if (abstractWidgetController instanceof FormfieldInputController) {
            if (n == 13) {
                return null;
            }
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: current widget is a FormfieldInputController, but matching cell is not a form field background.");
            log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
            return null;
        }
        log.log(10000, "GridMenuChanger#checkStructureAndUpdateModelValues: widget class %1 is unknown. Expected a class matching cell type=%2", (Object)abstractWidgetController.getClassName(), IGridCell.typeDescription.get(n));
        log.log(10000, "GridMenuChanger#updateModelValueForWidget: Widget=%1, cell=%2", (Object)abstractWidgetController, (Object)iGridCell);
        return null;
    }

    private void updateGridStructureAndValues(IGridList iGridList, MenuController menuController, MenuController menuController2, Object object) {
        Object object2;
        if (this.lockController != null) {
            this.lockController.clearMenuImages();
        }
        if (menuController2 != null && (object2 = iGridList.getHeader()) != null) {
            this.updateGridStructureAndValues((IGridList)object2, menuController2, null, object);
        }
        SpellerListener spellerListener = (object2 = iGridList.getSpeller()) == null ? null : (SpellerListener)object2.getSpellerListener();
        ICursorComponent iCursorComponent = iGridList.getCurrentCursor().getFocus();
        int n = iCursorComponent.getIndex();
        int n2 = iCursorComponent.getSubindex();
        List list = menuController.getChildren();
        int n3 = iGridList.getViewType();
        boolean bl = n3 == 1;
        boolean bl2 = n3 == 2;
        int n4 = bl2 ? iGridList.getInfiniteListData().getStartIndex() : -1;
        int n5 = iGridList.getIdRangeStart();
        log.log(1078071040, "GridMenuChanger#updateGridStructureAndValues: starting to update elements. isMediaType=%1, isInfiniteList=%2, idRangeStart=%3", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Integer.toString(n5));
        int n6 = list.size();
        for (int i2 = 0; i2 < n6; ++i2) {
            AbstractWidgetController abstractWidgetController;
            IGrid iGrid;
            int n7;
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!(abstractWidget instanceof IMenuItem)) continue;
            IMenuItem iMenuItem = (IMenuItem)((Object)abstractWidget);
            boolean bl3 = iMenuItem instanceof MenuItemController;
            boolean bl4 = iMenuItem instanceof ListController;
            if (!bl3 && !bl4) {
                log.log(-2137614336, "GridMenuChanger#updateGridStructureAndValues: menu child=%1 is not an updatable element", (Object)super.getClass());
                continue;
            }
            int n8 = iMenuItem.getWidgetID();
            if (bl2) {
                if (n8 != n5) {
                    log.log(1078071040, "GridMenuChanger#updateGridStructureAndValues: menu child with id=%1 is not an infinite list controller", (long)n8);
                    continue;
                }
                n7 = -1;
                iGrid = null;
            } else {
                n7 = iGridList.getIndexFromId(n8);
                if (n7 == -1) {
                    log.log(1078071040, "GridMenuChanger#updateGridStructureAndValues: menu child with id=%1 is not a grid list element", (long)n8);
                    continue;
                }
                iGrid = (IGrid)iGridList.get(n7);
            }
            boolean bl5 = n == n7;
            log.log(-2137614336, "GridMenuChanger#updateGridStructureAndValues: updating menu child with id=%1. isMenuItemController=%2", (Object)Integer.toString(n8), (Object)Boolean.toString(bl3));
            if (bl3) {
                abstractWidgetController = (MenuItemController)iMenuItem;
                this.deleteAllWidgets((MenuItemController)abstractWidgetController);
                LayoutManager[] layoutManagerArray = this.createAllLayouts((MenuItemController)abstractWidgetController, iGrid, n8, bl, object, spellerListener, true);
                ((MenuItemController)abstractWidgetController).setLayoutChoices(layoutManagerArray);
                int n9 = this.calculateLayout(iGrid, bl5);
                ((MultiLayoutContainerController)abstractWidgetController).selectLayoutManager(n9);
                continue;
            }
            abstractWidgetController = (ListController)iMenuItem;
            if (bl2) {
                this.updateGridForList((ListController)abstractWidgetController, null, iGridList, bl2, true, n + n4);
                continue;
            }
            this.updateGridForList((ListController)abstractWidgetController, iGrid, iGrid.getExpandedList(), bl2, bl5, n2);
        }
        log.log(1078071040, "GridMenuChanger#updateGridStructureAndValues: updating elements finished.");
    }

    private void updateModelValuesForList(ListController listController, IGrid iGrid, IGridList iGridList, boolean bl, boolean bl2, int n) {
        this.updateGridForList(listController, iGrid, iGridList, bl, bl2, n);
    }

    private void updateGridForList(ListController listController, IGrid iGrid, IGridList iGridList, boolean bl, boolean bl2, int n) {
        if (bl) {
            this.updateGridForInfiniteList(listController, iGridList, n);
            return;
        }
        this.updateGridForExpandedList(listController, iGrid, iGridList, bl2, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateGridForExpandedList(ListController listController, IGrid iGrid, IGridList iGridList, boolean bl, int n) {
        log.log(-2137614336, "GridMenuChanger#updateGridForExpandedList: called");
        boolean bl2 = false;
        int n2 = 0;
        int n3 = iGridList.size();
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n4 = gridListModel.getLength();
        for (int i2 = 0; i2 < n4; ++i2) {
            IGrid iGrid2;
            GridListRow gridListRow = (GridListRow)gridListModel.getRow(i2);
            if (!bl2 && iGrid != null && iGrid.isVisible()) {
                iGrid2 = iGrid;
                bl2 = true;
            } else {
                do {
                    if (n2 >= n3) {
                        return;
                    }
                    iGrid2 = (IGrid)iGridList.get(n2);
                    ++n2;
                } while (iGrid2 != null && !iGrid2.isVisible());
            }
            log.log(1078071040, "GridMenuChanger#updateGridForExpandedList: rendering grid %1", iGrid2.getLogObject(1));
            long l = gridListRow.getUniqueID();
            int n5 = this.calculateLayout(iGrid2, bl && (long)n == l);
            gridListRow.setGridAndLayout(iGrid2, n5);
            gridListModel.setRowWithoutEvent(i2, gridListRow);
            try {
                listController.setRecordSetCacheIgnored(true);
                WidgetUtilities.notifyChangedRowsImmediately(i2, 1, listController, this.terminalId);
                continue;
            }
            finally {
                listController.setRecordSetCacheIgnored(false);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateGridForInfiniteList(ListController listController, IGridList iGridList, int n) {
        log.log(-2137614336, "GridMenuChanger#updateGridForInfiniteList: called");
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n2 = gridListModel.getLength();
        if (n2 == 0) {
            log.log(-1601830656, "GridMenuChanger#updateGridForInfiniteList: current list contains no elements!");
            return;
        }
        int n3 = listController.getWidgetID();
        IInfiniteListModelAccess iInfiniteListModelAccess = (IInfiniteListModelAccess)listController.getDataAccess();
        long l = iInfiniteListModelAccess.getFirstVisibleRowId() % (long)n3;
        long l2 = iInfiniteListModelAccess.getLastVisibleRowId() % (long)n3;
        boolean bl = iInfiniteListModelAccess.isVisibleAreaOverlappingForbiddenArea();
        int n4 = iGridList.getInfiniteListData().getStartIndex();
        int n5 = iGridList.size();
        GridListModel$RowSubrowIterator gridListModel$RowSubrowIterator = gridListModel.rowSubrowIterator();
        while (gridListModel$RowSubrowIterator.hasNext()) {
            boolean bl2;
            GridListRow gridListRow = (GridListRow)gridListModel$RowSubrowIterator.next();
            RowInfo rowInfo = gridListModel$RowSubrowIterator.previousRowInfo();
            int n6 = gridListModel.getAbsoluteIndexOfRow(gridListRow);
            int n7 = n6 - n4;
            if (n7 < 0 || n7 > n5) continue;
            IGrid iGrid = (IGrid)iGridList.get(n7);
            Object object = iGrid.getLogObject(1);
            if (rowInfo.getSubindex() != -1) {
                log.log(1078071040, "GridMenuChanger#updateGridForInfiniteList: updating subgrid %1", object);
                gridListRow.setGridAndLayout(iGrid, 0);
                continue;
            }
            boolean bl3 = bl2 = (long)n6 >= l && (long)n6 <= l2;
            if (bl && bl2 && !iGrid.isUpdatePreservesHeight()) {
                log.log(1078071040, "GridMenuChanger#updateGridForInfiniteList: skipping grid %1", object);
                continue;
            }
            log.log(1078071040, "GridMenuChanger#updateGridForInfiniteList: rendering grid %1", object);
            int n8 = this.calculateLayout(iGrid, n == n6);
            gridListRow.setGridAndLayout(iGrid, n8);
            int n9 = rowInfo.getIndex();
            gridListModel.setRowWithoutEvent(n9, gridListRow);
            try {
                listController.setRecordSetCacheIgnored(true);
                WidgetUtilities.notifyChangedRowsImmediately(n9, 1, listController, this.terminalId);
            }
            finally {
                listController.setRecordSetCacheIgnored(false);
            }
        }
        iInfiniteListModelAccess.changeAllRowsToArtificialOrOriginal();
    }

    private static List matchByIndex(ListController listController, GridListRow[] gridListRowArray) {
        int n;
        int n2 = gridListRowArray.length;
        ArrayList arrayList = new ArrayList(n2);
        GridListModel gridListModel = (GridListModel)listController.getModel();
        int n3 = n = gridListModel == null ? 0 : gridListModel.getLength();
        if (n == 0) {
            log.log(10000, "GridMenuChanger#matchByIndex: current list has no entries which is not allowed. Matching cancelled!");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(n);
        GridListModel$RowSubrowIterator gridListModel$RowSubrowIterator = gridListModel.rowSubrowIterator();
        while (gridListModel$RowSubrowIterator.hasNext()) {
            GridListRow gridListRow = (GridListRow)gridListModel$RowSubrowIterator.next();
            if (gridListRow.isDeletableIfOffscreen()) continue;
            arrayList2.add(gridListRow);
            gridListRow.setDeletableIfOffscreen(true);
        }
        int n4 = 0;
        int n5 = 0;
        GridListRow gridListRow = null;
        int n6 = arrayList2.size();
        int n7 = gridListRowArray.length;
        int n8 = listController.getWidgetID();
        while (n5 < n7) {
            GridListRow gridListRow2;
            long l;
            long l2;
            GridListRow gridListRow3;
            if (n4 < n6) {
                gridListRow3 = (GridListRow)arrayList2.get(n4);
                l2 = gridListRow3.getUniqueID() % (long)n8;
            } else {
                gridListRow3 = null;
                l2 = Long.MAX_VALUE;
            }
            while (n5 < n7 && (l = (gridListRow2 = gridListRowArray[n5]).getUniqueID() % (long)n8) < l2) {
                if (gridListRow == null) {
                    arrayList.add(gridListRow2);
                } else {
                    List list = gridListRow.getRowsToInsertIfOffscreen();
                    long l3 = gridListRow.getUniqueID() % (long)n8;
                    if (l == l3) {
                        list.add(0, gridListRow2);
                    } else {
                        list.add(gridListRow2);
                    }
                }
                ++n5;
            }
            if (l2 == Long.MAX_VALUE) continue;
            ++n4;
            gridListRow = gridListRow3;
        }
        return arrayList;
    }

    private static Map analyseIds(GridListModel gridListModel, GridListRow[] gridListRowArray) {
        Object object;
        int n;
        int n2;
        int n3 = n2 = gridListModel == null ? 0 : gridListModel.getLength();
        if (n2 == 0) {
            log.log(-1601830656, "GridMenuChanger#analyseIds: current list has no entries which is not allowed. Matching by ID cancelled!");
            return Collections.EMPTY_MAP;
        }
        int n4 = n = gridListRowArray == null ? 0 : gridListRowArray.length;
        if (n == 0) {
            log.log(-1601830656, "GridMenuChanger#analyseIds: new list has no entries which is not allowed. Matching by ID cancelled!");
            return Collections.EMPTY_MAP;
        }
        HashMap hashMap = new HashMap(n2);
        Object object2 = gridListModel.rowSubrowIterator();
        while (((GridListModel$RowSubrowIterator)object2).hasNext()) {
            object = (GridListRow)((GridListModel$RowSubrowIterator)object2).next();
            if (((GridListRow)object).isDeletableIfOffscreen()) continue;
            String string = ((GridListRow)object).getGridId();
            if (string.length() == 0) {
                return Collections.EMPTY_MAP;
            }
            if (hashMap.containsKey(string)) {
                log.log(-1601830656, "GridMenuChanger#analyseIds: current list has duplicated IDs. id='%1', row=%2. Matching by ID cancelled!", (Object)string, object);
                return Collections.EMPTY_MAP;
            }
            hashMap.put(string, ((GridListModel$RowSubrowIterator)object2).previousRowInfo());
        }
        object2 = new HashSet(n);
        object = null;
        for (int i2 = 0; i2 < n; ++i2) {
            GridListRow gridListRow = gridListRowArray[i2];
            String string = gridListRow.getGridId();
            if (string.length() == 0) {
                return Collections.EMPTY_MAP;
            }
            boolean bl = ((HashSet)object2).add(string);
            if (!bl) {
                log.log(-1601830656, "GridMenuChanger#analyseIds: new list has duplicated IDs. id='%1', index=%2. Matching by ID cancelled!", (Object)string, (long)i2);
                return Collections.EMPTY_MAP;
            }
            RowInfo rowInfo = (RowInfo)hashMap.get(string);
            if (rowInfo == null) continue;
            if (object != null && rowInfo.isBefore((RowInfo)object)) {
                log.log(-1601830656, "GridMenuChanger#analyseIds: current list has switched ID positions. id='%1', index=%2. Matching by ID cancelled!", (Object)string, (long)i2);
                return Collections.EMPTY_MAP;
            }
            object = rowInfo;
        }
        if (object == null) {
            log.log(-1601830656, "GridMenuChanger#analyseIds: no reference point found. Matching by ID cancelled!");
            return Collections.EMPTY_MAP;
        }
        return hashMap;
    }

    private static List matchById(ListController listController, GridListRow[] gridListRowArray, Map map) {
        Object object;
        GridListModel gridListModel = (GridListModel)listController.getModel();
        GridListModel$RowSubrowIterator gridListModel$RowSubrowIterator = gridListModel.rowSubrowIterator();
        while (gridListModel$RowSubrowIterator.hasNext()) {
            object = (GridListRow)gridListModel$RowSubrowIterator.next();
            ((GridListRow)object).setDeletableIfOffscreen(true);
        }
        int n = gridListRowArray.length;
        object = new ArrayList(n);
        RowInfo rowInfo = null;
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            GridListRow gridListRow = gridListRowArray[i2];
            String string = gridListRow.getGridId();
            RowInfo rowInfo2 = (RowInfo)map.get(string);
            if (rowInfo2 != null) {
                rowInfo = rowInfo2;
                n2 = 0;
            }
            if (rowInfo == null) {
                object.add(gridListRow);
                continue;
            }
            rowInfo.getRow().getRowsToInsertIfOffscreen().add(n2, gridListRow);
            ++n2;
        }
        return object;
    }

    private static void flattenInfiniteList(GridListModel gridListModel) {
        GridListModel$RowSubrowIterator gridListModel$RowSubrowIterator = gridListModel.rowSubrowIterator(gridListModel.getLastRowInfo());
        while (gridListModel$RowSubrowIterator.hasPrevious()) {
            Object object;
            int n;
            Object object2;
            GridListRow gridListRow = (GridListRow)gridListModel$RowSubrowIterator.previous();
            RowInfo rowInfo = gridListModel$RowSubrowIterator.nextRowInfo();
            int n2 = rowInfo.getSubindex();
            if (n2 == -1) continue;
            if (n2 < 0) {
                object2 = "GridMenuChanger#flattenInfiniteList: inconsistent list structure: illegal subindex=%1 in list size=%2 detected. rowInfo=%3. row=%4";
                log.log(10000, (String)object2, (Object)Util.createInteger(n2), (Object)Util.createInteger(gridListModel.getLength()), (Object)rowInfo, (Object)gridListRow);
                continue;
            }
            object2 = rowInfo.getParent().getRowsToInsertIfOffscreen();
            int n3 = n2 + 1;
            if (gridListRow.isDeletableIfOffscreen()) {
                object2.remove(n2);
                --n3;
            }
            if (n3 > (n = object2.size())) {
                object = "GridMenuChanger#flattenInfiniteList: inconsistent sublist structure: illegal insert position=%1 in sublist size=%2 detected. rowInfo=%3. row=%4";
                log.log(10000, (String)object, (Object)Util.createInteger(n3), (Object)Util.createInteger(n), (Object)rowInfo, (Object)gridListRow);
                n3 = n;
            }
            object = gridListRow.getRowsToInsertIfOffscreen();
            object2.addAll(n3, (Collection)object);
            object.clear();
        }
    }

    @Override
    public void setImageLockController(IGridImageLocker iGridImageLocker) {
        log.log(1078071040, "GridMenuChanger#setImageLockController locker is inited and set %1", (Object)iGridImageLocker);
        this.lockController = iGridImageLocker;
    }
}

