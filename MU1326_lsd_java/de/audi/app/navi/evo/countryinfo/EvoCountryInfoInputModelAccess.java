/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.countryinfo;

import de.audi.app.navi.evo.addressinput.country.CountryInputModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.countryinfo.ICountryInfoHandler;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class EvoCountryInfoInputModelAccess
extends CountryInputModelAccess {
    private final ICountryInfoHandler countryInfoHandler;

    public EvoCountryInfoInputModelAccess(NavigationEnv navigationEnv, int n, int n2, ICountryInfoHandler iCountryInfoHandler, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        super(navigationEnv, n, n2, iAddressInputFormModelAccessHelper);
        this.countryInfoHandler = iCountryInfoHandler;
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.countryInfoHandler.setCountry(navLocation);
    }
}

