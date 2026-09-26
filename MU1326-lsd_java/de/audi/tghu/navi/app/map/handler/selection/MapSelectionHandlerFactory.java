/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;

public interface MapSelectionHandlerFactory {
    default public MapSelectionHandler createSelectionHandler(AbstractMap abstractMap, INaviInterface iNaviInterface) {
    }
}

