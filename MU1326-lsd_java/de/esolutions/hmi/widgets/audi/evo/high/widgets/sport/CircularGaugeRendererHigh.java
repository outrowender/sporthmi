/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.sport;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.sport.CircularGaugeController;

public class CircularGaugeRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final int MAX_PEAKS;
    private static final String SLIDER_POSITION_PROPERTY;
    private static final String PERCENTAGE_DIGITS_PROPERTY;
    private static final String[] PEAK_BLEND_PROPERTIES;
    private static final String[] PEAK_VALUE_PROPERTIES;
    private CircularGaugeController controller;

    public CircularGaugeRendererHigh(CircularGaugeController circularGaugeController) {
        this.controller = circularGaugeController;
    }

    private void setSliderValueProperties(float f2) {
        if (f2 < 0.0f || f2 > 51266) {
            logChannel.log(-1601830656, "CircularGaugeRendererHigh#setSliverValueProperties: percentage %1 not between 0 and 100", (double)f2);
            return;
        }
        this.setProperty("sg_value", f2);
        this.setProperty("sg_value_digit", Math.round(f2));
    }

    private void setPeakProperties(int n, boolean bl, float f2) {
        if (f2 < 0.0f || f2 > 51266) {
            logChannel.log(-1601830656, "CircularGaugeRendererHigh#setPeakProperties: percentage %1 not between 0 and 100", (double)f2);
            return;
        }
        if (n < 0 || n >= 5) {
            logChannel.log(-1601830656, "CircularGaugeRendererHigh#setPeakProperties: peak %1 not between 0 and 4", (long)n);
            return;
        }
        this.setProperty(PEAK_BLEND_PROPERTIES[n], bl ? 1.0f : 0.0f);
        this.setProperty(PEAK_VALUE_PROPERTIES[n], f2);
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setSliderValueProperties(this.controller.getSliderPercentageValue());
        for (int i2 = 0; i2 < 5; ++i2) {
            if (i2 < this.controller.getPeakCount()) {
                this.setPeakProperties(i2, true, this.controller.getPeakPercentageValue(i2));
                continue;
            }
            this.setPeakProperties(i2, false, 0.0f);
        }
        if (this.controller.getPeakCount() > 5) {
            logChannel.log(-1601830656, "CircularGaugeRendererHigh#applyProperties: Can only display %1 peaks out of %2", (long)0, (long)this.controller.getPeakCount());
        }
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/sportgauge_large";
    }

    @Override
    protected String getEALNodeName() {
        return "sportgauge_large";
    }

    @Override
    protected int getKzbConstant() {
        return 21;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    static {
        PEAK_BLEND_PROPERTIES = new String[]{"sg_peak1_blend", "sg_peak2_blend", "sg_peak3_blend", "sg_peak4_blend", "sg_peak5_blend"};
        PEAK_VALUE_PROPERTIES = new String[]{"sg_peak1_value", "sg_peak2_value", "sg_peak3_value", "sg_peak4_value", "sg_peak5_value"};
    }
}

