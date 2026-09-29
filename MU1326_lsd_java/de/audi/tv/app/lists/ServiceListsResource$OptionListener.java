/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.ServiceListsResource$1;

class ServiceListsResource$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ ServiceListsResource this$0;

    private ServiceListsResource$OptionListener(ServiceListsResource serviceListsResource) {
        this.this$0 = serviceListsResource;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        ServiceListsResource.access$500(this.this$0).log(1078071040, "[ServiceListsResource.OptionListener.keyTyped] %1, %2, %3", (long)n2, (long)n3, (long)n4);
        if (n4 == 2) {
            SelectedItem selectedItem = ServiceListsResource.access$600(this.this$0).getSelected();
            if (selectedItem != null) {
                this.this$0.handleAddFavorite(selectedItem.getIndex());
            }
        } else if (n == 1890330368) {
            this.this$0.handleAddFavorite(n3);
        }
    }

    /* synthetic */ ServiceListsResource$OptionListener(ServiceListsResource serviceListsResource, ServiceListsResource$1 serviceListsResource$1) {
        this(serviceListsResource);
    }
}

