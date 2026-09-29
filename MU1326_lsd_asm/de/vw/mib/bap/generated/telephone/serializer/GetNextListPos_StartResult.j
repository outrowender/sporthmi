.version 50 0 
.class public final super [149] 
.super [151] 
.implements [153] 
.field public [154] [155] 
.field private static final [156] [157] 
.field public [158] [159] 
.field private static final [160] [161] 
.field public [162] [163] 
.field private static final [164] [165] 
.field public static final [166] [167] 
.field public static final [168] [169] 
.field public static final [170] [171] 

.method public [173] : [174] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     invokespecial [23] 
L8:     aload_0 
L9:     invokespecial [24] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [177] : [178] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [27] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [28] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [29] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [172] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [172] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [16] 
L9:     aload_2 
L10:    getfield [16] 
L13:    if_icmpne L42 
L16:    aload_0 
L17:    getfield [17] 
L20:    aload_2 
L21:    getfield [17] 
L24:    if_icmpne L42 
L27:    aload_0 
L28:    getfield [18] 
L31:    aload_2 
L32:    getfield [18] 
L35:    if_icmpne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private enum [183] : [184] 
    .attribute [172] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [172] .code stack 2 locals 1 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [26] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [19] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [19] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [16] 
L27:    invokevirtual [20] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [19] 
L37:    pop 
L38:    aload_1 
L39:    aload_0 
L40:    getfield [17] 
L43:    invokevirtual [20] 
L46:    pop 
L47:    aload_1 
L48:    ldc [7] 
L50:    invokevirtual [19] 
L53:    pop 
L54:    aload_0 
L55:    getfield [18] 
L58:    tableswitch 0 
            L84 
            L94 
            L104 
            default : L114 

L84:    aload_1 
L85:    ldc [8] 
L87:    invokevirtual [19] 
L90:    pop 
L91:    goto L121 
L94:    aload_1 
L95:    ldc [9] 
L97:    invokevirtual [19] 
L100:   pop 
L101:   goto L121 
L104:   aload_1 
L105:   ldc [10] 
L107:   invokevirtual [19] 
L110:   pop 
L111:   goto L121 
L114:   aload_1 
L115:   ldc [11] 
L117:   invokevirtual [19] 
L120:   pop 
L121:   aload_1 
L122:   invokevirtual [21] 
L125:   areturn 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [172] .code stack 1 locals 1 
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

.method public [189] : [190] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     i2s 
L6:     invokeinterface [31] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [17] 
L16:    i2s 
L17:    invokeinterface [31] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [18] 
L27:    i2b 
L28:    invokeinterface [32] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [172] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [33] 0 
L7:     putfield [27] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [33] 0 
L17:    putfield [28] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [34] 0 
L27:    putfield [29] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [193] : [194] 
    .attribute [172] .code stack 1 locals 0 
L0:     bipush 54 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [172] .code stack 1 locals 0 
L0:     invokestatic [12] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = String [37] 
.const [5] = String [38] 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = String [41] 
.const [9] = String [42] 
.const [10] = String [43] 
.const [11] = String [44] 
.const [12] = Method [45] [46] 
.const [13] = Class [47] 
.const [14] = Class [48] 
.const [15] = Method [49] [50] 
.const [16] = Field [51] [52] 
.const [17] = Field [53] [54] 
.const [18] = Field [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Class [79] 
.const [31] = InterfaceMethod [80] [81] 
.const [32] = InterfaceMethod [82] [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = InterfaceMethod [86] [87] 
.const [35] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [36] = Utf8 java/lang/StringBuffer 
.const [37] = Utf8 'GetNextListPos_StartResult:' 
.const [38] = Utf8 '\n - currentPos - ' 
.const [39] = Utf8 '\n - Offset - ' 
.const [40] = Utf8 '\n - ListType: ' 
.const [41] = Utf8 '0x00 (phone book)' 
.const [42] = Utf8 '0x01 (combined numbers (DF4.3))' 
.const [43] = Utf8 '0x02 (favorite list (DF4.3))' 
.const [44] = Utf8 'UNKNOWN ENUM' 
.const [45] = Class [88] 
.const [46] = NameAndType [89] [90] 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [49] = Class [91] 
.const [50] = NameAndType [92] [93] 
.const [51] = Class [94] 
.const [52] = NameAndType [95] [96] 
.const [53] = Class [97] 
.const [54] = NameAndType [98] [99] 
.const [55] = Class [100] 
.const [56] = NameAndType [101] [102] 
.const [57] = Class [103] 
.const [58] = NameAndType [104] [105] 
.const [59] = Class [106] 
.const [60] = NameAndType [107] [108] 
.const [61] = Class [109] 
.const [62] = NameAndType [110] [111] 
.const [63] = Class [112] 
.const [64] = NameAndType [113] [114] 
.const [65] = Class [115] 
.const [66] = NameAndType [116] [117] 
.const [67] = Class [118] 
.const [68] = NameAndType [119] [120] 
.const [69] = Class [121] 
.const [70] = NameAndType [122] [123] 
.const [71] = Class [124] 
.const [72] = NameAndType [125] [126] 
.const [73] = Class [127] 
.const [74] = NameAndType [128] [129] 
.const [75] = Class [130] 
.const [76] = NameAndType [131] [132] 
.const [77] = Class [133] 
.const [78] = NameAndType [134] [135] 
.const [79] = Utf8 java/lang/StringBuffer 
.const [80] = Class [136] 
.const [81] = NameAndType [137] [138] 
.const [82] = Class [139] 
.const [83] = NameAndType [140] [141] 
.const [84] = Class [142] 
.const [85] = NameAndType [143] [144] 
.const [86] = Class [145] 
.const [87] = NameAndType [146] [147] 
.const [88] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [89] = Utf8 functionId 
.const [90] = Utf8 ()I 
.const [91] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [92] = Utf8 deserialize 
.const [93] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [94] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [95] = Utf8 currentPos 
.const [96] = Utf8 I 
.const [97] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [98] = Utf8 offset 
.const [99] = Utf8 I 
.const [100] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [101] = Utf8 listType 
.const [102] = Utf8 I 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 append 
.const [105] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [106] = Utf8 java/lang/StringBuffer 
.const [107] = Utf8 append 
.const [108] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [109] = Utf8 java/lang/StringBuffer 
.const [110] = Utf8 toString 
.const [111] = Utf8 ()Ljava/lang/String; 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [116] = Utf8 internalReset 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [119] = Utf8 customInitialization 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [122] = Utf8 <init> 
.const [123] = Utf8 ()V 
.const [124] = Utf8 java/lang/StringBuffer 
.const [125] = Utf8 <init> 
.const [126] = Utf8 ()V 
.const [127] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [128] = Utf8 currentPos 
.const [129] = Utf8 I 
.const [130] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [131] = Utf8 offset 
.const [132] = Utf8 I 
.const [133] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [134] = Utf8 listType 
.const [135] = Utf8 I 
.const [136] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [137] = Utf8 pushShort 
.const [138] = Utf8 (S)V 
.const [139] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [140] = Utf8 pushByte 
.const [141] = Utf8 (B)V 
.const [142] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [143] = Utf8 popFrontShort 
.const [144] = Utf8 ()I 
.const [145] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [146] = Utf8 popFrontByte 
.const [147] = Utf8 ()I 
.const [148] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_StartResult 
.const [149] = Class [148] 
.const [150] = Utf8 java/lang/Object 
.const [151] = Class [150] 
.const [152] = Utf8 de/vw/mib/bap/requests/StartResultMethod 
.const [153] = Class [152] 
.const [154] = Utf8 currentPos 
.const [155] = Utf8 I 
.const [156] = Utf8 CURRENT_POS_BITSIZE 
.const [157] = Utf8 I 
.const [158] = Utf8 offset 
.const [159] = Utf8 I 
.const [160] = Utf8 OFFSET_BITSIZE 
.const [161] = Utf8 I 
.const [162] = Utf8 listType 
.const [163] = Utf8 I 
.const [164] = Utf8 LIST_TYPE_BITSIZE 
.const [165] = Utf8 I 
.const [166] = Utf8 LIST_TYPE_PHONE_BOOK 
.const [167] = Utf8 I 
.const [168] = Utf8 LIST_TYPE_COMBINED_NUMBERS_DF4_3 
.const [169] = Utf8 I 
.const [170] = Utf8 LIST_TYPE_FAVORITE_LIST_DF4_3 
.const [171] = Utf8 I 
.const [172] = Utf8 Code 
.const [173] = Utf8 <init> 
.const [174] = Utf8 ()V 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [177] = Utf8 internalReset 
.const [178] = Utf8 ()V 
.const [179] = Utf8 reset 
.const [180] = Utf8 ()V 
.const [181] = Utf8 equalTo 
.const [182] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [183] = Utf8 customInitialization 
.const [184] = Utf8 ()V 
.const [185] = Utf8 toString 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 bitSize 
.const [188] = Utf8 ()I 
.const [189] = Utf8 serialize 
.const [190] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [191] = Utf8 deserialize 
.const [192] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [193] = Utf8 functionId 
.const [194] = Utf8 ()I 
.const [195] = Utf8 getFunctionId 
.const [196] = Utf8 ()I 
.end class 
