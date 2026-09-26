/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

class MapcodeInputSequence$14
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$14(MapcodeInputSequence mapcodeInputSequence, String string) {
        this.this$0 = mapcodeInputSequence;
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
                MapcodeInputSequence.access$300(this.this$0).log(-2137614336, "LIValueListElement from south side contains invalid Geographic information, setSelectedLocation to null");
                this.dsiResponseContainer.setSelectedLocation(null);
                this.getCommandList().commandFinished();
            }
        } else {
            MapcodeInputSequence.access$300(this.this$0).log(-2137614336, "LIValueList from south side is empty or invalid, setSelectedLocation to null");
            this.dsiResponseContainer.setSelectedLocation(null);
            this.getCommandList().commandFinished();
        }
    }
}

