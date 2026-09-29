/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.log.LogChannel;

public class MapConfig {
    private int[] contextObjects = null;
    private boolean googleEarth = false;
    private boolean maneuverView;
    private int mapInstanceId;
    private int mapInstanceIdGoogle;
    private boolean routeInfo;
    private int terminalID = 0;
    private boolean tooltip;
    private boolean zoomEngine;
    private LogChannel logDSIGoogle;
    private LogChannel logDSIGoogleListener;

    public int getMapInstanceId() {
        return this.mapInstanceId;
    }

    public int getMapInstanceIdGoogle() {
        return this.mapInstanceIdGoogle;
    }

    public int[] getSupportedContextClsIds() {
        return this.contextObjects;
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public boolean hasGoogleEarth() {
        return this.googleEarth;
    }

    public boolean hasManeuverView() {
        return this.maneuverView;
    }

    public boolean hasRouteInfo() {
        return this.routeInfo;
    }

    public boolean hasTooltip() {
        return this.tooltip;
    }

    public boolean hasZoomEngine() {
        return this.zoomEngine;
    }

    public void setGoogleEarth(boolean bl) {
        this.googleEarth = bl;
    }

    public void setManeuverView(boolean bl) {
        this.maneuverView = bl;
    }

    public void setMapInstanceId(int n) {
        this.mapInstanceId = n;
    }

    public void setMapInstanceIdGoogle(int n) {
        this.mapInstanceIdGoogle = n;
    }

    public void setRouteInfo(boolean bl) {
        this.routeInfo = bl;
    }

    public void setSupportedContextObjs(int[] nArray) {
        this.contextObjects = nArray;
    }

    public void setTerminalID(int n) {
        this.terminalID = n;
    }

    public void setTooltip(boolean bl) {
        this.tooltip = bl;
    }

    public void setZoomEngine(boolean bl) {
        this.zoomEngine = bl;
    }

    public void setDSIGoogleLogChannel(LogChannel logChannel, LogChannel logChannel2) {
        this.logDSIGoogle = logChannel;
        this.logDSIGoogleListener = logChannel2;
    }

    public LogChannel getLogDSIGoogle() {
        return this.logDSIGoogle;
    }

    public LogChannel getLogDSIGoogleListener() {
        return this.logDSIGoogleListener;
    }
}

