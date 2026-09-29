/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class MediaScreenBag3$1
implements ListItemFactory {
    MediaScreenBag3$1() {
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
                menuItemColumnsConstraints.alignment = new int[]{8, 1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, 0, 74, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentHoriz = 8;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayoutHints3.alignmentHoriz = 2;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                gridLayoutHints4.alignmentHoriz = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController3);
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
        menuItemColumnsConstraints.gaps = new int[]{0, 0};
        menuItemColumnsConstraints.grow = new float[]{0.0f};
        menuItemColumnsConstraints.min = new int[]{32};
        menuItemColumnsConstraints.shrink = new float[]{0.0f};
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        AxisConstraints axisConstraints = new AxisConstraints(1);
        axisConstraints.gaps = new int[]{0, 0};
        gridLayout.setRowConstraints(axisConstraints);
        AbstractWidgetController abstractWidgetController = this.createCell(4);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.hidemode = 0;
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
        menuItemController.add(abstractWidgetController);
        return menuItemController;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1642528000, -65535232, -1625750784, -1608973568, -1592196352, -1441201408, -1424424192, -1407646976, -1390869760, -1374092544, -1357315328, -1340538112, -1323760896, -1306983680, -1290206464, -1273429248, -1256652032, -1239874816, -1223097600, -1206320384, -1189543168, -1172765952, -1155988736, -1139211520, -1122434304, -1105657088, -1088879872, -1072102656, -1055325440, -1038548224, -1021771008, -1004993792, -988216576, -971439360, -954662144, -937884928, -1575419136, 639173376, -921107712, -904330496, -887553280, -870776064, -853998848, -837221632, -820444416, -803667200, -786889984, -770112768, -753335552, -736558336, -719781120, -703003904, -1558641920, 974717696, -686226688, -669449472, -652672256, -635895040, -619117824, -602340608, -1105657088, -619117824, -552008960, -535231744, -518454528, -501677312, -484900096, -468122880, -451345664, -1541864704, 1259930368, 1293484800, 1327039232, 1360593664, -434568448, -417791232, -401014016, -384236800, -367459584, -350682368, -333905152, -317127936, -300350720, -283573504, -266796288, -1055325440, -233241856, -216464640, -199687424, -182910208, -166132992, -149355776, -132578560, -115801344, -99024128, -82246912, -65469696, -48692480, -31915264, -15138048, 1704704, 18481920, 35259136, 52036352, -1525087488, -1978072320, 68813568, 85590784, 102368000, 119145216, 135922432, 152699648, 169476864, 186254080, 203031296, 219808512, 236585728, 253362944, 270140160, 286917376, 303694592, 320471808, 337249024, 354026240, 370803456, 387580672, 404357888, -1508310272, -1944517888, 421135104, 437912320, 454689536, 471466752, 488243968, 505021184, 521798400, 538575616, -1474755840, 1008272128, -1491533056, 689505024, 186188544, -1457978624, -15203584});
                labelController.setModelColumn(0);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1726217472, 1209664256, 1226441472, 1243218688, 1259995904, 1276773120, 1293550336});
                labelController.setModelColumn(1);
                return labelController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-351468800, -955383040, -1039269120, -1022491904, -1005714688, -1056046336, -988937472, -972160256});
                iconController.setModelColumn(2);
                return iconController;
            }
            case 3: {
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setModelColumn(3);
                return checkboxController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1592458496});
                return labelController;
            }
        }
        return null;
    }
}

