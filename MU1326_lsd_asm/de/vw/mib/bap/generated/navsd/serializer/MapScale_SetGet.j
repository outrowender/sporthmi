.version 50 0 
.class public final super [251] 
.super [253] 
.implements [255] 
.field public [256] [257] 
.field private static final [258] [259] 
.field public [260] [261] 
.field private static final [262] [263] 
.field public static final [264] [265] 
.field public static final [266] [267] 
.field public static final [268] [269] 
.field public static final [270] [271] 
.field public final [272] [273] 
.field public [274] [275] 
.field private static final [276] [277] 
.field public [278] [279] 
.field private static final [280] [281] 
.field public [282] [283] 
.field private static final [284] [285] 

.method public [287] : [288] 
    .attribute [286] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     new [42] 
L8:     dup 
L9:     invokespecial [37] 
L12:    putfield [43] 
L15:    aload_0 
L16:    invokespecial [38] 
L19:    aload_0 
L20:    invokespecial [39] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [286] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [40] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [291] : [292] 
    .attribute [286] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [44] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [45] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [46] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [47] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [48] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [286] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [38] 
L4:     aload_0 
L5:     getfield [20] 
L8:     invokevirtual [27] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [286] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [3] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [22] 
L9:     aload_2 
L10:    getfield [22] 
L13:    if_icmpne L78 
L16:    aload_0 
L17:    getfield [23] 
L20:    aload_2 
L21:    getfield [23] 
L24:    if_icmpne L78 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_2 
L32:    getfield [20] 
L35:    invokevirtual [28] 
L38:    ifeq L78 
L41:    aload_0 
L42:    getfield [24] 
L45:    aload_2 
L46:    getfield [24] 
L49:    if_icmpne L78 
L52:    aload_0 
L53:    getfield [25] 
L56:    aload_2 
L57:    getfield [25] 
L60:    if_icmpne L78 
L63:    aload_0 
L64:    getfield [26] 
L67:    aload_2 
L68:    getfield [26] 
L71:    if_icmpne L78 
L74:    iconst_1 
L75:    goto L79 
L78:    iconst_0 
L79:    areturn 
L80:    
    .end code 
.end method 

.method private enum [297] : [298] 
    .attribute [286] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [299] : [300] 
    .attribute [286] .code stack 2 locals 1 
L0:     new [49] 
L3:     dup 
L4:     invokespecial [41] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [5] 
L11:    invokevirtual [29] 
L14:    pop 
L15:    aload_1 
L16:    ldc [6] 
L18:    invokevirtual [29] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [22] 
L27:    invokevirtual [30] 
L30:    pop 
L31:    aload_1 
L32:    ldc [7] 
L34:    invokevirtual [29] 
L37:    pop 
L38:    aload_0 
L39:    getfield [23] 
L42:    lookupswitch 
            0 : L84 
            1 : L94 
            2 : L104 
            15 : L114 
            default : L124 

L84:    aload_1 
L85:    ldc [8] 
L87:    invokevirtual [29] 
L90:    pop 
L91:    goto L131 
L94:    aload_1 
L95:    ldc [9] 
L97:    invokevirtual [29] 
L100:   pop 
L101:   goto L131 
L104:   aload_1 
L105:   ldc [10] 
L107:   invokevirtual [29] 
L110:   pop 
L111:   goto L131 
L114:   aload_1 
L115:   ldc [11] 
L117:   invokevirtual [29] 
L120:   pop 
L121:   goto L131 
L124:   aload_1 
L125:   ldc [12] 
L127:   invokevirtual [29] 
L130:   pop 
L131:   aload_1 
L132:   ldc [13] 
L134:   invokevirtual [29] 
L137:   pop 
L138:   aload_1 
L139:   aload_0 
L140:   getfield [20] 
L143:   invokevirtual [31] 
L146:   invokevirtual [29] 
L149:   pop 
L150:   aload_1 
L151:   ldc [14] 
L153:   invokevirtual [29] 
L156:   pop 
L157:   aload_1 
L158:   aload_0 
L159:   getfield [24] 
L162:   invokevirtual [30] 
L165:   pop 
L166:   aload_1 
L167:   ldc [15] 
L169:   invokevirtual [29] 
L172:   pop 
L173:   aload_1 
L174:   aload_0 
L175:   getfield [25] 
L178:   invokevirtual [30] 
L181:   pop 
L182:   aload_1 
L183:   ldc [16] 
L185:   invokevirtual [29] 
L188:   pop 
L189:   aload_1 
L190:   aload_0 
L191:   getfield [26] 
L194:   invokevirtual [30] 
L197:   pop 
L198:   aload_1 
L199:   invokevirtual [32] 
L202:   areturn 
L203:   nop 
L204:   
    .end code 
.end method 

.method public [301] : [302] 
    .attribute [286] .code stack 2 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 4 
L8:     iload_1 
L9:     aload_0 
L10:    getfield [20] 
L13:    invokevirtual [33] 
L16:    iadd 
L17:    istore_1 
L18:    iinc 1 16 
L21:    iinc 1 8 
L24:    iinc 1 8 
L27:    iload_1 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [303] : [304] 
    .attribute [286] .code stack 3 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [22] 
L5:     i2b 
L6:     invokeinterface [50] 0 
L11:    aload_1 
L12:    iconst_4 
L13:    aload_0 
L14:    getfield [23] 
L17:    invokeinterface [51] 0 
L22:    aload_0 
L23:    getfield [20] 
L26:    aload_1 
L27:    invokevirtual [34] 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [24] 
L35:    i2s 
L36:    invokeinterface [52] 0 
L41:    aload_1 
L42:    aload_0 
L43:    getfield [25] 
L46:    i2b 
L47:    invokeinterface [50] 0 
L52:    aload_1 
L53:    aload_0 
L54:    getfield [26] 
L57:    i2b 
L58:    invokeinterface [50] 0 
L63:    return 
L64:    
    .end code 
.end method 

.method public [305] : [306] 
    .attribute [286] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [53] 0 
L7:     i2b 
L8:     putfield [44] 
L11:    aload_0 
L12:    aload_1 
L13:    iconst_4 
L14:    invokeinterface [54] 0 
L19:    putfield [45] 
L22:    aload_0 
L23:    getfield [20] 
L26:    aload_1 
L27:    invokevirtual [35] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [55] 0 
L37:    putfield [46] 
L40:    aload_0 
L41:    aload_1 
L42:    invokeinterface [53] 0 
L47:    putfield [47] 
L50:    aload_0 
L51:    aload_1 
L52:    invokeinterface [53] 0 
L57:    putfield [48] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [307] : [308] 
    .attribute [286] .code stack 1 locals 0 
L0:     bipush 45 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [309] : [310] 
    .attribute [286] .code stack 1 locals 0 
L0:     invokestatic [17] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Class [57] 
.const [4] = Class [58] 
.const [5] = String [59] 
.const [6] = String [60] 
.const [7] = String [61] 
.const [8] = String [62] 
.const [9] = String [63] 
.const [10] = String [64] 
.const [11] = String [65] 
.const [12] = String [66] 
.const [13] = String [67] 
.const [14] = String [68] 
.const [15] = String [69] 
.const [16] = String [70] 
.const [17] = Method [71] [72] 
.const [18] = Class [73] 
.const [19] = Class [74] 
.const [20] = Field [75] [76] 
.const [21] = Method [77] [78] 
.const [22] = Field [79] [80] 
.const [23] = Field [81] [82] 
.const [24] = Field [83] [84] 
.const [25] = Field [85] [86] 
.const [26] = Field [87] [88] 
.const [27] = Method [89] [90] 
.const [28] = Method [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Method [97] [98] 
.const [32] = Method [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Method [113] [114] 
.const [40] = Method [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Class [119] 
.const [43] = Field [120] [121] 
.const [44] = Field [122] [123] 
.const [45] = Field [124] [125] 
.const [46] = Field [126] [127] 
.const [47] = Field [128] [129] 
.const [48] = Field [130] [131] 
.const [49] = Class [132] 
.const [50] = InterfaceMethod [133] [134] 
.const [51] = InterfaceMethod [135] [136] 
.const [52] = InterfaceMethod [137] [138] 
.const [53] = InterfaceMethod [139] [140] 
.const [54] = InterfaceMethod [141] [142] 
.const [55] = InterfaceMethod [143] [144] 
.const [56] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [57] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [58] = Utf8 java/lang/StringBuffer 
.const [59] = Utf8 'MapScale_SetGet:' 
.const [60] = Utf8 '\n - Steps - ' 
.const [61] = Utf8 '\n - AutoZoom: ' 
.const [62] = Utf8 '0x0 (AutoZoom OFF)' 
.const [63] = Utf8 '0x1 (AutoZoom ON)' 
.const [64] = Utf8 '0x2 (AutoZoom ON for Intersection)' 
.const [65] = Utf8 '0xF (AutoZoom setting not supported)' 
.const [66] = Utf8 'UNKNOWN ENUM' 
.const [67] = Utf8 '\n - AutoZoomState - ' 
.const [68] = Utf8 '\n - Reserve2 - ' 
.const [69] = Utf8 '\n - Reserve3 - ' 
.const [70] = Utf8 '\n - Reserve4 - ' 
.const [71] = Class [145] 
.const [72] = NameAndType [146] [147] 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [75] = Class [148] 
.const [76] = NameAndType [149] [150] 
.const [77] = Class [151] 
.const [78] = NameAndType [152] [153] 
.const [79] = Class [154] 
.const [80] = NameAndType [155] [156] 
.const [81] = Class [157] 
.const [82] = NameAndType [158] [159] 
.const [83] = Class [160] 
.const [84] = NameAndType [161] [162] 
.const [85] = Class [163] 
.const [86] = NameAndType [164] [165] 
.const [87] = Class [166] 
.const [88] = NameAndType [167] [168] 
.const [89] = Class [169] 
.const [90] = NameAndType [170] [171] 
.const [91] = Class [172] 
.const [92] = NameAndType [173] [174] 
.const [93] = Class [175] 
.const [94] = NameAndType [176] [177] 
.const [95] = Class [178] 
.const [96] = NameAndType [179] [180] 
.const [97] = Class [181] 
.const [98] = NameAndType [182] [183] 
.const [99] = Class [184] 
.const [100] = NameAndType [185] [186] 
.const [101] = Class [187] 
.const [102] = NameAndType [188] [189] 
.const [103] = Class [190] 
.const [104] = NameAndType [191] [192] 
.const [105] = Class [193] 
.const [106] = NameAndType [194] [195] 
.const [107] = Class [196] 
.const [108] = NameAndType [197] [198] 
.const [109] = Class [199] 
.const [110] = NameAndType [200] [201] 
.const [111] = Class [202] 
.const [112] = NameAndType [203] [204] 
.const [113] = Class [205] 
.const [114] = NameAndType [206] [207] 
.const [115] = Class [208] 
.const [116] = NameAndType [209] [210] 
.const [117] = Class [211] 
.const [118] = NameAndType [212] [213] 
.const [119] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [120] = Class [214] 
.const [121] = NameAndType [215] [216] 
.const [122] = Class [217] 
.const [123] = NameAndType [218] [219] 
.const [124] = Class [220] 
.const [125] = NameAndType [221] [222] 
.const [126] = Class [223] 
.const [127] = NameAndType [224] [225] 
.const [128] = Class [226] 
.const [129] = NameAndType [227] [228] 
.const [130] = Class [229] 
.const [131] = NameAndType [230] [231] 
.const [132] = Utf8 java/lang/StringBuffer 
.const [133] = Class [232] 
.const [134] = NameAndType [233] [234] 
.const [135] = Class [235] 
.const [136] = NameAndType [236] [237] 
.const [137] = Class [238] 
.const [138] = NameAndType [239] [240] 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Class [247] 
.const [144] = NameAndType [248] [249] 
.const [145] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [146] = Utf8 functionId 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [149] = Utf8 autoZoomState 
.const [150] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [151] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [152] = Utf8 deserialize 
.const [153] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [154] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [155] = Utf8 steps 
.const [156] = Utf8 I 
.const [157] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [158] = Utf8 autoZoom 
.const [159] = Utf8 I 
.const [160] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [161] = Utf8 reserve2 
.const [162] = Utf8 I 
.const [163] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [164] = Utf8 reserve3 
.const [165] = Utf8 I 
.const [166] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [167] = Utf8 reserve4 
.const [168] = Utf8 I 
.const [169] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [170] = Utf8 reset 
.const [171] = Utf8 ()V 
.const [172] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [173] = Utf8 equalTo 
.const [174] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [175] = Utf8 java/lang/StringBuffer 
.const [176] = Utf8 append 
.const [177] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [178] = Utf8 java/lang/StringBuffer 
.const [179] = Utf8 append 
.const [180] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [181] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [182] = Utf8 toString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 java/lang/StringBuffer 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [188] = Utf8 bitSize 
.const [189] = Utf8 ()I 
.const [190] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [191] = Utf8 serialize 
.const [192] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [193] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [194] = Utf8 deserialize 
.const [195] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [196] = Utf8 java/lang/Object 
.const [197] = Utf8 <init> 
.const [198] = Utf8 ()V 
.const [199] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [203] = Utf8 internalReset 
.const [204] = Utf8 ()V 
.const [205] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [206] = Utf8 customInitialization 
.const [207] = Utf8 ()V 
.const [208] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [209] = Utf8 <init> 
.const [210] = Utf8 ()V 
.const [211] = Utf8 java/lang/StringBuffer 
.const [212] = Utf8 <init> 
.const [213] = Utf8 ()V 
.const [214] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [215] = Utf8 autoZoomState 
.const [216] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [217] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [218] = Utf8 steps 
.const [219] = Utf8 I 
.const [220] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [221] = Utf8 autoZoom 
.const [222] = Utf8 I 
.const [223] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [224] = Utf8 reserve2 
.const [225] = Utf8 I 
.const [226] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [227] = Utf8 reserve3 
.const [228] = Utf8 I 
.const [229] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [230] = Utf8 reserve4 
.const [231] = Utf8 I 
.const [232] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [233] = Utf8 pushByte 
.const [234] = Utf8 (B)V 
.const [235] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [236] = Utf8 pushBits 
.const [237] = Utf8 (II)V 
.const [238] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [239] = Utf8 pushShort 
.const [240] = Utf8 (S)V 
.const [241] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [242] = Utf8 popFrontByte 
.const [243] = Utf8 ()I 
.const [244] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [245] = Utf8 popFrontBits 
.const [246] = Utf8 (I)I 
.const [247] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [248] = Utf8 popFrontShort 
.const [249] = Utf8 ()I 
.const [250] = Utf8 de/vw/mib/bap/generated/navsd/serializer/MapScale_SetGet 
.const [251] = Class [250] 
.const [252] = Utf8 java/lang/Object 
.const [253] = Class [252] 
.const [254] = Utf8 de/vw/mib/bap/requests/SetGetProperty 
.const [255] = Class [254] 
.const [256] = Utf8 steps 
.const [257] = Utf8 I 
.const [258] = Utf8 STEPS_BITSIZE 
.const [259] = Utf8 I 
.const [260] = Utf8 autoZoom 
.const [261] = Utf8 I 
.const [262] = Utf8 AUTO_ZOOM_BITSIZE 
.const [263] = Utf8 I 
.const [264] = Utf8 AUTO_ZOOM_AUTO_ZOOM_OFF 
.const [265] = Utf8 I 
.const [266] = Utf8 AUTO_ZOOM_AUTO_ZOOM_ON 
.const [267] = Utf8 I 
.const [268] = Utf8 AUTO_ZOOM_AUTO_ZOOM_ON_FOR_INTERSECTION 
.const [269] = Utf8 I 
.const [270] = Utf8 AUTO_ZOOM_AUTO_ZOOM_SETTING_NOT_SUPPORTED 
.const [271] = Utf8 I 
.const [272] = Utf8 autoZoomState 
.const [273] = Utf8 Lde/vw/mib/bap/generated/navsd/serializer/MapScale_AutoZoomState; 
.const [274] = Utf8 reserve2 
.const [275] = Utf8 I 
.const [276] = Utf8 RESERVE2_BITSIZE 
.const [277] = Utf8 I 
.const [278] = Utf8 reserve3 
.const [279] = Utf8 I 
.const [280] = Utf8 RESERVE3_BITSIZE 
.const [281] = Utf8 I 
.const [282] = Utf8 reserve4 
.const [283] = Utf8 I 
.const [284] = Utf8 RESERVE4_BITSIZE 
.const [285] = Utf8 I 
.const [286] = Utf8 Code 
.const [287] = Utf8 <init> 
.const [288] = Utf8 ()V 
.const [289] = Utf8 <init> 
.const [290] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [291] = Utf8 internalReset 
.const [292] = Utf8 ()V 
.const [293] = Utf8 reset 
.const [294] = Utf8 ()V 
.const [295] = Utf8 equalTo 
.const [296] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [297] = Utf8 customInitialization 
.const [298] = Utf8 ()V 
.const [299] = Utf8 toString 
.const [300] = Utf8 ()Ljava/lang/String; 
.const [301] = Utf8 bitSize 
.const [302] = Utf8 ()I 
.const [303] = Utf8 serialize 
.const [304] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [305] = Utf8 deserialize 
.const [306] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [307] = Utf8 functionId 
.const [308] = Utf8 ()I 
.const [309] = Utf8 getFunctionId 
.const [310] = Utf8 ()I 
.end class 
