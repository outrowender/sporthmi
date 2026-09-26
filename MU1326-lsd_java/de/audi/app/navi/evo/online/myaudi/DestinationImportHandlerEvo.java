/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.online.myaudi;

import de.audi.app.navi.evo.online.myaudi.DestinationImportHandlerEvo$1;
import de.audi.app.navi.evo.online.myaudi.DestinationImportListenerEvo;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.OnlineAdbEntry;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.phone.ITelService;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.destinationimport.AbstractNaviMyAudiImportListener;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportImpl;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportUtil;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiSaveToAdbCommand;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.organizer.AdbEntry;

public class DestinationImportHandlerEvo
extends NaviMyAudiImportImpl {
    private AbstractNaviMyAudiImportListener destinationImportListener;

    public DestinationImportHandlerEvo(NavigationEnv navigationEnv, ITelService iTelService, ICommandListFactory iCommandListFactory, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, IPreviewMap iPreviewMap, DispatcherBase dispatcherBase, HomeAddressHandler homeAddressHandler, ADBInterAppService aDBInterAppService) {
        super(navigationEnv, iTelService, iCommandListFactory, iStartGuidanceToDestinationSequence, iPreviewMap, dispatcherBase, homeAddressHandler, aDBInterAppService);
        this.destinationImportListener = new DestinationImportListenerEvo(navigationEnv, this);
    }

    @Override
    public void fillEntryDetailsModels(OnlineAdbEntry onlineAdbEntry) {
        this.logChannel.log(-2137614336, "%1#fillEntryDetailsModels() - entry=%2", (Object)this.CLASS_NAME, (Object)onlineAdbEntry);
        AdbEntry adbEntry = onlineAdbEntry.getAdbEntry();
        String string = onlineAdbEntry.getAdditionalDescription();
        this.currentSelectedBusinessDestination = null;
        this.currentSelectedPrivateDestination = null;
        ListCell[] listCellArray = null;
        ListCell[] listCellArray2 = null;
        this.clearDetailsScreenData();
        this.previewMap.hidePreviewMap();
        this.subTitleLabel.setText(adbEntry.getCombinedName());
        boolean bl = Util.isHURegionNAR();
        int n = adbEntry.addressData.length;
        if (n > 0) {
            boolean bl2 = NaviMyAudiImportUtil.hasPostalAddressForDisplayInAdrDetailScreen(adbEntry.addressData[0], this.logChannel);
            this.businessAddressAvailableChoice.setValue(bl2 ? 1 : 0);
            String string2 = NaviMyAudiImportUtil.getFirstDisplayLineOfPostalAddress(adbEntry.addressData[0], this.logChannel);
            String string3 = NaviMyAudiImportUtil.getSecondDisplayLineOfPostalAddress(adbEntry.addressData[0], bl, this.logChannel);
            listCellArray = Util.isEmpty(string2) ? new ListCell[]{new TextListCell(string3), new TextListCell("")} : new ListCell[]{new TextListCell(string3), new TextListCell(string2)};
            this.businessAddressListModel.setMaxColumns(2);
            this.businessAddressListModel.addRow(listCellArray);
            this.currentSelectedBusinessDestination = adbEntry.addressData[0].navLocation;
            if (n > 1) {
                boolean bl3 = NaviMyAudiImportUtil.hasPostalAddressForDisplayInAdrDetailScreen(adbEntry.addressData[1], this.logChannel);
                this.privateAddressAvailableChoice.setValue(bl3 ? 1 : 0);
                String string4 = NaviMyAudiImportUtil.getFirstDisplayLineOfPostalAddress(adbEntry.addressData[1], this.logChannel);
                String string5 = NaviMyAudiImportUtil.getSecondDisplayLineOfPostalAddress(adbEntry.addressData[1], bl, this.logChannel);
                listCellArray2 = Util.isEmpty(string4) ? new ListCell[]{new TextListCell(string5), new TextListCell("")} : new ListCell[]{new TextListCell(string5), new TextListCell(string4)};
                this.privateAddressListModel.setMaxColumns(2);
                this.privateAddressListModel.addRow(listCellArray2);
                this.currentSelectedPrivateDestination = adbEntry.addressData[1].navLocation;
            }
        }
        NaviMyAudiImportUtil.fillTelNumberList(adbEntry, this.telephoneNumbersListModel, this.logChannel);
        if (Util.isEmpty(string)) {
            this.logChannel.log(-2137614336, "%1#fillEntryDetailsModels - no additional information available", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-702478848).setValue(0);
        } else {
            this.logChannel.log(-2137614336, "%1#fillEntryDetailsModels - additional information available", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-702478848).setValue(1);
            this.additionalInfoLabel.setText(string);
        }
    }

    @Override
    protected void fillResultListModel(OnlineAdbEntry[] onlineAdbEntryArray) {
        for (int i2 = 0; i2 < onlineAdbEntryArray.length; ++i2) {
            OnlineAdbEntry onlineAdbEntry = onlineAdbEntryArray[i2];
            this.logChannel.log(-2137614336, "%1#storeAddressList - appending listmodel with entry=%2, isImport", (Object)this.CLASS_NAME, (Object)onlineAdbEntry.getAdbEntry(), (Object)new Boolean(onlineAdbEntry.isImport()));
            EvoListRow evoListRow = new EvoListRow(i2, 4);
            onlineAdbEntry.setRowId(i2);
            evoListRow.setText(1, onlineAdbEntry.getAdbEntry().getCombinedName());
            evoListRow.setPropertyCell(2, EMPTY_PROPERTY_LIST_CELL);
            this.adbEntries.add(onlineAdbEntry);
            this.myAudiResultList.append(evoListRow);
        }
    }

    @Override
    public void updateAddressList(OnlineAdbEntry[] onlineAdbEntryArray) {
        for (int i2 = 0; i2 < onlineAdbEntryArray.length; ++i2) {
            OnlineAdbEntry onlineAdbEntry = onlineAdbEntryArray[i2];
            EvoListRow evoListRow = new EvoListRow(onlineAdbEntry.getRowId(), 4);
            evoListRow.setText(1, onlineAdbEntry.getAdbEntry().getCombinedName());
            evoListRow.setPropertyCell(2, EMPTY_PROPERTY_LIST_CELL);
            this.myAudiResultList.append(evoListRow);
        }
    }

    @Override
    public void saveInAddressBook() {
        this.env.getChoiceModel(1310852608).setValue(0);
        this.memoryErrorAppeard = false;
        this.importedEntries = 0;
        this.notImportedAdbEntries.clear();
        CommandList commandList = this.commandListFactory.createCommandList();
        this.logChannel.log(-2137614336, "%1#saveInAddressBook", (Object)this.CLASS_NAME);
        if (this.adbHmiAppService != null) {
            int n = this.myAudiResultList.getLength();
            for (int i2 = 0; i2 < n; ++i2) {
                OnlineAdbEntry onlineAdbEntry = (OnlineAdbEntry)this.adbEntries.get(i2);
                this.logChannel.log(-2137614336, "%1#saveInAddressBook - creating command entry=%2 import: %3", (Object)this.CLASS_NAME, (Object)onlineAdbEntry, (Object)new Boolean(onlineAdbEntry.isImport()));
                if (!onlineAdbEntry.isImport()) continue;
                if (this.importedAdbEntries.contains(new Long(onlineAdbEntry.getAdbEntry().getEntryId()))) {
                    this.logChannel.log(-2137614336, "%1#saveInAddressBook - entry was already imported %2", (Object)this.CLASS_NAME, (Object)onlineAdbEntry);
                    continue;
                }
                NaviMyAudiSaveToAdbCommand naviMyAudiSaveToAdbCommand = new NaviMyAudiSaveToAdbCommand(this.logChannel, onlineAdbEntry.getAdbEntry(), this.adbHmiAppService, new DestinationImportHandlerEvo$1(this));
                commandList.add(naviMyAudiSaveToAdbCommand);
            }
            this.logChannel.log(1078071040, "%1#saveInAddressBook - executing saveInAdbCommandList. Size: %1", (long)commandList.size());
            if (commandList.size() == 0) {
                this.resultOkWithoutContacts();
                return;
            }
            commandList.execute("NaviMyAudiImportImpl-saveInAdressbook");
        } else {
            this.logChannel.log(10000, "%1#saveInAddressBook - adbHmiAppService is null!", (Object)this.CLASS_NAME);
        }
    }
}

