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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

class SWDLScreenFactory$1
implements ListItemFactory {
    private final /* synthetic */ SWDLScreenFactory this$0;

    SWDLScreenFactory$1(SWDLScreenFactory sWDLScreenFactory) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentHoriz = 1;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayoutHints3.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                gridLayoutHints4.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                gridLayoutHints5.alignmentHoriz = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController3);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0, 0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 1, 1, 1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentHoriz = 1;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController6 = this.createCell(1);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                gridLayoutHints6.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController7 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 0);
                gridLayoutHints7.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController8 = this.createCell(3);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(3, 0);
                gridLayoutHints8.alignmentHoriz = 3;
                AbstractWidgetController abstractWidgetController9 = this.createCell(4);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(4, 0);
                gridLayoutHints9.alignmentHoriz = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9}, new Object[]{abstractWidgetController, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 5, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentHoriz = 1;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController10 = this.createCell(4);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                gridLayoutHints10.alignmentHoriz = 3;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController10);
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
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{32643328});
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{82974976, 99752192, 116529408, 133306624, 150083840, 166861056, 183638272, 200415488, -671737600, -654960384, -638183168, -621405952, -604628736, -587851520, 217192704, -571074304});
                labelController.setModelColumn(4);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{49420544});
                return labelController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                return iconController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1342826240, -1326049024, 233969920, 250747136, 267524352, 284301568});
                labelController.setModelColumn(4);
                return labelController;
            }
        }
        return null;
    }
}

