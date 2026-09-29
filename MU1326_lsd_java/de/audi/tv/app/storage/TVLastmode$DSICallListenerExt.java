/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.tv.app.TVUtil;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.storage.TVLastmode;
import de.audi.tv.app.storage.TVLastmode$1;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVLastmode$DSICallListenerExt
extends DSICallListener {
    private final /* synthetic */ TVLastmode this$0;

    private TVLastmode$DSICallListenerExt(TVLastmode tVLastmode) {
        this.this$0 = tVLastmode;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        TVLastmode.access$700(this.this$0).setTunedService(serviceInfo);
    }

    @Override
    public void switchSource(int n, boolean bl) {
        TVLastmode.access$400((TVLastmode)this.this$0).lcMain.log(-2137614336, "[TVLastmode.switchSource] source:%1", (long)n);
        int n2 = TVUtil.getInternalSourceRepresentation(n);
        if (n2 != -1) {
            TVLastmode.access$700(this.this$0).setActiveSource(n2);
        }
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        TVLastmode.access$302(this.this$0, n);
    }

    /* synthetic */ TVLastmode$DSICallListenerExt(TVLastmode tVLastmode, TVLastmode$1 tVLastmode$1) {
        this(tVLastmode);
    }
}

