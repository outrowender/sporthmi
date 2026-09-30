/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrl;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;
import org.osgi.framework.BundleContext;

public class DSIMapViewerStreetViewCtrlProvider
extends AbstractProvider
implements DSIMapViewerStreetViewCtrl {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private DSIMapViewerStreetViewCtrlProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl;

    public DSIMapViewerStreetViewCtrlProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    public String getName() {
        return (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = DSIMapViewerStreetViewCtrlProvider.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl).getName();
    }

    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    protected Proxy createNewProxy() {
        this.proxy = new DSIMapViewerStreetViewCtrlProxy(this.instance, (DSIMapViewerStreetViewCtrlReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    public void streetViewEnabled(boolean bl) {
        try {
            this.proxy.streetViewEnabled(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void streetViewVisible(boolean bl) {
        try {
            this.proxy.streetViewVisible(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void streetViewFreeze(boolean bl) {
        try {
            this.proxy.streetViewFreeze(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void goToView() {
        try {
            this.proxy.goToView();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setStreetViewZoomIndex(int n) {
        try {
            this.proxy.setStreetViewZoomIndex(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void streetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray) {
        try {
            this.proxy.streetViewThumbnails(streetViewThumbnailArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void loadStreetView(boolean bl) {
        try {
            this.proxy.loadStreetView(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void rotateView(short s, short s2) {
        try {
            this.proxy.rotateView(s, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void rotateViewByPolarCoordinates(int n, int n2) {
        try {
            this.proxy.rotateViewByPolarCoordinates(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setAzimuth(int n) {
        try {
            this.proxy.setAzimuth(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setInclination(int n) {
        try {
            this.proxy.setInclination(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void getInfoForScreenPosition(short s, short s2) {
        try {
            this.proxy.getInfoForScreenPosition(s, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setPosition(NavLocationWgs84 navLocationWgs84) {
        try {
            this.proxy.setPosition(navLocationWgs84);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setCrossHairsVisibility(boolean bl) {
        try {
            this.proxy.setCrossHairsVisibility(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setDayNightView(boolean bl) {
        try {
            this.proxy.setDayNightView(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void snapshot() {
        try {
            this.proxy.snapshot();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setViewRotationByPolarCoordinates(float f2, float f3) {
        try {
            this.proxy.setViewRotationByPolarCoordinates(f2, f3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void startViewRotationByPolarCoordinates(float f2, float f3) {
        try {
            this.proxy.startViewRotationByPolarCoordinates(f2, f3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void stopViewRotationByPolarCoordinates() {
        try {
            this.proxy.stopViewRotationByPolarCoordinates();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setScreenViewport(Rect rect) {
        try {
            this.proxy.setScreenViewport(rect);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setCrossHairsPosition(Point point) {
        try {
            this.proxy.setCrossHairsPosition(point);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setStreetViewZoomLevel(float f2) {
        try {
            this.proxy.setStreetViewZoomLevel(f2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

