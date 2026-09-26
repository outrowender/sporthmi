/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.util.osgi.NullDSIAudioManagement;
import org.dsi.ifc.audio.DSIAudioManagement;

public class AudioEnv {
    public final IFrameworkAccess framework;
    private DSIAudioManagement dsiAudio;
    public final LogChannel lcDSI;
    public final LogChannel lcMain;
    public final LogChannel lcVol;
    public final LogChannel lcSDIS;

    public AudioEnv(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.lcDSI = iFrameworkAccess.getLogChannel("Fw.Audio.DSI");
        this.lcMain = iFrameworkAccess.getLogChannel("Fw.Audio.Main");
        this.lcVol = iFrameworkAccess.getLogChannel("Fw.Audio.Volume");
        this.lcSDIS = iFrameworkAccess.getLogChannel("Fw.Audio.SDIS");
        this.dsiAudio = new NullDSIAudioManagement(this.lcDSI);
    }

    public DSIAudioManagement getDSIAudio() {
        return this.dsiAudio;
    }

    public void setDSIAudo(DSIAudioManagement dSIAudioManagement) {
        this.dsiAudio = dSIAudioManagement;
    }

    private final IHMIServiceApp getHMIService() {
        return this.framework.getHmiServiceApp();
    }

    public IStorageAccess getStorageAccess() {
        return this.framework.getStorageMgr();
    }

    public int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    public boolean isFrontUnit() {
        return this.framework.isFrontMU();
    }

    public boolean isRearUnit() {
        return !this.framework.isFrontMU();
    }

    public ChoiceModelApp getChoiceModel(int n, int n2) {
        return this.getHMIService().getChoiceModel(n, n2);
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.getHMIService().getButtonModel(n);
    }

    public ListModelApp getListModel(int n) {
        return this.getHMIService().getListModel(n);
    }

    public RangeModelApp getRangeModel(int n, int n2) {
        return this.getHMIService().getRangeModel(n, n2);
    }

    public void showRSEBTPopup(int n) {
    }

    public void removeRSEBTPopup(int n) {
    }

    public boolean isSWDLActive() {
        return this.framework.getSysApp().isEngineeringDownloadActive() || this.framework.getSysApp().isCustomerDownloadActive();
    }

    public boolean isHigh() {
        return this.framework.isEvoHigh() || this.framework.isPorscheHigh() || this.framework.isBentley();
    }

    public void logStartupEvent(String string) {
        this.framework.getStartupMgr().logStartupEvent(string);
    }

    public IErrorManager getErrorMgr() {
        return this.framework.getErrorMgr();
    }

    public Integer getIntegerVMOption(String string) {
        if (string == null) {
            return null;
        }
        return Integer.getInteger(string);
    }
}

