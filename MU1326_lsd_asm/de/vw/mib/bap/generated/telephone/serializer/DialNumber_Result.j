.version 50 0 
.class public final super [113] 
.super [115] 
.implements [117] 
.field public [118] [119] 
.field private static final [120] [121] 
.field public static final [122] [123] 
.field public static final [124] [125] 
.field public static final [126] [127] 
.field public static final [128] [129] 
.field public static final [130] [131] 
.field public static final [132] [133] 
.field public static final [134] [135] 
.field public static final [136] [137] 

.method public interface [139] : [140] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [138] .code stack 1 locals 0 
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

.method public [143] : [144] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [138] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method private enum [151] : [152] 
    .attribute [138] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [138] .code stack 2 locals 1 
L0:     new [28] 
L3:     dup 
L4:     invokespecial [26] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [20] 
L21:    pop 
L22:    aload_0 
L23:    getfield [18] 
L26:    tableswitch 0 
            L92 
            L102 
            L112 
            L122 
            L132 
            L142 
            L172 
            L172 
            L172 
            L172 
            L152 
            L172 
            L162 
            default : L172 

L92:    aload_1 
L93:    ldc [6] 
L95:    invokevirtual [20] 
L98:    pop 
L99:    goto L179 
L102:   aload_1 
L103:   ldc [7] 
L105:   invokevirtual [20] 
L108:   pop 
L109:   goto L179 
L112:   aload_1 
L113:   ldc [8] 
L115:   invokevirtual [20] 
L118:   pop 
L119:   goto L179 
L122:   aload_1 
L123:   ldc [9] 
L125:   invokevirtual [20] 
L128:   pop 
L129:   goto L179 
L132:   aload_1 
L133:   ldc [10] 
L135:   invokevirtual [20] 
L138:   pop 
L139:   goto L179 
L142:   aload_1 
L143:   ldc [11] 
L145:   invokevirtual [20] 
L148:   pop 
L149:   goto L179 
L152:   aload_1 
L153:   ldc [12] 
L155:   invokevirtual [20] 
L158:   pop 
L159:   goto L179 
L162:   aload_1 
L163:   ldc [13] 
L165:   invokevirtual [20] 
L168:   pop 
L169:   goto L179 
L172:   aload_1 
L173:   ldc [14] 
L175:   invokevirtual [20] 
L178:   pop 
L179:   aload_1 
L180:   invokevirtual [21] 
L183:   areturn 
L184:   
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [138] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     i2b 
L6:     invokeinterface [29] 0 
L11:    return 
L12:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [30] 0 
L7:     putfield [27] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [161] : [162] 
    .attribute [138] .code stack 1 locals 0 
L0:     bipush 26 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [138] .code stack 1 locals 0 
L0:     invokestatic [15] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Class [32] 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = String [37] 
.const [9] = String [38] 
.const [10] = String [39] 
.const [11] = String [40] 
.const [12] = String [41] 
.const [13] = String [42] 
.const [14] = String [43] 
.const [15] = Method [44] [45] 
.const [16] = Class [46] 
.const [17] = Class [47] 
.const [18] = Field [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Method [58] [59] 
.const [24] = Method [60] [61] 
.const [25] = Method [62] [63] 
.const [26] = Method [64] [65] 
.const [27] = Field [66] [67] 
.const [28] = Class [68] 
.const [29] = InterfaceMethod [69] [70] 
.const [30] = InterfaceMethod [71] [72] 
.const [31] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [32] = Utf8 java/lang/StringBuffer 
.const [33] = Utf8 'DialNumber_Result:' 
.const [34] = Utf8 '\n - DialNumber_Result: ' 
.const [35] = Utf8 '0x00 (successful)' 
.const [36] = Utf8 '0x01 (not successful)' 
.const [37] = Utf8 '0x02 (abort successful)' 
.const [38] = Utf8 '0x03 (abort not successful)' 
.const [39] = Utf8 '0x04 (not successful - number invalid)' 
.const [40] = Utf8 '0x05 (not successful - no network)' 
.const [41] = Utf8 '0x0A (not successful - confirm emergency call)' 
.const [42] = Utf8 '0x0C (not successful - automatic redial active)' 
.const [43] = Utf8 'UNKNOWN ENUM' 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [48] = Class [76] 
.const [49] = NameAndType [77] [78] 
.const [50] = Class [79] 
.const [51] = NameAndType [80] [81] 
.const [52] = Class [82] 
.const [53] = NameAndType [83] [84] 
.const [54] = Class [85] 
.const [55] = NameAndType [86] [87] 
.const [56] = Class [88] 
.const [57] = NameAndType [89] [90] 
.const [58] = Class [91] 
.const [59] = NameAndType [92] [93] 
.const [60] = Class [94] 
.const [61] = NameAndType [95] [96] 
.const [62] = Class [97] 
.const [63] = NameAndType [98] [99] 
.const [64] = Class [100] 
.const [65] = NameAndType [101] [102] 
.const [66] = Class [103] 
.const [67] = NameAndType [104] [105] 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Class [106] 
.const [70] = NameAndType [107] [108] 
.const [71] = Class [109] 
.const [72] = NameAndType [110] [111] 
.const [73] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [74] = Utf8 functionId 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [77] = Utf8 dialNumber_Result 
.const [78] = Utf8 I 
.const [79] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [80] = Utf8 deserialize 
.const [81] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 toString 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [92] = Utf8 internalReset 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [95] = Utf8 customInitialization 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [104] = Utf8 dialNumber_Result 
.const [105] = Utf8 I 
.const [106] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [107] = Utf8 pushByte 
.const [108] = Utf8 (B)V 
.const [109] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [110] = Utf8 popFrontByte 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/vw/mib/bap/generated/telephone/serializer/DialNumber_Result 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 de/vw/mib/bap/requests/ResultMethod 
.const [117] = Class [116] 
.const [118] = Utf8 dialNumber_Result 
.const [119] = Utf8 I 
.const [120] = Utf8 DIAL_NUMBER_RESULT_BITSIZE 
.const [121] = Utf8 I 
.const [122] = Utf8 DIAL_NUMBER_RESULT_SUCCESSFUL 
.const [123] = Utf8 I 
.const [124] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL 
.const [125] = Utf8 I 
.const [126] = Utf8 DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL 
.const [127] = Utf8 I 
.const [128] = Utf8 DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL 
.const [129] = Utf8 I 
.const [130] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID 
.const [131] = Utf8 I 
.const [132] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK 
.const [133] = Utf8 I 
.const [134] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL 
.const [135] = Utf8 I 
.const [136] = Utf8 DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE 
.const [137] = Utf8 I 
.const [138] = Utf8 Code 
.const [139] = Utf8 getResultCode 
.const [140] = Utf8 ()I 
.const [141] = Utf8 <init> 
.const [142] = Utf8 ()V 
.const [143] = Utf8 <init> 
.const [144] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [145] = Utf8 internalReset 
.const [146] = Utf8 ()V 
.const [147] = Utf8 reset 
.const [148] = Utf8 ()V 
.const [149] = Utf8 equalTo 
.const [150] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [151] = Utf8 customInitialization 
.const [152] = Utf8 ()V 
.const [153] = Utf8 toString 
.const [154] = Utf8 ()Ljava/lang/String; 
.const [155] = Utf8 bitSize 
.const [156] = Utf8 ()I 
.const [157] = Utf8 serialize 
.const [158] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [159] = Utf8 deserialize 
.const [160] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [161] = Utf8 functionId 
.const [162] = Utf8 ()I 
.const [163] = Utf8 getFunctionId 
.const [164] = Utf8 ()I 
.end class 
