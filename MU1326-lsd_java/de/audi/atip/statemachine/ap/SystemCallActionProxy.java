/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SystemCallActionProxy
extends ActionProxy {
    default public void adbCategorySet(int n, int n2, int n3) {
    }

    default public void adbDestByIDOpen(int n, int n2) {
    }

    default public void adbDestSet(int n, int n2) {
    }

    default public void adbListHide(int n, int n2) {
    }

    default public void adbListShow(int n, int n2) {
    }

    default public void adbNavigateToRecog(int n) {
    }

    default public void adbNumberByIDOpen(int n, int n2) {
    }

    default public void adbTopRecEntryOpen(int n, int n2) {
    }

    default public void adbListLineDataGet(int n, String string) {
    }

    default public void phoneParamSetNLU(int n) {
    }

    default public void adbDetailListLineTypeGet(int n) {
    }

    default public void adbMailByIDOpen(int n, int n2) {
    }

    default public void adbContactListLineSet(int n, boolean bl) {
    }

    default public void systemCursorHighlightLine(int n, int n2) {
    }

    default public void systemIncrementModel(int n, int n2) {
    }

    default public void systemPosttrainingOK(int n, boolean bl) {
    }

    default public void systemListPageSet(int n, int n2) {
    }

    default public void systemListHide(int n, int n2) {
    }

    default public void systemSessionStart(int n) {
    }

    default public void systemSessionWait(int n) {
    }

    default public void systemListClear(int n) {
    }

    default public void systemAbortStart(int n) {
    }

    default public void systemSessionEnd(int n) {
    }

    default public void systemTTSAbort(int n) {
    }

    default public void systemGraphemicGroupRecognized(int n) {
    }

    default public void systemListShow(int n, int n2) {
    }

    default public void systemListLineGet(int n) {
    }

    default public void adbEntrySelectionInterrupt(int n, boolean bl) {
    }

    default public void systemListLineDataGet(int n, String string) {
    }

    default public void systemCounterSecondReset(int n) {
    }

    default public void systemCounterSecondIncrement(int n) {
    }

    default public void systemPlayBeep(int n) {
    }

    default public void systemAnyCalled(int n) {
    }

    default public void systemJumpPointAction(int n) {
    }

    default public void systemStateSet(int n, int n2, int n3) {
    }

    default public void systemCounterIncrement(int n) {
    }

    default public void systemCounterReset(int n) {
    }

    default public void systemContextSet(int n, int n2) {
    }

    default public void systemStopRecognition(int n) {
    }

    default public void systemStartRecognition(int n, int n2, int n3) {
    }

    default public void systemCommandListShow(int n, int n2) {
    }

    default public void systemCommandListHide(int n, int n2) {
    }

    default public void systemCommandModeSet(int n, int n2, int n3, int n4) {
    }

    default public void systemWaitState(int n) {
    }

    default public void systemDisambiguationListShow(int n, int n2) {
    }

    default public void systemDisambiguationListHide(int n, int n2) {
    }

    default public void systemSetModel(int n, int n2, int n3) {
    }

    default public void systemParamSetNLU(int n, int n2) {
    }

    default public void systemListLineSet(int n, boolean bl) {
    }

    default public void systemAbsoluteLineNumberSet(int n, boolean bl, int n2) {
    }

    default public void systemListLineRequest(int n) {
    }

    default public void systemTruffleSet(int n) {
    }

    default public void systemScreenFadeOut(int n, int n2) {
    }

    default public void systemDialogContextSet(int n, int n2) {
    }

    default public void systemOneshotInitialize(int n, int n2) {
    }

    default public void systemSlotSetNLU(int n) {
    }

    default public void naviSynchronizeCountry(int n) {
    }

    default public void mediaPlayMusic(int n) {
    }

    default public void mediaFolderSelect(int n, int n2) {
    }

    default public void mediaDeviceSet(int n, int n2) {
    }

    default public void mediaMediumSelect(int n, int n2) {
    }

    default public void mediaG2POneshotFilterPicklist(int n, int n2) {
    }

    default public void mediaFolderUp(int n) {
    }

    default public void mediaListLineSet(int n) {
    }

    default public void mediaPlaymodeSet(int n, int n2) {
    }

    default public void mediaListHide(int n, int n2) {
    }

    default public void mediaDynDeviceSet(int n, int n2) {
    }

    default public void mediaListShow(int n, int n2) {
    }

    default public void mediaListLineDataGet(int n) {
    }

    default public void mediaUSBDeviceSet(int n, int n2) {
    }

    default public void mediaPlayItemCommand(int n, int n2, int n3) {
    }

    default public void mediaG2POneshotIsAmbiguous(int n, int n2) {
    }

    default public void mediaG2POneshotStoreData(int n) {
    }

    default public void mediaPlayAllTracks(int n) {
    }

    default public void adbMsgDictateFinish(int n) {
    }

    default public void adbMsgReadoutFinish(int n) {
    }

    default public void adbMsgReadoutDetail(int n) {
    }

    default public void adbMsgReadoutRecog(int n, boolean bl, int n2, int n3) {
    }

    default public void adbMsgPrepareDictation(int n, int n2) {
    }

    default public void adbMsgDictateActivate(int n) {
    }

    default public void adbMsgDictateRecog(int n, int n2) {
    }

    default public void adbMsgSend(int n) {
    }

    default public void msgAddRecipient(int n, int n2) {
    }

    default public void adbMsgDictateStart(int n, int n2) {
    }

    default public void adbMsgDictateStop(int n) {
    }

    default public void adbMsgDictateVoiceDataAvailable(int n) {
    }

    default public void msgListShow(int n) {
    }

    default public void msgListHide(int n) {
    }

    default public void msgListLineSet(int n) {
    }

    default public void adbMsgDictateDelete(int n, int n2) {
    }

    default public void msgDialogStepSet(int n, int n2) {
    }

    default public void msgClearRecipient(int n) {
    }

    default public void adbMsgTypeSet(int n, int n2) {
    }

    default public void naviPhoneNumberAdd(int n) {
    }

    default public void naviPhoneNumberDelete(int n, int n2) {
    }

    default public void naviPhoneNumberGet(int n) {
    }

    default public void naviMapCodeNavigable(int n) {
    }

    default public void naviFurtherInputPossible(int n, int n2) {
    }

    default public void naviGetTpegPOIResultByCategory(int n) {
    }

    default public void naviSelectTpegPOIResult(int n) {
    }

    default public void naviStartTpegPOI(int n) {
    }

    default public void naviTriggerTpegPOIReturn(int n) {
    }

    default public void naviSimpleMapAreaSet(int n) {
    }

    default public void naviSimpleMapFreeSelectionInit(int n) {
    }

    default public void naviDestinationAvailableASIA(int n, int n2) {
    }

    default public void naviOperatorCall(int n, int n2) {
    }

    default public void naviHousenumberResolve(int n, int n2) {
    }

    default public void naviMapCodeAdd(int n) {
    }

    default public void naviMapCodeDelete(int n, int n2) {
    }

    default public void naviMapCodeResolve(int n) {
    }

    default public void naviPOIHistoryEntryUnique(int n, int n2) {
    }

    default public void naviAddressInputCursorCorrection(int n, int n2, int n3) {
    }

    default public void naviAddressInputCursorSet(int n, int n2) {
    }

    default public void naviHousenumberJPKRValidate(int n) {
    }

    default public void naviTrufflesSearchDestination(int n) {
    }

    default public void naviTrufflesCorrection(int n) {
    }

    default public void naviTrufflesEnd(int n) {
    }

    default public void naviTrufflesSearchCancel(int n) {
    }

    default public void naviTrufflesSearchPrevious(int n) {
    }

    default public void naviPOIPromptLabelSet(int n, int n2) {
    }

    default public void naviSpellingMode(int n, boolean bl) {
    }

    default public void naviListHide(int n, int n2) {
    }

    default public void naviInputStarted(int n, int n2) {
    }

    default public void naviRouteGuidanceTypeSet(int n, int n2) {
    }

    default public void naviPOIOnlineSearchInit(int n, int n2) {
    }

    default public void naviPOIOnlineSearchAreaSet(int n, int n2) {
    }

    default public void naviPOIOnlineSearchCancel(int n) {
    }

    default public void naviMapOptionsSet(int n, int n2) {
    }

    default public void naviGuidanceSet(int n, int n2, boolean bl) {
    }

    default public void naviTMCReadout(int n) {
    }

    default public void naviDestinationGet(int n, int n2) {
    }

    default public void naviDestinationAvailable(int n, int n2) {
    }

    default public void naviBlockRouteValueSet(int n, int n2) {
    }

    default public void naviHomeSet(int n) {
    }

    default public void naviGetInfo(int n) {
    }

    default public void naviDestinationStatus(int n) {
    }

    default public void naviCheckRouteGuidance(int n) {
    }

    default public void naviAlternativeRouteNumberSet(int n, int n2) {
    }

    default public void naviPOISearchAreaSet(int n, int n2) {
    }

    default public void naviListShow(int n, int n2) {
    }

    default public void naviPOIShortcutSet_Old(int n, int n2, int n3) {
    }

    default public void naviVoiceGuidanceSet(int n, int n2) {
    }

    default public void naviSpellingModeCorrection(int n, int n2, boolean bl) {
    }

    default public void naviPOIOnlineRecog(int n, boolean bl) {
    }

    default public void naviDestinationSet(int n, int n2) {
    }

    default public void systemCorrectionCase(int n) {
    }

    default public void naviInputModeCheck(int n) {
    }

    default public void naviPOIValueSet(int n, int n2) {
    }

    default public void naviDestinationDelete(int n) {
    }

    default public void naviPostCodeCheck(int n) {
    }

    default public void naviHousenumberCheck(int n) {
    }

    default public void naviHousenumberSet(int n) {
    }

    default public void naviVDEOneshotIsAmbiguous(int n) {
    }

    default public void naviVDEOneshotFilterPicklist(int n, int n2) {
    }

    default public void naviSpeedLimitGet(int n) {
    }

    default public void naviListLineDataGet(int n, int n2) {
    }

    default public void naviHomeSave(int n) {
    }

    default public void naviRouteOptionsSet(int n, int n2) {
    }

    default public void naviAddDestination(int n, int n2) {
    }

    default public void naviGuidanceStart(int n) {
    }

    default public void naviGuidanceStop(int n) {
    }

    default public void naviAlternativeRouteCalc(int n) {
    }

    default public void naviPOIOnlineShowList(int n, int n2) {
    }

    default public void naviPOIShortcutSet(int n, int n2) {
    }

    default public void naviPOICorrectionHandling(int n) {
    }

    default public void naviPOIOnlineDidYouMean(int n) {
    }

    default public void naviLastDestinationSet(int n, int n2) {
    }

    default public void naviFavoriteDestinationSet(int n, int n2) {
    }

    default public void naviSUITypeGet(int n) {
    }

    default public void naviPOIOneshotIsAmbiguous(int n) {
    }

    default public void naviPOIOneshotFilterPicklist(int n, int n2) {
    }

    default public void naviMyAudiContactSelect(int n, int n2) {
    }

    default public void naviIntelliDestinationSet(int n, int n2) {
    }

    default public void systemRemoveFromPicklistHistory(int n, int n2) {
    }

    default public void naviSetBypassRoute(int n, boolean bl) {
    }

    default public void naviCheckBetterRoute(int n) {
    }

    default public void naviOneshotStoreData(int n, int n2) {
    }

    default public void naviDetailsPhoneCall(int n) {
    }

    default public void naviPOIOnlineSelectDestination(int n) {
    }

    default public void naviBlockRouteSetNLU(int n) {
    }

    default public void naviFillPromptLabels(int n) {
    }

    default public void naviEnterGeocoordinates(int n) {
    }

    default public void naviEnterRubberband(int n) {
    }

    default public void naviRouteInfoSet(int n, int n2) {
    }

    default public void naviOneshotIsAmbiguous(int n) {
    }

    default public void naviOneshotFilterPicklist(int n, int n2) {
    }

    default public void naviMapCodeGet(int n) {
    }

    default public void naviEnterPOISearchNames(int n) {
    }

    default public void naviAddressInputCorrection(int n, int n2) {
    }

    default public void sdsVoiceBargeInActivated(int n) {
    }

    default public void sdsVoiceBargeInDeactivated(int n) {
    }

    default public void onlineSetRemoteHMINavDestFormResult(int n) {
    }

    default public void onlineSetRemoteHMIResult(int n) {
    }

    default public void onlineSetRemoteHMIGlobalResult(int n) {
    }

    default public void onlineDialogStepFinished(int n) {
    }

    default public void onlineRequestDialogContinuation(int n) {
    }

    default public void onlineSetRemoteHMIGlobalEnter(int n) {
    }

    default public void onlineHelpOpened(int n, int n2) {
    }

    default public void onlineSetRemoteHMIHelpResult(int n) {
    }

    default public void systemDisclaimerAccept(int n, boolean bl) {
    }

    default public void systemConnectionAccept(int n, int n2) {
    }

    default public void onlineRemoteHMISetRecognizedLineNumber(int n) {
    }

    default public void phoneNumberDial(int n, int n2, int n3) {
    }

    default public void phoneNumberDelete(int n, int n2, int n3) {
    }

    default public void phoneNumberGet(int n, int n2) {
    }

    default public void phoneNumberAdd(int n, int n2) {
    }

    default public void phoneCallMailbox(int n) {
    }

    default public void phoneRedialNumber(int n) {
    }

    default public void phoneListEntrySelect(int n, int n2) {
    }

    default public void phoneLineDataGetType(int n, int n2) {
    }

    default public void phoneListShow(int n, int n2) {
    }

    default public void phoneListLineDataGet(int n) {
    }

    default public void phoneListHide(int n, int n2) {
    }

    default public void phoneSiriActivate(int n) {
    }

    default public void tunerWavebandSet(int n, int n2) {
    }

    default public void tunerFrequencySet(int n) {
    }

    default public void tunerCategorySet(int n, int n2) {
    }

    default public void tunerTrafficProgramSet(int n, boolean bl) {
    }

    default public void tunerGenreSet(int n, int n2) {
    }

    default public void tunerListLineSet(int n) {
    }

    default public void tunerListLineDataGet(int n) {
    }

    default public void tunerStationSet(int n, int n2) {
    }

    default public void tunerListHide(int n, int n2) {
    }

    default public void tunerListShow(int n, int n2) {
    }

    default public void systemStorePicklistInHistory(int n) {
    }

    default public void systemWaitForScreen(int n, int n2) {
    }

    default public void systemPromptTypeSet(int n, int n2) {
    }

    default public void sdsScreenSynced(int n) {
    }
}

