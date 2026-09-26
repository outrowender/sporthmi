/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RadioButtonRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class TVScreenBag2$2
implements ListItemFactory {
    TVScreenBag2$2() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 0};
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
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
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
                labelController.setTextIds(new int[]{-340973824, -324196608, -307419392, -290642176, -273864960, -257087744, -240310528, -223533312, -206756096, -189978880, -173201664, -156424448, -139647232, -122870016, -106092800, -89315584, -72538368, -55761152, -38983936, -22206720, -5429504, 11413248, 28190464, 44967680, 61744896, -441637120, -424859904, -408082688, -391305472, -374528256, -357751040, -659740928, -424663296, -827185408, -407886080, -391108864, -374331648, -357554432, -340777216, -324000000, -307222784, -290445568, -256891136, -240113920, -223336704, -206559488, -273668352});
                labelController.setModelColumn(0);
                return labelController;
            }
            case 1: {
                RadioButtonController radioButtonController = new RadioButtonController();
                RadioButtonRendererHigh radioButtonRendererHigh = new RadioButtonRendererHigh(radioButtonController);
                radioButtonController.setRenderer(radioButtonRendererHigh);
                radioButtonController.setBounds(0, 0, 100, 100);
                radioButtonController.setModelColumn(1);
                return radioButtonController;
            }
        }
        return null;
    }
}

