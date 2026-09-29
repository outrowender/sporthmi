/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.NBestListResult;

public interface SDSODPServiceListener {
    default public void dialogSessionAborted() {
    }

    default public void responseEndDialogSession() {
    }

    default public void responseStartDialogSession() {
    }

    default public void dialogSessionPaused() {
    }

    default public void languageChanged(String string) {
    }

    default public void eventSent(int n) {
    }

    default public void screenChanged(int n) {
    }

    default public void lineSelected(int n) {
    }

    default public void responseLoadGrammar(byte by) {
    }

    default public void responseUnloadGrammar(byte by) {
    }

    default public void responseStartRecognition(byte by, NBestListResult[] nBestListResultArray) {
    }

    default public void responsePlayPrompt(byte by) {
    }
}

