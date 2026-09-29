.version 50 0 
.class public final super [159] 
.super [161] 
.implements [163] 
.field private static final [164] [165] 
.field public [166] [167] 
.field public [168] [169] 
.field public [170] [171] 
.field public [172] [173] 
.field private static final [174] [175] 

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
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [34] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
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
L13:    if_icmpne L53 
L16:    aload_0 
L17:    getfield [21] 
L20:    aload_2 
L21:    getfield [21] 
L24:    if_icmpne L53 
L27:    aload_0 
L28:    getfield [22] 
L31:    aload_2 
L32:    getfield [22] 
L35:    if_icmpne L53 
L38:    aload_0 
L39:    getfield [23] 
L42:    aload_2 
L43:    getfield [23] 
L46:    if_icmpne L53 
L49:    iconst_1 
L50:    goto L54 
L53:    iconst_0 
L54:    areturn 
L55:    nop 
L56:    
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
L0:     new [35] 
L3:     dup 
L4:     invokespecial [30] 
L7:     astore_1 
L8:     aload_1 
L9:     ldc [4] 
L11:    invokevirtual [24] 
L14:    pop 
L15:    aload_1 
L16:    ldc [5] 
L18:    invokevirtual [24] 
L21:    pop 
L22:    aload_0 
L23:    getfield [20] 
L26:    ifeq L39 
L29:    aload_1 
L30:    ldc [6] 
L32:    invokevirtual [24] 
L35:    pop 
L36:    goto L46 
L39:    aload_1 
L40:    ldc [7] 
L42:    invokevirtual [24] 
L45:    pop 
L46:    aload_1 
L47:    ldc [8] 
L49:    invokevirtual [24] 
L52:    pop 
L53:    aload_0 
L54:    getfield [21] 
L57:    ifeq L70 
L60:    aload_1 
L61:    ldc [9] 
L63:    invokevirtual [24] 
L66:    pop 
L67:    goto L77 
L70:    aload_1 
L71:    ldc [10] 
L73:    invokevirtual [24] 
L76:    pop 
L77:    aload_1 
L78:    ldc [11] 
L80:    invokevirtual [24] 
L83:    pop 
L84:    aload_0 
L85:    getfield [22] 
L88:    ifeq L101 
L91:    aload_1 
L92:    ldc [12] 
L94:    invokevirtual [24] 
L97:    pop 
L98:    goto L108 
L101:   aload_1 
L102:   ldc [13] 
L104:   invokevirtual [24] 
L107:   pop 
L108:   aload_1 
L109:   ldc [14] 
L111:   invokevirtual [24] 
L114:   pop 
L115:   aload_0 
L116:   getfield [23] 
L119:   ifeq L132 
L122:   aload_1 
L123:   ldc [15] 
L125:   invokevirtual [24] 
L128:   pop 
L129:   goto L139 
L132:   aload_1 
L133:   ldc [16] 
L135:   invokevirtual [24] 
L138:   pop 
L139:   aload_1 
L140:   invokevirtual [25] 
L143:   areturn 
L144:   
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [176] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 8 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_1 
L1:     iconst_4 
L2:     invokeinterface [36] 0 
L7:     aload_1 
L8:     aload_0 
L9:     getfield [20] 
L12:    invokeinterface [37] 0 
L17:    aload_1 
L18:    aload_0 
L19:    getfield [21] 
L22:    invokeinterface [37] 0 
L27:    aload_1 
L28:    aload_0 
L29:    getfield [22] 
L32:    invokeinterface [37] 0 
L37:    aload_1 
L38:    aload_0 
L39:    getfield [23] 
L42:    invokeinterface [37] 0 
L47:    return 
L48:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [176] .code stack 2 locals 0 
L0:     aload_1 
L1:     iconst_4 
L2:     invokeinterface [38] 0 
L7:     aload_0 
L8:     aload_1 
L9:     invokeinterface [39] 0 
L14:    putfield [31] 
L17:    aload_0 
L18:    aload_1 
L19:    invokeinterface [39] 0 
L24:    putfield [32] 
L27:    aload_0 
L28:    aload_1 
L29:    invokeinterface [39] 0 
L34:    putfield [33] 
L37:    aload_0 
L38:    aload_1 
L39:    invokeinterface [39] 0 
L44:    putfield [34] 
L47:    return 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [40] 
.const [3] = Class [41] 
.const [4] = String [42] 
.const [5] = String [43] 
.const [6] = String [44] 
.const [7] = String [45] 
.const [8] = String [46] 
.const [9] = String [47] 
.const [10] = String [48] 
.const [11] = String [49] 
.const [12] = String [50] 
.const [13] = String [51] 
.const [14] = String [52] 
.const [15] = String [53] 
.const [16] = String [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Method [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Field [61] [62] 
.const [22] = Field [63] [64] 
.const [23] = Field [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Method [79] [80] 
.const [31] = Field [81] [82] 
.const [32] = Field [83] [84] 
.const [33] = Field [85] [86] 
.const [34] = Field [87] [88] 
.const [35] = Class [89] 
.const [36] = InterfaceMethod [90] [91] 
.const [37] = InterfaceMethod [92] [93] 
.const [38] = InterfaceMethod [94] [95] 
.const [39] = InterfaceMethod [96] [97] 
.const [40] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [41] = Utf8 java/lang/StringBuffer 
.const [42] = Utf8 'BluetoothConnections:' 
.const [43] = Utf8 '\n - Bit 3: ' 
.const [44] = Utf8 'true  (SimAccessProfile active' 
.const [45] = Utf8 'false  (SimAccessProfile not active' 
.const [46] = Utf8 '\n - Bit 2: ' 
.const [47] = Utf8 'true  (PhonebookAccessProfile active' 
.const [48] = Utf8 'false  (PhonebookAccessProfile not active' 
.const [49] = Utf8 '\n - Bit 1: ' 
.const [50] = Utf8 'true  (HandsFreeProfile active' 
.const [51] = Utf8 'false  (HandsFreeProfile not active' 
.const [52] = Utf8 '\n - Bit 0: ' 
.const [53] = Utf8 'true  (Audioplayer active' 
.const [54] = Utf8 'false  (Audioplayer not active' 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Class [131] 
.const [80] = NameAndType [132] [133] 
.const [81] = Class [134] 
.const [82] = NameAndType [135] [136] 
.const [83] = Class [137] 
.const [84] = NameAndType [138] [139] 
.const [85] = Class [140] 
.const [86] = NameAndType [141] [142] 
.const [87] = Class [143] 
.const [88] = NameAndType [144] [145] 
.const [89] = Utf8 java/lang/StringBuffer 
.const [90] = Class [146] 
.const [91] = NameAndType [147] [148] 
.const [92] = Class [149] 
.const [93] = NameAndType [150] [151] 
.const [94] = Class [152] 
.const [95] = NameAndType [153] [154] 
.const [96] = Class [155] 
.const [97] = NameAndType [156] [157] 
.const [98] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [99] = Utf8 deserialize 
.const [100] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [101] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [102] = Utf8 simAccessProfileActive 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [105] = Utf8 phonebookAccessProfileActive 
.const [106] = Utf8 Z 
.const [107] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [108] = Utf8 handsFreeProfileActive 
.const [109] = Utf8 Z 
.const [110] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [111] = Utf8 audioplayerActive 
.const [112] = Utf8 Z 
.const [113] = Utf8 java/lang/StringBuffer 
.const [114] = Utf8 append 
.const [115] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Utf8 toString 
.const [118] = Utf8 ()Ljava/lang/String; 
.const [119] = Utf8 java/lang/Object 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [123] = Utf8 internalReset 
.const [124] = Utf8 ()V 
.const [125] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [126] = Utf8 customInitialization 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 java/lang/StringBuffer 
.const [132] = Utf8 <init> 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [135] = Utf8 simAccessProfileActive 
.const [136] = Utf8 Z 
.const [137] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [138] = Utf8 phonebookAccessProfileActive 
.const [139] = Utf8 Z 
.const [140] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [141] = Utf8 handsFreeProfileActive 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [144] = Utf8 audioplayerActive 
.const [145] = Utf8 Z 
.const [146] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [147] = Utf8 resetBits 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [150] = Utf8 pushBoolean 
.const [151] = Utf8 (Z)V 
.const [152] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [153] = Utf8 discardBits 
.const [154] = Utf8 (I)V 
.const [155] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [156] = Utf8 popFrontBoolean 
.const [157] = Utf8 ()Z 
.const [158] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/ConnectionState_Status$BluetoothConnections 
.const [159] = Class [158] 
.const [160] = Utf8 java/lang/Object 
.const [161] = Class [160] 
.const [162] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [163] = Class [162] 
.const [164] = Utf8 RESERVED_BIT_4__7_BITSIZE 
.const [165] = Utf8 I 
.const [166] = Utf8 simAccessProfileActive 
.const [167] = Utf8 Z 
.const [168] = Utf8 phonebookAccessProfileActive 
.const [169] = Utf8 Z 
.const [170] = Utf8 handsFreeProfileActive 
.const [171] = Utf8 Z 
.const [172] = Utf8 audioplayerActive 
.const [173] = Utf8 Z 
.const [174] = Utf8 BLUETOOTH_CONNECTIONS_BITSIZE 
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
.end class 
