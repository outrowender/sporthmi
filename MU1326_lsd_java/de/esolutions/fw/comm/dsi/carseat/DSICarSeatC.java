/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public interface DSICarSeatC {
    public void setSeatRadioKeyAutomatic(boolean var1) throws MethodException;

    public void setSeatCodriverSettingsFromRear(boolean var1) throws MethodException;

    public void setSeatCodriverSettingsFromDriver(boolean var1) throws MethodException;

    public void setSeatEasyEntryFrontLeft(boolean var1) throws MethodException;

    public void setSeatEasyEntryFrontRight(boolean var1) throws MethodException;

    public void setSeatEasyEntryRearLeft(boolean var1) throws MethodException;

    public void setSeatEasyEntryRearRight(boolean var1) throws MethodException;

    public void setSeatSpecialPosition(SeatSpecialPosition var1) throws MethodException;

    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition var1) throws MethodException;

    public void showSeatPopup(SeatContent var1) throws MethodException;

    public void cancelSeatPopup(SeatContent var1, int var2) throws MethodException;

    public void setSeatHMIIsReady(boolean var1) throws MethodException;

    public void setSeatPneumaticCodriverSettingsFromDriver(boolean var1) throws MethodException;

    public void showSeatPneumaticPopup(SeatPneumaticContent var1) throws MethodException;

    public void cancelSeatPneumaticPopup(SeatPneumaticContent var1, int var2) throws MethodException;

    public void setSeatSetFactoryDefault() throws MethodException;

    public void setSeatPneumaticSetFactoryDefault() throws MethodException;

    public void startSeatMoveRearSeatDisplay() throws MethodException;

    public void abortSeatMoveRearSeatDisplay() throws MethodException;

    public void setSeatMassageData(int var1, MassageData var2) throws MethodException;

    public void setSeatSwitcherDataUp(int var1, SwitcherDataUpDown var2) throws MethodException;

    public void setSeatSwitcherDataDown(int var1, SwitcherDataUpDown var2) throws MethodException;

    public void setSeatSwitcherDataForward(int var1, SwitcherDataBackForward var2) throws MethodException;

    public void setSeatSwitcherDataBack(int var1, SwitcherDataBackForward var2) throws MethodException;

    public void setSeatAdjustment(int var1, SeatAdjustment var2) throws MethodException;

    public void startSeatDeleteSpecialPosition(boolean var1, boolean var2) throws MethodException;

    public void setSeatCoDriverSettingsFromRearActivation(boolean var1) throws MethodException;

    public void setSeatFoldHeadRestRearDriver(boolean var1) throws MethodException;

    public void setSeatFoldHeadRestRearCoDriver(boolean var1) throws MethodException;

    public void setSeatStopButton(int var1, boolean var2) throws MethodException;

    public void setSeatPremiumMassageData(int var1, MassageData var2) throws MethodException;

    public void setSeatPremiumMassageSwitcher(int var1, boolean var2) throws MethodException;

    public void setSeatMassageSwitcher(int var1, boolean var2) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

