/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommandList;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;

public class NavCommandListFactory
implements ICommandListFactory {
    private CommandListManager commandListManager;
    private DSINavigationManager dsiNavigationManager = null;
    private NavigationEnv env;
    private Navigation navigation;

    public NavCommandListFactory(CommandListManager commandListManager, NavigationEnv navigationEnv, Navigation navigation) {
        this.commandListManager = commandListManager;
        this.env = navigationEnv;
        this.navigation = navigation;
    }

    public CommandList createCommandList() {
        return new NavCommandList(this.commandListManager, this.dsiNavigationManager, this.env, this.navigation);
    }

    public CommandList createCommandList(int n) {
        return new NavCommandList(this.commandListManager, this.dsiNavigationManager, this.env, this.navigation, n);
    }

    public void cleanUp() {
        this.navigation = null;
        this.commandListManager = null;
        this.dsiNavigationManager = null;
        this.env = null;
    }

    public void setDsiNavigationManager(DSINavigationManager dSINavigationManager) {
        this.dsiNavigationManager = dSINavigationManager;
    }
}

