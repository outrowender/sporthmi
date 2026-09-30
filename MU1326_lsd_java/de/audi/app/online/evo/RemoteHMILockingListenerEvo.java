/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMILockingListener;

public class RemoteHMILockingListenerEvo
extends AbstractRemoteHMILockingListener {
    private static final int LOCKING_NOT_CODED = 0;
    private static final int LOCKING_CODED_DISABLED = 1;
    private static final int LOCKING_CODED_GREYOUT = 2;
    private static final int LOCKING_CODED_INVISIBLE = 3;
    private final RemoteHMIServiceEvo remoteHmiService;
    private ChoiceModelApp onlineStateChoice;
    private int codedLockAction = 0;

    public RemoteHMILockingListenerEvo(HMIService hMIService, RemoteHMIServiceEvo remoteHMIServiceEvo, LogChannel logChannel) {
        super(hMIService, logChannel);
        this.remoteHmiService = remoteHMIServiceEvo;
        this.onlineStateChoice = remoteHMIServiceEvo.getModelBankAccess().getChoiceModel(2301813);
        this.readoutCodedState();
        this.setOnlineStatus(this.isLocked());
        this.sendInitalEvent();
    }

    protected final void invokeAction(RemoteHMIAction remoteHMIAction) {
        this.logChannel.log(1000000, "RemoteHMILockingListenerEvo#invokeAction: action=%1.", (Object)remoteHMIAction);
        if (this.remoteHmiService != null && remoteHMIAction != null) {
            int n = remoteHMIAction.getType();
            if (n == 460) {
                this.setOnlineStatus(true);
            } else if (n == 461) {
                this.setOnlineStatus(false);
            }
            this.logChannel.log(1000000, "RemoteHMILockingListenerEvo#invokeAction: type=%1.", (long)remoteHMIAction.getType());
            this.remoteHmiService.invokeAction(remoteHMIAction);
            if (this.sendSpeedThresholdMessages()) {
                if (460 == remoteHMIAction.getType()) {
                    this.remoteHmiService.invokeAction(new RemoteHMIAction(450));
                } else if (461 == remoteHMIAction.getType()) {
                    this.remoteHmiService.invokeAction(new RemoteHMIAction(451));
                }
            }
        }
    }

    private void readoutCodedState() {
        if (this.remoteHmiService.getModelBankAccess().getChoiceModel(5604).getValue() == 1) {
            this.codedLockAction = 2;
        } else if (this.remoteHmiService.getModelBankAccess().getChoiceModel(5605).getValue() == 1) {
            this.codedLockAction = 3;
        }
    }

    private void setOnlineStatus(boolean bl) {
        if (this.onlineStateChoice == null || this.codedLockAction == 0) {
            return;
        }
        if (bl) {
            this.onlineStateChoice.setValue(this.codedLockAction);
        } else {
            this.onlineStateChoice.setValue(1);
        }
    }

    protected boolean sendSpeedThresholdMessages() {
        return true;
    }
}

