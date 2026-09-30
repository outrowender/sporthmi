/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MapDynamicSidebarConstants;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MapCrosshairController;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;

public class MapCrosshairRenderer
extends AbstractKanziTemplateRenderer
implements CompositeRenderer,
MapDynamicSidebarConstants {
    MapCrosshairController controller;
    boolean isCrosshairSetUp = false;
    private static final String EAL_NODE_NAME = "MapCrosshairRenderer";
    private static final String KZB_NODE_PATH = "Prefabs/crosshair";
    private boolean clipping = false;
    public static final int KZB_CROSSHAIR_PASSIVE = 1;
    public static final int KZB_CROSSHAIR_ACTIVE = 0;

    public MapCrosshairRenderer(MapCrosshairController mapCrosshairController) {
        this.controller = mapCrosshairController;
        this.controller.setRenderer(this);
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        sideBarLogChannel.log(10000000, "MapCrosshairRenderer#applyProperties crosshairChanged = %1", this.controller.hasCrosshairChanged());
        if (this.controller.hasCrosshairChanged() || !this.isCrosshairSetUp) {
            this.isCrosshairSetUp = true;
            this.updateCrosshairMode();
            this.updateAngle();
            this.controller.resetCrosshairChanged();
            this.node.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            this.node.setOpacity(this.controller.getRenderOpacity());
            this.node.setVisible(this.controller.shouldRender());
            this.node.setClipping(this.clipping);
        }
    }

    protected String getTemplateNodePath() {
        return KZB_NODE_PATH;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    protected int getKzbConstant() {
        return 17;
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void render(RedrawContext redrawContext) {
        super.render(redrawContext);
    }

    public void setClipping(boolean bl) {
        this.clipping = bl;
    }

    public void updateAngle() {
        this.setProperty("crosshair_angle", this.controller.getCurrentAngle());
    }

    public void updateCrosshairMode() {
        this.setProperty("crosshair_mode", this.controller.getCurrentMode());
        this.setProperty("passive", this.controller.isCrosshairActive() ? 0.0f : 1.0f);
    }
}

