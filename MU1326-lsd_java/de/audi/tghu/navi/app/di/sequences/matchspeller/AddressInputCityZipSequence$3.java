/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputCityZipSequence$3
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ AddressInputCityZipSequence this$0;

    AddressInputCityZipSequence$3(AddressInputCityZipSequence addressInputCityZipSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = addressInputCityZipSequence;
        this.val$previewMap = iPreviewMap;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("NavLocation from History");
        if (object == null || !(object instanceof NavLocation)) {
            this.getCommandList().commandAborted("unexpected Object");
        } else {
            NavLocation navLocation = (NavLocation)object;
            this.val$previewMap.setPreviewLocationCity(navLocation, 1, null, null);
            this.getCommandList().commandFinished();
        }
    }
}

