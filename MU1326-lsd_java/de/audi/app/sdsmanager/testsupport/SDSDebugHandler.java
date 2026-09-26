/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.testsupport.SDSDebugChannelsEnum;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandler$DebugMessage;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSDebugMsgQueueVisibleSizeEnum;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import org.osgi.framework.BundleContext;

public class SDSDebugHandler
extends TestSupportHandler {
    private static final LogChannel LC = Logger.getMainLog();
    private static final SDSDebugHandlerNotification SDS_HANDLER_NOTIF = new SDSDebugHandlerNotification();
    private static volatile SDSDebugHandler instance;
    private static SDSDebugHandler$DebugMessage[] msgQueue;
    private static int msgCounter;
    private static int msgQueueFilledSize;
    private static volatile SDSDebugMsgQueueVisibleSizeEnum msgQueueVisibleSize;

    private SDSDebugHandler(BundleContext bundleContext, String string) {
        super(string, true, true, SDS_HANDLER_NOTIF, bundleContext, LC);
    }

    public static void createSingletonInstance(BundleContext bundleContext, String string) {
        if (instance != null) {
            return;
        }
        instance = new SDSDebugHandler(bundleContext, string);
        instance.init();
        msgQueue = new SDSDebugHandler$DebugMessage[SDSDebugMsgQueueVisibleSizeEnum.getLargestSizeValue()];
        msgQueueFilledSize = 0;
        msgCounter = 1;
        msgQueueVisibleSize = SDSDebugMsgQueueVisibleSizeEnum.MEDIUM;
    }

    public static void deinitSingletonInstance() {
        if (instance != null) {
            instance.deinit();
            instance = null;
            msgQueue = null;
            msgQueueVisibleSize = null;
        }
    }

    public static void addDebugMsg(String string) {
        SDSDebugHandler.addDebugMsg(string, SDSDebugChannelsEnum.DEFAULT);
    }

    public static void addDebugMsg(String string, SDSDebugChannelsEnum sDSDebugChannelsEnum) {
        if (SDS_HANDLER_NOTIF == null || !SDS_HANDLER_NOTIF.isVisible()) {
            return;
        }
        if (SDSUtils.isEmpty(string)) {
            return;
        }
        if (sDSDebugChannelsEnum == null) {
            return;
        }
        if (!sDSDebugChannelsEnum.isActive()) {
            return;
        }
        if (msgQueue == null) {
            return;
        }
        System.arraycopy((Object)msgQueue, 1, (Object)msgQueue, 0, msgQueue.length - 1);
        SDSDebugHandler.msgQueue[SDSDebugHandler.msgQueue.length - 1] = new SDSDebugHandler$DebugMessage(string, sDSDebugChannelsEnum, null);
        if (msgQueueFilledSize < msgQueue.length) {
            ++msgQueueFilledSize;
        }
        SDSDebugHandler.printMsgQueue();
    }

    private static synchronized void printMsgQueue() {
        int n = Math.min(Math.min(msgQueue.length, msgQueueVisibleSize.getSizeValue()), msgQueueFilledSize);
        String[] stringArray = new String[n];
        int n2 = msgQueue.length - n;
        for (int i2 = 0; i2 < n; ++i2) {
            stringArray[i2] = msgQueue[n2 + i2] == null ? "" : msgQueue[n2 + i2].toString();
        }
        instance.updateData(stringArray);
    }

    static SDSDebugMsgQueueVisibleSizeEnum getMsgQueueVisibleSize() {
        return msgQueueVisibleSize;
    }

    static void setMsgQueueVisibleSize(SDSDebugMsgQueueVisibleSizeEnum sDSDebugMsgQueueVisibleSizeEnum) {
        if (sDSDebugMsgQueueVisibleSizeEnum == null || msgQueueVisibleSize.equals(sDSDebugMsgQueueVisibleSizeEnum)) {
            return;
        }
        msgQueueVisibleSize = sDSDebugMsgQueueVisibleSizeEnum;
        SDSDebugHandler.printMsgQueue();
        instance.updateCommandList();
    }

    static void updateCommandListToggledDebugChannels() {
        instance.updateCommandList();
    }

    static /* synthetic */ int access$008() {
        return msgCounter++;
    }
}

