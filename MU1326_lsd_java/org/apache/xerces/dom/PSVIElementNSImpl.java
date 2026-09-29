/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.apache.xerces.dom.ElementNSImpl;
import org.apache.xerces.xs.ElementPSVI;
import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSElementDeclaration;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSNotationDeclaration;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.XSTypeDefinition;

public class PSVIElementNSImpl
extends ElementNSImpl
implements ElementPSVI {
    static final long serialVersionUID;
    protected XSElementDeclaration fDeclaration = null;
    protected XSTypeDefinition fTypeDecl = null;
    protected boolean fNil = false;
    protected boolean fSpecified = true;
    protected String fNormalizedValue = null;
    protected Object fActualValue = null;
    protected short fActualValueType = (short)45;
    protected ShortList fItemValueTypes = null;
    protected XSNotationDeclaration fNotation = null;
    protected XSSimpleTypeDefinition fMemberType = null;
    protected short fValidationAttempted = 0;
    protected short fValidity = 0;
    protected StringList fErrorCodes = null;
    protected String fValidationContext = null;
    protected XSModel fSchemaInformation = null;

    public PSVIElementNSImpl(CoreDocumentImpl coreDocumentImpl, String string, String string2, String string3) {
        super(coreDocumentImpl, string, string2, string3);
    }

    public PSVIElementNSImpl(CoreDocumentImpl coreDocumentImpl, String string, String string2) {
        super(coreDocumentImpl, string, string2);
    }

    @Override
    public String getSchemaDefault() {
        return this.fDeclaration == null ? null : this.fDeclaration.getConstraintValue();
    }

    @Override
    public String getSchemaNormalizedValue() {
        return this.fNormalizedValue;
    }

    @Override
    public boolean getIsSchemaSpecified() {
        return this.fSpecified;
    }

    @Override
    public short getValidationAttempted() {
        return this.fValidationAttempted;
    }

    @Override
    public short getValidity() {
        return this.fValidity;
    }

    @Override
    public StringList getErrorCodes() {
        return this.fErrorCodes;
    }

    @Override
    public String getValidationContext() {
        return this.fValidationContext;
    }

    @Override
    public boolean getNil() {
        return this.fNil;
    }

    @Override
    public XSNotationDeclaration getNotation() {
        return this.fNotation;
    }

    @Override
    public XSTypeDefinition getTypeDefinition() {
        return this.fTypeDecl;
    }

    @Override
    public XSSimpleTypeDefinition getMemberTypeDefinition() {
        return this.fMemberType;
    }

    @Override
    public XSElementDeclaration getElementDeclaration() {
        return this.fDeclaration;
    }

    @Override
    public XSModel getSchemaInformation() {
        return this.fSchemaInformation;
    }

    public void setPSVI(ElementPSVI elementPSVI) {
        this.fDeclaration = elementPSVI.getElementDeclaration();
        this.fNotation = elementPSVI.getNotation();
        this.fValidationContext = elementPSVI.getValidationContext();
        this.fTypeDecl = elementPSVI.getTypeDefinition();
        this.fSchemaInformation = elementPSVI.getSchemaInformation();
        this.fValidity = elementPSVI.getValidity();
        this.fValidationAttempted = elementPSVI.getValidationAttempted();
        this.fErrorCodes = elementPSVI.getErrorCodes();
        this.fNormalizedValue = elementPSVI.getSchemaNormalizedValue();
        this.fActualValue = elementPSVI.getActualNormalizedValue();
        this.fActualValueType = elementPSVI.getActualNormalizedValueType();
        this.fItemValueTypes = elementPSVI.getItemValueTypes();
        this.fMemberType = elementPSVI.getMemberTypeDefinition();
        this.fSpecified = elementPSVI.getIsSchemaSpecified();
        this.fNil = elementPSVI.getNil();
    }

    @Override
    public Object getActualNormalizedValue() {
        return this.fActualValue;
    }

    @Override
    public short getActualNormalizedValueType() {
        return this.fActualValueType;
    }

    @Override
    public ShortList getItemValueTypes() {
        return this.fItemValueTypes;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        throw new NotSerializableException(super.getClass().getName());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new NotSerializableException(super.getClass().getName());
    }
}

