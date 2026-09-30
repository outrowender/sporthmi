/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.ListRow;
import de.audi.atip.hmi.model.ResourceLocatorListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneCallListRowBase
extends ListRow {
    protected static final int DISCREASON_INVALID = -1;
    protected static final int DISCREASON_NORMAL = 0;
    protected static final int DISCREASON_NOLINE = 1;
    protected static final int DISCREASON_SYSTEM_BUSY = 2;
    protected static final int DISCREASON_NUMBER_BUSY = 3;
    protected static final int DISCREASON_NUMBER_NOT_ASSIGNED = 4;
    protected static final int DISCREASON_NUMBER_NOT_REACHABLE = 5;
    protected static final int DISCREASON_NETWORK_FAILURE = 6;
    protected static final int DISCREASON_CALL_BARRING_ACTIVE = 7;
    protected static final int DISCREASON_USER_NOT_RESPONDING = 8;
    protected static final int DISCREASON_CALL_REJECTED = 9;
    protected static final int DISCREASON_NUMBER_CHANGED = 10;
    protected static final int DISCREASON_NUMBER_INVALID_INCOMPLETE = 11;
    protected static final int DISCREASON_SERVICE_NOT_AVAILABLE = 12;
    protected static final int DISCREASON_NO_INFO_AVAILABLE = 13;
    protected static final int DISCREASON_NUMBER_TEMP_FORBIDDEN = 14;
    protected static final int COL_CALLID = 0;
    protected static final int COL_NAME = 1;
    protected static final int COL_PHONETYPEICON = 2;
    protected static final int COL_NUMBER = 3;
    protected static final int COL_ACTION = 4;
    protected static final int COL_CALLDURATION = 5;
    protected static final int COL_DISCONNECTREASON = 6;
    protected static final int COL_PROPERTIES = 7;
    protected static final int COL_RECORDSET_NAME_NUMBER = 8;
    protected static final int COL_CALLTYPE = 9;
    protected static final int COL_CALLSTATE = 10;
    protected static final int COL_RESOURCELOCATOR = 11;
    protected static final int COL_RECORDSET_ACTIVE_NONACTIVE_LAYOUT = 12;
    protected static final int COL_MICMUTESTATE = 13;
    public static final int MAX_COLUMNS = 14;
    private static final int CALLSTATE_INVALID = -1;
    private static final int CALLSTATE_DIALING = 0;
    private static final int CALLSTATE_ACTIVE = 1;
    private static final int CALLSTATE_HOLD = 2;
    private static final int CALLSTATE_DISCONNECTING = 3;
    protected final LogChannel log;
    protected final AbstractPhoneCall call;

    protected static IntegerListCell getDisconnectReason(int n) {
        switch (n) {
            case 0: {
                return IntegerListCell.create(0);
            }
            case 1: {
                return IntegerListCell.create(1);
            }
            case 2: {
                return IntegerListCell.create(2);
            }
            case 3: {
                return IntegerListCell.create(3);
            }
            case 4: {
                return IntegerListCell.create(4);
            }
            case 5: {
                return IntegerListCell.create(5);
            }
            case 6: {
                return IntegerListCell.create(6);
            }
            case 7: {
                return IntegerListCell.create(7);
            }
            case 8: {
                return IntegerListCell.create(8);
            }
            case 9: {
                return IntegerListCell.create(9);
            }
            case 10: {
                return IntegerListCell.create(10);
            }
            case 11: {
                return IntegerListCell.create(11);
            }
            case 12: {
                return IntegerListCell.create(12);
            }
            case 13: {
                return IntegerListCell.create(13);
            }
            case 14: {
                return IntegerListCell.create(14);
            }
        }
        return IntegerListCell.create(-1);
    }

    private static IntegerListCell getCallState(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return IntegerListCell.create(0);
            }
            case 4: {
                return IntegerListCell.create(1);
            }
            case 6: 
            case 8: {
                return IntegerListCell.create(2);
            }
            case 5: {
                return IntegerListCell.create(3);
            }
        }
        return IntegerListCell.create(-1);
    }

    public PhoneCallListRowBase(AbstractPhoneCall abstractPhoneCall, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, LogChannel logChannel, int n) {
        this.log = logChannel;
        this.call = abstractPhoneCall;
        this.setCells(new ListCell[n]);
        this.setListRowCells(abstractPhoneCall, this.cells, iGlobalTelephoneStateStruct);
    }

    private void setListRowCells(AbstractPhoneCall abstractPhoneCall, ListCell[] listCellArray, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (abstractPhoneCall == null) {
            this.log.log(10000, "PhoneCallListRowBase#setListRowCells phoneCall is null");
            return;
        }
        if (iGlobalTelephoneStateStruct == null) {
            this.log.log(10000, "PhoneCallListRowBase#setListRowCells state is null");
            return;
        }
        this.setCell(0, IntegerListCell.create(abstractPhoneCall.getTelCallID()));
        this.setCell(1, TextListCell.create(iGlobalTelephoneStateStruct.getDisplayName(abstractPhoneCall)));
        this.setCell(3, TextListCell.create(iGlobalTelephoneStateStruct.getDisplayNumber(abstractPhoneCall)));
        String string = PhoneUtils.getDisplayCallDuration(abstractPhoneCall.getTelCallState(), abstractPhoneCall.getCallDuration());
        this.setCell(5, TextListCell.create(string));
        this.setCell(6, PhoneCallListRowBase.getDisconnectReason(abstractPhoneCall.getDisconnectReason()));
        this.setCell(2, IntegerListCell.create(ADBModelUtils.getIconTypeForPhoneNumber(abstractPhoneCall.getTelRemNumberType())));
        this.setCell(10, PhoneCallListRowBase.getCallState(abstractPhoneCall.getTelCallState()));
        ResourceLocator resourceLocator = abstractPhoneCall.getTelRemPictureId();
        if (resourceLocator != null) {
            this.setCell(11, new ResourceLocatorListCell(resourceLocator.getId(), resourceLocator.getUrl()));
        }
    }

    public boolean equals(Object object) {
        if (object instanceof PhoneCallListRowBase) {
            return ((PhoneCallListRowBase)object).getCell(0) == this.getCell(0);
        }
        return false;
    }

    public int hashCode() {
        int n = 17;
        n = 31 * n + this.getCell(0).hashCode();
        return n;
    }

    public int getCallID() {
        return this.call.getTelCallID();
    }

    public ResourceLocator getPicture() {
        return this.call.getTelRemPictureId();
    }
}

