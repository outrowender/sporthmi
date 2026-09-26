/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class NaviScreenBag4$1
implements ListItemFactory {
    NaviScreenBag4$1() {
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        switch (n) {
            case 0: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 1, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 0, 10, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{60, 60, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
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
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(0);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 1: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(1);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setTextIds(new int[]{1310656000, 1327433216, 1344210432, 1360987648});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setTextIds(new int[]{1411319296, 1428096512});
                labelController.setModelColumn(3);
                return labelController;
            }
        }
        return null;
    }
}

