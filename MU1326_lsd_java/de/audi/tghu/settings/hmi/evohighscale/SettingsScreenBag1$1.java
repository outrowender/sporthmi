/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RadioButtonRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.RadioButtonController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class SettingsScreenBag1$1
implements ListItemFactory {
    SettingsScreenBag1$1() {
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
                menuItemColumnsConstraints.max = new int[]{30, -1, 33};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.alignmentVert = 5;
                gridLayoutHints2.hidemode = 0;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController2);
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
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-3665920, 13176832, 29954048, 46731264, 63508480, 80285696, 97062912, 113840128, 583602176, 130617344, 147394560, 466161664, 164171776, 130617344, 180948992, 130617344, 197726208, 130617344, 214503424, 231280640, 248057856, 264835072, 600379392, 180948992, 633933824, 130617344, 583602176, 432607232, 449384448, 701042688, 717819904, 734597120, 751374336, 768151552, 784928768, 801705984});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{281677824, 298455040, 315232256, 332009472, 348786688, 365563904, 382341120, 399118336, 298455040, 298455040, 315232256, 332009472, 483004416, 298455040, 516558848, 298455040, 550113280, 298455040, 583667712, 600444928, 617222144, 633999360, 650776576, 667553792, 684331008, 298455040, 717885440, 751570944, 768348160, 13504512, -1228009472, -1211232256, -1194455040, -1177677824, -1160900608, -1144123392, -1127346176, -1127346176, -1127346176, -1127346176, 298455040});
                labelController.setModelColumn(0);
                labelRendererHigh.setAlignment(1, 5);
                return labelController;
            }
            case 2: {
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

