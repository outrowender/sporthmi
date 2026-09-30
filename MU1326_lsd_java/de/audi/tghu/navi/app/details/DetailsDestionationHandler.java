/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.tghu.navi.app.details.IDestinationHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.online.OperatorCallResult;

public class DetailsDestionationHandler
implements IDestinationHandler {
    private NavLocation location;
    private Route route;
    private NavSegmentID segmentID;
    private String phoneNumber;
    private int destinationType = 0;
    private boolean transfereToNdf;

    public void setLocation(NavLocation navLocation) {
        this.location = navLocation;
        this.destinationType = 0;
    }

    public void setRoute(Route route) {
        this.route = route;
        this.destinationType = 1;
        this.transfereToNdf = false;
    }

    public void setSegmentID(NavSegmentID navSegmentID) {
        this.segmentID = navSegmentID;
        this.destinationType = 2;
        this.transfereToNdf = false;
    }

    public void setOperatorCallResult(OperatorCallResult operatorCallResult) {
    }

    public void setPhoneNumber(String string) {
        this.phoneNumber = string;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public Route getRoute() {
        return this.route;
    }

    public NavSegmentID getSegmentID() {
        return this.segmentID;
    }

    public String getNumber() {
        return this.phoneNumber;
    }

    public int getDestinationType() {
        return this.destinationType;
    }

    public boolean shouldTransfereToNdf() {
        return this.transfereToNdf;
    }

    public void setTransfereToNdf(boolean bl) {
        this.transfereToNdf = bl;
    }
}

