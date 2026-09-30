/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.view.Screen;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DQuickDraw;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.ContainerRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.DirectWritingController;
import de.esolutions.hmi.widgets.audi.evo.widgets.FingerTraceController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IFingerTraceRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;

public abstract class AbstractFingerTraceRendererHigh
extends AbstractRendererHigh
implements IFingerTraceRenderer,
IKanziTemplateRenderer {
    public static final String NODE_FINGERTRACE_LINE_NAME = "fingertraceLine";
    protected static final int NODE_INDEX_LINE = 200;
    protected static final float TOUCHPAD_RESOLUTION_MIB2 = 1024.0f;
    protected static final float TOUCHPAD_RESOLUTION_AB3 = 256.0f;
    protected static final String PROPERTY_FINGERTRACE_PEEPHOLE = "ft_peepHole";
    protected IWrappedNode3DQuickDraw line;
    protected float lineScalingFactorX = 1.0f;
    protected float lineScalingFactorY = 1.0f;
    protected boolean showLineBackground = false;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    protected FingerTraceController controller;
    protected float tpResolution;
    private int kbdType = -1;
    protected IWrappedNode3D lineBackgroundKZB;
    private IWrappedNode3D main;

    public AbstractFingerTraceRendererHigh(FingerTraceController fingerTraceController) {
        this.controller = fingerTraceController;
    }

    protected IWrappedNode3D getMainNode() {
        return this.main;
    }

    protected abstract float getScalingFactorX();

    protected abstract float getScalingFactorY();

    protected abstract float getLineWidth();

    protected int getKbdType() {
        if (this.controller.getTerminal().getKbdService() != null) {
            this.kbdType = this.controller.getTerminal().getKbdService().getCurrentKeyboardType();
        } else {
            IWidgetLogChannel.tpLogChannelInternal.log(100000, "TouchRendererHigh#connect: no KbdService available - use ALL_IN_TOUCH as default keyboard type");
            this.kbdType = 6;
        }
        return this.kbdType;
    }

    public void showFingerTrace(float f2) {
        if (this.line != null) {
            this.line.setVisible(true);
            this.line.setOpacity(f2);
        }
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.lineScalingFactorX = this.getScalingFactorX();
        this.lineScalingFactorY = this.getScalingFactorY();
        this.tpResolution = this.getKbdType() == 15 ? 256.0f : 1024.0f;
        this.showLineBackground = false;
    }

    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender() || AbstractWidget.isVariantStd()) {
            return;
        }
        this.createLineIfNotExisting(redrawContext);
        this.applyProperties();
    }

    public void startLine(int n, int n2) {
        if (this.line != null) {
            this.line.getQuickDrawNode().addSeparator();
            this.line.add((int)((float)n * this.lineScalingFactorX - this.getLinePointOffsetX()), (int)((float)n2 * this.lineScalingFactorY - this.getLinePointOffsetY()));
        }
    }

    protected abstract void applyProperties();

    protected abstract float getLinePointOffsetX();

    protected abstract float getLinePointOffsetY();

    public void addPoint(int n, int n2) {
        if (this.line != null) {
            this.line.add((int)((float)n * this.lineScalingFactorX - this.getLinePointOffsetX()), (int)((float)n2 * this.lineScalingFactorY - this.getLinePointOffsetY()));
        }
    }

    public void clearLine() {
        if (this.line != null) {
            this.line.clearArea();
            this.line.setVisible(false);
        }
    }

    public void removeFingerTrace() {
        this.clearLine();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setKzbIDs(int[] nArray) {
    }

    public boolean isFingerTraceVisible() {
        return this.showLineBackground;
    }

    protected void createLineIfNotExisting(RedrawContext redrawContext) {
        if (null == this.line) {
            this.line = this.createLineQuickDrawNode();
            if (null == this.line) {
                return;
            }
            this.main = this.getFingertraceParentNode(redrawContext);
            if (null == this.lineBackgroundKZB) {
                this.lineBackgroundKZB = this.createBackgroundNode();
                if (null != this.lineBackgroundKZB) {
                    this.main.addByIndex(this.lineBackgroundKZB, 200);
                }
            }
            this.main.addByIndex(this.line, 200);
        }
    }

    protected abstract IWrappedNode3D createBackgroundNode();

    private IWrappedNode3DQuickDraw createLineQuickDrawNode() {
        IWrappedNode3DQuickDraw iWrappedNode3DQuickDraw = this.getEALManager().createQuickDrawNode3D(null, EALManager.createNodeName(NODE_FINGERTRACE_LINE_NAME, this), this.getFingerTraceWidth() * 2, this.getFingerTraceHeight() * 2, 0);
        if (iWrappedNode3DQuickDraw == null) {
            tpLogChannelInternal.log(10000, "AbstractFingerTraceRendererHigh#createLineQuickDrawNode: Could not create Finger trace line -> you need a Nvidia graphic card!!!");
            return null;
        }
        iWrappedNode3DQuickDraw.setLineWidth(this.getLineWidth());
        int n = EALManager.createColorCode(-1);
        iWrappedNode3DQuickDraw.setLineColor(n);
        iWrappedNode3DQuickDraw.setShouldFlipBack(!this.isLTR());
        iWrappedNode3DQuickDraw.setPosition(0.0f, 0.0f, 0.0f);
        iWrappedNode3DQuickDraw.setVisible(false);
        iWrappedNode3DQuickDraw.setScale(0.5f, 0.5f, 1.0f);
        return iWrappedNode3DQuickDraw;
    }

    protected IWrappedNode3D getFingertraceParentNode(RedrawContext redrawContext) {
        IWrappedNode3D iWrappedNode3D = null;
        if (this.controller.getParent() instanceof DirectWritingController) {
            Screen screen = this.controller.getInitContext().getScreen();
            if (screen instanceof ScreenWidgetEVO) {
                ContainerRendererHigh containerRendererHigh = (ContainerRendererHigh)((ScreenWidgetEVO)screen).getMainArea().getScreenAreaWidget().getRenderer();
                iWrappedNode3D = containerRendererHigh.getNode();
            }
        } else if (((RedrawContextHigh)redrawContext).parentNodeSecondary != null) {
            iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNodeSecondary;
        }
        if (iWrappedNode3D == null) {
            iWrappedNode3D = ((RedrawContextHigh)redrawContext).parentNode;
        }
        return iWrappedNode3D;
    }

    public void disconnect() {
        this.propertyCache.clearAll();
        if (this.line != null) {
            this.getEALManager().destroy(this.line);
            this.line = null;
        }
        if (this.lineBackgroundKZB != null) {
            this.getEALManager().destroy(this.lineBackgroundKZB);
            this.lineBackgroundKZB = null;
        }
        super.disconnect();
    }

    public void onviewSizeChanging() {
    }

    public void viewSizeChanged() {
    }

    protected abstract int getFingerTraceWidth();

    protected abstract int getFingerTraceHeight();
}

