/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets.asia;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.HMITerminal;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.TextureDescription;
import de.esolutions.hmi.widgets.audi.evo.InstructionTextContoller;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractFingerTraceRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.InstructionTextRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.asia.FingerTraceRendererFullScreenHigh$Point;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.GlassplateController;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.MenuController;
import java.util.List;

public class FingerTraceRendererFullScreenHigh
extends AbstractFingerTraceRendererHigh {
    public static final String NODE_NAME_PREFIX_GRAYOUT_OVERLAY;
    private static final float LINE_WIDTH_TOUCHWHEEL;
    private static final float LINE_WIDTH_AIT;
    public static final float DEFAULT_DIAMETER;
    private float diameter = 33859;
    private float canvasHeight = 0.0f;
    private float canvasWidth = 0.0f;
    private IWrappedNode3D grayOutOverlay;
    private int grayOutOverlayPositionX = 0;
    private int grayOutOverlayPositionY = 0;
    private InstructionTextContoller ancestorInstructionTextController;
    private GlassplateController glassplateController;
    private MenuController menuController;
    private int screenWidth;
    private int screenHeight;
    private float fingerTraceExtraScaling = 1.0f;

    public FingerTraceRendererFullScreenHigh(FingerTraceController fingerTraceController) {
        super(fingerTraceController);
    }

    @Override
    public void connect(InitializationContext initializationContext) {
        this.controllerHierarchyDetect();
        HMITerminal hMITerminal = this.controller.getTerminal();
        this.screenWidth = ((HMITerminalImpl)hMITerminal).getLayout().getDistance(1);
        this.screenHeight = ((HMITerminalImpl)hMITerminal).getLayout().getDistance(2);
        this.calculateDisplayBounds();
        if (this.getKbdType() == 6) {
            this.fingerTraceExtraScaling = 0x3333B33F;
        }
        super.connect(initializationContext);
    }

    private void controllerHierarchyDetect() {
        this.ancestorInstructionTextController = FingerTraceRendererFullScreenHigh.findInstructionTextController(this.controller);
        this.menuController = FingerTraceRendererFullScreenHigh.findMenuController(this.controller);
        this.glassplateController = FingerTraceRendererFullScreenHigh.findGlassplateController(this.menuController);
        tpLogChannelKeypanel.log(1078071040, "FingerTraceRendererFullScreenHigh#controllerHierarchyDetect: Hierarchy Detect Finished");
    }

    protected static InstructionTextContoller findInstructionTextController(FingerTraceController fingerTraceController) {
        for (AbstractWidget abstractWidget = fingerTraceController.getParent(); abstractWidget != null; abstractWidget = abstractWidget.getParent()) {
            if (!(abstractWidget instanceof InstructionTextContoller)) continue;
            return (InstructionTextContoller)abstractWidget;
        }
        return null;
    }

    protected static MenuController findMenuController(FingerTraceController fingerTraceController) {
        for (AbstractWidget abstractWidget = fingerTraceController; abstractWidget != null; abstractWidget = abstractWidget.getParent()) {
            if (!(abstractWidget instanceof MenuController)) continue;
            return (MenuController)abstractWidget;
        }
        return null;
    }

    @Override
    public void render(RedrawContext redrawContext) {
        super.render(redrawContext);
        this.createGrayOutOverlayIfNotExisting();
    }

    @Override
    protected IWrappedNode3D getFingertraceParentNode(RedrawContext redrawContext) {
        if (this.ancestorInstructionTextController != null) {
            InstructionTextRendererHigh instructionTextRendererHigh = (InstructionTextRendererHigh)this.ancestorInstructionTextController.getRenderer();
            return instructionTextRendererHigh.getForegroundNode();
        }
        return super.getFingertraceParentNode(redrawContext);
    }

    protected static GlassplateController findGlassplateController(MenuController menuController) {
        if (menuController == null) {
            return null;
        }
        GlassplateController glassplateController = FingerTraceRendererFullScreenHigh.findGlassPlateControllerChild(menuController);
        if (glassplateController != null) {
            tpLogChannelInternal.log(-2137614336, "FingerTraceRendererFullScreenHigh#findGlassplateController: found glassplate controller in default menu hierarchy.");
            return glassplateController;
        }
        AbstractWidget abstractWidget = menuController.getParent();
        if (abstractWidget instanceof ContainerController) {
            glassplateController = FingerTraceRendererFullScreenHigh.findGlassPlateControllerChild(menuController.getParent());
            tpLogChannelInternal.log(-2137614336, "FingerTraceRendererFullScreenHigh#findGlassplateController: found glassplate controller in menu parent hierarchy.");
            return glassplateController;
        }
        tpLogChannelInternal.log(10000, "FingerTraceRendererFullScreenHigh#findGlassplateController: could not find glassplate controller!");
        return null;
    }

    private static GlassplateController findGlassPlateControllerChild(AbstractWidget abstractWidget) {
        List list = abstractWidget.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!(list.get(i2) instanceof GlassplateController)) continue;
            return (GlassplateController)list.get(i2);
        }
        return null;
    }

    private void createGrayOutOverlayIfNotExisting() {
        if (this.grayOutOverlay == null) {
            TextureDescription textureDescription = this.getEALManager().createTextureDescription(HMIImageConstantsSystem.black_pixel, false, this.getInitContext().getScreenID());
            if (textureDescription == null) {
                tpLogChannelKeypanel.log(10000, "FingerTraceRendererFullScreenHigh#createGrayOutOverlayIfNotExisting: Could not create black pixel TextureDescription (index %1).", (long)HMIImageConstantsSystem.black_pixel);
                return;
            }
            this.grayOutOverlay = this.getEALManager().createImage3D(this.getMainNode(), EALManager.createNodeName("grayoutOverlay", this), textureDescription, 199, false, (Object)this);
            if (this.grayOutOverlay == null) {
                tpLogChannelKeypanel.log(10000, "FingerTraceRendererFullScreenHigh#createGrayOutOverlayIfNotExisting: Could not create grayOutOverlay.");
                return;
            }
            this.grayOutOverlay.setScale(this.screenWidth, this.screenHeight, 0.0f);
            this.grayOutOverlay.setVisible(false);
        }
        this.setGrayOutOverlayPositionIfChanged();
    }

    private void setGrayOutOverlayPositionIfChanged() {
        if (this.grayOutOverlay != null) {
            int n;
            int n2;
            if (this.ancestorInstructionTextController != null) {
                n2 = -this.ancestorInstructionTextController.getX();
                n = -this.ancestorInstructionTextController.getY();
            } else if (this.menuController != null) {
                n2 = -this.menuController.getX();
                n = -this.menuController.getY();
            } else {
                tpLogChannelKeypanel.log(10000, "FingerTraceRendererFullScreenHigh#setGrayOutOverlayPositionIfChanged: Could not determine gray-out overlay position");
                return;
            }
            if (n2 != this.grayOutOverlayPositionX || n != this.grayOutOverlayPositionY) {
                this.grayOutOverlayPositionX = n2;
                this.grayOutOverlayPositionY = n;
                this.grayOutOverlay.setPosition(n2, n, 0.0f);
            }
        }
    }

    private void calculateDisplayBounds() {
        int n;
        if (this.menuController != null && this.glassplateController != null) {
            n = (int)((float)Math.max(this.menuController.getHeight(), this.glassplateController.getHeight()));
            this.canvasWidth = Math.max(this.menuController.getWidth(), this.glassplateController.getWidth());
            this.canvasHeight = n;
            tpLogChannelKeypanel.log(-2137614336, "FingerTraceRendererFullScreenHigh#calculateDisplayBound: found menu widget, using menu bounds: diameter %1, canvasWidth %2", (Object)String.valueOf(this.diameter), (Object)String.valueOf(this.canvasWidth));
        } else {
            n = 33859;
            this.canvasWidth = this.screenWidth;
            this.canvasHeight = this.screenHeight;
            tpLogChannelKeypanel.log(10000, "FingerTraceRendererFullScreenHigh#calculateDisplayBound: did not find menu widget, using screen bounds: diameter %1.", (double)this.diameter);
        }
        if (this.diameter != n) {
            this.destroyLineForRecreate();
            this.diameter = n;
        }
    }

    private void destroyLineForRecreate() {
        if (this.line != null) {
            this.getEALManager().destroy(this.line);
            this.line = null;
        }
    }

    @Override
    protected float getLineWidth() {
        float f2 = 1.0f;
        f2 = this.getKbdType() == 6 ? (float)53313 : (float)45121;
        return f2;
    }

    @Override
    protected int getFingerTraceWidth() {
        return (int)(this.diameter * this.fingerTraceExtraScaling);
    }

    @Override
    protected int getFingerTraceHeight() {
        return (int)(this.diameter * this.fingerTraceExtraScaling);
    }

    @Override
    protected IWrappedNode3D createBackgroundNode() {
        return null;
    }

    @Override
    protected void applyProperties() {
    }

    @Override
    protected void createLineIfNotExisting(RedrawContext redrawContext) {
        super.createLineIfNotExisting(redrawContext);
        this.doFingerTracePositioning();
    }

    private void doFingerTracePositioning() {
        if (this.line != null) {
            float f2;
            float f3;
            if (this.isInstructionTextHierarchy()) {
                f3 = this.menuController.getY() + this.glassplateController.getY();
                f2 = (this.canvasWidth - this.diameter * this.fingerTraceExtraScaling) / 2.0f + (float)this.menuController.getX();
            } else if (this.isNormalMenuHierarchy()) {
                f3 = 0.0f;
                f2 = (this.canvasWidth - this.diameter * this.fingerTraceExtraScaling) / 2.0f;
            } else {
                FingerTraceRendererFullScreenHigh$Point fingerTraceRendererFullScreenHigh$Point = FingerTraceRendererFullScreenHigh.getAbsoluteParentOffsetToUpperLeftScreenCorner(this.line);
                f2 = (this.canvasWidth - this.diameter * this.fingerTraceExtraScaling) / 2.0f - (float)fingerTraceRendererFullScreenHigh$Point.x;
                f3 = (this.canvasHeight - this.diameter) / 2.0f - (float)fingerTraceRendererFullScreenHigh$Point.y;
            }
            this.line.setPosition(f2, f3, 0.0f);
        }
    }

    private boolean isNormalMenuHierarchy() {
        return this.ancestorInstructionTextController == null && this.menuController != null && this.glassplateController != null;
    }

    public boolean isInstructionTextHierarchy() {
        return this.ancestorInstructionTextController != null && this.menuController != null && this.glassplateController != null;
    }

    private static FingerTraceRendererFullScreenHigh$Point getAbsoluteParentOffsetToUpperLeftScreenCorner(IWrappedNode3D iWrappedNode3D) {
        int n = 0;
        int n2 = 0;
        IWrappedNode3D iWrappedNode3D2 = iWrappedNode3D;
        while (iWrappedNode3D2.getParent() != null) {
            iWrappedNode3D2 = iWrappedNode3D2.getParent();
            n = (int)((float)n + iWrappedNode3D2.getX());
            n2 = (int)((float)n2 + iWrappedNode3D2.getY());
        }
        FingerTraceRendererFullScreenHigh$Point fingerTraceRendererFullScreenHigh$Point = new FingerTraceRendererFullScreenHigh$Point(null);
        fingerTraceRendererFullScreenHigh$Point.x = n;
        fingerTraceRendererFullScreenHigh$Point.y = n2;
        return fingerTraceRendererFullScreenHigh$Point;
    }

    @Override
    protected float getLinePointOffsetX() {
        return 0.0f;
    }

    @Override
    protected float getLinePointOffsetY() {
        return 0.0f;
    }

    @Override
    protected float getScalingFactorX() {
        return (float)(this.getFingerTraceWidth() * 2) / this.tpResolution;
    }

    @Override
    protected float getScalingFactorY() {
        return (float)(this.getFingerTraceHeight() * 2) / this.tpResolution;
    }

    @Override
    public void viewSizeChanged() {
        if (this.glassplateController == null) {
            this.controllerHierarchyDetect();
        }
        this.calculateDisplayBounds();
        this.doFingerTracePositioning();
    }

    @Override
    public void showFingerTrace(float f2) {
        if (this.line != null && this.line.isVisible()) {
            this.updateBackgroundGrayOut(f2);
        }
        super.showFingerTrace(f2);
    }

    protected void updateBackgroundGrayOut(float f2) {
        if (this.grayOutOverlay == null) {
            return;
        }
        if (f2 <= 0.0f) {
            this.grayOutOverlay.setVisible(false);
        } else {
            this.grayOutOverlay.setVisible(true);
            this.grayOutOverlay.setOpacity(Math.min((float)63, (float)(63 * f2)));
        }
    }

    @Override
    public void clearLine() {
        this.updateBackgroundGrayOut(0.0f);
        super.clearLine();
    }

    @Override
    public void disconnect() {
        this.ancestorInstructionTextController = null;
        this.menuController = null;
        this.glassplateController = null;
        this.grayOutOverlayPositionX = -1;
        this.grayOutOverlayPositionY = -1;
        if (this.grayOutOverlay != null) {
            this.getEALManager().destroy(this.grayOutOverlay);
            this.grayOutOverlay = null;
        }
        super.disconnect();
    }

    @Override
    public void onviewSizeChanging() {
        this.calculateDisplayBounds();
        this.doFingerTracePositioning();
    }
}

