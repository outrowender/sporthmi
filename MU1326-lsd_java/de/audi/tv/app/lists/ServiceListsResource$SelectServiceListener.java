/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.ServiceListsResource$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class ServiceListsResource$SelectServiceListener
extends DSICallListener {
    private final /* synthetic */ ServiceListsResource this$0;

    private ServiceListsResource$SelectServiceListener(ServiceListsResource serviceListsResource) {
        this.this$0 = serviceListsResource;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        ServiceListsResource.access$1100(this.this$0, serviceInfo);
        TVCommandList tVCommandList = ServiceListsResource.access$800(this.this$0).createCmdList(0);
        tVCommandList.add(ServiceListsResource.access$800(this.this$0).createUpdateSelectedStationCmd(this.this$0, false));
        ServiceListsResource.access$800(this.this$0).enqueue(tVCommandList);
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        ServiceListsResource.access$600(this.this$0).updateServiceLinking(bl);
    }

    /* synthetic */ ServiceListsResource$SelectServiceListener(ServiceListsResource serviceListsResource, ServiceListsResource$1 serviceListsResource$1) {
        this(serviceListsResource);
    }
}

