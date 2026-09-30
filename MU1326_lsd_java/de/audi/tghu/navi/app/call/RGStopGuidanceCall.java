/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.NavSimpleCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public class RGStopGuidanceCall
extends NavSimpleCall {
    private final DSINavigationManager dsiNavigationManager;
    private final NavigationEnv env;

    public RGStopGuidanceCall(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager) {
        super(navigationEnv.getCommandLogChannel());
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
    }

    public void execute() {
        if (this.env.getContainer().isRgActive()) {
            this.logger.log(10000000, "RGStopGuidanceCall#execute() - calling rgStopGuidance()");
            this.dsiNavigationManager.getDSINavigation(0).rgStopGuidance();
        } else {
            this.logger.log(10000000, "RGStopGuidanceCall#execute() - guidance is not active!");
        }
    }
}

