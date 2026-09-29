.version 50 0 
.class public super [213] 
.super [215] 
.implements [217] 
.implements [219] 
.implements [221] 
.field private [222] [223] 
.field private [224] [225] 
.field private [226] [227] 
.field private [228] [229] 

.method public [231] : [232] 
    .attribute [230] .code stack 3 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     iconst_1 
L3:     invokespecial [21] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [230] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iconst_1 
L3:     invokespecial [21] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [230] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [34] 
L9:     aload_0 
L10:    iconst_1 
L11:    putfield [35] 
L14:    aload_0 
L15:    iconst_1 
L16:    putfield [36] 
L19:    aload_0 
L20:    iconst_1 
L21:    putfield [37] 
L24:    aload_0 
L25:    aload_1 
L26:    iload_2 
L27:    invokespecial [23] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public final synchronized [237] : [238] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L23 
L7:     aload_0 
L8:     getfield [13] 
L11:    invokevirtual [17] 
L14:    checkcast [2] 
L17:    checkcast [2] 
L20:    goto L24 
L23:    aconst_null 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public final synchronized [239] : [240] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [35] 
L5:     aload_0 
L6:     aload_1 
L7:     ifnull L23 
L10:    aload_1 
L11:    invokevirtual [17] 
L14:    checkcast [2] 
L17:    checkcast [2] 
L20:    goto L24 
L23:    aconst_null 
L24:    putfield [34] 
L27:    return 
L28:    
    .end code 
.end method 

.method public final synchronized [241] : [242] 
    .attribute [230] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public final interface [243] : [244] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [245] : [246] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [36] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final interface [247] : [248] 
    .attribute [230] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final [249] : [250] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [37] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [230] .code stack 3 locals 2 
L0:     aconst_null 
L1:     astore_3 
L2:     aload_1 
L3:     ifnull L20 
L6:     aload_2 
L7:     ifnull L20 
L10:    aload_0 
L11:    aload_1 
L12:    aload_2 
L13:    invokespecial [24] 
L16:    astore_3 
L17:    goto L30 
L20:    aload_2 
L21:    ifnull L30 
L24:    aload_0 
L25:    aload_2 
L26:    invokespecial [25] 
L29:    astore_3 
L30:    aload_3 
L31:    ifnull L53 
L34:    new [38] 
L37:    dup 
L38:    aload_3 
L39:    invokespecial [26] 
L42:    astore 4 
L44:    aload 4 
L46:    aload_1 
L47:    invokevirtual [18] 
L50:    aload 4 
L52:    areturn 
L53:    aconst_null 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [230] .code stack 5 locals 2 
L0:     aconst_null 
L1:     astore 5 
L3:     aload_0 
L4:     invokespecial [27] 
L7:     ifne L45 
L10:    aload_3 
L11:    ifnull L45 
        .catch [5] from L14 to L40 using L43 
L14:    new [39] 
L17:    dup 
L18:    new [39] 
L21:    dup 
L22:    aload_3 
L23:    invokespecial [28] 
L26:    aload 4 
L28:    invokespecial [29] 
L31:    astore 6 
L33:    aload 6 
L35:    invokevirtual [19] 
L38:    astore 4 
L40:    goto L45 
L43:    astore 6 
L45:    aload_2 
L46:    ifnull L66 
L49:    aload 4 
L51:    ifnull L66 
L54:    aload_0 
L55:    aload_2 
L56:    aload 4 
L58:    invokespecial [24] 
L61:    astore 5 
L63:    goto L79 
L66:    aload 4 
L68:    ifnull L79 
L71:    aload_0 
L72:    aload 4 
L74:    invokespecial [25] 
L77:    astore 5 
L79:    aload 5 
L81:    ifnull L104 
L84:    new [38] 
L87:    dup 
L88:    aload 5 
L90:    invokespecial [26] 
L93:    astore 6 
L95:    aload 6 
L97:    aload_2 
L98:    invokevirtual [18] 
L101:   aload 6 
L103:   areturn 
L104:   aconst_null 
L105:   areturn 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [230] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [230] .code stack 5 locals 2 
L0:     aconst_null 
L1:     astore 6 
L3:     aload_2 
L4:     ifnull L14 
L7:     aload_0 
L8:     aload_2 
L9:     invokespecial [30] 
L12:    astore 6 
L14:    aload_0 
L15:    invokespecial [27] 
L18:    ifne L58 
L21:    aload 5 
L23:    ifnull L58 
        .catch [5] from L26 to L53 using L56 
        .catch [6] from L3 to L97 using L100 
L26:    new [39] 
L29:    dup 
L30:    new [39] 
L33:    dup 
L34:    aload 5 
L36:    invokespecial [28] 
L39:    aload 4 
L41:    invokespecial [29] 
L44:    astore 7 
L46:    aload 7 
L48:    invokevirtual [19] 
L51:    astore 4 
L53:    goto L58 
L56:    astore 7 
L58:    aload 6 
L60:    ifnonnull L97 
L63:    aload_3 
L64:    ifnull L84 
L67:    aload 4 
L69:    ifnull L84 
L72:    aload_0 
L73:    aload_3 
L74:    aload 4 
L76:    invokespecial [24] 
L79:    astore 6 
L81:    goto L97 
L84:    aload 4 
L86:    ifnull L97 
L89:    aload_0 
L90:    aload 4 
L92:    invokespecial [25] 
L95:    astore 6 
L97:    goto L102 
L100:   astore 7 
L102:   aload 6 
L104:   ifnull L120 
L107:   new [40] 
L110:   dup 
L111:   aload_3 
L112:   aload 6 
L114:   aload 5 
L116:   invokespecial [31] 
L119:   areturn 
L120:   aconst_null 
L121:   areturn 
L122:   nop 
L123:   nop 
L124:   
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [230] .code stack 5 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [20] 
L5:     astore_2 
L6:     aload_2 
L7:     ifnull L31 
L10:    new [41] 
L13:    dup 
L14:    aload_1 
L15:    invokeinterface [42] 0 
L20:    aload_2 
L21:    aload_1 
L22:    invokeinterface [43] 0 
L27:    invokespecial [32] 
L30:    areturn 
L31:    aconst_null 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [230] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_2 
L2:     aload_1 
L3:     invokeinterface [44] 0 
L8:     astore_3 
L9:     aload_3 
L10:    ifnull L19 
L13:    aload_0 
L14:    aload_3 
L15:    invokespecial [30] 
L18:    astore_2 
L19:    aload_2 
L20:    ifnonnull L89 
L23:    aload_1 
L24:    invokeinterface [42] 0 
L29:    astore 4 
L31:    aload_0 
L32:    invokespecial [27] 
L35:    ifeq L47 
L38:    aload_1 
L39:    invokeinterface [45] 0 
L44:    goto L53 
L47:    aload_1 
L48:    invokeinterface [46] 0 
L53:    astore 5 
L55:    aload 4 
L57:    ifnull L77 
L60:    aload 5 
L62:    ifnull L77 
L65:    aload_0 
L66:    aload 4 
L68:    aload 5 
L70:    invokespecial [24] 
L73:    astore_2 
L74:    goto L89 
L77:    aload 5 
L79:    ifnull L89 
L82:    aload_0 
L83:    aload 5 
L85:    invokespecial [25] 
L88:    astore_2 
L89:    aload_2 
L90:    areturn 
L91:    nop 
L92:    
    .end code 
.end method 

.method public final synchronized [263] : [264] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifeq L16 
L7:     aload_0 
L8:     invokespecial [33] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [35] 
L16:    ldc [9] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final synchronized [265] : [266] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifeq L16 
L7:     aload_0 
L8:     invokespecial [33] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [35] 
L16:    ldc [9] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public final synchronized [267] : [268] 
    .attribute [230] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifeq L16 
L7:     aload_0 
L8:     invokespecial [33] 
L11:    aload_0 
L12:    iconst_0 
L13:    putfield [35] 
L16:    ldc [9] 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method private [269] : [270] 
    .attribute [230] .code stack 2 locals 2 
L0:     aload_0 
L1:     dup 
L2:     astore_3 
L3:     monitorenter 
        .catch [0] from L4 to L28 using L31 
L4:     aload_0 
L5:     aload_1 
L6:     ifnull L22 
L9:     aload_1 
L10:    invokevirtual [17] 
L13:    checkcast [2] 
L16:    checkcast [2] 
L19:    goto L23 
L22:    aconst_null 
L23:    putfield [34] 
L26:    aload_3 
L27:    monitorexit 
L28:    goto L38 
        .catch [0] from L31 to L35 using L31 
L31:    astore 4 
L33:    aload_3 
L34:    monitorexit 
L35:    aload 4 
L37:    athrow 
L38:    aload_0 
L39:    iload_2 
L40:    putfield [36] 
L43:    return 
L44:    
    .end code 
.end method 

.method private enum [271] : [272] 
    .attribute [230] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [47] 
.const [3] = Class [48] 
.const [4] = Class [49] 
.const [5] = Class [50] 
.const [6] = Class [51] 
.const [7] = Class [52] 
.const [8] = Class [53] 
.const [9] = String [54] 
.const [10] = Class [55] 
.const [11] = Class [56] 
.const [12] = Class [57] 
.const [13] = Field [58] [59] 
.const [14] = Field [60] [61] 
.const [15] = Field [62] [63] 
.const [16] = Field [64] [65] 
.const [17] = Method [66] [67] 
.const [18] = Method [68] [69] 
.const [19] = Method [70] [71] 
.const [20] = Method [72] [73] 
.const [21] = Method [74] [75] 
.const [22] = Method [76] [77] 
.const [23] = Method [78] [79] 
.const [24] = Method [80] [81] 
.const [25] = Method [82] [83] 
.const [26] = Method [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Field [100] [101] 
.const [35] = Field [102] [103] 
.const [36] = Field [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Class [108] 
.const [39] = Class [109] 
.const [40] = Class [110] 
.const [41] = Class [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = InterfaceMethod [116] [117] 
.const [45] = InterfaceMethod [118] [119] 
.const [46] = InterfaceMethod [120] [121] 
.const [47] = Utf8 [Ljava/lang/String; 
.const [48] = Utf8 org/xml/sax/InputSource 
.const [49] = Utf8 org/apache/xerces/util/URI 
.const [50] = Utf8 org/apache/xerces/util/URI$MalformedURIException 
.const [51] = Utf8 java/io/IOException 
.const [52] = Utf8 org/apache/xerces/dom/DOMInputImpl 
.const [53] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [54] = Utf8 '' 
.const [55] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [56] = Utf8 java/lang/Object 
.const [57] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [58] = Class [122] 
.const [59] = NameAndType [123] [124] 
.const [60] = Class [125] 
.const [61] = NameAndType [126] [127] 
.const [62] = Class [128] 
.const [63] = NameAndType [129] [130] 
.const [64] = Class [131] 
.const [65] = NameAndType [132] [133] 
.const [66] = Class [134] 
.const [67] = NameAndType [135] [136] 
.const [68] = Class [137] 
.const [69] = NameAndType [138] [139] 
.const [70] = Class [140] 
.const [71] = NameAndType [141] [142] 
.const [72] = Class [143] 
.const [73] = NameAndType [144] [145] 
.const [74] = Class [146] 
.const [75] = NameAndType [147] [148] 
.const [76] = Class [149] 
.const [77] = NameAndType [150] [151] 
.const [78] = Class [152] 
.const [79] = NameAndType [153] [154] 
.const [80] = Class [155] 
.const [81] = NameAndType [156] [157] 
.const [82] = Class [158] 
.const [83] = NameAndType [159] [160] 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Utf8 org/xml/sax/InputSource 
.const [109] = Utf8 org/apache/xerces/util/URI 
.const [110] = Utf8 org/apache/xerces/dom/DOMInputImpl 
.const [111] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Class [203] 
.const [117] = NameAndType [204] [205] 
.const [118] = Class [206] 
.const [119] = NameAndType [207] [208] 
.const [120] = Class [209] 
.const [121] = NameAndType [210] [211] 
.const [122] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [123] = Utf8 fCatalogsList 
.const [124] = Utf8 [Ljava/lang/String; 
.const [125] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [126] = Utf8 fCatalogsChanged 
.const [127] = Utf8 Z 
.const [128] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [129] = Utf8 fPreferPublic 
.const [130] = Utf8 Z 
.const [131] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [132] = Utf8 fUseLiteralSystemId 
.const [133] = Utf8 Z 
.const [134] = Utf8 java/lang/Object 
.const [135] = Utf8 clone 
.const [136] = Utf8 ()Ljava/lang/Object; 
.const [137] = Utf8 org/xml/sax/InputSource 
.const [138] = Utf8 setPublicId 
.const [139] = Utf8 (Ljava/lang/String;)V 
.const [140] = Utf8 org/apache/xerces/util/URI 
.const [141] = Utf8 toString 
.const [142] = Utf8 ()Ljava/lang/String; 
.const [143] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [144] = Utf8 resolveIdentifier 
.const [145] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Ljava/lang/String; 
.const [146] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ([Ljava/lang/String;Z)V 
.const [149] = Utf8 java/lang/Object 
.const [150] = Utf8 <init> 
.const [151] = Utf8 ()V 
.const [152] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [153] = Utf8 init 
.const [154] = Utf8 ([Ljava/lang/String;Z)V 
.const [155] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [156] = Utf8 resolvePublic 
.const [157] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [158] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [159] = Utf8 resolveSystem 
.const [160] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [161] = Utf8 org/xml/sax/InputSource 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Ljava/lang/String;)V 
.const [164] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [165] = Utf8 getUseLiteralSystemId 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 org/apache/xerces/util/URI 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Ljava/lang/String;)V 
.const [170] = Utf8 org/apache/xerces/util/URI 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lorg/apache/xerces/util/URI;Ljava/lang/String;)V 
.const [173] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [174] = Utf8 resolveURI 
.const [175] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [176] = Utf8 org/apache/xerces/dom/DOMInputImpl 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [179] = Utf8 org/apache/xerces/xni/parser/XMLInputSource 
.const [180] = Utf8 <init> 
.const [181] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V 
.const [182] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [183] = Utf8 parseCatalogs 
.const [184] = Utf8 ()V 
.const [185] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [186] = Utf8 fCatalogsList 
.const [187] = Utf8 [Ljava/lang/String; 
.const [188] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [189] = Utf8 fCatalogsChanged 
.const [190] = Utf8 Z 
.const [191] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [192] = Utf8 fPreferPublic 
.const [193] = Utf8 Z 
.const [194] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [195] = Utf8 fUseLiteralSystemId 
.const [196] = Utf8 Z 
.const [197] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [198] = Utf8 getPublicId 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [201] = Utf8 getBaseSystemId 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [204] = Utf8 getNamespace 
.const [205] = Utf8 ()Ljava/lang/String; 
.const [206] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [207] = Utf8 getLiteralSystemId 
.const [208] = Utf8 ()Ljava/lang/String; 
.const [209] = Utf8 org/apache/xerces/xni/XMLResourceIdentifier 
.const [210] = Utf8 getExpandedSystemId 
.const [211] = Utf8 ()Ljava/lang/String; 
.const [212] = Utf8 org/apache/xerces/util/XMLCatalogResolver 
.const [213] = Class [212] 
.const [214] = Utf8 java/lang/Object 
.const [215] = Class [214] 
.const [216] = Utf8 org/apache/xerces/xni/parser/XMLEntityResolver 
.const [217] = Class [216] 
.const [218] = Utf8 org/xml/sax/ext/EntityResolver2 
.const [219] = Class [218] 
.const [220] = Utf8 org/w3c/dom/ls/LSResourceResolver 
.const [221] = Class [220] 
.const [222] = Utf8 fCatalogsList 
.const [223] = Utf8 [Ljava/lang/String; 
.const [224] = Utf8 fCatalogsChanged 
.const [225] = Utf8 Z 
.const [226] = Utf8 fPreferPublic 
.const [227] = Utf8 Z 
.const [228] = Utf8 fUseLiteralSystemId 
.const [229] = Utf8 Z 
.const [230] = Utf8 Code 
.const [231] = Utf8 <init> 
.const [232] = Utf8 ()V 
.const [233] = Utf8 <init> 
.const [234] = Utf8 ([Ljava/lang/String;)V 
.const [235] = Utf8 <init> 
.const [236] = Utf8 ([Ljava/lang/String;Z)V 
.const [237] = Utf8 getCatalogList 
.const [238] = Utf8 ()[Ljava/lang/String; 
.const [239] = Utf8 setCatalogList 
.const [240] = Utf8 ([Ljava/lang/String;)V 
.const [241] = Utf8 clear 
.const [242] = Utf8 ()V 
.const [243] = Utf8 getPreferPublic 
.const [244] = Utf8 ()Z 
.const [245] = Utf8 setPreferPublic 
.const [246] = Utf8 (Z)V 
.const [247] = Utf8 getUseLiteralSystemId 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 setUseLiteralSystemId 
.const [250] = Utf8 (Z)V 
.const [251] = Utf8 resolveEntity 
.const [252] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lorg/xml/sax/InputSource; 
.const [253] = Utf8 resolveEntity 
.const [254] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xml/sax/InputSource; 
.const [255] = Utf8 getExternalSubset 
.const [256] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Lorg/xml/sax/InputSource; 
.const [257] = Utf8 resolveResource 
.const [258] = Utf8 (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/w3c/dom/ls/LSInput; 
.const [259] = Utf8 resolveEntity 
.const [260] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Lorg/apache/xerces/xni/parser/XMLInputSource; 
.const [261] = Utf8 resolveIdentifier 
.const [262] = Utf8 (Lorg/apache/xerces/xni/XMLResourceIdentifier;)Ljava/lang/String; 
.const [263] = Utf8 resolveSystem 
.const [264] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [265] = Utf8 resolvePublic 
.const [266] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [267] = Utf8 resolveURI 
.const [268] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [269] = Utf8 init 
.const [270] = Utf8 ([Ljava/lang/String;Z)V 
.const [271] = Utf8 parseCatalogs 
.const [272] = Utf8 ()V 
.end class 
