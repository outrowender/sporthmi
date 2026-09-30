/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui.views;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.gui.IAsiaMapContentView;

public class AsiaMapContentViewCluster
implements IAsiaMapContentView {
    private final NavigationEnv env;

    public AsiaMapContentViewCluster(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public ButtonModelApp getRemoveAllPOI() {
        return this.env.getButtonModel(402144);
    }

    public ChoiceModelApp getTrafficFlow() {
        return this.env.getChoiceModel(402138);
    }

    public ChoiceModelApp getTrafficEventIcons() {
        return this.env.getChoiceModel(402137);
    }

    public ChoiceModelApp getTrafficEventNotice() {
        return this.env.getChoiceModel(402140);
    }

    public ChoiceModelApp getUncrowdedRoad() {
        return this.env.getChoiceModel(402143);
    }

    public ChoiceModelApp getFavorites() {
        return this.env.getChoiceModel(402142);
    }

    public ChoiceModelApp getWeatherIcons() {
        return this.env.getChoiceModel(402155);
    }
}

