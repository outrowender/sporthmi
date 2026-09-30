/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.intercommunication.RubberbandConstants;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.util.StringUtilities;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.AxisConstraints;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayout;
import de.esolutions.hmi.widgets.audi.evo.gridlayout.GridLayoutHints;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.TextDescriptorLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LayoutContainerController;
import java.util.Date;

public class RubberbandController
extends LayoutContainerController
implements RubberbandConstants {
    private static final int INDEX_FONT_TEXT = 0;
    private static final int INDEX_FONT_AM_PM = 2;
    private static final int BITMAP_INDEX_FLAG = 0;
    private IconController flag;
    private LabelController dta;
    private LabelController eta;
    private LabelController diffDta;
    private LabelController diffEta;
    private boolean isSetUp = false;
    private Distance dtaOriginalRoute;
    private Distance dtaAlternativeRoute;
    private DateMetric etaOriginalRoute;
    private DateMetric etaAlternativeRoute;
    private DateMetric diffEtaMetric;
    private Distance diffDtaMetric;
    private boolean isFaster = false;
    private boolean isShorter = false;
    private boolean isZero = false;

    public void connected(InitializationContext initializationContext) {
        if (!this.isSetUp) {
            this.initializeMetrics();
        }
        this.readDataFromModel();
        this.setUpWidget();
        this.updateLabelPrefix();
        super.connected(initializationContext);
    }

    private static IconController createIcon(int n) {
        IconController iconController = new IconController();
        IconRendererHigh iconRendererHigh = new IconRendererHigh(iconController);
        iconController.setRenderer(iconRendererHigh);
        iconController.setBitmaps(new int[]{n});
        return iconController;
    }

    private static LabelController createLabelWithTextDescriptorRenderer() {
        LabelController labelController = new LabelController();
        TextDescriptorLabelRenderer textDescriptorLabelRenderer = new TextDescriptorLabelRenderer(labelController);
        textDescriptorLabelRenderer.setAbbreviateText(true);
        labelController.setRenderer(textDescriptorLabelRenderer);
        return labelController;
    }

    public static final long getTime() {
        AbstractMetrics abstractMetrics;
        long l = 0L;
        MetricsModelGUI metricsModelGUI = (MetricsModelGUI)((Object)hmiService.getModel(1100134));
        if (metricsModelGUI != null && (abstractMetrics = metricsModelGUI.getMetric()) instanceof DateMetric) {
            DateMetric dateMetric = (DateMetric)abstractMetrics;
            l = dateMetric.getDate().getTime();
        }
        return l;
    }

    private void initializeMetrics() {
        this.dtaOriginalRoute = new Distance(0.0f, 1);
        this.dtaAlternativeRoute = new Distance(0.0f, 1);
        this.etaOriginalRoute = new DateMetric(new Date(0L), 1);
        this.etaAlternativeRoute = new DateMetric(new Date(0L), 1);
        this.diffEtaMetric = new DateMetric(new Date(0L), 24);
        this.diffDtaMetric = new Distance(0.0f, 1);
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (this.isConnected()) {
            sideBarLogChannel.log(10000000, "RubberbandController#processModelUpdateEvent %1", (Object)modelUpdateEvent);
            this.readDataFromModel();
            this.updateLabelPrefix();
            this.eta.updateContent();
            this.dta.updateContent();
            this.diffDta.updateContent();
            this.diffEta.updateContent();
            sideBarLogChannel.log(10000000, "RubberbandController#processModelUpdateEvent Label texts: %1, %2, %3, %4", (Object)this.eta.getText(), (Object)this.dta.getText(), (Object)this.diffEta.getText(), (Object)this.diffDta.getText());
        } else {
            sideBarLogChannel.log(10000000, "RubberbandController#processModelUpdateEvent Discard event because widget is not connected.");
        }
    }

    private void readDataFromModel() {
        if (this.model instanceof BaseListModel) {
            EvoListRow evoListRow = ((BaseListModel)this.model).getRow(0);
            EvoListRow evoListRow2 = ((BaseListModel)this.model).getRow(1);
            long l = evoListRow2.getLong(1);
            int n = evoListRow2.getInteger(0);
            boolean bl = l < 0L;
            this.isZero = l == 0L;
            this.etaOriginalRoute.setDate(evoListRow.getLong(1));
            this.etaAlternativeRoute.setDate(l);
            this.dtaOriginalRoute.setValue(evoListRow.getInteger(0));
            this.dtaAlternativeRoute.setValue(n);
            long l2 = this.etaAlternativeRoute.getDate().getTime() - this.etaOriginalRoute.getDate().getTime();
            float f2 = this.dtaAlternativeRoute.getValue(1) - this.dtaOriginalRoute.getValue(1);
            if (Math.abs(l2) < 60000L) {
                l2 = 0L;
            }
            long l3 = RubberbandController.getTime();
            l = bl ? -1L : l3 + evoListRow2.getLong(1);
            this.etaAlternativeRoute.setDate(l);
            this.isFaster = l2 < 0L;
            boolean bl2 = this.isShorter = f2 < 0.0f;
            if (this.isFaster) {
                l2 *= -1L;
            }
            if (this.isShorter) {
                f2 *= -1.0f;
            }
            if (this.isZero) {
                l2 = -1L;
                f2 = -1.0f;
            }
            this.diffEtaMetric.setDate(l2);
            this.diffDtaMetric.setValue(f2);
            if (sideBarLogChannel.isDebug()) {
                String string = StringUtilities.formatMessage("RubberbandController#readDataFromModel Original route ETA = %1, DTA = %2. Alternative route ETA = %3, DTA = %4. Diff route ETA = %5, DTA = %6.", new String[]{this.etaOriginalRoute.format(), this.dtaOriginalRoute.format(), this.etaAlternativeRoute.format(), this.dtaAlternativeRoute.format(), this.diffEtaMetric.format(), this.diffDtaMetric.format()});
                sideBarLogChannel.log(10000000, string);
            }
        }
    }

    private void setUpWidget() {
        if (!this.isSetUp) {
            IWrappedFont[] iWrappedFontArray;
            this.isSetUp = true;
            this.flag = RubberbandController.createIcon(this.getBitmap(0));
            this.dta = RubberbandController.createLabelWithTextDescriptorRenderer();
            this.eta = RubberbandController.createLabelWithTextDescriptorRenderer();
            this.diffDta = RubberbandController.createLabelWithTextDescriptorRenderer();
            this.diffDta.setPrefix(1435);
            this.diffEta = RubberbandController.createLabelWithTextDescriptorRenderer();
            this.diffEta.setPrefix(1435);
            CompositeRendererHigh compositeRendererHigh = (CompositeRendererHigh)this.getRenderer();
            IWrappedFont[] iWrappedFontArray2 = iWrappedFontArray = compositeRendererHigh.getFonts();
            if (iWrappedFontArray.length > 2) {
                iWrappedFontArray2 = new IWrappedFont[]{iWrappedFontArray[0], iWrappedFontArray[2]};
            }
            TextDescriptorLabelRenderer textDescriptorLabelRenderer = (TextDescriptorLabelRenderer)this.eta.getRenderer();
            textDescriptorLabelRenderer.setFonts(iWrappedFontArray2);
            this.eta.setModel(this.etaAlternativeRoute);
            this.dta.setModel(this.dtaAlternativeRoute);
            this.diffEta.setModel(this.diffEtaMetric);
            this.diffDta.setModel(this.diffDtaMetric);
            this.add(this.flag);
            this.add(this.dta);
            this.add(this.eta);
            this.add(this.diffDta);
            this.add(this.diffEta);
            int n = 14;
            int n2 = 10;
            int n3 = 12;
            int n4 = 20;
            GridLayout gridLayout = new GridLayout(1, 2);
            ((AxisConstraints)gridLayout.getRowConstraints()).setGaps(new int[]{n3, n2, n2});
            ((AxisConstraints)gridLayout.getColumnConstraints()).setGaps(new int[]{n, n4});
            GridLayoutHints gridLayoutHints = new GridLayoutHints(0, 0);
            GridLayoutHints gridLayoutHints2 = new GridLayoutHints(0, 1);
            int n5 = this.getParent().getWidth();
            gridLayoutHints2.widthMin = gridLayoutHints2.widthMax = n5 - n - n4;
            gridLayoutHints.widthMin = gridLayoutHints2.widthMax;
            GridLayout gridLayout2 = new GridLayout(2, 2);
            ((AxisConstraints)gridLayout2.getColumnConstraints()).grow = new float[]{1.0f, 1.0f};
            ((AxisConstraints)gridLayout2.getRowConstraints()).gaps = new int[]{0, 12, 2};
            GridLayoutHints gridLayoutHints3 = new GridLayoutHints(0, 0);
            gridLayoutHints3.rowSpan = 2;
            gridLayoutHints3.alignmentHoriz = 2;
            gridLayoutHints3.alignmentVert = 5;
            gridLayoutHints3.widthMin = 48;
            gridLayoutHints3.widthMax = 48;
            GridLayoutHints gridLayoutHints4 = new GridLayoutHints(1, 0);
            gridLayoutHints4.setAlignmentHoriz(3);
            gridLayoutHints4.widthMax = 150;
            GridLayoutHints gridLayoutHints5 = new GridLayoutHints(1, 1);
            gridLayoutHints5.setAlignmentHoriz(3);
            gridLayoutHints5.widthMax = 150;
            gridLayout2.setCellConstraints(new GridLayoutHints[]{gridLayoutHints3, gridLayoutHints4, gridLayoutHints5}, new Object[]{this.flag, this.dta, this.eta});
            GridLayout gridLayout3 = new GridLayout(2, 1);
            ((AxisConstraints)gridLayout3.getColumnConstraints()).gaps = new int[]{0, 10, 0};
            ((AxisConstraints)gridLayout3.getColumnConstraints()).grow = new float[]{0.0f, 1.0f};
            ((AxisConstraints)gridLayout3.getColumnConstraints()).shrink = new float[]{1.0f, 1.0f};
            GridLayoutHints gridLayoutHints6 = new GridLayoutHints(0, 0);
            GridLayoutHints gridLayoutHints7 = new GridLayoutHints(1, 0);
            gridLayoutHints7.setAlignmentHoriz(3);
            gridLayout3.setCellConstraints(new GridLayoutHints[]{gridLayoutHints6, gridLayoutHints7}, new Object[]{this.diffDta, this.diffEta});
            gridLayout.setCellConstraints(new GridLayoutHints[]{gridLayoutHints, gridLayoutHints2}, new Object[]{gridLayout2, gridLayout3});
            this.setLayoutManager(gridLayout);
        }
    }

    private void updateLabelPrefix() {
        this.diffEta.setPrefix(this.isZero ? -1 : (this.isFaster ? -2 : -3));
        this.diffDta.setPrefix(this.isZero ? -1 : (this.isShorter ? -2 : -3));
    }
}

