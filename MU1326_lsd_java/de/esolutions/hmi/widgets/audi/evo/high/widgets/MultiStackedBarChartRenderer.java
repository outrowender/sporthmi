/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MultiStackedBarChartController;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.StackedBarChartController;

public class MultiStackedBarChartRenderer
extends AbstractRendererHigh
implements IWidgetLogChannel {
    private static final String TEMPLATE_NODE_NAME = "Prefabs/statistics_column";
    private static final String EAL_NODE_NAME = "ETRON_STATS";
    private static final String EAL_NODE_NAME_MULTIBARCHART = "MultiBarChart";
    private static final String EAL_NODE_NAME_SINGELBARCHART = "SingleBarChart";
    private static final String EAL_NODE_NAME_STACKEDBAR = "StackedBar";
    private static final String EAL_NODE_NAME_CHART_BACKGROUND = "ChartBackground";
    private static final String EAL_NODE_NAME_CHART_FRAME = "ChartFrame";
    private static final String PROPERTY_BAR_WIDTH = "sc_width";
    private static final String PROPERTY_BAR_HEIGHT = "sc_height";
    private static final String PROPERTY_BAR_MARGIN = "sc_margin";
    private static final String PROPERTY_BAR_SECTION1_COLOR = "sc_section1_color";
    private static final String PROPERTY_BAR_SECTION2_COLOR = "sc_section2_color";
    private static final String PROPERTY_BAR_SECTION1_RATIO = "sc_section1_ratio";
    private static final String PROPERTY_BAR_SECTION2_RATIO = "sc_section2_ratio";
    private static final String PROPERTY_BAR_SECTION3_VISIBLE = "sc_section3_visible";
    private static final int OFFSET_LEFT = 7;
    private static final int OFFSET_TOP = 10;
    private static final int MAX_BARS = 30;
    private static final int IMAGE_INDEX_BACKGROUND = 0;
    private static final int IMAGE_INDEX_FRAME = 0;
    private static int colorYellow;
    private static int colorGreen;
    private IWrappedNode3D precalculatedBar;
    private IWrappedNode3D multiBarGroup;
    private IWrappedNode3D[] postcalculatedBar;
    private IWrappedNode3DImage axes;
    private IWrappedNode3DImage frame;
    private EALPropertyCache propertyCache;
    private IWrappedNode3D singleBar;
    private MultiStackedBarChartController multiBarChartController;
    private StackedBarChartController singleBarChartController;
    private IWrappedNode3D rootNode;
    private boolean loadresources;

    public MultiStackedBarChartRenderer(AbstractWidgetController abstractWidgetController) {
        if (abstractWidgetController instanceof MultiStackedBarChartController) {
            this.multiBarChartController = (MultiStackedBarChartController)abstractWidgetController;
        }
        if (abstractWidgetController instanceof StackedBarChartController) {
            this.singleBarChartController = (StackedBarChartController)abstractWidgetController;
        }
    }

    private void loadResources(RedrawContextHigh redrawContextHigh) {
        if (!this.loadresources) {
            colorYellow = EALManager.createColorCode(-1397497);
            colorGreen = EALManager.createColorCode(-16711936);
            this.propertyCache = new EALPropertyCache();
            this.postcalculatedBar = new IWrappedNode3D[30];
            this.rootNode = this.getEALManager().createNode3D(redrawContextHigh.parentNode, EAL_NODE_NAME, this.getAbstractController().getWidth(), this.getAbstractController().getHeight());
            if (this.isMultiBarchart()) {
                int n = this.multiBarChartController.getBarCount();
                if (n <= 0) {
                    logStatisticsStackedBarChart.log(10000, "StackedBarChartRenderer#loadResources barCount is zero");
                    return;
                }
                this.axes = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName(EAL_NODE_NAME_CHART_BACKGROUND, this), this.getTextureDescription(0, true), 0, true, (Object)this);
                if (n > 0 && n <= 30) {
                    this.multiBarGroup = this.getEALManager().createNode3D(this.rootNode, EAL_NODE_NAME_MULTIBARCHART, this.rootNode.getWidth(), this.rootNode.getHeight());
                    this.precalculatedBar = this.getEALManager().createTemplateInstanceNode(this.multiBarGroup, EAL_NODE_NAME_STACKEDBAR, this.multiBarChartController.getPostcalculatedBarWidth(), this.multiBarChartController.getPostcalculatedBarHeight(), this.getKZBId(), TEMPLATE_NODE_NAME, redrawContextHigh.getScreenID());
                    for (int i2 = 0; i2 < n; ++i2) {
                        this.postcalculatedBar[i2] = this.getEALManager().createTemplateInstanceNode(this.rootNode, new String(EAL_NODE_NAME_STACKEDBAR.concat("_").concat(String.valueOf(i2))), this.multiBarChartController.getPostcalculatedBarWidth(), this.multiBarChartController.getPostcalculatedBarHeight(), this.getKZBId(), TEMPLATE_NODE_NAME, redrawContextHigh.getScreenID());
                    }
                }
            } else {
                this.frame = this.getEALManager().createImage3D(this.rootNode, EALManager.createNodeName(EAL_NODE_NAME_CHART_FRAME, this), this.getTextureDescription(0, true), 0, true, (Object)this);
                this.singleBar = this.getEALManager().createTemplateInstanceNode(this.rootNode, EAL_NODE_NAME_SINGELBARCHART, this.singleBarChartController.getBarWidth(), this.singleBarChartController.getBarHeight(), this.getKZBId(), TEMPLATE_NODE_NAME, redrawContextHigh.getScreenID());
            }
            this.loadresources = true;
        }
    }

    private void applyProperties() {
        if (this.isMultiBarchart() && this.loadresources) {
            this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_WIDTH, (float)this.multiBarChartController.getPostcalculatedBarWidth());
            this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_HEIGHT, (float)this.multiBarChartController.getPostcalculatedBarHeight());
            this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_MARGIN, (float)this.multiBarChartController.getBarMargin());
            this.propertyCache.setColorProperty(this.precalculatedBar, PROPERTY_BAR_SECTION1_COLOR, colorGreen);
            this.propertyCache.setColorProperty(this.precalculatedBar, PROPERTY_BAR_SECTION2_COLOR, colorYellow);
            this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_SECTION3_VISIBLE, false);
            float f2 = this.multiBarChartController.getPrecalculatedData(0, 0);
            float f3 = this.multiBarChartController.getPrecalculatedData(0, 1);
            if (f2 == 3.0f || f2 == -1.0f) {
                this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_SECTION1_RATIO, 0.0f);
                this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_SECTION2_RATIO, 0.0f);
            } else {
                this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_SECTION1_RATIO, f3 != -1.0f ? f3 : 0.0f);
                this.propertyCache.setProperty(this.precalculatedBar, PROPERTY_BAR_SECTION2_RATIO, f3 != -1.0f ? 1.0f - f3 : 0.0f);
            }
            this.applyCalculatePosition(0, this.precalculatedBar);
            for (int i2 = 0; i2 < this.postcalculatedBar.length - 1; ++i2) {
                this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_WIDTH, (float)this.multiBarChartController.getPostcalculatedBarWidth());
                this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_HEIGHT, (float)this.multiBarChartController.getPostcalculatedBarHeight());
                this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_MARGIN, (float)this.multiBarChartController.getBarMargin());
                this.propertyCache.setColorProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION1_COLOR, colorGreen);
                this.propertyCache.setColorProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION2_COLOR, colorYellow);
                this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION3_VISIBLE, false);
                f3 = this.multiBarChartController.getPostcalculatedData(i2, 0);
                float f4 = this.multiBarChartController.getPostcalculatedData(i2, 1);
                if (f3 == 3.0f || f3 == -1.0f) {
                    this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION1_RATIO, 0.0f);
                    this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION2_RATIO, 0.0f);
                } else {
                    this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION1_RATIO, f4 != -1.0f ? f4 : 0.0f);
                    this.propertyCache.setProperty(this.postcalculatedBar[i2], PROPERTY_BAR_SECTION2_RATIO, f4 != -1.0f ? 1.0f - f4 : 0.0f);
                }
                this.applyCalculatePosition(i2 + 1, this.postcalculatedBar[i2]);
            }
        } else {
            this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_WIDTH, (float)this.singleBarChartController.getBarWidth());
            this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_HEIGHT, (float)this.singleBarChartController.getBarHeight());
            this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_MARGIN, (float)this.singleBarChartController.getBarMargin());
            this.propertyCache.setColorProperty(this.singleBar, PROPERTY_BAR_SECTION1_COLOR, colorGreen);
            this.propertyCache.setColorProperty(this.singleBar, PROPERTY_BAR_SECTION2_COLOR, colorYellow);
            this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_SECTION3_VISIBLE, false);
            if (this.singleBarChartController.getValue() == -1.0f) {
                this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_SECTION1_RATIO, 0.0f);
                this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_SECTION2_RATIO, 0.0f);
            } else {
                this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_SECTION1_RATIO, this.singleBarChartController.getValue());
                this.propertyCache.setProperty(this.singleBar, PROPERTY_BAR_SECTION2_RATIO, 1.0f - this.singleBarChartController.getValue());
            }
            this.singleBar.setPosition(this.singleBarChartController.getX(), this.singleBarChartController.getY(), 0.0f);
            this.frame.setPosition(this.singleBarChartController.getX() - 3, this.singleBarChartController.getY() - 3, 0.0f);
        }
    }

    private void applyCalculatePosition(int n, IWrappedNode3D iWrappedNode3D) {
        int n2;
        int n3;
        int n4 = this.multiBarChartController.getBarMargin();
        int n5 = this.multiBarChartController.getIndexGap();
        int n6 = this.multiBarChartController.getPrecalculatedBarWidth();
        int n7 = this.multiBarChartController.getPostcalculatedBarWidth();
        if (this.axes != null) {
            this.axes.setPosition(this.multiBarChartController.getX(), this.multiBarChartController.getY(), 0.0f);
        }
        if (n == 0) {
            n3 = 7 + this.multiBarChartController.getX();
            n2 = 10 + this.multiBarChartController.getY();
        } else {
            n3 = 2 * n4 + n5 + 7 + this.multiBarChartController.getX() + n6 + (n - 1) * (2 * n4 + n7 + n5);
            n2 = 10 + this.multiBarChartController.getY();
        }
        if (!this.multiBarChartController.isLTR()) {
            n3 = 2 * this.multiBarChartController.getWidth() - n3 + 3;
        }
        iWrappedNode3D.setPosition(n3, n2, 0.0f);
    }

    public void render(RedrawContext redrawContext) {
        this.loadResources((RedrawContextHigh)redrawContext);
        this.applyProperties();
    }

    public AbstractWidgetController getAbstractController() {
        if (this.multiBarChartController != null) {
            return this.multiBarChartController;
        }
        if (this.singleBarChartController != null) {
            return this.singleBarChartController;
        }
        return null;
    }

    private boolean isMultiBarchart() {
        return this.getAbstractController() instanceof MultiStackedBarChartController;
    }

    private int getKZBId() {
        return 3;
    }

    public void disconnect() {
        if (this.propertyCache != null) {
            this.propertyCache.clearAll();
        }
        if (this.precalculatedBar != null) {
            this.getEALManager().destroy(this.precalculatedBar);
            this.precalculatedBar = null;
        }
        if (this.postcalculatedBar != null) {
            for (int i2 = 0; i2 < this.postcalculatedBar.length; ++i2) {
                this.getEALManager().destroy(this.postcalculatedBar[i2]);
            }
            this.postcalculatedBar = null;
        }
        if (this.multiBarGroup != null) {
            this.getEALManager().destroy(this.multiBarGroup);
            this.multiBarGroup = null;
        }
        if (this.singleBar != null) {
            this.getEALManager().destroy(this.singleBar);
        }
        if (this.axes != null) {
            this.getEALManager().destroy(this.axes);
            this.axes = null;
        }
        if (this.frame != null) {
            this.getEALManager().destroy(this.frame);
        }
        this.loadresources = false;
        super.disconnect();
    }
}

