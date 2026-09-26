/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class CityZipInputSimpleSequence$6
extends NavCommand {
    private final /* synthetic */ IPreviewMap val$previewMap;
    private final /* synthetic */ CityZipInputSimpleSequence this$0;

    CityZipInputSimpleSequence$6(CityZipInputSimpleSequence cityZipInputSimpleSequence, String string, IPreviewMap iPreviewMap) {
        this.this$0 = cityZipInputSimpleSequence;
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

