/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.text.CharacterIterator;
import java.util.Map;
import java.util.Set;

public interface AttributedCharacterIterator
extends CharacterIterator {
    public Set getAllAttributeKeys();

    public Object getAttribute(Attribute var1);

    public Map getAttributes();

    public int getRunLimit();

    public int getRunLimit(Attribute var1);

    public int getRunLimit(Set var1);

    public int getRunStart();

    public int getRunStart(Attribute var1);

    public int getRunStart(Set var1);

    public static class Attribute
    implements Serializable {
        private static final long serialVersionUID = -9142742483513960612L;
        public static final Attribute INPUT_METHOD_SEGMENT = new Attribute("input_method_segment");
        public static final Attribute LANGUAGE = new Attribute("language");
        public static final Attribute READING = new Attribute("reading");
        private String name;
        static /* synthetic */ Class class$0;

        protected Attribute(String string) {
            this.name = string;
        }

        public final boolean equals(Object object) {
            return this == object;
        }

        protected String getName() {
            return this.name;
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        protected Object readResolve() throws InvalidObjectException {
            Class clazz = this.getClass();
            Class clazz2 = class$0;
            if (clazz2 == null) {
                try {
                    clazz2 = class$0 = Class.forName("java.text.AttributedCharacterIterator$Attribute");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            if (clazz != clazz2) {
                throw new InvalidObjectException(Msg.getString("K000c"));
            }
            if (Attribute.INPUT_METHOD_SEGMENT.name.equals(this.name)) {
                return INPUT_METHOD_SEGMENT;
            }
            if (Attribute.LANGUAGE.name.equals(this.name)) {
                return LANGUAGE;
            }
            if (Attribute.READING.name.equals(this.name)) {
                return READING;
            }
            throw new InvalidObjectException(Msg.getString("K000d"));
        }

        public String toString() {
            return new StringBuffer(String.valueOf(this.getClass().getName())).append('(').append(this.getName()).append(')').toString();
        }
    }
}

