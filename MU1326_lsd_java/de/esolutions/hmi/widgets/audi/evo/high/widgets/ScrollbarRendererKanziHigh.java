/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarInterval;
import de.esolutions.hmi.widgets.audi.evo.widgets.ScrollbarRenderer;

public class ScrollbarRendererKanziHigh
extends AbstractKanziTemplateRenderer
implements ScrollbarRenderer {
    private static final String TEMPLATE_NODE_PATH;
    private static final String EAL_NODE_NAME;
    private final ScrollbarController controller;

    public ScrollbarRendererKanziHigh(ScrollbarController scrollbarController) {
        this.controller = scrollbarController;
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        float f2;
        float f3;
        this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        ScrollbarInterval scrollbarInterval = this.controller.getAnimationInterval();
        if (scrollbarInterval.isVisible()) {
            f3 = this.controller.getScrollbarHeight();
            f2 = this.controller.getScrollbarPosition();
        } else {
            f2 = 0.0f;
            f3 = this.controller.getHeight();
        }
        this.setProperty("sb_bg_length", this.controller.getHeight());
        this.setProperty("sb_scrollPos", f2);
        this.setProperty("sb_bar_length", f3);
        this.node.setOpacity(scrollbarInterval.getOpacity() * this.controller.getRenderOpacity());
    }

    @Override
    protected String getTemplateNodePath() {
        return "Prefabs/scrollBar";
    }

    @Override
    protected String getEALNodeName() {
        return "scrollBar";
    }

    @Override
    protected int getKzbConstant() {
        return 6;
    }
}

