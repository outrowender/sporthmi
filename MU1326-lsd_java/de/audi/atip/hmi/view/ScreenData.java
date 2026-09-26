/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Converter;

public final class ScreenData
implements IScreenData {
    private final int id;
    private final boolean reinit;
    private final boolean animated;
    private final int[] states;
    private final boolean locked;
    private int[] partialPopups;
    private long[] contextIDs;
    private int popupId;
    private int popupPriority;
    private boolean notify = true;
    private final long selectionDrawerID;
    private final long optionsDrawerID;
    private final int animationInfo;
    private int colorScheme;
    private int screenMode;
    private Screen screen;
    private final AdditionalScreenData metaInfos;
    private int zpmPopupPriority;
    private int zpmPopupSlotID;

    public ScreenData() {
        this(-1, false, false, null, false, null, null, null, -1L, -1L, 0, 0, 0, null);
    }

    public ScreenData(boolean bl) {
        this(-1, bl, false, null, false, null, null, null, -1L, -1L, 0, 0, 0, null);
    }

    public ScreenData(int n, boolean bl, boolean bl2, int[] nArray, boolean bl3, Screen screen, int[] nArray2, long[] lArray, long l, long l2, int n2, int n3, int n4, AdditionalScreenData additionalScreenData) {
        this.id = n;
        this.screen = screen;
        this.reinit = bl;
        this.animated = bl2;
        this.states = nArray;
        this.locked = bl3;
        this.partialPopups = nArray2;
        this.popupId = 0;
        this.popupPriority = 0;
        this.zpmPopupPriority = 0;
        this.zpmPopupSlotID = 0;
        this.contextIDs = lArray;
        this.selectionDrawerID = l;
        this.optionsDrawerID = l2;
        this.animationInfo = n2;
        this.colorScheme = n3;
        this.screenMode = n4;
        this.metaInfos = additionalScreenData;
    }

    public ScreenData(int n, boolean bl, boolean bl2, int[] nArray, boolean bl3, Screen screen, int[] nArray2, int n2, int n3, int n4, boolean bl4, int n5, long[] lArray, long l, long l2, int n6, int n7, int n8, AdditionalScreenData additionalScreenData) {
        this(n, bl, bl2, nArray, bl3, screen, nArray2, lArray, l, l2, n6, n7, n8, additionalScreenData);
        this.popupId = n2;
        this.setNotify(bl4);
        this.popupPriority = n5;
        this.zpmPopupPriority = n3;
        this.zpmPopupSlotID = n4;
    }

    public ScreenData(ScreenData screenData) {
        this.id = screenData.id;
        this.screen = screenData.screen;
        this.reinit = screenData.reinit;
        this.animated = screenData.animated;
        this.states = screenData.states;
        this.locked = screenData.locked;
        this.partialPopups = screenData.partialPopups;
        this.popupId = screenData.popupId;
        this.popupPriority = screenData.popupPriority;
        this.contextIDs = screenData.contextIDs;
        this.selectionDrawerID = screenData.getSelectionDrawerID();
        this.optionsDrawerID = screenData.getOptionsDrawerID();
        this.animationInfo = screenData.getAnimationInfo();
        this.colorScheme = screenData.getColorScheme();
        this.screenMode = screenData.getScreenMode();
        this.metaInfos = screenData.getMetaInfos();
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer(200);
        if (this.getId() == 0) {
            buffer.append("--");
        } else {
            buffer.append("ScreenData(id:");
            buffer.append(this.getId());
            buffer.append(this.isReinit() ? " reinit" : "");
            buffer.append(this.isAnimated() ? " animated" : "");
            if (this.getStates() != null) {
                buffer.append(" states: ");
                buffer.append(Converter.intArrayToString(this.getStates()));
            }
            if (this.getPartialPopups() != null) {
                buffer.append(" partial popups: ");
                buffer.append(Converter.intArrayToString(this.getPartialPopups()));
            }
            if (this.getContextIDs() != null) {
                buffer.append(" context IDs: ");
                for (int i2 = 0; i2 < this.contextIDs.length; ++i2) {
                    buffer.append(this.contextIDs[i2]).append(",");
                }
            }
            buffer.append(this.isLocked() ? " locked" : "");
            buffer.append(" selectionDrawerID:").append(this.selectionDrawerID);
            buffer.append(" optionDrawerID:").append(this.optionsDrawerID);
            if (this.isPopup()) {
                buffer.append(" popupId: ");
                buffer.append(this.getPopupId());
                buffer.append(" popupPriority: ");
                buffer.append(this.getPopupPriority());
                if (this.isNotify()) {
                    buffer.append(" notify");
                }
                buffer.append(" zpmPrio: ").append(this.zpmPopupPriority);
                buffer.append(" zpmSlotID: ").append(this.zpmPopupSlotID);
            }
            buffer.append(" cursorPosition: ").append(this.getCursorPosition());
            buffer.append(" colorScheme: ").append(this.colorScheme);
            buffer.append(" screenMode: ").append(this.getScreenModeString());
            buffer.append(" animationInfo: ").append(this.animationInfo);
            buffer.append(')');
        }
        return buffer.toString();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int[] getPartialPopups() {
        return this.partialPopups;
    }

    @Override
    public int getPopupId() {
        return this.popupId;
    }

    @Override
    public int getPopupPriority() {
        return this.popupPriority;
    }

    @Override
    public Screen getScreen() {
        return this.screen;
    }

    @Override
    public int[] getStates() {
        return this.states;
    }

    @Override
    public boolean isAnimated() {
        return this.animated;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isNotify() {
        return this.notify;
    }

    @Override
    public boolean isReinit() {
        return this.reinit;
    }

    @Override
    public boolean isScreenIDValid() {
        return this.id > -1;
    }

    @Override
    public void setNotify(boolean bl) {
        this.notify = bl;
    }

    @Override
    public void setPartialPopups(int[] nArray) {
        this.partialPopups = nArray;
    }

    @Override
    public boolean isPartialPopupAvailable() {
        return this.partialPopups != null && this.partialPopups.length > 0;
    }

    @Override
    public boolean isPopup() {
        return this.popupId != 0;
    }

    @Override
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public long[] getContextIDs() {
        return this.contextIDs;
    }

    @Override
    public void setContextIDs(long[] lArray) {
        this.contextIDs = lArray;
    }

    @Override
    public long getSelectionDrawerID() {
        return this.selectionDrawerID;
    }

    @Override
    public long getOptionsDrawerID() {
        return this.optionsDrawerID;
    }

    @Override
    public int getAnimationInfo() {
        return this.animationInfo;
    }

    @Override
    public int getColorScheme() {
        return this.colorScheme;
    }

    @Override
    public void setColorScheme(int n) {
        this.colorScheme = n;
    }

    @Override
    public int getScreenMode() {
        return this.screenMode;
    }

    @Override
    public void setScreenMode(int n) {
        this.screenMode = n;
    }

    private String getScreenModeString() {
        switch (this.screenMode) {
            case 2: {
                return "OPTION_SCREEN";
            }
            case 1: {
                return "STANDARD_SCREEN";
            }
        }
        return Integer.toString(this.screenMode);
    }

    public AdditionalScreenData getMetaInfos() {
        return this.metaInfos;
    }

    @Override
    public int getCursorPosition() {
        if (this.metaInfos != null) {
            try {
                Integer n = (Integer)this.metaInfos.getData(1);
                if (n != null) {
                    return n;
                }
            }
            catch (ClassCastException classCastException) {
                return -1;
            }
        }
        return -1;
    }

    @Override
    public boolean isStayOnFocusedElement() {
        if (this.metaInfos != null) {
            try {
                Boolean bl = (Boolean)this.metaInfos.getData(2);
                if (bl != null) {
                    return bl;
                }
            }
            catch (ClassCastException classCastException) {
                return false;
            }
        }
        return false;
    }

    public int getZpmPopupPriority() {
        return this.zpmPopupPriority;
    }

    public int getZpmPopupSlotID() {
        return this.zpmPopupSlotID;
    }
}

