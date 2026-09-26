/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsMapListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.online.TransitionCallback;

class RemoteHMIAppsMapListener$1
implements TransitionCallback {
    private final /* synthetic */ ButtonModelApp val$buttonModelApp;
    private final /* synthetic */ RemoteHMIAppsMapListener this$0;

    RemoteHMIAppsMapListener$1(RemoteHMIAppsMapListener remoteHMIAppsMapListener, ButtonModelApp buttonModelApp) {
        this.this$0 = remoteHMIAppsMapListener;
        this.val$buttonModelApp = buttonModelApp;
    }

    @Override
    public void triggerTransition() {
        this.val$buttonModelApp.fireEvent(0);
    }
}

