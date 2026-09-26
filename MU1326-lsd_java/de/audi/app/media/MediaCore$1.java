/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media;

import de.audi.app.media.MediaCore;
import de.audi.atip.base.IDomainListener;

class MediaCore$1
implements IDomainListener {
    private final /* synthetic */ MediaCore this$0;

    MediaCore$1(MediaCore mediaCore) {
        this.this$0 = mediaCore;
    }

    @Override
    public void updateDomainState(int n, int n2) {
        if (n != 3 && !MediaCore.access$000(this.this$0).isEvoHigh()) {
            return;
        }
        int n3 = 0;
        if ((n2 & 0x4000) == 16384) {
            n3 |= 1;
        }
        MediaCore.access$000(this.this$0).getHmiServiceApp().getChoiceModel(2064581376).setValue(n3);
    }

    @Override
    public void muDomainIsAvailable(int n, int n2) {
    }
}

