/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.cmd.TVCommandList;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.ServiceListsResource$1;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

class ServiceListsResource$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ ServiceListsResource this$0;

    private ServiceListsResource$TVListenerImpl(ServiceListsResource serviceListsResource) {
        this.this$0 = serviceListsResource;
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray) {
        ServiceListsResource.access$700(this.this$0, serviceInfoArray);
        TVCommandList tVCommandList = ServiceListsResource.access$800(this.this$0).createCmdList(0);
        tVCommandList.add(ServiceListsResource.access$800(this.this$0).createUpdateStationListCmd(this.this$0, ServiceListsResource.access$900(this.this$0)));
        ServiceListsResource.access$800(this.this$0).enqueue(tVCommandList);
    }

    @Override
    public void updateLogoList(LogoInfo[] logoInfoArray) {
    }

    /* synthetic */ ServiceListsResource$TVListenerImpl(ServiceListsResource serviceListsResource, ServiceListsResource$1 serviceListsResource$1) {
        this(serviceListsResource);
    }
}

