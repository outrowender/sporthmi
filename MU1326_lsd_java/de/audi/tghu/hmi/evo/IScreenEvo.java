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
    public IPresetPopupData getPresetPopupData();

    public void predisconnecting();

    public int[] getHmiAppsToNotifyForVisibility();

    public void setPopupKeyConsuptionStrategy(IPopupKeyConsuptionStrategy var1);

    public void updateDrawers(IScreenData var1);
}

