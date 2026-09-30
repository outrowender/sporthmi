/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import org.apache.xerces.xni.Augmentations;

public class AugmentationsImpl
implements Augmentations {
    private AugmentationsItemsContainer fAugmentationsContainer = new SmallContainer();

    public Object putItem(String string, Object object) {
        Object object2 = this.fAugmentationsContainer.putItem(string, object);
        if (object2 == null && this.fAugmentationsContainer.isFull()) {
            this.fAugmentationsContainer = this.fAugmentationsContainer.expand();
        }
        return object2;
    }

    public Object getItem(String string) {
        return this.fAugmentationsContainer.getItem(string);
    }

    public Object removeItem(String string) {
        return this.fAugmentationsContainer.removeItem(string);
    }

    public Enumeration keys() {
        return this.fAugmentationsContainer.keys();
    }

    public void removeAllItems() {
        this.fAugmentationsContainer.clear();
    }

    public String toString() {
        return this.fAugmentationsContainer.toString();
    }

    class LargeContainer
    extends AugmentationsItemsContainer {
        final Hashtable fAugmentations;

        LargeContainer() {
            this.fAugmentations = new Hashtable();
        }

        public Object getItem(Object object) {
            return this.fAugmentations.get(object);
        }

        public Object putItem(Object object, Object object2) {
            return this.fAugmentations.put(object, object2);
        }

        public Object removeItem(Object object) {
            return this.fAugmentations.remove(object);
        }

        public Enumeration keys() {
            return this.fAugmentations.keys();
        }

        public void clear() {
            this.fAugmentations.clear();
        }

        public boolean isFull() {
            return false;
        }

        public AugmentationsItemsContainer expand() {
            return this;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LargeContainer");
            Enumeration enumeration = this.fAugmentations.keys();
            while (enumeration.hasMoreElements()) {
                Object object = enumeration.nextElement();
                stringBuffer.append("\nkey == ");
                stringBuffer.append(object);
                stringBuffer.append("; value == ");
                stringBuffer.append(this.fAugmentations.get(object));
            }
            return stringBuffer.toString();
        }
    }

    class SmallContainer
    extends AugmentationsItemsContainer {
        static final int SIZE_LIMIT = 10;
        final Object[] fAugmentations;
        int fNumEntries;

        SmallContainer() {
            this.fAugmentations = new Object[20];
            this.fNumEntries = 0;
        }

        public Enumeration keys() {
            return new SmallContainerKeyEnumeration();
        }

        public Object getItem(Object object) {
            for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
                if (!this.fAugmentations[i2].equals(object)) continue;
                return this.fAugmentations[i2 + 1];
            }
            return null;
        }

        public Object putItem(Object object, Object object2) {
            for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
                if (!this.fAugmentations[i2].equals(object)) continue;
                Object object3 = this.fAugmentations[i2 + 1];
                this.fAugmentations[i2 + 1] = object2;
                return object3;
            }
            this.fAugmentations[this.fNumEntries * 2] = object;
            this.fAugmentations[this.fNumEntries * 2 + 1] = object2;
            ++this.fNumEntries;
            return null;
        }

        public Object removeItem(Object object) {
            for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
                if (!this.fAugmentations[i2].equals(object)) continue;
                Object object2 = this.fAugmentations[i2 + 1];
                for (int i3 = i2; i3 < this.fNumEntries * 2 - 2; i3 += 2) {
                    this.fAugmentations[i3] = this.fAugmentations[i3 + 2];
                    this.fAugmentations[i3 + 1] = this.fAugmentations[i3 + 3];
                }
                this.fAugmentations[this.fNumEntries * 2 - 2] = null;
                this.fAugmentations[this.fNumEntries * 2 - 1] = null;
                --this.fNumEntries;
                return object2;
            }
            return null;
        }

        public void clear() {
            for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
                this.fAugmentations[i2] = null;
                this.fAugmentations[i2 + 1] = null;
            }
            this.fNumEntries = 0;
        }

        public boolean isFull() {
            return this.fNumEntries == 10;
        }

        public AugmentationsItemsContainer expand() {
            LargeContainer largeContainer = new LargeContainer();
            for (int i2 = 0; i2 < this.fNumEntries * 2; i2 += 2) {
                largeContainer.putItem(this.fAugmentations[i2], this.fAugmentations[i2 + 1]);
            }
            return largeContainer;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("SmallContainer - fNumEntries == ").append(this.fNumEntries);
            for (int i2 = 0; i2 < 20; i2 += 2) {
                stringBuffer.append("\nfAugmentations[");
                stringBuffer.append(i2);
                stringBuffer.append("] == ");
                stringBuffer.append(this.fAugmentations[i2]);
                stringBuffer.append("; fAugmentations[");
                stringBuffer.append(i2 + 1);
                stringBuffer.append("] == ");
                stringBuffer.append(this.fAugmentations[i2 + 1]);
            }
            return stringBuffer.toString();
        }

        class SmallContainerKeyEnumeration
        implements Enumeration {
            Object[] enumArray;
            int next;

            SmallContainerKeyEnumeration() {
                this.enumArray = new Object[SmallContainer.this.fNumEntries];
                this.next = 0;
                for (int i2 = 0; i2 < SmallContainer.this.fNumEntries; ++i2) {
                    this.enumArray[i2] = SmallContainer.this.fAugmentations[i2 * 2];
                }
            }

            public boolean hasMoreElements() {
                return this.next < this.enumArray.length;
            }

            public Object nextElement() {
                if (this.next >= this.enumArray.length) {
                    throw new NoSuchElementException();
                }
                Object object = this.enumArray[this.next];
                this.enumArray[this.next] = null;
                ++this.next;
                return object;
            }
        }
    }

    abstract class AugmentationsItemsContainer {
        AugmentationsItemsContainer() {
        }

        public abstract Object putItem(Object var1, Object var2);

        public abstract Object getItem(Object var1);

        public abstract Object removeItem(Object var1);

        public abstract Enumeration keys();

        public abstract void clear();

        public abstract boolean isFull();

        public abstract AugmentationsItemsContainer expand();
    }
}

