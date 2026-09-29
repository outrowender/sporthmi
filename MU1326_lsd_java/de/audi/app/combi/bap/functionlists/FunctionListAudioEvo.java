/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.functionlists;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.app.audio.AbstractFunctionListAudio;
import de.vw.mib.bap.generated.audiosd.serializer.FunctionList_Status;

public class FunctionListAudioEvo
extends AbstractFunctionListAudio {
    @Override
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
            case 2: 
            case 3: {
                this.initVariantMMIKombi(functionList_Status);
                break;
            }
            default: {
                this.initVariantHighPrem(functionList_Status);
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
        functionList_Status.fctFsg_SetupAvailable = true;
        this.functionSupported[14] = true;
        functionList_Status.fctFsg_OperationStateAvailable = true;
        this.functionSupported[15] = true;
    }

    private void initVariantStd(FunctionList_Status functionList_Status) {
        functionList_Status.fctActiveSourceAvailable = true;
        this.functionSupported[16] = true;
        functionList_Status.fctActiveSourceNameAvailable = true;
        this.functionSupported[17] = true;
        functionList_Status.fctSourceStateAvailable = true;
        this.functionSupported[20] = true;
        functionList_Status.fctCurrentStationInfoAvailable = true;
        this.functionSupported[21] = true;
        functionList_Status.fctCurrentStation_HandleAvailable = true;
        this.functionSupported[22] = true;
        functionList_Status.fctCurrentStation_Handle2Available = false;
        this.functionSupported[51] = false;
        functionList_Status.fctDedicatedAudioControlAvailable = true;
        this.functionSupported[24] = true;
        functionList_Status.fctGeneralInfoSwitchesAvailable = false;
        this.functionSupported[25] = false;
        functionList_Status.fctInfoStatesAvailable = true;
        this.functionSupported[30] = true;
        functionList_Status.fctSourceListAvailable = true;
        this.functionSupported[32] = true;
        functionList_Status.fctSwitchSourceAvailable = true;
        this.functionSupported[34] = true;
        functionList_Status.fctPreferredListAvailable = true;
        this.functionSupported[40] = true;
        functionList_Status.fctFunctionSynchronisationAvailable = true;
        this.functionSupported[42] = true;
        functionList_Status.fctAsg_CapabilitiesAvailable = true;
        this.functionSupported[43] = true;
        functionList_Status.fctGetNextListPosAvailable = true;
        this.functionSupported[44] = true;
        functionList_Status.fctSwitchRadioMediaAvailable = true;
        this.functionSupported[45] = true;
        functionList_Status.fctMediaImportStateAvailable = false;
        this.functionSupported[46] = false;
        functionList_Status.fctOnlineMusic_StateAvailable = false;
        this.functionSupported[49] = false;
        functionList_Status.fctCurrentVolumeAvailable = false;
        this.functionSupported[18] = false;
        functionList_Status.fctCurrentVolumeExtendedAvailable = false;
        this.functionSupported[47] = false;
        functionList_Status.fctMuteAvailable = true;
        this.functionSupported[19] = true;
        functionList_Status.fctReceptionListAvailable = true;
        this.functionSupported[23] = true;
        functionList_Status.fctTpMemoInfoAvailable = true;
        this.functionSupported[26] = true;
        functionList_Status.fctTpMemoListAvailable = false;
        this.functionSupported[27] = false;
        functionList_Status.fctAnnouncementInfoAvailable = true;
        this.functionSupported[28] = true;
        functionList_Status.fctAnnouncementEscapeAvailable = true;
        this.functionSupported[29] = true;
        functionList_Status.fctReceptionListTypeAvailable = true;
        this.functionSupported[31] = true;
        functionList_Status.fctRadioTv_PresetListAvailable = true;
        this.functionSupported[33] = true;
        functionList_Status.fctCommonListAvailable = false;
        this.functionSupported[50] = false;
        functionList_Status.fctMediaBrowser_FolderLevelAvailable = true;
        this.functionSupported[35] = true;
        functionList_Status.fctMediaBrowserAvailable = true;
        this.functionSupported[36] = true;
        functionList_Status.fctMediaPathAvailable = true;
        this.functionSupported[37] = true;
        functionList_Status.fctMediaBrowserControlAvailable = true;
        this.functionSupported[38] = true;
        functionList_Status.fctMediaFileInfoAvailable = false;
        this.functionSupported[39] = false;
        functionList_Status.fctPlayPositionAvailable = true;
        this.functionSupported[52] = true;
        functionList_Status.fctSds_StateAvailable = true;
        this.functionSupported[41] = true;
        functionList_Status.fctCustomerDownloadStateAvailable = false;
        this.functionSupported[48] = false;
    }

    private void initVariantHighPrem(FunctionList_Status functionList_Status) {
        this.initVariantStd(functionList_Status);
        functionList_Status.fctOnlineMusic_StateAvailable = true;
        this.functionSupported[49] = true;
        functionList_Status.fctMediaImportStateAvailable = true;
        this.functionSupported[46] = true;
    }

    private void initVariantMMIKombi(FunctionList_Status functionList_Status) {
        this.initVariantStd(functionList_Status);
        functionList_Status.fctCurrentStation_HandleAvailable = false;
        this.functionSupported[22] = false;
        functionList_Status.fctReceptionListAvailable = false;
        this.functionSupported[23] = false;
        functionList_Status.fctDedicatedAudioControlAvailable = false;
        this.functionSupported[24] = false;
        functionList_Status.fctReceptionListTypeAvailable = false;
        this.functionSupported[31] = false;
        functionList_Status.fctSourceListAvailable = true;
        this.functionSupported[32] = true;
        functionList_Status.fctRadioTv_PresetListAvailable = false;
        this.functionSupported[33] = false;
        functionList_Status.fctCommonListAvailable = true;
        this.functionSupported[50] = true;
        functionList_Status.fctSwitchSourceAvailable = false;
        this.functionSupported[34] = false;
        functionList_Status.fctPreferredListAvailable = false;
        this.functionSupported[40] = false;
        functionList_Status.fctMediaBrowser_FolderLevelAvailable = false;
        this.functionSupported[35] = false;
        functionList_Status.fctMediaBrowserAvailable = false;
        this.functionSupported[36] = false;
        functionList_Status.fctMediaPathAvailable = false;
        this.functionSupported[37] = false;
        functionList_Status.fctMediaBrowserControlAvailable = false;
        this.functionSupported[38] = false;
        functionList_Status.fctGetNextListPosAvailable = false;
        this.functionSupported[44] = false;
        functionList_Status.fctSwitchRadioMediaAvailable = false;
        this.functionSupported[45] = false;
        functionList_Status.fctMediaImportStateAvailable = true;
        this.functionSupported[46] = true;
        functionList_Status.fctCurrentVolumeExtendedAvailable = true;
        this.functionSupported[47] = true;
        functionList_Status.fctCustomerDownloadStateAvailable = true;
        this.functionSupported[48] = true;
        functionList_Status.fctOnlineMusic_StateAvailable = true;
        this.functionSupported[49] = true;
    }

    @Override
    protected int getMinModuleSpecificFctID() {
        return 16;
    }

    @Override
    protected int getMaxFctID() {
        return 52;
    }

    @Override
    public int getGetAllFctID() {
        return 1;
    }

    @Override
    public int getBAPConfigBAPFctID() {
        return 2;
    }

    @Override
    public int getFctListBAPFctID() {
        return 3;
    }

    @Override
    public int getOperationStateBAPFctID() {
        return 15;
    }
}

