.version 50 0 
.class public final super [105] 
.super [107] 
.implements [109] 
.field public [110] [111] 
.field private static final [112] [113] 
.field public static final [114] [115] 
.field public static final [116] [117] 
.field public static final [118] [119] 
.field public static final [120] [121] 

.method public [123] : [124] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     invokespecial [19] 
L8:     aload_0 
L9:     invokespecial [20] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [127] : [128] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [122] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [122] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [15] 
L9:     aload_2 
L10:    getfield [15] 
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

.method private enum [133] : [134] 
    .attribute [122] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [122] .code stack 2 locals 1 
L0:     new [24] 
L3:     dup 
L4:     invokespecial [22] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [16] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [16] 
L21:    pop 
L22:    aload_0 
L23:    getfield [15] 
L26:    tableswitch 0 
            L56 
            L66 
            L76 
            L86 
            default : L96 

L56:    aload_1 
L57:    ldc [6] 
L59:    invokevirtual [16] 
L62:    pop 
L63:    goto L103 
L66:    aload_1 
L67:    ldc [7] 
L69:    invokevirtual [16] 
L72:    pop 
L73:    goto L103 
L76:    aload_1 
L77:    ldc [8] 
L79:    invokevirtual [16] 
L82:    pop 
L83:    goto L103 
L86:    aload_1 
L87:    ldc [9] 
L89:    invokevirtual [16] 
L92:    pop 
L93:    goto L103 
L96:    aload_1 
L97:    ldc [10] 
L99:    invokevirtual [16] 
L102:   pop 
L103:   aload_1 
L104:   invokevirtual [17] 
L107:   areturn 
L108:   
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [122] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [15] 
L5:     i2b 
L6:     invokeinterface [25] 0 
L11:    return 
L12:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [26] 0 
L7:     putfield [23] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [122] .code stack 1 locals 0 
L0:     bipush 31 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [122] .code stack 1 locals 0 
L0:     invokestatic [11] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = String [29] 
.const [5] = String [30] 
.const [6] = String [31] 
.const [7] = String [32] 
.const [8] = String [33] 
.const [9] = String [34] 
.const [10] = String [35] 
.const [11] = Method [36] [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Method [40] [41] 
.const [15] = Field [42] [43] 
.const [16] = Method [44] [45] 
.const [17] = Method [46] [47] 
.const [18] = Method [48] [49] 
.const [19] = Method [50] [51] 
.const [20] = Method [52] [53] 
.const [21] = Method [54] [55] 
.const [22] = Method [56] [57] 
.const [23] = Field [58] [59] 
.const [24] = Class [60] 
.const [25] = InterfaceMethod [61] [62] 
.const [26] = InterfaceMethod [63] [64] 
.const [27] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [28] = Utf8 java/lang/StringBuffer 
.const [29] = Utf8 'PreferredDest_List_Status:' 
.const [30] = Utf8 '\n - ListType: ' 
.const [31] = Utf8 '0x00 (no list preferred / undefined)' 
.const [32] = Utf8 '0x01 (LastDestinations_List (fct 0x1D))' 
.const [33] = Utf8 '0x02 (FavoriteDestinations_List (fct. 0x1E))' 
.const [34] = Utf8 '0x03 (NavBook (fct. 0x20))' 
.const [35] = Utf8 'UNKNOWN ENUM' 
.const [36] = Class [65] 
.const [37] = NameAndType [66] [67] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Class [98] 
.const [62] = NameAndType [99] [100] 
.const [63] = Class [101] 
.const [64] = NameAndType [102] [103] 
.const [65] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [66] = Utf8 functionId 
.const [67] = Utf8 ()I 
.const [68] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [69] = Utf8 deserialize 
.const [70] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [71] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [72] = Utf8 listType 
.const [73] = Utf8 I 
.const [74] = Utf8 java/lang/StringBuffer 
.const [75] = Utf8 append 
.const [76] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 toString 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [84] = Utf8 internalReset 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [87] = Utf8 customInitialization 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [96] = Utf8 listType 
.const [97] = Utf8 I 
.const [98] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [99] = Utf8 pushByte 
.const [100] = Utf8 (B)V 
.const [101] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [102] = Utf8 popFrontByte 
.const [103] = Utf8 ()I 
.const [104] = Utf8 de/vw/mib/bap/generated/navsd/serializer/PreferredDest_List_Status 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 de/vw/mib/bap/requests/StatusProperty 
.const [109] = Class [108] 
.const [110] = Utf8 listType 
.const [111] = Utf8 I 
.const [112] = Utf8 LIST_TYPE_BITSIZE 
.const [113] = Utf8 I 
.const [114] = Utf8 LIST_TYPE_NO_LIST_PREFERRED_UNDEFINED 
.const [115] = Utf8 I 
.const [116] = Utf8 LIST_TYPE_LAST_DESTINATIONS_LIST_FCT_0X1D 
.const [117] = Utf8 I 
.const [118] = Utf8 LIST_TYPE_FAVORITE_DESTINATIONS_LIST_FCT_0X1E 
.const [119] = Utf8 I 
.const [120] = Utf8 LIST_TYPE_NAV_BOOK_FCT_0X20 
.const [121] = Utf8 I 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 ()V 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [127] = Utf8 internalReset 
.const [128] = Utf8 ()V 
.const [129] = Utf8 reset 
.const [130] = Utf8 ()V 
.const [131] = Utf8 equalTo 
.const [132] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [133] = Utf8 customInitialization 
.const [134] = Utf8 ()V 
.const [135] = Utf8 toString 
.const [136] = Utf8 ()Ljava/lang/String; 
.const [137] = Utf8 bitSize 
.const [138] = Utf8 ()I 
.const [139] = Utf8 serialize 
.const [140] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [141] = Utf8 deserialize 
.const [142] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [143] = Utf8 functionId 
.const [144] = Utf8 ()I 
.const [145] = Utf8 getFunctionId 
.const [146] = Utf8 ()I 
.end class 
