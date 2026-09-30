/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;
import java.io.ObjectStreamField;

class EmulatedFields {
    private ObjectSlot[] slotsToSerialize;
    private ObjectStreamField[] declaredFields;

    public EmulatedFields(ObjectStreamField[] objectStreamFieldArray, ObjectStreamField[] objectStreamFieldArray2) {
        this.buildSlots(objectStreamFieldArray);
        this.declaredFields = objectStreamFieldArray2;
    }

    private void buildSlots(ObjectStreamField[] objectStreamFieldArray) {
        this.slotsToSerialize = new ObjectSlot[objectStreamFieldArray.length];
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            ObjectSlot objectSlot;
            this.slotsToSerialize[n] = objectSlot = new ObjectSlot();
            objectSlot.field = objectStreamFieldArray[n];
            ++n;
        }
    }

    public boolean defaulted(String string) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, null);
        if (objectSlot != null) {
            return objectSlot.defaulted;
        }
        throw new IllegalArgumentException();
    }

    private ObjectSlot findSlot(String string, Class clazz) {
        Object object;
        boolean bl = clazz != null && clazz.isPrimitive();
        int n = 0;
        while (n < this.slotsToSerialize.length) {
            object = this.slotsToSerialize[n];
            if (((ObjectSlot)object).field.getName().equals(string)) {
                if (bl) {
                    if (((ObjectSlot)object).field.getType() == clazz) {
                        return object;
                    }
                } else {
                    if (clazz == null) {
                        return object;
                    }
                    if (((ObjectSlot)object).field.getType().isAssignableFrom(clazz)) {
                        return object;
                    }
                }
            }
            ++n;
        }
        if (this.declaredFields != null) {
            n = 0;
            while (n < this.declaredFields.length) {
                object = this.declaredFields[n];
                if (((ObjectStreamField)object).getName().equals(string) && (bl ? ((ObjectStreamField)object).getType() == clazz : clazz == null || ((ObjectStreamField)object).getType().isAssignableFrom(clazz))) {
                    ObjectSlot objectSlot = new ObjectSlot();
                    objectSlot.field = object;
                    objectSlot.defaulted = true;
                    return objectSlot;
                }
                ++n;
            }
        }
        return null;
    }

    public byte get(String string, byte by) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Byte.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? by : (Byte)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public char get(String string, char c2) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Character.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? c2 : ((Character)objectSlot.fieldValue).charValue();
        }
        throw new IllegalArgumentException();
    }

    public double get(String string, double d2) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Double.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? d2 : (Double)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public float get(String string, float f2) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Float.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? f2 : ((Float)objectSlot.fieldValue).floatValue();
        }
        throw new IllegalArgumentException();
    }

    public int get(String string, int n) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Integer.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? n : (Integer)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public long get(String string, long l) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Long.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? l : (Long)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public Object get(String string, Object object) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, null);
        if (objectSlot != null && !objectSlot.field.getType().isPrimitive()) {
            return objectSlot.defaulted ? object : objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public short get(String string, short s) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Short.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? s : (Short)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public boolean get(String string, boolean bl) throws IOException, IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Boolean.TYPE);
        if (objectSlot != null) {
            return objectSlot.defaulted ? bl : (Boolean)objectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public void put(String string, byte by) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Byte.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Byte(by);
        objectSlot.defaulted = false;
    }

    public void put(String string, char c2) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Character.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Character(c2);
        objectSlot.defaulted = false;
    }

    public void put(String string, double d2) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Double.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Double(d2);
        objectSlot.defaulted = false;
    }

    public void put(String string, float f2) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Float.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Float(f2);
        objectSlot.defaulted = false;
    }

    public void put(String string, int n) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Integer.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Integer(n);
        objectSlot.defaulted = false;
    }

    public void put(String string, long l) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Long.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Long(l);
        objectSlot.defaulted = false;
    }

    public void put(String string, Object object) throws IllegalArgumentException {
        ObjectSlot objectSlot;
        Class clazz = null;
        if (object != null) {
            clazz = object.getClass();
        }
        if ((objectSlot = this.findSlot(string, clazz)) == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = object;
        objectSlot.defaulted = false;
    }

    public void put(String string, short s) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Short.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Short(s);
        objectSlot.defaulted = false;
    }

    public void put(String string, boolean bl) throws IllegalArgumentException {
        ObjectSlot objectSlot = this.findSlot(string, Boolean.TYPE);
        if (objectSlot == null) {
            throw new IllegalArgumentException();
        }
        objectSlot.fieldValue = new Boolean(bl);
        objectSlot.defaulted = false;
    }

    public ObjectSlot[] slots() {
        return this.slotsToSerialize;
    }

    static class ObjectSlot {
        ObjectStreamField field;
        Object fieldValue;
        boolean defaulted = true;

        ObjectSlot() {
        }

        public ObjectStreamField getField() {
            return this.field;
        }

        public Object getFieldValue() {
            return this.fieldValue;
        }
    }
}

