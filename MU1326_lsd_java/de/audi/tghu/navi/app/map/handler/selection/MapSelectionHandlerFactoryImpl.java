/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerImpl;
import de.audi.tghu.navi.app.map.impl.PosInfoParser;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public class MapSelectionHandlerFactoryImpl
implements MapSelectionHandlerFactory {
    private NavigationEnv env;

    public MapSelectionHandlerFactoryImpl(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    protected PosInfoParser.PosInfoParserEnv createPosInfoParserEnv(final AbstractMap abstractMap, final INaviInterface iNaviInterface) {
        return new PosInfoParser.PosInfoParserEnv(){

            public NavigationEnv getNaviEnv() {
                return MapSelectionHandlerFactoryImpl.this.env;
            }

            public boolean is3DLandmarksEnabled() {
                return abstractMap.getSetup().get3DLandmarks(0);
            }

            public MapPin getMapPin(long l) {
                return abstractMap.getMapFlagHandler().getPin(l);
            }

            public OnlinePOIResultList getContextDependedOnlineResult() {
                return abstractMap.getActiveContext().getOnlinePOIResultList();
            }

            public IFavorite getFavorite(int n) {
                IFavorite[] iFavoriteArray = abstractMap.getNaviInterface().getFavorites();
                if (iFavoriteArray != null) {
                    for (int i2 = 0; i2 < iFavoriteArray.length; ++i2) {
                        if (iFavoriteArray[i2] == null || iFavoriteArray[i2].getUniqueID() != (long)n) continue;
                        return iFavoriteArray[i2];
                    }
                }
                return null;
            }

            public NavLocation getHomeAddress() {
                return iNaviInterface.getHomeAddressHandler().getCurrentHomeAddress();
            }

            public ITooltipFormatter getTooltipFormatter() {
                return abstractMap.getTooltipFormatter();
            }

            public AdbEntry getAdbEntry(int n) {
                return abstractMap.getMapDataContainer().sTopDestinations[n];
            }

            public NavLocation getOfficeAddress() {
                return abstractMap.getMapDataContainer().sOfficeAddress;
            }
        };
    }

    public MapSelectionHandler createSelectionHandler(AbstractMap abstractMap, INaviInterface iNaviInterface) {
        return new MapSelectionHandlerImpl(abstractMap, this.createPosInfoParserEnv(abstractMap, iNaviInterface));
    }
}

