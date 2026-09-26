/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.map.IView;

public interface IAsiaMapContentView
extends IView {
    default public ButtonModelApp getRemoveAllPOI() {
    }

    default public ChoiceModelApp getTrafficFlow() {
    }

    default public ChoiceModelApp getTrafficEventIcons() {
    }

    default public ChoiceModelApp getTrafficEventNotice() {
    }

    default public ChoiceModelApp getUncrowdedRoad() {
    }

    default public ChoiceModelApp getFavorites() {
    }

    default public ChoiceModelApp getWeatherIcons() {
    }
}

