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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class MediaScreenBag3$2
implements ListItemFactory {
    MediaScreenBag3$2() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3});
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
        AbstractWidgetController abstractWidgetController = this.createCell(3);
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
                labelController.setTextIds(new int[]{554959616, 571736832, 588514048, 605291264, 622068480, 638845696, 655622912, 672400128, 689177344, 705954560, 722731776, 739508992, 756286208, 773063424, 789840640, 806617856, 823395072, 840172288, 856949504, 873726720, 890503936, 907281152, 924058368, 940835584, 957612800, 974390016, 991167232, 1007944448, 1024721664, 1041498880, 1058276096, 1075053312, 1091830528, 1108607744, 1125384960, 1142162176, 1158939392, 1175716608, 1192493824, 1209271040, 1226048256, 1242825472, 1259602688, 1276379904, 1293157120, 1309934336, 1326711552, 1343488768, 1360265984, 1377043200, 1393820416, 1410597632, 1427374848, 1444152064, 1460929280, 1477706496, 1494483712, 1511260928, 1528038144, 1544815360, 974390016, 1528038144, 1595147008, 1611924224, 1628701440, 1645478656, 1662255872, 1679033088, 1695810304, 1712587520, 1729364736, 1746141952, 1762919168, 1779696384, 1796473600, 1813250816, 1830028032, 1846805248, 1863582464, 1880359680, 1897136896, 1913914112, 1930691328, 1947468544, 1964245760, 1024721664, 1997800192, 2014577408, 2031354624, 2048131840, 2064909056, 2081686272, 2098463488, 2115240704, 2132017920, -2146172160, -2129394944, -2112617728, -2095840512, -2079063296, -2062286080, -2045508864, -2028731648, -2011954432, -1995177216, -1978400000, -1961622784, -1944845568, -1928068352, -1911291136, -1894513920, -1877736704, -1860959488, -1844182272, -1827405056, -1810627840, -1793850624, -1777073408, -1760296192, -1743518976, -1726741760, -1709964544, -1693187328, -1676410112, -1659632896, -1642855680, -1626078464, -1609301248, -1592524032, -1575746816, -1558969600, -1542192384, -1525415168, -1508637952, -1491860736, -1475083520, -1458306304, -1441529088, -1424751872, -1407974656, -1391197440, -1374420224, -1357643008, -1340865792});
                labelController.setModelColumn(0);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 2: {
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setModelColumn(2);
                return checkboxController;
            }
            case 3: {
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

