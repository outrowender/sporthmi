.version 50 0 
.class super [99] 
.super [101] 
.implements [103] 
.field private final synthetic [104] [105] 
.field private final synthetic [106] [107] 
.field private final synthetic [108] [109] 
.field private final synthetic [110] [111] 
.field private final synthetic [112] [113] 

.method [115] : [116] 
    .attribute [114] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [10] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [11] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [12] 
L15:    aload_0 
L16:    aload 4 
L18:    putfield [13] 
L21:    aload_0 
L22:    aload 5 
L24:    putfield [14] 
L27:    aload_0 
L28:    invokespecial [9] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [117] : [118] 
    .attribute [114] .code stack 3 locals 2 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [5] 
L5:     invokeinterface [15] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [6] 
L15:    invokeinterface [15] 0 
L20:    aload_0 
L21:    getfield [7] 
L24:    ifnull L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    istore_2 
L33:    aload_1 
L34:    iload_2 
L35:    ifne L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    invokeinterface [16] 0 
L48:    iload_2 
L49:    ifeq L93 
L52:    aload_1 
L53:    aload_0 
L54:    getfield [7] 
L57:    arraylength 
L58:    i2l 
L59:    invokeinterface [17] 0 
L64:    iconst_0 
L65:    istore_3 
L66:    iload_3 
L67:    aload_0 
L68:    getfield [7] 
L71:    arraylength 
L72:    if_icmpge L93 
L75:    aload_1 
L76:    aload_0 
L77:    getfield [7] 
L80:    iload_3 
L81:    aaload 
L82:    invokeinterface [18] 0 
L87:    iinc 3 1 
L90:    goto L66 
L93:    aload_1 
L94:    aload_0 
L95:    getfield [8] 
L98:    invokeinterface [19] 0 
L103:   return 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [20] 
.const [3] = Class [21] 
.const [4] = Class [22] 
.const [5] = Field [23] [24] 
.const [6] = Field [25] [26] 
.const [7] = Field [27] [28] 
.const [8] = Field [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Field [33] [34] 
.const [11] = Field [35] [36] 
.const [12] = Field [37] [38] 
.const [13] = Field [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = InterfaceMethod [43] [44] 
.const [16] = InterfaceMethod [45] [46] 
.const [17] = InterfaceMethod [47] [48] 
.const [18] = InterfaceMethod [49] [50] 
.const [19] = InterfaceMethod [51] [52] 
.const [20] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [23] = Class [53] 
.const [24] = NameAndType [54] [55] 
.const [25] = Class [56] 
.const [26] = NameAndType [57] [58] 
.const [27] = Class [59] 
.const [28] = NameAndType [60] [61] 
.const [29] = Class [62] 
.const [30] = NameAndType [63] [64] 
.const [31] = Class [65] 
.const [32] = NameAndType [66] [67] 
.const [33] = Class [68] 
.const [34] = NameAndType [69] [70] 
.const [35] = Class [71] 
.const [36] = NameAndType [72] [73] 
.const [37] = Class [74] 
.const [38] = NameAndType [75] [76] 
.const [39] = Class [77] 
.const [40] = NameAndType [78] [79] 
.const [41] = Class [80] 
.const [42] = NameAndType [81] [82] 
.const [43] = Class [83] 
.const [44] = NameAndType [84] [85] 
.const [45] = Class [86] 
.const [46] = NameAndType [87] [88] 
.const [47] = Class [89] 
.const [48] = NameAndType [90] [91] 
.const [49] = Class [92] 
.const [50] = NameAndType [93] [94] 
.const [51] = Class [95] 
.const [52] = NameAndType [96] [97] 
.const [53] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [54] = Utf8 val$namespaces 
.const [55] = Utf8 [J 
.const [56] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [57] = Utf8 val$keys 
.const [58] = Utf8 [J 
.const [59] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [60] = Utf8 val$values 
.const [61] = Utf8 [[S 
.const [62] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [63] = Utf8 val$status 
.const [64] = Utf8 [I 
.const [65] = Utf8 java/lang/Object 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [69] = Utf8 this$0 
.const [70] = Utf8 Lde/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy; 
.const [71] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [72] = Utf8 val$namespaces 
.const [73] = Utf8 [J 
.const [74] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [75] = Utf8 val$keys 
.const [76] = Utf8 [J 
.const [77] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [78] = Utf8 val$values 
.const [79] = Utf8 [[S 
.const [80] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [81] = Utf8 val$status 
.const [82] = Utf8 [I 
.const [83] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [84] = Utf8 putOptionalUInt32VarArray 
.const [85] = Utf8 ([J)V 
.const [86] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [87] = Utf8 putBool 
.const [88] = Utf8 (Z)V 
.const [89] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [90] = Utf8 putUInt32 
.const [91] = Utf8 (J)V 
.const [92] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [93] = Utf8 putOptionalUInt8VarArray 
.const [94] = Utf8 ([S)V 
.const [95] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [96] = Utf8 putOptionalEnumVarArray 
.const [97] = Utf8 ([I)V 
.const [98] = Utf8 de/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy$4 
.const [99] = Class [98] 
.const [100] = Utf8 java/lang/Object 
.const [101] = Class [100] 
.const [102] = Utf8 de/esolutions/fw/util/serializer/ISerializable 
.const [103] = Class [102] 
.const [104] = Utf8 val$namespaces 
.const [105] = Utf8 [J 
.const [106] = Utf8 val$keys 
.const [107] = Utf8 [J 
.const [108] = Utf8 val$values 
.const [109] = Utf8 [[S 
.const [110] = Utf8 val$status 
.const [111] = Utf8 [I 
.const [112] = Utf8 this$0 
.const [113] = Utf8 Lde/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy; 
.const [114] = Utf8 Code 
.const [115] = Utf8 <init> 
.const [116] = Utf8 (Lde/esolutions/fw/comm/asi/persistence/impl/AttributesReplyProxy;[J[J[[S[I)V 
.const [117] = Utf8 serialize 
.const [118] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.end class 
