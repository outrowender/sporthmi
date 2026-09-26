/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

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

final class TunerScreenBag1$9
implements ListItemFactory {
    TunerScreenBag1$9() {
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
                menuItemColumnsConstraints.gaps = new int[]{0, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{abstractWidgetController, abstractWidgetController2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 22, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{92, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(0);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                gridLayoutHints3.hidemode = 0;
                AbstractWidgetController abstractWidgetController4 = this.createCell(1);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController, abstractWidgetController3, abstractWidgetController4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController4);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                gridLayout.setCellConstraints(new GridLayoutHints[0], new Object[0]);
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                gridLayout.setCellConstraints(new GridLayoutHints[0], new Object[0]);
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{3, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 22, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{92, 66, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(0);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(1);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{3, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 22, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{92, 66, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController8 = this.createCell(3);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(1);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController, abstractWidgetController8, abstractWidgetController9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                return menuItemController;
            }
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 22, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{92, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(0);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(1);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints10, gridLayoutHints11}, new Object[]{abstractWidgetController, abstractWidgetController10, abstractWidgetController11});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController11);
                return menuItemController;
            }
            case 7: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(4);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 8: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController12 = this.createCell(1);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints12}, new Object[]{abstractWidgetController, abstractWidgetController12});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController12);
                return menuItemController;
            }
            case 9: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{3, 1, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 22, 22, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 1.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{66, 92, -1, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(3);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(2);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController14 = this.createCell(0);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(1);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(3, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints13, gridLayoutHints14, gridLayoutHints15}, new Object[]{abstractWidgetController, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController15);
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
                labelController.setModelColumn(0);
                return labelController;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{333, -947519232, 127, 127, -930742016, -913964800, 127, -897187584, 127, 127, -880410368, -360316672, 25624832, 42402048, -863633152});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(5);
                return labelController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1215495936});
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setColorIndices(new int[]{1, 4, 4, 0});
                labelController.setModelColumn(0);
                return labelController;
            }
        }
        return null;
    }
}

