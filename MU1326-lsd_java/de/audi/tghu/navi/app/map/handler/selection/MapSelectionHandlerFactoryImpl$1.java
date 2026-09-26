/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactoryImpl;
import de.audi.tghu.navi.app.map.impl.PosInfoParser$PosInfoParserEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

class MapSelectionHandlerFactoryImpl$1
implements PosInfoParser$PosInfoParserEnv {
    private final /* synthetic */ AbstractMap val$map;
    private final /* synthetic */ INaviInterface val$naviInterface;
    private final /* synthetic */ MapSelectionHandlerFactoryImpl this$0;

    MapSelectionHandlerFactoryImpl$1(MapSelectionHandlerFactoryImpl mapSelectionHandlerFactoryImpl, AbstractMap abstractMap, INaviInterface iNaviInterface) {
        this.this$0 = mapSelectionHandlerFactoryImpl;
        this.val$map = abstractMap;
        this.val$naviInterface = iNaviInterface;
    }

    @Override
    public NavigationEnv getNaviEnv() {
        return MapSelectionHandlerFactoryImpl.access$000(this.this$0);
    }

    @Override
    public boolean is3DLandmarksEnabled() {
        return this.val$map.getSetup().get3DLandmarks(0);
    }

    @Override
    public MapPin getMapPin(long l) {
        return this.val$map.getMapFlagHandler().getPin(l);
    }

    @Override
    public OnlinePOIResultList getContextDependedOnlineResult() {
        return this.val$map.getActiveContext().getOnlinePOIResultList();
    }

    @Override
    public IFavorite getFavorite(int n) {
        IFavorite[] iFavoriteArray = this.val$map.getNaviInterface().getFavorites();
        if (iFavoriteArray != null) {
            for (int i2 = 0; i2 < iFavoriteArray.length; ++i2) {
                if (iFavoriteArray[i2] == null || iFavoriteArray[i2].getUniqueID() != (long)n) continue;
                return iFavoriteArray[i2];
            }
        }
        return null;
    }

    @Override
    public NavLocation getHomeAddress() {
        return this.val$naviInterface.getHomeAddressHandler().getCurrentHomeAddress();
    }

    @Override
    public ITooltipFormatter getTooltipFormatter() {
        return this.val$map.getTooltipFormatter();
    }

    @Override
    public AdbEntry getAdbEntry(int n) {
        return this.val$map.getMapDataContainer().sTopDestinations[n];
    }

    @Override
    public NavLocation getOfficeAddress() {
        return this.val$map.getMapDataContainer().sOfficeAddress;
    }
}

