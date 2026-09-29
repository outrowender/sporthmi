/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.disambiguation.LocationDisambiguatorSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class LocationDisambiguatorSequence$4
extends NavCommand {
    private final /* synthetic */ LocationDisambiguatorSequence this$0;

    LocationDisambiguatorSequence$4(LocationDisambiguatorSequence locationDisambiguatorSequence, String string) {
        this.this$0 = locationDisambiguatorSequence;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.env.getContainer().getLispValueList();
        if (Util.isListValid(lIValueList) && lIValueList.getList().length == 1) {
            LIValueListElement lIValueListElement = lIValueList.getList()[0];
            if (lIValueListElement.validDestination && lIValueListElement.latitude != 0 && lIValueListElement.longitude != 0) {
                this.getCommandList().commandFinishedWithPostCommand(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
            } else {
                this.dsiResponseContainer.setSelectedLocation(null);
                this.getCommandList().commandAborted("LIValueListElement from south side contains invalid Geographic information, setSelectedLocation to null");
            }
        } else {
            this.dsiResponseContainer.setSelectedLocation(null);
            this.getCommandList().commandAborted("LIValueList from south side is empty or invalid, setSelectedLocation to null");
        }
    }
}

