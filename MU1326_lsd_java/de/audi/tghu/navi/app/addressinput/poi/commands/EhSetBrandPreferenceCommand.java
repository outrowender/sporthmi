/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class EhSetBrandPreferenceCommand
extends NavCommand {
    private final int mapStyleType;
    private final int[] brandUid;
    private final boolean[] preference;

    public EhSetBrandPreferenceCommand(int n, int[] nArray, boolean[] blArray) {
        this.mapStyleType = n;
        this.brandUid = nArray;
        this.preference = blArray;
    }

    public void execute() {
        this.logger.log(1000000, "EhSetBrandPreferenceCommand#execute() - calling ehSetBrandPreference() mapStyle = %1, brandUid = %2, preference = %3", (Object)String.valueOf(this.mapStyleType), (Object)this.brandUid, (Object)this.preference);
        this.getDSINavigation().ehSetBrandPreference(this.mapStyleType, this.brandUid, this.preference);
    }

    public void ehResult(int n, int n2) {
        this.logger.log(1000000, "EhSetBrandPreferenceCommand#ehResult( %1, %2 )", (long)n, (long)n2);
        if (n2 == 0) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted(n2);
        }
    }
}

