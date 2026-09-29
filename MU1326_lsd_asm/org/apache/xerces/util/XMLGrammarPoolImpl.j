.version 50 0 
.class public super [170] 
.super [172] 
.implements [174] 
.field protected static final [175] [176] 
.field protected [177] [178] 
.field protected [179] [180] 
.field protected [181] [182] 
.field private static final [183] [184] 

.method public [186] : [187] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [28] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [29] 
L14:    aload_0 
L15:    bipush 11 
L17:    anewarray [2] 
L20:    putfield [28] 
L23:    aload_0 
L24:    iconst_0 
L25:    putfield [31] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [28] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [29] 
L14:    aload_0 
L15:    iload_1 
L16:    anewarray [2] 
L19:    putfield [28] 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [31] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [185] .code stack 5 locals 7 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L116 using L117 
L7:     aload_0 
L8:     getfield [11] 
L11:    arraylength 
L12:    istore_3 
L13:    aload_0 
L14:    getfield [12] 
L17:    anewarray [3] 
L20:    astore 4 
L22:    iconst_0 
L23:    istore 5 
L25:    iconst_0 
L26:    istore 6 
L28:    iload 6 
L30:    iload_3 
L31:    if_icmpge L94 
L34:    aload_0 
L35:    getfield [11] 
L38:    iload 6 
L40:    aaload 
L41:    astore 7 
L43:    aload 7 
L45:    ifnull L88 
L48:    aload 7 
L50:    getfield [14] 
L53:    invokeinterface [32] 0 
L58:    aload_1 
L59:    invokevirtual [15] 
L62:    ifeq L78 
L65:    aload 4 
L67:    iload 5 
L69:    iinc 5 1 
L72:    aload 7 
L74:    getfield [16] 
L77:    aastore 
L78:    aload 7 
L80:    getfield [17] 
L83:    astore 7 
L85:    goto L43 
L88:    iinc 6 1 
L91:    goto L28 
L94:    iload 5 
L96:    anewarray [3] 
L99:    astore 6 
L101:   aload 4 
L103:   iconst_0 
L104:   aload 6 
L106:   iconst_0 
L107:   iload 5 
L109:   invokestatic [4] 
L112:   aload 6 
L114:   aload_2 
L115:   monitorexit 
L116:   areturn 
        .catch [0] from L117 to L121 using L117 
L117:   astore 8 
L119:   aload_2 
L120:   monitorexit 
L121:   aload 8 
L123:   athrow 
L124:   
    .end code 
.end method 

.method public [192] : [193] 
    .attribute [185] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifne L28 
L7:     iconst_0 
L8:     istore_3 
L9:     iload_3 
L10:    aload_2 
L11:    arraylength 
L12:    if_icmpge L28 
L15:    aload_0 
L16:    aload_2 
L17:    iload_3 
L18:    aaload 
L19:    invokevirtual [18] 
L22:    iinc 3 1 
L25:    goto L9 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [194] : [195] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokevirtual [19] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [196] : [197] 
    .attribute [185] .code stack 7 locals 6 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifne L148 
L7:     aload_0 
L8:     getfield [11] 
L11:    dup 
L12:    astore_2 
L13:    monitorenter 
        .catch [0] from L14 to L86 using L141 
L14:    aload_1 
L15:    invokeinterface [35] 0 
L20:    astore_3 
L21:    aload_0 
L22:    aload_3 
L23:    invokevirtual [20] 
L26:    istore 4 
L28:    iload 4 
L30:    ldc [5] 
L32:    iand 
L33:    aload_0 
L34:    getfield [11] 
L37:    arraylength 
L38:    irem 
L39:    istore 5 
L41:    aload_0 
L42:    getfield [11] 
L45:    iload 5 
L47:    aaload 
L48:    astore 6 
L50:    aload 6 
L52:    ifnull L97 
L55:    aload 6 
L57:    getfield [21] 
L60:    iload 4 
L62:    if_icmpne L87 
L65:    aload_0 
L66:    aload 6 
L68:    getfield [14] 
L71:    aload_3 
L72:    invokevirtual [22] 
L75:    ifeq L87 
L78:    aload 6 
L80:    aload_1 
L81:    putfield [33] 
L84:    aload_2 
L85:    monitorexit 
L86:    return 
        .catch [0] from L87 to L138 using L141 
L87:    aload 6 
L89:    getfield [17] 
L92:    astore 6 
L94:    goto L50 
L97:    new [30] 
L100:   dup 
L101:   iload 4 
L103:   aload_3 
L104:   aload_1 
L105:   aload_0 
L106:   getfield [11] 
L109:   iload 5 
L111:   aaload 
L112:   invokespecial [27] 
L115:   astore 6 
L117:   aload_0 
L118:   getfield [11] 
L121:   iload 5 
L123:   aload 6 
L125:   aastore 
L126:   aload_0 
L127:   dup 
L128:   getfield [12] 
L131:   iconst_1 
L132:   iadd 
L133:   putfield [29] 
L136:   aload_2 
L137:   monitorexit 
L138:   goto L148 
        .catch [0] from L141 to L145 using L141 
L141:   astore 7 
L143:   aload_2 
L144:   monitorexit 
L145:   aload 7 
L147:   athrow 
L148:   return 
L149:   nop 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [198] : [199] 
    .attribute [185] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L68 using L83 
L7:     aload_0 
L8:     aload_1 
L9:     invokevirtual [20] 
L12:    istore_3 
L13:    iload_3 
L14:    ldc [5] 
L16:    iand 
L17:    aload_0 
L18:    getfield [11] 
L21:    arraylength 
L22:    irem 
L23:    istore 4 
L25:    aload_0 
L26:    getfield [11] 
L29:    iload 4 
L31:    aaload 
L32:    astore 5 
L34:    aload 5 
L36:    ifnull L79 
L39:    aload 5 
L41:    getfield [21] 
L44:    iload_3 
L45:    if_icmpne L69 
L48:    aload_0 
L49:    aload 5 
L51:    getfield [14] 
L54:    aload_1 
L55:    invokevirtual [22] 
L58:    ifeq L69 
L61:    aload 5 
L63:    getfield [16] 
L66:    aload_2 
L67:    monitorexit 
L68:    areturn 
        .catch [0] from L69 to L82 using L83 
L69:    aload 5 
L71:    getfield [17] 
L74:    astore 5 
L76:    goto L34 
L79:    aconst_null 
L80:    aload_2 
L81:    monitorexit 
L82:    areturn 
        .catch [0] from L83 to L87 using L83 
L83:    astore 6 
L85:    aload_2 
L86:    monitorexit 
L87:    aload 6 
L89:    athrow 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [200] : [201] 
    .attribute [185] .code stack 3 locals 7 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L121 using L140 
L7:     aload_0 
L8:     aload_1 
L9:     invokevirtual [20] 
L12:    istore_3 
L13:    iload_3 
L14:    ldc [5] 
L16:    iand 
L17:    aload_0 
L18:    getfield [11] 
L21:    arraylength 
L22:    irem 
L23:    istore 4 
L25:    aload_0 
L26:    getfield [11] 
L29:    iload 4 
L31:    aaload 
L32:    astore 5 
L34:    aconst_null 
L35:    astore 6 
L37:    aload 5 
L39:    ifnull L136 
L42:    aload 5 
L44:    getfield [21] 
L47:    iload_3 
L48:    if_icmpne L122 
L51:    aload_0 
L52:    aload 5 
L54:    getfield [14] 
L57:    aload_1 
L58:    invokevirtual [22] 
L61:    ifeq L122 
L64:    aload 6 
L66:    ifnull L82 
L69:    aload 6 
L71:    aload 5 
L73:    getfield [17] 
L76:    putfield [34] 
L79:    goto L94 
L82:    aload_0 
L83:    getfield [11] 
L86:    iload 4 
L88:    aload 5 
L90:    getfield [17] 
L93:    aastore 
L94:    aload 5 
L96:    getfield [16] 
L99:    astore 7 
L101:   aload 5 
L103:   aconst_null 
L104:   putfield [33] 
L107:   aload_0 
L108:   dup 
L109:   getfield [12] 
L112:   iconst_1 
L113:   isub 
L114:   putfield [29] 
L117:   aload 7 
L119:   aload_2 
L120:   monitorexit 
L121:   areturn 
        .catch [0] from L122 to L139 using L140 
L122:   aload 5 
L124:   astore 6 
L126:   aload 5 
L128:   getfield [17] 
L131:   astore 5 
L133:   goto L37 
L136:   aconst_null 
L137:   aload_2 
L138:   monitorexit 
L139:   areturn 
        .catch [0] from L140 to L144 using L140 
L140:   astore 8 
L142:   aload_2 
L143:   monitorexit 
L144:   aload 8 
L146:   athrow 
L147:   nop 
L148:   
    .end code 
.end method 

.method public [202] : [203] 
    .attribute [185] .code stack 3 locals 5 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L64 using L79 
L7:     aload_0 
L8:     aload_1 
L9:     invokevirtual [20] 
L12:    istore_3 
L13:    iload_3 
L14:    ldc [5] 
L16:    iand 
L17:    aload_0 
L18:    getfield [11] 
L21:    arraylength 
L22:    irem 
L23:    istore 4 
L25:    aload_0 
L26:    getfield [11] 
L29:    iload 4 
L31:    aaload 
L32:    astore 5 
L34:    aload 5 
L36:    ifnull L75 
L39:    aload 5 
L41:    getfield [21] 
L44:    iload_3 
L45:    if_icmpne L65 
L48:    aload_0 
L49:    aload 5 
L51:    getfield [14] 
L54:    aload_1 
L55:    invokevirtual [22] 
L58:    ifeq L65 
L61:    iconst_1 
L62:    aload_2 
L63:    monitorexit 
L64:    areturn 
        .catch [0] from L65 to L78 using L79 
L65:    aload 5 
L67:    getfield [17] 
L70:    astore 5 
L72:    goto L34 
L75:    iconst_0 
L76:    aload_2 
L77:    monitorexit 
L78:    areturn 
        .catch [0] from L79 to L83 using L79 
L79:    astore 6 
L81:    aload_2 
L82:    monitorexit 
L83:    aload 6 
L85:    athrow 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [204] : [205] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [206] : [207] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [31] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [185] .code stack 3 locals 3 
L0:     aload_0 
L1:     getfield [11] 
L4:     dup 
L5:     astore_1 
L6:     monitorenter 
        .catch [0] from L7 to L56 using L59 
L7:     iconst_0 
L8:     istore_2 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [11] 
L14:    arraylength 
L15:    if_icmpge L49 
L18:    aload_0 
L19:    getfield [11] 
L22:    iload_2 
L23:    aaload 
L24:    ifnull L43 
L27:    aload_0 
L28:    getfield [11] 
L31:    iload_2 
L32:    aaload 
L33:    invokevirtual [23] 
L36:    aload_0 
L37:    getfield [11] 
L40:    iload_2 
L41:    aconst_null 
L42:    aastore 
L43:    iinc 2 1 
L46:    goto L9 
L49:    aload_0 
L50:    iconst_0 
L51:    putfield [29] 
L54:    aload_1 
L55:    monitorexit 
L56:    goto L64 
        .catch [0] from L59 to L62 using L59 
L59:    astore_3 
L60:    aload_1 
L61:    monitorexit 
L62:    aload_3 
L63:    athrow 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [185] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_2 
L2:     invokevirtual [24] 
L5:     areturn 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [185] .code stack 1 locals 0 
L0:     aload_1 
L1:     invokevirtual [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = Class [37] 
.const [4] = Method [38] [39] 
.const [5] = Int -129 
.const [6] = Class [40] 
.const [7] = Class [41] 
.const [8] = Class [42] 
.const [9] = Class [43] 
.const [10] = Class [44] 
.const [11] = Field [45] [46] 
.const [12] = Field [47] [48] 
.const [13] = Field [49] [50] 
.const [14] = Field [51] [52] 
.const [15] = Method [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Method [59] [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Field [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Field [79] [80] 
.const [29] = Field [81] [82] 
.const [30] = Class [83] 
.const [31] = Field [84] [85] 
.const [32] = InterfaceMethod [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = InterfaceMethod [92] [93] 
.const [36] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [37] = Utf8 org/apache/xerces/xni/grammars/Grammar 
.const [38] = Class [94] 
.const [39] = NameAndType [95] [96] 
.const [40] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 org/apache/xerces/xni/grammars/XMLGrammarDescription 
.const [43] = Utf8 java/lang/String 
.const [44] = Utf8 java/lang/System 
.const [45] = Class [97] 
.const [46] = NameAndType [98] [99] 
.const [47] = Class [100] 
.const [48] = NameAndType [101] [102] 
.const [49] = Class [103] 
.const [50] = NameAndType [104] [105] 
.const [51] = Class [106] 
.const [52] = NameAndType [107] [108] 
.const [53] = Class [109] 
.const [54] = NameAndType [110] [111] 
.const [55] = Class [112] 
.const [56] = NameAndType [113] [114] 
.const [57] = Class [115] 
.const [58] = NameAndType [116] [117] 
.const [59] = Class [118] 
.const [60] = NameAndType [119] [120] 
.const [61] = Class [121] 
.const [62] = NameAndType [122] [123] 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Class [127] 
.const [66] = NameAndType [128] [129] 
.const [67] = Class [130] 
.const [68] = NameAndType [131] [132] 
.const [69] = Class [133] 
.const [70] = NameAndType [134] [135] 
.const [71] = Class [136] 
.const [72] = NameAndType [137] [138] 
.const [73] = Class [139] 
.const [74] = NameAndType [140] [141] 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [84] = Class [154] 
.const [85] = NameAndType [155] [156] 
.const [86] = Class [157] 
.const [87] = NameAndType [158] [159] 
.const [88] = Class [160] 
.const [89] = NameAndType [161] [162] 
.const [90] = Class [163] 
.const [91] = NameAndType [164] [165] 
.const [92] = Class [166] 
.const [93] = NameAndType [167] [168] 
.const [94] = Utf8 java/lang/System 
.const [95] = Utf8 arraycopy 
.const [96] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [97] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [98] = Utf8 fGrammars 
.const [99] = Utf8 [Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry; 
.const [100] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [101] = Utf8 fGrammarCount 
.const [102] = Utf8 I 
.const [103] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [104] = Utf8 fPoolIsLocked 
.const [105] = Utf8 Z 
.const [106] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [107] = Utf8 desc 
.const [108] = Utf8 Lorg/apache/xerces/xni/grammars/XMLGrammarDescription; 
.const [109] = Utf8 java/lang/String 
.const [110] = Utf8 equals 
.const [111] = Utf8 (Ljava/lang/Object;)Z 
.const [112] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [113] = Utf8 grammar 
.const [114] = Utf8 Lorg/apache/xerces/xni/grammars/Grammar; 
.const [115] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [116] = Utf8 next 
.const [117] = Utf8 Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry; 
.const [118] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [119] = Utf8 putGrammar 
.const [120] = Utf8 (Lorg/apache/xerces/xni/grammars/Grammar;)V 
.const [121] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [122] = Utf8 getGrammar 
.const [123] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Lorg/apache/xerces/xni/grammars/Grammar; 
.const [124] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [125] = Utf8 hashCode 
.const [126] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)I 
.const [127] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [128] = Utf8 hash 
.const [129] = Utf8 I 
.const [130] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [131] = Utf8 equals 
.const [132] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Z 
.const [133] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [134] = Utf8 clear 
.const [135] = Utf8 ()V 
.const [136] = Utf8 java/lang/Object 
.const [137] = Utf8 equals 
.const [138] = Utf8 (Ljava/lang/Object;)Z 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 hashCode 
.const [141] = Utf8 ()I 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 <init> 
.const [144] = Utf8 ()V 
.const [145] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (ILorg/apache/xerces/xni/grammars/XMLGrammarDescription;Lorg/apache/xerces/xni/grammars/Grammar;Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry;)V 
.const [148] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [149] = Utf8 fGrammars 
.const [150] = Utf8 [Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry; 
.const [151] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [152] = Utf8 fGrammarCount 
.const [153] = Utf8 I 
.const [154] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [155] = Utf8 fPoolIsLocked 
.const [156] = Utf8 Z 
.const [157] = Utf8 org/apache/xerces/xni/grammars/XMLGrammarDescription 
.const [158] = Utf8 getGrammarType 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [161] = Utf8 grammar 
.const [162] = Utf8 Lorg/apache/xerces/xni/grammars/Grammar; 
.const [163] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl$Entry 
.const [164] = Utf8 next 
.const [165] = Utf8 Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry; 
.const [166] = Utf8 org/apache/xerces/xni/grammars/Grammar 
.const [167] = Utf8 getGrammarDescription 
.const [168] = Utf8 ()Lorg/apache/xerces/xni/grammars/XMLGrammarDescription; 
.const [169] = Utf8 org/apache/xerces/util/XMLGrammarPoolImpl 
.const [170] = Class [169] 
.const [171] = Utf8 java/lang/Object 
.const [172] = Class [171] 
.const [173] = Utf8 org/apache/xerces/xni/grammars/XMLGrammarPool 
.const [174] = Class [173] 
.const [175] = Utf8 TABLE_SIZE 
.const [176] = Utf8 I 
.const [177] = Utf8 fGrammars 
.const [178] = Utf8 [Lorg/apache/xerces/util/XMLGrammarPoolImpl$Entry; 
.const [179] = Utf8 fPoolIsLocked 
.const [180] = Utf8 Z 
.const [181] = Utf8 fGrammarCount 
.const [182] = Utf8 I 
.const [183] = Utf8 DEBUG 
.const [184] = Utf8 Z 
.const [185] = Utf8 Code 
.const [186] = Utf8 <init> 
.const [187] = Utf8 ()V 
.const [188] = Utf8 <init> 
.const [189] = Utf8 (I)V 
.const [190] = Utf8 retrieveInitialGrammarSet 
.const [191] = Utf8 (Ljava/lang/String;)[Lorg/apache/xerces/xni/grammars/Grammar; 
.const [192] = Utf8 cacheGrammars 
.const [193] = Utf8 (Ljava/lang/String;[Lorg/apache/xerces/xni/grammars/Grammar;)V 
.const [194] = Utf8 retrieveGrammar 
.const [195] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Lorg/apache/xerces/xni/grammars/Grammar; 
.const [196] = Utf8 putGrammar 
.const [197] = Utf8 (Lorg/apache/xerces/xni/grammars/Grammar;)V 
.const [198] = Utf8 getGrammar 
.const [199] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Lorg/apache/xerces/xni/grammars/Grammar; 
.const [200] = Utf8 removeGrammar 
.const [201] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Lorg/apache/xerces/xni/grammars/Grammar; 
.const [202] = Utf8 containsGrammar 
.const [203] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Z 
.const [204] = Utf8 lockPool 
.const [205] = Utf8 ()V 
.const [206] = Utf8 unlockPool 
.const [207] = Utf8 ()V 
.const [208] = Utf8 clear 
.const [209] = Utf8 ()V 
.const [210] = Utf8 equals 
.const [211] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)Z 
.const [212] = Utf8 hashCode 
.const [213] = Utf8 (Lorg/apache/xerces/xni/grammars/XMLGrammarDescription;)I 
.end class 
