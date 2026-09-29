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
import de.esolutions.hmi.widgets.audi.evo.high.widgets.HighlightingLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MenuItemRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class MediaScreenBag1$4
implements ListItemFactory {
    private final /* synthetic */ MediaScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    MediaScreenBag1$4(MediaScreenFactory mediaScreenFactory, int n) {
        this.val$factory = mediaScreenFactory;
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                axisConstraints.shrink = new float[]{0.0f};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                gridLayoutHints3.hidemode = 0;
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                gridLayoutHints4.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(6);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 5, 5, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(1);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 0);
                gridLayoutHints5.columnSpan = 3;
                AbstractWidgetController abstractWidgetController6 = this.createCell(2);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(4, 0);
                gridLayoutHints6.hidemode = 0;
                AbstractWidgetController abstractWidgetController7 = this.createCell(3);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(5, 0);
                gridLayoutHints7.hidemode = 0;
                AbstractWidgetController abstractWidgetController8 = this.createCell(4);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController9 = this.createCell(5);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 1);
                AbstractWidgetController abstractWidgetController10 = this.createCell(6);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(3, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints5, gridLayoutHints6, gridLayoutHints7, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10}, new Object[]{abstractWidgetController, abstractWidgetController5, abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9, abstractWidgetController10});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController10);
                return menuItemController;
            }
            case 2: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(1);
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController12 = this.createCell(2);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(3);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(3, 0);
                gridLayoutHints13.hidemode = 0;
                AbstractWidgetController abstractWidgetController14 = this.createCell(4);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints11, gridLayoutHints12, gridLayoutHints13, gridLayoutHints14}, new Object[]{abstractWidgetController, abstractWidgetController11, abstractWidgetController12, abstractWidgetController13, abstractWidgetController14});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController14);
                return menuItemController;
            }
            case 3: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(1);
                axisConstraints.alignment = new int[]{5};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(1);
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(1, 0);
                gridLayoutHints15.hidemode = 0;
                AbstractWidgetController abstractWidgetController16 = this.createCell(3);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(2, 0);
                gridLayoutHints16.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints15, gridLayoutHints16}, new Object[]{abstractWidgetController, abstractWidgetController15, abstractWidgetController16});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController15);
                return menuItemController;
            }
            case 4: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 5, 5, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController17 = this.createCell(1);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(1, 0);
                gridLayoutHints17.hidemode = 0;
                gridLayoutHints17.columnSpan = 3;
                AbstractWidgetController abstractWidgetController18 = this.createCell(3);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(4, 0);
                gridLayoutHints18.hidemode = 0;
                AbstractWidgetController abstractWidgetController19 = this.createCell(4);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(1, 1);
                AbstractWidgetController abstractWidgetController20 = this.createCell(5);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(2, 1);
                AbstractWidgetController abstractWidgetController21 = this.createCell(6);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(3, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints17, gridLayoutHints18, gridLayoutHints19, gridLayoutHints20, gridLayoutHints21}, new Object[]{abstractWidgetController, abstractWidgetController17, abstractWidgetController18, abstractWidgetController19, abstractWidgetController20, abstractWidgetController21});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController21);
                return menuItemController;
            }
            case 5: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints.alignment = new int[]{8, 8, 8};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.max = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.min = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints.size = new int[]{-1, -1, -1};
                menuItemColumnsConstraints.tabulatorIDs = new int[]{-1, -1, -1, -1};
                menuItemColumnsConstraints.hidemode = new int[]{0, 0, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController22 = this.createCell(1);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(1, 0);
                gridLayoutHints22.hidemode = 0;
                AbstractWidgetController abstractWidgetController23 = this.createCell(3);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(2, 0);
                gridLayoutHints23.hidemode = 0;
                AbstractWidgetController abstractWidgetController24 = this.createCell(4);
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints22, gridLayoutHints23, gridLayoutHints24}, new Object[]{abstractWidgetController, abstractWidgetController22, abstractWidgetController23, abstractWidgetController24});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController24);
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
        AbstractWidgetController abstractWidgetController = this.createCell(7);
        GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
        gridLayoutHints.hidemode = 0;
        gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints}, new Object[]{abstractWidgetController});
        menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
        return menuItemController;
    }

    public AbstractWidgetController createCell(int n) {
        switch (n) {
            case 0: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{1863189248, 1879966464, 1896743680, 163, 1846412032, 164, 165, 1980629760, 1947075328, 1963852544});
                iconController.setChainedAction(1, 1);
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(22);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                labelController.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -920976640, -954924288, -938147072, -166395136, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -887422208, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, 723190528, -334167296, -317390080, -300612864, -283835648, -769981696, -753532160, -736754944, -719977728, 958399232, 0x23200300, 505414400});
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(5);
                LabelController labelController2 = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh2 = new HighlightingLabelRendererHigh(labelController2);
                labelController2.setRenderer(highlightingLabelRendererHigh2);
                labelController2.setBounds(0, 0, 0, 0);
                labelController2.setChainedAction(1, 1);
                labelController2.setModelColumn(2);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                layoutContainerController.setChainedAction(1, 1);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.gaps = new int[]{0, 10, 0};
                axisConstraints.hidemode = new int[]{2, 2};
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{labelController, labelController2});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController2);
                return layoutContainerController;
            }
            case 2: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{39, 39, 39, 39});
                iconController.setChainedAction(1, 1);
                iconController.setPreferredHeight(22);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -888274176, -871496960});
                iconController.setChainedAction(1, 1);
                iconController.setModelColumn(20);
                iconController.setPreferredHeight(22);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -1424227584, -954924288, -938147072, -1373895936, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -1239547136, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728, 958399232, 924844800, 505414400});
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(6);
                LabelController labelController3 = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh3 = new HighlightingLabelRendererHigh(labelController3);
                labelController3.setRenderer(highlightingLabelRendererHigh3);
                highlightingLabelRendererHigh3.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController3.setBounds(0, 0, 0, 0);
                labelController3.setChainedAction(1, 1);
                labelController3.setColorIndices(new int[]{1, 7, 4, 2});
                labelController3.setModelColumn(3);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                layoutContainerController.setChainedAction(1, 1);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints3);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
                gridLayoutHints3.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints3}, new Object[]{labelController, labelController3});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController3);
                return layoutContainerController;
            }
            case 5: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{0x2200300});
                labelController.setChainedAction(1, 1);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 6: {
                LabelController labelController = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh = new HighlightingLabelRendererHigh(labelController);
                labelController.setRenderer(highlightingLabelRendererHigh);
                highlightingLabelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -1424227584, -954924288, -938147072, 1025508096, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -1239547136, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728, 958399232, 924844800, 505414400});
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(7);
                LabelController labelController4 = new LabelController();
                HighlightingLabelRendererHigh highlightingLabelRendererHigh4 = new HighlightingLabelRendererHigh(labelController4);
                labelController4.setRenderer(highlightingLabelRendererHigh4);
                highlightingLabelRendererHigh4.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController4.setBounds(0, 0, 0, 0);
                labelController4.setChainedAction(1, 1);
                labelController4.setColorIndices(new int[]{1, 7, 4, 2});
                labelController4.setModelColumn(4);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                layoutContainerController.setBounds(0, 0, 100, 100);
                layoutContainerController.setChainedAction(1, 1);
                GridLayout gridLayout = new GridLayout();
                AxisConstraints axisConstraints = new AxisConstraints(2);
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints4 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints4);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                gridLayoutHints4.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints4}, new Object[]{labelController, labelController4});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController4);
                return layoutContainerController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{-753728768});
                return labelController;
            }
        }
        return null;
    }
}

