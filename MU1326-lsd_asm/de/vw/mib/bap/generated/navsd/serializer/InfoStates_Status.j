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

.method public [139] : [140] 
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

.method public [141] : [142] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [143] : [144] 
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

.method public [145] : [146] 
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

.method public [147] : [148] 
    .attribute [138] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [19] 
L9:     aload_2 
L10:    getfield [19] 
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

.method private enum [149] : [150] 
    .attribute [138] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [151] : [152] 
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
L23:    getfield [19] 
L26:    lookupswitch 
            0 : L100 
            1 : L110 
            2 : L120 
            3 : L130 
            4 : L140 
            5 : L150 
            6 : L160 
            255 : L170 
            default : L180 

L100:   aload_1 
L101:   ldc [6] 
L103:   invokevirtual [20] 
L106:   pop 
L107:   goto L187 
L110:   aload_1 
L111:   ldc [7] 
L113:   invokevirtual [20] 
L116:   pop 
L117:   goto L187 
L120:   aload_1 
L121:   ldc [8] 
L123:   invokevirtual [20] 
L126:   pop 
L127:   goto L187 
L130:   aload_1 
L131:   ldc [9] 
L133:   invokevirtual [20] 
L136:   pop 
L137:   goto L187 
L140:   aload_1 
L141:   ldc [10] 
L143:   invokevirtual [20] 
L146:   pop 
L147:   goto L187 
L150:   aload_1 
L151:   ldc [11] 
L153:   invokevirtual [20] 
L156:   pop 
L157:   goto L187 
L160:   aload_1 
L161:   ldc [12] 
L163:   invokevirtual [20] 
L166:   pop 
L167:   goto L187 
L170:   aload_1 
L171:   ldc [13] 
L173:   invokevirtual [20] 
L176:   pop 
L177:   goto L187 
L180:   aload_1 
L181:   ldc [14] 
L183:   invokevirtual [20] 
L186:   pop 
L187:   aload_1 
L188:   invokevirtual [21] 
L191:   areturn 
L192:   
    .end code 
.end method 

.method public [153] : [154] 
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

.method public [155] : [156] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [19] 
L5:     i2b 
L6:     invokeinterface [29] 0 
L11:    return 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
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

.method public static [159] : [160] 
    .attribute [138] .code stack 1 locals 0 
L0:     bipush 38 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [161] : [162] 
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
.const [18] = Method [48] [49] 
.const [19] = Field [50] [51] 
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
.const [31] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [32] = Utf8 java/lang/StringBuffer 
.const [33] = Utf8 'InfoStates_Status:' 
.const [34] = Utf8 '\n - States: ' 
.const [35] = Utf8 '0x00 (no error/no information)' 
.const [36] = Utf8 '0x01 (no navigation data medium inserted)' 
.const [37] = Utf8 '0x02 (navigation database corrupted)' 
.const [38] = Utf8 '0x03 (no GPS signal available)' 
.const [39] = Utf8 '0x04 (navigation database update ongoing/in progress (DF4.1))' 
.const [40] = Utf8 '0x05 (Initializing MOST Map (DF4.2))' 
.const [41] = Utf8 '0x06 (Navigation in mobile device active (DF 4.3))' 
.const [42] = Utf8 '0xFF (unknown )' 
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
.const [73] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [74] = Utf8 functionId 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [77] = Utf8 deserialize 
.const [78] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [79] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [80] = Utf8 states 
.const [81] = Utf8 I 
.const [82] = Utf8 java/lang/StringBuffer 
.const [83] = Utf8 append 
.const [84] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 toString 
.const [87] = Utf8 ()Ljava/lang/String; 
.const [88] = Utf8 java/lang/Object 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [92] = Utf8 internalReset 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [95] = Utf8 customInitialization 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [98] = Utf8 <init> 
.const [99] = Utf8 ()V 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [104] = Utf8 states 
.const [105] = Utf8 I 
.const [106] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [107] = Utf8 pushByte 
.const [108] = Utf8 (B)V 
.const [109] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [110] = Utf8 popFrontByte 
.const [111] = Utf8 ()I 
.const [112] = Utf8 de/vw/mib/bap/generated/navsd/serializer/InfoStates_Status 
.const [113] = Class [112] 
.const [114] = Utf8 java/lang/Object 
.const [115] = Class [114] 
.const [116] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [117] = Class [116] 
.const [118] = Utf8 states 
.const [119] = Utf8 I 
.const [120] = Utf8 STATES_BITSIZE 
.const [121] = Utf8 I 
.const [122] = Utf8 STATES_NO_ERROR_NO_INFORMATION 
.const [123] = Utf8 I 
.const [124] = Utf8 STATES_NO_NAVIGATION_DATA_MEDIUM_INSERTED 
.const [125] = Utf8 I 
.const [126] = Utf8 STATES_NAVIGATION_DATABASE_CORRUPTED 
.const [127] = Utf8 I 
.const [128] = Utf8 STATES_NO_GPS_SIGNAL_AVAILABLE 
.const [129] = Utf8 I 
.const [130] = Utf8 STATES_NAVIGATION_DATABASE_UPDATE_ONGOING_IN_PROGRESS_DF4_1 
.const [131] = Utf8 I 
.const [132] = Utf8 STATES_INITIALIZING_MOST_MAP_DF4_2 
.const [133] = Utf8 I 
.const [134] = Utf8 STATES_NAVIGATION_IN_MOBILE_DEVICE_ACTIVE_DF_4_3 
.const [135] = Utf8 I 
.const [136] = Utf8 STATES_UNKNOWN 
.const [137] = Utf8 I 
.const [138] = Utf8 Code 
.const [139] = Utf8 <init> 
.const [140] = Utf8 ()V 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [143] = Utf8 internalReset 
.const [144] = Utf8 ()V 
.const [145] = Utf8 reset 
.const [146] = Utf8 ()V 
.const [147] = Utf8 equalTo 
.const [148] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [149] = Utf8 customInitialization 
.const [150] = Utf8 ()V 
.const [151] = Utf8 toString 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 bitSize 
.const [154] = Utf8 ()I 
.const [155] = Utf8 serialize 
.const [156] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [157] = Utf8 deserialize 
.const [158] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [159] = Utf8 functionId 
.const [160] = Utf8 ()I 
.const [161] = Utf8 getFunctionId 
.const [162] = Utf8 ()I 
.end class 
