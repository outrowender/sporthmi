/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class ExtendedResourceBundle
extends ResourceBundle {
    private Hashtable table;

    protected abstract Object[][] getContents();

    public Enumeration getKeys() {
        if (this.table == null) {
            this.initializeTable();
        }
        if (this.parent == null) {
            return this.table.keys();
        }
        return new Enumeration(){
            Enumeration local;
            Enumeration pEnum;
            Object nextElement;
            {
                this.local = ExtendedResourceBundle.this.table.keys();
                this.pEnum = ExtendedResourceBundle.this.parent.getKeys();
                this.nextElement = null;
            }

            /*
             * Unable to fully structure code
             */
            private boolean findNext() {
                if (this.nextElement == null) ** GOTO lbl7
                return true;
lbl-1000:
                // 1 sources

                {
                    var1_1 = (String)this.pEnum.nextElement();
                    if (ExtendedResourceBundle.access$0(ExtendedResourceBundle.this).containsKey(var1_1)) continue;
                    this.nextElement = var1_1;
                    return true;
lbl7:
                    // 2 sources

                    ** while (this.pEnum.hasMoreElements())
                }
lbl8:
                // 1 sources

                return false;
            }

            public boolean hasMoreElements() {
                if (this.local.hasMoreElements()) {
                    return true;
                }
                return this.findNext();
            }

            public Object nextElement() {
                if (this.local.hasMoreElements()) {
                    return this.local.nextElement();
                }
                if (this.findNext()) {
                    Object object = this.nextElement;
                    this.nextElement = null;
                    return object;
                }
                return this.pEnum.nextElement();
            }
        };
    }

    public final Object getObject(Integer n) {
        ExtendedResourceBundle extendedResourceBundle;
        ExtendedResourceBundle extendedResourceBundle2 = this;
        do {
            Object object;
            if ((object = extendedResourceBundle2.handleGetObject(n)) != null) {
                return object;
            }
            extendedResourceBundle = extendedResourceBundle2;
        } while ((extendedResourceBundle2 = (ExtendedResourceBundle)extendedResourceBundle2.parent) != null);
        throw new MissingResourceException(null, extendedResourceBundle.getClass().getName(), n.toString());
    }

    public Object handleGetObject(String string) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(string);
    }

    public Object handleGetObject(Integer n) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(n);
    }

    private synchronized void initializeTable() {
        if (this.table == null) {
            Object[][] objectArray = this.getContents();
            this.table = new Hashtable(objectArray.length / 3 * 4 + 3);
            int n = 0;
            while (n < objectArray.length) {
                this.table.put(objectArray[n][0], objectArray[n][1]);
                ++n;
            }
        }
    }
}

