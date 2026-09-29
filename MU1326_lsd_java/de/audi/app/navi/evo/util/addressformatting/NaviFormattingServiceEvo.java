/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.util.addressformatting;

import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.AbstractNaviFormattingService;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;

public class NaviFormattingServiceEvo
extends AbstractNaviFormattingService {
    public NaviFormattingServiceEvo(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public IFormattingResponse formatAddress(IFormattingRequest iFormattingRequest) {
        if (!(iFormattingRequest instanceof LocationFormattingRequest)) {
            this.logger.log(10000, "NaviFormattingServiceEvo#formatAddress formattingRequest is not an instance of LocationFormattingRequest");
            return null;
        }
        this.logger.log(1078071040, "NaviFormattingServiceEvo#formatAddress : formattingRequest(%1)", (Object)((Object)iFormattingRequest).toString());
        return AddressFormatter.formatTwoLines((LocationFormattingRequest)iFormattingRequest, this.env);
    }
}

