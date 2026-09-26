/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.map.PosInfo;

public class PosInfoWrapper {
    private final PosInfo posInfo;
    private String content = null;

    public PosInfoWrapper(PosInfo posInfo) {
        this.posInfo = posInfo;
    }

    public String toString() {
        if (this.content == null) {
            this.content = PosInfoWrapper.toShortString(this.posInfo);
        }
        return this.content;
    }

    public static String toShortString(PosInfo posInfo) {
        Buffer buffer = new Buffer();
        buffer.append("PosInfo(eInfoType=").append(posInfo.eInfoType);
        buffer.append("; objectId=").append(posInfo.objectId);
        if (!StringUtilities.isNullOrEmpty(posInfo.infoTxt)) {
            buffer.append("; infoTxt=").append(posInfo.infoTxt);
        }
        if (!StringUtilities.isNullOrEmpty(posInfo.url)) {
            buffer.append("; url=").append(posInfo.url);
        }
        if (posInfo.numberOfObjects > 1) {
            buffer.append("; numberOfObjects=").append(posInfo.numberOfObjects);
        }
        if (posInfo.tLocation != null && posInfo.tLocation.isPositionValid()) {
            LocationFormattingRequest locationFormattingRequest = new LocationFormattingRequest(posInfo.tLocation, false);
            buffer.append("; tLocation=[").append(locationFormattingRequest.toString()).append("]");
        }
        buffer.append(')');
        return buffer.toString();
    }
}

