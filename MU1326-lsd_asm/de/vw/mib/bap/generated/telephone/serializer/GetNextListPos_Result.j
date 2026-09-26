.version 50 0 
.class public final super [165] 
.super [167] 
.implements [169] 
.field public [170] [171] 
.field private static final [172] [173] 
.field public static final [174] [175] 
.field public static final [176] [177] 
.field public static final [178] [179] 
.field public static final [180] [181] 
.field public [182] [183] 
.field private static final [184] [185] 
.field public [186] [187] 
.field private static final [188] [189] 
.field public [190] [191] 
.field private static final [192] [193] 

.method public interface [195] : [196] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     invokespecial [26] 
L8:     aload_0 
L9:     invokespecial [27] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [201] : [202] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [30] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [31] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [32] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [33] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [203] : [204] 
    .attribute [194] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [205] : [206] 
    .attribute [194] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [17] 
L9:     aload_2 
L10:    getfield [17] 
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_2 
L32:    getfield [20] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [21] 
L42:    aload_2 
L43:    getfield [21] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private enum [207] : [208] 
    .attribute [194] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [194] .code stack 2 locals 1 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [29] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [22] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [22] 
L21:    pop 
L22:    aload_0 
L23:    getfield [17] 
L26:    tableswitch 0 
            L56 
            L66 
            L76 
            L86 
            default : L96 

L56:    aload_1 
L57:    ldc [6] 
L59:    invokevirtual [22] 
L62:    pop 
L63:    goto L103 
L66:    aload_1 
L67:    ldc [7] 
L69:    invokevirtual [22] 
L72:    pop 
L73:    goto L103 
L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [22] 
L82:    pop 
L83:    goto L103 
L86:    aload_1 
L87:    ldc [9] 
L89:    invokevirtual [22] 
L92:    pop 
L93:    goto L103 
L96:    aload_1 
L97:    ldc [10] 
L99:    invokevirtual [22] 
L102:   pop 
L103:   aload_1 
L104:   ldc [11] 
L106:   invokevirtual [22] 
L109:   pop 
L110:   aload_1 
L111:   aload_0 
L112:   getfield [19] 
L115:   invokevirtual [23] 
L118:   pop 
L119:   aload_1 
L120:   ldc [12] 
L122:   invokevirtual [22] 
L125:   pop 
L126:   aload_1 
L127:   aload_0 
L128:   getfield [20] 
L131:   invokevirtual [23] 
L134:   pop 
L135:   aload_1 
L136:   ldc [13] 
L138:   invokevirtual [22] 
L141:   pop 
L142:   aload_1 
L143:   aload_0 
L144:   getfield [21] 
L147:   invokevirtual [23] 
L150:   pop 
L151:   aload_1 
L152:   invokevirtual [24] 
L155:   areturn 
L156:   
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [194] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 16 
L8:     iinc 1 16 
L11:    iinc 1 16 
L14:    iload_1 
L15:    areturn 
L16:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [17] 
L5:     i2b 
L6:     invokeinterface [35] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [19] 
L16:    i2s 
L17:    invokeinterface [36] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [20] 
L27:    i2s 
L28:    invokeinterface [36] 0 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [21] 
L38:    i2s 
L39:    invokeinterface [36] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [215] : [216] 
    .attribute [194] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [37] 0 
L7:     putfield [30] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [38] 0 
L17:    putfield [31] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [38] 0 
L27:    putfield [32] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [38] 0 
L37:    putfield [33] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [217] : [218] 
    .attribute [194] .code stack 1 locals 0 
L0:     bipush 54 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [194] .code stack 1 locals 0 
L0:     invokestatic [14] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [39] 
.const [3] = Class [40] 
.const [4] = String [41] 
.const [5] = String [42] 
.const [6] = String [43] 
.const [7] = String [44] 
.const [8] = String [45] 
.const [9] = String [46] 
.const [10] = String [47] 
.const [11] = String [48] 
.const [12] = String [49] 
.const [13] = String [50] 
.const [14] = Method [51] [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Field [55] [56] 
.const [18] = Method [57] [58] 
.const [19] = Field [59] [60] 
.const [20] = Field [61] [62] 
.const [21] = Field [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Field [87] [88] 
.const [34] = Class [89] 
.const [35] = InterfaceMethod [90] [91] 
.const [36] = InterfaceMethod [92] [93] 
.const [37] = InterfaceMethod [94] [95] 
.const [38] = InterfaceMethod [96] [97] 
.const [39] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [40] = Utf8 java/lang/StringBuffer 
.const [41] = Utf8 'GetNextListPos_Result:' 
.const [42] = Utf8 '\n - GetNextListPos_Result: ' 
.const [43] = Utf8 '0x00 (successful)' 
.const [44] = Utf8 '0x01 (not successful)' 
.const [45] = Utf8 '0x02 (abort successful)' 
.const [46] = Utf8 '0x03 (abort not successful)' 
.const [47] = Utf8 'UNKNOWN ENUM' 
.const [48] = Utf8 '\n - currentPos - ' 
.const [49] = Utf8 '\n - nextPos - ' 
.const [50] = Utf8 '\n - absoluteListPos - ' 
.const [51] = Class [98] 
.const [52] = NameAndType [99] [100] 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [55] = Class [101] 
.const [56] = NameAndType [102] [103] 
.const [57] = Class [104] 
.const [58] = NameAndType [105] [106] 
.const [59] = Class [107] 
.const [60] = NameAndType [108] [109] 
.const [61] = Class [110] 
.const [62] = NameAndType [111] [112] 
.const [63] = Class [113] 
.const [64] = NameAndType [114] [115] 
.const [65] = Class [116] 
.const [66] = NameAndType [117] [118] 
.const [67] = Class [119] 
.const [68] = NameAndType [120] [121] 
.const [69] = Class [122] 
.const [70] = NameAndType [123] [124] 
.const [71] = Class [125] 
.const [72] = NameAndType [126] [127] 
.const [73] = Class [128] 
.const [74] = NameAndType [129] [130] 
.const [75] = Class [131] 
.const [76] = NameAndType [132] [133] 
.const [77] = Class [134] 
.const [78] = NameAndType [135] [136] 
.const [79] = Class [137] 
.const [80] = NameAndType [138] [139] 
.const [81] = Class [140] 
.const [82] = NameAndType [141] [142] 
.const [83] = Class [143] 
.const [84] = NameAndType [144] [145] 
.const [85] = Class [146] 
.const [86] = NameAndType [147] [148] 
.const [87] = Class [149] 
.const [88] = NameAndType [150] [151] 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Class [152] 
.const [91] = NameAndType [153] [154] 
.const [92] = Class [155] 
.const [93] = NameAndType [156] [157] 
.const [94] = Class [158] 
.const [95] = NameAndType [159] [160] 
.const [96] = Class [161] 
.const [97] = NameAndType [162] [163] 
.const [98] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [99] = Utf8 functionId 
.const [100] = Utf8 ()I 
.const [101] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [102] = Utf8 getNextListPos_Result 
.const [103] = Utf8 I 
.const [104] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [105] = Utf8 deserialize 
.const [106] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [107] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [108] = Utf8 currentPos 
.const [109] = Utf8 I 
.const [110] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [111] = Utf8 nextPos 
.const [112] = Utf8 I 
.const [113] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [114] = Utf8 absoluteListPos 
.const [115] = Utf8 I 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 append 
.const [121] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 toString 
.const [124] = Utf8 ()Ljava/lang/String; 
.const [125] = Utf8 java/lang/Object 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [129] = Utf8 internalReset 
.const [130] = Utf8 ()V 
.const [131] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [132] = Utf8 customInitialization 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [135] = Utf8 <init> 
.const [136] = Utf8 ()V 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 <init> 
.const [139] = Utf8 ()V 
.const [140] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [141] = Utf8 getNextListPos_Result 
.const [142] = Utf8 I 
.const [143] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [144] = Utf8 currentPos 
.const [145] = Utf8 I 
.const [146] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [147] = Utf8 nextPos 
.const [148] = Utf8 I 
.const [149] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [150] = Utf8 absoluteListPos 
.const [151] = Utf8 I 
.const [152] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [153] = Utf8 pushByte 
.const [154] = Utf8 (B)V 
.const [155] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [156] = Utf8 pushShort 
.const [157] = Utf8 (S)V 
.const [158] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [159] = Utf8 popFrontByte 
.const [160] = Utf8 ()I 
.const [161] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [162] = Utf8 popFrontShort 
.const [163] = Utf8 ()I 
.const [164] = Utf8 de/vw/mib/bap/generated/telephone/serializer/GetNextListPos_Result 
.const [165] = Class [164] 
.const [166] = Utf8 java/lang/Object 
.const [167] = Class [166] 
.const [168] = Utf8 de/vw/mib/bap/requests/ResultMethod 
.const [169] = Class [168] 
.const [170] = Utf8 getNextListPos_Result 
.const [171] = Utf8 I 
.const [172] = Utf8 GET_NEXT_LIST_POS_RESULT_BITSIZE 
.const [173] = Utf8 I 
.const [174] = Utf8 GET_NEXT_LIST_POS_RESULT_SUCCESSFUL 
.const [175] = Utf8 I 
.const [176] = Utf8 GET_NEXT_LIST_POS_RESULT_NOT_SUCCESSFUL 
.const [177] = Utf8 I 
.const [178] = Utf8 GET_NEXT_LIST_POS_RESULT_ABORT_SUCCESSFUL 
.const [179] = Utf8 I 
.const [180] = Utf8 GET_NEXT_LIST_POS_RESULT_ABORT_NOT_SUCCESSFUL 
.const [181] = Utf8 I 
.const [182] = Utf8 currentPos 
.const [183] = Utf8 I 
.const [184] = Utf8 CURRENT_POS_BITSIZE 
.const [185] = Utf8 I 
.const [186] = Utf8 nextPos 
.const [187] = Utf8 I 
.const [188] = Utf8 NEXT_POS_BITSIZE 
.const [189] = Utf8 I 
.const [190] = Utf8 absoluteListPos 
.const [191] = Utf8 I 
.const [192] = Utf8 ABSOLUTE_LIST_POS_BITSIZE 
.const [193] = Utf8 I 
.const [194] = Utf8 Code 
.const [195] = Utf8 getResultCode 
.const [196] = Utf8 ()I 
.const [197] = Utf8 <init> 
.const [198] = Utf8 ()V 
.const [199] = Utf8 <init> 
.const [200] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [201] = Utf8 internalReset 
.const [202] = Utf8 ()V 
.const [203] = Utf8 reset 
.const [204] = Utf8 ()V 
.const [205] = Utf8 equalTo 
.const [206] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [207] = Utf8 customInitialization 
.const [208] = Utf8 ()V 
.const [209] = Utf8 toString 
.const [210] = Utf8 ()Ljava/lang/String; 
.const [211] = Utf8 bitSize 
.const [212] = Utf8 ()I 
.const [213] = Utf8 serialize 
.const [214] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [215] = Utf8 deserialize 
.const [216] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [217] = Utf8 functionId 
.const [218] = Utf8 ()I 
.const [219] = Utf8 getFunctionId 
.const [220] = Utf8 ()I 
.end class 
