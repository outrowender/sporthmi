/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.SmallStageApplicationIconController;

public class GlassplateContainerRendererHigh
extends ContainerRendererHigh {
    protected IWrappedLayer glassplateContainerLayer;
    protected IWrappedNode3D contentNode;
    protected IWrappedNode3D textureOffsetNode;

    public GlassplateContainerRendererHigh(ContainerController containerController) {
        super(containerController);
    }

    @Override
    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        super.renderNode(redrawContextHigh);
        this.glassplateContainerLayer = this.getEALManager().createLayer(EALManager.createNodeName("GlassplateContainer", this), -10, GlassplateRendererHigh.OFFSCREEN_TEXTURE_WIDTH, GlassplateRendererHigh.OFFSCREEN_TEXTURE_HEIGHT);
        if (this.glassplateContainerLayer != null) {
            IWrappedNode3D iWrappedNode3D = this.glassplateContainerLayer.getNode();
            this.textureOffsetNode = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("GlassplateContainerTextureOffsetNode", this), this.controller.getWidth(), this.controller.getHeight());
            this.contentNode = this.getEALManager().createNode3D(this.textureOffsetNode, EALManager.createNodeName("GlassplateContainerContentNode", this), this.controller.getWidth(), this.controller.getHeight());
        }
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        IWrappedNode3D iWrappedNode3D = this.glassplateContainerLayer.getNode();
        iWrappedNode3D.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
        iWrappedNode3D.setSize(this.controller.getWidth(), this.controller.getHeight());
        iWrappedNode3D.setOpacity(this.controller.getRenderOpacity());
        iWrappedNode3D.setVisible(this.shouldRenderVisible());
        iWrappedNode3D.setRotationZ(this.rotationZ);
    }

    @Override
    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = new RedrawContextHigh();
        this.copyRedrawContextFields((RedrawContextHigh)redrawContext, redrawContextHigh);
        this.storeOwnRedrawContextFields(redrawContextHigh);
        return redrawContextHigh;
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        if (abstractWidget instanceof GlassplateController || abstractWidget instanceof PartialPopupGlassplateController) {
            if (this.glassplateContainerLayer != null && this.controller.isInvalid()) {
                this.glassplateContainerLayer.setInvalid(true);
                abstractWidget.setCompositesDirty(true);
            }
            ((RedrawContextHigh)redrawContext).parentNode = this.node;
            ((RedrawContextHigh)redrawContext).parentNodeSecondary = this.textureOffsetNode;
            ((RedrawContextHigh)redrawContext).offscreenLayer = this.glassplateContainerLayer;
        } else if (abstractWidget instanceof SmallStageApplicationIconController) {
            ((RedrawContextHigh)redrawContext).parentNode = this.node;
        } else {
            if (this.contentNode != null && this.contentNode.isValid()) {
                ((RedrawContextHigh)redrawContext).parentNode = this.contentNode;
            } else {
                logChannel3DEngine.log(10000, "GlasplateContainerRendererHigh#prepareRedrawContextForChildren: contentNode is null or invalid");
            }
            ((RedrawContextHigh)redrawContext).parentNodeSecondary = this.node;
        }
    }

    @Override
    public void disconnect() {
        if (this.glassplateContainerLayer != null) {
            this.getEALManager().destroy(this.contentNode);
            this.getEALManager().destroy(this.textureOffsetNode);
            this.contentNode = null;
            this.textureOffsetNode = null;
            this.getEALManager().destroy(this.glassplateContainerLayer);
            this.glassplateContainerLayer = null;
        }
        super.disconnect();
    }
}

