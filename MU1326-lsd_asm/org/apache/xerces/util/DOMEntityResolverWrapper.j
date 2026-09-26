.version 50 0 
.class public super [179] 
.super [181] 
.implements [183] 
.field private static final [184] [185] 
.field private static final [186] [187] 
.field protected [188] [189] 

.method public annotation [191] : [192] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [13] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [190] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [197] : [198] 
    .attribute [190] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [190] .code stack 6 locals 9 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnull L207 
L7:     aload_1 
L8:     ifnonnull L28 
L11:    aload_0 
L12:    getfield [14] 
L15:    aconst_null 
L16:    aconst_null 
L17:    aconst_null 
L18:    aconst_null 
L19:    aconst_null 
L20:    invokeinterface [25] 0 
L25:    goto L66 
L28:    aload_0 
L29:    getfield [14] 
L32:    aload_0 
L33:    aload_1 
L34:    invokespecial [21] 
L37:    aload_1 
L38:    invokeinterface [26] 0 
L43:    aload_1 
L44:    invokeinterface [27] 0 
L49:    aload_1 
L50:    invokeinterface [28] 0 
L55:    aload_1 
L56:    invokeinterface [29] 0 
L61:    invokeinterface [25] 0 
L66:    astore_2 
L67:    aload_2 
L68:    ifnull L207 
L71:    aload_2 
L72:    invokeinterface [30] 0 
L77:    astore_3 
L78:    aload_2 
L79:    invokeinterface [31] 0 
L84:    astore 4 
L86:    aload_2 
L87:    invokeinterface [32] 0 
L92:    astore 5 
L94:    aload_2 
L95:    invokeinterface [33] 0 
L100:   astore 6 
L102:   aload_2 
L103:   invokeinterface [34] 0 
L108:   astore 7 
L110:   aload_2 
L111:   invokeinterface [35] 0 
L116:   astore 8 
L118:   aload_2 
L119:   invokeinterface [36] 0 
L124:   astore 9 
L126:   new [37] 
L129:   dup 
L130:   aload_3 
L131:   aload 4 
L133:   aload 5 
L135:   invokespecial [22] 
L138:   astore 10 
L140:   aload 7 
L142:   ifnull L155 
L145:   aload 10 
L147:   aload 7 
L149:   invokevirtual [15] 
L152:   goto L197 
L155:   aload 6 
L157:   ifnull L170 
L160:   aload 10 
L162:   aload 6 
L164:   invokevirtual [16] 
L167:   goto L197 
L170:   aload 9 
L172:   ifnull L197 
L175:   aload 9 
L177:   invokevirtual [17] 
L180:   ifeq L197 
L183:   aload 10 
L185:   new [38] 
L188:   dup 
L189:   aload 9 
L191:   invokespecial [23] 
L194:   invokevirtual [15] 
L197:   aload 10 
L199:   aload 8 
L201:   invokevirtual [18] 
L204:   aload 10 
L206:   areturn 
L207:   aconst_null 
L208:   areturn 
L209:   nop 
L210:   nop 
L211:   nop 
L212:   
    .end code 
.end method 

.method private [201] : [202] 
    .attribute [190] .code stack 2 locals 1 
L0:     aload_1 
L1:     instanceof [4] 
L4:     ifeq L29 
L7:     aload_1 
L8:     checkcast [4] 
L11:    astore_2 
L12:    ldc [5] 
L14:    aload_2 
L15:    invokeinterface [39] 0 
L20:    invokevirtual [19] 
L23:    ifeq L29 
L26:    ldc [5] 
L28:    areturn 
L29:    ldc [6] 
L31:    areturn 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = Class [41] 
.const [4] = Class [42] 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = Class [45] 
.const [8] = Class [46] 
.const [9] = Class [47] 
.const [10] = Class [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Method [51] [52] 
.const [14] = Field [53] [54] 
.const [15] = Method [55] [56] 
.const [16] = Method [57] [58] 
.const [17] = Method [59] [60] 
.const [18] = Method [61] [62] 
.const [19] = Method [63] [64] 
.const [20] = Method [65] [66] 
.const [21] = Method [67] [68] 
.const [22] = Method [69] [70] 
.const [23] = Method [71] [72] 
.const [24] = Field [73] [74] 
.const [25] = InterfaceMethod [75] [76] 
.const [26] = InterfaceMethod [77] [78] 
.const [27] = InterfaceMethod [79] [80] 
.const [28] = InterfaceMethod [81] [82] 
.const [29] = InterfaceMethod [83] [84] 
.const [30] = InterfaceMethod [85] [86] 
.const [31] = InterfaceMethod [87] [88] 
.const [32] = InterfaceMethod [89] [90] 
.const [33] = InterfaceMethod [91] [92] 
.const [34] = InterfaceMethod [93] [94] 
.const [35] = InterfaceMethod [95] [96] 
.const [36] = InterfaceMethod [97] [98] 
.const [37] = Class [99] 
.const [38] = Class [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [41] = Utf8 java/io/StringReader 
.const [42] = Utf8 org/apache/xerces/xni/grammars/XMLGrammarDescription 
.const [43] = Utf8 'http://www.w3.org/2001/XMLSchema' 
.const [44] = Utf8 'http://www.w3.org/TR/REC-xml' 
.const [45] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 org/w3c/dom/ls/LSResourceResolver 
.const [48] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [49] = Utf8 org/w3c/dom/ls/LSInput 
.const [50] = Utf8 java/lang/String 
.const [51] = Class [103] 
.const [52] = NameAndType [104] [105] 
.const [53] = Class [106] 
.const [54] = NameAndType [107] [108] 
.const [55] = Class [109] 
.const [56] = NameAndType [110] [111] 
.const [57] = Class [112] 
.const [58] = NameAndType [113] [114] 
.const [59] = Class [115] 
.const [60] = NameAndType [116] [117] 
.const [61] = Class [118] 
.const [62] = NameAndType [119] [120] 
.const [63] = Class [121] 
.const [64] = NameAndType [122] [123] 
.const [65] = Class [124] 
.const [66] = NameAndType [125] [126] 
.const [67] = Class [127] 
.const [68] = NameAndType [128] [129] 
.const [69] = Class [130] 
.const [70] = NameAndType [131] [132] 
.const [71] = Class [133] 
.const [72] = NameAndType [134] [135] 
.const [73] = Class [136] 
.const [74] = NameAndType [137] [138] 
.const [75] = Class [139] 
.const [76] = NameAndType [140] [141] 
.const [77] = Class [142] 
.const [78] = NameAndType [143] [144] 
.const [79] = Class [145] 
.const [80] = NameAndType [146] [147] 
.const [81] = Class [148] 
.const [82] = NameAndType [149] [150] 
.const [83] = Class [151] 
.const [84] = NameAndType [152] [153] 
.const [85] = Class [154] 
.const [86] = NameAndType [155] [156] 
.const [87] = Class [157] 
.const [88] = NameAndType [158] [159] 
.const [89] = Class [160] 
.const [90] = NameAndType [161] [162] 
.const [91] = Class [163] 
.const [92] = NameAndType [164] [165] 
.const [93] = Class [166] 
.const [94] = NameAndType [167] [168] 
.const [95] = Class [169] 
.const [96] = NameAndType [170] [171] 
.const [97] = Class [172] 
.const [98] = NameAndType [173] [174] 
.const [99] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [100] = Utf8 java/io/StringReader 
.const [101] = Class [175] 
.const [102] = NameAndType [176] [177] 
.const [103] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [104] = Utf8 setEntityResolver 
.const [105] = Utf8 (Lorg/w3c/dom/ls/LSResourceResolver;)V 
.const [106] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [107] = Utf8 fEntityResolver 
.const [108] = Utf8 Lorg/w3c/dom/ls/LSResourceResolver; 
.const [109] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [110] = Utf8 setCharacterStream 
.const [111] = Utf8 (Ljava/io/Reader;)V 
.const [112] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [113] = Utf8 setByteStream 
.const [114] = Utf8 (Ljava/io/InputStream;)V 
.const [115] = Utf8 java/lang/String 
.const [116] = Utf8 length 
.const [117] = Utf8 ()I 
.const [118] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [119] = Utf8 setEncoding 
.const [120] = Utf8 (Ljava/lang/String;)V 
.const [121] = Utf8 java/lang/String 
.const [122] = Utf8 equals 
.const [123] = Utf8 (Ljava/lang/Object;)Z 
.const [124] = Utf8 java/lang/Object 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [128] = Utf8 getType 
.const [129] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Ljava/lang/String; 
.const [130] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [133] = Utf8 java/io/StringReader 
.const [134] = Utf8 <init> 
.const [135] = Utf8 (Ljava/lang/String;)V 
.const [136] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [137] = Utf8 fEntityResolver 
.const [138] = Utf8 Lorg/w3c/dom/ls/LSResourceResolver; 
.const [139] = Utf8 org/w3c/dom/ls/LSResourceResolver 
.const [140] = Utf8 resolveResource 
.const [141] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/ls/LSInput; 
.const [142] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [143] = Utf8 getNamespace 
.const [144] = Utf8 ()Ljava/lang/String; 
.const [145] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [146] = Utf8 getPublicId 
.const [147] = Utf8 ()Ljava/lang/String; 
.const [148] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [149] = Utf8 getLiteralSystemId 
.const [150] = Utf8 ()Ljava/lang/String; 
.const [151] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [152] = Utf8 getBaseSystemId 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 org/w3c/dom/ls/LSInput 
.const [155] = Utf8 getPublicId 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 org/w3c/dom/ls/LSInput 
.const [158] = Utf8 getSystemId 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 org/w3c/dom/ls/LSInput 
.const [161] = Utf8 getBaseURI 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 org/w3c/dom/ls/LSInput 
.const [164] = Utf8 getByteStream 
.const [165] = Utf8 ()Ljava/io/InputStream; 
.const [166] = Utf8 org/w3c/dom/ls/LSInput 
.const [167] = Utf8 getCharacterStream 
.const [168] = Utf8 ()Ljava/io/Reader; 
.const [169] = Utf8 org/w3c/dom/ls/LSInput 
.const [170] = Utf8 getEncoding 
.const [171] = Utf8 ()Ljava/lang/String; 
.const [172] = Utf8 org/w3c/dom/ls/LSInput 
.const [173] = Utf8 getStringData 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 org/apache/xerces/xni/grammars/XMLGrammarDescription 
.const [176] = Utf8 getGrammarType 
.const [177] = Utf8 ()Ljava/lang/String; 
.const [178] = Utf8 org/apache/xerces/util/DOMEntityResolverWrapper 
.const [179] = Class [178] 
.const [180] = Utf8 java/lang/Object 
.const [181] = Class [180] 
.const [182] = Utf8 org/apache/xerces/xni/parser/XMLEntityResolver 
.const [183] = Class [182] 
.const [184] = Utf8 XML_TYPE 
.const [185] = Utf8 Ljava/lang/String; 
.const [186] = Utf8 XSD_TYPE 
.const [187] = Utf8 Ljava/lang/String; 
.const [188] = Utf8 fEntityResolver 
.const [189] = Utf8 Lorg/w3c/dom/ls/LSResourceResolver; 
.const [190] = Utf8 Code 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lorg/w3c/dom/ls/LSResourceResolver;)V 
.const [195] = Utf8 setEntityResolver 
.const [196] = Utf8 (Lorg/w3c/dom/ls/LSResourceResolver;)V 
.const [197] = Utf8 getEntityResolver 
.const [198] = Utf8 ()Lorg/w3c/dom/ls/LSResourceResolver; 
.const [199] = Utf8 resolveEntity 
.const [200] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Lorg/apache/xerces/xni/parser/XMLInputSource; 
.const [201] = Utf8 getType 
.const [202] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Ljava/lang/String; 
.end class 
