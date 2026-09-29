/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import org.dsi.ifc.global.NavLocation;

class AddressInputProvinceSequenceAsia$4
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ AddressInputProvinceSequenceAsia this$0;

    AddressInputProvinceSequenceAsia$4(AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia, String string, IPreviewMap iPreviewMap) {
        this.this$0 = addressInputProvinceSequenceAsia;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object instanceof NavLocation) {
            NavLocation navLocation = (NavLocation)object;
            this.val$previewMap.setPreviewLocationCity(navLocation, 1, null, null);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("unexpected Object");
        }
    }
}

