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

    public void leavePoiScreens() {
        this.env.getLogChannel().log(10000000, "PoiInputModelAccess#leavePoiScreens() - toggle mediator: %1", 400602L);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400602);
        if (choiceModelApp != null) {
            int n = choiceModelApp.getValue();
            int n2 = n == 0 ? 1 : 0;
            choiceModelApp.setValue(n2);
        }
    }
}

