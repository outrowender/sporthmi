/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.jexl.parser;

public interface ParserConstants {
    public static final int EOF = 0;
    public static final int COMMENT = 1;
    public static final int INTEGER_LITERAL = 7;
    public static final int FLOAT_LITERAL = 8;
    public static final int IDENTIFIER = 58;
    public static final int LETTER = 59;
    public static final int DIGIT = 60;
    public static final int STRING_LITERAL = 61;
    public static final int DEFAULT = 0;
    public static final String[] tokenImage = new String[]{"<EOF>", "<COMMENT>", "\" \"", "\"\\t\"", "\"\\n\"", "\"\\r\"", "\"\\f\"", "<INTEGER_LITERAL>", "<FLOAT_LITERAL>", "\"{\"", "\"}\"", "\"empty\"", "\"(\"", "\")\"", "\"size\"", "\"=\"", "\"||\"", "\"or\"", "\"&&\"", "\"and\"", "\"|\"", "\"^\"", "\"&\"", "\"==\"", "\"eq\"", "\"!=\"", "\"ne\"", "\"<\"", "\"lt\"", "\">\"", "\"gt\"", "\"<=\"", "\"le\"", "\">=\"", "\"ge\"", "\"+\"", "\"-\"", "\"*\"", "\"/\"", "\"div\"", "\"%\"", "\"mod\"", "\"~\"", "\"!\"", "\"not\"", "\"null\"", "\"true\"", "\"false\"", "\";\"", "\"if\"", "\"else\"", "\"while\"", "\"foreach\"", "\"in\"", "\",\"", "\"[\"", "\"]\"", "\".\"", "<IDENTIFIER>", "<LETTER>", "<DIGIT>", "<STRING_LITERAL>"};
}

