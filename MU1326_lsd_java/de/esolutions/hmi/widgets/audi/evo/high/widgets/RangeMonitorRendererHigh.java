/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.log.LogChannel;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.RangeMonitorController;

public class RangeMonitorRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/eRange_monitor";
    private static final String EAL_NODE_NAME = "eRange_monitor";
    private static final String WHITE_BAR_PROPERTY = "eRange_potential";
    private static final String GREEN_BAR_PROPERTY = "eRange_range";
    private static final float MAXIMUM_COMBINED_BAR_LENGTH = 1.0f;
    private static final float MINIMUM_LENGTH_WHITE_BAR = 0.045f;
    private static final float MINMUM_BAR_LENGHT = 0.0f;
    private static final float MAXIMUM_BAR_LENGTH = 1.0f;
    private RangeMonitorController controller;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;

    public RangeMonitorRendererHigh(RangeMonitorController rangeMonitorController) {
        this.controller = rangeMonitorController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        float f2 = this.controller.getGreenBarValue();
        float f3 = this.controller.getWhiteBarValue();
        float f4 = f2 + f3;
        if (f4 > 1.0f) {
            this.logChannel3DCar.log(100000, "RangeMonitorRendererHigh#applyProperties: MAXIMUM_COMBINED_BAR_LENGTH (Green and White) is greater than 1 (100%): %1", (double)f4);
        }
        this.setGreenBarProperty(f2);
        this.setWhiteBarProperty(f3);
    }

    private void setWhiteBarProperty(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            this.logChannel3DCar.log(100000, "RangeMonitorRendererHigh#applyProperties: GreenBalcony length should always be between 0 to 1  but actual value : ", (double)this.controller.getWhiteBarValue());
            return;
        }
        if (f2 < 0.045f) {
            this.logChannel3DCar.log(100000, "RangeMonitorRendererHigh#applyProperties: WhiteBarLenght is less than 0.045: %1", (double)this.controller.getWhiteBarValue());
        }
        this.setProperty(WHITE_BAR_PROPERTY, f2);
    }

    private void setGreenBarProperty(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            this.logChannel3DCar.log(100000, "RangeMonitorRendererHigh#applyProperties: WhiteBalcony length is wrong ( should always be between 0 to 1 ) WhiteBarValue : ", (double)this.controller.getGreenBarValue());
            return;
        }
        this.setProperty(GREEN_BAR_PROPERTY, f2);
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected int getKzbConstant() {
        return 3;
    }
}

