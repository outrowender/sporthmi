/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio.list;

import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;

public abstract class AbstractSourceListObserver {
    private volatile CombiBAPAudioSource sourceToWaitFor;

    public void setSourceToWaitFor(CombiBAPAudioSource combiBAPAudioSource) {
        this.sourceToWaitFor = combiBAPAudioSource;
    }

    public CombiBAPAudioSource getSourceToWaitFor() {
        return this.sourceToWaitFor;
    }

    public abstract void notifySourceAdded(CombiBAPAudioSource var1);
}

