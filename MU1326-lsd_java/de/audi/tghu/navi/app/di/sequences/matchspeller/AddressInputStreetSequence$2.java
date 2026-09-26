/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequence$2
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ AddressInputStreetSequence this$0;

    AddressInputStreetSequence$2(AddressInputStreetSequence addressInputStreetSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = addressInputStreetSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("STREET_HISTORY_ENTRY_LOCATION");
        if (object == null || !(object instanceof NavLocation)) {
            this.getCommandList().commandAborted("unexpected Object");
        } else {
            NavLocation navLocation = (NavLocation)object;
            this.val$previewMap.setPreviewLocationAroundReferencePoint(navLocation, null, 1, null, null);
            this.getCommandList().commandFinished();
        }
    }
}

