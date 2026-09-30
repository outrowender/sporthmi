/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.rml;

import de.audi.app.navi.evo.rml.RMLModelAccess;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;

public class RMLModelAccessAsia
extends RMLModelAccess {
    private IVehicle vehicle;

    public RMLModelAccessAsia(NavigationEnv navigationEnv, int n, int n2, int n3, IconHandler iconHandler, IPreviewMap iPreviewMap, IRouteManager iRouteManager, IVehicle iVehicle) {
        super(navigationEnv, n, n2, n3, iconHandler, iPreviewMap, iRouteManager);
        this.vehicle = iVehicle;
    }

    protected int countFirstLinesWithoutDistance() {
        return 0;
    }

    protected String getCCPText() {
        if (null == this.vehicle) {
            return null;
        }
        NavLocation navLocation = this.vehicle.getVehicleLocationDescription();
        if (null == navLocation) {
            return null;
        }
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatOneLine(navLocation, this.env);
        return locationFormattingResponse.getFirstLineAsText();
    }
}

