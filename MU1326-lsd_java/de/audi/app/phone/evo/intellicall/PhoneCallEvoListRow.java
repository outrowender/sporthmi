/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.addressbook.core.common.ADBModelUtils;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneCallEvoListRow
extends EvoListRow {
    public static final int MAX_COLUMNS;
    public static final int MAX_ROWS;
    public static final int CANCEL_ICON_INVALID;
    public static final int CANCEL_ICON_HANGUP;
    public static final int CANCEL_ICON_HOLD;
    public static final int ACTION_HANGUP;
    public static final int ACTION_SWAP;
    public static final int ACTION_NONE;
    protected static final int DISCREASON_INVALID;
    protected static final int DISCREASON_NORMAL;
    protected static final int DISCREASON_NOLINE;
    protected static final int DISCREASON_SYSTEM_BUSY;
    protected static final int DISCREASON_NUMBER_BUSY;
    protected static final int DISCREASON_NUMBER_NOT_ASSIGNED;
    protected static final int DISCREASON_NUMBER_NOT_REACHABLE;
    protected static final int DISCREASON_NETWORK_FAILURE;
    protected static final int DISCREASON_CALL_BARRING_ACTIVE;
    protected static final int DISCREASON_USER_NOT_RESPONDING;
    protected static final int DISCREASON_CALL_REJECTED;
    protected static final int DISCREASON_NUMBER_CHANGED;
    protected static final int DISCREASON_NUMBER_INVALID_INCOMPLETE;
    protected static final int DISCREASON_SERVICE_NOT_AVAILABLE;
    protected static final int DISCREASON_NO_INFO_AVAILABLE;
    protected static final int DISCREASON_NUMBER_TEMP_FORBIDDEN;
    protected static final int COL_CALLID;
    protected static final int COL_NAME;
    protected static final int COL_PHONETYPEICON;
    protected static final int COL_NUMBER;
    protected static final int COL_DISCONNECTING_DISABLED_PRIMARY_ACTION_TEXT;
    protected static final int COL_CALLDURATION;
    protected static final int COL_DISCONNECTREASON;
    protected static final int COL_PROPERTIES;
    protected static final int COL_RECORDSET_NAME_NUMBER;
    protected static final int COL_CALLTYPE_ICON;
    protected static final int COL_CANCEL_ICON;
    protected static final int COL_RESOURCELOCATOR;
    protected static final int COL_RECORDSET_ACTIVE_NONACTIVE_LAYOUT;
    protected static final int COL_TEXT_SECOND_LINE_ACTIVE_CALL;
    protected static final int COL_TEXT_SECOND_LINE_HELD_CALL;
    protected static final int COL_TEXT_THIRD_LINE_ACTIVE_CALL;
    private static final long SECS_PER_HOUR;
    private static final long SECS_PER_MINUTE;
    private static final int RECORDSET_USE_NAME_COLUMN;
    private static final int RECORDSET_USE_CALLTYPE_COLUMN;
    private static final int RECORDSET_LARGE_ACTIVE_ADBMATCH;
    private static final int RECORDSET_LARGE_ACTIVE_NO_ADBMATCH;
    private static final int RECORDSET_LARGE_DIALING_ALEARTING_ADBMATCH;
    private static final int RECORDSET_LARGE_DIALING_ALEARTING_NO_ADBMATCH;
    private static final int RECORDSET_LARGE_DISCONNECTING_ACTIVE_ALEARING_DIALING_ADBMATCH;
    private static final int RECORDSET_LARGE_DISCONNECTING_ACTIVE_ALEARING_DIALING_NO_ADBMATCH;
    private static final int RECORDSET_LARGE_HOLD_ADBMATCH;
    private static final int RECORDSET_LARGE_HOLD_NO_ADBMATCH;
    private static final int RECORDSET_LARGE_DISCONNECTING_HOLD_RINGING_ADBMATCH;
    private static final int RECORDSET_LARGE_DISCONNECTING_HOLD_RINGING_NO_ADBMATCH;
    private static final int RECORDSET_SMALL_ACTIVE_ADBMATCH;
    private static final int RECORDSET_SMALL_ACTIVE_NO_ADBMATCH;
    private static final int RECORDSET_SMALL_DIALING_ALEARTING_ADBMATCH;
    private static final int RECORDSET_SMALL_DIALING_ALEARTING_NO_ADBMATCH;
    private static final int RECORDSET_SMALL_DISCONNECTING_ACTIVE_ALEARING_DIALING_ADBMATCH;
    private static final int RECORDSET_SMALL_DISCONNECTING_ACTIVE_ALEARING_DIALING_NO_ADBMATCH;
    private static final int RECORDSET_SMALL_HOLD_ADBMATCH;
    private static final int RECORDSET_SMALL_HOLD_NO_ADBMATCH;
    private static final int RECORDSET_SMALL_DISCONNECTING_HOLD_RINGING_ADBMATCH;
    private static final int RECORDSET_SMALL_DISCONNECTING_HOLD_RINGING_NO_ADBMATCH;
    private static final int CALLTYPEICON_DUMMY_SINGLE;
    private static final int CALLTYPEICON_SINGLE_PICTURE;
    private static final int CALLTYPEICON_DUMMY_CONFERENCE;
    private volatile int primaryAction = 2;
    protected final LogChannel log;
    protected final AbstractPhoneCall call;
    private final int nrCallRows;
    private ITelApplication phoneApplication;

    public PhoneCallEvoListRow(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2, int n, LogChannel logChannel, int n2, ITelApplication iTelApplication) {
        super(abstractPhoneCall.getTelCallID(), n2);
        this.log = logChannel;
        this.call = abstractPhoneCall;
        this.nrCallRows = n;
        this.phoneApplication = iTelApplication;
        this.setListRowCells(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState, iTelDSIMobileEquipmentDeviceState2);
    }

    public PhoneCallEvoListRow(PhoneCallEvoListRow phoneCallEvoListRow, LogChannel logChannel, int n, AbstractPhoneCall abstractPhoneCall) {
        super(phoneCallEvoListRow);
        this.log = logChannel;
        this.call = abstractPhoneCall;
        this.nrCallRows = n;
        this.primaryAction = phoneCallEvoListRow.primaryAction;
    }

    public PhoneCallEvoListRow(AbstractPhoneCall abstractPhoneCall, LogChannel logChannel) {
        super(abstractPhoneCall.getTelCallID(), 16);
        this.log = logChannel;
        this.call = abstractPhoneCall;
        this.nrCallRows = 1;
        this.setListRowCellsForEmergencyCall(abstractPhoneCall);
    }

    final int getPrimaryAction() {
        return this.primaryAction;
    }

    public AbstractPhoneCall getCall() {
        return this.call;
    }

    public int getCallID() {
        return this.call.getTelCallID();
    }

    public ResourceLocator getPicture() {
        return this.call.getTelRemPictureId();
    }

    @Override
    public EvoListRow copy() {
        return new PhoneCallEvoListRow(this, this.log, this.nrCallRows, this.call);
    }

    protected static String getDisplayCallDuration(int n, long l) {
        if (n == 4 || n == 6) {
            return PhoneCallEvoListRow.formatTime(l);
        }
        return "";
    }

    private static String formatTime(long l) {
        Buffer buffer = new Buffer();
        long l2 = l / 0;
        long l3 = l % 0 / 0;
        long l4 = l % 0;
        String string = Long.toString(l2);
        if (l2 > 0L) {
            buffer.append(string);
            buffer.append(':');
        }
        if (l3 < 0 && l2 > 0L) {
            buffer.append('0');
        }
        buffer.append(Long.toString(l3));
        buffer.append(':');
        if (l4 < 0) {
            buffer.append('0');
        }
        buffer.append(Long.toString(l4));
        return buffer.toString();
    }

    private int getCancelIconValue(AbstractPhoneCall abstractPhoneCall) {
        int n;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#getCancelIconValue] phoneCall is null.");
            return -1;
        }
        block0 : switch (abstractPhoneCall.getTelCallState()) {
            case 1: 
            case 2: 
            case 4: {
                n = 1;
                break;
            }
            case 6: 
            case 8: {
                n = 2;
                break;
            }
            case 5: {
                switch (abstractPhoneCall.getPreviousCallState()) {
                    case 1: 
                    case 2: 
                    case 4: {
                        n = 1;
                        break block0;
                    }
                    case 6: 
                    case 8: {
                        n = 2;
                        break block0;
                    }
                }
                n = -1;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    private static int getCallTypeIcon(AbstractPhoneCall abstractPhoneCall) {
        return abstractPhoneCall != null && abstractPhoneCall.isConferenceCall() ? 2 : (PhoneUtils.isPictureAvailable(abstractPhoneCall.getTelRemPictureId()) ? 1 : 0);
    }

    private PropertyListCell getProperties(AbstractPhoneCall abstractPhoneCall) {
        PropertyListCell propertyListCell;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallEvoListRow#getProperties] phoneCall is null.");
            return PropertyListCell.create(0, new int[0]);
        }
        boolean bl = abstractPhoneCall.isConferenceCall();
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
            case 6: 
            case 8: {
                propertyListCell = PropertyListCell.create(bl ? 1686777316 : 674348036, new int[0]);
                break;
            }
            default: {
                propertyListCell = PropertyListCell.create(0, new int[0]);
            }
        }
        return propertyListCell;
    }

    private static boolean hasPhoneTypeIcon(AbstractPhoneCall abstractPhoneCall) {
        return abstractPhoneCall != null && abstractPhoneCall.telRemNumberType != -1;
    }

    private static boolean hasRemoteName(AbstractPhoneCall abstractPhoneCall) {
        return abstractPhoneCall != null && !StringUtilities.isNullOrEmpty(abstractPhoneCall.getTelRemName());
    }

    private static boolean isAddressBookRecord(AbstractPhoneCall abstractPhoneCall) {
        return abstractPhoneCall != null && abstractPhoneCall.getTelRemEntryId() > 0L || PhoneCallEvoListRow.hasRemoteName(abstractPhoneCall) && PhoneCallEvoListRow.hasPhoneTypeIcon(abstractPhoneCall);
    }

    private static boolean useLargeLayout(int n) {
        return n <= 1;
    }

    private int getSimpleCallStateLayout(AbstractPhoneCall abstractPhoneCall) {
        int n = -1;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallEvoListRow#getSimpleCallStateLayout] phoneCall is null.");
            return n;
        }
        block0 : switch (abstractPhoneCall.getTelCallState()) {
            case 4: {
                n = 1;
                break;
            }
            case 1: 
            case 2: {
                n = 3;
                break;
            }
            case 5: {
                int n2 = abstractPhoneCall.getPreviousCallState();
                switch (n2) {
                    case 1: 
                    case 2: 
                    case 4: {
                        n = 5;
                        break block0;
                    }
                    case 3: 
                    case 6: 
                    case 8: {
                        n = 9;
                        break block0;
                    }
                }
                break;
            }
            case 6: 
            case 8: {
                n = 7;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    private static int recordSetLayoutForCallStateActive(boolean bl, boolean bl2) {
        int n = -1;
        n = bl ? (bl2 ? 0 : 10) : (bl2 ? 1 : 11);
        return n;
    }

    private static int recordSetLayoutForCallStateDialing(boolean bl, boolean bl2) {
        int n = -1;
        n = bl ? (bl2 ? 2 : 12) : (bl2 ? 3 : 13);
        return n;
    }

    private int recordSetLayoutForCallStateDisconnecting(boolean bl, boolean bl2, AbstractPhoneCall abstractPhoneCall, CallStateStruct callStateStruct) {
        int n = -1;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallEvoListRow#recordSetLayoutForCallStateDisconnecting] phoneCall is null.");
            return n;
        }
        int n2 = abstractPhoneCall.getPreviousCallState();
        switch (n2) {
            case 1: 
            case 2: 
            case 4: {
                if (bl) {
                    n = bl2 ? 4 : (callStateStruct != null && callStateStruct.isHasActiveCall() ? 18 : 14);
                    break;
                }
                n = bl2 ? 5 : (callStateStruct != null && callStateStruct.isHasActiveCall() ? 19 : 15);
                break;
            }
            case 3: 
            case 6: 
            case 8: {
                if (bl) {
                    n = bl2 ? 8 : 18;
                    break;
                }
                n = bl2 ? 9 : 19;
                break;
            }
        }
        return n;
    }

    private static int recordSetLayoutForCallStateHold(boolean bl, boolean bl2) {
        int n = -1;
        n = bl ? (bl2 ? 6 : 16) : (bl2 ? 7 : 17);
        return n;
    }

    private int getCallStateLayout(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, int n) {
        int n2 = -1;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#getCallStateLayout] phoneCall is null.");
            return n2;
        }
        CallStateStruct callStateStruct = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() : null;
        boolean bl = PhoneCallEvoListRow.isAddressBookRecord(abstractPhoneCall);
        boolean bl2 = PhoneCallEvoListRow.useLargeLayout(n);
        switch (abstractPhoneCall.getTelCallState()) {
            case 4: {
                n2 = PhoneCallEvoListRow.recordSetLayoutForCallStateActive(bl, bl2);
                break;
            }
            case 1: 
            case 2: {
                n2 = PhoneCallEvoListRow.recordSetLayoutForCallStateDialing(bl, bl2);
                break;
            }
            case 5: {
                n2 = this.recordSetLayoutForCallStateDisconnecting(bl, bl2, abstractPhoneCall, callStateStruct);
                break;
            }
            case 6: 
            case 8: {
                n2 = PhoneCallEvoListRow.recordSetLayoutForCallStateHold(bl, bl2);
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    private int getCallStatusText(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        int n = 0;
        if (abstractPhoneCall != null && iTelDSIMobileEquipmentDeviceState != null) {
            if (iTelDSIMobileEquipmentDeviceState.getTelMode() == 3 && iTelDSIMobileEquipmentDeviceState.getHandsFreeMode() == 4) {
                n = 3;
            } else if (iTelDSIMobileEquipmentDeviceState.getmICMuteState() == 0) {
                n = 1;
            } else if (abstractPhoneCall.isConferenceCall()) {
                n = 2;
            }
        }
        return n;
    }

    private void setListRowCellsForEmergencyCall(AbstractPhoneCall abstractPhoneCall) {
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#setListRowCellsForEmergencyCall] phoneCall is null.");
            return;
        }
        int n = PhoneCallEvoListRow.getCallTypeIcon(abstractPhoneCall);
        this.setInteger(0, abstractPhoneCall.getTelCallID());
        this.setText(1, abstractPhoneCall.getTelRemName());
        this.setText(3, abstractPhoneCall.getTelRemNumber());
        this.setText(5, "");
        this.setInteger(6, abstractPhoneCall.getDisconnectReason());
        this.setInteger(2, ADBModelUtils.getIconTypeForPhoneNumber(abstractPhoneCall.getTelRemNumberType()));
        this.setInteger(10, this.getCancelIconValue(abstractPhoneCall));
        this.determinePrimaryAction(abstractPhoneCall);
        this.setInteger(4, this.getPriamryActionText(abstractPhoneCall));
        this.setHMIResourceLocator(11, abstractPhoneCall.getHMIResourceLocator());
        this.setInteger(8, n == 0 ? 0 : 1);
        this.setInteger(9, n);
        this.setPropertyCell(7, this.getProperties(abstractPhoneCall));
        this.setInteger(12, this.getSimpleCallStateLayout(abstractPhoneCall));
        this.setInteger(13, 0);
        this.setInteger(14, abstractPhoneCall.isConferenceCall() ? 1 : 0);
        this.setText(15, abstractPhoneCall.getTelRemNumber());
    }

    private void setListRowCells(AbstractPhoneCall abstractPhoneCall, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2) {
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#setListRowCells] phoneCall is null.");
            return;
        }
        if (iTelDSIMobileEquipmentDeviceState == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#setListRowCells] callLeadingState is null.");
            return;
        }
        this.setInteger(0, abstractPhoneCall.getTelCallID());
        this.setText(1, iTelDSIMobileEquipmentDeviceState.getDisplayName(abstractPhoneCall));
        this.setText(3, iTelDSIMobileEquipmentDeviceState.getDisplayNumber(abstractPhoneCall));
        this.setText(5, PhoneCallEvoListRow.getDisplayCallDuration(abstractPhoneCall.getTelCallState(), abstractPhoneCall.getCallDuration()));
        this.setInteger(6, abstractPhoneCall.getDisconnectReason());
        this.setInteger(2, ADBModelUtils.getIconTypeForPhoneNumber(abstractPhoneCall.getTelRemNumberType()));
        this.setInteger(10, this.getCancelIconValue(abstractPhoneCall));
        this.determinePrimaryAction(abstractPhoneCall);
        this.setInteger(4, this.getPriamryActionText(abstractPhoneCall));
        this.setHMIResourceLocator(11, abstractPhoneCall.getHMIResourceLocator());
        int n = PhoneCallEvoListRow.getCallTypeIcon(abstractPhoneCall);
        this.setInteger(8, n == 0 ? 0 : 1);
        this.setInteger(9, n);
        this.setPropertyCell(7, this.getProperties(abstractPhoneCall));
        this.setInteger(12, this.getCallStateLayout(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState, this.nrCallRows));
        this.setInteger(13, this.getCallStatusText(abstractPhoneCall, iTelDSIMobileEquipmentDeviceState));
        this.setInteger(14, abstractPhoneCall.isConferenceCall() ? 1 : 0);
        this.setText(15, this.getThirdLineTextIntegerValue(iTelDSIMobileEquipmentDeviceState, iTelDSIMobileEquipmentDeviceState2));
    }

    private String getThirdLineTextIntegerValue(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2) {
        String string;
        boolean bl;
        boolean bl2 = iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
        boolean bl3 = iTelDSIMobileEquipmentDeviceState2 != null ? iTelDSIMobileEquipmentDeviceState2.isPhoneReady() : false;
        boolean bl4 = bl2 ? iTelDSIMobileEquipmentDeviceState.isRoleAssociated() : false;
        boolean bl5 = bl3 ? iTelDSIMobileEquipmentDeviceState2.isRoleAssociated() : false;
        boolean bl6 = bl = bl4 || bl5;
        if (bl) {
            string = iTelDSIMobileEquipmentDeviceState != null ? (this.isHFPorSAP(iTelDSIMobileEquipmentDeviceState) ? this.getBtDeviceName(iTelDSIMobileEquipmentDeviceState) : this.getSIMText()) : "";
            this.log.log(-2137614336, "[PhoneCallListRow#getThirdLineTextIntegerValue] activeCallAt %1", (Object)string);
        } else {
            string = "";
        }
        return string;
    }

    private boolean isHFPorSAP(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getTelMode() == 3 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 2 || iTelDSIMobileEquipmentDeviceState.getTelMode() == 1 : false;
    }

    private String getBtDeviceName(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? (iTelDSIMobileEquipmentDeviceState.getPhoneInformation() != null ? (iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName() != null ? iTelDSIMobileEquipmentDeviceState.getPhoneInformation().getMeFriendlyName() : "") : "") : "";
    }

    private String getSIMText() {
        return this.phoneApplication.getTextFactory() != null ? this.phoneApplication.getTextFactory().getText(13) : "";
    }

    private int getPriamryActionText(AbstractPhoneCall abstractPhoneCall) {
        int n;
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#getPriamryActionText] phoneCall is null.");
            return 2;
        }
        block0 : switch (abstractPhoneCall.getTelCallState()) {
            case 1: 
            case 2: 
            case 4: {
                n = 0;
                break;
            }
            case 5: {
                switch (abstractPhoneCall.getPreviousCallState()) {
                    case 1: 
                    case 2: 
                    case 4: {
                        n = 0;
                        break block0;
                    }
                    case 6: 
                    case 8: {
                        n = 1;
                        break block0;
                    }
                }
                n = 2;
                break;
            }
            case 6: 
            case 8: {
                n = 1;
                break;
            }
            default: {
                n = 2;
            }
        }
        return n;
    }

    private void determinePrimaryAction(AbstractPhoneCall abstractPhoneCall) {
        if (abstractPhoneCall == null) {
            this.log.log(-2137614336, "[PhoneCallListRow#determinePrimaryAction] phoneCall is null.");
            this.primaryAction = 2;
            return;
        }
        int n = abstractPhoneCall.getTelCallState();
        switch (n) {
            case 1: 
            case 2: 
            case 4: {
                this.primaryAction = 0;
                break;
            }
            case 6: 
            case 8: {
                this.primaryAction = 1;
                break;
            }
            default: {
                this.primaryAction = 2;
                this.log.log(-2137614336, "[PhoneCallListRow#determinePrimaryAction] no primary action for call state %1", (long)n);
            }
        }
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(super.toString());
        buffer.append(", action=");
        buffer.append(this.getPrimaryAction());
        return buffer.toString();
    }
}

