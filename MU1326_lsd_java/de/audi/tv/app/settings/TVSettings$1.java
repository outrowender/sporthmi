/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.tv.app.settings.TVSettings;

class TVSettings$1
implements Consumer {
    private final /* synthetic */ TVSettings this$0;

    TVSettings$1(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    public void accept(Integer n) {
        if (n == 26) {
            TVSettings.access$500(this.this$0).enterSelectedTvAvMode();
            TVSettings.access$600(this.this$0).enterTVMode();
        } else {
            TVSettings.access$500(this.this$0).enterTerminalMode();
            TVSettings.access$600(this.this$0).enterTerminalMode();
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Integer)object);
    }
}

