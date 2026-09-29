/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR$3;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceNAR$3$1
extends NavCommand {
    private final /* synthetic */ Object val$object;
    private final /* synthetic */ AddressInputStreetSequenceNAR$3 this$1;

    AddressInputStreetSequenceNAR$3$1(AddressInputStreetSequenceNAR$3 addressInputStreetSequenceNAR$3, String string, Object object) {
        this.this$1 = addressInputStreetSequenceNAR$3;
        this.val$object = object;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().lispSelectItemFromLocation((NavLocation)this.val$object);
    }

    @Override
    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(-2137614336, "LispSelectItemFromLocationCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2, usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        if (l != 0L) {
            this.getCommandList().commandAborted(l);
            return;
        }
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.getCommandList().commandFinished();
    }
}

