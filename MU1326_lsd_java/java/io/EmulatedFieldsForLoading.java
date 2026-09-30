/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.EmulatedFields;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class EmulatedFieldsForLoading
extends ObjectInputStream.GetField {
    private ObjectStreamClass streamClass;
    private EmulatedFields emulatedFields;

    EmulatedFieldsForLoading(ObjectStreamClass objectStreamClass) {
        this.streamClass = objectStreamClass;
        this.emulatedFields = new EmulatedFields(objectStreamClass.getLoadFields(), objectStreamClass.fields());
    }

    public boolean defaulted(String string) throws IOException, IllegalArgumentException {
        return this.emulatedFields.defaulted(string);
    }

    EmulatedFields emulatedFields() {
        return this.emulatedFields;
    }

    public byte get(String string, byte by) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, by);
    }

    public char get(String string, char c2) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, c2);
    }

    public double get(String string, double d2) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, d2);
    }

    public float get(String string, float f2) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, f2);
    }

    public int get(String string, int n) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, n);
    }

    public long get(String string, long l) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, l);
    }

    public Object get(String string, Object object) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, object);
    }

    public short get(String string, short s) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, s);
    }

    public boolean get(String string, boolean bl) throws IOException, IllegalArgumentException {
        return this.emulatedFields.get(string, bl);
    }

    public ObjectStreamClass getObjectStreamClass() {
        return this.streamClass;
    }
}

