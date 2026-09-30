/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.util.Msg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Attributes
implements Cloneable,
Map {
    protected Map map;

    public Attributes() {
        this.map = new HashMap();
    }

    public Attributes(Attributes attributes) {
        this.map = (Map)((HashMap)attributes.map).clone();
    }

    public Attributes(int n) {
        this.map = new HashMap(n);
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    public Set entrySet() {
        return this.map.entrySet();
    }

    public Object get(Object object) {
        return this.map.get(object);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public Object put(Object object, Object object2) {
        return this.map.put((Name)object, (String)object2);
    }

    public void putAll(Map map) {
        this.map.putAll((Attributes)map);
    }

    public Object remove(Object object) {
        return this.map.remove(object);
    }

    public int size() {
        return this.map.size();
    }

    public Collection values() {
        return this.map.values();
    }

    public Object clone() {
        Attributes attributes;
        try {
            attributes = (Attributes)super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
        attributes.map = (Map)((HashMap)this.map).clone();
        return attributes;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Attributes) {
            return this.map.equals(((Attributes)object).map);
        }
        return false;
    }

    public String getValue(Name name) {
        return (String)this.map.get(name);
    }

    public String getValue(String string) {
        return (String)this.map.get(new Name(string));
    }

    public String putValue(String string, String string2) {
        return (String)this.map.put(new Name(string), string2);
    }

    public static class Name {
        private String name;
        private int hashCode;
        public static final Name CLASS_PATH = new Name("Class-Path", false);
        public static final Name MANIFEST_VERSION = new Name("Manifest-Version", false);
        public static final Name MAIN_CLASS = new Name("Main-Class", false);
        public static final Name SIGNATURE_VERSION = new Name("Signature-Version", false);
        public static final Name CONTENT_TYPE = new Name("Content-Type", false);
        public static final Name SEALED = new Name("Sealed", false);
        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title", false);
        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version", false);
        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor", false);
        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title", false);
        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version", false);
        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor", false);
        public static final Name EXTENSION_LIST = new Name("Extension-List", false);
        public static final Name EXTENSION_NAME = new Name("Extension-Name", false);
        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation", false);
        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id", false);
        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL", false);
        private static final int NAME_MAX_LENGTH = 70;

        /*
         * Unable to fully structure code
         */
        public Name(String var1_1) {
            super();
            var2_2 = var1_1.length();
            if (var2_2 != 0 && var2_2 <= 70) ** GOTO lbl8
            throw new IllegalArgumentException(Msg.getString("K0404", Integer.toString(70), var1_1));
lbl-1000:
            // 1 sources

            {
                var3_3 = var1_1.charAt(var2_2);
                if (var3_3 >= 'a' && var3_3 <= 'z' || var3_3 >= 'A' && var3_3 <= 'Z' || var3_3 == '_' || var3_3 == '-' || var3_3 >= '0' && var3_3 <= '9') continue;
                throw new IllegalArgumentException(var1_1);
lbl8:
                // 2 sources

                ** while (--var2_2 >= 0)
            }
lbl9:
            // 1 sources

            this.name = var1_1;
        }

        Name(String string, boolean bl) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            return object.getClass() == this.getClass() && this.name.equalsIgnoreCase(((Name)object).name);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                this.hashCode = this.name.toLowerCase().hashCode();
            }
            return this.hashCode;
        }
    }
}

