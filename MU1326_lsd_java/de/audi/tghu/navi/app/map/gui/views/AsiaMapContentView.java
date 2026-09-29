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

    @Override
    public ButtonModelApp getRemoveAllPOI() {
        return this.env.getButtonModel(-132053504);
    }

    @Override
    public ChoiceModelApp getTrafficFlow() {
        return this.env.getChoiceModel(-1440676352);
    }

    @Override
    public ChoiceModelApp getTrafficEventIcons() {
        return this.env.getChoiceModel(-1491008000);
    }

    @Override
    public ChoiceModelApp getTrafficEventNotice() {
        return this.env.getChoiceModel(-1474230784);
    }

    @Override
    public ChoiceModelApp getUncrowdedRoad() {
        return this.env.getChoiceModel(-1457453568);
    }

    @Override
    public ChoiceModelApp getFavorites() {
        return this.env.getChoiceModel(-1407121920);
    }

    @Override
    public ChoiceModelApp getWeatherIcons() {
        return this.env.getChoiceModel(-366868992);
    }
}

