/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.DomainHandler;
import de.esolutions.fw.util.commons.Buffer;

class AppStateManager$StartDomain
implements Runnable {
    private final int domainId;
    private final int minumumState;
    private final int requiredState;
    private final Runnable onSuccess;
    private final boolean async;
    private final ComponentState componentState;
    private final /* synthetic */ AppStateManager this$0;

    AppStateManager$StartDomain(AppStateManager appStateManager, int n, int n2, int n3, Runnable runnable, boolean bl, ComponentState componentState) {
        this.this$0 = appStateManager;
        this.domainId = n;
        this.minumumState = n2;
        this.requiredState = n3;
        this.onSuccess = runnable;
        this.async = bl;
        this.componentState = componentState;
    }

    public String toString() {
        return new Buffer().append(new StringBuffer().append("StartDomain").append(this.async ? "Async" : "").append("(").toString()).append(AppStateManager.access$100(this.this$0, this.domainId)).append(", 0x").append(Integer.toHexString(this.requiredState)).append(')').toString();
    }

    @Override
    public void run() {
        if (!this.async) {
            if (this.onSuccess != null && this.componentState != null) {
                this.this$0.getLog().log(-2137614336, "set DomainState to %1", 1L);
                this.componentState.setDomainStartState(1);
            }
            int n = AppStateManager.access$200(this.this$0).doStartDomain(this.domainId, this.requiredState);
            this.this$0.getLog().log(1078071040, "AppStateManager.StartDomain.run( %1, 0x%2): resultstate: 0x%3", (Object)DomainHandler.getDomainName(this.domainId), (long)this.requiredState, (long)n);
            if (DomainHandler.isFailed(n)) {
                if (this.componentState != null) {
                    this.componentState.setDomainStartState(-1);
                }
            } else if (DomainHandler.isIncluded(this.minumumState, n) && this.onSuccess != null) {
                if (this.componentState != null) {
                    this.componentState.setDomainStartState(2);
                }
                this.onSuccess.run();
            }
            if (this.domainId == 6) {
                this.this$0.getStartupManager().getSyncNav().setupWait();
                this.this$0.getStartupManager().getSyncTTS().setupWait();
            } else if (this.domainId == 10) {
                this.this$0.getStartupManager().getSyncSDS().setupWait();
            }
        } else {
            AppStateManager.access$200(this.this$0).doStartDomainAsync(this.domainId, this.requiredState);
        }
    }
}

