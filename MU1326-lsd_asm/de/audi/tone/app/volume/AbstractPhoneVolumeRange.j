.version 50 0 
.class public super abstract [68] 
.super [70] 
.field protected [71] [72] 

.method public [74] : [75] 
    .attribute [73] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     iload 4 
L6:     invokespecial [14] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [16] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [76] : [77] 
    .attribute [73] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     invokespecial [15] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [16] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [78] : [79] 
    .attribute [73] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     iload_1 
L5:     if_icmpne L9 
L8:     return 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [16] 
L14:    aload_0 
L15:    getfield [9] 
L18:    getfield [10] 
L21:    ldc [2] 
L23:    ldc [3] 
L25:    iload_1 
L26:    i2l 
L27:    invokevirtual [11] 
L30:    pop 
L31:    iload_1 
L32:    tableswitch 1 
            L60 
            L66 
            L72 
            default : L78 

L60:    bipush 88 
L62:    istore_2 
L63:    goto L80 
L66:    bipush 87 
L68:    istore_2 
L69:    goto L80 
L72:    bipush 91 
L74:    istore_2 
L75:    goto L80 
L78:    iconst_0 
L79:    istore_2 
L80:    aload_0 
L81:    iload_2 
L82:    invokevirtual [12] 
L85:    aload_0 
L86:    invokevirtual [13] 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method protected enum [80] : [81] 
    .attribute [73] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Field [22] [23] 
.const [9] = Field [24] [25] 
.const [10] = Field [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Field [38] [39] 
.const [17] = Utf8 '[RingtoneVolumeRange.setPhoneAudioScenario] %1' 
.const [18] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [19] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [20] = Utf8 de/audi/tone/app/ToneEnv 
.const [21] = Utf8 de/audi/atip/log/LogChannel 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
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
.const [40] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [41] = Utf8 scenario 
.const [42] = Utf8 I 
.const [43] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [44] = Utf8 env 
.const [45] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [46] = Utf8 de/audi/tone/app/ToneEnv 
.const [47] = Utf8 lcMain 
.const [48] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [49] = Utf8 de/audi/atip/log/LogChannel 
.const [50] = Utf8 log 
.const [51] = Utf8 (ILjava/lang/String;J)Z 
.const [52] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [53] = Utf8 setForegroundConnection 
.const [54] = Utf8 (I)V 
.const [55] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [56] = Utf8 init 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [59] = Utf8 <init> 
.const [60] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;III)V 
.const [61] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [62] = Utf8 <init> 
.const [63] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;II)V 
.const [64] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [65] = Utf8 scenario 
.const [66] = Utf8 I 
.const [67] = Utf8 de/audi/tone/app/volume/AbstractPhoneVolumeRange 
.const [68] = Class [67] 
.const [69] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [70] = Class [69] 
.const [71] = Utf8 scenario 
.const [72] = Utf8 I 
.const [73] = Utf8 Code 
.const [74] = Utf8 <init> 
.const [75] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;III)V 
.const [76] = Utf8 <init> 
.const [77] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;II)V 
.const [78] = Utf8 setPhoneAudioScenario 
.const [79] = Utf8 (I)V 
.const [80] = Utf8 setUserDefinedRingtone 
.const [81] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.end class 
