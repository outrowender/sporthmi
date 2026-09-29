/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;
import org.apache.xerces.dom.DOMMessageFormatter;
import org.apache.xerces.dom.DOMStringListImpl;
import org.apache.xerces.dom.ObjectFactory;
import org.apache.xerces.impl.Constants;
import org.apache.xerces.impl.XMLEntityManager;
import org.apache.xerces.impl.XMLErrorReporter;
import org.apache.xerces.impl.dv.DTDDVFactory;
import org.apache.xerces.impl.msg.XMLMessageFormatter;
import org.apache.xerces.impl.validation.ValidationManager;
import org.apache.xerces.util.DOMEntityResolverWrapper;
import org.apache.xerces.util.DOMErrorHandlerWrapper;
import org.apache.xerces.util.MessageFormatter;
import org.apache.xerces.util.ParserConfigurationSettings;
import org.apache.xerces.util.SymbolTable;
import org.apache.xerces.xni.XMLDTDContentModelHandler;
import org.apache.xerces.xni.XMLDTDHandler;
import org.apache.xerces.xni.XMLDocumentHandler;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.grammars.XMLGrammarPool;
import org.apache.xerces.xni.parser.XMLComponent;
import org.apache.xerces.xni.parser.XMLComponentManager;
import org.apache.xerces.xni.parser.XMLConfigurationException;
import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.apache.xerces.xni.parser.XMLParserConfiguration;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;
import org.w3c.dom.ls.LSResourceResolver;

public class DOMConfigurationImpl
extends ParserConfigurationSettings
implements XMLParserConfiguration,
DOMConfiguration {
    protected static final String XML11_DATATYPE_VALIDATOR_FACTORY;
    protected static final String XERCES_VALIDATION;
    protected static final String XERCES_NAMESPACES;
    protected static final String SCHEMA;
    protected static final String SCHEMA_FULL_CHECKING;
    protected static final String DYNAMIC_VALIDATION;
    protected static final String NORMALIZE_DATA;
    protected static final String SCHEMA_ELEMENT_DEFAULT;
    protected static final String SEND_PSVI;
    protected static final String GENERATE_SYNTHETIC_ANNOTATIONS;
    protected static final String VALIDATE_ANNOTATIONS;
    protected static final String HONOUR_ALL_SCHEMALOCATIONS;
    protected static final String USE_GRAMMAR_POOL_ONLY;
    protected static final String DISALLOW_DOCTYPE_DECL_FEATURE;
    protected static final String BALANCE_SYNTAX_TREES;
    protected static final String WARN_ON_DUPLICATE_ATTDEF;
    protected static final String ENTITY_MANAGER;
    protected static final String ERROR_REPORTER;
    protected static final String XML_STRING;
    protected static final String SYMBOL_TABLE;
    protected static final String GRAMMAR_POOL;
    protected static final String ERROR_HANDLER;
    protected static final String ENTITY_RESOLVER;
    protected static final String JAXP_SCHEMA_LANGUAGE;
    protected static final String JAXP_SCHEMA_SOURCE;
    protected static final String DTD_VALIDATOR_PROPERTY;
    protected static final String DTD_VALIDATOR_FACTORY_PROPERTY;
    protected static final String VALIDATION_MANAGER;
    protected static final String SCHEMA_LOCATION;
    protected static final String SCHEMA_NONS_LOCATION;
    XMLDocumentHandler fDocumentHandler;
    protected short features = 0;
    protected static final short NAMESPACES;
    protected static final short DTNORMALIZATION;
    protected static final short ENTITIES;
    protected static final short CDATA;
    protected static final short SPLITCDATA;
    protected static final short COMMENTS;
    protected static final short VALIDATE;
    protected static final short PSVI;
    protected static final short WELLFORMED;
    protected static final short NSDECL;
    protected static final short INFOSET_TRUE_PARAMS;
    protected static final short INFOSET_FALSE_PARAMS;
    protected static final short INFOSET_MASK;
    protected SymbolTable fSymbolTable;
    protected ArrayList fComponents;
    protected ValidationManager fValidationManager;
    protected Locale fLocale;
    protected XMLErrorReporter fErrorReporter;
    protected final DOMErrorHandlerWrapper fErrorHandlerWrapper = new DOMErrorHandlerWrapper();
    protected DTDDVFactory fCurrentDVFactory;
    protected DTDDVFactory fDatatypeValidatorFactory;
    protected DTDDVFactory fXML11DatatypeFactory;
    private DOMStringList fRecognizedParameters;

    protected DOMConfigurationImpl() {
        this(null, null);
    }

    protected DOMConfigurationImpl(SymbolTable symbolTable) {
        this(symbolTable, null);
    }

    protected DOMConfigurationImpl(SymbolTable symbolTable, XMLComponentManager xMLComponentManager) {
        super(xMLComponentManager);
        MessageFormatter messageFormatter;
        this.fRecognizedFeatures = new ArrayList();
        this.fRecognizedProperties = new ArrayList();
        this.fFeatures = new HashMap();
        this.fProperties = new HashMap();
        String[] stringArray = new String[]{"http://xml.org/sax/features/validation", "http://xml.org/sax/features/namespaces", "http://apache.org/xml/features/validation/schema", "http://apache.org/xml/features/validation/schema-full-checking", "http://apache.org/xml/features/validation/dynamic", "http://apache.org/xml/features/validation/schema/normalized-value", "http://apache.org/xml/features/validation/schema/element-default", "http://apache.org/xml/features/validation/schema/augment-psvi", "http://apache.org/xml/features/generate-synthetic-annotations", "http://apache.org/xml/features/validate-annotations", "http://apache.org/xml/features/honour-all-schemaLocations", "http://apache.org/xml/features/internal/validation/schema/use-grammar-pool-only", "http://apache.org/xml/features/disallow-doctype-decl", "http://apache.org/xml/features/validation/balance-syntax-trees", "http://apache.org/xml/features/validation/warn-on-duplicate-attdef", "http://apache.org/xml/features/internal/parser-settings"};
        this.addRecognizedFeatures(stringArray);
        this.setFeature("http://xml.org/sax/features/validation", false);
        this.setFeature("http://apache.org/xml/features/validation/schema", false);
        this.setFeature("http://apache.org/xml/features/validation/schema-full-checking", false);
        this.setFeature("http://apache.org/xml/features/validation/dynamic", false);
        this.setFeature("http://apache.org/xml/features/validation/schema/normalized-value", false);
        this.setFeature("http://apache.org/xml/features/validation/schema/element-default", false);
        this.setFeature("http://xml.org/sax/features/namespaces", true);
        this.setFeature("http://apache.org/xml/features/validation/schema/augment-psvi", true);
        this.setFeature("http://apache.org/xml/features/generate-synthetic-annotations", false);
        this.setFeature("http://apache.org/xml/features/validate-annotations", false);
        this.setFeature("http://apache.org/xml/features/honour-all-schemaLocations", false);
        this.setFeature("http://apache.org/xml/features/internal/validation/schema/use-grammar-pool-only", false);
        this.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false);
        this.setFeature("http://apache.org/xml/features/validation/balance-syntax-trees", false);
        this.setFeature("http://apache.org/xml/features/validation/warn-on-duplicate-attdef", false);
        this.setFeature("http://apache.org/xml/features/internal/parser-settings", true);
        String[] stringArray2 = new String[]{"http://xml.org/sax/properties/xml-string", "http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-handler", "http://apache.org/xml/properties/internal/entity-resolver", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-manager", "http://apache.org/xml/properties/internal/validation-manager", "http://apache.org/xml/properties/internal/grammar-pool", "http://java.sun.com/xml/jaxp/properties/schemaSource", "http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://apache.org/xml/properties/schema/external-schemaLocation", "http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", "http://apache.org/xml/properties/internal/validator/dtd", "http://apache.org/xml/properties/internal/datatype-validator-factory"};
        this.addRecognizedProperties(stringArray2);
        this.features = (short)(this.features | 1);
        this.features = (short)(this.features | 4);
        this.features = (short)(this.features | 0x20);
        this.features = (short)(this.features | 8);
        this.features = (short)(this.features | 0x10);
        this.features = (short)(this.features | 0x100);
        this.features = (short)(this.features | 0x200);
        if (symbolTable == null) {
            symbolTable = new SymbolTable();
        }
        this.fSymbolTable = symbolTable;
        this.fComponents = new ArrayList();
        this.setProperty("http://apache.org/xml/properties/internal/symbol-table", this.fSymbolTable);
        this.fErrorReporter = new XMLErrorReporter();
        this.setProperty("http://apache.org/xml/properties/internal/error-reporter", this.fErrorReporter);
        this.addComponent(this.fErrorReporter);
        this.fDatatypeValidatorFactory = DTDDVFactory.getInstance();
        this.fXML11DatatypeFactory = DTDDVFactory.getInstance("org.apache.xerces.impl.dv.dtd.XML11DTDDVFactoryImpl");
        this.fCurrentDVFactory = this.fDatatypeValidatorFactory;
        this.setProperty("http://apache.org/xml/properties/internal/datatype-validator-factory", this.fCurrentDVFactory);
        XMLEntityManager xMLEntityManager = new XMLEntityManager();
        this.setProperty("http://apache.org/xml/properties/internal/entity-manager", xMLEntityManager);
        this.addComponent(xMLEntityManager);
        this.fValidationManager = this.createValidationManager();
        this.setProperty("http://apache.org/xml/properties/internal/validation-manager", this.fValidationManager);
        if (this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210") == null) {
            messageFormatter = new XMLMessageFormatter();
            this.fErrorReporter.putMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210", messageFormatter);
            this.fErrorReporter.putMessageFormatter("http://www.w3.org/TR/1999/REC-xml-names-19990114", messageFormatter);
        }
        if (this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/xml-schema-1") == null) {
            messageFormatter = null;
            try {
                messageFormatter = (MessageFormatter)ObjectFactory.newInstance("org.apache.xerces.impl.xs.XSMessageFormatter", ObjectFactory.findClassLoader(), true);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (messageFormatter != null) {
                this.fErrorReporter.putMessageFormatter("http://www.w3.org/TR/xml-schema-1", messageFormatter);
            }
        }
        try {
            this.setLocale(Locale.getDefault());
        }
        catch (XNIException xNIException) {
            // empty catch block
        }
    }

    @Override
    public void parse(XMLInputSource xMLInputSource) {
    }

    @Override
    public void setDocumentHandler(XMLDocumentHandler xMLDocumentHandler) {
        this.fDocumentHandler = xMLDocumentHandler;
    }

    @Override
    public XMLDocumentHandler getDocumentHandler() {
        return this.fDocumentHandler;
    }

    @Override
    public void setDTDHandler(XMLDTDHandler xMLDTDHandler) {
    }

    @Override
    public XMLDTDHandler getDTDHandler() {
        return null;
    }

    @Override
    public void setDTDContentModelHandler(XMLDTDContentModelHandler xMLDTDContentModelHandler) {
    }

    @Override
    public XMLDTDContentModelHandler getDTDContentModelHandler() {
        return null;
    }

    @Override
    public void setEntityResolver(XMLEntityResolver xMLEntityResolver) {
        if (xMLEntityResolver != null) {
            this.fProperties.put("http://apache.org/xml/properties/internal/entity-resolver", xMLEntityResolver);
        }
    }

    @Override
    public XMLEntityResolver getEntityResolver() {
        return (XMLEntityResolver)this.fProperties.get("http://apache.org/xml/properties/internal/entity-resolver");
    }

    @Override
    public void setErrorHandler(XMLErrorHandler xMLErrorHandler) {
        if (xMLErrorHandler != null) {
            this.fProperties.put("http://apache.org/xml/properties/internal/error-handler", xMLErrorHandler);
        }
    }

    @Override
    public XMLErrorHandler getErrorHandler() {
        return (XMLErrorHandler)this.fProperties.get("http://apache.org/xml/properties/internal/error-handler");
    }

    @Override
    public boolean getFeature(String string) {
        if (string.equals("http://apache.org/xml/features/internal/parser-settings")) {
            return true;
        }
        return super.getFeature(string);
    }

    @Override
    public void setFeature(String string, boolean bl) {
        super.setFeature(string, bl);
    }

    @Override
    public void setProperty(String string, Object object) {
        super.setProperty(string, object);
    }

    @Override
    public void setLocale(Locale locale) {
        this.fLocale = locale;
        this.fErrorReporter.setLocale(locale);
    }

    @Override
    public Locale getLocale() {
        return this.fLocale;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void setParameter(String string, Object object) {
        boolean bl = true;
        if (object instanceof Boolean) {
            boolean bl2 = (Boolean)object;
            if (string.equalsIgnoreCase("comments")) {
                this.features = (short)(bl2 ? this.features | 0x20 : this.features & 0xFFFFFFDF);
            } else if (string.equalsIgnoreCase("datatype-normalization")) {
                this.setFeature("http://apache.org/xml/features/validation/schema/normalized-value", bl2);
                this.features = (short)(bl2 ? this.features | 2 : this.features & 0xFFFFFFFD);
                if (bl2) {
                    this.features = (short)(this.features | 0x40);
                }
            } else if (string.equalsIgnoreCase("namespaces")) {
                this.features = (short)(bl2 ? this.features | 1 : this.features & 0xFFFFFFFE);
            } else if (string.equalsIgnoreCase("cdata-sections")) {
                this.features = (short)(bl2 ? this.features | 8 : this.features & 0xFFFFFFF7);
            } else if (string.equalsIgnoreCase("entities")) {
                this.features = (short)(bl2 ? this.features | 4 : this.features & 0xFFFFFFFB);
            } else if (string.equalsIgnoreCase("split-cdata-sections")) {
                this.features = (short)(bl2 ? this.features | 0x10 : this.features & 0xFFFFFFEF);
            } else if (string.equalsIgnoreCase("validate")) {
                this.features = (short)(bl2 ? this.features | 0x40 : this.features & 0xFFFFFFBF);
            } else if (string.equalsIgnoreCase("well-formed")) {
                this.features = (short)(bl2 ? this.features | 0x100 : this.features & 0xFFFFFEFF);
            } else if (string.equalsIgnoreCase("namespace-declarations")) {
                this.features = (short)(bl2 ? this.features | 0x200 : this.features & 0xFFFFFDFF);
            } else if (string.equalsIgnoreCase("infoset")) {
                if (bl2) {
                    this.features = (short)(this.features | 0x321);
                    this.features = (short)(this.features & 0xFFFFFFF1);
                    this.setFeature("http://apache.org/xml/features/validation/schema/normalized-value", false);
                }
            } else if (string.equalsIgnoreCase("normalize-characters") || string.equalsIgnoreCase("canonical-form") || string.equalsIgnoreCase("validate-if-schema") || string.equalsIgnoreCase("check-character-normalization")) {
                if (bl2) {
                    String string2 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "FEATURE_NOT_SUPPORTED", new Object[]{string});
                    throw new DOMException(9, string2);
                }
            } else if (string.equalsIgnoreCase("element-content-whitespace")) {
                if (!bl2) {
                    String string3 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "FEATURE_NOT_SUPPORTED", new Object[]{string});
                    throw new DOMException(9, string3);
                }
            } else if (string.equalsIgnoreCase("http://apache.org/xml/features/validation/schema/augment-psvi")) {
                if (!bl2) {
                    String string4 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "FEATURE_NOT_SUPPORTED", new Object[]{string});
                    throw new DOMException(9, string4);
                }
            } else if (string.equalsIgnoreCase("psvi")) {
                this.features = (short)(bl2 ? this.features | 0x80 : this.features & 0xFFFFFF7F);
            } else {
                bl = false;
            }
        }
        if (bl) {
            if (object instanceof Boolean) return;
        }
        bl = true;
        if (string.equalsIgnoreCase("error-handler")) {
            if (!(object instanceof DOMErrorHandler) && object != null) {
                String string5 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
                throw new DOMException(17, string5);
            }
            this.fErrorHandlerWrapper.setErrorHandler((DOMErrorHandler)object);
            this.setErrorHandler(this.fErrorHandlerWrapper);
            return;
        }
        if (string.equalsIgnoreCase("resource-resolver")) {
            if (!(object instanceof LSResourceResolver) && object != null) {
                String string6 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
                throw new DOMException(17, string6);
            }
            try {
                this.setEntityResolver(new DOMEntityResolverWrapper((LSResourceResolver)object));
                return;
            }
            catch (XMLConfigurationException xMLConfigurationException) {
                return;
            }
        }
        if (string.equalsIgnoreCase("schema-location")) {
            if (!(object instanceof String) && object != null) {
                String string7 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
                throw new DOMException(17, string7);
            }
            try {
                this.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource", object);
                return;
            }
            catch (XMLConfigurationException xMLConfigurationException) {
                return;
            }
        }
        if (string.equalsIgnoreCase("schema-type")) {
            if (!(object instanceof String) && object != null) {
                String string8 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
                throw new DOMException(17, string8);
            }
            try {
                if (object == null) {
                    this.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", null);
                    return;
                }
                if (object.equals(Constants.NS_XMLSCHEMA)) {
                    this.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", Constants.NS_XMLSCHEMA);
                    return;
                }
                if (!object.equals(Constants.NS_DTD)) return;
                this.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", Constants.NS_DTD);
                return;
            }
            catch (XMLConfigurationException xMLConfigurationException) {
                return;
            }
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/properties/internal/symbol-table")) {
            if (object instanceof SymbolTable) {
                this.setProperty("http://apache.org/xml/properties/internal/symbol-table", object);
                return;
            }
            String string9 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
            throw new DOMException(17, string9);
        }
        if (!string.equalsIgnoreCase("http://apache.org/xml/properties/internal/grammar-pool")) {
            String string10 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "FEATURE_NOT_FOUND", new Object[]{string});
            throw new DOMException(8, string10);
        }
        if (object instanceof XMLGrammarPool) {
            this.setProperty("http://apache.org/xml/properties/internal/grammar-pool", object);
            return;
        }
        String string11 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "TYPE_MISMATCH_ERR", new Object[]{string});
        throw new DOMException(17, string11);
    }

    @Override
    public Object getParameter(String string) {
        if (string.equalsIgnoreCase("comments")) {
            return (this.features & 0x20) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("namespaces")) {
            return (this.features & 1) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("datatype-normalization")) {
            return (this.features & 2) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("cdata-sections")) {
            return (this.features & 8) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("entities")) {
            return (this.features & 4) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("split-cdata-sections")) {
            return (this.features & 0x10) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("validate")) {
            return (this.features & 0x40) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("well-formed")) {
            return (this.features & 0x100) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("namespace-declarations")) {
            return (this.features & 0x200) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("infoset")) {
            return (this.features & 0x32F) == 801 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("normalize-characters") || string.equalsIgnoreCase("canonical-form") || string.equalsIgnoreCase("validate-if-schema") || string.equalsIgnoreCase("check-character-normalization")) {
            return Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/features/validation/schema/augment-psvi")) {
            return Boolean.TRUE;
        }
        if (string.equalsIgnoreCase("psvi")) {
            return (this.features & 0x80) != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("element-content-whitespace")) {
            return Boolean.TRUE;
        }
        if (string.equalsIgnoreCase("error-handler")) {
            return this.fErrorHandlerWrapper.getErrorHandler();
        }
        if (string.equalsIgnoreCase("resource-resolver")) {
            XMLEntityResolver xMLEntityResolver = this.getEntityResolver();
            if (xMLEntityResolver != null && xMLEntityResolver instanceof DOMEntityResolverWrapper) {
                return ((DOMEntityResolverWrapper)xMLEntityResolver).getEntityResolver();
            }
            return null;
        }
        if (string.equalsIgnoreCase("schema-type")) {
            return this.getProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage");
        }
        if (string.equalsIgnoreCase("schema-location")) {
            return this.getProperty("http://java.sun.com/xml/jaxp/properties/schemaSource");
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/properties/internal/symbol-table")) {
            return this.getProperty("http://apache.org/xml/properties/internal/symbol-table");
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/properties/internal/grammar-pool")) {
            return this.getProperty("http://apache.org/xml/properties/internal/grammar-pool");
        }
        String string2 = DOMMessageFormatter.formatMessage("http://www.w3.org/dom/DOMTR", "FEATURE_NOT_FOUND", new Object[]{string});
        throw new DOMException(8, string2);
    }

    @Override
    public boolean canSetParameter(String string, Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Boolean) {
            if (string.equalsIgnoreCase("comments") || string.equalsIgnoreCase("datatype-normalization") || string.equalsIgnoreCase("cdata-sections") || string.equalsIgnoreCase("entities") || string.equalsIgnoreCase("split-cdata-sections") || string.equalsIgnoreCase("namespaces") || string.equalsIgnoreCase("validate") || string.equalsIgnoreCase("well-formed") || string.equalsIgnoreCase("infoset") || string.equalsIgnoreCase("namespace-declarations")) {
                return true;
            }
            if (string.equalsIgnoreCase("normalize-characters") || string.equalsIgnoreCase("canonical-form") || string.equalsIgnoreCase("validate-if-schema") || string.equalsIgnoreCase("check-character-normalization")) {
                return !object.equals(Boolean.TRUE);
            }
            if (string.equalsIgnoreCase("element-content-whitespace") || string.equalsIgnoreCase("http://apache.org/xml/features/validation/schema/augment-psvi")) {
                return object.equals(Boolean.TRUE);
            }
            return false;
        }
        if (string.equalsIgnoreCase("error-handler")) {
            return object instanceof DOMErrorHandler;
        }
        if (string.equalsIgnoreCase("resource-resolver")) {
            return object instanceof LSResourceResolver;
        }
        if (string.equalsIgnoreCase("schema-location")) {
            return object instanceof String;
        }
        if (string.equalsIgnoreCase("schema-type")) {
            return object instanceof String && object.equals(Constants.NS_XMLSCHEMA);
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/properties/internal/symbol-table")) {
            return object instanceof SymbolTable;
        }
        if (string.equalsIgnoreCase("http://apache.org/xml/properties/internal/grammar-pool")) {
            return object instanceof XMLGrammarPool;
        }
        return false;
    }

    @Override
    public DOMStringList getParameterNames() {
        if (this.fRecognizedParameters == null) {
            Vector vector = new Vector();
            vector.add("comments");
            vector.add("datatype-normalization");
            vector.add("cdata-sections");
            vector.add("entities");
            vector.add("split-cdata-sections");
            vector.add("namespaces");
            vector.add("validate");
            vector.add("infoset");
            vector.add("normalize-characters");
            vector.add("canonical-form");
            vector.add("validate-if-schema");
            vector.add("check-character-normalization");
            vector.add("well-formed");
            vector.add("namespace-declarations");
            vector.add("element-content-whitespace");
            vector.add("error-handler");
            vector.add("schema-type");
            vector.add("schema-location");
            vector.add("resource-resolver");
            vector.add("http://apache.org/xml/properties/internal/grammar-pool");
            vector.add("http://apache.org/xml/properties/internal/symbol-table");
            vector.add("http://apache.org/xml/features/validation/schema/augment-psvi");
            this.fRecognizedParameters = new DOMStringListImpl(vector);
        }
        return this.fRecognizedParameters;
    }

    protected void reset() {
        if (this.fValidationManager != null) {
            this.fValidationManager.reset();
        }
        int n = this.fComponents.size();
        for (int i2 = 0; i2 < n; ++i2) {
            XMLComponent xMLComponent = (XMLComponent)this.fComponents.get(i2);
            xMLComponent.reset(this);
        }
    }

    @Override
    protected void checkProperty(String string) {
        int n;
        if (string.startsWith("http://xml.org/sax/properties/") && (n = string.length() - "http://xml.org/sax/properties/".length()) == "xml-string".length() && string.endsWith("xml-string")) {
            short s = 1;
            throw new XMLConfigurationException(s, string);
        }
        super.checkProperty(string);
    }

    protected void addComponent(XMLComponent xMLComponent) {
        if (this.fComponents.contains(xMLComponent)) {
            return;
        }
        this.fComponents.add(xMLComponent);
        String[] stringArray = xMLComponent.getRecognizedFeatures();
        this.addRecognizedFeatures(stringArray);
        String[] stringArray2 = xMLComponent.getRecognizedProperties();
        this.addRecognizedProperties(stringArray2);
    }

    protected ValidationManager createValidationManager() {
        return new ValidationManager();
    }

    protected final void setDTDValidatorFactory(String string) {
        if ("1.1".equals(string)) {
            if (this.fCurrentDVFactory != this.fXML11DatatypeFactory) {
                this.fCurrentDVFactory = this.fXML11DatatypeFactory;
                this.setProperty("http://apache.org/xml/properties/internal/datatype-validator-factory", this.fCurrentDVFactory);
            }
        } else if (this.fCurrentDVFactory != this.fDatatypeValidatorFactory) {
            this.fCurrentDVFactory = this.fDatatypeValidatorFactory;
            this.setProperty("http://apache.org/xml/properties/internal/datatype-validator-factory", this.fCurrentDVFactory);
        }
    }
}

