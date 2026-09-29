/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.listener;

import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;

public class ExlapSoundEmptyListener
implements ExlapSoundListener {
    @Override
    public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
    }

    @Override
    public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
    }

    @Override
    public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
    }

    @Override
    public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
    }

    @Override
    public void updateEntertainmentContext(EntertainmentContextContainer entertainmentContextContainer) {
    }
}

