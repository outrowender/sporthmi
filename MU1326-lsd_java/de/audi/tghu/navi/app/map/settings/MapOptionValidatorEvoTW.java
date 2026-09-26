/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.settings;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.util.Util;

public class MapOptionValidatorEvoTW
extends MapOptionValidator {
    public MapOptionValidatorEvoTW(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    public boolean isMapRepresentationValid(int n) {
        switch (n) {
            case 0: {
                return true;
            }
            case 1: {
                return Util.isGoogleEarthPresent(this.fw);
            }
            case 3: {
                return Util.isRangeMapDisplayPresent(this.fw);
            }
        }
        return false;
    }

    @Override
    public boolean isAutoZoomValid(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }
}

