/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.adb.AddAddressToContactSelectionListRow;
import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.adb.commands.GetEntryCommand;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.search.Token;

public class AdbContactsGuiSearchHandler
extends IntelliDestGuiSearchHandler {
    private BaseListModelApp addressSelectBaseListModel;

    public AdbContactsGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, iNaviFavoriteHandler, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null);
        this.addressSelectBaseListModel = navigationEnv.getHMIService().getBaseListModel(401549);
    }

    public void activate() {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "AdbContactsGuiSearchHandler#activate()");
        }
        ((IntelliDestSearch)this.appSearch).clearAddressDataFilterForAdb();
        this.registerListeners();
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(401008).setValue(1);
        this.performQuery("");
    }

    public void enterScreen() {
        this.mdlSpellerSearchText.clear();
    }

    protected void parentNodeSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.lc.log(10000000, "AdbContactsGuiSearchHandler#parentNodeSelected");
        this.createSelectionListFor(searchResultListRow);
        this.saveContactNameInLabel(searchResultListRow);
        ((IntelliDestSearch)this.appSearch).destinationAddedToContact = true;
        this.env.getHMIService().getBaseListModel(n).fireEvent(n2);
    }

    private void saveContactNameInLabel(SearchResultListRow searchResultListRow) {
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResultListRow.getSearchResult().tokens, 5);
        this.env.getLabelModel(401581).setText(token.getToken());
    }

    private void createSelectionListFor(final SearchResultListRow searchResultListRow) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("AdbContactsGuiSearchHandler#getAdbEntry"){

            public void execute() {
                GetEntryCommand.createGetEntryCommand(AdbContactsGuiSearchHandler.this.naviADBHandler, searchResultListRow.getSearchResult().dataId, AdbContactsGuiSearchHandler.this.mdlChoiceSearchIsActive, this);
            }
        });
        commandList.add(new NavCommand("AdbContactsGuiSearchHandler#createAdbEntrySelectionList"){

            public void execute() {
                AdbContactsGuiSearchHandler.this.addressSelectBaseListModel.removeAll();
                AdbEntry adbEntry = AdbContactsGuiSearchHandler.this.naviADBHandler.getCurrentEntry();
                this.logger.log(10000000, "AdbContactsGuiSearchHandler#enter selection screen, entry is [%1]", adbEntry.entryId);
                CommandList commandList = this.getAddRowCL(adbEntry.addressData[1], 1);
                commandList.add(this.getAddRowCL(adbEntry.addressData[0], 0));
                this.getCommandList().commandFinishedWithPostSequence(commandList);
            }

            private CommandList getAddRowCL(AddressData addressData, int n) {
                CommandList commandList = AdbContactsGuiSearchHandler.this.commandListFactory.createCommandList();
                if (this.addressExistsFor(addressData)) {
                    this.logger.log(10000000, "Location existed");
                    commandList.add(new StreamToLocationCommand(addressData.navLocation));
                    commandList.add(this.addressExistingCreateAddRowCmd(n));
                } else {
                    this.logger.log(10000000, "Location did not exist");
                    commandList.add(this.noAddressCreateAddRowCmd(n));
                }
                return commandList;
            }

            public boolean addressExistsFor(AddressData addressData) {
                return addressData != null && addressData.navLocation != null && addressData.navLocation.length != 0;
            }

            private NavCommand addressExistingCreateAddRowCmd(int n) {
                return this.createAddRowCommand(n, true);
            }

            private NavCommand noAddressCreateAddRowCmd(int n) {
                return this.createAddRowCommand(n, false);
            }

            private NavCommand createAddRowCommand(final int n, final boolean bl) {
                return new NavCommand(new StringBuffer().append("Add address ").append(n).toString()){

                    public void execute() {
                        Object object;
                        Buffer buffer = new Buffer();
                        if (bl) {
                            object = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
                            this.logger.log(10000000, "AdbContactsGuiSearchHandler#createAddRowCommand - navlocation=%1", object);
                            String[] stringArray = (this).AdbContactsGuiSearchHandler.this.adbInterAppService.getLocationNameForNavLocation((NavLocation)object);
                            buffer.append(stringArray[0]);
                            if (!"".equals(stringArray[1])) {
                                buffer.append(", ").append(stringArray[1]);
                            }
                        }
                        object = new AddAddressToContactSelectionListRow(n, bl, buffer.toString(), n);
                        AdbContactsGuiSearchHandler.this.addressSelectBaseListModel.append((EvoListRow)object);
                        this.getCommandList().commandFinished();
                    }
                };
            }
        });
        commandList.execute("Start Save Address on Contact");
    }
}

