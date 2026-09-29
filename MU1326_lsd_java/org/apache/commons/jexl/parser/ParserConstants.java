/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public interface ParserConstants {
    public static final int EOF;
    public static final int COMMENT;
    public static final int INTEGER_LITERAL;
    public static final int FLOAT_LITERAL;
    public static final int IDENTIFIER;
    public static final int LETTER;
    public static final int DIGIT;
    public static final int STRING_LITERAL;
    public static final int DEFAULT;
    public static final String[] tokenImage;

    static {
        tokenImage = new String[]{"<EOF>", "<COMMENT>", "\" \"", "\"\\t\"", "\"\\n\"", "\"\\r\"", "\"\\f\"", "<INTEGER_LITERAL>", "<FLOAT_LITERAL>", "\"{\"", "\"}\"", "\"empty\"", "\"(\"", "\")\"", "\"size\"", "\"=\"", "\"||\"", "\"or\"", "\"&&\"", "\"and\"", "\"|\"", "\"^\"", "\"&\"", "\"==\"", "\"eq\"", "\"!=\"", "\"ne\"", "\"<\"", "\"lt\"", "\">\"", "\"gt\"", "\"<=\"", "\"le\"", "\">=\"", "\"ge\"", "\"+\"", "\"-\"", "\"*\"", "\"/\"", "\"div\"", "\"%\"", "\"mod\"", "\"~\"", "\"!\"", "\"not\"", "\"null\"", "\"true\"", "\"false\"", "\";\"", "\"if\"", "\"else\"", "\"while\"", "\"foreach\"", "\"in\"", "\",\"", "\"[\"", "\"]\"", "\".\"", "<IDENTIFIER>", "<LETTER>", "<DIGIT>", "<STRING_LITERAL>"};
    }
}

