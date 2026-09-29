/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;
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

class SWDLScreenFactory$4
implements ListItemFactory {
    private final /* synthetic */ SWDLScreenFactory this$0;

    SWDLScreenFactory$4(SWDLScreenFactory sWDLScreenFactory) {
        this.this$0 = sWDLScreenFactory;
    }

    @Override
    public AbstractWidgetController createListItem(int n, ListCell[] listCellArray) {
        switch (n) {
            case 0: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(6);
                menuItemColumnsConstraints.alignment = new int[]{8, 1, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 0, 0, 0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1, 1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentHoriz = 1;
                gridLayoutHints.hidemode = 0;
                gridLayoutHints.columnSpan = 5;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(5, 0);
                gridLayoutHints2.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 1);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(2, 1);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(3, 1);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(4, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController5);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(10);
                menuItemColumnsConstraints.gaps = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.columnSpan = 6;
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(6, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(7, 0);
                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(8, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(10);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(9, 0);
                AbstractWidgetController abstractWidgetController12 = this.createCell(2);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(0, 1);
                gridLayoutHints12.hidemode = 2;
                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController14 = this.createCell(4);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 1);
                AbstractWidgetController abstractWidgetController15 = this.createCell(5);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(3, 1);
                AbstractWidgetController abstractWidgetController16 = this.createCell(6);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(4, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14, gridLayoutHints15, gridLayoutHints16}, new Object[]{abstractWidgetController, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController9);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController17 = this.createCell(3);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController17});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController17);
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
                labelController.setModelColumn(1);
                return labelController;
            }
            case 1: {
                CheckboxController checkboxController = new CheckboxController();
                CheckboxRendererHigh checkboxRendererHigh = new CheckboxRendererHigh(checkboxController);
                checkboxController.setRenderer(checkboxRendererHigh);
                checkboxController.setBounds(0, 0, 100, 100);
                checkboxController.setColorIndices(new int[]{1, 0, 4, 0, 2, 3});
                checkboxController.setModelColumn(7);
                return checkboxController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-976640});
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
                labelController.setTextIds(new int[]{317856000});
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(6);
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{15866112});
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{32643328});
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1342826240, -1326049024, 233969920, 250747136, 267524352, 284301568});
                labelController.setModelColumn(8);
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{167254272});
                return labelController;
            }
            case 10: {
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

