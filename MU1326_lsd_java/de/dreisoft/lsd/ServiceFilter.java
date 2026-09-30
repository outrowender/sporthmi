/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceInfo;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.osgi.framework.Filter;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class ServiceFilter
implements Filter {
    private String filterString;
    private String[] svcInterfaces;
    private Condition condition;

    ServiceFilter(String string) throws InvalidSyntaxException {
        if (string == null) {
            throw new NullPointerException("filter string must not be null");
        }
        this.filterString = string;
        HashSet hashSet = new HashSet();
        this.condition = new Parser().parse(this.filterString, hashSet);
        this.svcInterfaces = new String[hashSet.size()];
        if (!hashSet.isEmpty()) {
            this.svcInterfaces = (String[])hashSet.toArray(this.svcInterfaces);
        }
    }

    public String[] getServiceInterfaces() {
        return this.svcInterfaces;
    }

    public boolean isServiceInterfaceList() {
        return this.condition.isServiceInterfaceList();
    }

    public boolean match(ServiceReference serviceReference) {
        return this.match(((ServiceInfo)serviceReference).getProperties());
    }

    public boolean match(Dictionary dictionary) {
        return this.condition.isFulfilled(dictionary);
    }

    public String toString() {
        return this.filterString;
    }

    private static class Parser {
        private Set svcInterfaces;
        private String filterString;
        private char[] raw;
        private int pos = 0;

        private Parser() {
        }

        public Condition parse(String string, Set set) throws InvalidSyntaxException {
            this.svcInterfaces = set;
            this.filterString = string;
            this.raw = string.toCharArray();
            this.skipWhitespace();
            Condition condition = this.parseTerm();
            if (!condition.hasDestinctServiceInterfaces()) {
                this.svcInterfaces.clear();
            }
            return condition;
        }

        private Condition parseTerm() throws InvalidSyntaxException {
            if (!this.termStarts()) {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: '(' expected at position ").append(this.pos).toString(), this.filterString);
            }
            ++this.pos;
            this.skipWhitespace();
            Condition condition = this.isOperator() ? this.parseOperation() : this.parseComparison();
            this.skipWhitespace();
            if (!this.termEnds()) {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), this.filterString);
            }
            ++this.pos;
            this.skipWhitespace();
            return condition;
        }

        private Condition parseOperation() throws InvalidSyntaxException {
            Condition.Operation operation;
            switch (this.raw[this.pos]) {
                case '&': {
                    ++this.pos;
                    this.skipWhitespace();
                    operation = new Condition.And();
                    while (!this.termEnds()) {
                        operation.addTerm(this.parseTerm());
                    }
                    break;
                }
                case '|': {
                    ++this.pos;
                    this.skipWhitespace();
                    operation = new Condition.Or();
                    while (!this.termEnds()) {
                        operation.addTerm(this.parseTerm());
                    }
                    break;
                }
                case '!': {
                    ++this.pos;
                    this.skipWhitespace();
                    operation = new Condition.Not();
                    operation.addTerm(this.parseTerm());
                    this.skipWhitespace();
                    if (this.termEnds()) break;
                    throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), this.filterString);
                }
                default: {
                    throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: unsupported operator '").append(this.raw[this.pos]).append("'at position ").append(this.pos).toString(), this.filterString);
                }
            }
            return operation;
        }

        private Condition parseComparison() throws InvalidSyntaxException {
            Condition.Equals equals;
            String string = this.parseProperty();
            this.skipWhitespace();
            switch (this.raw[this.pos]) {
                case '=': {
                    ++this.pos;
                    equals = new Condition.Equals();
                    equals.setProperty(string);
                    break;
                }
                case '<': {
                    throw new InvalidSyntaxException("filter syntax invalid: SMALLER-comparator'>' not supported", this.filterString);
                }
                case '>': {
                    throw new InvalidSyntaxException("filter syntax invalid: GREATER-comparator'>' not supported", this.filterString);
                }
                case '~': {
                    throw new InvalidSyntaxException("filter syntax invalid: SIMILAR-comparator'!' not supported", this.filterString);
                }
                default: {
                    throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: comparator (i.e. '=', '<', '>' or '~')expected at position ").append(this.pos).toString(), this.filterString);
                }
            }
            this.skipWhitespace();
            Object object = this.parseValue();
            equals.setValue(object);
            this.skipWhitespace();
            if (((Condition)equals).hasDestinctServiceInterfaces()) {
                this.svcInterfaces.add(equals.getServiceInterface());
            }
            return equals;
        }

        private String parseProperty() {
            int n = this.pos;
            int n2 = this.pos;
            while (!(this.isOperator() || this.isComparator() || this.termStarts() || this.termEnds() || this.isWhitespace())) {
                n2 = ++this.pos;
            }
            return new String(this.raw, n, n2 - n);
        }

        private Object parseValue() throws InvalidSyntaxException {
            String string = this.parseProperty();
            if (string.indexOf(42) != -1) {
                return new Condition.WildcardValue(this.filterString, string);
            }
            return string;
        }

        private boolean termStarts() {
            return this.raw[this.pos] == '(';
        }

        private boolean termEnds() {
            return this.raw[this.pos] == ')';
        }

        private boolean isWhitespace() {
            return Character.isWhitespace(this.raw[this.pos]);
        }

        private boolean isOperator() {
            return "&|!".indexOf(this.raw[this.pos]) != -1;
        }

        private boolean isComparator() {
            return "=<>~".indexOf(this.raw[this.pos]) != -1;
        }

        private void skipWhitespace() {
            while (this.pos < this.raw.length && this.isWhitespace()) {
                ++this.pos;
            }
        }
    }

    private static abstract class Condition {
        private Condition() {
        }

        public abstract boolean isFulfilled(Dictionary var1);

        public abstract boolean hasDestinctServiceInterfaces();

        public abstract boolean isServiceInterfaceList();

        public static class Or
        extends Operation {
            public boolean hasDestinctServiceInterfaces() {
                int n = this.terms.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (((Condition)this.terms.get(i2)).hasDestinctServiceInterfaces()) continue;
                    return false;
                }
                return true;
            }

            public boolean isFulfilled(Dictionary dictionary) {
                int n = this.terms.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (!((Condition)this.terms.get(i2)).isFulfilled(dictionary)) continue;
                    return true;
                }
                return false;
            }

            public boolean isServiceInterfaceList() {
                int n = this.terms.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (((Condition)this.terms.get(i2)).isServiceInterfaceList()) continue;
                    return false;
                }
                return true;
            }
        }

        public static class And
        extends Operation {
            public boolean hasDestinctServiceInterfaces() {
                int n = this.terms.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (!((Condition)this.terms.get(i2)).hasDestinctServiceInterfaces()) continue;
                    return true;
                }
                return false;
            }

            public boolean isFulfilled(Dictionary dictionary) {
                int n = this.terms.size();
                for (int i2 = 0; i2 < n; ++i2) {
                    if (((Condition)this.terms.get(i2)).isFulfilled(dictionary)) continue;
                    return false;
                }
                return true;
            }

            public boolean isServiceInterfaceList() {
                return false;
            }
        }

        public static class Not
        extends Operation {
            public boolean hasDestinctServiceInterfaces() {
                return false;
            }

            public boolean isFulfilled(Dictionary dictionary) {
                return !((Condition)this.terms.get(0)).isFulfilled(dictionary);
            }

            public boolean isServiceInterfaceList() {
                return false;
            }
        }

        public static class Equals
        extends Comparison {
            public boolean hasDestinctServiceInterfaces() {
                return this.isDestinctObjectClassProp;
            }

            public boolean isFulfilled(Dictionary dictionary) {
                if (this.isObjectClassProp) {
                    String[] stringArray = (String[])dictionary.get(this.property);
                    for (int i2 = 0; i2 < stringArray.length; ++i2) {
                        if (!this.value.equals(stringArray[i2])) continue;
                        return true;
                    }
                    return false;
                }
                Object object = dictionary.get(this.property);
                if (object == null) {
                    return false;
                }
                return this.value.equals(object.toString());
            }

            public boolean isServiceInterfaceList() {
                return this.isDestinctObjectClassProp;
            }
        }

        public static abstract class Operation
        extends Condition {
            protected List terms = new ArrayList(2);

            public void addTerm(Condition condition) {
                this.terms.add(condition);
            }
        }

        public static abstract class Comparison
        extends Condition {
            protected boolean isObjectClassProp = false;
            protected boolean isDestinctObjectClassProp = false;
            protected String property;
            protected Object value;

            public void setProperty(String string) {
                this.property = string;
                if (this.property.equals("objectClass")) {
                    this.isObjectClassProp = true;
                    this.isDestinctObjectClassProp = true;
                }
            }

            public void setValue(Object object) {
                this.value = object;
                if (this.value instanceof WildcardValue) {
                    this.isDestinctObjectClassProp = false;
                }
            }

            public String getServiceInterface() {
                if (this.isDestinctObjectClassProp) {
                    return (String)this.value;
                }
                return null;
            }

            public boolean isServiceInterfaceList() {
                return false;
            }
        }

        public static class WildcardValue {
            private String valStr;
            private String prefix;
            private String suffix;

            public WildcardValue(String string, String string2) throws InvalidSyntaxException {
                this.valStr = string2;
                int n = this.valStr.indexOf(42);
                this.prefix = this.valStr.substring(0, n);
                this.suffix = this.valStr.substring(n + 1);
                if (this.suffix.indexOf(42) != -1) {
                    throw new InvalidSyntaxException("filter syntax invalid: only one wildcard symbol allowed per value", string);
                }
            }

            public boolean equals(Object object) {
                if (object == null) {
                    return false;
                }
                String string = object.toString();
                return string.length() >= this.prefix.length() + this.suffix.length() && string.startsWith(this.prefix) && string.endsWith(this.suffix);
            }

            public String toString() {
                return this.valStr;
            }
        }
    }
}

