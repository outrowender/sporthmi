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
        this.setName(new StringBuffer().append("SdisCmdChangeFrontLastMode: ").append(this.contextLabel).toString());
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[SdisCmdChangeFrontLastMode.execute] %1", (Object)this.contextLabel);
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
                    throw new IllegalArgumentException(new StringBuffer().append("Unexpected audio context: ").append(this.context).toString());
                }
            }
            if (this.lastmodeHandler.isValidLastmode(n)) {
                this.lastmodeHandler.setLastmode(0, n, true);
            } else {
                this.logger.log(-2137614336, new StringBuffer().append("[SdisCmdChangeFrontLastMode.execute] Invalid last mode: ").append(n).toString());
            }
            this.commandList.commandFinished();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            this.commandList.commandAborted(illegalArgumentException);
        }
    }
}

