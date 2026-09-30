/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.base.DSIListener;
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

public interface DSICarSeatListener
extends DSIListener {
    public void updateSeatViewOptions(SeatViewOptions var1, int var2);

    public void updateSeatRadioKeyAutomatic(boolean var1, int var2);

    public void updateSeatSpecialPosition(SeatSpecialPosition var1, int var2);

    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition var1, int var2);

    public void updateSeatFrontLeftStopButton(boolean var1, int var2);

    public void updateSeatFrontRightStopButton(boolean var1, int var2);

    public void updateSeatRearLeftStopButton(boolean var1, int var2);

    public void updateSeatRearRightStopButton(boolean var1, int var2);

    public void updateSeatCodriverSettingsFromDriver(boolean var1, int var2);

    public void updateSeatCodriverSettingsFromRear(boolean var1, int var2);

    public void updateSeatMassageData1RL(MassageData var1, int var2);

    public void updateSeatMassageData1RR(MassageData var1, int var2);

    public void updateSeatMassageData2RL(MassageData var1, int var2);

    public void updateSeatMassageData2RR(MassageData var1, int var2);

    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatContent(SeatContent var1, int var2);

    public void updateSeatEasyEntryFrontLeft(boolean var1, int var2);

    public void updateSeatEasyEntryFrontRight(boolean var1, int var2);

    public void updateSeatEasyEntryRearLeft(boolean var1, int var2);

    public void updateSeatEasyEntryRearRight(boolean var1, int var2);

    public void requestSeatPopup(SeatContent var1);

    public void acknowledgeSeatPopup(SeatContent var1);

    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions var1, int var2);

    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean var1, int var2);

    public void updateSeatPneumaticMassageData1RL(MassageData var1, int var2);

    public void updateSeatPneumaticMassageData1RR(MassageData var1, int var2);

    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown var1, int var2);

    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward var1, int var2);

    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown var1, int var2);

    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward var1, int var2);

    public void updateSeatPneumaticContent(SeatPneumaticContent var1, int var2);

    public void requestSeatPneumaticPopup(SeatPneumaticContent var1);

    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent var1);

    public void acknowledgeSeatSetFactoryDefault(boolean var1);

    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean var1);

    public void acknowledgeSeatDeleteSpecialPosition(boolean var1);

    public void acknowledgeSeatMoveRearSeatDisplay(boolean var1);

    public void updateSeatAdjustment1RL(SeatAdjustment var1, int var2);

    public void updateSeatAdjustment1RR(SeatAdjustment var1, int var2);

    public void updateSeatAdjustment2RL(SeatAdjustment var1, int var2);

    public void updateSeatAdjustment2RR(SeatAdjustment var1, int var2);

    public void updateSeatCoDriverSettingsFromRearActivation(boolean var1, int var2);

    public void updateSeatRestSeatStatus(RestSeatStatus var1, int var2);

    public void updateSeatFoldHeadRestRearDriver(boolean var1, int var2);

    public void updateSeatFoldHeadRestRearCoDriver(boolean var1, int var2);

    public void updateSeatPremiumMassageData1RL(MassageData var1, int var2);

    public void updateSeatPremiumMassageData1RR(MassageData var1, int var2);

    public void updateSeatPremiumMassageData2RL(MassageData var1, int var2);

    public void updateSeatPremiumMassageData2RR(MassageData var1, int var2);

    public void updateSeatPremiumMassageSwitcher1RL(boolean var1, int var2);

    public void updateSeatPremiumMassageSwitcher1RR(boolean var1, int var2);

    public void updateSeatPremiumMassageSwitcher2RL(boolean var1, int var2);

    public void updateSeatPremiumMassageSwitcher2RR(boolean var1, int var2);

    public void updateSeatMassageSwitcher1RL(boolean var1, int var2);

    public void updateSeatMassageSwitcher1RR(boolean var1, int var2);

    public void updateSeatMassageSwitcher2RL(boolean var1, int var2);

    public void updateSeatMassageSwitcher2RR(boolean var1, int var2);
}

