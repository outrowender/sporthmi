.version 50 0 
.class super [68] 
.super [70] 
.field private final synthetic [71] [72] 

.method private [74] : [75] 
    .attribute [73] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [16] 
L5:     aload_0 
L6:     invokespecial [15] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [73] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [12] 
L4:     invokestatic [2] 
L7:     dup 
L8:     astore 4 
L10:    monitorenter 
        .catch [0] from L11 to L31 using L34 
L11:    aload_0 
L12:    getfield [12] 
L15:    iload_1 
L16:    invokestatic [3] 
L19:    pop 
L20:    aload_0 
L21:    getfield [12] 
L24:    invokestatic [4] 
L27:    astore_3 
L28:    aload 4 
L30:    monitorexit 
L31:    goto L42 
        .catch [0] from L34 to L39 using L34 
L34:    astore 5 
L36:    aload 4 
L38:    monitorexit 
L39:    aload 5 
L41:    athrow 
L42:    aload_0 
L43:    getfield [12] 
L46:    invokestatic [5] 
L49:    ldc [6] 
L51:    ldc [7] 
L53:    aload_3 
L54:    invokevirtual [13] 
L57:    pop 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method synthetic [78] : [79] 
    .attribute [73] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [14] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [17] [18] 
.const [3] = Method [19] [20] 
.const [4] = Method [21] [22] 
.const [5] = Method [23] [24] 
.const [6] = Int -2137614336 
.const [7] = String [25] 
.const [8] = Class [26] 
.const [9] = Class [27] 
.const [10] = Class [28] 
.const [11] = Class [29] 
.const [12] = Field [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Field [38] [39] 
.const [17] = Class [40] 
.const [18] = NameAndType [41] [42] 
.const [19] = Class [43] 
.const [20] = NameAndType [44] [45] 
.const [21] = Class [46] 
.const [22] = NameAndType [47] [48] 
.const [23] = Class [49] 
.const [24] = NameAndType [50] [51] 
.const [25] = Utf8 '[VolumeLimits.updateActiveConnection] %1' 
.const [26] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [27] = Utf8 de/audi/audio/intra/DefaultAudioListener 
.const [28] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [41] = Utf8 access$200 
.const [42] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Ljava/lang/Object; 
.const [43] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [44] = Utf8 access$302 
.const [45] = Utf8 (Lde/audi/audio/volume/VolumeLimits;I)I 
.const [46] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [47] = Utf8 access$400 
.const [48] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/esolutions/fw/util/commons/Buffer; 
.const [49] = Utf8 de/audi/audio/volume/VolumeLimits 
.const [50] = Utf8 access$500 
.const [51] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)Lde/audi/atip/log/LogChannel; 
.const [52] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [53] = Utf8 this$0 
.const [54] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [55] = Utf8 de/audi/atip/log/LogChannel 
.const [56] = Utf8 log 
.const [57] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [58] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)V 
.const [61] = Utf8 de/audi/audio/intra/DefaultAudioListener 
.const [62] = Utf8 <init> 
.const [63] = Utf8 ()V 
.const [64] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [65] = Utf8 this$0 
.const [66] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [67] = Utf8 de/audi/audio/volume/VolumeLimits$Audiolistener 
.const [68] = Class [67] 
.const [69] = Utf8 de/audi/audio/intra/DefaultAudioListener 
.const [70] = Class [69] 
.const [71] = Utf8 this$0 
.const [72] = Utf8 Lde/audi/audio/volume/VolumeLimits; 
.const [73] = Utf8 Code 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (Lde/audi/audio/volume/VolumeLimits;)V 
.const [76] = Utf8 updateActiveConnection 
.const [77] = Utf8 (II)V 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Lde/audi/audio/volume/VolumeLimits;Lde/audi/audio/volume/VolumeLimits$1;)V 
.end class 
