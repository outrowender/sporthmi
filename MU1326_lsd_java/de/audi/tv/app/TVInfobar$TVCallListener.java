/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVInfobar;
import de.audi.tv.app.TVInfobar$1;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVInfobar$TVCallListener
extends DSICallListener {
    private final /* synthetic */ TVInfobar this$0;

    private TVInfobar$TVCallListener(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            TVInfobar.access$1602(this.this$0, 0);
            ProgramInfo programInfo = new ProgramInfo();
            programInfo.serviceInfo = serviceInfo;
            programInfo.availableAudioChannels = new AudioChannel[0];
            TVInfobar.access$700(this.this$0, programInfo, true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void switchSource(int n, boolean bl) {
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            if (n == 1 && !TVInfobar.access$1200(this.this$0)) {
                TVInfobar.access$900(this.this$0).cancel();
                TVInfobar.access$1202(this.this$0, true);
                TVInfobar.access$600(this.this$0);
                TVInfobar.access$1800(this.this$0).getLabelModel(-1901320448).setText("");
            } else if (n == 0 && TVInfobar.access$1200(this.this$0)) {
                TVInfobar.access$1202(this.this$0, false);
                TVInfobar.access$1800(this.this$0).getLabelModel(-1901320448).setText(TVInfobar.access$1900(this.this$0, TVInfobar.access$1300((TVInfobar)this.this$0).serviceInfo));
            }
            TVInfobar.access$1500(this.this$0).flush();
        }
    }

    /* synthetic */ TVInfobar$TVCallListener(TVInfobar tVInfobar, TVInfobar$1 tVInfobar$1) {
        this(tVInfobar);
    }
}

