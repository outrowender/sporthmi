/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.TVSettings$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVSettings$DSICallListenerExt
extends DSICallListener {
    private final /* synthetic */ TVSettings this$0;

    private TVSettings$DSICallListenerExt(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    @Override
    public void switchSource(int n, boolean bl) {
        TVSettings.access$900(this.this$0).setSelectedSource(n);
        TVSettings.access$600(this.this$0).setSelectedSource(n);
        TVSettings.access$500(this.this$0).setSelectedSource(n);
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        TVSettings.access$1000(this.this$0).update(bl);
    }

    @Override
    public void enableSubtitle(boolean bl) {
        TVSettings.access$1100(this.this$0).update(bl);
    }

    @Override
    public void setBrowserListSort(int n) {
        TVSettings.access$1200(this.this$0).update(n);
    }

    @Override
    public void setNormArea(int n) {
        TVSettings.access$1300(this.this$0).updateTVNormArea(n);
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        TVSettings.access$1400((TVSettings)this.this$0).callListener.selectService(serviceInfo, bl);
    }

    @Override
    public void selectNextService(int n) {
        TVSettings.access$1400((TVSettings)this.this$0).callListener.selectNextService(n);
    }

    /* synthetic */ TVSettings$DSICallListenerExt(TVSettings tVSettings, TVSettings$1 tVSettings$1) {
        this(tVSettings);
    }
}

