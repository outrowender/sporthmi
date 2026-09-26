/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.calllist;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.calllist.PhoneCallListRowBase;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class PhoneCallListRowEvo
extends PhoneCallListRowBase {
    static final int ACTION_HANGUP;
    static final int ACTION_SWAP;
    static final int ACTION_NONE;
    private static final int RECORDSET_USE_NAME_COLUMN;
    private static final int RECORDSET_USE_CALLTYPE_COLUMN;
    private static final int RECORDSET_ACTIVE_ADBMATCH;
    private static final int RECORDSET_ACTIVE_NO_ADBMATCH;
    private static final int RECORDSET_NONACTIVE_ADBMATCH;
    private static final int RECORDSET_NONACTIVE_NO_ADBMATCH;
    private static final int RECORDSET_ADBMATCH_DISCONNECTING;
    private static final int RECORDSET_NO_ADBMATCH_DISCONNECTING;
    private static final int RECORDSET_ADBMATCH_HELD;
    private static final int RECORDSET_NO_ADBMATCH_HELD;
    static final int MAX_ROWS;
    private volatile int action = 2;

    private static PropertyListCell getProperties(AbstractPhoneCall abstractPhoneCall) {
        PropertyListCell propertyListCell;
        boolean bl = abstractPhoneCall instanceof ConferenceCall;
        switch (abstractPhoneCall.getTelCallState()) {
            case 4: {
                propertyListCell = PropertyListCell.create(bl ? -1870334089 : -2092804066, new int[0]);
                break;
            }
            case 1: 
            case 2: {
                propertyListCell = PropertyListCell.create(bl ? 305144287 : 1274181782, new int[0]);
                break;
            }
            case 5: {
                propertyListCell = PropertyListCell.create(bl ? -1896195209 : -180290914, new int[0]);
                break;
            }
            case 6: {
                propertyListCell = PropertyListCell.create(bl ? 1686777316 : 674348036, new int[0]);
                break;
            }
            default: {
                propertyListCell = PropertyListCell.create(0, new int[0]);
            }
        }
        return propertyListCell;
    }

    private static IntegerListCell getCallStateLayout(AbstractPhoneCall abstractPhoneCall) {
        boolean bl;
        int n = -1;
        boolean bl2 = abstractPhoneCall.getTelCallState() == 4;
        boolean bl3 = bl = abstractPhoneCall.getTelRemEntryId() > 0L || abstractPhoneCall.getTelRemName() != null && abstractPhoneCall.getTelRemName().length() > 0;
        n = bl2 ? (bl ? 0 : 1) : (abstractPhoneCall.getTelCallState() == 5 ? (bl ? 4 : 5) : (abstractPhoneCall.getTelCallState() == 6 ? (bl ? 6 : 7) : (bl ? 2 : 3)));
        return IntegerListCell.create(n);
    }

    public PhoneCallListRowEvo(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, LogChannel logChannel) {
        super(abstractPhoneCall, iGlobalTelephoneStateStruct, logChannel, 14);
        this.setEvoCells(abstractPhoneCall, iGlobalTelephoneStateStruct);
    }

    private static int getCallType(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        int n = -1;
        if (abstractPhoneCall != null) {
            if (abstractPhoneCall.isConferenceCall() && abstractPhoneCall.getTelCallType() == 4) {
                n = 5;
            } else {
                String string = abstractPhoneCall.getTelRemNumber();
                if (string == null || string.length() == 0) {
                    n = 4;
                } else if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isEmergencyNumber(string) && abstractPhoneCall.getTelCallType() == 3) {
                    n = 3;
                } else if (iGlobalTelephoneStateStruct.isMailboxNumber(string)) {
                    n = 0;
                } else if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isInfoNumber(string) && abstractPhoneCall.getTelCallType() == 5) {
                    n = 1;
                } else if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.isBreakdownNumber(string) && abstractPhoneCall.getTelCallType() == 6) {
                    n = 2;
                }
            }
        }
        return n;
    }

    private void setEvoCells(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        switch (abstractPhoneCall.getTelCallState()) {
            case 4: {
                this.setAction(0);
                break;
            }
            case 1: 
            case 2: {
                this.setAction(0);
                break;
            }
            case 5: {
                this.setAction(2);
                break;
            }
            case 6: {
                this.setAction(1);
                break;
            }
            default: {
                this.setAction(2);
                this.log.log(-1601830656, "[PhoneCallListRow#PhoneCallListRow] no call state handling for call state %1", (long)this.getAction());
            }
        }
        this.setCell(4, IntegerListCell.create(this.getAction()));
        int n = PhoneCallListRowEvo.getCallType(abstractPhoneCall, iGlobalTelephoneStateStruct);
        this.setCell(8, IntegerListCell.create(n == -1 ? 0 : 1));
        this.setCell(9, IntegerListCell.create(n));
        this.setCell(7, PhoneCallListRowEvo.getProperties(abstractPhoneCall));
        this.setCell(12, PhoneCallListRowEvo.getCallStateLayout(abstractPhoneCall));
        this.setCell(13, IntegerListCell.create(iGlobalTelephoneStateStruct.getmICMuteState() == 0 ? 1 : 0));
    }

    final int getAction() {
        return this.action;
    }

    private void setAction(int n) {
        this.action = n;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(super.toString());
        buffer.append(", action=");
        buffer.append(this.getAction());
        return buffer.toString();
    }
}

