.version 50 0 
.class public super [213] 
.super [215] 
.field private [216] [217] 

.method public [219] : [220] 
    .attribute [218] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     fload_2 
L3:     fload_3 
L4:     iload 4 
L6:     iload 5 
L8:     iload 7 
L10:    invokespecial [37] 
L13:    aload_0 
L14:    aload 6 
L16:    putfield [42] 
L19:    aload_0 
L20:    iconst_0 
L21:    invokevirtual [19] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [218] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [38] 
L5:     istore_2 
L6:     aload_0 
L7:     invokevirtual [20] 
L10:    iload_2 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [218] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [39] 
L6:     aload_0 
L7:     invokevirtual [20] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [218] .code stack 6 locals 3 
L0:     iconst_0 
L1:     istore_1 
L2:     aload_0 
L3:     getfield [21] 
L6:     ifnull L69 
L9:     iconst_0 
L10:    istore_2 
L11:    iload_2 
L12:    aload_0 
L13:    getfield [21] 
L16:    invokeinterface [43] 0 
L21:    if_icmpge L69 
L24:    aload_0 
L25:    getfield [21] 
L28:    iload_2 
L29:    invokeinterface [44] 0 
L34:    checkcast [2] 
L37:    astore_3 
L38:    aload_3 
L39:    invokeinterface [45] 0 
L44:    ifeq L63 
L47:    iconst_1 
L48:    istore_1 
L49:    getstatic [3] 
L52:    ldc [4] 
L54:    ldc [5] 
L56:    invokevirtual [22] 
L59:    pop 
L60:    goto L69 
L63:    iinc 2 1 
L66:    goto L11 
L69:    aload_0 
L70:    getfield [23] 
L73:    iload_1 
L74:    if_icmpne L106 
L77:    getstatic [3] 
L80:    invokevirtual [24] 
L83:    ifeq L105 
L86:    getstatic [3] 
L89:    ldc [4] 
L91:    ldc [6] 
L93:    iload_1 
L94:    aload_0 
L95:    invokevirtual [25] 
L98:    invokevirtual [26] 
L101:   invokevirtual [27] 
L104:   pop 
L105:   return 
L106:   getstatic [3] 
L109:   invokevirtual [28] 
L112:   ifeq L137 
L115:   getstatic [3] 
L118:   ldc [7] 
L120:   ldc [8] 
L122:   iload_1 
L123:   aload_0 
L124:   invokevirtual [25] 
L127:   invokevirtual [26] 
L130:   aload_0 
L131:   getfield [18] 
L134:   invokevirtual [29] 
L137:   aload_0 
L138:   iload_1 
L139:   invokevirtual [19] 
L142:   aload_0 
L143:   getfield [18] 
L146:   ifnull L159 
L149:   aload_0 
L150:   getfield [18] 
L153:   iload_1 
L154:   invokeinterface [46] 0 
L159:   return 
L160:   
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [218] .code stack 2 locals 2 
L0:     ldc [9] 
L2:     astore_1 
L3:     new [47] 
L6:     dup 
L7:     invokespecial [40] 
L10:    astore_2 
L11:    aload_2 
L12:    aload_1 
L13:    invokevirtual [30] 
L16:    aload_0 
L17:    invokevirtual [31] 
L20:    invokevirtual [30] 
L23:    pop 
L24:    aload_2 
L25:    ldc [11] 
L27:    invokevirtual [30] 
L30:    aload_0 
L31:    invokevirtual [32] 
L34:    invokevirtual [33] 
L37:    bipush 93 
L39:    invokevirtual [34] 
L42:    pop 
L43:    aload_2 
L44:    invokevirtual [35] 
L47:    areturn 
L48:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [218] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [36] 
L4:     istore_1 
L5:     aload_0 
L6:     invokespecial [41] 
L9:     aload_0 
L10:    iload_1 
L11:    invokevirtual [19] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [48] 
.const [3] = Field [49] [50] 
.const [4] = Int -2137614336 
.const [5] = String [51] 
.const [6] = String [52] 
.const [7] = Int 1078071040 
.const [8] = String [53] 
.const [9] = String [54] 
.const [10] = Class [55] 
.const [11] = String [56] 
.const [12] = Class [57] 
.const [13] = Class [58] 
.const [14] = Class [59] 
.const [15] = Class [60] 
.const [16] = Class [61] 
.const [17] = Class [62] 
.const [18] = Field [63] [64] 
.const [19] = Method [65] [66] 
.const [20] = Method [67] [68] 
.const [21] = Field [69] [70] 
.const [22] = Method [71] [72] 
.const [23] = Field [73] [74] 
.const [24] = Method [75] [76] 
.const [25] = Method [77] [78] 
.const [26] = Method [79] [80] 
.const [27] = Method [81] [82] 
.const [28] = Method [83] [84] 
.const [29] = Method [85] [86] 
.const [30] = Method [87] [88] 
.const [31] = Method [89] [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Method [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Field [111] [112] 
.const [43] = InterfaceMethod [113] [114] 
.const [44] = InterfaceMethod [115] [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = InterfaceMethod [119] [120] 
.const [47] = Class [121] 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [49] = Class [122] 
.const [50] = NameAndType [123] [124] 
.const [51] = Utf8 'WrappedNode3DVisibility#updateVisibility: at least one visible child' 
.const [52] = Utf8 'WrappedNode3DVisibility#updateVisibility: %2 no visibility change, visible = %1' 
.const [53] = Utf8 'WrappedNode3DVisibility#updateVisibility: %3, %2 visibility set to %1' 
.const [54] = Utf8 WrappedNode3DVisibility[ 
.const [55] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [56] = Utf8 ', parent=' 
.const [57] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [59] = Utf8 java/util/List 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport 
.const [63] = Class [125] 
.const [64] = NameAndType [126] [127] 
.const [65] = Class [128] 
.const [66] = NameAndType [129] [130] 
.const [67] = Class [131] 
.const [68] = NameAndType [132] [133] 
.const [69] = Class [134] 
.const [70] = NameAndType [135] [136] 
.const [71] = Class [137] 
.const [72] = NameAndType [138] [139] 
.const [73] = Class [140] 
.const [74] = NameAndType [141] [142] 
.const [75] = Class [143] 
.const [76] = NameAndType [144] [145] 
.const [77] = Class [146] 
.const [78] = NameAndType [147] [148] 
.const [79] = Class [149] 
.const [80] = NameAndType [150] [151] 
.const [81] = Class [152] 
.const [82] = NameAndType [153] [154] 
.const [83] = Class [155] 
.const [84] = NameAndType [156] [157] 
.const [85] = Class [158] 
.const [86] = NameAndType [159] [160] 
.const [87] = Class [161] 
.const [88] = NameAndType [162] [163] 
.const [89] = Class [164] 
.const [90] = NameAndType [165] [166] 
.const [91] = Class [167] 
.const [92] = NameAndType [168] [169] 
.const [93] = Class [170] 
.const [94] = NameAndType [171] [172] 
.const [95] = Class [173] 
.const [96] = NameAndType [174] [175] 
.const [97] = Class [176] 
.const [98] = NameAndType [177] [178] 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Class [185] 
.const [104] = NameAndType [186] [187] 
.const [105] = Class [188] 
.const [106] = NameAndType [189] [190] 
.const [107] = Class [191] 
.const [108] = NameAndType [192] [193] 
.const [109] = Class [194] 
.const [110] = NameAndType [195] [196] 
.const [111] = Class [197] 
.const [112] = NameAndType [198] [199] 
.const [113] = Class [200] 
.const [114] = NameAndType [201] [202] 
.const [115] = Class [203] 
.const [116] = NameAndType [204] [205] 
.const [117] = Class [206] 
.const [118] = NameAndType [207] [208] 
.const [119] = Class [209] 
.const [120] = NameAndType [210] [211] 
.const [121] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [122] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [123] = Utf8 logChannel3DEngineLayersAndViewports 
.const [124] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [125] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [126] = Utf8 viewport 
.const [127] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport; 
.const [128] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [129] = Utf8 setVisible 
.const [130] = Utf8 (Z)V 
.const [131] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [132] = Utf8 updateVisibility 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [135] = Utf8 children 
.const [136] = Utf8 Ljava/util/List; 
.const [137] = Utf8 de/audi/atip/log/LogChannel 
.const [138] = Utf8 log 
.const [139] = Utf8 (ILjava/lang/String;)Z 
.const [140] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [141] = Utf8 visible 
.const [142] = Utf8 Z 
.const [143] = Utf8 de/audi/atip/log/LogChannel 
.const [144] = Utf8 isDebug 
.const [145] = Utf8 ()Z 
.const [146] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [147] = Utf8 getNode 
.const [148] = Utf8 ()Lde/esolutions/graphics/eal/api/INode3D; 
.const [149] = Utf8 de/esolutions/graphics/eal/api/INode3D 
.const [150] = Utf8 getName 
.const [151] = Utf8 ()Ljava/lang/String; 
.const [152] = Utf8 de/audi/atip/log/LogChannel 
.const [153] = Utf8 log 
.const [154] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;)Z 
.const [155] = Utf8 de/audi/atip/log/LogChannel 
.const [156] = Utf8 isInfo 
.const [157] = Utf8 ()Z 
.const [158] = Utf8 de/audi/atip/log/LogChannel 
.const [159] = Utf8 log 
.const [160] = Utf8 (ILjava/lang/String;ZLjava/lang/Object;Ljava/lang/Object;)V 
.const [161] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [162] = Utf8 append 
.const [163] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [164] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [165] = Utf8 getNodeName 
.const [166] = Utf8 ()Ljava/lang/String; 
.const [167] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [168] = Utf8 getParent 
.const [169] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D; 
.const [170] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [171] = Utf8 append 
.const [172] = Utf8 (Ljava/lang/Object;)Lde/esolutions/fw/util/commons/Buffer; 
.const [173] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [174] = Utf8 append 
.const [175] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [176] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [180] = Utf8 isVisible 
.const [181] = Utf8 ()Z 
.const [182] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;FFZIZ)V 
.const [185] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [186] = Utf8 remove 
.const [187] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D;)Z 
.const [188] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [189] = Utf8 addByIndex 
.const [190] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D;I)V 
.const [191] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [195] = Utf8 resetTransformation 
.const [196] = Utf8 ()V 
.const [197] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [198] = Utf8 viewport 
.const [199] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport; 
.const [200] = Utf8 java/util/List 
.const [201] = Utf8 size 
.const [202] = Utf8 ()I 
.const [203] = Utf8 java/util/List 
.const [204] = Utf8 get 
.const [205] = Utf8 (I)Ljava/lang/Object; 
.const [206] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [207] = Utf8 isVisible 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport 
.const [210] = Utf8 setVisible 
.const [211] = Utf8 (Z)V 
.const [212] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DVisibility 
.const [213] = Class [212] 
.const [214] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [215] = Class [214] 
.const [216] = Utf8 viewport 
.const [217] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport; 
.const [218] = Utf8 Code 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;FFZILde/esolutions/hmi/widgets/audi/base/eal/IWrappedViewport;Z)V 
.const [221] = Utf8 remove 
.const [222] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D;)Z 
.const [223] = Utf8 addByIndex 
.const [224] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D;I)V 
.const [225] = Utf8 updateVisibility 
.const [226] = Utf8 ()V 
.const [227] = Utf8 toString 
.const [228] = Utf8 ()Ljava/lang/String; 
.const [229] = Utf8 resetTransformation 
.const [230] = Utf8 ()V 
.end class 
