/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.InstructionTextRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;

public class InstructionTextRendererHigh
extends CompositeRendererHigh
implements InstructionTextRenderer {
    protected IWrappedLayer glassplateLayer;
    protected IWrappedNode3D contentNode;
    protected IWrappedNode3D foregroundNode;
    protected IWrappedNode3D textureOffsetNode;

    public InstructionTextRendererHigh(InstructionTextContoller instructionTextContoller) {
        super(instructionTextContoller);
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        super.renderNode(redrawContextHigh);
        if (this.hasGlassplate()) {
            this.glassplateLayer = this.getEALManager().createLayer(EALManager.createNodeName("InstructionText", this), -10, GlassplateRendererHigh.OFFSCREEN_TEXTURE_WIDTH, GlassplateRendererHigh.OFFSCREEN_TEXTURE_HEIGHT);
        }
        if (this.glassplateLayer == null) {
            this.contentNode = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("InstructionTextContentNode", this), this.controller.getWidth(), this.controller.getHeight());
            this.foregroundNode = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("InstructionTextForegroundNode", this), this.controller.getWidth(), this.controller.getHeight());
        } else {
            IWrappedNode3D iWrappedNode3D = this.glassplateLayer.getNode();
            this.textureOffsetNode = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("InstructionTextOffsetNode", this), this.controller.getWidth(), this.controller.getHeight());
            this.contentNode = this.getEALManager().createNode3D(this.textureOffsetNode, EALManager.createNodeName("InstructionTextContentNode", this), this.controller.getWidth(), this.controller.getHeight());
            this.foregroundNode = this.getEALManager().createNode3D(this.textureOffsetNode, EALManager.createNodeName("InstructionTextForegroundNode", this), this.controller.getWidth(), this.controller.getHeight());
        }
    }

    private boolean hasGlassplate() {
        return ((InstructionTextContoller)this.controller).getGlassPlate() != null;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.glassplateLayer != null) {
            IWrappedNode3D iWrappedNode3D = this.glassplateLayer.getNode();
            iWrappedNode3D.setPosition(this.controller.getX(), this.controller.getY(), 0.0f);
            iWrappedNode3D.setSize(this.controller.getWidth(), this.controller.getHeight());
            iWrappedNode3D.setOpacity(this.controller.getRenderOpacity());
            iWrappedNode3D.setVisible(this.shouldRenderVisible());
            iWrappedNode3D.setRotationZ(this.rotationZ);
        }
    }

    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = new RedrawContextHigh();
        this.copyRedrawContextFields((RedrawContextHigh)redrawContext, redrawContextHigh);
        this.storeOwnRedrawContextFields(redrawContextHigh);
        return redrawContextHigh;
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        if (abstractWidget instanceof GlassplateController || abstractWidget instanceof PartialPopupGlassplateController) {
            if (this.glassplateLayer != null && this.controller.isInvalid()) {
                this.glassplateLayer.setInvalid(true);
                abstractWidget.setCompositesDirty(true);
            }
            ((RedrawContextHigh)redrawContext).parentNode = this.node;
            ((RedrawContextHigh)redrawContext).parentNodeSecondary = this.textureOffsetNode;
            ((RedrawContextHigh)redrawContext).offscreenLayer = this.glassplateLayer;
        } else {
            if (this.contentNode != null && this.contentNode.isValid()) {
                ((RedrawContextHigh)redrawContext).parentNode = this.contentNode;
            } else {
                logChannel3DEngine.log(10000, "InstructionTextRendererHigh#prepareRedrawContextForChildren: contentNode is null or invalid");
            }
            if (this.foregroundNode != null && this.foregroundNode.isValid()) {
                ((RedrawContextHigh)redrawContext).parentNodeSecondary = this.foregroundNode;
            } else {
                logChannel3DEngine.log(10000, "InstructionTextRendererHigh#prepareRedrawContextForChildren: foregroundNode is null or invalid");
            }
        }
    }

    public IWrappedNode3D getForegroundNode() {
        return this.foregroundNode;
    }

    public void disconnect() {
        this.getEALManager().destroy(this.contentNode);
        this.getEALManager().destroy(this.foregroundNode);
        if (this.glassplateLayer != null) {
            this.getEALManager().destroy(this.textureOffsetNode);
            this.foregroundNode = null;
            this.contentNode = null;
            this.textureOffsetNode = null;
            this.getEALManager().destroy(this.glassplateLayer);
            this.glassplateLayer = null;
        }
        this.contentNode = null;
        this.foregroundNode = null;
        super.disconnect();
    }
}

