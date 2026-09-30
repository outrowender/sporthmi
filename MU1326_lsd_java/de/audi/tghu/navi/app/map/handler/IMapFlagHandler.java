/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;

public interface IMapFlagHandler {
    public static final int PERSONAL_DEST_INDEX_UNDEFINED = -1;
    public static final int PERSONAL_DEST_INDEX_FOR_REMOVE = 0;
    public static final int PERSONAL_DEST_INDEX_FOR_REPLACE = 1;
    public static final int PERSONAL_DEST_INDEX_FOR_ADD = 2;
    public static final int PERSONAL_DEST_INDEX_MAX = 3;

    public void refresh(boolean var1);

    public void refresh(boolean var1, boolean var2);

    public void setTemporaryPins(MapPin[] var1);

    public void addTemporaryPins(MapPin[] var1);

    public void removeTemporaryPins(MapPin[] var1);

    public void cleanPins(MapPin[] var1);

    public void setPins(MapPin[] var1);

    public void cleanAllPins();

    public MapPin[] getPins();

    public MapPin getPin(long var1);

    public boolean configureFlags(long[] var1);

    public void onChangedRenderer(int var1);

    public static interface IMapFlagHandlerEnv {
        public LogChannel getLogger();

        public NavLocation getHome();

        public NavLocation getOffice();

        public AdbEntry[] getTops();

        public MapPin[] getContextDependedPins();

        public boolean isFavoriteVisible(int var1);

        public IFavorite[] getFavorites();

        public MapDataContainer getMapDataContainer();

        public void configureFlags(int var1, MapFlag[] var2);
    }
}

