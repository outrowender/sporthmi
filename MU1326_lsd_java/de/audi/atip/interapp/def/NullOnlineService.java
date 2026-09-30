/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.OnlineService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullOnlineService
extends NullService
implements OnlineService {
    public NullOnlineService(LogChannel logChannel) {
        super(logChannel, "OnlineService");
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public void setRemoteHMIRecognizedID(int n) {
        super.log();
    }

    public void setRemoteHMIGlobalRecognizedID(int n) {
        super.log();
    }

    public void requestDialogContinuation() {
    }

    public void dialogStepFinished() {
    }

    public void setRemoteHMIHelpRecognizedID(int n, byte by) {
    }

    public void helpOpened(int n) {
    }

    public void setRemoteHMINavDestFormFinished() {
    }

    public void setRemoteHMIGlobalEnter() {
    }

    public void setDisclaimerResult(boolean bl) {
    }

    public void remoteHMIUpdateHelp() {
    }

    public void remoteHMISetRecognizedLineNumber() {
    }

    public void remoteHMIResetNavLocationInput() {
    }
}

