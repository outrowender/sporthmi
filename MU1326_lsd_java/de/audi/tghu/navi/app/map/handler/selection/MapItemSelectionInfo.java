/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.tmc.TmcMessage;

public class MapItemSelectionInfo {
    public static final int RESOLVED;
    public static final int RESOLVING;
    public static final int RESOLVING_FAILED;
    public final long ID;
    public int state = 0;
    public final PosInfo posInfo;
    public String textDescriptionSingleLine = "";
    public String Url = null;
    public NavLocation navLocationAdditionalInfo = null;
    public NavLocation navLocationPicNavTransformed = null;
    public NavLocation navLocationPoiOnboardGoogle = null;
    public NavLocation navLocationXtResolved = null;
    public TmcMessage tmcMessage = null;
    public boolean isRouteSegment = false;
    public long routeSegmentIndex = -1L;
    public PoiOnlineSearchValuelistElement poiOnlineSearchElement = null;
    public ExtRenderingInfo tmc_roadSignInfo;
    public String tmc_roadNr;
    public int tmc_eventIconID;
    public NavLocation navLocationHomeOrOffice = null;
    public NavLocation navLocationOnlineResolved = null;
    public LogChannel logChannel;

    public static MapItemSelectionInfo create(PosInfo posInfo, LogChannel logChannel) {
        MapItemSelectionInfo mapItemSelectionInfo = new MapItemSelectionInfo(posInfo, logChannel);
        return mapItemSelectionInfo;
    }

    private MapItemSelectionInfo(PosInfo posInfo, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.posInfo = posInfo;
        this.ID = System.currentTimeMillis();
    }

    public ResourceLocator getPicNavLocator() {
        return this.posInfo.getResourceLocator();
    }

    public int getState() {
        return this.state;
    }

    public void setResolved(boolean bl) {
        this.state = bl ? 0 : 255;
    }

    public String toString() {
        Buffer buffer = new Buffer("SelectedValue [ID=").append(this.ID);
        buffer.append(", state=").append(this.state);
        buffer.append(", posInfo=").append(this.posInfo);
        buffer.append(", str=").append(this.textDescriptionSingleLine);
        buffer.append(", Url=").append(this.Url);
        buffer.append(", additionalInfo=").append(this.navLocationAdditionalInfo);
        buffer.append(", picNavTransformedLocation=").append(this.navLocationPicNavTransformed);
        buffer.append(", googleOnboardPOILocation=").append(this.navLocationPoiOnboardGoogle);
        buffer.append(", XTResolvedLocation=").append(this.navLocationXtResolved);
        buffer.append(", tmcmsg=").append(this.tmcMessage);
        buffer.append(", isRouteSegment=").append(this.isRouteSegment);
        buffer.append(", routeSegmentIndex=").append(this.routeSegmentIndex);
        buffer.append(", poiOnlineSearchElement=").append(this.poiOnlineSearchElement);
        buffer.append(", tmc_roadSignInfo=").append(this.tmc_roadSignInfo);
        buffer.append(", tmc_roadNr=").append(this.tmc_roadNr);
        buffer.append(", tmc_eventIconID=").append(this.tmc_eventIconID);
        buffer.append(']');
        return buffer.toString();
    }

    public NavLocation getLocationTransformed() {
        if (this.navLocationHomeOrOffice != null && this.navLocationHomeOrOffice.isPositionValid()) {
            return this.navLocationHomeOrOffice;
        }
        if (this.navLocationAdditionalInfo != null && this.navLocationAdditionalInfo.isPositionValid()) {
            return this.navLocationAdditionalInfo;
        }
        if (this.navLocationXtResolved != null && this.navLocationXtResolved.isPositionValid()) {
            return this.navLocationXtResolved;
        }
        if (this.navLocationPoiOnboardGoogle != null && this.navLocationPoiOnboardGoogle.isPositionValid()) {
            return this.navLocationPoiOnboardGoogle;
        }
        if (this.navLocationPicNavTransformed != null && this.navLocationPicNavTransformed.isPositionValid()) {
            return this.navLocationPicNavTransformed;
        }
        if (this.navLocationOnlineResolved != null && this.navLocationOnlineResolved.isPositionValid()) {
            return this.navLocationOnlineResolved;
        }
        if (this.posInfo != null && this.posInfo.getTLocation() != null && this.posInfo.getTLocation().isPositionValid()) {
            return this.posInfo.getTLocation();
        }
        this.logChannel.log(10000, "MapItemSelectionInfo#getLocationTransformed(): no valid navLocation found");
        if (this.navLocationHomeOrOffice != null) {
            return this.navLocationHomeOrOffice;
        }
        if (this.navLocationAdditionalInfo != null) {
            return this.navLocationAdditionalInfo;
        }
        if (this.navLocationXtResolved != null) {
            return this.navLocationXtResolved;
        }
        if (this.navLocationPoiOnboardGoogle != null) {
            return this.navLocationPoiOnboardGoogle;
        }
        if (this.navLocationPicNavTransformed != null) {
            return this.navLocationPicNavTransformed;
        }
        if (this.navLocationOnlineResolved != null) {
            return this.navLocationOnlineResolved;
        }
        if (this.posInfo != null && this.posInfo.getTLocation() != null) {
            return this.posInfo.getTLocation();
        }
        this.logChannel.log(10000, "MapItemSelectionInfo#getLocationTransformed(): no navLocation at all found");
        return null;
    }

    public NavLocation getLocationPoiOnlineResolved() {
        if (this.navLocationOnlineResolved != null) {
            return this.navLocationOnlineResolved;
        }
        return null;
    }
}

