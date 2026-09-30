/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.handler.DefaultMenuModelHandler;
import de.audi.app.car.common.handler.DefaultRange2DModelHandler;
import de.audi.app.car.common.handler.DefaultRangeModelHandler;
import de.audi.app.car.core.light.AbstractDSICarLightAdapter;
import de.audi.app.car.core.light.IntLightAmbientColorRangeModelEventBusiness;
import de.audi.app.car.core.light.IntLightChoiceEventBusiness;
import de.audi.app.car.core.light.IntLightChoiceModelHandler;
import de.audi.app.car.core.light.IntLightColorListBusiness;
import de.audi.app.car.core.light.IntLightCountourColorRangeModelEventBusiness;
import de.audi.app.car.core.light.IntLightCurrentFocus;
import de.audi.app.car.core.light.IntLightIndividualBrightnessRangeBusiness;
import de.audi.app.car.core.light.IntLightIndividualRangeModelHandler;
import de.audi.app.car.core.light.IntLightMenuEventBusiness;
import de.audi.app.car.core.light.IntLightRange2DBusiness;
import de.audi.app.car.core.light.IntLightRangeEventBusiness;
import de.audi.app.car.core.light.IntLightRangeModelHandler;
import de.audi.app.car.core.light.IntLightSetEvaluator;
import de.audi.app.car.core.light.IntLightSingleRotaryBusiness;
import de.audi.atip.hmi.model.list.BaseListModel;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractIntLightComponent
extends AbstractDSICarLightAdapter {
    private static final int RANGE_2D_STEP_Y_5 = 5;
    private static final int RANGE_2D_STEP_X = 1;
    private static final int PROFILE_RANGE_2D_MAX_NUMBER = 8;
    private static final int PROFILE_RANGE_2D_MIN_NUMBER = 0;
    private static final int BRIGHTNESS_ROTARY_STEP_5 = 5;
    private static final int BRIGHTNESS_MIN_VALUE = 0;
    private static final int BRIGHTNESS_MAX_VALUE = 100;
    public static final short CODING_ID = 1;
    protected static final String LOGCHANNEL_NAME = "App.Car.IntLight";
    protected volatile IntLightViewOptions currentViewOptions;
    private IntLightChoiceModelHandler choiceHandler;
    protected IntLightRangeModelHandler rangeHandler;
    protected IntLightSetEvaluator intLightSetEvaluator = null;
    private IntLightIndividualRangeModelHandler[] individualBrightnessRangeHandlers = null;
    private IntLightIndividualRangeModelHandler footWellBrightnessRangeModelHandler;
    private IntLightIndividualRangeModelHandler cockpitBrightnessRangeModelHandler;
    private IntLightIndividualRangeModelHandler doorsBrightnessRangeModelHandler;
    private IntLightIndividualRangeModelHandler sunRoofBrightnessRangeModelHandler;
    private IntLightIndividualRangeModelHandler contoursBrightnessRangeModelHandler;
    private IntLightIndividualRangeModelHandler surfaceBrightnessRangeModelHandler;
    private DefaultRangeModelHandler ambientColorRangeModelHandler;
    private DefaultRangeModelHandler contourColorRangeModelHandler;
    private DefaultMenuModelHandler menuModelHandler;
    protected DefaultRange2DModelHandler range2DModelHandler;
    private DefaultRangeModelHandler singleRotaryHandler;
    private IntLightAmbientColorRangeModelEventBusiness ambientColorBusiness = null;
    private IntLightCountourColorRangeModelEventBusiness contourColorBusiness = null;
    protected IntLightColorListBusiness ambientColorListBusiness = null;
    private IntLightColorListBusiness contourColorListBusiness = null;
    private IntLightIndividualBrightnessRangeBusiness cockpitBrightnessBusiness = null;
    private IntLightIndividualBrightnessRangeBusiness countourBrightnessBusiness = null;
    private IntLightIndividualBrightnessRangeBusiness doorBrightnessBusiness = null;
    private IntLightIndividualBrightnessRangeBusiness footwellBrightnessBusiness = null;
    private IntLightIndividualBrightnessRangeBusiness roofBrightnessBusiness = null;
    private IntLightMenuEventBusiness menuEventBusiness = null;
    protected IntLightRange2DBusiness range2DBusiness = null;
    protected IntLightSingleRotaryBusiness singleRotaryBusiness = null;
    private Object colorListMutex = new Object();
    private int numberOfColors = 0;
    private int numberOfTransmittableColorElements = 0;
    private IntLightRGBColorListRA0[] colorData = null;
    private IntLightRGBColorListRA0[] lastReceivedColorArray = null;
    private IntLightRGBColorListUpdateInfo latestRGBColorListUpdateInfo = null;
    private int lastPos = -1;
    private Object mutex = new Object();
    private boolean profileMode = false;
    private boolean singleRotaryProfileMode = false;
    protected boolean inOneBrightnessScreen = false;
    private int singleRotarySetNum = 0;
    private int[] profileNameMapping = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    protected BaseListModel ambientColorListModel;
    private BaseListModel contourColorListModel;
    private IntLightIndividualBrightnessRangeBusiness surfaceBrightnessBusiness;

    public AbstractIntLightComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.choiceHandler = new IntLightChoiceModelHandler(this.getChoiceModel(600772), this.getLogChannel());
        this.rangeHandler = new IntLightRangeModelHandler(this.getRangeModel(600945), this.getLogChannel());
        this.footWellBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(600778), this.getLogChannel());
        this.cockpitBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(600779), this.getLogChannel());
        this.doorsBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(600777), this.getLogChannel());
        this.sunRoofBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(600780), this.getLogChannel());
        this.contoursBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(600775), this.getLogChannel());
        this.surfaceBrightnessRangeModelHandler = new IntLightIndividualRangeModelHandler(this.getRangeModel(602075), this.getLogChannel());
        this.ambientColorRangeModelHandler = new DefaultRangeModelHandler(this.getRangeModel(600774), this.getLogChannel());
        this.contourColorRangeModelHandler = new DefaultRangeModelHandler(this.getRangeModel(600776), this.getLogChannel());
        this.footWellBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.cockpitBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.doorsBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.sunRoofBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.contoursBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.surfaceBrightnessRangeModelHandler.updateRangeModelLimits(0, 100, this.getIndividualBrightnessStepWidth());
        this.singleRotaryHandler = new DefaultRangeModelHandler(this.getRangeModel(600963), this.getLogChannel());
        this.singleRotaryHandler.updateRangeModelLimits(0, 100, 5);
        this.menuModelHandler = new DefaultMenuModelHandler(this.getMenuModel(601075), this.getLogChannel());
        this.range2DModelHandler = new DefaultRange2DModelHandler(this.getRange2DModel(601073), this.getLogChannel());
        this.range2DModelHandler.updateRangeModel2DLimits(0, 8, 1, 0, 100, 5);
        this.range2DModelHandler.updateRangeModelValueX(0);
        this.range2DModelHandler.updateRangeModelValueY(50);
        this.ambientColorListModel = (BaseListModel)this.getBaseListModel(601211);
        this.contourColorListModel = (BaseListModel)this.getBaseListModel(601212);
    }

    protected abstract int getIndividualBrightnessStepWidth();

    protected void deinitModels() {
        this.choiceHandler.deinitModel();
        this.rangeHandler.deinitModel();
        this.footWellBrightnessRangeModelHandler.deinitModel();
        this.cockpitBrightnessRangeModelHandler.deinitModel();
        this.doorsBrightnessRangeModelHandler.deinitModel();
        this.sunRoofBrightnessRangeModelHandler.deinitModel();
        this.contoursBrightnessRangeModelHandler.deinitModel();
        this.ambientColorRangeModelHandler.deinitModel();
        this.contourColorRangeModelHandler.deinitModel();
        this.surfaceBrightnessRangeModelHandler.deinitModel();
        this.menuModelHandler.deinitModel();
        this.range2DModelHandler.deinitModel();
        this.singleRotaryHandler.deinitModel();
        this.ambientColorListBusiness.deinit();
        this.contourColorListBusiness.deinit();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void initBusiness() {
        IntLightCurrentFocus intLightCurrentFocus = new IntLightCurrentFocus();
        this.choiceHandler.setBusiness(new IntLightChoiceEventBusiness(this.getDSI(), this.getLogChannel()));
        this.rangeHandler.setBusiness(new IntLightRangeEventBusiness(this.getDSI(), this.getLogChannel()));
        this.range2DBusiness = new IntLightRange2DBusiness(intLightCurrentFocus, this.getDSI(), this.getLogChannel());
        Object object = this.mutex;
        synchronized (object) {
            this.ambientColorBusiness = new IntLightAmbientColorRangeModelEventBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.contourColorBusiness = new IntLightCountourColorRangeModelEventBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.contourColorListBusiness = new IntLightColorListBusiness(this.getDSI(), this.getLogChannel(), this.contourColorListModel);
            this.cockpitBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.countourBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.doorBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.footwellBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.roofBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            this.surfaceBrightnessBusiness = new IntLightIndividualBrightnessRangeBusiness(this.getDSI(), this.profileMode, this.getLogChannel());
            RangeModelApp rangeModelApp = this.getRangeModel(600963);
            this.singleRotaryBusiness = new IntLightSingleRotaryBusiness(this.getDSI(), this.singleRotaryProfileMode, this.singleRotarySetNum, rangeModelApp, new AllSetSyncHandler(), this.getLogChannel());
        }
        this.menuEventBusiness = new IntLightMenuEventBusiness(intLightCurrentFocus, this.getDSI(), this.getLogChannel());
        this.footWellBrightnessRangeModelHandler.setBusiness(this.footwellBrightnessBusiness);
        this.cockpitBrightnessRangeModelHandler.setBusiness(this.cockpitBrightnessBusiness);
        this.doorsBrightnessRangeModelHandler.setBusiness(this.doorBrightnessBusiness);
        this.sunRoofBrightnessRangeModelHandler.setBusiness(this.roofBrightnessBusiness);
        this.contoursBrightnessRangeModelHandler.setBusiness(this.countourBrightnessBusiness);
        this.ambientColorRangeModelHandler.setBusiness(this.ambientColorBusiness);
        this.contourColorRangeModelHandler.setBusiness(this.contourColorBusiness);
        this.surfaceBrightnessRangeModelHandler.setBusiness(this.surfaceBrightnessBusiness);
        this.menuModelHandler.setBusiness(this.menuEventBusiness);
        this.range2DModelHandler.setBusiness(this.range2DBusiness);
        this.singleRotaryHandler.setBusiness(this.singleRotaryBusiness);
        this.setIlluminationSetNumbnersToBusiness();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightViewOptions: intLightViewOptions=%1", (Object)this.limitViewOptionOutput(intLightViewOptions));
            }
            this.currentViewOptions = intLightViewOptions;
            this.intLightSetEvaluator = new IntLightSetEvaluator(intLightViewOptions, this.getLogChannel());
            this.setIlluminationSetNumbnersToBusiness();
            this.individualBrightnessRangeHandlers = new IntLightIndividualRangeModelHandler[9];
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getFootwellFrontRearSetNumber()] = this.footWellBrightnessRangeModelHandler;
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getCockpitSetNumber()] = this.cockpitBrightnessRangeModelHandler;
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getDoorsFrontRearSetNumber()] = this.doorsBrightnessRangeModelHandler;
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getSunRoofSetNumber()] = this.sunRoofBrightnessRangeModelHandler;
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getContourSetNumber()] = this.contoursBrightnessRangeModelHandler;
            this.individualBrightnessRangeHandlers[this.intLightSetEvaluator.getSurfaceSetSetNumber()] = this.surfaceBrightnessRangeModelHandler;
            this.updateMenuEntryVisibility(this.currentViewOptions, this.intLightSetEvaluator);
            this.setConfigForProfileNameMapping(this.currentViewOptions.getIntLightConfig());
            Object object = this.colorListMutex;
            synchronized (object) {
                this.numberOfTransmittableColorElements = intLightViewOptions.getIntLightConfig().getRgbColorListTransmittableElements().getRa0();
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void setConfigForProfileNameMapping(IntLightConfig intLightConfig) {
        if (intLightConfig == null) {
            this.getLogChannel().log(1000000, "IntLightConfig is null, use default profile mapping");
            return;
        }
        this.profileNameMapping[1] = intLightConfig.getSetupIlluminationProfile1();
        this.profileNameMapping[2] = intLightConfig.getSetupIlluminationProfile2();
        this.profileNameMapping[3] = intLightConfig.getSetupIlluminationProfile3();
        this.profileNameMapping[4] = intLightConfig.getSetupIlluminationProfile4();
        this.profileNameMapping[5] = intLightConfig.getSetupIlluminationProfile5();
        this.profileNameMapping[6] = intLightConfig.getSetupIlluminationProfile6();
        this.profileNameMapping[7] = intLightConfig.getSetupIlluminationProfile7();
        this.profileNameMapping[8] = intLightConfig.getSetupIlluminationProfile8();
        this.range2DBusiness.setProfileMapping(this.profileNameMapping);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightRGBColorListTotalNumberOfElements: numberOfElementss=%1, validFlag=%2", (long)n, (long)n2);
            }
            Object object = this.colorListMutex;
            synchronized (object) {
                this.numberOfColors = n;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightRGBColorListUpdateInfo: infos=%1, validFlag=%2", (Object)intLightRGBColorListUpdateInfo, (long)n);
            }
            Object object = this.colorListMutex;
            synchronized (object) {
                this.latestRGBColorListUpdateInfo = intLightRGBColorListUpdateInfo;
            }
            this.initIntLightColorListRequest();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        if (intLightRGBColorListRA0Array != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightRGBColorListUpdateInfo: responseIntLightRGBColorListRA0=%1, number of records=%2", (Object)intLightRGBColorListUpdateInfo, (long)intLightRGBColorListRA0Array.length);
            }
            if (intLightRGBColorListUpdateInfo.getArrayContent() == 1 || intLightRGBColorListUpdateInfo.getArrayContent() == 2) {
                Object object = this.colorListMutex;
                synchronized (object) {
                    this.lastReceivedColorArray = intLightRGBColorListRA0Array;
                }
                this.manageColorData();
            } else if (intLightRGBColorListUpdateInfo.getArrayContent() == 3 || intLightRGBColorListUpdateInfo.getArrayContent() == 0 || intLightRGBColorListUpdateInfo.getArrayContent() == 4 || intLightRGBColorListUpdateInfo.getArrayContent() == 5 || intLightRGBColorListUpdateInfo.getArrayContent() == 6) {
                this.getLogChannel().log(1000000, "no msc defined for arraycontent = %1", (long)intLightRGBColorListUpdateInfo.getArrayContent());
            }
        } else {
            this.getLogChannel().log(1000000, "updateIntLightRGBColorListUpdateInfo: responseIntLightRGBColorListRA0=%1, IntLightRGBColorListRA0[]=null", (Object)intLightRGBColorListUpdateInfo);
        }
    }

    public void updateIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightAmbientLightColor: color=%1, validFlag=%2", (Object)intLightRGBValues, (long)n);
            }
            this.ambientColorListBusiness.setSelectedColor(intLightRGBValues);
            int n2 = this.ambientColorListBusiness.getColorDataIndex(intLightRGBValues);
            if (n2 >= 0) {
                this.ambientColorRangeModelHandler.updateRangeModelValue(n2);
                this.ambientColorListBusiness.setValidSelectedIndex(n2);
            }
        }
    }

    public void updateIntLightContourLightColor(IntLightRGBValues intLightRGBValues, int n) {
        if (n == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightContourLightColor: color=%1, validFlag=%2", (Object)intLightRGBValues, (long)n);
            }
            this.contourColorListBusiness.setSelectedColor(intLightRGBValues);
            int n2 = this.contourColorListBusiness.getColorDataIndex(intLightRGBValues);
            if (n2 >= 0) {
                this.getLogChannel().log(1000000, "updateIntLightContourLightColor: found colorIndex=%1", (long)n2);
                this.contourColorRangeModelHandler.updateRangeModelValue(n2);
                this.contourColorListBusiness.setValidSelectedIndex(n2);
            }
        }
    }

    public void updateIntLightIlluminationSet1(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet1: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(1, n);
        }
    }

    public void updateIntLightIlluminationSet2(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet2: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(2, n);
        }
    }

    public void updateIntLightIlluminationSet3(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet3: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(3, n);
        }
    }

    public void updateIntLightIlluminationSet4(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet4: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(4, n);
        }
    }

    public void updateIntLightIlluminationSet5(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet5: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(5, n);
        }
    }

    public void updateIntLightIlluminationSet6(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet6: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(6, n);
        }
    }

    public void updateIntLightIlluminationSet7(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet7: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(7, n);
        }
    }

    public void updateIntLightIlluminationSet8(int n, int n2) {
        if (n2 == 1) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateIntLightIlluminationSet8: brightness=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.processIlluminationSetUpdate(8, n);
        }
    }

    public void updateIntLightActiveProfile(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightActiveProfile: profile=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.choiceHandler.updateChoiceModelValue(n);
            this.rangeHandler.setSelectedProfile(n);
            this.range2DModelHandler.getRange2DModel().forceUpdate(true);
            this.range2DModelHandler.updateRange2DModelValue(this.rangeHandler.getSelectedProfile(), this.rangeHandler.getSelectedProfilesValue());
            this.getChoiceModel(601129).setValue(n - 1);
        }
    }

    public void updateIntLightIlluminationProfile1(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile1: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(1, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 1) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile2(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile2: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(2, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 2) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile3(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile3: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(3, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 3) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile4(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile4: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(4, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 4) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile5(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile5: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(5, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 5) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile6(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile6: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(6, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 6) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile7(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile7: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(7, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 7) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightIlluminationProfile8(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightIlluminationProfile8: brightness=%1, validFlag=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            this.rangeHandler.setBrightness(8, n);
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 8) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(n);
            }
            if (this.singleRotaryProfileMode && this.singleRotarySetNum == 0) {
                this.singleRotaryBusiness.getWatcherTimer().setValidValue(n);
            }
        }
    }

    public void updateIntLightBrightness(IntLightBrightness intLightBrightness, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateIntLightBrightness: intLightBrightness=%1, validFlag=%2", (Object)intLightBrightness, (long)n);
        }
        if (n == 1 && intLightBrightness != null) {
            this.rangeHandler.setBrightness(0, intLightBrightness.getBrightness());
            if (this.range2DModelHandler.getRange2DModel().getValueX() == 8) {
                this.range2DModelHandler.getRange2DModel().forceUpdate(false);
                this.range2DModelHandler.updateRangeModelValueY(intLightBrightness.getBrightness());
            }
            this.singleRotaryHandler.updateRangeModelValue(intLightBrightness.getBrightness());
        }
    }

    protected IntLightSetEvaluator getIntLightSetEvaluator() {
        return this.intLightSetEvaluator;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setProfilesMode(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            this.profileMode = bl;
            if (this.cockpitBrightnessBusiness != null) {
                this.cockpitBrightnessBusiness.setProfilesMode(bl);
            }
            if (this.countourBrightnessBusiness != null) {
                this.countourBrightnessBusiness.setProfilesMode(bl);
            }
            if (this.doorBrightnessBusiness != null) {
                this.doorBrightnessBusiness.setProfilesMode(bl);
            }
            if (this.footwellBrightnessBusiness != null) {
                this.footwellBrightnessBusiness.setProfilesMode(bl);
            }
            if (this.roofBrightnessBusiness != null) {
                this.roofBrightnessBusiness.setProfilesMode(bl);
            }
            if (this.ambientColorBusiness != null) {
                this.ambientColorBusiness.setProfilesMode(bl);
            }
            if (this.contourColorBusiness != null) {
                this.contourColorBusiness.setProfilesMode(bl);
            }
            if (this.surfaceBrightnessBusiness != null) {
                this.surfaceBrightnessBusiness.setProfilesMode(bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setSingleRotaryMode(boolean bl, int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.singleRotaryProfileMode = bl;
            this.singleRotarySetNum = n;
            if (this.singleRotaryBusiness != null) {
                this.singleRotaryBusiness.activateProfile1Mode(bl);
                this.singleRotaryBusiness.activateSetMode(n);
            }
        }
    }

    protected abstract void updateMenuEntryVisibility(IntLightViewOptions var1, IntLightSetEvaluator var2);

    public String getName() {
        return "IntLight";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{50, 49, 45, 37, 38, 39, 40, 41, 42, 43, 44, 29, 30, 31, 32, 33, 34, 35, 36, 46, 47, 27})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    private void setIlluminationSetNumbnersToBusiness() {
        if (this.intLightSetEvaluator != null) {
            if (this.cockpitBrightnessBusiness != null) {
                this.cockpitBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getCockpitSetNumber());
            }
            if (this.countourBrightnessBusiness != null) {
                this.countourBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getContourSetNumber());
            }
            if (this.doorBrightnessBusiness != null) {
                this.doorBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getDoorsFrontRearSetNumber());
            }
            if (this.footwellBrightnessBusiness != null) {
                this.footwellBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getFootwellFrontRearSetNumber());
            }
            if (this.roofBrightnessBusiness != null) {
                this.roofBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getSunRoofSetNumber());
            }
            if (this.surfaceBrightnessBusiness != null) {
                this.surfaceBrightnessBusiness.setIlluminationSetNumber(this.intLightSetEvaluator.getSurfaceSetSetNumber());
            }
        }
    }

    private synchronized void processIlluminationSetUpdate(int n, int n2) {
        if (this.individualBrightnessRangeHandlers != null && this.individualBrightnessRangeHandlers[n] != null) {
            this.individualBrightnessRangeHandlers[n].updateRangeModelValue(n2);
        }
        if (this.singleRotarySetNum != 0 && this.singleRotarySetNum == n && this.singleRotaryBusiness != null) {
            this.singleRotaryBusiness.getWatcherTimer().setValidValue(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initIntLightColorListRequest() {
        Object object = this.colorListMutex;
        synchronized (object) {
            if (this.numberOfTransmittableColorElements != 0 && this.latestRGBColorListUpdateInfo != null && this.checkViewOption(this.currentViewOptions.getIntLightRGBColorList())) {
                IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(this.latestRGBColorListUpdateInfo.getArrayContent(), 0, 0, this.numberOfTransmittableColorElements, 1);
                this.requestColorList(intLightRGBColorListUpdateInfo);
            }
        }
    }

    private boolean checkViewOption(CarViewOption carViewOption) {
        if (carViewOption != null) {
            return carViewOption.getState() == 2;
        }
        return false;
    }

    private void requestColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "calling DSI: requestIntLightRGBColorLis( %1 )", (Object)intLightRGBColorListUpdateInfo);
        }
        this.getDSI().requestIntLightRGBColorList(intLightRGBColorListUpdateInfo);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void manageColorData() {
        Object object = this.colorListMutex;
        synchronized (object) {
            if (this.colorData == null && this.numberOfColors > 0) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "creating local color-array with number of entries = %1 ", (long)this.numberOfColors);
                }
                this.colorData = new IntLightRGBColorListRA0[this.numberOfColors];
            }
            this.getLogChannel().log(10000000, "[AbstractIntLightComponent.manageColorData] colorData: %1, numberOfColors: %2, lastReceivedColorArray: %3", (Object)this.colorData, (Object)new Integer(this.numberOfColors), (Object)this.lastReceivedColorArray);
            if (this.colorData != null && this.lastReceivedColorArray != null) {
                int n;
                ++this.lastPos;
                for (n = 0; n < this.lastReceivedColorArray.length; ++n) {
                    this.getLogChannel().log(10000000, "[AbstractIntLightComponent.manageColorData] lastPos: %1, colorData.length: %2, lastReceivedColorArray[%4]: %3", (Object)new Integer(this.lastPos), (Object)new Integer(this.colorData.length), (Object)this.lastReceivedColorArray[n], (long)n);
                    if (this.lastReceivedColorArray[n] != null && this.lastPos < this.colorData.length) {
                        IntLightRGBColorListRA0 intLightRGBColorListRA0 = this.lastReceivedColorArray[n];
                        this.colorData[this.lastPos + n] = new IntLightRGBColorListRA0(intLightRGBColorListRA0.getPos(), intLightRGBColorListRA0.getValues());
                        continue;
                    }
                    if (this.lastReceivedColorArray[n] != null) {
                        this.getLogChannel().log(100000, "trying to add IntLightRGBColorListRA0 with pos = %1 and numberOfColors = %2", (long)this.lastReceivedColorArray[n].getPos(), (long)this.numberOfColors);
                        continue;
                    }
                    this.getLogChannel().log(100000, "trying to add null IntLightRGBColorListRA0");
                }
                this.lastPos += this.lastReceivedColorArray.length - 1;
                this.lastReceivedColorArray = null;
                if (this.lastPos < this.numberOfColors - 1) {
                    n = this.numberOfColors - (this.lastPos + 1);
                    int n2 = n < this.numberOfTransmittableColorElements ? n : this.numberOfTransmittableColorElements;
                    IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo = new IntLightRGBColorListUpdateInfo(2, 0, this.lastPos, n2, this.latestRGBColorListUpdateInfo.getTransactionID() + 1);
                    this.requestColorList(intLightRGBColorListUpdateInfo);
                } else {
                    this.getLogChannel().log(10000000, "[AbstractIntLightComponent.manageColorData] Fill BaseListModel");
                    this.ambientColorRangeModelHandler.updateRangeModelLimits(1, this.colorData.length, 1);
                    this.contourColorRangeModelHandler.updateRangeModelLimits(1, this.colorData.length, 1);
                    this.ambientColorListBusiness.fillBaseListModels(this.colorData);
                    this.contourColorListBusiness.fillBaseListModels(this.colorData);
                    n = this.ambientColorListBusiness.getValidSelectedIndex();
                    this.ambientColorRangeModelHandler.updateRangeModelValue(n);
                    int n3 = this.contourColorListBusiness.getValidSelectedIndex();
                    this.contourColorRangeModelHandler.updateRangeModelValue(n3);
                    this.lastReceivedColorArray = null;
                    this.lastPos = -1;
                }
            }
        }
    }

    private String limitViewOptionOutput(IntLightViewOptions intLightViewOptions) {
        Buffer buffer = new Buffer(1500);
        buffer.append("Config.Profiles: ").append(intLightViewOptions.intLightConfig.setupIlluminationProfile1).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile2).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile3).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile4).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile5).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile6).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile7).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationProfile8).append("\n");
        buffer.append("Config.Set ").append(intLightViewOptions.intLightConfig.setupIlluminationSet1).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet2).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet3).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet4).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet5).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet6).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet7).append("|").append(intLightViewOptions.intLightConfig.setupIlluminationSet8).append("\n");
        buffer.append(intLightViewOptions.intLightConfig.getRgbColorListTransmittableElements());
        buffer.append("ViewOptions: \n");
        buffer.append("intLightActiveProfile: ").append(intLightViewOptions.intLightActiveProfile).append("\n");
        buffer.append("intLightIlluminationProfile1: ").append(intLightViewOptions.intLightIlluminationProfile1);
        buffer.append("intLightIlluminationProfile2: ").append(intLightViewOptions.intLightIlluminationProfile2).append("\n");
        buffer.append("intLightIlluminationProfile3: ").append(intLightViewOptions.intLightIlluminationProfile3);
        buffer.append("intLightIlluminationProfile4: ").append(intLightViewOptions.intLightIlluminationProfile4).append("\n");
        buffer.append("intLightIlluminationProfile5: ").append(intLightViewOptions.intLightIlluminationProfile5);
        buffer.append("intLightIlluminationProfile6: ").append(intLightViewOptions.intLightIlluminationProfile6).append("\n");
        buffer.append("intLightIlluminationProfile7: ").append(intLightViewOptions.intLightIlluminationProfile7);
        buffer.append("intLightIlluminationProfile8: ").append(intLightViewOptions.intLightIlluminationProfile8).append("\n");
        buffer.append("intLightIlluminationSet1: ").append(intLightViewOptions.intLightIlluminationSet1);
        buffer.append("intLightIlluminationSet2: ").append(intLightViewOptions.intLightIlluminationSet2).append("\n");
        buffer.append("intLightIlluminationSet3: ").append(intLightViewOptions.intLightIlluminationSet3);
        buffer.append("intLightIlluminationSet4: ").append(intLightViewOptions.intLightIlluminationSet4).append("\n");
        buffer.append("intLightIlluminationSet5: ").append(intLightViewOptions.intLightIlluminationSet5);
        buffer.append("intLightIlluminationSet6: ").append(intLightViewOptions.intLightIlluminationSet6).append("\n");
        buffer.append("intLightIlluminationSet7: ").append(intLightViewOptions.intLightIlluminationSet7);
        buffer.append("intLightIlluminationSet8: ").append(intLightViewOptions.intLightIlluminationSet8).append("\n");
        buffer.append("intLightRGBColorList: ").append(intLightViewOptions.intLightRGBColorList);
        buffer.append("intLightAmbientLightColor: ").append(intLightViewOptions.intLightAmbientLightColor).append("\n");
        buffer.append("intLightContourLightColor: ").append(intLightViewOptions.intLightContourLightColor);
        return buffer.toString();
    }

    class AllSetSyncHandler {
        AllSetSyncHandler() {
        }

        protected void triggerAllSetSync(boolean bl) {
            if (AbstractIntLightComponent.this.intLightSetEvaluator.hasAllSetsSyncSet() && AbstractIntLightComponent.this.inOneBrightnessScreen && !bl) {
                int n = AbstractIntLightComponent.this.singleRotaryHandler.getRangeModel().getValue();
                if (AbstractIntLightComponent.this.getIntLightSetEvaluator() != null) {
                    int n2 = AbstractIntLightComponent.this.getIntLightSetEvaluator().getAllSetsSyncSetNumber();
                    AbstractIntLightComponent.this.getLogChannel().log(1000000, "[IntLightSingleRotaryBusiness: sync: dsi.setIntLightIlluminationSet(%1, %2)]", (long)n2, (long)n);
                    AbstractIntLightComponent.this.getDSI().setIntLightIlluminationSet(n2, n);
                }
            }
        }
    }
}

