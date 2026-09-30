/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.RemoteHmiLockingCoding;

public abstract class AbstractRemoteHMILockingListener {
    private static final String CLASS_NAME = "AbstractRemoteHMILockingListener";
    protected final HMIService hmiService;
    protected final LogChannel logChannel;

    public AbstractRemoteHMILockingListener(HMIService hMIService, LogChannel logChannel) {
        this.hmiService = hMIService;
        this.logChannel = logChannel;
    }

    protected final void sendInitalEvent() {
        this.logChannel.log(1000000, "AbstractRemoteHMILockingListener#sendInitalEvent: locked=%1.", (Object)Boolean.toString(this.isLocked()));
        this.invokeAction(this.getAction(this.isLocked()));
        this.sendLockingBits();
    }

    protected abstract void invokeAction(RemoteHMIAction var1);

    private RemoteHMIAction getAction(boolean bl) {
        int n = bl ? 460 : 461;
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(n);
        remoteHMIAction.setParameters(this.getLockingBits());
        return remoteHMIAction;
    }

    protected boolean isLocked() {
        boolean bl = false;
        if (this.hmiService == null) {
            this.logChannel.log(10000, "%1#isLocked: hmiService is null!", (Object)this.getClass().getName());
        } else {
            int n = this.hmiService.getChoiceModel(5583).getValue();
            this.logChannel.log(10000000, "%1#isLocked: LOCK_FEATURE_STATE_CHOICE = %2.", (Object)CLASS_NAME, (long)n);
            bl = n == 1;
        }
        return bl;
    }

    protected HMIProperties getLockingBits() {
        HMIProperties hMIProperties = new HMIProperties();
        return hMIProperties;
    }

    public final void updateLockingState(boolean bl) {
        this.logChannel.log(1000000, "%1#udpateLockingState param=%2", (Object)CLASS_NAME, (Object)Boolean.toString(bl));
        this.invokeAction(this.getAction(bl));
    }

    public void sendLockingBits() {
        this.logChannel.log(1000000, "%1#sendLockingBits called.", (Object)CLASS_NAME);
        RemoteHmiLockingCoding remoteHmiLockingCoding = RemoteHmiLockingCoding.create(this.hmiService, this.logChannel);
        if (remoteHmiLockingCoding == null) {
            this.logChannel.log(100000, "%1#sendLockingBits read coding error!", (Object)CLASS_NAME);
            return;
        }
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(462);
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("lockingBits", remoteHmiLockingCoding);
        remoteHMIAction.setParameters(hMIProperties);
        this.invokeAction(remoteHMIAction);
    }
}

