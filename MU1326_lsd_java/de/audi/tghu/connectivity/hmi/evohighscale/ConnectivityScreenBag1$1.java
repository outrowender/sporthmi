/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CheckboxRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.FormfieldInputRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CheckboxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FormfieldInputController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class ConnectivityScreenBag1$1
implements ListItemFactory {
    ConnectivityScreenBag1$1() {
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
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, 260};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, 1, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.shrink = new float[]{0.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 0;
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints2.gaps = new int[]{11, 11};
                menuItemColumnsConstraints2.grow = new float[]{1.0f};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                gridLayoutHints4.alignmentHoriz = 8;
                gridLayoutHints4.alignmentVert = 9;
                gridLayoutHints4.setIgnoreForCellSizes(true);
                gridLayoutHints4.overlapGaps = 15;
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController3, abstractWidgetController4});
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, gridLayout2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1, 260};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, 1, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.shrink = new float[]{0.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(4);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController5 = this.createCell(1);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                gridLayoutHints6.hidemode = 0;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints3.gaps = new int[]{11, 11};
                menuItemColumnsConstraints3.grow = new float[]{1.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController6 = this.createCell(2);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(3);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(0, 0);
                gridLayoutHints8.alignmentHoriz = 8;
                gridLayoutHints8.alignmentVert = 9;
                gridLayoutHints8.setIgnoreForCellSizes(true);
                gridLayoutHints8.overlapGaps = 15;
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints7, gridLayoutHints8}, new Object[]{abstractWidgetController6, abstractWidgetController7});
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6, gridLayoutHints9}, new Object[]{abstractWidgetController, abstractWidgetController5, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 15, 12, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{45, -1, -1, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.shrink = new float[]{0.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(1, 0);
                gridLayoutHints.alignmentVert = 5;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController8 = this.createCell(6);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(7);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(8);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(4, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12}, new Object[]{abstractWidgetController, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController9);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{45, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(9);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(1, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController11 = this.createCell(10);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(2, 0);
                gridLayoutHints13.alignmentVert = 5;
                gridLayoutHints13.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints13}, new Object[]{abstractWidgetController, abstractWidgetController11});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController11);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(7);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 15, 5, 5, 12, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{45, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.gaps = new int[]{0, 0};
                axisConstraints.grow = new float[]{0.0f};
                axisConstraints.max = new int[]{-1};
                axisConstraints.min = new int[]{-1};
                axisConstraints.shrink = new float[]{0.0f};
                axisConstraints.size = new int[]{-1};
                axisConstraints.hidemode = new int[]{0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(1, 0);
                gridLayoutHints.alignmentVert = 5;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController12 = this.createCell(6);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 0);
                gridLayoutHints14.hidemode = 0;
                AbstractWidgetController abstractWidgetController13 = this.createCell(11);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(3, 0);
                gridLayoutHints15.hidemode = 0;
                AbstractWidgetController abstractWidgetController14 = this.createCell(12);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(4, 0);
                gridLayoutHints16.hidemode = 0;
                AbstractWidgetController abstractWidgetController15 = this.createCell(7);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(5, 0);
                gridLayoutHints17.hidemode = 0;
                AbstractWidgetController abstractWidgetController16 = this.createCell(8);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(6, 0);
                gridLayoutHints18.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints14, gridLayoutHints15, gridLayoutHints16, gridLayoutHints17, gridLayoutHints18}, new Object[]{abstractWidgetController, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController14);
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
                iconController.setBitmaps(new int[]{-1457183232});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1227302400, 1244079616, 1260856832, 1277634048, 1294411264, -400022016, -383244800, 1294542336});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                labelRendererHigh.setAlignment(3, 4);
                return labelController;
            }
            case 3: {
                FormfieldInputController formfieldInputController = new FormfieldInputController();
                FormfieldInputRendererHigh formfieldInputRendererHigh = new FormfieldInputRendererHigh(formfieldInputController);
                formfieldInputController.setRenderer(formfieldInputRendererHigh);
                formfieldInputController.setBounds(0, 0, 100, 100);
                formfieldInputController.setColorIndices(new int[]{2, 0, 4, 0});
                return formfieldInputController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-1440406016});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{-1608178176, -1591400960, -1574623744, -1574623744, -1574623744, -1591400960});
                iconController.setModelColumn(5);
                iconController.setPreferredHeight(1);
                iconController.setProcessStateChange(2);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 7: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -1423628800});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconController.setProcessStateChange(2);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 8: {
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setModelColumn(7);
                return checkboxController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1311188480});
                return labelController;
            }
            case 10: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 11: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{2049517056});
                return labelController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1932076544, 1948853760, 1965630976, 1982408192});
                labelController.setModelColumn(9);
                return labelController;
            }
        }
        return null;
    }
}

