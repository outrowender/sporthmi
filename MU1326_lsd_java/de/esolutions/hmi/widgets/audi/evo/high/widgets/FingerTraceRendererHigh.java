/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractFingerTraceRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;

public class FingerTraceRendererHigh
extends AbstractFingerTraceRendererHigh {
    public static final String NODE_NAME_FINGERTRACE_BACKGROUND = "fingertraceBackground";
    protected static final int FINGER_TRACE_SIZE = 88;
    private static final float PEEPHOLE_FULLY_TRANSPARENT = 1.0f;
    private static final float WIFA_HACK_SCALING_FOR_ALL_IN_TOUCH = 1.5f;
    public static final int Y_OFFSET_LINE = -17;
    public static final int X_OFFSET_LINE = 19;
    public static final int X_OFFSET_LINEBACKGROUND = 12;
    public static final int Y_OFFSET_LINEBACKGROUND = -22;
    private static final String TEMPLATE_PATH_FINGER_TRACE_PLATE = "Prefabs/fingerTrace_plate";
    private float wifaHackExtraOffsetX;
    private float wifaHackExtraOffsetY;
    private float wifaHackExtraScaling = 1.0f;

    public FingerTraceRendererHigh(FingerTraceController fingerTraceController) {
        super(fingerTraceController);
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        int n = this.getKbdType();
        this.wifaHackExtraScaling = n == 6 ? 1.5f : 1.0f;
        this.wifaHackExtraOffsetX = (this.wifaHackExtraScaling - 1.0f) * (float)this.getFingerTraceWidth();
        this.wifaHackExtraOffsetY = (this.wifaHackExtraScaling - 1.0f) * (float)this.getFingerTraceHeight();
        if (n == 6) {
            this.wifaHackExtraOffsetY -= 22.0f;
        }
    }

    protected void applyProperties() {
        int n = this.controller.getX();
        int n2 = this.controller.getY();
        if (this.line != null) {
            this.line.setPosition(n + 19, n2 + -17, 0.0f);
        }
        if (this.lineBackgroundKZB != null) {
            this.lineBackgroundKZB.setPosition(n + 12, n2 + -22, 0.0f);
        }
    }

    public void showFingerTrace(float f2) {
        super.showFingerTrace(f2);
        if (this.lineBackgroundKZB != null) {
            this.lineBackgroundKZB.setVisible(true);
            this.lineBackgroundKZB.setOpacity(this.controller.getMaxOpacity() * f2);
            this.propertyCache.setProperty(this.lineBackgroundKZB, "ft_peepHole", this.controller.getPeepholeTransparency());
        }
        this.showLineBackground = f2 > 0.0f;
    }

    public void clearLine() {
        super.clearLine();
        if (this.lineBackgroundKZB != null) {
            this.propertyCache.setProperty(this.lineBackgroundKZB, "ft_peepHole", 1.0f);
        }
    }

    public void removeFingerTrace() {
        super.removeFingerTrace();
        if (this.lineBackgroundKZB != null) {
            this.lineBackgroundKZB.setVisible(false);
        }
        this.showLineBackground = false;
    }

    protected String getTemplateNodePath() {
        return TEMPLATE_PATH_FINGER_TRACE_PLATE;
    }

    protected String getEALNodeName() {
        return "fingerTracePlate";
    }

    protected float getLineWidth() {
        float f2 = 1.0f;
        f2 = this.getKbdType() == 6 ? 8.0f : 10.0f;
        return f2;
    }

    protected float getScalingFactorX() {
        return (float)(this.getFingerTraceWidth() * 2) * this.wifaHackExtraScaling / this.tpResolution;
    }

    protected float getScalingFactorY() {
        return (float)(this.getFingerTraceHeight() * 2) * this.wifaHackExtraScaling / this.tpResolution;
    }

    protected int getFingerTraceWidth() {
        return 88;
    }

    protected int getFingerTraceHeight() {
        return 88;
    }

    protected float getLinePointOffsetX() {
        return this.wifaHackExtraOffsetX;
    }

    protected float getLinePointOffsetY() {
        return this.wifaHackExtraOffsetY;
    }

    protected IWrappedNode3D createBackgroundNode() {
        IWrappedNode3D iWrappedNode3D = null;
        iWrappedNode3D = this.getEALManager().createTemplateInstanceNode(null, EALManager.createNodeName(NODE_NAME_FINGERTRACE_BACKGROUND, this), 0.0f, 0.0f, 18, TEMPLATE_PATH_FINGER_TRACE_PLATE, this.getInitContext().getScreenID());
        if (iWrappedNode3D != null) {
            iWrappedNode3D.setVisible(false);
        }
        return iWrappedNode3D;
    }
}

