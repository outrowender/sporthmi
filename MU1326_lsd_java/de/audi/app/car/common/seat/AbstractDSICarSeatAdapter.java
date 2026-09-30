/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.seat;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public abstract class AbstractDSICarSeatAdapter
extends AbstractCarComponent
implements DSICarSeatListener {
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeatListener;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeat;

    public AbstractDSICarSeatAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarSeat getDSI() {
        return (DSICarSeat)this.getBaseDSI();
    }

    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carseat$DSICarSeatListener == null ? (class$org$dsi$ifc$carseat$DSICarSeatListener = AbstractDSICarSeatAdapter.class$("org.dsi.ifc.carseat.DSICarSeatListener")) : class$org$dsi$ifc$carseat$DSICarSeatListener).getName();
    }

    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carseat$DSICarSeat == null ? (class$org$dsi$ifc$carseat$DSICarSeat = AbstractDSICarSeatAdapter.class$("org.dsi.ifc.carseat.DSICarSeat")) : class$org$dsi$ifc$carseat$DSICarSeat).getName();
    }

    public final boolean isUsingDSI() {
        return true;
    }

    public void updateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        this.logStub();
    }

    public void updateSeatRadioKeyAutomatic(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition, int n) {
        this.logStub();
    }

    public void updateSeatFrontLeftStopButton(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatFrontRightStopButton(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatCodriverSettingsFromDriver(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatCodriverSettingsFromRear(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageData1RL(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatMassageData1RR(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatContent(SeatContent seatContent, int n) {
        this.logStub();
    }

    public void updateSeatEasyEntryFrontLeft(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatEasyEntryFrontRight(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatEasyEntryRearLeft(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatEasyEntryRearRight(boolean bl, int n) {
        this.logStub();
    }

    public void requestSeatPopup(SeatContent seatContent) {
        this.logStub();
    }

    public void acknowledgeSeatPopup(SeatContent seatContent) {
        this.logStub();
    }

    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions seatPneumaticViewOptions, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticMassageData1RL(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticMassageData1RR(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatPneumaticContent(SeatPneumaticContent seatPneumaticContent, int n) {
        this.logStub();
    }

    public void requestSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        this.logStub();
    }

    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        this.logStub();
    }

    public void acknowledgeSeatSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition, int n) {
        this.logStub();
    }

    public void updateSeatRearLeftStopButton(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatRearRightStopButton(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageData2RL(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatMassageData2RR(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown switcherDataUpDown, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward switcherDataBackForward, int n) {
        this.logStub();
    }

    public void acknowledgeSeatDeleteSpecialPosition(boolean bl) {
        this.logStub();
    }

    public void acknowledgeSeatMoveRearSeatDisplay(boolean bl) {
        this.logStub();
    }

    public void updateSeatAdjustment1RL(SeatAdjustment seatAdjustment, int n) {
        this.logStub();
    }

    public void updateSeatAdjustment1RR(SeatAdjustment seatAdjustment, int n) {
        this.logStub();
    }

    public void updateSeatAdjustment2RL(SeatAdjustment seatAdjustment, int n) {
        this.logStub();
    }

    public void updateSeatAdjustment2RR(SeatAdjustment seatAdjustment, int n) {
        this.logStub();
    }

    public void updateSeatCoDriverSettingsFromRearActivation(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatRestSeatStatus(int n, int n2) {
        this.logStub();
    }

    public void updateSeatFoldHeadRestRearDriver(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatFoldHeadRestRearCoDriver(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatRestSeatStatus(RestSeatStatus restSeatStatus, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageData1RL(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageData1RR(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageData2RL(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageData2RR(MassageData massageData, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageSwitcher1RL(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageSwitcher1RR(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageSwitcher2RL(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatPremiumMassageSwitcher2RR(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageSwitcher1RL(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageSwitcher1RR(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageSwitcher2RL(boolean bl, int n) {
        this.logStub();
    }

    public void updateSeatMassageSwitcher2RR(boolean bl, int n) {
        this.logStub();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

