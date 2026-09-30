/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis.cmd;

import de.audi.atip.audio.AudioConnection;
import de.audi.audio.AudioEnv;
import de.audi.audio.store.ConnectionStore;
import de.audi.tghu.command.Command;

public class SdisCmdWaitForAudible
extends Command {
    private final int[] connections;

    public SdisCmdWaitForAudible(AudioEnv audioEnv, int n) {
        this(audioEnv, new int[]{n});
    }

    public SdisCmdWaitForAudible(AudioEnv audioEnv, int[] nArray) {
        super(audioEnv.lcSDIS, "SdisCmdWaitForAudible");
        this.connections = nArray;
    }

    public void execute() {
        for (int i2 = 0; i2 < this.connections.length; ++i2) {
            int n = this.connections[i2];
            int n2 = ConnectionStore.INSTANCE.getStatus(n, 2);
            this.logger.log(10000000, "[SdisCmdWaitForAudible.execute] AC:%1, status:%2", (long)n, (long)n2);
            if (n2 != 5 && n2 != 4 && n2 != 0) continue;
            this.finishCmd(n);
        }
    }

    public void finishCmd(int n) {
        if (AudioConnection.contains(this.connections, n)) {
            this.logger.log(10000000, "[SdisCmdWaitForAudible.finishCmd] AC:%1", (long)n);
            this.commandList.commandFinished();
        } else {
            this.logger.log(10000000, "[SdisCmdWaitForAudible.finishCmd] AC:%1 is not a valid connection", (long)n);
        }
    }
}

