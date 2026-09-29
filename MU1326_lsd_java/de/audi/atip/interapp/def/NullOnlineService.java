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

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public void setRemoteHMIRecognizedID(int n) {
        super.log();
    }

    @Override
    public void setRemoteHMIGlobalRecognizedID(int n) {
        super.log();
    }

    @Override
    public void requestDialogContinuation() {
    }

    @Override
    public void dialogStepFinished() {
    }

    @Override
    public void setRemoteHMIHelpRecognizedID(int n, byte by) {
    }

    @Override
    public void helpOpened(int n) {
    }

    @Override
    public void setRemoteHMINavDestFormFinished() {
    }

    @Override
    public void setRemoteHMIGlobalEnter() {
    }

    @Override
    public void setDisclaimerResult(boolean bl) {
    }

    @Override
    public void remoteHMIUpdateHelp() {
    }

    @Override
    public void remoteHMISetRecognizedLineNumber() {
    }

    @Override
    public void remoteHMIResetNavLocationInput() {
    }
}

