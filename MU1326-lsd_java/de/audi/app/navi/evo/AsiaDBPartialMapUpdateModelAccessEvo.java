/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.tghu.navi.app.AsiaDBPartialMapUpdateModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;

public class AsiaDBPartialMapUpdateModelAccessEvo
implements AsiaDBPartialMapUpdateModelAccess {
    private NavigationEnv env;

    public AsiaDBPartialMapUpdateModelAccessEvo(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    @Override
    public void onUpdateMapIntegrationState(int n) {
        if (2 == n) {
            this.env.getLogChannel().log(-2137614336, "AsiaDBPartialMapUpdateModelAccessEvo#onUpdateMapIntegrationState State is MAPINTEGRATIONSTATE_FINISHED = 2, show popup.");
            this.env.getHMIService().showPopup(-1894119936);
        }
    }

    @Override
    public void setCurrentDatabaseVersionLabel(String string) {
        this.env.getLabelModel(857802240).setText(string);
    }
}

