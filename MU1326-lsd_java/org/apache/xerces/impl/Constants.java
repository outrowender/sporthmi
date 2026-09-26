/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.util.Enumeration;
import org.apache.xerces.impl.Constants$ArrayEnumeration;

public final class Constants {
    public static final String NS_XMLSCHEMA = "http://www.w3.org/2001/XMLSchema".intern();
    public static final String NS_DTD = "http://www.w3.org/TR/REC-xml".intern();
    public static final String SAX_FEATURE_PREFIX;
    public static final String NAMESPACES_FEATURE;
    public static final String NAMESPACE_PREFIXES_FEATURE;
    public static final String STRING_INTERNING_FEATURE;
    public static final String VALIDATION_FEATURE;
    public static final String EXTERNAL_GENERAL_ENTITIES_FEATURE;
    public static final String EXTERNAL_PARAMETER_ENTITIES_FEATURE;
    public static final String LEXICAL_HANDLER_PARAMETER_ENTITIES_FEATURE;
    public static final String IS_STANDALONE_FEATURE;
    public static final String RESOLVE_DTD_URIS_FEATURE;
    public static final String USE_ATTRIBUTES2_FEATURE;
    public static final String USE_LOCATOR2_FEATURE;
    public static final String USE_ENTITY_RESOLVER2_FEATURE;
    public static final String UNICODE_NORMALIZATION_CHECKING_FEATURE;
    public static final String XMLNS_URIS_FEATURE;
    public static final String XML_11_FEATURE;
    public static final String ALLOW_DTD_EVENTS_AFTER_ENDDTD_FEATURE;
    public static final String SAX_PROPERTY_PREFIX;
    public static final String DECLARATION_HANDLER_PROPERTY;
    public static final String LEXICAL_HANDLER_PROPERTY;
    public static final String DOM_NODE_PROPERTY;
    public static final String XML_STRING_PROPERTY;
    public static final String DOCUMENT_XML_VERSION_PROPERTY;
    public static final String JAXP_PROPERTY_PREFIX;
    public static final String SCHEMA_SOURCE;
    public static final String SCHEMA_LANGUAGE;
    public static final String INCLUDE_COMMENTS_FEATURE;
    public static final String CREATE_CDATA_NODES_FEATURE;
    public static final String LOAD_AS_INFOSET;
    public static final String DOM_CANONICAL_FORM;
    public static final String DOM_CDATA_SECTIONS;
    public static final String DOM_COMMENTS;
    public static final String DOM_CHARSET_OVERRIDES_XML_ENCODING;
    public static final String DOM_DATATYPE_NORMALIZATION;
    public static final String DOM_ENTITIES;
    public static final String DOM_INFOSET;
    public static final String DOM_NAMESPACES;
    public static final String DOM_NAMESPACE_DECLARATIONS;
    public static final String DOM_SUPPORTED_MEDIATYPES_ONLY;
    public static final String DOM_VALIDATE_IF_SCHEMA;
    public static final String DOM_VALIDATE;
    public static final String DOM_ELEMENT_CONTENT_WHITESPACE;
    public static final String DOM_DISCARD_DEFAULT_CONTENT;
    public static final String DOM_NORMALIZE_CHARACTERS;
    public static final String DOM_CHECK_CHAR_NORMALIZATION;
    public static final String DOM_WELLFORMED;
    public static final String DOM_SPLIT_CDATA;
    public static final String DOM_FORMAT_PRETTY_PRINT;
    public static final String DOM_XMLDECL;
    public static final String DOM_UNKNOWNCHARS;
    public static final String DOM_CERTIFIED;
    public static final String DOM_DISALLOW_DOCTYPE;
    public static final String DOM_IGNORE_UNKNOWN_CHARACTER_DENORMALIZATIONS;
    public static final String DOM_RESOURCE_RESOLVER;
    public static final String DOM_ERROR_HANDLER;
    public static final String DOM_SCHEMA_TYPE;
    public static final String DOM_SCHEMA_LOCATION;
    public static final String DOM_PSVI;
    public static final String XERCES_FEATURE_PREFIX;
    public static final String SCHEMA_VALIDATION_FEATURE;
    public static final String SCHEMA_NORMALIZED_VALUE;
    public static final String SCHEMA_ELEMENT_DEFAULT;
    public static final String SCHEMA_FULL_CHECKING;
    public static final String SCHEMA_AUGMENT_PSVI;
    public static final String DYNAMIC_VALIDATION_FEATURE;
    public static final String WARN_ON_DUPLICATE_ATTDEF_FEATURE;
    public static final String WARN_ON_UNDECLARED_ELEMDEF_FEATURE;
    public static final String WARN_ON_DUPLICATE_ENTITYDEF_FEATURE;
    public static final String ALLOW_JAVA_ENCODINGS_FEATURE;
    public static final String DISALLOW_DOCTYPE_DECL_FEATURE;
    public static final String CONTINUE_AFTER_FATAL_ERROR_FEATURE;
    public static final String LOAD_DTD_GRAMMAR_FEATURE;
    public static final String LOAD_EXTERNAL_DTD_FEATURE;
    public static final String DEFER_NODE_EXPANSION_FEATURE;
    public static final String CREATE_ENTITY_REF_NODES_FEATURE;
    public static final String INCLUDE_IGNORABLE_WHITESPACE;
    public static final String DEFAULT_ATTRIBUTE_VALUES_FEATURE;
    public static final String VALIDATE_CONTENT_MODELS_FEATURE;
    public static final String VALIDATE_DATATYPES_FEATURE;
    public static final String BALANCE_SYNTAX_TREES;
    public static final String NOTIFY_CHAR_REFS_FEATURE;
    public static final String NOTIFY_BUILTIN_REFS_FEATURE;
    public static final String STANDARD_URI_CONFORMANT_FEATURE;
    public static final String GENERATE_SYNTHETIC_ANNOTATIONS_FEATURE;
    public static final String VALIDATE_ANNOTATIONS_FEATURE;
    public static final String HONOUR_ALL_SCHEMALOCATIONS_FEATURE;
    public static final String XINCLUDE_FEATURE;
    public static final String XINCLUDE_FIXUP_BASE_URIS_FEATURE;
    public static final String XINCLUDE_FIXUP_LANGUAGE_FEATURE;
    public static final String IGNORE_XSI_TYPE_FEATURE;
    public static final String ID_IDREF_CHECKING_FEATURE;
    public static final String IDC_CHECKING_FEATURE;
    public static final String UNPARSED_ENTITY_CHECKING_FEATURE;
    public static final String USE_GRAMMAR_POOL_ONLY_FEATURE;
    public static final String PARSER_SETTINGS;
    public static final String XERCES_PROPERTY_PREFIX;
    public static final String CURRENT_ELEMENT_NODE_PROPERTY;
    public static final String DOCUMENT_CLASS_NAME_PROPERTY;
    public static final String SYMBOL_TABLE_PROPERTY;
    public static final String ERROR_REPORTER_PROPERTY;
    public static final String ERROR_HANDLER_PROPERTY;
    public static final String XINCLUDE_HANDLER_PROPERTY;
    public static final String XPOINTER_HANDLER_PROPERTY;
    public static final String ENTITY_MANAGER_PROPERTY;
    public static final String BUFFER_SIZE_PROPERTY;
    public static final String SECURITY_MANAGER_PROPERTY;
    public static final String ENTITY_RESOLVER_PROPERTY;
    public static final String XMLGRAMMAR_POOL_PROPERTY;
    public static final String DATATYPE_VALIDATOR_FACTORY_PROPERTY;
    public static final String DOCUMENT_SCANNER_PROPERTY;
    public static final String DTD_SCANNER_PROPERTY;
    public static final String DTD_PROCESSOR_PROPERTY;
    public static final String VALIDATOR_PROPERTY;
    public static final String DTD_VALIDATOR_PROPERTY;
    public static final String SCHEMA_VALIDATOR_PROPERTY;
    public static final String SCHEMA_LOCATION;
    public static final String SCHEMA_NONS_LOCATION;
    public static final String NAMESPACE_BINDER_PROPERTY;
    public static final String NAMESPACE_CONTEXT_PROPERTY;
    public static final String VALIDATION_MANAGER_PROPERTY;
    public static final String ROOT_TYPE_DEFINITION_PROPERTY;
    public static final String ELEMENT_PSVI;
    public static final String ATTRIBUTE_PSVI;
    public static final String ATTRIBUTE_DECLARED;
    public static final String ENTITY_SKIPPED;
    public static final String CHAR_REF_PROBABLE_WS;
    public static final short XML_VERSION_ERROR;
    public static final short XML_VERSION_1_0;
    public static final short XML_VERSION_1_1;
    public static final boolean SCHEMA_1_1_SUPPORT;
    private static final String[] fgSAXFeatures;
    private static final String[] fgSAXProperties;
    private static final String[] fgXercesFeatures;
    private static final String[] fgXercesProperties;
    private static final Enumeration fgEmptyEnumeration;

    private Constants() {
    }

    public static Enumeration getSAXFeatures() {
        return fgSAXFeatures.length > 0 ? new Constants$ArrayEnumeration(fgSAXFeatures) : fgEmptyEnumeration;
    }

    public static Enumeration getSAXProperties() {
        return fgSAXProperties.length > 0 ? new Constants$ArrayEnumeration(fgSAXProperties) : fgEmptyEnumeration;
    }

    public static Enumeration getXercesFeatures() {
        return fgXercesFeatures.length > 0 ? new Constants$ArrayEnumeration(fgXercesFeatures) : fgEmptyEnumeration;
    }

    public static Enumeration getXercesProperties() {
        return fgXercesProperties.length > 0 ? new Constants$ArrayEnumeration(fgXercesProperties) : fgEmptyEnumeration;
    }

    public static void main(String[] stringArray) {
        Constants.print("SAX features:", "http://xml.org/sax/features/", fgSAXFeatures);
        Constants.print("SAX properties:", "http://xml.org/sax/properties/", fgSAXProperties);
        Constants.print("Xerces features:", "http://apache.org/xml/features/", fgXercesFeatures);
        Constants.print("Xerces properties:", "http://apache.org/xml/properties/", fgXercesProperties);
    }

    private static void print(String string, String string2, Object[] objectArray) {
        System.out.print(string);
        if (objectArray.length > 0) {
            System.out.println();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                System.out.print("  ");
                System.out.print(string2);
                System.out.println(objectArray[i2]);
            }
        } else {
            System.out.println(" none.");
        }
    }

    static {
        fgSAXFeatures = new String[]{"namespaces", "namespace-prefixes", "string-interning", "validation", "external-general-entities", "external-parameter-entities"};
        fgSAXProperties = new String[]{"declaration-handler", "lexical-handler", "dom-node", "xml-string"};
        fgXercesFeatures = new String[]{"validation/schema", "validation/schema-full-checking", "validation/dynamic", "validation/warn-on-duplicate-attdef", "validation/warn-on-undeclared-elemdef", "allow-java-encodings", "continue-after-fatal-error", "nonvalidating/load-dtd-grammar", "nonvalidating/load-external-dtd", "dom/create-entity-ref-nodes", "dom/include-ignorable-whitespace", "validation/default-attribute-values", "validation/validate-content-models", "validation/validate-datatypes", "validation/balance-syntax-trees", "scanner/notify-char-refs", "scanner/notify-builtin-refs", "disallow-doctype-decl", "standard-uri-conformant", "generate-synthetic-annotations", "validate-annotations", "honour-all-schemaLocations", "xinclude", "xinclude/fixup-base-uris", "xinclude/fixup-language", "validation/schema/ignore-xsi-type-until-elemdecl", "validation/id-idref-checking", "validation/identity-constraint-checking", "validation/unparsed-entity-checking"};
        fgXercesProperties = new String[]{"dom/current-element-node", "dom/document-class-name", "internal/symbol-table", "internal/error-handler", "internal/error-reporter", "internal/entity-manager", "internal/entity-resolver", "internal/grammar-pool", "internal/datatype-validator-factory", "internal/document-scanner", "internal/dtd-scanner", "internal/validator", "schema/external-schemaLocation", "schema/external-noNamespaceSchemaLocation", "internal/validation-manager", "input-buffer-size", "security-manager", "validation/schema/root-type-definition"};
        fgEmptyEnumeration = new Constants$ArrayEnumeration(new Object[0]);
    }
}

