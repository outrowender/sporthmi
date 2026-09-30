/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public class NullDSICarSeat
implements DSICarSeat {
    private final LogChannel logChan;

    public NullDSICarSeat(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatRadioKeyAutomatic(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatCodriverSettingsFromRear(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatCodriverSettingsFromDriver(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatEasyEntryFrontLeft(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatEasyEntryFrontRight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatEasyEntryRearLeft(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatEasyEntryRearRight(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void showSeatPopup(SeatContent seatContent) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void cancelSeatPopup(SeatContent seatContent, int n) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatHMIIsReady(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatPneumaticSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void startSeatMoveRearSeatDisplay() {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void abortSeatMoveRearSeatDisplay() {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatMassageData(int n, MassageData massageData) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatFoldHeadRestRearDriver(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatStopButton(int n, boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatPremiumMassageData(int n, MassageData massageData) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }

    public void setSeatMassageSwitcher(int n, boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarSeat");
    }
}

