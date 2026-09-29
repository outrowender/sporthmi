/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationsCache;
import de.audi.tghu.navi.app.util.LocationFormatter;
import java.util.Arrays;
import org.dsi.ifc.navigation.TryMatchLocationData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;

public class LITryMatchLocationCommand
extends NavCommand {
    private TryMatchLocationData tmlData;
    private final NavLocationsCache cache;

    public LITryMatchLocationCommand(TryMatchLocationData tryMatchLocationData, NavLocationsCache navLocationsCache) {
        this.tmlData = tryMatchLocationData;
        this.cache = navLocationsCache;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute() - calling liTryMatchLocation() tmlData: %2 ", (Object)this.CLASS_NAME, (Object)this.tmlData);
        this.getDSINavigation().liTryMatchLocation(this.tmlData);
    }

    @Override
    public void liTryMatchLocationResult(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        if (tryMatchLocationResultDataArray != null && tryMatchLocationResultDataArray.length > 0 && tryMatchLocationResultDataArray[0] != null) {
            this.logger.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#liTryMatchLocationResult() matchLevel=%2, result.length=%3, result[0].getLocation(): %1").toString(), (Object)LocationFormatter.formatLocationShort(tryMatchLocationResultDataArray[0].getLocation()), (long)tryMatchLocationResultDataArray[0].matchLevel, (long)tryMatchLocationResultDataArray.length);
        } else {
            this.logger.log(10000, "%1#liTryMatchLocationResult() invalid result: %2", (Object)this.CLASS_NAME, (Object)Arrays.asList(tryMatchLocationResultDataArray));
        }
        this.dsiResponseContainer.setTryMatchLocationResultData(tryMatchLocationResultDataArray);
        if (this.cache != null) {
            this.cache.saveResponse(tryMatchLocationResultDataArray, this.tmlData);
        }
        this.getCommandList().commandFinished();
    }
}

