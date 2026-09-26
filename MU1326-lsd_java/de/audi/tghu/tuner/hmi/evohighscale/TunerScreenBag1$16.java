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

final class TunerScreenBag1$16
implements ListItemFactory {
    private final /* synthetic */ TunerScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    TunerScreenBag1$16(TunerScreenFactory tunerScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints = new MenuItemColumnsConstraints(1);
                menuItemColumnsConstraints.grow = new float[]{1.0f};
                gridLayout.setColumnConstraints(menuItemColumnsConstraints);
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout2 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints2.alignment = new int[]{8, 1, 8, 1, 1};
                menuItemColumnsConstraints2.gaps = new int[]{0, 15, 12, 15, 12, 0};
                menuItemColumnsConstraints2.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{0, 0, 0, 2, 0};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.widthMax = 30;
                gridLayoutHints.widthMin = 30;
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                gridLayoutHints2.widthMax = 90;
                gridLayoutHints2.widthMin = 90;
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                gridLayoutHints5.widthMax = 170;
                gridLayoutHints5.widthMin = 170;
                gridLayoutHints5.visibleConditions = -13;
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5});
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints3.gaps = new int[]{0, 15, 8, 8, 0};
                menuItemColumnsConstraints3.shrink = new float[]{0.0f, 1.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints3.hidemode = new int[]{1, 2, 2, 2};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.alignment = new int[]{5};
                axisConstraints3.hidemode = new int[]{2};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 0);
                gridLayoutHints7.widthMax = 30;
                gridLayoutHints7.widthMin = 30;
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(3, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints7, gridLayoutHints8, gridLayoutHints9, gridLayoutHints10}, new Object[]{abstractWidgetController6, abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 1);
                gridLayoutHints11.visibleConditions = -11;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints11}, new Object[]{gridLayout2, gridLayout3});
                GridLayout gridLayout4 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints4 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints4.gaps = new int[]{10, 0, 0};
                menuItemColumnsConstraints4.grow = new float[]{1.0f, 0.0f};
                menuItemColumnsConstraints4.shrink = new float[]{1.0f, 0.0f};
                gridLayout4.setColumnConstraints(menuItemColumnsConstraints4);
                AxisConstraints axisConstraints4 = new AxisConstraints(5);
                axisConstraints4.alignment = new int[]{5, 5, 5, 5, 5};
                axisConstraints4.gaps = new int[]{42, 18, 34, 20, 20, 0};
                axisConstraints4.size = new int[]{20, 16, 16, 16, 16};
                gridLayout4.setRowConstraints(axisConstraints4);
                GridLayout gridLayout5 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints5 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints5.gaps = new int[]{0, 15, 12, 0};
                menuItemColumnsConstraints5.shrink = new float[]{0.0f, 1.0f, 1.0f};
                menuItemColumnsConstraints5.hidemode = new int[]{2, 0, 0};
                gridLayout5.setColumnConstraints(menuItemColumnsConstraints5);
                AxisConstraints axisConstraints5 = new AxisConstraints(1);
                axisConstraints5.alignment = new int[]{5};
                gridLayout5.setRowConstraints(axisConstraints5);
                AbstractWidgetController abstractWidgetController10 = this.createCell(9);
                GridLayoutHints gridLayoutHints12 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController11 = this.createCell(10);
                GridLayoutHints gridLayoutHints13 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController12 = this.createCell(11);
                GridLayoutHints gridLayoutHints14 = new GridLayoutHints(2, 0);
                gridLayout5.setCellConstraints(new GridLayoutHints[]{gridLayoutHints12, gridLayoutHints13, gridLayoutHints14}, new Object[]{abstractWidgetController10, abstractWidgetController11, abstractWidgetController12});
                GridLayoutHints gridLayoutHints15 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController13 = this.createCell(12);
                GridLayoutHints gridLayoutHints16 = new GridLayoutHints(1, 0);
                gridLayoutHints16.alignmentVert = 9;
                gridLayoutHints16.rowSpan = 5;
                gridLayoutHints16.widthMax = 216;
                gridLayoutHints16.widthMin = 216;
                gridLayoutHints16.visibleConditions = -13;
                GridLayout gridLayout6 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints6 = new MenuItemColumnsConstraints(4);
                menuItemColumnsConstraints6.alignment = new int[]{1, 8, 8, 8};
                menuItemColumnsConstraints6.gaps = new int[]{0, 22, 15, 15, 0};
                menuItemColumnsConstraints6.grow = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints6.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints6.hidemode = new int[]{0, 2, 2, 2};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                axisConstraints6.alignment = new int[]{5};
                axisConstraints6.hidemode = new int[]{2};
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController14 = this.createCell(13);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(14);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController16 = this.createCell(15);
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController17 = this.createCell(16);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(3, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints17, gridLayoutHints18, gridLayoutHints19, gridLayoutHints20}, new Object[]{abstractWidgetController14, abstractWidgetController15, abstractWidgetController16, abstractWidgetController17});
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(0, 1);
                GridLayout gridLayout7 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints7 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints7.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints7.shrink = new float[]{0.0f, 1.0f};
                gridLayout7.setColumnConstraints(menuItemColumnsConstraints7);
                AxisConstraints axisConstraints7 = new AxisConstraints(1);
                axisConstraints7.alignment = new int[]{5};
                gridLayout7.setRowConstraints(axisConstraints7);
                AbstractWidgetController abstractWidgetController18 = this.createCell(17);
                GridLayoutHints gridLayoutHints22 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController19 = this.createCell(18);
                GridLayoutHints gridLayoutHints23 = new GridLayoutHints(1, 0);
                gridLayout7.setCellConstraints(new GridLayoutHints[]{gridLayoutHints22, gridLayoutHints23}, new Object[]{abstractWidgetController18, abstractWidgetController19});
                GridLayoutHints gridLayoutHints24 = new GridLayoutHints(0, 2);
                GridLayout gridLayout8 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints8 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints8.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints8.shrink = new float[]{0.0f, 1.0f};
                gridLayout8.setColumnConstraints(menuItemColumnsConstraints8);
                AxisConstraints axisConstraints8 = new AxisConstraints(1);
                axisConstraints8.alignment = new int[]{5};
                gridLayout8.setRowConstraints(axisConstraints8);
                AbstractWidgetController abstractWidgetController20 = this.createCell(19);
                GridLayoutHints gridLayoutHints25 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController21 = this.createCell(20);
                GridLayoutHints gridLayoutHints26 = new GridLayoutHints(1, 0);
                gridLayout8.setCellConstraints(new GridLayoutHints[]{gridLayoutHints25, gridLayoutHints26}, new Object[]{abstractWidgetController20, abstractWidgetController21});
                GridLayoutHints gridLayoutHints27 = new GridLayoutHints(0, 3);
                GridLayout gridLayout9 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints9 = new MenuItemColumnsConstraints(2);
                menuItemColumnsConstraints9.gaps = new int[]{0, 15, 0};
                menuItemColumnsConstraints9.shrink = new float[]{0.0f, 1.0f};
                gridLayout9.setColumnConstraints(menuItemColumnsConstraints9);
                AxisConstraints axisConstraints9 = new AxisConstraints(1);
                axisConstraints9.alignment = new int[]{5};
                gridLayout9.setRowConstraints(axisConstraints9);
                AbstractWidgetController abstractWidgetController22 = this.createCell(21);
                GridLayoutHints gridLayoutHints28 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController23 = this.createCell(22);
                GridLayoutHints gridLayoutHints29 = new GridLayoutHints(1, 0);
                gridLayout9.setCellConstraints(new GridLayoutHints[]{gridLayoutHints28, gridLayoutHints29}, new Object[]{abstractWidgetController22, abstractWidgetController23});
                GridLayoutHints gridLayoutHints30 = new GridLayoutHints(0, 4);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints21, gridLayoutHints24, gridLayoutHints27, gridLayoutHints30}, new Object[]{gridLayout5, abstractWidgetController13, gridLayout6, gridLayout7, gridLayout8, gridLayout9});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout, gridLayout4});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController18);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController19);
                menuItemController.add(abstractWidgetController20);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController21);
                menuItemController.add(abstractWidgetController22);
                menuItemController.add(abstractWidgetController23);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController13);
                menuItemController.add(abstractWidgetController6);
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
                AxisConstraints axisConstraints = new AxisConstraints(2);
                axisConstraints.hidemode = new int[]{0, 2};
                gridLayout.setRowConstraints(axisConstraints);
                GridLayout gridLayout10 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints10 = new MenuItemColumnsConstraints(5);
                menuItemColumnsConstraints10.alignment = new int[]{8, 8, 8, 1, 8};
                menuItemColumnsConstraints10.gaps = new int[]{0, 15, 12, 12, 12, 0};
                menuItemColumnsConstraints10.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
                menuItemColumnsConstraints10.shrink = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints10.hidemode = new int[]{0, 0, 0, 2, 0};
                gridLayout10.setColumnConstraints(menuItemColumnsConstraints10);
                AxisConstraints axisConstraints10 = new AxisConstraints(1);
                axisConstraints10.alignment = new int[]{5};
                gridLayout10.setRowConstraints(axisConstraints10);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                gridLayoutHints.widthMax = 30;
                gridLayoutHints.widthMin = 30;
                AbstractWidgetController abstractWidgetController24 = this.createCell(23);
                GridLayoutHints gridLayoutHints31 = new GridLayoutHints(1, 0);
                gridLayoutHints31.widthMax = 90;
                gridLayoutHints31.widthMin = 90;
                AbstractWidgetController abstractWidgetController25 = this.createCell(24);
                GridLayoutHints gridLayoutHints32 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController26 = this.createCell(3);
                GridLayoutHints gridLayoutHints33 = new GridLayoutHints(3, 0);
                AbstractWidgetController abstractWidgetController27 = this.createCell(25);
                GridLayoutHints gridLayoutHints34 = new GridLayoutHints(4, 0);
                gridLayoutHints34.widthMax = 170;
                gridLayoutHints34.widthMin = 170;
                gridLayoutHints34.visibleConditions = -13;
                gridLayout10.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints31, gridLayoutHints32, gridLayoutHints33, gridLayoutHints34}, new Object[]{abstractWidgetController, abstractWidgetController24, abstractWidgetController25, abstractWidgetController26, abstractWidgetController27});
                GridLayoutHints gridLayoutHints35 = new GridLayoutHints(0, 0);
                GridLayout gridLayout11 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints11 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints11.gaps = new int[]{0, 8, 8, 0};
                menuItemColumnsConstraints11.shrink = new float[]{1.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints11.hidemode = new int[]{2, 2, 2};
                gridLayout11.setColumnConstraints(menuItemColumnsConstraints11);
                AxisConstraints axisConstraints11 = new AxisConstraints(1);
                axisConstraints11.hidemode = new int[]{2};
                gridLayout11.setRowConstraints(axisConstraints11);
                gridLayout11.setCellConstraints(new GridLayoutHints[0], new Object[0]);
                GridLayoutHints gridLayoutHints36 = new GridLayoutHints(0, 1);
                gridLayoutHints36.visibleConditions = -11;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints35, gridLayoutHints36}, new Object[]{gridLayout10, gridLayout11});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController24);
                menuItemController.add(abstractWidgetController25);
                menuItemController.add(abstractWidgetController27);
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
                iconController.setBitmaps(new int[]{127, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 1166475520, 1183252736, 1200029952, 1216807168, 1233584384, 1250361600, 1267138816, 1283916032});
                iconController.setModelColumn(4);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 1: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(0);
                return labelController;
            }
            case 2: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(1);
                return labelController;
            }
            case 3: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 981926144, 1149698304, 998703360, 1015480576, 1032257792});
                iconController.setModelColumn(5);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 4: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setModelColumn(2);
                return labelController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127});
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
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
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-1316224768, -1316224768, -1299447552});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(12);
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(9);
                return labelController;
            }
            case 9: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 1166475520, 1183252736, 1200029952, 1216807168, 1233584384, 1250361600, 1267138816, 1283916032});
                iconController.setModelColumn(4);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 10: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setModelColumn(0);
                return labelController;
            }
            case 11: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setModelColumn(11);
                return labelController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                return labelController;
            }
            case 13: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(6, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(10);
                return labelController;
            }
            case 14: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 981926144, 1149698304, 998703360, 1015480576, 1032257792});
                iconController.setModelColumn(5);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 15: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 1300693248, -494534400});
                iconController.setModelColumn(14);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 16: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 344391936, -1383726848});
                iconController.setModelColumn(13);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 17: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 847708416});
                iconController.setModelColumn(6);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 18: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(7);
                return labelController;
            }
            case 19: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 864485632});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 20: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(9);
                return labelController;
            }
            case 21: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 1065812224});
                iconController.setModelColumn(17);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 22: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(18);
                return labelController;
            }
            case 23: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setColorIndices(new int[]{1, 4, 4, 0});
                labelController.setModelColumn(0);
                return labelController;
            }
            case 24: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setColorIndices(new int[]{1, 4, 4, 0});
                labelController.setModelColumn(1);
                return labelController;
            }
            case 25: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setColorIndices(new int[]{1, 4, 4, 0});
                labelController.setModelColumn(2);
                return labelController;
            }
        }
        return null;
    }
}

