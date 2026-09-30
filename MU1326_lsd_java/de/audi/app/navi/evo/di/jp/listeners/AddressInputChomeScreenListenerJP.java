/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.jp.listeners;

import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.app.navi.evo.di.jp.listeners.AbstractAddressInputListenerJP;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToPOIOnlineSearchSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;

public class AddressInputChomeScreenListenerJP
extends AbstractAddressInputListenerJP
implements TiledListModelListener,
MenuModelListener {
    private final ChoiceModelApp housenumberAvailable;

    public AddressInputChomeScreenListenerJP(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputChomeSequence addressInputChomeSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputChomeSequence, n, n2, n3);
        this.initListeners();
        this.housenumberAvailable = navigationEnv.getChoiceModel(DIScreensEvo.getDiJpChomeNeedsNumberChoice());
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
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        final int n5 = this.inputManager.getActiveSpellerContextId();
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AILIVLELR", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 20502);
        }
        if (commandList != null) {
            commandList.add(new NavCommand("Add post command list based on if number is available"){

                public void execute() {
                    if (AddressInputChomeScreenListenerJP.this.housenumberAvailable.getValue() == 1) {
                        AddressInputChomeScreenListenerJP.this.addFireModelEventCommand(n, n4, this.getCommandList());
                        this.getCommandList().commandFinishedWithPostSequence(AddressInputChomeScreenListenerJP.this.inputManager.handleAddressInputEvent(AddressInputChomeScreenListenerJP.this.commandListFactory.createCommandList(), 20804));
                    } else {
                        CommandList commandList = AddressInputChomeScreenListenerJP.this.commandListFactory.createCommandList();
                        if (AddressInputUtilEvo.isOnlinePOIContext(this.env) && n5 == 96) {
                            this.logger.log(10000000, "%1#itemSelected - in online POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                            commandList.add(new ReturnNavLocationToPOIOnlineSearchSequence(AddressInputChomeScreenListenerJP.this.commandListFactory).getStartCommandList());
                            AddressInputChomeScreenListenerJP.this.addFireModelEventCommand(n, n4, commandList);
                        } else if (AddressInputUtilEvo.isNormalPOIContext(this.env)) {
                            this.logger.log(10000000, "%1#itemSelected - in normal POI new area set, finish new area setting.", (Object)this.CLASS_NAME);
                            AddressInputChomeScreenListenerJP.this.addFireModelEventCommand(n, n4, commandList);
                            commandList.add(new NavCommand(){

                                public void execute() {
                                    AddressInputChomeScreenListenerJP.this.inputManager.getPoiService().startPoiWithSearchContext(4, this.dsiResponseContainer.getLiCurrentLD(), true);
                                    this.getCommandList().commandFinished();
                                }
                            });
                        } else {
                            this.logger.log(10000000, "%1#itemSelected - in address input context.", (Object)this.CLASS_NAME);
                            AddressInputChomeScreenListenerJP.this.addFireModelEventCommand(n, n4, commandList);
                        }
                        this.getCommandList().commandFinishedWithPostSequence(commandList);
                    }
                }
            });
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

