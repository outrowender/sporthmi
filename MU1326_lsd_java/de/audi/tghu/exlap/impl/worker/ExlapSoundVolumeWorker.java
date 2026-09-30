/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSoundVolumeWorker
extends ExlapAbstractWorker {
    private static final int SOUND_VOLUME_PROPERTY = 25;

    public ExlapSoundVolumeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapSoundVolumeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(25, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSoundEmptyListener(){

            public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
                ExlapSoundVolumeWorker.this.log.log(10000000, "[new ExlapSoundEmptyListener#updateSoundVolume] received new container: %1", (Object)soundVolumeContainer);
                ExlapSoundVolumeWorker.this.container = soundVolumeContainer;
                if (ExlapSoundVolumeWorker.this.interval != -1) {
                    ExlapSoundVolumeWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{25};
    }
}

