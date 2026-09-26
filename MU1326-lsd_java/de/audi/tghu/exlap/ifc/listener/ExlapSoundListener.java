/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;

public interface ExlapSoundListener
extends ExlapListener {
    default public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
    }

    default public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
    }

    default public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
    }

    default public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
    }

    default public void updateEntertainmentContext(EntertainmentContextContainer entertainmentContextContainer) {
    }
}

