/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.call;

import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.call.NavCall;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public class ClearNotificationCall
extends NavCall {
    public static final int CLEAR_NOTIFICATION_NAVIGATION;
    public static final int CLEAR_NOTIFICATION_BLOCKING;
    public static final int CLEAR_NOTIFICATION_COMBINEDROUTELIST;
    private int whichDSI;

    public ClearNotificationCall(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, Navigation navigation, int n, int n2) {
        super(navigationEnv, dSINavigationManager, navigation);
        this.dsiType = n;
        this.whichDSI = n2;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "ClearNotificationCall#execute() - calling clearNotification() on dsiType: %1", (Object)DSINavigationManager.dsiTypeToString(this.dsiType));
        try {
            switch (this.whichDSI) {
                case 0: {
                    if (this.getDSINavigation(this.dsiType) != null) {
                        this.getDSINavigation(this.dsiType).clearNotification(this.navigation.getDsiNavigationManager().getDispatcher(this.dsiType));
                    }
                    break;
                }
                case 1: {
                    if (this.getDSIBlocking(this.dsiType) != null) {
                        this.getDSIBlocking(this.dsiType).clearNotification(this.navigation.getDsiNavigationManager().getDispatcher(this.dsiType));
                    }
                    break;
                }
                case 2: {
                    if (this.getDSICombinedRouteList(this.dsiType) != null) {
                        this.getDSICombinedRouteList(this.dsiType).clearNotification(this.navigation.getDsiNavigationManager().getDispatcher(this.dsiType));
                    }
                    break;
                }
                default: {
                    this.logger.log(10000, "ClearNotificationCall#execute() - unknown DSI %1 !", (long)this.whichDSI);
                    break;
                }
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "ClearNotificationCall#execute() - whichDSI: %3, dsiType: %1, ERROR=%2", (Object)DSINavigationManager.dsiTypeToString(this.dsiType), (Object)exception, (long)this.whichDSI);
        }
    }
}

