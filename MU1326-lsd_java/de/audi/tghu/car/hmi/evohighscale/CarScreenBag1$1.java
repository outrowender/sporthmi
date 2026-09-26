/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class CarScreenBag1$1
implements ListItemFactory {
    private final /* synthetic */ CarScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    CarScreenBag1$1(CarScreenFactory carScreenFactory, int n) {
        this.val$factory = carScreenFactory;
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.alignment = new int[]{1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.gaps = new int[]{0, 0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints2.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints2.grow = new float[]{1.0f, 1.0f};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 1.0f};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                gridLayoutHints3.hidemode = 0;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints3.grow = new float[]{1.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4}, new Object[]{abstractWidgetController3});
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(0, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints5}, new Object[]{gridLayout2, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
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
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(2);
                return labelController;
            }
        }
        return null;
    }
}

