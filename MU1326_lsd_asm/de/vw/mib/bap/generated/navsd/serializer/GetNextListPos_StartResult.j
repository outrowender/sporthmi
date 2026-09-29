.version 50 0 
.class public final super [153] 
.super [155] 
.implements [157] 
.field public [158] [159] 
.field private static final [160] [161] 
.field public [162] [163] 
.field private static final [164] [165] 
.field public [166] [167] 
.field private static final [168] [169] 
.field public static final [170] [171] 
.field public static final [172] [173] 
.field public static final [174] [175] 
.field public static final [176] [177] 
.field public static final [178] [179] 

.method public [181] : [182] 
    .attribute [180] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     invokespecial [25] 
L8:     aload_0 
L9:     invokespecial [26] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [180] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [185] : [186] 
    .attribute [180] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [29] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [30] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [31] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [180] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [180] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L42 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
L24:    if_icmpne L42 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_2 
L32:    getfield [20] 
L35:    if_icmpne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private enum [191] : [192] 
    .attribute [180] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [180] .code stack 2 locals 1 
L0:     new [32] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [21] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [21] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [18] 
L27:    invokevirtual [22] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [21] 
L37:    pop 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [19] 
L43:    invokevirtual [22] 
L46:    pop 
L47:    aload_1 
L48:    ldc [7] 
L50:    invokevirtual [21] 
L53:    pop 
L54:    aload_0 
L55:    getfield [20] 
L58:    tableswitch 0 
            L92 
            L102 
            L112 
            L122 
            L132 
            default : L142 

L92:    aload_1 
L93:    ldc [8] 
L95:    invokevirtual [21] 
L98:    pop 
L99:    goto L149 
L102:   aload_1 
L103:   ldc [9] 
L105:   invokevirtual [21] 
L108:   pop 
L109:   goto L149 
L112:   aload_1 
L113:   ldc [10] 
L115:   invokevirtual [21] 
L118:   pop 
L119:   goto L149 
L122:   aload_1 
L123:   ldc [11] 
L125:   invokevirtual [21] 
L128:   pop 
L129:   goto L149 
L132:   aload_1 
L133:   ldc [12] 
L135:   invokevirtual [21] 
L138:   pop 
L139:   goto L149 
L142:   aload_1 
L143:   ldc [13] 
L145:   invokevirtual [21] 
L148:   pop 
L149:   aload_1 
L150:   invokevirtual [23] 
L153:   areturn 
L154:   nop 
L155:   nop 
L156:   
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [180] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 16 
L5:     iinc 1 16 
L8:     iinc 1 8 
L11:    iload_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [180] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     i2s 
L6:     invokeinterface [33] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [19] 
L16:    i2s 
L17:    invokeinterface [33] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [20] 
L27:    i2b 
L28:    invokeinterface [34] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [180] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [35] 0 
L7:     putfield [29] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [35] 0 
L17:    i2s 
L18:    putfield [30] 
L21:    aload_0 
L22:    aload_1 
L23:    invokeinterface [36] 0 
L28:    putfield [31] 
L31:    return 
L32:    
    .end code 
.end method 

.method public static [201] : [202] 
    .attribute [180] .code stack 1 locals 0 
L0:     bipush 41 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [180] .code stack 1 locals 0 
L0:     invokestatic [14] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Class [38] 
.const [4] = String [39] 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = String [42] 
.const [8] = String [43] 
.const [9] = String [44] 
.const [10] = String [45] 
.const [11] = String [46] 
.const [12] = String [47] 
.const [13] = String [48] 
.const [14] = Method [49] [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Method [53] [54] 
.const [18] = Field [55] [56] 
.const [19] = Field [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Field [79] [80] 
.const [31] = Field [81] [82] 
.const [32] = Class [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = InterfaceMethod [86] [87] 
.const [35] = InterfaceMethod [88] [89] 
.const [36] = InterfaceMethod [90] [91] 
.const [37] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 'GetNextListPos_StartResult:' 
.const [40] = Utf8 '\n - currentPos - ' 
.const [41] = Utf8 '\n - Offset - ' 
.const [42] = Utf8 '\n - ListType: ' 
.const [43] = Utf8 '0x00 (LastDestinations_List)' 
.const [44] = Utf8 '0x01 (FavoriteDestinations_List)' 
.const [45] = Utf8 '0x02 (NavBook)' 
.const [46] = Utf8 '0x03 (Address_List)' 
.const [47] = Utf8 '0x04 (POI_List (DF4.1))' 
.const [48] = Utf8 'UNKNOWN ENUM' 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Class [104] 
.const [60] = NameAndType [105] [106] 
.const [61] = Class [107] 
.const [62] = NameAndType [108] [109] 
.const [63] = Class [110] 
.const [64] = NameAndType [111] [112] 
.const [65] = Class [113] 
.const [66] = NameAndType [114] [115] 
.const [67] = Class [116] 
.const [68] = NameAndType [117] [118] 
.const [69] = Class [119] 
.const [70] = NameAndType [120] [121] 
.const [71] = Class [122] 
.const [72] = NameAndType [123] [124] 
.const [73] = Class [125] 
.const [74] = NameAndType [126] [127] 
.const [75] = Class [128] 
.const [76] = NameAndType [129] [130] 
.const [77] = Class [131] 
.const [78] = NameAndType [132] [133] 
.const [79] = Class [134] 
.const [80] = NameAndType [135] [136] 
.const [81] = Class [137] 
.const [82] = NameAndType [138] [139] 
.const [83] = Utf8 java/lang/StringBuffer 
.const [84] = Class [140] 
.const [85] = NameAndType [141] [142] 
.const [86] = Class [143] 
.const [87] = NameAndType [144] [145] 
.const [88] = Class [146] 
.const [89] = NameAndType [147] [148] 
.const [90] = Class [149] 
.const [91] = NameAndType [150] [151] 
.const [92] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [93] = Utf8 functionId 
.const [94] = Utf8 ()I 
.const [95] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [96] = Utf8 deserialize 
.const [97] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [98] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [99] = Utf8 currentPos 
.const [100] = Utf8 I 
.const [101] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [102] = Utf8 offset 
.const [103] = Utf8 I 
.const [104] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [105] = Utf8 listType 
.const [106] = Utf8 I 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 append 
.const [109] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [110] = Utf8 java/lang/StringBuffer 
.const [111] = Utf8 append 
.const [112] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 toString 
.const [115] = Utf8 ()Ljava/lang/String; 
.const [116] = Utf8 java/lang/Object 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [120] = Utf8 internalReset 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [123] = Utf8 customInitialization 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 java/lang/StringBuffer 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [132] = Utf8 currentPos 
.const [133] = Utf8 I 
.const [134] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [135] = Utf8 offset 
.const [136] = Utf8 I 
.const [137] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [138] = Utf8 listType 
.const [139] = Utf8 I 
.const [140] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [141] = Utf8 pushShort 
.const [142] = Utf8 (S)V 
.const [143] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [144] = Utf8 pushByte 
.const [145] = Utf8 (B)V 
.const [146] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [147] = Utf8 popFrontShort 
.const [148] = Utf8 ()I 
.const [149] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [150] = Utf8 popFrontByte 
.const [151] = Utf8 ()I 
.const [152] = Utf8 de/vw/mib/bap/generated/navsd/serializer/GetNextListPos_StartResult 
.const [153] = Class [152] 
.const [154] = Utf8 java/lang/Object 
.const [155] = Class [154] 
.const [156] = Utf8 de/vw/mib/bap/requests/StartResultMethod 
.const [157] = Class [156] 
.const [158] = Utf8 currentPos 
.const [159] = Utf8 I 
.const [160] = Utf8 CURRENT_POS_BITSIZE 
.const [161] = Utf8 I 
.const [162] = Utf8 offset 
.const [163] = Utf8 I 
.const [164] = Utf8 OFFSET_BITSIZE 
.const [165] = Utf8 I 
.const [166] = Utf8 listType 
.const [167] = Utf8 I 
.const [168] = Utf8 LIST_TYPE_BITSIZE 
.const [169] = Utf8 I 
.const [170] = Utf8 LIST_TYPE_LAST_DESTINATIONS_LIST 
.const [171] = Utf8 I 
.const [172] = Utf8 LIST_TYPE_FAVORITE_DESTINATIONS_LIST 
.const [173] = Utf8 I 
.const [174] = Utf8 LIST_TYPE_NAV_BOOK 
.const [175] = Utf8 I 
.const [176] = Utf8 LIST_TYPE_ADDRESS_LIST 
.const [177] = Utf8 I 
.const [178] = Utf8 LIST_TYPE_POI_LIST_DF4_1 
.const [179] = Utf8 I 
.const [180] = Utf8 Code 
.const [181] = Utf8 <init> 
.const [182] = Utf8 ()V 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [185] = Utf8 internalReset 
.const [186] = Utf8 ()V 
.const [187] = Utf8 reset 
.const [188] = Utf8 ()V 
.const [189] = Utf8 equalTo 
.const [190] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [191] = Utf8 customInitialization 
.const [192] = Utf8 ()V 
.const [193] = Utf8 toString 
.const [194] = Utf8 ()Ljava/lang/String; 
.const [195] = Utf8 bitSize 
.const [196] = Utf8 ()I 
.const [197] = Utf8 serialize 
.const [198] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [199] = Utf8 deserialize 
.const [200] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [201] = Utf8 functionId 
.const [202] = Utf8 ()I 
.const [203] = Utf8 getFunctionId 
.const [204] = Utf8 ()I 
.end class 
