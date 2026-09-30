/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.settings;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.navi.app.map.settings.MapOptionValidator;
import de.audi.tghu.navi.app.util.Util;

public class MapOptionValidatorEvoCN
extends MapOptionValidator {
    public MapOptionValidatorEvoCN(IFrameworkAccess iFrameworkAccess) {
        super(iFrameworkAccess);
    }

    public boolean isMapRepresentationValid(int n) {
        switch (n) {
            case 0: {
                return true;
            }
            case 3: {
                return Util.isRangeMapDisplayPresent(this.fw);
            }
        }
        return false;
    }

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

