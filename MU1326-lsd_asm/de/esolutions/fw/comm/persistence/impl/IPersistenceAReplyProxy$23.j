.version 50 0 
.class super [107] 
.super [109] 
.implements [111] 
.field private final synthetic [112] [113] 
.field private final synthetic [114] [115] 
.field private final synthetic [116] [117] 
.field private final synthetic [118] [119] 
.field private final synthetic [120] [121] 

.method [123] : [124] 
    .attribute [122] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [13] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [14] 
L15:    aload_0 
L16:    aload 4 
L18:    putfield [15] 
L21:    aload_0 
L22:    aload 5 
L24:    putfield [16] 
L27:    aload_0 
L28:    invokespecial [11] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [122] .code stack 3 locals 2 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [7] 
L5:     invokestatic [2] 
L8:     aload_1 
L9:     aload_0 
L10:    getfield [8] 
L13:    invokeinterface [17] 0 
L18:    aload_0 
L19:    getfield [9] 
L22:    ifnull L29 
L25:    iconst_1 
L26:    goto L30 
L29:    iconst_0 
L30:    istore_2 
L31:    aload_1 
L32:    iload_2 
L33:    ifne L40 
L36:    iconst_1 
L37:    goto L41 
L40:    iconst_0 
L41:    invokeinterface [18] 0 
L46:    iload_2 
L47:    ifeq L91 
L50:    aload_1 
L51:    aload_0 
L52:    getfield [9] 
L55:    arraylength 
L56:    i2l 
L57:    invokeinterface [19] 0 
L62:    iconst_0 
L63:    istore_3 
L64:    iload_3 
L65:    aload_0 
L66:    getfield [9] 
L69:    arraylength 
L70:    if_icmpge L91 
L73:    aload_1 
L74:    aload_0 
L75:    getfield [9] 
L78:    iload_3 
L79:    aaload 
L80:    invokeinterface [20] 0 
L85:    iinc 3 1 
L88:    goto L64 
L91:    aload_1 
L92:    aload_0 
L93:    getfield [10] 
L96:    invokeinterface [21] 0 
L101:   return 
L102:   nop 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Field [28] [29] 
.const [8] = Field [30] [31] 
.const [9] = Field [32] [33] 
.const [10] = Field [34] [35] 
.const [11] = Method [36] [37] 
.const [12] = Field [38] [39] 
.const [13] = Field [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = InterfaceMethod [48] [49] 
.const [18] = InterfaceMethod [50] [51] 
.const [19] = InterfaceMethod [52] [53] 
.const [20] = InterfaceMethod [54] [55] 
.const [21] = InterfaceMethod [56] [57] 
.const [22] = Class [58] 
.const [23] = NameAndType [59] [60] 
.const [24] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [25] = Utf8 java/lang/Object 
.const [26] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [27] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [28] = Class [61] 
.const [29] = NameAndType [62] [63] 
.const [30] = Class [64] 
.const [31] = NameAndType [65] [66] 
.const [32] = Class [67] 
.const [33] = NameAndType [68] [69] 
.const [34] = Class [70] 
.const [35] = NameAndType [71] [72] 
.const [36] = Class [73] 
.const [37] = NameAndType [74] [75] 
.const [38] = Class [76] 
.const [39] = NameAndType [77] [78] 
.const [40] = Class [79] 
.const [41] = NameAndType [80] [81] 
.const [42] = Class [82] 
.const [43] = NameAndType [83] [84] 
.const [44] = Class [85] 
.const [45] = NameAndType [86] [87] 
.const [46] = Class [88] 
.const [47] = NameAndType [89] [90] 
.const [48] = Class [91] 
.const [49] = NameAndType [92] [93] 
.const [50] = Class [94] 
.const [51] = NameAndType [95] [96] 
.const [52] = Class [97] 
.const [53] = NameAndType [98] [99] 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Utf8 de/esolutions/fw/comm/persistence/impl/PartitionHandleSerializer 
.const [59] = Utf8 putOptionalPartitionHandle 
.const [60] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lde/esolutions/fw/comm/persistence/PartitionHandle;)V 
.const [61] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [62] = Utf8 val$handle 
.const [63] = Utf8 Lde/esolutions/fw/comm/persistence/PartitionHandle; 
.const [64] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [65] = Utf8 val$keys 
.const [66] = Utf8 [J 
.const [67] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [68] = Utf8 val$values 
.const [69] = Utf8 [[S 
.const [70] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [71] = Utf8 val$status 
.const [72] = Utf8 [I 
.const [73] = Utf8 java/lang/Object 
.const [74] = Utf8 <init> 
.const [75] = Utf8 ()V 
.const [76] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [77] = Utf8 this$0 
.const [78] = Utf8 Lde/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy; 
.const [79] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [80] = Utf8 val$handle 
.const [81] = Utf8 Lde/esolutions/fw/comm/persistence/PartitionHandle; 
.const [82] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [83] = Utf8 val$keys 
.const [84] = Utf8 [J 
.const [85] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [86] = Utf8 val$values 
.const [87] = Utf8 [[S 
.const [88] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [89] = Utf8 val$status 
.const [90] = Utf8 [I 
.const [91] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [92] = Utf8 putOptionalUInt32VarArray 
.const [93] = Utf8 ([J)V 
.const [94] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [95] = Utf8 putBool 
.const [96] = Utf8 (Z)V 
.const [97] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [98] = Utf8 putUInt32 
.const [99] = Utf8 (J)V 
.const [100] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [101] = Utf8 putOptionalUInt8VarArray 
.const [102] = Utf8 ([S)V 
.const [103] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [104] = Utf8 putOptionalEnumVarArray 
.const [105] = Utf8 ([I)V 
.const [106] = Utf8 de/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy$23 
.const [107] = Class [106] 
.const [108] = Utf8 java/lang/Object 
.const [109] = Class [108] 
.const [110] = Utf8 de/esolutions/fw/util/serializer/ISerializable 
.const [111] = Class [110] 
.const [112] = Utf8 val$handle 
.const [113] = Utf8 Lde/esolutions/fw/comm/persistence/PartitionHandle; 
.const [114] = Utf8 val$keys 
.const [115] = Utf8 [J 
.const [116] = Utf8 val$values 
.const [117] = Utf8 [[S 
.const [118] = Utf8 val$status 
.const [119] = Utf8 [I 
.const [120] = Utf8 this$0 
.const [121] = Utf8 Lde/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy; 
.const [122] = Utf8 Code 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/fw/comm/persistence/impl/IPersistenceAReplyProxy;Lde/esolutions/fw/comm/persistence/PartitionHandle;[J[[S[I)V 
.const [125] = Utf8 serialize 
.const [126] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.end class 
