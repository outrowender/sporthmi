/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class MediaScreenBag2$2
implements ListItemFactory {
    MediaScreenBag2$2() {
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
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 0;
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
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                gridLayoutHints5.hidemode = 0;
                AbstractWidgetController abstractWidgetController6 = this.createCell(2);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(3);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController8 = this.createCell(5);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                gridLayoutHints8.hidemode = 0;
                AbstractWidgetController abstractWidgetController9 = this.createCell(2);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(3);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController10);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(6);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController11 = this.createCell(7);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(1, 0);
                gridLayoutHints11.hidemode = 0;
                AbstractWidgetController abstractWidgetController12 = this.createCell(2);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13}, new Object[]{abstractWidgetController, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController13);
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
                iconController.setBitmaps(new int[]{1477247744, 1024328448, 1494024960, 1510802176, 1527579392, 1544356608, 1561133824, 1577911040, 1594688256, 0x3E0E0300, 1611465472, 1628242688, 1645019904, 1661797120, 1678574336, 1695351552, 1712128768, 1728905984, 1745683200, 1762460416, 1779237632, 1796014848, -1173552384, -1173552384, -1173552384, 1846346496, 1863123712, -1156775168, -1156775168, -1156775168, 1846346496, 1863123712, 1796014848, -1207106816, -1190329600, 1997341440, 1796014848, 2014118656, 2030895872, 2030895872, 2047673088, 2064450304, -1139997952, -1123220736, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1024328448, 1494024960, 1510802176, 1527579392, 1544356608, 1561133824, 1577911040, 1594688256, 0x3E0E0300, 1611465472, 1628242688, 1645019904, 1661797120, 1678574336, 1695351552, 1712128768, 1728905984, 1745683200, 1762460416, 1779237632, 1796014848, -1173552384, -1173552384, -1173552384, 1846346496, 1863123712, -1156775168, -1156775168, -1156775168, 1846346496, 1863123712, 1796014848, -1207106816, -1190329600, 1997341440, 1796014848, 2014118656, 2030895872, 2030895872, 2047673088, 2064450304, -1139997952, -1123220736, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744});
                iconController.setDefaultImageMode(1);
                iconController.setModelColumn(4);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1158873856, 756155136, 756155136, -1827536128, -1827536128, 772932352, 789709568, 806486784, 823264000, 840041216, -1793981696, 856818432, -1777204480, -1760427264, 723518208, -1743650048, -1726872832, -1710095616, -1340996864, -1324219648, -1693318400, -1777204480, 656016128, 1158873856, -1659763968, -1944911104, -887749888, -1777204480, 656016128, -1743650048, 269943552, -1743650048, -1743650048, -417398016});
                labelController.setModelColumn(1);
                return labelController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1477247744, 1091437312, -217251072, -200473856, -183696640, -166919424, -150142208, -133364992, -116587776, 1108214528, -99810560, -83033344, -66256128, -49478912, -32701696, -15924480, 918272, 17695488, 34472704, 0x30E0300, 68027136, 84804352, 101581568, 101581568, 101581568, 151913216, 168690432, 185467648, 185467648, 185467648, 0xE0E0300, 168690432, 269353728, 286130944, 302908160, 319685376, 269353728, 336462592, 353239808, 353239808, -267582720, -250805504, -1139997952, 386794240, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, -234028288, 1091437312, -217251072, -200473856, -183696640, -166919424, -150142208, -133364992, -116587776, 1108214528, -99810560, -83033344, -66256128, -49478912, -32701696, -15924480, 918272, 17695488, 34472704, 0x30E0300, 68027136, 84804352, 101581568, 101581568, 101581568, 151913216, 168690432, 185467648, 185467648, 185467648, 0xE0E0300, 168690432, 269353728, 286130944, 302908160, 319685376, 269353728, 336462592, 353239808, 353239808, -267582720, -250805504, -1139997952, 386794240, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744, 1477247744});
                iconController.setDefaultImageMode(1);
                iconController.setModelColumn(6);
                return iconController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{240, -1626537216, -1626537216, -1106443520, -1089666304, -1072889088, -1056111872, -1039334656, -1022557440, -1341324544, -1341324544, -1005780224, -989003008, -972225792, -955448576, -938671360, -921894144, -1307770112, -905116928, -888339712, -1324547328, -1592982784, -871562496, -871562496, -871562496, -821230848, -821230848, -787676416, -787676416, -787676416, -821230848, -821230848, -1609760000, -703790336, -687013120, -1576205568, -1576205568, -653458688, -1290992896, -1290992896, -636681472, -619904256, -1139997952, -586349824, 240, 240, 240, 240, 240, 240});
                iconController.setDefaultImageMode(1);
                iconController.setModelColumn(4);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{873595648, 1225982720, 890372864, 907150080, 923927296, 940704512, 1259537152, 1477640960, 1309868800, -1273888000, 957481728, 1494418176, 1360200448, 974258944, 991036160, 1007813376, 1024590592, 1041367808, 1058145024, 1074922240, 437715712});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 6: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1477247744, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736, -1123220736});
                iconController.setModelColumn(4);
                return iconController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
        }
        return null;
    }
}

