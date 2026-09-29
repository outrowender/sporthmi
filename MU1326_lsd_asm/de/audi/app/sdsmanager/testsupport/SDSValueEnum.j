.version 50 0 
.class public super [229] 
.super [231] 
.field public static final [232] [233] 
.field public static final [234] [235] 
.field private static [236] [237] 
.field private static [238] [239] 
.field private static [240] [241] 
.field private static [242] [243] 
.field private static [244] [245] 

.method private [247] : [248] 
    .attribute [246] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     getstatic [2] 
L7:     ifnonnull L20 
L10:    new [50] 
L13:    dup 
L14:    invokespecial [40] 
L17:    putstatic [39] 
L20:    getstatic [2] 
L23:    aload_1 
L24:    aload 4 
L26:    invokeinterface [51] 0 
L31:    pop 
L32:    getstatic [4] 
L35:    ifnonnull L48 
L38:    new [50] 
L41:    dup 
L42:    invokespecial [40] 
L45:    putstatic [41] 
L48:    getstatic [4] 
L51:    aload_1 
L52:    aload_2 
L53:    invokeinterface [51] 0 
L58:    pop 
L59:    getstatic [5] 
L62:    ifnonnull L75 
L65:    new [50] 
L68:    dup 
L69:    invokespecial [40] 
L72:    putstatic [42] 
L75:    getstatic [5] 
L78:    aload_1 
L79:    aload_3 
L80:    invokeinterface [51] 0 
L85:    pop 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public static synchronized [249] : [250] 
    .attribute [246] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     aload_0 
L4:     invokeinterface [52] 0 
L9:     checkcast [6] 
L12:    checkcast [6] 
L15:    iload_1 
L16:    aaload 
L17:    invokestatic [7] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static synchronized [251] : [252] 
    .attribute [246] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     aload_0 
L4:     invokeinterface [52] 0 
L9:     checkcast [6] 
L12:    checkcast [6] 
L15:    arraylength 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static synchronized [253] : [254] 
    .attribute [246] .code stack 6 locals 4 
L0:     getstatic [4] 
L3:     aload_0 
L4:     invokeinterface [52] 0 
L9:     checkcast [8] 
L12:    astore 4 
L14:    getstatic [5] 
L17:    aload_0 
L18:    invokeinterface [52] 0 
L23:    checkcast [8] 
L26:    astore 5 
L28:    aload 4 
L30:    ifnull L38 
L33:    aload 5 
L35:    ifnonnull L40 
L38:    fload_2 
L39:    areturn 
        .catch [11] from L40 to L78 using L81 
L40:    getstatic [2] 
L43:    aload_0 
L44:    invokeinterface [52] 0 
L49:    checkcast [6] 
L52:    checkcast [6] 
L55:    iload_1 
L56:    aaload 
L57:    invokestatic [7] 
L60:    fstore 7 
L62:    fload_2 
L63:    fload 7 
L65:    fadd 
L66:    ldc [9] 
L68:    fmul 
L69:    invokestatic [10] 
L72:    i2f 
L73:    ldc [9] 
L75:    fdiv 
L76:    fstore 6 
L78:    goto L99 
L81:    astore 7 
L83:    invokestatic [12] 
L86:    ldc [13] 
L88:    ldc [14] 
L90:    aload_0 
L91:    iload_1 
L92:    i2l 
L93:    invokevirtual [31] 
L96:    pop 
L97:    fload_2 
L98:    areturn 
L99:    fload 6 
L101:   aload 4 
L103:   invokevirtual [32] 
L106:   fcmpg 
L107:   ifgt L120 
L110:   aload 4 
L112:   invokevirtual [32] 
L115:   fstore 6 
L117:   goto L138 
L120:   fload 6 
L122:   aload 5 
L124:   invokevirtual [32] 
L127:   fcmpl 
L128:   iflt L138 
L131:   aload 5 
L133:   invokevirtual [32] 
L136:   fstore 6 
L138:   fload 6 
L140:   aload_0 
L141:   aload_3 
L142:   invokestatic [15] 
L145:   fload 6 
L147:   areturn 
L148:   
    .end code 
.end method 

.method private static [255] : [256] 
    .attribute [246] .code stack 2 locals 0 
L0:     getstatic [16] 
L3:     aload_1 
L4:     invokevirtual [33] 
L7:     ifeq L18 
L10:    aload_2 
L11:    fload_0 
L12:    invokevirtual [34] 
L15:    goto L33 
L18:    getstatic [17] 
L21:    aload_1 
L22:    invokevirtual [33] 
L25:    ifeq L33 
L28:    aload_2 
L29:    fload_0 
L30:    invokevirtual [35] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public static synchronized [257] : [258] 
    .attribute [246] .code stack 2 locals 0 
L0:     getstatic [16] 
L3:     aload_0 
L4:     invokevirtual [33] 
L7:     ifeq L15 
L10:    aload_1 
L11:    invokevirtual [36] 
L14:    areturn 
L15:    getstatic [17] 
L18:    aload_0 
L19:    invokevirtual [33] 
L22:    ifeq L30 
L25:    aload_1 
L26:    invokevirtual [37] 
L29:    areturn 
L30:    fconst_0 
L31:    areturn 
L32:    
    .end code 
.end method 

.method static [259] : [260] 
    .attribute [246] .code stack 9 locals 0 
L0:     new [54] 
L3:     dup 
L4:     iconst_0 
L5:     invokespecial [45] 
L8:     putstatic [43] 
L11:    new [54] 
L14:    dup 
L15:    iconst_1 
L16:    invokespecial [45] 
L19:    putstatic [44] 
L22:    new [55] 
L25:    dup 
L26:    getstatic [16] 
L29:    new [53] 
L32:    dup 
L33:    fconst_0 
L34:    invokespecial [46] 
L37:    new [53] 
L40:    dup 
L41:    fconst_1 
L42:    invokespecial [46] 
L45:    iconst_4 
L46:    anewarray [20] 
L49:    dup 
L50:    iconst_0 
L51:    ldc [21] 
L53:    aastore 
L54:    dup 
L55:    iconst_1 
L56:    ldc [22] 
L58:    aastore 
L59:    dup 
L60:    iconst_2 
L61:    ldc [23] 
L63:    aastore 
L64:    dup 
L65:    iconst_3 
L66:    ldc [24] 
L68:    aastore 
L69:    invokespecial [47] 
L72:    putstatic [48] 
L75:    new [55] 
L78:    dup 
L79:    getstatic [17] 
L82:    new [53] 
L85:    dup 
L86:    fconst_0 
L87:    invokespecial [46] 
L90:    new [53] 
L93:    dup 
L94:    fconst_1 
L95:    invokespecial [46] 
L98:    iconst_4 
L99:    anewarray [20] 
L102:   dup 
L103:   iconst_0 
L104:   ldc [21] 
L106:   aastore 
L107:   dup 
L108:   iconst_1 
L109:   ldc [22] 
L111:   aastore 
L112:   dup 
L113:   iconst_2 
L114:   ldc [23] 
L116:   aastore 
L117:   dup 
L118:   iconst_3 
L119:   ldc [24] 
L121:   aastore 
L122:   invokespecial [47] 
L125:   putstatic [49] 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [56] [57] 
.const [3] = Class [58] 
.const [4] = Field [59] [60] 
.const [5] = Field [61] [62] 
.const [6] = Class [63] 
.const [7] = Method [64] [65] 
.const [8] = Class [66] 
.const [9] = Int 31300 
.const [10] = Method [67] [68] 
.const [11] = Class [69] 
.const [12] = Method [70] [71] 
.const [13] = Int -1601830656 
.const [14] = String [72] 
.const [15] = Method [73] [74] 
.const [16] = Field [75] [76] 
.const [17] = Field [77] [78] 
.const [18] = Class [79] 
.const [19] = Class [80] 
.const [20] = Class [81] 
.const [21] = String [82] 
.const [22] = String [83] 
.const [23] = String [84] 
.const [24] = String [85] 
.const [25] = Class [86] 
.const [26] = Class [87] 
.const [27] = Class [88] 
.const [28] = Class [89] 
.const [29] = Class [90] 
.const [30] = Class [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Method [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Field [108] [109] 
.const [40] = Method [110] [111] 
.const [41] = Field [112] [113] 
.const [42] = Field [114] [115] 
.const [43] = Field [116] [117] 
.const [44] = Field [118] [119] 
.const [45] = Method [120] [121] 
.const [46] = Method [122] [123] 
.const [47] = Method [124] [125] 
.const [48] = Field [126] [127] 
.const [49] = Field [128] [129] 
.const [50] = Class [130] 
.const [51] = InterfaceMethod [131] [132] 
.const [52] = InterfaceMethod [133] [134] 
.const [53] = Class [135] 
.const [54] = Class [136] 
.const [55] = Class [137] 
.const [56] = Class [138] 
.const [57] = NameAndType [139] [140] 
.const [58] = Utf8 java/util/HashMap 
.const [59] = Class [141] 
.const [60] = NameAndType [142] [143] 
.const [61] = Class [144] 
.const [62] = NameAndType [145] [146] 
.const [63] = Utf8 [Ljava/lang/String; 
.const [64] = Class [147] 
.const [65] = NameAndType [148] [149] 
.const [66] = Utf8 java/lang/Float 
.const [67] = Class [150] 
.const [68] = NameAndType [151] [152] 
.const [69] = Utf8 java/lang/NumberFormatException 
.const [70] = Class [153] 
.const [71] = NameAndType [154] [155] 
.const [72] = Utf8 'SDSValueEnum#addValue: NumberFormatException: valueType %1, entryID %2' 
.const [73] = Class [156] 
.const [74] = NameAndType [157] [158] 
.const [75] = Class [159] 
.const [76] = NameAndType [160] [161] 
.const [77] = Class [162] 
.const [78] = NameAndType [163] [164] 
.const [79] = Utf8 java/lang/Integer 
.const [80] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [81] = Utf8 java/lang/String 
.const [82] = Utf8 '0.01' 
.const [83] = Utf8 '0.001' 
.const [84] = Utf8 '-0.01' 
.const [85] = Utf8 '-0.001' 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 java/util/Map 
.const [88] = Utf8 java/lang/Math 
.const [89] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Class [192] 
.const [111] = NameAndType [193] [194] 
.const [112] = Class [195] 
.const [113] = NameAndType [196] [197] 
.const [114] = Class [198] 
.const [115] = NameAndType [199] [200] 
.const [116] = Class [201] 
.const [117] = NameAndType [202] [203] 
.const [118] = Class [204] 
.const [119] = NameAndType [205] [206] 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Class [210] 
.const [123] = NameAndType [211] [212] 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Class [216] 
.const [127] = NameAndType [217] [218] 
.const [128] = Class [219] 
.const [129] = NameAndType [220] [221] 
.const [130] = Utf8 java/util/HashMap 
.const [131] = Class [222] 
.const [132] = NameAndType [223] [224] 
.const [133] = Class [225] 
.const [134] = NameAndType [226] [227] 
.const [135] = Utf8 java/lang/Float 
.const [136] = Utf8 java/lang/Integer 
.const [137] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [138] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [139] = Utf8 addValuesMap 
.const [140] = Utf8 Ljava/util/Map; 
.const [141] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [142] = Utf8 minimalMap 
.const [143] = Utf8 Ljava/util/Map; 
.const [144] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [145] = Utf8 maximalMap 
.const [146] = Utf8 Ljava/util/Map; 
.const [147] = Utf8 java/lang/Float 
.const [148] = Utf8 parseFloat 
.const [149] = Utf8 (Ljava/lang/String;)F 
.const [150] = Utf8 java/lang/Math 
.const [151] = Utf8 round 
.const [152] = Utf8 (F)I 
.const [153] = Utf8 de/audi/app/sdsmanager/common/Logger 
.const [154] = Utf8 getMainLog 
.const [155] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [157] = Utf8 setPersistValue 
.const [158] = Utf8 (FLjava/lang/Integer;Lde/audi/app/sdsmanager/apps/SDSAdapter;)V 
.const [159] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [160] = Utf8 TOP_ENTRY_GAP 
.const [161] = Utf8 Ljava/lang/Integer; 
.const [162] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [163] = Utf8 FOLLOWUP_ENTRY_GAP 
.const [164] = Utf8 Ljava/lang/Integer; 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [168] = Utf8 java/lang/Float 
.const [169] = Utf8 floatValue 
.const [170] = Utf8 ()F 
.const [171] = Utf8 java/lang/Integer 
.const [172] = Utf8 equals 
.const [173] = Utf8 (Ljava/lang/Object;)Z 
.const [174] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [175] = Utf8 changeTopEntryThreshold 
.const [176] = Utf8 (F)V 
.const [177] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [178] = Utf8 changeFollowupEntryThreshold 
.const [179] = Utf8 (F)V 
.const [180] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [181] = Utf8 getTopEntryThreshold 
.const [182] = Utf8 ()F 
.const [183] = Utf8 de/audi/app/sdsmanager/apps/SDSAdapter 
.const [184] = Utf8 getFollowupEntryThreshold 
.const [185] = Utf8 ()F 
.const [186] = Utf8 java/lang/Object 
.const [187] = Utf8 <init> 
.const [188] = Utf8 ()V 
.const [189] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [190] = Utf8 addValuesMap 
.const [191] = Utf8 Ljava/util/Map; 
.const [192] = Utf8 java/util/HashMap 
.const [193] = Utf8 <init> 
.const [194] = Utf8 ()V 
.const [195] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [196] = Utf8 minimalMap 
.const [197] = Utf8 Ljava/util/Map; 
.const [198] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [199] = Utf8 maximalMap 
.const [200] = Utf8 Ljava/util/Map; 
.const [201] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [202] = Utf8 TOP_ENTRY_GAP 
.const [203] = Utf8 Ljava/lang/Integer; 
.const [204] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [205] = Utf8 FOLLOWUP_ENTRY_GAP 
.const [206] = Utf8 Ljava/lang/Integer; 
.const [207] = Utf8 java/lang/Integer 
.const [208] = Utf8 <init> 
.const [209] = Utf8 (I)V 
.const [210] = Utf8 java/lang/Float 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (F)V 
.const [213] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;[Ljava/lang/String;)V 
.const [216] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [217] = Utf8 topGapEnum 
.const [218] = Utf8 Lde/audi/app/sdsmanager/testsupport/SDSValueEnum; 
.const [219] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [220] = Utf8 followupGapEnum 
.const [221] = Utf8 Lde/audi/app/sdsmanager/testsupport/SDSValueEnum; 
.const [222] = Utf8 java/util/Map 
.const [223] = Utf8 put 
.const [224] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [225] = Utf8 java/util/Map 
.const [226] = Utf8 get 
.const [227] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [228] = Utf8 de/audi/app/sdsmanager/testsupport/SDSValueEnum 
.const [229] = Class [228] 
.const [230] = Utf8 java/lang/Object 
.const [231] = Class [230] 
.const [232] = Utf8 TOP_ENTRY_GAP 
.const [233] = Utf8 Ljava/lang/Integer; 
.const [234] = Utf8 FOLLOWUP_ENTRY_GAP 
.const [235] = Utf8 Ljava/lang/Integer; 
.const [236] = Utf8 topGapEnum 
.const [237] = Utf8 Lde/audi/app/sdsmanager/testsupport/SDSValueEnum; 
.const [238] = Utf8 followupGapEnum 
.const [239] = Utf8 Lde/audi/app/sdsmanager/testsupport/SDSValueEnum; 
.const [240] = Utf8 addValuesMap 
.const [241] = Utf8 Ljava/util/Map; 
.const [242] = Utf8 minimalMap 
.const [243] = Utf8 Ljava/util/Map; 
.const [244] = Utf8 maximalMap 
.const [245] = Utf8 Ljava/util/Map; 
.const [246] = Utf8 Code 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;[Ljava/lang/String;)V 
.const [249] = Utf8 getAdditionValue 
.const [250] = Utf8 (Ljava/lang/Integer;I)F 
.const [251] = Utf8 getAdditionValueLength 
.const [252] = Utf8 (Ljava/lang/Integer;)I 
.const [253] = Utf8 addValue 
.const [254] = Utf8 (Ljava/lang/Integer;IFLde/audi/app/sdsmanager/apps/SDSAdapter;)F 
.const [255] = Utf8 setPersistValue 
.const [256] = Utf8 (FLjava/lang/Integer;Lde/audi/app/sdsmanager/apps/SDSAdapter;)V 
.const [257] = Utf8 getPersistValue 
.const [258] = Utf8 (Ljava/lang/Integer;Lde/audi/app/sdsmanager/apps/SDSAdapter;)F 
.const [259] = Utf8 <clinit> 
.const [260] = Utf8 ()V 
.end class 
