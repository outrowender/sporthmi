/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.ServiceListsResource$1;
import org.dsi.ifc.tvtuner.ProgramInfo;

class ServiceListsResource$SelectedServiceDebouncedListener
extends TVEventDefaultListener {
    private final /* synthetic */ ServiceListsResource this$0;

    private ServiceListsResource$SelectedServiceDebouncedListener(ServiceListsResource serviceListsResource) {
        this.this$0 = serviceListsResource;
    }

    @Override
    public void onSelectedServiceDebounced(ProgramInfo programInfo) {
        ServiceListsResource.access$1000(this.this$0, programInfo);
        TVCommandList tVCommandList = ServiceListsResource.access$800(this.this$0).createCmdList(0);
        tVCommandList.add(ServiceListsResource.access$800(this.this$0).createUpdateSelectedStationCmd(this.this$0, true));
        ServiceListsResource.access$800(this.this$0).enqueue(tVCommandList);
    }

    /* synthetic */ ServiceListsResource$SelectedServiceDebouncedListener(ServiceListsResource serviceListsResource, ServiceListsResource$1 serviceListsResource$1) {
        this(serviceListsResource);
    }
}

