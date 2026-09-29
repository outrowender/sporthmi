.version 50 0 
.class public super [134] 
.super [136] 
.field private final [137] [138] 
.field private volatile [139] [140] 
.field private volatile [141] [142] 
.field private volatile [143] [144] 

.method public [146] : [147] 
    .attribute [145] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [25] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [26] 
L14:    aload_0 
L15:    aload_1 
L16:    getfield [15] 
L19:    putfield [27] 
L22:    aload_0 
L23:    new [28] 
L26:    dup 
L27:    aload_0 
L28:    getfield [16] 
L31:    invokespecial [24] 
L34:    putfield [29] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [148] : [149] 
    .attribute [145] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [18] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [29] 
L18:    aload_0 
L19:    getfield [13] 
L22:    ifeq L52 
L25:    aload_0 
L26:    getfield [16] 
L29:    ldc [3] 
L31:    ldc [5] 
L33:    aload_1 
L34:    aload_0 
L35:    getfield [13] 
L38:    i2l 
L39:    invokevirtual [19] 
L42:    pop 
L43:    aload_0 
L44:    aload_0 
L45:    getfield [13] 
L48:    iconst_0 
L49:    invokevirtual [20] 
L52:    aload_0 
L53:    getfield [14] 
L56:    ifeq L86 
L59:    aload_0 
L60:    getfield [16] 
L63:    ldc [3] 
L65:    ldc [6] 
L67:    aload_1 
L68:    aload_0 
L69:    getfield [14] 
L72:    i2l 
L73:    invokevirtual [19] 
L76:    pop 
L77:    aload_0 
L78:    aload_0 
L79:    getfield [14] 
L82:    iconst_0 
L83:    invokevirtual [21] 
L86:    return 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [150] : [151] 
    .attribute [145] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [7] 
L8:     invokevirtual [22] 
L11:    pop 
L12:    aload_0 
L13:    new [28] 
L16:    dup 
L17:    aload_0 
L18:    getfield [16] 
L21:    invokespecial [24] 
L24:    putfield [29] 
L27:    return 
L28:    
    .end code 
.end method 

.method public interface [152] : [153] 
    .attribute [145] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [154] : [155] 
    .attribute [145] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     getfield [17] 
L9:     iload_1 
L10:    iload_2 
L11:    invokeinterface [30] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [156] : [157] 
    .attribute [145] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [26] 
L5:     aload_0 
L6:     getfield [17] 
L9:     iload_1 
L10:    iload_2 
L11:    invokeinterface [31] 0 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [32] 
.const [3] = Int -2137614336 
.const [4] = String [33] 
.const [5] = String [34] 
.const [6] = String [35] 
.const [7] = String [36] 
.const [8] = Class [37] 
.const [9] = Class [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Field [42] [43] 
.const [14] = Field [44] [45] 
.const [15] = Field [46] [47] 
.const [16] = Field [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Class [72] 
.const [29] = Field [73] [74] 
.const [30] = InterfaceMethod [75] [76] 
.const [31] = InterfaceMethod [77] [78] 
.const [32] = Utf8 de/audi/atip/interapp/def/NullATIPAudioServiceListener 
.const [33] = Utf8 '[InterAppHandler.register] ATIPAudioListener:%1' 
.const [34] = Utf8 '[InterAppHandler.register] %1 -> AAC:%2' 
.const [35] = Utf8 '[InterAppHandler.register] %1 -> AEC:%2' 
.const [36] = Utf8 '[InterAppHandler.deregister]' 
.const [37] = Utf8 de/audi/audio/InterAppHandler 
.const [38] = Utf8 java/lang/Object 
.const [39] = Utf8 de/audi/audio/AudioEnv 
.const [40] = Utf8 de/audi/atip/log/LogChannel 
.const [41] = Utf8 de/audi/atip/interapp/audio/ATIPAudioServiceListener 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Class [118] 
.const [69] = NameAndType [119] [120] 
.const [70] = Class [121] 
.const [71] = NameAndType [122] [123] 
.const [72] = Utf8 de/audi/atip/interapp/def/NullATIPAudioServiceListener 
.const [73] = Class [124] 
.const [74] = NameAndType [125] [126] 
.const [75] = Class [127] 
.const [76] = NameAndType [128] [129] 
.const [77] = Class [130] 
.const [78] = NameAndType [131] [132] 
.const [79] = Utf8 de/audi/audio/InterAppHandler 
.const [80] = Utf8 activeConn 
.const [81] = Utf8 I 
.const [82] = Utf8 de/audi/audio/InterAppHandler 
.const [83] = Utf8 activeEntConn 
.const [84] = Utf8 I 
.const [85] = Utf8 de/audi/audio/AudioEnv 
.const [86] = Utf8 lcMain 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/audio/InterAppHandler 
.const [89] = Utf8 lc 
.const [90] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [91] = Utf8 de/audi/audio/InterAppHandler 
.const [92] = Utf8 listener 
.const [93] = Utf8 Lde/audi/atip/interapp/audio/ATIPAudioServiceListener; 
.const [94] = Utf8 de/audi/atip/log/LogChannel 
.const [95] = Utf8 log 
.const [96] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [100] = Utf8 de/audi/audio/InterAppHandler 
.const [101] = Utf8 updateActiveConnection 
.const [102] = Utf8 (II)V 
.const [103] = Utf8 de/audi/audio/InterAppHandler 
.const [104] = Utf8 updateActiveEntertainmentConnection 
.const [105] = Utf8 (II)V 
.const [106] = Utf8 de/audi/atip/log/LogChannel 
.const [107] = Utf8 log 
.const [108] = Utf8 (ILjava/lang/String;)Z 
.const [109] = Utf8 java/lang/Object 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 de/audi/atip/interapp/def/NullATIPAudioServiceListener 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [115] = Utf8 de/audi/audio/InterAppHandler 
.const [116] = Utf8 activeConn 
.const [117] = Utf8 I 
.const [118] = Utf8 de/audi/audio/InterAppHandler 
.const [119] = Utf8 activeEntConn 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/audio/InterAppHandler 
.const [122] = Utf8 lc 
.const [123] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [124] = Utf8 de/audi/audio/InterAppHandler 
.const [125] = Utf8 listener 
.const [126] = Utf8 Lde/audi/atip/interapp/audio/ATIPAudioServiceListener; 
.const [127] = Utf8 de/audi/atip/interapp/audio/ATIPAudioServiceListener 
.const [128] = Utf8 updateActiveConnection 
.const [129] = Utf8 (II)V 
.const [130] = Utf8 de/audi/atip/interapp/audio/ATIPAudioServiceListener 
.const [131] = Utf8 updateActiveEntertainmentConnection 
.const [132] = Utf8 (II)V 
.const [133] = Utf8 de/audi/audio/InterAppHandler 
.const [134] = Class [133] 
.const [135] = Utf8 java/lang/Object 
.const [136] = Class [135] 
.const [137] = Utf8 lc 
.const [138] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [139] = Utf8 listener 
.const [140] = Utf8 Lde/audi/atip/interapp/audio/ATIPAudioServiceListener; 
.const [141] = Utf8 activeConn 
.const [142] = Utf8 I 
.const [143] = Utf8 activeEntConn 
.const [144] = Utf8 I 
.const [145] = Utf8 Code 
.const [146] = Utf8 <init> 
.const [147] = Utf8 (Lde/audi/audio/AudioEnv;)V 
.const [148] = Utf8 register 
.const [149] = Utf8 (Lde/audi/atip/interapp/audio/ATIPAudioServiceListener;)V 
.const [150] = Utf8 deregister 
.const [151] = Utf8 ()V 
.const [152] = Utf8 getListener 
.const [153] = Utf8 ()Lde/audi/atip/interapp/audio/ATIPAudioServiceListener; 
.const [154] = Utf8 updateActiveConnection 
.const [155] = Utf8 (II)V 
.const [156] = Utf8 updateActiveEntertainmentConnection 
.const [157] = Utf8 (II)V 
.end class 
