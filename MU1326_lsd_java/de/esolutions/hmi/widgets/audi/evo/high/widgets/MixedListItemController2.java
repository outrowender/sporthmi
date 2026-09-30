/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.ObjectListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.IGridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListController2;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayout;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayoutPackage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListPlaceholder;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListPlaceholderContainer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListTollGateInfoController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListTollGateInfoRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureFrameController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PictureFrameRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MixedListItemController2
extends LayoutContainerController
implements MixedListConstants {
    private MixedListController2 parentController;
    private MixedListLayout currentPixelExactLayout;
    private int currentPosition = -1;
    private int currentContentNode = -1;
    private int currentModelRow = -1;
    private boolean isSetUp = false;
    private boolean isDoubleSized = false;
    private int currentFormat = -1;
    private boolean isOldData = false;
    protected CellInstance[] cellInstances;
    private Map iconLabelMapToPlaceHolder = new HashMap();

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        if (this.parentController != null && this.parentController.isActive()) {
            this.setupWidget();
        }
    }

    private AbstractWidget createContainerCellInstance(MixedListPlaceholderContainer mixedListPlaceholderContainer, ListCell[] listCellArray, CellInstance cellInstance) {
        LayoutContainerController layoutContainerController = new LayoutContainerController();
        CompositeRendererHigh compositeRendererHigh = new CompositeRendererHigh(layoutContainerController);
        layoutContainerController.setRenderer(compositeRendererHigh);
        GridLayout gridLayout = MixedListItemController2.copyLayout(mixedListPlaceholderContainer.layout);
        int n = mixedListPlaceholderContainer.placeholder.length;
        Object[] objectArray = new Object[n];
        IGridLayoutHints[] iGridLayoutHintsArray = new GridLayoutHints[n];
        cellInstance.grid = new CellInstance[n];
        for (int i2 = 0; i2 < n; ++i2) {
            CellInstance cellInstance2 = new CellInstance();
            this.createCellInstance(mixedListPlaceholderContainer.placeholder[i2], listCellArray, cellInstance2);
            objectArray[i2] = cellInstance2.getWidget();
            iGridLayoutHintsArray[i2] = MixedListItemController2.copyHint(mixedListPlaceholderContainer.hints[i2]);
            layoutContainerController.add(cellInstance2.getWidget());
            cellInstance.grid[i2] = cellInstance2;
        }
        gridLayout.setCellConstraints(iGridLayoutHintsArray, objectArray);
        layoutContainerController.setLayoutManager(gridLayout);
        cellInstance.widget = layoutContainerController;
        cellInstance.isPrimaryCell = true;
        return layoutContainerController;
    }

    private void createCellInstance(MixedListPlaceholder mixedListPlaceholder, ListCell[] listCellArray, CellInstance cellInstance) {
        AbstractWidget abstractWidget = this.createCellInstance(mixedListPlaceholder, listCellArray);
        this.iconLabelMapToPlaceHolder.put(abstractWidget, mixedListPlaceholder);
        if (abstractWidget == null) {
            if (mixedListPlaceholder.secondaryEntity != null) {
                abstractWidget = this.createCellInstance(mixedListPlaceholder.secondaryEntity, listCellArray);
            }
            cellInstance.isPrimaryCell = false;
        } else {
            cellInstance.isPrimaryCell = true;
        }
        cellInstance.widget = abstractWidget;
    }

    private AbstractWidget createCellInstance(MixedListPlaceholder mixedListPlaceholder, ListCell[] listCellArray) {
        MixedListPlaceholder mixedListPlaceholder2 = mixedListPlaceholder;
        if (mixedListPlaceholder2 == null) {
            mixedListItemLogCh.log(10000, "MixedListItemController#createCell Placeholder is null.");
            return null;
        }
        ListCell listCell = null;
        int n = mixedListPlaceholder2.getModelColumn();
        if (n != -1) {
            if (listCellArray == null) {
                mixedListItemLogCh.log(10000, "MixedListItemController#createCell data is null.");
                return null;
            }
            if (n < 0 || n >= listCellArray.length) {
                mixedListItemLogCh.log(10000, "MixedListItemController#createCell Cell index = %1 out of range %2.", (long)n, (long)listCellArray.length);
                return null;
            }
            listCell = listCellArray[n];
            if (listCell == null) {
                mixedListItemLogCh.log(100000, "MixedListItemController#createCell Cell at index %1 is null.", (long)n);
            }
        }
        mixedListItemLogCh.log(10000000, "MixedListItemController#createCell Format = %1", (long)n);
        AbstractWidgetController abstractWidgetController = null;
        switch (n) {
            case -1: {
                String string = "No content\navailable";
                abstractWidgetController = MixedListItemController2.createLabel(string);
                break;
            }
            case 4: 
            case 12: 
            case 13: 
            case 19: 
            case 26: 
            case 51: 
            case 52: {
                abstractWidgetController = MixedListItemController2.createLabelCellWidget(n, listCell, true, this.parentController);
                break;
            }
            case 3: 
            case 11: 
            case 18: 
            case 22: 
            case 25: 
            case 28: 
            case 29: 
            case 38: 
            case 49: 
            case 54: 
            case 55: 
            case 58: 
            case 66: 
            case 67: {
                abstractWidgetController = MixedListItemController2.createLabelCellWidget(n, listCell, false, this.parentController);
                break;
            }
            case 20: {
                abstractWidgetController = MixedListItemController2.createTurnArrowIcon(listCell, this.parentController);
                break;
            }
            case 1: 
            case 2: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 21: 
            case 24: 
            case 27: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 57: {
                abstractWidgetController = MixedListItemController2.createIconLabelCellWidget(listCell, mixedListPlaceholder, n, this.parentController);
                break;
            }
            case 45: {
                abstractWidgetController = MixedListItemController2.createPictureFrameCellWidget(listCell, this.parentController);
                break;
            }
            case 50: {
                if (!(mixedListPlaceholder2.additionalData instanceof Integer)) break;
                IconController iconController = MixedListItemController2.createIcon(this.parentController.getBitmap((Integer)mixedListPlaceholder2.additionalData));
                abstractWidgetController = iconController;
                break;
            }
            case 59: {
                abstractWidgetController = MixedListItemController2.createGreenCanbanCellWidget(this.parentController);
                break;
            }
            case 61: {
                abstractWidgetController = MixedListItemController2.createLaneGuidanceCellWidget(listCell, this.parentController);
                break;
            }
            case 60: {
                abstractWidgetController = MixedListItemController2.createTollGateInfoCellWidget(listCell, this.parentController);
                break;
            }
            case 63: {
                abstractWidgetController = MixedListItemController2.createDateMetricLabelCellWidget(listCell, this.parentController, 17);
                break;
            }
            case 65: {
                abstractWidgetController = MixedListItemController2.createDateMetricLabelCellWidget(listCell, this.parentController, 23);
                break;
            }
            case 62: {
                break;
            }
        }
        return abstractWidgetController;
    }

    public static IconController createIcon(int n) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{n});
        return iconController;
    }

    public static IconController createIcon(HMIResourceLocator hMIResourceLocator) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setModel(hMIResourceLocator);
        return iconController;
    }

    private static IconLabelController createIconCellWidget(IconCell iconCell) {
        IconLabelController iconLabelController = new IconLabelController();
        IconLabelRendererHigh iconLabelRendererHigh = new IconLabelRendererHigh(iconLabelController);
        iconLabelController.setRenderer(iconLabelRendererHigh);
        iconLabelController.setModel(iconCell);
        return iconLabelController;
    }

    public static LabelController createLabel(String string) {
        LabelController labelController = new LabelController();
        LabelRendererHigh labelRendererHigh = new LabelRendererHigh(labelController);
        labelController.setRenderer(labelRendererHigh);
        labelController.setText(string);
        return labelController;
    }

    private static LabelController createLabelWithTextDescriptorRenderer(StringBuffer stringBuffer) {
        LabelController labelController = new LabelController();
        TextDescriptorLabelRenderer textDescriptorLabelRenderer = new TextDescriptorLabelRenderer(labelController);
        labelController.setRenderer(textDescriptorLabelRenderer);
        labelController.setLineDescription(TextDescriptorLabelRenderer.parseTextDescriptorAsList(stringBuffer));
        textDescriptorLabelRenderer.setAbbreviateText(true);
        return labelController;
    }

    private static LabelController createLabelWithTextDescriptorRenderer(AbstractMetrics abstractMetrics) {
        LabelController labelController = new LabelController();
        TextDescriptorLabelRenderer textDescriptorLabelRenderer = new TextDescriptorLabelRenderer(labelController);
        labelController.setRenderer(textDescriptorLabelRenderer);
        labelController.setModel(abstractMetrics);
        textDescriptorLabelRenderer.setAbbreviateText(true);
        return labelController;
    }

    protected void destroyRendererNode() {
        mixedListItemLogCh.log(100000000, "MixedListItemController2#destroyRendererNode");
        CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.getRenderer();
        compositeRendererHigh.destroyNode();
        this.setCompositesDirty(true);
    }

    public void disconnecting() {
        mixedListItemLogCh.log(100000000, "MixedListItemController2#disconnecting pos = %1, content = %2", (long)this.currentPosition, (long)this.currentContentNode);
        super.disconnecting();
    }

    protected int getCurrentContentNode() {
        return this.currentContentNode;
    }

    protected int getCurrentPosition() {
        return this.currentPosition;
    }

    protected int getCurrentModelRow() {
        return this.currentModelRow;
    }

    private static String getDebugText(int n) {
        String string = "";
        switch (n) {
            case 4: {
                string = "400 m";
                break;
            }
            case 66: {
                string = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
                break;
            }
            case 12: 
            case 26: {
                string = "in 6000 km und 60 m";
                break;
            }
            case 19: {
                string = "in 15 km";
                break;
            }
            case 3: {
                string = "Unfall";
                if (MixedListLayoutPackage.isNAR) {
                    string = "Slow traffic";
                }
                if (!MixedListLayoutPackage.isAsia) break;
                string = "Slow traffic qqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
                break;
            }
            case 38: {
                string = "in km/h";
                break;
            }
            case 28: {
                string = "Geltende";
                if (!MixedListController2.isMMIKombi()) break;
                string = "Tempolimits";
                break;
            }
            case 29: {
                string = "Geschwindigkeiten";
                break;
            }
            case 22: {
                string = "Calculating...";
                break;
            }
            case 25: {
                string = "Grenz\u00fcbertritt";
                break;
            }
            case 11: {
                string = "RASTHOF F\u00dcRHOLZEN";
                break;
            }
            case 18: 
            case 58: {
                string = "ST2236";
                string = "Gerolfinger...";
                break;
            }
            case 49: {
                string = "W";
                break;
            }
            case 13: {
                string = "1 Hrs. 10 min.";
                break;
            }
            case 54: 
            case 55: {
                string = "HHHHHJJJJJJJJJHHH";
                break;
            }
            case 51: {
                string = "00 km";
                break;
            }
            case 52: {
                string = "10 h 17 min";
                break;
            }
            default: {
                string = "Unknown cell index";
            }
        }
        return string;
    }

    private static int getDebugImageIndex(int n) {
        int n2 = 0;
        switch (n) {
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                n2 = 5;
                break;
            }
            case 30: 
            case 31: 
            case 32: 
            case 33: {
                n2 = 4;
                break;
            }
            case 27: {
                n2 = 2;
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                n2 = 3;
                break;
            }
            case 2: 
            case 21: 
            case 57: {
                n2 = 1;
                if (!MixedListLayoutPackage.isNAR) break;
                n2 = 15;
                break;
            }
            case 1: {
                n2 = 12;
                if (!MixedListLayoutPackage.isNAR) break;
                n2 = 14;
                break;
            }
            case 24: {
                n2 = 13;
                break;
            }
        }
        return n2;
    }

    private static MixedListConstants.TollGateInfo getDebugTollGateInfo() {
        MixedListConstants.TollGateInfo tollGateInfo = new MixedListConstants.TollGateInfo();
        MixedListConstants.TollgateType_enum[] tollgateType_enumArray = new MixedListConstants.TollgateType_enum[]{MixedListConstants.TollgateType_enum.ETC_AND_GENERAL_COMBINED, MixedListConstants.TollgateType_enum.ETC_GENERAL_ONLY, MixedListConstants.TollgateType_enum.ETC_DEDICATED, MixedListConstants.TollgateType_enum.ETC_AND_GENERAL_COMBINED, MixedListConstants.TollgateType_enum.ETC_GENERAL_ONLY, MixedListConstants.TollgateType_enum.ETC_DEDICATED};
        tollGateInfo.setTollGateTypes(tollgateType_enumArray);
        return tollGateInfo;
    }

    private static MixedListConstants.LaneGuidance getDebugLaneGuidance() {
        MixedListConstants.LaneArrowCombined[] laneArrowCombinedArray = new MixedListConstants.LaneArrowCombined[3];
        laneArrowCombinedArray[0] = new MixedListConstants.LaneArrowCombined(1, 2);
        MixedListConstants.LaneArrow laneArrow = new MixedListConstants.LaneArrow(0, 0, 0);
        MixedListConstants.LaneArrow laneArrow2 = new MixedListConstants.LaneArrow(2, 0, 1);
        laneArrowCombinedArray[0].arrows = new MixedListConstants.LaneArrow[]{laneArrow, laneArrow2};
        laneArrowCombinedArray[1] = new MixedListConstants.LaneArrowCombined(1, 0);
        MixedListConstants.LaneArrow laneArrow3 = new MixedListConstants.LaneArrow(0, 0, 0);
        MixedListConstants.LaneArrow laneArrow4 = new MixedListConstants.LaneArrow(2, 0, 1);
        laneArrowCombinedArray[1].arrows = new MixedListConstants.LaneArrow[]{laneArrow3, laneArrow4};
        laneArrowCombinedArray[2] = new MixedListConstants.LaneArrowCombined(1, 1);
        MixedListConstants.LaneArrow laneArrow5 = new MixedListConstants.LaneArrow(4, 3, 1);
        laneArrowCombinedArray[2].arrows = new MixedListConstants.LaneArrow[]{laneArrow5};
        MixedListConstants.LaneGuidance laneGuidance = new MixedListConstants.LaneGuidance();
        laneGuidance.setDirectionArrow(laneArrowCombinedArray);
        return laneGuidance;
    }

    private static boolean refreshLabelTextCell(MixedListPlaceholder mixedListPlaceholder, CellInstance cellInstance, ListCell[] listCellArray, ListCell[] listCellArray2) {
        if (mixedListPlaceholder instanceof MixedListPlaceholderContainer) {
            boolean bl = false;
            MixedListPlaceholderContainer mixedListPlaceholderContainer = (MixedListPlaceholderContainer)mixedListPlaceholder;
            for (int i2 = 0; i2 < mixedListPlaceholderContainer.placeholder.length; ++i2) {
                CellInstance cellInstance2 = cellInstance.grid[i2];
                MixedListPlaceholder mixedListPlaceholder2 = mixedListPlaceholderContainer.placeholder[i2];
                MixedListPlaceholder mixedListPlaceholder3 = mixedListPlaceholder2 = cellInstance2.isPrimaryCell ? mixedListPlaceholder2 : mixedListPlaceholder2.secondaryEntity;
                if (mixedListPlaceholder2 == null) continue;
                bl |= MixedListItemController2.refreshLabelTextCell(mixedListPlaceholder2, cellInstance2, listCellArray, listCellArray2);
            }
            if (cellInstance.widget instanceof LayoutContainerController) {
                ((LayoutContainerController)cellInstance.widget).invalidateLayout(null);
            }
            return bl;
        }
        int n = mixedListPlaceholder.getModelColumn();
        if (n < 0) {
            return false;
        }
        if (listCellArray2[n] == null || listCellArray[n] == null) {
            mixedListItemLogCh.log(100000, "MixedListItemController2#refreshDistanceCell Data cell with index %1 is null.", (long)n);
            return false;
        }
        switch (n) {
            case 4: 
            case 12: 
            case 13: 
            case 19: 
            case 26: 
            case 51: 
            case 52: {
                return MixedListItemController2.refreshLabelTextCellForString(listCellArray2[n], listCellArray[n], cellInstance, n, true);
            }
            case 62: 
            case 63: 
            case 65: {
                return MixedListItemController2.refreshLabelTextCellForMetric(listCellArray2[n], listCellArray[n], cellInstance, n);
            }
            case 3: 
            case 11: 
            case 18: 
            case 22: 
            case 25: 
            case 28: 
            case 29: 
            case 38: 
            case 49: 
            case 54: 
            case 55: 
            case 58: 
            case 66: 
            case 67: {
                return MixedListItemController2.refreshLabelTextCellForString(listCellArray2[n], listCellArray[n], cellInstance, n, false);
            }
        }
        return false;
    }

    private static boolean refreshLabelTextCellForString(ListCell listCell, ListCell listCell2, CellInstance cellInstance, int n, boolean bl) {
        String string;
        String string2 = ((TextListCell)listCell).getText();
        if (StringUtilities.equals(string2, string = ((TextListCell)listCell2).getText())) {
            mixedListItemLogCh.log(10000000, "MixedListItemController2#refreshLabelTextCell LabelText for cell = %1 did not change.", (long)n);
            return false;
        }
        LabelController labelController = (LabelController)cellInstance.getWidget();
        if (bl) {
            StringBuffer stringBuffer = TextDescriptorLabelRenderer.createTextDescriptorFromMetricsData(string);
            labelController.setLineDescription(TextDescriptorLabelRenderer.parseTextDescriptorAsList(stringBuffer));
        } else {
            labelController.setText(string);
        }
        labelController.updateContent();
        labelController.setCompositesDirty(true);
        mixedListItemLogCh.log(10000000, "MixedListItemController2#refreshDistanceCell for %2 new value = %1", (Object)string, (long)n);
        return true;
    }

    private static boolean refreshLabelTextCellForMetric(ListCell listCell, ListCell listCell2, CellInstance cellInstance, int n) {
        long l;
        long l2 = ((LongListCell)listCell).getValue();
        if (l2 == (l = ((LongListCell)listCell2).getValue())) {
            mixedListItemLogCh.log(10000000, "MixedListItemController2#refreshDistanceCell Distance for cell = %1 did not change.", (long)n);
            return false;
        }
        LabelController labelController = (LabelController)cellInstance.getWidget();
        AbstractMetrics abstractMetrics = (AbstractMetrics)labelController.getModel();
        if (abstractMetrics instanceof DateMetric) {
            ((DateMetric)abstractMetrics).setDate(new Date(l));
        } else {
            abstractMetrics.setValue(l);
        }
        labelController.updateContent();
        labelController.setCompositesDirty(true);
        mixedListItemLogCh.log(10000000, "MixedListItemController2#refreshDistanceCell for %2 new value = %1", l, (long)n);
        return true;
    }

    private static void refreshLabelTextsForPixelExactLayout(MixedListLayout mixedListLayout, ListCell[] listCellArray, ListCell[] listCellArray2, CellInstance[] cellInstanceArray) {
        mixedListLogChannel.log(10000000, "MixedListItemController#refreshLabelTextsForPixelExactLayout");
        List list = mixedListLayout.getChildren();
        int n = list.size();
        for (int i2 = 0; i2 < n; ++i2) {
            CellInstance cellInstance = cellInstanceArray[i2];
            MixedListPlaceholder mixedListPlaceholder = (MixedListPlaceholder)list.get(i2);
            MixedListPlaceholder mixedListPlaceholder2 = mixedListPlaceholder = cellInstance.isPrimaryCell ? mixedListPlaceholder : mixedListPlaceholder.secondaryEntity;
            if (mixedListPlaceholder == null) continue;
            AbstractWidgetController abstractWidgetController = cellInstance.getWidget();
            if (abstractWidgetController != null) {
                if (!MixedListItemController2.refreshLabelTextCell(mixedListPlaceholder, cellInstance, listCellArray, listCellArray2)) continue;
                MixedListItemController2.positionCell(mixedListPlaceholder, abstractWidgetController);
                continue;
            }
            mixedListLogChannel.log(10000, "MixedListItemController#refreshDistancesForPixelExactLayout Could not refresh distance for cell %1 in layout %2.", (long)mixedListPlaceholder.getModelColumn(), (long)mixedListLayout.getLayoutFormat());
        }
    }

    private static void positionCell(MixedListPlaceholder mixedListPlaceholder, AbstractWidgetController abstractWidgetController) {
        int n = mixedListPlaceholder.getX();
        int n2 = mixedListPlaceholder.getY();
        int n3 = mixedListPlaceholder.getWidth();
        int n4 = mixedListPlaceholder.getHeight();
        int n5 = abstractWidgetController.getPreferredWidth();
        int n6 = abstractWidgetController.getPreferredHeight();
        if (mixedListItemLogCh.isDebug()) {
            String string = "MixedListItemController#positionCell cell = %3, x = %1, y = %2, w = %6, h = %7, pw = %4, ph = %5";
            string = StringUtilities.formatMessage(string, new int[]{n, n2, mixedListPlaceholder.getModelColumn(), n3, n4, n5, n6});
            mixedListItemLogCh.log(10000000, string);
        }
        if (mixedListPlaceholder.isCenterAligned()) {
            int n7 = n - n5 / 2;
            int n8 = n2 - n6 / 2;
            abstractWidgetController.setBounds(n7, n8, n5, n6);
            return;
        }
        if (abstractWidgetController instanceof LabelController) {
            abstractWidgetController.setBounds(n, n2, n3, n4);
            ((LabelRenderer)abstractWidgetController.getRenderer()).setAlignment(mixedListPlaceholder.getHorizontalAlignment(), mixedListPlaceholder.getVerticalAlignment());
            return;
        }
        if (abstractWidgetController instanceof IconController) {
            abstractWidgetController.setBounds(n, n2, n3, n4);
            ((IconRenderer)abstractWidgetController.getRenderer()).setAlignment(mixedListPlaceholder.getHorizontalAlignment(), mixedListPlaceholder.getVerticalAlignment());
            return;
        }
        if (abstractWidgetController instanceof IconLabelController) {
            if (mixedListPlaceholder.getModelColumn() == 24 && n5 > n3) {
                float f2 = (float)n3 / (float)n5;
                ((IconLabelRendererHigh)abstractWidgetController.getRenderer()).setScaleFactor(f2, 1.0f);
            }
            abstractWidgetController.setBounds(n, n2, n3, n4);
            ((IconRenderer)abstractWidgetController.getRenderer()).setAlignment(mixedListPlaceholder.getHorizontalAlignment(), mixedListPlaceholder.getVerticalAlignment());
            return;
        }
        abstractWidgetController.setBounds(n, n2, n3, n4);
    }

    public void refreshLabelTexts(ListCell[] listCellArray, ListCell[] listCellArray2) {
        if (this.currentPixelExactLayout != null) {
            MixedListItemController2.refreshLabelTextsForPixelExactLayout(this.currentPixelExactLayout, listCellArray, listCellArray2, this.cellInstances);
        }
    }

    protected void removeChildren() {
        mixedListItemLogCh.log(100000000, "MixedListItemController2#removeChildren pos = %1", (long)this.currentPosition);
        this.setLayoutManager(null);
        List list = this.getChildren();
        while (!list.isEmpty()) {
            this.remove((AbstractWidget)list.get(0));
        }
    }

    protected void setDoubleSized(boolean bl) {
        this.isDoubleSized = bl;
        if (!this.isDoubleSized) {
            this.setHeight(MixedListController2.getInnerHeight());
        } else {
            this.setHeight(MixedListController2.getInnerHeightDoubleSize());
        }
    }

    protected void setParentController(MixedListController2 mixedListController2) {
        this.parentController = mixedListController2;
    }

    protected void setCurrentContentNode(int n) {
        this.currentContentNode = n;
    }

    protected void setCurrentPosition(int n) {
        this.currentPosition = n;
    }

    private void setupPixelExactLayout(MixedListLayout mixedListLayout, ListCell[] listCellArray) {
        this.currentPixelExactLayout = mixedListLayout;
        List list = mixedListLayout.getChildren();
        int n = list.size();
        this.cellInstances = new CellInstance[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = list.get(i2);
            if (!(object instanceof MixedListPlaceholder)) continue;
            MixedListPlaceholder mixedListPlaceholder = (MixedListPlaceholder)object;
            CellInstance cellInstance = new CellInstance();
            if (mixedListPlaceholder instanceof MixedListPlaceholderContainer) {
                this.createContainerCellInstance((MixedListPlaceholderContainer)mixedListPlaceholder, listCellArray, cellInstance);
            } else {
                this.createCellInstance(mixedListPlaceholder, listCellArray, cellInstance);
            }
            this.cellInstances[i2] = cellInstance;
            AbstractWidgetController abstractWidgetController = cellInstance.getWidget();
            if (abstractWidgetController != null) {
                if (this.getChildren().contains(abstractWidgetController)) continue;
                this.add(abstractWidgetController);
                MixedListItemController2.positionCell(cellInstance.isPrimaryCell ? mixedListPlaceholder : mixedListPlaceholder.secondaryEntity, abstractWidgetController);
                continue;
            }
            mixedListItemLogCh.log(100000, "MixedListItemController2#setupPixelExactLayout Widget is null.");
        }
    }

    private void setupWidget() {
        if (!this.isSetUp) {
            MixedListLayout mixedListLayout = this.parentController.getPixelExactLayout(-1);
            if (mixedListLayout != null) {
                mixedListItemLogCh.log(10000000, "MixedListItemController#setupWidget setup layout");
                this.setupPixelExactLayout(mixedListLayout, null);
            } else {
                mixedListItemLogCh.log(10000, "MixedListItemController#setupWidget Missing pixel exact Layout no. %1", -1L);
            }
        }
        this.isSetUp = true;
    }

    public void setupWidgetAndLayout(ListCell[] listCellArray, int n, boolean bl) {
        MixedListLayout mixedListLayout;
        mixedListItemLogCh.log(100000000, "MixedListItemController#setupWidgetAndLayout at pos = %1", (long)this.currentPosition);
        this.iconLabelMapToPlaceHolder.clear();
        this.currentModelRow = n;
        int n2 = -1;
        if (listCellArray != null && listCellArray[0] != null) {
            n2 = ((IntegerListCell)listCellArray[0]).getValue();
        }
        this.currentFormat = n2;
        this.isOldData = bl;
        if (this.parentController.isDebugMode()) {
            this.currentFormat = bl ? this.parentController.oldFormatIDs[this.currentModelRow] : this.parentController.newFormatIDs[this.currentModelRow];
        }
        if ((mixedListLayout = this.parentController.getPixelExactLayout(this.currentFormat)) == null) {
            mixedListLayout = this.parentController.getPixelExactLayout(-1);
        }
        this.setupPixelExactLayout(mixedListLayout, listCellArray);
    }

    protected boolean isOldData() {
        return this.isOldData;
    }

    protected void setIsOldData(boolean bl) {
        this.isOldData = bl;
    }

    private static GridLayoutHints copyHint(GridLayoutHints gridLayoutHints) {
        GridLayoutHints gridLayoutHints2 = new GridLayoutHints(gridLayoutHints.getColumn(), gridLayoutHints.getRow());
        gridLayoutHints2.setAlignmentHoriz(gridLayoutHints.getAlignmentHoriz());
        gridLayoutHints2.setAlignmentVert(gridLayoutHints.getAlignmentVert());
        return gridLayoutHints2;
    }

    private static GridLayout copyLayout(GridLayout gridLayout) {
        GridLayout gridLayout2 = new GridLayout();
        AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
        AxisConstraints axisConstraints2 = new AxisConstraints(axisConstraints.getLength());
        axisConstraints2.gaps = axisConstraints.gaps;
        axisConstraints2.grow = axisConstraints.grow;
        axisConstraints2.shrink = axisConstraints.shrink;
        axisConstraints2.alignment = axisConstraints.alignment;
        axisConstraints2.min = axisConstraints.min;
        axisConstraints2.max = axisConstraints.max;
        axisConstraints2.hidemode = axisConstraints.hidemode;
        gridLayout2.setColumnConstraints(axisConstraints2);
        AxisConstraints axisConstraints3 = (AxisConstraints)gridLayout.getRowConstraints();
        AxisConstraints axisConstraints4 = new AxisConstraints(axisConstraints3.getLength());
        axisConstraints4.gaps = axisConstraints3.gaps;
        axisConstraints4.grow = axisConstraints3.grow;
        axisConstraints4.shrink = axisConstraints3.shrink;
        axisConstraints4.alignment = axisConstraints3.alignment;
        axisConstraints4.min = axisConstraints3.min;
        axisConstraints4.max = axisConstraints3.max;
        gridLayout2.setRowConstraints(axisConstraints4);
        return gridLayout2;
    }

    private static LabelController createDateMetricLabelCellWidget(ListCell listCell, MixedListController2 mixedListController2, int n) {
        long l = 0L;
        if (mixedListController2.isDebugMode()) {
            l = 10000000L;
        } else if (listCell instanceof LongListCell) {
            l = ((LongListCell)listCell).getValue();
        }
        DateMetric dateMetric = new DateMetric(new Date(l), n);
        return MixedListItemController2.createLabelWithTextDescriptorRenderer(dateMetric);
    }

    private static MixedListTollGateInfoController createTollGateInfoCellWidget(ListCell listCell, MixedListController2 mixedListController2) {
        MixedListTollGateInfoController mixedListTollGateInfoController = new MixedListTollGateInfoController();
        MixedListTollGateInfoRenderer mixedListTollGateInfoRenderer = new MixedListTollGateInfoRenderer(mixedListTollGateInfoController);
        mixedListTollGateInfoController.setRenderer(mixedListTollGateInfoRenderer);
        MixedListConstants.TollGateInfo tollGateInfo = null;
        if (!mixedListController2.isDebugMode()) {
            if (listCell instanceof ObjectListCell) {
                ObjectListCell objectListCell = (ObjectListCell)listCell;
                if (objectListCell.value instanceof MixedListConstants.TollGateInfo) {
                    tollGateInfo = (MixedListConstants.TollGateInfo)objectListCell.value;
                }
            }
        } else {
            tollGateInfo = MixedListItemController2.getDebugTollGateInfo();
        }
        mixedListTollGateInfoController.setModel(tollGateInfo);
        mixedListTollGateInfoController.updateContent();
        return mixedListTollGateInfoController;
    }

    private static MixedListLaneGuidanceController createLaneGuidanceCellWidget(ListCell listCell, MixedListController2 mixedListController2) {
        MixedListLaneGuidanceController mixedListLaneGuidanceController = new MixedListLaneGuidanceController();
        MixedListLaneGuidanceRenderer mixedListLaneGuidanceRenderer = new MixedListLaneGuidanceRenderer(mixedListLaneGuidanceController);
        mixedListLaneGuidanceController.setRenderer(mixedListLaneGuidanceRenderer);
        MixedListConstants.LaneGuidance laneGuidance = null;
        if (!mixedListController2.isDebugMode()) {
            if (listCell instanceof ObjectListCell) {
                ObjectListCell objectListCell = (ObjectListCell)listCell;
                if (objectListCell.value instanceof MixedListConstants.LaneGuidance) {
                    laneGuidance = (MixedListConstants.LaneGuidance)objectListCell.value;
                }
            }
        } else {
            laneGuidance = MixedListItemController2.getDebugLaneGuidance();
        }
        mixedListLaneGuidanceController.setModel(laneGuidance);
        mixedListLaneGuidanceController.updateContent();
        return mixedListLaneGuidanceController;
    }

    private static PictureFrameController createGreenCanbanCellWidget(MixedListController2 mixedListController2) {
        PictureFrameController pictureFrameController = new PictureFrameController();
        PictureFrameRenderer pictureFrameRenderer = new PictureFrameRenderer(pictureFrameController);
        pictureFrameController.setRenderer(pictureFrameRenderer);
        pictureFrameController.setType(3);
        return pictureFrameController;
    }

    private static PictureFrameController createPictureFrameCellWidget(ListCell listCell, MixedListController2 mixedListController2) {
        PictureFrameController pictureFrameController = new PictureFrameController();
        PictureFrameRenderer pictureFrameRenderer = new PictureFrameRenderer(pictureFrameController);
        pictureFrameController.setRenderer(pictureFrameRenderer);
        if (mixedListController2.isDebugMode()) {
            pictureFrameController.setType(2);
            pictureFrameController.setBitmaps(mixedListController2.getBitmapIndices());
            pictureFrameController.setValue(2);
        } else {
            pictureFrameController.setType(0);
            if (listCell instanceof IconCell) {
                IconCell iconCell = (IconCell)listCell;
                pictureFrameController.setModel(iconCell.getResourceLocator());
                mixedListItemLogCh.log(10000000, "MixedListItemController#createCell Destination image available = %1", (Object)iconCell.getResourceLocator());
            } else {
                mixedListItemLogCh.log(10000000, "MixedListItemController#createCell Destination image not available");
            }
        }
        return pictureFrameController;
    }

    private static AbstractWidgetController createIconLabelCellWidget(ListCell listCell, MixedListPlaceholder mixedListPlaceholder, int n, MixedListController2 mixedListController2) {
        if (!mixedListController2.isDebugMode()) {
            IconCell iconCell = null;
            if (listCell instanceof IconCell) {
                iconCell = (IconCell)listCell;
            }
            boolean bl = IconLabelController.isImageAvailable(iconCell);
            if (mixedListItemLogCh.isDebug()) {
                HMIResourceLocator hMIResourceLocator = iconCell != null ? iconCell.getResourceLocator() : null;
                mixedListItemLogCh.log(10000000, "MixedListItemController#createCell IconCell available = %1, value = %2", bl, (Object)hMIResourceLocator);
            }
            if (mixedListPlaceholder.secondaryEntity == null || bl) {
                return MixedListItemController2.createIconCellWidget(iconCell);
            }
            return null;
        }
        int n2 = MixedListItemController2.getDebugImageIndex(n);
        return MixedListItemController2.createIcon(mixedListController2.getBitmap(n2));
    }

    private static IconController createTurnArrowIcon(ListCell listCell, MixedListController2 mixedListController2) {
        int n = framework.isTarget() ? 12 : 16;
        int n2 = 1;
        if (!mixedListController2.isDebugMode() && listCell instanceof IntegerListCell) {
            n2 = ((IntegerListCell)listCell).getValue();
        }
        if (n2 == -1) {
            n2 = 1;
        }
        int n3 = mixedListController2.getBitmap(n + n2);
        mixedListItemLogCh.log(10000000, "MixedListItemController#createCell Bitmap cell with bitmapIndex = %1, bitmapID = %2", (long)n2, (long)n3);
        return MixedListItemController2.createIcon(n3);
    }

    private static LabelController createLabelCellWidget(int n, ListCell listCell, boolean bl, MixedListController2 mixedListController2) {
        LabelController labelController = null;
        String string = "";
        if (mixedListController2.isDebugMode()) {
            string = MixedListItemController2.getDebugText(n);
        } else if (listCell instanceof TextListCell) {
            string = ((TextListCell)listCell).getText();
        }
        if (bl) {
            if (string != null) {
                LabelController labelController2;
                StringBuffer stringBuffer = TextDescriptorLabelRenderer.createTextDescriptorFromMetricsData(string);
                mixedListItemLogCh.log(10000000, "MixedListItemController#createLabelCellWidget Textdescriptor = %1", (Object)(stringBuffer != null ? stringBuffer.toString() : null));
                labelController = labelController2 = MixedListItemController2.createLabelWithTextDescriptorRenderer(stringBuffer);
            }
        } else {
            labelController = MixedListItemController2.createLabel(string);
        }
        mixedListItemLogCh.log(10000000, "MixedListItemController#createLabelCellWidget Text cell with text = %1", (Object)string);
        return labelController;
    }

    public void invalidateLayout(AbstractWidget abstractWidget) {
        MixedListPlaceholder mixedListPlaceholder = (MixedListPlaceholder)this.iconLabelMapToPlaceHolder.get(abstractWidget);
        if (this.isSetUp && mixedListPlaceholder != null && abstractWidget != null) {
            MixedListItemController2.positionCell(mixedListPlaceholder, (AbstractWidgetController)abstractWidget);
        }
    }

    private static class CellInstance {
        Object widget;
        boolean isPrimaryCell;
        CellInstance[] grid;

        private CellInstance() {
        }

        public AbstractWidgetController getWidget() {
            return (AbstractWidgetController)this.widget;
        }
    }
}

