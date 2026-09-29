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
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemColumnsConstraints;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuItemController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemFactory;

final class MediaScreenBag3$4
implements ListItemFactory {
    private final /* synthetic */ MediaScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    MediaScreenBag3$4(MediaScreenFactory mediaScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{8, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.hidemode = new int[]{2, 0};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 0;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                return menuItemController;
            }
            case 1: {
                MenuItemController menuItemController = new MenuItemController();
                menuItemController.setType(16);
                menuItemController.setRenderer(new MenuItemRendererHigh(menuItemController));
                GridLayout gridLayout = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints.alignment = new int[]{8, 1};
                menuItemColumnsConstraints.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints.grow = new float[]{0.0f, 1.0f};
                menuItemColumnsConstraints.shrink = new float[]{0.0f, 1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.alignment = new int[]{5, 9};
                gridLayout.setRowConstraints(axisConstraints);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
                gridLayoutHints4.hidemode = 0;
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 1);
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController4, abstractWidgetController5});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
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
        AbstractWidgetController abstractWidgetController = this.createCell(5);
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
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{76, 1896743680, 1879966464, 1846412032, 165, 164});
                iconController.setChainedAction(1, 1);
                iconController.setModelColumn(7);
                iconController.setPreferredHeight(22);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(1);
                LabelController labelController2 = new LabelController();
                LabelRendererHigh labelRendererHigh2 = new LabelRendererHigh(labelController2);
                labelController2.setRenderer(labelRendererHigh2);
                labelController2.setTextIds(new int[]{-1022033152, -1743125760, -988478720, -971701504, 874251008, -938147072, -250215680, -250215680, -887815424, 958137088, 958137088, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -518716672, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728});
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
                gridLayout.setColumnConstraints(axisConstraints);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                gridLayout.setRowConstraints(axisConstraints2);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.hidemode = 0;
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.hidemode = 0;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{labelController, labelController2});
                layoutContainerController.setLayoutManager(gridLayout);
                layoutContainerController.add(labelController);
                layoutContainerController.add(labelController2);
                return layoutContainerController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setChainedAction(1, 1);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                return labelController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setModelColumn(1);
                LabelController labelController3 = new LabelController();
                LabelRendererHigh labelRendererHigh3 = new LabelRendererHigh(labelController3);
                labelController3.setRenderer(labelRendererHigh3);
                labelController3.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -266992896, -954924288, -938147072, -250215680, -250215680, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -233438464, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728});
                labelController3.setBounds(0, 0, 0, 0);
                labelController3.setChainedAction(1, 1);
                labelController3.setModelColumn(2);
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
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setBounds(0, 0, 0, 0);
                labelController.setChainedAction(1, 1);
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                LabelController labelController4 = new LabelController();
                LabelRendererHigh labelRendererHigh4 = new LabelRendererHigh(labelController4);
                labelController4.setRenderer(labelRendererHigh4);
                labelRendererHigh4.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController4.setTextIds(new int[]{-1022033152, -1005255936, -988478720, -971701504, 874251008, -938147072, -921369856, -904592640, -887815424, -871038208, -854260992, -837483776, -820706560, -803929344, -787152128, -770374912, -753597696, -736820480, -720043264, -703266048, -686488832, -669711616, -652934400, -636157184, -619379968, -602602752, -585825536, -569048320, -552271104, -535493888, -518716672, -501939456, -485162240, -468385024, -451607808, -434830592, -418053376, -401276160, -384498944, -367721728, -350944512, -334167296, -317390080, -300612864, -283835648, -267058432, -753532160, -736754944, -719977728});
                labelController4.setBounds(0, 0, 0, 0);
                labelController4.setChainedAction(1, 1);
                labelController4.setColorIndices(new int[]{1, 7, 4, 2});
                labelController4.setModelColumn(4);
                LayoutContainerController layoutContainerController = new LayoutContainerController();
                CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
                layoutContainerController.setRenderer(compositeRendererHigh);
                compositeRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                layoutContainerController.setBounds(0, 0, 100, 100);
                layoutContainerController.setChainedAction(1, 1);
                layoutContainerController.setColorIndices(new int[]{1, 7, 4, 2});
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
            case 5: {
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

