/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sdis;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sdis.NaviSDISStartGuidanceHandler;
import de.audi.tghu.navi.app.setup.IRouteCriteriaManager;

public class NaviSDISStartGuidanceHandlerEvo
extends NaviSDISStartGuidanceHandler {
    public NaviSDISStartGuidanceHandlerEvo(LogChannel logChannel, NavigationEnv navigationEnv, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IRouteCriteriaManager iRouteCriteriaManager, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory) {
        super(logChannel, navigationEnv, iStartGuidanceToDestinationSequence, iRouteCriteriaManager, iRouteManager, iCommandListFactory);
    }

    @Override
    protected void showGuidanceRequestPopUp() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 179);
    }

    @Override
    protected void hideGuidanceRequestPopUp() {
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 179);
    }
}

