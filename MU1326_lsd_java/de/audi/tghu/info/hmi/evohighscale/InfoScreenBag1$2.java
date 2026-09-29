/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class InfoScreenBag1$2
implements ListItemFactory {
    private final /* synthetic */ InfoScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    InfoScreenBag1$2(InfoScreenFactory infoScreenFactory, int n) {
        this.val$factory = infoScreenFactory;
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
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 60, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{20, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 9;
                gridLayoutHints.rowSpan = 2;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.alignmentVert = 5;
                gridLayoutHints2.hidemode = 0;
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints2.alignment = new int[]{8, 8, 8, 3};
                menuItemColumnsConstraints2.gaps = new int[]{0, 10, 10, 12, 0};
                menuItemColumnsConstraints2.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints2.shrink = new float[]{1.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 0, 0, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(3, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6}, new Object[]{abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6});
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(2, 0);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 1);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints3.gaps = new int[]{0, 10, 12, 12, 0};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints3.size = new int[]{-1, -1, -1, 120};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(0, 0);
                gridLayoutHints9.alignmentVert = 5;
                gridLayoutHints9.afterEffects = new int[]{0, -2, 0, 0};
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 0);
                gridLayoutHints10.alignmentHoriz = 1;
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(2, 0);
                gridLayoutHints11.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(3, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12}, new Object[]{abstractWidgetController7, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10});
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(2, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints7, gridLayoutHints8, gridLayoutHints13}, new Object[]{abstractWidgetController, abstractWidgetController2, gridLayout2, abstractWidgetController, gridLayout3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 60, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{20, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 9;
                gridLayoutHints.rowSpan = 2;
                AbstractWidgetController abstractWidgetController11 = this.createCell(1);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                gridLayoutHints14.alignmentVert = 5;
                gridLayoutHints14.hidemode = 0;
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints4.alignment = new int[]{8, 8, 8, 3};
                menuItemColumnsConstraints4.gaps = new int[]{0, 10, 10, 12, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints4.shrink = new float[]{1.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints4.hidemode = new int[]{0, 0, 0, 2};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                axisConstraints4.alignment = new int[]{5};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController12 = this.createCell(2);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController14 = this.createCell(4);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(5);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(3, 0);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints17, gridLayoutHints18}, new Object[]{abstractWidgetController12, abstractWidgetController13, abstractWidgetController14, abstractWidgetController15});
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(2, 0);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(1, 1);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints5.gaps = new int[]{0, 10, 12, 8, 0};
                menuItemColumnsConstraints5.grow = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints5.size = new int[]{-1, -1, -1, 120};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController16 = this.createCell(6);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(0, 0);
                gridLayoutHints21.alignmentVert = 5;
                gridLayoutHints21.afterEffects = new int[]{0, -2, 0, 0};
                AbstractWidgetController abstractWidgetController17 = this.createCell(7);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 0);
                gridLayoutHints22.alignmentHoriz = 1;
                AbstractWidgetController abstractWidgetController18 = this.createCell(10);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController19 = this.createCell(9);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(3, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints21, gridLayoutHints22, gridLayoutHints23, gridLayoutHints24}, new Object[]{abstractWidgetController16, abstractWidgetController17, abstractWidgetController18, abstractWidgetController19});
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(2, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints14, gridLayoutHints19, gridLayoutHints20, gridLayoutHints25}, new Object[]{abstractWidgetController, abstractWidgetController11, gridLayout4, abstractWidgetController, gridLayout5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 60, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{20, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 9;
                gridLayoutHints.rowSpan = 2;
                AbstractWidgetController abstractWidgetController20 = this.createCell(1);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                gridLayoutHints26.alignmentVert = 5;
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints6.alignment = new int[]{8, 8, 8, 3};
                menuItemColumnsConstraints6.gaps = new int[]{0, 10, 10, 12, 0};
                menuItemColumnsConstraints6.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints6.shrink = new float[]{1.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints6.hidemode = new int[]{0, 0, 0, 2};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                axisConstraints6.alignment = new int[]{5};
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController21 = this.createCell(2);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController22 = this.createCell(3);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController23 = this.createCell(4);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController24 = this.createCell(5);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(3, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints27, gridLayoutHints28, gridLayoutHints29, gridLayoutHints30}, new Object[]{abstractWidgetController21, abstractWidgetController22, abstractWidgetController23, abstractWidgetController24});
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(2, 0);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(1, 1);
                GridLayout gridLayout7 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints7 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints7.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints7.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints7.shrink = new float[]{0.0f, 1.0f};
                gridLayout7.setColumnConstraints(menuItemColumnsConstraints7);
                AxisConstraints axisConstraints7 = new AxisConstraints(1);
                axisConstraints7.alignment = new int[]{5};
                gridLayout7.setRowConstraints(axisConstraints7);
                AbstractWidgetController abstractWidgetController25 = this.createCell(6);
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(0, 0);
                gridLayoutHints33.alignmentVert = 5;
                gridLayoutHints33.afterEffects = new int[]{0, -2, 0, 0};
                AbstractWidgetController abstractWidgetController26 = this.createCell(7);
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(1, 0);
                gridLayoutHints34.alignmentHoriz = 1;
                gridLayout7.setCellConstraints(new GridLayoutHints[]{gridLayoutHints33, gridLayoutHints34}, new Object[]{abstractWidgetController25, abstractWidgetController26});
                GridLayoutHints gridLayoutHints35 = new GridLayoutHints(2, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints26, gridLayoutHints31, gridLayoutHints32, gridLayoutHints35}, new Object[]{abstractWidgetController, abstractWidgetController20, gridLayout6, abstractWidgetController, gridLayout7});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController26);
                menuItemController.add(abstractWidgetController);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 3, 3};
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 10, 12, 8, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.min = new int[]{-1, 60, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{20, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(11);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController27 = this.createCell(1);
                GridLayoutHints gridLayoutHints36 = new GridLayoutHints(1, 0);
                gridLayoutHints36.alignmentVert = 5;
                AbstractWidgetController abstractWidgetController28 = this.createCell(2);
                GridLayoutHints gridLayoutHints37 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController29 = this.createCell(7);
                GridLayoutHints gridLayoutHints38 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController30 = this.createCell(12);
                GridLayoutHints gridLayoutHints39 = new GridLayoutHints(4, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints36, gridLayoutHints37, gridLayoutHints38, gridLayoutHints39}, new Object[]{abstractWidgetController, abstractWidgetController27, abstractWidgetController28, abstractWidgetController29, abstractWidgetController30});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController27);
                menuItemController.add(abstractWidgetController28);
                menuItemController.add(abstractWidgetController29);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController30);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.size = new int[]{20, -1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController31 = this.createCell(13);
                GridLayoutHints gridLayoutHints40 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints40}, new Object[]{abstractWidgetController, abstractWidgetController31});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController31);
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
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        AxisConstraints axisConstraints = new AxisConstraints(1);
        gridLayout.setRowConstraints(axisConstraints);
        AbstractWidgetController abstractWidgetController = this.createCell(13);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
        menuItemController.add(abstractWidgetController);
        return menuItemController;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(1);
                iconLabelController.setPreferredHeight(1);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 547424000, 564201216, 580978432});
                iconController.setModelColumn(3);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(4);
                return labelController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 614532864});
                iconController.setModelColumn(13);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 6: {
                IconLabelController iconLabelController = new IconLabelController();
                IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
                iconLabelController.setRenderer(iconLabelRendererHigh);
                iconLabelController.setBounds(0, 0, 100, 100);
                iconLabelController.setModelColumn(5);
                iconLabelController.setPreferredHeight(18);
                iconLabelRendererHigh.setAlignment(1, 5);
                return iconLabelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(7);
                return labelController;
            }
            case 8: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setMetricsFormat(1);
                labelController.setModelColumn(9);
                return labelController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{648087296});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 11: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{186, 185});
                iconController.setModelColumn(12);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(2, 5);
                return iconController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{966854400});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 13: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{1302398720});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
        }
        return null;
    }
}

