/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.car.LockingBits;
import java.io.Serializable;

public class RemoteHmiLockingCoding
implements LockingBits,
Serializable {
    private static final long serialVersionUID;
    public static final Object[][] LOCKING_DATA;
    private final boolean[] lockingBitCoding = new boolean[LOCKING_DATA.length];
    private final String[] lockingBitKeys = new String[LOCKING_DATA.length];

    public static RemoteHmiLockingCoding create(HMIService hMIService, LogChannel logChannel) {
        if (hMIService == null) {
            return null;
        }
        RemoteHmiLockingCoding remoteHmiLockingCoding = new RemoteHmiLockingCoding();
        for (int i2 = 0; i2 < LOCKING_DATA.length; ++i2) {
            String string = (String)LOCKING_DATA[i2][0];
            ChoiceModelApp choiceModelApp = hMIService.getChoiceModel((Integer)LOCKING_DATA[i2][1]);
            if (choiceModelApp != null) {
                boolean bl = choiceModelApp.getValue() == 1;
                logChannel.log(-2137614336, "RemoteHmiLockingCoding#create() %1: %2", (Object)string, (Object)Boolean.toString(bl));
                remoteHmiLockingCoding.setLockingBit(i2, string, bl);
                continue;
            }
            logChannel.log(-1601830656, "RemoteHmiLockingCoding#create() Unkown model for key %1", (Object)string);
        }
        return remoteHmiLockingCoding;
    }

    private RemoteHmiLockingCoding() {
    }

    private void setLockingBit(int n, String string, boolean bl) {
        this.lockingBitKeys[n] = string;
        this.lockingBitCoding[n] = bl;
    }

    @Override
    public boolean getLockingBit(String string) {
        if (string == null || string.length() == 0) {
            return false;
        }
        int n = -1;
        for (int i2 = 0; i2 < this.lockingBitKeys.length; ++i2) {
            if (!string.equals(this.lockingBitKeys[i2])) continue;
            n = i2;
            break;
        }
        if (n == -1) {
            return false;
        }
        return this.lockingBitCoding[n];
    }

    @Override
    public String[] availableKeys() {
        return this.lockingBitKeys;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RemoteHmiLockingCoding[Keys: ").append(this.lockingBitKeys.length).append(" ");
        for (int i2 = 0; i2 < this.lockingBitKeys.length; ++i2) {
            stringBuffer.append(this.lockingBitKeys[i2]).append("=").append(this.lockingBitCoding[i2]).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    static {
        LOCKING_DATA = new Object[][]{{"FB_CAR_0", new Integer(5608)}, {"FB_MEDIA_0", new Integer(5587)}, {"FB_MEDIA_1", new Integer(5597)}, {"FB_MEDIA_2", new Integer(5592)}, {"FB_MEDIA_3", new Integer(5618)}, {"FB_NAV_1", new Integer(5590)}, {"FB_NAV_0", new Integer(5593)}, {"FB_NAV_2", new Integer(5598)}, {"FB_NAV_3", new Integer(5613)}, {"FB_PHONE_0", new Integer(5588)}, {"FB_MISC_0", new Integer(5600)}, {"FB_MISC_1", new Integer(5601)}, {"FB_MISC_2", new Integer(5604)}, {"FB_MISC_3", new Integer(5605)}, {"FB_MISC_4", new Integer(5603)}, {"FB_MISC_5", new Integer(5602)}, {"FB_MISC_6", new Integer(5606)}, {"FB_MISC_7", new Integer(5607)}, {"FB_TUNER_0", new Integer(5584)}};
    }
}

