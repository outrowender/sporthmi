/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdSetAudioRouteMedia
extends Command {
    private static AudioRoute[] mediaRoute = new AudioRoute[]{new AudioRoute(1, 1, 0)};
    private final DSIMediaRouter dsiMediaRouter;
    private ChoiceModelApp smartphoneChoice;

    public SdisCmdSetAudioRouteMedia(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, AudioRoute audioRoute) {
        super(audioEnv.lcSDIS, "SdisCmdSetAudioRouteMedia");
        this.dsiMediaRouter = dSIMediaRouter;
        this.smartphoneChoice = audioEnv.framework.getHMIService().getChoiceModel(4451);
    }

    @Override
    public void execute() {
        int n = this.smartphoneChoice.getValue();
        this.logger.log(-2137614336, "[SdisCmdSetAudioRouteMedia.execute] smartphoneEntertainmentSource: %1", (long)n);
        switch (n) {
            case 1: {
                SdisCmdSetAudioRouteMedia.mediaRoute[0] = new AudioRoute(4, 1, 0);
                break;
            }
            case 2: {
                SdisCmdSetAudioRouteMedia.mediaRoute[0] = new AudioRoute(5, 1, 0);
                break;
            }
            case 3: {
                SdisCmdSetAudioRouteMedia.mediaRoute[0] = new AudioRoute(4, 1, 0);
                break;
            }
            default: {
                SdisCmdSetAudioRouteMedia.mediaRoute[0] = new AudioRoute(1, 1, 0);
            }
        }
        this.logger.log(-2137614336, "[SdisCmdSetAudioRouteMedia.execute] -> DSIMediaRouter.setAudioRoutes() VIRTUALCHANNEL_MEDIA PHYSICALCHANNEL_MPL1");
        this.dsiMediaRouter.setAudioRoutes(mediaRoute);
        this.commandList.commandFinished();
    }
}

