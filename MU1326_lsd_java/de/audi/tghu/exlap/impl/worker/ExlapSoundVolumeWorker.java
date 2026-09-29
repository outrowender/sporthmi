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
import de.audi.tghu.exlap.impl.worker.ExlapSoundVolumeWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSoundVolumeWorker
extends ExlapAbstractWorker {
    private static final int SOUND_VOLUME_PROPERTY;

    public ExlapSoundVolumeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapSoundVolumeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(25, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapSoundVolumeWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{25};
    }

    static /* synthetic */ LogChannel access$000(ExlapSoundVolumeWorker exlapSoundVolumeWorker) {
        return exlapSoundVolumeWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapSoundVolumeWorker exlapSoundVolumeWorker, Container container) {
        exlapSoundVolumeWorker.container = container;
        return exlapSoundVolumeWorker.container;
    }

    static /* synthetic */ int access$200(ExlapSoundVolumeWorker exlapSoundVolumeWorker) {
        return exlapSoundVolumeWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapSoundVolumeWorker exlapSoundVolumeWorker) {
        exlapSoundVolumeWorker.trigger();
    }
}

