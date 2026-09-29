/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IEventListenerEvo;
import de.audi.tghu.hmi.evo.IPresetPopupData;

public interface IScreenEvo
extends Screen,
IEventListenerEvo {
    default public IPresetPopupData getPresetPopupData() {
    }

    default public void predisconnecting() {
    }

    default public int[] getHmiAppsToNotifyForVisibility() {
    }

    default public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
    }

    default public void updateDrawers(IScreenData iScreenData) {
    }
}

