/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import org.dsi.ifc.navigation.RouteOptions;

public interface IRouteCriteria {
    public static final int OPTION_IGNORE;
    public static final int OPTION_WITH;
    public static final int OPTION_AVOID;
    public static final int OPTION_AUTO;
    public static final int OPTION_MANUAL;
    public static final int OPTION_ON;
    public static final int OPTION_OFF;
    public static final int OPTION_AVOID_EXCEPT;

    default public void setValuesFromObject(IRouteCriteria iRouteCriteria) {
    }

    default public RouteOptions[] getRouteOptions(boolean bl) {
    }

    default public int getTrafficRerouting() {
    }

    default public void setTrafficRerouting(int n) {
    }

    default public int getFreeways() {
    }

    default public void setFreeways(int n) {
    }

    default public int getTollRoads() {
    }

    default public void setTollRoads(int n) {
    }

    default public int getFerries() {
    }

    default public void setFerries(int n) {
    }

    default public int getMotorrail() {
    }

    default public void setMotorrail(int n) {
    }

    default public int getTimeRestrictedRoads() {
    }

    default public void setTimeRestrictedRoads(int n) {
    }

    default public int getSeasonRestricted() {
    }

    default public void setSeasonRestricted(int n) {
    }

    default public int getTrailer() {
    }

    default public void setTrailer(int n) {
    }

    default public int getVignettes() {
    }

    default public void setVignettes(int n) {
    }

    default public int[] getVignetteCountries() {
    }

    default public void setVignetteCountries(int[] nArray) {
    }

    default public void setRouteOption(int n) {
    }

    default public void setTunnels(int n) {
    }

    default public int getTunnels() {
    }

    default public void setHovLanes(int n) {
    }

    default public int getHovLanes() {
    }

    default public void setUnpaved(int n) {
    }

    default public int getUnpaved() {
    }

    default public void setIpd(int n) {
    }

    default public int getIpd() {
    }
}

