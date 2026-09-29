/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.storage.TVLastmode;
import de.audi.tv.app.storage.TVLastmode$1;
import org.dsi.ifc.tvtuner.ProgramInfo;

class TVLastmode$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ TVLastmode this$0;

    private TVLastmode$TVListenerImpl(TVLastmode tVLastmode) {
        this.this$0 = tVLastmode;
    }

    @Override
    public void updateTerminalMode(int n, int n2) {
        TVLastmode.access$302(this.this$0, n);
    }

    @Override
    public void updateTunerState(int n) {
        TVLastmode.access$400((TVLastmode)this.this$0).lcMain.log(-2137614336, "[TVLastmode.updateTunerState] state:%1", (long)n);
        boolean bl = TVLastmode.access$500(this.this$0) == 0 && n == 1;
        TVLastmode.access$502(this.this$0, n);
        TVLastmode.access$600(this.this$0, bl);
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        TVLastmode.access$700(this.this$0).setTunedService(programInfo.serviceInfo);
    }

    /* synthetic */ TVLastmode$TVListenerImpl(TVLastmode tVLastmode, TVLastmode$1 tVLastmode$1) {
        this(tVLastmode);
    }
}

