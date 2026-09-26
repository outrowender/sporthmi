.version 50 0 
.class public final super [209] 
.super [211] 
.implements [213] 
.field public [214] [215] 
.field private static final [216] [217] 
.field public static final [218] [219] 
.field public static final [220] [221] 
.field public static final [222] [223] 
.field public [224] [225] 
.field private static final [226] [227] 
.field public static final [228] [229] 
.field public static final [230] [231] 
.field public static final [232] [233] 
.field public static final [234] [235] 
.field public static final [236] [237] 
.field public [238] [239] 
.field private static final [240] [241] 
.field public static final [242] [243] 
.field public static final [244] [245] 
.field public static final [246] [247] 
.field public static final [248] [249] 
.field public final [250] [251] 

.method public [253] : [254] 
    .attribute [252] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     new [45] 
L8:     dup 
L9:     invokespecial [40] 
L12:    putfield [46] 
L15:    aload_0 
L16:    invokespecial [41] 
L19:    aload_0 
L20:    invokespecial [42] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [27] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [257] : [258] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [47] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [48] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [49] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [252] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [41] 
L4:     aload_0 
L5:     getfield [26] 
L8:     invokevirtual [31] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [252] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [28] 
L9:     aload_2 
L10:    getfield [28] 
L13:    if_icmpne L56 
L16:    aload_0 
L17:    getfield [29] 
L20:    aload_2 
L21:    getfield [29] 
L24:    if_icmpne L56 
L27:    aload_0 
L28:    getfield [30] 
L31:    aload_2 
L32:    getfield [30] 
L35:    if_icmpne L56 
L38:    aload_0 
L39:    getfield [26] 
L42:    aload_2 
L43:    getfield [26] 
L46:    invokevirtual [32] 
L49:    ifeq L56 
L52:    iconst_1 
L53:    goto L57 
L56:    iconst_0 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private enum [263] : [264] 
    .attribute [252] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [265] : [266] 
    .attribute [252] .code stack 2 locals 1 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [44] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [33] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [33] 
L21:    pop 
L22:    aload_0 
L23:    getfield [28] 
L26:    tableswitch 0 
            L52 
            L62 
            L72 
            default : L82 

L52:    aload_1 
L53:    ldc [7] 
L55:    invokevirtual [33] 
L58:    pop 
L59:    goto L89 
L62:    aload_1 
L63:    ldc [8] 
L65:    invokevirtual [33] 
L68:    pop 
L69:    goto L89 
L72:    aload_1 
L73:    ldc [9] 
L75:    invokevirtual [33] 
L78:    pop 
L79:    goto L89 
L82:    aload_1 
L83:    ldc [10] 
L85:    invokevirtual [33] 
L88:    pop 
L89:    aload_1 
L90:    ldc [11] 
L92:    invokevirtual [33] 
L95:    pop 
L96:    aload_0 
L97:    getfield [29] 
L100:   tableswitch 0 
            L136 
            L146 
            L156 
            L166 
            L176 
            default : L186 

L136:   aload_1 
L137:   ldc [12] 
L139:   invokevirtual [33] 
L142:   pop 
L143:   goto L193 
L146:   aload_1 
L147:   ldc [13] 
L149:   invokevirtual [33] 
L152:   pop 
L153:   goto L193 
L156:   aload_1 
L157:   ldc [14] 
L159:   invokevirtual [33] 
L162:   pop 
L163:   goto L193 
L166:   aload_1 
L167:   ldc [15] 
L169:   invokevirtual [33] 
L172:   pop 
L173:   goto L193 
L176:   aload_1 
L177:   ldc [16] 
L179:   invokevirtual [33] 
L182:   pop 
L183:   goto L193 
L186:   aload_1 
L187:   ldc [10] 
L189:   invokevirtual [33] 
L192:   pop 
L193:   aload_1 
L194:   ldc [17] 
L196:   invokevirtual [33] 
L199:   pop 
L200:   aload_0 
L201:   getfield [30] 
L204:   lookupswitch 
            0 : L248 
            1 : L258 
            2 : L268 
            255 : L278 
            default : L288 

L248:   aload_1 
L249:   ldc [18] 
L251:   invokevirtual [33] 
L254:   pop 
L255:   goto L295 
L258:   aload_1 
L259:   ldc [19] 
L261:   invokevirtual [33] 
L264:   pop 
L265:   goto L295 
L268:   aload_1 
L269:   ldc [20] 
L271:   invokevirtual [33] 
L274:   pop 
L275:   goto L295 
L278:   aload_1 
L279:   ldc [21] 
L281:   invokevirtual [33] 
L284:   pop 
L285:   goto L295 
L288:   aload_1 
L289:   ldc [10] 
L291:   invokevirtual [33] 
L294:   pop 
L295:   aload_1 
L296:   ldc [22] 
L298:   invokevirtual [33] 
L301:   pop 
L302:   aload_1 
L303:   aload_0 
L304:   getfield [26] 
L307:   invokevirtual [34] 
L310:   invokevirtual [33] 
L313:   pop 
L314:   aload_1 
L315:   invokevirtual [35] 
L318:   areturn 
L319:   nop 
L320:   
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [252] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iinc 1 8 
L11:    iload_1 
L12:    aload_0 
L13:    getfield [26] 
L16:    invokevirtual [36] 
L19:    iadd 
L20:    istore_1 
L21:    iload_1 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [269] : [270] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [28] 
L5:     i2b 
L6:     invokeinterface [51] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [29] 
L16:    i2b 
L17:    invokeinterface [51] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [30] 
L27:    i2b 
L28:    invokeinterface [51] 0 
L33:    aload_0 
L34:    getfield [26] 
L37:    aload_1 
L38:    invokevirtual [37] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [252] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [52] 0 
L7:     putfield [47] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [52] 0 
L17:    putfield [48] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [52] 0 
L27:    putfield [49] 
L30:    aload_0 
L31:    getfield [26] 
L34:    aload_1 
L35:    invokevirtual [38] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public static [273] : [274] 
    .attribute [252] .code stack 1 locals 0 
L0:     bipush 43 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [252] .code stack 1 locals 0 
L0:     invokestatic [23] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [53] 
.const [3] = Class [54] 
.const [4] = Class [55] 
.const [5] = String [56] 
.const [6] = String [57] 
.const [7] = String [58] 
.const [8] = String [59] 
.const [9] = String [60] 
.const [10] = String [61] 
.const [11] = String [62] 
.const [12] = String [63] 
.const [13] = String [64] 
.const [14] = String [65] 
.const [15] = String [66] 
.const [16] = String [67] 
.const [17] = String [68] 
.const [18] = String [69] 
.const [19] = String [70] 
.const [20] = String [71] 
.const [21] = String [72] 
.const [22] = String [73] 
.const [23] = Method [74] [75] 
.const [24] = Class [76] 
.const [25] = Class [77] 
.const [26] = Field [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Field [82] [83] 
.const [29] = Field [84] [85] 
.const [30] = Field [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Method [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Method [100] [101] 
.const [38] = Method [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Method [114] [115] 
.const [45] = Class [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Field [121] [122] 
.const [49] = Field [123] [124] 
.const [50] = Class [125] 
.const [51] = InterfaceMethod [126] [127] 
.const [52] = InterfaceMethod [128] [129] 
.const [53] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [54] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [55] = Utf8 java/lang/StringBuffer 
.const [56] = Utf8 'MapColorAndType_Status:' 
.const [57] = Utf8 '\n - Colour: ' 
.const [58] = Utf8 '0x00 (day)' 
.const [59] = Utf8 '0x01 (night)' 
.const [60] = Utf8 '0x02 (auto)' 
.const [61] = Utf8 'UNKNOWN ENUM' 
.const [62] = Utf8 '\n - ActiveMapType: ' 
.const [63] = Utf8 '0x00 (destination)' 
.const [64] = Utf8 '0x01 (position 2D)' 
.const [65] = Utf8 '0x02 (position 3D)' 
.const [66] = Utf8 '0x03 (overview)' 
.const [67] = Utf8 '0x04 (range map)' 
.const [68] = Utf8 '\n - MainMapSetup: ' 
.const [69] = Utf8 '0x00 (init (no map in ASG))' 
.const [70] = Utf8 '0x01 (main map in ASG (primary map in ASG / instrument cluster))' 
.const [71] = Utf8 '0x02 (main map in FSG (secondary map in ASG / instrument cluster))' 
.const [72] = Utf8 '0xFF (not supported)' 
.const [73] = Utf8 '\n - SupportedMapTypes - ' 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Utf8 java/lang/Object 
.const [77] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [78] = Class [133] 
.const [79] = NameAndType [134] [135] 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Class [148] 
.const [89] = NameAndType [149] [150] 
.const [90] = Class [151] 
.const [91] = NameAndType [152] [153] 
.const [92] = Class [154] 
.const [93] = NameAndType [155] [156] 
.const [94] = Class [157] 
.const [95] = NameAndType [158] [159] 
.const [96] = Class [160] 
.const [97] = NameAndType [161] [162] 
.const [98] = Class [163] 
.const [99] = NameAndType [164] [165] 
.const [100] = Class [166] 
.const [101] = NameAndType [167] [168] 
.const [102] = Class [169] 
.const [103] = NameAndType [170] [171] 
.const [104] = Class [172] 
.const [105] = NameAndType [173] [174] 
.const [106] = Class [175] 
.const [107] = NameAndType [176] [177] 
.const [108] = Class [178] 
.const [109] = NameAndType [179] [180] 
.const [110] = Class [181] 
.const [111] = NameAndType [182] [183] 
.const [112] = Class [184] 
.const [113] = NameAndType [185] [186] 
.const [114] = Class [187] 
.const [115] = NameAndType [188] [189] 
.const [116] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [117] = Class [190] 
.const [118] = NameAndType [191] [192] 
.const [119] = Class [193] 
.const [120] = NameAndType [194] [195] 
.const [121] = Class [196] 
.const [122] = NameAndType [197] [198] 
.const [123] = Class [199] 
.const [124] = NameAndType [200] [201] 
.const [125] = Utf8 java/lang/StringBuffer 
.const [126] = Class [202] 
.const [127] = NameAndType [203] [204] 
.const [128] = Class [205] 
.const [129] = NameAndType [206] [207] 
.const [130] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [131] = Utf8 functionId 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [134] = Utf8 supportedMapTypes 
.const [135] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes; 
.const [136] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [137] = Utf8 deserialize 
.const [138] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [139] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [140] = Utf8 colour 
.const [141] = Utf8 I 
.const [142] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [143] = Utf8 activeMapType 
.const [144] = Utf8 I 
.const [145] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [146] = Utf8 mainMapSetup 
.const [147] = Utf8 I 
.const [148] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [149] = Utf8 reset 
.const [150] = Utf8 ()V 
.const [151] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [152] = Utf8 equalTo 
.const [153] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 append 
.const [156] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [157] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [158] = Utf8 toString 
.const [159] = Utf8 ()Ljava/lang/String; 
.const [160] = Utf8 java/lang/StringBuffer 
.const [161] = Utf8 toString 
.const [162] = Utf8 ()Ljava/lang/String; 
.const [163] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [164] = Utf8 bitSize 
.const [165] = Utf8 ()I 
.const [166] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [167] = Utf8 serialize 
.const [168] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [169] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [170] = Utf8 deserialize 
.const [171] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [172] = Utf8 java/lang/Object 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes 
.const [176] = Utf8 <init> 
.const [177] = Utf8 ()V 
.const [178] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [179] = Utf8 internalReset 
.const [180] = Utf8 ()V 
.const [181] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [182] = Utf8 customInitialization 
.const [183] = Utf8 ()V 
.const [184] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [191] = Utf8 supportedMapTypes 
.const [192] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes; 
.const [193] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [194] = Utf8 colour 
.const [195] = Utf8 I 
.const [196] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [197] = Utf8 activeMapType 
.const [198] = Utf8 I 
.const [199] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [200] = Utf8 mainMapSetup 
.const [201] = Utf8 I 
.const [202] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [203] = Utf8 pushByte 
.const [204] = Utf8 (B)V 
.const [205] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [206] = Utf8 popFrontByte 
.const [207] = Utf8 ()I 
.const [208] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status 
.const [209] = Class [208] 
.const [210] = Utf8 java/lang/Object 
.const [211] = Class [210] 
.const [212] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [213] = Class [212] 
.const [214] = Utf8 colour 
.const [215] = Utf8 I 
.const [216] = Utf8 COLOUR_BITSIZE 
.const [217] = Utf8 I 
.const [218] = Utf8 COLOUR_DAY 
.const [219] = Utf8 I 
.const [220] = Utf8 COLOUR_NIGHT 
.const [221] = Utf8 I 
.const [222] = Utf8 COLOUR_AUTO 
.const [223] = Utf8 I 
.const [224] = Utf8 activeMapType 
.const [225] = Utf8 I 
.const [226] = Utf8 ACTIVE_MAP_TYPE_BITSIZE 
.const [227] = Utf8 I 
.const [228] = Utf8 ACTIVE_MAP_TYPE_DESTINATION 
.const [229] = Utf8 I 
.const [230] = Utf8 ACTIVE_MAP_TYPE_POSITION_2D 
.const [231] = Utf8 I 
.const [232] = Utf8 ACTIVE_MAP_TYPE_POSITION_3D 
.const [233] = Utf8 I 
.const [234] = Utf8 ACTIVE_MAP_TYPE_OVERVIEW 
.const [235] = Utf8 I 
.const [236] = Utf8 ACTIVE_MAP_TYPE_RANGE_MAP 
.const [237] = Utf8 I 
.const [238] = Utf8 mainMapSetup 
.const [239] = Utf8 I 
.const [240] = Utf8 MAIN_MAP_SETUP_BITSIZE 
.const [241] = Utf8 I 
.const [242] = Utf8 MAIN_MAP_SETUP_INIT_NO_MAP_IN_ASG 
.const [243] = Utf8 I 
.const [244] = Utf8 MAIN_MAP_SETUP_MAIN_MAP_IN_ASG 
.const [245] = Utf8 I 
.const [246] = Utf8 MAIN_MAP_SETUP_MAIN_MAP_IN_FSG 
.const [247] = Utf8 I 
.const [248] = Utf8 MAIN_MAP_SETUP_NOT_SUPPORTED 
.const [249] = Utf8 I 
.const [250] = Utf8 supportedMapTypes 
.const [251] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapColorAndType_Status$SupportedMapTypes; 
.const [252] = Utf8 Code 
.const [253] = Utf8 <init> 
.const [254] = Utf8 ()V 
.const [255] = Utf8 <init> 
.const [256] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [257] = Utf8 internalReset 
.const [258] = Utf8 ()V 
.const [259] = Utf8 reset 
.const [260] = Utf8 ()V 
.const [261] = Utf8 equalTo 
.const [262] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [263] = Utf8 customInitialization 
.const [264] = Utf8 ()V 
.const [265] = Utf8 toString 
.const [266] = Utf8 ()Ljava/lang/String; 
.const [267] = Utf8 bitSize 
.const [268] = Utf8 ()I 
.const [269] = Utf8 serialize 
.const [270] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [271] = Utf8 deserialize 
.const [272] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [273] = Utf8 functionId 
.const [274] = Utf8 ()I 
.const [275] = Utf8 getFunctionId 
.const [276] = Utf8 ()I 
.end class 
