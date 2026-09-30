/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.LISPGetLocationFromLIValueListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPSelectListItemCommand;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectListItemByIdent;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.UnrequestItemsCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.nospeller.IAddressInputNoSpellerSequence;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class AbstractAddressInputNoSpellerSequence
implements IAddressInputNoSpellerSequence {
    protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    protected final IAddressInputManager inputManager;
    protected final ICommandListFactory commandListFactory;
    protected final NavigationEnv env;
    protected final IMatchspellerModelAccess modelAccess;
    protected final IPreviewMap previewMap;
    protected final LogChannel logChannel;
    protected final SpellerStack spellerStack;
    private final int selCritDes;

    public AbstractAddressInputNoSpellerSequence(int n, IAddressInputManager iAddressInputManager, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack) {
        this.selCritDes = n;
        this.commandListFactory = iCommandListFactory;
        this.env = navigationEnv;
        this.modelAccess = iMatchspellerModelAccess;
        this.previewMap = iPreviewMap;
        this.spellerStack = spellerStack;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.inputManager = iAddressInputManager;
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LIStartSpellerCommand(this.selCritDes, false, false, false));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        return commandList;
    }

    public CommandList getSelectListElementCommandList(LIValueListElement lIValueListElement) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISPSelectListItemCommand(lIValueListElement.getListIndex()));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, 1, null, null));
        }
        return commandList;
    }

    public CommandList getSelectElementByIdentifierCommandList(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LispSelectListItemByIdent(string));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        return commandList;
    }

    public void requestNextResultListWindow(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPRequestValueListByListIndexCommand(n, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
    }

    public void unrequestItems(int n, int n2) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new UnrequestItemsCommand(n, n2, this.modelAccess));
        commandList.execute(this.CLASS_NAME + "#unrequestItems");
    }

    public void checkIfElementIsAmbiguous(LIValueListElement lIValueListElement, final Command command) {
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new LISPGetLocationFromLIValueListElementCommand(lIValueListElement));
        commandList.add(new NavCommand("Get NavLocation from Response Container"){

            public void execute() {
                NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
                this.logger.log(10000000, "Get NavLocation from Response Container - location=%1", (Object)navLocation);
                this.getCommandList().put("LocationToTest", navLocation);
                this.getCommandList().commandFinishedWithPostCommand(command);
            }
        });
        commandList.execute(this.CLASS_NAME + "#createCheckIfStreetIsAmbiguousCommandList");
    }
}

