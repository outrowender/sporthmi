/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.ifc.service.ExlapSoundService;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService$1;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService$2;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService$3;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService$4;
import de.audi.tghu.exlap.impl.service.ExlapAbstractSoundService$5;

public abstract class ExlapAbstractSoundService
extends ExlapAbstractService
implements ExlapSoundService,
ExlapSoundListener {
    @Override
    public void updateSoundVolume(SoundVolumeContainer soundVolumeContainer) {
        this.iterateListener(25, new ExlapAbstractSoundService$1(this, soundVolumeContainer));
    }

    @Override
    public void updateSoundVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer) {
        this.iterateListener(26, new ExlapAbstractSoundService$2(this, soundVolumeRangesContainer));
    }

    @Override
    public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
        this.iterateListener(45, new ExlapAbstractSoundService$3(this, balanceFaderContainer));
    }

    @Override
    public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
        this.iterateListener(46, new ExlapAbstractSoundService$4(this, balanceFaderRangesContainer));
    }

    @Override
    public void updateEntertainmentContext(EntertainmentContextContainer entertainmentContextContainer) {
        this.iterateListener(58, new ExlapAbstractSoundService$5(this, entertainmentContextContainer));
    }
}

