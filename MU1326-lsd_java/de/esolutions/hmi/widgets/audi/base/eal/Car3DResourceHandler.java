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
import de.esolutions.hmi.widgets.audi.base.eal.Car3DResourceHandler$TranslationRotation;
import de.esolutions.hmi.widgets.audi.base.eal.EALManager;
import de.esolutions.hmi.widgets.audi.base.eal.EALPropertyCache;
import de.esolutions.hmi.widgets.audi.base.eal.HMITerminalEAL;
import java.util.ArrayList;
import java.util.List;

public class Car3DResourceHandler
implements AnimationListener {
    private static final int NONE;
    private static boolean DEBUG_OUTPUT;
    private static final boolean ANIMATED;
    private static final int MAX_ANIMATION_TIME;
    private static final int MIN_ANIMATION_TIME;
    private static final int SCREEN_CHANGE_ANIMATION_TIME;
    private static final boolean OVERWRITE_FXAA;
    private static final boolean OVERWRITE_FXAA_VALUE;
    private static final boolean OVERWRITE_SUPERSAMPLING;
    private static final float OVERWRITE_SUPERSAMPLING_RATE;
    private static final float SUPERSAMPLING_RATE_ANIMATED;
    private static final float SUPERSAMPLING_RATE_STILL;
    private static final boolean FXAA_STILL;
    private static final boolean FXAA_ANIMATED;
    private static final float STATE_OFF;
    private static final float STATE_NO_UPDATE;
    private static final float STATE_ACTIVE;
    private static final int PASSIVE_INDEX;
    private static final int SMALL_STAGE_INDEX;
    private static final int SERVICE_INTERVAL_INDEX;
    private static final int UGDO_INDEX;
    private static final int OIL_LEVEL_INDEX;
    private static final String DEFAULT_PROPERTY_NAME;
    private static final String SMALL_STAGE_PROPERTY_NAME;
    private static final String[] WIDGET_ID_MAPPING_LHD;
    private static final String CAR_MENU_TRANSFORMATION_LAYER_NAME;
    private static final String CAR_TRANSFORMATION_LAYER_NAME;
    private static final String CAR_MENU_FBO_LAYER_NAME;
    private static final String CAR_MENU_FBO_TEXTURE_NAME;
    private static final String CAR_MENU_3D_SCALE_TRANSFORMATION_SHORTCUT;
    private static final String DRIVE_SELECT_TRANSFORMATION_LAYER_NAME;
    private static final String DRIVE_SELECT_FBO_LAYER_NAME;
    private static final String DRIVE_SELECT_FBO_TEXTURE_NAME;
    private static final String DRIVE_SELECT_PHEV_STATE;
    private static final String DRIVE_SELECT_MODE_RACE;
    private static final String DRIVE_SELECT_MODE_DYNAMIC;
    private static final String DRIVE_SELECT_MODE_EFFICIENCY;
    private static final String DRIVE_SELECT_MODE_COMFORT;
    private static final String DRIVE_SELECT_GYRO_ROLL_WARNING_RANGE;
    private static final String DRIVE_SELECT_GYRO_ROLL_HARD_WARNING;
    private static final String DRIVE_SELECT_GYRO_ROLL_SOFT_WARNING;
    private static final String DRIVE_SELECT_GYRO_ROLL;
    private static final String DRIVE_SELECT_GYRO_PITCH_WARNING_RANGE;
    private static final String DRIVE_SELECT_GYRO_PITCH_HARD_WARNING;
    private static final String DRIVE_SELECT_GYRO_PITCH_SOFT_WARNING;
    private static final String DRIVE_SELECT_GYRO_PITCH;
    private static final String GARAGENTOR_ANLERNEN_INNENSPIEGEL_RHD;
    private static final String HUD_RHD;
    private static final String BELEGUNG_LENKRADTASTE_ROADSTER;
    private static final String BELEGUNG_LENKRADTASTE_RHD;
    private static final String ROTATION_Z;
    private static final String ROTATION_Y;
    private static final String ROTATION_X;
    private static final String ATTENUATION;
    private static final String TRANSLATION_Z;
    private static final String TRANSLATION_Y;
    private static final String TRANSLATION_X;
    private static final String DRIVE_SELECT_MENUE_SHIFT;
    private static final String DRIVE_SELECT_GYRO_STATE;
    private static final String DRIVE_SELECT_STATE;
    private static final String AMBIENT_LIGHT_STATE;
    private static final String AMBIENT_LIGHT_FLOOR_COLOR;
    private static final String AMBIENT_LIGHT_DOORS_COLOR;
    private static final String AMBIENT_LIGHT_DASH_COLOR;
    private static final String AMBIENT_LIGHT_BORDER_COLOR;
    private static final String AMBIENT_LIGHT_BORDER_ITAFEL_COLOR;
    private static final String AMBIENT_LIGHT_BORDER_DOOR_COLOR;
    private static final String AMBIENT_LIGHT_BORDER_MIKO_COLOR;
    private static final String CAR_MENUE_SUPER_SAMPLING_RATE;
    private static final String CAR_MENUE_RHD;
    private static final String CAR_MENUE_STATE;
    private static final String DESATURATE;
    private static final String LAYER_MATERIAL;
    private static final String CAR_MENU_PROPERTY_NODE;
    private static final String DRIVE_SELECT_PROPERTY_NODE;
    private static final String CAR_MENU_3D_TRANSFORMATION_NODE_NAME;
    private static final String CAR_MENU_FXAA_LAYER_NAME;
    private static final String DRIVE_SELECT_FXAA_LAYER_NAME;
    private static final String AMBIENT_LIGHT_LAYER_NAME;
    private static final String FXAA_OFF_MATERIAL_NAME;
    private static final String FXAA_ON_MATERIAL_NAME;
    private static final float OVERLAY_OFF_VALUE;
    private static final float OVERLAY_ON_VALUE;
    private static final float OVERLAY_ON_VALUE_SERVICE_INTERVAL;
    private static final int ROOT_TRANSLATION_OFFSET_X_KOMBI;
    private static final int ROOT_TRANSLATION_OFFSET_X;
    private static final String CAR_MENU_POINTLIGHT_0_NODE_NAME;
    private static final String CAR_MENU_POINTLIGHT_1_NODE_NAME;
    private static final String CAR_MENU_REFLECTION_ADJUSTMENT_NODE_NAME;
    private static final String CAR_MENU_WINDOW_REFLECTION_ADJUSTMENT_NODE_NAME;
    private static final String CAR_MENU_POINTLIGHT_0_ANIMATION_NAME;
    private static final String CAR_MENU_POINTLIGHT_1_ANIMATION_NAME;
    private static final String CAR_MENU_SCALE_ENHENCED_TRANSLATION;
    private static final String CAR_MENU_lightConstant_ATTENUATION_NAME;
    private static String[] widgetIDMapping;
    private static INode3D[] stateNodes;
    private static String[] stateKeys;
    private static INode3D[] carMenuOverlayNodes;
    private static String[] carMenuOverlayKeys;
    private static INode2D[] desaturateNodes;
    private static String[] desaturateKeys;
    private static Car3DResourceHandler$TranslationRotation[] carMenuTransformations;
    private static Car3DResourceHandler$TranslationRotation interpolatedTransRot;
    private static Car3DResourceHandler$TranslationRotation carMenuStartTransformation;
    private static Car3DResourceHandler$TranslationRotation carMenuEndTransformation;
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
    private static final int ANIMATION_TYPE_ENDLESS;
    private static final int ANIMATION_TYPE_CARMENU;
    private static final int ANIMATION_TYPE_DRIVESELECT_SHIFT;
    private static final int ANIMATION_TYPE_DRIVESELECT_GYRO;
    private static final int ANIMATION_TYPE_DRIVESELECT_GRID;
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
    public static final int QQ1;
    public static final int QQ2;
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
    private float smallStageTransCenterX = 23747;
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#getAnimationClip: Could not get clip '%1'", (Object)string);
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
        if (this.backgroundNode != null && this.backgroundNode.getWidth() <= 0) {
            this.backgroundNode = null;
        }
        if (widgetIDMapping == null) {
            widgetIDMapping = WIDGET_ID_MAPPING_LHD;
        }
        INode2D iNode2D2 = this.getNode2D("carMenu_imageLayer");
        carMenuTransformationLayer = this.getNode2D("carMenue_transformation_layer");
        skinTranslationNode = this.getNode2D("car_transformation_layer");
        materialFXAAOff = this.getMaterial("car_noPostFXMaterial");
        materialFXAAOn = this.getMaterial("car_PostFXMaterial");
        materialNodes = new INode2D[5];
        materialKeys = new String[5];
        Car3DResourceHandler.materialNodes[0] = iNode2D = this.getNode2D("carMenue_FBO_PostFX");
        Car3DResourceHandler.materialKeys[0] = "LayerMaterial";
        desaturateNodes = new INode2D[5];
        desaturateKeys = new String[5];
        Car3DResourceHandler.desaturateNodes[0] = iNode2D2;
        Car3DResourceHandler.desaturateKeys[0] = "desaturate";
        INode3D iNode3D = this.getNode3D("carMenue_Controls");
        carMenuePointLight0 = this.getNode3D("carMenue_PointLight0");
        carMenuePointLight1 = this.getNode3D("carMenue_PointLight1");
        reflectionAdjustmentNode = this.getNode3D("ReflectionAdjustmentNode");
        windowReflectionAdjustmentNode = this.getNode3D("WindowReflectionAdjustmentNode");
        if (AbstractWidget.isScreenResolution800()) {
            scaleOffsetTranslationNode = this.getNode2D("carMenue_scale_offset");
        }
        if (iNode3D == null) {
            return;
        }
        stateNodes = new INode3D[5];
        stateKeys = new String[5];
        Car3DResourceHandler.stateNodes[0] = iNode3D;
        Car3DResourceHandler.stateKeys[0] = "carMenue_state";
        this.propertyCache.setProperty((INode)stateNodes[0], stateKeys[0], 0.0f);
        this.propertyCache.setProperty((INode)iNode3D, "carMenue_RHD", AbstractWidget.isRightHandDrive() ? 1.0f : 0.0f);
        int n2 = widgetIDMapping.length;
        carMenuOverlayNodes = new INode3D[n2];
        carMenuOverlayKeys = new String[n2];
        for (n = n2 - 1; n >= 0; --n) {
            Car3DResourceHandler.carMenuOverlayNodes[n] = iNode3D;
            Car3DResourceHandler.carMenuOverlayKeys[n] = widgetIDMapping[n];
            if (carMenuOverlayNodes[n] == null) {
                Car3DResourceHandler.carMenuOverlayNodes[n] = iNode3D;
                Car3DResourceHandler.carMenuOverlayKeys[n] = "0_Default_Position";
            }
            this.propertyCache.setProperty((INode)carMenuOverlayNodes[n], carMenuOverlayKeys[n], 0.0f);
        }
        superSamplingRateNodes = new INode3D[5];
        superSamplingRateKeys = new String[5];
        Car3DResourceHandler.superSamplingRateNodes[0] = iNode3D;
        Car3DResourceHandler.superSamplingRateKeys[0] = "car_superSamplingRate";
        carMenu3DTransformationNode = this.getNode3D("CarmenueObjects");
        carMenuTransformations = new Car3DResourceHandler$TranslationRotation[n2];
        for (n = n2 - 1; n >= 0; --n) {
            Car3DResourceHandler.carMenuTransformations[n] = new Car3DResourceHandler$TranslationRotation(this, null);
            object = new float[1];
            IAnimationClip iAnimationClip = null;
            String string = this.mapDivergendIDMapping(n);
            iAnimationClip = string != null ? this.getAnimationClip(new StringBuffer().append("Animation Clips/").append(string).toString()) : this.getAnimationClip(new StringBuffer().append("Animation Clips/").append(widgetIDMapping[n]).toString());
            if (iAnimationClip == null) continue;
            int n3 = (int)iAnimationClip.getSize();
            for (int i2 = 0; i2 < n3; ++i2) {
                IAnimation iAnimation = iAnimationClip.getAnimation(i2);
                iAnimation.getValue(0L, (float[])object);
                String string2 = iAnimation.getName();
                if (string2.indexOf("CarmenueObjects") >= 0) {
                    this.setCarTranslationRotation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf("WindowReflectionAdjustmentNode") >= 0) {
                    this.setWindowReflectionTranslation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf("ReflectionAdjustmentNode") >= 0) {
                    this.setReflectionAdjustment(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf("Point Light0") >= 0) {
                    this.setPointLight0Translation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf("Point Light1") >= 0) {
                    this.setPointLight1Translation(carMenuTransformations[n], string2, object[0]);
                } else if (string2.indexOf("scale_offset") >= 0) {
                    this.setEnhancedTranslation(carMenuTransformations[n], string2, object[0]);
                }
                iAnimation.dispose();
            }
            iAnimationClip.dispose();
            while (Car3DResourceHandler.carMenuTransformations[n].rotY < 0.0f) {
                Car3DResourceHandler.carMenuTransformations[n].rotY += 46147;
            }
            while (Car3DResourceHandler.carMenuTransformations[n].rotY > 46147) {
                Car3DResourceHandler.carMenuTransformations[n].rotY -= 46147;
            }
            if (!DEBUG_OUTPUT) continue;
            System.out.println(widgetIDMapping[n]);
            System.out.println(carMenuTransformations[n]);
            System.out.println("");
        }
        finalCarMenuFBOTexture = this.getEALTexture("carMenu_complete_FBO");
        ambientLightNode = this.getNode2D("AmbientLight");
        INode2D iNode2D3 = this.getNode2D("driveSelect_imageLayer");
        boolean bl = driveSelectAvailable = iNode2D3 != null;
        if (driveSelectAvailable) {
            driveSelectTransformationLayer = this.getNode2D("driveSelect_transformation_layer");
            this.driveSelectPropertyHolderNode = this.getNode3D("driveSelect_Controls");
            if (this.driveSelectPropertyHolderNode != null) {
                Car3DResourceHandler.stateNodes[1] = this.driveSelectPropertyHolderNode;
                Car3DResourceHandler.stateKeys[1] = "driveSelect_state";
                this.propertyCache.setProperty((INode)stateNodes[1], stateKeys[1], 0.0f);
                Car3DResourceHandler.desaturateNodes[1] = iNode2D3;
                Car3DResourceHandler.desaturateKeys[1] = "desaturate";
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "carMenue_RHD", AbstractWidget.isRightHandDrive() ? 1.0f : 0.0f);
                object = this.getNode2D("driveSelect_FBO_PostFX");
                Car3DResourceHandler.materialNodes[1] = object;
                Car3DResourceHandler.materialKeys[1] = "LayerMaterial";
                Car3DResourceHandler.superSamplingRateNodes[1] = this.driveSelectPropertyHolderNode;
                Car3DResourceHandler.superSamplingRateKeys[1] = "car_superSamplingRate";
                driveSelectFBOTexture = this.getEALTexture("driveSelect_complete_FBO");
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
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_state", this.gyroVisible ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_menue_shift", this.driveSelectDDBOpen ? 1.0f : 0.0f);
        interpolatedTransRot = new Car3DResourceHandler$TranslationRotation(this, null);
    }

    private void setPointLight0Translation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight0TransX = f2;
        } else if (string.indexOf("TRANSLATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight0TransY = f2;
        } else if (string.indexOf("TRANSLATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight0TransZ = f2;
        } else if (string.indexOf("Attenuation") >= 0) {
            car3DResourceHandler$TranslationRotation.attenuationPointLight0 = f2;
        }
    }

    private void setPointLight1Translation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight1TransX = f2;
        } else if (string.indexOf("TRANSLATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight1TransY = f2;
        } else if (string.indexOf("TRANSLATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.pointLight1TransZ = f2;
        } else if (string.indexOf("Attenuation") >= 0) {
            car3DResourceHandler$TranslationRotation.attenuationPointLight1 = f2;
        }
    }

    private void setEnhancedTranslation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.enhancedTranslationX = f2;
        }
    }

    private void setReflectionAdjustment(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransX = f2;
        } else if (string.indexOf("TRANSLATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransY = f2;
        } else if (string.indexOf("TRANSLATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransZ = f2;
        }
    }

    private void setWindowReflectionTranslation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransX = f2;
        } else if (string.indexOf("TRANSLATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransY = f2;
        } else if (string.indexOf("TRANSLATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransZ = f2;
        }
    }

    private void setCarTranslationRotation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, String string, float f2) {
        if (string.indexOf("ROTATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.rotX = f2;
        } else if (string.indexOf("ROTATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.rotY = f2;
        } else if (string.indexOf("ROTATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.rotZ = f2;
        } else if (string.indexOf("TRANSLATION_X") >= 0) {
            car3DResourceHandler$TranslationRotation.transX = f2;
        } else if (string.indexOf("TRANSLATION_Y") >= 0) {
            car3DResourceHandler$TranslationRotation.transY = f2;
        } else if (string.indexOf("TRANSLATION_Z") >= 0) {
            car3DResourceHandler$TranslationRotation.transZ = f2;
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
                    return "Belegung_Lenkradtaste_RHD";
                }
                if (n2 != 21) break;
                return "Belegung_Lenkradtaste_Roadster";
            }
            case 32: {
                if (!bl) break;
                return "HUD_RHD";
            }
            case 49: {
                if (!iCarCodingHelper.isB9() || !bl) break;
                return "Garagentor_Anlernen_Innenspiegel_RHD";
            }
        }
        return string;
    }

    private void setGyroVisible(boolean bl) {
        AbstractAnimation abstractAnimation;
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setGyroVisible %1", bl);
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
        abstractAnimation.startDynamicAnimation(0.0f, 51266, 101, false, this.carViewerController);
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
            abstractAnimation.startDynamicAnimation(0.0f, 51266, 108, false, this.carViewerController);
        }
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#startGridTranslationAnimation: Animation is started");
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
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch", this.gyroPitch);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_softWarning", (float)this.gyroPitchSoftWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_hardWarning", (float)this.gyroPitchHardWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_warningRange", (float)this.gyroPitchHardWarningEndAngle);
            } else {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_softWarning", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_hardWarning", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_pitch_warningRange", 0.0f);
            }
            if (this.rollAngleVisible) {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll", this.gyroRoll);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_softWarning", (float)this.gyroRollSoftWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_hardWarning", (float)this.gyroRollHardWarningStartAngle);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_warningRange", (float)this.gyroRollHardWarningEndAngle);
            } else {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_softWarning", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_hardWarning", 0.0f);
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_roll_warningRange", 0.0f);
            }
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_mode_comfort", this.selectedDriveSelectProfile == 3 ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_mode_efficiency", this.selectedDriveSelectProfile == 2 ? 1.0f : 0.0f);
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_mode_dynamic", this.selectedDriveSelectProfile == 5 ? 1.0f : 0.0f);
        if (this.terminal.getCarCodingHelper().isR8orTT()) {
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_mode_race", this.selectedDriveSelectProfile == 8 ? 1.0f : 0.0f);
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#loadResources: time for 3D car loading: %1ms (thereof %2ms scene parsing for nodes and properties)", l3 - l, l3 - l2);
    }

    public void loadResourcesAsync(int n, int n2, String string) {
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#loadResources: start loading %1 resources async", (Object)string);
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#asyncMergeFinished: time for 3D car loading: %1ms (thereof %2ms scene parsing forr nodes and properties)", l2 - this.asyncLoadStartTime, l2 - l);
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
            this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setVisible %1", bl);
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

    private void applyTransformationRotation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation) {
        this.applyCarMenuTransformations(car3DResourceHandler$TranslationRotation);
        this.applyCarMenuLightTransformations(car3DResourceHandler$TranslationRotation);
        this.applyCarMenuEnhancedTransformation(car3DResourceHandler$TranslationRotation);
    }

    private void applyCarMenuTransformations(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation) {
        carMenu3DTransformationNode.setTranslation(car3DResourceHandler$TranslationRotation.transX, car3DResourceHandler$TranslationRotation.transY, car3DResourceHandler$TranslationRotation.transZ);
        carMenu3DTransformationNode.setRotationXYZ(car3DResourceHandler$TranslationRotation.rotX, car3DResourceHandler$TranslationRotation.rotY, car3DResourceHandler$TranslationRotation.rotZ);
    }

    private void applyCarMenuLightTransformations(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation) {
        if (carMenuePointLight0 != null) {
            this.propertyCache.setProperty(carMenuePointLight0, "PointLightAttenuation", car3DResourceHandler$TranslationRotation.attenuationPointLight0, 0.0f, 0.0f);
            carMenuePointLight0.setTranslation(car3DResourceHandler$TranslationRotation.pointLight0TransX, car3DResourceHandler$TranslationRotation.pointLight0TransY, car3DResourceHandler$TranslationRotation.pointLight0TransZ);
        }
        if (carMenuePointLight1 != null) {
            this.propertyCache.setProperty(carMenuePointLight1, "PointLightAttenuation", car3DResourceHandler$TranslationRotation.attenuationPointLight1, 0.0f, 0.0f);
            carMenuePointLight1.setTranslation(car3DResourceHandler$TranslationRotation.pointLight1TransX, car3DResourceHandler$TranslationRotation.pointLight1TransY, car3DResourceHandler$TranslationRotation.pointLight1TransZ);
        }
        if (reflectionAdjustmentNode != null) {
            reflectionAdjustmentNode.setTranslation(car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransX, car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransY, car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransZ);
        }
        if (windowReflectionAdjustmentNode != null) {
            windowReflectionAdjustmentNode.setTranslation(car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransX, car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransY, car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransZ);
        }
    }

    private void applyCarMenuEnhancedTransformation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation) {
        if (scaleOffsetTranslationNode != null) {
            scaleOffsetTranslationNode.setTranslation(car3DResourceHandler$TranslationRotation.enhancedTranslationX, 0.0f);
        }
    }

    private void prepareCarMenuTransformAnim(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation2) {
        if (carMenuStartTransformation == null) {
            carMenuStartTransformation = new Car3DResourceHandler$TranslationRotation(this, null);
        }
        if (carMenuEndTransformation == null) {
            carMenuEndTransformation = new Car3DResourceHandler$TranslationRotation(this, null);
        }
        carMenuStartTransformation.copyValuesFrom(car3DResourceHandler$TranslationRotation);
        carMenuEndTransformation.copyValuesFrom(car3DResourceHandler$TranslationRotation2);
        if (Car3DResourceHandler.carMenuEndTransformation.rotY > Car3DResourceHandler.carMenuStartTransformation.rotY) {
            if (Car3DResourceHandler.carMenuEndTransformation.rotY - Car3DResourceHandler.carMenuStartTransformation.rotY > 13379) {
                Car3DResourceHandler.carMenuStartTransformation.rotY += 46147;
            }
        } else if (Car3DResourceHandler.carMenuStartTransformation.rotY - Car3DResourceHandler.carMenuEndTransformation.rotY > 13379) {
            Car3DResourceHandler.carMenuEndTransformation.rotY += 46147;
        }
        float f2 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.rotY - Car3DResourceHandler.carMenuEndTransformation.rotY);
        float f3 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.rotZ - Car3DResourceHandler.carMenuEndTransformation.rotZ);
        float f4 = (f2 + f3) / 2.0f;
        float f5 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transX - Car3DResourceHandler.carMenuEndTransformation.transX);
        float f6 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transY - Car3DResourceHandler.carMenuEndTransformation.transY);
        float f7 = Math.abs(Car3DResourceHandler.carMenuStartTransformation.transZ - Car3DResourceHandler.carMenuEndTransformation.transZ);
        float f8 = (f5 + f6 + f7) / 16448;
        float f9 = f4 / 13379;
        float f10 = f8 / 4161;
        float f11 = Math.max(f9, f10);
        f11 = Math.min(f11, 1.0f);
        this.currentAnimationDuration = (f11 = Math.max(f11, 0.0f)) == 0.0f ? 0 : (int)((float)MIN_ANIMATION_TIME + (float)(MAX_ANIMATION_TIME - MIN_ANIMATION_TIME) * f11);
        if (this.terminal.getIAnimationController().isScreenChangeAnimationRunning()) {
            this.currentAnimationDuration = 250;
        }
    }

    public void setCurrentCarMenuOverlayUnanimated() {
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setCurrentCarMenuOverlayUnanimated: currentCarMenuIndex is %1", (long)this.currentCarMenuIndex);
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
            this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setActiveCarMenuOverlay: setting menuitem id %1", (long)n);
            if (carMenuOverlayNodes != null && carMenuOverlayNodes[n] != null) {
                this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setActiveCarMenuOverlay: setting overlay name \"%1\"", (Object)carMenuOverlayNodes[n].getProperty(carMenuOverlayKeys[n]).getName());
            } else {
                this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setActiveCarMenuOverlay: carMenuOverlayNodes[%1] is null", (long)n);
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
            abstractAnimation.startDynamicAnimation(0.0f, 51266, 97, false, this.carViewerController);
        }
    }

    private void setAmbientLightProperties() {
        if (this.terminal.getCarCodingHelper().isQ2()) {
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_doors_color", new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_floor_color", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_border_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_state", 1.0f);
        } else if (this.terminal.getCarCodingHelper().isR8()) {
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_doors_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_floor_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_border_color", new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_dash_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_state", this.colorBrightness[0]);
        } else if (this.terminal.getCarCodingHelper().isQ7()) {
            if (this.ambientPackage == 1) {
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_miko", new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_dash_color", new colorRGBAf(1.0f, 1.0f, 1.0f, 0.0f));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_doors_color", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_doors", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_floor_color", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_i_tafel", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[3]));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_state", 1.0f);
            } else if (this.ambientPackage == 2) {
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_doors_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_dash_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_floor_color", new colorRGBAf(1.0f, 1.0f, 1.0f, this.colorBrightness[1]));
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_miko", new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_doors", new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, "ContourLight_i_tafel", new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
                this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_state", 1.0f);
            }
        } else {
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_doors_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[0]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_floor_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[1]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_border_color", new colorRGBAf(this.contourLightColor[0], this.contourLightColor[1], this.contourLightColor[2], this.colorBrightness[2]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_dash_color", new colorRGBAf(this.ambientLightColor[0], this.ambientLightColor[1], this.ambientLightColor[2], this.colorBrightness[3]));
            this.propertyCache.setProperty((INode)ambientLightNode, "AmbientLight_state", 1.0f);
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setDriveSelectDDBOpen %1", bl);
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
        abstractAnimation.startDynamicAnimation(0.0f, 51266, 100, false, this.carViewerController);
    }

    public void setUGDOMode(int n) {
        this.setActiveCarMenuOverlay(46 + n);
    }

    public void setMode(int n) {
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setMode %1", (long)n);
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

    @Override
    public void animationStarted(int n, int n2) {
    }

    @Override
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
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_menue_shift", this.driveSelectDDBOpen ? 1.0f : 0.0f);
            this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_state", this.gyroVisible ? 1.0f : 0.0f);
        }
        this.invalidatePartialRendering();
        this.setOpacity(this.opacity);
    }

    private void calculateTransformationRotation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation2, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation3, float f2) {
        this.calculateCarMenuTransformation(car3DResourceHandler$TranslationRotation, car3DResourceHandler$TranslationRotation2, car3DResourceHandler$TranslationRotation3, f2);
        this.calculateCarMenuLightTransformation(car3DResourceHandler$TranslationRotation, car3DResourceHandler$TranslationRotation2, car3DResourceHandler$TranslationRotation3, f2);
        this.calculateCarMenuEnhancedTransformation(car3DResourceHandler$TranslationRotation, car3DResourceHandler$TranslationRotation2, car3DResourceHandler$TranslationRotation3, f2);
    }

    private void calculateCarMenuTransformation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation2, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation3, float f2) {
        car3DResourceHandler$TranslationRotation3.transX = car3DResourceHandler$TranslationRotation.transX + (car3DResourceHandler$TranslationRotation2.transX - car3DResourceHandler$TranslationRotation.transX) * f2;
        car3DResourceHandler$TranslationRotation3.transY = car3DResourceHandler$TranslationRotation.transY + (car3DResourceHandler$TranslationRotation2.transY - car3DResourceHandler$TranslationRotation.transY) * f2;
        car3DResourceHandler$TranslationRotation3.transZ = car3DResourceHandler$TranslationRotation.transZ + (car3DResourceHandler$TranslationRotation2.transZ - car3DResourceHandler$TranslationRotation.transZ) * f2;
        car3DResourceHandler$TranslationRotation3.rotX = car3DResourceHandler$TranslationRotation.rotX + (car3DResourceHandler$TranslationRotation2.rotX - car3DResourceHandler$TranslationRotation.rotX) * f2;
        car3DResourceHandler$TranslationRotation3.rotY = car3DResourceHandler$TranslationRotation.rotY + (car3DResourceHandler$TranslationRotation2.rotY - car3DResourceHandler$TranslationRotation.rotY) * f2;
        car3DResourceHandler$TranslationRotation3.rotZ = car3DResourceHandler$TranslationRotation.rotZ + (car3DResourceHandler$TranslationRotation2.rotZ - car3DResourceHandler$TranslationRotation.rotZ) * f2;
    }

    private void calculateCarMenuLightTransformation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation2, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation3, float f2) {
        if (carMenuePointLight0 != null) {
            car3DResourceHandler$TranslationRotation3.pointLight0TransX = car3DResourceHandler$TranslationRotation.pointLight0TransX + (car3DResourceHandler$TranslationRotation2.pointLight0TransX - car3DResourceHandler$TranslationRotation.pointLight0TransX) * f2;
            car3DResourceHandler$TranslationRotation3.pointLight0TransY = car3DResourceHandler$TranslationRotation.pointLight0TransY + (car3DResourceHandler$TranslationRotation2.pointLight0TransY - car3DResourceHandler$TranslationRotation.pointLight0TransY) * f2;
            car3DResourceHandler$TranslationRotation3.pointLight0TransZ = car3DResourceHandler$TranslationRotation.pointLight0TransZ + (car3DResourceHandler$TranslationRotation2.pointLight0TransZ - car3DResourceHandler$TranslationRotation.pointLight0TransZ) * f2;
            car3DResourceHandler$TranslationRotation3.attenuationPointLight0 = car3DResourceHandler$TranslationRotation.attenuationPointLight0 + (car3DResourceHandler$TranslationRotation2.attenuationPointLight0 - car3DResourceHandler$TranslationRotation.attenuationPointLight0) * f2;
        }
        if (carMenuePointLight1 != null) {
            car3DResourceHandler$TranslationRotation3.pointLight1TransX = car3DResourceHandler$TranslationRotation.pointLight1TransX + (car3DResourceHandler$TranslationRotation2.pointLight1TransX - car3DResourceHandler$TranslationRotation.pointLight1TransX) * f2;
            car3DResourceHandler$TranslationRotation3.pointLight1TransY = car3DResourceHandler$TranslationRotation.pointLight1TransY + (car3DResourceHandler$TranslationRotation2.pointLight1TransY - car3DResourceHandler$TranslationRotation.pointLight1TransY) * f2;
            car3DResourceHandler$TranslationRotation3.pointLight1TransZ = car3DResourceHandler$TranslationRotation.pointLight1TransZ + (car3DResourceHandler$TranslationRotation2.pointLight1TransZ - car3DResourceHandler$TranslationRotation.pointLight1TransZ) * f2;
            car3DResourceHandler$TranslationRotation3.attenuationPointLight1 = car3DResourceHandler$TranslationRotation.attenuationPointLight1 + (car3DResourceHandler$TranslationRotation2.attenuationPointLight1 - car3DResourceHandler$TranslationRotation.attenuationPointLight1) * f2;
        }
        if (reflectionAdjustmentNode != null) {
            car3DResourceHandler$TranslationRotation3.reflectionAdjustmentTransX = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransX + (car3DResourceHandler$TranslationRotation2.reflectionAdjustmentTransX - car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransX) * f2;
            car3DResourceHandler$TranslationRotation3.reflectionAdjustmentTransY = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransY + (car3DResourceHandler$TranslationRotation2.reflectionAdjustmentTransY - car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransY) * f2;
            car3DResourceHandler$TranslationRotation3.reflectionAdjustmentTransZ = car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransZ + (car3DResourceHandler$TranslationRotation2.reflectionAdjustmentTransZ - car3DResourceHandler$TranslationRotation.reflectionAdjustmentTransZ) * f2;
        }
        if (windowReflectionAdjustmentNode != null) {
            car3DResourceHandler$TranslationRotation3.windowReflectionAdjustmentTransX = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransX + (car3DResourceHandler$TranslationRotation2.windowReflectionAdjustmentTransX - car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransX) * f2;
            car3DResourceHandler$TranslationRotation3.windowReflectionAdjustmentTransY = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransY + (car3DResourceHandler$TranslationRotation2.windowReflectionAdjustmentTransY - car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransY) * f2;
            car3DResourceHandler$TranslationRotation3.windowReflectionAdjustmentTransZ = car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransZ + (car3DResourceHandler$TranslationRotation2.windowReflectionAdjustmentTransZ - car3DResourceHandler$TranslationRotation.windowReflectionAdjustmentTransZ) * f2;
        }
    }

    private void calculateCarMenuEnhancedTransformation(Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation2, Car3DResourceHandler$TranslationRotation car3DResourceHandler$TranslationRotation3, float f2) {
        if (scaleOffsetTranslationNode != null) {
            car3DResourceHandler$TranslationRotation3.enhancedTranslationX = car3DResourceHandler$TranslationRotation.enhancedTranslationX + (car3DResourceHandler$TranslationRotation2.enhancedTranslationX - car3DResourceHandler$TranslationRotation.enhancedTranslationX) * f2;
        }
    }

    private void animateCarMenu() {
        float f2 = this.getCarMenuAnimation().getProgress();
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#animateCarMenu: progress = %1", (double)f2);
        if (this.currentCarMenuIndex == 20) {
            if (f2 < 63) {
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2);
                this.applyTransformationRotation(interpolatedTransRot);
            } else {
                interpolatedTransRot.copyValuesFrom(carMenuEndTransformation);
                this.applyTransformationRotation(carMenuEndTransformation);
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], 2.0f * f2);
            }
        } else if (this.lastCarMenuIndex == 20) {
            if (f2 < 63) {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 2.0f - 2.0f * f2);
                interpolatedTransRot.copyValuesFrom(carMenuStartTransformation);
            } else {
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.lastCarMenuIndex], carMenuOverlayKeys[this.lastCarMenuIndex], 0.0f);
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2 - 1.0f);
                this.applyTransformationRotation(interpolatedTransRot);
            }
        } else if (this.currentCarMenuIndex == 14) {
            if (f2 < 63) {
                this.calculateTransformationRotation(carMenuStartTransformation, carMenuEndTransformation, interpolatedTransRot, 2.0f * f2);
                this.applyTransformationRotation(interpolatedTransRot);
            } else {
                interpolatedTransRot.copyValuesFrom(carMenuEndTransformation);
                this.applyTransformationRotation(carMenuEndTransformation);
                this.propertyCache.setProperty((INode)carMenuOverlayNodes[this.currentCarMenuIndex], carMenuOverlayKeys[this.currentCarMenuIndex], 2.0f * (f2 - 63));
            }
        } else if (this.lastCarMenuIndex == 14) {
            if (f2 < 63) {
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
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "driveSelect_menue_shift", f2);
    }

    private void animateDriveSelectGyro() {
        float f2 = this.getDriveSelectGyroAnimation().getProgress();
        if (!this.gyroVisible) {
            f2 = 1.0f - f2;
        }
        this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "gyro_state", f2);
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
            this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#animateDriveSelectGyroGrid: Grid is set to default position ");
        }
        boolean bl3 = this.gridPosition > (float)gridDefaultPosition;
        boolean bl4 = bl2 = this.gridPosition < (float)gridGyroPosition;
        if (this.carViewerController != null && !this.carViewerController.isLTR()) {
            gridGyroPosition = 2 * gridDefaultPosition;
            bl3 = this.gridPosition < (float)gridDefaultPosition;
            bl2 = this.gridPosition > (float)gridGyroPosition;
        }
        int n = 32959;
        if (!bl && bl3) {
            n = (int)((float)gridDefaultPosition - (float)(gridDefaultPosition - gridGyroPosition) * (1.0f - f2));
        } else if (bl && bl2) {
            n = (int)((float)gridDefaultPosition - (float)(gridDefaultPosition - gridGyroPosition) * f2);
        }
        this.gridPosition = n == 32959 ? (int)this.gridPosition : n;
        this.backgroundNode.setTranslation(this.gridPosition, 0.0f);
        if (this.logChannel3DCar.isDebug()) {
            this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#animateDriveSelectGyroGrid: Grid is moved to x:  %1, progress: %2", (Object)String.valueOf(this.gridPosition), (Object)String.valueOf(f2));
        }
    }

    private void animateDriveSelectPHEV() {
        INode3D iNode3D;
        float f2 = this.getDriveSelectGyroAnimation().getProgress();
        if (this.gyroVisible) {
            f2 = 1.0f - f2;
        }
        if ((iNode3D = this.getNode3D("driveSelect_Controls")) != null && this.terminal.getCarCodingHelper().isPHEVCar()) {
            this.propertyCache.setProperty((INode)iNode3D, "phev_state", f2);
            iNode3D.dispose();
        }
    }

    @Override
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setViewSizeTargetChanged: stage = %1", (long)n);
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setViewSizeAnimationFinished: stage = %1", (long)n);
        this.setSmallStagePositionPercentage(n == 0 ? 0.0f : 1.0f);
        if (this.currentMode == 1) {
            this.setFXAAEnabled(1, FXAA_STILL);
        }
    }

    private void setDriveSelectSmallStagePercentage(float f2) {
        this.invalidatePartialRendering();
    }

    public void setSmallStagePositionPercentage(float f2) {
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#setSmallStagePositionPercentage: %1", (double)f2);
        if (!this.resourcesLoaded()) {
            return;
        }
        if (this.currentMode == 1) {
            if (this.selectedDriveSelectProfile == 8) {
                this.propertyCache.setProperty((INode)this.driveSelectPropertyHolderNode, "KB_Position", f2);
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#stopAnimations");
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
        this.logChannel3DCar.log(-2137614336, "Car3DResourceHandler#initializeCarPHEVHanlder");
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    static {
        DEBUG_OUTPUT = false;
        MAX_ANIMATION_TIME = Integer.valueOf(System.getProperty("3DCarMaxAnimationTime", "700"));
        MIN_ANIMATION_TIME = Integer.valueOf(System.getProperty("3DCarMinAnimationTime", "100"));
        OVERWRITE_FXAA = System.getProperty("3DCarFXAA") != null;
        OVERWRITE_FXAA_VALUE = Boolean.getBoolean("3DCarFXAA");
        OVERWRITE_SUPERSAMPLING = System.getProperty("3DCarSuperSamplingRate") != null;
        OVERWRITE_SUPERSAMPLING_RATE = Float.valueOf(System.getProperty("3DCarSuperSamplingRate", "0.0")).floatValue();
        SUPERSAMPLING_RATE_ANIMATED = OVERWRITE_SUPERSAMPLING ? OVERWRITE_SUPERSAMPLING_RATE : (float)49215;
        SUPERSAMPLING_RATE_STILL = OVERWRITE_SUPERSAMPLING ? OVERWRITE_SUPERSAMPLING_RATE : 2.0f;
        FXAA_STILL = OVERWRITE_FXAA ? OVERWRITE_FXAA_VALUE : true;
        FXAA_ANIMATED = OVERWRITE_FXAA ? OVERWRITE_FXAA_VALUE : false;
        WIDGET_ID_MAPPING_LHD = new String[]{"ACC", "Ambientebeleuchtung", "AmbientlightWizard", "Ambientebeleuchtung", "AmbientlightWizard", "AmbientlightWizard", "Aussenbeleuchtung", "Belegung_Lenkradtaste", "Einparkhilfe", "Fahrerassistenz", "Fahrzeugeinstellungen", "Fahrzeuginfo", "Klima", "Lane_Assist", "Oelstand", "Pausenempfehlung", "Audi_Pre_Sense", "Regensensor", "Reifendruckkontrolle", "Service_Kontrolle", "Serviceintervalle", "Audi_Sideassist", "Sitze", "Tempowarnung", "Umluftautomatik", "Verkehrszeichen", "Wischerwechsel", "Zentralverriegelung", "Zuheizer", "0_Default_Position", "Luftfeder_Anhaenger", "Nachtsichtassistenz", "HUD", "AdBlue", "Abstandwarner", "Anhaengermodus", "Fussraumtemperatur", "Stauassistenz", "Verbrauchstatistik", "Garagentoroeffner", "Luftfeder_Radwechsel", "PEA", "0_Default_Position", "KB_Position", "Sitzheizung", "Sitzlueftung", "Garagentor_Anlernen_Scheinwerfer_Links", "Garagentor_Anlernen_Audiringe", "Garagentor_Anlernen_Scheinwerfer_Rechts", "Garagentor_Anlernen_Innenspiegel", "Feedback_Fahrpedal", "Datum_Uhrzeit", "Fahrschulmodus"};
        firstTime = true;
        resourcesLoaded = false;
    }
}

