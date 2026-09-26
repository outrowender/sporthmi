.version 50 0 
.class public final super [145] 
.super [147] 
.implements [149] 
.field public [150] [151] 
.field private static final [152] [153] 
.field public static final [154] [155] 
.field public static final [156] [157] 
.field public static final [158] [159] 
.field public static final [160] [161] 
.field public [162] [163] 
.field private static final [164] [165] 
.field public [166] [167] 
.field private static final [168] [169] 
.field public static final [170] [171] 
.field public static final [172] [173] 
.field public static final [174] [175] 

.method public [177] : [178] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     invokespecial [27] 
L8:     aload_0 
L9:     invokespecial [28] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [179] : [180] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [29] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [19] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [181] : [182] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [31] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [32] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [33] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [176] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [176] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [20] 
L9:     aload_2 
L10:    getfield [20] 
L13:    if_icmpne L42 
L16:    aload_0 
L17:    getfield [21] 
L20:    aload_2 
L21:    getfield [21] 
L24:    if_icmpne L42 
L27:    aload_0 
L28:    getfield [22] 
L31:    aload_2 
L32:    getfield [22] 
L35:    if_icmpne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private enum [187] : [188] 
    .attribute [176] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [176] .code stack 2 locals 1 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [30] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [23] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [23] 
L21:    pop 
L22:    aload_0 
L23:    getfield [20] 
L26:    tableswitch 0 
            L56 
            L66 
            L76 
            L86 
            default : L96 

L56:    aload_1 
L57:    ldc [6] 
L59:    invokevirtual [23] 
L62:    pop 
L63:    goto L103 
L66:    aload_1 
L67:    ldc [7] 
L69:    invokevirtual [23] 
L72:    pop 
L73:    goto L103 
L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [23] 
L82:    pop 
L83:    goto L103 
L86:    aload_1 
L87:    ldc [9] 
L89:    invokevirtual [23] 
L92:    pop 
L93:    goto L103 
L96:    aload_1 
L97:    ldc [10] 
L99:    invokevirtual [23] 
L102:   pop 
L103:   aload_1 
L104:   ldc [11] 
L106:   invokevirtual [23] 
L109:   pop 
L110:   aload_1 
L111:   aload_0 
L112:   getfield [21] 
L115:   invokevirtual [24] 
L118:   pop 
L119:   aload_1 
L120:   ldc [12] 
L122:   invokevirtual [23] 
L125:   pop 
L126:   aload_0 
L127:   getfield [22] 
L130:   lookupswitch 
            0 : L164 
            1 : L174 
            255 : L184 
            default : L194 

L164:   aload_1 
L165:   ldc [13] 
L167:   invokevirtual [23] 
L170:   pop 
L171:   goto L201 
L174:   aload_1 
L175:   ldc [14] 
L177:   invokevirtual [23] 
L180:   pop 
L181:   goto L201 
L184:   aload_1 
L185:   ldc [15] 
L187:   invokevirtual [23] 
L190:   pop 
L191:   goto L201 
L194:   aload_1 
L195:   ldc [10] 
L197:   invokevirtual [23] 
L200:   pop 
L201:   aload_1 
L202:   invokevirtual [25] 
L205:   areturn 
L206:   nop 
L207:   nop 
L208:   
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [176] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iinc 1 8 
L11:    iload_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [20] 
L5:     i2b 
L6:     invokeinterface [35] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [21] 
L16:    i2b 
L17:    invokeinterface [35] 0 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [22] 
L27:    i2b 
L28:    invokeinterface [35] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [36] 0 
L7:     putfield [31] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [36] 0 
L17:    putfield [32] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [36] 0 
L27:    putfield [33] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [197] : [198] 
    .attribute [176] .code stack 1 locals 0 
L0:     bipush 48 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [199] : [200] 
    .attribute [176] .code stack 1 locals 0 
L0:     invokestatic [16] 
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
.const [14] = String [49] 
.const [15] = String [50] 
.const [16] = Method [51] [52] 
.const [17] = Class [53] 
.const [18] = Class [54] 
.const [19] = Method [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Field [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = Field [79] [80] 
.const [32] = Field [81] [82] 
.const [33] = Field [83] [84] 
.const [34] = Class [85] 
.const [35] = InterfaceMethod [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 'OnlineNavigationState_Status:' 
.const [40] = Utf8 '\n - State: ' 
.const [41] = Utf8 '0x00 (off)' 
.const [42] = Utf8 '0x01 (init/loading)' 
.const [43] = Utf8 '0x02 (active)' 
.const [44] = Utf8 '0x03 (no data connection)' 
.const [45] = Utf8 'UNKNOWN ENUM' 
.const [46] = Utf8 '\n - Progress - ' 
.const [47] = Utf8 '\n - OnlineNavigationSystem: ' 
.const [48] = Utf8 '0x00 (online navigation not built-in)' 
.const [49] = Utf8 '0x01 (GOOGLE navigation)' 
.const [50] = Utf8 '0xFF (unknown technical system for online navigation)' 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [55] = Class [93] 
.const [56] = NameAndType [94] [95] 
.const [57] = Class [96] 
.const [58] = NameAndType [97] [98] 
.const [59] = Class [99] 
.const [60] = NameAndType [100] [101] 
.const [61] = Class [102] 
.const [62] = NameAndType [103] [104] 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Class [114] 
.const [70] = NameAndType [115] [116] 
.const [71] = Class [117] 
.const [72] = NameAndType [118] [119] 
.const [73] = Class [120] 
.const [74] = NameAndType [121] [122] 
.const [75] = Class [123] 
.const [76] = NameAndType [124] [125] 
.const [77] = Class [126] 
.const [78] = NameAndType [127] [128] 
.const [79] = Class [129] 
.const [80] = NameAndType [130] [131] 
.const [81] = Class [132] 
.const [82] = NameAndType [133] [134] 
.const [83] = Class [135] 
.const [84] = NameAndType [136] [137] 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Class [138] 
.const [87] = NameAndType [139] [140] 
.const [88] = Class [141] 
.const [89] = NameAndType [142] [143] 
.const [90] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [91] = Utf8 functionId 
.const [92] = Utf8 ()I 
.const [93] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [94] = Utf8 deserialize 
.const [95] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [96] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [97] = Utf8 state 
.const [98] = Utf8 I 
.const [99] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [100] = Utf8 progress 
.const [101] = Utf8 I 
.const [102] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [103] = Utf8 onlineNavigationSystem 
.const [104] = Utf8 I 
.const [105] = Utf8 java/lang/StringBuffer 
.const [106] = Utf8 append 
.const [107] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [108] = Utf8 java/lang/StringBuffer 
.const [109] = Utf8 append 
.const [110] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 toString 
.const [113] = Utf8 ()Ljava/lang/String; 
.const [114] = Utf8 java/lang/Object 
.const [115] = Utf8 <init> 
.const [116] = Utf8 ()V 
.const [117] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [118] = Utf8 internalReset 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [121] = Utf8 customInitialization 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [124] = Utf8 <init> 
.const [125] = Utf8 ()V 
.const [126] = Utf8 java/lang/StringBuffer 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [130] = Utf8 state 
.const [131] = Utf8 I 
.const [132] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [133] = Utf8 progress 
.const [134] = Utf8 I 
.const [135] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [136] = Utf8 onlineNavigationSystem 
.const [137] = Utf8 I 
.const [138] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [139] = Utf8 pushByte 
.const [140] = Utf8 (B)V 
.const [141] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [142] = Utf8 popFrontByte 
.const [143] = Utf8 ()I 
.const [144] = Utf8 de/vw/mib/bap/generated/navsd/serializer/OnlineNavigationState_Status 
.const [145] = Class [144] 
.const [146] = Utf8 java/lang/Object 
.const [147] = Class [146] 
.const [148] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [149] = Class [148] 
.const [150] = Utf8 state 
.const [151] = Utf8 I 
.const [152] = Utf8 STATE_BITSIZE 
.const [153] = Utf8 I 
.const [154] = Utf8 STATE_OFF 
.const [155] = Utf8 I 
.const [156] = Utf8 STATE_INIT_LOADING 
.const [157] = Utf8 I 
.const [158] = Utf8 STATE_ACTIVE 
.const [159] = Utf8 I 
.const [160] = Utf8 STATE_NO_DATA_CONNECTION 
.const [161] = Utf8 I 
.const [162] = Utf8 progress 
.const [163] = Utf8 I 
.const [164] = Utf8 PROGRESS_BITSIZE 
.const [165] = Utf8 I 
.const [166] = Utf8 onlineNavigationSystem 
.const [167] = Utf8 I 
.const [168] = Utf8 ONLINE_NAVIGATION_SYSTEM_BITSIZE 
.const [169] = Utf8 I 
.const [170] = Utf8 ONLINE_NAVIGATION_SYSTEM_ONLINE_NAVIGATION_NOT_BUILT_IN 
.const [171] = Utf8 I 
.const [172] = Utf8 ONLINE_NAVIGATION_SYSTEM_GOOGLE_NAVIGATION 
.const [173] = Utf8 I 
.const [174] = Utf8 ONLINE_NAVIGATION_SYSTEM_UNKNOWN_TECHNICAL_SYSTEM_FOR_ONLINE_NAVIGATION 
.const [175] = Utf8 I 
.const [176] = Utf8 Code 
.const [177] = Utf8 <init> 
.const [178] = Utf8 ()V 
.const [179] = Utf8 <init> 
.const [180] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [181] = Utf8 internalReset 
.const [182] = Utf8 ()V 
.const [183] = Utf8 reset 
.const [184] = Utf8 ()V 
.const [185] = Utf8 equalTo 
.const [186] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [187] = Utf8 customInitialization 
.const [188] = Utf8 ()V 
.const [189] = Utf8 toString 
.const [190] = Utf8 ()Ljava/lang/String; 
.const [191] = Utf8 bitSize 
.const [192] = Utf8 ()I 
.const [193] = Utf8 serialize 
.const [194] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [195] = Utf8 deserialize 
.const [196] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [197] = Utf8 functionId 
.const [198] = Utf8 ()I 
.const [199] = Utf8 getFunctionId 
.const [200] = Utf8 ()I 
.end class 
