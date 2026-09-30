/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyResourceBundle
extends ResourceBundle {
    final Properties resources = new Properties();

    public PropertyResourceBundle(InputStream inputStream) throws IOException {
        this.resources.load(inputStream);
    }

    public Enumeration getKeys() {
        if (this.parent == null) {
            return this.resources.keys();
        }
        return new Enumeration(){
            Enumeration local;
            Enumeration pEnum;
            Object nextElement;
            {
                this.local = PropertyResourceBundle.this.resources.keys();
                this.pEnum = PropertyResourceBundle.this.parent.getKeys();
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
                    if (PropertyResourceBundle.this.resources.containsKey(var1_1)) continue;
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

    public Object handleGetObject(String string) {
        return this.resources.get(string);
    }
}

