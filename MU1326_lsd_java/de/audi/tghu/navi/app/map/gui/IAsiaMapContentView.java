/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.IView;

public interface IAsiaMapContentView
extends IView {
    public ButtonModelApp getRemoveAllPOI();

    public ChoiceModelApp getTrafficFlow();

    public ChoiceModelApp getTrafficEventIcons();

    public ChoiceModelApp getTrafficEventNotice();

    public ChoiceModelApp getUncrowdedRoad();

    public ChoiceModelApp getFavorites();

    public ChoiceModelApp getWeatherIcons();
}

