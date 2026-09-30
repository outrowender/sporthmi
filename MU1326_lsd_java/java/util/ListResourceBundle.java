/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public abstract class ListResourceBundle
extends ResourceBundle {
    Hashtable table;

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
                this.local = ListResourceBundle.this.table.keys();
                this.pEnum = ListResourceBundle.this.parent.getKeys();
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
                    if (ListResourceBundle.this.table.containsKey(var1_1)) continue;
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

    public final Object handleGetObject(String string) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(string);
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

