/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.RubberbandConstants;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.LabelRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapOverlayPlateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RubberbandController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateController;
import java.util.Date;

public class RubberbandTooltip
extends LayoutContainerController
implements RubberbandConstants {
    private static final int INDEX_FONT_TEXT;
    private static final int INDEX_FONT_UNITS;
    private static final int INDEX_FONT_AM_PM;
    private static final int MAX_WIDTH_LABEL;
    private static final int HEIGHT;
    private static final int WIDTH_ETA_LABEL;
    private static final int WIDTH_DTA_LABEL;
    private LabelController labelOriginalRoute;
    private LabelController labelDTA;
    private LabelController labelETA;
    private IconController iconFlag;
    private boolean isSetUp = false;
    private int[] textIDs;
    private DateMetric etaOriginalRoute;
    private Distance dtaOriginalRoute;

    @Override
    public void connected(InitializationContext initializationContext) {
        if (!this.isSetUp) {
            this.initializeMetrics();
        }
        this.readDataFromModel();
        this.setUpWidget();
        super.connected(initializationContext);
        this.updateContent();
    }

    private void initializeMetrics() {
        this.dtaOriginalRoute = new Distance(0.0f, 1);
        this.etaOriginalRoute = new DateMetric(new Date(0L), 1);
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        mapOverlayLogCh.log(-2137614336, "RubberbandTooltip#processModelUpdateEvent Model-ID %1, Typ %2", (long)modelUpdateEvent.getModelId(), (long)modelUpdateEvent.getUpdateType());
        this.readDataFromModel();
        this.updateContent();
    }

    private void readDataFromModel() {
        if (this.model instanceof BaseListModel) {
            EvoListRow evoListRow = ((BaseListModel)this.model).getRow(0);
            long l = RubberbandController.getTime();
            long l2 = evoListRow.getLong(1);
            boolean bl = l2 < 0L;
            this.etaOriginalRoute.setDate(bl ? -1L : l + l2);
            this.dtaOriginalRoute.setValue(evoListRow.getInteger(0));
        }
    }

    public void setTextIds(int[] nArray) {
        this.textIDs = nArray;
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            IWrappedFont[] iWrappedFontArray;
            this.isSetUp = true;
            CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.getRenderer();
            MapOverlayPlateController mapOverlayPlateController = new MapOverlayPlateController();
            MapOverlayPlateRendererHigh mapOverlayPlateRendererHigh = new MapOverlayPlateRendererHigh(mapOverlayPlateController);
            mapOverlayPlateController.setRenderer(mapOverlayPlateRendererHigh);
            this.add(mapOverlayPlateController);
            this.labelOriginalRoute = new LabelController();
            LabelRendererHigh labelRendererHigh = new LabelRendererHigh(this.labelOriginalRoute);
            this.labelOriginalRoute.setRenderer(labelRendererHigh);
            this.labelOriginalRoute.setBounds(0, 0, 180, 50);
            this.labelOriginalRoute.setTextIds(this.textIDs);
            this.add(this.labelOriginalRoute);
            this.iconFlag = new IconController();
            IconRendererHigh iconRendererHigh = new IconRendererHigh(this.iconFlag);
            this.iconFlag.setRenderer(iconRendererHigh);
            this.iconFlag.setBitmaps(this.getBitmapIndices());
            this.add(this.iconFlag);
            IWrappedFont[] iWrappedFontArray2 = iWrappedFontArray = compositeRendererHigh.getFonts();
            IWrappedFont[] iWrappedFontArray3 = iWrappedFontArray;
            if (iWrappedFontArray.length > 2) {
                iWrappedFontArray2 = new IWrappedFont[]{iWrappedFontArray[0], iWrappedFontArray[1]};
                iWrappedFontArray3 = new IWrappedFont[]{iWrappedFontArray[0], iWrappedFontArray[2]};
            }
            this.labelDTA = new LabelController();
            TextDescriptorLabelRenderer textDescriptorLabelRenderer = new TextDescriptorLabelRenderer(this.labelDTA);
            textDescriptorLabelRenderer.setAbbreviateText(true);
            this.labelDTA.setRenderer(textDescriptorLabelRenderer);
            this.labelDTA.setModel(this.dtaOriginalRoute);
            textDescriptorLabelRenderer.setFonts(iWrappedFontArray2);
            this.add(this.labelDTA);
            this.labelETA = new LabelController();
            TextDescriptorLabelRenderer textDescriptorLabelRenderer2 = new TextDescriptorLabelRenderer(this.labelETA);
            textDescriptorLabelRenderer2.setAbbreviateText(true);
            this.labelETA.setRenderer(textDescriptorLabelRenderer2);
            this.labelETA.setModel(this.etaOriginalRoute);
            textDescriptorLabelRenderer2.setFonts(iWrappedFontArray3);
            this.add(this.labelETA);
            GridLayout gridLayout = new GridLayout(4, 1);
            AxisConstraints axisConstraints = (AxisConstraints)gridLayout.getColumnConstraints();
            axisConstraints.gaps = new int[]{10, 10, 4, 10, 10};
            axisConstraints.shrink = new float[]{1.0f, 0.0f, 0.0f, 0.0f};
            GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
            gridLayoutHints.ignoreForCellSizes = true;
            gridLayoutHints.overlapGaps = 15;
            gridLayoutHints.columnSpan = 4;
            GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 0);
            gridLayoutHints2.alignmentVert = 5;
            GridLayoutHints gridLayoutHints3 = new GridLayoutHints(1, 0);
            gridLayoutHints3.heightMax = gridLayoutHints3.heightMin = 40;
            gridLayoutHints3.alignmentVert = 5;
            GridLayoutHints gridLayoutHints4 = new GridLayoutHints(2, 0);
            gridLayoutHints4.alignmentVert = 5;
            gridLayoutHints4.widthMin = 99;
            gridLayoutHints4.widthMax = 99;
            GridLayoutHints gridLayoutHints5 = new GridLayoutHints(3, 0);
            gridLayoutHints5.alignmentVert = 5;
            gridLayoutHints5.widthMin = 110;
            gridLayoutHints5.widthMax = 110;
            gridLayoutHints5.alignmentHoriz = 3;
            gridLayout.setWidgetConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2, gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new AbstractWidgetController[]{mapOverlayPlateController, this.labelOriginalRoute, this.iconFlag, this.labelDTA, this.labelETA});
            this.setLayoutManager(gridLayout);
        }
    }

    private void updateContent() {
        this.labelETA.updateContent();
        this.labelDTA.updateContent();
    }
}

