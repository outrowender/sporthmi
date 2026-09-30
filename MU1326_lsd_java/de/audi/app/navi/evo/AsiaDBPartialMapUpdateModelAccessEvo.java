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

    public void onUpdateMapIntegrationState(int n) {
        if (2 == n) {
            this.env.getLogChannel().log(10000000, "AsiaDBPartialMapUpdateModelAccessEvo#onUpdateMapIntegrationState State is MAPINTEGRATIONSTATE_FINISHED = 2, show popup.");
            this.env.getHMIService().showPopup(400015);
        }
    }

    public void setCurrentDatabaseVersionLabel(String string) {
        this.env.getLabelModel(401715).setText(string);
    }
}

