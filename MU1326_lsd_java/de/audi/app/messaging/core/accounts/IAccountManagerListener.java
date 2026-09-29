/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

public interface IAccountManagerListener {
    default public void selectedAccountChanged() {
    }

    default public void updateAvailableAccounts(int n, int n2, int n3, int n4) {
    }
}

