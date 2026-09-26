/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.sdis.SdisAudioHandler;
import de.audi.audio.sdis.SdisAudioHandler$1;
import de.audi.audio.sdis.cmd.SdisCmdStreamRegister;
import de.audi.audio.sdis.cmd.SdisCmdStreamRequestConf;
import de.audi.audio.sdis.cmd.SdisCmdStreamStart;
import de.audi.audio.sdis.cmd.SdisCmdStreamStop;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouterListener;

class SdisAudioHandler$DSIMediaRouterListenerImpl
implements DSIMediaRouterListener {
    private final /* synthetic */ SdisAudioHandler this$0;

    private SdisAudioHandler$DSIMediaRouterListenerImpl(SdisAudioHandler sdisAudioHandler) {
        this.this$0 = sdisAudioHandler;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[DSIMediaRouterListenerImpl.asyncException] errorMsg:%1 errorCode:%2 requestType:%3", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void responseConfiguration(int n, int n2) {
        if (n2 == 0) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[DSIMediaRouterListenerImpl.responseConfiguration] clientID:%1 result:OK(%2)", (long)n, (long)n2);
        } else {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-1601830656, "[DSIMediaRouterListenerImpl.responseConfiguration] clientID:%1 result:NOK(%2)", (long)n, (long)n2);
        }
        Command command = SdisAudioHandler.access$1600(this.this$0);
        if (command instanceof SdisCmdStreamRequestConf) {
            ((SdisCmdStreamRequestConf)command).responseConfiguration(n, n2);
        }
    }

    @Override
    public void responseClientStatus(int n, int n2) {
        int n3;
        String string;
        switch (n2) {
            case 4: {
                string = "DEREGISTRATION_FAILED";
                n3 = -1601830656;
                break;
            }
            case 3: {
                string = "DEREGISTRATION_SUCCESS";
                n3 = -2137614336;
                break;
            }
            case 2: {
                string = "REGISTRATION_FAILED";
                n3 = -1601830656;
                break;
            }
            case 1: {
                string = "REGISTRATION_SUCCESS";
                n3 = -2137614336;
                break;
            }
            default: {
                string = "UNKNOWN";
                n3 = -1601830656;
            }
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(n3, "[DSIMediaRouterListenerImpl.responseClientStatus] clientID:%3 status:%1(%2)", (Object)string, (long)n2, (long)n);
        Command command = SdisAudioHandler.access$1600(this.this$0);
        if (command instanceof SdisCmdStreamRegister) {
            ((SdisCmdStreamRegister)command).responseClientStatus(n, n2);
        }
    }

    @Override
    public void updateStreamingStatus(int n, int n2, int n3) {
        int n4;
        String string;
        if (n3 != 1) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(1078071040, "[DSIMediaRouterListenerImpl.updateStreamingStatus] INVALID clientID:%1 status:%2 valid:%3", (long)n, (long)n2, (long)n3);
            return;
        }
        switch (n2) {
            case 1: {
                string = "STARTED";
                n4 = -2137614336;
                break;
            }
            case 2: {
                string = "STOPPED";
                n4 = -2137614336;
                break;
            }
            case 3: {
                string = "STOPPED_WITH_ERROR";
                n4 = -1601830656;
                break;
            }
            default: {
                string = "UNKNOWN";
                n4 = -1601830656;
            }
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(n4, "[DSIMediaRouterListenerImpl.updateStreamingStatus] clientID:%3 status:%1(%2)", (Object)string, (long)n2, (long)n);
        Command command = SdisAudioHandler.access$1600(this.this$0);
        if (command instanceof SdisCmdStreamStart) {
            ((SdisCmdStreamStart)command).updateStreamingStatus(n, n2);
        } else if (command instanceof SdisCmdStreamStop) {
            ((SdisCmdStreamStop)command).updateStreamingStatus(n, n2);
        }
    }

    @Override
    public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
        if (n != 1 || audioRouteArray == null) {
            SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(1078071040, "[DSIMediaRouterListenerImpl.updateActiveAudioRoutes] INVALID valid:%1", (long)n);
            return;
        }
        for (int i2 = 0; i2 < audioRouteArray.length; ++i2) {
            AudioRoute audioRoute = audioRouteArray[i2];
            if (audioRoute == null || audioRoute.routingOutput != 1) continue;
            SdisAudioHandler.access$700((SdisAudioHandler)this.this$0).routingInput = audioRoute.routingInput;
            break;
        }
        SdisAudioHandler.access$200((SdisAudioHandler)this.this$0).lcSDIS.log(-2137614336, "[DSIMediaRouterListenerImpl.updateActiveAudioRoutes] currentAudioRoute:%1", (Object)SdisAudioHandler.access$700(this.this$0));
    }

    /* synthetic */ SdisAudioHandler$DSIMediaRouterListenerImpl(SdisAudioHandler sdisAudioHandler, SdisAudioHandler$1 sdisAudioHandler$1) {
        this(sdisAudioHandler);
    }
}

