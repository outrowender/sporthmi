/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelMessagingServiceHandler;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.app.phone.evo.intellicall.IntellicallFullMenuFocusHandler;
import de.audi.app.phone.evo.intellicall.search.AbstractIntellicallSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBEntryDetailsResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallADBSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallCallStackSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallFavoriteSearchResultRow;
import de.audi.app.phone.evo.intellicall.search.IntellicallSearchModelHandler;
import de.audi.atip.hmi.model.OptionModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.phone.TelFavoriteStruct;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class PhoneIntellicallSearchHandler
extends AbstractEvoPhoneComponent
implements OptionModelListener {
    private final TelMessagingServiceHandler messagingServiceHandler;
    private final IntellicallSearchModelHandler searchHandler;

    public PhoneIntellicallSearchHandler(ITelEvoApplication iTelEvoApplication, ITelDSISearchAccess iTelDSISearchAccess, IntellicallFullMenuFocusHandler intellicallFullMenuFocusHandler) {
        super(iTelEvoApplication, "App.Phone.Main");
        this.searchHandler = new IntellicallSearchModelHandler((ITelApplication)iTelEvoApplication, iTelDSISearchAccess, intellicallFullMenuFocusHandler);
        this.addSubPhoneComponent(this.searchHandler);
        this.messagingServiceHandler = new TelMessagingServiceHandler(iTelEvoApplication);
        this.addSubPhoneComponent(this.messagingServiceHandler);
    }

    @Override
    public void init() {
        super.init();
        this.log.log(-2137614336, "[PhoneIntellicallSearchHandler#init]");
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getOptionModel(-1936391168).setListener(this, -1365900288);
        this.getOptionModel(-1751776256).setListener(this, -1365900288);
        this.getOptionModel(-1198128128).setListener(this, -1365900288);
        this.getOptionModel(-946469888).setListener(this, -1365900288);
        this.getOptionModel(379061248).setListener(this, -1365900288);
        this.getOptionModel(-996801536).setListener(this, -1365900288);
        this.getOptionModel(680985600).setListener(this, -1365900288);
        this.getOptionModel(664208384).setListener(this, -1365900288);
        this.getChoiceModel(-1902771200).setValue(1);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.log.log(-2137614336, "[PhoneIntellicallSearchHandler#deinit]");
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getOptionModel(-1936391168).removeListener(-1365900288);
        this.getOptionModel(-996801536).removeListener(-1365900288);
        this.getOptionModel(-1751776256).removeListener(-1365900288);
        this.getOptionModel(-1198128128).removeListener(-1365900288);
        this.getOptionModel(379061248).removeListener(-1365900288);
        this.getOptionModel(-946469888).removeListener(-1365900288);
        this.getOptionModel(680985600).removeListener(-1365900288);
        this.getOptionModel(664208384).removeListener(-1365900288);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (!iGlobalTelephoneStateStruct.isPhoneReady()) {
            this.clearSearch();
        }
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
            this.log.log(1078071040, "[PhoneIntellicallSearchHandler#keyTyped] %1", (Object)TelLoggingUtils.keyTypedOption(n, n2, n3, n4, n5));
        }
        if (n2 == -1365900288) {
            EvoListRow evoListRow = this.getBaseListModel(n2).getRow(n3);
            switch (n) {
                case 300428: {
                    this.telRslDial(n5, evoListRow);
                    break;
                }
                case 300695: {
                    this.telRslAddToFavorite(n5, evoListRow);
                    break;
                }
                case 300728: {
                    this.telRslDeleteCallStackEntry(n5, evoListRow);
                    break;
                }
                case 301078: {
                    this.getApplication().getTelephoneDSIAccess().deleteAllCallStacks(3, n5);
                    break;
                }
                case 300740: {
                    this.telRslEditNumber(n5, evoListRow);
                    break;
                }
                case 300743: {
                    this.telRslShowContactDetails(n, n5, evoListRow);
                    break;
                }
                case 300840: {
                    this.telRslSendSms(n, n5, evoListRow);
                    break;
                }
                case 300839: {
                    long l = 0L;
                    this.telRslSendEmail(n, n5, evoListRow, l);
                    break;
                }
                default: {
                    this.log.log(-1601830656, "[PhoneIntellicallSearchHandler#keyTyped] no handling for model %1", (long)n);
                    break;
                }
            }
        } else {
            this.log.log(1078071040, "[PhoneIntellicallSearchHandler#keyTyped] NOP!");
        }
    }

    private void telRslSendEmail(int n, int n2, EvoListRow evoListRow, long l) {
        if (evoListRow instanceof IntellicallADBSearchResultRow) {
            l = ((IntellicallADBSearchResultRow)evoListRow).getAdbEntryId();
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            l = ((IntellicallADBEntryDetailsResultRow)evoListRow).getAdbEntryId();
        } else if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            l = ((IntellicallCallStackSearchResultRow)evoListRow).getCallStackEntry().getAdbEntryID();
        }
        if (l > 0L) {
            this.messagingServiceHandler.prepareSendEmail(l);
            this.getOptionModel(n).fireEvent(n2);
        }
    }

    private void telRslSendSms(int n, int n2, EvoListRow evoListRow) {
        if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            this.prepareSendSMSADBEntry((IntellicallADBEntryDetailsResultRow)evoListRow);
        } else if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            this.prepareSendSMSCallStackEntry(((IntellicallCallStackSearchResultRow)evoListRow).getCallStackEntry());
        } else if (evoListRow instanceof IntellicallFavoriteSearchResultRow) {
            this.prepareSendSMSTelFavorite((IntellicallFavoriteSearchResultRow)evoListRow);
        }
        this.getOptionModel(n).fireEvent(n2);
    }

    private void telRslShowContactDetails(int n, int n2, EvoListRow evoListRow) {
        long l = 0L;
        if (evoListRow instanceof IntellicallADBSearchResultRow) {
            l = ((IntellicallADBSearchResultRow)evoListRow).getAdbEntryId();
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            l = ((IntellicallADBEntryDetailsResultRow)evoListRow).getAdbEntryId();
        } else if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            l = ((IntellicallCallStackSearchResultRow)evoListRow).getCallStackEntry().getAdbEntryID();
        }
        if (l > 0L) {
            this.getApplication().getADBHandler().showEntryDetails(l);
            this.getOptionModel(n).fireEvent(n2);
        }
    }

    private void telRslEditNumber(int n, EvoListRow evoListRow) {
        String string = null;
        if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            string = ((AbstractIntellicallSearchResultRow)evoListRow).getTelephoneNumber();
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            string = ((IntellicallADBEntryDetailsResultRow)evoListRow).getNumber();
        }
        if (string != null) {
            this.getButtonModel(1922368512).setStatus(string.length() > 0 ? 1 : 0);
            this.getSpellerModel(-2003434496).setText(string);
            this.getOptionModel(-996801536).fireEvent(n);
        }
    }

    private void telRslDeleteCallStackEntry(int n, EvoListRow evoListRow) {
        if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)evoListRow;
            this.getApplication().getTelephoneDSIAccess().deleteCallStackEntry(intellicallCallStackSearchResultRow.getCallStackEntry().getClEntryType(), intellicallCallStackSearchResultRow.getCallStackEntry().getClEntryID(), n);
        }
    }

    private void telRslAddToFavorite(int n, EvoListRow evoListRow) {
        if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)evoListRow;
            String string = intellicallCallStackSearchResultRow.getName();
            String string2 = intellicallCallStackSearchResultRow.getTelephoneNumber();
            this.getEvoApplication().getFavoriteHandler().addToFavorites(new TelFavoriteStruct(PhoneUtils.getDisplayName(string, string2), string2, intellicallCallStackSearchResultRow.getCallStackEntry().getAdbNumberType()));
            this.getOptionModel(-1751776256).fireEvent(n);
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            String string = intellicallADBEntryDetailsResultRow.getName();
            String string3 = intellicallADBEntryDetailsResultRow.getNumber();
            this.getEvoApplication().getFavoriteHandler().addToFavorites(new TelFavoriteStruct(PhoneUtils.getDisplayName(string, string3), string3, intellicallADBEntryDetailsResultRow.getPhoneNumberType()));
            this.getOptionModel(-1751776256).fireEvent(n);
        }
    }

    private void telRslDial(int n, EvoListRow evoListRow) {
        if (evoListRow instanceof IntellicallCallStackSearchResultRow) {
            IntellicallCallStackSearchResultRow intellicallCallStackSearchResultRow = (IntellicallCallStackSearchResultRow)evoListRow;
            CallStackEntry callStackEntry = intellicallCallStackSearchResultRow.getCallStackEntry();
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromCallStackEntry(callStackEntry, n);
        } else if (evoListRow instanceof IntellicallADBEntryDetailsResultRow) {
            IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow = (IntellicallADBEntryDetailsResultRow)evoListRow;
            this.log.log(-2137614336, "[PhoneIntellicallSearchHandler#childNodeSelected] dialing %1", (Object)intellicallADBEntryDetailsResultRow.getNumber());
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromADBEntry(intellicallADBEntryDetailsResultRow.getEntry(), intellicallADBEntryDetailsResultRow.getPhoneNumberIdx(), n);
        } else if (evoListRow instanceof IntellicallFavoriteSearchResultRow) {
            IntellicallFavoriteSearchResultRow intellicallFavoriteSearchResultRow = (IntellicallFavoriteSearchResultRow)evoListRow;
            ((ITelEvoApplication)this.getApplication()).getIntellicallHandler().dialNumberFromDBEntry(intellicallFavoriteSearchResultRow.getTelephoneNumber(), 0L, intellicallFavoriteSearchResultRow.getName(), (short)intellicallFavoriteSearchResultRow.getPhoneNumberType(), (short)0, null, 0, 0, n);
        }
    }

    private void prepareSendSMSCallStackEntry(CallStackEntry callStackEntry) {
        if (callStackEntry == null) {
            this.log.log(10000, "[PhoneIntellicallSearchHandler#prepareSendSMSCallStackEntry] callStackEntry is null.");
            return;
        }
        String string = callStackEntry.getClNumber();
        long l = callStackEntry.getAdbEntryID();
        int n = callStackEntry.getAdbPhoneDataIndex();
        if (l > 0L) {
            this.messagingServiceHandler.prepareSendSMS(string, l, n);
        } else {
            this.messagingServiceHandler.prepareSendSMS(string);
        }
    }

    private void prepareSendSMSADBEntry(IntellicallADBEntryDetailsResultRow intellicallADBEntryDetailsResultRow) {
        if (intellicallADBEntryDetailsResultRow == null) {
            this.log.log(10000, "[PhoneIntellicallSearchHandler#prepareSendSMSADBEntry] adbPhoneNumberRow is null.");
            return;
        }
        String string = intellicallADBEntryDetailsResultRow.getNumber();
        long l = intellicallADBEntryDetailsResultRow.getAdbEntryId();
        int n = intellicallADBEntryDetailsResultRow.getPhoneNumberIdx();
        this.messagingServiceHandler.prepareSendSMS(string, l, n);
    }

    private void prepareSendSMSTelFavorite(IntellicallFavoriteSearchResultRow intellicallFavoriteSearchResultRow) {
        if (intellicallFavoriteSearchResultRow == null) {
            this.log.log(10000, "[PhoneIntellicallSearchHandler#prepareSendSMSTelFavorite] favoriteSearchRow is null.");
            return;
        }
        String string = intellicallFavoriteSearchResultRow.getTelephoneNumber();
        this.messagingServiceHandler.prepareSendSMS(string);
    }

    void clearSearch() {
        this.searchHandler.clearSearchSpeller();
    }

    @Override
    public void customAction(int n, int n2, int n3, int n4, int n5) {
    }
}

