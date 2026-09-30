/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.accounts;

public interface IAccountManagerListener {
    public void selectedAccountChanged();

    public void updateAvailableAccounts(int var1, int var2, int var3, int var4);

    public static class DefaultAccountManagerListener
    implements IAccountManagerListener {
        public void selectedAccountChanged() {
        }

        public void updateAvailableAccounts(int n, int n2, int n3, int n4) {
        }
    }
}

