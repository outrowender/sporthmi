.version 50 0 
.class public super [85] 
.super [87] 
.implements [89] 
.field private final [90] [91] 
.field private [92] [93] 

.method public [95] : [96] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [17] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    new [20] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [18] 
L18:    putfield [21] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifeq L28 
L7:     aload_0 
L8:     getfield [13] 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    aload_1 
L16:    invokevirtual [15] 
L19:    pop 
L20:    aload_0 
L21:    aload_1 
L22:    checkcast [3] 
L25:    putfield [21] 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_1 
L1:     instanceof [3] 
L4:     ifeq L35 
L7:     aload_0 
L8:     getfield [13] 
L11:    ldc [6] 
L13:    ldc [7] 
L15:    aload_1 
L16:    invokevirtual [15] 
L19:    pop 
L20:    aload_0 
L21:    new [20] 
L24:    dup 
L25:    aload_0 
L26:    getfield [13] 
L29:    invokespecial [18] 
L32:    putfield [21] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [94] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [4] 
L6:     ldc [8] 
L8:     invokevirtual [16] 
L11:    pop 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokeinterface [22] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [94] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ldc [4] 
L6:     ldc [9] 
L8:     invokevirtual [16] 
L11:    pop 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokeinterface [23] 0 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Int -2137614336 
.const [5] = String [26] 
.const [6] = Int 1078071040 
.const [7] = String [27] 
.const [8] = String [28] 
.const [9] = String [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Class [32] 
.const [13] = Field [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Class [47] 
.const [21] = Field [48] [49] 
.const [22] = InterfaceMethod [50] [51] 
.const [23] = InterfaceMethod [52] [53] 
.const [24] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [25] = Utf8 de/audi/atip/interapp/SDSService 
.const [26] = Utf8 '[SDSSamplePlayer.registerService] %1' 
.const [27] = Utf8 '[SDSSamplePlayer.deregisterService] %1' 
.const [28] = Utf8 'SDSSamplePlayer.play(): Sending SDS command VOLUME!' 
.const [29] = Utf8 'SDSSamplePlayer.stop(): Sending SDS command SILENT_ABORT!' 
.const [30] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/audi/atip/log/LogChannel 
.const [33] = Class [54] 
.const [34] = NameAndType [55] [56] 
.const [35] = Class [57] 
.const [36] = NameAndType [58] [59] 
.const [37] = Class [60] 
.const [38] = NameAndType [61] [62] 
.const [39] = Class [63] 
.const [40] = NameAndType [64] [65] 
.const [41] = Class [66] 
.const [42] = NameAndType [67] [68] 
.const [43] = Class [69] 
.const [44] = NameAndType [70] [71] 
.const [45] = Class [72] 
.const [46] = NameAndType [73] [74] 
.const [47] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [48] = Class [75] 
.const [49] = NameAndType [76] [77] 
.const [50] = Class [78] 
.const [51] = NameAndType [79] [80] 
.const [52] = Class [81] 
.const [53] = NameAndType [82] [83] 
.const [54] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [55] = Utf8 lc 
.const [56] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [57] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [58] = Utf8 sdsService 
.const [59] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 log 
.const [62] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [63] = Utf8 de/audi/atip/log/LogChannel 
.const [64] = Utf8 log 
.const [65] = Utf8 (ILjava/lang/String;)Z 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 <init> 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/audi/atip/interapp/def/NullSDSService 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [72] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [73] = Utf8 lc 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [76] = Utf8 sdsService 
.const [77] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [78] = Utf8 de/audi/atip/interapp/SDSService 
.const [79] = Utf8 startVolumeSettingSession 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/audi/atip/interapp/SDSService 
.const [82] = Utf8 stopVolumeSettingSession 
.const [83] = Utf8 ()V 
.const [84] = Utf8 de/audi/tone/app/volume/samples/SDSSamplePlayer 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 de/audi/tone/app/volume/samples/ISamplePlayer 
.const [89] = Class [88] 
.const [90] = Utf8 lc 
.const [91] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [92] = Utf8 sdsService 
.const [93] = Utf8 Lde/audi/atip/interapp/SDSService; 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [97] = Utf8 registerService 
.const [98] = Utf8 (Ljava/lang/Object;)V 
.const [99] = Utf8 deregisterService 
.const [100] = Utf8 (Ljava/lang/Object;)V 
.const [101] = Utf8 play 
.const [102] = Utf8 ()V 
.const [103] = Utf8 stop 
.const [104] = Utf8 ()V 
.end class 
