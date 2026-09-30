/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.system;

import de.audi.app.combi.bap.AbstractCombiConnector;
import de.audi.app.combi.bap.app.audio.CombiModuleAudio;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem;
import de.vw.mib.bap.generated.audiosd.serializer.CustomerDownloadState_Status;

public class AppConnectorSystem
extends AbstractCombiConnector
implements CombiBAPServiceSystem {
    public AppConnectorSystem(CombiModuleAudio combiModuleAudio) {
        super(combiModuleAudio);
    }

    public void updateCustomerDownloadState(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorSystem#updateCustomerDownloadState] called (state=%1, progress=%2)", (long)n, (long)n2);
        CustomerDownloadState_Status customerDownloadState_Status = new CustomerDownloadState_Status();
        customerDownloadState_Status.customerDownloadState = n;
        customerDownloadState_Status.progressCustomerDownload = n2;
        this.sendPropertyStatus(48, customerDownloadState_Status);
    }
}

