/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.ServiceListsResource$1;
import de.audi.tv.app.settings.ISettingListener$Stub;

class ServiceListsResource$SettingListener
extends ISettingListener$Stub {
    private final /* synthetic */ ServiceListsResource this$0;

    private ServiceListsResource$SettingListener(ServiceListsResource serviceListsResource) {
        this.this$0 = serviceListsResource;
    }

    @Override
    public void updateStationListSorting(int n) {
        ServiceListsResource.access$1202(this.this$0, n);
    }

    /* synthetic */ ServiceListsResource$SettingListener(ServiceListsResource serviceListsResource, ServiceListsResource$1 serviceListsResource$1) {
        this(serviceListsResource);
    }
}

