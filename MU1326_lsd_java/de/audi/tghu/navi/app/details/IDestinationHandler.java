/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.online.OperatorCallResult;

public interface IDestinationHandler {
    public static final int DESTINATIONTYPE_NAVLOCATION = 0;
    public static final int DESTINATIONTYPE_ROUTE = 1;
    public static final int DESTINATIONTYPE_NAVSEGMENTID = 2;

    public NavLocation getLocation();

    public void setLocation(NavLocation var1);

    public Route getRoute();

    public void setRoute(Route var1);

    public NavSegmentID getSegmentID();

    public void setSegmentID(NavSegmentID var1);

    public String getNumber();

    public void setOperatorCallResult(OperatorCallResult var1);

    public void setPhoneNumber(String var1);

    public int getDestinationType();

    public boolean shouldTransfereToNdf();

    public void setTransfereToNdf(boolean var1);
}

