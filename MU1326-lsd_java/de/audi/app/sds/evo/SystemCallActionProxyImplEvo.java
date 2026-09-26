/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sds.evo;

import de.audi.app.sdsmanager.common.SDSListener;
import de.audi.app.sdsmanager.syscall.SystemCall;
import de.audi.atip.statemachine.ap.SystemCallActionProxy;

public class SystemCallActionProxyImplEvo
implements SystemCallActionProxy {
    private SDSListener sds;

    public void setSDSListener(SDSListener sDSListener) {
        this.sds = sDSListener;
    }

    @Override
    public void adbDestByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(0x70110100, n2));
    }

    @Override
    public void adbDestSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(0x71110100, n2));
    }

    @Override
    public void adbListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1913716992, n2));
    }

    @Override
    public void adbListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1930494208, n2));
    }

    @Override
    public void adbEntrySelectionInterrupt(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1947271424, bl));
    }

    @Override
    public void adbMsgDictateActivate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-936640256));
    }

    @Override
    public void adbMsgDictateDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-903085824, n2));
    }

    @Override
    public void adbMsgDictateFinish(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-869531392));
    }

    @Override
    public void adbMsgReadoutFinish(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-131858176));
    }

    @Override
    public void adbMsgDictateRecog(int n, int n2) {
    }

    @Override
    public void adbMsgDictateStart(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-802422528, n2));
    }

    @Override
    public void msgClearRecipient(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-919863040));
    }

    @Override
    public void adbMsgDictateStop(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-785645312));
    }

    @Override
    public void adbMsgDictateVoiceDataAvailable(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-768868096));
    }

    public void adbMsgNumberAdd(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-115080960, n2));
    }

    @Override
    public void msgAddRecipient(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-115080960, n2));
    }

    @Override
    public void adbMsgReadoutRecog(int n, boolean bl, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-81526528, bl, n2, n3));
    }

    @Override
    public void adbMsgReadoutDetail(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-64749312));
    }

    @Override
    public void adbMsgSend(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-47972096));
    }

    @Override
    public void adbNavigateToRecog(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1964048640));
    }

    @Override
    public void adbNumberByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1980825856, n2));
    }

    @Override
    public void adbCategorySet(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(0x77110100, n2, n3));
    }

    @Override
    public void adbTopRecEntryOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2014380288, n2));
    }

    @Override
    public void adbDetailListLineTypeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2064711936));
    }

    @Override
    public void mediaDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20000, n2));
    }

    @Override
    public void mediaPlaymodeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20021, n2));
    }

    @Override
    public void mediaG2POneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20003, n2));
    }

    @Override
    public void mediaFolderUp(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20015));
    }

    @Override
    public void mediaListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20016, n2));
    }

    @Override
    public void mediaFolderSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20017, n2));
    }

    @Override
    public void mediaListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20019, n2));
    }

    @Override
    public void mediaMediumSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20020, n2));
    }

    @Override
    public void naviBlockRouteValueSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1100742656, n2));
    }

    @Override
    public void naviFillPromptLabels(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1885601792));
    }

    @Override
    public void naviDestinationDelete(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1134297088));
    }

    @Override
    public void naviDestinationAvailable(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1151074304, n2));
    }

    @Override
    public void naviDestinationGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1167851520, n2));
    }

    @Override
    public void naviDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1201405952, n2));
    }

    @Override
    public void naviDestinationStatus(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1234960384));
    }

    @Override
    public void naviSpellingMode(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1251737600, bl));
    }

    @Override
    public void naviSpellingModeCorrection(int n, int n2, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1268514816, n2, bl));
    }

    @Override
    public void naviCheckRouteGuidance(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1302069248));
    }

    @Override
    public void naviRouteGuidanceTypeSet(int n, int n2) {
    }

    @Override
    public void naviAlternativeRouteNumberSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1335623680, n2));
    }

    @Override
    public void naviGuidanceSet(int n, int n2, boolean bl) {
    }

    @Override
    public void naviHousenumberCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1385955328));
    }

    @Override
    public void naviHousenumberResolve(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1768161280, n2));
    }

    @Override
    public void naviHousenumberSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1402732544));
    }

    @Override
    public void naviHomeSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1419509760));
    }

    @Override
    public void naviHomeSave(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2073821184));
    }

    @Override
    public void naviGetInfo(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1436286976));
    }

    @Override
    public void naviInputStarted(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1486618624, n2));
    }

    @Override
    public void naviListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1520173056, n2));
    }

    @Override
    public void naviListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1553727488, n2));
    }

    @Override
    public void naviMapOptionsSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1570504704, n2));
    }

    @Override
    public void naviPOISearchAreaSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1637613568, n2));
    }

    @Override
    public void naviPOIValueSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1755054080, n2));
    }

    @Override
    public void naviPOIOnlineSearchAreaSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1805385728, n2));
    }

    @Override
    public void naviPOIOnlineSearchInit(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1855717376, n2));
    }

    @Override
    public void naviPOIOnlineSearchCancel(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1838940160));
    }

    @Override
    public void naviPOIOnlineRecog(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1788608512, bl));
    }

    public void naviPOIHistoryEntryUnique(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1801715712));
    }

    @Override
    public void naviPOIHistoryEntryUnique(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1801715712, n2));
    }

    @Override
    public void naviPostCodeCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1939603456));
    }

    @Override
    public void naviRouteOptionsSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1956380672, n2));
    }

    @Override
    public void naviInputModeCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1469841408));
    }

    @Override
    public void naviTMCReadout(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1989935104));
    }

    @Override
    public void naviVoiceGuidanceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2006712320, n2));
    }

    @Override
    public void naviVDEOneshotIsAmbiguous(int n) {
        this.sds.processCommand(new SystemCall(2023489536));
    }

    @Override
    public void naviVDEOneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2040266752, n2));
    }

    @Override
    public void naviOneshotIsAmbiguous(int n) {
        this.sds.processCommand(new SystemCall(-1751384064));
    }

    @Override
    public void naviOneshotFilterPicklist(int n, int n2) {
        this.sds.processCommand(new SystemCall(-1734606848, n2));
    }

    @Override
    public void systemOneshotInitialize(int n, int n2) {
        this.sds.processCommand(new SystemCall(1064, n2));
    }

    @Override
    public void phoneCallMailbox(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30000));
    }

    @Override
    public void phoneNumberAdd(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30002, n2));
    }

    @Override
    public void phoneNumberDelete(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30003, n2, n3));
    }

    @Override
    public void phoneNumberDial(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30004, n2, n3));
    }

    @Override
    public void phoneNumberGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30005, n2));
    }

    @Override
    public void phoneRedialNumber(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30006));
    }

    @Override
    public void systemAbortStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1000));
    }

    @Override
    public void systemAnyCalled(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1001));
    }

    @Override
    public void systemCommandListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1002, n2));
    }

    @Override
    public void systemCommandListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1003, n2));
    }

    @Override
    public void systemCommandModeSet(int n, int n2, int n3, int n4) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1007, n2, n3, n4));
    }

    @Override
    public void systemCorrectionCase(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1010));
    }

    @Override
    public void systemStorePicklistInHistory(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1052));
    }

    @Override
    public void systemCounterIncrement(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1012));
    }

    @Override
    public void systemCounterReset(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1013));
    }

    @Override
    public void systemCounterSecondIncrement(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1014));
    }

    @Override
    public void systemCounterSecondReset(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1015));
    }

    @Override
    public void systemIncrementModel(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1017, n2));
    }

    @Override
    public void systemJumpPointAction(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1019));
    }

    @Override
    public void systemListClear(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1020));
    }

    @Override
    public void systemListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1021, n2));
    }

    @Override
    public void systemListLineDataGet(int n, String string) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1022, string));
    }

    @Override
    public void systemListLineGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1023));
    }

    @Override
    public void systemListLineSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1024, bl));
    }

    @Override
    public void systemListPageSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1025, n2));
    }

    @Override
    public void systemListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1027, n2));
    }

    @Override
    public void systemPlayBeep(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1032, 0));
    }

    @Override
    public void systemPosttrainingOK(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1033, bl));
    }

    @Override
    public void systemGraphemicGroupRecognized(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1035));
    }

    @Override
    public void systemSessionEnd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1038));
    }

    @Override
    public void systemSessionStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1039));
    }

    @Override
    public void systemSessionWait(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1049));
    }

    @Override
    public void systemStartRecognition(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1041, n2, n3));
    }

    @Override
    public void systemStateSet(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1043, n2, n3));
    }

    @Override
    public void systemTTSAbort(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1044));
    }

    @Override
    public void tunerCategorySet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10000, n2));
    }

    @Override
    public void tunerFrequencySet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10001));
    }

    @Override
    public void tunerStationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10002, n2));
    }

    @Override
    public void tunerTrafficProgramSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10004, bl));
    }

    @Override
    public void tunerWavebandSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10005, n2));
    }

    @Override
    public void onlineSetRemoteHMIResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1921123072));
    }

    @Override
    public void onlineSetRemoteHMIGlobalResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1937900288));
    }

    @Override
    public void onlineSetRemoteHMIHelpResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1954677504));
    }

    @Override
    public void onlineRequestDialogContinuation(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1971454720));
    }

    @Override
    public void onlineDialogStepFinished(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1988231936));
    }

    @Override
    public void onlineHelpOpened(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2005009152, n2));
    }

    @Override
    public void onlineSetRemoteHMINavDestFormResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2021786368));
    }

    @Override
    public void onlineSetRemoteHMIGlobalEnter(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2038563584));
    }

    @Override
    public void systemContextSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1045, n2));
    }

    @Override
    public void adbMsgPrepareDictation(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-886308608, n2));
    }

    @Override
    public void systemStopRecognition(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1042));
    }

    @Override
    public void mediaListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20023));
    }

    @Override
    public void mediaDynDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20024, n2));
    }

    @Override
    public void tunerListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10006, n2));
    }

    @Override
    public void tunerListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10007, n2));
    }

    @Override
    public void tunerGenreSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10003, n2));
    }

    @Override
    public void adbListLineDataGet(int n, String string) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2047934720, string));
    }

    @Override
    public void systemWaitState(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1046));
    }

    @Override
    public void tunerListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10008));
    }

    @Override
    public void naviSpeedLimitGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1922826240));
    }

    @Override
    public void naviListLineDataGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1973157888, n2));
    }

    @Override
    public void systemDisambiguationListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1047, n2));
    }

    @Override
    public void systemDisambiguationListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1048, n2));
    }

    @Override
    public void phoneLineDataGetType(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30008, n2));
    }

    @Override
    public void phoneListEntrySelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30007, n2));
    }

    @Override
    public void tunerListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10009));
    }

    @Override
    public void naviAddDestination(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2124152832, n2));
    }

    @Override
    public void naviGuidanceStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2090598400));
    }

    @Override
    public void naviGuidanceStop(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2107375616));
    }

    @Override
    public void naviAlternativeRouteCalc(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2140930048));
    }

    @Override
    public void mediaListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20025));
    }

    @Override
    public void phoneParamSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1053));
    }

    @Override
    public void mediaUSBDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20026, n2));
    }

    @Override
    public void systemSetModel(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1051, n2, n3));
    }

    @Override
    public void naviPOIOnlineShowList(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2137260032, n2));
    }

    @Override
    public void systemParamSetNLU(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1053, n2));
    }

    @Override
    public void systemSlotSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1030));
    }

    @Override
    public void mediaPlayItemCommand(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20001, n2, n3));
    }

    @Override
    public void naviPOIShortcutSet_Old(int n, int n2, int n3) {
    }

    @Override
    public void naviPOIShortcutSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1654390784, n2));
    }

    @Override
    public void phoneListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30010, n2));
    }

    @Override
    public void phoneListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30009, n2));
    }

    @Override
    public void phoneListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30011));
    }

    @Override
    public void naviPOICorrectionHandling(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1620836352));
    }

    @Override
    public void sdsScreenSynced(int n) {
    }

    @Override
    public void systemAbsoluteLineNumberSet(int n, boolean bl, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1055, bl, n2));
    }

    @Override
    public void naviPOIOnlineDidYouMean(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1822162944));
    }

    @Override
    public void systemListLineRequest(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1056));
    }

    @Override
    public void naviLastDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2103705600, n2));
    }

    @Override
    public void naviIntelliDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2019819520, n2));
    }

    @Override
    public void naviFavoriteDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2120482816, n2));
    }

    @Override
    public void msgListShow(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-31194880));
    }

    @Override
    public void msgListHide(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-14417664));
    }

    @Override
    public void msgListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2425088));
    }

    @Override
    public void naviSUITypeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2086928384));
    }

    @Override
    public void systemDisclaimerAccept(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1057, bl));
    }

    @Override
    public void systemConnectionAccept(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1029, n2));
    }

    @Override
    public void onlineRemoteHMISetRecognizedLineNumber(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2055340800));
    }

    @Override
    public void naviPOIOneshotIsAmbiguous(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2070151168));
    }

    @Override
    public void naviPOIOneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2053373952, n2));
    }

    @Override
    public void systemCursorHighlightLine(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1058, n2));
    }

    public void naviMyAudiContactsDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2036596736, n2));
    }

    @Override
    public void naviMyAudiContactSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2036596736, n2));
    }

    public void naviPOIPromptLabelSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2003042304));
    }

    @Override
    public void naviPOIPromptLabelSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-2003042304, n2));
    }

    @Override
    public void systemRemoveFromPicklistHistory(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1059, n2));
    }

    @Override
    public void naviOneshotStoreData(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1986265088, n2));
    }

    @Override
    public void systemTruffleSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1060));
    }

    @Override
    public void naviCheckBetterRoute(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1969487872));
    }

    @Override
    public void naviSetBypassRoute(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1952710656, bl));
    }

    @Override
    public void naviDetailsPhoneCall(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1935933440));
    }

    @Override
    public void naviPOIOnlineSelectDestination(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1919156224));
    }

    @Override
    public void phoneSiriActivate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30012));
    }

    @Override
    public void systemWaitForScreen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1061, n2));
    }

    @Override
    public void systemPromptTypeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1034, n2));
    }

    @Override
    public void naviBlockRouteSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1902379008));
    }

    @Override
    public void systemScreenFadeOut(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1062, n2));
    }

    @Override
    public void naviDestinationAvailableASIA(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1852047360, n2));
    }

    @Override
    public void naviEnterGeocoordinates(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1868824576));
    }

    @Override
    public void mediaPlayMusic(int n) {
    }

    @Override
    public void mediaG2POneshotIsAmbiguous(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20002, n2));
    }

    @Override
    public void mediaG2POneshotStoreData(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20004));
    }

    @Override
    public void systemDialogContextSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1063, n2));
    }

    @Override
    public void msgDialogStepSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-752090880, n2));
    }

    @Override
    public void naviOperatorCall(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1835270144, n2));
    }

    @Override
    public void naviEnterRubberband(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1818492928));
    }

    @Override
    public void naviRouteInfoSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1784938496, n2));
    }

    @Override
    public void adbMailByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2031157504, n2));
    }

    @Override
    public void naviMapCodeAdd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1717829632));
    }

    @Override
    public void naviMapCodeDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1701052416, n2));
    }

    @Override
    public void naviMapCodeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1684275200));
    }

    @Override
    public void naviMapCodeResolve(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1667497984));
    }

    @Override
    public void naviMapCodeNavigable(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1432616960));
    }

    @Override
    public void naviFurtherInputPossible(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1415839744, n2));
    }

    @Override
    public void naviPhoneNumberAdd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1650720768));
    }

    @Override
    public void naviPhoneNumberDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1633943552, n2));
    }

    @Override
    public void naviPhoneNumberGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1617166336));
    }

    @Override
    public void naviEnterPOISearchNames(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1600389120));
    }

    @Override
    public void naviTrufflesSearchDestination(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1583611904));
    }

    @Override
    public void naviTrufflesCorrection(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1566834688));
    }

    @Override
    public void naviAddressInputCorrection(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1550057472, n2));
    }

    @Override
    public void naviStartTpegPOI(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1533280256));
    }

    @Override
    public void naviGetTpegPOIResultByCategory(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1516503040));
    }

    @Override
    public void naviSelectTpegPOIResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1499725824));
    }

    @Override
    public void naviTriggerTpegPOIReturn(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1482948608));
    }

    @Override
    public void naviSynchronizeCountry(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1466171392));
    }

    @Override
    public void naviTrufflesEnd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1449394176));
    }

    @Override
    public void naviTrufflesSearchCancel(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1399062528));
    }

    @Override
    public void naviSimpleMapAreaSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1382285312));
    }

    @Override
    public void sdsVoiceBargeInActivated(int n) {
    }

    @Override
    public void sdsVoiceBargeInDeactivated(int n) {
    }

    @Override
    public void naviAddressInputCursorCorrection(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1365508096, n2, n3));
    }

    @Override
    public void naviAddressInputCursorSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1348730880, n2));
    }

    @Override
    public void naviSimpleMapFreeSelectionInit(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1331953664));
    }

    @Override
    public void naviHousenumberJPKRValidate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1315176448));
    }

    @Override
    public void adbMsgTypeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(19202304, n2));
    }

    @Override
    public void adbContactListLineSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(2081489152, bl));
    }

    @Override
    public void naviTrufflesSearchPrevious(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(-1298399232));
    }

    @Override
    public void mediaPlayAllTracks(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20027));
    }
}

