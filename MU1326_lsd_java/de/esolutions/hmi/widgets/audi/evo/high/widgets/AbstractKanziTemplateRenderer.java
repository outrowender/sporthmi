/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;

public abstract class AbstractKanziTemplateRenderer
extends AbstractRendererHigh
implements IKanziTemplateRenderer {
    private static final int OFFSCREEN_FBO_HEIGHT_DEFAULT = 400;
    private static final int OFFSCREEN_FBO_HEIGHT_RES_400 = 200;
    private static final int OFFSCREEEN_FBO_WIDTH_DEFAULT = 950;
    private static final int OFFSCREEN_FBO_WIDTH_RES_400 = 380;
    private static final int OFFSCREEN_FBO_WIDTH_RES_800 = 800;
    protected IWrappedNode3D node;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();

    public void render(RedrawContext redrawContext) {
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        int n = redrawContext.getCalculatedNodeIndex(this.getAbstractController().getDepth());
        if (this.node == null) {
            this.node = this.createNode(redrawContextHigh.parentNode, n);
        } else {
            this.node.setNodeIndex(n);
            IWrappedNode3D iWrappedNode3D = this.node.getParent();
            if (iWrappedNode3D == null) {
                IWrappedNode3D iWrappedNode3D2 = redrawContextHigh.parentNode;
                iWrappedNode3D2.add(this.node);
            }
        }
        if (this.node != null) {
            if (this.getAbstractController().shouldRender()) {
                this.applyVisibility(true);
                this.applyProperties(redrawContextHigh);
            } else {
                this.applyVisibility(false);
            }
        }
    }

    protected void applyVisibility(boolean bl) {
        this.node.setVisible(bl);
    }

    protected abstract void applyProperties(RedrawContextHigh var1);

    protected abstract String getTemplateNodePath();

    protected abstract String getEALNodeName();

    protected IWrappedNode3D createNode(IWrappedNode3D iWrappedNode3D, int n) {
        IWrappedNode3D iWrappedNode3D2 = null;
        int n2 = this.getKzbConstant();
        if (n2 == 0) {
            logChannel3DEngine.log(10000, "AbstractKanziTemplateRenderer#createNode: kzbConstant not set at Renderer");
            return null;
        }
        String string = this.getTemplateNodePath();
        if (string == null) {
            logChannel3DEngine.log(10000, "AbstractKanziTemplateRenderer#createNode: templateNodePath not set");
            return null;
        }
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            logChannel3DEngine.log(10000, "AbstractKanziTemplateRenderer#createNode: no EALManager available, this=%1", (Object)this);
            return null;
        }
        InitializationContext initializationContext = this.getInitContext();
        if (initializationContext == null) {
            logChannel3DEngine.log(10000, "AbstractKanziTemplateRenderer#createNode: no InitializationContext available, this=%1", (Object)this);
            return null;
        }
        IWrappedNode3D iWrappedNode3D3 = null;
        if (string.equals("Prefabs/generic_glassPlate_partialPopup")) {
            iWrappedNode3D3 = eALManager.createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName("optionDrawerGlassPlate", this), 0.0f, 0.0f, n2, "Prefabs/generic_glassPlate_optionsDrawer", initializationContext.getScreenID());
        }
        iWrappedNode3D2 = eALManager.createTemplateInstanceNode(iWrappedNode3D, EALManager.createNodeName(this.getEALNodeName(), this), 0.0f, 0.0f, n2, string, initializationContext.getScreenID(), n);
        if (iWrappedNode3D3 != null) {
            eALManager.destroy(iWrappedNode3D3);
        }
        return iWrappedNode3D2;
    }

    protected abstract int getKzbConstant();

    public void disconnect() {
        this.destroyProperties();
        super.disconnect();
        if (this.node != null) {
            this.getEALManager().destroy(this.node);
            this.node = null;
        }
    }

    protected void destroyProperties() {
        this.propertyCache.clearAll();
    }

    protected boolean setProperty(String string, float f2) {
        return this.propertyCache.setProperty(this.node, string, f2);
    }

    protected boolean setColorProperty(String string, int n) {
        return this.propertyCache.setColorProperty(this.node, string, n);
    }

    protected boolean setProperty(String string, boolean bl) {
        return this.propertyCache.setProperty(this.node, string, bl);
    }

    protected boolean setPropertyWithoutChangeCheck(String string, boolean bl) {
        return this.propertyCache.setPropertyWithoutChangeCheck(this.node.getNode(), string, bl);
    }

    protected boolean setProperty(String string, colorRGBAf colorRGBAf2) {
        return this.propertyCache.setProperty(this.node, string, colorRGBAf2);
    }

    protected boolean setProperty(String string, ITexture iTexture) {
        return this.propertyCache.setProperty(this.node, string, iTexture);
    }

    public void setKzbIDs(int[] nArray) {
    }

    protected static int getOffscreenWidth() {
        int n = 950;
        int n2 = AbstractWidget.framework.getScreenRes();
        if (n2 == 1) {
            n = 800;
        }
        if (n2 == 0) {
            n = 380;
        }
        return n;
    }

    protected static int getOffscreenHeight() {
        int n = 400;
        if (AbstractWidget.isScreenResolution400()) {
            n = 200;
        }
        return n;
    }
}

