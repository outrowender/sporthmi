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

final class TunerScreenBag1$17
implements ListItemFactory {
    private final /* synthetic */ TunerScreenFactory val$factory;
    private final /* synthetic */ int val$terminalID;

    TunerScreenBag1$17(TunerScreenFactory tunerScreenFactory, int n) {
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
                MenuItemColumnsConstraints menuItemColumnsConstraints2 = new MenuItemColumnsConstraints(6);
                menuItemColumnsConstraints2.alignment = new int[]{8, 8, 1, 8, 8, 8};
                menuItemColumnsConstraints2.gaps = new int[]{0, 15, 12, 12, 12, 0, 0};
                menuItemColumnsConstraints2.grow = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints2.shrink = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints2.hidemode = new int[]{2, 0, 2, 0, 0, 2};
                gridLayout2.setColumnConstraints(menuItemColumnsConstraints2);
                AxisConstraints axisConstraints2 = new AxisConstraints(1);
                axisConstraints2.alignment = new int[]{5};
                gridLayout2.setRowConstraints(axisConstraints2);
                AbstractWidgetController abstractWidgetController = this.createCell(0);
                GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController2 = this.createCell(1);
                GridLayoutHints gridLayoutHints2 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController3 = this.createCell(2);
                GridLayoutHints gridLayoutHints3 = new GridLayoutHints(2, 0);
                AbstractWidgetController abstractWidgetController4 = this.createCell(3);
                GridLayoutHints gridLayoutHints4 = new GridLayoutHints(3, 0);
                gridLayoutHints4.widthMax = 162;
                gridLayoutHints4.widthMin = 162;
                gridLayoutHints4.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController5 = this.createCell(4);
                GridLayoutHints gridLayoutHints5 = new GridLayoutHints(4, 0);
                gridLayoutHints5.widthMax = 40;
                gridLayoutHints5.widthMin = 40;
                gridLayoutHints5.visibleConditions = -13;
                AbstractWidgetController abstractWidgetController6 = this.createCell(5);
                GridLayoutHints gridLayoutHints6 = new GridLayoutHints(5, 0);
                gridLayoutHints6.visibleConditions = -4;
                gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5, gridLayoutHints6}, new Object[]{abstractWidgetController, abstractWidgetController2, abstractWidgetController3, abstractWidgetController4, abstractWidgetController5, abstractWidgetController6});
                GridLayoutHints gridLayoutHints7 = new GridLayoutHints(0, 0);
                GridLayout gridLayout3 = new GridLayout();
                MenuItemColumnsConstraints menuItemColumnsConstraints3 = new MenuItemColumnsConstraints(3);
                menuItemColumnsConstraints3.gaps = new int[]{0, 8, 8, 0};
                menuItemColumnsConstraints3.shrink = new float[]{1.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints3.hidemode = new int[]{2, 2, 2};
                gridLayout3.setColumnConstraints(menuItemColumnsConstraints3);
                AxisConstraints axisConstraints3 = new AxisConstraints(1);
                axisConstraints3.hidemode = new int[]{2};
                gridLayout3.setRowConstraints(axisConstraints3);
                AbstractWidgetController abstractWidgetController7 = this.createCell(6);
                GridLayoutHints gridLayoutHints8 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController8 = this.createCell(7);
                GridLayoutHints gridLayoutHints9 = new GridLayoutHints(1, 0);
                AbstractWidgetController abstractWidgetController9 = this.createCell(8);
                GridLayoutHints gridLayoutHints10 = new GridLayoutHints(2, 0);
                gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints8, gridLayoutHints9, gridLayoutHints10}, new Object[]{abstractWidgetController7, abstractWidgetController8, abstractWidgetController9});
                GridLayoutHints gridLayoutHints11 = new GridLayoutHints(0, 1);
                gridLayoutHints11.visibleConditions = -11;
                gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints7, gridLayoutHints11}, new Object[]{gridLayout2, gridLayout3});
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
                menuItemColumnsConstraints5.alignment = new int[]{8, 8, 3};
                menuItemColumnsConstraints5.gaps = new int[]{0, 22, 22, 0};
                menuItemColumnsConstraints5.grow = new float[]{0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints5.shrink = new float[]{1.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints5.hidemode = new int[]{0, 2, 0};
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
                menuItemColumnsConstraints6.alignment = new int[]{8, 8, 8, 3};
                menuItemColumnsConstraints6.gaps = new int[]{0, 15, 15, 0, 0};
                menuItemColumnsConstraints6.grow = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
                menuItemColumnsConstraints6.shrink = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
                menuItemColumnsConstraints6.hidemode = new int[]{2, 2, 2, 1};
                gridLayout6.setColumnConstraints(menuItemColumnsConstraints6);
                AxisConstraints axisConstraints6 = new AxisConstraints(1);
                axisConstraints6.alignment = new int[]{5};
                axisConstraints6.hidemode = new int[]{2};
                gridLayout6.setRowConstraints(axisConstraints6);
                AbstractWidgetController abstractWidgetController14 = this.createCell(13);
                GridLayoutHints gridLayoutHints17 = new GridLayoutHints(0, 0);
                AbstractWidgetController abstractWidgetController15 = this.createCell(14);
                GridLayoutHints gridLayoutHints18 = new GridLayoutHints(1, 0);
                gridLayout6.setCellConstraints(new GridLayoutHints[]{gridLayoutHints17, gridLayoutHints18}, new Object[]{abstractWidgetController14, abstractWidgetController15});
                GridLayoutHints gridLayoutHints19 = new GridLayoutHints(0, 1);
                AbstractWidgetController abstractWidgetController16 = this.createCell(15);
                GridLayoutHints gridLayoutHints20 = new GridLayoutHints(0, 2);
                AbstractWidgetController abstractWidgetController17 = this.createCell(16);
                GridLayoutHints gridLayoutHints21 = new GridLayoutHints(0, 3);
                gridLayout4.setCellConstraints(new GridLayoutHints[]{gridLayoutHints15, gridLayoutHints16, gridLayoutHints19, gridLayoutHints20, gridLayoutHints21}, new Object[]{gridLayout5, abstractWidgetController13, gridLayout6, abstractWidgetController16, abstractWidgetController17});
                menuItemController.setLayoutChoices(new GridLayout[]{gridLayout, gridLayout4});
                menuItemController.add(abstractWidgetController);
                menuItemController.add(abstractWidgetController2);
                menuItemController.add(abstractWidgetController10);
                menuItemController.add(abstractWidgetController3);
                menuItemController.add(abstractWidgetController11);
                menuItemController.add(abstractWidgetController4);
                menuItemController.add(abstractWidgetController5);
                menuItemController.add(abstractWidgetController6);
                menuItemController.add(abstractWidgetController12);
                menuItemController.add(abstractWidgetController14);
                menuItemController.add(abstractWidgetController15);
                menuItemController.add(abstractWidgetController7);
                menuItemController.add(abstractWidgetController16);
                menuItemController.add(abstractWidgetController8);
                menuItemController.add(abstractWidgetController9);
                menuItemController.add(abstractWidgetController17);
                menuItemController.add(abstractWidgetController13);
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
                iconController.setBitmaps(new int[]{127, 194});
                iconController.setModelColumn(13);
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
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -393871104});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 3: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelController.setTextIds(new int[]{1418395904, 1435173120, 1451950336, 931856640, 1485504768, 1502281984, 1519059200, 1535836416, 1552613632, 1569390848, 1586168064, 1602945280, 1619722496, 1636499712, 1653276928, 1670054144, -1198915328, 1703608576, 1720385792, 1737163008, 1753940224, 1770717440, 1787494656, 1804271872, 1821049088, 1837826304, 1854603520, 1871380736, 1888157952, 1904935168, 1921712384, 1938489600});
                labelController.setModelColumn(5);
                return labelController;
            }
            case 4: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -947519232, -913964800, 333});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 5: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 127, 127, 333});
                iconController.setModelColumn(1);
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
                labelController.setModelColumn(2);
                return labelController;
            }
            case 7: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setTextIds(new int[]{-1316224768, -1316224768, -1299447552});
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(6);
                return labelController;
            }
            case 8: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 7, 4, 2});
                labelController.setModelColumn(3);
                return labelController;
            }
            case 9: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(2, this.val$terminalID));
                labelController.setModelColumn(0);
                return labelController;
            }
            case 10: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -393871104});
                iconController.setModelColumn(8);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 11: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -947519232, -913964800, 333});
                iconController.setModelColumn(1);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 12: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                return labelController;
            }
            case 13: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, 344391936, -1383726848});
                iconController.setModelColumn(10);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 14: {
                IconController iconController = new IconController();
                IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
                iconController.setRenderer(iconRendererHigh);
                iconController.setBitmaps(new int[]{127, -343539456, -1366949632});
                iconController.setModelColumn(11);
                iconController.setPreferredHeight(1);
                iconRendererHigh.setAlignment(1, 5);
                return iconController;
            }
            case 15: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(2);
                return labelController;
            }
            case 16: {
                LabelController labelController = new LabelController();
                LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
                labelController.setRenderer(labelRendererHigh);
                labelRendererHigh.setFonts(this.val$factory.getFonts(1, this.val$terminalID));
                labelController.setColorIndices(new int[]{1, 6, 4, 0});
                labelController.setModelColumn(3);
                return labelController;
            }
        }
        return null;
    }
}

