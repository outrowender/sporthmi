/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.Alignment;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.MixedListKZBMerger;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.MapOverlayPlateRenderer;

public class MapOverlayPlateRendererHigh
extends AbstractKanziTemplateRenderer
implements MapOverlayPlateRenderer,
Alignment {
    public static final int SIDEBAR;
    public static final int INFOLINE;
    private MapOverlayPlateController controller;
    private int prefab = 1;
    private int hAlign = 1;

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        int n3 = this.controller.getWidth();
        int n4 = this.controller.getHeight();
        if (this.hAlign == 2) {
            n -= n3 / 2;
        }
        this.node.setPosition(n, n2, 0.0f);
        this.setProperty("gp_width", n3);
        this.setProperty("gp_height", n4);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(this.controller.isVisible() && this.controller.isVisibleOnCurrentStage());
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public int getAlignmentHoriz() {
        return this.hAlign;
    }

    @Override
    protected String getEALNodeName() {
        return "mapOverlayPlate";
    }

    @Override
    protected String getTemplateNodePath() {
        if (this.prefab == 1) {
            return "Prefabs/w142_sidebar";
        }
        return "Prefabs/navStatusbar";
    }

    public MapOverlayPlateRendererHigh(MapOverlayPlateController mapOverlayPlateController) {
        this.controller = mapOverlayPlateController;
    }

    public void setAlignment(int n, int n2) {
        this.hAlign = n;
    }

    public void setPrefab(int n) {
        if (0 < n && n <= 2) {
            this.prefab = n;
        }
    }

    @Override
    protected int getKzbConstant() {
        return 17;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (MixedListKZBMerger.kzbMerged) {
            super.render(redrawContext);
        }
    }
}

