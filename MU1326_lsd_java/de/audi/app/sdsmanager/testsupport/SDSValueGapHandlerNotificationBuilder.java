/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.testsupport.SDSValueEntryGapHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSValueEnum;
import org.osgi.framework.BundleContext;

public class SDSValueGapHandlerNotificationBuilder {
    private static SDSValueEntryGapHandlerNotification topEntryGap;
    private static SDSValueEntryGapHandlerNotification followupEntryGap;

    public static void createSingletonInstances(BundleContext bundleContext, SDSAdapter sDSAdapter) {
        topEntryGap = new SDSValueEntryGapHandlerNotification(bundleContext, "AppSDS-TopEntryGap", SDSValueEnum.TOP_ENTRY_GAP, sDSAdapter);
        followupEntryGap = new SDSValueEntryGapHandlerNotification(bundleContext, "AppSDS-FollowupEntryGap", SDSValueEnum.FOLLOWUP_ENTRY_GAP, sDSAdapter);
    }

    public static void deinitSingletonInstances() {
        topEntryGap.deinit();
        followupEntryGap.deinit();
    }
}

