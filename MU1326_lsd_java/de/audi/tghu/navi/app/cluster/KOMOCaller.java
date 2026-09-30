/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.hmi.combi.ddp2.CombiSignConverter;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfoListener;
import org.dsi.ifc.komoview.DSIKOMOView;
import org.dsi.ifc.komoview.DSIKOMOViewListener;
import org.dsi.ifc.komoview.RouteInfoElement;

public class KOMOCaller {
    private LogChannel logChannel;
    private NavigationEnv env;
    private DSIKOMONavInfo komoNavInfo;
    private DSIKOMOView komoView;
    private DSIKOMOGfxStreamSink komoGfxStreamSink;
    private static int RG_SELECT_INVALID;
    private String cityName = "";
    private String currentStreet = "";
    private long distanceToDest;
    private int distanceToDestUnit;
    private boolean distanceToDestValidity;
    private long distanceToNextManeuver;
    private int distanceToNextManeuverUnit;
    private boolean distanceToNextManeuverValidity;
    private int etaTimeFormat;
    private short etaDay;
    private short etaHour;
    private short etaMin;
    private boolean etaValidity;
    private boolean etaTimeInfo;
    private int mapScaleSteps;
    private int mapScaleAutoZoom;
    private boolean[] mapScaleAutoZoomState;
    private int mapScale;
    private int mapScaleUnit;
    private boolean[] mapScaleSupportedAutoZoom;
    private boolean mapScaleValidity;
    private int rgMode = RG_SELECT_INVALID;
    private short rttHour;
    private short rttMin;
    private boolean rttValidity;
    private boolean alternativeRoute;
    private int trafficOffsetTimeFormat;
    private short trafficOffsetDay;
    private short trafficOffsetHour;
    private short trafficOffsetMin;
    private boolean trafficOffsetValidity;
    private String turnToInfo;
    private String signPost;
    private boolean komoEnabled = false;
    private boolean komoVisible = false;
    private RouteInfoElement[] routeInfoElements = new RouteInfoElement[0];
    private RouteInfoElement routeInfoElement = new RouteInfoElement();

    public KOMOCaller(LogChannel logChannel, NavigationEnv navigationEnv) {
        this.logChannel = logChannel;
        this.env = navigationEnv;
    }

    public synchronized void setDSIKOMONavInfo(DSIKOMONavInfo dSIKOMONavInfo, DSIKOMONavInfoListener dSIKOMONavInfoListener) {
        this.logChannel.log(1000000, "KOMOCaller#setDSIKOMONavInfo( %1 )", (Object)dSIKOMONavInfo);
        if (this.komoNavInfo != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMONavInfo() - clearNotification()");
        }
        this.komoNavInfo = dSIKOMONavInfo;
        if (dSIKOMONavInfo != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMONavInfo() - calling setNotification()");
            dSIKOMONavInfo.setNotification(dSIKOMONavInfoListener);
            this.setCapabilities(new boolean[]{Util.isClusterKDKAvailable(this.env.getFramework()), Util.isClusterMapAvailable(this.env.getFramework())});
            this.setCityName(this.cityName);
            this.setCurrentStreet(this.currentStreet);
            this.setDistanceToDestination(this.distanceToDest, this.distanceToDestUnit, this.distanceToDestValidity);
            this.setDistanceToNextManeuver(this.distanceToNextManeuver, this.distanceToNextManeuverUnit, this.distanceToNextManeuverValidity);
            this.setETA(this.etaTimeFormat, this.etaDay, this.etaHour, this.etaMin, this.etaValidity, this.etaTimeInfo);
            this.setMapScale(this.mapScaleSteps, this.mapScaleAutoZoom, this.mapScaleAutoZoomState, this.mapScale, this.mapScaleUnit, this.mapScaleSupportedAutoZoom, this.mapScaleValidity);
            this.setRgSelect(this.rgMode);
            this.setRTT(this.rttHour, this.rttMin, this.rttValidity);
            this.setSemiDynRoute(this.alternativeRoute);
            this.setTrafficOffset(this.trafficOffsetTimeFormat, this.trafficOffsetDay, this.trafficOffsetHour, this.trafficOffsetMin, this.trafficOffsetValidity);
            this.setTurnToStreet(this.turnToInfo, this.signPost);
        }
    }

    public synchronized void setDSIKOMOView(DSIKOMOView dSIKOMOView, DSIKOMOViewListener dSIKOMOViewListener) {
        this.logChannel.log(1000000, "KOMOCaller#setDSIKOMOView( %1 )", (Object)dSIKOMOView);
        if (this.komoView != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMOView() - clearNotification()");
        }
        this.komoView = dSIKOMOView;
        if (dSIKOMOView != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMOView() - setNotification()");
            dSIKOMOView.setNotification(dSIKOMOViewListener);
            this.setKomoViewStyle(this.getKomoViewStyle());
            this.enableKomoView(true);
            this.notifyVisibility(this.komoVisible);
            if (this.routeInfoElements != null && this.routeInfoElements.length == 2 && Util.isSetRouteInfoDSIAvailable(this.env.getFramework())) {
                this.setRouteInfo(this.routeInfoElements);
            }
            this.setRouteInfoElement(this.routeInfoElement);
        }
    }

    public synchronized void setDSIKOMOGfxStreamSink(DSIKOMOGfxStreamSink dSIKOMOGfxStreamSink, DSIKOMOGfxStreamSinkListener dSIKOMOGfxStreamSinkListener) {
        this.logChannel.log(1000000, "KOMOCaller#setDSIKOMOGfxStreamSink( %1 )", (Object)dSIKOMOGfxStreamSink);
        if (this.komoGfxStreamSink != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMOGfxStreamSink() - clearNotification()");
        }
        this.komoGfxStreamSink = dSIKOMOGfxStreamSink;
        if (dSIKOMOGfxStreamSink != null) {
            this.logChannel.log(10000000, "KOMOCaller#setDSIKOMOGfxStreamSink() - setNotification()");
            dSIKOMOGfxStreamSink.setNotification(new int[]{3, 1, 2}, (DSIListener)dSIKOMOGfxStreamSinkListener);
        }
    }

    public synchronized void setCapabilities(boolean[] blArray) {
        if (this.komoNavInfo != null) {
            if (blArray != null && blArray.length > 1) {
                this.logChannel.log(1000000, "KOMOCaller#setCapabilities() - KOMO: %1, MAP: %2", blArray[0], blArray[1]);
                this.komoNavInfo.setCapabilities(blArray);
            } else {
                this.logChannel.log(10000, "KOMOCaller#setCapabilities() - suppNavType invalid!");
            }
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setCapabilities() - komoNavInfo service not set!");
        }
    }

    public synchronized void setCityName(String string) {
        if (!this.compareString(this.cityName, string)) {
            this.cityName = string;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setCityName( %1 )", (Object)string);
                this.komoNavInfo.setCityName(string);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setCityName() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setCurrentStreet(String string) {
        if (!this.compareString(this.currentStreet, string)) {
            this.currentStreet = string;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setCurrentStreet( %1 )", (Object)string);
                this.komoNavInfo.setCurrentStreet(string);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setCurrentStreet() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setDistanceToNextManeuver(long l, int n, boolean bl) {
        if (this.distanceToNextManeuver != l || this.distanceToNextManeuverUnit != n || this.distanceToNextManeuverValidity != bl) {
            this.distanceToNextManeuver = l;
            this.distanceToNextManeuverUnit = n;
            this.distanceToNextManeuverValidity = bl;
            if (this.komoNavInfo != null) {
                this.logChannel.log(1000000, "KOMOCaller#setDistanceToNextManeuver( %1, %2, %3 )", l, (long)n, bl);
                this.komoNavInfo.setDistanceToNextManeuver(l, n, bl);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setDistanceToNextManeuverBG() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setETA(int n, short s, short s2, short s3, boolean bl, boolean bl2) {
        if (this.etaTimeFormat != n || this.etaDay != s || this.etaHour != s2 || this.etaMin != s3 || this.etaValidity != bl || this.etaTimeInfo != bl2) {
            this.etaTimeFormat = n;
            this.etaDay = s;
            this.etaHour = s2;
            this.etaMin = s3;
            this.etaValidity = bl;
            this.etaTimeInfo = bl2;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setETA() - timeFormat: %1", (long)n);
                this.logChannel.log(10000000, "KOMOCaller#setETA() - day: %1, hour: %2, min: %3", (long)s, (long)s2, (long)s3);
                this.logChannel.log(10000000, "KOMOCaller#setETA() - validity: %1, timeInfo: %2", bl, bl2);
                this.komoNavInfo.setETA(n, s, s2, s3, bl, bl2);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setETA() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        if (this.mapScaleSteps != n || this.mapScaleAutoZoom != n2 || !Arrays.equals(this.mapScaleAutoZoomState, blArray) || this.mapScale != n3 || this.mapScaleUnit != n4 || !Arrays.equals(this.mapScaleSupportedAutoZoom, blArray2) || this.mapScaleValidity != bl) {
            this.mapScaleSteps = n;
            this.mapScaleAutoZoom = n2;
            this.mapScaleAutoZoomState = blArray;
            this.mapScale = n3;
            this.mapScaleUnit = n4;
            this.mapScaleSupportedAutoZoom = blArray2;
            this.mapScaleValidity = bl;
            if (this.komoNavInfo == null) {
                this.logChannel.log(10000000, "KOMOCaller#setMapScale() - komoNavInfo service not set!");
                return;
            }
            Buffer buffer = new Buffer().append(n).append(", ").append(n2).append(", [").append(MapUtils.toString(blArray)).append("], ").append(n3).append(", ").append(n4).append(", [").append(MapUtils.toString(blArray2)).append("], ").append(bl);
            this.logChannel.log(10000000, "KOMOCaller#setMapScale() - calling setMapScaleResult( %1 )", (Object)buffer);
            this.komoNavInfo.setMapScaleResult(n, n2, blArray, n3, n4, blArray2, bl);
        }
    }

    public synchronized void setRgSelect(int n) {
        if (n != RG_SELECT_INVALID) {
            this.rgMode = n;
            if (this.komoNavInfo != null) {
                this.logChannel.log(1000000, "KOMOCaller#setRgSelect( %1 )", (long)n);
                this.komoNavInfo.setRgSelect(n);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setRgSelect() - komoNavInfo service not set!");
            }
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setRgSelect() - invalid value: %1", (long)n);
        }
    }

    public synchronized void setRTT(short s, short s2, boolean bl) {
        if (this.rttHour != s || this.rttMin != s2 || this.rttValidity != bl) {
            this.rttHour = s;
            this.rttMin = s2;
            this.rttValidity = bl;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setRTT( %1, %2, %3 )", (long)s, (long)s2, bl);
                this.komoNavInfo.setRTT(s, s2, bl);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setRTT() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setSemiDynRoute(boolean bl) {
        this.alternativeRoute = bl;
        if (this.komoNavInfo != null) {
            this.logChannel.log(10000000, "KOMOCaller#setSemiDynRoute( %1 )", bl);
            this.komoNavInfo.setSemiDynRoute(bl);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setSemiDynRoute() - komoNavInfo service not set!");
        }
    }

    public synchronized void setTrafficOffset(int n, short s, short s2, short s3, boolean bl) {
        if (this.trafficOffsetTimeFormat != n || this.trafficOffsetDay != s || this.trafficOffsetHour != s2 || this.trafficOffsetMin != s3 || this.trafficOffsetValidity != bl) {
            this.trafficOffsetTimeFormat = n;
            this.trafficOffsetDay = s;
            this.trafficOffsetHour = s2;
            this.trafficOffsetMin = s3;
            this.trafficOffsetValidity = bl;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setTrafficOffset() - timeFormat: %2, validity: %1", bl, (long)n);
                this.logChannel.log(10000000, "KOMOCaller#setTrafficOffset() - day: %1, hour: %2, min: %3", (long)s, (long)s2, (long)s3);
                this.komoNavInfo.setTrafficOffset(n, s, s2, s3, bl);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setTrafficOffset() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setDistanceToDestination(long l, int n, boolean bl) {
        if (this.distanceToDest != l || this.distanceToDestUnit != n || this.distanceToDestValidity != bl) {
            this.distanceToDest = l;
            this.distanceToDestUnit = n;
            this.distanceToDestValidity = bl;
            if (this.komoNavInfo != null) {
                this.logChannel.log(10000000, "KOMOCaller#setDistanceToDestination( %1, %2, %3 )", l, (long)n, bl);
                this.komoNavInfo.setDistanceToDestination(l, n, bl);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setDistanceToDestination() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void setTurnToStreet(String string, String string2) {
        if (!this.compareString(this.turnToInfo, string) || !this.compareString(this.signPost, string2)) {
            this.turnToInfo = string;
            this.signPost = string2;
            if (this.komoNavInfo != null) {
                String string3 = string;
                if (Util.isBentley(this.env.getFramework()) && !Util.isEmpty(string3)) {
                    string3 = CombiSignConverter.convertSign(13) + string;
                }
                this.logChannel.log(10000000, "KOMOCaller#setTurnToStreet( %1, %2 )", (Object)string3, (Object)string2);
                this.komoNavInfo.setTurnToStreet(string3, string2);
            } else {
                this.logChannel.log(10000000, "KOMOCaller#setTurnToStreet() - komoNavInfo service not set!");
            }
        }
    }

    public synchronized void enableKomoView(boolean bl) {
        this.komoEnabled = bl;
        if (this.komoView != null) {
            this.logChannel.log(1000000, "KOMOCaller#enableKomoView( %1 )", bl);
            this.komoView.enableKomoView(bl);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#enableKomoView() - komoView service not set!");
        }
    }

    public synchronized void notifyVisibility(boolean bl) {
        this.komoVisible = bl;
        if (this.komoView != null) {
            this.logChannel.log(10000000, "KOMOCaller#notifyVisibility( %1 )", bl);
            this.komoView.notifyVisibility(bl);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#notifyVisibility() - komoView service not set!");
        }
    }

    public synchronized void setRouteInfoElement(RouteInfoElement routeInfoElement) {
        this.routeInfoElement = routeInfoElement;
        if (this.komoView != null) {
            this.logChannel.log(10000000, "KOMOCaller#setRouteInfoElement( %1 ) [DEPRECATED]", (Object)routeInfoElement);
            this.komoView.setRouteInfoElement(routeInfoElement);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setRouteInfoElement() [DEPRECATED] - komoView service not set!");
        }
    }

    public synchronized void setRouteInfo(RouteInfoElement[] routeInfoElementArray) {
        this.routeInfoElements = routeInfoElementArray;
        if (this.komoView != null) {
            if (this.logChannel.isDebug() && routeInfoElementArray != null) {
                this.logChannel.log(10000000, "KOMOCaller#setRouteInfo( %1 )", (Object)Arrays.asList(routeInfoElementArray));
            }
            if (Util.isSetRouteInfoDSIAvailable(this.env.getFramework())) {
                this.komoView.setRouteInfo(routeInfoElementArray);
            } else if (routeInfoElementArray != null && routeInfoElementArray.length >= 1) {
                this.komoView.setRouteInfoElement(routeInfoElementArray[0]);
            }
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setRouteInfo() - komoView service not set!");
        }
    }

    public synchronized void setKomoViewStyle(int n) {
        if (this.komoView != null) {
            this.logChannel.log(10000000, "KOMOCaller#setKomoViewStyle( %1 )", (long)n);
            this.komoView.setKomoViewStyle(n);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setKomoViewStyle() - komoView service not set!");
        }
    }

    public synchronized void fadeIn(int n, int n2, int n3) {
        if (this.komoGfxStreamSink != null) {
            this.logChannel.log(10000000, "KOMOCaller#fadeIn( %1, %2, %3 )", (long)n, (long)n2, (long)n3);
            this.komoGfxStreamSink.fadeIn(n, n2, n3);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#fadeIn() - komoGfxStreamSink service not set!");
        }
    }

    public synchronized void fadeOut(int n) {
        if (this.komoGfxStreamSink != null) {
            this.logChannel.log(10000000, "KOMOCaller#fadeOut( %1 )", (long)n);
            this.komoGfxStreamSink.fadeOut(n);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#fadeOut() - komoGfxStreamSink service not set!");
        }
    }

    public synchronized void setFGLayer(int n) {
        if (this.komoGfxStreamSink != null) {
            this.logChannel.log(10000000, "KOMOCaller#setFGLayer( %1 )", (long)n);
            this.komoGfxStreamSink.setFGLayer(n);
        } else {
            this.logChannel.log(10000000, "KOMOCaller#setFGLayer() - komoGfxStreamSink service not set!");
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(650);
        buffer.append("DSIKOMONavInfo: ").append(this.komoNavInfo != null ? "available" : "n/a").append('\n');
        buffer.append("DSIKOMOView: ").append(this.komoView != null ? "available" : "n/a").append('\n');
        buffer.append("DSIKOMOGfxStreamSink: ").append(this.komoGfxStreamSink != null ? "available" : "n/a").append('\n');
        buffer.append("cityName: ").append(this.cityName).append('\n');
        buffer.append("currentStreet: ").append(this.currentStreet).append('\n');
        buffer.append("distanceToDest: ").append(this.distanceToDest).append('\n');
        buffer.append("distanceToDestUnit: ").append(this.distanceToDestUnit).append('\n');
        buffer.append("distanceToDestValidity: ").append(this.distanceToDestValidity).append('\n');
        buffer.append("distanceToNextManeuver: ").append(this.distanceToNextManeuver).append('\n');
        buffer.append("distanceToNextManeuverUnit: ").append(this.distanceToNextManeuverUnit).append('\n');
        buffer.append("distanceToNextManeuverValidity: ").append(this.distanceToNextManeuverValidity).append('\n');
        buffer.append("etaDay: ").append(this.etaDay).append('\n');
        buffer.append("etaHour: ").append(this.etaHour).append('\n');
        buffer.append("etaMin: ").append(this.etaMin).append('\n');
        buffer.append("etaTimeFormat: ").append(this.etaTimeFormat).append('\n');
        buffer.append("etaTimeInfo: ").append(this.etaTimeInfo).append('\n');
        buffer.append("etaValidity: ").append(this.etaValidity).append('\n');
        buffer.append("mapScaleSteps: ").append(this.mapScaleSteps).append('\n');
        buffer.append("mapScaleAutoZoom: ").append(this.mapScaleAutoZoom).append('\n');
        buffer.append("mapScaleAutoZoomState: [").append(MapUtils.toString(this.mapScaleAutoZoomState)).append("]\n");
        buffer.append("mapScale: ").append(this.mapScale).append('\n');
        buffer.append("mapScaleUnit: ").append(this.mapScaleUnit).append('\n');
        buffer.append("mapScaleSupportedAutoZoom: [").append(MapUtils.toString(this.mapScaleSupportedAutoZoom)).append("]\n");
        buffer.append("mapScaleValidity: ").append(this.mapScaleValidity).append('\n');
        buffer.append("rgMode: ").append(this.rgMode).append('\n');
        buffer.append("rttHour: ").append(this.rttHour).append('\n');
        buffer.append("rttMin: ").append(this.rttMin).append('\n');
        buffer.append("rttValidity: ").append(this.rttValidity).append('\n');
        buffer.append("signPost: ").append(this.signPost).append('\n');
        buffer.append("trafficOffsetDay: ").append(this.trafficOffsetDay).append('\n');
        buffer.append("trafficOffsetHour: ").append(this.trafficOffsetHour).append('\n');
        buffer.append("trafficOffsetMin: ").append(this.trafficOffsetMin).append('\n');
        buffer.append("trafficOffsetTimeFormat: ").append(this.trafficOffsetTimeFormat).append('\n');
        buffer.append("trafficOffsetValidity: ").append(this.trafficOffsetValidity).append('\n');
        buffer.append("turnToInfo: ").append(this.turnToInfo).append('\n');
        buffer.append("komoEnabled: ").append(this.komoEnabled).append('\n');
        buffer.append("komoVisible: ").append(this.komoVisible).append('\n');
        buffer.append("routeInfoElements: ").append(this.routeInfoElements).append('\n');
        return buffer.toString();
    }

    private int getKomoViewStyle() {
        if (Util.isClusterMapFPK(this.env.getFramework())) {
            return 3;
        }
        if (Util.isClusterMapMOST(this.env.getFramework())) {
            return 1;
        }
        if (Util.isClusterMMI(this.env.getFramework())) {
            return 3;
        }
        return 255;
    }

    private boolean compareString(String string, String string2) {
        return de.audi.atip.util.Util.equals(string, string2);
    }
}

