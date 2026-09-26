/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker;

class ExlapSoundVolumeRangesWorker$1
extends ExlapSoundEmptyListener {
    private final /* synthetic */ ExlapSoundVolumeRangesWorker this$0;

    ExlapSoundVolumeRangesWorker$1(ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker) {
        this.this$0 = exlapSoundVolumeRangesWorker;
    }

    @Override
    public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
        ExlapSoundVolumeRangesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSoundEmptyListener#updateSoundVolumeRanges] received new container: %1", (Object)soundVolumeRangesContainer);
        ExlapSoundVolumeRangesWorker.access$102(this.this$0, soundVolumeRangesContainer);
        if (ExlapSoundVolumeRangesWorker.access$200(this.this$0) != -1) {
            ExlapSoundVolumeRangesWorker.access$300(this.this$0);
        }
    }
}

