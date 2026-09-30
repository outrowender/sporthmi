/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.mfl;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.mfl.BAPIndicationHandlerMFL;
import de.audi.app.combi.bap.app.mfl.CombiModuleMFL;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.combi.bap.mfl.CombiBAPServiceMFL;
import de.vw.mib.bap.generated.mfl.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_SetGet;
import de.vw.mib.bap.generated.mfl.serializer.InstrumentClusterFunctions_Status;

public class AppConnectorMFL
extends AbstractCombiConnector
implements CombiBAPServiceMFL {
    protected AppConnectorMFL(CombiModuleMFL combiModuleMFL) {
        super(combiModuleMFL);
    }

    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        super.setAppServiceListener(bAPServiceListener);
        if (bAPServiceListener == null) {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(false);
        } else {
            this.moduleFsg.getInitializationManager().notifyAppServiceChanged(true);
            this.setAvailableJokerKeyClusterFunctions();
        }
    }

    private void setAvailableJokerKeyClusterFunctions() {
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(16);
        if (bAPFunctionPropertyFSG.isDataValid()) {
            InstrumentClusterFunctions_Status instrumentClusterFunctions_Status = (InstrumentClusterFunctions_Status)bAPFunctionPropertyFSG.getLastStatus();
            InstrumentClusterFunctions_SetGet instrumentClusterFunctions_SetGet = new InstrumentClusterFunctions_SetGet();
            instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToDigitalSpeedAvailable = instrumentClusterFunctions_Status.configurationOptions.contextSwitchToDigitalSpeedAvailable;
            instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToTrafficSignInformationAvailable = instrumentClusterFunctions_Status.configurationOptions.contextSwitchToTrafficSignInformationAvailable;
            instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToLastDestinationsListAvailable = instrumentClusterFunctions_Status.configurationOptions.contextSwitchToLastDestinationsListAvailable;
            instrumentClusterFunctions_SetGet.configurationOptions.contextSwitchToPhoneBookAvailable = instrumentClusterFunctions_Status.configurationOptions.contextSwitchToPhoneBookAvailable;
            instrumentClusterFunctions_SetGet.configurationOptions.trafficSignsOnOffAvailable = instrumentClusterFunctions_Status.configurationOptions.trafficSignsOnOffAvailable;
            instrumentClusterFunctions_SetGet.configurationOptions.screensaverOnOffAvailable = instrumentClusterFunctions_Status.configurationOptions.screensaverOnOffAvailable;
            ((BAPIndicationHandlerMFL)this.moduleFsg.getIndicationListener()).processInstrumentClusterFunctionsSetGet(bAPFunctionPropertyFSG, instrumentClusterFunctions_SetGet);
        }
    }

    public void updateInstalledKeys(int n) {
        this.logChannel.log(1000000, "[AppConnectorMFL#updateInstalledKeys] called (availableKeys=%1)", (Object)Integer.toBinaryString(n));
        FSG_Setup_Status fSG_Setup_Status = new FSG_Setup_Status();
        fSG_Setup_Status.installedKeys.jokerKey1Installed = (n & 1) == 1;
        fSG_Setup_Status.installedKeys.jokerKey2Installed = (n & 2) == 2;
        fSG_Setup_Status.installedKeys.jokerKey3Installed = (n & 4) == 4;
        fSG_Setup_Status.installedKeys.jokerKey4Installed = (n & 8) == 8;
        fSG_Setup_Status.installedKeys.jokerKey5Installed = (n & 0x10) == 16;
        this.moduleFsg.getBAPFunctionPropertyFSG(14).sendStatusIfChanged(fSG_Setup_Status);
    }

    public void updateCurrentJokerKeyFunction(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorMFL#updateCurrentJokerKeyFunction] called (keyID=%1, configuration=%2)", (long)n, (long)n2);
        ((CombiModuleMFL)this.moduleFsg).getMFLKeyHandler().updateKeyConfiguration(n, n2);
    }

    public void updateAvailableJokerKeyClusterFunctions(int n) {
        this.logChannel.log(1000000, "[AppConnectorMFL#updateAvailableJokerKeyClusterFunctions] called (availableFunctions=%1)", (long)n);
        ((CombiModuleMFL)this.moduleFsg).getMFLKeyHandler().updateInstrumentClusterFunctions(n);
    }
}

