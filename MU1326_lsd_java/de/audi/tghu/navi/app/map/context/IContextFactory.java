/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;

public interface IContextFactory {
    public IContext createContext(int var1, AbstractMap var2, IconHandler var3);

    public IContext createNullContext(LogChannel var1);
}

