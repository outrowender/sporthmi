/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.log.LogChannel;
import de.audi.atip.onlinelogo.IOnlineLogoProvider;
import de.audi.atip.onlinelogo.OnlineLogoItem;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.DownloadLogoItemCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;

public class OnlineLogoProvider
implements IOnlineLogoProvider {
    private final OnlineServiceRegistrationSubsystem onlineService;
    LogChannel logger;

    public OnlineLogoProvider(OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.onlineService = onlineServiceRegistrationSubsystem;
        this.logger = onlineServiceRegistrationSubsystem.getLogChannel();
        this.logger.log(1078071040, "OnlineLogoProvider#OnlineLogoProvider()");
    }

    @Override
    public void downloadLogoItem(String string, String string2, OnlineLogoItem onlineLogoItem) {
        this.logger.log(-2137614336, "OnlineLogoProvider#downloadLogoItem() URL = %1, path = %2", (Object)string, (Object)string2);
        OSRCommandList oSRCommandList = this.onlineService.createCommandList();
        DownloadLogoItemCommand downloadLogoItemCommand = new DownloadLogoItemCommand(this.logger, string, string2, onlineLogoItem);
        oSRCommandList.add(downloadLogoItemCommand);
        oSRCommandList.execute(super.getClass().getName());
    }
}

