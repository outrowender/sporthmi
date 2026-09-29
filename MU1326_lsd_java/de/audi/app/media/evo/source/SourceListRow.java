/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.source;

import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.logger.LogUtil;
import de.audi.app.media.source.ISourceSlot;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.esolutions.fw.util.commons.Buffer;

public class SourceListRow
extends EvoListRow {
    static final int HMI_SLOT_STATE_EMPTY;
    static final int HMI_SLOT_STATE_LOADING;
    static final int HMI_SLOT_STATE_LOADED;
    static final int HMI_SLOT_STATE_WRONG_REGION_CODE_NO_CHANGES_LEFT;
    static final int HMI_SLOT_STATE_WRONG_REGION_CODE_CHANGES_LEFT;
    static final int HMI_SLOT_STATE_CHILDLOCK;
    static final int HMI_SLOT_STATE_IMPORT_RUNNING;
    static final int HMI_SLOT_STATE_NO_PLAYABLE_FILES;
    static final int HMI_SLOT_STATE_DELETION_RUNNING;
    static final int HMI_SLOT_STATE_OVERCURRENT;
    static final int HMI_SLOT_STATE_TEMPERATURE_TOO_HIGH;
    static final int HMI_SLOT_STATE_TEMPERATURE_TOO_LOW;
    static final int HMI_SLOT_STATE_BT_DEACTIVATED_CLAMP_S_OFF;
    static final int HMI_SLOT_STATE_BT_DEACTIVATED;
    static final int HMI_SLOT_STATE_BT_AUDIOPLAYER_DEACTIVATED;
    static final int HMI_SLOT_STATE_BT_AUDIOPLAYER_NOT_CONNECTED;
    static final int HMI_SLOT_STATE_BT_RECONNECTING;
    static final int HMI_SLOT_STATE_DEVICE_UNAVAILABLE;
    static final int HMI_SLOT_STATE_UNREADABLE;
    static final int HMI_SLOT_STATE_UNSUPPORTED;
    static final int HMI_SLOT_STATE_UNSUPPORTED_WRONG_FIRMWARE;
    static final int HMI_SLOT_STATE_WLAN_DEACTIVATED_CLAMP_S_OFF;
    static final int HMI_SLOT_STATE_WLAN_DEACTIVATED;
    static final int HMI_SLOT_STATE_JUKEBOX_NOT_FILLED;
    static final int HMI_SLOT_STATE_CORRUPTED_PARTITION;
    static final int HMI_SLOT_STATE_IMPORT_DISABLED;
    static final int HMI_SLOT_STATE_CHARGING;
    static final int HMI_SLOT_STATE_ONLINE_DEACTIVATED_CLAMP_S_OFF;
    static final int HMI_SLOT_STATE_ONLINE_DEACTIVATED_WLAN_OFF;
    static final int HMI_SLOT_STATE_ONLINE_DEACTIVATED_WLAN_NO_CONN;
    static final int HMI_SLOT_STATE_ONLINE_NO_APP;
    static final int HMI_SLOT_STATE_WLAN_NO_DEVICE_CONNECTED;
    static final int HMI_SLOT_STATE_USB_NOT_CONNECTED;
    static final int HMI_SLOT_STATE_WLAN_NO_APP;
    private static final IntMap SLOTSTATEMAP;
    private static final String[] SLOT_STATE_STR;
    public static final int COMPLETE_SOURCE;
    public static final int DEFAULT_DEVICE_INDEX;
    private static final int REC_SET_SLOT_STATUS;
    private static final int REC_SET_MEDIA_TYPE;
    private static final int REC_SET_MEDIA_NAME;
    private static final String[] REC_STATE_STR;
    protected static final int COLUMN_SIZE;
    private static final int COL_RECORD_SET;
    private static final int COL_SLOT_STATE;
    private static final int COL_MEDIA_TYPE;
    private static final int COL_MEDIA_NAME;
    private static final int COL_SOURCE_ICON;
    private static final int COL_ENABLED;
    private static final int COL_SOURCE_REFLECTION_ICON;
    private static final int OFFSET_ENABLED_SOURCE_ICON;
    private static final int OFFSET_DISABLED_SOURCE_ICON;
    private final int orderID;
    private final int sourceType;
    private final int slotIdx;
    private final boolean importDisabled;

    public SourceListRow(int n, int n2, ISourceSlot iSourceSlot, boolean bl) {
        super(n, 7);
        int n3;
        this.importDisabled = bl;
        this.orderID = n2;
        this.sourceType = iSourceSlot.getSource().getType();
        this.slotIdx = iSourceSlot.getIndex();
        int n4 = this.getHMISlotState(iSourceSlot);
        switch (n4) {
            case 2: {
                if (iSourceSlot.getName() == null || iSourceSlot.getName().length() == 0) {
                    n3 = 1;
                    break;
                }
                n3 = 2;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        this.setInteger(0, n3);
        this.setInteger(1, this.getHMISlotState(iSourceSlot));
        this.setInteger(2, MediaUtils.getHMIMediaType(iSourceSlot.getMediaType()));
        this.setText(3, iSourceSlot.getName());
        boolean bl2 = MediaUtils.isSlotEnabledInHMISourceList(iSourceSlot);
        this.setInteger(5, bl2 ? 1 : 0);
        int n5 = MediaUtils.getHMISourceIcon(iSourceSlot) + (bl2 ? 0 : 50);
        this.setHMIResourceLocator(4, new HMIResourceLocator(n5, iSourceSlot.getActiveSourceListIcon()));
        this.setHMIResourceLocator(6, new HMIResourceLocator(n5, iSourceSlot.getActiveSourceListReflectionIcon()));
    }

    public SourceListRow(int n, int n2, int n3, int n4, int n5, boolean bl, int n6) {
        super(n, 7);
        this.importDisabled = bl;
        this.orderID = n2;
        this.sourceType = n3;
        this.slotIdx = n4;
        this.setInteger(0, 0);
        if (n6 == 0) {
            this.setInteger(1, 10 == n3 ? 32 : 0);
        } else {
            this.setInteger(1, SourceListRow.getHMISlotState(n6, this.importDisabled));
        }
        this.setInteger(2, MediaUtils.getHMIMediaType(0));
        this.setText(3, null);
        int n7 = MediaUtils.getHMISourceIcon(n3, n4, n5, 0) + 50;
        this.setHMIResourceLocator(4, new HMIResourceLocator(n7, HMIResourceLocator.UNDEFINED_URI));
        this.setHMIResourceLocator(6, new HMIResourceLocator(n7, HMIResourceLocator.UNDEFINED_URI));
        this.setInteger(5, MediaUtils.isSourceEnabled(n3) ? 1 : 0);
    }

    public SourceListRow(SourceListRow sourceListRow) {
        super(sourceListRow);
        this.importDisabled = sourceListRow.importDisabled;
        this.orderID = sourceListRow.orderID;
        this.sourceType = sourceListRow.sourceType;
        this.slotIdx = sourceListRow.slotIdx;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getSlotIdx() {
        return this.slotIdx;
    }

    public int getOrderKey() {
        return this.orderID;
    }

    public boolean isEnabled() {
        return this.getInteger(5) == 1;
    }

    private int getHMISlotState(ISourceSlot iSourceSlot) {
        switch (iSourceSlot.getState()) {
            case 0: {
                return 10 == iSourceSlot.getSource().getType() ? 32 : 0;
            }
            case 1: 
            case 2: {
                return 1;
            }
            case 3: {
                return SourceListRow.getHMISlotState(iSourceSlot.getError(), this.importDisabled);
            }
        }
        return 0;
    }

    static int getHMISlotState(int n, boolean bl) {
        if (n == 22) {
            return bl ? 25 : 23;
        }
        try {
            return SLOTSTATEMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return 2;
        }
    }

    @Override
    public EvoListRow copy() {
        return new SourceListRow(this);
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append(this.getOrderKey()).append(" - ").append(LogUtil.getSourceTypeStr(this.getSourceType())).append(this.getSlotIdx());
        buffer.append(" - ");
        buffer.append(REC_STATE_STR[this.getInteger(0)]);
        buffer.append(" - ");
        buffer.append(SLOT_STATE_STR[this.getInteger(1)]);
        buffer.append(" - ");
        buffer.append(this.getInteger(5) == 1 ? "Enabled" : "Disabled");
        HMIResourceLocator hMIResourceLocator = (HMIResourceLocator)this.getCell(4);
        if (hMIResourceLocator != null) {
            String string = hMIResourceLocator.getResourceURI();
            if (string != null && string.length() != 0) {
                buffer.append(" - ");
                buffer.append(string);
            }
            buffer.append(" - ");
            buffer.append(hMIResourceLocator.getResourceID());
        }
        return buffer.toString();
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.importDisabled ? 1231 : 1237);
        n = 31 * n + this.orderID;
        n = 31 * n + this.slotIdx;
        n = 31 * n + this.sourceType;
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        SourceListRow sourceListRow = (SourceListRow)object;
        if (this.importDisabled != sourceListRow.importDisabled) {
            return false;
        }
        if (this.orderID != sourceListRow.orderID) {
            return false;
        }
        if (this.slotIdx != sourceListRow.slotIdx) {
            return false;
        }
        return this.sourceType == sourceListRow.sourceType;
    }

    static {
        SLOTSTATEMAP = new IntMap(45);
        SLOTSTATEMAP.put(10, 14);
        SLOTSTATEMAP.put(11, 15);
        SLOTSTATEMAP.put(12, 13);
        SLOTSTATEMAP.put(13, 12);
        SLOTSTATEMAP.put(14, 16);
        SLOTSTATEMAP.put(3, 5);
        SLOTSTATEMAP.put(23, 24);
        SLOTSTATEMAP.put(6, 8);
        SLOTSTATEMAP.put(15, 17);
        SLOTSTATEMAP.put(19, 0);
        SLOTSTATEMAP.put(4, 6);
        SLOTSTATEMAP.put(5, 7);
        SLOTSTATEMAP.put(7, 9);
        SLOTSTATEMAP.put(8, 10);
        SLOTSTATEMAP.put(9, 11);
        SLOTSTATEMAP.put(16, 18);
        SLOTSTATEMAP.put(17, 19);
        SLOTSTATEMAP.put(18, 20);
        SLOTSTATEMAP.put(20, 21);
        SLOTSTATEMAP.put(21, 22);
        SLOTSTATEMAP.put(29, 31);
        SLOTSTATEMAP.put(30, 33);
        SLOTSTATEMAP.put(1, 3);
        SLOTSTATEMAP.put(2, 4);
        SLOTSTATEMAP.put(24, 26);
        SLOTSTATEMAP.put(25, 27);
        SLOTSTATEMAP.put(26, 28);
        SLOTSTATEMAP.put(27, 29);
        SLOTSTATEMAP.put(28, 30);
        SLOT_STATE_STR = new String[]{"EMPTY", "LOADING", "LOADED", "WRONG REGION CODE (NO CHANGES)", "WRONG REGION CODE", "CHILDLOCK", "IMPORT RUNNING", "NO PLAYABLE FILES", "DELETION RUNNING", "OVERCURRENT", "TEMP HIGH", "TEMP LOW", "BT DEACTIVATED CLAMP", "BT DEACTIVATED", "BT AP DEACTIVATED", "BT AP NOT CONNECTED", "RECONNECT", "DEVICE UNAVAILABLE", "UNREADABLE", "UNSUPPORTED", "WRONG FIRMWARE", "WLAN CLAMP OFF", "WLAN OFF", "JUKEBOX NOT FILLED", "CORRUPT PARTITION", "IMPORT_DISABLED", "CHARGING", "ONLINE CLAMPS OFF", "ONLINE DEACTIVATED WLAN OFF", "ONLINE DEACTIVATED NO_CONN", "ONLINE NO APP", "HMI_SLOT_STATE_WLAN_NO_DEVICE_CONNECTED", "HMI_SLOT_STATE_USB_NOT_CONNECTED", "HMI_SLOT_STATE_WLAN_NO_APP"};
        REC_STATE_STR = new String[]{"STATUS", "TYPE", "NAME"};
    }
}

