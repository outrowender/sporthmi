/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.sds;

import de.audi.atip.statemachine.ActionProxy;

public interface SpeechRecActionProxy
extends ActionProxy {
    default public void preloadGrammarAdb() {
    }

    default public void loadGrammarCountry(String string, int n, int n2, int n3, int n4, int n5) {
    }

    default public void loadGrammarCountry() {
    }

    default public void loadGrammarCountrySpelling() {
    }

    default public void loadGrammarAreaCode() {
    }

    default public void loadGrammarCity(String string) {
    }

    default public void loadGrammarCitySpelling(String string) {
    }

    default public void loadGrammarHouseNumber() {
    }

    default public void unloadGrammars() {
    }

    default public void setLanguage(String string) {
    }

    default public void setTimeout(int n, int n2) {
    }

    default public void startRecognition() {
    }

    default public void waitForResults() {
    }

    default public void storeRecognitionResult(int n) {
    }

    default public void storeRecognitionResultNBest(int n) {
    }

    default public void storeRecognitionResultNBest(int n, int n2) {
    }

    default public void getRecognizedAdbList(int n, int n2) {
    }

    default public void getRecognizedString(int n) {
    }

    default public void getRecognizedIntFromWordList(int n) {
    }

    default public void abort() {
    }

    default public boolean init() {
    }

    default public void shutdown() {
    }

    default public void startPostTraining(int n) {
    }

    default public void stopPostTraining() {
    }

    default public void loadProfile(int n) {
    }

    default public void unloadProfile() {
    }

    default public void deleteProfile(int n) {
    }

    default public void setPromptNotAbortable(boolean bl) {
    }

    default public void copyListModel(int n, int n2) {
    }

    default public void formatZIPCode(int n) {
    }

    default public void showList(int n) {
    }
}

