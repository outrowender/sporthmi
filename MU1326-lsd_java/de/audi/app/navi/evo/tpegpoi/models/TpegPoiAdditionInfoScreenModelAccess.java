/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.models;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiDetailScreenModelAccess;
import de.audi.tghu.navi.app.util.LocationFormatter;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.PoiExtendedInfo;

public class TpegPoiAdditionInfoScreenModelAccess
implements IPoiDetailScreenModelAccess {
    private static final int NO_ID_FOUND;
    private final NavigationEnv env;
    private LabelModelApp title;
    private MetricsModelApp timeStamp;
    private LabelModelApp address;
    private LabelModelApp text;
    private ChoiceModelApp picture;

    public TpegPoiAdditionInfoScreenModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.title = navigationEnv.getLabelModel(-1910307328);
        this.timeStamp = navigationEnv.getMetricsModel(-1943861760);
        this.address = navigationEnv.getLabelModel(1713636864);
        this.text = navigationEnv.getLabelModel(-1893530112);
        this.picture = navigationEnv.getChoiceModel(-1859975680);
    }

    @Override
    public void onStart() {
        this.timeStamp.setMetric(null);
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation) {
        PoiExtendedInfo poiExtendedInfo = this.env.getContainer().getPoiExtendedInfo();
        if (poiExtendedInfo != null) {
            this.title.setText(this.extractTitle(navLocation));
            this.timeStamp.setMetric(this.extractDateMetric(poiExtendedInfo));
            this.address.setText(poiExtendedInfo.getUnstructuredAddress());
            this.text.setText(poiExtendedInfo.getDescription());
            this.picture.setValue(this.extractResourceID(poiExtendedInfo));
        }
    }

    private int extractResourceID(PoiExtendedInfo poiExtendedInfo) {
        ResourceLocator[] resourceLocatorArray = poiExtendedInfo.getPictureReferences();
        if (resourceLocatorArray.length > 0) {
            for (int i2 = 0; i2 < resourceLocatorArray.length; ++i2) {
                if (resourceLocatorArray[i2] == null) continue;
                return resourceLocatorArray[i2].getId();
            }
        }
        return -1;
    }

    private String extractTitle(NavLocation navLocation) {
        return LocationFormatter.formatPOIName(navLocation);
    }

    private AbstractMetrics extractDateMetric(PoiExtendedInfo poiExtendedInfo) {
        DateMetric dateMetric = new DateMetric(new Date(poiExtendedInfo.getTimestamp().getTime()), 0);
        return dateMetric;
    }
}

