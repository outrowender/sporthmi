/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackEntryRow;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler;
import de.audi.app.phone.core.interapp.TelMessagingServiceHandler;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.callstacks.TelEvoCallStackRow;
import de.audi.app.phone.evo.intellicall.IntellicallCombinedCallStackHandler$1;
import de.audi.app.phone.evo.intellicall.IntellicallCombinedCallStackHandler$DeleteAllCallStacksButtonListener;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class IntellicallCombinedCallStackHandler
extends AbstractCallStackHandler
implements OptionModelListener {
    private final TelMessagingServiceHandler messagingServiceHandler;

    public IntellicallCombinedCallStackHandler(ITelEvoApplication iTelEvoApplication) {
        super((ITelApplication)iTelEvoApplication, 10);
        this.messagingServiceHandler = new TelMessagingServiceHandler(iTelEvoApplication);
        this.addSubPhoneComponent(this.messagingServiceHandler);
        this.addSubPhoneComponent(new IntellicallCombinedCallStackHandler$DeleteAllCallStacksButtonListener(this, iTelEvoApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getOptionModel(-946469888).setListener(this, -1718287360);
        this.getOptionModel(-1751776256).setListener(this, -1718287360);
        this.getOptionModel(-1198128128).setListener(this, -1718287360);
        this.getOptionModel(379061248).setListener(this, -1718287360);
        this.getOptionModel(-996801536).setListener(this, -1718287360);
        this.getOptionModel(680985600).setListener(this, -1718287360);
        this.getOptionModel(664208384).setListener(this, -1718287360);
        this.getOptionModel(-1936391168).setListener(this, -1718287360);
        this.getOptionModel(-1936391168).setListener(this, -1265302528);
        this.getOptionModel(680985600).setListener(this, -1265302528);
        this.getOptionModel(-1751776256).setListener(this, -1265302528);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getOptionModel(-946469888).removeListener(-1718287360);
        this.getOptionModel(-1751776256).removeListener(-1718287360);
        this.getOptionModel(-1198128128).removeListener(-1718287360);
        this.getOptionModel(379061248).removeListener(-1718287360);
        this.getOptionModel(-996801536).removeListener(-1718287360);
        this.getOptionModel(680985600).removeListener(-1718287360);
        this.getOptionModel(664208384).removeListener(-1718287360);
        this.getOptionModel(-1936391168).removeListener(-1718287360);
        this.getOptionModel(-1936391168).removeListener(-1265302528);
        this.getOptionModel(680985600).removeListener(-1265302528);
        this.getOptionModel(-1751776256).removeListener(-1265302528);
    }

    @Override
    protected ListModelApp getCombinedNumbersList() {
        return this.getListModel(-1718287360);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[IntellicallCombinedCallStackHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == -1718287360) {
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
                    this.getOptionModel(-1751776256).fireEvent(n5);
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
                    this.getButtonModel(1922368512).setStatus(string2.length() > 0 ? 1 : 0);
                    this.getSpellerModel(-2003434496).setText(string2);
                    this.getOptionModel(-996801536).fireEvent(n5);
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
        } else if (n2 == -1265302528) {
            String string = this.getLabelModel(-1282079744).getText();
            switch (n) {
                case 300428: {
                    ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumber(string, n5);
                    break;
                }
                case 300695: {
                    ((ITelEvoApplication)this.getApplication()).getFavoriteHandler().addToFavorites(new TelFavoriteStruct(string, string, 0));
                    this.getOptionModel(-1751776256).fireEvent(n5);
                    break;
                }
                case 300840: {
                    this.messagingServiceHandler.prepareSendSMS(string);
                    this.getOptionModel(n).fireEvent(n5);
                    break;
                }
            }
        } else {
            this.log.log(1078071040, "[IntellicallCombinedCallStackHandler#keyTyped] NOP!");
        }
    }

    @Override
    protected void callEntry(CallStackEntry callStackEntry, int n) {
        if (callStackEntry != null) {
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromCallStackEntry(callStackEntry, n, new IntellicallCombinedCallStackHandler$1(this, callStackEntry));
        } else {
            this.log.log(-1601830656, "[IntellicallCombinedCallStackHandler#keyTyped] no call stack entry available!");
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
            this.log.log(-1601830656, "[IntellicallCombinedCallStackHandler#prepareSendSMS] no call stack entry available!");
        }
    }

    protected void prepareSendEmail(long l) {
        this.messagingServiceHandler.prepareSendEmail(l);
    }

    @Override
    protected void callStackEntryDialed(CallStackEntry callStackEntry) {
        this.log.log(-2137614336, "IntellicallCombinedCallStackHandler#callStackEntryDialed(): entry=%1", (Object)callStackEntry);
        PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    @Override
    protected void updateMissedNumbers(CallStackEntry[] callStackEntryArray) {
    }

    @Override
    protected void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray) {
    }

    @Override
    protected void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray) {
    }

    @Override
    protected BaseListRow getCallStackRow(CallStackEntry callStackEntry) {
        return new TelEvoCallStackRow(callStackEntry, this.log, this.telephoneState);
    }

    @Override
    protected void callStackEntrySelected(int n, AbstractCallStackEntryRow abstractCallStackEntryRow, int n2, int n3) {
        this.callEntry(abstractCallStackEntryRow.getCallStackEntry(), n3);
    }

    @Override
    protected void updateCallStackEntries() {
        CallStackEntry[] callStackEntryArray = this.telephoneState.getCombinedCallStackEntries();
        if (callStackEntryArray != null) {
            this.updateCombinedCallStackList(callStackEntryArray);
        }
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

