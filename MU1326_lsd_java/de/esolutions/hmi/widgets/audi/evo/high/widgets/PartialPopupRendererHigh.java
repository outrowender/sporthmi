/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedViewport;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.CompositeRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.GlassplateRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupGlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupRenderer;
import java.util.List;

public class PartialPopupRendererHigh
extends CompositeRendererHigh
implements PartialPopupRenderer {
    protected final PartialPopupController controller;
    protected IWrappedLayer offscreenLayer;
    private boolean keepPositionInRTL;

    /*
     * Enabled aggressive block sorting
     */
    public void render(RedrawContext redrawContext) {
        float f2;
        super.render(redrawContext);
        if (this.node == null) {
            return;
        }
        boolean bl = this.controller.shouldRender();
        if (this.controller.getStyle() == 1 && this.controller.isDynamicSize() && bl) {
            if (this.controller.isBgGreyOutDeactive()) {
                this.node.setVisible(true);
                this.node.setScale(1.0f, 1.0f, 1.0f);
                this.setOffscreenLayerVisible(true);
            } else {
                float f3 = this.controller.getAnimationValue();
                if (!(f3 > 0.0f)) {
                    this.node.setVisible(false);
                    this.setOffscreenLayerVisible(false);
                    return;
                }
                this.node.setScale(f3, f3, f3);
                this.node.setVisible(true);
                this.setOffscreenLayerVisible(true);
            }
        } else {
            this.node.setVisible(bl);
            this.setOffscreenLayerVisible(bl);
        }
        if (!bl) {
            return;
        }
        boolean bl2 = this.getTerminal().getFramework().getLanguageMgr().isLeftToRightOrientation();
        if (!bl2 && this.keepPositionInRTL()) {
            int n = this.getXOffsetRTL();
            f2 = (float)(this.node.getScreenWidth() - this.controller.getX()) - this.x0 - (float)this.controller.getWidth() + (float)n;
        } else {
            f2 = (float)this.controller.getX() + this.x0;
        }
        float f4 = (float)this.controller.getY() + this.y0;
        this.node.setPosition(f2, f4, 0.0f);
        this.node.setSize(this.getClippingWidth(), this.getClippingHeight());
        this.node.setOpacity(this.controller.getRenderOpacity());
        this.node.setRotationZ(this.rotationZ);
        this.node.setClipping(this.clipping);
        this.controller.sendBoundsToPartialPopupManager((int)f2, (int)f4);
    }

    public PartialPopupRendererHigh(PartialPopupController partialPopupController) {
        super(partialPopupController);
        this.controller = partialPopupController;
    }

    public void hide() {
        if (this.node != null) {
            this.node.setVisible(false);
            this.setOffscreenLayerVisible(false);
        }
    }

    private void setOffscreenLayerVisible(boolean bl) {
        if (this.offscreenLayer != null) {
            IWrappedViewport iWrappedViewport = this.offscreenLayer.getViewport();
            iWrappedViewport.setForceInvisible(!bl);
            iWrappedViewport.setVisible(bl);
        }
    }

    protected IWrappedNode3D getParentNode(RedrawContextHigh redrawContextHigh) {
        if (this.controller.getlayer() == 0) {
            if (this.controller.isUserHint()) {
                return this.getEALManager().getScreenPartialPopupsNode();
            }
            return this.getEALManager().getPartialPopupsBackNode();
        }
        if (this.controller.getlayer() == 3) {
            return this.getEALManager().getPartialPopupsBetweenNode();
        }
        return this.getEALManager().getPartialPopupsFrontNode();
    }

    protected void renderNode(RedrawContextHigh redrawContextHigh) {
        IWrappedNode3D iWrappedNode3D = this.getParentNode(redrawContextHigh);
        this.node = this.getEALManager().createNode3D(iWrappedNode3D, EALManager.createNodeName("partialPopupRoot", this.controller.getID(), (AbstractRenderer)this), this.controller.getWidth(), this.controller.getHeight(), redrawContextHigh.getCalculatedNodeIndex(this.controller.getDepth()));
        if (this.controller.getCurrentStyle() == 1) {
            this.node.setVisible(false);
            this.setOffscreenLayerVisible(false);
        }
        if (this.clipping) {
            this.node.setClipping(true);
        }
        if (this.hasGlassplate()) {
            this.offscreenLayer = this.getEALManager().createLayer(EALManager.createNodeName("PartialPopupGlassplate", this), -10, GlassplateRendererHigh.OFFSCREEN_TEXTURE_WIDTH, GlassplateRendererHigh.OFFSCREEN_TEXTURE_HEIGHT);
        }
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (abstractWidget instanceof PartialPopupGlassplateController) {
            if (this.offscreenLayer != null && this.controller.isInvalid()) {
                this.offscreenLayer.setInvalid(true);
                abstractWidget.setCompositesDirty(true);
            }
            redrawContextHigh.parentNode = this.node;
            redrawContextHigh.offscreenLayer = this.offscreenLayer;
        } else {
            redrawContextHigh.parentNode = this.offscreenLayer != null ? this.offscreenLayer.getNode() : this.node;
        }
    }

    protected boolean hasGlassplate() {
        List list = this.controller.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            AbstractWidget abstractWidget = (AbstractWidget)list.get(i2);
            if (!(abstractWidget instanceof PartialPopupGlassplateController)) continue;
            return true;
        }
        return false;
    }

    public void disconnect() {
        super.disconnect();
        if (this.offscreenLayer != null) {
            this.getEALManager().destroy(this.offscreenLayer);
            this.offscreenLayer = null;
        }
    }

    private boolean keepPositionInRTL() {
        int n = this.controller.getID();
        return n == 2100016 || n == 2100017 || n == 2100018 || n == 2100021 || n == 2100035 || n == 2100040 || n == 2100008 || this.keepPositionInRTL;
    }

    public void keepPositionInRTL(boolean bl) {
        this.keepPositionInRTL = bl;
    }

    private int getXOffsetRTL() {
        int n = this.controller.getID();
        int n2 = 0;
        if (AbstractWidget.isScreenResolution1024()) {
            switch (n) {
                case 2100016: 
                case 2100017: {
                    n2 = 48;
                    break;
                }
                case 2100008: {
                    n2 = -6;
                    break;
                }
                default: {
                    logChannelPopups.log(10000000, "PartialPopupRendererHigh#getXOffsetRTL: no offset for the given popup with the id=%1", (long)n);
                    break;
                }
            }
        } else if (AbstractWidget.isScreenResolution800()) {
            switch (n) {
                case 2100008: {
                    n2 = -13;
                    break;
                }
                default: {
                    logChannelPopups.log(10000000, "PartialPopupRendererHigh#getXOffsetRTL: no offset for the given popup with the id=%1", (long)n);
                }
            }
        }
        return n2;
    }

    protected void applyProperties(RedrawContextHigh redrawContextHigh) {
    }
}

