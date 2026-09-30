/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;

public class PartialPopupGlassplateRendererHigh
extends AbstractKanziTemplateRenderer
implements GlassplateRenderer {
    private static final String EAL_NODE_NAME = "pp_plate";
    private static final String EAL_NODE_NAME_SEPARATOR = "pp_plate_separator";
    private final PartialPopupGlassplateController controller;
    private IWrappedNode3D separatorNode;
    private IWrappedLayer offscreenLayer;
    private IWrappedNode3D offsetNode;

    public PartialPopupGlassplateRendererHigh(PartialPopupGlassplateController partialPopupGlassplateController) {
        this.controller = partialPopupGlassplateController;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        int n = this.controller.getWidth();
        int n2 = this.controller.getHeight();
        int n3 = this.controller.getX();
        int n4 = this.controller.getY() + n2;
        float f2 = (float)n3 + (float)n / 2.0f;
        this.propertyCache.setProperty(this.node, "gp_contentFBOwidth", (float)PartialPopupGlassplateRendererHigh.getOffscreenWidth());
        this.propertyCache.setProperty(this.node, "gp_contentFBOheight", (float)PartialPopupGlassplateRendererHigh.getOffscreenHeight());
        logChannel.log(10000000, "PartialPopupGlassplateRendererHigh#applyProperties set offscreenFBOSize width: %1, height: %2", (long)PartialPopupGlassplateRendererHigh.getOffscreenWidth(), (long)PartialPopupGlassplateRendererHigh.getOffscreenHeight());
        this.node.setPosition(f2, n4, 0.0f);
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.propertyCache.setProperty(this.node, "gp_width", (float)n);
        this.propertyCache.setProperty(this.node, "gp_height", (float)n2);
        float f3 = this.controller.getGlassplateOpacity();
        boolean bl = f3 >= 1.0f;
        this.propertyCache.setProperty(this.node, "gp_shadow", bl ? 1.0f : 0.0f);
        this.propertyCache.setProperty(this.node, "gp_opacity", f3);
        if (this.separatorNode == null) {
            this.separatorNode = this.createSeparatorNode(redrawContextHigh.parentNode);
        }
        if (this.separatorNode != null) {
            if (this.controller.getSeparatorVisible()) {
                this.separatorNode.setPosition(f2, n4, 0.0f);
                this.separatorNode.setOpacity(this.controller.getRenderOpacity());
                this.propertyCache.setProperty(this.separatorNode, "gp_width", (float)n);
                this.propertyCache.setProperty(this.separatorNode, "gp_height", (float)n2);
                this.propertyCache.setProperty(this.separatorNode, "gp_separatorPos", (float)this.controller.getSeparatorYPosition());
            } else {
                this.separatorNode.setOpacity(0.0f);
            }
        }
        if (this.offscreenLayer == null) {
            RedrawContextHigh redrawContextHigh2 = redrawContextHigh;
            IWrappedLayer iWrappedLayer = redrawContextHigh2.offscreenLayer;
            if (iWrappedLayer == null) {
                logChannel.log(10000, "PartialPopupGlassplateRendererHigh#applyProperties No offscreen layer found");
            } else {
                IWrappedTexture iWrappedTexture = iWrappedLayer.getViewport().enableOffscreen();
                if (iWrappedTexture == null) {
                    logChannel.log(10000, "PartialPopupGlassplateRendererHigh#applyProperties Could not get offscreen texture");
                    this.propertyCache.setProperty(this.node, "ContentTex", (ITexture)null);
                } else {
                    this.propertyCache.setProperty(this.node, "ContentTex", iWrappedTexture.getTexture());
                    this.offscreenLayer = iWrappedLayer;
                }
                this.offsetNode = redrawContextHigh2.parentNodeSecondary;
            }
        } else if (null != this.offscreenLayer && this.offscreenLayer.isInvalid()) {
            this.setPropertyWithoutChangeCheck("gp_invalidate", true);
            this.offscreenLayer.setInvalid(false);
        }
        if (this.offsetNode != null) {
            this.offsetNode.setPosition(0.0f, 0.0f, 0.0f);
        }
    }

    protected void applyVisibility(boolean bl) {
        super.applyVisibility(bl);
        if (this.separatorNode != null) {
            this.separatorNode.setVisible(bl);
        }
    }

    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)((RedrawContextHigh)redrawContext).clone();
        this.storeOwnRedrawContextFields(redrawContextHigh);
        return redrawContextHigh;
    }

    protected String getTemplateNodePath() {
        return "Prefabs/generic_glassPlate_partialPopup";
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    protected String getEALNodeName() {
        return EAL_NODE_NAME;
    }

    private IWrappedNode3D createSeparatorNode(IWrappedNode3D iWrappedNode3D) {
        return this.getEALManager().createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName(EAL_NODE_NAME_SEPARATOR, this), 0.0f, 0.0f, this.getKzbConstant(), "Prefabs/generic_glassPlate_partialPopup_separator", this.getInitContext().getScreenID());
    }

    public void disconnect() {
        if (this.separatorNode != null) {
            this.getEALManager().destroy(this.separatorNode);
            this.separatorNode = null;
        }
        this.offscreenLayer = null;
        this.offsetNode = null;
        super.disconnect();
    }

    public void setSDSCommandLineValue(float f2) {
    }

    protected int getKzbConstant() {
        return 6;
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        redrawContextHigh.parentNode = this.node;
    }
}

