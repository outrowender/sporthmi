/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public class RequestAudioTriggerCall
extends NavSimpleCall {
    private final int audioMode;
    private final DSINavigationManager dsiNavigationManager;

    public RequestAudioTriggerCall(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, int n) {
        super(navigationEnv.getCommandLogChannel());
        this.audioMode = n;
        this.dsiNavigationManager = dSINavigationManager;
    }

    @Override
    public void execute() {
        if (this.dsiNavigationManager == null) {
            this.logger.log(10000, "RequestAudioTriggerCall#execute() - dsiNavigationManager is null %1", (Object)this.dsiNavigationManager);
            return;
        }
        if (this.dsiNavigationManager.getDSINavigation(0) == null) {
            this.logger.log(10000, "RequestAudioTriggerCall#execute() - dsiNavigation is null");
            return;
        }
        this.logger.log(-2137614336, "RequestAudioTriggerCall#execute() - calling requestAudioTrigger( %1 )", (long)this.audioMode);
        this.dsiNavigationManager.getDSINavigation(0).requestAudioTrigger(this.audioMode);
    }
}

