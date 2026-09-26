/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeRangesWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSoundVolumeRangesWorker
extends ExlapAbstractWorker {
    private static final int SOUND_VOLUME_RANGES_PROPERTY;

    public ExlapSoundVolumeRangesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapSoundVolumeRangesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(26, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapSoundVolumeRangesWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{26};
    }

    static /* synthetic */ LogChannel access$000(ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker) {
        return exlapSoundVolumeRangesWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker, Container container) {
        exlapSoundVolumeRangesWorker.container = container;
        return exlapSoundVolumeRangesWorker.container;
    }

    static /* synthetic */ int access$200(ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker) {
        return exlapSoundVolumeRangesWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapSoundVolumeRangesWorker exlapSoundVolumeRangesWorker) {
        exlapSoundVolumeRangesWorker.trigger();
    }
}

