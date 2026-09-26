/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;

class ActiveDestinationsManager$ActiveDestText {
    private final LocationFormattingResponse formattedAddress;
    private final long routeID;
    private final String routeName;
    private final boolean isMainDest;
    private final /* synthetic */ ActiveDestinationsManager this$0;

    ActiveDestinationsManager$ActiveDestText(ActiveDestinationsManager activeDestinationsManager, NavLocation navLocation, long l, String string, boolean bl) {
        this.this$0 = activeDestinationsManager;
        this.routeID = l;
        this.routeName = string;
        this.isMainDest = bl;
        this.formattedAddress = AddressFormatter.formatTwoLines(navLocation, ActiveDestinationsManager.access$200(activeDestinationsManager));
    }

    String getMainTitle() {
        if (0 == this.routeID) {
            if (this.isMainDest) {
                return this.routeName;
            }
            return ActiveDestinationsManager.access$200(this.this$0).getTranslatedText(21);
        }
        return this.formattedAddress.getFirstLineAsText();
    }

    String getSubTitle() {
        if (0 == this.routeID) {
            return "";
        }
        return this.formattedAddress.getSecondLineAsText();
    }
}

