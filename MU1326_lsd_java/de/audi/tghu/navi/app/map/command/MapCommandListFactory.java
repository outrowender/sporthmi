/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.command.MapCommandList;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;

public class MapCommandListFactory
implements ICommandListFactory {
    private final CommandListManager commandListManager;
    private final MapResponseDispatcher mapResponseDispatcher;
    private final NavigationEnv env;
    private final AbstractMap naviMap;

    public MapCommandListFactory(CommandListManager commandListManager, MapResponseDispatcher mapResponseDispatcher, NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.commandListManager = commandListManager;
        this.mapResponseDispatcher = mapResponseDispatcher;
        this.env = navigationEnv;
        this.naviMap = abstractMap;
    }

    public CommandList createCommandList() {
        return new MapCommandList(this.commandListManager, this.mapResponseDispatcher, this.env, this.naviMap);
    }

    public CommandList createCommandList(int n) {
        return new MapCommandList(this.commandListManager, this.mapResponseDispatcher, this.env, this.naviMap, n);
    }
}

