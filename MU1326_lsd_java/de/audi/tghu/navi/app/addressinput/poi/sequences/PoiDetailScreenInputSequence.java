/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiManager;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiDetailScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractPoiScreenInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiDetailScreenInputSequence
extends AbstractPoiScreenInputSequence {
    private final IPoiDetailScreenModelAccess modelAccess;
    private final IPreviewMap previewMapInterface;

    public PoiDetailScreenInputSequence(IPoiDetailScreenModelAccess iPoiDetailScreenModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, SpellerStack spellerStack, IPreviewMap iPreviewMap, IPoiManager iPoiManager) {
        super(iCommandListFactory, poiSearchArea, navigationEnv, spellerStack, new SpellerContext(18), iPoiManager);
        this.modelAccess = iPoiDetailScreenModelAccess;
        this.previewMapInterface = iPreviewMap;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new PoiModelStartCommand(this.modelAccess));
        commandList.add(new NavCommand("SelectListItem with Element from CommandListContext"){

            public void execute() {
                this.getCommandList().commandFinishedWithPostCommand(new LISPSelectListItemCommand(((LIValueListElement)this.getCommandList().get("CurrentSelection")).getListIndex()));
            }
        });
        commandList.add(new NavCommand("Model onUpdateLocation"){

            public void execute() {
                PoiDetailScreenInputSequence.this.modelAccess.onUpdateLocation(this.dsiResponseContainer.getLiCurrentLD());
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand(new StringBuffer().append(this.CLASS_NAME).append(" - Setting preview map").toString()){

            public void execute() {
                PoiDetailScreenInputSequence.this.previewMapInterface.setPreviewPOIsOnboard(new NavLocation[]{this.dsiResponseContainer.getLiCurrentLD()}, 1, null, null);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartGuidanceCommandList() {
        return this.commandListFactory.createCommandList();
    }
}

