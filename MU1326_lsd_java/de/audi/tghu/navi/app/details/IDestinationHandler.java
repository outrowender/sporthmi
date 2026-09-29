/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.online.OperatorCallResult;

public interface IDestinationHandler {
    public static final int DESTINATIONTYPE_NAVLOCATION;
    public static final int DESTINATIONTYPE_ROUTE;
    public static final int DESTINATIONTYPE_NAVSEGMENTID;

    default public NavLocation getLocation() {
    }

    default public void setLocation(NavLocation navLocation) {
    }

    default public Route getRoute() {
    }

    default public void setRoute(Route route) {
    }

    default public NavSegmentID getSegmentID() {
    }

    default public void setSegmentID(NavSegmentID navSegmentID) {
    }

    default public String getNumber() {
    }

    default public void setOperatorCallResult(OperatorCallResult operatorCallResult) {
    }

    default public void setPhoneNumber(String string) {
    }

    default public int getDestinationType() {
    }

    default public boolean shouldTransfereToNdf() {
    }

    default public void setTransfereToNdf(boolean bl) {
    }
}

