/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService;

class ExlapAbstractSoundService$2
implements ListenerIterator {
    private final /* synthetic */ SoundVolumeRangesContainer val$soundVolumeRangesProperty;
    private final /* synthetic */ ExlapAbstractSoundService this$0;

    ExlapAbstractSoundService$2(ExlapAbstractSoundService exlapAbstractSoundService, SoundVolumeRangesContainer soundVolumeRangesContainer) {
        this.this$0 = exlapAbstractSoundService;
        this.val$soundVolumeRangesProperty = soundVolumeRangesContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSoundListener)exlapListener).updateSoundVolumeRanges(this.val$soundVolumeRangesProperty);
    }
}

