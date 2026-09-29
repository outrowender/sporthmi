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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class NaviScreenBag2$4
implements ListItemFactory {
    private final /* synthetic */ NaviScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    NaviScreenBag2$4(NaviScreenFactory naviScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.alignment = new int[]{1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.alignment = new int[]{1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController3 = this.createCell(1);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 1);
                gridLayoutHints3.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
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
                labelController.setModelColumn(2);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                return labelController;
            }
        }
        return null;
    }
}

