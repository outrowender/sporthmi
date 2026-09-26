.version 50 0 
.class public super [175] 
.super [177] 
.field protected [178] [179] 
.field protected [180] [181] 

.method public [183] : [184] 
    .attribute [182] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [26] 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [12] 
L10:    putfield [29] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [185] : [186] 
    .attribute [182] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [27] 
L5:     aload_0 
L6:     getfield [13] 
L9:     ifnull L35 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [13] 
L17:    invokeinterface [30] 0 
L22:    aload_1 
L23:    getfield [14] 
L26:    invokeinterface [31] 0 
L31:    fadd 
L32:    putfield [32] 
L35:    return 
L36:    
    .end code 
.end method 

.method protected [187] : [188] 
    .attribute [182] .code stack 4 locals 4 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokevirtual [12] 
L7:     aload_0 
L8:     getfield [13] 
L11:    invokeinterface [33] 0 
L16:    aload_1 
L17:    iconst_0 
L18:    faload 
L19:    fmul 
L20:    aload_0 
L21:    getfield [17] 
L24:    invokestatic [2] 
L27:    fstore_3 
L28:    aload_0 
L29:    getfield [16] 
L32:    invokevirtual [18] 
L35:    aload_0 
L36:    getfield [13] 
L39:    invokeinterface [34] 0 
L44:    aload_1 
L45:    iconst_1 
L46:    faload 
L47:    fmul 
L48:    aload_0 
L49:    getfield [19] 
L52:    invokestatic [2] 
L55:    fstore 4 
L57:    aload_0 
L58:    getfield [16] 
L61:    invokevirtual [20] 
L64:    i2f 
L65:    aload_0 
L66:    getfield [21] 
L69:    fadd 
L70:    fload_3 
L71:    fadd 
L72:    fstore 5 
L74:    aload_0 
L75:    getfield [16] 
L78:    invokevirtual [22] 
L81:    i2f 
L82:    aload_0 
L83:    getfield [23] 
L86:    fadd 
L87:    fload 4 
L89:    fadd 
L90:    fstore 6 
L92:    aload_2 
L93:    getfield [14] 
L96:    invokeinterface [31] 0 
L101:   fload 5 
L103:   fadd 
L104:   aload_0 
L105:   getfield [15] 
L108:   fsub 
L109:   f2i 
L110:   invokestatic [3] 
L113:   iconst_2 
L114:   if_icmpge L146 
L117:   aload_0 
L118:   getfield [13] 
L121:   aload_0 
L122:   getfield [15] 
L125:   aload_2 
L126:   getfield [14] 
L129:   invokeinterface [31] 0 
L134:   fsub 
L135:   fload 6 
L137:   fconst_0 
L138:   invokeinterface [35] 0 
L143:   goto L183 
L146:   aload_0 
L147:   aload_0 
L148:   getfield [13] 
L151:   invokeinterface [30] 0 
L156:   aload_2 
L157:   getfield [14] 
L160:   invokeinterface [31] 0 
L165:   fadd 
L166:   putfield [32] 
L169:   aload_0 
L170:   getfield [13] 
L173:   fload 5 
L175:   fload 6 
L177:   fconst_0 
L178:   invokeinterface [35] 0 
L183:   aload_0 
L184:   aload_0 
L185:   getfield [13] 
L188:   invokeinterface [30] 0 
L193:   aload_2 
L194:   getfield [14] 
L197:   invokeinterface [31] 0 
L202:   fadd 
L203:   putfield [32] 
L206:   return 
L207:   nop 
L208:   
    .end code 
.end method 

.method public [189] : [190] 
    .attribute [182] .code stack 4 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [28] 
L7:     aload_0 
L8:     getfield [16] 
L11:    invokevirtual [24] 
L14:    astore 4 
L16:    aload 4 
L18:    instanceof [4] 
L21:    ifeq L32 
L24:    aload 4 
L26:    checkcast [4] 
L29:    invokevirtual [25] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Method [38] [39] 
.const [4] = Class [40] 
.const [5] = Class [41] 
.const [6] = Class [42] 
.const [7] = Class [43] 
.const [8] = Class [44] 
.const [9] = Class [45] 
.const [10] = Class [46] 
.const [11] = Class [47] 
.const [12] = Method [48] [49] 
.const [13] = Field [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Field [54] [55] 
.const [16] = Field [56] [57] 
.const [17] = Field [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Field [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Field [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Field [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = InterfaceMethod [84] [85] 
.const [31] = InterfaceMethod [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = InterfaceMethod [90] [91] 
.const [34] = InterfaceMethod [92] [93] 
.const [35] = InterfaceMethod [94] [95] 
.const [36] = Class [96] 
.const [37] = NameAndType [97] [98] 
.const [38] = Class [99] 
.const [39] = NameAndType [100] [101] 
.const [40] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconCrossFadeController 
.const [41] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighAsync 
.const [43] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [44] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh 
.const [46] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [47] = Utf8 java/lang/Math 
.const [48] = Class [102] 
.const [49] = NameAndType [103] [104] 
.const [50] = Class [105] 
.const [51] = NameAndType [106] [107] 
.const [52] = Class [108] 
.const [53] = NameAndType [109] [110] 
.const [54] = Class [111] 
.const [55] = NameAndType [112] [113] 
.const [56] = Class [114] 
.const [57] = NameAndType [115] [116] 
.const [58] = Class [117] 
.const [59] = NameAndType [118] [119] 
.const [60] = Class [120] 
.const [61] = NameAndType [121] [122] 
.const [62] = Class [123] 
.const [63] = NameAndType [124] [125] 
.const [64] = Class [126] 
.const [65] = NameAndType [127] [128] 
.const [66] = Class [129] 
.const [67] = NameAndType [130] [131] 
.const [68] = Class [132] 
.const [69] = NameAndType [133] [134] 
.const [70] = Class [135] 
.const [71] = NameAndType [136] [137] 
.const [72] = Class [138] 
.const [73] = NameAndType [139] [140] 
.const [74] = Class [141] 
.const [75] = NameAndType [142] [143] 
.const [76] = Class [144] 
.const [77] = NameAndType [145] [146] 
.const [78] = Class [147] 
.const [79] = NameAndType [148] [149] 
.const [80] = Class [150] 
.const [81] = NameAndType [151] [152] 
.const [82] = Class [153] 
.const [83] = NameAndType [154] [155] 
.const [84] = Class [156] 
.const [85] = NameAndType [157] [158] 
.const [86] = Class [159] 
.const [87] = NameAndType [160] [161] 
.const [88] = Class [162] 
.const [89] = NameAndType [163] [164] 
.const [90] = Class [165] 
.const [91] = NameAndType [166] [167] 
.const [92] = Class [168] 
.const [93] = NameAndType [169] [170] 
.const [94] = Class [171] 
.const [95] = NameAndType [172] [173] 
.const [96] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [97] = Utf8 calculateNodeOffset 
.const [98] = Utf8 (IFI)F 
.const [99] = Utf8 java/lang/Math 
.const [100] = Utf8 abs 
.const [101] = Utf8 (I)I 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [103] = Utf8 getWidth 
.const [104] = Utf8 ()I 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [106] = Utf8 node 
.const [107] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage; 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh 
.const [109] = Utf8 parentNode 
.const [110] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D; 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [112] = Utf8 lastNodePosition 
.const [113] = Utf8 F 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [115] = Utf8 controller 
.const [116] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController; 
.const [117] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [118] = Utf8 alignmentHoriz 
.const [119] = Utf8 I 
.const [120] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [121] = Utf8 getHeight 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [124] = Utf8 alignmentVert 
.const [125] = Utf8 I 
.const [126] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [127] = Utf8 getX 
.const [128] = Utf8 ()I 
.const [129] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [130] = Utf8 x0 
.const [131] = Utf8 F 
.const [132] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [133] = Utf8 getY 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [136] = Utf8 y0 
.const [137] = Utf8 F 
.const [138] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [139] = Utf8 getParent 
.const [140] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/AbstractWidget; 
.const [141] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconCrossFadeController 
.const [142] = Utf8 startCrossFadingAnimation 
.const [143] = Utf8 ()V 
.const [144] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighAsync 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController;)V 
.const [147] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighAsync 
.const [148] = Utf8 renderNode 
.const [149] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh;)V 
.const [150] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighAsync 
.const [151] = Utf8 resourceLoadedCallback 
.const [152] = Utf8 (ILjava/lang/Object;Lde/audi/atip/hmi/event/ATIPEvent;)V 
.const [153] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [154] = Utf8 lastControllerWidth 
.const [155] = Utf8 I 
.const [156] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [157] = Utf8 getX 
.const [158] = Utf8 ()F 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3D 
.const [160] = Utf8 getX 
.const [161] = Utf8 ()F 
.const [162] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [163] = Utf8 lastNodePosition 
.const [164] = Utf8 F 
.const [165] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [166] = Utf8 getUnscaledWidth 
.const [167] = Utf8 ()F 
.const [168] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [169] = Utf8 getUnscaledHeight 
.const [170] = Utf8 ()F 
.const [171] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DImage 
.const [172] = Utf8 setPosition 
.const [173] = Utf8 (FFF)V 
.const [174] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighSlideshow 
.const [175] = Class [174] 
.const [176] = Utf8 de/esolutions/hmi/widgets/audi/evo/high/widgets/IconRendererHighAsync 
.const [177] = Class [176] 
.const [178] = Utf8 lastControllerWidth 
.const [179] = Utf8 I 
.const [180] = Utf8 lastNodePosition 
.const [181] = Utf8 F 
.const [182] = Utf8 Code 
.const [183] = Utf8 <init> 
.const [184] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/widgets/IconController;)V 
.const [185] = Utf8 renderNode 
.const [186] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh;)V 
.const [187] = Utf8 calculatePosition 
.const [188] = Utf8 ([FLde/esolutions/hmi/widgets/audi/evo/high/RedrawContextHigh;)V 
.const [189] = Utf8 resourceLoadedCallback 
.const [190] = Utf8 (ILjava/lang/Object;Lde/audi/atip/hmi/event/ATIPEvent;)V 
.end class 
