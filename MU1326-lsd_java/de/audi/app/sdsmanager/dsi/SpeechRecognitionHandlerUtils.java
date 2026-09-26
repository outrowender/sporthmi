/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.common.Logger;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.speechrec.DSISpeechRec;
import org.dsi.ifc.speechrec.Grammar;
import org.dsi.ifc.speechrec.GrammarInfo;

class SpeechRecognitionHandlerUtils {
    private LogChannel lc = Logger.getDSIASRLog();
    private DSISpeechRec dsiSR;
    private int profileID = 0;

    SpeechRecognitionHandlerUtils() {
    }

    void stop() {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#stop] called");
        this.dsiSR = null;
    }

    void unsetDSISR() {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#unsetDSISR] called");
        this.dsiSR = null;
    }

    public DSISpeechRec getDSISR() {
        return this.dsiSR;
    }

    public void setDSISR(DSISpeechRec dSISpeechRec) {
        this.dsiSR = dSISpeechRec;
    }

    boolean requestVDECapabilities(String string) {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#requestVDECapabilities] country=%1", (Object)string);
        if (this.dsiSR == null) {
            this.lc.log(-1601830656, "[SpeechRecognitionHandlerUtils#requestVDECapabilities] No DSISpeechRec available!");
            return false;
        }
        this.dsiSR.requestVDECapabilities(string);
        return true;
    }

    void startPostTraining(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#startPostTraining] id=%1", (long)n);
        this.profileID = n;
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#startPostTraining] No DSISpeechRec available!");
            return;
        }
        this.dsiSR.startPostTraining(n);
    }

    void stopPostTraining() {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#stopPostTraining] No DSISpeechRec available!");
            return;
        }
        this.dsiSR.stopPostTraining();
    }

    void loadProfile(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#loadProfile] id=%1", (long)n);
        this.profileID = n;
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#loadProfile] No DSISpeechRec available!");
            return;
        }
        this.dsiSR.loadProfile(n);
    }

    void unloadProfile() {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#loadProfile] profileID=%1", (long)this.profileID);
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#unloadProfile] No DSISpeechRec available!");
            return;
        }
        this.dsiSR.unloadProfile(this.profileID);
    }

    void deleteProfile(int n) {
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#deleteProfile] id=%1", (long)n);
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#deleteProfile] No DSISpeechRec available!");
            return;
        }
        this.dsiSR.deleteProfile(n);
    }

    public void setMaxCommandNBestListSize(int n) {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#setMaxCommandNBestListSize] No DSISpeechRec available!");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#setMaxCommandNBestListSize] Setting MaxCommandNBestListSize to %1!", (long)n);
        this.dsiSR.setMaxCommandNBestListSize(n);
    }

    public void setMaxSlotNBestListSize(int n) {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#setMaxSlotNBestListSize] No DSISpeechRec available!");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#setMaxSlotNBestListSize] Setting MaxSlotNBestListSize to %1!", (long)n);
        this.dsiSR.setMaxSlotNBestListSize(n);
    }

    public void setUnambiguousResultThreshold(int n) {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#setUnambiguousResultThreshold] No DSISpeechRec available!");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#setUnambiguousResultThreshold] Setting UnambiguousResultThreshold to %1!", (long)n);
        this.dsiSR.setUnambiguousResultThreshold(n);
    }

    public void setUnambiguousResultRange(int n) {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#setUnambiguousResultRange] No DSISpeechRec available!");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#setUnambiguousResultRange] Setting UnambiguousResultRange to %1!", (long)n);
        this.dsiSR.setUnambiguousResultRange(n);
    }

    public void setFirstLevelSize(int n) {
        if (this.dsiSR == null) {
            this.lc.log(10000, "[SpeechRecognitionHandlerUtils#setFirstLevelSize] No DSISpeechRec available!");
            return;
        }
        this.lc.log(-2137614336, "[SpeechRecognitionHandlerUtils#setFirstLevelSize] Setting FirstLevelSize to %1!", (long)n);
        this.dsiSR.setFirstLevelSize(n);
    }

    static GrammarInfo[] convertInfo(int[] nArray) {
        if (nArray == null) {
            return new GrammarInfo[0];
        }
        int n = nArray.length;
        GrammarInfo[] grammarInfoArray = new GrammarInfo[n];
        for (int i2 = 0; i2 < n; ++i2) {
            grammarInfoArray[i2] = new GrammarInfo(nArray[i2], 0);
        }
        return grammarInfoArray;
    }

    static int[] getGrammarIDs(Grammar[] grammarArray) {
        if (grammarArray == null) {
            return new int[0];
        }
        int n = grammarArray.length;
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            Grammar grammar = grammarArray[i2];
            if (grammar == null) continue;
            nArray[i2] = grammar.getGrammarId();
        }
        return nArray;
    }

    static int[] getGrammarIDs(GrammarInfo[] grammarInfoArray) {
        if (grammarInfoArray == null) {
            return new int[0];
        }
        int n = grammarInfoArray.length;
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            GrammarInfo grammarInfo = grammarInfoArray[i2];
            if (grammarInfo == null) continue;
            nArray[i2] = grammarInfo.getId();
        }
        return nArray;
    }
}

