/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.testsupport.SDSStatisticsDataConverter;
import de.audi.app.sdsmanager.testsupport.SDSStatisticsHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SLMRulesMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.NBestListEntry;
import org.osgi.framework.BundleContext;

public final class SDSStatisticsHandler
extends TestSupportHandler {
    private static final LogChannel LC = Logger.getMainLog();
    private static final SDSStatisticsHandlerNotification SDS_HANDLER_NOTIF = new SDSStatisticsHandlerNotification();
    private static SDSStatisticsDataConverter dataConverter;
    private static SDSStatisticsHandler instance;

    private SDSStatisticsHandler(BundleContext bundleContext, String string, SLMRulesMap sLMRulesMap) {
        super(string, true, false, SDS_HANDLER_NOTIF, bundleContext, LC);
        dataConverter = new SDSStatisticsDataConverter(sLMRulesMap);
    }

    public static void createSingletonInstance(BundleContext bundleContext, String string, SLMRulesMap sLMRulesMap) {
        if (instance != null) {
            LC.log(-2137614336, "SDSStatisticsHandler#createSingletonInstance: SDS-statistics singleton already created!");
            return;
        }
        LC.log(-2137614336, "SDSStatisticsHandler#createSingletonInstance: Create instance now!");
        instance = new SDSStatisticsHandler(bundleContext, string, sLMRulesMap);
        instance.init();
    }

    public static void deinitSingletonInstance() {
        if (instance != null) {
            instance.deinit();
        } else {
            LC.log(-1601830656, "SDSStatisticsHandler#deinitSingletonInstance: SDS-statistics singleton not existing!");
        }
    }

    public static void addSpeechRecognitionData(NBestList nBestList) {
        if (!SDS_HANDLER_NOTIF.isVisible()) {
            return;
        }
        NBestListEntry nBestListEntry = SDSUtils.isEmpty(nBestList) ? null : nBestList.getEntries()[0];
        String[] stringArray = dataConverter.getLastSDSCommandInfos(nBestListEntry);
        LC.log(-2137614336, "SDSStatisticsHandler#addSpeechRecognitionData: %1", (Object)SDSUtils.toString(stringArray, true));
        instance.updateData(stringArray);
    }
}

