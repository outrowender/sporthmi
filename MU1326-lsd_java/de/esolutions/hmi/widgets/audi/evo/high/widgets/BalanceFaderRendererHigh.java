/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.BalanceFaderController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IBalanceFaderRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.balancefader.ValuePair;

public class BalanceFaderRendererHigh
extends AbstractRendererHigh
implements IBalanceFaderRenderer {
    private static final float VISIBLE;
    private static final float INVISIBLE;
    private static final int BACKGROUND_IMAGE_INDEX;
    private static boolean isProjectMerged;
    private static IWrappedNode3D rootNodeOnscreen;
    private static INode2D rootNodeOffscreen;
    private final BalanceFaderController controller;
    private final EALPropertyCache propertyCache;
    private boolean isInitialized;
    private boolean resourcesLoaded;
    private IWrappedNode3D backgroundNode;
    private IWrappedNode3D backgroundImage;

    public BalanceFaderRendererHigh(BalanceFaderController balanceFaderController) {
        this.controller = balanceFaderController;
        this.propertyCache = new EALPropertyCache();
    }

    @Override
    public void disconnect() {
        this.destroyBackgroundImage();
        this.removeRootNodeFromScenegraph();
        rootNodeOffscreen.setVisible(false);
        this.disposeNode(this.backgroundNode);
        this.backgroundNode = null;
        this.isInitialized = false;
        this.resourcesLoaded = false;
        super.disconnect();
    }

    private void destroyBackgroundImage() {
        if (this.backgroundImage != null) {
            this.getEALManager().destroy(this.backgroundImage);
            this.backgroundImage = null;
        }
    }

    private void removeRootNodeFromScenegraph() {
        if (rootNodeOnscreen != null) {
            INode3D iNode3D = rootNodeOnscreen.getNode().getParent();
            if (iNode3D.isValid()) {
                iNode3D.remove(rootNodeOnscreen.getNode());
            }
            iNode3D.dispose();
        }
    }

    @Override
    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender() || this.controller.getOpacity() == 0.0f) {
            return;
        }
        if (!this.resourcesLoaded) {
            this.loadResources((RedrawContextHigh)redrawContext);
        }
        this.applyProperties();
    }

    private void loadResources(RedrawContextHigh redrawContextHigh) {
        if (!isProjectMerged) {
            this.mergeKzbProject();
            if (!isProjectMerged) {
                return;
            }
            rootNodeOnscreen = new WrappedNode3D(this.getEALManager().getShortcutNode3D("balanceFader_OnScreenRoot"), 1.0f, 1.0f, false, 0, this.isLTR());
            rootNodeOffscreen = this.getEALManager().getShortcutNode2D("balanceFader_ViewportOffScreen");
        } else {
            logBalanceFader.log(-2137614336, "BalanceFaderRendererHigh#loadResources: project already merged");
        }
        this.backgroundNode = new WrappedNode3D(this.getEALManager().getShortcutNode3D("balanceFader_Background_Texture"), 1.0f, 1.0f, false, 0, this.isLTR());
        INode3D iNode3D = rootNodeOnscreen.getNode().getParent();
        if (iNode3D.isValid()) {
            iNode3D.remove(rootNodeOnscreen.getNode());
        }
        iNode3D.dispose();
        redrawContextHigh.parentNode.getNode().add(rootNodeOnscreen.getNode());
        logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#loadResources: resources loaded");
        this.resourcesLoaded = true;
    }

    private void mergeKzbProject() {
        logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#loadResources: merging project");
        int n = this.getInitContext().getScreenID();
        INode2D iNode2D = this.getEALManager().mergeProject(2, 180, n);
        if (iNode2D == null) {
            logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#loadResources: could not merge project");
            return;
        }
        this.disposeNode(iNode2D);
        isProjectMerged = true;
        logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#loadResources: project merged");
    }

    private void disposeNode(INode iNode) {
        if (iNode == null) {
            return;
        }
        iNode.dispose();
    }

    private void disposeNode(IWrappedNode3D iWrappedNode3D) {
        if (iWrappedNode3D == null) {
            return;
        }
        this.disposeNode(iWrappedNode3D.getNode());
    }

    private void applyProperties() {
        if (!this.resourcesLoaded) {
            logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#applyProperties: could not apply properties: resources not loaded");
            return;
        }
        if (!this.isInitialized) {
            rootNodeOnscreen.setShouldFlipBack(!this.isLTR());
            rootNodeOffscreen.setVisible(true);
            this.setNodePositions();
            this.applyBackgroundImage();
            this.isInitialized = true;
        }
        this.applyCrosshairVisibility();
        this.applyCrosshairPosition();
        if (AbstractWidget.isRightHandDrive() && this.isLTR() || !this.isLTR() && !AbstractWidget.isRightHandDrive()) {
            this.backgroundImage.setHorizontalFlip(true);
        }
    }

    private void applyBackgroundImage() {
        TextureDescription textureDescription = this.getTextureDescription(0, true);
        if (textureDescription != null) {
            this.backgroundImage = this.getEALManager().createImage3D(this.backgroundNode, "BalanceFaderInterieur", textureDescription, 0, true, (Object)this);
            if (this.backgroundImage == null) {
                logBalanceFader.log(1078071040, "BalanceFaderRendererHigh#applyBackgroundImage texture null ");
            }
        }
    }

    private void setNodePositions() {
        ValuePair valuePair = this.calculateBackgroundImagePosition();
        this.backgroundNode.setPosition(valuePair.getX(), valuePair.getY(), 0.0f);
        ValuePair valuePair2 = this.calculateRootNodePosition();
        rootNodeOnscreen.setPosition(valuePair2.getX(), valuePair2.getY(), 0.0f);
    }

    private ValuePair calculateBackgroundImagePosition() {
        float f2 = -((float)this.controller.getWidth() / 2.0f);
        float f3 = -((float)this.controller.getHeight() / 2.0f);
        f2 = Math.round(f2);
        f3 = Math.round(f3);
        return new ValuePair(f2, f3);
    }

    private ValuePair calculateRootNodePosition() {
        ValuePair valuePair = new ValuePair(this.controller.getX(), this.controller.getY());
        if (!this.isLTR()) {
            valuePair = valuePair.add(this.controller.getWidth(), 0.0f);
        }
        return valuePair;
    }

    private void applyCrosshairVisibility() {
        int n = this.controller.getCrosshairMode();
        if (n == 0) {
            this.setVisibilityFreeMove(1.0f);
            this.setVisibilityBalance(0.0f);
            this.setVisibilityFader(0.0f);
        }
        if (n == 1) {
            this.setVisibilityFreeMove(0.0f);
            this.setVisibilityBalance(1.0f);
            this.setVisibilityFader(0.0f);
        }
        if (n == 2) {
            this.setVisibilityFreeMove(0.0f);
            this.setVisibilityBalance(0.0f);
            this.setVisibilityFader(1.0f);
        }
        if (n == 3) {
            this.setVisibilityFreeMove(0.0f);
            this.setVisibilityBalance(0.0f);
            this.setVisibilityFader(0.0f);
        }
    }

    private void setVisibilityFreeMove(float f2) {
        this.propertyCache.setProperty(rootNodeOnscreen, "freeMove_visible", f2);
    }

    private void setVisibilityBalance(float f2) {
        this.propertyCache.setProperty(rootNodeOnscreen, "balance_visible", f2);
    }

    private void setVisibilityFader(float f2) {
        this.propertyCache.setProperty(rootNodeOnscreen, "fader_visible", f2);
    }

    private void applyCrosshairPosition() {
        ValuePair valuePair = this.controller.getCrosshairPosition();
        this.propertyCache.setProperty(rootNodeOnscreen, "translate_X", valuePair.getX());
        this.propertyCache.setProperty(rootNodeOnscreen, "translate_Y", valuePair.getY());
    }

    protected String getTemplateNodePath() {
        return "Prefabs/BalanceFader";
    }

    protected String getEALNodeName() {
        return "BalanceFader";
    }

    @Override
    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setMoveableArea(int n, int n2, int n3, int n4) {
    }
}

