/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVInfobar;
import de.audi.tv.app.TVInfobar$1;
import de.audi.tv.app.dsi.DefaultTVListener;

class TVInfobar$TVListener
extends DefaultTVListener {
    private final /* synthetic */ TVInfobar this$0;

    private TVInfobar$TVListener(TVInfobar tVInfobar) {
        this.this$0 = tVInfobar;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateMuteState(int n) {
        TVInfobar.access$1602(this.this$0, n);
        Object object = TVInfobar.access$400(this.this$0);
        synchronized (object) {
            int n2 = TVInfobar.access$1700(this.this$0, TVInfobar.access$1300(this.this$0));
            TVInfobar.access$1800(this.this$0).getChoiceModel(-1230231808).setValue(n2);
            TVInfobar.access$1500(this.this$0).flush();
        }
    }

    /* synthetic */ TVInfobar$TVListener(TVInfobar tVInfobar, TVInfobar$1 tVInfobar$1) {
        this(tVInfobar);
    }
}

