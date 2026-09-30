/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import org.dsi.ifc.telephoneng.CallStackEntry;

public abstract class AbstractCallStackEntryRow
extends BaseListRow {
    protected static final int COL_ID = 0;
    protected static final int COL_IDX_LLD = 1;
    protected static final int COL_IDX_ICONID = 2;
    protected static final int COL_NAME = 3;
    protected static final int COL_NUMBER = 4;
    protected static final int COL_DATE = 5;
    protected static final int COL_TIME = 6;
    protected static final int COL_IDX_PROPERTIES = 7;
    protected static final int COL_PHONENUMBERTYPE_ICON = 8;
    protected static final int COL_TIMESTAMP_AVAILABLE = 9;
    private static final int LLD_ADBMATCH = 0;
    private static final int LLD_ADBMATCH_SAME_NAME_NUMBER = 1;
    private static final int LLD_NO_ADBMATCH = 2;
    private static final int LLD_NO_ADBMATCH_UNKNOWN_NUMBER = 3;
    private static final int ICONID_UNDEFINED = -1;
    private static final int ICONID_CALLSTACK_LD = 0;
    private static final int ICONID_CALLSTACK_MC = 1;
    private static final int ICONID_CALLSTACK_RC = 2;
    protected final CallStackEntry callStackEntry;
    protected final LogChannel log;
    private final String displayName;
    private final String displayNumber;

    public AbstractCallStackEntryRow(ListCell[] listCellArray, CallStackEntry callStackEntry, LogChannel logChannel, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        super(listCellArray);
        if (callStackEntry == null) {
            throw new IllegalArgumentException("TelEvoCallStackRow: callStackEntry is null!");
        }
        this.callStackEntry = callStackEntry;
        this.log = logChannel;
        this.displayName = iGlobalTelephoneStateStruct.getDisplayName(callStackEntry.getClName(), callStackEntry.getClNumber());
        this.displayNumber = iGlobalTelephoneStateStruct.getDisplayNumber(callStackEntry.getClName(), callStackEntry.getClNumber());
        listCellArray[0] = IntegerListCell.create(this.callStackEntry.getClEntryID());
        listCellArray[1] = this.getRecordSetColumn(iGlobalTelephoneStateStruct);
        listCellArray[2] = this.getIconID(this.callStackEntry.getClEntryType());
        listCellArray[3] = TextListCell.create(this.getDisplayName());
        listCellArray[4] = TextListCell.create(this.getDisplayNumber());
        listCellArray[5] = this.getDate();
        listCellArray[6] = this.getTime();
        listCellArray[8] = IntegerListCell.create(this.getIconTypeForPhoneNumber(this.displayNumber));
        listCellArray[9] = IntegerListCell.create(TelCallStacksUtils.hasValidTimestamp(this.callStackEntry) ? 1 : 0);
    }

    private int getIconTypeForPhoneNumber(String string) {
        if (string != null && string.length() > 0) {
            return ADBModelUtils.getIconTypeForPhoneNumber(this.callStackEntry.getAdbNumberType());
        }
        return 9;
    }

    public CallStackEntry getCallStackEntry() {
        return this.callStackEntry;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDisplayNumber() {
        return this.displayNumber;
    }

    protected IntegerListCell getIconID(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            default: {
                this.log.log(100000, "[TelEvoCallStackRow#setIconID] no call stack type found for %1", (long)n);
                n2 = -1;
            }
        }
        return IntegerListCell.create(n2);
    }

    protected final IntegerListCell getRecordSetColumn(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        boolean bl;
        String string = this.callStackEntry.getClNumber();
        String string2 = this.callStackEntry.getClName();
        int n = 2;
        boolean bl2 = string2 != null && string2.length() > 0;
        boolean bl3 = bl = string != null && string.length() > 0;
        n = iGlobalTelephoneStateStruct != null && (bl2 && bl || iGlobalTelephoneStateStruct.isEmergencyNumber(string) || iGlobalTelephoneStateStruct.isInfoNumber(string) || iGlobalTelephoneStateStruct.isBreakdownNumber(string) || iGlobalTelephoneStateStruct.isMailboxNumber(string)) ? (string.equals(string2) ? 1 : 0) : (bl ? 2 : 3);
        return IntegerListCell.create(n);
    }

    protected final TextListCell getDate() {
        if (TelCallStacksUtils.hasValidTimestamp(this.callStackEntry)) {
            DateMetric dateMetric = new DateMetric(TelCallStacksUtils.getDate(this.callStackEntry), 0);
            return TextListCell.create(dateMetric.format());
        }
        return TextListCell.create("");
    }

    protected final TextListCell getTime() {
        if (TelCallStacksUtils.hasValidTimestamp(this.callStackEntry)) {
            DateMetric dateMetric = new DateMetric(TelCallStacksUtils.getDate(this.callStackEntry), 1);
            return TextListCell.create(dateMetric.format());
        }
        return TextListCell.create("");
    }
}

