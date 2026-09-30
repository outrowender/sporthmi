/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackEntryRow;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.interapp.TelMessagingServiceHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.callstacks.TelEvoCallStackRow;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class IntellicallCombinedCallStackHandler
extends AbstractCallStackHandler
implements OptionModelListener {
    private final TelMessagingServiceHandler messagingServiceHandler;

    public IntellicallCombinedCallStackHandler(ITelEvoApplication iTelEvoApplication) {
        super((ITelApplication)iTelEvoApplication, 10);
        this.messagingServiceHandler = new TelMessagingServiceHandler(iTelEvoApplication);
        this.addSubPhoneComponent(this.messagingServiceHandler);
        this.addSubPhoneComponent(new DeleteAllCallStacksButtonListener(iTelEvoApplication));
    }

    public void init() {
        super.init();
        this.getOptionModel(300743).setListener(this, 300441);
        this.getOptionModel(300695).setListener(this, 300441);
        this.getOptionModel(300728).setListener(this, 300441);
        this.getOptionModel(301078).setListener(this, 300441);
        this.getOptionModel(300740).setListener(this, 300441);
        this.getOptionModel(300840).setListener(this, 300441);
        this.getOptionModel(300839).setListener(this, 300441);
        this.getOptionModel(300428).setListener(this, 300441);
        this.getOptionModel(300428).setListener(this, 300468);
        this.getOptionModel(300840).setListener(this, 300468);
        this.getOptionModel(300695).setListener(this, 300468);
    }

    public void deinit() {
        super.deinit();
        this.getOptionModel(300743).removeListener(300441);
        this.getOptionModel(300695).removeListener(300441);
        this.getOptionModel(300728).removeListener(300441);
        this.getOptionModel(301078).removeListener(300441);
        this.getOptionModel(300740).removeListener(300441);
        this.getOptionModel(300840).removeListener(300441);
        this.getOptionModel(300839).removeListener(300441);
        this.getOptionModel(300428).removeListener(300441);
        this.getOptionModel(300428).removeListener(300468);
        this.getOptionModel(300840).removeListener(300468);
        this.getOptionModel(300695).removeListener(300468);
    }

    protected ListModelApp getCombinedNumbersList() {
        return this.getListModel(300441);
    }

    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[IntellicallCombinedCallStackHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == 300441) {
            TelEvoCallStackRow telEvoCallStackRow = (TelEvoCallStackRow)this.getListModel(n2).getRow(n3);
            String string = telEvoCallStackRow.getDisplayName();
            CallStackEntry callStackEntry = telEvoCallStackRow.getCallStackEntry();
            String string2 = callStackEntry.getClNumber();
            switch (n) {
                case 300428: {
                    this.callEntry(callStackEntry, n5);
                    break;
                }
                case 300695: {
                    ((ITelEvoApplication)this.getApplication()).getFavoriteHandler().addToFavorites(new TelFavoriteStruct(PhoneUtils.getDisplayName(string, string2), string2, callStackEntry.getAdbNumberType()));
                    this.getOptionModel(300695).fireEvent(n5);
                    break;
                }
                case 300728: {
                    this.getApplication().getTelephoneDSIAccess().deleteCallStackEntry(callStackEntry.getClEntryType(), callStackEntry.getClEntryID(), n5);
                    break;
                }
                case 301078: {
                    this.getApplication().getTelephoneDSIAccess().deleteAllCallStacks(3, n5);
                    break;
                }
                case 300740: {
                    if (string2 == null) break;
                    this.getButtonModel(300402).setStatus(string2.length() > 0 ? 1 : 0);
                    this.getSpellerModel(300680).setText(string2);
                    this.getOptionModel(300740).fireEvent(n5);
                    break;
                }
                case 300743: {
                    long l = callStackEntry.getAdbEntryID();
                    if (l <= 0L) break;
                    this.getApplication().getADBHandler().showEntryDetails(l);
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
                case 300840: {
                    this.prepareSendSMS(callStackEntry);
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
                case 300839: {
                    this.prepareSendEmail(callStackEntry.getAdbEntryID());
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
            }
        } else if (n2 == 300468) {
            String string = this.getLabelModel(300467).getText();
            switch (n) {
                case 300428: {
                    ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(string, n5);
                    break;
                }
                case 300695: {
                    ((ITelEvoApplication)this.getApplication()).getFavoriteHandler().addToFavorites(new TelFavoriteStruct(string, string, 0));
                    this.getOptionModel(300695).fireEvent(n5);
                    break;
                }
                case 300840: {
                    this.messagingServiceHandler.prepareSendSMS(string);
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
            }
        } else {
            this.log.log(1000000, "[IntellicallCombinedCallStackHandler#keyTyped] NOP!");
        }
    }

    protected void callEntry(final CallStackEntry callStackEntry, int n) {
        if (callStackEntry != null) {
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromCallStackEntry(callStackEntry, n, new TelDefaultDSIResponseListener(){

                public void responseDialNumber(int n, int n2, SuppServiceResponseStruct suppServiceResponseStruct, int n3) {
                    if (n == 0) {
                        IntellicallCombinedCallStackHandler.this.callStackEntryDialed(callStackEntry);
                    }
                }
            });
        } else {
            this.log.log(100000, "[IntellicallCombinedCallStackHandler#keyTyped] no call stack entry available!");
        }
    }

    protected void prepareSendSMS(CallStackEntry callStackEntry) {
        if (callStackEntry != null) {
            String string = callStackEntry.getClNumber();
            long l = callStackEntry.getAdbEntryID();
            int n = callStackEntry.getAdbPhoneDataIndex();
            if (l > 0L) {
                this.messagingServiceHandler.prepareSendSMS(string, l, n);
            } else {
                this.messagingServiceHandler.prepareSendSMS(string);
            }
        } else {
            this.log.log(100000, "[IntellicallCombinedCallStackHandler#prepareSendSMS] no call stack entry available!");
        }
    }

    protected void prepareSendEmail(long l) {
        this.messagingServiceHandler.prepareSendEmail(l);
    }

    protected void callStackEntryDialed(CallStackEntry callStackEntry) {
        this.log.log(10000000, "IntellicallCombinedCallStackHandler#callStackEntryDialed(): entry=%1", (Object)callStackEntry);
        PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    protected void updateMissedNumbers(CallStackEntry[] callStackEntryArray) {
    }

    protected void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray) {
    }

    protected void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray) {
    }

    protected BaseListRow getCallStackRow(CallStackEntry callStackEntry) {
        return new TelEvoCallStackRow(callStackEntry, this.log, this.telephoneState);
    }

    protected void callStackEntrySelected(int n, AbstractCallStackEntryRow abstractCallStackEntryRow, int n2, int n3) {
        this.callEntry(abstractCallStackEntryRow.getCallStackEntry(), n3);
    }

    protected void updateCallStackEntries() {
        CallStackEntry[] callStackEntryArray = this.telephoneState.getCombinedCallStackEntries();
        if (callStackEntryArray != null) {
            this.updateCombinedCallStackList(callStackEntryArray);
        }
    }

    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }

    private class DeleteAllCallStacksButtonListener
    extends TelDefaultButtonListener {
        public DeleteAllCallStacksButtonListener(ITelApplication iTelApplication) {
            super(iTelApplication, 300727);
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[IntellicallCombinedCallStackHandler.DeleteAllCallStacksButtonListener#keyTyped] deleting all call stacks.");
            this.getApplication().getTelephoneDSIAccess().deleteAllCallStacks(3, n3);
            this.fireEvent(n3);
        }
    }
}

