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

    @Override
    public void setLocation(NavLocation navLocation) {
        this.location = navLocation;
        this.destinationType = 0;
    }

    @Override
    public void setRoute(Route route) {
        this.route = route;
        this.destinationType = 1;
        this.transfereToNdf = false;
    }

    @Override
    public void setSegmentID(NavSegmentID navSegmentID) {
        this.segmentID = navSegmentID;
        this.destinationType = 2;
        this.transfereToNdf = false;
    }

    @Override
    public void setOperatorCallResult(OperatorCallResult operatorCallResult) {
    }

    @Override
    public void setPhoneNumber(String string) {
        this.phoneNumber = string;
    }

    @Override
    public NavLocation getLocation() {
        return this.location;
    }

    @Override
    public Route getRoute() {
        return this.route;
    }

    @Override
    public NavSegmentID getSegmentID() {
        return this.segmentID;
    }

    @Override
    public String getNumber() {
        return this.phoneNumber;
    }

    @Override
    public int getDestinationType() {
        return this.destinationType;
    }

    @Override
    public boolean shouldTransfereToNdf() {
        return this.transfereToNdf;
    }

    @Override
    public void setTransfereToNdf(boolean bl) {
        this.transfereToNdf = bl;
    }
}

