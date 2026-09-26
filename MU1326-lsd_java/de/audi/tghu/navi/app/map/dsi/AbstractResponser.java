/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;
import org.dsi.ifc.base.DSIListener;

public abstract class AbstractResponser
implements DSIListener {
    protected AbstractMap naviMap = null;
    private LogChannel logChannel = null;

    public AbstractResponser(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    protected void cleanup() {
    }

    protected LogChannel getLogger() {
        return this.logChannel;
    }

    protected abstract String getName() {
    }

    public void bind(AbstractMap abstractMap) {
        this.naviMap = abstractMap;
    }

    protected AbstractMap getMap() {
        if (this.naviMap == null) {
            this.getLogger().log(10000, "AbstractResponser#getMap() - map was NOT bound.");
        }
        return this.naviMap;
    }

    protected IContext getActiveContext() {
        return this.getMap().getActiveContext();
    }

    public abstract void resetMemberVariables() {
    }
}

