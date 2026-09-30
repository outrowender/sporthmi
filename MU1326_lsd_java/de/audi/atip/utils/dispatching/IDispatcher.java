/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

public interface IDispatcher {
    public void execute(Runnable var1);

    public ICancelable execute(Runnable var1, long var2);

    public boolean isDispatchThread();

    public static interface ICancelable {
        public void cancel();

        public static class Stub
        implements ICancelable {
            public void cancel() {
            }
        }
    }
}

