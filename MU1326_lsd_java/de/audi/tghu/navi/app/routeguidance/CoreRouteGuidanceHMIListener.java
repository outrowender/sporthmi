/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;

public class CoreRouteGuidanceHMIListener
implements ButtonListener {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final IRouteManager routeManager;

    public CoreRouteGuidanceHMIListener(NavigationEnv navigationEnv, LogChannel logChannel, IRouteManager iRouteManager) {
        this.env = navigationEnv;
        this.logChannel = logChannel;
        this.routeManager = iRouteManager;
        this.initListeners();
    }

    public final void initListeners() {
        this.env.getButtonModel(400809).setButtonListener(this);
        this.env.getButtonModel(400808).setButtonListener(this);
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "[RouteGuidance] CoreRouteGuidanceHMIListener#keyTyped( %1 ) ", (long)n);
        if (n == 400809) {
            this.logChannel.log(10000000, "[RouteGuidance] CoreRouteGuidanceHMIListener#keyTyped( %1 ) - stop route guidance. ", (long)n);
            this.routeManager.stopRouteGuidance();
        } else if (n == 400808) {
            this.logChannel.log(10000000, "[RouteGuidance] CoreRouteGuidanceHMIListener#keyTyped( %1 ) - start route guidance. ", (long)n);
            this.routeManager.startGuidance();
        }
        this.logChannel.log(10000000, "[RouteGuidance] CoreRouteGuidanceHMIListener#keyTyped( %1 ) - fire event. ", (long)n);
        this.env.fireModelEvent(n, n3);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }
}

