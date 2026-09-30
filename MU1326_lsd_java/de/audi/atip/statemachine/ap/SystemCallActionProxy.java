/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface SystemCallActionProxy
extends ActionProxy {
    public void adbCategorySet(int var1, int var2, int var3);

    public void adbDestByIDOpen(int var1, int var2);

    public void adbDestSet(int var1, int var2);

    public void adbListHide(int var1, int var2);

    public void adbListShow(int var1, int var2);

    public void adbNavigateToRecog(int var1);

    public void adbNumberByIDOpen(int var1, int var2);

    public void adbTopRecEntryOpen(int var1, int var2);

    public void adbListLineDataGet(int var1, String var2);

    public void phoneParamSetNLU(int var1);

    public void adbDetailListLineTypeGet(int var1);

    public void adbMailByIDOpen(int var1, int var2);

    public void adbContactListLineSet(int var1, boolean var2);

    public void systemCursorHighlightLine(int var1, int var2);

    public void systemIncrementModel(int var1, int var2);

    public void systemPosttrainingOK(int var1, boolean var2);

    public void systemListPageSet(int var1, int var2);

    public void systemListHide(int var1, int var2);

    public void systemSessionStart(int var1);

    public void systemSessionWait(int var1);

    public void systemListClear(int var1);

    public void systemAbortStart(int var1);

    public void systemSessionEnd(int var1);

    public void systemTTSAbort(int var1);

    public void systemGraphemicGroupRecognized(int var1);

    public void systemListShow(int var1, int var2);

    public void systemListLineGet(int var1);

    public void adbEntrySelectionInterrupt(int var1, boolean var2);

    public void systemListLineDataGet(int var1, String var2);

    public void systemCounterSecondReset(int var1);

    public void systemCounterSecondIncrement(int var1);

    public void systemPlayBeep(int var1);

    public void systemAnyCalled(int var1);

    public void systemJumpPointAction(int var1);

    public void systemStateSet(int var1, int var2, int var3);

    public void systemCounterIncrement(int var1);

    public void systemCounterReset(int var1);

    public void systemContextSet(int var1, int var2);

    public void systemStopRecognition(int var1);

    public void systemStartRecognition(int var1, int var2, int var3);

    public void systemCommandListShow(int var1, int var2);

    public void systemCommandListHide(int var1, int var2);

    public void systemCommandModeSet(int var1, int var2, int var3, int var4);

    public void systemWaitState(int var1);

    public void systemDisambiguationListShow(int var1, int var2);

    public void systemDisambiguationListHide(int var1, int var2);

    public void systemSetModel(int var1, int var2, int var3);

    public void systemParamSetNLU(int var1, int var2);

    public void systemListLineSet(int var1, boolean var2);

    public void systemAbsoluteLineNumberSet(int var1, boolean var2, int var3);

    public void systemListLineRequest(int var1);

    public void systemTruffleSet(int var1);

    public void systemScreenFadeOut(int var1, int var2);

    public void systemDialogContextSet(int var1, int var2);

    public void systemOneshotInitialize(int var1, int var2);

    public void systemSlotSetNLU(int var1);

    public void naviSynchronizeCountry(int var1);

    public void mediaPlayMusic(int var1);

    public void mediaFolderSelect(int var1, int var2);

    public void mediaDeviceSet(int var1, int var2);

    public void mediaMediumSelect(int var1, int var2);

    public void mediaG2POneshotFilterPicklist(int var1, int var2);

    public void mediaFolderUp(int var1);

    public void mediaListLineSet(int var1);

    public void mediaPlaymodeSet(int var1, int var2);

    public void mediaListHide(int var1, int var2);

    public void mediaDynDeviceSet(int var1, int var2);

    public void mediaListShow(int var1, int var2);

    public void mediaListLineDataGet(int var1);

    public void mediaUSBDeviceSet(int var1, int var2);

    public void mediaPlayItemCommand(int var1, int var2, int var3);

    public void mediaG2POneshotIsAmbiguous(int var1, int var2);

    public void mediaG2POneshotStoreData(int var1);

    public void mediaPlayAllTracks(int var1);

    public void adbMsgDictateFinish(int var1);

    public void adbMsgReadoutFinish(int var1);

    public void adbMsgReadoutDetail(int var1);

    public void adbMsgReadoutRecog(int var1, boolean var2, int var3, int var4);

    public void adbMsgPrepareDictation(int var1, int var2);

    public void adbMsgDictateActivate(int var1);

    public void adbMsgDictateRecog(int var1, int var2);

    public void adbMsgSend(int var1);

    public void msgAddRecipient(int var1, int var2);

    public void adbMsgDictateStart(int var1, int var2);

    public void adbMsgDictateStop(int var1);

    public void adbMsgDictateVoiceDataAvailable(int var1);

    public void msgListShow(int var1);

    public void msgListHide(int var1);

    public void msgListLineSet(int var1);

    public void adbMsgDictateDelete(int var1, int var2);

    public void msgDialogStepSet(int var1, int var2);

    public void msgClearRecipient(int var1);

    public void adbMsgTypeSet(int var1, int var2);

    public void naviPhoneNumberAdd(int var1);

    public void naviPhoneNumberDelete(int var1, int var2);

    public void naviPhoneNumberGet(int var1);

    public void naviMapCodeNavigable(int var1);

    public void naviFurtherInputPossible(int var1, int var2);

    public void naviGetTpegPOIResultByCategory(int var1);

    public void naviSelectTpegPOIResult(int var1);

    public void naviStartTpegPOI(int var1);

    public void naviTriggerTpegPOIReturn(int var1);

    public void naviSimpleMapAreaSet(int var1);

    public void naviSimpleMapFreeSelectionInit(int var1);

    public void naviDestinationAvailableASIA(int var1, int var2);

    public void naviOperatorCall(int var1, int var2);

    public void naviHousenumberResolve(int var1, int var2);

    public void naviMapCodeAdd(int var1);

    public void naviMapCodeDelete(int var1, int var2);

    public void naviMapCodeResolve(int var1);

    public void naviPOIHistoryEntryUnique(int var1, int var2);

    public void naviAddressInputCursorCorrection(int var1, int var2, int var3);

    public void naviAddressInputCursorSet(int var1, int var2);

    public void naviHousenumberJPKRValidate(int var1);

    public void naviTrufflesSearchDestination(int var1);

    public void naviTrufflesCorrection(int var1);

    public void naviTrufflesEnd(int var1);

    public void naviTrufflesSearchCancel(int var1);

    public void naviTrufflesSearchPrevious(int var1);

    public void naviPOIPromptLabelSet(int var1, int var2);

    public void naviSpellingMode(int var1, boolean var2);

    public void naviListHide(int var1, int var2);

    public void naviInputStarted(int var1, int var2);

    public void naviRouteGuidanceTypeSet(int var1, int var2);

    public void naviPOIOnlineSearchInit(int var1, int var2);

    public void naviPOIOnlineSearchAreaSet(int var1, int var2);

    public void naviPOIOnlineSearchCancel(int var1);

    public void naviMapOptionsSet(int var1, int var2);

    public void naviGuidanceSet(int var1, int var2, boolean var3);

    public void naviTMCReadout(int var1);

    public void naviDestinationGet(int var1, int var2);

    public void naviDestinationAvailable(int var1, int var2);

    public void naviBlockRouteValueSet(int var1, int var2);

    public void naviHomeSet(int var1);

    public void naviGetInfo(int var1);

    public void naviDestinationStatus(int var1);

    public void naviCheckRouteGuidance(int var1);

    public void naviAlternativeRouteNumberSet(int var1, int var2);

    public void naviPOISearchAreaSet(int var1, int var2);

    public void naviListShow(int var1, int var2);

    public void naviPOIShortcutSet_Old(int var1, int var2, int var3);

    public void naviVoiceGuidanceSet(int var1, int var2);

    public void naviSpellingModeCorrection(int var1, int var2, boolean var3);

    public void naviPOIOnlineRecog(int var1, boolean var2);

    public void naviDestinationSet(int var1, int var2);

    public void systemCorrectionCase(int var1);

    public void naviInputModeCheck(int var1);

    public void naviPOIValueSet(int var1, int var2);

    public void naviDestinationDelete(int var1);

    public void naviPostCodeCheck(int var1);

    public void naviHousenumberCheck(int var1);

    public void naviHousenumberSet(int var1);

    public void naviVDEOneshotIsAmbiguous(int var1);

    public void naviVDEOneshotFilterPicklist(int var1, int var2);

    public void naviSpeedLimitGet(int var1);

    public void naviListLineDataGet(int var1, int var2);

    public void naviHomeSave(int var1);

    public void naviRouteOptionsSet(int var1, int var2);

    public void naviAddDestination(int var1, int var2);

    public void naviGuidanceStart(int var1);

    public void naviGuidanceStop(int var1);

    public void naviAlternativeRouteCalc(int var1);

    public void naviPOIOnlineShowList(int var1, int var2);

    public void naviPOIShortcutSet(int var1, int var2);

    public void naviPOICorrectionHandling(int var1);

    public void naviPOIOnlineDidYouMean(int var1);

    public void naviLastDestinationSet(int var1, int var2);

    public void naviFavoriteDestinationSet(int var1, int var2);

    public void naviSUITypeGet(int var1);

    public void naviPOIOneshotIsAmbiguous(int var1);

    public void naviPOIOneshotFilterPicklist(int var1, int var2);

    public void naviMyAudiContactSelect(int var1, int var2);

    public void naviIntelliDestinationSet(int var1, int var2);

    public void systemRemoveFromPicklistHistory(int var1, int var2);

    public void naviSetBypassRoute(int var1, boolean var2);

    public void naviCheckBetterRoute(int var1);

    public void naviOneshotStoreData(int var1, int var2);

    public void naviDetailsPhoneCall(int var1);

    public void naviPOIOnlineSelectDestination(int var1);

    public void naviBlockRouteSetNLU(int var1);

    public void naviFillPromptLabels(int var1);

    public void naviEnterGeocoordinates(int var1);

    public void naviEnterRubberband(int var1);

    public void naviRouteInfoSet(int var1, int var2);

    public void naviOneshotIsAmbiguous(int var1);

    public void naviOneshotFilterPicklist(int var1, int var2);

    public void naviMapCodeGet(int var1);

    public void naviEnterPOISearchNames(int var1);

    public void naviAddressInputCorrection(int var1, int var2);

    public void sdsVoiceBargeInActivated(int var1);

    public void sdsVoiceBargeInDeactivated(int var1);

    public void onlineSetRemoteHMINavDestFormResult(int var1);

    public void onlineSetRemoteHMIResult(int var1);

    public void onlineSetRemoteHMIGlobalResult(int var1);

    public void onlineDialogStepFinished(int var1);

    public void onlineRequestDialogContinuation(int var1);

    public void onlineSetRemoteHMIGlobalEnter(int var1);

    public void onlineHelpOpened(int var1, int var2);

    public void onlineSetRemoteHMIHelpResult(int var1);

    public void systemDisclaimerAccept(int var1, boolean var2);

    public void systemConnectionAccept(int var1, int var2);

    public void onlineRemoteHMISetRecognizedLineNumber(int var1);

    public void phoneNumberDial(int var1, int var2, int var3);

    public void phoneNumberDelete(int var1, int var2, int var3);

    public void phoneNumberGet(int var1, int var2);

    public void phoneNumberAdd(int var1, int var2);

    public void phoneCallMailbox(int var1);

    public void phoneRedialNumber(int var1);

    public void phoneListEntrySelect(int var1, int var2);

    public void phoneLineDataGetType(int var1, int var2);

    public void phoneListShow(int var1, int var2);

    public void phoneListLineDataGet(int var1);

    public void phoneListHide(int var1, int var2);

    public void phoneSiriActivate(int var1);

    public void tunerWavebandSet(int var1, int var2);

    public void tunerFrequencySet(int var1);

    public void tunerCategorySet(int var1, int var2);

    public void tunerTrafficProgramSet(int var1, boolean var2);

    public void tunerGenreSet(int var1, int var2);

    public void tunerListLineSet(int var1);

    public void tunerListLineDataGet(int var1);

    public void tunerStationSet(int var1, int var2);

    public void tunerListHide(int var1, int var2);

    public void tunerListShow(int var1, int var2);

    public void systemStorePicklistInHistory(int var1);

    public void systemWaitForScreen(int var1, int var2);

    public void systemPromptTypeSet(int var1, int var2);

    public void sdsScreenSynced(int var1);
}

