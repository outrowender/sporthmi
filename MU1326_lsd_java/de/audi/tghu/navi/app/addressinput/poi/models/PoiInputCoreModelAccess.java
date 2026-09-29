/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiInputModelAccess;

public abstract class PoiInputCoreModelAccess
implements IPoiInputModelAccess {
    protected NavigationEnv env;

    public PoiInputCoreModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void leavePoiScreens() {
        this.env.getLogChannel().log(-2137614336, "PoiInputModelAccess#leavePoiScreens() - toggle mediator: %1", (long)0);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-635697664);
        if (choiceModelApp != null) {
            int n = choiceModelApp.getValue();
            int n2 = n == 0 ? 1 : 0;
            choiceModelApp.setValue(n2);
        }
    }
}

