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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SelectionCursorRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SelectionCursorController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class NaviScreenBag1$1
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    NaviScreenBag1$1(NaviScreenFactory naviScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(3);
                axisConstraints.alignment = new int[]{9, 9, 5};
                axisConstraints.max = new int[]{145, -1, -1};
                axisConstraints.min = new int[]{145, -1, -1};
                axisConstraints.hidemode = new int[]{2, 0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.visibleConditions = -13;
                gridLayoutHints.afterEffects = new int[]{-22, -10, 0, 0};
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.visibleConditions = -4;
                gridLayoutHints2.afterEffects = new int[]{-16, -16, 0, 0};
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                gridLayoutHints3.columnSpan = 3;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.alignment = new int[]{8, 8, 3};
                menuItemColumnsConstraints3.gaps = new int[]{8, 15, 12, 34};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(2);
                axisConstraints3.gaps = new int[]{13, 16, 13};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                gridLayoutHints4.alignmentVert = 5;
                gridLayoutHints4.rowSpan = 2;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(0, 0);
                gridLayoutHints5.alignmentHoriz = 8;
                gridLayoutHints5.alignmentVert = 9;
                gridLayoutHints5.columnSpan = 3;
                gridLayoutHints5.rowSpan = 2;
                gridLayoutHints5.setIgnoreForCellSizes(true);
                gridLayoutHints5.overlapGaps = 15;
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 1);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8});
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(0, 1);
                gridLayoutHints10.alignmentVert = 5;
                gridLayoutHints10.columnSpan = 3;
                gridLayoutHints10.afterEffects = new int[]{-8, 0, 42, 0};
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 2);
                gridLayoutHints11.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 2);
                gridLayoutHints12.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12}, new Object[]{gridLayout2, gridLayout3, abstractWidgetController9, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{9, 5};
                axisConstraints.size = new int[]{75, -1};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints4.alignment = new int[]{8, 8, 3};
                menuItemColumnsConstraints4.gaps = new int[]{8, 15, 12, 34};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(2);
                axisConstraints4.gaps = new int[]{13, 16, 13};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                gridLayoutHints.rowSpan = 2;
                AbstractWidgetController abstractWidgetController11 = this.createCell(3);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 0);
                gridLayoutHints13.alignmentHoriz = 8;
                gridLayoutHints13.alignmentVert = 9;
                gridLayoutHints13.columnSpan = 3;
                gridLayoutHints13.rowSpan = 2;
                gridLayoutHints13.setIgnoreForCellSizes(true);
                gridLayoutHints13.overlapGaps = 15;
                AbstractWidgetController abstractWidgetController12 = this.createCell(4);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(5);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController14 = this.createCell(6);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController15 = this.createCell(7);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 1);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints13, gridLayoutHints14, gridLayoutHints15, gridLayoutHints16, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15});
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(0, 0);
                gridLayoutHints18.alignmentVert = 5;
                gridLayoutHints18.columnSpan = 3;
                gridLayoutHints18.afterEffects = new int[]{-8, 0, 42, 0};
                AbstractWidgetController abstractWidgetController16 = this.createCell(8);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(0, 1);
                gridLayoutHints19.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController17 = this.createCell(9);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(1, 1);
                gridLayoutHints20.columnSpan = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints18, gridLayoutHints19, gridLayoutHints20}, new Object[]{gridLayout4, abstractWidgetController16, abstractWidgetController17});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController16);
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
                iconController.setBitmaps(new int[]{-316996096});
                return iconController;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                return iconController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-585431552, -568654336});
                iconController.setModelColumn(0);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                SelectionCursorController selectionCursorController = new SelectionCursorController();
                SelectionCursorRendererHigh selectionCursorRendererHigh = new SelectionCursorRendererHigh(selectionCursorController);
                selectionCursorController.setRenderer(selectionCursorRendererHigh);
                selectionCursorController.setBounds(0, 0, 100, 100);
                selectionCursorController.setColorIndices(new int[]{1, 2, 4, 0});
                selectionCursorController.setSeparatorPosition(74);
                selectionCursorController.setSeparatorVisible(true);
                selectionCursorRendererHigh.setBackgroundMode(1);
                return selectionCursorController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(4);
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setDateFormatMode(1);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 8: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-551877120});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setTextIds(new int[]{136447488, -350091776});
                labelController.setModelColumn(6);
                return labelController;
            }
        }
        return null;
    }
}

