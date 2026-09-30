/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.models;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.app.addressbook.core.main.commands.edit.DeleteEntryCommand;
import de.audi.app.addressbook.core.main.commands.edit.GetAndReadoutEntryCommand;
import de.audi.app.addressbook.core.main.commands.setup.SetSortOrderCommand;
import de.audi.app.addressbook.core.main.commands.userprofile.DeleteProfilesCommand;
import de.audi.app.addressbook.core.main.commands.userprofile.RestartDownloadCommand;
import de.audi.app.addressbook.core.vcardexchange.commands.SendAsVCardCommand;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.log.LogChannel;

public class AddressBookViewListener
implements ButtonListener,
ChoiceListener,
MenuModelListener {
    private LogChannel log;
    private IHMIServiceApp hmiService;
    private AbstractAddressBookApplication appAdr;

    public AddressBookViewListener(LogChannel logChannel, AbstractAddressBookApplication abstractAddressBookApplication) {
        this.log = logChannel;
        this.appAdr = abstractAddressBookApplication;
        this.hmiService = abstractAddressBookApplication.getHMIService();
        this.hmiService.getButtonModel(399).setButtonListener(this);
        this.hmiService.getButtonModel(157).setButtonListener(this);
        this.hmiService.getButtonModel(171).setButtonListener(this);
        this.hmiService.getButtonModel(528).setButtonListener(this);
        this.hmiService.getButtonModel(700491).setButtonListener(this);
        this.hmiService.getButtonModel(700439).setButtonListener(this);
        this.hmiService.getButtonModel(700438).setButtonListener(this);
        this.hmiService.getButtonModel(700547).setButtonListener(this);
        this.hmiService.getButtonModel(700548).setButtonListener(this);
        this.hmiService.getButtonModel(700492).setButtonListener(this);
        abstractAddressBookApplication.getHMIService().getChoiceModel(700494).setChoiceListener(this);
        abstractAddressBookApplication.getHMIService().getMenuModel(700541).setListener(this);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(10000000, "AddressBookViewListener#keyTyped(): modelID: %1", (long)n);
        switch (n) {
            case 399: {
                this.appAdr.loadMainList(0);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 157: {
                this.appAdr.loadMainList(1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 171: {
                this.appAdr.loadMainList(1);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 528: {
                this.appAdr.loadMainList(2);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700491: {
                this.log.log(10000000, "AddressBookViewListener#keyTyped( ADR_READOUT_FOCUSED_ENTRY_BUTTON )");
                GetAndReadoutEntryCommand.createGetAndReadoutEntryCommand(this.appAdr, this.appAdr.getFocusedEntryId());
                break;
            }
            case 700439: {
                int n4 = this.appAdr.getFocusedEntryType();
                this.hmiService.getChoiceModel(700440).setValue(ADBModelUtils.getEntryTypeModelValue(n4));
                if (n4 == 4 || n4 == 0 || n4 == 3) {
                    this.log.log(1000000, "AddressBookViewListener#keyTyped( ADR_DELETE_FOCUSED_ENTRY_BUTTON ): deleting entry with id: %1", this.appAdr.getFocusedEntryId());
                    DeleteEntryCommand.createDeleteEntryCommand(this.appAdr, this.appAdr.getFocusedEntryId(), this.hmiService.getModelApp(700498));
                } else {
                    this.log.log(1000000, "AddressBookViewListener#keyTyped( ADR_DELETE_FOCUSED_ENTRY_BUTTON ): not deleting entry with id %2 as entry type is %1", (Object)ADBDbgUtils.dbgEntryType(this.appAdr.getFocusedEntryType()), this.appAdr.getFocusedEntryId());
                }
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700438: {
                this.appAdr.getVCardExchangeADBHandler().abortImport();
                DeleteProfilesCommand.createDeleteProfilesCommand(this.appAdr, new int[]{0, this.appAdr.getAdbStateHandler().getActiveProfile()}, this.hmiService.getModelApp(700438));
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700492: {
                RestartDownloadCommand.createRestartDownloadCommand(this.appAdr);
                this.hmiService.getModelApp(n).fireEvent(n3);
                break;
            }
            case 700548: {
                this.log.log(1000000, "AddressBookViewListener#keyTyped(ADR_SEND_AS_SMS_BUTTON)");
                if (this.appAdr.getMessagingGateway().isSendSMSReady()) {
                    SendAsVCardCommand.createSendAsVCardCommand(this.appAdr.getVCardExchangeADBHandler(), this.appAdr.getFocusedEntryId(), this.appAdr.getMessagingGateway(), this.hmiService.getModelApp(n), 0);
                    this.hmiService.getModelApp(n).fireEvent(n3);
                    break;
                }
                this.log.log(1000000, "AddressBookViewListener#keyTyped(ADR_SEND_AS_SMS_BUTTON): sending sms not possible currently.");
                break;
            }
            case 700547: {
                this.log.log(1000000, "AddressBookViewListener#keyTyped(ADR_SEND_AS_EMAIL_BUTTON)");
                if (this.appAdr.getMessagingGateway().isSendEmailReady()) {
                    SendAsVCardCommand.createSendAsVCardCommand(this.appAdr.getVCardExchangeADBHandler(), this.appAdr.getFocusedEntryId(), this.appAdr.getMessagingGateway(), this.hmiService.getModelApp(n), 1);
                    this.hmiService.getModelApp(n).fireEvent(n3);
                    break;
                }
                this.log.log(1000000, "AddressBookViewListener#keyTyped(ADR_SEND_AS_EMAIL_BUTTON): sending emails not possible currently.");
                break;
            }
            case 700494: {
                break;
            }
            default: {
                this.log.log(10000, "AddressBookViewListener#keyTyped(): unhandled modelID: %1", (long)n);
            }
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        switch (n) {
            case 700494: {
                int n5 = ADBModelUtils.getDSISortOrderValue(n2);
                this.log.log(1000000, "AddressBookViewListener#itemSelected( ADR_SORT_ORDER_CHOICE ): setting sort order to: %1", (Object)ADBDbgUtils.dbgSortOrder(n5));
                this.hmiService.getChoiceModel(n).setValue(n2);
                SetSortOrderCommand.createSetSortOrderCommand(this.appAdr, n5);
                break;
            }
            default: {
                this.log.log(10000, "AddressBookViewListener#itemSelected(): unhandled modelID: %1", (long)n);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemFocused(int n, int n2, long l, int n3) {
    }
}

