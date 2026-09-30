/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.views;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.IAsiaMapContentView;

public class AsiaMapContentView
implements IAsiaMapContentView {
    private final NavigationEnv env;

    public AsiaMapContentView(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public ButtonModelApp getRemoveAllPOI() {
        return this.env.getButtonModel(401912);
    }

    public ChoiceModelApp getTrafficFlow() {
        return this.env.getChoiceModel(401834);
    }

    public ChoiceModelApp getTrafficEventIcons() {
        return this.env.getChoiceModel(401831);
    }

    public ChoiceModelApp getTrafficEventNotice() {
        return this.env.getChoiceModel(401832);
    }

    public ChoiceModelApp getUncrowdedRoad() {
        return this.env.getChoiceModel(401833);
    }

    public ChoiceModelApp getFavorites() {
        return this.env.getChoiceModel(401836);
    }

    public ChoiceModelApp getWeatherIcons() {
        return this.env.getChoiceModel(402154);
    }
}

