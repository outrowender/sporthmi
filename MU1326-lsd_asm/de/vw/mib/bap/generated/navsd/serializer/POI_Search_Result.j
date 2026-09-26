.version 50 0 
.class public final super [129] 
.super [131] 
.implements [133] 
.field public [134] [135] 
.field private static final [136] [137] 
.field public [138] [139] 
.field private static final [140] [141] 
.field public static final [142] [143] 
.field public static final [144] [145] 
.field public static final [146] [147] 
.field public static final [148] [149] 
.field public static final [150] [151] 
.field public static final [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     invokespecial [24] 
L8:     aload_0 
L9:     invokespecial [25] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [17] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [159] : [160] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [28] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [29] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [154] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_2 
L10:    getfield [18] 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    getfield [19] 
L20:    aload_2 
L21:    getfield [19] 
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

.method private enum [165] : [166] 
    .attribute [154] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [154] .code stack 2 locals 1 
L0:     new [30] 
L3:     dup 
L4:     invokespecial [27] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [20] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [20] 
L21:    pop 
L22:    aload_1 
L23:    aload_0 
L24:    getfield [18] 
L27:    invokevirtual [21] 
L30:    pop 
L31:    aload_1 
L32:    ldc [6] 
L34:    invokevirtual [20] 
L37:    pop 
L38:    aload_0 
L39:    getfield [19] 
L42:    tableswitch 0 
            L80 
            L90 
            L100 
            L110 
            L120 
            L130 
            default : L140 

L80:    aload_1 
L81:    ldc [7] 
L83:    invokevirtual [20] 
L86:    pop 
L87:    goto L147 
L90:    aload_1 
L91:    ldc [8] 
L93:    invokevirtual [20] 
L96:    pop 
L97:    goto L147 
L100:   aload_1 
L101:   ldc [9] 
L103:   invokevirtual [20] 
L106:   pop 
L107:   goto L147 
L110:   aload_1 
L111:   ldc [10] 
L113:   invokevirtual [20] 
L116:   pop 
L117:   goto L147 
L120:   aload_1 
L121:   ldc [11] 
L123:   invokevirtual [20] 
L126:   pop 
L127:   goto L147 
L130:   aload_1 
L131:   ldc [12] 
L133:   invokevirtual [20] 
L136:   pop 
L137:   goto L147 
L140:   aload_1 
L141:   ldc [13] 
L143:   invokevirtual [20] 
L146:   pop 
L147:   aload_1 
L148:   invokevirtual [22] 
L151:   areturn 
L152:   
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [154] .code stack 1 locals 1 
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

.method public [171] : [172] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [18] 
L5:     i2b 
L6:     invokeinterface [31] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [19] 
L16:    i2b 
L17:    invokeinterface [31] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [154] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [32] 0 
L7:     putfield [28] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [32] 0 
L17:    putfield [29] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [175] : [176] 
    .attribute [154] .code stack 1 locals 0 
L0:     bipush 51 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [154] .code stack 1 locals 0 
L0:     invokestatic [14] 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public interface [179] : [180] 
    .attribute [154] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
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
.const [12] = String [43] 
.const [13] = String [44] 
.const [14] = Method [45] [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Field [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Field [73] [74] 
.const [30] = Class [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [34] = Utf8 java/lang/StringBuffer 
.const [35] = Utf8 'POI_Search_Result:' 
.const [36] = Utf8 '\n - AmountOfFoundEntries - ' 
.const [37] = Utf8 '\n - POI_Search_Result: ' 
.const [38] = Utf8 '0x00 (successful)' 
.const [39] = Utf8 '0x01 (not successful)' 
.const [40] = Utf8 '0x02 (abort successful)' 
.const [41] = Utf8 '0x03 (abort not successful)' 
.const [42] = Utf8 '0x04 (not successful - Entry not found)' 
.const [43] = Utf8 '0x05 (not successful - POI_Type does not match to FSG internal value)' 
.const [44] = Utf8 'UNKNOWN ENUM' 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Utf8 java/lang/Object 
.const [48] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Class [107] 
.const [66] = NameAndType [108] [109] 
.const [67] = Class [110] 
.const [68] = NameAndType [111] [112] 
.const [69] = Class [113] 
.const [70] = NameAndType [114] [115] 
.const [71] = Class [116] 
.const [72] = NameAndType [117] [118] 
.const [73] = Class [119] 
.const [74] = NameAndType [120] [121] 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Class [122] 
.const [77] = NameAndType [123] [124] 
.const [78] = Class [125] 
.const [79] = NameAndType [126] [127] 
.const [80] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [81] = Utf8 functionId 
.const [82] = Utf8 ()I 
.const [83] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [84] = Utf8 deserialize 
.const [85] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [86] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [87] = Utf8 amountOfFoundEntries 
.const [88] = Utf8 I 
.const [89] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [90] = Utf8 poi_Search_Result 
.const [91] = Utf8 I 
.const [92] = Utf8 java/lang/StringBuffer 
.const [93] = Utf8 append 
.const [94] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [95] = Utf8 java/lang/StringBuffer 
.const [96] = Utf8 append 
.const [97] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [98] = Utf8 java/lang/StringBuffer 
.const [99] = Utf8 toString 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [105] = Utf8 internalReset 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [108] = Utf8 customInitialization 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 <init> 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [117] = Utf8 amountOfFoundEntries 
.const [118] = Utf8 I 
.const [119] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [120] = Utf8 poi_Search_Result 
.const [121] = Utf8 I 
.const [122] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [123] = Utf8 pushByte 
.const [124] = Utf8 (B)V 
.const [125] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [126] = Utf8 popFrontByte 
.const [127] = Utf8 ()I 
.const [128] = Utf8 de/vw/mib/bap/generated/navsd/serializer/POI_Search_Result 
.const [129] = Class [128] 
.const [130] = Utf8 java/lang/Object 
.const [131] = Class [130] 
.const [132] = Utf8 de/vw/mib/bap/requests/ResultMethod 
.const [133] = Class [132] 
.const [134] = Utf8 amountOfFoundEntries 
.const [135] = Utf8 I 
.const [136] = Utf8 AMOUNT_OF_FOUND_ENTRIES_BITSIZE 
.const [137] = Utf8 I 
.const [138] = Utf8 poi_Search_Result 
.const [139] = Utf8 I 
.const [140] = Utf8 POI_SEARCH_RESULT_BITSIZE 
.const [141] = Utf8 I 
.const [142] = Utf8 POI_SEARCH_RESULT_SUCCESSFUL 
.const [143] = Utf8 I 
.const [144] = Utf8 POI_SEARCH_RESULT_NOT_SUCCESSFUL 
.const [145] = Utf8 I 
.const [146] = Utf8 POI_SEARCH_RESULT_ABORT_SUCCESSFUL 
.const [147] = Utf8 I 
.const [148] = Utf8 POI_SEARCH_RESULT_ABORT_NOT_SUCCESSFUL 
.const [149] = Utf8 I 
.const [150] = Utf8 POI_SEARCH_RESULT_NOT_SUCCESSFUL_ENTRY_NOT_FOUND 
.const [151] = Utf8 I 
.const [152] = Utf8 POI_SEARCH_RESULT_NOT_SUCCESSFUL_POI_TYPE_DOES_NOT_MATCH_TO_FSG_INTERNAL_VALUE 
.const [153] = Utf8 I 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [159] = Utf8 internalReset 
.const [160] = Utf8 ()V 
.const [161] = Utf8 reset 
.const [162] = Utf8 ()V 
.const [163] = Utf8 equalTo 
.const [164] = Utf8 (Lde/vw/mib/bap/datatypes/BAPEntity;)Z 
.const [165] = Utf8 customInitialization 
.const [166] = Utf8 ()V 
.const [167] = Utf8 toString 
.const [168] = Utf8 ()Ljava/lang/String; 
.const [169] = Utf8 bitSize 
.const [170] = Utf8 ()I 
.const [171] = Utf8 serialize 
.const [172] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [173] = Utf8 deserialize 
.const [174] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [175] = Utf8 functionId 
.const [176] = Utf8 ()I 
.const [177] = Utf8 getFunctionId 
.const [178] = Utf8 ()I 
.const [179] = Utf8 getResultCode 
.const [180] = Utf8 ()I 
.end class 
