/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.presentationmode;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.presentationmode.IDemoModeModelAccess;

public class DemoModeModelAccess
implements IDemoModeModelAccess {
    private NavigationEnv env;
    private int demoModeChoiceModel;

    public DemoModeModelAccess(NavigationEnv navigationEnv, int n) {
        this.env = navigationEnv;
        this.demoModeChoiceModel = n;
    }

    public void updateDemoModeState(boolean bl) {
        if (bl) {
            this.env.getChoiceModel(this.demoModeChoiceModel).setValue(1);
        } else {
            this.env.getChoiceModel(this.demoModeChoiceModel).setValue(0);
        }
    }

    public void setDemoStatus(int n) {
        this.env.getChoiceModel(401077).setValue(n);
        this.env.getChoiceModel(this.demoModeChoiceModel).setStatus(n);
    }

    public boolean isDemoModeActive() {
        return this.env.getChoiceModel(this.demoModeChoiceModel).getStatus() == 1;
    }
}

