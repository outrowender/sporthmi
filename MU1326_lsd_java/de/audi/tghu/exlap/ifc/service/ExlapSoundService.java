/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.service;

import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ifc.listener.ExlapSoundListener;
import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;

public interface ExlapSoundService
extends ExlapService,
ExlapSoundListener {
    default public void increaseVolume(int n) {
    }

    default public void decreaseVolume(int n) {
    }

    default public void muteEntertainment(int n) {
    }

    default public void unmuteEntertainment(int n) {
    }

    default public void setBalanceFader(int n, BalanceFaderContainer balanceFaderContainer) {
    }
}

