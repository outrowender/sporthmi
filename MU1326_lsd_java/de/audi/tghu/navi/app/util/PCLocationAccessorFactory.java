/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.util.IMyLocationAccessorFactory;
import de.audi.tghu.navi.app.util.PCLocationAccessor;
import de.audi.tghu.navi.app.util.PCLocationAccessorWrapper;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class PCLocationAccessorFactory
implements IMyLocationAccessorFactory {
    private ILocationAccessorFactory factory = null;

    public PCLocationAccessorFactory(ILocationAccessorFactory iLocationAccessorFactory) {
        this.factory = iLocationAccessorFactory;
    }

    public IMyLocationAccessor cloneLocationAccessor(IMyLocationAccessor iMyLocationAccessor) {
        if (iMyLocationAccessor instanceof PCLocationAccessor) {
            if (this.factory == null) {
                return new PCLocationAccessor((PCLocationAccessor)iMyLocationAccessor);
            }
        } else if (iMyLocationAccessor instanceof PCLocationAccessorWrapper && this.factory != null) {
            return new PCLocationAccessorWrapper(this.factory, (PCLocationAccessorWrapper)iMyLocationAccessor);
        }
        return null;
    }

    public IMyLocationAccessor createLocationAccessorFromGeoPos(int n, int n2) {
        return this.factory != null ? new PCLocationAccessorWrapper(this.factory.createLocationAccessorFromGeoPos(n, n2)) : new PCLocationAccessor(n, n2);
    }

    public IMyLocationAccessor fromLocation(NavLocation navLocation) {
        return this.factory != null ? new PCLocationAccessorWrapper(this.factory.fromLocation(navLocation)) : new PCLocationAccessor(navLocation);
    }

    public NavLocation toLocation(IMyLocationAccessor iMyLocationAccessor) {
        if (iMyLocationAccessor instanceof PCLocationAccessor) {
            return ((PCLocationAccessor)iMyLocationAccessor).trans;
        }
        if (iMyLocationAccessor instanceof PCLocationAccessorWrapper && this.factory != null) {
            return this.factory.toLocation(((PCLocationAccessorWrapper)iMyLocationAccessor).getAccessor());
        }
        return null;
    }

    public IMyLocationAccessor fromTraceId(NavSegmentID navSegmentID) {
        return this.factory != null ? new PCLocationAccessorWrapper(this.factory.fromTraceId(navSegmentID)) : new PCLocationAccessor(navSegmentID);
    }
}

