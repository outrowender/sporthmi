/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.ScreenMainArea;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ScreenWidgetEVO;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractPartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.AbstractStatusBarController;
import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerController;
import de.esolutions.hmi.widgets.audi.evo.widgets.EntertainmentDrawerOpenCloseController;
import de.esolutions.hmi.widgets.audi.evo.widgets.PartialPopupController;
import de.esolutions.hmi.widgets.audi.evo.widgets.StatusBarG24Controller;

public class StatusBarStubController
extends AbstractWidgetController {
    private int bluetoothState;
    private int adbImportState;
    private int adb1ImportState;
    private int adb2ImportState;
    private int googleProgressState;
    private int googleTrademarkState;
    private int trafficSourceState;
    private int mediaImportState;
    private int mediaMixState;
    private int mediaRepeatState;
    private int gracenoteState;
    private int roamingState;
    private int providerLogoState;
    private int providerNameState;
    private int wirelessChargingState;
    private int providerLogoConnectState;
    private int smsStorageFullState;
    private int bluetoothMediaState;
    private int dragonLogoState;
    private int selfLearningNavigationState;
    private int bluetoothMediaOnState;
    private int asiaVICSState;
    private int asiaTPEGState;
    private int asiaTTSState;
    public static final int ICON_STATE_IGNORE;
    public static final int ICON_STATE_SHOW;
    public static final int ICON_STATE_HIDE;
    protected int renderStyle = 0;
    protected int hmiContext = -1;
    private StatusBarG24Controller statusbarG24;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateStatusBar();
    }

    private void updateStatusBar() {
        int n = this.getPPID();
        if (this.renderStyle == 2) {
            this.terminal.getPartialPopupManager().hidePopup(n);
            this.setEntertainmentDrawerVisible(false);
        } else if (this.renderStyle == 3) {
            this.hmiContext = -1;
            this.terminal.getPartialPopupManager().showPopup(n);
            this.setEntertainmentDrawerVisible(true);
        } else {
            this.terminal.getPartialPopupManager().showPopup(n);
            this.setEntertainmentDrawerVisible(true);
            if (this.model != null) {
                int n2 = ((ChoiceModelGUI)this.model).getValue();
                switch (n2) {
                    case 0: {
                        this.hmiContext = 0;
                        break;
                    }
                    case 1: {
                        this.hmiContext = 1;
                        break;
                    }
                    case 2: {
                        this.hmiContext = 2;
                        break;
                    }
                    case 3: {
                        this.hmiContext = 3;
                        break;
                    }
                    case 4: {
                        this.hmiContext = 4;
                        break;
                    }
                    case 5: {
                        this.hmiContext = 5;
                        break;
                    }
                    case 6: {
                        this.hmiContext = 6;
                        break;
                    }
                    case 7: {
                        this.hmiContext = 7;
                        break;
                    }
                    case 8: {
                        this.hmiContext = 8;
                        break;
                    }
                    case 9: {
                        this.hmiContext = 9;
                        break;
                    }
                    default: {
                        this.hmiContext = -1;
                        break;
                    }
                }
            } else {
                this.hmiContext = -1;
            }
        }
        if (this.terminal.getFramework().getKombiType() == 4) {
            this.updateStatusbarG24(this.hmiContext);
        } else {
            this.updateStatusbarHigh(this.hmiContext);
        }
    }

    private void setEntertainmentDrawerVisible(boolean bl) {
        if (this.terminal != null) {
            Object object = this.terminal.getDrawerFocusManager().getEntertainmentDrawer();
            if (object instanceof EntertainmentDrawerController) {
                EntertainmentDrawerOpenCloseController entertainmentDrawerOpenCloseController = ((EntertainmentDrawerController)object).getOpenCloseController();
                entertainmentDrawerOpenCloseController.onDrawerVisibiltyChange(bl);
            } else if (object == null) {
                IWidgetLogChannel.logEntertainmentDrawerEvents.log(-1601830656, "StatusBarStubController#setEntertainmentDrawerVisible entertainmentDrawer is not initialized yet, store visibility at drawerfocusmanager. Will be set when entertainment drawer is activated -> visible=%1", bl);
                this.terminal.getDrawerFocusManager().setEarlyEntertainmentDrawerVisibility(bl);
            }
        }
    }

    private int getPPID() {
        if (this.isKombiType()) {
            return 101;
        }
        return 62;
    }

    private void updateStatusbarHigh(int n) {
        AbstractStatusBarController abstractStatusBarController;
        IPartialPopupController iPartialPopupController = this.terminal.getPartialPopupManagerEvo().getPartialPopup(62);
        if (iPartialPopupController != null && this.isStatusbarValid(abstractStatusBarController = (AbstractStatusBarController)((AbstractPartialPopupController)iPartialPopupController).getChild(0))) {
            abstractStatusBarController.setCurrentHMIContext(n);
            abstractStatusBarController.setIconState(this.bluetoothState, this.adbImportState, this.adb1ImportState, this.adb2ImportState, this.googleProgressState, this.googleTrademarkState, this.trafficSourceState, this.mediaImportState, this.mediaMixState, this.mediaRepeatState, this.gracenoteState, this.roamingState, this.providerLogoState, this.providerNameState, this.wirelessChargingState, this.providerLogoConnectState, this.smsStorageFullState, this.bluetoothMediaState, this.asiaVICSState, this.asiaTPEGState, this.asiaTTSState, this.dragonLogoState, this.selfLearningNavigationState, this.bluetoothMediaOnState);
        }
    }

    private void updateStatusbarG24(int n) {
        PartialPopupController partialPopupController = (PartialPopupController)this.terminal.getPartialPopupManagerEvo().getPartialPopup(101);
        if (partialPopupController != null) {
            this.statusbarG24 = (StatusBarG24Controller)partialPopupController.getChild(0);
            if (this.isStatusbarValid(this.statusbarG24)) {
                this.statusbarG24.setScreen((AbstractScreenWidget)this.getInitContext().getScreen());
                this.statusbarG24.setCurrentHMIContext(n);
                this.statusbarG24.setIconState(this.bluetoothState, this.adbImportState, this.adb1ImportState, this.adb2ImportState, this.googleProgressState, this.googleTrademarkState, this.trafficSourceState, this.mediaImportState, this.mediaMixState, this.mediaRepeatState, this.gracenoteState, this.roamingState, this.providerLogoState, this.providerNameState, this.wirelessChargingState, this.providerLogoConnectState, this.smsStorageFullState, this.bluetoothMediaState, this.asiaVICSState, this.asiaTPEGState, this.asiaTTSState, this.dragonLogoState, this.selfLearningNavigationState, this.bluetoothMediaOnState);
                if (this.statusbarG24.isSDSVisible() || this.renderStyle == 3) {
                    ScreenMainArea screenMainArea = ((ScreenWidgetEVO)this.initContext.getScreen()).getMainArea();
                    this.statusbarG24.notifyNewMainArea((ContainerController)screenMainArea);
                } else {
                    this.statusbarG24.notifyNewMainArea(partialPopupController);
                }
            } else {
                logChannel.log(10000, "StatusbarStubController#initializeWidget no statusbar G24 found (statusbarG24 == null)");
            }
        }
    }

    @Override
    public void predisconnecting() {
        super.predisconnecting();
        if (this.isKombiType() && this.isStatusbarValid(this.statusbarG24)) {
            this.statusbarG24.notifyNewMainArea(null);
        }
    }

    private boolean isKombiType() {
        return this.terminal != null && this.terminal.getFramework() != null && this.terminal.getFramework().getKombiType() == 4;
    }

    public void setRenderStyle(int n) {
        if (this.renderStyle != n) {
            this.renderStyle = n;
            this.setCompositesDirty(true);
            if (this.isConnected()) {
                this.updateStatusBar();
            }
        }
    }

    @Override
    protected void handleFocusChanged(int n, int n2, int n3) {
        if (this.isStatusbarValid(this.statusbarG24)) {
            this.statusbarG24.setDrawerState(n2);
        }
        super.handleFocusChanged(n, n2, n3);
    }

    private boolean isStatusbarValid(AbstractStatusBarController abstractStatusBarController) {
        boolean bl;
        boolean bl2 = bl = abstractStatusBarController == null;
        if (bl) {
            logChannel.log(-1601830656, "StatusbarStubController#isStatusbarValid statusbar %1 is not valid, it is null", (Object)abstractStatusBarController);
            return false;
        }
        boolean bl3 = abstractStatusBarController.isConnected();
        if (!bl3) {
            logChannel.log(-1601830656, "StatusbarStubController#isStatusbarValid statusbar %1 is not valid, it is not connected", (Object)abstractStatusBarController);
            return false;
        }
        return true;
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    public void setBluetoothState(int n) {
        this.bluetoothState = n;
    }

    public void setAdbImportState(int n) {
        this.adbImportState = n;
    }

    public void setAdb1ImportState(int n) {
        this.adb1ImportState = n;
    }

    public void setAdb2ImportState(int n) {
        this.adb2ImportState = n;
    }

    public void setGoogleProgressState(int n) {
        this.googleProgressState = n;
    }

    public void setGoogleTrademarkState(int n) {
        this.googleTrademarkState = n;
    }

    public void setTrafficSourceState(int n) {
        this.trafficSourceState = n;
    }

    public void setMediaImportState(int n) {
        this.mediaImportState = n;
    }

    public void setMediaMixState(int n) {
        this.mediaMixState = n;
    }

    public void setMediaRepeatState(int n) {
        this.mediaRepeatState = n;
    }

    public void setGracenoteState(int n) {
        this.gracenoteState = n;
    }

    public void setRoamingState(int n) {
        this.roamingState = n;
    }

    public void setProviderLogoState(int n) {
        this.providerLogoState = n;
    }

    public void setDragonLogoState(int n) {
        this.dragonLogoState = n;
    }

    public void setProviderNameState(int n) {
        this.providerNameState = n;
    }

    public void setWirelessChargingState(int n) {
        this.wirelessChargingState = n;
    }

    public void setProviderLogoConnectState(int n) {
        this.providerLogoConnectState = n;
    }

    public void setSmsStorageFullState(int n) {
        this.smsStorageFullState = n;
    }

    public void setBluetoothMediaState(int n) {
        this.bluetoothMediaState = n;
    }

    public void setAsiaVICSState(int n) {
        this.asiaVICSState = n;
    }

    public void setAsiaTPEGState(int n) {
        this.asiaTPEGState = n;
    }

    public void setAsiaTTSState(int n) {
        this.asiaTTSState = n;
    }

    public void setSelfLearningNavigationState(int n) {
        this.selfLearningNavigationState = n;
    }

    public void setBluetoothMediaOnState(int n) {
        this.bluetoothMediaOnState = n;
    }
}

