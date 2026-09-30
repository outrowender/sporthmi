/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.ifc.service.ExlapSoundService;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeContainer;
import de.audi.tghu.exlap.impl.container.SoundVolumeRangesContainer;

public abstract class ExlapAbstractSoundService
extends ExlapAbstractService
implements ExlapSoundService,
ExlapSoundListener {
    public void updateSoundVolume(final SoundVolumeContainer soundVolumeContainer) {
        this.iterateListener(25, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSoundListener)exlapListener).updateSoundVolume(soundVolumeContainer);
            }
        });
    }

    public void updateSoundVolumeRanges(final SoundVolumeRangesContainer soundVolumeRangesContainer) {
        this.iterateListener(26, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSoundListener)exlapListener).updateSoundVolumeRanges(soundVolumeRangesContainer);
            }
        });
    }

    public void updateBalanceFader(final BalanceFaderContainer balanceFaderContainer) {
        this.iterateListener(45, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSoundListener)exlapListener).updateBalanceFader(balanceFaderContainer);
            }
        });
    }

    public void updateBalanceFaderRanges(final BalanceFaderRangesContainer balanceFaderRangesContainer) {
        this.iterateListener(46, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSoundListener)exlapListener).updateBalanceFaderRanges(balanceFaderRangesContainer);
            }
        });
    }

    public void updateEntertainmentContext(final EntertainmentContextContainer entertainmentContextContainer) {
        this.iterateListener(58, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapSoundListener)exlapListener).updateEntertainmentContext(entertainmentContextContainer);
            }
        });
    }
}

