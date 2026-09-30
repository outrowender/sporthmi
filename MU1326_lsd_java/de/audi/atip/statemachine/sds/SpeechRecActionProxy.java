/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import de.audi.atip.statemachine.ActionProxy;

public interface SpeechRecActionProxy
extends ActionProxy {
    public void preloadGrammarAdb();

    public void loadGrammarCountry(String var1, int var2, int var3, int var4, int var5, int var6);

    public void loadGrammarCountry();

    public void loadGrammarCountrySpelling();

    public void loadGrammarAreaCode();

    public void loadGrammarCity(String var1);

    public void loadGrammarCitySpelling(String var1);

    public void loadGrammarHouseNumber();

    public void unloadGrammars();

    public void setLanguage(String var1);

    public void setTimeout(int var1, int var2);

    public void startRecognition();

    public void waitForResults();

    public void storeRecognitionResult(int var1);

    public void storeRecognitionResultNBest(int var1);

    public void storeRecognitionResultNBest(int var1, int var2);

    public void getRecognizedAdbList(int var1, int var2);

    public void getRecognizedString(int var1);

    public void getRecognizedIntFromWordList(int var1);

    public void abort();

    public boolean init();

    public void shutdown();

    public void startPostTraining(int var1);

    public void stopPostTraining();

    public void loadProfile(int var1);

    public void unloadProfile();

    public void deleteProfile(int var1);

    public void setPromptNotAbortable(boolean var1);

    public void copyListModel(int var1, int var2);

    public void formatZIPCode(int var1);

    public void showList(int var1);
}

