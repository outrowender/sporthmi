/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class NavLocationWrapper {
    private final NavLocation loc;
    private String content = null;

    public NavLocationWrapper(NavLocation navLocation) {
        this.loc = navLocation;
    }

    public String toString() {
        if (this.content == null) {
            this.content = NavLocationWrapper.toShortString(this.loc);
        }
        return this.content;
    }

    public static String toShortString(NavLocation navLocation) {
        Buffer buffer = new Buffer();
        buffer.append("Location [lat=").append(navLocation.latitude);
        buffer.append("; long=").append(navLocation.longitude);
        MapUtils.appendIfNotEmpty(buffer, " #contry=", navLocation.country);
        MapUtils.appendIfNotEmpty(buffer, " #countryAbbreviation=", navLocation.countryAbbreviation);
        MapUtils.appendIfNotEmpty(buffer, " #housenumber=", navLocation.housenumber);
        MapUtils.appendIfNotEmpty(buffer, " #junction=", navLocation.junction);
        MapUtils.appendIfNotEmpty(buffer, " #street=", navLocation.street);
        MapUtils.appendIfNotEmpty(buffer, " #streetRefinement=", navLocation.streetRefinement);
        MapUtils.appendIfNotEmpty(buffer, " #towncenter=", navLocation.towncenter);
        MapUtils.appendIfNotEmpty(buffer, " #zipCode=", navLocation.zipCode);
        MapUtils.appendIfNotEmpty(buffer, " #contry=", navLocation.country);
        if (!navLocation.positionValid) {
            buffer.append(" #positionValid=").append(navLocation.positionValid);
        }
        if (!navLocation.versionOfLocationStructureValid) {
            buffer.append(" #versionOfLocationStructureValid=").append(navLocation.versionOfLocationStructureValid);
        }
        buffer.append("]");
        return buffer.toString();
    }
}

