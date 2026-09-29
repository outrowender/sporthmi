.version 50 0 
.class super abstract [161] 
.super [163] 
.field protected [164] [165] 
.field protected [166] [167] 
.field private [168] [169] 
.field private [170] [171] 
.field private final synthetic [172] [173] 

.method private [175] : [176] 
    .attribute [174] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [32] 
L5:     aload_0 
L6:     invokespecial [29] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [33] 
L14:    aload_0 
L15:    iload_2 
L16:    putfield [34] 
L19:    return 
L20:    
    .end code 
.end method 

.method private interface [177] : [178] 
    .attribute [174] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method [179] : [180] 
    .attribute [174] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [35] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synchronized [181] : [182] 
    .attribute [174] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    invokevirtual [21] 
L14:    pop 
L15:    aload_0 
L16:    getfield [18] 
L19:    ifne L107 
        .catch [8] from L22 to L93 using L99 
L22:    aload_0 
L23:    getfield [17] 
L26:    invokestatic [2] 
L29:    ldc [3] 
L31:    ldc [5] 
L33:    invokevirtual [21] 
L36:    pop 
L37:    invokestatic [6] 
L40:    lstore_1 
L41:    aload_0 
L42:    ldc_w [1] 
L45:    invokespecial [30] 
L48:    invokestatic [6] 
L51:    lstore_3 
L52:    aload_0 
L53:    getfield [18] 
L56:    ifne L96 
L59:    aload_0 
L60:    getfield [17] 
L63:    invokestatic [2] 
L66:    ldc [3] 
L68:    ldc [7] 
L70:    lload_3 
L71:    lload_1 
L72:    lsub 
L73:    invokevirtual [22] 
L76:    pop 
L77:    aload_0 
L78:    getfield [20] 
L81:    ifnull L93 
L84:    aload_0 
L85:    getfield [20] 
L88:    aconst_null 
L89:    iconst_0 
L90:    invokevirtual [23] 
L93:    goto L107 
L96:    goto L15 
L99:    astore_1 
L100:   aload_1 
L101:   invokevirtual [24] 
L104:   goto L15 
L107:   aload_0 
L108:   getfield [25] 
L111:   ifnull L122 
L114:   aload_0 
L115:   aload_0 
L116:   getfield [25] 
L119:   invokevirtual [26] 
L122:   aload_0 
L123:   getfield [25] 
L126:   areturn 
L127:   nop 
L128:   
    .end code 
.end method 

.method protected abstract [183] : [184] 
    .attribute [174] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method synchronized [185] : [186] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [9] 
L11:    invokevirtual [21] 
L14:    pop 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [36] 
L20:    aload_0 
L21:    iload_2 
L22:    putfield [33] 
L25:    aload_0 
L26:    invokespecial [31] 
L29:    aload_0 
L30:    getfield [17] 
L33:    invokestatic [2] 
L36:    ldc [3] 
L38:    ldc [10] 
L40:    invokevirtual [21] 
L43:    pop 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method static synthetic [187] : [188] 
    .attribute [174] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [28] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synthetic [189] : [190] 
    .attribute [174] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokespecial [27] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [38] [39] 
.const [3] = Int -2137614336 
.const [4] = String [40] 
.const [5] = String [41] 
.const [6] = Method [42] [43] 
.const [7] = String [44] 
.const [8] = Class [45] 
.const [9] = String [46] 
.const [10] = String [47] 
.const [11] = Class [48] 
.const [12] = Class [49] 
.const [13] = Class [50] 
.const [14] = Class [51] 
.const [15] = Class [52] 
.const [16] = Class [53] 
.const [17] = Field [54] [55] 
.const [18] = Field [56] [57] 
.const [19] = Field [58] [59] 
.const [20] = Field [60] [61] 
.const [21] = Method [62] [63] 
.const [22] = Method [64] [65] 
.const [23] = Method [66] [67] 
.const [24] = Method [68] [69] 
.const [25] = Field [70] [71] 
.const [26] = Method [72] [73] 
.const [27] = Method [74] [75] 
.const [28] = Method [76] [77] 
.const [29] = Method [78] [79] 
.const [30] = Method [80] [81] 
.const [31] = Method [82] [83] 
.const [32] = Field [84] [85] 
.const [33] = Field [86] [87] 
.const [34] = Field [88] [89] 
.const [35] = Field [90] [91] 
.const [36] = Field [92] [93] 
.const [37] = Int -2012020736 
.const [38] = Class [94] 
.const [39] = NameAndType [95] [96] 
.const [40] = Utf8 '[IconRenderer#QueueElement#waitForResponse] called' 
.const [41] = Utf8 '[IconRenderer#QueueElement#waitForResponse] Wait...' 
.const [42] = Class [97] 
.const [43] = NameAndType [98] [99] 
.const [44] = Utf8 '[IconRenderer#QueueElement#waitForResponse] Timeout, time: %1' 
.const [45] = Utf8 java/lang/InterruptedException 
.const [46] = Utf8 '[IconRenderer#QueueElement#setRenderingInfo] called' 
.const [47] = Utf8 '[IconRenderer#QueueElement#setRenderingInfo] Notify' 
.const [48] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$RequestQueue 
.const [51] = Utf8 de/audi/tghu/iconrenderer/IconRenderer 
.const [52] = Utf8 de/audi/atip/log/LogChannel 
.const [53] = Utf8 java/lang/System 
.const [54] = Class [100] 
.const [55] = NameAndType [101] [102] 
.const [56] = Class [103] 
.const [57] = NameAndType [104] [105] 
.const [58] = Class [106] 
.const [59] = NameAndType [107] [108] 
.const [60] = Class [109] 
.const [61] = NameAndType [110] [111] 
.const [62] = Class [112] 
.const [63] = NameAndType [113] [114] 
.const [64] = Class [115] 
.const [65] = NameAndType [116] [117] 
.const [66] = Class [118] 
.const [67] = NameAndType [119] [120] 
.const [68] = Class [121] 
.const [69] = NameAndType [122] [123] 
.const [70] = Class [124] 
.const [71] = NameAndType [125] [126] 
.const [72] = Class [127] 
.const [73] = NameAndType [128] [129] 
.const [74] = Class [130] 
.const [75] = NameAndType [131] [132] 
.const [76] = Class [133] 
.const [77] = NameAndType [134] [135] 
.const [78] = Class [136] 
.const [79] = NameAndType [137] [138] 
.const [80] = Class [139] 
.const [81] = NameAndType [140] [141] 
.const [82] = Class [142] 
.const [83] = NameAndType [143] [144] 
.const [84] = Class [145] 
.const [85] = NameAndType [146] [147] 
.const [86] = Class [148] 
.const [87] = NameAndType [149] [150] 
.const [88] = Class [151] 
.const [89] = NameAndType [152] [153] 
.const [90] = Class [154] 
.const [91] = NameAndType [155] [156] 
.const [92] = Class [157] 
.const [93] = NameAndType [158] [159] 
.const [94] = Utf8 de/audi/tghu/iconrenderer/IconRenderer 
.const [95] = Utf8 access$300 
.const [96] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer;)Lde/audi/atip/log/LogChannel; 
.const [97] = Utf8 java/lang/System 
.const [98] = Utf8 currentTimeMillis 
.const [99] = Utf8 ()J 
.const [100] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [101] = Utf8 this$0 
.const [102] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer; 
.const [103] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [104] = Utf8 responseReceived 
.const [105] = Utf8 Z 
.const [106] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [107] = Utf8 requestType 
.const [108] = Utf8 I 
.const [109] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [110] = Utf8 queue 
.const [111] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer$RequestQueue; 
.const [112] = Utf8 de/audi/atip/log/LogChannel 
.const [113] = Utf8 log 
.const [114] = Utf8 (ILjava/lang/String;)Z 
.const [115] = Utf8 de/audi/atip/log/LogChannel 
.const [116] = Utf8 log 
.const [117] = Utf8 (ILjava/lang/String;J)Z 
.const [118] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$RequestQueue 
.const [119] = Utf8 dequeue 
.const [120] = Utf8 (Lde/audi/atip/interapp/icon/RenderingInfo;Z)V 
.const [121] = Utf8 java/lang/InterruptedException 
.const [122] = Utf8 printStackTrace 
.const [123] = Utf8 ()V 
.const [124] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [125] = Utf8 renderingInfo 
.const [126] = Utf8 Lde/audi/atip/interapp/icon/RenderingInfo; 
.const [127] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [128] = Utf8 putIntoCache 
.const [129] = Utf8 (Lde/audi/atip/interapp/icon/RenderingInfo;)V 
.const [130] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer;I)V 
.const [133] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [134] = Utf8 getRequestType 
.const [135] = Utf8 ()I 
.const [136] = Utf8 java/lang/Object 
.const [137] = Utf8 <init> 
.const [138] = Utf8 ()V 
.const [139] = Utf8 java/lang/Object 
.const [140] = Utf8 wait 
.const [141] = Utf8 (J)V 
.const [142] = Utf8 java/lang/Object 
.const [143] = Utf8 notifyAll 
.const [144] = Utf8 ()V 
.const [145] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [146] = Utf8 this$0 
.const [147] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer; 
.const [148] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [149] = Utf8 responseReceived 
.const [150] = Utf8 Z 
.const [151] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [152] = Utf8 requestType 
.const [153] = Utf8 I 
.const [154] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [155] = Utf8 queue 
.const [156] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer$RequestQueue; 
.const [157] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [158] = Utf8 renderingInfo 
.const [159] = Utf8 Lde/audi/atip/interapp/icon/RenderingInfo; 
.const [160] = Utf8 de/audi/tghu/iconrenderer/IconRenderer$QueueElement 
.const [161] = Class [160] 
.const [162] = Utf8 java/lang/Object 
.const [163] = Class [162] 
.const [164] = Utf8 queue 
.const [165] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer$RequestQueue; 
.const [166] = Utf8 requestType 
.const [167] = Utf8 I 
.const [168] = Utf8 responseReceived 
.const [169] = Utf8 Z 
.const [170] = Utf8 renderingInfo 
.const [171] = Utf8 Lde/audi/atip/interapp/icon/RenderingInfo; 
.const [172] = Utf8 this$0 
.const [173] = Utf8 Lde/audi/tghu/iconrenderer/IconRenderer; 
.const [174] = Utf8 Code 
.const [175] = Utf8 <init> 
.const [176] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer;I)V 
.const [177] = Utf8 getRequestType 
.const [178] = Utf8 ()I 
.const [179] = Utf8 setQueue 
.const [180] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer$RequestQueue;)V 
.const [181] = Utf8 waitForResponse 
.const [182] = Utf8 ()Lde/audi/atip/interapp/icon/RenderingInfo; 
.const [183] = Utf8 putIntoCache 
.const [184] = Utf8 (Lde/audi/atip/interapp/icon/RenderingInfo;)V 
.const [185] = Utf8 setRenderingInfo 
.const [186] = Utf8 (Lde/audi/atip/interapp/icon/RenderingInfo;Z)V 
.const [187] = Utf8 access$400 
.const [188] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer$QueueElement;)I 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Lde/audi/tghu/iconrenderer/IconRenderer;ILde/audi/tghu/iconrenderer/IconRenderer$1;)V 
.end class 
