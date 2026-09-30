/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.kr.listener;

import de.audi.app.navi.evo.addressinput.AddressInputHistoryElementListRow;
import de.audi.app.navi.evo.addressinput.AddressInputLIValueListElementListRow;
import de.audi.app.navi.evo.di.kr.listener.AbstractAddressInputListenerKR;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.IAddressInputManager;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequence;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class AddressInputCityScreenListenerKR
extends AbstractAddressInputListenerKR {
    private final int cityNeedsWard;
    private final int wardAvailable;
    private final int wardUnavailable;

    public AddressInputCityScreenListenerKR(NavigationEnv navigationEnv, IPreviewMap iPreviewMap, ICommandListFactory iCommandListFactory, IAddressInputManager iAddressInputManager, AddressInputCityZipSequence addressInputCityZipSequence, int n, int n2, int n3) {
        super(navigationEnv, iPreviewMap, iCommandListFactory, iAddressInputManager, addressInputCityZipSequence, n, n2, n3);
        this.cityNeedsWard = 402590;
        this.wardAvailable = 1;
        this.wardUnavailable = 0;
        this.initListeners();
    }

    protected void initListeners() {
        this.tiledListModel = this.env.getTiledListModel(this.tiledListModelId);
        this.tiledListModel.setListener(this);
        this.matchspellerModel = this.env.getMatchSpellerModel(this.matchSpellerModelId);
        this.matchspellerModel.setSpellerListenerAsia(this);
        this.menuModel = this.env.getMenuModel(this.menuModelId);
        this.menuModel.setListener(this);
    }

    public void itemSelected(EvoListRow evoListRow, final int n, int n2, int n3, final int n4) {
        this.logChannel.log(10000000, "%1#itemSelected row=%2, model=%3, index=%4", (Object)this.CLASS_NAME, (Object)evoListRow, (Object)Integer.toString(n), (long)n2);
        this.inputManager.getMainScreenListener().resetPreviousLocation();
        CommandList commandList = null;
        if (evoListRow instanceof AddressInputLIValueListElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputLIValueListElementListRow", (Object)this.CLASS_NAME);
            AddressInputLIValueListElementListRow addressInputLIValueListElementListRow = (AddressInputLIValueListElementListRow)evoListRow;
            commandList = this.inputManager.handleAddressInputEvent(this.inputSequence.getSelectListElementCommandList(addressInputLIValueListElementListRow.getElement()), 40202);
        } else if (evoListRow instanceof AddressInputHistoryElementListRow) {
            this.logChannel.log(10000000, "%1#itemSelected row is instanceOf AddressInputHistoryElementListRow", (Object)this.CLASS_NAME);
            AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
            CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
            commandList = this.inputManager.handleAddressInputEvent(((AddressInputCityZipSequence)this.inputSequence).getSelectHistoryElementCommandList((LICityHistoryEntry)historyEntry.getEntry()), 40203);
        }
        if (commandList != null) {
            commandList.add(new NavCommand(){

                public void execute() {
                    CommandList commandList = AddressInputCityScreenListenerKR.this.commandListFactory.createCommandList();
                    if (this.env.getChoiceModel(402590).getValue() == 1) {
                        commandList.add(new NavCommand("Delay fire model event"){

                            public void execute() {
                                this.env.fireModelEvent(n, n4);
                                this.getCommandList().commandFinished();
                            }
                        });
                        commandList.add(AddressInputCityScreenListenerKR.this.inputManager.handleAddressInputEvent(AddressInputCityScreenListenerKR.this.commandListFactory.createCommandList(), 40303));
                    } else if (this.env.getChoiceModel(402590).getValue() == 0) {
                        commandList.add(new NavCommand("Delay fire model event"){

                            public void execute() {
                                this.env.fireModelEvent(n, n4);
                                this.getCommandList().commandFinished();
                            }
                        });
                    }
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            });
            commandList.execute(new StringBuffer().append(this.CLASS_NAME).append("#itemSelected").toString());
        } else {
            this.env.fireModelEvent(n, n4);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "%1#itemFocused - item focused was called with model = %2, index = %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        if (evoListRow instanceof AddressInputHistoryElementListRow) {
            if (this.previewMap != null && !this.isSpellerOpen) {
                AddressInputHistoryElementListRow addressInputHistoryElementListRow = (AddressInputHistoryElementListRow)evoListRow;
                CityHistory.HistoryEntry historyEntry = addressInputHistoryElementListRow.getHistoryEntry();
                ((AddressInputCityZipSequence)this.inputSequence).showHistoryLocationInPreviewMap(this.previewMap, (LICityHistoryEntry)historyEntry.getEntry());
            }
        } else {
            super.itemFocused(evoListRow, n, n2, n3, n4);
        }
    }
}

