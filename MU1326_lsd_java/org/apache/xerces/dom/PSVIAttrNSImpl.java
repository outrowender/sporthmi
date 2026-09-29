/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.xerces.dom.AttrNSImpl;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.apache.xerces.xs.AttributePSVI;
import org.apache.xerces.xs.ShortList;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSAttributeDeclaration;
import org.apache.xerces.xs.XSSimpleTypeDefinition;
import org.apache.xerces.xs.XSTypeDefinition;

public class PSVIAttrNSImpl
extends AttrNSImpl
implements AttributePSVI {
    static final long serialVersionUID;
    protected XSAttributeDeclaration fDeclaration = null;
    protected XSTypeDefinition fTypeDecl = null;
    protected boolean fSpecified = true;
    protected String fNormalizedValue = null;
    protected Object fActualValue = null;
    protected short fActualValueType = (short)45;
    protected ShortList fItemValueTypes = null;
    protected XSSimpleTypeDefinition fMemberType = null;
    protected short fValidationAttempted = 0;
    protected short fValidity = 0;
    protected StringList fErrorCodes = null;
    protected String fValidationContext = null;

    public PSVIAttrNSImpl(CoreDocumentImpl coreDocumentImpl, String string, String string2, String string3) {
        super(coreDocumentImpl, string, string2, string3);
    }

    public PSVIAttrNSImpl(CoreDocumentImpl coreDocumentImpl, String string, String string2) {
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
    public XSTypeDefinition getTypeDefinition() {
        return this.fTypeDecl;
    }

    @Override
    public XSSimpleTypeDefinition getMemberTypeDefinition() {
        return this.fMemberType;
    }

    @Override
    public XSAttributeDeclaration getAttributeDeclaration() {
        return this.fDeclaration;
    }

    public void setPSVI(AttributePSVI attributePSVI) {
        this.fDeclaration = attributePSVI.getAttributeDeclaration();
        this.fValidationContext = attributePSVI.getValidationContext();
        this.fValidity = attributePSVI.getValidity();
        this.fValidationAttempted = attributePSVI.getValidationAttempted();
        this.fErrorCodes = attributePSVI.getErrorCodes();
        this.fNormalizedValue = attributePSVI.getSchemaNormalizedValue();
        this.fActualValue = attributePSVI.getActualNormalizedValue();
        this.fActualValueType = attributePSVI.getActualNormalizedValueType();
        this.fItemValueTypes = attributePSVI.getItemValueTypes();
        this.fTypeDecl = attributePSVI.getTypeDefinition();
        this.fMemberType = attributePSVI.getMemberTypeDefinition();
        this.fSpecified = attributePSVI.getIsSchemaSpecified();
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

