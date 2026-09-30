/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavoriteLocationFormat;
import de.audi.tghu.navi.app.util.MMIInternalData;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class DefaultFavoriteLocationFormat
implements IFavoriteLocationFormat {
    private final NavigationEnv env;
    protected IMyLocationAccessor locationAccessor;
    protected MMIInternalData mmiInternalData;

    public DefaultFavoriteLocationFormat(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public String getDefaultName(NavLocation navLocation) {
        if (navLocation == null) {
            return "";
        }
        this.clear();
        return this.getTimeStamp();
    }

    protected void init(NavLocation navLocation) {
        this.createLocationAccessor(navLocation);
        this.createMMIInternalDataAccessor(navLocation);
    }

    protected void clear() {
        this.locationAccessor = null;
        this.mmiInternalData = null;
    }

    protected void createLocationAccessor(NavLocation navLocation) {
        this.locationAccessor = Util.getLocationAccessor(navLocation);
    }

    protected void createMMIInternalDataAccessor(NavLocation navLocation) {
        if (this.locationAccessor == null) {
            this.createLocationAccessor(navLocation);
        }
        this.mmiInternalData = new MMIInternalData();
        this.mmiInternalData.init(this.locationAccessor.getMmiInternalData());
    }

    protected String getTimeStamp() {
        long l = this.env.getFramework().getSysApp().getAdjustedTime();
        return Util.formatDate(l);
    }

    protected boolean isLocationPOI() {
        return this.locationAccessor != null && (!Util.isEmpty(this.locationAccessor.getPoiClass()) || !Util.isEmpty(this.locationAccessor.getPoiCategory()) || !Util.isEmpty(this.locationAccessor.getPoiName()));
    }

    protected String getPOIName() {
        if (this.locationAccessor != null) {
            return this.locationAccessor.getPoiName();
        }
        return "";
    }

    protected boolean isLocationContact() {
        return this.locationAccessor != null && this.mmiInternalData.isKeyAvailable("Title") && !Util.isEmpty(this.mmiInternalData.getValue("Title"));
    }

    protected String getContactName() {
        if (this.mmiInternalData != null) {
            return this.mmiInternalData.getValue("Title");
        }
        return "";
    }
}

