/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;

public interface DSICarSeat
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int ATTR_SEATVIEWOPTIONS = 1;
    public static final int ATTR_SEATRADIOKEYAUTOMATIC = 2;
    public static final int ATTR_SEATSPECIALPOSITION = 3;
    public static final int ATTR_SEATFRONTLEFTSTOPBUTTON = 4;
    public static final int ATTR_SEATFRONTRIGHTSTOPBUTTON = 5;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMDRIVER = 6;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMREAR = 7;
    public static final int ATTR_SEATMASSAGEDATA1RL = 8;
    public static final int ATTR_SEATMASSAGEDATA1RR = 9;
    public static final int ATTR_SEATSWITCHERDATAUP1RL = 10;
    public static final int ATTR_SEATSWITCHERDATADOWN1RL = 11;
    public static final int ATTR_SEATSWITCHERDATAFORWARD1RL = 12;
    public static final int ATTR_SEATSWITCHERDATABACK1RL = 13;
    public static final int ATTR_SEATSWITCHERDATAUP1RR = 14;
    public static final int ATTR_SEATSWITCHERDATADOWN1RR = 15;
    public static final int ATTR_SEATSWITCHERDATAFORWARD1RR = 16;
    public static final int ATTR_SEATSWITCHERDATABACK1RR = 17;
    public static final int ATTR_SEATCONTENT = 18;
    public static final int ATTR_SEATEASYENTRYFRONTLEFT = 19;
    public static final int ATTR_SEATEASYENTRYFRONTRIGHT = 20;
    public static final int ATTR_SEATEASYENTRYREARLEFT = 21;
    public static final int ATTR_SEATEASYENTRYREARRIGHT = 22;
    public static final int ATTR_SEATPNEUMATICVIEWOPTIONS = 23;
    public static final int ATTR_SEATPNEUMATICCODRIVERSETTINGSFROMDRIVER = 24;
    public static final int ATTR_SEATPNEUMATICMASSAGEDATA1RL = 25;
    public static final int ATTR_SEATPNEUMATICMASSAGEDATA1RR = 26;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAUP1RL = 27;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATADOWN1RL = 28;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAFORWARD1RL = 29;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATABACK1RL = 30;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAUP1RR = 31;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATADOWN1RR = 32;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATAFORWARD1RR = 33;
    public static final int ATTR_SEATPNEUMATICSWITCHERDATABACK1RR = 34;
    public static final int ATTR_SEATPNEUMATICCONTENT = 35;
    public static final int ATTR_SEATREARLEFTSTOPBUTTON = 36;
    public static final int ATTR_SEATREARRIGHTSTOPBUTTON = 37;
    public static final int ATTR_SEATMASSAGEDATA2RL = 38;
    public static final int ATTR_SEATMASSAGEDATA2RR = 39;
    public static final int ATTR_SEATSWITCHERDATAUP2RL = 40;
    public static final int ATTR_SEATSWITCHERDATADOWN2RL = 41;
    public static final int ATTR_SEATSWITCHERDATAFORWARD2RL = 42;
    public static final int ATTR_SEATSWITCHERDATABACK2RL = 43;
    public static final int ATTR_SEATSWITCHERDATAUP2RR = 44;
    public static final int ATTR_SEATSWITCHERDATADOWN2RR = 45;
    public static final int ATTR_SEATSWITCHERDATAFORWARD2RR = 46;
    public static final int ATTR_SEATSWITCHERDATABACK2RR = 47;
    public static final int ATTR_SEATADJUSTMENT1RL = 48;
    public static final int ATTR_SEATADJUSTMENT1RR = 49;
    public static final int ATTR_SEATADJUSTMENT2RL = 50;
    public static final int ATTR_SEATADJUSTMENT2RR = 51;
    public static final int ATTR_SEATSPECIALPOSITIONREARCODRIVER = 52;
    public static final int ATTR_SEATCODRIVERSETTINGSFROMREARACTIVATION = 53;
    public static final int ATTR_SEATRESTSEATSTATUS = 54;
    public static final int ATTR_SEATFOLDHEADRESTREARDRIVER = 55;
    public static final int ATTR_SEATFOLDHEADRESTREARCODRIVER = 56;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA1RL = 57;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA1RR = 58;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA2RL = 59;
    public static final int ATTR_SEATPREMIUMMASSAGEDATA2RR = 60;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER1RL = 61;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER1RR = 62;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER2RL = 63;
    public static final int ATTR_SEATPREMIUMMASSAGESWITCHER2RR = 64;
    public static final int ATTR_SEATMASSAGESWITCHER1RL = 65;
    public static final int ATTR_SEATMASSAGESWITCHER1RR = 66;
    public static final int ATTR_SEATMASSAGESWITCHER2RL = 67;
    public static final int ATTR_SEATMASSAGESWITCHER2RR = 68;
    public static final int SEATSPECIALPOSITIONS_NONE = 0;
    public static final int SEATSPECIALPOSITIONS_COMFORTVIEW = 1;
    public static final int SEATSPECIALPOSITIONS_SEATSYMMETRY = 2;
    public static final int SEATSPECIALPOSITIONS_NORMALPOSITION = 3;
    public static final int SEATSPECIALPOSITIONS_RELAXPOSITION = 4;
    public static final int SEATSPECIALPOSITIONS_BUSINESSPOSITION = 5;
    public static final int MEMORYDETAIL_MEMORY_NONE = 0;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED = 1;
    public static final int MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED = 2;
    public static final int MEMORYDETAIL_SET_PRESS_PROGRAM = 3;
    public static final int MEMORYDETAIL_SET_PRESS_ON_OFF = 4;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_ON_OFF = 5;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_SET = 6;
    public static final int MEMORYDETAIL_PROGRAM_PRESS_PROGRAM = 7;
    public static final int MEMORYDETAIL_RADIOKEY_PRESS_PROGRAM = 8;
    public static final int SEATPOSITION_NO_SEAT = 0;
    public static final int SEATPOSITION_SEAT_1RL = 1;
    public static final int SEATPOSITION_SEAT_1RR = 2;
    public static final int SEATPOSITION_SEAT_2RL = 3;
    public static final int SEATPOSITION_SEAT_2RR = 4;
    public static final int SEATPOSITION_SEAT_3RL = 5;
    public static final int SEATPOSITION_SEAT_3RR = 6;
    public static final int SEATCONTENT_NONE = 0;
    public static final int SEATCONTENT_GURTHOEHE = 1;
    public static final int SEATCONTENT_LEHNENKOPF = 2;
    public static final int SEATCONTENT_LORDOSE = 3;
    public static final int SEATCONTENT_SEITENWANGEN = 4;
    public static final int SEATCONTENT_SITZTIEFE = 5;
    public static final int SEATCONTENT_MASSAGE = 6;
    public static final int SEATCONTENT_MEMORY = 7;
    public static final int SEATCONTENT_LEHNENWANGEN = 8;
    public static final int SEATCONTENT_SITZWANGEN = 9;
    public static final int SEATCONTENT_MENU = 10;
    public static final int SEATPNEUMATICCONTENT_NONE = 0;
    public static final int SEATPNEUMATICCONTENT_GURTHOEHE = 1;
    public static final int SEATPNEUMATICCONTENT_LEHNENKOPF = 2;
    public static final int SEATPNEUMATICCONTENT_LORDOSE = 3;
    public static final int SEATPNEUMATICCONTENT_SEITENWANGEN = 4;
    public static final int SEATPNEUMATICCONTENT_SITZTIEFE = 5;
    public static final int SEATPNEUMATICCONTENT_MASSAGE = 6;
    public static final int SEATADJUSTMENTPOSITION_NONE = 0;
    public static final int SEATADJUSTMENTPOSITION_INCREASE = 1;
    public static final int SEATADJUSTMENTPOSITION_DECREASE = 2;
    public static final int RESTSEATSTATUSMESSAGE_NONE = 0;
    public static final int RESTSEATSTATUSMESSAGE_CODRIVERSEAT_AT_RESTSEAT_POSITION = 1;
    public static final int RESTSEATSTATUSMESSAGE_DISPLAY_DOWN = 2;
    public static final int RESTSEATSTATUSMESSAGE_DISPLAY_OR_RESTSEAT_MOVING = 3;
    public static final int RT_SETSEATRADIOKEYAUTOMATIC = 1000;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMREAR = 1001;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMDRIVER = 1002;
    public static final int RT_SETSEATEASYENTRYFRONTLEFT = 1003;
    public static final int RT_SETSEATEASYENTRYFRONTRIGHT = 1004;
    public static final int RT_SETSEATEASYENTRYREARLEFT = 1005;
    public static final int RT_SETSEATEASYENTRYREARRIGHT = 1006;
    public static final int RT_SETSEATSPECIALPOSITION = 1007;
    public static final int RT_SHOWSEATPOPUP = 1008;
    public static final int RT_CANCELSEATPOPUP = 1009;
    public static final int RT_SETSEATHMIISREADY = 1010;
    public static final int RT_SHOWSEATPNEUMATICPOPUP = 1011;
    public static final int RT_CANCELSEATPNEUMATICPOPUP = 1012;
    public static final int RT_SETSEATPNEUMATICCODRIVERSETTINGSFROMDRIVER = 1013;
    public static final int RT_SETSEATSETFACTORYDEFAULT = 1014;
    public static final int RT_SETSEATPNEUMATICSETFACTORYDEFAULT = 1015;
    public static final int RT_STARTSEATMOVEREARSEATDISPLAY = 1016;
    public static final int RT_ABORTSEATMOVEREARSEATDISPLAY = 1017;
    public static final int RT_SETSEATMASSAGEDATA = 1018;
    public static final int RT_SETSEATSWITCHERDATAUP = 1019;
    public static final int RT_SETSEATSWITCHERDATADOWN = 1020;
    public static final int RT_SETSEATSWITCHERDATAFORWARD = 1021;
    public static final int RT_SETSEATSWITCHERDATABACK = 1022;
    public static final int RT_SETSEATADJUSTMENT = 1023;
    public static final int RT_SETSEATSPECIALPOSITIONREARCODRIVER = 1024;
    public static final int RT_STARTSEATDELETESPECIALPOSITION = 1025;
    public static final int RT_SETSEATCODRIVERSETTINGSFROMREARACTIVATION = 1026;
    public static final int RT_SETSEATFOLDHEADRESTREARDRIVER = 1027;
    public static final int RT_SETSEATFOLDHEADRESTREARCODRIVER = 1028;
    public static final int RT_SETSEATSTOPBUTTON = 1029;
    public static final int RT_SETSEATPREMIUMMASSAGEDATA = 1030;
    public static final int RT_SETSEATPREMIUMMASSAGESWITCHER = 1031;
    public static final int RT_SETSEATMASSAGESWITCHER = 1032;
    public static final int RP_REQUESTSEATPOPUP = 2000;
    public static final int RP_ACKNOWLEDGESEATPOPUP = 2001;
    public static final int RP_REQUESTSEATPNEUMATICPOPUP = 2002;
    public static final int RP_ACKNOWLEDGESEATPNEUMATICPOPUP = 2003;
    public static final int RP_ACKNOWLEDGESEATSETFACTORYDEFAULT = 2004;
    public static final int RP_ACKNOWLEDGESEATPNEUMATICSETFACTORYDEFAULT = 2005;
    public static final int RP_ACKNOWLEDGESEATDELETESPECIALPOSITION = 2006;
    public static final int RP_ACKNOWLEDGESEATMOVEREARSEATDISPLAY = 2007;

    public void setSeatRadioKeyAutomatic(boolean var1);

    public void setSeatCodriverSettingsFromRear(boolean var1);

    public void setSeatCodriverSettingsFromDriver(boolean var1);

    public void setSeatEasyEntryFrontLeft(boolean var1);

    public void setSeatEasyEntryFrontRight(boolean var1);

    public void setSeatEasyEntryRearLeft(boolean var1);

    public void setSeatEasyEntryRearRight(boolean var1);

    public void setSeatSpecialPosition(SeatSpecialPosition var1);

    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition var1);

    public void showSeatPopup(SeatContent var1);

    public void cancelSeatPopup(SeatContent var1, int var2);

    public void setSeatHMIIsReady(boolean var1);

    public void setSeatPneumaticCodriverSettingsFromDriver(boolean var1);

    public void showSeatPneumaticPopup(SeatPneumaticContent var1);

    public void cancelSeatPneumaticPopup(SeatPneumaticContent var1, int var2);

    public void setSeatSetFactoryDefault();

    public void setSeatPneumaticSetFactoryDefault();

    public void startSeatMoveRearSeatDisplay();

    public void abortSeatMoveRearSeatDisplay();

    public void setSeatMassageData(int var1, MassageData var2);

    public void setSeatSwitcherDataUp(int var1, SwitcherDataUpDown var2);

    public void setSeatSwitcherDataDown(int var1, SwitcherDataUpDown var2);

    public void setSeatSwitcherDataForward(int var1, SwitcherDataBackForward var2);

    public void setSeatSwitcherDataBack(int var1, SwitcherDataBackForward var2);

    public void setSeatAdjustment(int var1, SeatAdjustment var2);

    public void startSeatDeleteSpecialPosition(boolean var1, boolean var2);

    public void setSeatCoDriverSettingsFromRearActivation(boolean var1);

    public void setSeatFoldHeadRestRearDriver(boolean var1);

    public void setSeatFoldHeadRestRearCoDriver(boolean var1);

    public void setSeatStopButton(int var1, boolean var2);

    public void setSeatPremiumMassageData(int var1, MassageData var2);

    public void setSeatPremiumMassageSwitcher(int var1, boolean var2);

    public void setSeatMassageSwitcher(int var1, boolean var2);
}

