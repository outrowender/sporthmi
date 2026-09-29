/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdSetAudioRouteA2LS
extends Command {
    private static final AudioRoute[] A2LS_ROUTE = new AudioRoute[]{new AudioRoute(2, 1, 0)};
    private final DSIMediaRouter dsiMediaRouter;

    public SdisCmdSetAudioRouteA2LS(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter) {
        super(audioEnv.lcSDIS, "SdisCmdSetAudioRouteA2LS");
        this.dsiMediaRouter = dSIMediaRouter;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SdisCmdSetAudioRouteA2LS.execute] -> DSIMediaRouter.setAudioRoutes() VIRTUALCHANNEL_A2LS PHYSICALCHANNEL_MPL1");
        this.dsiMediaRouter.setAudioRoutes(A2LS_ROUTE);
        this.commandList.commandFinished();
    }
}

