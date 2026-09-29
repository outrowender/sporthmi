/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ComboBoxRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;

public class ComboBoxRendererHigh
extends CompositeRendererHigh
implements ComboBoxRenderer {
    private IWrappedNode3D parentWhenClosed;
    private IWrappedNode3D menuNode;
    private IWrappedNode3D backgroundNode;

    public ComboBoxRendererHigh(ComboBoxController comboBoxController) {
        super(comboBoxController);
    }

    @Override
    public void open() {
        if (this.node == null || !this.node.isValid()) {
            return;
        }
        this.parentWhenClosed = this.node.getParent();
        IWrappedNode3D iWrappedNode3D = this.findParentNodeForOpen();
        if (iWrappedNode3D != null) {
            this.getEALManager().moveToParent(this.node, iWrappedNode3D);
        } else {
            this.parentWhenClosed = null;
        }
    }

    @Override
    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
        super.applyProperties(redrawContextHigh);
        if (this.isRenderedInOpenParentNode()) {
            this.adjustPositionForChangedParentNode();
        }
        this.menuNode.setClippingRectangle(((ComboBoxController)this.controller).getComboBoxBackground().getX(), ((ComboBoxController)this.controller).getComboBoxBackground().getY(), ((ComboBoxController)this.controller).getComboBoxBackground().getWidth(), ((ComboBoxController)this.controller).getComboBoxBackground().getHeight());
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (abstractWidget instanceof MenuController) {
            redrawContextHigh.parentNode = this.menuNode;
            redrawContextHigh.parentNodeSecondary = null;
        } else {
            redrawContextHigh.parentNode = this.backgroundNode;
            redrawContextHigh.parentNodeSecondary = null;
        }
    }

    @Override
    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        super.renderNode(redrawContextHigh);
        this.backgroundNode = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("ComboBoxBackgroundNode", this), this.controller.getWidth(), this.controller.getHeight());
        this.backgroundNode.setClipping(false);
        this.menuNode = this.getEALManager().createNode3D(this.node, EALManager.createNodeName("ComboBoxMenuNode", this), this.controller.getWidth(), this.controller.getHeight());
        this.menuNode.setClippingInheritance(16);
        this.menuNode.setClippingRectangle(((ComboBoxController)this.controller).getComboBoxBackground().getX(), ((ComboBoxController)this.controller).getComboBoxBackground().getY(), ((ComboBoxController)this.controller).getComboBoxBackground().getWidth(), ((ComboBoxController)this.controller).getComboBoxBackground().getHeight());
        this.menuNode.useClippingRectangle(true);
        this.menuNode.setClipping(true);
    }

    @Override
    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        IWrappedNode3D iWrappedNode3D = redrawContextHigh.parentNode;
        if (((ComboBoxController)this.controller).isOpen()) {
            this.parentWhenClosed = iWrappedNode3D;
            IWrappedNode3D iWrappedNode3D2 = this.findParentNodeForOpen();
            if (iWrappedNode3D2 != null) {
                return iWrappedNode3D2;
            }
            this.parentWhenClosed = null;
        }
        return super.getParentNode(redrawContextHigh);
    }

    private IWrappedNode3D findParentNodeForOpen() {
        IWrappedNode3D iWrappedNode3D = this.parentWhenClosed;
        IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D.getParent();
        return iWrappedNode3D2.getParent();
    }

    @Override
    public void close() {
        if (this.node == null || !this.node.isValid()) {
            return;
        }
        if (this.parentWhenClosed != null && this.parentWhenClosed.isValid()) {
            this.getEALManager().moveToParent(this.node, this.parentWhenClosed);
        }
        this.parentWhenClosed = null;
    }

    private void adjustPositionForChangedParentNode() {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        IWrappedNode3D iWrappedNode3D = this.node.getParent();
        for (IWrappedNode3D iWrappedNode3D2 = this.parentWhenClosed; iWrappedNode3D2 != null && !iWrappedNode3D2.equals(iWrappedNode3D); iWrappedNode3D2 = iWrappedNode3D2.getParent()) {
            n = (int)((float)n * iWrappedNode3D2.getScaleX());
            n2 = (int)((float)n2 * iWrappedNode3D2.getScaleY());
            n3 = (int)((float)n3 * iWrappedNode3D2.getScaleZ());
            n = (int)((float)n + iWrappedNode3D2.getX());
            n2 = (int)((float)n2 + iWrappedNode3D2.getY());
            n3 = (int)((float)n3 + iWrappedNode3D2.getZ());
            n4 = (int)((float)n4 * iWrappedNode3D2.getScaleX());
            n5 = (int)((float)n5 * iWrappedNode3D2.getScaleY());
            n6 = (int)((float)n6 * iWrappedNode3D2.getScaleZ());
        }
        this.node.setPosition(this.node.getX() + (float)n, this.node.getY() + (float)n2, this.node.getZ() + (float)n3);
        this.node.setScale(this.node.getScaleX() + (float)n4, this.node.getScaleY() + (float)n5, this.node.getScaleZ() + (float)n6);
    }

    private boolean isRenderedInOpenParentNode() {
        return this.parentWhenClosed != null;
    }

    @Override
    public void disconnect() {
        this.getEALManager().destroy(this.menuNode);
        this.getEALManager().destroy(this.backgroundNode);
        this.menuNode = null;
        this.backgroundNode = null;
        super.disconnect();
        this.parentWhenClosed = null;
    }
}

