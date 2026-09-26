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

    @Override
    public ButtonModelApp getRemoveAllPOI() {
        return this.env.getButtonModel(-534641152);
    }

    @Override
    public ChoiceModelApp getTrafficFlow() {
        return this.env.getChoiceModel(-635304448);
    }

    @Override
    public ChoiceModelApp getTrafficEventIcons() {
        return this.env.getChoiceModel(-652081664);
    }

    @Override
    public ChoiceModelApp getTrafficEventNotice() {
        return this.env.getChoiceModel(-601750016);
    }

    @Override
    public ChoiceModelApp getUncrowdedRoad() {
        return this.env.getChoiceModel(-551418368);
    }

    @Override
    public ChoiceModelApp getFavorites() {
        return this.env.getChoiceModel(-568195584);
    }

    @Override
    public ChoiceModelApp getWeatherIcons() {
        return this.env.getChoiceModel(-350091776);
    }
}

