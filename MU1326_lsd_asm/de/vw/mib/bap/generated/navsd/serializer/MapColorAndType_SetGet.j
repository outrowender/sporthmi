.version 50 0 
.class public final super [169] 
.super [171] 
.implements [173] 
.field public [174] [175] 
.field private static final [176] [177] 
.field public static final [178] [179] 
.field public static final [180] [181] 
.field public static final [182] [183] 
.field public [184] [185] 
.field private static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field public static final [192] [193] 
.field public static final [194] [195] 
.field public static final [196] [197] 
.field public [198] [199] 
.field private static final [200] [201] 
.field public static final [202] [203] 
.field public static final [204] [205] 
.field public static final [206] [207] 
.field public static final [208] [209] 
.field public [210] [211] 
.field private static final [212] [213] 

.method public [215] : [216] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [33] 
L4:     aload_0 
L5:     invokespecial [34] 
L8:     aload_0 
L9:     invokespecial [35] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [217] : [218] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [219] : [220] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [38] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [39] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [40] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [41] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [34] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [214] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [26] 
L9:     aload_2 
L10:    getfield [26] 
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [27] 
L20:    aload_2 
L21:    getfield [27] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [28] 
L31:    aload_2 
L32:    getfield [28] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [29] 
L42:    aload_2 
L43:    getfield [29] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private enum [225] : [226] 
    .attribute [214] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [214] .code stack 2 locals 1 
L0:     new [42] 
L3:     dup 
L4:     invokespecial [37] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [30] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [30] 
L21:    pop 
L22:    aload_0 
L23:    getfield [26] 
L26:    tableswitch 0 
            L52 
            L62 
            L72 
            default : L82 

L52:    aload_1 
L53:    ldc [6] 
L55:    invokevirtual [30] 
L58:    pop 
L59:    goto L89 
L62:    aload_1 
L63:    ldc [7] 
L65:    invokevirtual [30] 
L68:    pop 
L69:    goto L89 
L72:    aload_1 
L73:    ldc [8] 
L75:    invokevirtual [30] 
L78:    pop 
L79:    goto L89 
L82:    aload_1 
L83:    ldc [9] 
L85:    invokevirtual [30] 
L88:    pop 
L89:    aload_1 
L90:    ldc [10] 
L92:    invokevirtual [30] 
L95:    pop 
L96:    aload_0 
L97:    getfield [27] 
L100:   tableswitch 0 
            L136 
            L146 
            L156 
            L166 
            L176 
            default : L186 

L136:   aload_1 
L137:   ldc [11] 
L139:   invokevirtual [30] 
L142:   pop 
L143:   goto L193 
L146:   aload_1 
L147:   ldc [12] 
L149:   invokevirtual [30] 
L152:   pop 
L153:   goto L193 
L156:   aload_1 
L157:   ldc [13] 
L159:   invokevirtual [30] 
L162:   pop 
L163:   goto L193 
L166:   aload_1 
L167:   ldc [14] 
L169:   invokevirtual [30] 
L172:   pop 
L173:   goto L193 
L176:   aload_1 
L177:   ldc [15] 
L179:   invokevirtual [30] 
L182:   pop 
L183:   goto L193 
L186:   aload_1 
L187:   ldc [9] 
L189:   invokevirtual [30] 
L192:   pop 
L193:   aload_1 
L194:   ldc [16] 
L196:   invokevirtual [30] 
L199:   pop 
L200:   aload_0 
L201:   getfield [28] 
L204:   lookupswitch 
            0 : L248 
            1 : L258 
            2 : L268 
            255 : L278 
            default : L288 

L248:   aload_1 
L249:   ldc [17] 
L251:   invokevirtual [30] 
L254:   pop 
L255:   goto L295 
L258:   aload_1 
L259:   ldc [18] 
L261:   invokevirtual [30] 
L264:   pop 
L265:   goto L295 
L268:   aload_1 
L269:   ldc [19] 
L271:   invokevirtual [30] 
L274:   pop 
L275:   goto L295 
L278:   aload_1 
L279:   ldc [20] 
L281:   invokevirtual [30] 
L284:   pop 
L285:   goto L295 
L288:   aload_1 
L289:   ldc [9] 
L291:   invokevirtual [30] 
L294:   pop 
L295:   aload_1 
L296:   ldc [21] 
L298:   invokevirtual [30] 
L301:   pop 
L302:   aload_1 
L303:   aload_0 
L304:   getfield [29] 
L307:   invokevirtual [31] 
L310:   pop 
L311:   aload_1 
L312:   invokevirtual [32] 
L315:   areturn 
L316:   
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [214] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iinc 1 8 
L11:    iinc 1 8 
L14:    iload_1 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [26] 
L5:     i2b 
L6:     invokeinterface [43] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [27] 
L16:    i2b 
L17:    invokeinterface [43] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [28] 
L27:    i2b 
L28:    invokeinterface [43] 0 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [29] 
L38:    i2b 
L39:    invokeinterface [43] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [44] 0 
L7:     putfield [38] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [44] 0 
L17:    putfield [39] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [44] 0 
L27:    putfield [40] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [44] 0 
L37:    putfield [41] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [235] : [236] 
    .attribute [214] .code stack 1 locals 0 
L0:     bipush 43 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [214] .code stack 1 locals 0 
L0:     invokestatic [22] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [45] 
.const [3] = Class [46] 
.const [4] = String [47] 
.const [5] = String [48] 
.const [6] = String [49] 
.const [7] = String [50] 
.const [8] = String [51] 
.const [9] = String [52] 
.const [10] = String [53] 
.const [11] = String [54] 
.const [12] = String [55] 
.const [13] = String [56] 
.const [14] = String [57] 
.const [15] = String [58] 
.const [16] = String [59] 
.const [17] = String [60] 
.const [18] = String [61] 
.const [19] = String [62] 
.const [20] = String [63] 
.const [21] = String [64] 
.const [22] = Method [65] [66] 
.const [23] = Class [67] 
.const [24] = Class [68] 
.const [25] = Method [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Method [81] [82] 
.const [32] = Method [83] [84] 
.const [33] = Method [85] [86] 
.const [34] = Method [87] [88] 
.const [35] = Method [89] [90] 
.const [36] = Method [91] [92] 
.const [37] = Method [93] [94] 
.const [38] = Field [95] [96] 
.const [39] = Field [97] [98] 
.const [40] = Field [99] [100] 
.const [41] = Field [101] [102] 
.const [42] = Class [103] 
.const [43] = InterfaceMethod [104] [105] 
.const [44] = InterfaceMethod [106] [107] 
.const [45] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [46] = Utf8 java/lang/StringBuffer 
.const [47] = Utf8 'MapColorAndType_SetGet:' 
.const [48] = Utf8 '\n - Colour: ' 
.const [49] = Utf8 '0x00 (day)' 
.const [50] = Utf8 '0x01 (night)' 
.const [51] = Utf8 '0x02 (auto)' 
.const [52] = Utf8 'UNKNOWN ENUM' 
.const [53] = Utf8 '\n - ActiveMapType: ' 
.const [54] = Utf8 '0x00 (destination)' 
.const [55] = Utf8 '0x01 (position 2D)' 
.const [56] = Utf8 '0x02 (position 3D)' 
.const [57] = Utf8 '0x03 (overview)' 
.const [58] = Utf8 '0x04 (range map)' 
.const [59] = Utf8 '\n - MainMapSetup: ' 
.const [60] = Utf8 '0x00 (init (no map in ASG))' 
.const [61] = Utf8 '0x01 (main map in ASG (primary map in ASG / instrument cluster))' 
.const [62] = Utf8 '0x02 (main map in FSG (secondary map in ASG / instrument cluster))' 
.const [63] = Utf8 '0xFF (not supported)' 
.const [64] = Utf8 '\n - Reserve - ' 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Utf8 java/lang/Object 
.const [68] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [69] = Class [111] 
.const [70] = NameAndType [112] [113] 
.const [71] = Class [114] 
.const [72] = NameAndType [115] [116] 
.const [73] = Class [117] 
.const [74] = NameAndType [118] [119] 
.const [75] = Class [120] 
.const [76] = NameAndType [121] [122] 
.const [77] = Class [123] 
.const [78] = NameAndType [124] [125] 
.const [79] = Class [126] 
.const [80] = NameAndType [127] [128] 
.const [81] = Class [129] 
.const [82] = NameAndType [130] [131] 
.const [83] = Class [132] 
.const [84] = NameAndType [133] [134] 
.const [85] = Class [135] 
.const [86] = NameAndType [136] [137] 
.const [87] = Class [138] 
.const [88] = NameAndType [139] [140] 
.const [89] = Class [141] 
.const [90] = NameAndType [142] [143] 
.const [91] = Class [144] 
.const [92] = NameAndType [145] [146] 
.const [93] = Class [147] 
.const [94] = NameAndType [148] [149] 
.const [95] = Class [150] 
.const [96] = NameAndType [151] [152] 
.const [97] = Class [153] 
.const [98] = NameAndType [154] [155] 
.const [99] = Class [156] 
.const [100] = NameAndType [157] [158] 
.const [101] = Class [159] 
.const [102] = NameAndType [160] [161] 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Class [162] 
.const [105] = NameAndType [163] [164] 
.const [106] = Class [165] 
.const [107] = NameAndType [166] [167] 
.const [108] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [109] = Utf8 functionId 
.const [110] = Utf8 ()I 
.const [111] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [112] = Utf8 deserialize 
.const [113] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [114] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [115] = Utf8 colour 
.const [116] = Utf8 I 
.const [117] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [118] = Utf8 activeMapType 
.const [119] = Utf8 I 
.const [120] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [121] = Utf8 mainMapSetup 
.const [122] = Utf8 I 
.const [123] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [124] = Utf8 reserve 
.const [125] = Utf8 I 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 append 
.const [128] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [129] = Utf8 java/lang/StringBuffer 
.const [130] = Utf8 append 
.const [131] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Utf8 toString 
.const [134] = Utf8 ()Ljava/lang/String; 
.const [135] = Utf8 java/lang/Object 
.const [136] = Utf8 <init> 
.const [137] = Utf8 ()V 
.const [138] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [139] = Utf8 internalReset 
.const [140] = Utf8 ()V 
.const [141] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [142] = Utf8 customInitialization 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 java/lang/StringBuffer 
.const [148] = Utf8 <init> 
.const [149] = Utf8 ()V 
.const [150] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [151] = Utf8 colour 
.const [152] = Utf8 I 
.const [153] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [154] = Utf8 activeMapType 
.const [155] = Utf8 I 
.const [156] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [157] = Utf8 mainMapSetup 
.const [158] = Utf8 I 
.const [159] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [160] = Utf8 reserve 
.const [161] = Utf8 I 
.const [162] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [163] = Utf8 pushByte 
.const [164] = Utf8 (B)V 
.const [165] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [166] = Utf8 popFrontByte 
.const [167] = Utf8 ()I 
.const [168] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapColorAndType_SetGet 
.const [169] = Class [168] 
.const [170] = Utf8 java/lang/Object 
.const [171] = Class [170] 
.const [172] = Utf8 de/vw/mib/bap/requests/SetGetProperty 
.const [173] = Class [172] 
.const [174] = Utf8 colour 
.const [175] = Utf8 I 
.const [176] = Utf8 COLOUR_BITSIZE 
.const [177] = Utf8 I 
.const [178] = Utf8 COLOUR_DAY 
.const [179] = Utf8 I 
.const [180] = Utf8 COLOUR_NIGHT 
.const [181] = Utf8 I 
.const [182] = Utf8 COLOUR_AUTO 
.const [183] = Utf8 I 
.const [184] = Utf8 activeMapType 
.const [185] = Utf8 I 
.const [186] = Utf8 ACTIVE_MAP_TYPE_BITSIZE 
.const [187] = Utf8 I 
.const [188] = Utf8 ACTIVE_MAP_TYPE_DESTINATION 
.const [189] = Utf8 I 
.const [190] = Utf8 ACTIVE_MAP_TYPE_POSITION_2D 
.const [191] = Utf8 I 
.const [192] = Utf8 ACTIVE_MAP_TYPE_POSITION_3D 
.const [193] = Utf8 I 
.const [194] = Utf8 ACTIVE_MAP_TYPE_OVERVIEW 
.const [195] = Utf8 I 
.const [196] = Utf8 ACTIVE_MAP_TYPE_RANGE_MAP 
.const [197] = Utf8 I 
.const [198] = Utf8 mainMapSetup 
.const [199] = Utf8 I 
.const [200] = Utf8 MAIN_MAP_SETUP_BITSIZE 
.const [201] = Utf8 I 
.const [202] = Utf8 MAIN_MAP_SETUP_INIT_NO_MAP_IN_ASG 
.const [203] = Utf8 I 
.const [204] = Utf8 MAIN_MAP_SETUP_MAIN_MAP_IN_ASG 
.const [205] = Utf8 I 
.const [206] = Utf8 MAIN_MAP_SETUP_MAIN_MAP_IN_FSG 
.const [207] = Utf8 I 
.const [208] = Utf8 MAIN_MAP_SETUP_NOT_SUPPORTED 
.const [209] = Utf8 I 
.const [210] = Utf8 reserve 
.const [211] = Utf8 I 
.const [212] = Utf8 RESERVE_BITSIZE 
.const [213] = Utf8 I 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 ()V 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [219] = Utf8 internalReset 
.const [220] = Utf8 ()V 
.const [221] = Utf8 reset 
.const [222] = Utf8 ()V 
.const [223] = Utf8 equalTo 
.const [224] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [225] = Utf8 customInitialization 
.const [226] = Utf8 ()V 
.const [227] = Utf8 toString 
.const [228] = Utf8 ()Ljava/lang/String; 
.const [229] = Utf8 bitSize 
.const [230] = Utf8 ()I 
.const [231] = Utf8 serialize 
.const [232] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [233] = Utf8 deserialize 
.const [234] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [235] = Utf8 functionId 
.const [236] = Utf8 ()I 
.const [237] = Utf8 getFunctionId 
.const [238] = Utf8 ()I 
.end class 
