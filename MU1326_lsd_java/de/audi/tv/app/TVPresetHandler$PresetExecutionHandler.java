/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.TVPresetStation;
import java.io.Serializable;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVPresetHandler$PresetExecutionHandler
implements IAppPresetExecutionHandler {
    private final /* synthetic */ TVPresetHandler this$0;

    private TVPresetHandler$PresetExecutionHandler(TVPresetHandler tVPresetHandler) {
        this.this$0 = tVPresetHandler;
    }

    @Override
    public int getExecutionType() {
        return 7;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestExecute(ExecuteRequest executeRequest) {
        Serializable serializable = executeRequest.getPreset().getData();
        if (serializable instanceof TVPresetStation) {
            ServiceInfo serviceInfo = TVPresetHandler.access$1000((TVPresetStation)serializable);
            Object object = TVPresetHandler.access$600(this.this$0);
            synchronized (object) {
                TVPresetHandler.access$900(this.this$0).log(-2137614336, "[TVPresetHandler.requestExecute] service: %1", (Object)serviceInfo);
                if (TVPresetHandler.access$1100(this.this$0)) {
                    if (TVPresetHandler.access$1200(this.this$0) != 0) {
                        TVPresetHandler.access$1300(this.this$0).changeService(serviceInfo, true);
                        TVPresetHandler.access$1402(this.this$0, serviceInfo);
                        TVPresetHandler.access$1500(this.this$0).activate(0);
                    } else {
                        TVPresetHandler.access$1300(this.this$0).changeService(serviceInfo, true);
                    }
                    if (!TVPresetHandler.access$1600(this.this$0)) {
                        TVPresetHandler.access$1700(this.this$0).activateTVAudio(0);
                        TVPresetHandler.access$900(this.this$0).log(-2137614336, "[TVPresetHandler.requestExecute] TV audiofocus for MU forced!");
                    }
                } else {
                    TVPresetHandler.access$1802(this.this$0, serviceInfo);
                    if (!TVPresetHandler.access$1600(this.this$0)) {
                        TVPresetHandler.access$1700(this.this$0).activateTVAudio(0);
                        TVPresetHandler.access$1500(this.this$0).activate(0);
                        TVPresetHandler.access$1900(this.this$0).activateParent();
                    }
                }
            }
            executeRequest.responseExecute(0);
        } else {
            TVPresetHandler.access$900(this.this$0).log(-2137614336, "[TVPresetHandler.requestExecute] error");
            executeRequest.responseExecute(1);
        }
    }

    /* synthetic */ TVPresetHandler$PresetExecutionHandler(TVPresetHandler tVPresetHandler, TVPresetHandler$1 tVPresetHandler$1) {
        this(tVPresetHandler);
    }
}

