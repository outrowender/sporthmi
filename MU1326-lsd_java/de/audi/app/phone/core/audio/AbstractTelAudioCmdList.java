/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.TelReleaseConnectionCmd;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import java.util.ArrayList;

abstract class AbstractTelAudioCmdList
extends CommandList {
    private static int[] relevantTelephoneAudioConnectionsForRelease = new int[]{104, 106, 99, 102, 110, 111, 103, 98, 87, 136, 137};
    protected final LogChannel log;
    protected final HMIAudioService audioService;

    protected static int[] getAudioConnectionsToRelease(int[] nArray) {
        int n;
        ArrayList arrayList = new ArrayList(relevantTelephoneAudioConnectionsForRelease.length);
        if (nArray != null) {
            for (int i2 = 0; i2 < relevantTelephoneAudioConnectionsForRelease.length; ++i2) {
                n = relevantTelephoneAudioConnectionsForRelease[i2];
                boolean bl = true;
                for (int i3 = 0; i3 < nArray.length; ++i3) {
                    if (nArray[i3] != n) continue;
                    bl = false;
                }
                if (!bl) continue;
                arrayList.add(new Integer(n));
            }
        }
        int[] nArray2 = new int[arrayList.size()];
        for (n = 0; n < nArray2.length; ++n) {
            nArray2[n] = (Integer)arrayList.get(n);
        }
        return nArray2;
    }

    public AbstractTelAudioCmdList(CommandListManager commandListManager, LogChannel logChannel, HMIAudioService hMIAudioService) {
        super(commandListManager);
        this.log = logChannel;
        this.audioService = hMIAudioService;
    }

    protected void addReleaseConnectionCommands(int[] nArray) {
        if (nArray == null) {
            this.log.log(10000, "AbstractTelAudioCmdList#addReleaseConnectionCommands connectionsToRelease is null");
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.add(new TelReleaseConnectionCmd(this.log, nArray[i2], this.audioService));
        }
    }
}

