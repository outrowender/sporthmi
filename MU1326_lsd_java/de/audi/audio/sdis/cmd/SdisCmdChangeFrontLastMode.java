/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.start.ILastmodeHandler;
import de.audi.audio.AudioEnv;
import de.audi.audio.sdis.SdisLabels;
import de.audi.tghu.command.Command;

public class SdisCmdChangeFrontLastMode
extends Command {
    private ILastmodeHandler lastmodeHandler;
    private int context;
    private final String contextLabel;

    public SdisCmdChangeFrontLastMode(AudioEnv audioEnv, ILastmodeHandler iLastmodeHandler, int n) {
        super(audioEnv.lcSDIS);
        this.lastmodeHandler = iLastmodeHandler;
        this.context = n;
        this.contextLabel = SdisLabels.getContext(n);
        this.setName("SdisCmdChangeFrontLastMode: " + this.contextLabel);
    }

    public void execute() {
        this.logger.log(10000000, "[SdisCmdChangeFrontLastMode.execute] %1", (Object)this.contextLabel);
        int n = 0;
        try {
            switch (this.context) {
                case 2: {
                    n = 1;
                    break;
                }
                case 3: {
                    n = 2;
                    break;
                }
                case 4: {
                    n = 38;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unexpected audio context: " + this.context);
                }
            }
            if (this.lastmodeHandler.isValidLastmode(n)) {
                this.lastmodeHandler.setLastmode(0, n, true);
            } else {
                this.logger.log(10000000, "[SdisCmdChangeFrontLastMode.execute] Invalid last mode: " + n);
            }
            this.commandList.commandFinished();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.commandList.commandAborted(illegalArgumentException);
        }
    }
}

