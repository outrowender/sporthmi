/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;

public abstract class AbstractNavCommand
extends Command {
    protected Navigation navigation = null;
    protected DSIResponseContainer dsiResponseContainer = null;
    protected NavigationEnv env = null;
    protected DSINavigationManager dsiNavigationManager;

    public AbstractNavCommand() {
        this((String)null);
    }

    public AbstractNavCommand(String string) {
        super(null, string);
    }

    protected void init(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, Navigation navigation) {
        this.logger = navigationEnv.getCommandLogChannel();
        this.env = navigationEnv;
        this.navigation = navigation;
        this.dsiNavigationManager = dSINavigationManager;
        this.dsiResponseContainer = navigationEnv.getContainer();
    }

    protected DSINavigation getDSINavigation(int n) {
        return this.dsiNavigationManager.getDSINavigation(n);
    }

    protected DSIBlocking getDSIBlocking(int n) {
        return this.dsiNavigationManager.getDSIBlocking(n);
    }

    protected DSICombinedRouteList getDSICombinedRouteList(int n) {
        return this.dsiNavigationManager.getDSICombinedRouteList(n);
    }
}

