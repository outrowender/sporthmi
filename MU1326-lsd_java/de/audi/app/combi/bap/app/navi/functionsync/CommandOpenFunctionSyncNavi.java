/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi.functionsync;

import de.audi.app.combi.bap.functionsync.AbstractCommandOpenFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.vw.mib.bap.generated.navsd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.requests.StatusProperty;

public class CommandOpenFunctionSyncNavi
extends AbstractCommandOpenFunctionSync {
    public CommandOpenFunctionSyncNavi(AbstractCombiModule abstractCombiModule, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractCombiModule, abstractFunctionSynchronization);
    }

    @Override
    protected StatusProperty createFunctionSynchronizationStatus() {
        return new FunctionSynchronisation_Status();
    }

    @Override
    protected void setFunctionBit(int n) {
        FunctionSynchronisation_Status functionSynchronisation_Status = (FunctionSynchronisation_Status)this.functionSyncStatusSerializer;
        switch (n) {
            case 16: {
                functionSynchronisation_Status.fctList_1.fctCompassInfoIsToBeSynchronised = true;
                break;
            }
            case 17: {
                functionSynchronisation_Status.fctList_1.fctRg_StatusIsToBeSynchronised = true;
                break;
            }
            case 18: {
                functionSynchronisation_Status.fctList_1.fctDistanceToNextManeuverIsToBeSynchronised = true;
                break;
            }
            case 19: {
                functionSynchronisation_Status.fctList_1.fctCurrentPositionInfoIsToBeSynchronised = true;
                break;
            }
            case 20: {
                functionSynchronisation_Status.fctList_1.fctTurnToInfoIsToBeSynchronised = true;
                break;
            }
            case 21: {
                functionSynchronisation_Status.fctList_1.fctDistanceToDestinationIsToBeSynchronised = true;
                break;
            }
            case 22: {
                functionSynchronisation_Status.fctList_1.fctTimeToDestinationIsToBeSynchronised = true;
                break;
            }
            case 23: {
                functionSynchronisation_Status.fctList_1.fctManeuverDescriptorIsToBeSynchronised = true;
                break;
            }
            case 24: {
                functionSynchronisation_Status.fctList_1.fctLaneGuidanceIsToBeSynchronised = true;
                break;
            }
            case 25: {
                functionSynchronisation_Status.fctList_1.fctTmcinfoIsToBeSynchronised = true;
                break;
            }
            case 26: {
                functionSynchronisation_Status.fctList_1.fctMagnetFieldZoneIsToBeSynchronised = true;
                break;
            }
            case 27: {
                functionSynchronisation_Status.fctList_1.fctCalibrationIsToBeSynchronised = true;
                break;
            }
            case 29: {
                functionSynchronisation_Status.fctList_1.fctLastDest_ListIsToBeSynchronised = true;
                break;
            }
            case 30: {
                functionSynchronisation_Status.fctList_1.fctFavoriteDest_ListIsToBeSynchronised = true;
                break;
            }
            case 31: {
                functionSynchronisation_Status.fctList_1.fctPreferredDest_ListIsToBeSynchronised = true;
                break;
            }
            case 32: {
                functionSynchronisation_Status.fctList_1.fctNavBookIsToBeSynchronised = true;
                break;
            }
            case 33: {
                functionSynchronisation_Status.fctList_1.fctAddress_ListIsToBeSynchronised = true;
                break;
            }
            case 34: {
                functionSynchronisation_Status.fctList_1.fctRg_ActDeactIsToBeSynchronised = true;
                break;
            }
            case 36: {
                functionSynchronisation_Status.fctList_1.fctVoiceGuidanceIsToBeSynchronised = true;
                break;
            }
            case 38: {
                functionSynchronisation_Status.fctList_1.fctInfoStatesIsToBeSynchronised = true;
                break;
            }
            case 39: {
                functionSynchronisation_Status.fctList_1.fctActiveRgTypeIsToBeSynchronised = true;
                break;
            }
            case 40: {
                functionSynchronisation_Status.fctList_1.fctTrafficBlock_IndicationIsToBeSynchronised = true;
                break;
            }
            case 43: {
                functionSynchronisation_Status.fctList_1.fct_MapColorAndTypeIsToBeSynchronised = true;
                break;
            }
            case 44: {
                functionSynchronisation_Status.fctList_1.fct_MapViewAndOrientationIsToBeSynchronised = true;
                break;
            }
            case 45: {
                functionSynchronisation_Status.fctList_1.fct_MapScaleIsToBeSynchronised = true;
                break;
            }
            case 46: {
                functionSynchronisation_Status.fctList_1.fct_DestinationInfoIsToBeSynchronised = true;
                break;
            }
            case 47: {
                functionSynchronisation_Status.fctList_1.fct_AltitudeIsToBeSynchronised = true;
                break;
            }
            case 48: {
                functionSynchronisation_Status.fctList_2.fct_OnlineNavigationStateIsToBeSynchronised = true;
                break;
            }
            case 49: {
                functionSynchronisation_Status.fctList_2.fct_ExitViewIsToBeSynchronised = true;
                break;
            }
            case 50: {
                functionSynchronisation_Status.fctList_2.fct_SemidynamicRouteGuidanceIsToBeSynchronised = true;
                break;
            }
            case 53: {
                functionSynchronisation_Status.fctList_2.fct_Fsg_SetupIsToBeSynchronised = true;
                break;
            }
            case 54: {
                functionSynchronisation_Status.fctList_2.fct_MapPresentationIsToBeSynchronised = true;
                break;
            }
            default: {
                this.logger.log(10000, "[CommandOpenFunctionSyncNavi#enabledSyncForFunction] invalid fctID: %1", (long)n);
            }
        }
    }
}

