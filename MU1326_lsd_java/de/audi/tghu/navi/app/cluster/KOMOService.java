/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterKDKHandler;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.cluster.KOMOCaller;
import de.audi.tghu.navi.app.cluster.KOMOTime;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.komoview.DSIKOMOViewListener;
import org.dsi.ifc.komoview.RouteInfoElement;

public class KOMOService
implements DSIKOMONavInfoListener,
DSIKOMOViewListener,
DSIKOMOGfxStreamSinkListener {
    private LogChannel logChannel;
    private NavigationEnv env;
    private ClusterService service;
    private KOMOCaller komoCaller;
    private boolean isFadeOut;
    private ClusterKDKHandler clusterKDKHandler;
    public static final int INVALID_DTM_UNIT = 255;

    public static int convertTimeFormatToKOMO(int n) {
        switch (n) {
            case 11: {
                return 1;
            }
        }
        return 0;
    }

    public static KOMOTime convertTimeToKOMO(long l) {
        KOMOTime kOMOTime = new KOMOTime();
        if (l >= 0L) {
            Date date = new Date(l);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);
            kOMOTime.year = (short)(gregorianCalendar.get(1) % 100);
            kOMOTime.month = (short)(gregorianCalendar.get(2) + 1);
            kOMOTime.day = (short)gregorianCalendar.get(5);
            kOMOTime.hour = (short)gregorianCalendar.get(11);
            kOMOTime.min = (short)gregorianCalendar.get(12);
        }
        return kOMOTime;
    }

    public static KOMOTime convertDurationToKOMO(long l) {
        KOMOTime kOMOTime = new KOMOTime();
        if (l >= 0L) {
            int n = (int)(l / 1000L);
            int n2 = n / 60;
            kOMOTime.hour = (short)(n2 / 60);
            kOMOTime.min = (short)(n2 % 60);
        }
        return kOMOTime;
    }

    public KOMOService(NavigationEnv navigationEnv, ClusterService clusterService, ClusterKDKHandler clusterKDKHandler) {
        this.logChannel = navigationEnv.getClusterKOMOLogChannel();
        this.env = navigationEnv;
        this.service = clusterService;
        this.isFadeOut = false;
        this.komoCaller = new KOMOCaller(this.logChannel, navigationEnv);
        this.clusterKDKHandler = clusterKDKHandler;
    }

    public void setDSIKOMONavInfo(DSIKOMONavInfo dSIKOMONavInfo) {
        this.logChannel.log(1000000, "KOMOService#setDSIKOMONavInfo( %1 )", (Object)dSIKOMONavInfo);
        this.komoCaller.setDSIKOMONavInfo(dSIKOMONavInfo, this);
    }

    public void setDSIKOMOView(DSIKOMOView dSIKOMOView) {
        this.logChannel.log(1000000, "KOMOService#setDSIKOMOView( %1 )", (Object)dSIKOMOView);
        this.komoCaller.setDSIKOMOView(dSIKOMOView, this);
    }

    public void setDSIKOMOGfxStreamSink(DSIKOMOGfxStreamSink dSIKOMOGfxStreamSink) {
        this.logChannel.log(1000000, "KOMOService#setDSIKOMOGfxStreamSink( %1 )", (Object)dSIKOMOGfxStreamSink);
        this.komoCaller.setDSIKOMOGfxStreamSink(dSIKOMOGfxStreamSink, this);
    }

    public void setCityName(String string) {
        this.komoCaller.setCityName(string);
    }

    public void setCurrentStreet(String string) {
        this.komoCaller.setCurrentStreet(string);
    }

    public void setDistanceToNextManeuver(long l, int n, boolean bl) {
        this.logChannel.log(10000000, "KOMOService#setDistanceToNextManeuver() - distance: %1, unit: %2, validity: %3", l, (long)n, bl);
        this.komoCaller.setDistanceToNextManeuver(l, n, bl);
    }

    public void setETA(int n, short s, short s2, short s3, boolean bl, boolean bl2) {
        this.komoCaller.setETA(n, s, s2, s3, bl, bl2);
    }

    public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        this.komoCaller.setMapScale(n, n2, blArray, n3, n4, blArray2, bl);
    }

    public void setRgSelect(int n) {
        this.komoCaller.setRgSelect(n);
        if (Util.isClusterMapMOSTAlwaysOn() && Util.isClusterMapMOST(this.env.getFramework())) {
            if (n == 1 || n == 3) {
                this.updateDataRate(2, 1);
            } else {
                this.updateDataRate(0, 1);
            }
        }
    }

    public void setRTT(short s, short s2, boolean bl) {
        this.komoCaller.setRTT(s, s2, bl);
    }

    public void setSemiDynRoute(boolean bl) {
        this.komoCaller.setSemiDynRoute(bl);
    }

    public void setTrafficOffset(int n, short s, short s2, short s3, boolean bl) {
        this.komoCaller.setTrafficOffset(n, s, s2, s3, bl);
    }

    public void setDistanceToDestination(long l, int n, boolean bl) {
        this.logChannel.log(100000000, "KOMOService#setDistanceToDestination() - distance: %1, unit: %2, validity: %3", l, (long)n, bl);
        this.komoCaller.setDistanceToDestination(l, n, bl);
    }

    public void setTurnToStreet(String string, String string2) {
        this.komoCaller.setTurnToStreet(string, string2);
    }

    public void enableKomoView(boolean bl) {
        this.logChannel.log(1000000, "KOMOService#enableKomoView() - enable: %1", bl);
        this.komoCaller.enableKomoView(bl);
    }

    public void notifyVisibility(boolean bl) {
        this.komoCaller.notifyVisibility(bl);
    }

    public void setRouteInfoElement(RouteInfoElement routeInfoElement) {
        this.komoCaller.setRouteInfoElement(routeInfoElement);
    }

    public void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "KOMOService#setRouteInfoElement( %1 )", (Object)Arrays.asList(routeInfoElementArray));
        }
        this.komoCaller.setRouteInfo(routeInfoElementArray);
    }

    public void asyncException(int n, String string, int n2) {
        this.logChannel.log(10000000, "KOMOService#asyncException( %2, %1, %3 )", (Object)string, (long)n, (long)n2);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("isFadeOut: ").append(this.isFadeOut).append('\n');
        buffer.append(this.komoCaller);
        return buffer.toString();
    }

    public void updateGfxState(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(1000000, "KOMOService#updateGfxState( %1 )", (long)n);
            this.service.getClusterViewMode().setGFXAvailable(n == 1);
        }
    }

    public void updateRequestSync(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(1000000, "KOMOService#updateRequestSync( %1 )", (long)n);
            if (n == 1) {
                this.service.reSyncKOMO();
            }
        }
    }

    public void updateDataRate(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(1000000, "KOMOService#updateDataRate( %1 )", (long)n);
            this.service.getClusterViewMode().setDataRate(n);
            this.service.setKOMODataRate(n);
        }
    }

    public void setFGLayerResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setFGLayerResult( %1 )", (long)n);
    }

    public void fadeInResult() {
        this.logChannel.log(10000000, "KOMOService#fadeInResult( %1 )");
    }

    public void fadeOutResult() {
        this.logChannel.log(10000000, "KOMOService#fadeOutResult( %1 )");
        this.service.getClusterViewMode().fadeOutFinished();
    }

    public void updateKomoViewEnabled(boolean bl, int n) {
        if (n == 1) {
            this.logChannel.log(1000000, "KOMOService#updateKomoViewEnabled( %1 )", bl);
            if (!bl && Util.isClusterMapMOSTAlwaysOn()) {
                this.logChannel.log(1000000, "KOMOService#updateKomoViewEnabled() - override for always-on!");
                bl = true;
            }
            this.service.getClusterViewMode().setKOMOViewEnabled(bl);
            this.clusterKDKHandler.updateKOMOViewEnabled(bl);
        }
    }

    public void updateVisibility(boolean bl, int n) {
        if (n == 1) {
            this.logChannel.log(1000000, "KOMOService#updateVisibility( %1 )", bl);
            this.service.getClusterViewMode().setKOMOViewVisible(bl);
            this.clusterKDKHandler.updateKOMOViewVisible(bl);
        }
    }

    public void setCurrentStreetResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setCurrentStreetResult( %1 )", (long)n);
    }

    public void setTurnToStreetResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setTurnToStreetResult( %1 )", (long)n);
    }

    public void setCityNameResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setCityNameResult( %1 )", (long)n);
    }

    public void setSemiDynRouteResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setSemiDynRouteResult( %1 )", (long)n);
    }

    public void setTrafficOffsetResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setTrafficOffsetResult( %1 )", (long)n);
    }

    public void setRgSelectResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setRgSelectResult( %1 )", (long)n);
    }

    public void setCapabilitiesResult(int n) {
        this.logChannel.log(10000000, "KOMOService#setCapabilitiesResult( %1 )", (long)n);
    }

    protected void doFadeIn(int n) {
        this.logChannel.log(10000000, "KOMOService#doFadeIn( %1 )", (long)n);
        this.isFadeOut = false;
        this.komoCaller.fadeIn(n, 0, 0);
    }

    protected void doFadeOut(int n) {
        this.logChannel.log(10000000, "KOMOService#doFadeOut( %1 )", (long)n);
        this.isFadeOut = true;
        this.komoCaller.fadeOut(n);
    }

    protected boolean isFadedOut() {
        return this.isFadeOut;
    }

    public void komoViewResult(int n) {
        this.logChannel.log(10000000, "KOMOService#komoViewResult( %1 )", (long)n);
    }

    public void updateCurrentKomoViewType(int n, int n2) {
        if (n2 == 1) {
            this.logChannel.log(10000000, "KOMOService#updateCurrentKomoViewType( %1 )", (long)n);
        }
    }

    public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        this.logChannel.log(10000000, "KOMOService#setMapScaleResult() - deprecated");
    }

    public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
        Buffer buffer = new Buffer().append(n).append(", ").append(n2).append(", [").append(MapUtils.toString(blArray)).append("], ").append(n3).append(", ").append(n4).append(", ").append(n5);
        this.logChannel.log(10000000, "KOMOService#setMapScale( %1 )", (Object)buffer);
    }
}

