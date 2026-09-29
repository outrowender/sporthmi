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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class PhoneScreenBag1$8
implements ListItemFactory {
    private final /* synthetic */ PhoneScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    PhoneScreenBag1$8(PhoneScreenFactory phoneScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.alignmentHoriz = 1;
                gridLayoutHints2.hidemode = 0;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayoutHints3.hidemode = 0;
                gridLayoutHints3.visibleConditions = -13;
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints2.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints2.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{2, 0};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController4, abstractWidgetController5});
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(1, 1);
                gridLayoutHints6.hidemode = 0;
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 1);
                gridLayoutHints7.hidemode = 0;
                gridLayoutHints7.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints6, gridLayoutHints7}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, gridLayout2, abstractWidgetController6});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController4);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                gridLayoutHints8.hidemode = 0;
                AbstractWidgetController abstractWidgetController8 = this.createCell(2);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 0);
                gridLayoutHints9.hidemode = 0;
                gridLayoutHints9.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController9 = this.createCell(5);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(2, 1);
                gridLayoutHints10.hidemode = 0;
                gridLayoutHints10.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController10 = this.createCell(6);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(1, 0);
                gridLayoutHints11.hidemode = 0;
                AbstractWidgetController abstractWidgetController11 = this.createCell(2);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(2, 0);
                gridLayoutHints12.hidemode = 0;
                gridLayoutHints12.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController12 = this.createCell(3);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(1, 1);
                gridLayoutHints13.hidemode = 2;
                AbstractWidgetController abstractWidgetController13 = this.createCell(5);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 1);
                gridLayoutHints14.hidemode = 2;
                gridLayoutHints14.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14}, new Object[]{abstractWidgetController, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController12);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController14 = this.createCell(7);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(1, 0);
                gridLayoutHints15.hidemode = 0;
                AbstractWidgetController abstractWidgetController15 = this.createCell(2);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(2, 0);
                gridLayoutHints16.hidemode = 0;
                gridLayoutHints16.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController16 = this.createCell(5);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 1);
                gridLayoutHints17.hidemode = 2;
                gridLayoutHints17.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints15, gridLayoutHints16, gridLayoutHints17}, new Object[]{abstractWidgetController, abstractWidgetController14, abstractWidgetController15, abstractWidgetController16});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController14);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                axisConstraints.gaps = new int[]{0, 0, 0};
                axisConstraints.grow = new float[]{0.0f, 0.0f};
                axisConstraints.max = new int[]{-1, -1};
                axisConstraints.min = new int[]{-1, -1};
                axisConstraints.shrink = new float[]{1.0f, 1.0f};
                axisConstraints.size = new int[]{-1, -1};
                axisConstraints.hidemode = new int[]{0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController17 = this.createCell(8);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(1, 0);
                gridLayoutHints18.alignmentHoriz = 1;
                gridLayoutHints18.hidemode = 0;
                AbstractWidgetController abstractWidgetController18 = this.createCell(2);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(2, 0);
                gridLayoutHints19.hidemode = 0;
                gridLayoutHints19.visibleConditions = -13;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints3.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints3.hidemode = new int[]{2, 0};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController19 = this.createCell(3);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(0, 0);
                gridLayoutHints20.hidemode = 2;
                AbstractWidgetController abstractWidgetController20 = this.createCell(4);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(1, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints20, gridLayoutHints21}, new Object[]{abstractWidgetController19, abstractWidgetController20});
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 1);
                gridLayoutHints22.hidemode = 0;
                gridLayoutHints22.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController21 = this.createCell(5);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(2, 1);
                gridLayoutHints23.hidemode = 0;
                gridLayoutHints23.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints18, gridLayoutHints19, gridLayoutHints22, gridLayoutHints23}, new Object[]{abstractWidgetController, abstractWidgetController17, abstractWidgetController18, gridLayout3, abstractWidgetController21});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController17);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController22 = this.createCell(9);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 0);
                gridLayoutHints24.alignmentHoriz = 1;
                gridLayoutHints24.hidemode = 0;
                AbstractWidgetController abstractWidgetController23 = this.createCell(2);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(2, 0);
                gridLayoutHints25.hidemode = 0;
                gridLayoutHints25.visibleConditions = -13;
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints4.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints4.hidemode = new int[]{2, 0};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController24 = this.createCell(3);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(0, 0);
                gridLayoutHints26.hidemode = 2;
                AbstractWidgetController abstractWidgetController25 = this.createCell(4);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(1, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints26, gridLayoutHints27}, new Object[]{abstractWidgetController24, abstractWidgetController25});
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(1, 1);
                gridLayoutHints28.hidemode = 0;
                AbstractWidgetController abstractWidgetController26 = this.createCell(5);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(2, 1);
                gridLayoutHints29.hidemode = 0;
                gridLayoutHints29.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints24, gridLayoutHints25, gridLayoutHints28, gridLayoutHints29}, new Object[]{abstractWidgetController, abstractWidgetController22, abstractWidgetController23, gridLayout4, abstractWidgetController26});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController26);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController22);
                return menuItemController;
            }
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{1, 1, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController27 = this.createCell(10);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(1, 0);
                gridLayoutHints30.alignmentHoriz = 1;
                gridLayoutHints30.hidemode = 0;
                AbstractWidgetController abstractWidgetController28 = this.createCell(2);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(2, 0);
                gridLayoutHints31.hidemode = 0;
                gridLayoutHints31.visibleConditions = -13;
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints5.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints5.hidemode = new int[]{2, 0};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController29 = this.createCell(3);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(0, 0);
                gridLayoutHints32.hidemode = 2;
                AbstractWidgetController abstractWidgetController30 = this.createCell(4);
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(1, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints32, gridLayoutHints33}, new Object[]{abstractWidgetController29, abstractWidgetController30});
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(1, 1);
                gridLayoutHints34.hidemode = 0;
                AbstractWidgetController abstractWidgetController31 = this.createCell(5);
                GridLayoutHints gridLayoutHints35 = new GridLayoutHints(2, 1);
                gridLayoutHints35.hidemode = 0;
                gridLayoutHints35.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints30, gridLayoutHints31, gridLayoutHints34, gridLayoutHints35}, new Object[]{abstractWidgetController, abstractWidgetController27, abstractWidgetController28, gridLayout5, abstractWidgetController31});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController30);
                menuItemController.add(abstractWidgetController28);
                menuItemController.add(abstractWidgetController31);
                menuItemController.add(abstractWidgetController29);
                menuItemController.add(abstractWidgetController27);
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
                iconController.setBitmaps(new int[]{-493681664, 395576320, -460127232});
                iconController.setModelColumn(2);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(6);
                labelRendererHigh.setAlignment(3, 4);
                return labelController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1016333312, 1033110528, 1049887744, 1066664960, 0x40940400, 1100219392, 461, 462, 463, 127, 1116996608, 1133773824});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(4);
                return labelController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(5);
                labelRendererHigh.setAlignment(3, 4);
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-761920512});
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1368916992});
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-1114110976});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{1251607552});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
        }
        return null;
    }
}

