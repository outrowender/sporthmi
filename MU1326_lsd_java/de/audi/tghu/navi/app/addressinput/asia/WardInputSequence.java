/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.asia;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.asia.AbstractMatchspellerInputSequenceAsia;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class WardInputSequence
extends AbstractMatchspellerInputSequenceAsia {
    private final NaviServiceListener naviServiceListener;

    public WardInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, SpellerStack spellerStack, ICommandListFactory iCommandListFactory, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap, NaviServiceListener naviServiceListener) {
        super(iMatchspellerModelAccess, spellerStack, iCommandListFactory, iAddressInputForm, iPreviewMap);
        this.naviServiceListener = naviServiceListener;
    }

    protected NavCommand getStartSpellerCommand() {
        return new LIStartSpellerCommand(152, false, false, false);
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new NavCommand("Check if ward was selected or if southside removed the ward"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
                if (Util.isEmpty(Util.getLocationAccessor(navLocation).getWard())) {
                    this.getCommandList().commandFinishedWithPostCommand(new NotifySDSCommand(WardInputSequence.this.naviServiceListener){

                        public void call() {
                            this.getCommandList().put("[SDS_Command_List_Invalid]", new Boolean(true));
                            this.getCommandList().commandFinished();
                        }
                    });
                } else {
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.addressInputForm));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        return commandList;
    }
}

