/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.global.NavLocation;

public class UpdateNavLocationNameComponent
extends AbstractRemoteHMIComponent {
    public void init(final LogChannel logChannel, final RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        remoteHMIService.addCommandHandler(1100009008, new AbstractCommandHandler("updating-navlocation-name"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(10000, "UpdateNavLocationNameComponent#indicateCommand() called with %1", object);
                if (!(object instanceof NavLocation)) {
                    logChannel.log(10000, "UpdateNavLocationNameComponent#indicateCommand() invalid payload: %1", object);
                    return;
                }
                NavLocation navLocation = (NavLocation)object;
                String string = remoteHMIService.getNaviComponent().getNaviService().getAdditionalNameFromNavLocation(navLocation);
                RemoteHMIAction remoteHMIAction = remoteHMIService.getAction(1100009009);
                HMIProperties hMIProperties = remoteHMIAction.getParameters();
                hMIProperties.put("propNavLocation", navLocation);
                if (string != null) {
                    hMIProperties.put("propNavLocationName", string);
                }
                remoteHMIService.invokeAction(remoteHMIAction);
            }
        });
    }
}

