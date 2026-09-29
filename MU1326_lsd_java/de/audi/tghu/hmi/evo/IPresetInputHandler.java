/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.KeyListener;
import de.audi.atip.hmi.event.TouchPadEventListener;

public interface IPresetInputHandler
extends TouchPadEventListener,
KeyListener {
    default public void presetPopupVisible(boolean bl) {
    }
}

