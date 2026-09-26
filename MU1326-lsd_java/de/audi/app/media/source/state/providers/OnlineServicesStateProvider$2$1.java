/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;

class OnlineServicesStateProvider$2$1
implements OnlineApplicationOtherContext {
    private final /* synthetic */ OnlineServicesStateProvider$2 this$1;

    OnlineServicesStateProvider$2$1(OnlineServicesStateProvider$2 onlineServicesStateProvider$2) {
        this.this$1 = onlineServicesStateProvider$2;
    }

    @Override
    public String getAppName() {
        return "Napster";
    }

    @Override
    public String getAppContext() {
        return "Napster";
    }

    @Override
    public String getSourceListIconActive() {
        return null;
    }

    @Override
    public String getSourceListIconInactive() {
        return null;
    }

    @Override
    public String getSourceListIconReflection() {
        return null;
    }

    @Override
    public String getCaptionIcon() {
        return null;
    }

    @Override
    public String getLoadingIcon() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int getEntryPointId() {
        return 12346;
    }

    @Override
    public String getSubEntryPoint() {
        return null;
    }
}

