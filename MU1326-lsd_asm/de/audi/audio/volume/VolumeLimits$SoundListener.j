.version 50 0 
.class super [74] 
.super [76] 
.field private final synthetic [77] [78] 

.method private [80] : [81] 
    .attribute [79] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     invokespecial [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public enum [82] : [83] 
    .attribute [79] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [84] : [85] 
    .attribute [79] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokestatic [2] 
L7:     dup 
L8:     astore 4 
L10:    monitorenter 
        .catch [0] from L11 to L40 using L43 
L11:    aload_0 
L12:    getfield [13] 
L15:    iload_1 
L16:    invokestatic [3] 
L19:    pop 
L20:    aload_0 
L21:    getfield [13] 
L24:    iload_2 
L25:    invokestatic [4] 
L28:    pop 
L29:    aload_0 
L30:    getfield [13] 
L33:    invokestatic [5] 
L36:    astore_3 
L37:    aload 4 
L39:    monitorexit 
L40:    goto L51 
        .catch [0] from L43 to L48 using L43 
L43:    astore 5 
L45:    aload 4 
L47:    monitorexit 
L48:    aload 5 
L50:    athrow 
L51:    aload_0 
L52:    getfield [13] 
L55:    invokestatic [6] 
L58:    ldc [7] 
L60:    ldc [8] 
L62:    aload_3 
L63:    invokevirtual [14] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method synthetic [86] : [87] 
    .attribute [79] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [15] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [18] [19] 
.const [3] = Method [20] [21] 
.const [4] = Method [22] [23] 
.const [5] = Method [24] [25] 
.const [6] = Method [26] [27] 
.const [7] = Int -2137614336 
.const [8] = String [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Class [32] 
.const [13] = Field [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Field [41] [42] 
.const [18] = Class [43] 
.const [19] = NameAndType [44] [45] 
.const [20] = Class [46] 
.const [21] = NameAndType [47] [48] 
.const [22] = Class [49] 
.const [23] = NameAndType [50] [51] 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Class [55] 
.const [27] = NameAndType [56] [57] 
.const [28] = Utf8 '[VolumeLimits.updateVolumeRange] %1' 
.const [29] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [30] = Utf8 de/audi/audio/intra/DefaultSoundListener 
.const [31] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [32] = Utf8 de/audi/atip/log/LogChannel 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [44] = Utf8 access$200 
.const [45] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Ljava/lang/Object; 
.const [46] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [47] = Utf8 access$602 
.const [48] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.const [49] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [50] = Utf8 access$702 
.const [51] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.const [52] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [53] = Utf8 access$400 
.const [54] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/esolutions/fw/util/commons/Buffer; 
.const [55] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [56] = Utf8 access$500 
.const [57] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/audi/atip/log/LogChannel; 
.const [58] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [59] = Utf8 this$0 
.const [60] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [64] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [65] = Utf8 <init> 
.const [66] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)V 
.const [67] = Utf8 de/audi/audio/intra/DefaultSoundListener 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [73] = Utf8 de/audi/audio/volume/VolumeLimits$SoundListener 
.const [74] = Class [73] 
.const [75] = Utf8 de/audi/audio/intra/DefaultSoundListener 
.const [76] = Class [75] 
.const [77] = Utf8 this$0 
.const [78] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [79] = Utf8 Code 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)V 
.const [82] = Utf8 updateActiveAmplifiers 
.const [83] = Utf8 (I)V 
.const [84] = Utf8 updateVolumeRange 
.const [85] = Utf8 (II)V 
.const [86] = Utf8 <init> 
.const [87] = Utf8 (Lde/audi/audio/volume/VolumeLimits;Lde/audi/audio/volume/VolumeLimits$1;)V 
.end class 
