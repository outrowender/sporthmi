/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.testsupport.DefaultTestSupportHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSDebugChannelsEnum;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandler;
import de.audi.app.sdsmanager.testsupport.SDSDebugMsgQueueVisibleSizeEnum;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.esolutions.fw.util.commons.Buffer;

public class SDSDebugHandlerNotification
extends DefaultTestSupportHandlerNotification {
    private volatile boolean testSupportDebugVisible = false;
    private static final int DEBUG_CHANNEL_START_ENTRY_ID = 1;

    public boolean isVisible() {
        return this.testSupportDebugVisible;
    }

    public void debugDataVisible(boolean bl) {
        this.testSupportDebugVisible = bl;
    }

    public void commandEntrySelected(int n) {
        if (n == 0) {
            SDSDebugMsgQueueVisibleSizeEnum sDSDebugMsgQueueVisibleSizeEnum = SDSDebugHandler.getMsgQueueVisibleSize().getNextSize();
            SDSDebugHandler.setMsgQueueVisibleSize(sDSDebugMsgQueueVisibleSizeEnum);
            return;
        }
        if (n - 1 < SDSDebugChannelsEnum.getChannelsSize()) {
            SDSDebugChannelsEnum.getChannelByIndex(n - 1).toggleActivationStatus();
            SDSDebugHandler.updateCommandListToggledDebugChannels();
            return;
        }
    }

    public TestSupportDataReceiverEntry[] getCommandEntries() {
        int n = 1 + SDSDebugChannelsEnum.getChannelsSize();
        TestSupportDataReceiverEntry[] testSupportDataReceiverEntryArray = new TestSupportDataReceiverEntry[n];
        Buffer buffer = new Buffer();
        testSupportDataReceiverEntryArray[0] = new TestSupportDataReceiverEntry(0, buffer.append("Toggle message queue size: ").append(SDSDebugHandler.getMsgQueueVisibleSize()).toString(), false, false);
        for (int i2 = 0; i2 < SDSDebugChannelsEnum.getChannelsSize(); ++i2) {
            buffer.clear();
            SDSDebugChannelsEnum sDSDebugChannelsEnum = SDSDebugChannelsEnum.getChannelByIndex(i2);
            if (sDSDebugChannelsEnum == null) {
                sDSDebugChannelsEnum = SDSDebugChannelsEnum.DEFAULT;
            }
            testSupportDataReceiverEntryArray[i2 + 1] = new TestSupportDataReceiverEntry(i2 + 1, buffer.append("Debug channel ").append(sDSDebugChannelsEnum.getChannelName()).toString(), true, sDSDebugChannelsEnum.isActive());
        }
        return testSupportDataReceiverEntryArray;
    }
}

