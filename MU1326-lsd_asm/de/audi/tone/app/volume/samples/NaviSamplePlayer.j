.version 50 0 
.class public super [95] 
.super [97] 
.implements [99] 
.field private [100] [101] 
.field private final [102] [103] 
.field private volatile [104] [105] 

.method public [107] : [108] 
    .attribute [106] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    new [23] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [21] 
L18:    putfield [24] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [106] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifeq L31 
L7:     aload_0 
L8:     getfield [15] 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    aload_1 
L16:    invokevirtual [17] 
L19:    pop 
L20:    aload_0 
L21:    aload_1 
L22:    checkcast [3] 
L25:    putfield [24] 
L28:    goto L44 
L31:    aload_0 
L32:    getfield [15] 
L35:    ldc [4] 
L37:    ldc [6] 
L39:    aload_1 
L40:    invokevirtual [17] 
L43:    pop 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [106] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifeq L35 
L7:     aload_0 
L8:     getfield [15] 
L11:    ldc [7] 
L13:    ldc [8] 
L15:    aload_1 
L16:    invokevirtual [17] 
L19:    pop 
L20:    aload_0 
L21:    new [23] 
L24:    dup 
L25:    aload_0 
L26:    getfield [15] 
L29:    invokespecial [21] 
L32:    putfield [24] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [113] : [114] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifne L37 
L7:     aload_0 
L8:     getfield [15] 
L11:    ldc [4] 
L13:    ldc [9] 
L15:    invokevirtual [19] 
L18:    pop 
L19:    aload_0 
L20:    getfield [16] 
L23:    iconst_1 
L24:    invokeinterface [26] 0 
L29:    aload_0 
L30:    iconst_1 
L31:    putfield [25] 
L34:    goto L49 
L37:    aload_0 
L38:    getfield [15] 
L41:    ldc [4] 
L43:    ldc [10] 
L45:    invokevirtual [19] 
L48:    pop 
L49:    return 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [106] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ldc [4] 
L6:     ldc [11] 
L8:     invokevirtual [19] 
L11:    pop 
L12:    aload_0 
L13:    getfield [16] 
L16:    iconst_0 
L17:    invokeinterface [26] 0 
L22:    aload_0 
L23:    iconst_0 
L24:    putfield [25] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [27] 
.const [3] = Class [28] 
.const [4] = Int -2137614336 
.const [5] = String [29] 
.const [6] = String [30] 
.const [7] = Int 1078071040 
.const [8] = String [31] 
.const [9] = String [32] 
.const [10] = String [33] 
.const [11] = String [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Class [37] 
.const [15] = Field [38] [39] 
.const [16] = Field [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Field [52] [53] 
.const [23] = Class [54] 
.const [24] = Field [55] [56] 
.const [25] = Field [57] [58] 
.const [26] = InterfaceMethod [59] [60] 
.const [27] = Utf8 de/audi/atip/interapp/def/NullNaviService 
.const [28] = Utf8 de/audi/atip/interapp/NaviService 
.const [29] = Utf8 '[NaviSamplePlayer.registerService] service: %1' 
.const [30] = Utf8 '[NaviSamplePlayer.registerService] service: %1 is not instanceof NaviService' 
.const [31] = Utf8 '[NaviSamplePlayer.deregisterService]' 
.const [32] = Utf8 '[NaviSamplePlayer.play]' 
.const [33] = Utf8 '[NaviSamplePlayer.play] ignored (already playing)' 
.const [34] = Utf8 '[NaviSamplePlayer.stop]' 
.const [35] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Class [61] 
.const [39] = NameAndType [62] [63] 
.const [40] = Class [64] 
.const [41] = NameAndType [65] [66] 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Class [73] 
.const [47] = NameAndType [74] [75] 
.const [48] = Class [76] 
.const [49] = NameAndType [77] [78] 
.const [50] = Class [79] 
.const [51] = NameAndType [80] [81] 
.const [52] = Class [82] 
.const [53] = NameAndType [83] [84] 
.const [54] = Utf8 de/audi/atip/interapp/def/NullNaviService 
.const [55] = Class [85] 
.const [56] = NameAndType [86] [87] 
.const [57] = Class [88] 
.const [58] = NameAndType [89] [90] 
.const [59] = Class [91] 
.const [60] = NameAndType [92] [93] 
.const [61] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [62] = Utf8 lc 
.const [63] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [65] = Utf8 naviService 
.const [66] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [67] = Utf8 de/audi/atip/log/LogChannel 
.const [68] = Utf8 log 
.const [69] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [70] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [71] = Utf8 playing 
.const [72] = Utf8 Z 
.const [73] = Utf8 de/audi/atip/log/LogChannel 
.const [74] = Utf8 log 
.const [75] = Utf8 (ILjava/lang/String;)Z 
.const [76] = Utf8 java/lang/Object 
.const [77] = Utf8 <init> 
.const [78] = Utf8 ()V 
.const [79] = Utf8 de/audi/atip/interapp/def/NullNaviService 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [82] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [83] = Utf8 lc 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [86] = Utf8 naviService 
.const [87] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [88] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [89] = Utf8 playing 
.const [90] = Utf8 Z 
.const [91] = Utf8 de/audi/atip/interapp/NaviService 
.const [92] = Utf8 setAnnouncementRepeatMode 
.const [93] = Utf8 (Z)V 
.const [94] = Utf8 de/audi/tone/app/volume/samples/NaviSamplePlayer 
.const [95] = Class [94] 
.const [96] = Utf8 java/lang/Object 
.const [97] = Class [96] 
.const [98] = Utf8 de/audi/tone/app/volume/samples/ISamplePlayer 
.const [99] = Class [98] 
.const [100] = Utf8 naviService 
.const [101] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [102] = Utf8 lc 
.const [103] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [104] = Utf8 playing 
.const [105] = Utf8 Z 
.const [106] = Utf8 Code 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [109] = Utf8 registerService 
.const [110] = Utf8 (Ljava/lang/Object;)V 
.const [111] = Utf8 deregisterService 
.const [112] = Utf8 (Ljava/lang/Object;)V 
.const [113] = Utf8 play 
.const [114] = Utf8 ()V 
.const [115] = Utf8 stop 
.const [116] = Utf8 ()V 
.end class 
