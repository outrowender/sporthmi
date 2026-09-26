.version 50 0 
.class public final super [119] 
.super [121] 
.implements [123] 
.field public [124] [125] 
.field private static final [126] [127] 
.field public static final [128] [129] 
.field public static final [130] [131] 
.field public [132] [133] 
.field private static final [134] [135] 
.field public static final [136] [137] 
.field public static final [138] [139] 

.method public [141] : [142] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     invokespecial [21] 
L8:     aload_0 
L9:     invokespecial [22] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [145] : [146] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [25] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [26] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [140] .code stack 2 locals 1 
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

.method private enum [151] : [152] 
    .attribute [140] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 2 locals 1 
L0:     new [27] 
L3:     dup 
L4:     invokespecial [24] 
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
L86:    aload_0 
L87:    getfield [17] 
L90:    lookupswitch 
            63 : L116 
            103 : L126 
            default : L136 

L116:   aload_1 
L117:   ldc [10] 
L119:   invokevirtual [18] 
L122:   pop 
L123:   goto L143 
L126:   aload_1 
L127:   ldc [11] 
L129:   invokevirtual [18] 
L132:   pop 
L133:   goto L143 
L136:   aload_1 
L137:   ldc [8] 
L139:   invokevirtual [18] 
L142:   pop 
L143:   aload_1 
L144:   invokevirtual [19] 
L147:   areturn 
L148:   
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [140] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iinc 1 8 
L8:     iload_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     i2b 
L6:     invokeinterface [28] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [17] 
L16:    i2b 
L17:    invokeinterface [28] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [29] 0 
L7:     putfield [25] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [29] 0 
L17:    putfield [26] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [161] : [162] 
    .attribute [140] .code stack 1 locals 0 
L0:     bipush 51 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [140] .code stack 1 locals 0 
L0:     invokestatic [12] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Class [31] 
.const [4] = String [32] 
.const [5] = String [33] 
.const [6] = String [34] 
.const [7] = String [35] 
.const [8] = String [36] 
.const [9] = String [37] 
.const [10] = String [38] 
.const [11] = String [39] 
.const [12] = Method [40] [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Method [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = Field [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Field [66] [67] 
.const [27] = Class [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [31] = Utf8 java/lang/StringBuffer 
.const [32] = Utf8 'POI_Search_StartResult:' 
.const [33] = Utf8 '\n - SearchType: ' 
.const [34] = Utf8 '0x00 (Search along the current route (in case of active RG))' 
.const [35] = Utf8 '0x01 (Search in the circumference to the current location)' 
.const [36] = Utf8 'UNKNOWN ENUM' 
.const [37] = Utf8 '\n - POI_Type: ' 
.const [38] = Utf8 '0x3F (Gasstation (general))' 
.const [39] = Utf8 '0x67 (Parking (general))' 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Class [79] 
.const [47] = NameAndType [80] [81] 
.const [48] = Class [82] 
.const [49] = NameAndType [83] [84] 
.const [50] = Class [85] 
.const [51] = NameAndType [86] [87] 
.const [52] = Class [88] 
.const [53] = NameAndType [89] [90] 
.const [54] = Class [91] 
.const [55] = NameAndType [92] [93] 
.const [56] = Class [94] 
.const [57] = NameAndType [95] [96] 
.const [58] = Class [97] 
.const [59] = NameAndType [98] [99] 
.const [60] = Class [100] 
.const [61] = NameAndType [101] [102] 
.const [62] = Class [103] 
.const [63] = NameAndType [104] [105] 
.const [64] = Class [106] 
.const [65] = NameAndType [107] [108] 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [74] = Utf8 functionId 
.const [75] = Utf8 ()I 
.const [76] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [77] = Utf8 deserialize 
.const [78] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [79] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [80] = Utf8 searchType 
.const [81] = Utf8 I 
.const [82] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [83] = Utf8 poi_Type 
.const [84] = Utf8 I 
.const [85] = Utf8 java/lang/StringBuffer 
.const [86] = Utf8 append 
.const [87] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [88] = Utf8 java/lang/StringBuffer 
.const [89] = Utf8 toString 
.const [90] = Utf8 ()Ljava/lang/String; 
.const [91] = Utf8 java/lang/Object 
.const [92] = Utf8 <init> 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [95] = Utf8 internalReset 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [98] = Utf8 customInitialization 
.const [99] = Utf8 ()V 
.const [100] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 java/lang/StringBuffer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [107] = Utf8 searchType 
.const [108] = Utf8 I 
.const [109] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [110] = Utf8 poi_Type 
.const [111] = Utf8 I 
.const [112] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [113] = Utf8 pushByte 
.const [114] = Utf8 (B)V 
.const [115] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [116] = Utf8 popFrontByte 
.const [117] = Utf8 ()I 
.const [118] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_StartResult 
.const [119] = Class [118] 
.const [120] = Utf8 java/lang/Object 
.const [121] = Class [120] 
.const [122] = Utf8 de/vw/mib/bap/requests/StartResultMethod 
.const [123] = Class [122] 
.const [124] = Utf8 searchType 
.const [125] = Utf8 I 
.const [126] = Utf8 SEARCH_TYPE_BITSIZE 
.const [127] = Utf8 I 
.const [128] = Utf8 SEARCH_TYPE_SEARCH_ALONG_THE_CURRENT_ROUTE_IN_CASE_OF_ACTIVE_RG 
.const [129] = Utf8 I 
.const [130] = Utf8 SEARCH_TYPE_SEARCH_IN_THE_CIRCUMFERENCE_TO_THE_CURRENT_LOCATION 
.const [131] = Utf8 I 
.const [132] = Utf8 poi_Type 
.const [133] = Utf8 I 
.const [134] = Utf8 POI_TYPE_BITSIZE 
.const [135] = Utf8 I 
.const [136] = Utf8 POI_TYPE_GASSTATION_GENERAL 
.const [137] = Utf8 I 
.const [138] = Utf8 POI_TYPE_PARKING_GENERAL 
.const [139] = Utf8 I 
.const [140] = Utf8 Code 
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
