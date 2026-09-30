/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamException;

public class InvalidClassException
extends ObjectStreamException {
    private static final long serialVersionUID = -4333316296251054416L;
    public String classname;

    public InvalidClassException(String string) {
        super(string);
    }

    public InvalidClassException(String string, String string2) {
        super(string2);
        this.classname = string;
    }

    public String getMessage() {
        String string = super.getMessage();
        if (this.classname != null) {
            string = String.valueOf(this.classname) + ';' + ' ' + string;
        }
        return string;
    }
}

