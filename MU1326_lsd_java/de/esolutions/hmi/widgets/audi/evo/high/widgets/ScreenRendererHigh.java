/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.AbstractRenderer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedLayer;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.ScreenWidgetRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.HMITerminalImplMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;

public class ScreenRendererHigh
extends AbstractRendererHigh
implements ScreenWidgetRenderer {
    private final AbstractScreenWidget controller;
    protected IWrappedNode3D node;
    protected IWrappedLayer layerAbove;
    protected IWrappedLayer layerBelow;
    protected IWrappedLayer layerMapBorder;

    public ScreenRendererHigh(AbstractScreenWidget abstractScreenWidget) {
        this.controller = abstractScreenWidget;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.getEALManager().newScreenConnected(this.controller);
        this.getEALManager().setClearMethod(this.controller.getClearMethod());
        if (this.node != null) {
            this.node.setVisible(true);
            this.node.setPosition(0.0f, 0.0f, 0.0f);
        }
        this.connectLayer(this.layerAbove);
        this.connectLayer(this.layerBelow);
        this.connectLayer(this.layerMapBorder);
    }

    private void connectLayer(IWrappedLayer iWrappedLayer) {
        if (iWrappedLayer == null) {
            return;
        }
        IWrappedNode3D iWrappedNode3D = iWrappedLayer.getNode();
        iWrappedNode3D.setVisible(true);
        iWrappedNode3D.setPosition(0.0f, 0.0f, 0.0f);
    }

    public void disconnect() {
        super.disconnect();
        this.destroyNode();
    }

    private void destroyNode() {
        this.getEALManager().destroy(this.node);
        this.getEALManager().destroy(this.layerAbove);
        this.getEALManager().destroy(this.layerBelow);
        this.getEALManager().destroy(this.layerMapBorder);
        this.node = null;
        this.layerAbove = null;
        this.layerBelow = null;
        this.layerMapBorder = null;
    }

    public RedrawContext createRedrawContextRoot() {
        return new RedrawContextHigh();
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        IWrappedNode3D iWrappedNode3D = this.getParentNodeForChild(abstractWidget);
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        if (iWrappedNode3D == null || !iWrappedNode3D.isValid()) {
            logChannel3DEngine.log(10000, "ScreenRendererHigh#prepareRedrawContextForChildren: node is null or invalid");
            return;
        }
        ((RedrawContextHigh)redrawContext).parentNode = iWrappedNode3D;
    }

    public void invalidateViewPort() {
        this.getEALManager().getScreensLayer().setInvalid(true);
    }

    private IWrappedNode3D getParentNodeForChild(AbstractWidget abstractWidget) {
        if (!(abstractWidget instanceof ContainerController)) {
            return this.node;
        }
        ContainerController containerController = (ContainerController)abstractWidget;
        int n = containerController.getScreenLayer();
        if (n == 2) {
            return this.node;
        }
        if (n == 1 || n == 6) {
            if (this.layerAbove != null) {
                return this.layerAbove.getNode();
            }
            this.layerAbove = this.createLayer(1);
            if (this.layerAbove != null) {
                boolean bl = this.getTerminal().getFramework().getLanguageMgr().isLeftToRightOrientation();
                this.layerAbove.setLayoutDirectionLeftToRight(bl || n == 6);
                return this.layerAbove.getNode();
            }
        } else if (n == 3) {
            if (this.layerBelow != null) {
                return this.layerBelow.getNode();
            }
            this.layerBelow = this.createLayer(3);
            if (this.layerBelow != null) {
                return this.layerBelow.getNode();
            }
        } else if (n == 7) {
            if (this.layerMapBorder != null) {
                return this.layerMapBorder.getNode();
            }
            this.layerMapBorder = this.createLayer(7);
            if (this.layerMapBorder != null) {
                return this.layerMapBorder.getNode();
            }
        }
        return this.node;
    }

    private IWrappedLayer createLayer(int n) {
        int n2;
        String string;
        logChannel3DEngine.log(10000000, "ScreenRendererHigh#createLayer(%1) - Called", (long)n);
        int n3 = this.getTerminal().getLayout().getDistance(1);
        int n4 = this.getTerminal().getLayout().getDistance(2);
        switch (n) {
            case 1: {
                string = "secondaryScreenAbove";
                n2 = 150;
                break;
            }
            case 3: {
                string = "secondaryScreenBelow";
                n2 = 120;
                break;
            }
            case 7: {
                string = "secondaryScreenMapBorder";
                n2 = 160;
                break;
            }
            default: {
                logChannel3DEngine.log(100000, "ScreenRendererHigh#createLayer: Could not create layer for ID %1 as it is unknown.", (long)n);
                return null;
            }
        }
        IWrappedLayer iWrappedLayer = this.getEALManager().createLayer(string, n2, n3, n4);
        if (iWrappedLayer == null) {
            logChannel3DEngine.log(10000, "ScreenRendererHigh#createLayer: Could not create layer %1 at index %2", (Object)string, (long)n2);
            return null;
        }
        switch (n) {
            case 7: {
                try {
                    HMITerminalImplMIB2High hMITerminalImplMIB2High = (HMITerminalImplMIB2High)this.getTerminal();
                    if (hMITerminalImplMIB2High.getCarCodingHelper().isR8()) {
                        float f2 = iWrappedLayer.getMainNode().getX();
                        float f3 = iWrappedLayer.getMainNode().getY();
                        float f4 = iWrappedLayer.getMainNode().getZ();
                        int n5 = hMITerminalImplMIB2High.getLayout().getIntegerConstant(108);
                        int n6 = hMITerminalImplMIB2High.getLayout().getIntegerConstant(109);
                        iWrappedLayer.getMainNode().setPosition(f2 + (float)n5, f3 + (float)n6, f4);
                    }
                }
                catch (ClassCastException classCastException) {
                    logChannel3DEngine.log(10000, "ScreenRendererHigh#createLayer: Could not cast terminal to HMITerminalImplMIB2High.");
                }
                return iWrappedLayer;
            }
        }
        return iWrappedLayer;
    }

    public void render(RedrawContext redrawContext) {
        if (this.node == null) {
            this.node = this.getEALManager().createNode3D(this.getEALManager().getScreensNode(), EALManager.createNodeName("screenRoot", this.controller.getID(), (AbstractRenderer)this), 0.0f, 0.0f);
        }
    }

    public void handlePaintError(Exception exception) {
        exception.printStackTrace();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }
}

