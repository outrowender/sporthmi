.version 50 0 
.class super [58] 
.super [60] 
.implements [62] 
.field private final synthetic [63] [64] 

.method [66] : [67] 
    .attribute [65] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [15] 
L5:     aload_0 
L6:     invokespecial [14] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [68] : [69] 
    .attribute [65] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     getfield [12] 
L7:     ldc [2] 
L9:     ldc [3] 
L11:    ldc [4] 
L13:    iload_1 
L14:    i2l 
L15:    iload_2 
L16:    i2l 
L17:    invokevirtual [13] 
L20:    pop 
L21:    aload_0 
L22:    getfield [11] 
L25:    invokestatic [5] 
L28:    dup 
L29:    astore_3 
L30:    monitorenter 
        .catch [0] from L31 to L66 using L69 
L31:    iconst_0 
L32:    iload_1 
L33:    if_icmpne L49 
L36:    aload_0 
L37:    getfield [11] 
L40:    iconst_0 
L41:    iconst_2 
L42:    iload_2 
L43:    invokestatic [6] 
L46:    goto L64 
L49:    iconst_2 
L50:    iload_1 
L51:    if_icmpne L64 
L54:    aload_0 
L55:    getfield [11] 
L58:    iconst_2 
L59:    iconst_0 
L60:    iload_2 
L61:    invokestatic [6] 
L64:    aload_3 
L65:    monitorexit 
L66:    goto L76 
        .catch [0] from L69 to L73 using L69 
L69:    astore 4 
L71:    aload_3 
L72:    monitorexit 
L73:    aload 4 
L75:    athrow 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [16] 
.const [4] = String [17] 
.const [5] = Method [18] [19] 
.const [6] = Method [20] [21] 
.const [7] = Class [22] 
.const [8] = Class [23] 
.const [9] = Class [24] 
.const [10] = Class [25] 
.const [11] = Field [26] [27] 
.const [12] = Field [28] [29] 
.const [13] = Method [30] [31] 
.const [14] = Method [32] [33] 
.const [15] = Field [34] [35] 
.const [16] = Utf8 '[%1.updateAudioFocus] tId=%2, appid=%3' 
.const [17] = Utf8 AudioFocusSyncer 
.const [18] = Class [36] 
.const [19] = NameAndType [37] [38] 
.const [20] = Class [39] 
.const [21] = NameAndType [40] [41] 
.const [22] = Utf8 de/audi/app/media/audio/AudioFocusSyncer$2 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 de/audi/app/media/audio/AudioFocusSyncer 
.const [25] = Utf8 de/audi/atip/log/LogChannel 
.const [26] = Class [42] 
.const [27] = NameAndType [43] [44] 
.const [28] = Class [45] 
.const [29] = NameAndType [46] [47] 
.const [30] = Class [48] 
.const [31] = NameAndType [49] [50] 
.const [32] = Class [51] 
.const [33] = NameAndType [52] [53] 
.const [34] = Class [54] 
.const [35] = NameAndType [55] [56] 
.const [36] = Utf8 de/audi/app/media/audio/AudioFocusSyncer 
.const [37] = Utf8 access$000 
.const [38] = Utf8 (Lde/audi/app/media/audio/AudioFocusSyncer;)Ljava/lang/Object; 
.const [39] = Utf8 de/audi/app/media/audio/AudioFocusSyncer 
.const [40] = Utf8 access$100 
.const [41] = Utf8 (Lde/audi/app/media/audio/AudioFocusSyncer;III)V 
.const [42] = Utf8 de/audi/app/media/audio/AudioFocusSyncer$2 
.const [43] = Utf8 this$0 
.const [44] = Utf8 Lde/audi/app/media/audio/AudioFocusSyncer; 
.const [45] = Utf8 de/audi/app/media/audio/AudioFocusSyncer 
.const [46] = Utf8 log 
.const [47] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Utf8 log 
.const [50] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 <init> 
.const [53] = Utf8 ()V 
.const [54] = Utf8 de/audi/app/media/audio/AudioFocusSyncer$2 
.const [55] = Utf8 this$0 
.const [56] = Utf8 Lde/audi/app/media/audio/AudioFocusSyncer; 
.const [57] = Utf8 de/audi/app/media/audio/AudioFocusSyncer$2 
.const [58] = Class [57] 
.const [59] = Utf8 java/lang/Object 
.const [60] = Class [59] 
.const [61] = Utf8 de/audi/atip/audio/IAudioFocusClient 
.const [62] = Class [61] 
.const [63] = Utf8 this$0 
.const [64] = Utf8 Lde/audi/app/media/audio/AudioFocusSyncer; 
.const [65] = Utf8 Code 
.const [66] = Utf8 <init> 
.const [67] = Utf8 (Lde/audi/app/media/audio/AudioFocusSyncer;)V 
.const [68] = Utf8 updateAudioFocus 
.const [69] = Utf8 (II)V 
.end class 
