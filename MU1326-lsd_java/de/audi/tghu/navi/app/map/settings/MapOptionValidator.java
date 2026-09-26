/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.settings;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.navi.app.util.Util;

public abstract class MapOptionValidator {
    protected IFrameworkAccess fw;

    protected MapOptionValidator(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
    }

    public boolean isSetupMapColorValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    public boolean is3dBuildingsValid(int n) {
        switch (n) {
            case 2: {
                return Util.isCityModelModeAvailable(this.fw);
            }
            case 0: {
                return true;
            }
        }
        return false;
    }

    public boolean isGoogle3DCityModelValid(int n) {
        switch (n) {
            case 2: {
                return Util.isGoogle3dCityModelAvailable();
            }
            case 0: {
                return true;
            }
        }
        return false;
    }

    public boolean isAdditionalInfosValid(int n) {
        switch (n) {
            case 2: {
                return Util.isMapInMapAvailable(this.fw);
            }
            case 0: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    public boolean isAutoZoomValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    public boolean isBrandedPOIsValid(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public boolean isCrossingViewValid(int n) {
        if (!Util.isClusterRGI(this.fw) || Util.isClusterMMI(this.fw)) {
            return false;
        }
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public boolean isMapRepresentationValid(int n) {
        switch (n) {
            case 0: {
                return true;
            }
            case 2: {
                return Util.isTrafficMapAvailable(this.fw);
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

    public boolean isMapTypeValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                return true;
            }
        }
        return false;
    }

    public boolean isMapTypeAndOrientationValid(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return true;
            }
        }
        return this.isOrientationValid(n);
    }

    public boolean isOrientationValid(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return true;
            }
        }
        return false;
    }

    public boolean isPoiCategoryValid(int n) {
        switch (n) {
            case 1: 
            case 19: 
            case 56: 
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 109: 
            case 110: 
            case 111: 
            case 121: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: 
            case 132: 
            case 133: 
            case 134: 
            case 135: 
            case 136: 
            case 137: 
            case 138: 
            case 150: 
            case 151: {
                return true;
            }
        }
        return false;
    }

    public boolean isZoomListIndexValid(int n) {
        return n >= -1 && n < 42;
    }

    public boolean isOnlineTrafficValid(int n) {
        switch (n) {
            case 1: {
                return Util.isOnlineTrafficPresent(this.fw);
            }
            case 0: {
                return true;
            }
        }
        return false;
    }

    public boolean isTrafficEventNoticeMapValid() {
        return Util.isTrafficEventNoticeMapAvailable(this.fw);
    }

    public boolean isUncrowdedRoadValid() {
        return Util.isUncrowdedRoadsCheckboxAvailable(this.fw);
    }
}

