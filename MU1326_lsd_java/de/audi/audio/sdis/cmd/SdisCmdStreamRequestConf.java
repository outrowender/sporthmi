/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisLabels;
import de.audi.audio.sdis.SdisStreamState;
import de.audi.tghu.command.Command;
import org.dsi.ifc.media.DSIMediaRouter;

public class SdisCmdStreamRequestConf
extends Command {
    public static final int MEDIA_SOURCE_INTERNAL = 0;
    public static final int MEDIA_SOURCE_EXTERNAL_AUDIO_VIDEO = 1;
    public static final int MEDIA_SOURCE_EXTERNAL_AUDIO_ONLY = 2;
    private final String STREAMING_USE_JOINT_MODE;
    private static final int JOINT_MODE = 1;
    private static final int REMOTE_MODE = 0;
    private final DSIMediaRouter dsiMediaRouter;
    private final int clientID;
    private final AudioEnv env;
    private SdisStreamState streamState;
    private final int context;
    private int mediasource;
    private final String contextLabel;
    private int audioSource;
    private int videoSource;
    private int sink;
    private int mode;

    public SdisCmdStreamRequestConf(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n, int n2, SdisStreamState sdisStreamState) {
        this(audioEnv, dSIMediaRouter, n, n2, 0, sdisStreamState);
    }

    public SdisCmdStreamRequestConf(AudioEnv audioEnv, DSIMediaRouter dSIMediaRouter, int n, int n2, int n3, SdisStreamState sdisStreamState) {
        super(audioEnv.lcSDIS);
        this.STREAMING_USE_JOINT_MODE = "SDISStreamingMode";
        this.env = audioEnv;
        this.dsiMediaRouter = dSIMediaRouter;
        this.clientID = n;
        this.context = n2;
        this.contextLabel = SdisLabels.getContext(n2);
        this.mediasource = n3;
        this.setName("SdisCmdStreamRequestConf: " + this.contextLabel);
        this.streamState = sdisStreamState;
        this.computeConfiguration();
        this.streamState.setRequiredMediaRouterConfig(this.audioSource, this.videoSource, this.sink);
    }

    private void computeConfiguration() {
        this.mode = this.getMode();
        switch (this.context) {
            case 2: {
                this.audioSource = 2;
                this.videoSource = 0;
                this.sink = this.mode;
                break;
            }
            case 4: {
                this.audioSource = 2;
                this.videoSource = 2;
                this.sink = this.mode;
                break;
            }
            case 3: {
                if (this.mediasource == 0) {
                    this.audioSource = 1;
                    this.videoSource = 1;
                } else if (this.mediasource == 1) {
                    this.audioSource = 2;
                    this.videoSource = 2;
                } else {
                    this.audioSource = 2;
                    this.videoSource = 0;
                }
                this.sink = this.mode;
                break;
            }
            case 1: {
                this.audioSource = 3;
                this.videoSource = 0;
                this.sink = 1;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid context " + this.context);
            }
        }
    }

    public void execute() {
        if (this.streamState.reconfigureMediaRouterNecessary()) {
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.execute] -> DSIMediaRouter.requestConfiguration()");
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.execute] -> clientID:%1", (long)this.clientID);
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.execute] -> audioSource:%1 videoSource:%2 sink:0b%3", (long)this.audioSource, (long)this.videoSource, (long)this.sink);
            this.streamState.setRequestedMediaRouterConfig(this.audioSource, this.videoSource, this.sink);
            this.dsiMediaRouter.requestConfiguration(this.clientID, this.audioSource, this.videoSource, this.sink);
        } else {
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.execute] -> No reconfiguration of the media router necessary.");
            this.commandList.commandFinished();
        }
    }

    public void responseConfiguration(int n, int n2) {
        if (n != this.clientID) {
            this.logger.log(100000, "[SdisCmdStreamRequestConf.responseConfiguration] ClientID mismatch %1 vs. %2", (long)this.clientID, (long)n);
            return;
        }
        if (n2 == 0) {
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.responseConfiguration] OK(%1) -> finish command", (long)n2);
            this.commandList.commandFinished();
        } else {
            this.logger.log(100000, "[SdisCmdStreamRequestConf.responseConfiguration] NOK(%1) -> abort command", (long)n2);
            this.commandList.commandAborted("Configuration result NOK!");
        }
    }

    private int getMode() {
        int n;
        Integer n2 = this.env.getIntegerVMOption("SDISStreamingMode");
        if (n2 == null) {
            this.logger.log(100000, "[SdisCmdStreamRequestConf.getMode] wrong mode VMOPTION %1 must not be unset -> set default", (Object)"SDISStreamingMode");
            return 3;
        }
        try {
            n = n2;
        }
        catch (Exception exception) {
            this.logger.log(100000, "[SdisCmdStreamRequestConf.getMode] wrong mode: VMOPTION %1 must not be unset but set to JOINT_MODE or REMOTE_MODE -> set default", (Object)"SDISStreamingMode");
            n = 2;
        }
        if (n == 1) {
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.getMode] JOINT_MODE active");
            return 3;
        }
        if (n == 0) {
            this.logger.log(10000000, "[SdisCmdStreamRequestConf.getMode] REMOTE_MODE active");
            return 2;
        }
        this.logger.log(100000, "[SdisCmdStreamRequestConf.getMode] wrong mode %1 must be JOINT_MODE or REMOTE_MODE -> set default", (Object)"SDISStreamingMode");
        return 2;
    }
}

