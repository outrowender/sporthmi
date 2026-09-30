/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.eal.WrappedNode3D;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.widgets.CarViewerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ICarViewerRenderer;

public class CarViewerRendererHigh
extends AbstractRendererHigh
implements ICarViewerRenderer {
    private final CarViewerController controller;
    private Car3DResourceHandler car3DResourceHandler;
    private static final String NODE_PATH_PITCH = "gyro_pitch_angle";
    private static final String NODE_PATH_ROLL = "gyro_roll_angle";
    private IWrappedNode3D pitchTextParentNode;
    private IWrappedNode3D rollTextParentNode;
    private boolean resourcesLoaded;

    public CarViewerRendererHigh(CarViewerController carViewerController) {
        this.controller = carViewerController;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        this.car3DResourceHandler = this.getEALManager().getCar3DResourceHandler();
        if (this.car3DResourceHandler != null) {
            if (!this.car3DResourceHandler.resourcesLoaded()) {
                EALManager eALManager = this.getEALManager();
                eALManager.registerAsKzbListener(3, this.controller);
            }
            if (this.car3DResourceHandler.getCar3DPEHEVHandler() != null) {
                this.car3DResourceHandler.getCar3DPEHEVHandler().setCarViewerController(this.controller);
            }
            this.car3DResourceHandler.setCarViewerController(this.controller);
        }
    }

    public void disconnect() {
        if (this.car3DResourceHandler != null) {
            boolean bl;
            boolean bl2 = bl = !((CarViewerController)this.car3DResourceHandler.getCarViewerController()).isConnected() && this.car3DResourceHandler.getMode() == 1;
            if (this.car3DResourceHandler.getCar3DPEHEVHandler() != null && bl) {
                this.car3DResourceHandler.getCar3DPEHEVHandler().enablePhevHandler(false);
            }
            if (!((CarViewerController)this.car3DResourceHandler.getCarViewerController()).isConnected()) {
                this.stopAnimations();
            }
        }
        this.getEALManager().unregisterAsKzbListener(this.controller);
        super.disconnect();
    }

    private void applyProperties() {
        if (this.car3DResourceHandler == null || !this.car3DResourceHandler.resourcesLoaded()) {
            return;
        }
        this.car3DResourceHandler.setOpacity(this.controller.getRenderOpacity());
        this.car3DResourceHandler.setDesaturation(this.controller.getDesaturation());
        this.car3DResourceHandler.setTranslation(this.controller.getTransX(), this.controller.getTransY());
        this.car3DResourceHandler.setScale(this.controller.getScale());
    }

    public void render(RedrawContext redrawContext) {
        if (!this.controller.isConnected()) {
            logChannel3DCar.log(10000000, "CarViewerRendererHigh#render do nothing because not connected");
            return;
        }
        if (!this.resourcesLoaded) {
            this.loadResources();
        }
        if (!this.controller.shouldRender()) {
            logChannel3DCar.log(10000000, "CarViewerRendererHigh#render set invisible because should not render");
            this.setVisible(false);
            return;
        }
        this.applyProperties();
    }

    private void loadResources() {
        if (AbstractWidget.isVariantStd()) {
            this.resourcesLoaded = true;
            return;
        }
        if (!this.controller.getTerminalImpl().getCarCodingHelper().hasGyro()) {
            this.resourcesLoaded = true;
            logChannel3DCar.log(10000000, "CarViewerRendererHigh#loadResources derivate has no gyro");
            return;
        }
        INode3D iNode3D = this.getEALManager().getShortcutNode3D(NODE_PATH_PITCH);
        INode3D iNode3D2 = this.getEALManager().getShortcutNode3D(NODE_PATH_ROLL);
        if (iNode3D == null || iNode3D2 == null) {
            this.resourcesLoaded = false;
            logChannel3DCar.log(10000, "CarViewerRendererHigh#loadResources failed to load pitch/roll angle node(s)");
            return;
        }
        this.pitchTextParentNode = new WrappedNode3D(iNode3D, 1.0f, 1.0f, false, 0, this.isLTR());
        this.pitchTextParentNode.ignoreOpacity(true);
        this.rollTextParentNode = new WrappedNode3D(iNode3D2, 1.0f, 1.0f, false, 0, this.isLTR());
        this.rollTextParentNode.ignoreOpacity(true);
        if (this.pitchTextParentNode == null) {
            this.clearResources();
            this.resourcesLoaded = false;
            return;
        }
        if (this.rollTextParentNode == null) {
            this.clearResources();
            this.resourcesLoaded = false;
            return;
        }
        this.resourcesLoaded = true;
    }

    private void clearResources() {
        this.disposeNode(this.pitchTextParentNode);
        this.pitchTextParentNode = null;
        this.disposeNode(this.rollTextParentNode);
        this.rollTextParentNode = null;
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

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    public void setVisible(boolean bl) {
        if (this.car3DResourceHandler != null && this.car3DResourceHandler.isVisible() != bl) {
            logChannel3DCar.log(10000000, "CarViewerController#setVisible: visibility of carViewer changed to: %1", bl);
            if (this.car3DResourceHandler.getMode() == 1) {
                this.car3DResourceHandler.startGridTranslationAnimation();
            }
        }
        this.car3DResourceHandler.setVisible(bl);
    }

    public void setCarMenuIndex(int n) {
        if (this.car3DResourceHandler != null && this.controller.isConnected()) {
            this.car3DResourceHandler.setActiveCarMenuOverlay(n);
        }
    }

    public void setMode(int n) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setMode(n);
        }
    }

    public void setDriveSelectValues(int n, float f2, float f3, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setDriveSelectValues(n, f2, f3, n2, n3, n4, n5, n6, n7, bl, bl2, bl3);
        }
    }

    public void setDriveSelectDDBOpen(boolean bl) {
        if (this.car3DResourceHandler != null) {
            // empty if block
        }
    }

    public void setAmbientLightValues(float[] fArray, float[] fArray2, float[] fArray3) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setAmbientLightValues(fArray, fArray2, fArray3);
        }
    }

    public void setAmbientLightPackage(int n) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setAmbientLightPackage(n);
        }
    }

    public void setUGDOMode(int n) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setUGDOMode(n);
        }
    }

    public void setViewSizeTargetChanged(int n, boolean bl) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setViewSizeTargetChanged(n, bl);
        }
    }

    public void setViewSizeAnimationFinished(int n) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setViewSizeAnimationFinished(n);
        }
    }

    public void setSmallStagePositionPercentage(float f2) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setSmallStagePositionPercentage(f2);
        }
    }

    public void stopAnimations() {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.stopAnimations();
        }
    }

    public void prepareRedrawContextForChildren(RedrawContext redrawContext, AbstractWidget abstractWidget) {
        super.prepareRedrawContextForChildren(redrawContext, abstractWidget);
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        if (abstractWidget == this.controller.getChildOfRole(2) || abstractWidget == this.controller.getChildOfRole(3)) {
            redrawContextHigh.parentNode = this.pitchTextParentNode;
        }
        if (abstractWidget == this.controller.getChildOfRole(0) || abstractWidget == this.controller.getChildOfRole(1)) {
            redrawContextHigh.parentNode = this.rollTextParentNode;
        }
    }

    public void setDriveSelectPHEVValues(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setDriveSelectPHEVValues(n, n2, n3, n4, n5, n6, n7);
        }
    }

    public void updateSmallStageTranslationOffset(float f2) {
        if (this.car3DResourceHandler != null) {
            this.car3DResourceHandler.setSmallStageTranslationOffset(f2);
        }
    }
}

