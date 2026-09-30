/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.metrics.Speed;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DText;
import de.esolutions.graphics.eal.api.IProperty;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.RedrawContext;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedNode3DImage;
import de.esolutions.hmi.widgets.audi.base.eal.IWrappedTexture;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.evo.high.RedrawContextHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.AbstractRendererHigh;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.PLAPropertySetter;
import de.esolutions.hmi.widgets.audi.evo.widgets.IKanziTemplateRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IOPSRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.OPSController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController;

public class OPSRendererHigh
extends AbstractRendererHigh
implements IKanziTemplateRenderer,
IOPSRenderer {
    private static final String OPS_SPLITSCREEN_FBO = "ops_splitscreen_FBO";
    private static final String OPS_SPLITSCREEN_OFFSCREEN = "ops_splitscreen_offscreen";
    private static final String OPS_LIEGEND_FBO = "ops_liegend_FBO";
    private static final String OPS_LIEGEND_OFFSCREEN = "ops_liegend_offscreen";
    private static final String OPS_PERSPECTIVE_OFFSCREEN = "ops_perspective_offscreen";
    private static final String OPS_PERSPECTIVE_FBO = "ops_perspective_FBO";
    private static final int VPS_VIEW_TOPVIEW = 4;
    private final OPSController controller;
    private static IWrappedNode3DImage opsNode;
    private static IWrappedNode3DImage opsLiegendNode;
    private static IWrappedNode3DImage plaNode;
    private IWrappedNode3DImage current3DNode;
    private PLAPropertySetter plaPropertySetter;
    private boolean horizontalOrientation;
    private static EALManager ealManager;
    private static boolean asyncMergeFinalized;
    private static INode2DText unitsOPS2DText;
    private static INode2DText unitsPLA2DText;
    private static INode2D speedUnitOPSNode2D;
    private static INode2D speedUnitPLANode2D;
    private static Speed speedMetric;
    private static INode2D ops2DNode;
    private static INode2D opsLiegend2DNode;
    private static INode2D pla2DNode;
    private static INode2D propertyHolderNode;
    private static ITexture offscreenTextureOPS;
    private static ITexture offscreenTextureOPSLiegend;
    private static ITexture offscreenTexturePLA;
    private static IProperty[] propertySectorValues;
    private static IProperty[] propertySectorColors;
    private static IProperty propertyRCTALeft;
    private static IProperty propertyRCTARight;
    private static IProperty propertySectorBackgroundsVisible;
    private static IProperty propertyTopviewErrorLeft;
    private static IProperty propertyTopviewErrorLeftCause;
    private static IProperty propertyTopviewErrorRight;
    private static IProperty propertyTopviewErrorRightCause;
    private static IProperty propertyTopviewErrorRear;
    private static IProperty propertyTopviewErrorLeft_liegend;
    private static IProperty propertyTopviewErrorLeftCause_liegend;
    private static IProperty propertyTopviewErrorRight_liegend;
    private static IProperty propertyTopviewErrorRightCause_liegend;
    private static IProperty propertyTopviewErrorRear_liegend;
    private static IProperty propertyParkingHoseDirection;
    private static IProperty propertyParkingHoseFrontWheelRadius;
    private static IProperty propertyParkingHoseRearWheelRadius;
    private static IProperty propertyParkingHoseTrackDisplay;
    private static IProperty propertyParkingHoseWheelBase;
    private static IProperty propertyOPSVisible;
    private static IProperty propertyOPSTrailer;
    private static IProperty propertyRCTAErrorLeft;
    private static IProperty propertyRCTAErrorRight;
    private static IProperty propertyPDCFrontStatus;
    private static IProperty propertyPDCRearStatus;
    private static IProperty propertyBrakeSymbol;
    private static IProperty propertyOPSForwardSymbol;
    private static IProperty propertyOPSReverseSymbol;
    private static IProperty propertyOPSReverseGearSymbol;
    private static IProperty propertyOPSSteeringInterventionSymbol;
    private static boolean propertyErrorOccurred;

    public OPSRendererHigh(OPSController oPSController) {
        this.controller = oPSController;
    }

    public void connect(InitializationContext initializationContext) {
        super.connect(initializationContext);
        if (ealManager == null) {
            ealManager = this.getEALManager();
        }
        ealManager.registerAsKzbListener(12, this.controller);
        this.updateInheritedFonts();
    }

    private IProperty getProperty(INode2D iNode2D, String string) {
        IProperty iProperty = iNode2D.getProperty(string);
        if (!iProperty.isValid()) {
            propertyErrorOccurred = true;
            logChannelParking.log(10000, "OPSRendererHigh#getProperty: could not create property for node '%1', key '%2'", (Object)iNode2D.getName(), (Object)string);
            iProperty.dispose();
            return null;
        }
        return iProperty;
    }

    private boolean findProperties() {
        propertyErrorOccurred = false;
        propertySectorValues = new IProperty[16];
        propertySectorColors = new IProperty[16];
        for (int i2 = 0; i2 < 16; ++i2) {
            OPSRendererHigh.propertySectorValues[i2] = this.getProperty(propertyHolderNode, "ops_seg" + i2);
            OPSRendererHigh.propertySectorColors[i2] = this.getProperty(propertyHolderNode, "ops_segColor" + i2);
        }
        propertyRCTALeft = this.getProperty(propertyHolderNode, "ops_rcta_left");
        propertyRCTARight = this.getProperty(propertyHolderNode, "ops_rcta_right");
        propertyTopviewErrorLeft = this.getProperty(propertyHolderNode, "ops_topViewErrorLeft");
        propertyTopviewErrorLeftCause = this.getProperty(propertyHolderNode, "ops_topViewErrorLeft_cause");
        propertyTopviewErrorRight = this.getProperty(propertyHolderNode, "ops_topViewErrorRight");
        propertyTopviewErrorRightCause = this.getProperty(propertyHolderNode, "ops_topViewErrorRight_cause");
        propertyTopviewErrorRear = this.getProperty(propertyHolderNode, "ops_topViewErrorRear");
        propertySectorBackgroundsVisible = this.getProperty(propertyHolderNode, "ops_segBG");
        propertyParkingHoseDirection = this.getProperty(propertyHolderNode, "dh_Direction");
        propertyParkingHoseFrontWheelRadius = this.getProperty(propertyHolderNode, "dh_RadiusFrontWheel");
        propertyParkingHoseRearWheelRadius = this.getProperty(propertyHolderNode, "dh_RadiusRearWheel");
        propertyParkingHoseTrackDisplay = this.getProperty(propertyHolderNode, "dh_TrackDisplay");
        propertyParkingHoseWheelBase = this.getProperty(propertyHolderNode, "dh_Wheelbase");
        propertyRCTAErrorLeft = this.getProperty(propertyHolderNode, "ops_rcta_error_left");
        propertyRCTAErrorRight = this.getProperty(propertyHolderNode, "ops_rcta_error_right");
        propertyOPSTrailer = this.getProperty(propertyHolderNode, "ops_trailer");
        propertyPDCFrontStatus = this.getProperty(propertyHolderNode, "ops_error_front");
        propertyPDCRearStatus = this.getProperty(propertyHolderNode, "ops_error_back");
        propertyBrakeSymbol = this.getProperty(propertyHolderNode, "ops_instruction_brake");
        propertyOPSForwardSymbol = this.getProperty(propertyHolderNode, "ops_instruction_forward");
        propertyOPSReverseSymbol = this.getProperty(propertyHolderNode, "ops_instruction_reverse");
        propertyOPSReverseGearSymbol = this.getProperty(propertyHolderNode, "ops_instruction_reverseGear");
        propertyOPSSteeringInterventionSymbol = this.getProperty(propertyHolderNode, "ops_indicator");
        propertyTopviewErrorLeft_liegend = this.getProperty(propertyHolderNode, "ops_topViewErrorLeft_liegend");
        propertyTopviewErrorLeftCause_liegend = this.getProperty(propertyHolderNode, "ops_topViewErrorLeft_cause_liegend");
        propertyTopviewErrorRight_liegend = this.getProperty(propertyHolderNode, "ops_topViewErrorRight_liegend");
        propertyTopviewErrorRightCause_liegend = this.getProperty(propertyHolderNode, "ops_topViewErrorRight_cause_liegend");
        propertyTopviewErrorRear_liegend = this.getProperty(propertyHolderNode, "ops_topViewErrorRear_liegend");
        propertyOPSVisible = this.getProperty(propertyHolderNode, "ops_state");
        if (propertyErrorOccurred) {
            logChannelParking.log(10000, "OPSRendererHigh#findProperties: one or more properties could not be found");
            return false;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void loadResources(RedrawContextHigh redrawContextHigh) {
        if (ealManager.isOpsKzbMerged() && !asyncMergeFinalized) {
            this.finalizeAsyncMerge("Layers/ops_root");
        } else if (!ealManager.isOpsKzbMergeStarted()) {
            if (!this.mergeKZB()) return;
            ealManager.setOpsKzbMergeStarted(true);
        } else if (!ealManager.isOpsKzbMerged() && !asyncMergeFinalized) {
            logChannelParking.log(1000000, "OPSRendererHigh#loadResources: async loading is running");
            return;
        }
        IMaterial iMaterial = this.getEALManager().createMaterial("Prefabs/MaterialLibrary", "Materials/PremultipliedAlpha/PremultipliedAlpha", 10, -1);
        if (iMaterial == null) {
            logChannel3DEngine.log(10000, "OPSRendererHigh#loadResources: could not load premultipliedMaterial");
            return;
        }
        this.loadOPSResources(iMaterial);
        this.loadOPSHorizontalResources(iMaterial);
        this.loadPLAResources(iMaterial);
        iMaterial.dispose();
        if (propertyHolderNode != null) return;
        propertyHolderNode = ealManager.getShortcutNode2D("ops_animControls");
        if (propertyHolderNode == null) {
            logChannel3DEngine.log(10000, "OPSRendererHigh#loadResources: could not get propertyHolderNode");
            return;
        }
        if (this.findProperties()) return;
    }

    private boolean mergeKZB() {
        INode2D iNode2D = ealManager.mergeProject(12, -30, this.getInitContext().getScreenID());
        if (iNode2D == null) {
            logChannelParking.log(10000, "OPSRendererHigh#mergeKZB: could not merge OPS-KZB");
            return false;
        }
        iNode2D.dispose();
        ealManager.setOpsKzbMerged(true);
        asyncMergeFinalized = true;
        logChannelParking.log(1000000, "OPSRendererHigh#mergeKZB: synchronous merge finished");
        return true;
    }

    private void loadOPSResources(IMaterial iMaterial) {
        if (opsNode == null) {
            ops2DNode = ealManager.getShortcutNode2D(OPS_SPLITSCREEN_OFFSCREEN);
            offscreenTextureOPS = ealManager.getProject().getTexture(OPS_SPLITSCREEN_FBO);
            IWrappedTexture iWrappedTexture = this.getEALManager().getWrappedTexture(offscreenTextureOPS);
            opsNode = this.getEALManager().createImage3D(null, EALManager.createNodeName("ops3DNode", this), iWrappedTexture, 1, true, (Object)this);
            opsNode.getImageNode().setMaterial(iMaterial);
            ops2DNode.setVisible(true);
            speedUnitOPSNode2D = ealManager.getShortcutNode2D("pla_splitscreen_speedUnit_anchor");
            unitsOPS2DText = new INode2DText(ealManager.getProject(), "pla_splitscreen_speedUnit", 10, this.formatUnitsText());
            unitsOPS2DText.setVisible(true);
            unitsOPS2DText.setColor(EALManager.createColorCode(-16777216));
            unitsOPS2DText.setTranslation(10.0f, 27.0f);
            speedUnitOPSNode2D.add(unitsOPS2DText);
            logChannelParking.log(1000000, "OPSRendererHigh#loadOPSResources: OPS resources loaded");
        }
    }

    private void loadOPSHorizontalResources(IMaterial iMaterial) {
        EALManager eALManager = this.getEALManager();
        if (opsLiegendNode == null && this.horizontalOrientation) {
            opsLiegend2DNode = eALManager.getShortcutNode2D(OPS_LIEGEND_OFFSCREEN);
            offscreenTextureOPSLiegend = eALManager.getProject().getTexture(OPS_LIEGEND_FBO);
            IWrappedTexture iWrappedTexture = this.getEALManager().getWrappedTexture(offscreenTextureOPSLiegend);
            opsLiegendNode = this.getEALManager().createImage3D(null, EALManager.createNodeName("opsLiegend3DNode", this), iWrappedTexture, 1, true, (Object)this);
            opsLiegendNode.getImageNode().setMaterial(iMaterial);
            opsLiegend2DNode.setVisible(true);
            logChannelParking.log(1000000, "OPSRendererHigh#loadOPSHorizontalResources: OPS horizontal resources loaded");
        }
    }

    private void loadPLAResources(IMaterial iMaterial) {
        if (plaNode == null && this.controller.isPLAModeActive()) {
            pla2DNode = ealManager.getShortcutNode2D(OPS_PERSPECTIVE_OFFSCREEN);
            offscreenTexturePLA = ealManager.getProject().getTexture(OPS_PERSPECTIVE_FBO);
            IWrappedTexture iWrappedTexture = this.getEALManager().getWrappedTexture(offscreenTexturePLA);
            plaNode = this.getEALManager().createImage3D(null, EALManager.createNodeName("pla3DNode", this), iWrappedTexture, 0, true, (Object)this);
            plaNode.getImageNode().setMaterial(iMaterial);
            pla2DNode.setVisible(true);
            speedUnitPLANode2D = ealManager.getShortcutNode2D("pla_perspective_speedUnit_anchor");
            unitsPLA2DText = new INode2DText(ealManager.getProject(), "pla_perspective_speedUnit", 10, this.formatUnitsText());
            unitsPLA2DText.setVisible(true);
            unitsPLA2DText.setColor(EALManager.createColorCode(-16777216));
            unitsPLA2DText.setTranslation(10.0f, 27.0f);
            speedUnitPLANode2D.add(unitsPLA2DText);
            logChannelParking.log(1000000, "OPSRendererHigh#loadPLAResources: PLA resources loaded");
        }
    }

    private String formatUnitsText() {
        return Speed.getSystemUnit() == 1 ? speedMetric.getFormattedMetricUnit() : " " + speedMetric.getFormattedMetricUnit();
    }

    public void setVisible(boolean bl) {
        if (this.controller.isPLAModeActive()) {
            if (pla2DNode != null) {
                pla2DNode.setVisible(bl);
            }
        } else {
            if (opsLiegend2DNode != null && this.horizontalOrientation) {
                opsLiegend2DNode.setVisible(bl);
            }
            if (ops2DNode != null && !this.horizontalOrientation) {
                ops2DNode.setVisible(bl);
            }
        }
    }

    private void setProperty(IProperty iProperty, float f2) {
        if (iProperty != null) {
            iProperty.set(f2);
        }
    }

    private int convertTrackDisplay(int n) {
        if (n == 1) {
            return -1;
        }
        if (n == 2) {
            return 1;
        }
        return 0;
    }

    private int convertDirection(int n) {
        if (n == 0) {
            return 0;
        }
        return 1;
    }

    private void applyProperties() {
        float f2;
        if (this.current3DNode == null) {
            return;
        }
        if (this.getEALManager() != null && !this.isLTR()) {
            this.current3DNode.setLanguageOrientation(false);
            f2 = this.horizontalOrientation ? (float)this.current3DNode.getScreenWidth() - this.current3DNode.getWidth() : (float)this.controller.getX();
        } else {
            this.current3DNode.setLanguageOrientation(true);
            f2 = this.controller.getX();
        }
        this.current3DNode.setPosition(f2, this.controller.getY(), 0.0f);
        this.current3DNode.setOpacity(this.controller.getRenderOpacity());
        if (this.controller.isOPSVisible()) {
            this.setProperty(propertyOPSVisible, 1.0f);
            if (this.controller.isTopViewActive()) {
                this.setProperty(propertySectorBackgroundsVisible, 0.0f);
                for (int i2 = 0; i2 < propertySectorValues.length; ++i2) {
                    if (this.controller.getSectorHighlight(i2)) {
                        this.setProperty(propertySectorValues[i2], this.controller.getSectorValue(i2));
                        this.setProperty(propertySectorColors[i2], 1.0f);
                        continue;
                    }
                    this.setProperty(propertySectorValues[i2], 0.0f);
                }
                this.setProperty(propertyTopviewErrorLeft, this.controller.getTopViewErrorLeft() > 0 ? 1.0f : 0.0f);
                this.setProperty(propertyTopviewErrorLeftCause, this.controller.getTopViewErrorLeft() == 1 ? 0.0f : 1.0f);
                this.setProperty(propertyTopviewErrorRight, this.controller.getTopViewErrorRight() > 0 ? 1.0f : 0.0f);
                this.setProperty(propertyTopviewErrorRightCause, this.controller.getTopViewErrorRight() == 1 ? 0.0f : 1.0f);
                this.setProperty(propertyTopviewErrorRear, this.controller.isTopViewErrorRear() ? 1.0f : 0.0f);
                this.setProperty(propertyOPSTrailer, 0.0f);
            } else {
                this.setProperty(propertySectorBackgroundsVisible, 1.0f);
                for (int i3 = 0; i3 < propertySectorValues.length; ++i3) {
                    this.setProperty(propertySectorValues[i3], this.controller.getSectorValue(i3));
                    this.setProperty(propertySectorColors[i3], this.controller.getSectorHighlight(i3) ? 1.0f : 0.0f);
                }
                this.setProperty(propertyTopviewErrorLeft, 0.0f);
                this.setProperty(propertyTopviewErrorRight, 0.0f);
                this.setProperty(propertyTopviewErrorRear, 0.0f);
                this.setProperty(propertyOPSTrailer, this.controller.isTrailerSymbol() ? 1.0f : 0.0f);
            }
            this.setProperty(propertyParkingHoseDirection, this.convertDirection(this.controller.getParkingHoseData().direction));
            this.setProperty(propertyParkingHoseFrontWheelRadius, this.controller.getParkingHoseData().frontWheelRadius);
            this.setProperty(propertyParkingHoseRearWheelRadius, this.controller.getParkingHoseData().rearWheelRadius);
            this.setProperty(propertyParkingHoseTrackDisplay, this.convertTrackDisplay(this.controller.getParkingHoseData().trackDisplay));
            this.setProperty(propertyParkingHoseWheelBase, this.controller.getParkingHoseData().wheelBase / 100);
            logChannelParking.log(1000000, "OPSControllerHigh#applyProperties %1", (Object)this.controller.getParkingHoseData());
        } else {
            this.setProperty(propertyOPSVisible, 0.0f);
            this.setProperty(propertySectorBackgroundsVisible, 0.0f);
            for (int i4 = 0; i4 < propertySectorValues.length; ++i4) {
                this.setProperty(propertySectorValues[i4], -1.0f);
            }
            this.setProperty(propertyTopviewErrorLeft, 0.0f);
            this.setProperty(propertyTopviewErrorRight, 0.0f);
            this.setProperty(propertyTopviewErrorRear, 0.0f);
            this.setProperty(propertyParkingHoseTrackDisplay, 0.0f);
        }
        this.setProperty(propertyRCTALeft, this.controller.getRCTALeftStatus() == 1 ? 1.0f : 0.0f);
        this.setProperty(propertyRCTARight, this.controller.getRCTARightStatus() == 1 ? 1.0f : 0.0f);
        this.setProperty(propertyRCTAErrorLeft, this.controller.getRCTALeftStatus() == 2 ? 1.0f : 0.0f);
        this.setProperty(propertyRCTAErrorRight, this.controller.getRCTARightStatus() == 2 ? 1.0f : 0.0f);
        this.setProperty(propertyPDCFrontStatus, this.controller.ispDCFrontStatus() ? 1.0f : 0.0f);
        this.setProperty(propertyPDCRearStatus, this.controller.ispDCRearStatus() ? 1.0f : 0.0f);
        this.setProperty(propertyBrakeSymbol, this.controller.isBrakeSymbol() ? 1.0f : 0.0f);
        if (this.controller.getpLADrivingDirection() == 0) {
            this.setProperty(propertyOPSForwardSymbol, 0.0f);
            this.setProperty(propertyOPSReverseSymbol, 0.0f);
            this.setProperty(propertyOPSReverseGearSymbol, 0.0f);
        } else if (this.controller.getpLADrivingDirection() == 1) {
            this.setProperty(propertyOPSForwardSymbol, 1.0f);
            this.setProperty(propertyOPSReverseSymbol, 0.0f);
            this.setProperty(propertyOPSReverseGearSymbol, 0.0f);
        } else if (this.controller.getpLADrivingDirection() == 2) {
            this.setProperty(propertyOPSForwardSymbol, 0.0f);
            this.setProperty(propertyOPSReverseSymbol, 1.0f);
            this.setProperty(propertyOPSReverseGearSymbol, 0.0f);
        } else if (this.controller.getpLADrivingDirection() == 3) {
            this.setProperty(propertyOPSForwardSymbol, 0.0f);
            this.setProperty(propertyBrakeSymbol, 0.0f);
            this.setProperty(propertyOPSReverseSymbol, 1.0f);
            this.setProperty(propertyOPSReverseGearSymbol, 1.0f);
        }
        this.setProperty(propertyOPSSteeringInterventionSymbol, this.controller.getSteeringIntervention());
        if (this.horizontalOrientation) {
            this.setProperty(propertyTopviewErrorLeft_liegend, this.controller.getTopViewErrorLeft() > 0 ? 1.0f : 0.0f);
            this.setProperty(propertyTopviewErrorLeftCause_liegend, this.controller.getTopViewErrorLeft() == 1 ? 0.0f : 1.0f);
            this.setProperty(propertyTopviewErrorRight_liegend, this.controller.getTopViewErrorRight() > 0 ? 1.0f : 0.0f);
            this.setProperty(propertyTopviewErrorRightCause_liegend, this.controller.getTopViewErrorRight() == 1 ? 0.0f : 1.0f);
            this.setProperty(propertyTopviewErrorRear_liegend, this.controller.isTopViewErrorRear() ? 1.0f : 0.0f);
        }
        logChannelParking.log(10000000, "OPSRendererHigh#applyProperties VPS_VIEW_TOPVIEW = %1", this.controller.getViewMode() == 4);
        if (this.controller.getViewMode() == 4) {
            this.setProperty(propertyParkingHoseTrackDisplay, 0.0f);
        }
        if (unitsOPS2DText != null) {
            this.getInheritedFont().getFontGroup().activate();
            unitsOPS2DText.setText(10, this.formatUnitsText());
        }
        if (ops2DNode != null) {
            ops2DNode.invalidateObject();
        }
        if (opsLiegend2DNode != null) {
            opsLiegend2DNode.invalidateObject();
        }
        this.applyPLAProperties();
        this.current3DNode.setScale(this.controller.getScaleFactor(), this.controller.getScaleFactor(), 1.0f);
        this.current3DNode.invalidateObject();
        this.current3DNode.setVisible(true);
    }

    private void applyPLAProperties() {
        PLAController pLAController = this.controller.getPLAController();
        if (pLAController == null) {
            return;
        }
        IPLAStatus iPLAStatus = pLAController.getPLAStatus();
        if (iPLAStatus == null) {
            return;
        }
        if (this.plaPropertySetter == null) {
            this.plaPropertySetter = new PLAPropertySetter(pLAController, propertyHolderNode);
        }
        this.plaPropertySetter.applyProperties();
        this.getInheritedFont().getFontGroup().activate();
        unitsPLA2DText.setText(10, this.formatUnitsText());
        pla2DNode.invalidateObject();
    }

    public void render(RedrawContext redrawContext) {
        if (AbstractWidget.isScreenResolution1440()) {
            return;
        }
        if (!this.controller.shouldRender()) {
            if (this.current3DNode != null) {
                this.current3DNode.setVisible(false);
            }
            return;
        }
        RedrawContextHigh redrawContextHigh = (RedrawContextHigh)redrawContext;
        this.loadResources(redrawContextHigh);
        if (this.controller.isPLAModeActive()) {
            if (plaNode == null) {
                logChannelParking.log(100000, "OPSRendererHigh#render: plaNode == null");
                return;
            }
            this.controller.setBounds(0, 0, 100, 100);
            this.current3DNode = plaNode;
            logChannelParking.log(10000000, "OPSRendererHigh#render: current3DNode == plaNode");
        } else if (this.horizontalOrientation) {
            if (opsLiegendNode == null) {
                logChannelParking.log(100000, "OPSRendererHigh#render: opsLiegendNode == null");
                return;
            }
            this.current3DNode = opsLiegendNode;
            logChannelParking.log(10000000, "OPSRendererHigh#render: current3DNode == opsLiegendNode");
        } else {
            if (opsNode == null) {
                logChannelParking.log(100000, "OPSRendererHigh#render: opsNode == null");
                return;
            }
            this.current3DNode = opsNode;
            logChannelParking.log(10000000, "OPSRendererHigh#render: current3DNode == opsNode");
        }
        if (this.current3DNode != null && this.current3DNode.getParent() != null) {
            this.current3DNode.getParent().remove(this.current3DNode);
        }
        redrawContextHigh.parentNode.add(this.current3DNode);
        this.applyProperties();
    }

    public void setKzbIDs(int[] nArray) {
    }

    public AbstractWidgetController getAbstractController() {
        return this.controller;
    }

    private void clearResources() {
        if (this.controller.isPLAModeActive() && this.plaPropertySetter != null) {
            this.plaPropertySetter.clearResources();
        }
    }

    public void disconnect() {
        super.disconnect();
        this.clearResources();
    }

    public void activateHorizontalOrientation(boolean bl) {
        this.horizontalOrientation = bl;
    }

    public void finalizeAsyncMerge(String string) {
        EALManager eALManager = this.getEALManager();
        INode2D iNode2D = eALManager.getShortcutNode2D(string);
        if (iNode2D == null) {
            logChannelParking.log(10000, "OPSRendererHigh#finalizeAsyncMerge: unable to get async merged node \"%1\" from project", (Object)string);
            return;
        }
        eALManager.getMasterRoot().addAuto(iNode2D, -30);
        iNode2D.dispose();
        asyncMergeFinalized = true;
        logChannelParking.log(1000000, "OPSRendererHigh#finalizeAsyncMerge: asynchronous merge finalized");
    }

    static {
        speedMetric = new Speed(0.0f, 1);
    }
}

