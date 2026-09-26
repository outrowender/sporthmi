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
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    SeparatingHeadlineController controller;

    public SeparatingHeadlineRendererHigh(SeparatingHeadlineController separatingHeadlineController) {
        this.controller = separatingHeadlineController;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        this.setProperty("sh_width", this.controller.getWidth());
        this.setProperty("sh_height", this.controller.getHeight());
        this.node.setOpacity(this.controller.getRenderOpacity());
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/separatingHeadline";
    }

    @Override
    protected String getEALNodeName() {
        return "separatingheadline";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

