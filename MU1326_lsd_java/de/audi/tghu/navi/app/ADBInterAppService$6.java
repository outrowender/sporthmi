/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class ADBInterAppService$6
extends NavCommand {
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$6(ADBInterAppService aDBInterAppService) {
        this.this$0 = aDBInterAppService;
    }

    @Override
    public void execute() {
        if (this.env.getChoiceModel(-249690624).getValue() == 0) {
            ADBInterAppService.access$400(this.this$0).log(-2137614336, "%1#focusPreviewMap() - No valid TryBestMatchResult found!", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinished();
        } else {
            this.env.getChoiceModel(4078).setValue(1);
            try {
                NavLocation navLocation = this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation();
                GuiTooltipInformationContainer guiTooltipInformationContainer = null;
                if (this.this$0.guiModelAccessDetails != null) {
                    guiTooltipInformationContainer = this.this$0.guiModelAccessDetails.createMapTooltipInformationContainer(navLocation, "");
                }
                ADBInterAppService.access$700(this.this$0).getPreviewMap().setPreviewAddressBookEntry(navLocation, 10, this.this$0.guiModelAccessDetails, guiTooltipInformationContainer);
            }
            catch (Exception exception) {
                ADBInterAppService.access$400(this.this$0).log(10000, "%1#focusPreviewMap() - ERROR=%2", (Object)this.CLASS_NAME, (Throwable)exception);
                exception.printStackTrace();
            }
            this.getCommandList().commandFinished();
        }
    }
}

