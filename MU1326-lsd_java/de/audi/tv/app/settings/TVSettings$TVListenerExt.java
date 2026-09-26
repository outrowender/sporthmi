/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.TVSettings$1;
import org.dsi.ifc.tvtuner.ProgramInfo;

class TVSettings$TVListenerExt
extends DefaultTVListener {
    private final /* synthetic */ TVSettings this$0;

    private TVSettings$TVListenerExt(TVSettings tVSettings) {
        this.this$0 = tVSettings;
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo) {
        TVSettings.access$700(this.this$0).update(programInfo.availableAudioChannels);
        TVSettings.access$700(this.this$0).updateActiveAudioChannel(programInfo.selectedAudioChannel);
        TVSettings.access$600(this.this$0).update(programInfo.videoFormat);
        TVSettings.access$1400(this.this$0).updateRequiredAge(programInfo.parentalRating);
    }

    @Override
    public void updateServiceLinking(boolean bl) {
        TVSettings.access$1000(this.this$0).update(bl);
    }

    @Override
    public void updateSubtitle(boolean bl) {
        TVSettings.access$1100(this.this$0).update(bl);
    }

    @Override
    public void updateTVNormArea(int n) {
        TVSettings.access$1300(this.this$0).updateTVNormArea(n);
    }

    @Override
    public void updateTVNormList(int[] nArray) {
        TVSettings.access$1300(this.this$0).updateTVNormList(nArray);
    }

    @Override
    public void updateBrowserListSort(int n) {
        TVSettings.access$1200(this.this$0).update(n);
    }

    /* synthetic */ TVSettings$TVListenerExt(TVSettings tVSettings, TVSettings$1 tVSettings$1) {
        this(tVSettings);
    }
}

