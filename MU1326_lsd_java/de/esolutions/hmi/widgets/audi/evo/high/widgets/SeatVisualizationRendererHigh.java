/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedFont;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MassageProgramNodeManager;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.ISeatRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.SeatVisualizationController;

public class SeatVisualizationRendererHigh
extends AbstractRendererHigh
implements IKanziTemplateRenderer,
ISeatRenderer {
    private static final float ICON_OPACITY_DISABLED = 0.0f;
    private static final float ICON_OPACITY_ENABLED = 1.0f;
    private static final float ICON_OPACITY_ACTIVATED = 2.0f;
    private static final float ICON_OPACITY_HIGHLIGHTED = 3.0f;
    private static final String[] PROPERTY_HOLDER_NODE_NAMES = new String[]{"seat_left", "seat_right"};
    private static final String[] TEXTURE_NAMES = new String[]{"seats_left_FBO", "seats_right_FBO"};
    private static final int PROPERTY_SEAT_FUNCTION_ID = 6;
    private static final int PROPERTY_MASSAGE_PROGRAM = 7;
    private static final int PROPERTY_MASSAGE_DIGIT = 8;
    private static final int PROPERTY_MASSAGE_SETTING_ACTIVE = 9;
    private static final int PROPERTY_ARROW_UP_STATUS = 10;
    private static final int PROPERTY_ARROW_DOWN_STATUS = 11;
    private static final int PROPERTY_ARROW_FORWARD_STATUS = 12;
    private static final int PROPERTY_ARROW_BACKWARD_STATUS = 13;
    private static final String[] PROPERTY_NAMES = new String[]{"seat_function_Massage_status", "seat_function_Gurthoehe_status", "seat_function_Lehnenkopf_status", "seat_function_Lordose_status", "seat_function_Seitenwangen_status", "seat_function_Sitztiefe_status", "seat_function_ID", "seat_massage_ID", "seat_massage_cursor_digit", "seat_massage_cursor_settings_active", "seat_rotator_up_status", "seat_rotator_down_status", "seat_rotator_forward_status", "seat_rotator_backward_status"};
    private final SeatVisualizationController controller;
    private IWrappedTexture wrappedTexture;
    private IWrappedNode3DImage imageNode;
    private INode2D propertyHolderNode;
    private boolean resourcesLoaded;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    private static boolean projectMerged = false;
    private boolean nodeAdded;

    public SeatVisualizationRendererHigh(SeatVisualizationController seatVisualizationController) {
        this.controller = seatVisualizationController;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
    }

    protected void applyProperties() {
        float f2 = this.controller.getX();
        float f3 = this.controller.getY();
        this.imageNode.setPosition(f2, f3, 0.0f);
        this.imageNode.setOpacity(this.controller.getOpacity());
        this.imageNode.setVisible(true);
        this.propertyHolderNode.setVisible(true);
        this.updateFunctionIconsAndCursorOpacity();
        this.updateMassageProgramOpacity();
        this.updateArrowOpacity(this.controller.getArrowUpState(), 10);
        this.updateArrowOpacity(this.controller.getArrowDownState(), 11);
        this.updateArrowOpacity(this.controller.getArrowForwardState(), 12);
        this.updateArrowOpacity(this.controller.getArrowBackwardState(), 13);
        this.imageNode.invalidateObject();
    }

    private void updateFunctionIconsAndCursorOpacity() {
        int n;
        int n2 = this.controller.getSelectedSeatFunction();
        for (n = 0; n < 6; ++n) {
            float f2 = 0.0f;
            if (this.controller.isSeatFunctionAvailable(n)) {
                f2 = n2 == n ? 3.0f : 2.0f;
            }
            this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[n], f2);
        }
        n = this.controller.getSeatFunctionSlot(n2, true);
        this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[6], (float)n);
    }

    private void updateMassageProgramOpacity() {
        int n = this.controller.getSelectedMassageProgram();
        int n2 = this.controller.getMassageProgramSlot(n, true);
        this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[7], (float)n2);
        boolean bl = n == 0;
        this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[9], bl ? 0.0f : 1.0f);
        if (!bl) {
            this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[8], (float)this.controller.getMassageIntensity());
        }
    }

    private void updateArrowOpacity(int n, int n2) {
        float f2 = 0.0f;
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                f2 = 1.0f;
                break;
            }
            case 2: {
                f2 = 2.0f;
                break;
            }
            default: {
                logChannel.log(100000, "SeatVisualizationRendererHigh#updateArrowOpacity state %1 is not supported; using the default opacity: %2", (Object)String.valueOf(n), (Object)String.valueOf(f2));
            }
        }
        this.propertyCache.setProperty((INode)this.propertyHolderNode, PROPERTY_NAMES[n2], f2);
    }

    private INode2D getNode2D(String string) {
        logChannel.log(10000000, "SeatVisualizationRendererHigh#getNode2D: getting node '%1'", (Object)string);
        INode2D iNode2D = this.getEALManager().getProject().getNode2D(string);
        if (!iNode2D.isValid()) {
            logChannel.log(10000, "SeatVisualizationRendererHigh#getNode2D: Could not get node '%1'", (Object)string);
            iNode2D.dispose();
            return null;
        }
        return iNode2D;
    }

    private IWrappedFont getFont() {
        if (this.fonts != null) {
            return this.fonts[0];
        }
        return this.getInheritedFont();
    }

    private void setupTexts() {
        MassageProgramNodeManager massageProgramNodeManager = MassageProgramNodeManager.getInstance(this.getEALManager());
        if (massageProgramNodeManager != null) {
            IWrappedFont iWrappedFont = this.getFont();
            if (iWrappedFont == null) {
                logChannel.log(10000, "SeatVisualizationRendererHigh#setupTexts font= &1; MassageProgramTexts not set!", (Object)iWrappedFont);
                return;
            }
            for (int i2 = 0; i2 < 7; ++i2) {
                int n = this.controller.getMassageProgramSlot(i2, false);
                if (n == -1) continue;
                massageProgramNodeManager.updateNode(this.controller.getSide(), n, this.controller.getMassageText(i2), iWrappedFont);
            }
        }
    }

    private void loadResources() {
        EALManager eALManager = this.getEALManager();
        if (eALManager == null) {
            logChannel.log(10000, "SeatVisualizationRendererHigh#loadResources unable to retrieve the EAL manager; can't load any resources");
            return;
        }
        if (this.mergeProject(eALManager)) {
            this.propertyHolderNode = this.getNode2D(PROPERTY_HOLDER_NODE_NAMES[this.controller.getSide()]);
            if (this.propertyHolderNode == null) {
                return;
            }
            this.propertyHolderNode.setVisible(false);
            ITexture iTexture = eALManager.getProject().getTexture(TEXTURE_NAMES[this.controller.getSide()]);
            if (!iTexture.isValid()) {
                logChannel.log(10000, "SeatVisualizationRendererHigh#loadResources: testure %1 not found in kzb", (Object)TEXTURE_NAMES[this.controller.getSide()]);
                return;
            }
            this.wrappedTexture = this.getEALManager().getWrappedTexture(iTexture);
            this.imageNode = this.getEALManager().createImage3D(null, EALManager.createNodeName("seatPopin", this), this.wrappedTexture, 0, true, (Object)this);
            if (this.controller.getSide() == 1) {
                this.imageNode.mirrorX();
            }
            iTexture.dispose();
            this.resourcesLoaded = true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean mergeProject(EALManager eALManager) {
        if (projectMerged) return projectMerged;
        try {
            int n = 15;
            if (!eALManager.isProjectMerged(n)) {
                INode2D iNode2D = eALManager.mergeProject(15, -60, this.getInitContext().getScreenID());
                if (iNode2D == null) {
                    logChannel.log(10000, "SeatVisualizationRendererHigh#mergeProject unable to load KZB %1; it may have already been merged", (long)n);
                    return false;
                }
                iNode2D.dispose();
            } else {
                logChannel.log(100000, "SeatVisualizationRendererHigh#mergeProject KZB %1 seems to have been loaded already; no need to load it anymore", (long)n);
            }
            logChannel.log(10000000, "SeatVisualizationRendererHigh#mergeProject the seat KZB has been merged successfully");
            projectMerged = true;
            return projectMerged;
        }
        catch (Throwable throwable) {
            logChannel.log(10000, "SeatVisualizationRendererHigh#mergeProject failed to load the seat KZB", throwable);
        }
        return projectMerged;
    }

    public void render(RedrawContext redrawContext) {
        if (!this.controller.shouldRender()) {
            if (this.imageNode != null) {
                this.imageNode.setVisible(false);
            }
            return;
        }
        if (!this.resourcesLoaded) {
            this.loadResources();
            if (!this.resourcesLoaded) {
                return;
            }
        }
        this.setupTexts();
        if (!this.nodeAdded) {
            RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
            if (redrawContextHigh.parentNode != null) {
                redrawContextHigh.parentNode.add(this.imageNode);
            }
            this.nodeAdded = true;
        }
        if (this.imageNode == null) {
            return;
        }
        this.applyProperties();
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setKzbIDs(int[] nArray) {
    }

    public void setVisible(boolean bl) {
        if (this.resourcesLoaded) {
            this.imageNode.setVisible(bl);
            this.propertyHolderNode.setVisible(bl);
        }
    }

    public void disconnect() {
        super.disconnect();
        this.nodeAdded = false;
        this.resourcesLoaded = false;
        this.propertyCache.clearAll();
        this.disposeNode(this.propertyHolderNode);
        this.disposeNode(this.imageNode);
        this.wrappedTexture = null;
        this.propertyHolderNode = null;
        this.imageNode = null;
    }

    private void disposeNode(IWrappedNode3D iWrappedNode3D) {
        if (iWrappedNode3D == null) {
            return;
        }
        iWrappedNode3D.dispose();
        this.disposeNode(iWrappedNode3D.getNode());
    }

    private void disposeNode(INode iNode) {
        if (iNode == null) {
            return;
        }
        iNode.dispose();
    }
}

