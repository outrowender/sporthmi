/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.commands.GetLastCityHistoryEntryCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPAddCharacterCommand;
import de.audi.tghu.navi.app.addressinput.commands.LISPRequestValueListByListIndexCommand;
import de.audi.tghu.navi.app.addressinput.commands.LispSelectItemFromLocation;
import de.audi.tghu.navi.app.addressinput.commands.ModelInputChangedCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelSelectListElementCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelStartCommand;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.command.LIGetStateCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSimpleSequence;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class AddressInputCityZipSequence
extends AddressInputCityZipSimpleSequence {
    public AddressInputCityZipSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory, int n) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory, n);
    }

    public AddressInputCityZipSequence(ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, IMatchspellerModelAccess iMatchspellerModelAccess, IPreviewMap iPreviewMap, SpellerStack spellerStack, IAddressInputManager iAddressInputManager, CityHistory cityHistory) {
        super(iCommandListFactory, navigationEnv, iMatchspellerModelAccess, iPreviewMap, spellerStack, iAddressInputManager, cityHistory);
    }

    public CommandList getStartCommandList() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new ModelStartCommand(this.modelAccess));
        commandList.add(new LISPCancelSpellerCommand());
        commandList.add(super.getStartCommandList());
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (this.previewMap != null) {
            commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        }
        return commandList;
    }

    public CommandList getSelectHistoryElementCommandList(LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("selectedElement", lICityHistoryEntry);
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new LispSelectItemFromLocation("NavLocation from History"));
        commandList.add(new ModelSelectListElementCommand(this.modelAccess));
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.previewMap, true, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.inputManager));
        return commandList;
    }

    public void addCharacter(String string, final int n, boolean bl) {
        CommandList commandList = this.commandListFactory.createCommandList();
        if (bl) {
            IAdditionalStateInfo iAdditionalStateInfo = new IAdditionalStateInfo(){

                public void gatherInfo() {
                }

                public void restoreBefore() {
                }

                public void restoreAfter() {
                    DSIResponseContainer dSIResponseContainer = AddressInputCityZipSequence.this.env.getContainer();
                    String string = dSIResponseContainer.getLispValidCharacters();
                    String string2 = dSIResponseContainer.getLispCurrentInput();
                    boolean bl = dSIResponseContainer.isLispIsFullMatch();
                    boolean bl2 = dSIResponseContainer.isLispIsUndoAvailable();
                    LIValueList lIValueList = dSIResponseContainer.getLispValueList();
                    long l = dSIResponseContainer.getLispValueListCount();
                    AddressInputCityZipSequence.this.modelAccess.onUpdateResultList(lIValueList, l, string2, bl, -1, 0);
                    AddressInputCityZipSequence.this.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
                }
            };
            commandList.add(new LIGetStateCommand(this.spellerStack, new IAdditionalStateInfo[]{iAdditionalStateInfo}, new SpellerContext(52)));
        }
        commandList.add(new LISPAddCharacterCommand(string));
        commandList.add(new ModelInputChangedCommand(this.modelAccess));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess));
        if (bl) {
            final int n2 = this.spellerStack.getActiveSC().getContextID();
            commandList.add(new NavCommand(this.CLASS_NAME + "#addCharacter - if single result select it immediately"){

                public void execute() {
                    if (this.dsiResponseContainer.getLispValueListCount() == 1L) {
                        LIValueListElement lIValueListElement = this.dsiResponseContainer.getLispValueList().getList()[0];
                        CommandList commandList = AddressInputCityZipSequence.this.getSelectListElementCommandList(lIValueListElement);
                        AddressInputCityZipSequence.this.sendLocationToOnline(this.env, n, 0, n2, commandList);
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputCityZipSequence.this.inputManager.handleAddressInputEvent(commandList, AddressInputCityZipSequence.this.inputManager.getAutoSelectLeftElementEventId()));
                        return;
                    }
                    AddressInputCityZipSequence.this.spellerStack.pop();
                    this.getCommandList().commandFinished();
                }
            });
        }
        commandList.execute(this.CLASS_NAME + "#addCharacter");
    }

    public void showHistoryLocationInPreviewMap(final IPreviewMap iPreviewMap, LICityHistoryEntry lICityHistoryEntry) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new GetLastCityHistoryEntryCommand(lICityHistoryEntry));
        commandList.add(new NavCommand("SetNavLocationForPreviewMap"){

            public void execute() {
                Object object = this.getCommandList().get("NavLocation from History");
                if (object == null || !(object instanceof NavLocation)) {
                    this.getCommandList().commandAborted("unexpected Object");
                } else {
                    NavLocation navLocation = (NavLocation)object;
                    iPreviewMap.setPreviewLocationCity(navLocation, 1, null, null);
                    this.getCommandList().commandFinished();
                }
            }
        });
        commandList.execute(this.CLASS_NAME + "#showHistoryLocationInPreviewMap");
    }

    public void requestNextResultListWindow(int n, int n2) {
        this.logChannel.log(10000000, "%1#requestNextResultListWindow(), anchorIndex = %2, requestID = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = this.commandListFactory.createCommandList(1);
        int n3 = 0;
        int n4 = 0;
        String string = this.env.getContainer().getLispCurrentInput();
        if (this.cityHistory != null && this.cityHistory.getMatchingLastCities(string) != null) {
            n3 = this.cityHistory.getMatchingLastCities(string).size();
        }
        n4 = n >= n3 ? n - n3 : n;
        commandList.add(new LISPRequestValueListByListIndexCommand(n4, true));
        commandList.add(new ModelUpdateSpellerAndResultListCommand(this.modelAccess, n2, n));
        commandList.execute(this.CLASS_NAME + "#requestNextResultListWindows");
    }
}

