/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.entertainmentdrawer;

import de.audi.app.phone.evo.entertainmentdrawer.EntertainmentDrawerControllerImplNew;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContextListener;

class EntertainmentDrawerControllerImplNew$1
implements AudioDrawerContextListener {
    private final /* synthetic */ EntertainmentDrawerControllerImplNew this$0;

    EntertainmentDrawerControllerImplNew$1(EntertainmentDrawerControllerImplNew entertainmentDrawerControllerImplNew) {
        this.this$0 = entertainmentDrawerControllerImplNew;
    }

    @Override
    public void updateActiveContext(AudioDrawerContext$Source audioDrawerContext$Source, int n) {
        EntertainmentDrawerControllerImplNew.access$000(this.this$0).log(1078071040, "[EntertainmentDrawerControllerImplNew.AudioDrawerContextListener#updateActiveContext] source=%1, drawerState=%2", (Object)audioDrawerContext$Source, (long)n);
        if (EntertainmentDrawerControllerImplNew.access$100(this.this$0) == 2) {
            EntertainmentDrawerControllerImplNew.access$200(this.this$0);
        }
    }

    @Override
    public void entertainmentDrawerOpened() {
        EntertainmentDrawerControllerImplNew.access$300(this.this$0).log(1078071040, "[EntertainmentDrawerControllerImplNew#entertainmentDrawerOpened]");
        this.this$0.setDrawerState(0);
    }

    @Override
    public void entertainmentDrawerClosed() {
        EntertainmentDrawerControllerImplNew.access$400(this.this$0).log(1078071040, "[EntertainmentDrawerControllerImplNew#entertainmentDrawerClosed]");
        this.this$0.setDrawerState(1);
        this.this$0.flushModelGroupAndChangeAudioContext();
    }
}

