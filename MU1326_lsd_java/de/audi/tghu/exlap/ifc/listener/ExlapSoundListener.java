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
    public void updateSoundVolume(SoundVolumeContainer var1);

    public void updateSoundVolumeRanges(SoundVolumeRangesContainer var1);

    public void updateBalanceFader(BalanceFaderContainer var1);

    public void updateBalanceFaderRanges(BalanceFaderRangesContainer var1);

    public void updateEntertainmentContext(EntertainmentContextContainer var1);
}

