/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.RemoteHMIAppsDestinationListener;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.interapp.online.TransitionCallback;

class RemoteHMIAppsDestinationListener$1
implements TransitionCallback {
    private final /* synthetic */ OptionModelApp val$optionModelApp;
    private final /* synthetic */ RemoteHMIAppsDestinationListener this$0;

    RemoteHMIAppsDestinationListener$1(RemoteHMIAppsDestinationListener remoteHMIAppsDestinationListener, OptionModelApp optionModelApp) {
        this.this$0 = remoteHMIAppsDestinationListener;
        this.val$optionModelApp = optionModelApp;
    }

    @Override
    public void triggerTransition() {
        this.val$optionModelApp.fireEvent(0);
    }
}

