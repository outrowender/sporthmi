/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;

public class MapCommandList
extends CommandList {
    private final AbstractMap naviMap;
    private final NavigationEnv env;
    private MapResponseDispatcher mapResponseDispatcher;

    public MapCommandList(CommandListManager commandListManager, MapResponseDispatcher mapResponseDispatcher, NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(commandListManager);
        this.naviMap = abstractMap;
        this.env = navigationEnv;
        this.mapResponseDispatcher = mapResponseDispatcher;
    }

    public MapCommandList(CommandListManager commandListManager, MapResponseDispatcher mapResponseDispatcher, NavigationEnv navigationEnv, AbstractMap abstractMap, int n) {
        super(commandListManager, n);
        this.naviMap = abstractMap;
        this.env = navigationEnv;
        this.mapResponseDispatcher = mapResponseDispatcher;
    }

    public AbstractMap getMap() {
        return this.naviMap;
    }

    public NavigationEnv getEnv() {
        return this.env;
    }

    public MapResponseDispatcher getMapResponseDispatcher() {
        return this.mapResponseDispatcher;
    }
}

