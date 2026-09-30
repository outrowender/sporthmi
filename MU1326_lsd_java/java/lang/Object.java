/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  
 */
package java.lang;

public class Object
extends  {
    protected native Object clone();

    public boolean equals(Object object) {
        return this == object;
    }

    protected void finalize() throws Throwable {
    }

    public final native Class getClass();

    public native int hashCode();

    public final native void notify();

    public final native void notifyAll();

    public String toString() {
        return String.valueOf(this.getClass().getName()) + "@" + Integer.toHexString(this.hashCode());
    }

    public final void wait() throws InterruptedException {
        this.wait(0L, 0);
    }

    public final void wait(long l) throws InterruptedException {
        this.wait(l, 0);
    }

    public final native void wait(long var1, int var3);

    private Object newInstancePrototype(Class clazz) {
        return null;
    }
}

