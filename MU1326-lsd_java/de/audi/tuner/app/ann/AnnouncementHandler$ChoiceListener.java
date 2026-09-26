/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ann;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ann.AnnouncementHandler$1;

class AnnouncementHandler$ChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ AnnouncementHandler this$0;

    private AnnouncementHandler$ChoiceListener(AnnouncementHandler announcementHandler) {
        this.this$0 = announcementHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100285: {
                if (this.this$0.toggleTaMode()) {
                    AnnouncementHandler.access$900(this.this$0).showPartialPopup(8);
                    break;
                }
                AnnouncementHandler.access$900(this.this$0).showPartialPopup(7);
                break;
            }
            case 5551: {
                AnnouncementHandler.access$1000(this.this$0, 0);
                break;
            }
            case 3826: {
                this.this$0.abortAnnouncement();
                break;
            }
            case 3827: {
                this.this$0.abortAnnouncement();
                this.this$0.switchTrafficAnnouncements(0, false);
                break;
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 100187: 
            case 100260: {
                AnnouncementHandler.access$1100(this.this$0).getChoiceModel(n).setValue(n2);
                int n5 = AnnouncementHandler.access$1100(this.this$0).getChoiceModel(0x880100).getValue();
                this.this$0.switchTrafficAnnouncements(n2, n5 == 1);
                break;
            }
            case 100352: {
                AnnouncementHandler.access$1100(this.this$0).getChoiceModel(n).setValue(n2);
                int n6 = AnnouncementHandler.access$1100(this.this$0).getChoiceModel(1535574272).getValue();
                this.this$0.switchTrafficAnnouncements(n6, n2 == 1);
                break;
            }
            case 100510: {
                if (this.this$0.toggleTaMode()) {
                    AnnouncementHandler.access$900(this.this$0).showPartialPopup(8);
                    break;
                }
                AnnouncementHandler.access$900(this.this$0).showPartialPopup(7);
                break;
            }
        }
    }

    /* synthetic */ AnnouncementHandler$ChoiceListener(AnnouncementHandler announcementHandler, AnnouncementHandler$1 announcementHandler$1) {
        this(announcementHandler);
    }
}

