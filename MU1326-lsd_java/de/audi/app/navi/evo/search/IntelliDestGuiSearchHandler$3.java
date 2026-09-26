/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$3
implements Runnable {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$3(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, NavLocation navLocation) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$navLocation = navLocation;
    }

    @Override
    public void run() {
        IntelliDestGuiSearchHandler.access$300(this.this$0, this.val$navLocation);
    }
}

