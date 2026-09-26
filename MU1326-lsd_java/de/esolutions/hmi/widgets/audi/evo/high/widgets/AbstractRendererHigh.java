/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.view.Screen;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMIImage;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.Mirrorable;
import java.util.Iterator;

public abstract class AbstractRendererHigh
extends AbstractRenderer
implements Mirrorable {
    protected boolean dirty;
    protected IWrappedFont[] fonts;
    private IWrappedFont[] inheritedFonts;
    protected float x0;
    protected float y0;
    RedrawContextHigh redrawContext = new RedrawContextHigh();
    private IWrappedFont[] parentFonts;
    private int[] activeParentColorPlate;
    private boolean widgetIsMirrored = false;
    protected boolean nodeIsMirrored = false;
    private IWrappedNode3D currentNode = null;
    private IWrappedNode3D oldParentNode;
    private IWrappedNode3D oldParentSecondaryNode;

    @Override
    public void connect(InitializationContext initializationContext) {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public InitializationContext createInitContextForChildren(InitializationContext initializationContext) {
        return initializationContext;
    }

    @Override
    public RedrawContext createRedrawContext(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        this.parentFonts = redrawContextHigh.getFonts();
        this.activeParentColorPlate = redrawContextHigh.getActiveColorPlate();
        this.copyRedrawContextFields(redrawContextHigh, this.redrawContext);
        this.storeOwnRedrawContextFields(this.redrawContext);
        this.oldParentNode = this.redrawContext.parentNode;
        this.oldParentSecondaryNode = this.redrawContext.parentNodeSecondary;
        return this.redrawContext;
    }

    @Override
    public void restoreRedrawContext(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        redrawContextHigh.setFonts(this.parentFonts);
        redrawContextHigh.setActiveColorPlate(this.activeParentColorPlate);
        redrawContextHigh.parentNode = this.oldParentNode;
        redrawContextHigh.parentNodeSecondary = this.oldParentSecondaryNode;
    }

    protected void copyRedrawContextFields(RedrawContextHigh redrawContextHigh, RedrawContextHigh redrawContextHigh2) {
        redrawContextHigh2.parentNode = redrawContextHigh.parentNode;
        redrawContextHigh2.parentNodeSecondary = redrawContextHigh.parentNodeSecondary;
        redrawContextHigh2.offscreenLayer = redrawContextHigh.offscreenLayer;
        redrawContextHigh2.setScreenID(redrawContextHigh.getScreenID());
        redrawContextHigh2.setFonts(redrawContextHigh.getFonts());
        redrawContextHigh2.setFont(redrawContextHigh.getFontIndex());
        redrawContextHigh2.setColorIndices(redrawContextHigh.getColorIndices());
        redrawContextHigh2.setActiveColorPlate(redrawContextHigh.getActiveColorPlate());
        redrawContextHigh2.setNodeIndex(redrawContextHigh.getNodeIndex());
    }

    protected void storeOwnRedrawContextFields(RedrawContextHigh redrawContextHigh) {
        Screen screen;
        int n;
        if (this.fonts != null) {
            redrawContextHigh.setFonts(this.fonts);
            redrawContextHigh.setFont(0);
        }
        if ((n = this.getAbstractController().getFixedColorScheme()) != -1 && (screen = this.getAbstractController().getInitContext().getRootWindow().getCurrentScreen()) instanceof AbstractScreenWidget) {
            redrawContextHigh.setActiveColorPlate(((AbstractScreenWidget)screen).getColorPlate(n));
        }
    }

    @Override
    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
    }

    @Override
    public void setCompositesDirty(boolean bl) {
        this.dirty = bl;
    }

    @Override
    public void setCompositeDirty(int n) {
        this.dirty = true;
    }

    protected EALManager getEALManager() {
        EALManager eALManager = null;
        HMITerminalEAL hMITerminalEAL = (HMITerminalEAL)((Object)this.getTerminal());
        if (hMITerminalEAL != null) {
            eALManager = hMITerminalEAL.getEALManager();
        }
        return eALManager;
    }

    protected HMIImage getBitmap(int n) {
        int n2 = this.getAbstractController().getBitmap(n);
        if (n2 < 0) {
            return (HMIImage)this.getTerminal().getImageLoader().getEmptyImage();
        }
        if (AbstractWidget.hmiService == null) {
            logChannel.log(-1601830656, "AbstractRendererHigh#getBitmap hmiService is null. Bitmap ID: %1", (long)n2);
            return (HMIImage)this.getTerminal().getImageLoader().getEmptyImage();
        }
        EALManager eALManager = this.getEALManager();
        if (eALManager != null) {
            logChannel.log(-2137614336, "AbstractRendererHigh#getBitmap with id: %1 for index: %2", (long)n2, (long)n);
            return eALManager.getHMIImage(n2, this.getInitContext().getScreenID());
        }
        return this.getTerminal() != null && this.getTerminal().getImageLoader() != null ? (HMIImage)this.getTerminal().getImageLoader().getEmptyImage() : null;
    }

    protected TextureDescription getTextureDescription(int n, boolean bl) {
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            return null;
        }
        int n2 = this.getAbstractController().getBitmap(n);
        if (n2 >= 0 && AbstractWidget.hmiService != null) {
            logChannel.log(-2137614336, "AbstractRendererHigh#getTextureDescription with id: %1 for index: %2", (long)n2, (long)n);
            return eALManager.createTextureDescription(n2, bl, this.getInitContext().getScreenID());
        }
        HMIImage hMIImage = (HMIImage)this.getTerminal().getImageLoader().getEmptyImage();
        if (hMIImage == null) {
            return null;
        }
        return eALManager.createTextureDescription(hMIImage, eALManager.getCache(0), bl);
    }

    protected TextureDescription getTextureDescription(int n, boolean bl, boolean bl2) {
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            return null;
        }
        int n2 = this.getAbstractController().getBitmap(n);
        if (n2 >= 0 && AbstractWidget.hmiService != null) {
            logChannel.log(-2137614336, "AbstractRendererHigh#getTextureDescription with id: %1 for index: %2", (long)n2, (long)n);
            return eALManager.createTextureDescription(n2, bl, this.getInitContext().getScreenID());
        }
        HMIImage hMIImage = (HMIImage)this.getTerminal().getImageLoader().getEmptyImage();
        if (hMIImage == null) {
            return null;
        }
        return eALManager.createTextureDescription(hMIImage, eALManager.getCache(0), bl, bl2);
    }

    public IWrappedFont[] getFonts() {
        return this.fonts;
    }

    public void setFonts(IWrappedFont[] iWrappedFontArray) {
        this.fonts = iWrappedFontArray;
        this.updateInheritedFonts();
    }

    public IWrappedFont[] getInheritedFonts() {
        return this.inheritedFonts;
    }

    public IWrappedFont getInheritedFont() {
        if (this.inheritedFonts == null || this.inheritedFonts.length == 0) {
            return null;
        }
        return this.inheritedFonts[0];
    }

    @Override
    public void updateInheritedFonts() {
        IWrappedFont[] iWrappedFontArray = this.calculateInheritedFonts();
        if (this.inheritedFonts == iWrappedFontArray) {
            return;
        }
        this.inheritedFonts = iWrappedFontArray;
        this.updateChildrenInheritedFonts();
    }

    private void updateChildrenInheritedFonts() {
        AbstractWidgetController abstractWidgetController = this.getAbstractController();
        if (abstractWidgetController != null) {
            Iterator iterator = abstractWidgetController.getChildren().iterator();
            while (iterator.hasNext()) {
                IRenderer iRenderer;
                AbstractWidget abstractWidget = (AbstractWidget)iterator.next();
                if (!(abstractWidget instanceof AbstractWidgetController) || (iRenderer = ((AbstractWidgetController)abstractWidget).getRenderer()) == null) continue;
                iRenderer.updateInheritedFonts();
            }
        }
    }

    protected IWrappedFont[] calculateInheritedFonts() {
        if (this.fonts != null) {
            return this.fonts;
        }
        AbstractWidgetController abstractWidgetController = this.getAbstractController();
        if (abstractWidgetController == null) {
            return null;
        }
        int n = 20;
        for (int i2 = 0; i2 < n; ++i2) {
            if ((abstractWidgetController = (AbstractWidgetController)abstractWidgetController.getParent()) == null) {
                logChannel.log(-1601830656, "AbstractRendererHigh#calculateInheritedFonts: no font found in widget hierachy");
                return null;
            }
            IRenderer iRenderer = abstractWidgetController.getRenderer();
            if (!(iRenderer instanceof AbstractRendererHigh)) continue;
            return ((AbstractRendererHigh)iRenderer).getInheritedFonts();
        }
        logChannel.log(-1601830656, "AbstractRendererHigh#calculateInheritedFonts: widget hierachy deeper than maxHierarchyDepth: %1. No font found.", (long)n);
        return null;
    }

    public void setFloatingPointOffset(float f2, float f3) {
        this.x0 = f2;
        this.y0 = f3;
    }

    @Override
    public boolean areCompositesDirty() {
        return this.dirty;
    }

    @Override
    public void mirror(boolean bl) {
        this.widgetIsMirrored = bl;
    }

    @Override
    public void toggleMirror() {
        this.widgetIsMirrored = !this.widgetIsMirrored;
    }

    @Override
    public boolean isMirrored() {
        return this.widgetIsMirrored;
    }

    protected void applyMirrorStatus(IWrappedNode3D iWrappedNode3D) {
        boolean bl;
        boolean bl2 = bl = !Util.equals(iWrappedNode3D, this.currentNode);
        if (bl) {
            this.nodeIsMirrored = false;
        }
        boolean bl3 = this.isLTR();
        if (this.isMirrored()) {
            iWrappedNode3D.setPosition(bl3 ? iWrappedNode3D.getX() : iWrappedNode3D.getX() - iWrappedNode3D.getWidth(), iWrappedNode3D.getY(), iWrappedNode3D.getZ());
        }
        if (this.isMirrored() && !this.nodeIsMirrored) {
            iWrappedNode3D.setScale(bl3 ? iWrappedNode3D.getScaleX() : -iWrappedNode3D.getScaleX(), iWrappedNode3D.getScaleY(), iWrappedNode3D.getScaleZ());
            this.nodeIsMirrored = true;
            this.currentNode = iWrappedNode3D;
        }
    }
}

