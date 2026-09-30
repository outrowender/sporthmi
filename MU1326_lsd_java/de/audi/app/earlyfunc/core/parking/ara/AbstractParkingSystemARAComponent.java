/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ara;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import de.audi.app.earlyfunc.core.parking.ara.ARAMessageHandler;
import de.audi.app.earlyfunc.core.parking.ara.IARAMessageHandler;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.ITestSupportHandler;
import de.audi.atip.testsupport.handler.ITestSupportHandlerNotification;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.ARATrailerConfiguration;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSystemARAComponent
extends AbstractParkingSystemComponent
implements RangeListener,
ChoiceListener,
ITestSupportHandlerNotification {
    private IARAMessageHandler messageHandler;
    private volatile ARACurrentTrailerAngle currentAngle = new ARACurrentTrailerAngle();
    private volatile int currentTargetAngle;
    private volatile int currentMaxAngle;
    private volatile ARAInfo currentARAInfo;
    private int[] tickToDegreeMappingIncreasing;
    private int[] tickToDegreeMappingDecreasing;
    private ITestSupportHandler testSupportHandler;
    private String[] testSupportData = new String[]{"", "", "", "", "", "", "", ""};
    private volatile boolean testSupportVisible = false;
    private BaseListModelApp araDataModel;
    private static final int ARA_DATA_LISTMODEL_LENGTH = 10;
    private static final int ARA_ROW_CURRENT_ANGLE = 0;
    private static final int ARA_ROW_CURRENT_ANGLE_AVAILABLE = 1;
    private static final int ARA_ROW_TARGET_ANGLE = 2;
    private static final int ARA_ROW_TARGET_ANGLE_AVAILABLE = 3;
    private static final int ARA_ROW_HAZINESS_ANGLE = 4;
    private static final int ARA_ROW_HAZINESS_ANGLE_AVAILABLE = 5;
    private static final int ARA_ROW_MAX_ANGLE = 6;
    private static final int ARA_ROW_MAX_ANGLE_AVAILABLE = 7;
    private static final int ARA_ROW_INSTANT_ANGLE = 8;
    private static final int ARA_ROW_INSTANT_ANGLE_AVAILABLE = 9;
    private static final int ARA_POPUP_STATE_INACTIVE = 0;
    private static final int ARA_POPUP_STATE_ACTIVE_HMI = 1;
    private static final int ARA_POPUP_STATE_ACTIVE_VPS = 2;
    private static final int MAX_ANGLE_FALLBACK = 85;
    private static final int INVALID_VALUE = 255;

    public AbstractParkingSystemARAComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController) {
        super(iCarApplication, iParkingSystemController, "App.EarlyFunc.Parking.ARA");
    }

    public void init() {
        this.messageHandler = new ARAMessageHandler(this.getApplication(), this.controller, this.getLogChannel(), this.getDefaultMessagePartialPopupID(), this.getSplitscreenCenteredMessagePartialPopupID());
        this.messageHandler.init();
        this.tickToDegreeMappingIncreasing = new int[171];
        this.tickToDegreeMappingDecreasing = new int[171];
        for (int i2 = 0; i2 < this.tickToDegreeMappingIncreasing.length; ++i2) {
            this.tickToDegreeMappingIncreasing[i2] = 1;
            this.tickToDegreeMappingDecreasing[i2] = 1;
        }
        this.testSupportHandler = new TestSupportHandler("ParkingARA", true, false, this, this.getApplication().getBundleContext(), this.getLogChannel());
        this.testSupportHandler.init();
        super.init();
        this.controller.registerParkingSystemComponent(this);
    }

    public void deinit() {
        this.testSupportHandler.deinit();
        this.blockUserInteraction(false);
        this.controller.unregisterParkingSystemComponent(this);
        this.messageHandler.deinit();
        super.deinit();
    }

    protected void initModels() {
        this.getChoiceModel(2100348).setChoiceListener(this);
        this.getRangeModel(2100167).setRangeListener(this);
        this.getRangeModel(2100167).setLimits(-1, 1, 1, 0);
        this.araDataModel = this.getBaseListModel(2100302);
        BaseListModelApp baseListModelApp = this.araDataModel.getCopy();
        EvoListRow[] evoListRowArray = new EvoListRow[10];
        evoListRowArray[0] = new EvoListRow(0L, 1);
        evoListRowArray[0].setInteger(0, 0);
        evoListRowArray[1] = new EvoListRow(1L, 1);
        evoListRowArray[1].setInteger(0, 0);
        evoListRowArray[2] = new EvoListRow(2L, 1);
        evoListRowArray[2].setInteger(0, 0);
        evoListRowArray[3] = new EvoListRow(3L, 1);
        evoListRowArray[3].setInteger(0, 0);
        evoListRowArray[4] = new EvoListRow(4L, 1);
        evoListRowArray[4].setInteger(0, 0);
        evoListRowArray[5] = new EvoListRow(5L, 1);
        evoListRowArray[5].setInteger(0, 0);
        evoListRowArray[6] = new EvoListRow(6L, 1);
        evoListRowArray[6].setInteger(0, 0);
        evoListRowArray[7] = new EvoListRow(7L, 1);
        evoListRowArray[7].setInteger(0, 0);
        evoListRowArray[8] = new EvoListRow(8L, 1);
        evoListRowArray[8].setInteger(0, 0);
        evoListRowArray[9] = new EvoListRow(9L, 1);
        evoListRowArray[9].setInteger(0, 0);
        baseListModelApp.append(evoListRowArray);
        this.araDataModel.update(baseListModelApp);
    }

    protected void deinitModels() {
        this.getRangeModel(2100348).resetListener();
        this.getRangeModel(2100167).resetListener();
        this.araDataModel.clearAll();
    }

    protected abstract int getDefaultMessagePartialPopupID();

    protected abstract int getSplitscreenCenteredMessagePartialPopupID();

    public String getName() {
        return "Parking system ARA";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{45, 46, 47, 48})};
    }

    public void setActive(boolean bl, DisplayContent displayContent) {
        this.getLogChannel().log(10000000, "[AbstractParkingSystemARAComponent#setActive] active=%1, displayContent=%2", bl, (Object)displayContent);
        if (bl) {
            if (displayContent.getPopup() == 9 || displayContent.getPopup() == 10 || displayContent.getPopup() == 11 || displayContent.getPopup() == 13 || displayContent.getPopup() == 14) {
                this.getChoiceModel(2100166).setValue(1);
                this.getChoiceModel(2100348).setValue(1);
                if (displayContent.getPopup() == 13 || displayContent.getPopup() == 14) {
                    this.controller.notifyViewModeSettingChanged(this, 2, 0, 0, true);
                } else {
                    this.controller.notifyViewModeSettingChanged(this, 2, 1, 1, true);
                }
            } else if (displayContent.getMode() == 12) {
                this.getChoiceModel(2100166).setValue(2);
                this.getChoiceModel(2100348).setValue(0);
                int n = ((AbstractParkingSystemControllerComponent)this.controller).getCurrentOPSViewMode();
                this.controller.notifyViewModeSettingChanged(this, 2, n, n, true);
            } else {
                this.getChoiceModel(2100166).setValue(0);
                this.setPowerState(false);
            }
            this.controller.addPopupRequest(this.getHMIPopupID(displayContent.popup), this);
        } else {
            this.getChoiceModel(2100166).setValue(0);
            this.controller.removePopupRequest(this.getHMIPopupID(this.controller.getCurrentDisplayContent().getPopup()), this);
            this.setPowerState(false);
        }
        this.updateSteeringInterventionSymbolState();
        this.controller.notifyParkingSystemActive(this, bl);
        if (this.isAraActive() && null != this.currentARAInfo) {
            this.blockUserInteraction(this.currentARAInfo.isDeactivationProhibited());
        }
    }

    public int[] getSupportedDSIPopupIDs() {
        return new int[]{9, 10, 11, 12, 13, 14};
    }

    public int getParkingSystemID() {
        return 8;
    }

    private void angleDataChanged() {
        if (this.currentViewOptions != null && this.currentAngle != null) {
            short s = this.currentViewOptions.getAraTrailerConfiguration().getInstantTrailerAngle();
            short s2 = this.currentViewOptions.getAraTrailerConfiguration().getHazinessTrailerAngle();
            boolean bl = this.hasHazinessAngle();
            int n = this.currentMaxAngle;
            boolean bl2 = this.hasMaxAngle();
            int n2 = this.currentAngle.getAngle();
            boolean bl3 = this.hasCurrentAngle() && this.currentAngle.isValid();
            int n3 = this.currentTargetAngle;
            boolean bl4 = bl && this.hasCurrentTargetAngle();
            BaseListModelApp baseListModelApp = this.araDataModel.getCopy();
            this.updateListRow(baseListModelApp, 0, n2);
            this.updateListRow(baseListModelApp, 1, bl3 ? 1 : 0);
            this.updateListRow(baseListModelApp, 2, n3);
            this.updateListRow(baseListModelApp, 3, bl4 ? 1 : 0);
            this.updateListRow(baseListModelApp, 4, s2);
            this.updateListRow(baseListModelApp, 5, bl ? 1 : 0);
            if (!this.isEmergencyRegulation()) {
                this.updateListRow(baseListModelApp, 6, this.currentViewOptions.getAraTrailerConfiguration().getMaxTrailerAngle());
                this.updateListRow(baseListModelApp, 7, bl2 ? 1 : 0);
            } else {
                this.updateListRow(baseListModelApp, 6, 0);
                this.updateListRow(baseListModelApp, 7, 0);
            }
            this.updateListRow(baseListModelApp, 8, s);
            this.updateListRow(baseListModelApp, 9, s == 255 ? 0 : 1);
            this.araDataModel.update(baseListModelApp);
            if (this.testSupportVisible) {
                this.testSupportData[0] = "Current Angle: " + (bl3 ? Integer.toString(n2) : "not available");
                this.testSupportData[1] = "Current Target Angle: " + (bl4 ? Integer.toString(n3) : "not available");
                this.testSupportData[2] = "Haziness Angle: " + (bl ? Integer.toString(s2) : "not available");
                this.testSupportData[3] = "Instant Angle: " + Integer.toString(s);
                this.testSupportData[4] = "Max Angle: " + (bl2 ? Integer.toString(this.currentViewOptions.getAraTrailerConfiguration().getMaxTrailerAngle()) : "not available | calculated value: " + n);
                this.testSupportData[5] = "Auto Steering: " + (this.currentARAInfo != null ? Boolean.toString(this.currentARAInfo.isAutomaticSteering()) : "ARAInfo not received");
                this.testSupportData[6] = "Deactivation Proh.: " + (this.currentARAInfo != null ? Boolean.toString(this.currentARAInfo.isDeactivationProhibited()) : "ARAInfo not received");
                this.testSupportData[7] = "Last Message: " + (this.currentARAInfo != null ? Integer.toString(this.currentARAInfo.getMessage()) : "ARAInfo not received");
                try {
                    this.testSupportHandler.updateData(this.testSupportData);
                }
                catch (Exception exception) {
                    this.getLogChannel().log(100000, "[AbstractParkingSystemARAComponent#angleDataChanged] exception occured sending data to TestSupport", (Throwable)exception);
                }
            }
        }
    }

    private boolean isEmergencyRegulation() {
        return !this.hasMaxAngle();
    }

    private void calculateAndSetAngleConfiguration() {
        ARATrailerConfiguration aRATrailerConfiguration = this.currentViewOptions.getAraTrailerConfiguration();
        if (aRATrailerConfiguration != null) {
            int n = this.currentMaxAngle = this.calculateMaxAngle();
            this.tickToDegreeMappingIncreasing = new int[n * 2 + 1];
            this.tickToDegreeMappingDecreasing = new int[n * 2 + 1];
            byte by = aRATrailerConfiguration.getStepSize1();
            byte by2 = aRATrailerConfiguration.getStepSize1();
            for (int i2 = -n; i2 <= n; ++i2) {
                int n2 = i2 < 0 ? 0 - i2 : i2;
                by = aRATrailerConfiguration.getStepSize4();
                by = n2 >= aRATrailerConfiguration.getThreshold3() ? aRATrailerConfiguration.getStepSize4() : (n2 >= aRATrailerConfiguration.getThreshold2() ? aRATrailerConfiguration.getStepSize3() : (n2 >= aRATrailerConfiguration.getThreshold1() ? aRATrailerConfiguration.getStepSize2() : aRATrailerConfiguration.getStepSize1()));
                by2 = aRATrailerConfiguration.getStepSize4();
                by2 = n2 > aRATrailerConfiguration.getThreshold3() ? aRATrailerConfiguration.getStepSize4() : (n2 > aRATrailerConfiguration.getThreshold2() ? aRATrailerConfiguration.getStepSize3() : (n2 > aRATrailerConfiguration.getThreshold1() ? aRATrailerConfiguration.getStepSize2() : aRATrailerConfiguration.getStepSize1()));
                this.tickToDegreeMappingDecreasing[i2 + n] = i2 < 0 ? by : by2;
                this.tickToDegreeMappingIncreasing[i2 + n] = i2 < 0 ? by2 : by;
            }
            this.getRangeModel(2100167).setLimits(-aRATrailerConfiguration.getMaxTrailerAngle(), aRATrailerConfiguration.getMaxTrailerAngle(), 1, 0);
        } else {
            this.getLogChannel().log(1000, "[AbstractParkingSystemARAComponent#calculateAndSetAngleConfiguration] ARATrailerConfiguration of last received ViewOptions is null: %1", (Object)this.formatViewOptionsLog(this.currentViewOptions.toString()));
        }
    }

    private void updateListRow(BaseListModelApp baseListModelApp, int n, int n2) {
        EvoListRow evoListRow = baseListModelApp.getRow(baseListModelApp.getIndexForUniqueID(n));
        if (evoListRow != null) {
            evoListRow.setInteger(0, n2);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(n), evoListRow);
        }
    }

    private void updateARAViewModeSetting(int n, int n2, int n3, int n4) {
        DisplayContent displayContent;
        DisplayContent displayContent2;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARAViewModeSetting] viewModeARA='%1', viewModeOPS='%2'", (long)n3, (long)n4);
        }
        if (null != (displayContent2 = ARAViewModeHelper.getDisplayContent(displayContent = this.controller.getCurrentDisplayContent(), n, n2, n3, n4))) {
            if (!this.controller.equalsDisplayContent(displayContent, displayContent2)) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARAViewModeSetting] Change display content: currentContent='%1' -> newContent='%2'", (Object)displayContent, (Object)displayContent2);
                }
                if (0 == n3 || 0 == n4) {
                    this.controller.changeDisplayContent(displayContent2, true);
                } else {
                    this.controller.changeDisplayContent(displayContent2, false);
                }
            } else if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARAViewModeSetting] Display content equal: currentContent='%1' newContent='%2'.", (Object)displayContent, (Object)displayContent2);
            }
        } else {
            this.getLogChannel().log(100000, "[AbstractParkingSystemARAComponent#updateARAViewModeSetting] New content='%1' invalid! Update ignored.", (Object)displayContent2);
        }
    }

    public void updateOPSViewModeSetting(int n, int n2) {
        if (this.isAraActive()) {
            int n3 = ARAViewModeHelper.getViewModeARA(this.controller.getCurrentDisplayContent());
            if (-1 != n3) {
                this.updateARAViewModeSetting(n3, n, n3, n2);
            } else {
                this.getLogChannel().log(100000, "[AbstractParkingSystemARAComponent#updateOPSViewModeSetting] Update ignored. viewModeARA='%1' invalid!", (long)n3);
            }
        }
    }

    public synchronized void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        super.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
        if (n == 1 && parkingSystemViewOptions != null) {
            this.calculateAndSetAngleConfiguration();
            this.angleDataChanged();
            this.primaryAttributeFirstSetReceived();
        }
    }

    public synchronized void updateARAFailure(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARAFailure] failure='%1', valid='%2'", bl, (long)n);
        if (n == 1) {
            this.getLogChannel().log(100000, "[AbstractParkingSystemARAComponent#updateARAFailure] call currently not supported by HMI");
        }
    }

    public synchronized void updateARAInfo(ARAInfo aRAInfo, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARAInfo] info='%1', valid='%2'", (Object)aRAInfo, (long)n);
        if (n == 1) {
            this.currentARAInfo = aRAInfo;
            if (aRAInfo != null) {
                this.angleDataChanged();
                this.messageHandler.showMessage(aRAInfo.getMessage());
                if (this.isAraActive()) {
                    boolean bl = aRAInfo.isDeactivationProhibited();
                    this.blockUserInteraction(bl);
                    if (bl) {
                        this.controller.setHighProtocol(true, new int[]{1}, true);
                    } else {
                        this.controller.setHighProtocol(false, null, true);
                    }
                    this.updateSteeringInterventionSymbolState();
                }
            }
        }
    }

    private void updateSteeringInterventionSymbolState() {
        int n = 0;
        if (this.isAraActive()) {
            n = this.currentARAInfo != null && this.currentARAInfo.isAutomaticSteering() ? 2 : 1;
        }
        this.getChoiceModel(2100315).setValue(n);
    }

    private void blockUserInteraction(boolean bl) {
        Object object;
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#blockUserInteraction] blocking user interaction '%1'", bl);
        try {
            object = this.getAraPopupConsumptionStrategy(bl);
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#blockUserInteraction] Set PopupKeyConsumptionStrategy: %1", object);
            this.getApplication().getFrameworkAccess().getHmiServiceApp().setPopupKeyConsuptionStrategy((IPopupKeyConsuptionStrategy)object);
        }
        catch (Exception exception) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#blockUserInteraction] exception occured during lock/unlock usage ", (Throwable)exception);
        }
        this.setPowerState(bl);
        if (bl) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#blockUserInteraction] Close OptionDrawer.");
            }
            object = this.getApplication().getFrameworkAccess().getHMIService();
            DrawerEvent drawerEvent = new DrawerEvent(object.getRootWindow(0), 2);
            object.getEventDispatcher().postEvent(drawerEvent);
        }
    }

    private void setPowerState(boolean bl) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#setPowerState] isSteeringInterventionActive='%1'", bl);
        }
        try {
            this.getApplication().getFrameworkAccess().getPowerMgr().setExtendedPowerState(bl ? 150 : 151, 0);
        }
        catch (Exception exception) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#setPowerState] Exception occured during setting extended power state", (Throwable)exception);
        }
    }

    public abstract IPopupKeyConsuptionStrategy getAraPopupConsumptionStrategy(boolean var1);

    public synchronized void updateARACurrentTrailerAngle(ARACurrentTrailerAngle aRACurrentTrailerAngle, int n) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARACurrentTrailerAngle] angle='%1', valid='%2'", (Object)aRACurrentTrailerAngle, (long)n);
        if (n == 1) {
            this.currentAngle = aRACurrentTrailerAngle;
            this.angleDataChanged();
        }
    }

    public synchronized void updateARATargetTrailerAngle(int n, int n2) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#updateARATargetTrailerAngle] angle='%1', valid='%2'", (long)n, (long)n2);
        if (n2 == 1) {
            this.currentTargetAngle = n;
            this.angleDataChanged();
        }
    }

    protected void dsiAvailable(boolean bl) {
        if (!bl) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#dsiAvailable] dsi not available, remove possible userInteraction-blocking");
            this.blockUserInteraction(false);
        }
    }

    public synchronized void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#keyPressed] modelID: %1 , keyID: %2 ", (long)n, (long)n2);
        if (n2 == 17) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#keyPressed] DSI.setARATargetTrailerAngle(0)");
            this.getDSI().setARATargetTrailerAngle(0);
        }
    }

    public synchronized void keyReleased(int n, int n2, int n3) {
    }

    public synchronized void keyTyped(int n, int n2, int n3) {
    }

    public synchronized void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == 2100348) {
            DisplayContent displayContent = this.controller.getCurrentDisplayContent();
            int n5 = ARAViewModeHelper.getViewModeARA(displayContent);
            int n6 = this.controller.getOPSViewModeHandler().getOPSViewModeSetting();
            this.updateARAViewModeSetting(n5, n6, n2, n6);
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public synchronized void decrement(int n, int n2, int n3) {
        this.rangeModelValueChanged(n, n2, n3);
    }

    public synchronized void increment(int n, int n2, int n3) {
        this.rangeModelValueChanged(n, -n2, n3);
    }

    private void rangeModelValueChanged(int n, int n2, int n3) {
        int n4 = this.currentMaxAngle;
        int n5 = this.currentTargetAngle;
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#rangeModelValueChanged] modelID='%1', steps='%2', currentAngle='%3'", (long)n, (long)n2, (long)n5);
        if (n2 > 0 && n5 >= n4 || n2 < 0 && n5 <= -n4) {
            this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#rangeModelValueChanged] max angle already reached, nothing to do");
            return;
        }
        boolean bl = n2 < 0;
        int n6 = bl ? -n2 : n2;
        int n7 = n5;
        int[] nArray = bl ? this.tickToDegreeMappingDecreasing : this.tickToDegreeMappingIncreasing;
        for (int i2 = 0; i2 < n6; ++i2) {
            int n8 = n4 + n7;
            if (n8 > nArray.length) {
                n8 = nArray.length - 1;
            } else if (n8 < 0) {
                n8 = 0;
            }
            int n9 = n7 = bl ? n7 - nArray[n8] : n7 + nArray[n8];
            if (n7 >= n4) {
                n7 = n4;
                continue;
            }
            if (n7 > -n4) continue;
            n7 = -n4;
        }
        this.getLogChannel().log(1000000, "[AbstractParkingSystemARAComponent#rangeModelValueChanged] DSI.setARATargetTrailerAngle(%1)", (long)n7);
        this.getDSI().setARATargetTrailerAngle(n7);
    }

    private int calculateMaxAngle() {
        ARATrailerConfiguration aRATrailerConfiguration = this.currentViewOptions.getAraTrailerConfiguration();
        int n = 85;
        if (aRATrailerConfiguration.getThreshold4() != 255) {
            n = aRATrailerConfiguration.getThreshold4();
        } else if (aRATrailerConfiguration.getThreshold3() != 255) {
            n = aRATrailerConfiguration.getThreshold3();
        } else if (aRATrailerConfiguration.getThreshold2() != 255) {
            n = aRATrailerConfiguration.getThreshold2();
        } else if (aRATrailerConfiguration.getThreshold1() != 255) {
            n = aRATrailerConfiguration.getThreshold1();
        } else {
            this.getLogChannel().log(1000, "[AbstractParkingSystemARAComponent#calculateMaxAngle] all thresholds have invalid values", (Object)aRATrailerConfiguration);
        }
        return n;
    }

    private boolean hasMaxAngle() {
        if (this.currentViewOptions == null) {
            return false;
        }
        return this.currentViewOptions.getAraTrailerConfiguration().getMaxTrailerAngle() != 0 && this.currentViewOptions.getAraTrailerConfiguration().getMaxTrailerAngle() != 255;
    }

    private boolean hasHazinessAngle() {
        if (null == this.currentViewOptions || null == this.currentViewOptions.getAraTrailerConfiguration()) {
            return false;
        }
        short s = this.currentViewOptions.getAraTrailerConfiguration().getHazinessTrailerAngle();
        return 255 != s;
    }

    private boolean hasCurrentAngle() {
        if (this.currentViewOptions == null) {
            return false;
        }
        return this.getMenuEntryVisibilityState(this.currentViewOptions.getAraCurrentTrailerAngle()) == 0;
    }

    private boolean hasCurrentTargetAngle() {
        if (this.currentViewOptions == null) {
            return false;
        }
        return this.getMenuEntryVisibilityState(this.currentViewOptions.getAraTargetTrailerAngle()) == 0;
    }

    public void debugDataVisible(boolean bl) {
        this.testSupportVisible = bl;
        if (bl) {
            this.testSupportHandler.updateData(this.testSupportData);
        }
    }

    public void commandEntrySelected(int n) {
    }

    public TestSupportDataReceiverEntry[] getCommandEntries() {
        return new TestSupportDataReceiverEntry[0];
    }

    public boolean isAraActive() {
        return this.getChoiceModel(2100166).getValue() > 0;
    }

    public void notifyOPSActive(boolean bl) {
        this.messageHandler.updateMessage();
    }

    private static final class ARAViewModeHelper {
        private static DisplayContent lastDisplayContent;

        private ARAViewModeHelper() {
        }

        private static DisplayContent getDisplayContent(DisplayContent displayContent, int n, int n2, int n3, int n4) {
            boolean bl = ARAViewModeHelper.isFlankguard(displayContent);
            if (n == n3 && n2 == n4) {
                return displayContent;
            }
            DisplayContent displayContent2 = n == 1 && n2 == 1 ? (n3 == 1 && n4 == 0 ? new DisplayContent(bl ? 14 : 13, 2, 1, 12) : (n3 == 0 && n4 == 1 ? new DisplayContent(bl ? 8 : 3, ARAViewModeHelper.getLastShownScreen(displayContent.getScreen()), 1, 12) : ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 1 && n2 == 0 ? (n3 == 1 && n4 == 1 ? new DisplayContent(bl ? 11 : 10, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 0 ? new DisplayContent(bl ? 8 : 3, 2, 1, 12) : ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 0 && n2 == 1 ? (n3 == 1 && n4 == 1 ? new DisplayContent(bl ? 11 : 10, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 0 ? new DisplayContent(bl ? 8 : 3, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : (n == 0 && n2 == 0 ? (n3 == 1 && n4 == 0 ? new DisplayContent(bl ? 14 : 13, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : (n3 == 0 && n4 == 1 ? new DisplayContent(bl ? 8 : 3, displayContent.getScreen(), displayContent.getView(), displayContent.getMode()) : ARAViewModeHelper.getFallbackDisplayContent(n3, n4))) : ARAViewModeHelper.getFallbackDisplayContent(n3, n4))));
            lastDisplayContent = displayContent2;
            return displayContent2;
        }

        private static int getLastShownScreen(int n) {
            if (n != 0) {
                return n;
            }
            if (lastDisplayContent.getScreen() != 0) {
                return lastDisplayContent.getScreen();
            }
            return 2;
        }

        private static DisplayContent getFallbackDisplayContent(int n, int n2) {
            DisplayContent displayContent = n == 1 && n2 == 1 ? new DisplayContent(10, 2, 0, 0) : (n == 1 && n2 == 0 ? new DisplayContent(13, 2, 1, 12) : (n == 0 && n2 == 1 ? new DisplayContent(3, 2, 1, 12) : (n == 0 && n2 == 0 ? new DisplayContent(3, 2, 1, 12) : null)));
            return displayContent;
        }

        private static int getViewModeARA(DisplayContent displayContent) {
            int n = displayContent.getPopup();
            if (3 == n || 8 == n) {
                return 0;
            }
            if (10 == n || 11 == n || 13 == n || 14 == n) {
                return 1;
            }
            return -1;
        }

        private static boolean isFlankguard(DisplayContent displayContent) {
            switch (displayContent.getPopup()) {
                case 7: 
                case 8: 
                case 11: 
                case 14: 
                case 15: 
                case 16: {
                    return true;
                }
            }
            return false;
        }
    }
}

