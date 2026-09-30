/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sdis;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.sdis.NaviSDISStartGuidanceHandler;
import de.audi.tghu.navi.app.sdis.NaviTabletService;

public class NaviTabletServiceEvo
extends NaviTabletService {
    private SdisPartialPopupListener sdisPartialPopupListener;
    static /* synthetic */ Class class$de$audi$atip$hmi$view$IPartialPopupListener;

    public NaviTabletServiceEvo(LogChannel logChannel, IRouteManager iRouteManager, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler) {
        super(logChannel, iRouteManager, iCommandListFactory, navigationEnv, naviSDISStartGuidanceHandler);
    }

    public void registerService(AbstractActivator abstractActivator) {
        this.sdisPartialPopupListener = new SdisPartialPopupListener(this.startGuidanceHandler, this.env.getChoiceModel(401934));
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

    private class SdisPartialPopupListener
    implements IPartialPopupListener {
        private final int[] registeredPopups = new int[]{179};
        private final NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler;
        private final ChoiceModelApp naviSdisPopupChoice;

        public SdisPartialPopupListener(NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler, ChoiceModelApp choiceModelApp) {
            this.naviSDISStartGuidanceHandler = naviSDISStartGuidanceHandler;
            this.naviSdisPopupChoice = choiceModelApp;
        }

        public void partialPopupVisible(int n, int n2) {
        }

        public void partialPopupHidden(int n, int n2) {
        }

        public void partialPopupRemoved(int n, int n2) {
            if (n != 179) {
                return;
            }
            NaviTabletServiceEvo.this.logger.log(10000000, "NaviTabletServiceEvo.SdisPartialPopupListener#partialPopupRemoved");
            this.naviSdisPopupChoice.setValue(0);
            this.naviSDISStartGuidanceHandler.decline();
        }

        public int[] getPPIDsForCallbacks() {
            return this.registeredPopups;
        }

        public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
        }

        public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
        }
    }
}

