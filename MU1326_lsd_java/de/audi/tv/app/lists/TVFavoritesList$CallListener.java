/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.TVFavoritesList$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVFavoritesList$CallListener
extends DSICallListener {
    private final /* synthetic */ TVFavoritesList this$0;

    private TVFavoritesList$CallListener(TVFavoritesList tVFavoritesList) {
        this.this$0 = tVFavoritesList;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        TVFavoritesList.access$400(this.this$0, this.this$0.stationList);
    }

    /* synthetic */ TVFavoritesList$CallListener(TVFavoritesList tVFavoritesList, TVFavoritesList$1 tVFavoritesList$1) {
        this(tVFavoritesList);
    }
}

