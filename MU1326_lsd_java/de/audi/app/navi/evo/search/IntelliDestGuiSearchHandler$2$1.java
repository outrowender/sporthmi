/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler$2;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$2$1
implements Runnable {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ IntelliDestGuiSearchHandler$2 this$1;

    IntelliDestGuiSearchHandler$2$1(IntelliDestGuiSearchHandler$2 intelliDestGuiSearchHandler$2, NavLocation navLocation) {
        this.this$1 = intelliDestGuiSearchHandler$2;
        this.val$navLocation = navLocation;
    }

    @Override
    public void run() {
        if (IntelliDestGuiSearchHandler.access$100(IntelliDestGuiSearchHandler$2.access$000(this.this$1)).isDebug2()) {
            IntelliDestGuiSearchHandler.access$200(IntelliDestGuiSearchHandler$2.access$000(this.this$1)).log(14808325, "%1#searchResultSelected - Store Address as HomeAddress", (Object)"IntelliDestGuiSearchHandler");
        }
        IntelliDestGuiSearchHandler$2.access$000((IntelliDestGuiSearchHandler$2)this.this$1).homeAddressHandler.onCreateEditHomeAddress(this.val$navLocation);
    }
}

