/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.evo.main.models;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.addressbook.core.common.ADBEntryDetailsListRow;
import de.audi.app.addressbook.core.common.search.ADBSearchListRow;
import de.audi.app.addressbook.core.main.commands.edit.GetEntryAndEditNavDestinationCommand;
import de.audi.app.addressbook.core.main.commands.edit.GetEntryCommand;
import de.audi.app.addressbook.core.main.commands.edit.SaveEntryCommand;
import de.audi.app.addressbook.core.main.commands.setup.SetContextSpecificVisibilityCommand;
import de.audi.app.addressbook.core.main.models.EntryDetailsRowSelectionHandler;
import de.audi.app.addressbook.evo.main.AddressBookEvoApplication;
import de.audi.app.addressbook.evo.main.commands.CallFocusedEntryCommand;
import de.audi.app.addressbook.evo.main.commands.CreateTelFavoriteCommand;
import de.audi.app.addressbook.evo.main.commands.NavigateFocusedEntryCommand;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbEntry;

public class AddressBookEvoViewListener
implements ButtonListener,
ChoiceListener,
OptionModelListener,
MenuModelListener {
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private AddressBookEvoApplication appAdr;

    public AddressBookEvoViewListener(AddressBookEvoApplication addressBookEvoApplication, LogChannel logChannel) {
        this.appAdr = addressBookEvoApplication;
        this.log = logChannel;
        this.hmiService = addressBookEvoApplication.getHMIService();
        this.hmiService.getMenuModel(700509).setListener(this);
        this.hmiService.getButtonModel(700515).setButtonListener(this);
        this.hmiService.getChoiceModel(700507).setChoiceListener(this);
        this.hmiService.getOptionModel(700554).setListener(this, 700595);
        this.hmiService.getOptionModel(700554).setListener(this, 700594);
        this.hmiService.getOptionModel(700554).setListener(this, 700527);
        this.hmiService.getOptionModel(700523).setListener(this, 700595);
        this.hmiService.getOptionModel(700523).setListener(this, 700594);
        this.hmiService.getOptionModel(700523).setListener(this, 700527);
        this.hmiService.getButtonModel(700512).setButtonListener(this);
        this.hmiService.getButtonModel(700500).setButtonListener(this);
        this.hmiService.getButtonModel(700501).setButtonListener(this);
        this.hmiService.getButtonModel(700546).setButtonListener(this);
        this.hmiService.getButtonModel(700544).setButtonListener(this);
        this.hmiService.getOptionModel(700503).setListener(this, 700595);
        this.hmiService.getOptionModel(700503).setListener(this, 700594);
        this.hmiService.getOptionModel(700503).setListener(this, 700525);
        this.hmiService.getOptionModel(700502).setListener(this, 700595);
        this.hmiService.getOptionModel(700502).setListener(this, 700594);
        this.hmiService.getOptionModel(700502).setListener(this, 700525);
        this.hmiService.getOptionModel(700513).setListener(this, 700595);
        this.hmiService.getOptionModel(700513).setListener(this, 700594);
        this.hmiService.getOptionModel(700562).setListener(this, 700595);
        this.hmiService.getOptionModel(700562).setListener(this, 700594);
        this.hmiService.getOptionModel(700514).setListener(this, 700595);
        this.hmiService.getOptionModel(700514).setListener(this, 700594);
        this.hmiService.getOptionModel(700533).setListener(this, 700595);
        this.hmiService.getOptionModel(700533).setListener(this, 700594);
        this.hmiService.getOptionModel(700533).setListener(this, 700525);
        this.hmiService.getOptionModel(700532).setListener(this, 700595);
        this.hmiService.getOptionModel(700532).setListener(this, 700594);
        this.hmiService.getOptionModel(700532).setListener(this, 700527);
        this.hmiService.getOptionModel(700531).setListener(this, 700595);
        this.hmiService.getOptionModel(700531).setListener(this, 700594);
        this.hmiService.getOptionModel(700531).setListener(this, 700526);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.log.log(10000000, "AddressBookEvoViewListener#keyPressed(): modelID: %1", (long)n);
        switch (n) {
            case 700515: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SHOW_ENTRY_DETAILS_BUTTON)");
                GetEntryCommand.createGetEntryCommand(this.appAdr, this.appAdr.getFocusedEntryId());
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700512: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_NAVIGATE_FOCUSED_ENTRY_BUTTON)");
                NavigateFocusedEntryCommand.createNavigateFocusedEntryCommand(this.appAdr, this.appAdr.getFocusedEntryId());
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700500: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_BUSINESS_NAV_DEST_BUTTON)");
                this.appAdr.getLocationInputHandler().setCurrentlyEditedAddress(0);
                GetEntryAndEditNavDestinationCommand.createGetEntryAndEditNavDestinationCommand(this.appAdr, this.appAdr.getFocusedEntryId(), 0, 0);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700501: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_PRIVATE_NAV_DEST_BUTTON)");
                this.appAdr.getLocationInputHandler().setCurrentlyEditedAddress(1);
                GetEntryAndEditNavDestinationCommand.createGetEntryAndEditNavDestinationCommand(this.appAdr, this.appAdr.getFocusedEntryId(), 0, 1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700546: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_NAV_USE_POSTAL_ADDRESS_BUTTON)");
                int n4 = this.appAdr.getLocationInputHandler().getCurrentlyEditedAddress();
                GetEntryAndEditNavDestinationCommand.createGetEntryAndEditNavDestinationCommand(this.appAdr, this.appAdr.getFocusedEntryId(), 0, n4, 1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700544: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_NAV_NEW_LOCATION_BUTTON)");
                int n5 = this.appAdr.getLocationInputHandler().getCurrentlyEditedAddress();
                GetEntryAndEditNavDestinationCommand.createGetEntryAndEditNavDestinationCommand(this.appAdr, this.appAdr.getFocusedEntryId(), 0, n5, 2);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#keyPressed(): unhandled modelID: %1", (long)n);
            }
        }
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        long l;
        EvoListRow evoListRow = this.hmiService.getBaseListModel(n2).getRow(n3);
        AdbEntry adbEntry = null;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        if (evoListRow != null && evoListRow instanceof ADBSearchListRow) {
            ADBSearchListRow aDBSearchListRow = (ADBSearchListRow)((Object)evoListRow);
            l = aDBSearchListRow.getEntryId();
        } else if (evoListRow != null && evoListRow instanceof ADBEntryDetailsListRow) {
            ADBEntryDetailsListRow aDBEntryDetailsListRow = (ADBEntryDetailsListRow)evoListRow;
            adbEntry = aDBEntryDetailsListRow.getEntry();
            l = aDBEntryDetailsListRow.getEntryId();
            n6 = aDBEntryDetailsListRow.getDataIndex();
            n7 = aDBEntryDetailsListRow.getAddressIndex();
            n8 = aDBEntryDetailsListRow.getAddressType();
        } else {
            this.log.log(10000, "AddressBookEvoViewListener#keyPressed(): target row is null or has an unknown type!");
            return;
        }
        switch (n) {
            case 700554: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CALL_FOCUSED_ENTRY_OPTION): targetModelID: %1", (long)n2);
                this.handleCallFocusedEntry(n, n5, evoListRow, n6);
                break;
            }
            case 700523: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_TEL_FAVORITE_OPTION): targetModelID: %1", (long)n2);
                CreateTelFavoriteCommand.createCreateTelFavoriteCommand(this.appAdr, l, n6 == -1 ? -1 : n6);
                this.hmiService.getModelApp(n).fireEvent(n5);
                break;
            }
            case 700503: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_EDIT_NAV_DEST_OPTION): targetModelID: %1", (long)n2);
                this.appAdr.getLocationInputHandler().setCurrentlyEditedAddress(n7);
                GetEntryAndEditNavDestinationCommand.createGetEntryAndEditNavDestinationCommand(this.appAdr, l, 1, n7);
                this.hmiService.getModelApp(n).fireEvent(n5);
                break;
            }
            case 700502: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_DELETE_NAV_DEST_OPTION): targetModelID: %1", (long)n2);
                this.handleDeleteNavDestination(n, n5, adbEntry, n7);
                break;
            }
            case 700513: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_PARK_NEAR_DESTINATION_OPTION): targetModelID: %1", (long)n2);
                this.parkNearDestination(adbEntry, n8, n, n5);
                break;
            }
            case 700562: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_POI_NEAR_DESTINATION_OPTION): targetModelID: %1", (long)n2);
                this.poiNearDestination(adbEntry, n8, n, n5);
                break;
            }
            case 700514: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SHOW_DESTINATION_IN_MAP_OPTION): targetModelID: %1", (long)n2);
                this.showDestinationInMap(adbEntry, n8, n, n5);
                break;
            }
            case 700533: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_CREATE_NAV_FAVORITE_OPTION): targetModelID: %1", (long)n2);
                this.createNavFavorite(adbEntry, n8, n, n5);
                break;
            }
            case 700532: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SEND_SMS_TO_OPTION): targetModelID: %1", (long)n2);
                this.handleSendSmsToFocusedEntry(n, n5, l, n6);
                break;
            }
            case 700531: {
                this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SEND_EMAIL_TO_OPTION): targetModelID: %1", (long)n2);
                this.handleSendEmailToFocusedEntry(n, n5, l, n6);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#keyPressed(): unhandled optionModelID: %1", (long)n);
            }
        }
    }

    private void handleSendEmailToFocusedEntry(int n, int n2, long l, int n3) {
        if (this.appAdr.getMessagingGateway().isSendEmailReady()) {
            this.appAdr.getMessagingGateway().sendMessageTo(l, 1, n3 == -1 ? -1 : n3);
            this.hmiService.getModelApp(n).fireEvent(n2);
        } else {
            this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SEND_EMAIL_TO_OPTION): sending emails not possible currently.");
        }
    }

    private void handleSendSmsToFocusedEntry(int n, int n2, long l, int n3) {
        if (this.appAdr.getMessagingGateway().isSendSMSReady()) {
            this.appAdr.getMessagingGateway().sendMessageTo(l, 0, n3 == -1 ? -1 : n3);
            this.hmiService.getModelApp(n).fireEvent(n2);
        } else {
            this.log.log(1000000, "AddressBookEvoViewListener#keyPressed(ADR_SEND_SMS_TO_OPTION): sending sms not possible currently.");
        }
    }

    private void handleDeleteNavDestination(int n, int n2, AdbEntry adbEntry, int n3) {
        if (adbEntry != null) {
            adbEntry.addressData[n3].navLocation = null;
            SaveEntryCommand.createSaveEntryCommand(this.appAdr, adbEntry);
            this.hmiService.getModelApp(n).fireEvent(n2);
        } else {
            this.log.log(10000, "AddressBookEvoViewListener#keyPressed(ADR_DELETE_NAV_DEST_OPTION): entry is null!");
        }
    }

    private void handleCallFocusedEntry(int n, int n2, EvoListRow evoListRow, int n3) {
        if (evoListRow != null) {
            if (n3 != -1 && ((ADBEntryDetailsListRow)evoListRow).getDataType() == 0) {
                EntryDetailsRowSelectionHandler.entryDetailsRowSelected(this.appAdr, (ADBEntryDetailsListRow)evoListRow);
            } else {
                CallFocusedEntryCommand.createCallFocusedEntryCommand(this.appAdr, this.appAdr.getFocusedEntryId());
                this.hmiService.getModelApp(n).fireEvent(n2);
            }
        } else {
            this.log.log(10000, "AddressBookEvoViewListener#handleCallFocusedEntry evoListRow is null!");
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 700507: {
                boolean bl = n2 == 1;
                this.log.log(1000000, "AddressBookEvoViewListener#itemSelected( ADR_FILTERING_ENABLED_CHOICE ): showOnlyUsableContacts: %1", bl);
                SetContextSpecificVisibilityCommand.createSetContextSpecificVisibilityCommand(this.appAdr, bl);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#itemSelected(): unhandled modelID: %1", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, long l, int n3) {
        switch (n2) {
            case 700509: {
                if (n == 700595 || n == 700594) break;
                this.log.log(1000000, "AddressBookEvoViewListener#itemFocused( IEvoAddressBookModelBank.ADR_MAIN_MENU ): menuItemID: %1, clearing focused entry id", (long)n);
                this.appAdr.setFocusedEntryId(0L);
                this.hmiService.getMenuModel(n2).resetFocusedItem();
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#itemFocused(): unhandled modelID: %1", (long)n2);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private void parkNearDestination(AdbEntry adbEntry, int n, int n2, int n3) {
        if (adbEntry == null) {
            this.log.log(10000, "AddressBookEvoViewListener#parkNearDestination(): AdbEntry is null!");
            return;
        }
        switch (n) {
            case 2: {
                this.appAdr.getNaviGateway().parkNearDestination(adbEntry.addressData[0].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 3: {
                this.appAdr.getNaviGateway().parkNearDestination(adbEntry.addressData[1].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#parkNearDestination(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().parkNearDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#parkNearDestination(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().parkNearDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#parkNearDestination(): no handling available for address type %1", (long)n);
            }
        }
    }

    private void poiNearDestination(AdbEntry adbEntry, int n, int n2, int n3) {
        if (adbEntry == null) {
            this.log.log(10000, "AddressBookEvoViewListener#poiNearDestination(): AdbEntry is null!");
            return;
        }
        switch (n) {
            case 2: {
                this.appAdr.getNaviGateway().poiNearDestination(adbEntry.addressData[0].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 3: {
                this.appAdr.getNaviGateway().poiNearDestination(adbEntry.addressData[1].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#poiNearDestination(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().poiNearDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#poiNearDestination(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().poiNearDestination(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#poiNearDestination(): no handling available for address type %1", (long)n);
            }
        }
    }

    private void showDestinationInMap(AdbEntry adbEntry, int n, int n2, int n3) {
        if (adbEntry == null) {
            this.log.log(10000, "AddressBookEvoViewListener#showDestinationInMap(): AdbEntry is null!");
            return;
        }
        switch (n) {
            case 2: {
                this.appAdr.getNaviGateway().showDestinationInMap(adbEntry.addressData[0].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 3: {
                this.appAdr.getNaviGateway().showDestinationInMap(adbEntry.addressData[1].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#showDestinationInMap(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().showDestinationInMap(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#showDestinationInMap(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().showDestinationInMap(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#showDestinationInMap(): no handling available for address type %1", (long)n);
            }
        }
    }

    private void createNavFavorite(AdbEntry adbEntry, int n, int n2, int n3) {
        if (adbEntry == null) {
            this.log.log(10000, "AddressBookEvoViewListener#createNavFavorite(): AdbEntry is null!");
            return;
        }
        switch (n) {
            case 2: {
                this.appAdr.getNaviGateway().addToFavorites(adbEntry.addressData[0].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 3: {
                this.appAdr.getNaviGateway().addToFavorites(adbEntry.addressData[1].navLocation, adbEntry.combinedName);
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#createNavFavorite(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().addToFavorites(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(adbEntry.addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    this.log.log(10000, "AddressBookEvoViewListener#createNavFavorite(): invalid geo position");
                    break;
                }
                this.appAdr.getNaviGateway().addToFavorites(stringArray[1], stringArray[0], adbEntry.getCombinedName());
                this.hmiService.getModelApp(n2).fireEvent(n3);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookEvoViewListener#createNavFavorite(): no handling available for address type %1", (long)n);
            }
        }
    }
}

