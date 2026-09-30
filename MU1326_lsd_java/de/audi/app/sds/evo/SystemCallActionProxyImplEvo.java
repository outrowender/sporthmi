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

    public void adbDestByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70000, n2));
    }

    public void adbDestSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70001, n2));
    }

    public void adbListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70002, n2));
    }

    public void adbListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70003, n2));
    }

    public void adbEntrySelectionInterrupt(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70004, bl));
    }

    public void adbMsgDictateActivate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77000));
    }

    public void adbMsgDictateDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77002, n2));
    }

    public void adbMsgDictateFinish(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77004));
    }

    public void adbMsgReadoutFinish(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75000));
    }

    public void adbMsgDictateRecog(int n, int n2) {
    }

    public void adbMsgDictateStart(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77008, n2));
    }

    public void msgClearRecipient(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77001));
    }

    public void adbMsgDictateStop(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77009));
    }

    public void adbMsgDictateVoiceDataAvailable(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77010));
    }

    public void adbMsgNumberAdd(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75001, n2));
    }

    public void msgAddRecipient(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75001, n2));
    }

    public void adbMsgReadoutRecog(int n, boolean bl, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75003, bl, n2, n3));
    }

    public void adbMsgReadoutDetail(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75004));
    }

    public void adbMsgSend(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75005));
    }

    public void adbNavigateToRecog(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70005));
    }

    public void adbNumberByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70006, n2));
    }

    public void adbCategorySet(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70007, n2, n3));
    }

    public void adbTopRecEntryOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70008, n2));
    }

    public void adbDetailListLineTypeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70011));
    }

    public void mediaDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20000, n2));
    }

    public void mediaPlaymodeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20021, n2));
    }

    public void mediaG2POneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20003, n2));
    }

    public void mediaFolderUp(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20015));
    }

    public void mediaListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20016, n2));
    }

    public void mediaFolderSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20017, n2));
    }

    public void mediaListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20019, n2));
    }

    public void mediaMediumSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20020, n2));
    }

    public void naviBlockRouteValueSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40001, n2));
    }

    public void naviFillPromptLabels(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40079));
    }

    public void naviDestinationDelete(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40003));
    }

    public void naviDestinationAvailable(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40004, n2));
    }

    public void naviDestinationGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40005, n2));
    }

    public void naviDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40007, n2));
    }

    public void naviDestinationStatus(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40009));
    }

    public void naviSpellingMode(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40010, bl));
    }

    public void naviSpellingModeCorrection(int n, int n2, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40011, n2, bl));
    }

    public void naviCheckRouteGuidance(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40013));
    }

    public void naviRouteGuidanceTypeSet(int n, int n2) {
    }

    public void naviAlternativeRouteNumberSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40015, n2));
    }

    public void naviGuidanceSet(int n, int n2, boolean bl) {
    }

    public void naviHousenumberCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40018));
    }

    public void naviHousenumberResolve(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40086, n2));
    }

    public void naviHousenumberSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40019));
    }

    public void naviHomeSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40020));
    }

    public void naviHomeSave(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40059));
    }

    public void naviGetInfo(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40021));
    }

    public void naviInputStarted(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40024, n2));
    }

    public void naviListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40026, n2));
    }

    public void naviListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40028, n2));
    }

    public void naviMapOptionsSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40029, n2));
    }

    public void naviPOISearchAreaSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40033, n2));
    }

    public void naviPOIValueSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40040, n2));
    }

    public void naviPOIOnlineSearchAreaSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40043, n2));
    }

    public void naviPOIOnlineSearchInit(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40046, n2));
    }

    public void naviPOIOnlineSearchCancel(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40045));
    }

    public void naviPOIOnlineRecog(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40042, bl));
    }

    public void naviPOIHistoryEntryUnique(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40084));
    }

    public void naviPOIHistoryEntryUnique(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40084, n2));
    }

    public void naviPostCodeCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40051));
    }

    public void naviRouteOptionsSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40052, n2));
    }

    public void naviInputModeCheck(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40023));
    }

    public void naviTMCReadout(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40054));
    }

    public void naviVoiceGuidanceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40055, n2));
    }

    public void naviVDEOneshotIsAmbiguous(int n) {
        this.sds.processCommand(new SystemCall(40056));
    }

    public void naviVDEOneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40057, n2));
    }

    public void naviOneshotIsAmbiguous(int n) {
        this.sds.processCommand(new SystemCall(40087));
    }

    public void naviOneshotFilterPicklist(int n, int n2) {
        this.sds.processCommand(new SystemCall(40088, n2));
    }

    public void systemOneshotInitialize(int n, int n2) {
        this.sds.processCommand(new SystemCall(1064, n2));
    }

    public void phoneCallMailbox(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30000));
    }

    public void phoneNumberAdd(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30002, n2));
    }

    public void phoneNumberDelete(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30003, n2, n3));
    }

    public void phoneNumberDial(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30004, n2, n3));
    }

    public void phoneNumberGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30005, n2));
    }

    public void phoneRedialNumber(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30006));
    }

    public void systemAbortStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1000));
    }

    public void systemAnyCalled(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1001));
    }

    public void systemCommandListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1002, n2));
    }

    public void systemCommandListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1003, n2));
    }

    public void systemCommandModeSet(int n, int n2, int n3, int n4) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1007, n2, n3, n4));
    }

    public void systemCorrectionCase(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1010));
    }

    public void systemStorePicklistInHistory(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1052));
    }

    public void systemCounterIncrement(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1012));
    }

    public void systemCounterReset(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1013));
    }

    public void systemCounterSecondIncrement(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1014));
    }

    public void systemCounterSecondReset(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1015));
    }

    public void systemIncrementModel(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1017, n2));
    }

    public void systemJumpPointAction(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1019));
    }

    public void systemListClear(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1020));
    }

    public void systemListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1021, n2));
    }

    public void systemListLineDataGet(int n, String string) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1022, string));
    }

    public void systemListLineGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1023));
    }

    public void systemListLineSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1024, bl));
    }

    public void systemListPageSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1025, n2));
    }

    public void systemListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1027, n2));
    }

    public void systemPlayBeep(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1032, 0));
    }

    public void systemPosttrainingOK(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1033, bl));
    }

    public void systemGraphemicGroupRecognized(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1035));
    }

    public void systemSessionEnd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1038));
    }

    public void systemSessionStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1039));
    }

    public void systemSessionWait(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1049));
    }

    public void systemStartRecognition(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1041, n2, n3));
    }

    public void systemStateSet(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1043, n2, n3));
    }

    public void systemTTSAbort(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1044));
    }

    public void tunerCategorySet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10000, n2));
    }

    public void tunerFrequencySet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10001));
    }

    public void tunerStationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10002, n2));
    }

    public void tunerTrafficProgramSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10004, bl));
    }

    public void tunerWavebandSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10005, n2));
    }

    public void onlineSetRemoteHMIResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230002));
    }

    public void onlineSetRemoteHMIGlobalResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230003));
    }

    public void onlineSetRemoteHMIHelpResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230004));
    }

    public void onlineRequestDialogContinuation(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230005));
    }

    public void onlineDialogStepFinished(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230006));
    }

    public void onlineHelpOpened(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230007, n2));
    }

    public void onlineSetRemoteHMINavDestFormResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230008));
    }

    public void onlineSetRemoteHMIGlobalEnter(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230009));
    }

    public void systemContextSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1045, n2));
    }

    public void adbMsgPrepareDictation(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77003, n2));
    }

    public void systemStopRecognition(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1042));
    }

    public void mediaListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20023));
    }

    public void mediaDynDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20024, n2));
    }

    public void tunerListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10006, n2));
    }

    public void tunerListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10007, n2));
    }

    public void tunerGenreSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10003, n2));
    }

    public void adbListLineDataGet(int n, String string) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70010, string));
    }

    public void systemWaitState(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1046));
    }

    public void tunerListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10008));
    }

    public void naviSpeedLimitGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40050));
    }

    public void naviListLineDataGet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40053, n2));
    }

    public void systemDisambiguationListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1047, n2));
    }

    public void systemDisambiguationListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1048, n2));
    }

    public void phoneLineDataGetType(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30008, n2));
    }

    public void phoneListEntrySelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30007, n2));
    }

    public void tunerListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(10009));
    }

    public void naviAddDestination(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40062, n2));
    }

    public void naviGuidanceStart(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40060));
    }

    public void naviGuidanceStop(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40061));
    }

    public void naviAlternativeRouteCalc(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40063));
    }

    public void mediaListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20025));
    }

    public void phoneParamSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1053));
    }

    public void mediaUSBDeviceSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20026, n2));
    }

    public void systemSetModel(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1051, n2, n3));
    }

    public void naviPOIOnlineShowList(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40064, n2));
    }

    public void systemParamSetNLU(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1053, n2));
    }

    public void systemSlotSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1030));
    }

    public void mediaPlayItemCommand(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20001, n2, n3));
    }

    public void naviPOIShortcutSet_Old(int n, int n2, int n3) {
    }

    public void naviPOIShortcutSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40034, n2));
    }

    public void phoneListHide(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30010, n2));
    }

    public void phoneListShow(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30009, n2));
    }

    public void phoneListLineDataGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30011));
    }

    public void naviPOICorrectionHandling(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40032));
    }

    public void sdsScreenSynced(int n) {
    }

    public void systemAbsoluteLineNumberSet(int n, boolean bl, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1055, bl, n2));
    }

    public void naviPOIOnlineDidYouMean(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40044));
    }

    public void systemListLineRequest(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1056));
    }

    public void naviLastDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40066, n2));
    }

    public void naviIntelliDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40071, n2));
    }

    public void naviFavoriteDestinationSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40065, n2));
    }

    public void msgListShow(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75006));
    }

    public void msgListHide(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75007));
    }

    public void msgListLineSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75008));
    }

    public void naviSUITypeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40067));
    }

    public void systemDisclaimerAccept(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1057, bl));
    }

    public void systemConnectionAccept(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1029, n2));
    }

    public void onlineRemoteHMISetRecognizedLineNumber(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(230010));
    }

    public void naviPOIOneshotIsAmbiguous(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40068));
    }

    public void naviPOIOneshotFilterPicklist(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40069, n2));
    }

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
        this.sds.processCommand(new SystemCall(40070, n2));
    }

    public void naviMyAudiContactSelect(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40070, n2));
    }

    public void naviPOIPromptLabelSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40072));
    }

    public void naviPOIPromptLabelSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40072, n2));
    }

    public void systemRemoveFromPicklistHistory(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1059, n2));
    }

    public void naviOneshotStoreData(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40073, n2));
    }

    public void systemTruffleSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1060));
    }

    public void naviCheckBetterRoute(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40074));
    }

    public void naviSetBypassRoute(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40075, bl));
    }

    public void naviDetailsPhoneCall(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40076));
    }

    public void naviPOIOnlineSelectDestination(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40077));
    }

    public void phoneSiriActivate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(30012));
    }

    public void systemWaitForScreen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1061, n2));
    }

    public void systemPromptTypeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1034, n2));
    }

    public void naviBlockRouteSetNLU(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40078));
    }

    public void systemScreenFadeOut(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1062, n2));
    }

    public void naviDestinationAvailableASIA(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40081, n2));
    }

    public void naviEnterGeocoordinates(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40080));
    }

    public void mediaPlayMusic(int n) {
    }

    public void mediaG2POneshotIsAmbiguous(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20002, n2));
    }

    public void mediaG2POneshotStoreData(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20004));
    }

    public void systemDialogContextSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(1063, n2));
    }

    public void msgDialogStepSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(77011, n2));
    }

    public void naviOperatorCall(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40082, n2));
    }

    public void naviEnterRubberband(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40083));
    }

    public void naviRouteInfoSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40085, n2));
    }

    public void adbMailByIDOpen(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70009, n2));
    }

    public void naviMapCodeAdd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40089));
    }

    public void naviMapCodeDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40090, n2));
    }

    public void naviMapCodeGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40091));
    }

    public void naviMapCodeResolve(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40092));
    }

    public void naviMapCodeNavigable(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40106));
    }

    public void naviFurtherInputPossible(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40107, n2));
    }

    public void naviPhoneNumberAdd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40093));
    }

    public void naviPhoneNumberDelete(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40094, n2));
    }

    public void naviPhoneNumberGet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40095));
    }

    public void naviEnterPOISearchNames(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40096));
    }

    public void naviTrufflesSearchDestination(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40097));
    }

    public void naviTrufflesCorrection(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40098));
    }

    public void naviAddressInputCorrection(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40099, n2));
    }

    public void naviStartTpegPOI(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40100));
    }

    public void naviGetTpegPOIResultByCategory(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40101));
    }

    public void naviSelectTpegPOIResult(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40102));
    }

    public void naviTriggerTpegPOIReturn(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40103));
    }

    public void naviSynchronizeCountry(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40104));
    }

    public void naviTrufflesEnd(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40105));
    }

    public void naviTrufflesSearchCancel(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40108));
    }

    public void naviSimpleMapAreaSet(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40109));
    }

    public void sdsVoiceBargeInActivated(int n) {
    }

    public void sdsVoiceBargeInDeactivated(int n) {
    }

    public void naviAddressInputCursorCorrection(int n, int n2, int n3) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40110, n2, n3));
    }

    public void naviAddressInputCursorSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40111, n2));
    }

    public void naviSimpleMapFreeSelectionInit(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40112));
    }

    public void naviHousenumberJPKRValidate(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40113));
    }

    public void adbMsgTypeSet(int n, int n2) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(75009, n2));
    }

    public void adbContactListLineSet(int n, boolean bl) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(70012, bl));
    }

    public void naviTrufflesSearchPrevious(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(40114));
    }

    public void mediaPlayAllTracks(int n) {
        if (this.sds == null) {
            return;
        }
        this.sds.processCommand(new SystemCall(20027));
    }
}

