/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.TVPresetStation;
import de.audi.tv.app.lists.AbstractTVStationRow;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVPresetHandler$PresetDefinitionHandler
implements IAppPresetDefinitionHandler {
    private final /* synthetic */ TVPresetHandler this$0;

    private TVPresetHandler$PresetDefinitionHandler(TVPresetHandler tVPresetHandler) {
        this.this$0 = tVPresetHandler;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int[] getModelIds() {
        return TVPresetHandler.access$500(this.this$0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void requestDefinition(DefinitionRequest definitionRequest) {
        Object object;
        int n = definitionRequest.getModelId();
        int n2 = definitionRequest.getRowId();
        ServiceInfo serviceInfo = null;
        if (n == -1146345728) {
            object = TVPresetHandler.access$600(this.this$0);
            synchronized (object) {
                serviceInfo = TVPresetHandler.access$700(this.this$0);
            }
        } else {
            object = TVPresetHandler.access$800(this.this$0).getBaseListModel(n).getRow(n2);
            if (object instanceof AbstractTVStationRow) {
                serviceInfo = ((AbstractTVStationRow)object).service;
            }
        }
        TVPresetHandler.access$900(this.this$0).log(-2137614336, "[TVPresetHandler.requestDefinition] model %2, service: %1", (Object)serviceInfo, (long)n);
        if (serviceInfo != null) {
            object = new PresetListRow();
            ((EvoListRow)object).setText(2, serviceInfo.name);
            ((EvoListRow)object).setText(4, "TV");
            definitionRequest.responseDefine(0, new TVPresetStation(serviceInfo), (PresetListRow)object, 7);
        } else {
            definitionRequest.responseDefine(1, null, null, 99);
        }
    }

    /* synthetic */ TVPresetHandler$PresetDefinitionHandler(TVPresetHandler tVPresetHandler, TVPresetHandler$1 tVPresetHandler$1) {
        this(tVPresetHandler);
    }
}

