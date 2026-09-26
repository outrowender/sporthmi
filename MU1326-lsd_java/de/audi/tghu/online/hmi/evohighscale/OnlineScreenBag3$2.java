/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class OnlineScreenBag3$2
implements ListItemFactory {
    OnlineScreenBag3$2() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints2.gaps = new int[]{0, 0};
                menuItemColumnsConstraints2.grow = new float[]{1.0f};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints3.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints3.grow = new float[]{1.0f, 1.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController2, abstractWidgetController3});
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(0, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints2, gridLayoutHints5}, new Object[]{gridLayout2, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController3);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.gaps = new int[]{0, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints4.alignment = new int[]{8, 2};
                menuItemColumnsConstraints4.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints4.grow = new float[]{1.0f, 0.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6}, new Object[]{abstractWidgetController, abstractWidgetController4});
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 0);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints5.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints5.grow = new float[]{1.0f, 1.0f};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController5 = this.createCell(1);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(2);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(1, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController5, abstractWidgetController6});
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(0, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints7, gridLayoutHints10}, new Object[]{gridLayout4, gridLayout5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController6);
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
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setDateFormatMode(0);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setDateFormatMode(1);
                labelController.setModelColumn(3);
                labelRendererHigh.setAlignment(3, 4);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(5);
                return labelController;
            }
        }
        return null;
    }
}

