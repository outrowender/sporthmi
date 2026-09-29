/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.testsupport.DefaultTestSupportHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSSettingsEnum;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.BundleContext;

public final class SDSSettingsHandlerNotification
extends DefaultTestSupportHandlerNotification {
    private static final LogChannel LC = Logger.getMainLog();
    private static final SDSSettingsHandlerNotification INSTANCE = new SDSSettingsHandlerNotification();
    private static TestSupportHandler testSupportHandler = null;

    private SDSSettingsHandlerNotification() {
    }

    public static void createSingletonInstance(BundleContext bundleContext, String string) {
        if (testSupportHandler != null) {
            return;
        }
        testSupportHandler = new TestSupportHandler(string, false, true, INSTANCE, bundleContext, LC);
        testSupportHandler.init();
    }

    public static void deinitSingletonInstance() {
        if (testSupportHandler != null) {
            testSupportHandler.deinit();
            testSupportHandler = null;
        }
    }

    @Override
    public void commandEntrySelected(int n) {
        SDSSettingsEnum sDSSettingsEnum = SDSSettingsEnum.getSDSSettingByIndex(n);
        if (sDSSettingsEnum == null) {
            LC.log(10000, "SDSSettingsHandlerNotification#commandEntrySelected: Entry with index %1 does not exist => NOP!", (long)n);
            return;
        }
        sDSSettingsEnum.toggleActivationStatus();
        testSupportHandler.updateCommandList();
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        int n = SDSSettingsEnum.getChannelsSize();
        TestSupportDataReceiverEntry[] testSupportDataReceiverEntryArray = new TestSupportDataReceiverEntry[n];
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.clear();
            SDSSettingsEnum sDSSettingsEnum = SDSSettingsEnum.getSDSSettingByIndex(i2);
            if (sDSSettingsEnum == null) {
                LC.log(10000, "SDSSettingsHandlerNotification#getCommandEntries: Access with index %1 is out of bounds => break!", (long)i2);
                break;
            }
            testSupportDataReceiverEntryArray[i2] = new TestSupportDataReceiverEntry(i2, buffer.append(sDSSettingsEnum.getChannelName()).toString(), true, sDSSettingsEnum.isActive());
        }
        return testSupportDataReceiverEntryArray;
    }
}

