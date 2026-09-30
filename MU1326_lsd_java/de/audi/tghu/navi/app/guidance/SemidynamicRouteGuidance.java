/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import java.util.Date;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;

public class SemidynamicRouteGuidance {
    public static final String NO_DURATION = "- -";
    public static final long TRAFFIC_OFFSET_THRESHOLD = 60000L;
    private final LogChannel logChannel;
    private int huRegion;
    private final ModelAccess modelAccess;
    private final Object modelMonitor = new Object();

    public SemidynamicRouteGuidance(NavigationEnv navigationEnv) {
        this(navigationEnv, new ModelAccessImpl(navigationEnv));
    }

    public SemidynamicRouteGuidance(NavigationEnv navigationEnv, ModelAccess modelAccess) {
        this.modelAccess = modelAccess;
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
        this.logChannel.log(1000000, "SemidynamicRouteGuidance#updateRgRouteCostChangeInformation( %1 ) ", (Object)rgRouteCostChangeInformation);
        if (!this.isActive()) {
            this.logChannel.log(1000000, "SemidynamicRouteGuidance#updateRgRouteCostChangeInformation - not active, ignoring update");
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
        if (l < 60000L) {
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
            return NO_DURATION;
        }
        DateMetric dateMetric = new DateMetric(new Date(l), 7);
        return dateMetric.format();
    }

    public static String formatDurationLong(long l) {
        if (l == 0L) {
            return NO_DURATION;
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
                this.modelAccess.setTrafficOffsetShort(NO_DURATION);
                this.modelAccess.setTrafficOffsetLong(NO_DURATION);
            }
        }
    }

    public static interface ModelAccess {
        public static final int SIDEBAR_ALTERNATIVE_ROUTES = 0;
        public static final int SIDEBAR_DYNAMIC_BYPASS = 1;

        public void setDynamicBypassAvailable(boolean var1);

        public boolean isDynamicBypassAvailable();

        public void setTrafficOffsetShort(String var1);

        public void setTrafficOffsetLong(String var1);

        public void setSidebarButtonMode(int var1);
    }

    private static class ModelAccessImpl
    implements ModelAccess {
        private final NavigationEnv env;
        private final LogChannel logChannel;

        public ModelAccessImpl(NavigationEnv navigationEnv) {
            this.env = navigationEnv;
            this.logChannel = navigationEnv.getLogChannel();
        }

        public void setDynamicBypassAvailable(boolean bl) {
            this.logChannel.log(10000000, "SemidynamicRouteGuidance#setDynamicBypassAvailable( %1 ) ", bl);
            this.env.getChoiceModel(160).setValue(bl ? 1 : 0);
        }

        public boolean isDynamicBypassAvailable() {
            return this.env.getChoiceModel(160).getValue() == 1;
        }

        public void setTrafficOffsetShort(String string) {
            this.logChannel.log(10000000, "SemidynamicRouteGuidance#setTrafficOffsetShort( %1 ) ", (Object)string);
            this.env.getLabelModel(164).setText(string);
        }

        public void setTrafficOffsetLong(String string) {
            this.logChannel.log(10000000, "SemidynamicRouteGuidance#setTrafficOffsetLong( %1 ) ", (Object)string);
            this.env.getLabelModel(163).setText(string);
        }

        public void setSidebarButtonMode(int n) {
            this.logChannel.log(10000000, "SemidynamicRouteGuidance#setSidebarButtonMode( %1 ) ", (long)n);
            ChoiceModelApp choiceModelApp = this.env.getChoiceModel(400880);
            choiceModelApp.setValue(n);
        }
    }
}

