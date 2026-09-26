/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.AbstractAppConnectorAudio;
import de.audi.app.combi.bap.app.audio.list.AbstractSourceListObserver;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;

class AbstractAppConnectorAudio$1
extends AbstractSourceListObserver {
    private final /* synthetic */ AbstractAppConnectorAudio this$0;

    AbstractAppConnectorAudio$1(AbstractAppConnectorAudio abstractAppConnectorAudio) {
        this.this$0 = abstractAppConnectorAudio;
    }

    @Override
    public void notifySourceAdded(CombiBAPAudioSource combiBAPAudioSource) {
        AbstractAppConnectorAudio.access$000(this.this$0).log(-2137614336, "[AbstractAppConnectorAudio#activateSource#notifySourceAdded] %1", (Object)combiBAPAudioSource);
        AbstractAppConnectorAudio.access$100(this.this$0).set(combiBAPAudioSource);
        AbstractAppConnectorAudio.access$202(this.this$0, combiBAPAudioSource.getPosID());
        AbstractAppConnectorAudio.access$300(this.this$0);
        AbstractAppConnectorAudio.access$400(this.this$0);
    }
}

