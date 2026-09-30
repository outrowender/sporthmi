/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapSoundVolumeRangesWorker
extends ExlapAbstractWorker {
    private static final int SOUND_VOLUME_RANGES_PROPERTY = 26;

    public ExlapSoundVolumeRangesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapSoundVolumeRangesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(26, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSoundEmptyListener(){

            public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
                ExlapSoundVolumeRangesWorker.this.log.log(10000000, "[new ExlapSoundEmptyListener#updateSoundVolumeRanges] received new container: %1", (Object)soundVolumeRangesContainer);
                ExlapSoundVolumeRangesWorker.this.container = soundVolumeRangesContainer;
                if (ExlapSoundVolumeRangesWorker.this.interval != -1) {
                    ExlapSoundVolumeRangesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{26};
    }
}

