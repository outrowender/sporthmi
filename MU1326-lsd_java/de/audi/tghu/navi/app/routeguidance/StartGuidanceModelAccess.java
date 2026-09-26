/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceModelAccess;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

public class StartGuidanceModelAccess
implements IStartGuidanceModelAccess {
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());

    public StartGuidanceModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getLogChannel();
    }

    @Override
    public void onStart(Route route, NavLocation navLocation, boolean bl) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onStart - isRgActive: %1, destinationToAdd: %3, currentRoute: %2").toString(), bl, (Object)route, (Object)navLocation);
        LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatOneLine(navLocation, this.env);
        String string = locationFormattingResponse.getFirstLineAsText();
        if (Util.isEmpty(string)) {
            this.logChannel.log(10000, "%1#onStart() destinationToAdd contains no valid information.", (Object)this.CLASS_NAME);
        }
        this.logChannel.log(-2137614336, "%1#onStart() update model Text to : \"%2\"", (Object)this.CLASS_NAME, (Object)string);
        this.env.getLabelModel(-400620032).setText(string);
    }
}

