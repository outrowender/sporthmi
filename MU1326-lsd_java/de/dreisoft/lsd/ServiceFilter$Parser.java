/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.ServiceFilter$1;
import de.dreisoft.lsd.ServiceFilter$Condition;
import de.dreisoft.lsd.ServiceFilter$Condition$And;
import de.dreisoft.lsd.ServiceFilter$Condition$Equals;
import de.dreisoft.lsd.ServiceFilter$Condition$Not;
import de.dreisoft.lsd.ServiceFilter$Condition$Operation;
import de.dreisoft.lsd.ServiceFilter$Condition$Or;
import de.dreisoft.lsd.ServiceFilter$Condition$WildcardValue;
import java.util.Set;
import org.osgi.framework.InvalidSyntaxException;

class ServiceFilter$Parser {
    private Set svcInterfaces;
    private String filterString;
    private char[] raw;
    private int pos = 0;

    private ServiceFilter$Parser() {
    }

    public ServiceFilter$Condition parse(String string, Set set) {
        this.svcInterfaces = set;
        this.filterString = string;
        this.raw = string.toCharArray();
        this.skipWhitespace();
        ServiceFilter$Condition serviceFilter$Condition = this.parseTerm();
        if (!serviceFilter$Condition.hasDestinctServiceInterfaces()) {
            this.svcInterfaces.clear();
        }
        return serviceFilter$Condition;
    }

    private ServiceFilter$Condition parseTerm() {
        if (!this.termStarts()) {
            throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: '(' expected at position ").append(this.pos).toString(), this.filterString);
        }
        ++this.pos;
        this.skipWhitespace();
        ServiceFilter$Condition serviceFilter$Condition = this.isOperator() ? this.parseOperation() : this.parseComparison();
        this.skipWhitespace();
        if (!this.termEnds()) {
            throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), this.filterString);
        }
        ++this.pos;
        this.skipWhitespace();
        return serviceFilter$Condition;
    }

    private ServiceFilter$Condition parseOperation() {
        ServiceFilter$Condition$Operation serviceFilter$Condition$Operation;
        switch (this.raw[this.pos]) {
            case '&': {
                ++this.pos;
                this.skipWhitespace();
                serviceFilter$Condition$Operation = new ServiceFilter$Condition$And();
                while (!this.termEnds()) {
                    serviceFilter$Condition$Operation.addTerm(this.parseTerm());
                }
                break;
            }
            case '|': {
                ++this.pos;
                this.skipWhitespace();
                serviceFilter$Condition$Operation = new ServiceFilter$Condition$Or();
                while (!this.termEnds()) {
                    serviceFilter$Condition$Operation.addTerm(this.parseTerm());
                }
                break;
            }
            case '!': {
                ++this.pos;
                this.skipWhitespace();
                serviceFilter$Condition$Operation = new ServiceFilter$Condition$Not();
                serviceFilter$Condition$Operation.addTerm(this.parseTerm());
                this.skipWhitespace();
                if (this.termEnds()) break;
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: ')' expected at position ").append(this.pos).toString(), this.filterString);
            }
            default: {
                throw new InvalidSyntaxException(new StringBuffer().append("filter syntax invalid: unsupported operator '").append(this.raw[this.pos]).append("'at position ").append(this.pos).toString(), this.filterString);
            }
        }
        return serviceFilter$Condition$Operation;
    }

    private ServiceFilter$Condition parseComparison() {
        ServiceFilter$Condition$Equals serviceFilter$Condition$Equals;
        String string = this.parseProperty();
        this.skipWhitespace();
        switch (this.raw[this.pos]) {
            case '=': {
                ++this.pos;
                serviceFilter$Condition$Equals = new ServiceFilter$Condition$Equals();
                serviceFilter$Condition$Equals.setProperty(string);
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
        serviceFilter$Condition$Equals.setValue(object);
        this.skipWhitespace();
        if (((ServiceFilter$Condition)serviceFilter$Condition$Equals).hasDestinctServiceInterfaces()) {
            this.svcInterfaces.add(serviceFilter$Condition$Equals.getServiceInterface());
        }
        return serviceFilter$Condition$Equals;
    }

    private String parseProperty() {
        int n = this.pos;
        int n2 = this.pos;
        while (!(this.isOperator() || this.isComparator() || this.termStarts() || this.termEnds() || this.isWhitespace())) {
            n2 = ++this.pos;
        }
        return new String(this.raw, n, n2 - n);
    }

    private Object parseValue() {
        String string = this.parseProperty();
        if (string.indexOf(42) != -1) {
            return new ServiceFilter$Condition$WildcardValue(this.filterString, string);
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

    /* synthetic */ ServiceFilter$Parser(ServiceFilter$1 serviceFilter$1) {
        this();
    }
}

