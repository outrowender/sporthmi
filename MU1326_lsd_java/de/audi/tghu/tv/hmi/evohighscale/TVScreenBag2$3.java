/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

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

final class TVScreenBag2$3
implements ListItemFactory {
    TVScreenBag2$3() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 15, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, 30, 30, 30};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
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
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1504716544, 1521493760, 1538270976, 1555048192, 1571825408, 1588602624, 1605379840, 1622157056, 1638934272, 1655711488, 1672488704, 1689265920, 1706043136, 1722820352, 1739597568, 1756374784, 1773152000, 1789929216, 1806706432, 1823483648, 1840260864, 1857038080, 1907369728, 1924146944, 1940924160, 1957701376, 1974478592, 1991255808, 2008033024, 2024810240, 2041587456, 2058364672, 2075141888, 2091919104, 2108696320, 2125473536, 2142250752, -2135939328, -2119162112, -2102384896, -2085607680, -2068830464, -2052053248, -2035276032, -2018498816, -2001721600, -1984944384, -1968167168, -1951389952, -1934612736, -1917835520, -1901058304, -1884281088, -1867503872, -1850726656, -1833949440, -1817172224, -1800395008, -1783617792, -1766840576, 1957701376, -1783617792, -1716508928, -1699731712, -1682954496, -1666177280, -1649400064, -1632622848, -1615845632, -1599068416, -1582291200, -1565513984, -1548736768, -1531959552, -1515182336, -1498405120, -1481627904, -1464850688, -1448073472, -1431296256, -1414519040, -1397741824, -1380964608, -1364187392, -1347410176, 2008033024, -1313855744, -1297078528, -1280301312, -1263524096, -1246746880, -1229969664, -1213192448, -1196415232, -1179638016, -1162860800, -1146083584, -1129306368, -1112529152, -1095751936, -1078974720, -1062197504, -1045420288, -1028643072, -1011865856, -995088640, -978311424, -961534208, -944756992, -927979776, -911202560, -894425344, -877648128, -860870912, -844093696, -827316480, -810539264, -793762048, -776984832, -760207616, -743430400, -726653184, -709875968, -693098752, -676321536, -659544320, -642767104, -625989888, -609212672, -592435456, -575658240, -558881024, -542103808, -525326592, -508549376, -491772160, -474994944, -458217728, -441440512, 1890592512, 263137024, 1873815296, -340908288});
                labelController.setModelColumn(1);
                return labelController;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 1202464512, 1219241728, 1219241728, 1236018944, 1219241728, 1219241728, 1252796160, 1269573376, 127, 127, 127, 127, 127, 127, 127});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127, 1487677184, 1504454400});
                iconController.setModelColumn(3);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                RadioButtonController radioButtonController = new RadioButtonController();
                RadioButtonRendererHigh radioButtonRendererHigh = new RadioButtonRendererHigh(radioButtonController);
                radioButtonController.setRenderer(radioButtonRendererHigh);
                radioButtonController.setBounds(0, 0, 100, 100);
                radioButtonController.setModelColumn(4);
                return radioButtonController;
            }
        }
        return null;
    }
}

