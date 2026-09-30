/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.DefaultTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterCNTWEnglish;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterCNTWNative;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterJPEnglish;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterJPNative;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterKREnglish;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterKRNative;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterNAR;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TooltipFormatter
implements ITooltipFormatter {
    private final NavigationEnv navigationEnv;
    private final AbstractMap map;
    private final ITooltipFormatter.TooltipFormatterEnvironment env;
    private boolean isNativeAsianLanguage;
    private ITooltipFormatter tooltipFormatter;

    public TooltipFormatter(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.navigationEnv = navigationEnv;
        this.map = abstractMap;
        this.env = new TooltipFormatterEnvironmentImpl();
        this.isNativeAsianLanguage = this.isNativeAsianLanguage();
        this.tooltipFormatter = this.createTooltipFormatter();
    }

    private ITooltipFormatter getInstance() {
        boolean bl = this.isNativeAsianLanguage();
        if (this.isNativeAsianLanguage != bl) {
            this.isNativeAsianLanguage = bl;
            this.tooltipFormatter = this.createTooltipFormatter();
        }
        return this.tooltipFormatter;
    }

    private boolean isNativeAsianLanguage() {
        int n = this.navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        switch (n) {
            case 12: 
            case 14: 
            case 16: 
            case 24: {
                return true;
            }
        }
        return false;
    }

    private ITooltipFormatter createTooltipFormatter() {
        AbstractTooltipFormatter abstractTooltipFormatter;
        switch (Util.region) {
            case 2: {
                if (this.isNativeAsianLanguage) {
                    abstractTooltipFormatter = new TooltipFormatterCNTWNative(this.env);
                    break;
                }
                abstractTooltipFormatter = new TooltipFormatterCNTWEnglish(this.env);
                break;
            }
            case 5: {
                if (this.isNativeAsianLanguage) {
                    abstractTooltipFormatter = new TooltipFormatterCNTWNative(this.env);
                    break;
                }
                abstractTooltipFormatter = new TooltipFormatterCNTWEnglish(this.env);
                break;
            }
            case 3: {
                if (this.isNativeAsianLanguage) {
                    abstractTooltipFormatter = new TooltipFormatterJPNative(this.env);
                    break;
                }
                abstractTooltipFormatter = new TooltipFormatterJPEnglish(this.env);
                break;
            }
            case 4: {
                if (this.isNativeAsianLanguage) {
                    abstractTooltipFormatter = new TooltipFormatterKRNative(this.env);
                    break;
                }
                abstractTooltipFormatter = new TooltipFormatterKREnglish(this.env);
                break;
            }
            case 1: {
                abstractTooltipFormatter = new TooltipFormatterNAR(this.env);
                break;
            }
            default: {
                abstractTooltipFormatter = new DefaultTooltipFormatter(this.env);
            }
        }
        return abstractTooltipFormatter;
    }

    public String formatPOI(NavLocation navLocation) {
        return this.getInstance().formatPOI(navLocation);
    }

    public String formatPOIStack(NavLocation navLocation, int n) {
        return this.getInstance().formatPOIStack(navLocation, n);
    }

    public String formatPOI3D(NavLocation navLocation) {
        return this.getInstance().formatPOI3D(navLocation);
    }

    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        return this.getInstance().formatOnlinePOI(poiOnlineSearchValuelistElement, navLocation);
    }

    public String formatPicNavLocation(NavLocation navLocation) {
        return this.getInstance().formatPicNavLocation(navLocation);
    }

    public String formatFavorite(IFavorite iFavorite) {
        return this.getInstance().formatFavorite(iFavorite);
    }

    public String formatAdbEntry(AdbEntry adbEntry, int n) {
        return this.getInstance().formatAdbEntry(adbEntry, n);
    }

    public String formatLocation(NavLocation navLocation) {
        return this.getInstance().formatLocation(navLocation);
    }

    public String formatHomeLocation(NavLocation navLocation) {
        return this.getInstance().formatHomeLocation(navLocation);
    }

    public String formatBuilding(NavLocation navLocation) {
        return this.getInstance().formatBuilding(navLocation);
    }

    public String formatTMC(TmcMessage tmcMessage) {
        return this.getInstance().formatTMC(tmcMessage);
    }

    public String formatTMC(TmcListElement tmcListElement) {
        return this.getInstance().formatTMC(tmcListElement);
    }

    public String formatFallback(NavLocation navLocation) {
        return this.getInstance().formatFallback(navLocation);
    }

    private class TooltipFormatterEnvironmentImpl
    implements ITooltipFormatter.TooltipFormatterEnvironment {
        private TooltipFormatterEnvironmentImpl() {
        }

        public LogChannel getLogChannel() {
            return TooltipFormatter.this.navigationEnv.getMapMainLogChannel();
        }

        public NavLocation getNavLocation(byte[] byArray) {
            return ((TooltipFormatter)TooltipFormatter.this).map.locationSerializer.streamToLocation(byArray);
        }

        public boolean hasIcon(NavLocation navLocation) {
            return LocationFormatter.getIconResourceID(TooltipFormatter.this.map.getIconHandler(), navLocation) != -1;
        }

        public float getZoomLevel() {
            return TooltipFormatter.this.map.getZoomHandler().getZoom();
        }
    }
}

