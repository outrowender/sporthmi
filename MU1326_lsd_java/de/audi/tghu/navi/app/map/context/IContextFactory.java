/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IContext;

public interface IContextFactory {
    default public IContext createContext(int n, AbstractMap abstractMap, IconHandler iconHandler) {
    }

    default public IContext createNullContext(LogChannel logChannel) {
    }
}

