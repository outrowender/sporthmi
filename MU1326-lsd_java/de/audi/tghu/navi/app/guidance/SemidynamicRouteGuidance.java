/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.SemidynamicRouteGuidance$ModelAccess;
import de.audi.tghu.navi.app.guidance.SemidynamicRouteGuidance$ModelAccessImpl;
import java.util.Date;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;

public class SemidynamicRouteGuidance {
    public static final String NO_DURATION;
    public static final long TRAFFIC_OFFSET_THRESHOLD;
    private final LogChannel logChannel;
    private int huRegion;
    private final SemidynamicRouteGuidance$ModelAccess modelAccess;
    private final Object modelMonitor = new Object();

    public SemidynamicRouteGuidance(NavigationEnv navigationEnv) {
        this(navigationEnv, new SemidynamicRouteGuidance$ModelAccessImpl(navigationEnv));
    }

    public SemidynamicRouteGuidance(NavigationEnv navigationEnv, SemidynamicRouteGuidance$ModelAccess semidynamicRouteGuidance$ModelAccess) {
        this.modelAccess = semidynamicRouteGuidance$ModelAccess;
        this.logChannel = navigationEnv.getLogChannel();
    }

    public void setHURegion(int n) {
        this.huRegion = n;
    }

    public boolean isActive() {
        return this.huRegion == 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isDynamicBypassAvailable() {
        Object object = this.modelMonitor;
        synchronized (object) {
            return this.isActive() && this.modelAccess.isDynamicBypassAvailable();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        this.logChannel.log(1078071040, "SemidynamicRouteGuidance#updateRgRouteCostChangeInformation( %1 ) ", (Object)rgRouteCostChangeInformation);
        if (!this.isActive()) {
            this.logChannel.log(1078071040, "SemidynamicRouteGuidance#updateRgRouteCostChangeInformation - not active, ignoring update");
            return;
        }
        boolean bl = SemidynamicRouteGuidance.isDynamicBypassAvailable(rgRouteCostChangeInformation);
        long l = SemidynamicRouteGuidance.getTrafficOffset(rgRouteCostChangeInformation);
        Object object = this.modelMonitor;
        synchronized (object) {
            this.modelAccess.setDynamicBypassAvailable(bl);
            this.modelAccess.setSidebarButtonMode(bl ? 1 : 0);
            this.modelAccess.setTrafficOffsetShort(SemidynamicRouteGuidance.formatDurationShort(l));
            this.modelAccess.setTrafficOffsetLong(SemidynamicRouteGuidance.formatDurationLong(l));
        }
    }

    private static boolean isDynamicBypassAvailable(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        return rgRouteCostChangeInformation != null && rgRouteCostChangeInformation.getOldRoute() != null && rgRouteCostChangeInformation.getNewRoute() != null && rgRouteCostChangeInformation.newRouteRecommended;
    }

    private static long getTrafficOffset(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        if (rgRouteCostChangeInformation == null) {
            return 0L;
        }
        return SemidynamicRouteGuidance.getTrafficOffset(rgRouteCostChangeInformation.getOldRoute());
    }

    public static long getTrafficOffset(CalculatedRouteListElement calculatedRouteListElement) {
        if (calculatedRouteListElement == null) {
            return 0L;
        }
        long l = calculatedRouteListElement.etaWithSpeedAndFlow - calculatedRouteListElement.eta;
        if (l < 0) {
            return 0L;
        }
        return l;
    }

    public static long getRttWithTrafficOffset(CalculatedRouteListElement calculatedRouteListElement, NavigationEnv navigationEnv) {
        if (calculatedRouteListElement == null) {
            return 0L;
        }
        long l = calculatedRouteListElement.eta - navigationEnv.getFramework().getKombiTime();
        return l + SemidynamicRouteGuidance.getTrafficOffset(calculatedRouteListElement);
    }

    public static String formatDurationShort(long l) {
        if (l == 0L) {
            return "- -";
        }
        DateMetric dateMetric = new DateMetric(new Date(l), 7);
        return dateMetric.format();
    }

    public static String formatDurationLong(long l) {
        if (l == 0L) {
            return "- -";
        }
        DateMetric dateMetric = new DateMetric(new Date(l), 5);
        return dateMetric.format();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRgActive(boolean bl) {
        if (!bl) {
            Object object = this.modelMonitor;
            synchronized (object) {
                this.modelAccess.setDynamicBypassAvailable(false);
                this.modelAccess.setSidebarButtonMode(0);
                this.modelAccess.setTrafficOffsetShort("- -");
                this.modelAccess.setTrafficOffsetLong("- -");
            }
        }
    }
}

