/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi.evohighscale;

import de.audi.atip.hmi.model.ListCell;
import de.audi.tghu.media.hmi.evohighscale.MediaScreenFactory;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ProgressBarRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

class MediaScreenFactory$1
implements ListItemFactory {
    private final /* synthetic */ MediaScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ MediaScreenFactory this$0;

    MediaScreenFactory$1(MediaScreenFactory mediaScreenFactory, MediaScreenFactory mediaScreenFactory2, int n) {
        this.this$0 = mediaScreenFactory;
        this.val$factory = mediaScreenFactory2;
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
                menuItemColumnsConstraints.gaps = new int[]{0, 10, 0};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 2;
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.gaps = new int[]{0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints2.gaps = new int[]{0, 10, 0};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(1);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController3});
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(0, 0);
                gridLayoutHints4.alignmentVert = 5;
                gridLayoutHints4.hidemode = 0;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                gridLayoutHints5.alignmentVert = 5;
                gridLayoutHints5.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints4, gridLayoutHints5}, new Object[]{gridLayout2, abstractWidgetController4});
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.gaps = new int[]{10, 15, 0, 0};
                menuItemColumnsConstraints3.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(6);
                axisConstraints3.gaps = new int[]{0, 0, 25, 18, 79, 0, 0};
                axisConstraints3.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                axisConstraints3.size = new int[]{42, -1, -1, -1, -1, -1};
                axisConstraints3.hidemode = new int[]{0, 1, 1, 0, 0, 0};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 1);
                gridLayoutHints6.hidemode = 1;
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(2, 1);
                gridLayoutHints8.hidemode = 0;
                gridLayoutHints8.rowSpan = 4;
                gridLayoutHints8.widthMin = 18;
                gridLayoutHints8.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(0, 2);
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(1, 2);
                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 3);
                AbstractWidgetController abstractWidgetController11 = this.createCell(10);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(1, 3);
                AbstractWidgetController abstractWidgetController12 = this.createCell(11);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(0, 4);
                gridLayoutHints13.columnSpan = 2;
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13}, new Object[]{abstractWidgetController5, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10, abstractWidgetController11, abstractWidgetController12});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout, gridLayout3});
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController7);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.gaps = new int[]{0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.alignmentVert = 5;
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 0);
                gridLayoutHints14.alignmentHoriz = 3;
                gridLayoutHints14.alignmentVert = 5;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints14}, new Object[]{abstractWidgetController, abstractWidgetController13});
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints4.gaps = new int[]{10, 15, 0, 0};
                menuItemColumnsConstraints4.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints4.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(6);
                axisConstraints4.gaps = new int[]{0, 0, 25, 18, 79, 0, 0};
                axisConstraints4.grow = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                axisConstraints4.size = new int[]{42, -1, -1, -1, -1, -1};
                axisConstraints4.hidemode = new int[]{0, 1, 1, 0, 0, 0};
                gridLayout4.setRowConstraints(axisConstraints4);
                AbstractWidgetController abstractWidgetController14 = this.createCell(4);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(0, 1);
                gridLayoutHints15.hidemode = 1;
                AbstractWidgetController abstractWidgetController15 = this.createCell(12);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 1);
                gridLayoutHints16.hidemode = 1;
                AbstractWidgetController abstractWidgetController16 = this.createCell(6);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(2, 1);
                gridLayoutHints17.hidemode = 0;
                gridLayoutHints17.rowSpan = 4;
                gridLayoutHints17.widthMin = 18;
                gridLayoutHints17.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController17 = this.createCell(7);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(0, 2);
                AbstractWidgetController abstractWidgetController18 = this.createCell(8);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(1, 2);
                AbstractWidgetController abstractWidgetController19 = this.createCell(9);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(0, 3);
                AbstractWidgetController abstractWidgetController20 = this.createCell(10);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(1, 3);
                AbstractWidgetController abstractWidgetController21 = this.createCell(11);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(0, 4);
                gridLayoutHints22.columnSpan = 2;
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints17, gridLayoutHints18, gridLayoutHints19, gridLayoutHints20, gridLayoutHints21, gridLayoutHints22}, new Object[]{abstractWidgetController14, abstractWidgetController15, abstractWidgetController16, abstractWidgetController17, abstractWidgetController18, abstractWidgetController19, abstractWidgetController20, abstractWidgetController21});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout, gridLayout4});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController16);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints5.gaps = new int[]{0, 10, 0};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController22 = this.createCell(1);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(1, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints23}, new Object[]{abstractWidgetController, abstractWidgetController22});
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(0, 0);
                gridLayoutHints24.hidemode = 0;
                AbstractWidgetController abstractWidgetController23 = this.createCell(13);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints24, gridLayoutHints25}, new Object[]{gridLayout5, abstractWidgetController23});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController22);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 2};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController24 = this.createCell(13);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints26}, new Object[]{abstractWidgetController, abstractWidgetController24});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController24);
                return menuItemController;
            }
            case 6: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.gaps = new int[]{0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints6.gaps = new int[]{0, 10, 12, 0};
                menuItemColumnsConstraints6.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints6.shrink = new float[]{1.0f, 1.0f, 0.0f};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController25 = this.createCell(1);
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController26 = this.createCell(3);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(2, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints27, gridLayoutHints28}, new Object[]{abstractWidgetController, abstractWidgetController25, abstractWidgetController26});
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(0, 0);
                gridLayoutHints29.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints29}, new Object[]{gridLayout6});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController26);
                return menuItemController;
            }
            case 7: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.gaps = new int[]{0, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.shrink = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints.hidemode = new int[]{0, 1};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.gaps = new int[]{0, 0};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                AbstractWidgetController abstractWidgetController27 = this.createCell(3);
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(1, 0);
                gridLayoutHints30.alignmentVert = 5;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints30}, new Object[]{abstractWidgetController, abstractWidgetController27});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController27);
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
        menuItemColumnsConstraints.gaps = new int[]{0, 0};
        menuItemColumnsConstraints.grow = new float[]{0.0f};
        menuItemColumnsConstraints.min = new int[]{32};
        menuItemColumnsConstraints.shrink = new float[]{0.0f};
        gridLayout.setColumnConstraints(menuItemColumnsConstraints);
        AxisConstraints axisConstraints = new AxisConstraints(1);
        axisConstraints.gaps = new int[]{0, 0};
        gridLayout.setRowConstraints(axisConstraints);
        AbstractWidgetController abstractWidgetController = this.createCell(14);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.hidemode = 0;
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
        menuItemController.add(abstractWidgetController);
        return menuItemController;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-1156447488});
                labelController.setChainedAction(1, 1);
                return labelController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(4);
                return labelController;
            }
            case 4: {
                AbstractWidgetController abstractWidgetController = this.val$factory.getRefWidget(this.val$terminalID, 8, this.val$factory);
                return abstractWidgetController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(3, this.val$terminalID));
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(2);
                LabelController labelController2 = new LabelController();
                LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
                labelController2.setRenderer(labelRendererHigh2);
                labelRendererHigh2.setFonts(this.val$factory.getFonts(3, this.val$terminalID));
                labelController2.setTextIds(new int[]{-1156447488});
                labelController2.setChainedAction(1, 1);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.gaps = new int[]{0, 10, 0};
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{labelController2, labelController});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController2);
                return layoutContainerController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                return labelController;
            }
            case 7: {
                AbstractWidgetController abstractWidgetController = this.val$factory.getRefWidget(this.val$terminalID, 9, this.val$factory);
                return abstractWidgetController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(13);
                LabelController labelController3 = new LabelController();
                LabelRendererHigh labelRendererHigh3 = new LabelRendererHigh(labelController3);
                labelController3.setRenderer(labelRendererHigh3);
                labelRendererHigh3.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController3.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -971701504, -954924288, -938147072, -921369856, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -518716672, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728});
                labelController3.setColorIndices(new int[]{1, 7, 4, 2});
                labelController3.setModelColumn(14);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints3);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3}, new Object[]{labelController, labelController3});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController3);
                return layoutContainerController;
            }
            case 9: {
                AbstractWidgetController abstractWidgetController = this.val$factory.getRefWidget(this.val$terminalID, 10, this.val$factory);
                return abstractWidgetController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(11);
                LabelController labelController4 = new LabelController();
                LabelRendererHigh labelRendererHigh4 = new LabelRendererHigh(labelController4);
                labelController4.setRenderer(labelRendererHigh4);
                labelRendererHigh4.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController4.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -266992896, -954924288, -938147072, -250215680, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -233438464, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728});
                labelController4.setColorIndices(new int[]{1, 7, 4, 2});
                labelController4.setModelColumn(12);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints4);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints4}, new Object[]{labelController, labelController4});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController4);
                return layoutContainerController;
            }
            case 11: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setBounds(0, 0, 0, 0);
                labelController.setModelColumn(4);
                ProgressBarController progressBarController = new ProgressBarController();
                ProgressBarRendererHigh progressBarRendererHigh = new ProgressBarRendererHigh(progressBarController);
                progressBarController.setRenderer(progressBarRendererHigh);
                progressBarController.setBitmaps(new int[]{40, 41, 42, 43, 44, 45});
                progressBarController.setColorIndices(new int[]{1, 2, 4, 0});
                progressBarController.setMaximumModelValue(100);
                progressBarController.setMinimumModelValue(0);
                progressBarController.setModelColumn(6);
                progressBarController.setPreferredHeight(15);
                LabelController labelController5 = new LabelController();
                LabelRendererHigh labelRendererHigh5 = new LabelRendererHigh(labelController5);
                labelController5.setRenderer(labelRendererHigh5);
                labelRendererHigh5.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController5.setBounds(0, 0, 0, 0);
                labelController5.setModelColumn(5);
                labelRendererHigh5.setAlignment(3, 4);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                layoutContainerController.setShouldBackmirrorProgressBarInArabic(true);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(3);
                axisConstraints.gaps = new int[]{0, 15, 10, 0};
                axisConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                axisConstraints.min = new int[]{67, -1, 75};
                axisConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints5);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(2, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints6}, new Object[]{labelController, progressBarController, labelController5});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(progressBarController);
                layoutContainerController.add(labelController5);
                return layoutContainerController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(3, this.val$terminalID));
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(3);
                return labelController;
            }
            case 13: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 453, 453, 453, 162});
                iconController.setChainedAction(1, 1);
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(22);
                iconRendererHigh.setAlignment(2, 5);
                return iconController;
            }
            case 14: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-166460672});
                return labelController;
            }
        }
        return null;
    }
}

