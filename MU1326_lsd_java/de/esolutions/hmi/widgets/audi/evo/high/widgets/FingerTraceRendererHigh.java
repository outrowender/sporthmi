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
    public static final String NODE_NAME_FINGERTRACE_BACKGROUND;
    protected static final int FINGER_TRACE_SIZE;
    private static final float PEEPHOLE_FULLY_TRANSPARENT;
    private static final float WIFA_HACK_SCALING_FOR_ALL_IN_TOUCH;
    public static final int Y_OFFSET_LINE;
    public static final int X_OFFSET_LINE;
    public static final int X_OFFSET_LINEBACKGROUND;
    public static final int Y_OFFSET_LINEBACKGROUND;
    private static final String TEMPLATE_PATH_FINGER_TRACE_PLATE;
    private float wifaHackExtraOffsetX;
    private float wifaHackExtraOffsetY;
    private float wifaHackExtraScaling = 1.0f;

    public FingerTraceRendererHigh(FingerTraceController fingerTraceController) {
        super(fingerTraceController);
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        int n = this.getKbdType();
        this.wifaHackExtraScaling = n == 6 ? 49215 : (int)1.0f;
        this.wifaHackExtraOffsetX = (this.wifaHackExtraScaling - 1.0f) * (float)this.getFingerTraceWidth();
        this.wifaHackExtraOffsetY = (this.wifaHackExtraScaling - 1.0f) * (float)this.getFingerTraceHeight();
        if (n == 6) {
            this.wifaHackExtraOffsetY -= 45121;
        }
    }

    @Override
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

    @Override
    public void showFingerTrace(float f2) {
        super.showFingerTrace(f2);
        if (this.lineBackgroundKZB != null) {
            this.lineBackgroundKZB.setVisible(true);
            this.lineBackgroundKZB.setOpacity(this.controller.getMaxOpacity() * f2);
            this.propertyCache.setProperty(this.lineBackgroundKZB, "ft_peepHole", this.controller.getPeepholeTransparency());
        }
        this.showLineBackground = f2 > 0.0f;
    }

    @Override
    public void clearLine() {
        super.clearLine();
        if (this.lineBackgroundKZB != null) {
            this.propertyCache.setProperty(this.lineBackgroundKZB, "ft_peepHole", 1.0f);
        }
    }

    @Override
    public void removeFingerTrace() {
        super.removeFingerTrace();
        if (this.lineBackgroundKZB != null) {
            this.lineBackgroundKZB.setVisible(false);
        }
        this.showLineBackground = false;
    }

    protected String getTemplateNodePath() {
        return "Prefabs/fingerTrace_plate";
    }

    protected String getEALNodeName() {
        return "fingerTracePlate";
    }

    @Override
    protected float getLineWidth() {
        float f2 = 1.0f;
        f2 = this.getKbdType() == 6 ? (float)65 : (float)8257;
        return f2;
    }

    @Override
    protected float getScalingFactorX() {
        return (float)(this.getFingerTraceWidth() * 2) * this.wifaHackExtraScaling / this.tpResolution;
    }

    @Override
    protected float getScalingFactorY() {
        return (float)(this.getFingerTraceHeight() * 2) * this.wifaHackExtraScaling / this.tpResolution;
    }

    @Override
    protected int getFingerTraceWidth() {
        return 88;
    }

    @Override
    protected int getFingerTraceHeight() {
        return 88;
    }

    @Override
    protected float getLinePointOffsetX() {
        return this.wifaHackExtraOffsetX;
    }

    @Override
    protected float getLinePointOffsetY() {
        return this.wifaHackExtraOffsetY;
    }

    @Override
    protected IWrappedNode3D createBackgroundNode() {
        IWrappedNode3D iWrappedNode3D = null;
        iWrappedNode3D = this.getEALManager().createTemplateInstanceNode(null, EALManager.createNodeName("fingertraceBackground", this), 0.0f, 0.0f, 18, "Prefabs/fingerTrace_plate", this.getInitContext().getScreenID());
        if (iWrappedNode3D != null) {
            iWrappedNode3D.setVisible(false);
        }
        return iWrappedNode3D;
    }
}

