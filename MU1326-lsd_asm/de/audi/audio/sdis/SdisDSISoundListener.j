.version 50 0 
.class public super [116] 
.super [118] 
.implements [120] 
.field private final [121] [122] 
.field private final [123] [124] 

.method public [126] : [127] 
    .attribute [125] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [25] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [128] : [129] 
    .attribute [125] .code stack 5 locals 0 
L0:     iload_3 
L1:     iconst_1 
L2:     if_icmpne L26 
L5:     aload_0 
L6:     getfield [17] 
L9:     new [26] 
L12:    dup 
L13:    iload_1 
L14:    iload_2 
L15:    invokespecial [22] 
L18:    invokeinterface [27] 0 
L23:    goto L41 
L26:    aload_0 
L27:    getfield [16] 
L30:    getfield [18] 
L33:    ldc [3] 
L35:    ldc [4] 
L37:    invokevirtual [19] 
L40:    pop 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [125] .code stack 7 locals 0 
L0:     iload 4 
L2:     iconst_1 
L3:     if_icmpne L46 
L6:     aload_0 
L7:     iload_1 
L8:     invokespecial [23] 
L11:    ifeq L46 
L14:    aload_0 
L15:    getfield [16] 
L18:    getfield [18] 
L21:    ldc [3] 
L23:    ldc [5] 
L25:    iload_1 
L26:    i2l 
L27:    iload_3 
L28:    i2l 
L29:    invokevirtual [20] 
L32:    pop 
L33:    aload_0 
L34:    getfield [17] 
L37:    iload_3 
L38:    invokeinterface [28] 0 
L43:    goto L66 
L46:    aload_0 
L47:    getfield [16] 
L50:    getfield [18] 
L53:    ldc [3] 
L55:    ldc [6] 
L57:    iload_1 
L58:    i2l 
L59:    iload 4 
L61:    i2l 
L62:    invokevirtual [20] 
L65:    pop 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method private [132] : [133] 
    .attribute [125] .code stack 2 locals 0 
L0:     getstatic [7] 
L3:     iload_1 
L4:     invokestatic [8] 
L7:     ifne L27 
L10:    getstatic [9] 
L13:    iload_1 
L14:    invokestatic [8] 
L17:    ifne L27 
L20:    sipush 308 
L23:    iload_1 
L24:    if_icmpne L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = Int 1078071040 
.const [4] = String [30] 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = Field [33] [34] 
.const [8] = Method [35] [36] 
.const [9] = Field [37] [38] 
.const [10] = Class [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Field [45] [46] 
.const [17] = Field [47] [48] 
.const [18] = Field [49] [50] 
.const [19] = Method [51] [52] 
.const [20] = Method [53] [54] 
.const [21] = Method [55] [56] 
.const [22] = Method [57] [58] 
.const [23] = Method [59] [60] 
.const [24] = Field [61] [62] 
.const [25] = Field [63] [64] 
.const [26] = Class [65] 
.const [27] = InterfaceMethod [66] [67] 
.const [28] = InterfaceMethod [68] [69] 
.const [29] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/VolumeRange 
.const [30] = Utf8 '[SdisDSISoundListener.updateVolumeRange] INVALID' 
.const [31] = Utf8 '[SdisDSISoundListener.updateVolume] AC:%1, value:%2' 
.const [32] = Utf8 '[SdisDSISoundListener.updateVolume] INVALID or AC:%1 is no entertainment connection (valid:%2)' 
.const [33] = Class [70] 
.const [34] = NameAndType [71] [72] 
.const [35] = Class [73] 
.const [36] = NameAndType [74] [75] 
.const [37] = Class [76] 
.const [38] = NameAndType [77] [78] 
.const [39] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [40] = Utf8 de/audi/atip/util/DefaultDSISoundListener 
.const [41] = Utf8 de/audi/audio/sdis/ifc/SdisAudioListener 
.const [42] = Utf8 de/audi/audio/AudioEnv 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/atip/audio/AudioConnection 
.const [45] = Class [79] 
.const [46] = NameAndType [80] [81] 
.const [47] = Class [82] 
.const [48] = NameAndType [83] [84] 
.const [49] = Class [85] 
.const [50] = NameAndType [86] [87] 
.const [51] = Class [88] 
.const [52] = NameAndType [89] [90] 
.const [53] = Class [91] 
.const [54] = NameAndType [92] [93] 
.const [55] = Class [94] 
.const [56] = NameAndType [95] [96] 
.const [57] = Class [97] 
.const [58] = NameAndType [98] [99] 
.const [59] = Class [100] 
.const [60] = NameAndType [101] [102] 
.const [61] = Class [103] 
.const [62] = NameAndType [104] [105] 
.const [63] = Class [106] 
.const [64] = NameAndType [107] [108] 
.const [65] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/VolumeRange 
.const [66] = Class [109] 
.const [67] = NameAndType [110] [111] 
.const [68] = Class [112] 
.const [69] = NameAndType [113] [114] 
.const [70] = Utf8 de/audi/atip/audio/AudioConnection 
.const [71] = Utf8 ENT_MEDIA_CONNS 
.const [72] = Utf8 [I 
.const [73] = Utf8 de/audi/atip/audio/AudioConnection 
.const [74] = Utf8 contains 
.const [75] = Utf8 ([II)Z 
.const [76] = Utf8 de/audi/atip/audio/AudioConnection 
.const [77] = Utf8 ENT_RADIO_CONNS 
.const [78] = Utf8 [I 
.const [79] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [80] = Utf8 env 
.const [81] = Utf8 Lde/audi/audio/AudioEnv; 
.const [82] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [83] = Utf8 sdisAudioListener 
.const [84] = Utf8 Lde/audi/audio/sdis/ifc/SdisAudioListener; 
.const [85] = Utf8 de/audi/audio/AudioEnv 
.const [86] = Utf8 lcSDIS 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;)Z 
.const [91] = Utf8 de/audi/atip/log/LogChannel 
.const [92] = Utf8 log 
.const [93] = Utf8 (ILjava/lang/String;JJ)Z 
.const [94] = Utf8 de/audi/atip/util/DefaultDSISoundListener 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 de/esolutions/fw/comm/asi/hmisync/audio/VolumeRange 
.const [98] = Utf8 <init> 
.const [99] = Utf8 (II)V 
.const [100] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [101] = Utf8 isEntertainmentConnection 
.const [102] = Utf8 (I)Z 
.const [103] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [104] = Utf8 env 
.const [105] = Utf8 Lde/audi/audio/AudioEnv; 
.const [106] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [107] = Utf8 sdisAudioListener 
.const [108] = Utf8 Lde/audi/audio/sdis/ifc/SdisAudioListener; 
.const [109] = Utf8 de/audi/audio/sdis/ifc/SdisAudioListener 
.const [110] = Utf8 updateVolumeRange 
.const [111] = Utf8 (Lde/esolutions/fw/comm/asi/hmisync/audio/VolumeRange;)V 
.const [112] = Utf8 de/audi/audio/sdis/ifc/SdisAudioListener 
.const [113] = Utf8 updateVolume 
.const [114] = Utf8 (I)V 
.const [115] = Utf8 de/audi/audio/sdis/SdisDSISoundListener 
.const [116] = Class [115] 
.const [117] = Utf8 de/audi/atip/util/DefaultDSISoundListener 
.const [118] = Class [117] 
.const [119] = Utf8 org/dsi/ifc/audio/DSISoundListener 
.const [120] = Class [119] 
.const [121] = Utf8 env 
.const [122] = Utf8 Lde/audi/audio/AudioEnv; 
.const [123] = Utf8 sdisAudioListener 
.const [124] = Utf8 Lde/audi/audio/sdis/ifc/SdisAudioListener; 
.const [125] = Utf8 Code 
.const [126] = Utf8 <init> 
.const [127] = Utf8 (Lde/audi/audio/AudioEnv;Lde/audi/audio/sdis/ifc/SdisAudioListener;)V 
.const [128] = Utf8 updateVolumeRange 
.const [129] = Utf8 (III)V 
.const [130] = Utf8 updateVolume 
.const [131] = Utf8 (IISI)V 
.const [132] = Utf8 isEntertainmentConnection 
.const [133] = Utf8 (I)Z 
.end class 
