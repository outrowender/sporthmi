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

final class NaviScreenBag6$4
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    NaviScreenBag6$4(NaviScreenFactory naviScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 135, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 2, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayoutHints3.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                gridLayoutHints5.alignmentHoriz = 3;
                gridLayoutHints5.alignmentVert = 5;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 135, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 2, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController6 = this.createCell(1);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 0);
                gridLayoutHints7.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController8 = this.createCell(3);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(4);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(4, 0);
                gridLayoutHints9.alignmentHoriz = 3;
                gridLayoutHints9.alignmentVert = 5;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, 135, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 2, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController10 = this.createCell(6);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(5);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(2, 0);
                gridLayoutHints11.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController12 = this.createCell(3);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(3, 0);
                gridLayoutHints12.hidemode = 0;
                AbstractWidgetController abstractWidgetController13 = this.createCell(4);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(4, 0);
                gridLayoutHints13.alignmentHoriz = 3;
                gridLayoutHints13.alignmentVert = 5;
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 1);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints2.alignment = new int[]{8, 8, 8, 8};
                menuItemColumnsConstraints2.gaps = new int[]{0, 0, 8, 8, 0};
                menuItemColumnsConstraints2.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints2.max = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints2.min = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints2.shrink = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
                menuItemColumnsConstraints2.size = new int[]{0, -1, -1, 1};
                menuItemColumnsConstraints2.tabulatorIDs = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 0, 0, 0};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{9};
                axisConstraints2.gaps = new int[]{0, 0};
                axisConstraints2.grow = new float[]{0.0f};
                axisConstraints2.max = new int[]{-1};
                axisConstraints2.min = new int[]{-1};
                axisConstraints2.shrink = new float[]{1.0f};
                axisConstraints2.size = new int[]{-1};
                axisConstraints2.hidemode = new int[]{2};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController14 = this.createCell(7);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(1, 0);
                gridLayoutHints15.hidemode = 0;
                AbstractWidgetController abstractWidgetController15 = this.createCell(8);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(2, 0);
                gridLayoutHints16.hidemode = 0;
                AbstractWidgetController abstractWidgetController16 = this.createCell(9);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(3, 0);
                gridLayoutHints17.hidemode = 0;
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints17}, new Object[]{abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(3, 1);
                gridLayoutHints18.hidemode = 0;
                gridLayoutHints18.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14, gridLayoutHints18}, new Object[]{abstractWidgetController, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController10, gridLayout2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController10);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, 135, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 2, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.gaps = new int[]{0, 0, 0};
                axisConstraints.grow = new float[]{0.0f, 0.0f};
                axisConstraints.max = new int[]{-1, -1};
                axisConstraints.min = new int[]{-1, -1};
                axisConstraints.shrink = new float[]{1.0f, 1.0f};
                axisConstraints.size = new int[]{-1, -1};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController17 = this.createCell(6);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController18 = this.createCell(5);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(2, 0);
                gridLayoutHints20.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController19 = this.createCell(3);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController20 = this.createCell(4);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(4, 0);
                gridLayoutHints22.alignmentHoriz = 3;
                gridLayoutHints22.alignmentVert = 5;
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(1, 1);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints3.alignment = new int[]{8, 8};
                menuItemColumnsConstraints3.gaps = new int[]{0, 0, 0};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 0.0f};
                menuItemColumnsConstraints3.max = new int[]{-1, -1};
                menuItemColumnsConstraints3.min = new int[]{-1, -1};
                menuItemColumnsConstraints3.shrink = new float[]{1.0f, 1.0f};
                menuItemColumnsConstraints3.size = new int[]{1, 135};
                menuItemColumnsConstraints3.tabulatorIDs = new int[]{-1, -1, -1};
                menuItemColumnsConstraints3.hidemode = new int[]{0, 0};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.hidemode = new int[]{2};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController21 = this.createCell(7);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 0);
                gridLayoutHints24.hidemode = 0;
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints24}, new Object[]{abstractWidgetController21});
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(3, 1);
                gridLayoutHints25.hidemode = 0;
                gridLayoutHints25.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints19, gridLayoutHints20, gridLayoutHints21, gridLayoutHints22, gridLayoutHints23, gridLayoutHints25}, new Object[]{abstractWidgetController, abstractWidgetController17, abstractWidgetController18, abstractWidgetController19, abstractWidgetController20, abstractWidgetController17, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController17);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, 135, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController22 = this.createCell(6);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController23 = this.createCell(5);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(3);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController25 = this.createCell(4);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(4, 0);
                gridLayoutHints29.alignmentHoriz = 3;
                gridLayoutHints29.alignmentVert = 5;
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(1, 1);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(11);
                menuItemColumnsConstraints4.alignment = new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
                menuItemColumnsConstraints4.gaps = new int[]{0, 5, 5, 5, 5, 5, 5, 0, 12, 8, 8, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints4.max = new int[]{-1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1};
                menuItemColumnsConstraints4.min = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints4.size = new int[]{-1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1};
                menuItemColumnsConstraints4.tabulatorIDs = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints4.hidemode = new int[]{2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                axisConstraints4.hidemode = new int[]{2};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController26 = this.createCell(10);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController27 = this.createCell(11);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController28 = this.createCell(12);
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController29 = this.createCell(13);
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController30 = this.createCell(14);
                GridLayoutHints gridLayoutHints35 = new GridLayoutHints(4, 0);
                AbstractWidgetController abstractWidgetController31 = this.createCell(15);
                GridLayoutHints gridLayoutHints36 = new GridLayoutHints(5, 0);
                AbstractWidgetController abstractWidgetController32 = this.createCell(16);
                GridLayoutHints gridLayoutHints37 = new GridLayoutHints(6, 0);
                AbstractWidgetController abstractWidgetController33 = this.createCell(7);
                GridLayoutHints gridLayoutHints38 = new GridLayoutHints(7, 0);
                GridLayoutHints gridLayoutHints39 = new GridLayoutHints(8, 0);
                AbstractWidgetController abstractWidgetController34 = this.createCell(8);
                GridLayoutHints gridLayoutHints40 = new GridLayoutHints(9, 0);
                AbstractWidgetController abstractWidgetController35 = this.createCell(9);
                GridLayoutHints gridLayoutHints41 = new GridLayoutHints(10, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints31, gridLayoutHints32, gridLayoutHints33, gridLayoutHints34, gridLayoutHints35, gridLayoutHints36, gridLayoutHints37, gridLayoutHints38, gridLayoutHints39, gridLayoutHints40, gridLayoutHints41}, new Object[]{abstractWidgetController26, abstractWidgetController27, abstractWidgetController28, abstractWidgetController29, abstractWidgetController30, abstractWidgetController31, abstractWidgetController32, abstractWidgetController33, abstractWidgetController33, abstractWidgetController34, abstractWidgetController35});
                GridLayoutHints gridLayoutHints42 = new GridLayoutHints(2, 1);
                gridLayoutHints42.hidemode = 0;
                gridLayoutHints42.columnSpan = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints26, gridLayoutHints27, gridLayoutHints28, gridLayoutHints29, gridLayoutHints30, gridLayoutHints42}, new Object[]{abstractWidgetController, abstractWidgetController22, abstractWidgetController23, abstractWidgetController24, abstractWidgetController25, abstractWidgetController22, gridLayout4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController33);
                menuItemController.add(abstractWidgetController34);
                menuItemController.add(abstractWidgetController35);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController26);
                menuItemController.add(abstractWidgetController27);
                menuItemController.add(abstractWidgetController28);
                menuItemController.add(abstractWidgetController29);
                menuItemController.add(abstractWidgetController30);
                menuItemController.add(abstractWidgetController31);
                menuItemController.add(abstractWidgetController32);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, 135, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 1, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController36 = this.createCell(6);
                GridLayoutHints gridLayoutHints43 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController37 = this.createCell(5);
                GridLayoutHints gridLayoutHints44 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController38 = this.createCell(3);
                GridLayoutHints gridLayoutHints45 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController39 = this.createCell(4);
                GridLayoutHints gridLayoutHints46 = new GridLayoutHints(4, 0);
                gridLayoutHints46.alignmentHoriz = 3;
                gridLayoutHints46.alignmentVert = 5;
                GridLayoutHints gridLayoutHints47 = new GridLayoutHints(1, 1);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(9);
                menuItemColumnsConstraints5.gaps = new int[]{0, 5, 5, 5, 5, 5, 5, 15, 0, 0};
                menuItemColumnsConstraints5.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f};
                menuItemColumnsConstraints5.size = new int[]{-1, -1, -1, -1, -1, -1, -1, 1, 135};
                menuItemColumnsConstraints5.hidemode = new int[]{2, 2, 2, 2, 2, 2, 2, 0, 0};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                axisConstraints5.hidemode = new int[]{2};
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController40 = this.createCell(10);
                GridLayoutHints gridLayoutHints48 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController41 = this.createCell(11);
                GridLayoutHints gridLayoutHints49 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController42 = this.createCell(12);
                GridLayoutHints gridLayoutHints50 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController43 = this.createCell(13);
                GridLayoutHints gridLayoutHints51 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController44 = this.createCell(14);
                GridLayoutHints gridLayoutHints52 = new GridLayoutHints(4, 0);
                AbstractWidgetController abstractWidgetController45 = this.createCell(15);
                GridLayoutHints gridLayoutHints53 = new GridLayoutHints(5, 0);
                AbstractWidgetController abstractWidgetController46 = this.createCell(16);
                GridLayoutHints gridLayoutHints54 = new GridLayoutHints(6, 0);
                AbstractWidgetController abstractWidgetController47 = this.createCell(7);
                GridLayoutHints gridLayoutHints55 = new GridLayoutHints(8, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints48, gridLayoutHints49, gridLayoutHints50, gridLayoutHints51, gridLayoutHints52, gridLayoutHints53, gridLayoutHints54, gridLayoutHints55}, new Object[]{abstractWidgetController40, abstractWidgetController41, abstractWidgetController42, abstractWidgetController43, abstractWidgetController44, abstractWidgetController45, abstractWidgetController46, abstractWidgetController47});
                GridLayoutHints gridLayoutHints56 = new GridLayoutHints(2, 1);
                gridLayoutHints56.columnSpan = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints43, gridLayoutHints44, gridLayoutHints45, gridLayoutHints46, gridLayoutHints47, gridLayoutHints56}, new Object[]{abstractWidgetController, abstractWidgetController36, abstractWidgetController37, abstractWidgetController38, abstractWidgetController39, abstractWidgetController36, gridLayout5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController37);
                menuItemController.add(abstractWidgetController38);
                menuItemController.add(abstractWidgetController39);
                menuItemController.add(abstractWidgetController47);
                menuItemController.add(abstractWidgetController36);
                menuItemController.add(abstractWidgetController40);
                menuItemController.add(abstractWidgetController41);
                menuItemController.add(abstractWidgetController42);
                menuItemController.add(abstractWidgetController43);
                menuItemController.add(abstractWidgetController44);
                menuItemController.add(abstractWidgetController45);
                menuItemController.add(abstractWidgetController46);
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
        AbstractWidgetController abstractWidgetController = this.createCell(17);
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
                iconController.setBitmaps(new int[]{127, 186, 185});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{102434304, 119211520});
                iconController.setModelColumn(3);
                iconController.setPreferredHeight(1);
                iconController.setPreferredWidth(30);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(4);
                return labelController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 39});
                iconController.setModelColumn(5);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(3);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setModelColumn(2);
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-2044328448});
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setModelColumn(6);
                return labelController;
            }
            case 10: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(7);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 11: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(8);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 12: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(9);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 13: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(10);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 14: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(11);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 15: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(12);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 16: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(13);
                iconLabelController.setPreferredHeight(20);
                iconLabelController.setPreferredWidth(20);
                iconLabelRendererHigh.setAlignment(1, 5);
                iconLabelRendererHigh.setScaleMode(1);
                return iconLabelController;
            }
            case 17: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setTextIds(new int[]{1797326336});
                return labelController;
            }
        }
        return null;
    }
}

