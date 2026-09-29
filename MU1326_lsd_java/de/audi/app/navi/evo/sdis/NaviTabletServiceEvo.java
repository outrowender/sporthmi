/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sdis;

import de.audi.app.navi.evo.sdis.NaviTabletServiceEvo$SdisPartialPopupListener;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sdis.NaviSDISStartGuidanceHandler;
import de.audi.tghu.navi.app.sdis.NaviTabletService;

public class NaviTabletServiceEvo
extends NaviTabletService {
    private NaviTabletServiceEvo$SdisPartialPopupListener sdisPartialPopupListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public NaviTabletServiceEvo(LogChannel logChannel, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler) {
        super(logChannel, iRouteManager, iCommandListFactory, navigationEnv, naviSDISStartGuidanceHandler);
    }

    @Override
    public void registerService(AbstractActivator abstractActivator) {
        this.sdisPartialPopupListener = new NaviTabletServiceEvo$SdisPartialPopupListener(this, this.startGuidanceHandler, this.env.getChoiceModel(237110784));
        abstractActivator.registerService((class$de$audi$atip$hmi$view$IPartialPopupListener == null ? (class$de$audi$atip$hmi$view$IPartialPopupListener = NaviTabletServiceEvo.class$("de.audi.atip.hmi.view.IPartialPopupListener")) : class$de$audi$atip$hmi$view$IPartialPopupListener).getName(), (Object)this.sdisPartialPopupListener, null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(NaviTabletServiceEvo naviTabletServiceEvo) {
        return naviTabletServiceEvo.logger;
    }
}

