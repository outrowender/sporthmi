/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.command;

import de.audi.tghu.command.Command;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.command.MapCommandList;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import de.audi.tghu.navi.app.map.utils.MapUtils;

public abstract class AbstractMapCommand
extends Command {
    protected NavigationEnv env = null;
    protected MapResponseDispatcher mapResponseDispatcher = null;
    protected AbstractMap naviMap = null;

    public AbstractMapCommand() {
        super(null);
    }

    public AbstractMapCommand(String string) {
        super(null, string);
    }

    public void setCommandList(ICommandList iCommandList) {
        super.setCommandList(iCommandList);
        if (!(iCommandList instanceof MapCommandList)) {
            throw new ClassCastException("Expected MapCommandList!");
        }
        MapCommandList mapCommandList = (MapCommandList)iCommandList;
        this.init(mapCommandList.getEnv(), mapCommandList.getMapResponseDispatcher(), mapCommandList.getMap());
    }

    protected void init(NavigationEnv navigationEnv, MapResponseDispatcher mapResponseDispatcher, AbstractMap abstractMap) {
        this.logger = MapUtils.getMapCommandLogChannel(navigationEnv, abstractMap.getMapConfig().getMapInstanceId());
        this.env = navigationEnv;
        this.mapResponseDispatcher = mapResponseDispatcher;
        this.naviMap = abstractMap;
    }

    protected MapResponseDispatcher getDispatcher() {
        return ((MapCommandList)this.getCommandList()).getMapResponseDispatcher();
    }

    protected MapCommandList getMapCommandList() {
        return (MapCommandList)this.getCommandList();
    }

    protected AbstractMap getMap() {
        return this.naviMap;
    }
}

