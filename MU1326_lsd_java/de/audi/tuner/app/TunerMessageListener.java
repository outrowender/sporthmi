/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.msg.MsgListener;
import de.audi.atip.util.NowPlayingScreenController;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.listener.MessageListener;
import de.audi.tuner.itunes.TaggingManager;
import java.util.ArrayList;
import java.util.List;

public class TunerMessageListener
implements MsgListener {
    private final Logger logger;
    private final TunerBasics basics;
    private final AnnouncementHandler announcement;
    private final TaggingManager taggingMgr;
    private final MemoryListHandler memory;
    private final NowPlayingScreenController npsControler;
    private final ILogoDatabase logoDatabase;
    private final List messageListeners = new ArrayList(10);

    TunerMessageListener(TunerBasics tunerBasics, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, TaggingManager taggingManager, MemoryListHandler memoryListHandler, NowPlayingScreenController nowPlayingScreenController, ILogoDatabase iLogoDatabase) {
        this.basics = tunerBasics;
        this.logger = tunerBasics.getLogger();
        this.announcement = announcementHandler;
        this.taggingMgr = taggingManager;
        this.memory = memoryListHandler;
        this.npsControler = nowPlayingScreenController;
        this.logoDatabase = iLogoDatabase;
    }

    public void addMessageListener(MessageListener messageListener) {
        this.logger.main.log(10000000, "[TunerMessageListener.addMessageListener] %1", (Object)messageListener);
        this.messageListeners.add(messageListener);
    }

    public void processMsg(int n) {
        switch (n) {
            case 29: {
                this.logger.main.log(1000000, "Resetting Tuner to default values.");
                TunerProxyManager.getInstance().getDABTuner().resetToDefaultSettings();
                TunerProxyManager.getInstance().getAmFmTuner().resetToDefaultSettings();
                TunerProxyManager.getInstance().getSDARSTuner().resetToDefaultSettings();
                this.npsControler.resetToFactorySettings();
                this.announcement.resetToDefaultSettings();
                if (this.taggingMgr != null) {
                    this.taggingMgr.reset();
                }
                this.memory.clearMemoryList();
                this.logoDatabase.resetToDefaultSettings();
                this.basics.getModels().setActiveList(this.basics.getModels().getActiveTuner());
                for (int i2 = 0; i2 < this.messageListeners.size(); ++i2) {
                    try {
                        MessageListener messageListener = (MessageListener)this.messageListeners.get(i2);
                        messageListener.resetToDefaultSettings();
                        continue;
                    }
                    catch (Exception exception) {
                        this.logger.main.log(10000, "Exception: ", (Throwable)exception);
                    }
                }
                break;
            }
            case 34: {
                this.memory.clearMemoryListForHardKeys();
                break;
            }
            case 3: {
                break;
            }
            case 43: {
                this.logger.main.log(100000, "[TunerMessageListener.processMessage] DiagnosisSession active");
                this.basics.getStatus().setDiagnosisActive(true);
                break;
            }
            case 44: {
                this.logger.main.log(100000, "[TunerMessageListener.processMessage] DiagnosisSession inactive");
                this.basics.getStatus().setDiagnosisActive(false);
                break;
            }
            case 11: {
                this.logger.main.log(1000000, "[TunerMessageListener.processMessage] UNITS_CHANGED");
                for (int i3 = 0; i3 < this.messageListeners.size(); ++i3) {
                    try {
                        MessageListener messageListener = (MessageListener)this.messageListeners.get(i3);
                        messageListener.unitsChanged();
                        continue;
                    }
                    catch (Exception exception) {
                        this.logger.main.log(10000, "Exception: ", (Throwable)exception);
                    }
                }
                break;
            }
            case 80: {
                this.logger.main.log(1000000, "[TunerMessageListener.processMessage] DEBUG_INFO_DAB_ON");
                TunerProxyManager.getInstance().getDABTuner().switchDebugInfos(true);
                break;
            }
            case 81: {
                this.logger.main.log(1000000, "[TunerMessageListener.processMessage] DEBUG_INFO_DAB_OFF");
                TunerProxyManager.getInstance().getDABTuner().switchDebugInfos(false);
                break;
            }
        }
    }
}

