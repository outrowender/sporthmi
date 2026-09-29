/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactoryImpl$1;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.map.impl.PosInfoParser$PosInfoParserEnv;

public class MapSelectionHandlerFactoryImpl
implements MapSelectionHandlerFactory {
    private NavigationEnv env;

    public MapSelectionHandlerFactoryImpl(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    protected PosInfoParser$PosInfoParserEnv createPosInfoParserEnv(AbstractMap abstractMap, INaviInterface iNaviInterface) {
        return new MapSelectionHandlerFactoryImpl$1(this, abstractMap, iNaviInterface);
    }

    @Override
    public MapSelectionHandler createSelectionHandler(AbstractMap abstractMap, INaviInterface iNaviInterface) {
        return new MapSelectionHandlerImpl(abstractMap, this.createPosInfoParserEnv(abstractMap, iNaviInterface));
    }

    static /* synthetic */ NavigationEnv access$000(MapSelectionHandlerFactoryImpl mapSelectionHandlerFactoryImpl) {
        return mapSelectionHandlerFactoryImpl.env;
    }
}

