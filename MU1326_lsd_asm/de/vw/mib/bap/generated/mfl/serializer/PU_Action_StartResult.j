.version 50 0 
.class public final super [127] 
.super [129] 
.implements [131] 
.field public [132] [133] 
.field private static final [134] [135] 
.field public [136] [137] 
.field private static final [138] [139] 
.field public static final [140] [141] 
.field public static final [142] [143] 
.field public static final [144] [145] 
.field public static final [146] [147] 
.field public static final [148] [149] 

.method public interface [151] : [152] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [150] .code stack 1 locals 0 
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

.method public [157] : [158] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
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
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [27] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [28] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [150] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [150] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [16] 
L9:     aload_2 
L10:    getfield [16] 
L13:    if_icmpne L31 
L16:    aload_0 
L17:    getfield [18] 
L20:    aload_2 
L21:    getfield [18] 
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
    .attribute [150] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [150] .code stack 2 locals 1 
L0:     new [29] 
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
L38:    aload_0 
L39:    getfield [18] 
L42:    tableswitch 0 
            L76 
            L86 
            L96 
            L106 
            L116 
            default : L126 

L76:    aload_1 
L77:    ldc [7] 
L79:    invokevirtual [19] 
L82:    pop 
L83:    goto L133 
L86:    aload_1 
L87:    ldc [8] 
L89:    invokevirtual [19] 
L92:    pop 
L93:    goto L133 
L96:    aload_1 
L97:    ldc [9] 
L99:    invokevirtual [19] 
L102:   pop 
L103:   goto L133 
L106:   aload_1 
L107:   ldc [10] 
L109:   invokevirtual [19] 
L112:   pop 
L113:   goto L133 
L116:   aload_1 
L117:   ldc [11] 
L119:   invokevirtual [19] 
L122:   pop 
L123:   goto L133 
L126:   aload_1 
L127:   ldc [12] 
L129:   invokevirtual [19] 
L132:   pop 
L133:   aload_1 
L134:   invokevirtual [21] 
L137:   areturn 
L138:   nop 
L139:   nop 
L140:   
    .end code 
.end method 

.method public [169] : [170] 
    .attribute [150] .code stack 1 locals 1 
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
    .attribute [150] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [16] 
L5:     i2b 
L6:     invokeinterface [30] 0 
L11:    aload_1 
L12:    aload_0 
L13:    getfield [18] 
L16:    i2b 
L17:    invokeinterface [30] 0 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [150] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [31] 0 
L7:     putfield [27] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [31] 0 
L17:    putfield [28] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public static [175] : [176] 
    .attribute [150] .code stack 1 locals 0 
L0:     bipush 20 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [150] .code stack 1 locals 0 
L0:     invokestatic [13] 
L3:     areturn 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Class [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = String [36] 
.const [7] = String [37] 
.const [8] = String [38] 
.const [9] = String [39] 
.const [10] = String [40] 
.const [11] = String [41] 
.const [12] = String [42] 
.const [13] = Method [43] [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Field [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Field [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Class [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [33] = Utf8 java/lang/StringBuffer 
.const [34] = Utf8 'PU_Action_StartResult:' 
.const [35] = Utf8 '\n - TAID - ' 
.const [36] = Utf8 '\n - Option: ' 
.const [37] = Utf8 '0x00 (quit)' 
.const [38] = Utf8 '0x01 (Option_1)' 
.const [39] = Utf8 '0x02 (Option_2)' 
.const [40] = Utf8 '0x03 (Option_3)' 
.const [41] = Utf8 '0x04 (Option_4)' 
.const [42] = Utf8 'UNKNOWN ENUM' 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [47] = Class [81] 
.const [48] = NameAndType [82] [83] 
.const [49] = Class [84] 
.const [50] = NameAndType [85] [86] 
.const [51] = Class [87] 
.const [52] = NameAndType [88] [89] 
.const [53] = Class [90] 
.const [54] = NameAndType [91] [92] 
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
.const [73] = Utf8 java/lang/StringBuffer 
.const [74] = Class [120] 
.const [75] = NameAndType [121] [122] 
.const [76] = Class [123] 
.const [77] = NameAndType [124] [125] 
.const [78] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [79] = Utf8 functionId 
.const [80] = Utf8 ()I 
.const [81] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [82] = Utf8 taid 
.const [83] = Utf8 I 
.const [84] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [85] = Utf8 deserialize 
.const [86] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [87] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [88] = Utf8 option 
.const [89] = Utf8 I 
.const [90] = Utf8 java/lang/StringBuffer 
.const [91] = Utf8 append 
.const [92] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [93] = Utf8 java/lang/StringBuffer 
.const [94] = Utf8 append 
.const [95] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [96] = Utf8 java/lang/StringBuffer 
.const [97] = Utf8 toString 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [103] = Utf8 internalReset 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [106] = Utf8 customInitialization 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [109] = Utf8 <init> 
.const [110] = Utf8 ()V 
.const [111] = Utf8 java/lang/StringBuffer 
.const [112] = Utf8 <init> 
.const [113] = Utf8 ()V 
.const [114] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [115] = Utf8 taid 
.const [116] = Utf8 I 
.const [117] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [118] = Utf8 option 
.const [119] = Utf8 I 
.const [120] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [121] = Utf8 pushByte 
.const [122] = Utf8 (B)V 
.const [123] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [124] = Utf8 popFrontByte 
.const [125] = Utf8 ()I 
.const [126] = Utf8 de/vw/mib/bap/generated/mfl/serializer/PU_Action_StartResult 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Object 
.const [129] = Class [128] 
.const [130] = Utf8 de/vw/mib/bap/requests/StartResultMethod 
.const [131] = Class [130] 
.const [132] = Utf8 taid 
.const [133] = Utf8 I 
.const [134] = Utf8 TAID_BITSIZE 
.const [135] = Utf8 I 
.const [136] = Utf8 option 
.const [137] = Utf8 I 
.const [138] = Utf8 OPTION_BITSIZE 
.const [139] = Utf8 I 
.const [140] = Utf8 OPTION_QUIT 
.const [141] = Utf8 I 
.const [142] = Utf8 OPTION_OPTION_1 
.const [143] = Utf8 I 
.const [144] = Utf8 OPTION_OPTION_2 
.const [145] = Utf8 I 
.const [146] = Utf8 OPTION_OPTION_3 
.const [147] = Utf8 I 
.const [148] = Utf8 OPTION_OPTION_4 
.const [149] = Utf8 I 
.const [150] = Utf8 Code 
.const [151] = Utf8 getTransactionId 
.const [152] = Utf8 ()I 
.const [153] = Utf8 setTransactionId 
.const [154] = Utf8 (I)V 
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
.end class 
