/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.arrays.ArrayHeaderBAP;
import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.generated.navi.AbstractBAPIndicationHandlerNavi;
import de.audi.app.bap.utils.FunctionIDs;
import de.audi.app.combi.bap.app.navi.CombiModuleNavi;
import de.audi.app.combi.bap.fw.arrays.GetArrayIndicationAddressList;
import de.audi.atip.interapp.ExternalKeyListener;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.navi.CombiBAPServiceNaviListener;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.vw.mib.bap.generated.navsd.serializer.ASG_Capabilities_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.ActiveRgType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.ActiveRgType_Status;
import de.vw.mib.bap.generated.navsd.serializer.Address_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.Calibration_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.FavoriteDest_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_Result;
import de.vw.mib.bap.generated.navsd.serializer.GetNextListPos_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.LaneGuidance_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.LastDest_List_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.MagnetFieldZone_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapColorAndType_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapColorAndType_Status;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapScale_Status;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.MapViewAndOrientation_Status;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.Map_Presentation_Status;
import de.vw.mib.bap.generated.navsd.serializer.NavBook_GetArray;
import de.vw.mib.bap.generated.navsd.serializer.NbSpeller_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.POI_Search_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_Result;
import de.vw.mib.bap.generated.navsd.serializer.RG_ActDeact_StartResult;
import de.vw.mib.bap.generated.navsd.serializer.RepeatLastNavAnnouncement_Result;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.VoiceGuidance_SetGet;
import de.vw.mib.bap.generated.navsd.serializer.VoiceGuidance_Status;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.ResultMethod;

public class BAPIndicationHandlerNavi
extends AbstractBAPIndicationHandlerNavi {
    protected BAPIndicationHandlerNavi(CombiModuleNavi combiModuleNavi) {
        super(combiModuleNavi, combiModuleNavi.getLogChannel());
    }

    public CombiBAPServiceNaviListener getNaviService() {
        return ((CombiModuleNavi)this.module).getNaviServiceListener();
    }

    @Override
    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        GetArrayIndication getArrayIndication = null;
        switch (n) {
            case 24: {
                LaneGuidance_GetArray laneGuidance_GetArray = (LaneGuidance_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(laneGuidance_GetArray.asg_Id, laneGuidance_GetArray.taid, new ArrayHeaderBAP(laneGuidance_GetArray.getArrayHeader()));
                break;
            }
            case 29: {
                LastDest_List_GetArray lastDest_List_GetArray = (LastDest_List_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(lastDest_List_GetArray.asg_Id, lastDest_List_GetArray.taid, new ArrayHeaderBAP(lastDest_List_GetArray.getArrayHeader()));
                break;
            }
            case 30: {
                FavoriteDest_List_GetArray favoriteDest_List_GetArray = (FavoriteDest_List_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(favoriteDest_List_GetArray.asg_Id, favoriteDest_List_GetArray.taid, new ArrayHeaderBAP(favoriteDest_List_GetArray.getArrayHeader()));
                break;
            }
            case 32: {
                NavBook_GetArray navBook_GetArray = (NavBook_GetArray)getArray;
                getArrayIndication = new GetArrayIndication(navBook_GetArray.asg_Id, navBook_GetArray.taid, new ArrayHeaderBAP(navBook_GetArray.getArrayHeader()));
                break;
            }
            case 33: {
                Address_List_GetArray address_List_GetArray = (Address_List_GetArray)getArray;
                getArrayIndication = new GetArrayIndicationAddressList(address_List_GetArray.asg_Id, address_List_GetArray.taid, new ArrayHeaderBAP(address_List_GetArray.getArrayHeader()), address_List_GetArray.otherListType, address_List_GetArray.otherList_Reference);
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPIndicationHandlerNavi#evaluateGetArrayIndication] function is not an array or not supported yet (%1)", (Object)FunctionIDs.getDescription(this.lsgID, n));
            }
        }
        return getArrayIndication;
    }

    @Override
    protected void processVoiceGuidanceSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, VoiceGuidance_SetGet voiceGuidance_SetGet) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processVoiceGuidanceSetGet] call navi service 'setVoiceGuidanceState( %1 )'", (long)voiceGuidance_SetGet.voiceGuidance_State);
        if (BAPIndicationHandlerNavi.reservedValueUsed(voiceGuidance_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processVoiceGuidanceSetGet] Reserved Value Used. serializer: %1", (Object)voiceGuidance_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        VoiceGuidance_Status voiceGuidance_Status = (VoiceGuidance_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (voiceGuidance_Status.voiceGuidance_State == voiceGuidance_SetGet.voiceGuidance_State) {
            bAPFunctionPropertyFSG.resendLastStatus();
        } else {
            this.getNaviService().setVoiceGuidanceState(voiceGuidance_SetGet.voiceGuidance_State);
        }
    }

    private static boolean reservedValueUsed(VoiceGuidance_SetGet voiceGuidance_SetGet) {
        return voiceGuidance_SetGet.voiceGuidance_State >= 4 && voiceGuidance_SetGet.voiceGuidance_State <= 255;
    }

    @Override
    protected void processCalibrationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Calibration_SetGet calibration_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(calibration_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processCalibrationSetGet] Reserved Value Used. serializer: %1", (Object)calibration_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        bAPFunctionPropertyFSG.functionNotSupported();
    }

    private static boolean reservedValueUsed(Calibration_SetGet calibration_SetGet) {
        return calibration_SetGet.calibrationState >= 3 && calibration_SetGet.calibrationState <= 254;
    }

    @Override
    protected void processRepeatLastNavAnnouncementAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRepeatLastNavAnnouncementAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        RepeatLastNavAnnouncement_Result repeatLastNavAnnouncement_Result = (RepeatLastNavAnnouncement_Result)((CombiModuleNavi)this.module).createResultSerializer(35);
        repeatLastNavAnnouncement_Result.repeatLna_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(repeatLastNavAnnouncement_Result);
    }

    @Override
    protected void processRepeatLastNavAnnouncementStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRepeatLastNavAnnouncementStartResult] call navi service 'repeatLastNavAnnouncement()'");
        this.getNaviService().repeatLastNavAnnouncement();
        if (this.getExternalKeyListener() != null) {
            this.getExternalKeyListener().supplyExternalKey(100, 104, 1, 1);
            this.getExternalKeyListener().supplyExternalKey(100, 104, 0, 1);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRepeatLastNavAnnouncementStartResult] externalKeyListener is null");
        }
    }

    private ExternalKeyListener getExternalKeyListener() {
        return ((CombiModuleNavi)this.module).getExternalKeyListener();
    }

    @Override
    protected void processMapScaleSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapScale_SetGet mapScale_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(mapScale_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processMapScaleSetGet] Reserved Value Used. serializer: %1", (Object)mapScale_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        MapScale_Status mapScale_Status = (MapScale_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (mapScale_Status.autoZoom == mapScale_SetGet.autoZoom) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapScaleSetGet] autoZoom setting didn't change (%1)", (long)mapScale_SetGet.autoZoom);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapScaleSetGet] call navi service 'setMapScaleSetting(%1)'", (long)mapScale_SetGet.autoZoom);
            this.getNaviService().setMapScaleSetting(mapScale_SetGet.autoZoom);
        }
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapScaleSetGet] call navi service 'setMapScale(%1)'", (long)mapScale_SetGet.steps);
        this.getNaviService().setMapScale(mapScale_SetGet.steps);
    }

    private static boolean reservedValueUsed(MapScale_SetGet mapScale_SetGet) {
        return mapScale_SetGet.autoZoom >= 3 && mapScale_SetGet.autoZoom <= 14;
    }

    @Override
    protected void processAsgCapabilitiesSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ASG_Capabilities_SetGet aSG_Capabilities_SetGet) {
        bAPFunctionPropertyFSG.functionNotSupported();
    }

    @Override
    protected void processPoiSearchAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    @Override
    protected void processPoiSearchStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, POI_Search_StartResult pOI_Search_StartResult) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processPoiSearchStartResult] call navi service 'startPOISearch(searchType=%1, poiType=%2)'", (long)pOI_Search_StartResult.searchType, (long)pOI_Search_StartResult.poi_Type);
        if (BAPIndicationHandlerNavi.reservedValueUsed(pOI_Search_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processPoiSearchStartResult] Reserved Value Used. serializer: %1", (Object)pOI_Search_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        this.getNaviService().startPOISearch(pOI_Search_StartResult.searchType, pOI_Search_StartResult.poi_Type);
    }

    private static boolean reservedValueUsed(POI_Search_StartResult pOI_Search_StartResult) {
        if (pOI_Search_StartResult.searchType >= 2 && pOI_Search_StartResult.searchType <= 255) {
            return true;
        }
        return pOI_Search_StartResult.searchType >= 0 && pOI_Search_StartResult.searchType <= 62 || pOI_Search_StartResult.searchType >= 64 && pOI_Search_StartResult.searchType <= 102 || pOI_Search_StartResult.searchType >= 104 && pOI_Search_StartResult.searchType <= 255;
    }

    @Override
    protected void processMagnetFieldZoneSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MagnetFieldZone_SetGet magnetFieldZone_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(magnetFieldZone_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processMagnetFieldZoneSetGet] Reserved Value Used. serializer: %1", (Object)magnetFieldZone_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        bAPFunctionPropertyFSG.functionNotSupported();
    }

    private static boolean reservedValueUsed(MagnetFieldZone_SetGet magnetFieldZone_SetGet) {
        return magnetFieldZone_SetGet.zone >= 16 && magnetFieldZone_SetGet.zone <= 255;
    }

    @Override
    protected void processTmCinfoSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, TMCinfo_SetGet tMCinfo_SetGet) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processTmcinfoSetGet] called (messageID=%1)", (long)tMCinfo_SetGet.messageId);
        if (BAPIndicationHandlerNavi.reservedValueUsed(tMCinfo_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processTmCinfoSetGet] Reserved Value Used. serializer: %1", (Object)tMCinfo_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        if (tMCinfo_SetGet.messageStatus == 3) {
            ((CombiModuleNavi)this.module).getTMCInfoHandler().notifyMessagePresentationConfirmed(tMCinfo_SetGet.messageId);
        } else {
            this.logChannel.log(-1601830656, "[BAPIndicationHandlerNavi#processTmcinfoSetGet] invalid request");
            this.module.getRequestHandler().requestError(this.lsgID, 25, 5);
        }
    }

    private static boolean reservedValueUsed(TMCinfo_SetGet tMCinfo_SetGet) {
        return tMCinfo_SetGet.messageStatus >= 4 && tMCinfo_SetGet.messageStatus <= 255;
    }

    @Override
    protected void processActiveRgTypeSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, ActiveRgType_SetGet activeRgType_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(activeRgType_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processActiveRgTypeSetGet] Reserved Value Used. serializer: %1", (Object)activeRgType_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        ActiveRgType_Status activeRgType_Status = (ActiveRgType_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (activeRgType_Status.rgtype == activeRgType_SetGet.rgtype) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processActiveRgTypeSetGet] value didn't change (%1)'", (long)activeRgType_SetGet.rgtype);
            bAPFunctionPropertyFSG.resendLastStatus();
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processActiveRgTypeSetGet] call navi service 'setActiveRGType(%1)'", (long)activeRgType_SetGet.rgtype);
            this.getNaviService().setActiveRGType(activeRgType_SetGet.rgtype);
        }
    }

    private static boolean reservedValueUsed(ActiveRgType_SetGet activeRgType_SetGet) {
        return activeRgType_SetGet.rgtype >= 6 && activeRgType_SetGet.rgtype <= 254;
    }

    @Override
    protected void processGetNextListPosAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    @Override
    protected void processGetNextListPosStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, GetNextListPos_StartResult getNextListPos_StartResult) {
        Object object;
        int n;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processGetNextListPosStartResult] called for listType %1", (long)getNextListPos_StartResult.listType);
        if (BAPIndicationHandlerNavi.reservedValueUsed(getNextListPos_StartResult)) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processGetNextListPosStartResult] Reserved Value Used. serializer: %1", (Object)getNextListPos_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        boolean bl = false;
        switch (getNextListPos_StartResult.listType) {
            case 0: {
                n = 29;
                break;
            }
            case 1: {
                n = 30;
                break;
            }
            case 2: {
                this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processGetNextListPosStartResult] invalid listType: %1 - NavBook not supported", (long)getNextListPos_StartResult.listType);
                n = -1;
                bl = true;
                break;
            }
            case 3: {
                n = 33;
                break;
            }
            case 4: {
                this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processGetNextListPosStartResult] invalid listType: %1 - POI_List not supported", (long)getNextListPos_StartResult.listType);
                n = -1;
                bl = true;
                break;
            }
            default: {
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] invalid listType: %1", (long)getNextListPos_StartResult.listType);
                n = -1;
                bl = true;
            }
        }
        if (n != -1) {
            object = ((AbstractBAPModuleFSG)this.module).getBAPFunctionArrayFSG(n);
            if (object != null) {
                ArrayHandler arrayHandler = ((BAPFunctionArrayFSG)object).getArrayHandler();
                if (arrayHandler != null) {
                    arrayHandler.getNextListPos(getNextListPos_StartResult.currentPos, (short)getNextListPos_StartResult.offset);
                } else {
                    this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] no arrayHandler found for listType=%1", (long)getNextListPos_StartResult.listType);
                    bl = true;
                }
            } else {
                this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] function for listType=%1 not found", (long)getNextListPos_StartResult.listType);
                bl = true;
            }
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerAudio#processGetNextListPosStartResult] invalid listType=%1", (long)getNextListPos_StartResult.listType);
            bl = true;
        }
        if (bl) {
            object = (GetNextListPos_Result)((CombiModuleNavi)this.module).createResultSerializer(41);
            ((GetNextListPos_Result)object).getNextListPos_Result = 1;
            ((GetNextListPos_Result)object).currentPos = getNextListPos_StartResult.currentPos;
            ((GetNextListPos_Result)object).nextPos = -65536;
            ((GetNextListPos_Result)object).absoluteListPos = -65536;
            bAPFunctionMethodFSG.resultREQ((ResultMethod)object);
        }
    }

    private static boolean reservedValueUsed(GetNextListPos_StartResult getNextListPos_StartResult) {
        return getNextListPos_StartResult.listType >= 5 && getNextListPos_StartResult.listType <= 255;
    }

    @Override
    protected void processNbSpellerAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        bAPFunctionMethodFSG.functionNotSupported();
    }

    @Override
    protected void processNbSpellerStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, NbSpeller_StartResult nbSpeller_StartResult) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(nbSpeller_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processNbSpellerStartResult] Reserved Value Used. serializer: %1", (Object)nbSpeller_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        bAPFunctionMethodFSG.functionNotSupported();
    }

    private static boolean reservedValueUsed(NbSpeller_StartResult nbSpeller_StartResult) {
        return nbSpeller_StartResult.mode >= 3 && nbSpeller_StartResult.mode <= 255;
    }

    @Override
    protected void processRgActDeactAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)((CombiModuleNavi)this.module).createResultSerializer(34);
        rG_ActDeact_Result.rg_ActDeact_Result = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(rG_ActDeact_Result);
    }

    @Override
    protected void processRgActDeactStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, RG_ActDeact_StartResult rG_ActDeact_StartResult) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(rG_ActDeact_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] Reserved Value Used. serializer: %1", (Object)rG_ActDeact_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG);
            return;
        }
        ((CombiModuleNavi)this.module).rgActDeactStartResultReceived(rG_ActDeact_StartResult);
        if (rG_ActDeact_StartResult.controlType == 0) {
            switch (rG_ActDeact_StartResult.ci_Type) {
                case 4: {
                    this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] start route guidance to home address", (Object)bAPFunctionMethodFSG.getFctIDDescription());
                    this.getNaviService().startRouteGuidanceToHomeAddress();
                    break;
                }
                case 1: {
                    this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] start route guidance to last destination");
                    this.startRouteGuidanceToDestination(bAPFunctionMethodFSG, 29, rG_ActDeact_StartResult.controlInformation);
                    break;
                }
                case 2: {
                    this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] start route guidance to favorite destination");
                    this.startRouteGuidanceToDestination(bAPFunctionMethodFSG, 30, rG_ActDeact_StartResult.controlInformation);
                    break;
                }
                case 0: 
                case 3: 
                case 5: {
                    this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] CI_TYPE not supported: %1", (long)rG_ActDeact_StartResult.ci_Type);
                    RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)((CombiModuleNavi)this.module).createResultSerializer(34);
                    rG_ActDeact_Result.rg_ActDeact_Result = 1;
                    bAPFunctionMethodFSG.resultREQ(rG_ActDeact_Result);
                    break;
                }
                default: {
                    this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] Reserved Value ci_Type: %1", (long)rG_ActDeact_StartResult.ci_Type);
                    break;
                }
            }
        } else if (rG_ActDeact_StartResult.controlType == 1) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] stop route guidance", (Object)bAPFunctionMethodFSG.getFctIDDescription());
            this.getNaviService().stopRouteGuidance();
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processRgActDeactStartResult] Reserved Value controlType: %1", (long)rG_ActDeact_StartResult.controlType);
        }
    }

    private static boolean reservedValueUsed(RG_ActDeact_StartResult rG_ActDeact_StartResult) {
        if (rG_ActDeact_StartResult.controlType >= 4 && rG_ActDeact_StartResult.controlType <= 15) {
            return true;
        }
        return rG_ActDeact_StartResult.ci_Type >= 8 && rG_ActDeact_StartResult.ci_Type <= 15;
    }

    private void startRouteGuidanceToDestination(BAPFunctionMethodFSG bAPFunctionMethodFSG, int n, int n2) {
        ArrayHandler arrayHandler = ((AbstractBAPModuleFSG)this.module).getBAPFunctionArrayFSG(n).getArrayHandler();
        CombiBAPArrayElement combiBAPArrayElement = arrayHandler.getArrayElement(n2);
        if (combiBAPArrayElement instanceof CombiBAPDestinationListEntry) {
            CombiBAPDestinationListEntry combiBAPDestinationListEntry = (CombiBAPDestinationListEntry)combiBAPArrayElement;
            CombiBAPNaviDestination combiBAPNaviDestination = combiBAPDestinationListEntry.getAddressList()[0];
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#startRouteGuidanceToDestination] address=%1", (Object)combiBAPNaviDestination);
            this.getNaviService().startRouteGuidance(combiBAPNaviDestination);
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#startRouteGuidanceToDestination] no list entry with posID=%1 available", (long)n2);
            RG_ActDeact_Result rG_ActDeact_Result = (RG_ActDeact_Result)((CombiModuleNavi)this.module).createResultSerializer(34);
            rG_ActDeact_Result.rg_ActDeact_Result = 1;
            bAPFunctionMethodFSG.resultREQ(rG_ActDeact_Result);
        }
    }

    @Override
    protected void processMapPresentationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, Map_Presentation_SetGet map_Presentation_SetGet) {
        Map_Presentation_Status map_Presentation_Status = (Map_Presentation_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (map_Presentation_Status.asg_Hmi_State.equalTo(map_Presentation_SetGet.asg_Hmi_State)) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapPresentationSetGet] value didn't change (largeView=%1, leftSideMenuOpen=%2, rightSideMenuOpen=%3)'", map_Presentation_SetGet.asg_Hmi_State.largeMapView, map_Presentation_SetGet.asg_Hmi_State.leftSideMenueOpen, map_Presentation_SetGet.asg_Hmi_State.rightSideMenueOpen);
            bAPFunctionPropertyFSG.resendLastStatus();
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapPresentationSetGet] call navi service 'setActiveRGType(largeMapView=%1, leftSideMenuOpen=%2, rightSideMenuOpen=%3)'", map_Presentation_SetGet.asg_Hmi_State.largeMapView, map_Presentation_SetGet.asg_Hmi_State.leftSideMenueOpen, map_Presentation_SetGet.asg_Hmi_State.rightSideMenueOpen);
            this.getNaviService().setMapPresentation(map_Presentation_SetGet.asg_Hmi_State.largeMapView, map_Presentation_SetGet.asg_Hmi_State.leftSideMenueOpen, map_Presentation_SetGet.asg_Hmi_State.rightSideMenueOpen);
        }
    }

    @Override
    protected void processMapViewAndOrientationSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(mapViewAndOrientation_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] Reserved Value Used. serializer: %1", (Object)mapViewAndOrientation_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        MapViewAndOrientation_Status mapViewAndOrientation_Status = (MapViewAndOrientation_Status)bAPFunctionPropertyFSG.getLastStatus();
        boolean bl = false;
        if (mapViewAndOrientation_Status.mapView != mapViewAndOrientation_SetGet.mapView) {
            this.getNaviService().mapViewChanged(true);
        }
        if (mapViewAndOrientation_Status.mapView == mapViewAndOrientation_SetGet.mapView && mapViewAndOrientation_Status.supplementaryMapView == mapViewAndOrientation_SetGet.supplementaryMapView) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] map view didn't change (mapView=%1, supplementaryMapView=%2)", (long)mapViewAndOrientation_SetGet.mapView, (long)mapViewAndOrientation_SetGet.supplementaryMapView);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] call navi service 'setMapView(mapView=%1, supplementaryMapView=%2)'", (long)mapViewAndOrientation_SetGet.mapView, (long)mapViewAndOrientation_SetGet.supplementaryMapView);
            this.getNaviService().setMapView(mapViewAndOrientation_SetGet.mapView, mapViewAndOrientation_SetGet.supplementaryMapView);
            bl = true;
        }
        if (mapViewAndOrientation_Status.mapVisibility.equalTo(mapViewAndOrientation_SetGet.mapVisibility)) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] map visibility didn't change (lvdsMapVisible=%1, supplementaryMapViewVisible=%2)", mapViewAndOrientation_SetGet.mapVisibility.lvdsMapIsVisible, mapViewAndOrientation_SetGet.mapVisibility.supplementaryMapViewIsVisible);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] call navi service 'setMapVisibility(lvdsMapVisible=%1, supplementaryMapViewVisible=%2)'", mapViewAndOrientation_SetGet.mapVisibility.lvdsMapIsVisible, mapViewAndOrientation_SetGet.mapVisibility.supplementaryMapViewIsVisible);
            this.getNaviService().setMapVisibility(mapViewAndOrientation_SetGet.mapVisibility.lvdsMapIsVisible, mapViewAndOrientation_SetGet.mapVisibility.supplementaryMapViewIsVisible);
            bl = true;
        }
        if (mapViewAndOrientation_Status.mapOrientation == mapViewAndOrientation_SetGet.mapOrientation) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] map orientation didn't change (mapOrientation=%1)", (long)mapViewAndOrientation_SetGet.mapOrientation);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapViewAndOrientationSetGet] call navi service 'setMapOrientation(mapOrientation=%1)'", (long)mapViewAndOrientation_SetGet.mapOrientation);
            this.getNaviService().setMapOrientation(mapViewAndOrientation_SetGet.mapOrientation);
            bl = true;
        }
        if (!bl) {
            bAPFunctionPropertyFSG.resendLastStatus();
        }
    }

    private static boolean reservedValueUsed(MapViewAndOrientation_SetGet mapViewAndOrientation_SetGet) {
        if (mapViewAndOrientation_SetGet.mapView >= 3 && mapViewAndOrientation_SetGet.mapView <= 255) {
            return true;
        }
        if (mapViewAndOrientation_SetGet.mapOrientation >= 3 && mapViewAndOrientation_SetGet.mapOrientation <= 255) {
            return true;
        }
        return mapViewAndOrientation_SetGet.supplementaryMapView >= 4 && mapViewAndOrientation_SetGet.supplementaryMapView <= 255;
    }

    @Override
    protected void processMapColorAndTypeSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, MapColorAndType_SetGet mapColorAndType_SetGet) {
        if (BAPIndicationHandlerNavi.reservedValueUsed(mapColorAndType_SetGet)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerNavi#processMapColorAndTypeSetGet] Reserved Value Used. serializer: %1", (Object)mapColorAndType_SetGet);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyFSG);
            return;
        }
        MapColorAndType_Status mapColorAndType_Status = (MapColorAndType_Status)bAPFunctionPropertyFSG.getLastStatus();
        boolean bl = false;
        if (mapColorAndType_Status.colour == mapColorAndType_SetGet.colour) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapColorAndTypeSetGet] map color didn't change (color=%1)", (long)mapColorAndType_SetGet.colour);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapColorAndTypeSetGet] call navi service 'setMapColor(%1)'", (long)mapColorAndType_SetGet.colour);
            this.getNaviService().setMapColor(mapColorAndType_SetGet.colour);
            bl = true;
        }
        if (mapColorAndType_Status.activeMapType == mapColorAndType_SetGet.activeMapType && mapColorAndType_Status.mainMapSetup == mapColorAndType_SetGet.mainMapSetup) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapColorAndTypeSetGet] map type didn't change (activeMapType=%1, mainMapSetup=%2)", (long)mapColorAndType_SetGet.activeMapType, (long)mapColorAndType_SetGet.mainMapSetup);
        } else {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerNavi#processMapColorAndTypeSetGet] call navi service 'setMapType(activeMapType=%1, mainMapSetup=%2)", (long)mapColorAndType_SetGet.activeMapType, (long)mapColorAndType_SetGet.mainMapSetup);
            this.getNaviService().setMapType(mapColorAndType_SetGet.activeMapType, mapColorAndType_SetGet.mainMapSetup);
        }
        if (!bl) {
            bAPFunctionPropertyFSG.resendLastStatus();
        }
    }

    private static boolean reservedValueUsed(MapColorAndType_SetGet mapColorAndType_SetGet) {
        if (mapColorAndType_SetGet.colour >= 3 && mapColorAndType_SetGet.colour <= 255) {
            return true;
        }
        if (mapColorAndType_SetGet.mainMapSetup >= 3 && mapColorAndType_SetGet.mainMapSetup <= 254) {
            return true;
        }
        return mapColorAndType_SetGet.activeMapType >= 5 && mapColorAndType_SetGet.activeMapType <= 255;
    }

    private void sendAppErrorOutOfRange(AbstractBAPFunction abstractBAPFunction) {
        this.module.getRequestHandler().requestErrorCode(this.module.getLSGID(), abstractBAPFunction.getFctID(), 65);
        abstractBAPFunction.reset();
    }
}

