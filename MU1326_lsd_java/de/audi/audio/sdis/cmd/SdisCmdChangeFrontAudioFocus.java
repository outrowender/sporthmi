/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.IAudioFocusManager;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisLabels;
import de.audi.tghu.command.Command;

public class SdisCmdChangeFrontAudioFocus
extends Command {
    private final IAudioFocusManager audioFocusManager;
    private final int context;
    private final String contextLabel;

    public SdisCmdChangeFrontAudioFocus(AudioEnv audioEnv, IAudioFocusManager iAudioFocusManager, int n) {
        super(audioEnv.lcSDIS);
        this.audioFocusManager = iAudioFocusManager;
        this.context = n;
        this.contextLabel = SdisLabels.getContext(n);
        this.setName("SDISCmdChangeFrontAudioFocus: " + this.contextLabel);
    }

    public void execute() {
        this.logger.log(10000000, "[SDISCmdChangeFrontAudioFocus.execute] %1", (Object)this.contextLabel);
        try {
            switch (this.context) {
                case 2: {
                    this.audioFocusManager.setActiveAudioApp(0, 1);
                    break;
                }
                case 3: {
                    this.audioFocusManager.setActiveAudioApp(0, 2);
                    break;
                }
                case 0: {
                    this.audioFocusManager.setActiveAudioApp(0, 0);
                    break;
                }
                case 4: {
                    this.audioFocusManager.setActiveAudioApp(0, 38);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unexpected audio context: " + this.context);
                }
            }
            this.commandList.commandFinished();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.commandList.commandAborted(illegalArgumentException);
        }
    }
}

