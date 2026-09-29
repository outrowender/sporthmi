/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService;

class ExlapAbstractSoundService$1
implements ListenerIterator {
    private final /* synthetic */ SoundVolumeContainer val$soundVolumeProperty;
    private final /* synthetic */ ExlapAbstractSoundService this$0;

    ExlapAbstractSoundService$1(ExlapAbstractSoundService exlapAbstractSoundService, SoundVolumeContainer soundVolumeContainer) {
        this.this$0 = exlapAbstractSoundService;
        this.val$soundVolumeProperty = soundVolumeContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapSoundListener)exlapListener).updateSoundVolume(this.val$soundVolumeProperty);
    }
}

