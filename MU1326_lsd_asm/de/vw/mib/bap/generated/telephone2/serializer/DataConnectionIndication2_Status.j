.version 50 0 
.class public final super [147] 
.super [149] 
.implements [151] 
.field public [152] [153] 
.field private static final [154] [155] 
.field public static final [156] [157] 
.field public static final [158] [159] 
.field public [160] [161] 
.field private static final [162] [163] 
.field public [164] [165] 
.field private static final [166] [167] 

.method public [169] : [170] 
    .attribute [168] .code stack 1 locals 0 
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

.method public [171] : [172] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [173] : [174] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [26] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [27] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [28] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [168] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [168] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [15] 
L9:     aload_2 
L10:    getfield [15] 
L13:    if_icmpne L42 
L16:    aload_0 
L17:    getfield [16] 
L20:    aload_2 
L21:    getfield [16] 
L24:    if_icmpne L42 
L27:    aload_0 
L28:    getfield [17] 
L31:    aload_2 
L32:    getfield [17] 
L35:    if_icmpne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method private enum [179] : [180] 
    .attribute [168] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [181] : [182] 
    .attribute [168] .code stack 2 locals 1 
L0:     new [29] 
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
L23:    getfield [15] 
L26:    lookupswitch 
            0 : L52 
            1 : L62 
            default : L72 

L52:    aload_1 
L53:    ldc [6] 
L55:    invokevirtual [18] 
L58:    pop 
L59:    goto L79 
L62:    aload_1 
L63:    ldc [7] 
L65:    invokevirtual [18] 
L68:    pop 
L69:    goto L79 
L72:    aload_1 
L73:    ldc [8] 
L75:    invokevirtual [18] 
L78:    pop 
L79:    aload_1 
L80:    ldc [9] 
L82:    invokevirtual [18] 
L85:    pop 
L86:    aload_1 
L87:    aload_0 
L88:    getfield [16] 
L91:    invokevirtual [19] 
L94:    pop 
L95:    aload_1 
L96:    ldc [10] 
L98:    invokevirtual [18] 
L101:   pop 
L102:   aload_1 
L103:   aload_0 
L104:   getfield [17] 
L107:   invokevirtual [19] 
L110:   pop 
L111:   aload_1 
L112:   invokevirtual [20] 
L115:   areturn 
L116:   
    .end code 
.end method 

.method public [183] : [184] 
    .attribute [168] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 32 
L8:     iinc 1 32 
L11:    iload_1 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [185] : [186] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [15] 
L5:     i2b 
L6:     invokeinterface [30] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [16] 
L16:    invokeinterface [31] 0 
L21:    aload_1 
L22:    aload_0 
L23:    getfield [17] 
L26:    invokeinterface [31] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [187] : [188] 
    .attribute [168] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [32] 0 
L7:     putfield [26] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [33] 0 
L17:    putfield [27] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [33] 0 
L27:    putfield [28] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [189] : [190] 
    .attribute [168] .code stack 1 locals 0 
L0:     bipush 21 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [168] .code stack 1 locals 0 
L0:     invokestatic [11] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [34] 
.const [3] = Class [35] 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = String [38] 
.const [7] = String [39] 
.const [8] = String [40] 
.const [9] = String [41] 
.const [10] = String [42] 
.const [11] = Method [43] [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Method [47] [48] 
.const [15] = Field [49] [50] 
.const [16] = Field [51] [52] 
.const [17] = Field [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Field [73] [74] 
.const [28] = Field [75] [76] 
.const [29] = Class [77] 
.const [30] = InterfaceMethod [78] [79] 
.const [31] = InterfaceMethod [80] [81] 
.const [32] = InterfaceMethod [82] [83] 
.const [33] = InterfaceMethod [84] [85] 
.const [34] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [35] = Utf8 java/lang/StringBuffer 
.const [36] = Utf8 'DataConnectionIndication2_Status:' 
.const [37] = Utf8 '\n - ConnectionIndication: ' 
.const [38] = Utf8 '0x00 (no data connection)' 
.const [39] = Utf8 '0x01 (data connection active)' 
.const [40] = Utf8 'UNKNOWN ENUM' 
.const [41] = Utf8 '\n - DataVolumeUplink - ' 
.const [42] = Utf8 '\n - DataVolumeDownlink - ' 
.const [43] = Class [86] 
.const [44] = NameAndType [87] [88] 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Class [98] 
.const [54] = NameAndType [99] [100] 
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
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Class [134] 
.const [79] = NameAndType [135] [136] 
.const [80] = Class [137] 
.const [81] = NameAndType [138] [139] 
.const [82] = Class [140] 
.const [83] = NameAndType [141] [142] 
.const [84] = Class [143] 
.const [85] = NameAndType [144] [145] 
.const [86] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [87] = Utf8 functionId 
.const [88] = Utf8 ()I 
.const [89] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [90] = Utf8 deserialize 
.const [91] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [92] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [93] = Utf8 connectionIndication 
.const [94] = Utf8 I 
.const [95] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [96] = Utf8 dataVolumeUplink 
.const [97] = Utf8 I 
.const [98] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [99] = Utf8 dataVolumeDownlink 
.const [100] = Utf8 I 
.const [101] = Utf8 java/lang/StringBuffer 
.const [102] = Utf8 append 
.const [103] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 append 
.const [106] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 toString 
.const [109] = Utf8 ()Ljava/lang/String; 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [114] = Utf8 internalReset 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [117] = Utf8 customInitialization 
.const [118] = Utf8 ()V 
.const [119] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [126] = Utf8 connectionIndication 
.const [127] = Utf8 I 
.const [128] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [129] = Utf8 dataVolumeUplink 
.const [130] = Utf8 I 
.const [131] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [132] = Utf8 dataVolumeDownlink 
.const [133] = Utf8 I 
.const [134] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [135] = Utf8 pushByte 
.const [136] = Utf8 (B)V 
.const [137] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [138] = Utf8 pushInt 
.const [139] = Utf8 (I)V 
.const [140] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [141] = Utf8 popFrontByte 
.const [142] = Utf8 ()I 
.const [143] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [144] = Utf8 popFrontInt 
.const [145] = Utf8 ()I 
.const [146] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/DataConnectionIndication2_Status 
.const [147] = Class [146] 
.const [148] = Utf8 java/lang/Object 
.const [149] = Class [148] 
.const [150] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [151] = Class [150] 
.const [152] = Utf8 connectionIndication 
.const [153] = Utf8 I 
.const [154] = Utf8 CONNECTION_INDICATION_BITSIZE 
.const [155] = Utf8 I 
.const [156] = Utf8 CONNECTION_INDICATION_NO_DATA_CONNECTION 
.const [157] = Utf8 I 
.const [158] = Utf8 CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE 
.const [159] = Utf8 I 
.const [160] = Utf8 dataVolumeUplink 
.const [161] = Utf8 I 
.const [162] = Utf8 DATA_VOLUME_UPLINK_BITSIZE 
.const [163] = Utf8 I 
.const [164] = Utf8 dataVolumeDownlink 
.const [165] = Utf8 I 
.const [166] = Utf8 DATA_VOLUME_DOWNLINK_BITSIZE 
.const [167] = Utf8 I 
.const [168] = Utf8 Code 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 <init> 
.const [172] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [173] = Utf8 internalReset 
.const [174] = Utf8 ()V 
.const [175] = Utf8 reset 
.const [176] = Utf8 ()V 
.const [177] = Utf8 equalTo 
.const [178] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [179] = Utf8 customInitialization 
.const [180] = Utf8 ()V 
.const [181] = Utf8 toString 
.const [182] = Utf8 ()Ljava/lang/String; 
.const [183] = Utf8 bitSize 
.const [184] = Utf8 ()I 
.const [185] = Utf8 serialize 
.const [186] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [187] = Utf8 deserialize 
.const [188] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [189] = Utf8 functionId 
.const [190] = Utf8 ()I 
.const [191] = Utf8 getFunctionId 
.const [192] = Utf8 ()I 
.end class 
