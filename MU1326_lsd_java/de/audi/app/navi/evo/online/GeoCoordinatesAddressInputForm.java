/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online;

import de.audi.app.navi.evo.online.GeoCoordinates;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import org.dsi.ifc.global.NavLocation;

public class GeoCoordinatesAddressInputForm
implements GeoCoordinates {
    private final LogChannel logChannel;
    private final IAddressInputForm addressInputForm;

    public GeoCoordinatesAddressInputForm(LogChannel logChannel, IAddressInputForm iAddressInputForm) {
        this.logChannel = logChannel;
        this.addressInputForm = iAddressInputForm;
    }

    public NavLocation extractGeoCoordinates(int n, int n2, NavigationEnv navigationEnv) {
        this.logChannel.log(10000000, "GeoCoordinatesAddressInputForm#extractGeoCoordinates: Called with targetModelID '%1' and targetRow '%2'", (long)n, (long)n2);
        if (this.addressInputForm == null) {
            this.logChannel.log(100000, "GeoCoordinatesAddressInputForm#extractGeoCoordinates: IAddressInputForm is null");
            return null;
        }
        return this.addressInputForm.getBackupLocation();
    }
}

