/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2$1;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2$2;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2$3;
import java.util.ArrayList;

class OnlineServicesStateProvider$2
implements IDiagnosisCommandProvider {
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$2(OnlineServicesStateProvider onlineServicesStateProvider) {
        this.this$0 = onlineServicesStateProvider;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"OnlineServiceStateProvider.updateOnlineServices", "OnlineServiceStateProvider.addRemoteHMIService", "OnlineServiceStateProvider.clearOnlineServiceList", "OnlineServiceStateProvider.removeRHMIDevice", "OnlineServiceStateProvider.updateLastIndex"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("OnlineServiceStateProvider.updateOnlineServices".equals(string)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new OnlineServicesStateProvider$2$1(this));
            arrayList.add(new OnlineServicesStateProvider$2$2(this));
            this.this$0.updateOnlineServices(arrayList);
        } else if ("OnlineServiceStateProvider.addRemoteHMIService".equals(string)) {
            OnlineServicesStateProvider.access$200(this.this$0, new OnlineServicesStateProvider$2$3(this));
        } else if ("OnlineServiceStateProvider.updateLastIndex".equals(string)) {
            this.this$0.updateLastActiveOnlineService(0);
        } else if ("OnlineServiceStateProvider.clearOnlineServiceList".equals(string)) {
            this.this$0.updateOnlineServices(new ArrayList(0));
        } else if ("OnlineServiceStateProvider.removeRHMIDevice".equals(string)) {
            this.this$0.updateOnlineServices(null);
        }
    }
}

