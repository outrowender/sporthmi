/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionlists;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.navi.AbstractFunctionListNavi;
import de.vw.mib.bap.generated.navsd.serializer.FunctionList_Status;

public class FunctionListNaviEvo
extends AbstractFunctionListNavi {
    protected void initFunctionListStatusWithVariantAndRegion(int n, int n2) {
        this.functionSupported = new boolean[this.getMaxFctID() + 1];
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(this.getFctListBAPFctID());
        FunctionList_Status functionList_Status = (FunctionList_Status)this.moduleFsg.createStatusSerializer(this.getFctListBAPFctID());
        this.initCommonFunctions(functionList_Status);
        switch (n) {
            case 0: {
                this.initVariantStd(functionList_Status);
                break;
            }
            case 1: {
                this.initVariantHighPrem(functionList_Status);
                break;
            }
            case 2: {
                this.initVariantMMIKombi(functionList_Status);
                break;
            }
            case 3: {
                this.initVariantMMIKombiHUD(functionList_Status);
                break;
            }
            default: {
                this.initVariantHighPrem(functionList_Status);
            }
        }
        switch (n2) {
            case 2: {
                this.initRegionChina(functionList_Status);
                break;
            }
        }
        bAPFunctionPropertyFSG.setInitialStatus(functionList_Status);
    }

    private void initCommonFunctions(FunctionList_Status functionList_Status) {
        functionList_Status.fctGetAllAvailable = true;
        this.functionSupported[1] = true;
        functionList_Status.fctBap_ConfigAvailable = true;
        this.functionSupported[2] = true;
        functionList_Status.fctFunctionListAvailable = true;
        this.functionSupported[3] = true;
        functionList_Status.fctHeartBeatAvailable = true;
        this.functionSupported[4] = true;
        functionList_Status.fctFsg_OperationStateAvailable = true;
        this.functionSupported[15] = true;
    }

    private void initVariantStd(FunctionList_Status functionList_Status) {
        functionList_Status.fctCompassInfoAvailable = true;
        this.functionSupported[16] = true;
        functionList_Status.fctRg_StatusAvailable = true;
        this.functionSupported[17] = true;
        functionList_Status.fctDistanceToNextManeuverAvailable = true;
        this.functionSupported[18] = true;
        functionList_Status.fctCurrentPositionInfoAvailable = true;
        this.functionSupported[19] = true;
        functionList_Status.fctTurnToInfoAvailable = true;
        this.functionSupported[20] = true;
        functionList_Status.fctDistanceToDestinationAvailable = true;
        this.functionSupported[21] = true;
        functionList_Status.fctTimeToDestinationAvailable = true;
        this.functionSupported[22] = true;
        functionList_Status.fctManeuverDescriptorAvailable = true;
        this.functionSupported[23] = true;
        functionList_Status.fctLaneGuidanceAvailable = true;
        this.functionSupported[24] = true;
        functionList_Status.fctTmcinfoAvailable = true;
        this.functionSupported[25] = true;
        functionList_Status.fctMagnetFieldZoneAvailable = false;
        this.functionSupported[26] = false;
        functionList_Status.fctCalibrationAvailable = false;
        this.functionSupported[27] = false;
        functionList_Status.fctAsg_CapabilitiesAvailable = false;
        this.functionSupported[28] = false;
        functionList_Status.fctLastDest_ListAvailable = true;
        this.functionSupported[29] = true;
        functionList_Status.fctFavoriteDest_ListAvailable = true;
        this.functionSupported[30] = true;
        functionList_Status.fctPreferredDest_ListAvailable = false;
        this.functionSupported[31] = false;
        functionList_Status.fctNavBookAvailable = false;
        this.functionSupported[32] = false;
        functionList_Status.fctAddress_ListAvailable = true;
        this.functionSupported[33] = true;
        functionList_Status.fctRg_ActDeactAvailable = true;
        this.functionSupported[34] = true;
        functionList_Status.fctRepeatLastNavAnnouncementAvailable = false;
        this.functionSupported[35] = false;
        functionList_Status.fctVoiceGuidanceAvailable = true;
        this.functionSupported[36] = true;
        functionList_Status.fctFunctionSynchronisationAvailable = true;
        this.functionSupported[37] = true;
        functionList_Status.fctInfoStatesAvailable = true;
        this.functionSupported[38] = true;
        functionList_Status.fctActiveRgTypeAvailable = true;
        this.functionSupported[39] = true;
        functionList_Status.fctTrafficBlock_IndicationAvailable = true;
        this.functionSupported[40] = true;
        functionList_Status.fctGetNextListPosAvailable = true;
        this.functionSupported[41] = true;
        functionList_Status.fctNbSpellerAvailable = false;
        this.functionSupported[42] = false;
        functionList_Status.fctMapColorAndTypeAvailable = false;
        this.functionSupported[43] = false;
        functionList_Status.fctMapViewAndOrientationAvailable = false;
        this.functionSupported[44] = false;
        functionList_Status.fctMapScaleAvailable = false;
        this.functionSupported[45] = false;
        functionList_Status.fctDestinationInfoAvailable = true;
        this.functionSupported[46] = true;
        functionList_Status.fctAltitudeAvailable = false;
        this.functionSupported[47] = false;
        functionList_Status.fctOnlineNavigationStateAvailable = false;
        this.functionSupported[48] = false;
        functionList_Status.fctExitviewAvailable = true;
        this.functionSupported[49] = true;
        functionList_Status.fctSemidynamicRouteGuidanceAvailable = true;
        this.functionSupported[50] = true;
        functionList_Status.fctPoi_SearchAvailable = false;
        this.functionSupported[51] = false;
        functionList_Status.fctPoi_ListAvailable = false;
        this.functionSupported[52] = false;
        functionList_Status.fctFsg_SetupAvailable = true;
        this.functionSupported[53] = true;
        functionList_Status.fctMap_PresentationAvailable = false;
        this.functionSupported[54] = false;
        functionList_Status.fctManeuverStateAvailable = true;
        this.functionSupported[55] = true;
    }

    private void initVariantHighPrem(FunctionList_Status functionList_Status) {
        this.initVariantStd(functionList_Status);
        functionList_Status.fctMapColorAndTypeAvailable = true;
        this.functionSupported[43] = true;
        functionList_Status.fctMapViewAndOrientationAvailable = true;
        this.functionSupported[44] = true;
        functionList_Status.fctMapScaleAvailable = true;
        this.functionSupported[45] = true;
        functionList_Status.fctAltitudeAvailable = true;
        this.functionSupported[47] = true;
        functionList_Status.fctOnlineNavigationStateAvailable = true;
        this.functionSupported[48] = true;
        functionList_Status.fctMap_PresentationAvailable = true;
        this.functionSupported[54] = true;
    }

    private void initVariantMMIKombi(FunctionList_Status functionList_Status) {
        functionList_Status.fctCompassInfoAvailable = true;
        this.functionSupported[16] = true;
        functionList_Status.fctRg_StatusAvailable = true;
        this.functionSupported[17] = true;
        functionList_Status.fctDistanceToNextManeuverAvailable = true;
        this.functionSupported[18] = true;
        functionList_Status.fctCurrentPositionInfoAvailable = true;
        this.functionSupported[19] = true;
        functionList_Status.fctTurnToInfoAvailable = true;
        this.functionSupported[20] = true;
        functionList_Status.fctDistanceToDestinationAvailable = true;
        this.functionSupported[21] = true;
        functionList_Status.fctTimeToDestinationAvailable = true;
        this.functionSupported[22] = true;
        functionList_Status.fctManeuverDescriptorAvailable = false;
        this.functionSupported[23] = false;
        functionList_Status.fctLaneGuidanceAvailable = false;
        this.functionSupported[24] = false;
        functionList_Status.fctTmcinfoAvailable = false;
        this.functionSupported[25] = false;
        functionList_Status.fctMagnetFieldZoneAvailable = false;
        this.functionSupported[26] = false;
        functionList_Status.fctCalibrationAvailable = false;
        this.functionSupported[27] = false;
        functionList_Status.fctAsg_CapabilitiesAvailable = false;
        this.functionSupported[28] = false;
        functionList_Status.fctLastDest_ListAvailable = false;
        this.functionSupported[29] = false;
        functionList_Status.fctFavoriteDest_ListAvailable = false;
        this.functionSupported[30] = false;
        functionList_Status.fctPreferredDest_ListAvailable = false;
        this.functionSupported[31] = false;
        functionList_Status.fctNavBookAvailable = false;
        this.functionSupported[32] = false;
        functionList_Status.fctAddress_ListAvailable = false;
        this.functionSupported[33] = false;
        functionList_Status.fctRg_ActDeactAvailable = false;
        this.functionSupported[34] = false;
        functionList_Status.fctRepeatLastNavAnnouncementAvailable = false;
        this.functionSupported[35] = false;
        functionList_Status.fctVoiceGuidanceAvailable = false;
        this.functionSupported[36] = false;
        functionList_Status.fctFunctionSynchronisationAvailable = true;
        this.functionSupported[37] = true;
        functionList_Status.fctInfoStatesAvailable = true;
        this.functionSupported[38] = true;
        functionList_Status.fctActiveRgTypeAvailable = false;
        this.functionSupported[39] = false;
        functionList_Status.fctTrafficBlock_IndicationAvailable = false;
        this.functionSupported[40] = false;
        functionList_Status.fctGetNextListPosAvailable = false;
        this.functionSupported[41] = false;
        functionList_Status.fctNbSpellerAvailable = false;
        this.functionSupported[42] = false;
        functionList_Status.fctMapColorAndTypeAvailable = false;
        this.functionSupported[43] = false;
        functionList_Status.fctMapViewAndOrientationAvailable = false;
        this.functionSupported[44] = false;
        functionList_Status.fctMapScaleAvailable = false;
        this.functionSupported[45] = false;
        functionList_Status.fctDestinationInfoAvailable = true;
        this.functionSupported[46] = true;
        functionList_Status.fctAltitudeAvailable = true;
        this.functionSupported[47] = true;
        functionList_Status.fctOnlineNavigationStateAvailable = true;
        this.functionSupported[48] = true;
        functionList_Status.fctExitviewAvailable = false;
        this.functionSupported[49] = false;
        functionList_Status.fctSemidynamicRouteGuidanceAvailable = true;
        this.functionSupported[50] = true;
        functionList_Status.fctPoi_SearchAvailable = false;
        this.functionSupported[51] = false;
        functionList_Status.fctPoi_ListAvailable = false;
        this.functionSupported[52] = false;
        functionList_Status.fctFsg_SetupAvailable = false;
        this.functionSupported[53] = false;
        functionList_Status.fctMap_PresentationAvailable = false;
        this.functionSupported[54] = false;
        functionList_Status.fctEtc_StatusAvailable = true;
        this.functionSupported[56] = true;
    }

    private void initVariantMMIKombiHUD(FunctionList_Status functionList_Status) {
        this.initVariantMMIKombi(functionList_Status);
        functionList_Status.fctManeuverDescriptorAvailable = true;
        this.functionSupported[23] = true;
        functionList_Status.fctLaneGuidanceAvailable = true;
        this.functionSupported[24] = true;
        functionList_Status.fctTrafficBlock_IndicationAvailable = true;
        this.functionSupported[40] = true;
        functionList_Status.fctExitviewAvailable = true;
        this.functionSupported[49] = true;
    }

    private void initRegionChina(FunctionList_Status functionList_Status) {
        functionList_Status.fctAltitudeAvailable = false;
        this.functionSupported[47] = false;
    }

    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    protected int getMaxFctID() {
        return 56;
    }

    public int getGetAllFctID() {
        return 1;
    }

    public int getBAPConfigBAPFctID() {
        return 2;
    }

    public int getFctListBAPFctID() {
        return 3;
    }

    public int getOperationStateBAPFctID() {
        return 15;
    }
}

