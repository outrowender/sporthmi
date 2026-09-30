/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.kr.listener.AbstractAddressInputListenerKR;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;
import de.audi.tghu.navi.app.li.SpellerStack;

public class AddressInputTownStreetScreenListenerKR
extends AbstractAddressInputListenerKR {
    private static final int townStreetNeedsVillageStreet = 401726;

    public AddressInputTownStreetScreenListenerKR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputTownStreetSequence addressInputTownStreetSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputTownStreetSequence, n, n2, n3);
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected - item selected was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 40502);
        }
        if (commandList != null) {
            if (AddressInputUtilEvo.isInPOIRelatedContext(this.env)) {
                commandList.add(new NavCommand("start poi with search context"){

                    public void execute() {
                        this.env.getChoiceModel(401726).setValue(0);
                        AddressInputTownStreetScreenListenerKR.this.inputManager.getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
                        this.getCommandList().commandFinished();
                    }
                });
                this.addFireModelEventCommand(n, n4, commandList);
            } else {
                commandList.add(new NavCommand(){

                    public void execute() {
                        CommandList commandList = AddressInputTownStreetScreenListenerKR.this.commandListFactory.createCommandList();
                        if (this.env.getChoiceModel(401726).getValue() == 1) {
                            AddressInputTownStreetScreenListenerKR.this.addFireModelEventCommand(n, n4, commandList);
                            commandList.add(AddressInputTownStreetScreenListenerKR.this.inputManager.handleAddressInputEvent(AddressInputTownStreetScreenListenerKR.this.commandListFactory.createCommandList(), 40603));
                        } else if (this.env.getChoiceModel(401726).getValue() == 0) {
                            AddressInputTownStreetScreenListenerKR.this.addFireModelEventCommand(n, n4, commandList);
                            SpellerStack.getInstance().pop();
                        }
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    }
                });
            }
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    private void addFireModelEventCommand(final int n, final int n2, ICommandList iCommandList) {
        iCommandList.add(new NavCommand("Delay fire model event"){

            public void execute() {
                this.env.fireModelEvent(n, n2);
                this.getCommandList().commandFinished();
            }
        });
    }
}

