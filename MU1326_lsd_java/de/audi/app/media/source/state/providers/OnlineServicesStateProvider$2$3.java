/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.interapp.online.TransitionCallback;
import org.dsi.ifc.global.NavLocation;

class OnlineServicesStateProvider$2$3
implements OnlineServiceProvider {
    private final /* synthetic */ OnlineServicesStateProvider$2 this$1;

    OnlineServicesStateProvider$2$3(OnlineServicesStateProvider$2 onlineServicesStateProvider$2) {
        this.this$1 = onlineServicesStateProvider$2;
    }

    @Override
    public void startMediaApp(String string, boolean bl) {
    }

    @Override
    public void stopMediaApp(String string) {
    }

    @Override
    public void startDestinationApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
    }

    @Override
    public void startMapApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
    }

    @Override
    public void downloadAppListForNavi() {
    }

    @Override
    public void stopPhoneApp(String string) {
    }

    @Override
    public void startPhoneApp(String string, boolean bl) {
    }
}

