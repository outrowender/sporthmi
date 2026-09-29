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

class NaviScreenFactory$1
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ NaviScreenFactory this$0;

    NaviScreenFactory$1(NaviScreenFactory naviScreenFactory, NaviScreenFactory naviScreenFactory2, int n) {
        this.this$0 = naviScreenFactory;
        this.val$factory = naviScreenFactory2;
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
                axisConstraints.alignment = new int[]{5, 9};
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints2.gaps = new int[]{0, 12, 15, 0};
                menuItemColumnsConstraints2.shrink = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 2, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController4 = this.createCell(1);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(4);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(2, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4, gridLayoutHints5, gridLayoutHints6}, new Object[]{abstractWidgetController4, abstractWidgetController5, abstractWidgetController6});
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 0);
                gridLayoutHints7.hidemode = 0;
                AbstractWidgetController abstractWidgetController7 = this.createCell(5);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 1);
                gridLayoutHints8.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints7, gridLayoutHints8}, new Object[]{abstractWidgetController, gridLayout2, abstractWidgetController7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(6);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.gaps = new int[]{0, 12, 15, 0};
                menuItemColumnsConstraints3.shrink = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints3.hidemode = new int[]{0, 2, 2};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController8 = this.createCell(1);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(3);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(4);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(2, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints9, gridLayoutHints10, gridLayoutHints11}, new Object[]{abstractWidgetController8, abstractWidgetController9, abstractWidgetController10});
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 0);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints4.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints4.size = new int[]{40, -1, -1};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController11 = this.createCell(7);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 0);
                gridLayoutHints13.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController12 = this.createCell(8);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(5);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(2, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints13, gridLayoutHints14, gridLayoutHints15}, new Object[]{abstractWidgetController11, abstractWidgetController12, abstractWidgetController13});
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints12, gridLayoutHints16}, new Object[]{abstractWidgetController, gridLayout3, gridLayout4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController10);
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
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(9);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController14 = this.createCell(1);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                gridLayoutHints17.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController14});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 4: {
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(10);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController15 = this.createCell(1);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(1, 0);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints5.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints5.size = new int[]{40, -1, -1};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController16 = this.createCell(7);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(0, 0);
                gridLayoutHints19.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController17 = this.createCell(8);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController18 = this.createCell(5);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(2, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints19, gridLayoutHints20, gridLayoutHints21}, new Object[]{abstractWidgetController16, abstractWidgetController17, abstractWidgetController18});
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints18, gridLayoutHints22}, new Object[]{abstractWidgetController, abstractWidgetController15, gridLayout5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController16);
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(11);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints6.gaps = new int[]{0, 12, 15, 0};
                menuItemColumnsConstraints6.shrink = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints6.hidemode = new int[]{0, 2, 2};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                axisConstraints6.alignment = new int[]{5};
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController19 = this.createCell(1);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController20 = this.createCell(3);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController21 = this.createCell(4);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(2, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints23, gridLayoutHints24, gridLayoutHints25}, new Object[]{abstractWidgetController19, abstractWidgetController20, abstractWidgetController21});
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                GridLayout gridLayout7 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints7 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints7.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints7.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints7.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints7.size = new int[]{40, -1, -1};
                gridLayout7.setColumnConstraints(menuItemColumnsConstraints7);
                AxisConstraints axisConstraints7 = new AxisConstraints(1);
                gridLayout7.setRowConstraints(axisConstraints7);
                AbstractWidgetController abstractWidgetController22 = this.createCell(7);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(0, 0);
                gridLayoutHints27.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController23 = this.createCell(8);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(5);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(2, 0);
                gridLayout7.setCellConstraints(new GridLayoutHints[]{gridLayoutHints27, gridLayoutHints28, gridLayoutHints29}, new Object[]{abstractWidgetController22, abstractWidgetController23, abstractWidgetController24});
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints26, gridLayoutHints30}, new Object[]{abstractWidgetController, gridLayout6, gridLayout7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController21);
                return menuItemController;
            }
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(12);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController25 = this.createCell(13);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(1, 0);
                gridLayoutHints31.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController26 = this.createCell(1);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints31, gridLayoutHints32}, new Object[]{abstractWidgetController, abstractWidgetController25, abstractWidgetController26});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController26);
                menuItemController.add(abstractWidgetController25);
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController27 = this.createCell(1);
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(1, 0);
                gridLayoutHints33.hidemode = 0;
                GridLayout gridLayout8 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints8 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints8.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints8.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints8.size = new int[]{40, -1, -1};
                gridLayout8.setColumnConstraints(menuItemColumnsConstraints8);
                AxisConstraints axisConstraints8 = new AxisConstraints(1);
                gridLayout8.setRowConstraints(axisConstraints8);
                AbstractWidgetController abstractWidgetController28 = this.createCell(7);
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(0, 0);
                gridLayoutHints34.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController29 = this.createCell(8);
                GridLayoutHints gridLayoutHints35 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController30 = this.createCell(2);
                GridLayoutHints gridLayoutHints36 = new GridLayoutHints(2, 0);
                gridLayout8.setCellConstraints(new GridLayoutHints[]{gridLayoutHints34, gridLayoutHints35, gridLayoutHints36}, new Object[]{abstractWidgetController28, abstractWidgetController29, abstractWidgetController30});
                GridLayoutHints gridLayoutHints37 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints33, gridLayoutHints37}, new Object[]{abstractWidgetController, abstractWidgetController27, gridLayout8});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController27);
                menuItemController.add(abstractWidgetController30);
                menuItemController.add(abstractWidgetController29);
                menuItemController.add(abstractWidgetController28);
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
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController31 = this.createCell(1);
                GridLayoutHints gridLayoutHints38 = new GridLayoutHints(1, 0);
                GridLayout gridLayout9 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints9 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints9.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints9.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints9.size = new int[]{40, -1, -1};
                gridLayout9.setColumnConstraints(menuItemColumnsConstraints9);
                AxisConstraints axisConstraints9 = new AxisConstraints(1);
                axisConstraints9.alignment = new int[]{5};
                gridLayout9.setRowConstraints(axisConstraints9);
                AbstractWidgetController abstractWidgetController32 = this.createCell(7);
                GridLayoutHints gridLayoutHints39 = new GridLayoutHints(0, 0);
                gridLayoutHints39.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController33 = this.createCell(8);
                GridLayoutHints gridLayoutHints40 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController34 = this.createCell(5);
                GridLayoutHints gridLayoutHints41 = new GridLayoutHints(2, 0);
                gridLayout9.setCellConstraints(new GridLayoutHints[]{gridLayoutHints39, gridLayoutHints40, gridLayoutHints41}, new Object[]{abstractWidgetController32, abstractWidgetController33, abstractWidgetController34});
                GridLayoutHints gridLayoutHints42 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints38, gridLayoutHints42}, new Object[]{abstractWidgetController, abstractWidgetController31, gridLayout9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController31);
                menuItemController.add(abstractWidgetController34);
                menuItemController.add(abstractWidgetController33);
                menuItemController.add(abstractWidgetController32);
                return menuItemController;
            }
        }
        return null;
    }

    @Override
    public AbstractWidgetController createListItemNoData() {
        return null;
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
                labelController.setTextOrientationHints(new int[]{6});
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
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127, 756811264, 773588480, 790365696, 127, 127, 127, 807142912});
                iconController.setModelColumn(7);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127, 756811264, 773588480, 790365696, 127, 127, 127, 807142912});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                labelController.setTextOrientationHints(new int[]{6});
                return labelController;
            }
            case 6: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, -50, 100, 100);
                iconLabelController.setModelColumn(1);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 7: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349});
                iconController.setModelColumn(6);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(5);
                return labelController;
            }
            case 9: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{186, 185, 127, 127, 127, 127});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 10: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{85657088});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 11: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{169543168});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 12: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 13: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{907740672, 924517888, 941295104, 958072320, 974849536, 974849536});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
        }
        return null;
    }
}

