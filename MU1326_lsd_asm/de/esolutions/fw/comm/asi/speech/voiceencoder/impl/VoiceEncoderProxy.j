.version 50 0 
.class public super [135] 
.super [137] 
.implements [139] 
.implements [141] 
.field private static final [142] [143] 
.field private [144] [145] 

.method public [147] : [148] 
    .attribute [146] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     new [30] 
L7:     dup 
L8:     ldc [3] 
L10:    iload_1 
L11:    ldc [4] 
L13:    ldc [5] 
L15:    invokespecial [24] 
L18:    astore_3 
L19:    new [31] 
L22:    dup 
L23:    aload_2 
L24:    invokespecial [25] 
L27:    astore 4 
L29:    aload_0 
L30:    new [32] 
L33:    dup 
L34:    aload_3 
L35:    aload 4 
L37:    getstatic [8] 
L40:    invokespecial [27] 
L43:    putfield [33] 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public interface [149] : [150] 
    .attribute [146] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [146] .code stack 3 locals 2 
L0:     new [34] 
L3:     dup 
L4:     invokespecial [28] 
L7:     astore 6 
        .catch [10] from L9 to L34 using L37 
L9:     aload 6 
L11:    iload_1 
L12:    invokevirtual [18] 
L15:    aload 6 
L17:    aload_2 
L18:    invokevirtual [19] 
L21:    aload 6 
L23:    aload_3 
L24:    invokevirtual [19] 
L27:    aload 6 
L29:    lload 4 
L31:    invokevirtual [20] 
L34:    goto L52 
L37:    astore 7 
L39:    new [35] 
L42:    dup 
L43:    aload 7 
L45:    invokevirtual [21] 
L48:    invokespecial [29] 
L51:    athrow 
L52:    aload_0 
L53:    getfield [17] 
L56:    iconst_1 
L57:    aload 6 
L59:    invokevirtual [22] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [146] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     iconst_0 
L5:     aconst_null 
L6:     invokevirtual [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static [155] : [156] 
    .attribute [146] .code stack 1 locals 0 
L0:     ldc [12] 
L2:     invokestatic [13] 
L5:     putstatic [26] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [36] 
.const [3] = String [37] 
.const [4] = String [38] 
.const [5] = String [39] 
.const [6] = Class [40] 
.const [7] = Class [41] 
.const [8] = Field [42] [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Class [46] 
.const [12] = String [47] 
.const [13] = Method [48] [49] 
.const [14] = Class [50] 
.const [15] = Class [51] 
.const [16] = Class [52] 
.const [17] = Field [53] [54] 
.const [18] = Method [55] [56] 
.const [19] = Method [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Method [77] [78] 
.const [30] = Class [79] 
.const [31] = Class [80] 
.const [32] = Class [81] 
.const [33] = Field [82] [83] 
.const [34] = Class [84] 
.const [35] = Class [85] 
.const [36] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [37] = Utf8 '2897fc85-6e2e-4482-b6fc-26536df6e757' 
.const [38] = Utf8 '0a41f958-da71-51bb-a6df-53cfe429da78' 
.const [39] = Utf8 'asi.speech.voiceencoder.VoiceEncoder' 
.const [40] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderReplyService 
.const [41] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [42] = Class [86] 
.const [43] = NameAndType [87] [88] 
.const [44] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [45] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [46] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [47] = Utf8 'PROXY.asi.speech.voiceencoder.VoiceEncoder' 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [51] = Utf8 java/lang/Object 
.const [52] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [53] = Class [92] 
.const [54] = NameAndType [93] [94] 
.const [55] = Class [95] 
.const [56] = NameAndType [96] [97] 
.const [57] = Class [98] 
.const [58] = NameAndType [99] [100] 
.const [59] = Class [101] 
.const [60] = NameAndType [102] [103] 
.const [61] = Class [104] 
.const [62] = NameAndType [105] [106] 
.const [63] = Class [107] 
.const [64] = NameAndType [108] [109] 
.const [65] = Class [110] 
.const [66] = NameAndType [111] [112] 
.const [67] = Class [113] 
.const [68] = NameAndType [114] [115] 
.const [69] = Class [116] 
.const [70] = NameAndType [117] [118] 
.const [71] = Class [119] 
.const [72] = NameAndType [120] [121] 
.const [73] = Class [122] 
.const [74] = NameAndType [123] [124] 
.const [75] = Class [125] 
.const [76] = NameAndType [126] [127] 
.const [77] = Class [128] 
.const [78] = NameAndType [129] [130] 
.const [79] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [80] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderReplyService 
.const [81] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [82] = Class [131] 
.const [83] = NameAndType [132] [133] 
.const [84] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [85] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [86] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [87] = Utf8 context 
.const [88] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [89] = Utf8 de/esolutions/fw/comm/core/CallContext 
.const [90] = Utf8 getContext 
.const [91] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/comm/core/CallContext; 
.const [92] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [93] = Utf8 proxy 
.const [94] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [95] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [96] = Utf8 putEnum 
.const [97] = Utf8 (I)V 
.const [98] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [99] = Utf8 putOptionalString 
.const [100] = Utf8 (Ljava/lang/String;)V 
.const [101] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [102] = Utf8 putUInt32 
.const [103] = Utf8 (J)V 
.const [104] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [105] = Utf8 getMessage 
.const [106] = Utf8 ()Ljava/lang/String; 
.const [107] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [108] = Utf8 remoteCallMethod 
.const [109] = Utf8 (SLde/esolutions/fw/util/serializer/ISerializable;)V 
.const [110] = Utf8 java/lang/Object 
.const [111] = Utf8 <init> 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/esolutions/fw/comm/core/ServiceInstanceID 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V 
.const [116] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderReplyService 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/esolutions/fw/comm/asi/speech/voiceencoder/VoiceEncoderReply;)V 
.const [119] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [120] = Utf8 context 
.const [121] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [122] = Utf8 de/esolutions/fw/comm/core/Proxy 
.const [123] = Utf8 <init> 
.const [124] = Utf8 (Lde/esolutions/fw/comm/core/ServiceInstanceID;Lde/esolutions/fw/comm/core/IReplyService;Lde/esolutions/fw/comm/core/CallContext;)V 
.const [125] = Utf8 de/esolutions/fw/util/serializer/adapter/GenericSerializable 
.const [126] = Utf8 <init> 
.const [127] = Utf8 ()V 
.const [128] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [129] = Utf8 <init> 
.const [130] = Utf8 (Ljava/lang/String;)V 
.const [131] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [132] = Utf8 proxy 
.const [133] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [134] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/impl/VoiceEncoderProxy 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/VoiceEncoder 
.const [139] = Class [138] 
.const [140] = Utf8 de/esolutions/fw/comm/asi/speech/voiceencoder/VoiceEncoderC 
.const [141] = Class [140] 
.const [142] = Utf8 context 
.const [143] = Utf8 Lde/esolutions/fw/comm/core/CallContext; 
.const [144] = Utf8 proxy 
.const [145] = Utf8 Lde/esolutions/fw/comm/core/Proxy; 
.const [146] = Utf8 Code 
.const [147] = Utf8 <init> 
.const [148] = Utf8 (ILde/esolutions/fw/comm/asi/speech/voiceencoder/VoiceEncoderReply;)V 
.const [149] = Utf8 getProxy 
.const [150] = Utf8 ()Lde/esolutions/fw/comm/core/Proxy; 
.const [151] = Utf8 startEncode 
.const [152] = Utf8 (ILjava/lang/String;Ljava/lang/String;J)V 
.const [153] = Utf8 cancel 
.const [154] = Utf8 ()V 
.const [155] = Utf8 <clinit> 
.const [156] = Utf8 ()V 
.end class 
