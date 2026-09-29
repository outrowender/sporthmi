/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.settings.VisualAudio;

class VisualAudio$1
implements Consumer {
    private final /* synthetic */ VisualAudio this$0;

    VisualAudio$1(VisualAudio visualAudio) {
        this.this$0 = visualAudio;
    }

    public void accept(Boolean bl) {
        VisualAudio.access$100(this.this$0, bl);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

