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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class NaviScreenBag1$2
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    NaviScreenBag1$2(NaviScreenFactory naviScreenFactory, int n) {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(3);
                axisConstraints.alignment = new int[]{5, 9, 9};
                axisConstraints.shrink = new float[]{0.0f, 1.0f, 1.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(1);
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints2}, new Object[]{abstractWidgetController2});
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(1);
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4}, new Object[]{abstractWidgetController3});
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 1);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints4.alignment = new int[]{8, 1, 8, 1};
                menuItemColumnsConstraints4.gaps = new int[]{0, 15, 17, 15, 0};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(3, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController4, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 2);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3, gridLayoutHints5, gridLayoutHints10}, new Object[]{abstractWidgetController, gridLayout2, gridLayout3, gridLayout4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(3);
                axisConstraints.alignment = new int[]{5, 9, 9};
                axisConstraints.shrink = new float[]{0.0f, 1.0f, 1.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(1);
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController8 = this.createCell(1);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints11}, new Object[]{abstractWidgetController8});
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 0);
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(1);
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController9 = this.createCell(2);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints13}, new Object[]{abstractWidgetController9});
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 1);
                GridLayout gridLayout7 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints7 = new MenuItemColumnsConstraints(7);
                menuItemColumnsConstraints7.alignment = new int[]{8, 1, 8, 1, 8, 8, 8};
                menuItemColumnsConstraints7.gaps = new int[]{0, 15, 17, 15, 17, 15, 8, 0};
                menuItemColumnsConstraints7.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f};
                gridLayout7.setColumnConstraints(menuItemColumnsConstraints7);
                AxisConstraints axisConstraints7 = new AxisConstraints(1);
                axisConstraints7.alignment = new int[]{5};
                gridLayout7.setRowConstraints(axisConstraints7);
                AbstractWidgetController abstractWidgetController10 = this.createCell(3);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(4);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController12 = this.createCell(5);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(6);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController14 = this.createCell(7);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(4, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(8);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(5, 0);
                AbstractWidgetController abstractWidgetController16 = this.createCell(9);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(6, 0);
                gridLayout7.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints17, gridLayoutHints18, gridLayoutHints19, gridLayoutHints20, gridLayoutHints21}, new Object[]{abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 2);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints12, gridLayoutHints14, gridLayoutHints22}, new Object[]{abstractWidgetController, gridLayout5, gridLayout6, gridLayout7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController16);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(3);
                axisConstraints.alignment = new int[]{5, 9, 9};
                axisConstraints.shrink = new float[]{0.0f, 1.0f, 1.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayout gridLayout8 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints8 = new MenuItemColumnsConstraints(1);
                gridLayout8.setColumnConstraints(menuItemColumnsConstraints8);
                AxisConstraints axisConstraints8 = new AxisConstraints(1);
                gridLayout8.setRowConstraints(axisConstraints8);
                AbstractWidgetController abstractWidgetController17 = this.createCell(1);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(0, 0);
                gridLayout8.setCellConstraints(new GridLayoutHints[]{gridLayoutHints23}, new Object[]{abstractWidgetController17});
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 0);
                GridLayout gridLayout9 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints9 = new MenuItemColumnsConstraints(1);
                gridLayout9.setColumnConstraints(menuItemColumnsConstraints9);
                AxisConstraints axisConstraints9 = new AxisConstraints(1);
                gridLayout9.setRowConstraints(axisConstraints9);
                AbstractWidgetController abstractWidgetController18 = this.createCell(2);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(0, 0);
                gridLayout9.setCellConstraints(new GridLayoutHints[]{gridLayoutHints25}, new Object[]{abstractWidgetController18});
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 1);
                GridLayout gridLayout10 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints10 = new MenuItemColumnsConstraints(6);
                menuItemColumnsConstraints10.alignment = new int[]{8, 1, 8, 1, 8, 8};
                menuItemColumnsConstraints10.gaps = new int[]{0, 15, 17, 15, 17, 15, 0};
                menuItemColumnsConstraints10.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f};
                gridLayout10.setColumnConstraints(menuItemColumnsConstraints10);
                AxisConstraints axisConstraints10 = new AxisConstraints(1);
                axisConstraints10.alignment = new int[]{5};
                gridLayout10.setRowConstraints(axisConstraints10);
                AbstractWidgetController abstractWidgetController19 = this.createCell(3);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController20 = this.createCell(4);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController21 = this.createCell(5);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController22 = this.createCell(6);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController23 = this.createCell(7);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(4, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(10);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(5, 0);
                gridLayout10.setCellConstraints(new GridLayoutHints[]{gridLayoutHints27, gridLayoutHints28, gridLayoutHints29, gridLayoutHints30, gridLayoutHints31, gridLayoutHints32}, new Object[]{abstractWidgetController19, abstractWidgetController20, abstractWidgetController21, abstractWidgetController22, abstractWidgetController23, abstractWidgetController24});
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(1, 2);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints24, gridLayoutHints26, gridLayoutHints33}, new Object[]{abstractWidgetController, gridLayout8, gridLayout9, gridLayout10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController24);
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
                iconController.setBitmaps(new int[]{127, 52168192});
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
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                labelController.setTextOrientationHints(new int[]{6});
                return labelController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349});
                iconController.setModelColumn(6);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(7);
                return labelController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 68945408});
                iconController.setModelColumn(4);
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
                labelController.setDateFormatMode(1);
                labelController.setModelColumn(5);
                return labelController;
            }
            case 7: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 203163136, 219940352, 236717568, 219940352});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-718862848});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(9);
                return labelController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-702085632});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                return labelController;
            }
        }
        return null;
    }
}

