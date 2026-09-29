/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler$IMapFlagHandlerEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;

class AbstractMap$1
implements IMapFlagHandler$IMapFlagHandlerEnv {
    private final /* synthetic */ AbstractMap this$0;

    AbstractMap$1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
    }

    @Override
    public AdbEntry[] getTops() {
        return this.this$0.mapDataContainer.sTopDestinations;
    }

    @Override
    public NavLocation getHome() {
        return this.this$0.mapDataContainer.sHomeAddress;
    }

    @Override
    public NavLocation getOffice() {
        return this.this$0.mapDataContainer.sOfficeAddress;
    }

    @Override
    public MapPin[] getContextDependedPins() {
        return this.this$0.getActiveContext().getDynamicPins();
    }

    @Override
    public boolean isFavoriteVisible(int n) {
        return this.this$0.getSetup().isFavoriteVisible(n);
    }

    @Override
    public IFavorite[] getFavorites() {
        return this.this$0.naviInterface.getFavorites();
    }

    @Override
    public MapDataContainer getMapDataContainer() {
        return this.this$0.mapDataContainer;
    }

    @Override
    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.this$0.getMVRequest().configureFlags(n, mapFlagArray);
    }

    @Override
    public LogChannel getLogger() {
        return this.this$0.getMapLogChannel();
    }
}

