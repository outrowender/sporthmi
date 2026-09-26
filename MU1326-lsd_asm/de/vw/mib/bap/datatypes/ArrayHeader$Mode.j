.version 50 0 
.class public final super [141] 
.super [143] 
.implements [145] 
.field public [146] [147] 
.field public [148] [149] 
.field public [150] [151] 
.field public [152] [153] 
.field private static final [154] [155] 

.method public interface [157] : [158] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     invokespecial [27] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [20] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [163] : [164] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     putfield [30] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [31] 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [32] 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [33] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [156] .code stack 2 locals 1 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [19] 
L9:     aload_2 
L10:    getfield [19] 
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

.method public [169] : [170] 
    .attribute [156] .code stack 2 locals 1 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [29] 
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
L23:    getfield [19] 
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

.method public [171] : [172] 
    .attribute [156] .code stack 1 locals 1 
L0:     iconst_0 
L1:     istore_1 
L2:     iinc 1 4 
L5:     iload_1 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [173] : [174] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [19] 
L5:     invokeinterface [35] 0 
L10:    aload_1 
L11:    aload_0 
L12:    getfield [21] 
L15:    invokeinterface [35] 0 
L20:    aload_1 
L21:    aload_0 
L22:    getfield [22] 
L25:    invokeinterface [35] 0 
L30:    aload_1 
L31:    aload_0 
L32:    getfield [23] 
L35:    invokeinterface [35] 0 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [175] : [176] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokeinterface [36] 0 
L7:     putfield [30] 
L10:    aload_0 
L11:    aload_1 
L12:    invokeinterface [36] 0 
L17:    putfield [31] 
L20:    aload_0 
L21:    aload_1 
L22:    invokeinterface [36] 0 
L27:    putfield [32] 
L30:    aload_0 
L31:    aload_1 
L32:    invokeinterface [36] 0 
L37:    putfield [33] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [177] : [178] 
    .attribute [156] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [22] 
L5:     putfield [32] 
L8:     aload_0 
L9:     aload_1 
L10:    getfield [21] 
L13:    putfield [31] 
L16:    aload_0 
L17:    aload_1 
L18:    getfield [19] 
L21:    putfield [30] 
L24:    aload_0 
L25:    aload_1 
L26:    getfield [23] 
L29:    putfield [33] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
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
.const [16] = String [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Field [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Field [58] [59] 
.const [22] = Field [60] [61] 
.const [23] = Field [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Method [66] [67] 
.const [26] = Method [68] [69] 
.const [27] = Method [70] [71] 
.const [28] = Method [72] [73] 
.const [29] = Method [74] [75] 
.const [30] = Field [76] [77] 
.const [31] = Field [78] [79] 
.const [32] = Field [80] [81] 
.const [33] = Field [82] [83] 
.const [34] = Class [84] 
.const [35] = InterfaceMethod [85] [86] 
.const [36] = InterfaceMethod [87] [88] 
.const [37] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [38] = Utf8 java/lang/StringBuffer 
.const [39] = Utf8 'Mode:' 
.const [40] = Utf8 '\n - Bit 3: ' 
.const [41] = Utf8 'true  (IndexSize 16 Bit for Start/Elements' 
.const [42] = Utf8 'false  (IndexSize 8 Bit for Start/Elements' 
.const [43] = Utf8 '\n - Bit 2: ' 
.const [44] = Utf8 'true  (Array position is transmitted' 
.const [45] = Utf8 'false  (Array position is not transmitted' 
.const [46] = Utf8 '\n - Bit 1: ' 
.const [47] = Utf8 'true  (Array direction is backward' 
.const [48] = Utf8 'false  (Array direction is forward' 
.const [49] = Utf8 '\n - Bit 0: ' 
.const [50] = Utf8 'true  (Shift' 
.const [51] = Utf8 'false  (Shift' 
.const [52] = Utf8 java/lang/Object 
.const [53] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Class [98] 
.const [61] = NameAndType [99] [100] 
.const [62] = Class [101] 
.const [63] = NameAndType [102] [103] 
.const [64] = Class [104] 
.const [65] = NameAndType [105] [106] 
.const [66] = Class [107] 
.const [67] = NameAndType [108] [109] 
.const [68] = Class [110] 
.const [69] = NameAndType [111] [112] 
.const [70] = Class [113] 
.const [71] = NameAndType [114] [115] 
.const [72] = Class [116] 
.const [73] = NameAndType [117] [118] 
.const [74] = Class [119] 
.const [75] = NameAndType [120] [121] 
.const [76] = Class [122] 
.const [77] = NameAndType [123] [124] 
.const [78] = Class [125] 
.const [79] = NameAndType [126] [127] 
.const [80] = Class [128] 
.const [81] = NameAndType [129] [130] 
.const [82] = Class [131] 
.const [83] = NameAndType [132] [133] 
.const [84] = Utf8 java/lang/StringBuffer 
.const [85] = Class [134] 
.const [86] = NameAndType [135] [136] 
.const [87] = Class [137] 
.const [88] = NameAndType [138] [139] 
.const [89] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [90] = Utf8 indexSize16BitForStartElements 
.const [91] = Utf8 Z 
.const [92] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [93] = Utf8 deserialize 
.const [94] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [95] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [96] = Utf8 arrayPositionIsTransmitted 
.const [97] = Utf8 Z 
.const [98] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [99] = Utf8 arrayDirectionIsBackward 
.const [100] = Utf8 Z 
.const [101] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [102] = Utf8 shift 
.const [103] = Utf8 Z 
.const [104] = Utf8 java/lang/StringBuffer 
.const [105] = Utf8 append 
.const [106] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [107] = Utf8 java/lang/StringBuffer 
.const [108] = Utf8 toString 
.const [109] = Utf8 ()Ljava/lang/String; 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [114] = Utf8 internalReset 
.const [115] = Utf8 ()V 
.const [116] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [117] = Utf8 <init> 
.const [118] = Utf8 ()V 
.const [119] = Utf8 java/lang/StringBuffer 
.const [120] = Utf8 <init> 
.const [121] = Utf8 ()V 
.const [122] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [123] = Utf8 indexSize16BitForStartElements 
.const [124] = Utf8 Z 
.const [125] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [126] = Utf8 arrayPositionIsTransmitted 
.const [127] = Utf8 Z 
.const [128] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [129] = Utf8 arrayDirectionIsBackward 
.const [130] = Utf8 Z 
.const [131] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [132] = Utf8 shift 
.const [133] = Utf8 Z 
.const [134] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [135] = Utf8 pushBoolean 
.const [136] = Utf8 (Z)V 
.const [137] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [138] = Utf8 popFrontBoolean 
.const [139] = Utf8 ()Z 
.const [140] = Utf8 de/vw/mib/bap/datatypes/ArrayHeader$Mode 
.const [141] = Class [140] 
.const [142] = Utf8 java/lang/Object 
.const [143] = Class [142] 
.const [144] = Utf8 de/vw/mib/bap/datatypes/BAPEntity 
.const [145] = Class [144] 
.const [146] = Utf8 indexSize16BitForStartElements 
.const [147] = Utf8 Z 
.const [148] = Utf8 arrayPositionIsTransmitted 
.const [149] = Utf8 Z 
.const [150] = Utf8 arrayDirectionIsBackward 
.const [151] = Utf8 Z 
.const [152] = Utf8 shift 
.const [153] = Utf8 Z 
.const [154] = Utf8 MODE_BITSIZE 
.const [155] = Utf8 I 
.const [156] = Utf8 Code 
.const [157] = Utf8 is16BitsIndexSize 
.const [158] = Utf8 ()Z 
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
.const [169] = Utf8 toString 
.const [170] = Utf8 ()Ljava/lang/String; 
.const [171] = Utf8 bitSize 
.const [172] = Utf8 ()I 
.const [173] = Utf8 serialize 
.const [174] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [175] = Utf8 deserialize 
.const [176] = Utf8 (Lde/vw/mib/bap/stream/BitStream;)V 
.const [177] = Utf8 copy 
.const [178] = Utf8 (Lde/vw/mib/bap/datatypes/ArrayHeader$Mode;)V 
.end class 
