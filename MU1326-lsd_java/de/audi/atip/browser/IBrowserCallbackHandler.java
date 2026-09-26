/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.browser;

public interface IBrowserCallbackHandler {
    default public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    default public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    default public void updateBrowserStateBusy(boolean bl) {
    }

    default public void updateBrowserState(int n) {
    }

    default public boolean scrollDown(int n) {
    }

    default public boolean scrollUp(int n) {
    }

    default public void indicateBrowserStateNotFound() {
    }

    default public void indicateBrowserStateComplete() {
    }

    default public void indicateBrowserStateTimeout() {
    }

    default public void javascriptAlert(String string) {
    }

    default public boolean press() {
    }

    default public boolean indicateEfiUrl(String string) {
    }

    default public void belowLowerThreshold(int n) {
    }

    default public void exceedsUpperThreshold(int n) {
    }

    default public void indicateBoardbookAvailable(boolean bl) {
    }

    default public void virtualButtonBack() {
    }
}

