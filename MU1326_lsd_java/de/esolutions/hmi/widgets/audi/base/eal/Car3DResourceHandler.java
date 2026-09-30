/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ScreenShotEvent;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.graphics.eal.api.IAnimation;
import de.esolutions.graphics.eal.api.IAnimationClip;
import de.esolutions.graphics.eal.api.IMaterial;
import de.esolutions.graphics.eal.api.INode;
import de.esolutions.graphics.eal.api.INode2D;
import de.esolutions.graphics.eal.api.INode2DImage;
import de.esolutions.graphics.eal.api.INode3D;
import de.esolutions.graphics.eal.api.ITexture;
import de.esolutions.graphics.eal.colorRGBAf;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.HMITerminalImpl;
import de.esolutions.hmi.widgets.audi.base.I3DCarListener;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.eal.Car3DPHEVHandler;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import java.util.ArrayList;
import java.util.List;

public class Car3DResourceHandler
implements AnimationListener {
    private static final int NONE = -1;
    private static boolean DEBUG_OUTPUT = false;
    private static final boolean ANIMATED = true;
    private static final int MAX_ANIMATION_TIME = Integer.valueOf(System.getProperty("3DCarMaxAnimationTime", "700"));
    private static final int MIN_ANIMATION_TIME = Integer.valueOf(System.getProperty("3DCarMinAnimationTime", "100"));
    private static final int SCREEN_CHANGE_ANIMATION_TIME = 250;
    private static final boolean OVERWRITE_FXAA = System.getProperty("3DCarFXAA") != null;
    private static final boolean OVERWRITE_FXAA_VALUE = Boolean.getBoolean("3DCarFXAA");
    private static final boolean OVERWRITE_SUPERSAMPLING = System.getProperty("3DCarSuperSamplingRate") != null;
    private static final float OVERWRITE_SUPERSAMPLING_RATE = Float.valueOf(System.getProperty("3DCarSuperSamplingRate", "0.0")).floatValue();
    private static final float SUPERSAMPLING_RATE_ANIMATED = OVERWRITE_SUPERSAMPLING ? OVERWRITE_SUPERSAMPLING_RATE : 1.5f;
    private static final float SUPERSAMPLING_RATE_STILL = OVERWRITE_SUPERSAMPLING ? OVERWRITE_SUPERSAMPLING_RATE : 2.0f;
    private static final boolean FXAA_STILL = OVERWRITE_FXAA ? OVERWRITE_FXAA_VALUE : true;
    private static final boolean FXAA_ANIMATED = OVERWRITE_FXAA ? OVERWRITE_FXAA_VALUE : false;
    private static final float STATE_OFF = 0.0f;
    private static final float STATE_NO_UPDATE = 1.0f;
    private static final float STATE_ACTIVE = 2.0f;
    private static final int PASSIVE_INDEX = 42;
    private static final int SMALL_STAGE_INDEX = 43;
    private static final int SERVICE_INTERVAL_INDEX = 20;
    private static final int UGDO_INDEX = 46;
    private static final int OIL_LEVEL_INDEX = 14;
    private static final String DEFAULT_PROPERTY_NAME = "0_Default_Position";
    private static final String SMALL_STAGE_PROPERTY_NAME = "KB_Position";
    private static final String[] WIDGET_ID_MAPPING_LHD = new String[]{"ACC", "Ambientebeleuchtung", "AmbientlightWizard", "Ambientebeleuchtung", "AmbientlightWizard", "AmbientlightWizard", "Aussenbeleuchtung", "Belegung_Lenkradtaste", "Einparkhilfe", "Fahrerassistenz", "Fahrzeugeinstellungen", "Fahrzeuginfo", "Klima", "Lane_Assist", "Oelstand", "Pausenempfehlung", "Audi_Pre_Sense", "Regensensor", "Reifendruckkontrolle", "Service_Kontrolle", "Serviceintervalle", "Audi_Sideassist", "Sitze", "Tempowarnung", "Umluftautomatik", "Verkehrszeichen", "Wischerwechsel", "Zentralverriegelung", "Zuheizer", "0_Default_Position", "Luftfeder_Anhaenger", "Nachtsichtassistenz", "HUD", "AdBlue", "Abstandwarner", "Anhaengermodus", "Fussraumtemperatur", "Stauassistenz", "Verbrauchstatistik", "Garagentoroeffner", "Luftfeder_Radwechsel", "PEA", "0_Default_Position", "KB_Position", "Sitzheizung", "Sitzlueftung", "Garagentor_Anlernen_Scheinwerfer_Links", "Garagentor_Anlernen_Audiringe", "Garagentor_Anlernen_Scheinwerfer_Rechts", "Garagentor_Anlernen_Innenspiegel", "Feedback_Fahrpedal", "Datum_Uhrzeit", "Fahrschulmodus"};
    private static final String CAR_MENU_TRANSFORMATION_LAYER_NAME = "carMenue_transformation_layer";
    private static final String CAR_TRANSFORMATION_LAYER_NAME = "car_transformation_layer";
    private static final String CAR_MENU_FBO_LAYER_NAME = "carMenu_imageLayer";
    private static final String CAR_MENU_FBO_TEXTURE_NAME = "carMenu_complete_FBO";
    private static final String CAR_MENU_3D_SCALE_TRANSFORMATION_SHORTCUT = "carMenue_scale_offset";
    private static final String DRIVE_SELECT_TRANSFORMATION_LAYER_NAME = "driveSelect_transformation_layer";
    private static final String DRIVE_SELECT_FBO_LAYER_NAME = "driveSelect_imageLayer";
    private static final String DRIVE_SELECT_FBO_TEXTURE_NAME = "driveSelect_complete_FBO";
    private static final String DRIVE_SELECT_PHEV_STATE = "phev_state";
    private static final String DRIVE_SELECT_MODE_RACE = "driveSelect_mode_race";
    private static final String DRIVE_SELECT_MODE_DYNAMIC = "driveSelect_mode_dynamic";
    private static final String DRIVE_SELECT_MODE_EFFICIENCY = "driveSelect_mode_efficiency";
    private static final String DRIVE_SELECT_MODE_COMFORT = "driveSelect_mode_comfort";
    private static final String DRIVE_SELECT_GYRO_ROLL_WARNING_RANGE = "gyro_roll_warningRange";
    private static final String DRIVE_SELECT_GYRO_ROLL_HARD_WARNING = "gyro_roll_hardWarning";
    private static final String DRIVE_SELECT_GYRO_ROLL_SOFT_WARNING = "gyro_roll_softWarning";
    private static final String DRIVE_SELECT_GYRO_ROLL = "gyro_roll";
    private static final String DRIVE_SELECT_GYRO_PITCH_WARNING_RANGE = "gyro_pitch_warningRange";
    private static final String DRIVE_SELECT_GYRO_PITCH_HARD_WARNING = "gyro_pitch_hardWarning";
    private static final String DRIVE_SELECT_GYRO_PITCH_SOFT_WARNING = "gyro_pitch_softWarning";
    private static final String DRIVE_SELECT_GYRO_PITCH = "gyro_pitch";
    private static final String GARAGENTOR_ANLERNEN_INNENSPIEGEL_RHD = "Garagentor_Anlernen_Innenspiegel_RHD";
    private static final String HUD_RHD = "HUD_RHD";
    private static final String BELEGUNG_LENKRADTASTE_ROADSTER = "Belegung_Lenkradtaste_Roadster";
    private static final String BELEGUNG_LENKRADTASTE_RHD = "Belegung_Lenkradtaste_RHD";
    private static final String ROTATION_Z = "ROTATION_Z";
    private static final String ROTATION_Y = "ROTATION_Y";
    private static final String ROTATION_X = "ROTATION_X";
    private static final String ATTENUATION = "Attenuation";
    private static final String TRANSLATION_Z = "TRANSLATION_Z";
    private static final String TRANSLATION_Y = "TRANSLATION_Y";
    private static final String TRANSLATION_X = "TRANSLATION_X";
    private static final String DRIVE_SELECT_MENUE_SHIFT = "driveSelect_menue_shift";
    private static final String DRIVE_SELECT_GYRO_STATE = "gyro_state";
    private static final String DRIVE_SELECT_STATE = "driveSelect_state";
    private static final String AMBIENT_LIGHT_STATE = "AmbientLight_state";
    private static final String AMBIENT_LIGHT_FLOOR_COLOR = "AmbientLight_floor_color";
    private static final String AMBIENT_LIGHT_DOORS_COLOR = "AmbientLight_doors_color";
    private static final String AMBIENT_LIGHT_DASH_COLOR = "AmbientLight_dash_color";
    private static final String AMBIENT_LIGHT_BORDER_COLOR = "AmbientLight_border_color";
    private static final String AMBIENT_LIGHT_BORDER_ITAFEL_COLOR = "ContourLight_i_tafel";
    private static final String AMBIENT_LIGHT_BORDER_DOOR_COLOR = "ContourLight_doors";
    private static final String AMBIENT_LIGHT_BORDER_MIKO_COLOR = "ContourLight_miko";
    private static final String CAR_MENUE_SUPER_SAMPLING_RATE = "car_superSamplingRate";
    private static final String CAR_MENUE_RHD = "carMenue_RHD";
    private static final String CAR_MENUE_STATE = "carMenue_state";
    private static final String DESATURATE = "desaturate";
    private static final String LAYER_MATERIAL = "LayerMaterial";
    private static final String CAR_MENU_PROPERTY_NODE = "carMenue_Controls";
    private static final String DRIVE_SELECT_PROPERTY_NODE = "driveSelect_Controls";
    private static final String CAR_MENU_3D_TRANSFORMATION_NODE_NAME = "CarmenueObjects";
    private static final String CAR_MENU_FXAA_LAYER_NAME = "carMenue_FBO_PostFX";
    private static final String DRIVE_SELECT_FXAA_LAYER_NAME = "driveSelect_FBO_PostFX";
    private static final String AMBIENT_LIGHT_LAYER_NAME = "AmbientLight";
    private static final String FXAA_OFF_MATERIAL_NAME = "car_noPostFXMaterial";
    private static final String FXAA_ON_MATERIAL_NAME = "car_PostFXMaterial";
    private static final float OVERLAY_OFF_VALUE = 0.0f;
    private static final float OVERLAY_ON_VALUE = 1.0f;
    private static final float OVERLAY_ON_VALUE_SERVICE_INTERVAL = 2.0f;
    private static final int ROOT_TRANSLATION_OFFSET_X_KOMBI = 1000;
    private static final int ROOT_TRANSLATION_OFFSET_X = 800;
    private static final String CAR_MENU_POINTLIGHT_0_NODE_NAME = "carMenue_PointLight0";
    private static final String CAR_MENU_POINTLIGHT_1_NODE_NAME = "carMenue_PointLight1";
    private static final String CAR_MENU_REFLECTION_ADJUSTMENT_NODE_NAME = "ReflectionAdjustmentNode";
    private static final String CAR_MENU_WINDOW_REFLECTION_ADJUSTMENT_NODE_NAME = "WindowReflectionAdjustmentNode";
    private static final String CAR_MENU_POINTLIGHT_0_ANIMATION_NAME = "Point Light0";
    private static final String CAR_MENU_POINTLIGHT_1_ANIMATION_NAME = "Point Light1";
    private static final String CAR_MENU_SCALE_ENHENCED_TRANSLATION = "scale_offset";
    private static final String CAR_MENU_lightConstant_ATTENUATION_NAME = "PointLightAttenuation";
    private static String[] widgetIDMapping;
    private static INode3D[] stateNodes;
    private static String[] stateKeys;
    private static INode3D[] carMenuOverlayNodes;
    private static String[] carMenuOverlayKeys;
    private static INode2D[] desaturateNodes;
    private static String[] desaturateKeys;
    private static TranslationRotation[] carMenuTransformations;
    private static TranslationRotation interpolatedTransRot;
    private static TranslationRotation carMenuStartTransformation;
    private static TranslationRotation carMenuEndTransformation;
    private static INode3D carMenu3DTransformationNode;
    private static INode3D carMenuePointLight0;
    private static INode3D carMenuePointLight1;
    private static INode3D reflectionAdjustmentNode;
    private static INode3D windowReflectionAdjustmentNode;
    private static INode2D scaleOffsetTranslationNode;
    private static INode2D ambientLightNode;
    private AbstractAnimation screenShotAnimation;
    private int currentScreenshotProgress = 0;
    private String screenshotPath;
    private static INode3D[] superSamplingRateNodes;
    private static String[] superSamplingRateKeys;
    private static IMaterial materialFXAAOff;
    private static IMaterial materialFXAAOn;
    private static INode2D[] materialNodes;
    private static String[] materialKeys;
    private static INode2D carMenuTransformationLayer;
    private static INode2D skinTranslationNode;
    private static INode2D driveSelectTransformationLayer;
    private static boolean driveSelectAvailable;
    private static ITexture finalCarMenuFBOTexture;
    private static ITexture driveSelectFBOTexture;
    private boolean isMMIKombi;
    private boolean offscreenRenderingEnabled;
    private int currentAnimationDuration;
    private int lastMode;
    private int currentMode = this.lastMode = 0;
    private int currentCarMenuIndex = 42;
    private int lastCarMenuIndex = 42;
    private static boolean firstTime;
    private boolean driveSelectDDBOpen = false;
    private HMITerminalImpl terminal;
    private EALManager ealManager;
    private LogChannel logChannel3DCar = IWidgetLogChannel.logChannel3DCar;
    private static final int ANIMATION_TYPE_ENDLESS = 1;
    private static final int ANIMATION_TYPE_CARMENU = 97;
    private static final int ANIMATION_TYPE_DRIVESELECT_SHIFT = 100;
    private static final int ANIMATION_TYPE_DRIVESELECT_GYRO = 101;
    private static final int ANIMATION_TYPE_DRIVESELECT_GRID = 108;
    private AbstractAnimation carMenuAnimation;
    private AbstractAnimation driveSelectShiftAnimation;
    private AbstractAnimation driveSelectGyroAnimation;
    private AbstractAnimation driveSelectGridAnimation;
    private long asyncLoadStartTime;
    AbstractWidget carViewerController;
    Car3DPHEVHandler carPHEVHandler;
    private boolean visible;
    private float gyroPitch;
    private float gyroRoll;
    private int gyroPitchSoftWarningStartAngle;
    private int gyroPitchHardWarningStartAngle;
    private int gyroPitchHardWarningEndAngle;
    private int gyroRollSoftWarningStartAngle;
    private int gyroRollHardWarningStartAngle;
    private int gyroRollHardWarningEndAngle;
    private boolean gyroVisible;
    private boolean pitchAngleVisible;
    private boolean rollAngleVisible;
    private int selectedDriveSelectProfile;
    private float[] ambientLightColor;
    private float[] contourLightColor;
    private float[] colorBrightness;
    private int ambientPackage;
    public static final int QQ1 = 1;
    public static final int QQ2 = 2;
    private float opacity = 1.0f;
    private float desaturation = 0.0f;
    private float scale = 1.0f;
    private float driveSelectScaleFactor = 1.0f;
    private float transX = 0.0f;
    private float transY = 0.0f;
    private float smallStageTransXDS = 0.0f;
    private float smallStageTransYDS = 0.0f;
    private float smallStageTransXCarMenu = 0.0f;
    private float smallStageTransYCarMenu = 0.0f;
    private float skinTransX = 0.0f;
    private float skinTransY = 0.0f;
    private float skinOpacity = 1.0f;
    private float gridPosition = 0.0f;
    private static int gridGyroPosition;
    private static int gridDefaultPosition;
    INode2DImage backgroundNode;
    INode3D driveSelectPropertyHolderNode;
    protected final EALPropertyCache propertyCache = new EALPropertyCache();
    private float smallStageTransCenterX = -220.0f;
    private int bigStageCarMenuIndex;
    private float lastViewStageValue = 0.0f;
    private float currentViewStageValue = 0.0f;
    private int targetViewStage = 0;
    private final List refractionGlassPlates = new ArrayList();
    private static boolean resourcesLoaded;

    public Car3DResourceHandler(HMITerminalImpl hMITerminalImpl, EALManager eALManager) {
        this.terminal = hMITerminalImpl;
        this.ealManager = eALManager;
        this.isMMIKombi = AbstractWidget.isScreenResolution1440();
    }

    public void setCarViewerController(AbstractWidget abstractWidget) {
        this.carViewerController = abstractWidget;
        if (this.getCarMenuAnimation().isAnimating()) {
            this.getCarMenuAnimation().setRepaintTarget(abstractWidget);
        }
        if (this.getDriveSelectGyroAnimation().isAnimating()) {
            this.getDriveSelectGyroAnimation().setRepaintTarget(abstractWidget);
        }
        if (this.getDriveSelectGridAnimation().isAnimating()) {
            this.getDriveSelectGridAnimation().setRepaintTarget(abstractWidget);
        }
        if (this.getDriveSelectShiftAnimation().isAnimating()) {
            this.getDriveSelectShiftAnimation().setRepaintTarget(abstractWidget);
        }
    }

    private IAnimationClip getAnimationClip(String string) {
        Buffer buffer = new Buffer();
        buffer.append(string).append("_").append(this.terminal.getCarCodingHelper().getKanziCarID());
        if (this.ealManager.getProject().isAnimationClip(buffer.toString())) {
            string = buffer.toString();
        }
        if (this.ealManager.getProject().isAnimationClip(string)) {
            IAnimationClip iAnimationClip = this.ealManager.getProject().getAnimationClip(string);
            if (!iAnimationClip.isValid()) {
                this.logChannel3DCar.log(10000, "Car3DResourceHandler#getAnimationClip: Could not get clip '%1'", (Object)string);
                iAnimationClip.dispose();
                return null;
            }
            return iAnimationClip;
        }
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#getAnimationClip: Could not get clip '%1'", (Object)string);
        return null;
    }

    private INode2D getNode2D(String string) {
        INode2D iNode2D = this.ealManager.getProject().getNode2D(string);
        if (!iNode2D.isValid()) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#getNode2D: Could not get node '%1'", (Object)string);
            iNode2D.dispose();
            return null;
        }
        return iNode2D;
    }

    private INode3D getNode3D(String string) {
        INode3D iNode3D = this.ealManager.getProject().getNode3D(string);
        if (!iNode3D.isValid()) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#getNode3D: Could not get node '%1'", (Object)string);
            iNode3D.dispose();
            return null;
        }
        return iNode3D;
    }

    private IMaterial getMaterial(String string) {
        IMaterial iMaterial = this.ealManager.getProject().getMaterial(string);
        if (!iMaterial.isValid()) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#getMaterial: Could not get material '%1'", (Object)string);
            iMaterial.dispose();
            return null;
        }
        return iMaterial;
    }

    private ITexture getEALTexture(String string) {
        ITexture iTexture = this.ealManager.getProject().getTexture(string);
        if (!iTexture.isValid()) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#getEALTexture: Could not get texture '%1'", (Object)string);
            iTexture.dispose();
            return null;
        }
        return iTexture;
    }

    public void setFXAAEnabled(int n, boolean bl) {
        if (this.resourcesLoaded()) {
            if (this.blockFXAAForPHEV()) {
                this.propertyCache.setProperty((INode)materialNodes[n], materialKeys[n], materialFXAAOff);
            } else {
                this.propertyCache.setProperty((INode)materialNodes[n], materialKeys[n], bl ? materialFXAAOn : materialFXAAOff);
            }
        }
    }

    private boolean blockFXAAForPHEV() {
        return this.carPHEVHandler != null && this.carPHEVHandler.isAnimating();
    }

    private void setSuperSamplingRate(int n, float f2) {
        this.propertyCache.setProperty((INode)superSamplingRateNodes[n], superSamplingRateKeys[n], f2);
    }

    public void invalidatePartialRendering() {
        this.setOffscreenRenderingEnabled(true);
        if (desaturateNodes[0] != null) {
            desaturateNodes[0].invalidateObject();
        }
        if (driveSelectAvailable) {
            desaturateNodes[1].invalidateObject();
        }
        this.notifyRefractionGlassplates();
    }

    private void getNodesAndProperties() {
        Object object;
        int n;
        INode2D iNode2D;
        Layout layout = this.terminal.getLayout();
        gridGyroPosition = layout.getIntegerConstant(112);
        gridDefaultPosition = layout.getIntegerConstant(111);
        this.gridPosition = gridDefaultPosition;
        this.backgroundNode = ((HMITerminalEAL)((Object)this.terminal)).getEALManager().getBackgroundImageNode();
        if (this.backgroundNode != null && this.backgroundNode.getWidth() <= 1024L) {
            this.backgroundNode = null;
        }
        if (widgetIDMapping == null) {
            widgetIDMapping = WIDGET_ID_MAPPING_LHD;
        }
        INode2D iNode2D2 = this.getNode2D(CAR_MENU_FBO_LAYER_NAME);
        carMenuTransformationLayer = this.getNode2D(CAR_MENU_TRANSFORMATION_LAYER_NAME);
        skinTranslationNode = this.getNode2D(CAR_TRANSFORMATION_LAYER_NAME);
        materialFXAAOff = this.getMaterial(FXAA_OFF_MATERIAL_NAME);
        materialFXAAOn = this.getMaterial(FXAA_ON_MATERIAL_NAME);
        materialNodes = new INode2D[5];
        materialKeys = new String[5];
        Car3DResourceHandler.materialNodes[0] = iNode2D = this.getNode2D(CAR_MENU_FXAA_LAYER_NAME);
        Car3DResourceHandler.materialKeys[0] = LAYER_MATERIAL;
        desaturateNodes = new INode2D[5];
        desaturateKeys = new String[5];
        Car3DResourceHandler.desaturateNodes[0] = iNode2D2;
        Car3DResourceHandler.desaturateKeys[0] = DESATURATE;
        INode3D iNode3D = this.getNode3D(CAR_MENU_PROPERTY_NODE);
        carMenuePointLight0 = this.getNode3D(CAR_MENU_POINTLIGHT_0_NODE_NAME);
        carMenuePointLight1 = this.getNode3D(CAR_MENU_POINTLIGHT_1_NODE_NAME);
        reflectionAdjustmentNode = this.getNode3D(CAR_MENU_REFLECTION_ADJUSTMENT_NODE_NAME);
        windowReflectionAdjustmentNode = this.getNode3D(CAR_MENU_WINDOW_REFLECTION_ADJUSTMENT_NODE_NAME);
        if (AbstractWidget.isScreenResolution800()) {
            scaleOffsetTranslationNode = this.getNode2D(CAR_MENU_3D_SCALE_TRANSFORMATION_SHORTCUT);
        }
        if (iNode3D == null) {
            return;
        }
        stateNodes = new INode3D[5];
        stateKeys = new String[5];
        Car3DResourceHandler.stateNodes[0] = iNode3D;
        Car3DResourceHandler.stateKeys[0] = CAR_MENUE_STATE;
        this.propertyCache.setProperty((INode)stateNodes[0], stateKeys[0], 0.0f);
        this.propertyCache.setProperty((INode)iNode3D, CAR_MENUE_RHD, AbstractWidget.isRightHandDrive() ? 1.0f : 0.0f);
        int n2 = widgetIDMapping.length;
        carMenuOverlayNodes = new INode3D[n2];
        carMenuOverlayKeys = new String[n2];
        for (n = n2 - 1; n >= 0; --n) {
            Car3DResourceHandler.carMenuOverlayNodes[n] = iNode3D;
            Car3DResourceHandler.carMenuOverlayKeys[n] = widgetIDMapping[n];
            if (carMenuOverlayNodes[n] == null) {
                Car3DResourceHandler.carMenuOverlayNodes[n] = iNode3D;
                Car3DResourceHandler.carMenuOverlayKeys[n] = DEFAULT_PROPERTY_NAME;
            }
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[n], carMenuOverlayKeys[n], 0.0f);
        }
        superSamplingRateNodes = new INode3D[5];
        superSamplingRateKeys = new String[5];
        Car3DResourceHandler.superSamplingRateNodes[0] = iNode3D;
        Car3DResourceHandler.superSamplingRateKeys[0] = CAR_MENUE_SUPER_SAMPLING_RATE;
        carMenu3DTransformationNode = this.getNode3D(CAR_MENU_3D_TRANSFORMATION_NODE_NAME);
        carMenuTransformations = new TranslationRotation[n2];
        for (n = n2 - 1; n >= 0; --n) {
            Car3DResourceHandler.carMenuTransformations[n] = new TranslationRotation();
            object = new float[1];
            IAnimationClip iAnimationClip = null;
            String string = this.mapDivergendIDMapping(n);
            iAnimationClip = string != null ? this.getAnimationClip("Animation Clips/" + string) : this.getAnimationClip("Animation Clips/" + widgetIDMapping[n]);
            if (iAnimationClip == null) continue;
            int n3 = (int)iAnimationClip.getSize();
            for (int i2 = 0; i2 < n3; ++i2) {
                IAnimation iAnimation = iAnimationClip.getAnimation(i2);
                iAnimation.getValue(0L, (float[])object);
                String string2 = iAnimation.getName();
                if (string2.indexOf(CAR_MENU_3D_TRANSFORMATION_NODE_NAME) >= 0) {
                    this.setCarTranslationRotation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf(CAR_MENU_WINDOW_REFLECTION_ADJUSTMENT_NODE_NAME) >= 0) {
                    this.setWindowReflectionTranslation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf(CAR_MENU_REFLECTION_ADJUSTMENT_NODE_NAME) >= 0) {
                    this.setReflectionAdjustment(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf(CAR_MENU_POINTLIGHT_0_ANIMATION_NAME) >= 0) {
                    this.setPointLight0Translation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf(CAR_MENU_POINTLIGHT_1_ANIMATION_NAME) >= 0) {
                    this.setPointLight1Translation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf(CAR_MENU_SCALE_ENHENCED_TRANSLATION) >= 0) {
                    this.setEnhancedTranslation(carMenuTransformations[n], string2, object[0]);
                }
                iAnimation.dispose();
            }
            iAnimationClip.dispose();
            while (Car3DResourceHandler.carMenuTransformations[n].rotY < 0.0f) {
                Car3DResourceHandler.carMenuTransformations[n].rotY += 360.0f;
            }
            while (Car3DResourceHandler.carMenuTransformations[n].rotY > 360.0f) {
                Car3DResourceHandler.carMenuTransformations[n].rotY -= 360.0f;
            }
            if (!DEBUG_OUTPUT) continue;
            System.out.println(widgetIDMapping[n]);
            System.out.println(carMenuTransformations[n]);
            System.out.println("");
        }
        finalCarMenuFBOTexture = this.getEALTexture(CAR_MENU_FBO_TEXTURE_NAME);
        ambientLightNode = this.getNode2D(AMBIENT_LIGHT_LAYER_NAME);
        INode2D iNode2D3 = this.getNode2D(DRIVE_SELECT_FBO_LAYER_NAME);
        boolean bl = driveSelectAvailable = iNode2D3 != null;
        if (driveSelectAvailable) {
            driveSelectTransformationLayer = this.getNode2D(DRIVE_SELECT_TRANSFORMATION_LAYER_NAME);
            this.driveSelectPropertyHolderNode = this.getNode3D(DRIVE_SELECT_PROPERTY_NODE);
            if (this.driveSelectPropertyHolderNode != null) {
                Car3DResourceHandler.stateNodes[1] = this.driveSelectPropertyHolderNode;
                Car3DResourceHandler.stateKeys[1] = DRIVE_SELECT_STATE;
                this.propertyCache.setProperty((INode)stateNodes[1], stateKeys[1], 0.0f);
                Car3DResourceHandler.desaturateNodes[1] = iNode2D3;
                Car3DResourceHandler.desaturateKeys[1] = DESATURATE;
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, CAR_MENUE_RHD, AbstractWidget.isRightHandDrive() ? 1.0f : 0.0f);
                object = this.getNode2D(DRIVE_SELECT_FXAA_LAYER_NAME);
                Car3DResourceHandler.materialNodes[1] = object;
                Car3DResourceHandler.materialKeys[1] = LAYER_MATERIAL;
                Car3DResourceHandler.superSamplingRateNodes[1] = this.driveSelectPropertyHolderNode;
                Car3DResourceHandler.superSamplingRateKeys[1] = CAR_MENUE_SUPER_SAMPLING_RATE;
                driveSelectFBOTexture = this.getEALTexture(DRIVE_SELECT_FBO_TEXTURE_NAME);
            } else {
                this.logChannel3DCar.log(10000, "Car3DResourceHandler#getNodesAndProperties driveSelectPropertyHolderNode is null.");
            }
        }
        this.propertyCache.setProperty((INode)stateNodes[this.currentMode], stateKeys[this.currentMode], 2.0f);
        this.setSuperSamplingRate(0, SUPERSAMPLING_RATE_STILL);
        this.setFXAAEnabled(0, FXAA_STILL);
        this.setSuperSamplingRate(1, SUPERSAMPLING_RATE_STILL);
        this.setFXAAEnabled(1, FXAA_STILL);
        this.setDriveSelectGyroProperties(this.gyroVisible);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_STATE, this.gyroVisible ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MENUE_SHIFT, this.driveSelectDDBOpen ? 1.0f : 0.0f);
        interpolatedTransRot = new TranslationRotation();
    }

    private void setPointLight0Translation(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.pointLight0TransX = f2;
        } else if (string.indexOf(TRANSLATION_Y) >= 0) {
            translationRotation.pointLight0TransY = f2;
        } else if (string.indexOf(TRANSLATION_Z) >= 0) {
            translationRotation.pointLight0TransZ = f2;
        } else if (string.indexOf(ATTENUATION) >= 0) {
            translationRotation.attenuationPointLight0 = f2;
        }
    }

    private void setPointLight1Translation(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.pointLight1TransX = f2;
        } else if (string.indexOf(TRANSLATION_Y) >= 0) {
            translationRotation.pointLight1TransY = f2;
        } else if (string.indexOf(TRANSLATION_Z) >= 0) {
            translationRotation.pointLight1TransZ = f2;
        } else if (string.indexOf(ATTENUATION) >= 0) {
            translationRotation.attenuationPointLight1 = f2;
        }
    }

    private void setEnhancedTranslation(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.enhancedTranslationX = f2;
        }
    }

    private void setReflectionAdjustment(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.reflectionAdjustmentTransX = f2;
        } else if (string.indexOf(TRANSLATION_Y) >= 0) {
            translationRotation.reflectionAdjustmentTransY = f2;
        } else if (string.indexOf(TRANSLATION_Z) >= 0) {
            translationRotation.reflectionAdjustmentTransZ = f2;
        }
    }

    private void setWindowReflectionTranslation(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.windowReflectionAdjustmentTransX = f2;
        } else if (string.indexOf(TRANSLATION_Y) >= 0) {
            translationRotation.windowReflectionAdjustmentTransY = f2;
        } else if (string.indexOf(TRANSLATION_Z) >= 0) {
            translationRotation.windowReflectionAdjustmentTransZ = f2;
        }
    }

    private void setCarTranslationRotation(TranslationRotation translationRotation, String string, float f2) {
        if (string.indexOf(ROTATION_X) >= 0) {
            translationRotation.rotX = f2;
        } else if (string.indexOf(ROTATION_Y) >= 0) {
            translationRotation.rotY = f2;
        } else if (string.indexOf(ROTATION_Z) >= 0) {
            translationRotation.rotZ = f2;
        } else if (string.indexOf(TRANSLATION_X) >= 0) {
            translationRotation.transX = f2;
        } else if (string.indexOf(TRANSLATION_Y) >= 0) {
            translationRotation.transY = f2;
        } else if (string.indexOf(TRANSLATION_Z) >= 0) {
            translationRotation.transZ = f2;
        }
    }

    private String mapDivergendIDMapping(int n) {
        ICarCodingHelper iCarCodingHelper = this.terminal.getCarCodingHelper();
        int n2 = iCarCodingHelper.getCarType();
        boolean bl = AbstractWidget.isRightHandDrive();
        String string = null;
        switch (n) {
            case 7: {
                if (bl) {
                    return BELEGUNG_LENKRADTASTE_RHD;
                }
                if (n2 != 21) break;
                return BELEGUNG_LENKRADTASTE_ROADSTER;
            }
            case 32: {
                if (!bl) break;
                return HUD_RHD;
            }
            case 49: {
                if (!iCarCodingHelper.isB9() || !bl) break;
                return GARAGENTOR_ANLERNEN_INNENSPIEGEL_RHD;
            }
        }
        return string;
    }

    private void setGyroVisible(boolean bl) {
        AbstractAnimation abstractAnimation;
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setGyroVisible %1", bl);
        if (this.gyroVisible == bl) {
            return;
        }
        if (!this.resourcesLoaded()) {
            return;
        }
        this.gyroVisible = bl;
        if (this.currentMode == 1) {
            this.enablePHEVEnergyFlow(!bl);
        }
        if ((abstractAnimation = this.getDriveSelectGyroAnimation()).isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        this.setSuperSamplingRate(1, SUPERSAMPLING_RATE_ANIMATED);
        this.setFXAAEnabled(1, FXAA_ANIMATED);
        abstractAnimation.startDynamicAnimation(0.0f, 100.0f, 101, false, this.carViewerController);
    }

    public boolean isGyroVisible() {
        return this.gyroVisible;
    }

    public void startGridTranslationAnimation() {
        if (!this.resourcesLoaded()) {
            return;
        }
        AbstractAnimation abstractAnimation = this.getDriveSelectGridAnimation();
        if (!abstractAnimation.isAnimating()) {
            abstractAnimation.startDynamicAnimation(0.0f, 100.0f, 108, false, this.carViewerController);
        }
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#startGridTranslationAnimation: Animation is started");
    }

    private void setDriveSelectGyroProperties(boolean bl) {
        if (this.gyroVisible != bl) {
            this.startGridTranslationAnimation();
        }
        this.setGyroVisible(bl);
        if (!this.resourcesLoaded()) {
            return;
        }
        if (bl && this.terminal.getCarCodingHelper().hasGyro()) {
            if (this.pitchAngleVisible) {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH, this.gyroPitch);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_SOFT_WARNING, (float)this.gyroPitchSoftWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_HARD_WARNING, (float)this.gyroPitchHardWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_WARNING_RANGE, (float)this.gyroPitchHardWarningEndAngle);
            } else {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_SOFT_WARNING, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_HARD_WARNING, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_PITCH_WARNING_RANGE, 0.0f);
            }
            if (this.rollAngleVisible) {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL, this.gyroRoll);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_SOFT_WARNING, (float)this.gyroRollSoftWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_HARD_WARNING, (float)this.gyroRollHardWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_WARNING_RANGE, (float)this.gyroRollHardWarningEndAngle);
            } else {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_SOFT_WARNING, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_HARD_WARNING, 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_ROLL_WARNING_RANGE, 0.0f);
            }
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MODE_COMFORT, this.selectedDriveSelectProfile == 3 ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MODE_EFFICIENCY, this.selectedDriveSelectProfile == 2 ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MODE_DYNAMIC, this.selectedDriveSelectProfile == 5 ? 1.0f : 0.0f);
        if (this.terminal.getCarCodingHelper().isR8orTT()) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MODE_RACE, this.selectedDriveSelectProfile == 8 ? 1.0f : 0.0f);
        }
        this.invalidatePartialRendering();
    }

    public void loadResources(int n) {
        long l = this.terminal.getFramework().getMonotonicTime();
        INode2D iNode2D = this.ealManager.mergeProject(n, 110, -1);
        if (iNode2D == null) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#loadResources: unable to load KZB");
            return;
        }
        iNode2D.dispose();
        long l2 = this.terminal.getFramework().getMonotonicTime();
        this.getNodesAndProperties();
        this.setNodesVisible(this.visible);
        resourcesLoaded = true;
        long l3 = this.terminal.getFramework().getMonotonicTime();
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#loadResources: time for 3D car loading: %1ms (thereof %2ms scene parsing for nodes and properties)", l3 - l, l3 - l2);
    }

    public void loadResourcesAsync(int n, int n2, String string) {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#loadResources: start loading %1 resources async", (Object)string);
        this.asyncLoadStartTime = this.terminal.getFramework().getMonotonicTime();
        this.ealManager.mergeProjectAsync(n, n2, -1);
    }

    public void asyncMergeFinished(String string) {
        INode2D iNode2D = this.ealManager.getProject().getNode2D(string);
        if (iNode2D == null) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#asyncMergeFinished: unable to get async merged node \"%1\" from project", (Object)string);
            return;
        }
        this.ealManager.getMasterRoot().addAuto(iNode2D, 110);
        iNode2D.dispose();
        long l = this.terminal.getFramework().getMonotonicTime();
        this.getNodesAndProperties();
        if (this.carPHEVHandler != null) {
            this.carPHEVHandler.loadResources();
        }
        this.setNodesVisible(this.visible);
        resourcesLoaded = true;
        long l2 = this.terminal.getFramework().getMonotonicTime();
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#asyncMergeFinished: time for 3D car loading: %1ms (thereof %2ms scene parsing forr nodes and properties)", l2 - this.asyncLoadStartTime, l2 - l);
    }

    private void setOffscreenRenderingEnabled(boolean bl) {
        if (this.offscreenRenderingEnabled == bl) {
            return;
        }
        if (stateNodes == null) {
            return;
        }
        this.offscreenRenderingEnabled = bl;
        if (this.isVisible()) {
            float f2 = bl ? 2.0f : 1.0f;
            this.propertyCache.setProperty((INode)stateNodes[this.currentMode], stateKeys[this.currentMode], f2);
        }
    }

    private void setNodesVisible(boolean bl) {
        if (stateNodes == null) {
            return;
        }
        float f2 = bl ? 2.0f : 0.0f;
        this.propertyCache.setProperty((INode)stateNodes[this.currentMode], stateKeys[this.currentMode], f2);
        if (bl) {
            this.invalidatePartialRendering();
        }
    }

    public void setVisible(boolean bl) {
        if (this.visible == bl) {
            return;
        }
        this.visible = bl;
        if (this.resourcesLoaded()) {
            AbstractAnimation abstractAnimation;
            this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setVisible %1", bl);
            this.setNodesVisible(bl);
            AbstractAnimation abstractAnimation2 = this.getCarMenuAnimation();
            if (!bl && abstractAnimation2.isAnimating()) {
                abstractAnimation2.finishAnimationSynchronously();
                abstractAnimation2.stopAnimation();
            }
            AbstractAnimation abstractAnimation3 = this.getDriveSelectShiftAnimation();
            if (!bl && abstractAnimation3.isAnimating()) {
                abstractAnimation3.finishAnimationSynchronously();
                abstractAnimation3.stopAnimation();
            }
            AbstractAnimation abstractAnimation4 = this.getDriveSelectGyroAnimation();
            if (!bl && abstractAnimation4.isAnimating()) {
                abstractAnimation4.finishAnimationSynchronously();
                abstractAnimation4.stopAnimation();
            }
            if ((abstractAnimation = this.getDriveSelectGridAnimation()).isAnimating()) {
                abstractAnimation.finishAnimationSynchronously();
                abstractAnimation.stopAnimation();
            }
            if (bl) {
                this.updateKanziOpacity();
                this.applyScaling();
                this.applyTranslation();
            }
        }
    }

    public boolean isVisible() {
        return this.resourcesLoaded() && this.visible;
    }

    public boolean resourcesLoaded() {
        return resourcesLoaded;
    }

    private void applyTransformationRotation(TranslationRotation translationRotation) {
        this.applyCarMenuTransformations(translationRotation);
        this.applyCarMenuLightTransformations(translationRotation);
        this.applyCarMenuEnhancedTransformation(translationRotation);
    }

    private void applyCarMenuTransformations(TranslationRotation translationRotation) {
        carMenu3DTransformationNode.setTranslation(translationRotation.transX, translationRotation.transY, translationRotation.transZ);
        carMenu3DTransformationNode.setRotationXYZ(translationRotation.rotX, translationRotation.rotY, translationRotation.rotZ);
    }

    private void applyCarMenuLightTransformations(TranslationRotation translationRotation) {
        if (carMenuePointLight0 != null) {
            this.propertyCache.setProperty(carMenuePointLight0, CAR_MENU_lightConstant_ATTENUATION_NAME, translationRotation.attenuationPointLight0, 0.0f, 0.0f);
            carMenuePointLight0.setTranslation(translationRotation.pointLight0TransX, translationRotation.pointLight0TransY, translationRotation.pointLight0TransZ);
        }
        if (carMenuePointLight1 != null) {
            this.propertyCache.setProperty(carMenuePointLight1, CAR_MENU_lightConstant_ATTENUATION_NAME, translationRotation.attenuationPointLight1, 0.0f, 0.0f);
            carMenuePointLight1.setTranslation(translationRotation.pointLight1TransX, translationRotation.pointLight1TransY, translationRotation.pointLight1TransZ);
        }
        if (reflectionAdjustmentNode != null) {
            reflectionAdjustmentNode.setTranslation(translationRotation.reflectionAdjustmentTransX, translationRotation.reflectionAdjustmentTransY, translationRotation.reflectionAdjustmentTransZ);
        }
        if (windowReflectionAdjustmentNode != null) {
            windowReflectionAdjustmentNode.setTranslation(translationRotation.windowReflectionAdjustmentTransX, translationRotation.windowReflectionAdjustmentTransY, translationRotation.windowReflectionAdjustmentTransZ);
        }
    }

    private void applyCarMenuEnhancedTransformation(TranslationRotation translationRotation) {
        if (scaleOffsetTranslationNode != null) {
            scaleOffsetTranslationNode.setTranslation(translationRotation.enhancedTranslationX, 0.0f);
        }
    }

    private void prepareCarMenuTransformAnim(TranslationRotation translationRotation, TranslationRotation translationRotation2) {
        if (carMenuStartTransformation == null) {
            carMenuStartTransformation = new TranslationRotation();
        }
        if (carMenuEndTransformation == null) {
            carMenuEndTransformation = new TranslationRotation();
        }
        carMenuStartTransformation.copyValuesFrom(translationRotation);
        carMenuEndTransformation.copyValuesFrom(translationRotation2);
        if (Car3DResourceHandler.carMenuEndTransformation.rotY > Car3DResourceHandler.carMenuStartTransformation.rotY) {
            if (Car3DResourceHandler.carMenuEndTransformation.rotY - Car3DResourceHandler.carMenuStartTransformation.rotY > 180.0f) {
                Car3DResourceHandler.carMenuStartTransformation.rotY += 360.0f;
            }
        } else if (Car3DResourceHandler.carMenuStartTransformation.rotY - Car3DResourceHandler.carMenuEndTransformation.rotY > 180.0f) {
            Car3DResourceHandler.carMenuEndTransformation.rotY += 360.0f;
        }
        float f2 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.rotY - Car3DResourceHandler.carMenuEndTransformation.rotY);
        float f3 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.rotZ - Car3DResourceHandler.carMenuEndTransformation.rotZ);
        float f4 = (f2 + f3) / 2.0f;
        float f5 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transX - Car3DResourceHandler.carMenuEndTransformation.transX);
        float f6 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transY - Car3DResourceHandler.carMenuEndTransformation.transY);
        float f7 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transZ - Car3DResourceHandler.carMenuEndTransformation.transZ);
        float f8 = (f5 + f6 + f7) / 3.0f;
        float f9 = f4 / 180.0f;
        float f10 = f8 / 9.0f;
        float f11 = Math.max(f9, f10);
        f11 = Math.min(f11, 1.0f);
        this.currentAnimationDuration = (f11 = Math.max(f11, 0.0f)) == 0.0f ? 0 : (int)((float)MIN_ANIMATION_TIME + (float)(MAX_ANIMATION_TIME - MIN_ANIMATION_TIME) * f11);
        if (this.terminal.getIAnimationController().isScreenChangeAnimationRunning()) {
            this.currentAnimationDuration = 250;
        }
    }

    public void setCurrentCarMenuOverlayUnanimated() {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setCurrentCarMenuOverlayUnanimated: currentCarMenuIndex is %1", (long)this.currentCarMenuIndex);
        if (this.currentCarMenuIndex == 43) {
            this.bigStageCarMenuIndex = this.lastCarMenuIndex;
        }
        this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
        this.applyTransformationRotation(carMenuTransformations[this.currentCarMenuIndex]);
        this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], this.currentCarMenuIndex == 20 ? 2.0f : 1.0f);
        if (this.isMMIKombi) {
            this.smallStageTransXCarMenu = this.currentCarMenuIndex == 43 ? this.smallStageTransCenterX : 0.0f;
            this.applyTranslation();
        }
        this.invalidatePartialRendering();
        this.setOpacity(this.opacity);
    }

    public void setActiveCarMenuOverlay(int n) {
        if (n == -1) {
            n = 42;
        }
        if (widgetIDMapping == null) {
            widgetIDMapping = WIDGET_ID_MAPPING_LHD;
        }
        if (n < 0 || n >= widgetIDMapping.length) {
            this.logChannel3DCar.log(10000, "Car3DResourceHandler#setActiveCarMenuOverlay: choice index %1 is out of range", (long)n);
            return;
        }
        if (this.targetViewStage == 1) {
            this.bigStageCarMenuIndex = n;
            return;
        }
        if (n == this.currentCarMenuIndex && !firstTime) {
            return;
        }
        firstTime = false;
        this.lastCarMenuIndex = this.currentCarMenuIndex;
        this.currentCarMenuIndex = n;
        if (this.logChannel3DCar.isDebug()) {
            this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setActiveCarMenuOverlay: setting menuitem id %1", (long)n);
            if (carMenuOverlayNodes != null && carMenuOverlayNodes[n] != null) {
                this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setActiveCarMenuOverlay: setting overlay name \"%1\"", (Object)carMenuOverlayNodes[n].getProperty(carMenuOverlayKeys[n]).getName());
            } else {
                this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setActiveCarMenuOverlay: carMenuOverlayNodes[%1] is null", (long)n);
            }
        }
        if (!this.resourcesLoaded()) {
            return;
        }
        AbstractAnimation abstractAnimation = this.getCarMenuAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], 0.0f);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[20], carMenuOverlayKeys[20], 0.0f);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[14], carMenuOverlayKeys[14], 0.0f);
            this.prepareCarMenuTransformAnim(interpolatedTransRot, carMenuTransformations[this.currentCarMenuIndex]);
        } else {
            this.prepareCarMenuTransformAnim(carMenuTransformations[this.lastCarMenuIndex], carMenuTransformations[this.currentCarMenuIndex]);
        }
        if (this.currentAnimationDuration == 0) {
            this.setCurrentCarMenuOverlayUnanimated();
        } else {
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[20], carMenuOverlayKeys[20], 0.0f);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[14], carMenuOverlayKeys[14], 0.0f);
            this.setSuperSamplingRate(0, SUPERSAMPLING_RATE_ANIMATED);
            this.setFXAAEnabled(0, FXAA_ANIMATED);
            abstractAnimation.setPlannedDuration(this.currentAnimationDuration);
            abstractAnimation.startDynamicAnimation(0.0f, 100.0f, 97, false, this.carViewerController);
        }
    }

    private void setAmbientLightProperties() {
        if (this.terminal.getCarCodingHelper().isQ2()) {
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DOORS_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_FLOOR_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_STATE, 1.0f);
        } else if (this.terminal.getCarCodingHelper().isR8()) {
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DOORS_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_FLOOR_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_COLOR, new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DASH_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_STATE, this.colorBrightness[0]);
        } else if (this.terminal.getCarCodingHelper().isQ7()) {
            if (this.ambientPackage == 1) {
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_MIKO_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DASH_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DOORS_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_DOOR_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_FLOOR_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_ITAFEL_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[3]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_STATE, 1.0f);
            } else if (this.ambientPackage == 2) {
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DOORS_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DASH_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_FLOOR_COLOR, new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_MIKO_COLOR, new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_DOOR_COLOR, new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_ITAFEL_COLOR, new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_STATE, 1.0f);
            }
        } else {
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DOORS_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_FLOOR_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_BORDER_COLOR, new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_DASH_COLOR, new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, AMBIENT_LIGHT_STATE, 1.0f);
        }
    }

    public void setAmbientLightValues(float[] fArray, float[] fArray2, float[] fArray3) {
        this.ambientLightColor = fArray;
        this.contourLightColor = fArray2;
        this.colorBrightness = fArray3;
        if (!this.resourcesLoaded()) {
            return;
        }
        this.setAmbientLightProperties();
        this.invalidatePartialRendering();
    }

    public void setAmbientLightPackage(int n) {
        this.ambientPackage = n;
    }

    public void setDriveSelectValues(int n, float f2, float f3, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl, boolean bl2, boolean bl3) {
        this.gyroPitch = f2;
        this.gyroRoll = f3;
        this.gyroPitchSoftWarningStartAngle = n2;
        this.gyroPitchHardWarningStartAngle = n3;
        this.gyroPitchHardWarningEndAngle = n4;
        this.gyroRollSoftWarningStartAngle = n5;
        this.gyroRollHardWarningStartAngle = n6;
        this.gyroRollHardWarningEndAngle = n7;
        this.pitchAngleVisible = bl2;
        this.rollAngleVisible = bl3;
        this.selectedDriveSelectProfile = n;
        this.setDriveSelectGyroProperties(bl);
    }

    public void setDriveSelectPHEVValues(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        if (this.carPHEVHandler != null) {
            this.carPHEVHandler.updatePHEVProperties(n, n2, n3, n4, n5, n6, n7);
        }
    }

    public void setDriveSelectDDBOpen(boolean bl) {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setDriveSelectDDBOpen %1", bl);
        if (this.driveSelectDDBOpen == bl) {
            return;
        }
        this.driveSelectDDBOpen = bl;
        if (!this.resourcesLoaded()) {
            return;
        }
        AbstractAnimation abstractAnimation = this.getDriveSelectShiftAnimation();
        if (abstractAnimation.isAnimating()) {
            abstractAnimation.stopAnimation();
        }
        this.setSuperSamplingRate(1, SUPERSAMPLING_RATE_ANIMATED);
        this.setFXAAEnabled(1, FXAA_ANIMATED);
        abstractAnimation.startDynamicAnimation(0.0f, 100.0f, 100, false, this.carViewerController);
    }

    public void setUGDOMode(int n) {
        this.setActiveCarMenuOverlay(46 + n);
    }

    public void setMode(int n) {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setMode %1", (long)n);
        if (this.currentMode == n) {
            return;
        }
        this.currentMode = n;
        if (this.resourcesLoaded()) {
            this.propertyCache.setProperty((INode)stateNodes[this.lastMode], stateKeys[this.lastMode], 0.0f);
            float f2 = this.isVisible() ? 2.0f : 0.0f;
            this.propertyCache.setProperty((INode)stateNodes[this.currentMode], stateKeys[this.currentMode], f2);
            if (this.currentMode == 1) {
                this.enablePHEVEnergyFlow(true);
            }
            if (this.currentMode == 0) {
                this.enablePHEVEnergyFlow(false);
                if (this.targetViewStage == 1) {
                    this.lastCarMenuIndex = this.currentCarMenuIndex;
                    this.currentCarMenuIndex = 43;
                    this.setCurrentCarMenuOverlayUnanimated();
                }
            } else {
                this.setDriveSelectSmallStagePercentage(this.targetViewStage == 1 ? 1.0f : 0.0f);
            }
        }
        this.lastMode = this.currentMode;
    }

    public int getMode() {
        return this.currentMode;
    }

    public ITexture getTexture() {
        if (this.currentMode == 0) {
            return finalCarMenuFBOTexture;
        }
        return driveSelectFBOTexture;
    }

    public void setDesaturation(float f2) {
        if (f2 == this.desaturation) {
            return;
        }
        this.desaturation = f2;
        this.updateKanziOpacity();
        if (this.isVisible()) {
            for (int i2 = 0; i2 < 5; ++i2) {
                if (desaturateNodes[i2] == null) continue;
                this.propertyCache.setProperty((INode)desaturateNodes[i2], desaturateKeys[i2], f2);
            }
        }
    }

    private void updateKanziOpacity() {
        if (this.isVisible()) {
            float f2 = this.opacity * this.skinOpacity;
            desaturateNodes[0].setOpacity(f2);
            if (driveSelectAvailable) {
                if (this.isMMIKombi) {
                    if (this.desaturation != 1.0f) {
                        desaturateNodes[1].setOpacity(this.opacity);
                    }
                } else {
                    desaturateNodes[1].setOpacity(this.opacity);
                }
            }
        }
    }

    public void setOpacity(float f2) {
        if (f2 == this.opacity) {
            return;
        }
        this.opacity = f2;
        this.updateKanziOpacity();
    }

    public float getOpacity() {
        return this.opacity;
    }

    public void setSkinOpacity(float f2) {
        if (f2 == this.skinOpacity) {
            return;
        }
        this.skinOpacity = f2;
        this.updateKanziOpacity();
    }

    private void notifyRefractionGlassplates() {
        int n = this.refractionGlassPlates.size();
        for (int i2 = 0; i2 < n; ++i2) {
            ((I3DCarListener)this.refractionGlassPlates.get(i2)).contentChanged();
        }
    }

    private void applyTranslation() {
        if (this.isVisible()) {
            if (skinTranslationNode != null && skinTranslationNode.isValid()) {
                skinTranslationNode.setTranslation(this.skinTransX, this.skinTransY);
            }
            carMenuTransformationLayer.setTranslation(this.transX + this.smallStageTransXCarMenu, this.transY + this.smallStageTransYCarMenu);
            if (driveSelectAvailable) {
                driveSelectTransformationLayer.setTranslation(this.transX + this.smallStageTransXDS, this.transY + this.smallStageTransYDS);
            }
            this.notifyRefractionGlassplates();
        }
    }

    public void setTranslation(float f2, float f3) {
        if (this.transX == f2 && this.transY == f3) {
            return;
        }
        this.transX = f2;
        this.transY = f3;
        this.applyTranslation();
    }

    public void setSkinTranslation(float f2, float f3) {
        if (this.skinTransX == f2 && this.skinTransY == f3) {
            return;
        }
        this.skinTransX = f2;
        this.skinTransY = f3;
        this.applyTranslation();
    }

    private void applyScaling() {
        if (this.isVisible()) {
            carMenuTransformationLayer.setScale(this.scale, this.scale);
            if (driveSelectAvailable) {
                driveSelectTransformationLayer.setScale(this.scale * this.driveSelectScaleFactor, this.scale * this.driveSelectScaleFactor);
            }
            this.notifyRefractionGlassplates();
        }
    }

    public void setScale(float f2) {
        if (this.scale == f2) {
            return;
        }
        this.scale = f2;
        this.applyScaling();
    }

    private AbstractAnimation getCarMenuAnimation() {
        if (this.carMenuAnimation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.carMenuAnimation = (AbstractAnimation)abstractAnimationController.getIAnimation(97);
            this.carMenuAnimation.addListener(this);
        }
        return this.carMenuAnimation;
    }

    private AbstractAnimation getDriveSelectShiftAnimation() {
        if (this.driveSelectShiftAnimation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.driveSelectShiftAnimation = (AbstractAnimation)abstractAnimationController.getIAnimation(100);
            this.driveSelectShiftAnimation.addListener(this);
        }
        return this.driveSelectShiftAnimation;
    }

    private AbstractAnimation getDriveSelectGyroAnimation() {
        if (this.driveSelectGyroAnimation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.driveSelectGyroAnimation = (AbstractAnimation)abstractAnimationController.getIAnimation(101);
            this.driveSelectGyroAnimation.addListener(this);
        }
        return this.driveSelectGyroAnimation;
    }

    private AbstractAnimation getDriveSelectGridAnimation() {
        if (this.driveSelectGridAnimation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.driveSelectGridAnimation = (AbstractAnimation)abstractAnimationController.getIAnimation(108);
            this.driveSelectGridAnimation.addListener(this);
        }
        return this.driveSelectGridAnimation;
    }

    public void animationStarted(int n, int n2) {
    }

    public void animationFinished(int n, int n2) {
        if (n == 97) {
            this.setSuperSamplingRate(0, SUPERSAMPLING_RATE_STILL);
            this.setFXAAEnabled(0, FXAA_STILL);
            this.applyTransformationRotation(carMenuEndTransformation);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], this.currentCarMenuIndex == 20 ? 2.0f : 1.0f);
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
            if (this.isMMIKombi) {
                this.smallStageTransXCarMenu = this.currentCarMenuIndex == 43 ? this.smallStageTransCenterX : 0.0f;
                this.applyTranslation();
            }
        } else {
            this.setSuperSamplingRate(1, SUPERSAMPLING_RATE_STILL);
            this.setFXAAEnabled(1, FXAA_STILL);
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MENUE_SHIFT, this.driveSelectDDBOpen ? 1.0f : 0.0f);
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_STATE, this.gyroVisible ? 1.0f : 0.0f);
        }
        this.invalidatePartialRendering();
        this.setOpacity(this.opacity);
    }

    private void calculateTransformationRotation(TranslationRotation translationRotation, TranslationRotation translationRotation2, TranslationRotation translationRotation3, float f2) {
        this.calculateCarMenuTransformation(translationRotation, translationRotation2, translationRotation3, f2);
        this.calculateCarMenuLightTransformation(translationRotation, translationRotation2, translationRotation3, f2);
        this.calculateCarMenuEnhancedTransformation(translationRotation, translationRotation2, translationRotation3, f2);
    }

    private void calculateCarMenuTransformation(TranslationRotation translationRotation, TranslationRotation translationRotation2, TranslationRotation translationRotation3, float f2) {
        translationRotation3.transX = translationRotation.transX + (translationRotation2.transX - translationRotation.transX) * f2;
        translationRotation3.transY = translationRotation.transY + (translationRotation2.transY - translationRotation.transY) * f2;
        translationRotation3.transZ = translationRotation.transZ + (translationRotation2.transZ - translationRotation.transZ) * f2;
        translationRotation3.rotX = translationRotation.rotX + (translationRotation2.rotX - translationRotation.rotX) * f2;
        translationRotation3.rotY = translationRotation.rotY + (translationRotation2.rotY - translationRotation.rotY) * f2;
        translationRotation3.rotZ = translationRotation.rotZ + (translationRotation2.rotZ - translationRotation.rotZ) * f2;
    }

    private void calculateCarMenuLightTransformation(TranslationRotation translationRotation, TranslationRotation translationRotation2, TranslationRotation translationRotation3, float f2) {
        if (carMenuePointLight0 != null) {
            translationRotation3.pointLight0TransX = translationRotation.pointLight0TransX + (translationRotation2.pointLight0TransX - translationRotation.pointLight0TransX) * f2;
            translationRotation3.pointLight0TransY = translationRotation.pointLight0TransY + (translationRotation2.pointLight0TransY - translationRotation.pointLight0TransY) * f2;
            translationRotation3.pointLight0TransZ = translationRotation.pointLight0TransZ + (translationRotation2.pointLight0TransZ - translationRotation.pointLight0TransZ) * f2;
            translationRotation3.attenuationPointLight0 = translationRotation.attenuationPointLight0 + (translationRotation2.attenuationPointLight0 - translationRotation.attenuationPointLight0) * f2;
        }
        if (carMenuePointLight1 != null) {
            translationRotation3.pointLight1TransX = translationRotation.pointLight1TransX + (translationRotation2.pointLight1TransX - translationRotation.pointLight1TransX) * f2;
            translationRotation3.pointLight1TransY = translationRotation.pointLight1TransY + (translationRotation2.pointLight1TransY - translationRotation.pointLight1TransY) * f2;
            translationRotation3.pointLight1TransZ = translationRotation.pointLight1TransZ + (translationRotation2.pointLight1TransZ - translationRotation.pointLight1TransZ) * f2;
            translationRotation3.attenuationPointLight1 = translationRotation.attenuationPointLight1 + (translationRotation2.attenuationPointLight1 - translationRotation.attenuationPointLight1) * f2;
        }
        if (reflectionAdjustmentNode != null) {
            translationRotation3.reflectionAdjustmentTransX = translationRotation.reflectionAdjustmentTransX + (translationRotation2.reflectionAdjustmentTransX - translationRotation.reflectionAdjustmentTransX) * f2;
            translationRotation3.reflectionAdjustmentTransY = translationRotation.reflectionAdjustmentTransY + (translationRotation2.reflectionAdjustmentTransY - translationRotation.reflectionAdjustmentTransY) * f2;
            translationRotation3.reflectionAdjustmentTransZ = translationRotation.reflectionAdjustmentTransZ + (translationRotation2.reflectionAdjustmentTransZ - translationRotation.reflectionAdjustmentTransZ) * f2;
        }
        if (windowReflectionAdjustmentNode != null) {
            translationRotation3.windowReflectionAdjustmentTransX = translationRotation.windowReflectionAdjustmentTransX + (translationRotation2.windowReflectionAdjustmentTransX - translationRotation.windowReflectionAdjustmentTransX) * f2;
            translationRotation3.windowReflectionAdjustmentTransY = translationRotation.windowReflectionAdjustmentTransY + (translationRotation2.windowReflectionAdjustmentTransY - translationRotation.windowReflectionAdjustmentTransY) * f2;
            translationRotation3.windowReflectionAdjustmentTransZ = translationRotation.windowReflectionAdjustmentTransZ + (translationRotation2.windowReflectionAdjustmentTransZ - translationRotation.windowReflectionAdjustmentTransZ) * f2;
        }
    }

    private void calculateCarMenuEnhancedTransformation(TranslationRotation translationRotation, TranslationRotation translationRotation2, TranslationRotation translationRotation3, float f2) {
        if (scaleOffsetTranslationNode != null) {
            translationRotation3.enhancedTranslationX = translationRotation.enhancedTranslationX + (translationRotation2.enhancedTranslationX - translationRotation.enhancedTranslationX) * f2;
        }
    }

    private void animateCarMenu() {
        float f2 = this.getCarMenuAnimation().getProgress();
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#animateCarMenu: progress = %1", (double)f2);
        if (this.currentCarMenuIndex == 20) {
            if (f2 < 0.5f) {
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2);
                this.applyTransformationRotation(interpolatedTransRot);
            } else {
                interpolatedTransRot.copyValuesFrom(carMenuEndTransformation);
                this.applyTransformationRotation(carMenuEndTransformation);
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], 2.0f * f2);
            }
        } else if (this.lastCarMenuIndex == 20) {
            if (f2 < 0.5f) {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 2.0f - 2.0f * f2);
                interpolatedTransRot.copyValuesFrom(carMenuStartTransformation);
            } else {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2 - 1.0f);
                this.applyTransformationRotation(interpolatedTransRot);
            }
        } else if (this.currentCarMenuIndex == 14) {
            if (f2 < 0.5f) {
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2);
                this.applyTransformationRotation(interpolatedTransRot);
            } else {
                interpolatedTransRot.copyValuesFrom(carMenuEndTransformation);
                this.applyTransformationRotation(carMenuEndTransformation);
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], 2.0f * (f2 - 0.5f));
            }
        } else if (this.lastCarMenuIndex == 14) {
            if (f2 < 0.5f) {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 1.0f - 2.0f * f2);
                interpolatedTransRot.copyValuesFrom(carMenuStartTransformation);
            } else {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2 - 1.0f);
                this.applyTransformationRotation(interpolatedTransRot);
            }
        } else {
            this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, f2);
            this.applyTransformationRotation(interpolatedTransRot);
        }
        if (this.isMMIKombi) {
            if (this.currentCarMenuIndex == 43) {
                this.currentViewStageValue = this.lastViewStageValue + ((float)this.targetViewStage - this.lastViewStageValue) * f2;
                this.smallStageTransXCarMenu = this.smallStageTransCenterX * this.currentViewStageValue;
                this.applyTranslation();
            } else if (this.lastCarMenuIndex == 43) {
                this.currentViewStageValue = (this.lastViewStageValue - (float)this.targetViewStage) * (1.0f - f2);
                this.smallStageTransXCarMenu = this.smallStageTransCenterX * this.currentViewStageValue;
                this.applyTranslation();
            }
        }
    }

    private void animateDriveSelectShift() {
        float f2 = this.getDriveSelectShiftAnimation().getProgress();
        if (!this.driveSelectDDBOpen) {
            f2 = 1.0f - f2;
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_MENUE_SHIFT, f2);
    }

    private void animateDriveSelectGyro() {
        float f2 = this.getDriveSelectGyroAnimation().getProgress();
        if (!this.gyroVisible) {
            f2 = 1.0f - f2;
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, DRIVE_SELECT_GYRO_STATE, f2);
    }

    private void animateDriveSelectGyroGrid(boolean bl) {
        boolean bl2;
        if (this.backgroundNode == null) {
            return;
        }
        float f2 = this.getDriveSelectGridAnimation().getProgress();
        if (!this.getDriveSelectGridAnimation().isAnimating() || !this.isVisible()) {
            f2 = 1.0f;
            bl = false;
            this.logChannel3DCar.log(10000000, "Car3DResourceHandler#animateDriveSelectGyroGrid: Grid is set to default position ");
        }
        boolean bl3 = this.gridPosition > (float)gridDefaultPosition;
        boolean bl4 = bl2 = this.gridPosition < (float)gridGyroPosition;
        if (this.carViewerController != null && !this.carViewerController.isLTR()) {
            gridGyroPosition = 2 * gridDefaultPosition;
            bl3 = this.gridPosition < (float)gridDefaultPosition;
            bl2 = this.gridPosition > (float)gridGyroPosition;
        }
        float f3 = -1.0f;
        if (!bl && bl3) {
            f3 = (float)gridDefaultPosition - (float)(gridDefaultPosition - gridGyroPosition) * (1.0f - f2);
        } else if (bl && bl2) {
            f3 = (float)gridDefaultPosition - (float)(gridDefaultPosition - gridGyroPosition) * f2;
        }
        this.gridPosition = f3 == -1.0f ? this.gridPosition : f3;
        this.backgroundNode.setTranslation(this.gridPosition, 0.0f);
        if (this.logChannel3DCar.isDebug()) {
            this.logChannel3DCar.log(10000000, "Car3DResourceHandler#animateDriveSelectGyroGrid: Grid is moved to x:  %1, progress: %2", (Object)String.valueOf(this.gridPosition), (Object)String.valueOf(f2));
        }
    }

    private void animateDriveSelectPHEV() {
        INode3D iNode3D;
        float f2 = this.getDriveSelectGyroAnimation().getProgress();
        if (this.gyroVisible) {
            f2 = 1.0f - f2;
        }
        if ((iNode3D = this.getNode3D(DRIVE_SELECT_PROPERTY_NODE)) != null && this.terminal.getCarCodingHelper().isPHEVCar()) {
            this.propertyCache.setProperty((INode)iNode3D, DRIVE_SELECT_PHEV_STATE, f2);
            iNode3D.dispose();
        }
    }

    public void animate(int n, float f2, int n2) {
        if (n == 1) {
            this.lastCarMenuIndex = this.currentCarMenuIndex;
            this.currentCarMenuIndex = this.currentScreenshotProgress;
            this.setCurrentCarMenuOverlayUnanimated();
            HMIService hMIService = this.terminal.getFramework().getHMIService();
            ScreenShotEvent screenShotEvent = new ScreenShotEvent((ATIPEventListener)hMIService.getRootWindow(0), this.screenshotPath);
            screenShotEvent.setFileName(widgetIDMapping[this.currentScreenshotProgress]);
            hMIService.getEventDispatcher().postEvent(screenShotEvent);
            ++this.currentScreenshotProgress;
            if (this.currentScreenshotProgress == 43) {
                ++this.currentScreenshotProgress;
            }
            if (this.currentScreenshotProgress == widgetIDMapping.length) {
                this.screenShotAnimation.stopAnimation();
                this.currentScreenshotProgress = 0;
                System.out.println("finished car screehshots");
            }
            return;
        }
        if (n == 97) {
            this.animateCarMenu();
        } else if (n == 100) {
            this.animateDriveSelectShift();
        } else if (n == 108) {
            this.animateDriveSelectGyroGrid(this.gyroVisible && this.isVisible());
        } else {
            this.animateDriveSelectGyro();
            this.animateDriveSelectPHEV();
        }
        this.invalidatePartialRendering();
    }

    public float getLayerPosX(float f2) {
        if (!resourcesLoaded) {
            return 0.0f;
        }
        if (this.currentMode == 0) {
            float f3 = desaturateNodes[0].getTranslation().X() * this.scale + this.transX + this.skinTransX + this.smallStageTransXCarMenu;
            if (skinTranslationNode != null && skinTranslationNode.isValid() && !this.carViewerController.isLTR()) {
                int n = 800;
                if (this.isMMIKombi) {
                    n = 1000;
                }
                f3 = (float)n - desaturateNodes[0].getTranslation().X() * this.scale - this.transX - this.skinTransX - this.smallStageTransXCarMenu;
            }
            return f3;
        }
        if (driveSelectAvailable) {
            float f4 = desaturateNodes[1].getTranslation().X() * this.scale + this.transX + this.skinTransX;
            if (skinTranslationNode != null && skinTranslationNode.isValid() && !this.carViewerController.isLTR()) {
                int n = 800;
                if (this.isMMIKombi) {
                    n = 1000;
                }
                f4 = (float)n - desaturateNodes[1].getTranslation().X() * this.scale - this.transX - this.skinTransX;
            }
            return f4;
        }
        return 0.0f;
    }

    public float getLayerPosY() {
        if (!resourcesLoaded) {
            return 0.0f;
        }
        if (this.currentMode == 0) {
            return desaturateNodes[0].getTranslation().Y() * this.scale + this.transY + this.skinTransY + this.smallStageTransYCarMenu;
        }
        if (driveSelectAvailable) {
            return desaturateNodes[1].getTranslation().Y() * this.scale + this.transY + this.skinTransY + this.smallStageTransYCarMenu;
        }
        return 0.0f;
    }

    public float getLayerWidth() {
        if (!resourcesLoaded) {
            return 0.0f;
        }
        if (this.currentMode == 0) {
            return (float)desaturateNodes[0].getWidth() * this.scale;
        }
        if (driveSelectAvailable) {
            return (float)desaturateNodes[1].getWidth() * this.scale * this.driveSelectScaleFactor;
        }
        return 0.0f;
    }

    public float getLayerHeight() {
        if (!resourcesLoaded) {
            return 0.0f;
        }
        if (this.currentMode == 0) {
            return (float)desaturateNodes[0].getHeight() * this.scale;
        }
        if (driveSelectAvailable) {
            return (float)desaturateNodes[1].getHeight() * this.scale * this.driveSelectScaleFactor;
        }
        return 0.0f;
    }

    public void afterDraw() {
        this.setOffscreenRenderingEnabled(false);
    }

    public void setViewSizeTargetChanged(int n, boolean bl) {
        if (this.targetViewStage == n) {
            return;
        }
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setViewSizeTargetChanged: stage = %1", (long)n);
        this.lastViewStageValue = this.currentViewStageValue;
        if (n == 1) {
            if (this.currentMode == 0) {
                this.bigStageCarMenuIndex = this.currentCarMenuIndex;
                if (bl) {
                    this.setActiveCarMenuOverlay(43);
                } else {
                    this.lastCarMenuIndex = this.currentCarMenuIndex;
                    this.currentCarMenuIndex = 43;
                    this.setCurrentCarMenuOverlayUnanimated();
                }
            }
            this.targetViewStage = 1;
        } else {
            this.targetViewStage = 0;
            if (this.currentMode == 0) {
                if (bl) {
                    this.setActiveCarMenuOverlay(this.bigStageCarMenuIndex);
                } else {
                    this.lastCarMenuIndex = this.currentCarMenuIndex;
                    this.currentCarMenuIndex = this.bigStageCarMenuIndex;
                    this.setCurrentCarMenuOverlayUnanimated();
                }
            }
        }
        if (this.currentMode == 1) {
            this.setFXAAEnabled(1, FXAA_ANIMATED);
        }
    }

    public void setViewSizeAnimationFinished(int n) {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setViewSizeAnimationFinished: stage = %1", (long)n);
        this.setSmallStagePositionPercentage(n == 0 ? 0.0f : 1.0f);
        if (this.currentMode == 1) {
            this.setFXAAEnabled(1, FXAA_STILL);
        }
    }

    private void setDriveSelectSmallStagePercentage(float f2) {
        this.invalidatePartialRendering();
    }

    public void setSmallStagePositionPercentage(float f2) {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#setSmallStagePositionPercentage: %1", (double)f2);
        if (!this.resourcesLoaded()) {
            return;
        }
        if (this.currentMode == 1) {
            if (this.selectedDriveSelectProfile == 8) {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, SMALL_STAGE_PROPERTY_NAME, f2);
            }
            this.setDriveSelectSmallStagePercentage(f2);
        } else {
            this.invalidatePartialRendering();
        }
    }

    public void registerRefractionGlassplate(I3DCarListener i3DCarListener) {
        this.refractionGlassPlates.add(i3DCarListener);
    }

    public void unRegisterRefractionGlassplate(I3DCarListener i3DCarListener) {
        this.refractionGlassPlates.remove(i3DCarListener);
    }

    public void screenshotAllCarMenus(String string) {
        if (this.screenShotAnimation == null) {
            AbstractAnimationController abstractAnimationController = (AbstractAnimationController)this.terminal.getIAnimationController();
            this.screenShotAnimation = (AbstractAnimation)abstractAnimationController.getIAnimation(1);
            this.screenShotAnimation.addListener(this);
        }
        this.screenshotPath = string;
        this.screenShotAnimation.startEndlessAnimation(1000, this.carViewerController);
    }

    public void stopAnimations() {
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#stopAnimations");
        if (this.carMenuAnimation != null) {
            if (this.carMenuAnimation.isAnimating()) {
                this.carMenuAnimation.stopAnimation();
            }
            this.carMenuAnimation = null;
        }
        if (this.driveSelectGyroAnimation != null) {
            if (this.driveSelectGyroAnimation.isAnimating()) {
                this.driveSelectGyroAnimation.stopAnimation();
            }
            this.driveSelectGyroAnimation = null;
        }
        if (this.driveSelectGridAnimation != null) {
            if (this.driveSelectGridAnimation.isAnimating()) {
                this.driveSelectGridAnimation.stopAnimation();
            }
            this.driveSelectGridAnimation = null;
        }
        if (this.driveSelectShiftAnimation != null) {
            if (this.driveSelectShiftAnimation.isAnimating()) {
                this.driveSelectShiftAnimation.stopAnimation();
            }
            this.driveSelectShiftAnimation = null;
        }
    }

    public void setSmallStageTranslationOffset(float f2) {
        this.smallStageTransCenterX = f2;
    }

    public Car3DPHEVHandler getCar3DPEHEVHandler() {
        return this.carPHEVHandler;
    }

    public AbstractWidget getCarViewerController() {
        return this.carViewerController;
    }

    public float getGridPosition() {
        if (!resourcesLoaded) {
            Layout layout = this.terminal.getLayout();
            gridGyroPosition = layout.getIntegerConstant(112);
            gridDefaultPosition = layout.getIntegerConstant(111);
            this.gridPosition = gridDefaultPosition;
        }
        return this.gridPosition;
    }

    public void setGridPosition(float f2) {
        this.gridPosition = f2;
    }

    private void enablePHEVEnergyFlow(boolean bl) {
        if (this.carPHEVHandler != null) {
            this.carPHEVHandler.enablePhevHandler(bl);
        }
    }

    public void initializePHEVHandler() {
        this.carPHEVHandler = new Car3DPHEVHandler(this.terminal, this.ealManager, this);
        this.logChannel3DCar.log(10000000, "Car3DResourceHandler#initializeCarPHEVHanlder");
    }

    static {
        firstTime = true;
        resourcesLoaded = false;
    }

    private class TranslationRotation {
        private static final float enhancedTranslationDefaultValue = 257.0f;
        public float transX;
        public float transY;
        public float transZ;
        public float rotX;
        public float rotY;
        public float rotZ;
        public float pointLight0TransX;
        public float pointLight0TransY;
        public float pointLight0TransZ;
        public float pointLight1TransX;
        public float pointLight1TransY;
        public float pointLight1TransZ;
        public float reflectionAdjustmentTransX;
        public float reflectionAdjustmentTransY;
        public float reflectionAdjustmentTransZ;
        public float windowReflectionAdjustmentTransX;
        public float windowReflectionAdjustmentTransY;
        public float windowReflectionAdjustmentTransZ;
        public float attenuationPointLight0;
        public float attenuationPointLight1;
        public float enhancedTranslationX = 257.0f;

        private TranslationRotation() {
        }

        public void copyValuesFrom(TranslationRotation translationRotation) {
            this.transX = translationRotation.transX;
            this.transY = translationRotation.transY;
            this.transZ = translationRotation.transZ;
            this.rotX = translationRotation.rotX;
            this.rotY = translationRotation.rotY;
            this.rotZ = translationRotation.rotZ;
            this.pointLight0TransX = translationRotation.pointLight0TransX;
            this.pointLight0TransY = translationRotation.pointLight0TransY;
            this.pointLight0TransZ = translationRotation.pointLight0TransZ;
            this.pointLight1TransX = translationRotation.pointLight1TransX;
            this.pointLight1TransY = translationRotation.pointLight1TransY;
            this.pointLight1TransZ = translationRotation.pointLight1TransZ;
            this.reflectionAdjustmentTransX = translationRotation.reflectionAdjustmentTransX;
            this.reflectionAdjustmentTransY = translationRotation.reflectionAdjustmentTransY;
            this.reflectionAdjustmentTransZ = translationRotation.reflectionAdjustmentTransZ;
            this.windowReflectionAdjustmentTransX = translationRotation.windowReflectionAdjustmentTransX;
            this.windowReflectionAdjustmentTransY = translationRotation.windowReflectionAdjustmentTransY;
            this.windowReflectionAdjustmentTransZ = translationRotation.windowReflectionAdjustmentTransZ;
            this.attenuationPointLight0 = translationRotation.attenuationPointLight0;
            this.attenuationPointLight1 = translationRotation.attenuationPointLight1;
            this.enhancedTranslationX = translationRotation.enhancedTranslationX;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("tx = ");
            buffer.append(this.transX);
            buffer.append(", ty = ");
            buffer.append(this.transY);
            buffer.append(", tz = ");
            buffer.append(this.transZ);
            buffer.append("\nrx = ");
            buffer.append(this.rotX);
            buffer.append(", ry = ");
            buffer.append(this.rotY);
            buffer.append(", rz = ");
            buffer.append(this.rotZ);
            buffer.append("\nPL0x = ");
            buffer.append(this.pointLight0TransX);
            buffer.append(", PL0y = ");
            buffer.append(this.pointLight0TransY);
            buffer.append(", PL0z = ");
            buffer.append(this.pointLight0TransZ);
            buffer.append("\nPL1x = ");
            buffer.append(this.pointLight1TransX);
            buffer.append(", PL1y = ");
            buffer.append(this.pointLight1TransY);
            buffer.append(", PL1z = ");
            buffer.append(this.pointLight1TransZ);
            buffer.append("\nRefAdjustx = ");
            buffer.append(this.reflectionAdjustmentTransX);
            buffer.append(", RefAdjusty = ");
            buffer.append(this.reflectionAdjustmentTransY);
            buffer.append(", RefAdjustz = ");
            buffer.append(this.reflectionAdjustmentTransZ);
            buffer.append("\nWindowRefAdjustx = ");
            buffer.append(this.windowReflectionAdjustmentTransX);
            buffer.append(", WindowRefAdjusty = ");
            buffer.append(this.windowReflectionAdjustmentTransY);
            buffer.append(", WindowRefAdjustz = ");
            buffer.append(this.windowReflectionAdjustmentTransZ);
            return buffer.toString();
        }
    }
}

