/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.favorite.IFavorite;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public interface ITooltipFormatter {
    public String formatPOI(NavLocation var1);

    public String formatPOIStack(NavLocation var1, int var2);

    public String formatPOI3D(NavLocation var1);

    public String formatOnlinePOI(PoiOnlineSearchValuelistElement var1, NavLocation var2);

    public String formatPicNavLocation(NavLocation var1);

    public String formatFavorite(IFavorite var1);

    public String formatAdbEntry(AdbEntry var1, int var2);

    public String formatLocation(NavLocation var1);

    public String formatHomeLocation(NavLocation var1);

    public String formatBuilding(NavLocation var1);

    public String formatTMC(TmcMessage var1);

    public String formatTMC(TmcListElement var1);

    public String formatFallback(NavLocation var1);

    public static interface TooltipFormatterEnvironment {
        public LogChannel getLogChannel();

        public NavLocation getNavLocation(byte[] var1);

        public boolean hasIcon(NavLocation var1);

        public float getZoomLevel();
    }
}

