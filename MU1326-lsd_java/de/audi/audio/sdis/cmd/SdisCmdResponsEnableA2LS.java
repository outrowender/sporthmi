/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.audio.AudioEnv;
import de.audi.tghu.command.Command;
import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;
import de.esolutions.fw.comm.core.method.MethodException;

public class SdisCmdResponsEnableA2LS
extends Command {
    private AudioEnv env;
    private ASIHMISyncAudioReply reply;

    public SdisCmdResponsEnableA2LS(AudioEnv audioEnv, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
        super(audioEnv.lcSDIS, "SdisCmdResponsEnableA2LS");
        this.env = audioEnv;
        this.reply = aSIHMISyncAudioReply;
    }

    @Override
    public void execute() {
        try {
            this.env.lcSDIS.log(-2137614336, "[SdisCmdResponsEnableA2LS.execute] reply: %1", (Object)this.reply);
            this.reply.responseEnableA2LS(0);
            this.getCommandList().commandFinished();
        }
        catch (MethodException methodException) {
            this.env.lcSDIS.log(-2137614336, "[SdisCmdResponsEnableA2LS.execute] Exception ", (Object)methodException.getMessage());
        }
    }
}

