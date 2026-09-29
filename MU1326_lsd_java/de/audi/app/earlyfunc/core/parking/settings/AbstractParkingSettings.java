/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.settings;

import de.audi.app.car.common.adapter.AbstractDSICarParkingSystemAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.parking.settings.ParkingSettingsConstant;
import de.audi.app.earlyfunc.core.parking.settings.ParkingSystemEntertainmentLowering;
import de.audi.atip.hmi.model.ChoiceListener;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSettings
extends AbstractDSICarParkingSystemAdapter
implements ChoiceListener {
    private static final String COMPONENT_NAME;
    public static final short CODING_ID;
    public static final int PDC_DEFAULT_FREQ_FRONT;
    public static final int PDC_DEFAULT_FREQ_REAR;
    private volatile ParkingSystemViewOptions currViewOptions;
    private final ParkingSystemEntertainmentLowering entertainmentLowering;
    private volatile int focusGained = 0;
    private static final int FOCUS_CONTENT_NONE;
    private static final int FOCUS_CONTENT_VOLUME_FRONT;
    private static final int FOCUS_CONTENT_VOLUME_REAR;
    private PDCSound currentlySelectedVolumeFront = new PDCSound(1, 4);
    private PDCSound currentlySelectedVolumeRear = new PDCSound(1, 6);
    private PDCSound currentlyChangingVolumeFront = new PDCSound(0, 4);
    private PDCSound currentlyChangingVolumeRear = new PDCSound(0, 6);
    private static final int FOCUS_LOST;

    public AbstractParkingSettings(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Parking.Settings");
        this.entertainmentLowering = new ParkingSystemEntertainmentLowering(this.getLogChannel());
    }

    @Override
    public void initBusiness() {
        this.entertainmentLowering.init(this.getDSI(), this.getApplication());
    }

    @Override
    public void deinit() {
        this.entertainmentLowering.deinit();
        super.deinit();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSettings#keyPressed] modelID='%1', keyID='%2'", (long)n, (long)n2);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSettings#keyReleased] modelID='%1', keyID='%2'", (long)n, (long)n2);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSettings#keyReleased] modelID='%1', keyID='%2'", (long)n, (long)n2);
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        if (n == ParkingSettingsConstant.VPSDEFAULTVIEW.getModelID()) {
            this.itemSelectedAutoVPSViewSwitching(n2);
        } else if (n == this.getVolumeSettingsFront().getModelID()) {
            this.itemSelectedPDCVolumeFront(n2);
        } else if (n == this.getVolumeSettingsRear().getModelID()) {
            this.itemSelectedPDCVolumeRear(n2);
        } else if (n == 806166528) {
            boolean bl = 1 == n2;
            this.getLogChannel().log(1078071040, "AbstractParkingSettings: DSI().setPDCAutoActivation(%1)", (Object)(bl ? "true" : "false"));
            this.getDSI().setPDCAutoActivation(bl);
        } else {
            this.logModelData("itemSelected:", n, n2, false);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logModelData("itemFocused:", n, n2, true);
        if (n == this.getVolumeSettingsFront().getModelID()) {
            this.itemFocusedPDCVolumeFront(n2);
        } else if (n == this.getVolumeSettingsRear().getModelID()) {
            this.itemFocusedPDCVolumeRear(n2);
        } else {
            this.logModelData("itemFocused:", n, n2, false);
        }
    }

    private void itemFocusedPDCVolumeFront(int n) {
        if (n == -1) {
            if (this.focusGained == 1) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSettings#itemFocusedPDCVolumeFront] focus lost --> dsi.setPDCSoundFront(%1)", (Object)this.currentlySelectedVolumeFront);
                this.getDSI().setPDCSoundFront(this.currentlySelectedVolumeFront);
                this.setFocusGained(0);
            }
        } else {
            this.sendDSISetVolumeFront(n);
            this.setFocusGained(1);
        }
    }

    private void itemFocusedPDCVolumeRear(int n) {
        if (n == -1) {
            if (this.focusGained == 2) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSettings#itemFocusedPDCVolumeRear] focus lost --> dsi.setPDCSoundRear(%1)", (Object)this.currentlySelectedVolumeRear);
                this.getDSI().setPDCSoundRear(this.currentlySelectedVolumeRear);
                this.setFocusGained(0);
            }
        } else {
            this.sendDSISetVolumeRear(n);
            this.setFocusGained(2);
        }
    }

    private void setFocusGained(int n) {
        this.focusGained = n;
    }

    private void itemSelectedAutoVPSViewSwitching(int n) {
        if (n < ParkingSettingsConstant.VPSDEFAULTVIEW.getSelectableOptions().length) {
            int n2 = ParkingSettingsConstant.VPSDEFAULTVIEW.getSelectableOptions()[n];
            this.getLogChannel().log(1078071040, "[AbstractParkingSettings#itemSelectedAutoVPSViewSwitching] dsi.setVPSDefaultView(%1)", (long)n2);
            this.getDSI().setVPSDefaultView(n2);
        }
    }

    protected void itemSelectedPDCVolumeRear(int n) {
        if (this.currentlyChangingVolumeRear.getVolume() == this.getVolumeFront(n)) {
            this.changeVolumeRear(this.currentlyChangingVolumeRear);
        } else {
            this.sendDSISetVolumeRear(n);
        }
        this.setFocusGained(0);
    }

    private void sendDSISetVolumeRear(int n) {
        if (n < this.getVolumeSettingsRear().getSelectableOptions().length) {
            PDCSound pDCSound = new PDCSound(this.getVolumeRear(n), 6);
            this.getLogChannel().log(1078071040, "[AbstractParkingSettings#sendDSISetVolumeRear] dsi.setPDCSoundRear(%1)", (Object)pDCSound);
            this.getDSI().setPDCSoundRear(pDCSound);
        }
    }

    protected void itemSelectedPDCVolumeFront(int n) {
        if (this.currentlyChangingVolumeFront.getVolume() == this.getVolumeFront(n)) {
            this.changeVolumeFront(this.currentlyChangingVolumeFront);
        } else {
            this.sendDSISetVolumeFront(n);
        }
        this.setFocusGained(0);
    }

    private void sendDSISetVolumeFront(int n) {
        if (n < this.getVolumeSettingsFront().getSelectableOptions().length) {
            PDCSound pDCSound = new PDCSound(this.getVolumeFront(n), 4);
            this.getLogChannel().log(1078071040, "[AbstractParkingSettings#sendDSISetVolumeFront] dsi.setPDCSoundFront(%1)", (Object)pDCSound);
            this.getDSI().setPDCSoundFront(pDCSound);
        }
    }

    private int getVolumeFront(int n) {
        if (n < this.getVolumeSettingsFront().getSelectableOptions().length) {
            return this.getVolumeSettingsFront().getSelectableOptions()[n];
        }
        return -1;
    }

    private int getVolumeRear(int n) {
        if (n < this.getVolumeSettingsRear().getSelectableOptions().length) {
            return this.getVolumeSettingsRear().getSelectableOptions()[n];
        }
        return -1;
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        this.getLogChannel().log(1078071040, "[AbstractParkingSettings#updateParkingSystemViewOptions] parkingSystemViewOptions=%1, valid=%2", (Object)parkingSystemViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = parkingSystemViewOptions;
            this.entertainmentLowering.updateViewOptions(this.currViewOptions);
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updatePDCSoundFront(PDCSound pDCSound, int n) {
        if (pDCSound != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSettings#updatePDCSoundFront] sound=%1, valid=%2", (Object)pDCSound, (long)n);
            }
            if (n == 1) {
                if (this.focusGained == 1) {
                    this.currentlyChangingVolumeFront.volume = pDCSound.getVolume();
                } else {
                    this.changeVolumeFront(pDCSound);
                }
            }
        }
    }

    private void changeVolumeFront(PDCSound pDCSound) {
        this.getVolumeSettingsFront().setPDCSoundVolume(this.getChoiceModel(this.getVolumeSettingsFront().getModelID()), pDCSound, this.getLogChannel());
        this.currentlySelectedVolumeFront.volume = pDCSound.getVolume();
        this.currentlyChangingVolumeFront.volume = 0;
    }

    @Override
    public void updatePDCSoundRear(PDCSound pDCSound, int n) {
        if (pDCSound != null) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "[AbstractParkingSettings#updatePDCSoundRear] sound=%1, valid=%2", (Object)pDCSound, (long)n);
            }
            if (n == 1) {
                if (this.focusGained == 2) {
                    this.currentlyChangingVolumeRear.volume = pDCSound.getVolume();
                } else {
                    this.changeVolumeRear(pDCSound);
                }
            }
        }
    }

    private void changeVolumeRear(PDCSound pDCSound) {
        this.getVolumeSettingsRear().setPDCSoundVolume(this.getChoiceModel(this.getVolumeSettingsRear().getModelID()), pDCSound, this.getLogChannel());
        this.currentlySelectedVolumeRear.volume = pDCSound.getVolume();
        this.currentlyChangingVolumeRear.volume = 0;
    }

    @Override
    public void updateVPSDefaultView(int n, int n2) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractParkingSettings#updateVPSDefaultView] vpsDefaultView=%1, valid=%2", (long)n, (long)n2);
        }
        if (n2 == 1) {
            ParkingSettingsConstant.VPSDEFAULTVIEW.setModelValue(this.getChoiceModel(ParkingSettingsConstant.VPSDEFAULTVIEW.getModelID()), n, this.getLogChannel());
        }
    }

    @Override
    public void updatePDCOPSAutoActivation(boolean bl, int n) {
        this.getLogChannel().log(1078071040, "updatePDCOPSAutoActivation: autoActivation=%1, valid=%2", bl, (long)n);
        if (n == 1) {
            this.getChoiceModel(806166528).setValue(bl ? 1 : 0);
        }
    }

    protected ParkingSettingsConstant getVolumeSettingsFront() {
        return ParkingSettingsConstant.VOLUMEFRONT;
    }

    protected ParkingSettingsConstant getVolumeSettingsRear() {
        return ParkingSettingsConstant.VOLUMEREAR;
    }

    @Override
    public String getName() {
        return "ParkingSettings";
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(ParkingSettingsConstant.VPSDEFAULTVIEW.getModelID()).setChoiceListener(this);
        this.getChoiceModel(this.getVolumeSettingsFront().getModelID()).setChoiceListener(this);
        this.getChoiceModel(this.getVolumeSettingsRear().getModelID()).setChoiceListener(this);
        this.getChoiceModel(806166528).setChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(ParkingSettingsConstant.VPSDEFAULTVIEW.getModelID()).resetListener();
        this.getChoiceModel(this.getVolumeSettingsFront().getModelID()).resetListener();
        this.getChoiceModel(this.getVolumeSettingsRear().getModelID()).resetListener();
        this.getChoiceModel(806166528).resetListener();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{ParkingSettingsConstant.VPSDEFAULTVIEW.getDsiAttribute(), this.getVolumeSettingsFront().getDsiAttribute(), this.getVolumeSettingsRear().getDsiAttribute(), 41})};
    }

    protected abstract void updateMenuEntryVisibility(ParkingSystemViewOptions parkingSystemViewOptions) {
    }
}

