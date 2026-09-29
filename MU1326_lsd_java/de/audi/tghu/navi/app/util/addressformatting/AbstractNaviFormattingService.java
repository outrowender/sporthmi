/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.IFormattingResponse;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingRequest;
import org.dsi.ifc.global.NavLocation;

public abstract class AbstractNaviFormattingService
implements INaviFormattingService {
    protected NavigationEnv env;
    protected LogChannel logger;

    public AbstractNaviFormattingService(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getLogChannel("App.Navi.Interapp");
    }

    @Override
    public abstract IFormattingResponse formatAddress(IFormattingRequest iFormattingRequest) {
    }

    @Override
    public IFormattingResponse formattingOneLine(IFormattingRequest iFormattingRequest) {
        if (!(iFormattingRequest instanceof LocationFormattingRequest)) {
            this.logger.log(10000, "AbstractNaviFormattingService#formattingOneLine formattingRequest is not an instance of LocationFormattingRequest");
            return null;
        }
        this.logger.log(1078071040, "AbstractNaviFormattingService#formattingOneLine : formattingRequest(%1)", (Object)((Object)iFormattingRequest).toString());
        return AddressFormatter.formatOneLine((LocationFormattingRequest)iFormattingRequest, this.env);
    }

    @Override
    public IFormattingResponse formattingTwoLines(IFormattingRequest iFormattingRequest) {
        if (!(iFormattingRequest instanceof LocationFormattingRequest)) {
            this.logger.log(10000, "AbstractNaviFormattingService#formattingTwoLines formattingRequest is not an instance of LocationFormattingRequest");
            return null;
        }
        this.logger.log(1078071040, "AbstractNaviFormattingService#formattingTwoLines : formattingRequest(%1)", (Object)((Object)iFormattingRequest).toString());
        return AddressFormatter.formatTwoLines((LocationFormattingRequest)iFormattingRequest, this.env);
    }

    @Override
    public IFormattingResponse formattingThreeLines(IFormattingRequest iFormattingRequest) {
        if (!(iFormattingRequest instanceof LocationFormattingRequest)) {
            this.logger.log(10000, "AbstractNaviFormattingService#formattingThreeLines formattingRequest is not an instance of LocationFormattingRequest");
            return null;
        }
        this.logger.log(1078071040, "AbstractNaviFormattingService#formattingThreeLines : formattingRequest(%1)", (Object)((Object)iFormattingRequest).toString());
        return AddressFormatter.formatThreeLines((LocationFormattingRequest)iFormattingRequest, this.env);
    }

    @Override
    public IFormattingRequest createNewFormattingRequest() {
        return new LocationFormattingRequest();
    }

    @Override
    public IFormattingRequest createNewFormattingRequest(NavLocation navLocation, boolean bl) {
        return new LocationFormattingRequest(navLocation, bl);
    }
}

