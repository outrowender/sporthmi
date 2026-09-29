/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker;

class ExlapSoundVolumeWorker$1
extends ExlapSoundEmptyListener {
    private final /* synthetic */ ExlapSoundVolumeWorker this$0;

    ExlapSoundVolumeWorker$1(ExlapSoundVolumeWorker exlapSoundVolumeWorker) {
        this.this$0 = exlapSoundVolumeWorker;
    }

    @Override
    public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
        ExlapSoundVolumeWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSoundEmptyListener#updateSoundVolume] received new container: %1", (Object)soundVolumeContainer);
        ExlapSoundVolumeWorker.access$102(this.this$0, soundVolumeContainer);
        if (ExlapSoundVolumeWorker.access$200(this.this$0) != -1) {
            ExlapSoundVolumeWorker.access$300(this.this$0);
        }
    }
}

