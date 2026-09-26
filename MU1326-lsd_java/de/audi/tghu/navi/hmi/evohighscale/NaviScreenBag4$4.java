/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class NaviScreenBag4$4
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    NaviScreenBag4$4(NaviScreenFactory naviScreenFactory, int n) {
        this.val$factory = naviScreenFactory;
        this.val$terminalID = n;
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        switch (n) {
            case 0: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{1, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.gaps = new int[]{0, 0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 0;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{1, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController4 = this.createCell(1);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                gridLayoutHints4.hidemode = 0;
                AbstractWidgetController abstractWidgetController5 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 1);
                gridLayoutHints5.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController4, abstractWidgetController5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{8, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(4);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController6 = this.createCell(1);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints2.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints2.size = new int[]{40, -1, -1};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController7 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 0);
                gridLayoutHints7.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController8 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(3);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController6, gridLayout2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 2, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(7);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController10 = this.createCell(1);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(1, 0);
                gridLayoutHints11.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints11}, new Object[]{abstractWidgetController, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(8);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController11 = this.createCell(1);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.gaps = new int[]{0, 0, 10, 0};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints3.size = new int[]{40, -1, -1};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController12 = this.createCell(5);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 0);
                gridLayoutHints13.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController13 = this.createCell(6);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController14 = this.createCell(3);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(2, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints13, gridLayoutHints14, gridLayoutHints15}, new Object[]{abstractWidgetController12, abstractWidgetController13, abstractWidgetController14});
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints12, gridLayoutHints16}, new Object[]{abstractWidgetController, abstractWidgetController11, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(9);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController15 = this.createCell(1);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints4.gaps = new int[]{0, 0, 10, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints4.size = new int[]{40, -1, -1};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController16 = this.createCell(5);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(0, 0);
                gridLayoutHints18.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController17 = this.createCell(6);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController18 = this.createCell(3);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(2, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints18, gridLayoutHints19, gridLayoutHints20}, new Object[]{abstractWidgetController16, abstractWidgetController17, abstractWidgetController18});
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17, gridLayoutHints21}, new Object[]{abstractWidgetController, abstractWidgetController15, gridLayout4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController16);
                return menuItemController;
            }
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(10);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController19 = this.createCell(11);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 0);
                gridLayoutHints22.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController20 = this.createCell(1);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints22, gridLayoutHints23}, new Object[]{abstractWidgetController, abstractWidgetController19, abstractWidgetController20});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 7: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{1, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.gaps = new int[]{0, 0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController21 = this.createCell(1);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 0);
                gridLayoutHints24.hidemode = 0;
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints5.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints5.size = new int[]{40, -1, -1};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController22 = this.createCell(5);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(0, 0);
                gridLayoutHints25.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController23 = this.createCell(6);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(2);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(2, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints25, gridLayoutHints26, gridLayoutHints27}, new Object[]{abstractWidgetController22, abstractWidgetController23, abstractWidgetController24});
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints24, gridLayoutHints28}, new Object[]{abstractWidgetController, abstractWidgetController21, gridLayout5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController22);
                return menuItemController;
            }
            case 8: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController25 = this.createCell(1);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(1, 0);
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints6.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints6.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints6.size = new int[]{40, -1, -1};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController26 = this.createCell(5);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(0, 0);
                gridLayoutHints30.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController27 = this.createCell(6);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController28 = this.createCell(3);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(2, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints30, gridLayoutHints31, gridLayoutHints32}, new Object[]{abstractWidgetController26, abstractWidgetController27, abstractWidgetController28});
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints29, gridLayoutHints33}, new Object[]{abstractWidgetController, abstractWidgetController25, gridLayout6});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController28);
                menuItemController.add(abstractWidgetController27);
                menuItemController.add(abstractWidgetController26);
                return menuItemController;
            }
        }
        return null;
    }

    @Override
    public AbstractWidgetController createListItemNoData() {
        MenuItemController menuItemController = new MenuItemController();
        menuItemController.setType(16);
        menuItemController.setRenderer(new CompositeRendererHigh(menuItemController));
        GridLayout gridLayout = new GridLayout();
        MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        AxisConstraints axisConstraints = new AxisConstraints(1);
        gridLayout.setRowConstraints(axisConstraints);
        AbstractWidgetController abstractWidgetController = this.createCell(12);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
        menuItemController.add(abstractWidgetController);
        return menuItemController;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{186, 68879872, 85657088, 35325440, 1041958400, -434436608, 354158080, -132446720});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-65141248});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                return labelController;
            }
            case 4: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, -50, 100, 100);
                iconLabelController.setModelColumn(1);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349});
                iconController.setModelColumn(6);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(5);
                return labelController;
            }
            case 7: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{186, 185, 127, 127, 127, 127});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 8: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{85657088});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 9: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{169543168});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 10: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 11: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{907740672, 924517888, 941295104, 958072320, 974849536, 974849536});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{1663501824});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
        }
        return null;
    }
}

