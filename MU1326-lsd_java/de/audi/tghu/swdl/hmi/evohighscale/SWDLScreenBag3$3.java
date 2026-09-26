/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class SWDLScreenBag3$3
implements ListItemFactory {
    SWDLScreenBag3$3() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
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
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(3);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(4);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController, abstractWidgetController3, abstractWidgetController4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints6}, new Object[]{abstractWidgetController, abstractWidgetController5, abstractWidgetController6});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
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
                labelController.setColorIndices(new int[]{1, 6, 6, 0});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1777801472});
                labelController.setColorIndices(new int[]{1, 6, 6, 0});
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 4: {
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setModelColumn(4);
                return checkboxController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                return iconController;
            }
        }
        return null;
    }
}

