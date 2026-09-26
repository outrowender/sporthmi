/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CompositeRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;

public class CompositeRendererHigh
extends AbstractRendererHigh
implements CompositeRenderer,
IKanziTemplateRenderer {
    protected final AbstractWidgetController controller;
    protected IWrappedNode3D node;
    protected boolean clipping;
    protected float rotationZ = 0.0f;

    public CompositeRendererHigh(AbstractWidgetController abstractWidgetController) {
        this.controller = abstractWidgetController;
    }

    @Override
    public void setClipping(boolean bl) {
        this.clipping = bl;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.dirty) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.node != null) {
                this.node.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (this.node == null) {
            this.renderNode(redrawContextHigh);
        } else {
            IWrappedNode3D iWrappedNode3D = this.getParentNode(redrawContextHigh);
            if (iWrappedNode3D != null && !iWrappedNode3D.equals(this.node.getParent())) {
                this.getEALManager().moveToParent(this.node, iWrappedNode3D);
            }
        }
        if (this.node == null) {
            return;
        }
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "CompositeRendererHigh#render: node is invalid");
            return;
        }
        this.applyProperties(redrawContextHigh);
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        if (this.node == null) {
            logChannel3DEngine.log(10000, "CompositeRendererHigh#prepareRedrawContextForChildren: node is null");
            return;
        }
        if (!this.node.isValid()) {
            logChannel3DEngine.log(10000, "CompositeRendererHigh#prepareRedrawContextForChildren: node is invalid");
            return;
        }
        ((RedrawContextHigh)redrawContext).parentNode = this.node;
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        this.renderNode(this.getParentNode(redrawContextHigh), redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
    }

    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        return redrawContextHigh.parentNode;
    }

    protected void renderNode(IWrappedNode3D iWrappedNode3D, int n) {
        this.node = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("composite", this), this.getClippingWidth(), this.getClippingHeight(), n);
    }

    protected void destroyNode() {
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            eALManager.destroy(this.node);
        }
        this.node = null;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        this.node.setPosition((float)this.controller.getX() + this.x0, (float)this.controller.getY() + this.y0, 0.0f);
        this.node.setSize(this.getClippingWidth(), this.getClippingHeight());
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setVisible(this.shouldRenderVisible());
        this.node.setRotationZ(this.rotationZ);
        this.node.setClipping(this.clipping);
    }

    protected int getClippingHeight() {
        return this.controller.getHeight();
    }

    protected int getClippingWidth() {
        return this.controller.getWidth();
    }

    protected boolean shouldRenderVisible() {
        return this.controller.shouldRender() && this.controller.getRenderOpacity() > 0.0f;
    }

    public void setRotationZ(float f2) {
        this.rotationZ = f2;
    }

    @Override
    public void disconnect() {
        this.destroyNode();
        super.disconnect();
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public IWrappedNode3D getNode() {
        return this.node;
    }

    @Override
    public void setKzbIDs(int[] nArray) {
    }
}

