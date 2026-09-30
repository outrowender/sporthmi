/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.StatusbarControllerHigh;

public class StatusbarRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/mib2_statusBar";
    private static final String EAL_NODE_NAME = "statusBar";
    private final StatusbarControllerHigh controller;

    public StatusbarRendererHigh(StatusbarControllerHigh statusbarControllerHigh) {
        this.controller = statusbarControllerHigh;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        int n3 = this.controller.getWidth();
        int n4 = this.controller.getHeight();
        float f2 = (float)n + (float)n3 / 2.0f;
        this.node.setPosition(f2, n2 + n4, 0.0f);
        this.node.setScale(this.controller.getScaleFactor(), this.controller.getScaleFactor(), 1.0f);
        this.setProperty("sb_overallWidth", (float)n3 / this.controller.getScaleFactor());
        this.setProperty("sb_gapWidth", (float)this.controller.getCurrentGapWidth() / this.controller.getScaleFactor());
        this.setProperty("sb_state", this.controller.getGapHeight());
        this.controller.doLeftGroupPriorisation();
        this.controller.doRightGroupPriorisation();
    }

    public void render(RedrawContext redrawContext) {
        super.render(redrawContext);
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_NODE_PATH;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbConstant() {
        return 16;
    }
}

