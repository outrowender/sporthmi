/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;

public class SdisCmdSleep
extends Command {
    private final long millis;

    public SdisCmdSleep(AudioEnv audioEnv, long l) {
        super(audioEnv.lcSDIS, "SdisCmdSleep: " + l);
        this.millis = l;
    }

    public void execute() {
        try {
            Thread.sleep(this.millis);
            this.logger.log(1000000, "[SdisCmdSleep.execute] finish commandlist now");
            this.commandList.commandFinished();
        }
        catch (InterruptedException interruptedException) {
            this.commandList.commandAborted(interruptedException);
        }
    }
}

