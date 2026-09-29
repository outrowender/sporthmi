/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ann.AnnouncementHandler$1;
import de.audi.tuner.ifc.IPowerEvent;

class AnnouncementHandler$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ AnnouncementHandler this$0;

    private AnnouncementHandler$PowerEventListener(AnnouncementHandler announcementHandler) {
        this.this$0 = announcementHandler;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        AnnouncementHandler.access$1202(this.this$0, n);
        switch (AnnouncementHandler.access$1200(this.this$0)) {
            case 2: 
            case 3: 
            case 4: {
                if (AnnouncementHandler.access$1300(this.this$0) == 20) break;
                this.this$0.abortAnnouncement();
                break;
            }
            case 0: 
            case 1: {
                if (AnnouncementHandler.access$1400(this.this$0) == 20) break;
                AnnouncementHandler.access$1500(this.this$0, AnnouncementHandler.access$1400(this.this$0));
                AnnouncementHandler.access$1402(this.this$0, 20);
                break;
            }
        }
    }

    /* synthetic */ AnnouncementHandler$PowerEventListener(AnnouncementHandler announcementHandler, AnnouncementHandler$1 announcementHandler$1) {
        this(announcementHandler);
    }
}

