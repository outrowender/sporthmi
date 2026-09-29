.version 50 0 
.class public final super [137] 
.super [139] 
.implements [141] 
.field public [142] [143] 
.field private static final [144] [145] 
.field public static final [146] [147] 
.field public static final [148] [149] 
.field public static final [150] [151] 
.field public static final [152] [153] 
.field public [154] [155] 
.field private static final [156] [157] 

.method public [159] : [160] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     invokespecial [22] 
L8:     aload_0 
L9:     invokespecial [23] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [26] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [27] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [158] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [158] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [16] 
L9:     aload_2 
L10:    getfield [16] 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    getfield [17] 
L20:    aload_2 
L21:    getfield [17] 
L24:    if_icmpne L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private enum [169] : [170] 
    .attribute [158] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [171] : [172] 
    .attribute [158] .code stack 2 locals 1 
L0:     new [28] 
L3:     dup 
L4:     invokespecial [25] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [18] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [18] 
L21:    pop 
L22:    aload_0 
L23:    getfield [16] 
L26:    tableswitch 0 
            L56 
            L66 
            L76 
            L86 
            default : L96 

L56:    aload_1 
L57:    ldc [6] 
L59:    invokevirtual [18] 
L62:    pop 
L63:    goto L103 
L66:    aload_1 
L67:    ldc [7] 
L69:    invokevirtual [18] 
L72:    pop 
L73:    goto L103 
L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [18] 
L82:    pop 
L83:    goto L103 
L86:    aload_1 
L87:    ldc [9] 
L89:    invokevirtual [18] 
L92:    pop 
L93:    goto L103 
L96:    aload_1 
L97:    ldc [10] 
L99:    invokevirtual [18] 
L102:   pop 
L103:   aload_1 
L104:   ldc [11] 
L106:   invokevirtual [18] 
L109:   pop 
L110:   aload_1 
L111:   aload_0 
L112:   getfield [17] 
L115:   invokevirtual [19] 
L118:   pop 
L119:   aload_1 
L120:   invokevirtual [20] 
L123:   areturn 
L124:   
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [158] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 16 
L8:     iload_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     i2b 
L6:     invokeinterface [29] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [17] 
L16:    i2s 
L17:    invokeinterface [30] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [158] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [31] 0 
L7:     putfield [26] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [32] 0 
L17:    putfield [27] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [179] : [180] 
    .attribute [158] .code stack 1 locals 0 
L0:     bipush 22 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [158] .code stack 1 locals 0 
L0:     invokestatic [12] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Class [34] 
.const [4] = String [35] 
.const [5] = String [36] 
.const [6] = String [37] 
.const [7] = String [38] 
.const [8] = String [39] 
.const [9] = String [40] 
.const [10] = String [41] 
.const [11] = String [42] 
.const [12] = Method [43] [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Method [47] [48] 
.const [16] = Field [49] [50] 
.const [17] = Field [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Method [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Method [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Field [69] [70] 
.const [27] = Field [71] [72] 
.const [28] = Class [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = InterfaceMethod [80] [81] 
.const [33] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 'EmailState_Status:' 
.const [36] = Utf8 '\n - StorageState: ' 
.const [37] = Utf8 '0x00 (Email storage available)' 
.const [38] = Utf8 '0x01 (Email storage full)' 
.const [39] = Utf8 '0x02 (Email storage full, Email pending_1)' 
.const [40] = Utf8 '0x03 (Email storage full, Email pending_2)' 
.const [41] = Utf8 'UNKNOWN ENUM' 
.const [42] = Utf8 '\n - NumberOfNewEmail - ' 
.const [43] = Class [82] 
.const [44] = NameAndType [83] [84] 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Class [127] 
.const [77] = NameAndType [128] [129] 
.const [78] = Class [130] 
.const [79] = NameAndType [131] [132] 
.const [80] = Class [133] 
.const [81] = NameAndType [134] [135] 
.const [82] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [83] = Utf8 functionId 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [86] = Utf8 deserialize 
.const [87] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [88] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [89] = Utf8 storageState 
.const [90] = Utf8 I 
.const [91] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [92] = Utf8 numberOfNewEmail 
.const [93] = Utf8 I 
.const [94] = Utf8 java/lang/StringBuffer 
.const [95] = Utf8 append 
.const [96] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [97] = Utf8 java/lang/StringBuffer 
.const [98] = Utf8 append 
.const [99] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [100] = Utf8 java/lang/StringBuffer 
.const [101] = Utf8 toString 
.const [102] = Utf8 ()Ljava/lang/String; 
.const [103] = Utf8 java/lang/Object 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [107] = Utf8 internalReset 
.const [108] = Utf8 ()V 
.const [109] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [110] = Utf8 customInitialization 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Utf8 <init> 
.const [117] = Utf8 ()V 
.const [118] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [119] = Utf8 storageState 
.const [120] = Utf8 I 
.const [121] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [122] = Utf8 numberOfNewEmail 
.const [123] = Utf8 I 
.const [124] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [125] = Utf8 pushByte 
.const [126] = Utf8 (B)V 
.const [127] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [128] = Utf8 pushShort 
.const [129] = Utf8 (S)V 
.const [130] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [131] = Utf8 popFrontByte 
.const [132] = Utf8 ()I 
.const [133] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [134] = Utf8 popFrontShort 
.const [135] = Utf8 ()I 
.const [136] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/EmailState_Status 
.const [137] = Class [136] 
.const [138] = Utf8 java/lang/Object 
.const [139] = Class [138] 
.const [140] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [141] = Class [140] 
.const [142] = Utf8 storageState 
.const [143] = Utf8 I 
.const [144] = Utf8 STORAGE_STATE_BITSIZE 
.const [145] = Utf8 I 
.const [146] = Utf8 STORAGE_STATE_EMAIL_STORAGE_AVAILABLE 
.const [147] = Utf8 I 
.const [148] = Utf8 STORAGE_STATE_EMAIL_STORAGE_FULL 
.const [149] = Utf8 I 
.const [150] = Utf8 STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_1 
.const [151] = Utf8 I 
.const [152] = Utf8 STORAGE_STATE_EMAIL_STORAGE_FULL_EMAIL_PENDING_2 
.const [153] = Utf8 I 
.const [154] = Utf8 numberOfNewEmail 
.const [155] = Utf8 I 
.const [156] = Utf8 NUMBER_OF_NEW_EMAIL_BITSIZE 
.const [157] = Utf8 I 
.const [158] = Utf8 Code 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 <init> 
.const [162] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [163] = Utf8 internalReset 
.const [164] = Utf8 ()V 
.const [165] = Utf8 reset 
.const [166] = Utf8 ()V 
.const [167] = Utf8 equalTo 
.const [168] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [169] = Utf8 customInitialization 
.const [170] = Utf8 ()V 
.const [171] = Utf8 toString 
.const [172] = Utf8 ()Ljava/lang/String; 
.const [173] = Utf8 bitSize 
.const [174] = Utf8 ()I 
.const [175] = Utf8 serialize 
.const [176] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [177] = Utf8 deserialize 
.const [178] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [179] = Utf8 functionId 
.const [180] = Utf8 ()I 
.const [181] = Utf8 getFunctionId 
.const [182] = Utf8 ()I 
.end class 
