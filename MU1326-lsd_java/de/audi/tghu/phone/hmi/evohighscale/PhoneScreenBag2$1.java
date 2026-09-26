/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;
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

final class PhoneScreenBag2$1
implements ListItemFactory {
    private final /* synthetic */ PhoneScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    PhoneScreenBag2$1(PhoneScreenFactory phoneScreenFactory, int n) {
        this.val$factory = phoneScreenFactory;
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.min = new int[]{0};
                menuItemColumnsConstraints.hidemode = new int[]{2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 4;
                gridLayoutHints.hidemode = 0;
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints2.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{2, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                axisConstraints2.hidemode = new int[]{2};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
                gridLayoutHints2.hidemode = 2;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                gridLayoutHints3.hidemode = 2;
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController2, abstractWidgetController3});
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 1);
                gridLayoutHints4.hidemode = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints4}, new Object[]{abstractWidgetController, gridLayout2});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.hidemode = new int[]{2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.hidemode = new int[]{0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 4;
                gridLayoutHints.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                gridLayout.setCellConstraints(new GridLayoutHints[0], new Object[0]);
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                return menuItemController;
            }
            case 5: {
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
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.min = new int[]{0};
                menuItemColumnsConstraints.hidemode = new int[]{2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 4;
                gridLayoutHints.hidemode = 0;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints3.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints3.hidemode = new int[]{2, 2};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                axisConstraints3.hidemode = new int[]{2};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController4 = this.createCell(1);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(0, 0);
                gridLayoutHints5.hidemode = 2;
                AbstractWidgetController abstractWidgetController5 = this.createCell(2);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 0);
                gridLayoutHints6.hidemode = 2;
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints5, gridLayoutHints6}, new Object[]{abstractWidgetController4, abstractWidgetController5});
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 1);
                gridLayoutHints7.hidemode = 2;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints7}, new Object[]{abstractWidgetController, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController4);
                return menuItemController;
            }
            case 7: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.hidemode = new int[]{2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.hidemode = new int[]{0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 4;
                gridLayoutHints.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
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
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 1: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1016333312, 1033110528, 1049887744, 1066664960, 0x40940400, 1100219392, 461, 462, 463, 127, 1116996608, 1133773824});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                return labelController;
            }
        }
        return null;
    }
}

