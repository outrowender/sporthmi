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
    public void increaseVolume(int var1);

    public void decreaseVolume(int var1);

    public void muteEntertainment(int var1);

    public void unmuteEntertainment(int var1);

    public void setBalanceFader(int var1, BalanceFaderContainer var2);
}

