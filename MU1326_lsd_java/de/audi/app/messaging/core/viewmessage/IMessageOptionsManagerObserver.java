/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

public interface IMessageOptionsManagerObserver {
    public void messageDetailsChanged();

    public static class EmptyImplementation
    implements IMessageOptionsManagerObserver {
        public void messageDetailsChanged() {
        }
    }
}

