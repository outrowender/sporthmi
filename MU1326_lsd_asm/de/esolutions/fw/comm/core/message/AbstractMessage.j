.version 50 0 
.class public super abstract [233] 
.super [235] 
.implements [237] 
.field private [238] [239] 
.field private [240] [241] 
.field private [242] [243] 
.field protected [244] [245] 

.method public [247] : [248] 
    .attribute [246] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [37] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [38] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [246] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [31] 
L4:     iload_3 
L5:     ifne L13 
L8:     aload_0 
L9:     aload_1 
L10:    putfield [37] 
L13:    aload_0 
L14:    aload_2 
L15:    iload_3 
L16:    invokevirtual [17] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [251] : [252] 
    .attribute [246] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [253] : [254] 
    .attribute [246] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [255] : [256] 
    .attribute [246] .code stack 2 locals 1 
        .catch [2] from L0 to L26 using L27 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokeinterface [39] 0 
L9:     aload_0 
L10:    aload_0 
L11:    getfield [16] 
L14:    invokevirtual [18] 
L17:    aload_0 
L18:    getfield [16] 
L21:    invokeinterface [40] 0 
L26:    areturn 
L27:    astore_1 
L28:    iconst_0 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [257] : [258] 
    .attribute [246] .code stack 4 locals 1 
        .catch [2] from L0 to L28 using L31 
L0:     aload_0 
L1:     getfield [16] 
L4:     aload_1 
L5:     invokeinterface [41] 0 
L10:    aload_0 
L11:    aload_0 
L12:    getfield [16] 
L15:    invokevirtual [18] 
L18:    aload_0 
L19:    getfield [16] 
L22:    invokeinterface [42] 0 
L27:    pop 
L28:    goto L59 
L31:    astore_2 
L32:    new [43] 
L35:    dup 
L36:    new [44] 
L39:    dup 
L40:    invokespecial [32] 
L43:    ldc [5] 
L45:    invokevirtual [19] 
L48:    aload_2 
L49:    invokevirtual [20] 
L52:    invokevirtual [21] 
L55:    invokespecial [33] 
L58:    athrow 
L59:    return 
L60:    
    .end code 
.end method 

.method public [259] : [260] 
    .attribute [246] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [15] 
L5:     invokevirtual [22] 
L8:     invokeinterface [45] 0 
L13:    aload_0 
L14:    aload_1 
L15:    invokevirtual [23] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [261] : [262] 
    .attribute [246] .code stack 2 locals 1 
L0:     iload_2 
L1:     ifeq L19 
L4:     aload_1 
L5:     invokeinterface [46] 0 
L10:    istore_3 
L11:    aload_0 
L12:    iload_3 
L13:    invokestatic [6] 
L16:    putfield [37] 
L19:    aload_0 
L20:    aload_1 
L21:    invokevirtual [24] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected abstract [263] : [264] 
    .attribute [246] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [265] : [266] 
    .attribute [246] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [267] : [268] 
    .attribute [246] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [47] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [269] : [270] 
    .attribute [246] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [25] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [271] : [272] 
    .attribute [246] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [48] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [273] : [274] 
    .attribute [246] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [275] : [276] 
    .attribute [246] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [49] 
L4:     dup 
L5:     lload_1 
L6:     aload_0 
L7:     invokespecial [34] 
L10:    putfield [48] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [277] : [278] 
    .attribute [246] .code stack 2 locals 0 
L0:     aload_1 
L1:     aload_0 
L2:     invokespecial [35] 
L5:     invokevirtual [27] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [246] .code stack 2 locals 1 
L0:     new [50] 
L3:     dup 
L4:     invokespecial [36] 
L7:     astore_1 
L8:     aload_0 
L9:     aload_1 
L10:    invokevirtual [29] 
L13:    aload_1 
L14:    invokevirtual [30] 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = Class [52] 
.const [4] = Class [53] 
.const [5] = String [54] 
.const [6] = Method [55] [56] 
.const [7] = Class [57] 
.const [8] = Class [58] 
.const [9] = Class [59] 
.const [10] = Class [60] 
.const [11] = Class [61] 
.const [12] = Class [62] 
.const [13] = Class [63] 
.const [14] = Class [64] 
.const [15] = Field [65] [66] 
.const [16] = Field [67] [68] 
.const [17] = Method [69] [70] 
.const [18] = Method [71] [72] 
.const [19] = Method [73] [74] 
.const [20] = Method [75] [76] 
.const [21] = Method [77] [78] 
.const [22] = Method [79] [80] 
.const [23] = Method [81] [82] 
.const [24] = Method [83] [84] 
.const [25] = Field [85] [86] 
.const [26] = Field [87] [88] 
.const [27] = Method [89] [90] 
.const [28] = Method [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Method [97] [98] 
.const [32] = Method [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Field [109] [110] 
.const [38] = Field [111] [112] 
.const [39] = InterfaceMethod [113] [114] 
.const [40] = InterfaceMethod [115] [116] 
.const [41] = InterfaceMethod [117] [118] 
.const [42] = InterfaceMethod [119] [120] 
.const [43] = Class [121] 
.const [44] = Class [122] 
.const [45] = InterfaceMethod [123] [124] 
.const [46] = InterfaceMethod [125] [126] 
.const [47] = Field [127] [128] 
.const [48] = Field [129] [130] 
.const [49] = Class [131] 
.const [50] = Class [132] 
.const [51] = Utf8 de/esolutions/fw/util/serializer/exception/SerializerException 
.const [52] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [53] = Utf8 java/lang/StringBuffer 
.const [54] = Utf8 'Serializer failed with: ' 
.const [55] = Class [133] 
.const [56] = NameAndType [134] [135] 
.const [57] = Utf8 de/esolutions/fw/comm/core/message/CommDebugTag 
.const [58] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [59] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [62] = Utf8 de/esolutions/fw/comm/core/message/MessageType 
.const [63] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [64] = Utf8 java/lang/Class 
.const [65] = Class [136] 
.const [66] = NameAndType [137] [138] 
.const [67] = Class [139] 
.const [68] = NameAndType [140] [141] 
.const [69] = Class [142] 
.const [70] = NameAndType [143] [144] 
.const [71] = Class [145] 
.const [72] = NameAndType [146] [147] 
.const [73] = Class [148] 
.const [74] = NameAndType [149] [150] 
.const [75] = Class [151] 
.const [76] = NameAndType [152] [153] 
.const [77] = Class [154] 
.const [78] = NameAndType [155] [156] 
.const [79] = Class [157] 
.const [80] = NameAndType [158] [159] 
.const [81] = Class [160] 
.const [82] = NameAndType [161] [162] 
.const [83] = Class [163] 
.const [84] = NameAndType [164] [165] 
.const [85] = Class [166] 
.const [86] = NameAndType [167] [168] 
.const [87] = Class [169] 
.const [88] = NameAndType [170] [171] 
.const [89] = Class [172] 
.const [90] = NameAndType [173] [174] 
.const [91] = Class [175] 
.const [92] = NameAndType [176] [177] 
.const [93] = Class [178] 
.const [94] = NameAndType [179] [180] 
.const [95] = Class [181] 
.const [96] = NameAndType [182] [183] 
.const [97] = Class [184] 
.const [98] = NameAndType [185] [186] 
.const [99] = Class [187] 
.const [100] = NameAndType [188] [189] 
.const [101] = Class [190] 
.const [102] = NameAndType [191] [192] 
.const [103] = Class [193] 
.const [104] = NameAndType [194] [195] 
.const [105] = Class [196] 
.const [106] = NameAndType [197] [198] 
.const [107] = Class [199] 
.const [108] = NameAndType [200] [201] 
.const [109] = Class [202] 
.const [110] = NameAndType [203] [204] 
.const [111] = Class [205] 
.const [112] = NameAndType [206] [207] 
.const [113] = Class [208] 
.const [114] = NameAndType [209] [210] 
.const [115] = Class [211] 
.const [116] = NameAndType [212] [213] 
.const [117] = Class [214] 
.const [118] = NameAndType [215] [216] 
.const [119] = Class [217] 
.const [120] = NameAndType [218] [219] 
.const [121] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [122] = Utf8 java/lang/StringBuffer 
.const [123] = Class [220] 
.const [124] = NameAndType [221] [222] 
.const [125] = Class [223] 
.const [126] = NameAndType [224] [225] 
.const [127] = Class [226] 
.const [128] = NameAndType [227] [228] 
.const [129] = Class [229] 
.const [130] = NameAndType [230] [231] 
.const [131] = Utf8 de/esolutions/fw/comm/core/message/CommDebugTag 
.const [132] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [133] = Utf8 de/esolutions/fw/comm/core/message/MessageType 
.const [134] = Utf8 getType 
.const [135] = Utf8 (B)Lde/esolutions/fw/comm/core/message/MessageType; 
.const [136] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [137] = Utf8 type 
.const [138] = Utf8 Lde/esolutions/fw/comm/core/message/MessageType; 
.const [139] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [140] = Utf8 serializer 
.const [141] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [142] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [143] = Utf8 deserialize 
.const [144] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;Z)V 
.const [145] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [146] = Utf8 serialize 
.const [147] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [148] = Utf8 java/lang/StringBuffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [151] = Utf8 java/lang/StringBuffer 
.const [152] = Utf8 append 
.const [153] = Utf8 (Ljava/lang/Object;)Ljava/lang/StringBuffer; 
.const [154] = Utf8 java/lang/StringBuffer 
.const [155] = Utf8 toString 
.const [156] = Utf8 ()Ljava/lang/String; 
.const [157] = Utf8 de/esolutions/fw/comm/core/message/MessageType 
.const [158] = Utf8 toByte 
.const [159] = Utf8 ()B 
.const [160] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [161] = Utf8 serializeElements 
.const [162] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [163] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [164] = Utf8 deserializeElements 
.const [165] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [166] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [167] = Utf8 payload 
.const [168] = Utf8 Lde/esolutions/fw/util/transport/IReadable; 
.const [169] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [170] = Utf8 debugTag 
.const [171] = Utf8 Ljava/lang/Object; 
.const [172] = Utf8 java/lang/Class 
.const [173] = Utf8 getName 
.const [174] = Utf8 ()Ljava/lang/String; 
.const [175] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [176] = Utf8 append 
.const [177] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [178] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [179] = Utf8 dump 
.const [180] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [181] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [182] = Utf8 toString 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 java/lang/Object 
.const [185] = Utf8 <init> 
.const [186] = Utf8 ()V 
.const [187] = Utf8 java/lang/StringBuffer 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (Ljava/lang/String;)V 
.const [193] = Utf8 de/esolutions/fw/comm/core/message/CommDebugTag 
.const [194] = Utf8 <init> 
.const [195] = Utf8 (JLde/esolutions/fw/comm/core/message/AbstractMessage;)V 
.const [196] = Utf8 java/lang/Object 
.const [197] = Utf8 getClass 
.const [198] = Utf8 ()Ljava/lang/Class; 
.const [199] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [200] = Utf8 <init> 
.const [201] = Utf8 ()V 
.const [202] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [203] = Utf8 type 
.const [204] = Utf8 Lde/esolutions/fw/comm/core/message/MessageType; 
.const [205] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [206] = Utf8 serializer 
.const [207] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [208] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [209] = Utf8 beginSizeCalc 
.const [210] = Utf8 ()V 
.const [211] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [212] = Utf8 endSizeCalc 
.const [213] = Utf8 ()I 
.const [214] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [215] = Utf8 attachBuffer 
.const [216] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [217] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [218] = Utf8 detachBuffer 
.const [219] = Utf8 ()I 
.const [220] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [221] = Utf8 putInt8 
.const [222] = Utf8 (B)V 
.const [223] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [224] = Utf8 getInt8 
.const [225] = Utf8 ()B 
.const [226] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [227] = Utf8 payload 
.const [228] = Utf8 Lde/esolutions/fw/util/transport/IReadable; 
.const [229] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [230] = Utf8 debugTag 
.const [231] = Utf8 Ljava/lang/Object; 
.const [232] = Utf8 de/esolutions/fw/comm/core/message/AbstractMessage 
.const [233] = Class [232] 
.const [234] = Utf8 java/lang/Object 
.const [235] = Class [234] 
.const [236] = Utf8 de/esolutions/fw/util/transport/IWriter 
.const [237] = Class [236] 
.const [238] = Utf8 debugTag 
.const [239] = Utf8 Ljava/lang/Object; 
.const [240] = Utf8 type 
.const [241] = Utf8 Lde/esolutions/fw/comm/core/message/MessageType; 
.const [242] = Utf8 serializer 
.const [243] = Utf8 Lde/esolutions/fw/util/serializer/ISerializer; 
.const [244] = Utf8 payload 
.const [245] = Utf8 Lde/esolutions/fw/util/transport/IReadable; 
.const [246] = Utf8 Code 
.const [247] = Utf8 <init> 
.const [248] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [249] = Utf8 <init> 
.const [250] = Utf8 (Lde/esolutions/fw/comm/core/message/MessageType;Lde/esolutions/fw/util/serializer/IDeserializer;Z)V 
.const [251] = Utf8 getMessageType 
.const [252] = Utf8 ()Lde/esolutions/fw/comm/core/message/MessageType; 
.const [253] = Utf8 getSerializer 
.const [254] = Utf8 ()Lde/esolutions/fw/util/serializer/ISerializer; 
.const [255] = Utf8 size 
.const [256] = Utf8 ()I 
.const [257] = Utf8 write 
.const [258] = Utf8 (Lde/esolutions/fw/util/transport/IWriteable;)V 
.const [259] = Utf8 serialize 
.const [260] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [261] = Utf8 deserialize 
.const [262] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;Z)V 
.const [263] = Utf8 serializeElements 
.const [264] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;)V 
.const [265] = Utf8 deserializeElements 
.const [266] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)V 
.const [267] = Utf8 setPayload 
.const [268] = Utf8 (Lde/esolutions/fw/util/transport/IReadable;)V 
.const [269] = Utf8 getPayload 
.const [270] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [271] = Utf8 setDebugTag 
.const [272] = Utf8 (Ljava/lang/Object;)V 
.const [273] = Utf8 getDebugTag 
.const [274] = Utf8 ()Ljava/lang/Object; 
.const [275] = Utf8 createDebugTag 
.const [276] = Utf8 (J)V 
.const [277] = Utf8 dump 
.const [278] = Utf8 (Lde/esolutions/fw/util/commons/Buffer;)V 
.const [279] = Utf8 toString 
.const [280] = Utf8 ()Ljava/lang/String; 
.end class 
