/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SeparatingHeadlineController;

public class SeparatingHeadlineRendererHigh
extends AbstractKanziTemplateRenderer {
    private static final String TEMPLATE_NODE_PATH = "Prefabs/separatingHeadline";
    private static final String EAL_NODE_NAME = "separatingheadline";
    SeparatingHeadlineController controller;

    public SeparatingHeadlineRendererHigh(SeparatingHeadlineController separatingHeadlineController) {
        this.controller = separatingHeadlineController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setProperty("sh_width", this.controller.getWidth());
        this.setProperty("sh_height", this.controller.getHeight());
        this.node.setOpacity(this.controller.getRenderOpacity());
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
        return 6;
    }
}

