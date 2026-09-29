/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiLineLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class InfoScreenBag1$1
implements ListItemFactory {
    InfoScreenBag1$1() {
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        switch (n) {
            case 0: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 10, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.max = new int[]{84, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{60, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0, 2};
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
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{60, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints2.alignment = new int[]{8, 3};
                menuItemColumnsConstraints2.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints2.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints2.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController6 = this.createCell(6);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(4);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController6, abstractWidgetController7});
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(0, 1);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(1);
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(0, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints10}, new Object[]{abstractWidgetController8});
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9, gridLayoutHints11}, new Object[]{abstractWidgetController, gridLayout2, abstractWidgetController, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{60, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(6);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(4);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints12, gridLayoutHints13}, new Object[]{abstractWidgetController, abstractWidgetController9, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{60, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(8);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                gridLayoutHints14.widthMax = 40;
                gridLayoutHints14.widthMin = 40;
                gridLayoutHints14.afterEffects = new int[]{0, -2, 0, 0};
                AbstractWidgetController abstractWidgetController12 = this.createCell(9);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints14, gridLayoutHints15}, new Object[]{abstractWidgetController, abstractWidgetController11, abstractWidgetController12});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 15, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{60, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(10);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 0);
                gridLayoutHints16.heightMin = -1;
                gridLayoutHints16.widthMax = 40;
                gridLayoutHints16.widthMin = 40;
                AbstractWidgetController abstractWidgetController14 = this.createCell(11);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints16, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController13, abstractWidgetController14});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{60, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(12);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController16 = this.createCell(11);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints18, gridLayoutHints19}, new Object[]{abstractWidgetController, abstractWidgetController15, abstractWidgetController16});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController);
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
                iconLabelController.setModelColumn(1);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 547424000, 564201216, 580978432});
                iconController.setModelColumn(4);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 614532864});
                iconController.setModelColumn(13);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setModelColumn(5);
                multiLineLabelRendererHigh.setAutoWrap(0);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setModelColumn(6);
                multiLineLabelRendererHigh.setAutoWrap(0);
                return labelController;
            }
            case 8: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(7);
                iconLabelController.setPreferredHeight(18);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                MultiLineLabelRendererHigh multiLineLabelRendererHigh = new MultiLineLabelRendererHigh(labelController);
                labelController.setRenderer(multiLineLabelRendererHigh);
                labelController.setModelColumn(8);
                multiLineLabelRendererHigh.setAutoWrap(0);
                return labelController;
            }
            case 10: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349});
                iconController.setModelColumn(9);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 11: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(10);
                return labelController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{748750592});
                return labelController;
            }
        }
        return null;
    }
}

