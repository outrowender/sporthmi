/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence;
import org.dsi.ifc.global.NavLocation;

class LocationDisambiguatorSequence$6
extends NavCommand {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ LocationDisambiguatorSequence this$0;

    LocationDisambiguatorSequence$6(LocationDisambiguatorSequence locationDisambiguatorSequence, String string, int n) {
        this.this$0 = locationDisambiguatorSequence;
        this.val$index = n;
        super(string);
    }

    @Override
    public void execute() {
        try {
            NavLocation navLocation = this.dsiResponseContainer.getDisambiguatedNavLocations()[this.val$index].getLocation();
            this.this$0.logChannel.log(-2137614336, "%1#setLocationAsCurrentLdForSds() - set currentLD hard to the selected destination", (Object)this.CLASS_NAME);
            this.dsiResponseContainer.setLiCurrentState(navLocation, new int[0], new int[0]);
            this.getCommandList().commandFinished();
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.getCommandList().commandAborted("Invalid index provided for selecting the location!");
        }
    }
}

