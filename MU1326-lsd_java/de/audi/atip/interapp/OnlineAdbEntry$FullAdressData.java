/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.organizer.AddressData;

public class OnlineAdbEntry$FullAdressData {
    public NavLocationWgs84 navLocation;
    public AddressData adress;

    public String toString() {
        return new StringBuffer().append("FullAdressData [navLocation=").append(this.navLocation).append(", adress=").append(this.adress).append("]").toString();
    }
}

