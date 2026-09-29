/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;
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

final class TunerScreenBag1$21
implements ListItemFactory {
    private final /* synthetic */ TunerScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    TunerScreenBag1$21(TunerScreenFactory tunerScreenFactory, int n) {
        this.val$factory = tunerScreenFactory;
        this.val$terminalID = n;
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
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{30, -1};
                menuItemColumnsConstraints.hidemode = new int[]{1, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints2.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints2.shrink = new float[]{1.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 2, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(2, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints2, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController2, abstractWidgetController3, abstractWidgetController4});
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.gaps = new int[]{0, 12, 12, 0};
                menuItemColumnsConstraints3.hidemode = new int[]{2, 2, 2};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.hidemode = new int[]{2};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(2, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints7, gridLayoutHints8}, new Object[]{abstractWidgetController5, abstractWidgetController6, abstractWidgetController7});
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(1, 1);
                gridLayoutHints9.visibleConditions = -11;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints9}, new Object[]{abstractWidgetController, gridLayout2, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController7);
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
                iconController.setBitmaps(new int[]{127, 981926144, 1149698304, 998703360, 1015480576, 1032257792});
                iconController.setModelColumn(4);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(5);
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(6);
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(7);
                return labelController;
            }
        }
        return null;
    }
}

