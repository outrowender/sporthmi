/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.settings;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.util.Util;

public class MapOptionValidatorEvoNAR
extends MapOptionValidator {
    public MapOptionValidatorEvoNAR(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    @Override
    public boolean isAdditionalInfosValid(int n) {
        switch (n) {
            case 2: {
                return Util.isMapInMapAvailable(this.fw);
            }
            case 0: 
            case 1: 
            case 3: {
                return true;
            }
        }
        return false;
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
}

