/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.functionsync;

import de.audi.app.bap.fw.AbstractBAPModuleFSG;
import de.audi.app.combi.bap.functionsync.AbstractCommandOpenFunctionSync;
import de.audi.app.combi.bap.functionsync.AbstractFunctionSynchronization;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionSynchronisation_Status;
import de.vw.mib.bap.requests.StatusProperty;

final class CommandOpenFunctionSyncAudio
extends AbstractCommandOpenFunctionSync {
    public CommandOpenFunctionSyncAudio(AbstractBAPModuleFSG abstractBAPModuleFSG, AbstractFunctionSynchronization abstractFunctionSynchronization) {
        super(abstractBAPModuleFSG, abstractFunctionSynchronization);
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
                functionSynchronisation_Status.fctList_1.fctActiveSourceIsToBeSynchronised = true;
                break;
            }
            case 17: {
                functionSynchronisation_Status.fctList_1.fctActiveSourceNameIsToBeSynchronised = true;
                break;
            }
            case 18: {
                functionSynchronisation_Status.fctList_1.fctCurrentVolumeIsToBeSynchronised = true;
                break;
            }
            case 19: {
                functionSynchronisation_Status.fctList_1.fctMuteIsToBeSynchronised = true;
                break;
            }
            case 20: {
                functionSynchronisation_Status.fctList_1.fctSourceStateIsToBeSynchronised = true;
                break;
            }
            case 21: {
                functionSynchronisation_Status.fctList_1.fctCurrentStationInfoIsToBeSynchronised = true;
                break;
            }
            case 22: {
                functionSynchronisation_Status.fctList_1.fctCurrentStation_HandleIsToBeSynchronised = true;
                break;
            }
            case 23: {
                functionSynchronisation_Status.fctList_1.fctReceptionListIsNotToBeSynchronised = true;
                break;
            }
            case 24: {
                functionSynchronisation_Status.fctList_1.fctDedicatedAudioControlIsNotToBeSynchronised = true;
                break;
            }
            case 25: {
                functionSynchronisation_Status.fctList_1.fctGeneralInfoSwitchesIsToBeSynchronised = true;
                break;
            }
            case 26: {
                functionSynchronisation_Status.fctList_1.fctTpMemoInfoIsToBeSynchronised = true;
                break;
            }
            case 27: {
                functionSynchronisation_Status.fctList_1.fctTpMemoListIsNotToBeSynchronised = true;
                break;
            }
            case 28: {
                functionSynchronisation_Status.fctList_1.fctAnnouncementInfoIsToBeSynchronised = true;
                break;
            }
            case 29: {
                functionSynchronisation_Status.fctList_1.fctAnnouncementEscapeIsNotToBeSynchronised = true;
                break;
            }
            case 30: {
                functionSynchronisation_Status.fctList_1.fctInfoStatesIsToBeSynchronised = true;
                break;
            }
            case 31: {
                functionSynchronisation_Status.fctList_1.fctReceptionListTypeIsToBeSynchronised = true;
                break;
            }
            case 32: {
                functionSynchronisation_Status.fctList_1.fctSourceListIsNotToBeSynchronised = true;
                break;
            }
            case 33: {
                functionSynchronisation_Status.fctList_1.fctRadioTv_PresetListIsNotToBeSynchronised = true;
                break;
            }
            case 34: {
                functionSynchronisation_Status.fctList_1.fctSwitchSourceIsNotToBeSynchronised = true;
                break;
            }
            case 35: {
                functionSynchronisation_Status.fctList_1.fctMediaBrowser_FolderLevelIsToBeSynchronised = true;
                break;
            }
            case 36: {
                functionSynchronisation_Status.fctList_1.fctMediaBrowserIsNotToBeSynchronised = true;
                break;
            }
            case 37: {
                functionSynchronisation_Status.fctList_1.fctMediaPathIsToBeSynchronised = true;
                break;
            }
            case 38: {
                functionSynchronisation_Status.fctList_1.fctMediaBrowserControlIsNotToBeSynchronised = true;
                break;
            }
            case 39: {
                functionSynchronisation_Status.fctList_1.fctMediaFileInfoIsToBeSynchronised = true;
                break;
            }
            case 40: {
                functionSynchronisation_Status.fctList_1.fctPreferredListIsToBeSynchronised = true;
                break;
            }
            case 41: {
                functionSynchronisation_Status.fctList_1.fctSds_StateIsToBeSynchronised = true;
                break;
            }
            case 42: {
                functionSynchronisation_Status.fctList_1.fctFunctionSynchronisationIsNotToBeSynchronised = true;
                break;
            }
            case 43: {
                functionSynchronisation_Status.fctList_1.fctAsg_CapabilitiesIsNotToBeSynchronised = true;
                break;
            }
            case 44: {
                functionSynchronisation_Status.fctList_1.fctGetNextListPosIsNotToBeSynchronised = true;
                break;
            }
            case 45: {
                functionSynchronisation_Status.fctList_1.fctSwitchRadioMediaIsNotToBeSynchronised = true;
                break;
            }
            case 46: {
                functionSynchronisation_Status.fctList_1.fctMediaImportStateIsToBeSynchronised = true;
                break;
            }
            case 47: {
                functionSynchronisation_Status.fctList_1.fctCurrentVolumeExtendedIsToBeSynchronised = true;
                break;
            }
            case 48: {
                functionSynchronisation_Status.fctList_2.fctCustomerDownloadStateIsToBeSynchronised = true;
                break;
            }
            case 49: {
                functionSynchronisation_Status.fctList_2.fctOnlineMusic_StateIsToBeSynchronised = true;
                break;
            }
            case 50: {
                functionSynchronisation_Status.fctList_2.fct_CommonListIsNotToBeSynchronised = true;
                break;
            }
            case 51: {
                functionSynchronisation_Status.fctList_2.fctCurrentStation_Handle2IsToBeSynchronised = true;
                break;
            }
            case 52: {
                functionSynchronisation_Status.fctList_2.fctPlayPositionIsToBeSynchronised = true;
                break;
            }
            default: {
                this.logger.log(10000, "[CommandOpenFunctionSyncAudio#setFunctionBit] invalid fctID: %1", (long)n);
            }
        }
    }
}

