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

final class PhoneScreenBag2$9
implements ListItemFactory {
    private final /* synthetic */ PhoneScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    PhoneScreenBag2$9(PhoneScreenFactory phoneScreenFactory, int n) {
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
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 1.0f};
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
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
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
                AbstractWidgetController abstractWidgetController12 = this.createCell(5);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(2, 1);
                gridLayoutHints13.hidemode = 0;
                gridLayoutHints13.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13}, new Object[]{abstractWidgetController, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController11);
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
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController13 = this.createCell(7);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                gridLayoutHints14.hidemode = 0;
                AbstractWidgetController abstractWidgetController14 = this.createCell(2);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(2, 0);
                gridLayoutHints15.hidemode = 0;
                gridLayoutHints15.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController15 = this.createCell(5);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(2, 1);
                gridLayoutHints16.hidemode = 0;
                gridLayoutHints16.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints14, gridLayoutHints15, gridLayoutHints16}, new Object[]{abstractWidgetController, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController13);
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
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController16 = this.createCell(8);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                gridLayoutHints17.alignmentHoriz = 1;
                gridLayoutHints17.hidemode = 0;
                AbstractWidgetController abstractWidgetController17 = this.createCell(2);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(2, 0);
                gridLayoutHints18.hidemode = 0;
                gridLayoutHints18.visibleConditions = -13;
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints3.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController18 = this.createCell(3);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController19 = this.createCell(4);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(1, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints19, gridLayoutHints20}, new Object[]{abstractWidgetController18, abstractWidgetController19});
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(1, 1);
                gridLayoutHints21.hidemode = 0;
                AbstractWidgetController abstractWidgetController20 = this.createCell(5);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(2, 1);
                gridLayoutHints22.hidemode = 0;
                gridLayoutHints22.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17, gridLayoutHints18, gridLayoutHints21, gridLayoutHints22}, new Object[]{abstractWidgetController, abstractWidgetController16, abstractWidgetController17, gridLayout3, abstractWidgetController20});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController16);
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
                AbstractWidgetController abstractWidgetController21 = this.createCell(9);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(1, 0);
                gridLayoutHints23.alignmentHoriz = 1;
                gridLayoutHints23.hidemode = 0;
                AbstractWidgetController abstractWidgetController22 = this.createCell(2);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(2, 0);
                gridLayoutHints24.hidemode = 0;
                gridLayoutHints24.visibleConditions = -13;
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints4.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 1.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController23 = this.createCell(3);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(4);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints25, gridLayoutHints26}, new Object[]{abstractWidgetController23, abstractWidgetController24});
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(1, 1);
                gridLayoutHints27.hidemode = 0;
                AbstractWidgetController abstractWidgetController25 = this.createCell(5);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(2, 1);
                gridLayoutHints28.hidemode = 0;
                gridLayoutHints28.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints23, gridLayoutHints24, gridLayoutHints27, gridLayoutHints28}, new Object[]{abstractWidgetController, abstractWidgetController21, abstractWidgetController22, gridLayout4, abstractWidgetController25});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController21);
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
                AbstractWidgetController abstractWidgetController26 = this.createCell(10);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(1, 0);
                gridLayoutHints29.alignmentHoriz = 1;
                gridLayoutHints29.hidemode = 0;
                AbstractWidgetController abstractWidgetController27 = this.createCell(2);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(2, 0);
                gridLayoutHints30.hidemode = 0;
                gridLayoutHints30.visibleConditions = -13;
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints5.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 1.0f};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController28 = this.createCell(3);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController29 = this.createCell(4);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(1, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints31, gridLayoutHints32}, new Object[]{abstractWidgetController28, abstractWidgetController29});
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(1, 1);
                gridLayoutHints33.hidemode = 0;
                AbstractWidgetController abstractWidgetController30 = this.createCell(5);
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(2, 1);
                gridLayoutHints34.hidemode = 0;
                gridLayoutHints34.visibleConditions = -13;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints29, gridLayoutHints30, gridLayoutHints33, gridLayoutHints34}, new Object[]{abstractWidgetController, abstractWidgetController26, abstractWidgetController27, gridLayout5, abstractWidgetController30});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController29);
                menuItemController.add(abstractWidgetController27);
                menuItemController.add(abstractWidgetController30);
                menuItemController.add(abstractWidgetController28);
                menuItemController.add(abstractWidgetController26);
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
                labelController.setTextIds(new int[]{-1097333760});
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1080556544});
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1063779328});
                return labelController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1047002112});
                return labelController;
            }
        }
        return null;
    }
}

