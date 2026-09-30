/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.view.HMIView;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.testsupport.hmi.evohighscale.TestSupportScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FocusCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScreenRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ScrollbarRendererKanziHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TitleBarRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.menu.MenuRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FocusCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarStubController;
import de.esolutions.hmi.widgets.audi.evo.widgets.TitleBarWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.BaseListModelAccess;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.InfoLineRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.ListController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

public class TestSupportScreenBag1 {
    public static Screen tsMain(TestSupportScreenFactory testSupportScreenFactory, int n) {
        GlassplateController glassplateController = new GlassplateController();
        GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
        glassplateController.setRenderer(glassplateRendererHigh);
        glassplateController.setBounds(0, 0, 100, 100);
        glassplateController.setSdsNumbersGapWidth(4);
        glassplateController.setSdsNumbersWidth(64);
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
        scrollbarController.setRenderer(scrollbarRendererKanziHigh);
        scrollbarController.setBounds(703, 11, 5, 302);
        FocusCursorController focusCursorController = new FocusCursorController();
        FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
        focusCursorController.setRenderer(focusCursorRendererHigh);
        focusCursorController.setBounds(0, 0, 100, 100);
        focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
        focusCursorController.setOptionsIconVisible(false);
        MenuItemController menuItemController = new MenuItemController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(menuItemController);
        menuItemController.setRenderer(compositeRendererHigh);
        menuItemController.setBitmaps(new int[]{39, 39, 39, 39});
        menuItemController.setEvent(2400000);
        menuItemController.setLabelId(2400011);
        menuItemController.setGlassplateInsetsBottom(6);
        menuItemController.setGlassplateInsetsTop(7);
        menuItemController.setInternalID(2400000);
        menuItemController.setType(4);
        MenuItemController menuItemController2 = new MenuItemController();
        CompositeRendererHigh compositeRendererHigh2 = new CompositeRendererHigh(menuItemController2);
        menuItemController2.setRenderer(compositeRendererHigh2);
        menuItemController2.setBitmaps(new int[]{39, 39, 39, 39});
        menuItemController2.setEvent(2400002);
        menuItemController2.setLabelId(2400019);
        menuItemController2.setGlassplateInsetsBottom(6);
        menuItemController2.setGlassplateInsetsTop(7);
        menuItemController2.setInternalID(2400027);
        menuItemController2.setType(4);
        MenuController menuController = new MenuController();
        MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
        menuController.setRenderer(menuRendererHigh);
        menuController.createInfolineWidgets(new InfoLineRendererHigh());
        menuController.getInfoline().getInfolineRenderer().setFonts(testSupportScreenFactory.getFonts(1, n));
        menuController.setDefaultDisabledInfolineTextId(2400023);
        menuController.getInfolineTimer().setIdleTime(800);
        menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
        menuController.getLayout().setBackgroundInsetsVert(7);
        menuController.getLayout().setContentLeftOffset(12);
        menuController.getLayout().setContentRightOffset(25);
        menuController.getLayout().setContentRightOffsetSmallStage(25);
        menuController.getLayout().setItemsGap(9);
        menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
        menuController.setBounds(62, 77, 716, 324);
        menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
        menuController.add(glassplateController, 4);
        menuController.add(scrollbarController, 3);
        menuController.add(focusCursorController, 1);
        menuController.add(menuItemController);
        menuController.add(menuItemController2);
        ContainerController containerController = new ContainerController();
        ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
        containerController.setRenderer(containerRendererHigh);
        containerController.setBounds(0, 0, 0, 0);
        containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
        containerController.setOpacitySet(1.0f, 0.4f);
        containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
        containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
        containerController.add(menuController);
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{127});
        iconController.setBounds(0, 0, 100, 100);
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(testSupportScreenFactory.getFonts(2, n));
        labelController.setTextIds(new int[]{2400012});
        labelController.setBounds(0, 0, 0, 30);
        labelController.setColorIndices(new int[]{1, 2, 4, 0});
        LabelController labelController2 = new LabelController();
        LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
        labelController2.setRenderer(labelRendererHigh2);
        labelController2.setBounds(0, 0, 0, 30);
        labelController2.setCoordinateSets(new int[]{1, 0, 0, 0, 30, 0, 0, 0, 30});
        TitleBarWidget titleBarWidget = new TitleBarWidget();
        TitleBarRendererHigh titleBarRendererHigh = new TitleBarRendererHigh(titleBarWidget);
        titleBarWidget.setRenderer(titleBarRendererHigh);
        titleBarWidget.setBitmaps(new int[]{58, 58});
        titleBarWidget.getTitleLayout().setGapInsideBreadcrumbs(15);
        titleBarWidget.getTitleLayout().setGapInsideTitles(15);
        titleBarWidget.setBounds(75, 28, 650, 22);
        titleBarWidget.setColorIndices(new int[]{1, 8, 4, 0});
        titleBarWidget.addLeftIcon(iconController);
        titleBarWidget.addTitle(labelController);
        titleBarWidget.addBreadcrumb(labelController2);
        ContainerController containerController2 = new ContainerController();
        ContainerRendererHigh containerRendererHigh2 = new ContainerRendererHigh(containerController2);
        containerController2.setRenderer(containerRendererHigh2);
        containerController2.setBounds(0, 0, 800, 0);
        containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
        containerController2.setOpacitySet(1.0f, 0.4f);
        containerController2.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.add(titleBarWidget);
        StatusBarStubController statusBarStubController = new StatusBarStubController();
        statusBarStubController.setModelID(138);
        statusBarStubController.setBounds(0, 0, 100, 100);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(2400000);
        screenWidgetEVO.setScreenFactory(testSupportScreenFactory);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenRendererHigh.setFonts(testSupportScreenFactory.getFonts(0, n));
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -16777216, -1, -1, -6645094, -5592406, -4868683, -6645094, -1}, {-1, -16777216, -65511, -5546136, -6645094, -5592406, -4868683, -6645094, -4703671}, {-1, -16777216, -19456, -6123155, -6645094, -5592406, -4868683, -6645094, -6123155}, {-1, -16777216, -14775126, -9594974, -6645094, -5592406, -4868683, -6645094, -9594974}, {-1, -16777216, -10180096, -9200779, -6645094, -5592406, -4868683, -6645094, -9200779}});
        screenWidgetEVO.setSmallStageType(3);
        screenWidgetEVO.add(containerController, 1);
        screenWidgetEVO.add(containerController2, 2);
        screenWidgetEVO.add(statusBarStubController);
        screenWidgetEVO.setViews(new int[]{138}, new HMIView[][]{{statusBarStubController}});
        return screenWidgetEVO;
    }

    public static Screen tsProviders(TestSupportScreenFactory testSupportScreenFactory, int n) {
        GlassplateController glassplateController = new GlassplateController();
        GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
        glassplateController.setRenderer(glassplateRendererHigh);
        glassplateController.setBounds(0, 0, 100, 100);
        glassplateController.setSdsNumbersGapWidth(4);
        glassplateController.setSdsNumbersWidth(64);
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
        scrollbarController.setRenderer(scrollbarRendererKanziHigh);
        scrollbarController.setBounds(703, 11, 5, 302);
        FocusCursorController focusCursorController = new FocusCursorController();
        FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
        focusCursorController.setRenderer(focusCursorRendererHigh);
        focusCursorController.setBounds(0, 0, 100, 100);
        focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
        focusCursorController.setOptionsIconVisible(false);
        ListController listController = new ListController();
        listController.setModelID(2400006);
        listController.setEvent(2400001);
        listController.setBounds(0, 0, 0, 0);
        listController.setGlassplateInsetsBottom(new int[0]);
        listController.setGlassplateInsetsTop(new int[0]);
        listController.setIdColumn(0);
        listController.setNoFocusAreasBottom(new int[0]);
        listController.setNoFocusAreasTop(new int[0]);
        listController.setDataAccess(new BaseListModelAccess());
        listController.setItemFactory(new ListItemFactory(){

            public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                switch (n) {
                    case 0: {
                        MenuItemController menuItemController = new MenuItemController();
                        menuItemController.setType(16);
                        menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                        GridLayout gridLayout = new GridLayout();
                        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                        menuItemColumnsConstraints.grow = new float[]{1.0f};
                        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                        AxisConstraints axisConstraints = new AxisConstraints(1);
                        gridLayout.setRowConstraints(axisConstraints);
                        AbstractWidgetController abstractWidgetController = this.createCell(0);
                        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                        gridLayoutHints.hidemode = 0;
                        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                        menuItemController.add(abstractWidgetController);
                        return menuItemController;
                    }
                }
                return null;
            }

            public AbstractWidgetController createListItemNoData() {
                return null;
            }

            public AbstractWidgetController createCell(int n) {
                switch (n) {
                    case 0: {
                        LabelController labelController = new LabelController();
                        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                        labelController.setRenderer(labelRendererHigh);
                        labelController.setModelColumn(1);
                        return labelController;
                    }
                }
                return null;
            }
        });
        MenuController menuController = new MenuController();
        MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
        menuController.setRenderer(menuRendererHigh);
        menuController.createInfolineWidgets(new InfoLineRendererHigh());
        menuController.getInfoline().getInfolineRenderer().setFonts(testSupportScreenFactory.getFonts(1, n));
        menuController.setDefaultDisabledInfolineTextId(2400023);
        menuController.getInfolineTimer().setIdleTime(800);
        menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
        menuController.getLayout().setBackgroundInsetsVert(7);
        menuController.getLayout().setContentLeftOffset(12);
        menuController.getLayout().setContentRightOffset(25);
        menuController.getLayout().setContentRightOffsetSmallStage(25);
        menuController.getLayout().setItemsGap(9);
        menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
        menuController.setBounds(62, 77, 716, 324);
        menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
        menuController.add(glassplateController, 4);
        menuController.add(scrollbarController, 3);
        menuController.add(focusCursorController, 1);
        menuController.add(listController);
        ContainerController containerController = new ContainerController();
        ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
        containerController.setRenderer(containerRendererHigh);
        containerController.setBounds(0, 0, 0, 0);
        containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
        containerController.setOpacitySet(1.0f, 0.4f);
        containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
        containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
        containerController.add(menuController);
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{127});
        iconController.setBounds(0, 0, 100, 100);
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(testSupportScreenFactory.getFonts(2, n));
        labelController.setTextIds(new int[]{2400013});
        labelController.setBounds(0, 0, 0, 30);
        labelController.setColorIndices(new int[]{1, 2, 4, 0});
        LabelController labelController2 = new LabelController();
        LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
        labelController2.setRenderer(labelRendererHigh2);
        labelController2.setTextIds(new int[]{2400012});
        labelController2.setBounds(0, 0, 0, 30);
        labelController2.setCoordinateSets(new int[]{1, 0, 0, 0, 30, 0, 0, 0, 30});
        TitleBarWidget titleBarWidget = new TitleBarWidget();
        TitleBarRendererHigh titleBarRendererHigh = new TitleBarRendererHigh(titleBarWidget);
        titleBarWidget.setRenderer(titleBarRendererHigh);
        titleBarWidget.setBitmaps(new int[]{58, 58});
        titleBarWidget.getTitleLayout().setGapInsideBreadcrumbs(15);
        titleBarWidget.getTitleLayout().setGapInsideTitles(15);
        titleBarWidget.setBounds(75, 28, 650, 22);
        titleBarWidget.setColorIndices(new int[]{1, 8, 4, 0});
        titleBarWidget.addLeftIcon(iconController);
        titleBarWidget.addTitle(labelController);
        titleBarWidget.addBreadcrumb(labelController2);
        ContainerController containerController2 = new ContainerController();
        ContainerRendererHigh containerRendererHigh2 = new ContainerRendererHigh(containerController2);
        containerController2.setRenderer(containerRendererHigh2);
        containerController2.setBounds(0, 0, 800, 0);
        containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
        containerController2.setOpacitySet(1.0f, 0.4f);
        containerController2.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.add(titleBarWidget);
        StatusBarStubController statusBarStubController = new StatusBarStubController();
        statusBarStubController.setModelID(138);
        statusBarStubController.setBounds(0, 0, 100, 100);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(2400001);
        screenWidgetEVO.setScreenFactory(testSupportScreenFactory);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenRendererHigh.setFonts(testSupportScreenFactory.getFonts(0, n));
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -16777216, -1, -1, -6645094, -5592406, -4868683, -6645094, -1}, {-1, -16777216, -65511, -5546136, -6645094, -5592406, -4868683, -6645094, -4703671}, {-1, -16777216, -19456, -6123155, -6645094, -5592406, -4868683, -6645094, -6123155}, {-1, -16777216, -14775126, -9594974, -6645094, -5592406, -4868683, -6645094, -9594974}, {-1, -16777216, -10180096, -9200779, -6645094, -5592406, -4868683, -6645094, -9200779}});
        screenWidgetEVO.setSmallStageType(3);
        screenWidgetEVO.add(containerController, 1);
        screenWidgetEVO.add(containerController2, 2);
        screenWidgetEVO.add(statusBarStubController);
        screenWidgetEVO.setViews(new int[]{138, 2400006}, new HMIView[][]{{statusBarStubController}, {listController}});
        screenWidgetEVO.setModelIDs(new int[]{2400006});
        screenWidgetEVO.setEventIDs(new int[]{2400001});
        return screenWidgetEVO;
    }

    public static Screen tsProviderDetails(TestSupportScreenFactory testSupportScreenFactory, int n) {
        GlassplateController glassplateController = new GlassplateController();
        GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
        glassplateController.setRenderer(glassplateRendererHigh);
        glassplateController.setBounds(0, 0, 100, 100);
        glassplateController.setSdsNumbersGapWidth(4);
        glassplateController.setSdsNumbersWidth(64);
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
        scrollbarController.setRenderer(scrollbarRendererKanziHigh);
        scrollbarController.setBounds(703, 11, 5, 302);
        FocusCursorController focusCursorController = new FocusCursorController();
        FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
        focusCursorController.setRenderer(focusCursorRendererHigh);
        focusCursorController.setBounds(0, 0, 100, 100);
        focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
        focusCursorController.setOptionsIconVisible(false);
        MenuItemController menuItemController = new MenuItemController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(menuItemController);
        menuItemController.setRenderer(compositeRendererHigh);
        menuItemController.setModelID(2400003);
        menuItemController.setLabelId(2400014);
        menuItemController.setGlassplateInsetsBottom(6);
        menuItemController.setGlassplateInsetsTop(7);
        menuItemController.setInternalID(2400001);
        menuItemController.setType(8);
        MenuItemController menuItemController2 = new MenuItemController();
        CompositeRendererHigh compositeRendererHigh2 = new CompositeRendererHigh(menuItemController2);
        menuItemController2.setRenderer(compositeRendererHigh2);
        menuItemController2.setModelID(2400004);
        menuItemController2.setLabelId(2400015);
        menuItemController2.setGlassplateInsetsBottom(6);
        menuItemController2.setGlassplateInsetsTop(7);
        menuItemController2.setInternalID(2400002);
        menuItemController2.setType(8);
        ListController listController = new ListController();
        listController.setModelID(2400005);
        listController.setBounds(0, 0, 0, 0);
        listController.setGlassplateInsetsBottom(new int[0]);
        listController.setGlassplateInsetsTop(new int[0]);
        listController.setIdColumn(0);
        listController.setNoFocusAreasBottom(new int[0]);
        listController.setNoFocusAreasTop(new int[0]);
        listController.setDataAccess(new BaseListModelAccess());
        listController.setItemFactory(new ListItemFactory(){

            public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                switch (n) {
                    case 0: {
                        MenuItemController menuItemController = new MenuItemController();
                        menuItemController.setType(16);
                        menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                        GridLayout gridLayout = new GridLayout();
                        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                        menuItemColumnsConstraints.grow = new float[]{1.0f};
                        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                        AxisConstraints axisConstraints = new AxisConstraints(1);
                        gridLayout.setRowConstraints(axisConstraints);
                        AbstractWidgetController abstractWidgetController = this.createCell(0);
                        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                        gridLayoutHints.hidemode = 0;
                        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                        menuItemController.add(abstractWidgetController);
                        return menuItemController;
                    }
                }
                return null;
            }

            public AbstractWidgetController createListItemNoData() {
                return null;
            }

            public AbstractWidgetController createCell(int n) {
                switch (n) {
                    case 0: {
                        LabelController labelController = new LabelController();
                        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                        labelController.setRenderer(labelRendererHigh);
                        labelController.setModelColumn(1);
                        return labelController;
                    }
                }
                return null;
            }
        });
        MenuController menuController = new MenuController();
        MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
        menuController.setRenderer(menuRendererHigh);
        menuController.createInfolineWidgets(new InfoLineRendererHigh());
        menuController.getInfoline().getInfolineRenderer().setFonts(testSupportScreenFactory.getFonts(1, n));
        menuController.setDefaultDisabledInfolineTextId(2400023);
        menuController.getInfolineTimer().setIdleTime(800);
        menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
        menuController.getLayout().setBackgroundInsetsVert(7);
        menuController.getLayout().setContentLeftOffset(12);
        menuController.getLayout().setContentRightOffset(25);
        menuController.getLayout().setContentRightOffsetSmallStage(25);
        menuController.getLayout().setItemsGap(9);
        menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
        menuController.setBounds(62, 77, 716, 324);
        menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
        menuController.add(glassplateController, 4);
        menuController.add(scrollbarController, 3);
        menuController.add(focusCursorController, 1);
        menuController.add(menuItemController);
        menuController.add(menuItemController2);
        menuController.add(listController);
        ContainerController containerController = new ContainerController();
        ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
        containerController.setRenderer(containerRendererHigh);
        containerController.setBounds(0, 0, 0, 0);
        containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
        containerController.setOpacitySet(1.0f, 0.4f);
        containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
        containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
        containerController.add(menuController);
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{127});
        iconController.setBounds(0, 0, 100, 100);
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(testSupportScreenFactory.getFonts(2, n));
        labelController.setModelID(2400001);
        labelController.setTextIds(new int[]{2400016});
        labelController.setBounds(0, 0, 0, 30);
        labelController.setColorIndices(new int[]{1, 2, 4, 0});
        LabelController labelController2 = new LabelController();
        LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
        labelController2.setRenderer(labelRendererHigh2);
        labelController2.setTextIds(new int[]{2400013});
        labelController2.setBounds(0, 0, 0, 30);
        labelController2.setCoordinateSets(new int[]{1, 0, 0, 0, 30, 0, 0, 0, 30});
        TitleBarWidget titleBarWidget = new TitleBarWidget();
        TitleBarRendererHigh titleBarRendererHigh = new TitleBarRendererHigh(titleBarWidget);
        titleBarWidget.setRenderer(titleBarRendererHigh);
        titleBarWidget.setBitmaps(new int[]{58, 58});
        titleBarWidget.getTitleLayout().setGapInsideBreadcrumbs(15);
        titleBarWidget.getTitleLayout().setGapInsideTitles(15);
        titleBarWidget.setBounds(75, 28, 650, 22);
        titleBarWidget.setColorIndices(new int[]{1, 8, 4, 0});
        titleBarWidget.addLeftIcon(iconController);
        titleBarWidget.addTitle(labelController);
        titleBarWidget.addBreadcrumb(labelController2);
        ContainerController containerController2 = new ContainerController();
        ContainerRendererHigh containerRendererHigh2 = new ContainerRendererHigh(containerController2);
        containerController2.setRenderer(containerRendererHigh2);
        containerController2.setBounds(0, 0, 800, 0);
        containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
        containerController2.setOpacitySet(1.0f, 0.4f);
        containerController2.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.add(titleBarWidget);
        StatusBarStubController statusBarStubController = new StatusBarStubController();
        statusBarStubController.setModelID(138);
        statusBarStubController.setBounds(0, 0, 100, 100);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(2400002);
        screenWidgetEVO.setScreenFactory(testSupportScreenFactory);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenRendererHigh.setFonts(testSupportScreenFactory.getFonts(0, n));
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -16777216, -1, -1, -6645094, -5592406, -4868683, -6645094, -1}, {-1, -16777216, -65511, -5546136, -6645094, -5592406, -4868683, -6645094, -4703671}, {-1, -16777216, -19456, -6123155, -6645094, -5592406, -4868683, -6645094, -6123155}, {-1, -16777216, -14775126, -9594974, -6645094, -5592406, -4868683, -6645094, -9594974}, {-1, -16777216, -10180096, -9200779, -6645094, -5592406, -4868683, -6645094, -9200779}});
        screenWidgetEVO.setSmallStageType(3);
        screenWidgetEVO.add(containerController, 1);
        screenWidgetEVO.add(containerController2, 2);
        screenWidgetEVO.add(statusBarStubController);
        screenWidgetEVO.setViews(new int[]{138, 2400001, 2400003, 2400004, 2400005}, new HMIView[][]{{statusBarStubController}, {labelController}, {menuItemController}, {menuItemController2}, {listController}});
        return screenWidgetEVO;
    }

    public static Screen tsReceivers(TestSupportScreenFactory testSupportScreenFactory, int n) {
        GlassplateController glassplateController = new GlassplateController();
        GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
        glassplateController.setRenderer(glassplateRendererHigh);
        glassplateController.setBounds(0, 0, 100, 100);
        glassplateController.setSdsNumbersGapWidth(4);
        glassplateController.setSdsNumbersWidth(64);
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
        scrollbarController.setRenderer(scrollbarRendererKanziHigh);
        scrollbarController.setBounds(703, 11, 5, 302);
        FocusCursorController focusCursorController = new FocusCursorController();
        FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
        focusCursorController.setRenderer(focusCursorRendererHigh);
        focusCursorController.setBounds(0, 0, 100, 100);
        focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
        focusCursorController.setOptionsIconVisible(false);
        ListController listController = new ListController();
        listController.setModelID(2400008);
        listController.setEvent(2400001);
        listController.setBounds(0, 0, 0, 0);
        listController.setGlassplateInsetsBottom(new int[0]);
        listController.setGlassplateInsetsTop(new int[0]);
        listController.setIdColumn(0);
        listController.setNoFocusAreasBottom(new int[0]);
        listController.setNoFocusAreasTop(new int[0]);
        listController.setDataAccess(new BaseListModelAccess());
        listController.setItemFactory(new ListItemFactory(){

            public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                switch (n) {
                    case 0: {
                        MenuItemController menuItemController = new MenuItemController();
                        menuItemController.setType(16);
                        menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                        GridLayout gridLayout = new GridLayout();
                        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                        menuItemColumnsConstraints.grow = new float[]{1.0f};
                        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                        AxisConstraints axisConstraints = new AxisConstraints(1);
                        gridLayout.setRowConstraints(axisConstraints);
                        AbstractWidgetController abstractWidgetController = this.createCell(0);
                        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                        gridLayoutHints.hidemode = 0;
                        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                        menuItemController.add(abstractWidgetController);
                        return menuItemController;
                    }
                }
                return null;
            }

            public AbstractWidgetController createListItemNoData() {
                return null;
            }

            public AbstractWidgetController createCell(int n) {
                switch (n) {
                    case 0: {
                        LabelController labelController = new LabelController();
                        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                        labelController.setRenderer(labelRendererHigh);
                        labelController.setModelColumn(0);
                        return labelController;
                    }
                }
                return null;
            }
        });
        MenuController menuController = new MenuController();
        MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
        menuController.setRenderer(menuRendererHigh);
        menuController.createInfolineWidgets(new InfoLineRendererHigh());
        menuController.getInfoline().getInfolineRenderer().setFonts(testSupportScreenFactory.getFonts(1, n));
        menuController.setDefaultDisabledInfolineTextId(2400023);
        menuController.getInfolineTimer().setIdleTime(800);
        menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
        menuController.getLayout().setBackgroundInsetsVert(7);
        menuController.getLayout().setContentLeftOffset(12);
        menuController.getLayout().setContentRightOffset(25);
        menuController.getLayout().setContentRightOffsetSmallStage(25);
        menuController.getLayout().setItemsGap(9);
        menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
        menuController.setBounds(62, 77, 716, 324);
        menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
        menuController.add(glassplateController, 4);
        menuController.add(scrollbarController, 3);
        menuController.add(focusCursorController, 1);
        menuController.add(listController);
        ContainerController containerController = new ContainerController();
        ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
        containerController.setRenderer(containerRendererHigh);
        containerController.setBounds(0, 0, 0, 0);
        containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
        containerController.setOpacitySet(1.0f, 0.4f);
        containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
        containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
        containerController.add(menuController);
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{127});
        iconController.setBounds(0, 0, 100, 100);
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(testSupportScreenFactory.getFonts(2, n));
        labelController.setTextIds(new int[]{2400020});
        labelController.setBounds(0, 0, 0, 30);
        labelController.setColorIndices(new int[]{1, 2, 4, 0});
        LabelController labelController2 = new LabelController();
        LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
        labelController2.setRenderer(labelRendererHigh2);
        labelController2.setTextIds(new int[]{2400012});
        labelController2.setBounds(0, 0, 0, 30);
        labelController2.setCoordinateSets(new int[]{1, 0, 0, 0, 30, 0, 0, 0, 30});
        TitleBarWidget titleBarWidget = new TitleBarWidget();
        TitleBarRendererHigh titleBarRendererHigh = new TitleBarRendererHigh(titleBarWidget);
        titleBarWidget.setRenderer(titleBarRendererHigh);
        titleBarWidget.setBitmaps(new int[]{58, 58});
        titleBarWidget.getTitleLayout().setGapInsideBreadcrumbs(15);
        titleBarWidget.getTitleLayout().setGapInsideTitles(15);
        titleBarWidget.setBounds(75, 28, 650, 22);
        titleBarWidget.setColorIndices(new int[]{1, 8, 4, 0});
        titleBarWidget.addLeftIcon(iconController);
        titleBarWidget.addTitle(labelController);
        titleBarWidget.addBreadcrumb(labelController2);
        ContainerController containerController2 = new ContainerController();
        ContainerRendererHigh containerRendererHigh2 = new ContainerRendererHigh(containerController2);
        containerController2.setRenderer(containerRendererHigh2);
        containerController2.setBounds(0, 0, 800, 0);
        containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
        containerController2.setOpacitySet(1.0f, 0.4f);
        containerController2.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.add(titleBarWidget);
        StatusBarStubController statusBarStubController = new StatusBarStubController();
        statusBarStubController.setModelID(138);
        statusBarStubController.setBounds(0, 0, 100, 100);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(2400003);
        screenWidgetEVO.setScreenFactory(testSupportScreenFactory);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenRendererHigh.setFonts(testSupportScreenFactory.getFonts(0, n));
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -16777216, -1, -1, -6645094, -5592406, -4868683, -6645094, -1}, {-1, -16777216, -65511, -5546136, -6645094, -5592406, -4868683, -6645094, -4703671}, {-1, -16777216, -19456, -6123155, -6645094, -5592406, -4868683, -6645094, -6123155}, {-1, -16777216, -14775126, -9594974, -6645094, -5592406, -4868683, -6645094, -9594974}, {-1, -16777216, -10180096, -9200779, -6645094, -5592406, -4868683, -6645094, -9200779}});
        screenWidgetEVO.setSmallStageType(3);
        screenWidgetEVO.add(containerController, 1);
        screenWidgetEVO.add(containerController2, 2);
        screenWidgetEVO.add(statusBarStubController);
        screenWidgetEVO.setViews(new int[]{138, 2400008}, new HMIView[][]{{statusBarStubController}, {listController}});
        screenWidgetEVO.setModelIDs(new int[]{2400008});
        screenWidgetEVO.setEventIDs(new int[]{2400001});
        return screenWidgetEVO;
    }

    public static Screen tsReceiversDetails(TestSupportScreenFactory testSupportScreenFactory, int n) {
        GlassplateController glassplateController = new GlassplateController();
        GlassplateRendererHigh glassplateRendererHigh = new GlassplateRendererHigh(glassplateController);
        glassplateController.setRenderer(glassplateRendererHigh);
        glassplateController.setBounds(0, 0, 100, 100);
        glassplateController.setSdsNumbersGapWidth(4);
        glassplateController.setSdsNumbersWidth(64);
        ScrollbarController scrollbarController = new ScrollbarController();
        ScrollbarRendererKanziHigh scrollbarRendererKanziHigh = new ScrollbarRendererKanziHigh(scrollbarController);
        scrollbarController.setRenderer(scrollbarRendererKanziHigh);
        scrollbarController.setBounds(703, 11, 5, 302);
        FocusCursorController focusCursorController = new FocusCursorController();
        FocusCursorRendererHigh focusCursorRendererHigh = new FocusCursorRendererHigh(focusCursorController);
        focusCursorController.setRenderer(focusCursorRendererHigh);
        focusCursorController.setBounds(0, 0, 100, 100);
        focusCursorController.setColorIndices(new int[]{1, 2, 4, 0});
        focusCursorController.setOptionsIconVisible(false);
        ListController listController = new ListController();
        listController.setModelID(2400007);
        listController.setBounds(0, 0, 0, 0);
        listController.setGlassplateInsetsBottom(new int[0]);
        listController.setGlassplateInsetsTop(new int[0]);
        listController.setIdColumn(0);
        listController.setNoFocusAreasBottom(new int[0]);
        listController.setNoFocusAreasTop(new int[0]);
        listController.setRecordSetColumn(3);
        listController.setDataAccess(new BaseListModelAccess());
        listController.setItemFactory(new ListItemFactory(){

            public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
                switch (n) {
                    case 0: {
                        MenuItemController menuItemController = new MenuItemController();
                        menuItemController.setType(16);
                        menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                        GridLayout gridLayout = new GridLayout();
                        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                        menuItemColumnsConstraints.grow = new float[]{1.0f};
                        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                        AxisConstraints axisConstraints = new AxisConstraints(1);
                        gridLayout.setRowConstraints(axisConstraints);
                        AbstractWidgetController abstractWidgetController = this.createCell(0);
                        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                        gridLayoutHints.hidemode = 0;
                        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                        menuItemController.add(abstractWidgetController);
                        return menuItemController;
                    }
                    case 1: {
                        MenuItemController menuItemController = new MenuItemController();
                        menuItemController.setType(16);
                        menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                        GridLayout gridLayout = new GridLayout();
                        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                        menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                        menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                        AxisConstraints axisConstraints = new AxisConstraints(1);
                        gridLayout.setRowConstraints(axisConstraints);
                        AbstractWidgetController abstractWidgetController = this.createCell(0);
                        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                        AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                        menuItemController.add(abstractWidgetController);
                        menuItemController.add(abstractWidgetController2);
                        return menuItemController;
                    }
                }
                return null;
            }

            public AbstractWidgetController createListItemNoData() {
                return null;
            }

            public AbstractWidgetController createCell(int n) {
                switch (n) {
                    case 0: {
                        LabelController labelController = new LabelController();
                        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                        labelController.setRenderer(labelRendererHigh);
                        labelController.setModelColumn(0);
                        return labelController;
                    }
                    case 1: {
                        CheckboxController checkboxController = new CheckboxController();
                        CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                        checkboxController.setRenderer(checkboxRendererHigh);
                        checkboxController.setBounds(0, 0, 100, 100);
                        checkboxController.setMapping(new int[][]{{0}, {1}});
                        checkboxController.setModelColumn(1);
                        return checkboxController;
                    }
                }
                return null;
            }
        });
        MenuController menuController = new MenuController();
        MenuRendererHigh menuRendererHigh = new MenuRendererHigh(menuController);
        menuController.setRenderer(menuRendererHigh);
        menuController.createInfolineWidgets(new InfoLineRendererHigh());
        menuController.getInfoline().getInfolineRenderer().setFonts(testSupportScreenFactory.getFonts(1, n));
        menuController.setDefaultDisabledInfolineTextId(2400023);
        menuController.getInfolineTimer().setIdleTime(800);
        menuController.getInfoline().setColorIndices(new int[]{2, 0, 4, 3});
        menuController.getLayout().setBackgroundInsetsVert(7);
        menuController.getLayout().setContentLeftOffset(12);
        menuController.getLayout().setContentRightOffset(25);
        menuController.getLayout().setContentRightOffsetSmallStage(25);
        menuController.getLayout().setItemsGap(9);
        menuController.getLayout().setOptionsIconAdditionalRightInsets(16);
        menuController.setBounds(62, 77, 716, 324);
        menuController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
        menuController.add(glassplateController, 4);
        menuController.add(scrollbarController, 3);
        menuController.add(focusCursorController, 1);
        menuController.add(listController);
        ContainerController containerController = new ContainerController();
        ContainerRendererHigh containerRendererHigh = new ContainerRendererHigh(containerController);
        containerController.setRenderer(containerRendererHigh);
        containerController.setBounds(0, 0, 0, 0);
        containerController.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.5f);
        containerController.setOpacitySet(1.0f, 0.4f);
        containerController.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.5f);
        containerController.setSelectionMenuTransformation(318.0f, 7.0f, 0.58f, 0.6f, 0.25f);
        containerController.add(menuController);
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{127});
        iconController.setBounds(0, 0, 100, 100);
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelRendererHigh.setFonts(testSupportScreenFactory.getFonts(2, n));
        labelController.setModelID(2400009);
        labelController.setTextIds(new int[]{2400016});
        labelController.setBounds(0, 0, 0, 30);
        labelController.setColorIndices(new int[]{1, 2, 4, 0});
        LabelController labelController2 = new LabelController();
        LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
        labelController2.setRenderer(labelRendererHigh2);
        labelController2.setTextIds(new int[]{2400020});
        labelController2.setBounds(0, 0, 0, 30);
        labelController2.setCoordinateSets(new int[]{1, 0, 0, 0, 30, 0, 0, 0, 30});
        TitleBarWidget titleBarWidget = new TitleBarWidget();
        TitleBarRendererHigh titleBarRendererHigh = new TitleBarRendererHigh(titleBarWidget);
        titleBarWidget.setRenderer(titleBarRendererHigh);
        titleBarWidget.setBitmaps(new int[]{58, 58});
        titleBarWidget.getTitleLayout().setGapInsideBreadcrumbs(15);
        titleBarWidget.getTitleLayout().setGapInsideTitles(15);
        titleBarWidget.setBounds(75, 28, 650, 22);
        titleBarWidget.setColorIndices(new int[]{1, 8, 4, 0});
        titleBarWidget.addLeftIcon(iconController);
        titleBarWidget.addTitle(labelController);
        titleBarWidget.addBreadcrumb(labelController2);
        ContainerController containerController2 = new ContainerController();
        ContainerRendererHigh containerRendererHigh2 = new ContainerRendererHigh(containerController2);
        containerController2.setRenderer(containerRendererHigh2);
        containerController2.setBounds(0, 0, 800, 0);
        containerController2.setEntertainmentMenuTransformation(12.0f, 12.0f, 0.96f, 0.96f, 0.0f);
        containerController2.setOpacitySet(1.0f, 0.4f);
        containerController2.setOptionMenuTransformation(-4.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.setSelectionMenuTransformation(391.0f, 7.0f, 0.6f, 0.6f, 0.0f);
        containerController2.add(titleBarWidget);
        StatusBarStubController statusBarStubController = new StatusBarStubController();
        statusBarStubController.setModelID(138);
        statusBarStubController.setBounds(0, 0, 100, 100);
        ScreenWidgetEVO screenWidgetEVO = new ScreenWidgetEVO(2400004);
        screenWidgetEVO.setScreenFactory(testSupportScreenFactory);
        ScreenRendererHigh screenRendererHigh = new ScreenRendererHigh(screenWidgetEVO);
        screenWidgetEVO.setRenderer(screenRendererHigh);
        screenRendererHigh.setFonts(testSupportScreenFactory.getFonts(0, n));
        screenWidgetEVO.setColorIndices(new int[]{1, 2, 4, 0});
        screenWidgetEVO.setColorPalettes(new int[][]{{-1, -16777216, -1, -1, -6645094, -5592406, -4868683, -6645094, -1}, {-1, -16777216, -65511, -5546136, -6645094, -5592406, -4868683, -6645094, -4703671}, {-1, -16777216, -19456, -6123155, -6645094, -5592406, -4868683, -6645094, -6123155}, {-1, -16777216, -14775126, -9594974, -6645094, -5592406, -4868683, -6645094, -9594974}, {-1, -16777216, -10180096, -9200779, -6645094, -5592406, -4868683, -6645094, -9200779}});
        screenWidgetEVO.setSmallStageType(3);
        screenWidgetEVO.add(containerController, 1);
        screenWidgetEVO.add(containerController2, 2);
        screenWidgetEVO.add(statusBarStubController);
        screenWidgetEVO.setViews(new int[]{138, 2400007, 2400009}, new HMIView[][]{{statusBarStubController}, {listController}, {labelController}});
        return screenWidgetEVO;
    }
}

