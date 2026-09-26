.version 50 0 
.class public super [99] 
.super [101] 
.field private final [102] [103] 
.field private [104] [105] 
.field private volatile [106] [107] 

.method public [109] : [110] 
    .attribute [108] .code stack 5 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [22] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [23] 
L14:    aload_0 
L15:    new [24] 
L18:    dup 
L19:    aload_1 
L20:    getfield [16] 
L23:    ldc [3] 
L25:    invokespecial [21] 
L28:    putfield [25] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [108] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     getfield [16] 
L7:     ldc [4] 
L9:     ldc [5] 
L11:    iload_1 
L12:    i2l 
L13:    invokevirtual [18] 
L16:    pop 
L17:    aload_0 
L18:    iload_1 
L19:    putfield [22] 
L22:    aload_0 
L23:    getfield [17] 
L26:    aload_0 
L27:    getfield [14] 
L30:    invokeinterface [26] 0 
L35:    return 
L36:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [108] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     getfield [16] 
L7:     ldc [6] 
L9:     ldc [7] 
L11:    aload_1 
L12:    invokevirtual [19] 
L15:    pop 
L16:    aload_0 
L17:    aload_1 
L18:    putfield [25] 
L21:    aload_0 
L22:    getfield [14] 
L25:    iconst_m1 
L26:    if_icmpeq L42 
L29:    aload_0 
L30:    getfield [17] 
L33:    aload_0 
L34:    getfield [14] 
L37:    invokeinterface [26] 0 
L42:    return 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [108] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     getfield [16] 
L7:     ldc [6] 
L9:     ldc [8] 
L11:    aload_1 
L12:    invokevirtual [19] 
L15:    pop 
L16:    aload_0 
L17:    new [24] 
L20:    dup 
L21:    aload_0 
L22:    getfield [15] 
L25:    getfield [16] 
L28:    ldc [3] 
L30:    invokespecial [21] 
L33:    putfield [25] 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = String [28] 
.const [4] = Int 1078071040 
.const [5] = String [29] 
.const [6] = Int -2137614336 
.const [7] = String [30] 
.const [8] = String [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Class [57] 
.const [25] = Field [58] [59] 
.const [26] = InterfaceMethod [60] [61] 
.const [27] = Utf8 de/audi/tone/app/NullAmplifierListener 
.const [28] = Utf8 AmplifierListener 
.const [29] = Utf8 '[AmplifierProvider.updateAmplifier] amplifier: %1' 
.const [30] = Utf8 '[AmplifierProvider.registerService] service  registered: %1' 
.const [31] = Utf8 '[AmplifierProvider.deregisterService] service  registered: %1' 
.const [32] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [33] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [34] = Utf8 de/audi/tone/app/ToneEnv 
.const [35] = Utf8 de/audi/atip/log/LogChannel 
.const [36] = Utf8 de/audi/atip/interapp/audio/AmplifierListener 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Class [86] 
.const [54] = NameAndType [87] [88] 
.const [55] = Class [89] 
.const [56] = NameAndType [90] [91] 
.const [57] = Utf8 de/audi/tone/app/NullAmplifierListener 
.const [58] = Class [92] 
.const [59] = NameAndType [93] [94] 
.const [60] = Class [95] 
.const [61] = NameAndType [96] [97] 
.const [62] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [63] = Utf8 cachedAmplifier 
.const [64] = Utf8 I 
.const [65] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [66] = Utf8 env 
.const [67] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [68] = Utf8 de/audi/tone/app/ToneEnv 
.const [69] = Utf8 lcMain 
.const [70] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [71] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [72] = Utf8 amplifierListener 
.const [73] = Utf8 Lde/audi/atip/interapp/audio/AmplifierListener; 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;J)Z 
.const [77] = Utf8 de/audi/atip/log/LogChannel 
.const [78] = Utf8 log 
.const [79] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [80] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/audi/tone/app/NullAmplifierListener 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;)V 
.const [86] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [87] = Utf8 cachedAmplifier 
.const [88] = Utf8 I 
.const [89] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [90] = Utf8 env 
.const [91] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [92] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [93] = Utf8 amplifierListener 
.const [94] = Utf8 Lde/audi/atip/interapp/audio/AmplifierListener; 
.const [95] = Utf8 de/audi/atip/interapp/audio/AmplifierListener 
.const [96] = Utf8 updateAmplifier 
.const [97] = Utf8 (I)V 
.const [98] = Utf8 de/audi/tone/app/AmplifierProvider 
.const [99] = Class [98] 
.const [100] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [101] = Class [100] 
.const [102] = Utf8 env 
.const [103] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [104] = Utf8 amplifierListener 
.const [105] = Utf8 Lde/audi/atip/interapp/audio/AmplifierListener; 
.const [106] = Utf8 cachedAmplifier 
.const [107] = Utf8 I 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Lde/audi/tone/app/ToneEnv;)V 
.const [111] = Utf8 updateAmplifier 
.const [112] = Utf8 (I)V 
.const [113] = Utf8 registerService 
.const [114] = Utf8 (Lde/audi/atip/interapp/audio/AmplifierListener;)V 
.const [115] = Utf8 deregisterService 
.const [116] = Utf8 (Lde/audi/atip/interapp/audio/AmplifierListener;)V 
.end class 
