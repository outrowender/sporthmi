/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public class NavCommandList
extends CommandList {
    private final Navigation navigation;
    private final NavigationEnv env;
    private DSINavigationManager dsiNavigationManager;

    public NavCommandList(CommandListManager commandListManager, DSINavigationManager dSINavigationManager, NavigationEnv navigationEnv, Navigation navigation) {
        super(commandListManager);
        this.navigation = navigation;
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
    }

    public NavCommandList(CommandListManager commandListManager, DSINavigationManager dSINavigationManager, NavigationEnv navigationEnv, Navigation navigation, int n) {
        super(commandListManager, n);
        this.navigation = navigation;
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
    }

    public Navigation getNavigation() {
        return this.navigation;
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    public DSINavigationManager getDSINavigationManager() {
        return this.dsiNavigationManager;
    }
}

