/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.arrays.GetArrayIndication;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.generated.mfl.AbstractBAPIndicationHandlerMFL;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFLListener;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_SetGet;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_Status;
import de.vw.mib.bap.generated.mfl.serializer.KeyConfiguration_Ack;
import de.vw.mib.bap.generated.mfl.serializer.PU_Action_Result;
import de.vw.mib.bap.generated.mfl.serializer.PU_Action_StartResult;
import de.vw.mib.bap.requests.GetArray;

public class BAPIndicationHandlerMFL
extends AbstractBAPIndicationHandlerMFL {
    protected BAPIndicationHandlerMFL(CombiModuleMFL combiModuleMFL) {
        super(combiModuleMFL, combiModuleMFL.getLogChannel());
    }

    public CombiBAPServiceMFLListener getMFLServiceListener() {
        return ((CombiModuleMFL)this.module).getMFLServiceListener();
    }

    @Override
    public GetArrayIndication evaluateGetArrayIndication(int n, GetArray getArray) {
        return null;
    }

    @Override
    protected void processInstrumentClusterFunctionsSetGet(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, InstrumentClusterFunctions_SetGet instrumentClusterFunctions_SetGet) {
        InstrumentClusterFunctions_Status instrumentClusterFunctions_Status = (InstrumentClusterFunctions_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (instrumentClusterFunctions_Status.configurationOptions.equalTo(instrumentClusterFunctions_SetGet.configurationOptions)) {
            bAPFunctionPropertyFSG.resendLastStatus();
            return;
        }
        int n = 0;
        if (instrumentClusterFunctions_SetGet.configurationOptions.screensaverOnOffAvailable) {
            n |= 1;
        }
        if (instrumentClusterFunctions_SetGet.configurationOptions.trafficSignsOnOffAvailable) {
            n |= 2;
        }
        if (instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToPhoneBookAvailable) {
            n |= 4;
        }
        if (instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToLastDestinationsListAvailable) {
            n |= 8;
        }
        if (instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToTrafficSignInformationAvailable) {
            n |= 0x10;
        }
        if (instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToDigitalSpeedAvailable) {
            n |= 0x20;
        }
        if (this.getMFLServiceListener() != null) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerMFL#processInstrumentClusterFunctionsSetGet] call mflService 'setAvailableJokerKeyFunctions'");
            this.getMFLServiceListener().setAvailableJokerKeyClusterFunctions(n);
        } else {
            this.logChannel.log(-1601830656, "[BAPIndicationHandlerMFL#processInstrumentClusterFunctionsSetGet] mflService not available");
            ((CombiModuleMFL)this.module).getMFLService().updateAvailableJokerKeyClusterFunctions(n);
        }
    }

    @Override
    protected void processKeyConfigurationAck(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, KeyConfiguration_Ack keyConfiguration_Ack) {
        if (this.getMFLServiceListener() != null) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerMFL#processKeyConfigurationAck] call mflService 'confirmCurrentJokerKeyFunctions'");
            this.getMFLServiceListener().confirmCurrentJokerKeyFunctions(keyConfiguration_Ack.configKey1, keyConfiguration_Ack.configKey2, keyConfiguration_Ack.configKey3, keyConfiguration_Ack.configKey4, keyConfiguration_Ack.configKey5);
        } else {
            this.logChannel.log(-1601830656, "[BAPIndicationHandlerMFL#processKeyConfigurationAck] mflService not available");
        }
    }

    @Override
    protected void processPuActionAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerMFL#processPuActionAbort] Method can't be aborted: %1", (Object)bAPFunctionMethodFSG.getFctIDDescription());
        PU_Action_Result pU_Action_Result = (PU_Action_Result)((CombiModuleMFL)this.module).createResultSerializer(20);
        pU_Action_Result.pu_ActionResult = 3;
        bAPFunctionMethodFSG.resultAbortNotSuccessfulREQ(pU_Action_Result);
    }

    @Override
    protected void processPuActionStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, PU_Action_StartResult pU_Action_StartResult) {
        this.logChannel.log(1078071040, "[BAPIndicationHandlerMFL#processPuActionStartResult] taid=%1, option=%2", (long)pU_Action_StartResult.taid, (long)pU_Action_StartResult.option);
        if (BAPIndicationHandlerMFL.reservedValueUsed(pU_Action_StartResult)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerMFL#processPuActionStartResult] Reserved Value Used. serializer: %1", (Object)pU_Action_StartResult);
            this.sendAppErrorOutOfRange(bAPFunctionMethodFSG.getFctID());
            return;
        }
        ((CombiModuleMFL)this.module).getPartialPopupHandler().popupActionPerformed(pU_Action_StartResult.taid, pU_Action_StartResult.option);
    }

    private static boolean reservedValueUsed(PU_Action_StartResult pU_Action_StartResult) {
        return pU_Action_StartResult.option >= 5 && pU_Action_StartResult.option <= 15;
    }

    private void sendAppErrorOutOfRange(int n) {
        this.module.getRequestHandler().requestErrorCode(this.module.getLSGID(), n, 65);
    }
}

