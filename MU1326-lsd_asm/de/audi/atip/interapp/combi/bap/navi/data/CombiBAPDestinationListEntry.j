.version 50 0 
.class public final super [237] 
.super [239] 
.implements [241] 
.field private [242] [243] 
.field private [244] [245] 
.field private [246] [247] 
.field private final [248] [249] 
.field private [250] [251] 

.method public [253] : [254] 
    .attribute [252] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     ldc [2] 
L5:     aload_2 
L6:     invokespecial [43] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [252] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     ldc [2] 
L5:     aload_3 
L6:     invokespecial [43] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [252] .code stack 6 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     aload_3 
L4:     aload 4 
L6:     aconst_null 
L7:     invokespecial [44] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [45] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [47] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [48] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [49] 
L19:    aload_0 
L20:    aload 4 
L22:    putfield [50] 
L25:    aload_0 
L26:    aload 5 
L28:    putfield [51] 
L31:    return 
L32:    
    .end code 
.end method 

.method public interface [261] : [262] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [263] : [264] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [252] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [24] 
L4:     ifnull L22 
L7:     aload_0 
L8:     getfield [24] 
L11:    invokevirtual [27] 
L14:    ifle L22 
L17:    aload_0 
L18:    getfield [24] 
L21:    areturn 
L22:    aload_0 
L23:    getfield [25] 
L26:    ifnull L148 
L29:    aload_0 
L30:    getfield [25] 
L33:    arraylength 
L34:    ifle L148 
L37:    new [52] 
L40:    dup 
L41:    invokespecial [46] 
L44:    astore_1 
L45:    aload_1 
L46:    aload_0 
L47:    getfield [25] 
L50:    iconst_0 
L51:    aaload 
L52:    invokevirtual [28] 
L55:    invokestatic [4] 
L58:    aload_1 
L59:    aload_0 
L60:    getfield [25] 
L63:    iconst_0 
L64:    aaload 
L65:    invokevirtual [29] 
L68:    invokestatic [4] 
L71:    aload_1 
L72:    invokevirtual [30] 
L75:    ifne L143 
L78:    aload_1 
L79:    aload_0 
L80:    getfield [25] 
L83:    iconst_0 
L84:    aaload 
L85:    invokevirtual [31] 
L88:    invokestatic [4] 
L91:    aload_1 
L92:    aload_0 
L93:    getfield [25] 
L96:    iconst_0 
L97:    aaload 
L98:    invokevirtual [32] 
L101:   invokestatic [4] 
L104:   aload_1 
L105:   aload_0 
L106:   getfield [25] 
L109:   iconst_0 
L110:   aaload 
L111:   invokevirtual [33] 
L114:   invokestatic [4] 
L117:   aload_1 
L118:   aload_0 
L119:   getfield [25] 
L122:   iconst_0 
L123:   aaload 
L124:   invokevirtual [34] 
L127:   invokestatic [4] 
L130:   aload_1 
L131:   aload_0 
L132:   getfield [25] 
L135:   iconst_0 
L136:   aaload 
L137:   invokevirtual [35] 
L140:   invokestatic [4] 
L143:   aload_1 
L144:   invokevirtual [36] 
L147:   areturn 
L148:   ldc [5] 
L150:   areturn 
L151:   nop 
L152:   
    .end code 
.end method 

.method private static [267] : [268] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnull L31 
L4:     aload_1 
L5:     invokevirtual [27] 
L8:     ifle L31 
L11:    aload_0 
L12:    invokevirtual [30] 
L15:    ifle L25 
L18:    aload_0 
L19:    ldc [6] 
L21:    invokevirtual [37] 
L24:    pop 
L25:    aload_0 
L26:    aload_1 
L27:    invokevirtual [37] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 

.method public interface [269] : [270] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [252] .code stack 3 locals 2 
L0:     new [52] 
L3:     dup 
L4:     invokespecial [46] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [7] 
L11:    invokevirtual [37] 
L14:    pop 
L15:    aload_1 
L16:    aload_0 
L17:    getfield [22] 
L20:    invokevirtual [38] 
L23:    pop 
L24:    aload_1 
L25:    ldc [8] 
L27:    invokevirtual [37] 
L30:    pop 
L31:    aload_1 
L32:    aload_0 
L33:    getfield [22] 
L36:    invokestatic [9] 
L39:    invokevirtual [37] 
L42:    pop 
L43:    aload_1 
L44:    ldc [10] 
L46:    invokevirtual [37] 
L49:    pop 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [23] 
L55:    invokevirtual [38] 
L58:    pop 
L59:    aload_1 
L60:    ldc [11] 
L62:    invokevirtual [37] 
L65:    pop 
L66:    aload_1 
L67:    aload_0 
L68:    invokevirtual [39] 
L71:    invokevirtual [37] 
L74:    pop 
L75:    aload_1 
L76:    ldc [12] 
L78:    invokevirtual [37] 
L81:    pop 
L82:    aload_0 
L83:    getfield [25] 
L86:    ifnull L130 
L89:    iconst_0 
L90:    istore_2 
L91:    iload_2 
L92:    aload_0 
L93:    getfield [25] 
L96:    arraylength 
L97:    if_icmpge L127 
L100:   aload_1 
L101:   ldc [13] 
L103:   invokevirtual [37] 
L106:   pop 
L107:   aload_1 
L108:   aload_0 
L109:   getfield [25] 
L112:   iload_2 
L113:   aaload 
L114:   invokevirtual [40] 
L117:   invokevirtual [37] 
L120:   pop 
L121:   iinc 2 1 
L124:   goto L91 
L127:   goto L137 
L130:   aload_1 
L131:   ldc [14] 
L133:   invokevirtual [37] 
L136:   pop 
L137:   aload_1 
L138:   ldc [15] 
L140:   invokevirtual [37] 
L143:   pop 
L144:   aload_1 
L145:   invokevirtual [36] 
L148:   areturn 
L149:   nop 
L150:   nop 
L151:   nop 
L152:   
    .end code 
.end method 

.method public [273] : [274] 
    .attribute [252] .code stack 2 locals 1 
L0:     aload_1 
L1:     aload_0 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     instanceof [16] 
L11:    ifeq L61 
L14:    aload_1 
L15:    checkcast [16] 
L18:    astore_2 
L19:    aload_0 
L20:    getfield [22] 
L23:    aload_2 
L24:    getfield [22] 
L27:    if_icmpne L59 
L30:    aload_0 
L31:    getfield [23] 
L34:    aload_2 
L35:    getfield [23] 
L38:    if_icmpne L59 
L41:    aload_0 
L42:    invokevirtual [39] 
L45:    aload_2 
L46:    invokevirtual [39] 
L49:    invokevirtual [41] 
L52:    ifeq L59 
L55:    iconst_1 
L56:    goto L60 
L59:    iconst_0 
L60:    areturn 
L61:    iconst_0 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [252] .code stack 4 locals 2 
L0:     iconst_0 
L1:     istore_2 
L2:     aload_0 
L3:     aload_1 
L4:     invokevirtual [42] 
L7:     ifeq L15 
L10:    iconst_m1 
L11:    istore_2 
L12:    goto L82 
L15:    aload_1 
L16:    instanceof [16] 
L19:    ifeq L82 
L22:    aload_1 
L23:    checkcast [16] 
L26:    astore_3 
L27:    aload_0 
L28:    getfield [22] 
L31:    aload_3 
L32:    getfield [22] 
L35:    if_icmpeq L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    aload_0 
L44:    getfield [23] 
L47:    aload_3 
L48:    getfield [23] 
L51:    if_icmpeq L58 
L54:    iconst_1 
L55:    goto L59 
L58:    iconst_0 
L59:    aload_0 
L60:    invokevirtual [39] 
L63:    aload_3 
L64:    invokevirtual [39] 
L67:    invokevirtual [41] 
L70:    ifne L77 
L73:    iconst_1 
L74:    goto L78 
L77:    iconst_0 
L78:    invokestatic [17] 
L81:    istore_2 
L82:    iload_2 
L83:    areturn 
L84:    
    .end code 
.end method 

.method public static [277] : [278] 
    .attribute [252] .code stack 2 locals 2 
L0:     iconst_0 
L1:     istore 4 
L3:     iload_0 
L4:     ifeq L10 
L7:     iinc 4 1 
L10:    iload_1 
L11:    ifeq L17 
L14:    iinc 4 1 
L17:    iload_2 
L18:    ifeq L24 
L21:    iinc 4 1 
L24:    iload 4 
L26:    ifne L34 
L29:    iconst_m1 
L30:    istore_3 
L31:    goto L82 
L34:    iload 4 
L36:    iconst_1 
L37:    if_icmpne L50 
L40:    iload_0 
L41:    ifeq L50 
L44:    bipush 15 
L46:    istore_3 
L47:    goto L82 
L50:    iload 4 
L52:    iconst_1 
L53:    if_icmpne L65 
L56:    iload_2 
L57:    ifeq L65 
L60:    iconst_1 
L61:    istore_3 
L62:    goto L82 
L65:    iload 4 
L67:    iconst_1 
L68:    if_icmpne L80 
L71:    iload_1 
L72:    ifeq L80 
L75:    iconst_2 
L76:    istore_3 
L77:    goto L82 
L80:    iconst_0 
L81:    istore_3 
L82:    iload_3 
L83:    areturn 
L84:    
    .end code 
.end method 

.method public interface [279] : [280] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ifnull L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [53] 
.const [3] = Class [54] 
.const [4] = Method [55] [56] 
.const [5] = String [57] 
.const [6] = String [58] 
.const [7] = String [59] 
.const [8] = String [60] 
.const [9] = Method [61] [62] 
.const [10] = String [63] 
.const [11] = String [64] 
.const [12] = String [65] 
.const [13] = String [66] 
.const [14] = String [67] 
.const [15] = String [68] 
.const [16] = Class [69] 
.const [17] = Method [70] [71] 
.const [18] = Class [72] 
.const [19] = Class [73] 
.const [20] = Class [74] 
.const [21] = Class [75] 
.const [22] = Field [76] [77] 
.const [23] = Field [78] [79] 
.const [24] = Field [80] [81] 
.const [25] = Field [82] [83] 
.const [26] = Field [84] [85] 
.const [27] = Method [86] [87] 
.const [28] = Method [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Method [92] [93] 
.const [31] = Method [94] [95] 
.const [32] = Method [96] [97] 
.const [33] = Method [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Method [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Method [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Field [126] [127] 
.const [48] = Field [128] [129] 
.const [49] = Field [130] [131] 
.const [50] = Field [132] [133] 
.const [51] = Field [134] [135] 
.const [52] = Class [136] 
.const [53] = Utf8 '' 
.const [54] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [55] = Class [137] 
.const [56] = NameAndType [138] [139] 
.const [57] = Utf8 '[description not available]' 
.const [58] = Utf8 ', ' 
.const [59] = Utf8 'CombiBAPDestinationListEntry {posID=' 
.const [60] = Utf8 ' (0x' 
.const [61] = Class [140] 
.const [62] = NameAndType [141] [142] 
.const [63] = Utf8 '), poiType=' 
.const [64] = Utf8 ', description=' 
.const [65] = Utf8 ', addressList=' 
.const [66] = Utf8 '\n' 
.const [67] = Utf8 null 
.const [68] = Utf8 '}' 
.const [69] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [70] = Class [143] 
.const [71] = NameAndType [144] [145] 
.const [72] = Utf8 java/lang/Object 
.const [73] = Utf8 java/lang/String 
.const [74] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [75] = Utf8 java/lang/Integer 
.const [76] = Class [146] 
.const [77] = NameAndType [147] [148] 
.const [78] = Class [149] 
.const [79] = NameAndType [150] [151] 
.const [80] = Class [152] 
.const [81] = NameAndType [153] [154] 
.const [82] = Class [155] 
.const [83] = NameAndType [156] [157] 
.const [84] = Class [158] 
.const [85] = NameAndType [159] [160] 
.const [86] = Class [161] 
.const [87] = NameAndType [162] [163] 
.const [88] = Class [164] 
.const [89] = NameAndType [165] [166] 
.const [90] = Class [167] 
.const [91] = NameAndType [168] [169] 
.const [92] = Class [170] 
.const [93] = NameAndType [171] [172] 
.const [94] = Class [173] 
.const [95] = NameAndType [174] [175] 
.const [96] = Class [176] 
.const [97] = NameAndType [177] [178] 
.const [98] = Class [179] 
.const [99] = NameAndType [180] [181] 
.const [100] = Class [182] 
.const [101] = NameAndType [183] [184] 
.const [102] = Class [185] 
.const [103] = NameAndType [186] [187] 
.const [104] = Class [188] 
.const [105] = NameAndType [189] [190] 
.const [106] = Class [191] 
.const [107] = NameAndType [192] [193] 
.const [108] = Class [194] 
.const [109] = NameAndType [195] [196] 
.const [110] = Class [197] 
.const [111] = NameAndType [198] [199] 
.const [112] = Class [200] 
.const [113] = NameAndType [201] [202] 
.const [114] = Class [203] 
.const [115] = NameAndType [204] [205] 
.const [116] = Class [206] 
.const [117] = NameAndType [207] [208] 
.const [118] = Class [209] 
.const [119] = NameAndType [210] [211] 
.const [120] = Class [212] 
.const [121] = NameAndType [213] [214] 
.const [122] = Class [215] 
.const [123] = NameAndType [216] [217] 
.const [124] = Class [218] 
.const [125] = NameAndType [219] [220] 
.const [126] = Class [221] 
.const [127] = NameAndType [222] [223] 
.const [128] = Class [224] 
.const [129] = NameAndType [225] [226] 
.const [130] = Class [227] 
.const [131] = NameAndType [228] [229] 
.const [132] = Class [230] 
.const [133] = NameAndType [231] [232] 
.const [134] = Class [233] 
.const [135] = NameAndType [234] [235] 
.const [136] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [137] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [138] = Utf8 appendToBuffer 
.const [139] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;Ljava/lang/String;)V 
.const [140] = Utf8 java/lang/Integer 
.const [141] = Utf8 toHexString 
.const [142] = Utf8 (I)Ljava/lang/String; 
.const [143] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [144] = Utf8 getRecordAddress 
.const [145] = Utf8 (ZZZ)I 
.const [146] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [147] = Utf8 posID 
.const [148] = Utf8 I 
.const [149] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [150] = Utf8 poiType 
.const [151] = Utf8 I 
.const [152] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [153] = Utf8 description 
.const [154] = Utf8 Ljava/lang/String; 
.const [155] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [156] = Utf8 addressList 
.const [157] = Utf8 [Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination; 
.const [158] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [159] = Utf8 formattedDestination 
.const [160] = Utf8 Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination; 
.const [161] = Utf8 java/lang/String 
.const [162] = Utf8 length 
.const [163] = Utf8 ()I 
.const [164] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [165] = Utf8 getLastName 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [168] = Utf8 getFirstName 
.const [169] = Utf8 ()Ljava/lang/String; 
.const [170] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [171] = Utf8 length 
.const [172] = Utf8 ()I 
.const [173] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [174] = Utf8 getCity 
.const [175] = Utf8 ()Ljava/lang/String; 
.const [176] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [177] = Utf8 getCityPart 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [180] = Utf8 getPostalCode 
.const [181] = Utf8 ()Ljava/lang/String; 
.const [182] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [183] = Utf8 getStreet 
.const [184] = Utf8 ()Ljava/lang/String; 
.const [185] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [186] = Utf8 getHouseNumber 
.const [187] = Utf8 ()Ljava/lang/String; 
.const [188] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [189] = Utf8 toString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [192] = Utf8 append 
.const [193] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [194] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [195] = Utf8 append 
.const [196] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [197] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [198] = Utf8 getDescription 
.const [199] = Utf8 ()Ljava/lang/String; 
.const [200] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination 
.const [201] = Utf8 toString 
.const [202] = Utf8 ()Ljava/lang/String; 
.const [203] = Utf8 java/lang/String 
.const [204] = Utf8 equals 
.const [205] = Utf8 (Ljava/lang/Object;)Z 
.const [206] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [207] = Utf8 hasSameContent 
.const [208] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Z 
.const [209] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [210] = Utf8 <init> 
.const [211] = Utf8 (IILjava/lang/String;[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;)V 
.const [212] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [213] = Utf8 <init> 
.const [214] = Utf8 (IILjava/lang/String;[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination;)V 
.const [215] = Utf8 java/lang/Object 
.const [216] = Utf8 <init> 
.const [217] = Utf8 ()V 
.const [218] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [219] = Utf8 <init> 
.const [220] = Utf8 ()V 
.const [221] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [222] = Utf8 posID 
.const [223] = Utf8 I 
.const [224] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [225] = Utf8 poiType 
.const [226] = Utf8 I 
.const [227] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [228] = Utf8 description 
.const [229] = Utf8 Ljava/lang/String; 
.const [230] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [231] = Utf8 addressList 
.const [232] = Utf8 [Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination; 
.const [233] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [234] = Utf8 formattedDestination 
.const [235] = Utf8 Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination; 
.const [236] = Utf8 de/audi/atip/interapp/combi/bap/navi/data/CombiBAPDestinationListEntry 
.const [237] = Class [236] 
.const [238] = Utf8 java/lang/Object 
.const [239] = Class [238] 
.const [240] = Utf8 de/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement 
.const [241] = Class [240] 
.const [242] = Utf8 posID 
.const [243] = Utf8 I 
.const [244] = Utf8 poiType 
.const [245] = Utf8 I 
.const [246] = Utf8 description 
.const [247] = Utf8 Ljava/lang/String; 
.const [248] = Utf8 formattedDestination 
.const [249] = Utf8 Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination; 
.const [250] = Utf8 addressList 
.const [251] = Utf8 [Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination; 
.const [252] = Utf8 Code 
.const [253] = Utf8 <init> 
.const [254] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;)V 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (II[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;)V 
.const [257] = Utf8 <init> 
.const [258] = Utf8 (IILjava/lang/String;[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;)V 
.const [259] = Utf8 <init> 
.const [260] = Utf8 (IILjava/lang/String;[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination;Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination;)V 
.const [261] = Utf8 getPosID 
.const [262] = Utf8 ()I 
.const [263] = Utf8 getPOIType 
.const [264] = Utf8 ()I 
.const [265] = Utf8 getDescription 
.const [266] = Utf8 ()Ljava/lang/String; 
.const [267] = Utf8 appendToBuffer 
.const [268] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;Ljava/lang/String;)V 
.const [269] = Utf8 getAddressList 
.const [270] = Utf8 ()[Lde/audi/atip/interapp/combi/bap/navi/data/CombiBAPNaviDestination; 
.const [271] = Utf8 toString 
.const [272] = Utf8 ()Ljava/lang/String; 
.const [273] = Utf8 hasSameContent 
.const [274] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)Z 
.const [275] = Utf8 getDiffRecordAddress 
.const [276] = Utf8 (Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)I 
.const [277] = Utf8 getRecordAddress 
.const [278] = Utf8 (ZZZ)I 
.const [279] = Utf8 getFormattedDestination 
.const [280] = Utf8 ()Lde/audi/atip/interapp/combi/bap/navi/data/FormattedDestination; 
.const [281] = Utf8 hasFormattedDestination 
.const [282] = Utf8 ()Z 
.end class 
