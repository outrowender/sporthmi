/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarSeatReply {
    public static final String IPL_COMM_UUID = "21b97a0b-812b-5d11-a709-028b7bf33cd2";
    public static final String IPL_COMM_INTERFACE_KEY = "b7b75143-6736-5b96-9460-67acad1509d9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public void updateSeatViewOptions(SeatViewOptions var1, int var2) throws MethodException;

    public void updateSeatRadioKeyAutomatic(boolean var1, int var2) throws MethodException;

    public void updateSeatSpecialPosition(SeatSpecialPosition var1, int var2) throws MethodException;

    public void updateSeatSpecialPositionRearCoDriver(SeatSpecialPosition var1, int var2) throws MethodException;

    public void updateSeatFrontLeftStopButton(boolean var1, int var2) throws MethodException;

    public void updateSeatFrontRightStopButton(boolean var1, int var2) throws MethodException;

    public void updateSeatRearLeftStopButton(boolean var1, int var2) throws MethodException;

    public void updateSeatRearRightStopButton(boolean var1, int var2) throws MethodException;

    public void updateSeatCodriverSettingsFromDriver(boolean var1, int var2) throws MethodException;

    public void updateSeatCodriverSettingsFromRear(boolean var1, int var2) throws MethodException;

    public void updateSeatMassageData1RL(MassageData var1, int var2) throws MethodException;

    public void updateSeatMassageData1RR(MassageData var1, int var2) throws MethodException;

    public void updateSeatMassageData2RL(MassageData var1, int var2) throws MethodException;

    public void updateSeatMassageData2RR(MassageData var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataUp1RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataDown1RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataForward1RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataBack1RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataUp1RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataDown1RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataForward1RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataBack1RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataUp2RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataDown2RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataForward2RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataBack2RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataUp2RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataDown2RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataForward2RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatSwitcherDataBack2RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatContent(SeatContent var1, int var2) throws MethodException;

    public void updateSeatEasyEntryFrontLeft(boolean var1, int var2) throws MethodException;

    public void updateSeatEasyEntryFrontRight(boolean var1, int var2) throws MethodException;

    public void updateSeatEasyEntryRearLeft(boolean var1, int var2) throws MethodException;

    public void updateSeatEasyEntryRearRight(boolean var1, int var2) throws MethodException;

    public void requestSeatPopup(SeatContent var1) throws MethodException;

    public void acknowledgeSeatPopup(SeatContent var1) throws MethodException;

    public void updateSeatPneumaticViewOptions(SeatPneumaticViewOptions var1, int var2) throws MethodException;

    public void updateSeatPneumaticCodriverSettingsFromDriver(boolean var1, int var2) throws MethodException;

    public void updateSeatPneumaticMassageData1RL(MassageData var1, int var2) throws MethodException;

    public void updateSeatPneumaticMassageData1RR(MassageData var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataUp1RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataDown1RL(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataForward1RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataBack1RL(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataUp1RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataDown1RR(SwitcherDataUpDown var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataForward1RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatPneumaticSwitcherDataBack1RR(SwitcherDataBackForward var1, int var2) throws MethodException;

    public void updateSeatPneumaticContent(SeatPneumaticContent var1, int var2) throws MethodException;

    public void requestSeatPneumaticPopup(SeatPneumaticContent var1) throws MethodException;

    public void acknowledgeSeatPneumaticPopup(SeatPneumaticContent var1) throws MethodException;

    public void acknowledgeSeatSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeSeatPneumaticSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeSeatDeleteSpecialPosition(boolean var1) throws MethodException;

    public void acknowledgeSeatMoveRearSeatDisplay(boolean var1) throws MethodException;

    public void updateSeatAdjustment1RL(SeatAdjustment var1, int var2) throws MethodException;

    public void updateSeatAdjustment1RR(SeatAdjustment var1, int var2) throws MethodException;

    public void updateSeatAdjustment2RL(SeatAdjustment var1, int var2) throws MethodException;

    public void updateSeatAdjustment2RR(SeatAdjustment var1, int var2) throws MethodException;

    public void updateSeatCoDriverSettingsFromRearActivation(boolean var1, int var2) throws MethodException;

    public void updateSeatRestSeatStatus(RestSeatStatus var1, int var2) throws MethodException;

    public void updateSeatFoldHeadRestRearDriver(boolean var1, int var2) throws MethodException;

    public void updateSeatFoldHeadRestRearCoDriver(boolean var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageData1RL(MassageData var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageData1RR(MassageData var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageData2RL(MassageData var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageData2RR(MassageData var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageSwitcher1RL(boolean var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageSwitcher1RR(boolean var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageSwitcher2RL(boolean var1, int var2) throws MethodException;

    public void updateSeatPremiumMassageSwitcher2RR(boolean var1, int var2) throws MethodException;

    public void updateSeatMassageSwitcher1RL(boolean var1, int var2) throws MethodException;

    public void updateSeatMassageSwitcher1RR(boolean var1, int var2) throws MethodException;

    public void updateSeatMassageSwitcher2RL(boolean var1, int var2) throws MethodException;

    public void updateSeatMassageSwitcher2RR(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

