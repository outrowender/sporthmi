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
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private static final String WHITE_BAR_PROPERTY;
    private static final String GREEN_BAR_PROPERTY;
    private static final float MAXIMUM_COMBINED_BAR_LENGTH;
    private static final float MINIMUM_LENGTH_WHITE_BAR;
    private static final float MINMUM_BAR_LENGHT;
    private static final float MAXIMUM_BAR_LENGTH;
    private RangeMonitorController controller;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;

    public RangeMonitorRendererHigh(RangeMonitorController rangeMonitorController) {
        this.controller = rangeMonitorController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        float f2 = this.controller.getGreenBarValue();
        float f3 = this.controller.getWhiteBarValue();
        float f4 = f2 + f3;
        if (f4 > 1.0f) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorRendererHigh#applyProperties: MAXIMUM_COMBINED_BAR_LENGTH (Green and White) is greater than 1 (100%): %1", (double)f4);
        }
        this.setGreenBarProperty(f2);
        this.setWhiteBarProperty(f3);
    }

    private void setWhiteBarProperty(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorRendererHigh#applyProperties: GreenBalcony length should always be between 0 to 1  but actual value : ", (double)this.controller.getWhiteBarValue());
            return;
        }
        if (f2 < -330221507) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorRendererHigh#applyProperties: WhiteBarLenght is less than 0.045: %1", (double)this.controller.getWhiteBarValue());
        }
        this.setProperty("eRange_potential", f2);
    }

    private void setGreenBarProperty(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            this.logChannel3DCar.log(-1601830656, "RangeMonitorRendererHigh#applyProperties: WhiteBalcony length is wrong ( should always be between 0 to 1 ) WhiteBarValue : ", (double)this.controller.getGreenBarValue());
            return;
        }
        this.setProperty("eRange_range", f2);
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/eRange_monitor";
    }

    @Override
    protected String getEALNodeName() {
        return "eRange_monitor";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected int getKzbConstant() {
        return 3;
    }
}

