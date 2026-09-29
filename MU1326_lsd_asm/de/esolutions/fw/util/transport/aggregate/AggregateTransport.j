.version 50 0 
.class public super [207] 
.super [209] 
.implements [211] 
.field protected [212] [213] 
.field protected [214] [215] 
.field protected [216] [217] 
.field protected [218] [219] 
.field protected [220] [221] 

.method public [223] : [224] 
    .attribute [222] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [31] 
L9:     aload_0 
L10:    new [32] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [27] 
L18:    putfield [33] 
L21:    aload_0 
L22:    new [34] 
L25:    dup 
L26:    aload_1 
L27:    invokespecial [28] 
L30:    putfield [35] 
L33:    aload_0 
L34:    iconst_0 
L35:    putfield [36] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [222] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [31] 
L9:     aload_0 
L10:    new [32] 
L13:    dup 
L14:    aload_1 
L15:    invokespecial [27] 
L18:    putfield [33] 
L21:    aload_0 
L22:    new [34] 
L25:    dup 
L26:    aload_1 
L27:    invokespecial [28] 
L30:    putfield [35] 
L33:    aload_0 
L34:    iload_2 
L35:    putfield [36] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L17 
L7:     new [37] 
L10:    dup 
L11:    ldc [5] 
L13:    invokespecial [29] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [14] 
L21:    invokevirtual [17] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L17 
L7:     new [37] 
L10:    dup 
L11:    ldc [5] 
L13:    invokespecial [29] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [14] 
L21:    aload_1 
L22:    invokevirtual [18] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnonnull L17 
L7:     new [37] 
L10:    dup 
L11:    ldc [5] 
L13:    invokespecial [29] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [14] 
L21:    aload_1 
L22:    invokevirtual [19] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [222] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnonnull L17 
L7:     new [37] 
L10:    dup 
L11:    ldc [6] 
L13:    invokespecial [29] 
L16:    athrow 
L17:    aload_0 
L18:    getfield [15] 
L21:    invokevirtual [20] 
L24:    areturn 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifeq L8 
L7:     return 
L8:     aload_0 
L9:     iconst_1 
L10:    putfield [38] 
L13:    aload_0 
L14:    getfield [13] 
L17:    invokeinterface [39] 0 
L22:    aload_0 
L23:    getfield [14] 
L26:    ifnull L40 
L29:    aload_0 
L30:    getfield [14] 
L33:    aload_0 
L34:    getfield [16] 
L37:    invokevirtual [22] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public interface [237] : [238] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [222] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifne L8 
L7:     return 
L8:     aload_0 
L9:     iconst_0 
L10:    putfield [38] 
L13:    aload_0 
L14:    getfield [13] 
L17:    iload_1 
L18:    invokeinterface [40] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [14] 
L11:    invokevirtual [23] 
L14:    areturn 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokeinterface [41] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokeinterface [42] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [222] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     invokeinterface [43] 0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [222] .code stack 2 locals 0 
L0:     new [44] 
L3:     dup 
L4:     invokespecial [30] 
L7:     ldc [8] 
L9:     invokevirtual [24] 
L12:    aload_0 
L13:    getfield [13] 
L16:    invokeinterface [45] 0 
L21:    invokevirtual [24] 
L24:    ldc [9] 
L26:    invokevirtual [24] 
L29:    invokevirtual [25] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public enum [251] : [252] 
    .attribute [222] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [46] 
.const [3] = Class [47] 
.const [4] = Class [48] 
.const [5] = String [49] 
.const [6] = String [50] 
.const [7] = Class [51] 
.const [8] = String [52] 
.const [9] = String [53] 
.const [10] = Class [54] 
.const [11] = Class [55] 
.const [12] = Class [56] 
.const [13] = Field [57] [58] 
.const [14] = Field [59] [60] 
.const [15] = Field [61] [62] 
.const [16] = Field [63] [64] 
.const [17] = Method [65] [66] 
.const [18] = Method [67] [68] 
.const [19] = Method [69] [70] 
.const [20] = Method [71] [72] 
.const [21] = Field [73] [74] 
.const [22] = Method [75] [76] 
.const [23] = Method [77] [78] 
.const [24] = Method [79] [80] 
.const [25] = Method [81] [82] 
.const [26] = Method [83] [84] 
.const [27] = Method [85] [86] 
.const [28] = Method [87] [88] 
.const [29] = Method [89] [90] 
.const [30] = Method [91] [92] 
.const [31] = Field [93] [94] 
.const [32] = Class [95] 
.const [33] = Field [96] [97] 
.const [34] = Class [98] 
.const [35] = Field [99] [100] 
.const [36] = Field [101] [102] 
.const [37] = Class [103] 
.const [38] = Field [104] [105] 
.const [39] = InterfaceMethod [106] [107] 
.const [40] = InterfaceMethod [108] [109] 
.const [41] = InterfaceMethod [110] [111] 
.const [42] = InterfaceMethod [112] [113] 
.const [43] = InterfaceMethod [114] [115] 
.const [44] = Class [116] 
.const [45] = InterfaceMethod [117] [118] 
.const [46] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [47] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateDecoder 
.const [48] = Utf8 java/lang/RuntimeException 
.const [49] = Utf8 'No Transmitter in Transport!' 
.const [50] = Utf8 'No Receiver in Transport!' 
.const [51] = Utf8 java/lang/StringBuffer 
.const [52] = Utf8 '[Aggregate:' 
.const [53] = Utf8 ']' 
.const [54] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [57] = Class [119] 
.const [58] = NameAndType [120] [121] 
.const [59] = Class [122] 
.const [60] = NameAndType [123] [124] 
.const [61] = Class [125] 
.const [62] = NameAndType [126] [127] 
.const [63] = Class [128] 
.const [64] = NameAndType [129] [130] 
.const [65] = Class [131] 
.const [66] = NameAndType [132] [133] 
.const [67] = Class [134] 
.const [68] = NameAndType [135] [136] 
.const [69] = Class [137] 
.const [70] = NameAndType [138] [139] 
.const [71] = Class [140] 
.const [72] = NameAndType [141] [142] 
.const [73] = Class [143] 
.const [74] = NameAndType [144] [145] 
.const [75] = Class [146] 
.const [76] = NameAndType [147] [148] 
.const [77] = Class [149] 
.const [78] = NameAndType [150] [151] 
.const [79] = Class [152] 
.const [80] = NameAndType [153] [154] 
.const [81] = Class [155] 
.const [82] = NameAndType [156] [157] 
.const [83] = Class [158] 
.const [84] = NameAndType [159] [160] 
.const [85] = Class [161] 
.const [86] = NameAndType [162] [163] 
.const [87] = Class [164] 
.const [88] = NameAndType [165] [166] 
.const [89] = Class [167] 
.const [90] = NameAndType [168] [169] 
.const [91] = Class [170] 
.const [92] = NameAndType [171] [172] 
.const [93] = Class [173] 
.const [94] = NameAndType [174] [175] 
.const [95] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [96] = Class [176] 
.const [97] = NameAndType [177] [178] 
.const [98] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateDecoder 
.const [99] = Class [179] 
.const [100] = NameAndType [180] [181] 
.const [101] = Class [182] 
.const [102] = NameAndType [183] [184] 
.const [103] = Utf8 java/lang/RuntimeException 
.const [104] = Class [185] 
.const [105] = NameAndType [186] [187] 
.const [106] = Class [188] 
.const [107] = NameAndType [189] [190] 
.const [108] = Class [191] 
.const [109] = NameAndType [192] [193] 
.const [110] = Class [194] 
.const [111] = NameAndType [195] [196] 
.const [112] = Class [197] 
.const [113] = NameAndType [198] [199] 
.const [114] = Class [200] 
.const [115] = NameAndType [201] [202] 
.const [116] = Utf8 java/lang/StringBuffer 
.const [117] = Class [203] 
.const [118] = NameAndType [204] [205] 
.const [119] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [120] = Utf8 transport 
.const [121] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [122] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [123] = Utf8 encoder 
.const [124] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateEncoder; 
.const [125] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [126] = Utf8 decoder 
.const [127] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateDecoder; 
.const [128] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [129] = Utf8 maxPacketSize 
.const [130] = Utf8 I 
.const [131] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [132] = Utf8 flushPacket 
.const [133] = Utf8 ()V 
.const [134] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [135] = Utf8 putMessage 
.const [136] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [137] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [138] = Utf8 putMessageCopy 
.const [139] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [140] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateDecoder 
.const [141] = Utf8 getMessage 
.const [142] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [143] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [144] = Utf8 isOpen 
.const [145] = Utf8 Z 
.const [146] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [147] = Utf8 init 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [150] = Utf8 getMaxMessageSize 
.const [151] = Utf8 ()I 
.const [152] = Utf8 java/lang/StringBuffer 
.const [153] = Utf8 append 
.const [154] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [155] = Utf8 java/lang/StringBuffer 
.const [156] = Utf8 toString 
.const [157] = Utf8 ()Ljava/lang/String; 
.const [158] = Utf8 java/lang/Object 
.const [159] = Utf8 <init> 
.const [160] = Utf8 ()V 
.const [161] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateEncoder 
.const [162] = Utf8 <init> 
.const [163] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)V 
.const [164] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateDecoder 
.const [165] = Utf8 <init> 
.const [166] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)V 
.const [167] = Utf8 java/lang/RuntimeException 
.const [168] = Utf8 <init> 
.const [169] = Utf8 (Ljava/lang/String;)V 
.const [170] = Utf8 java/lang/StringBuffer 
.const [171] = Utf8 <init> 
.const [172] = Utf8 ()V 
.const [173] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [174] = Utf8 transport 
.const [175] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [176] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [177] = Utf8 encoder 
.const [178] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateEncoder; 
.const [179] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [180] = Utf8 decoder 
.const [181] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateDecoder; 
.const [182] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [183] = Utf8 maxPacketSize 
.const [184] = Utf8 I 
.const [185] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [186] = Utf8 isOpen 
.const [187] = Utf8 Z 
.const [188] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [189] = Utf8 'open' 
.const [190] = Utf8 ()V 
.const [191] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [192] = Utf8 close 
.const [193] = Utf8 (Z)V 
.const [194] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [195] = Utf8 isReliable 
.const [196] = Utf8 ()Z 
.const [197] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [198] = Utf8 detectsPeerReset 
.const [199] = Utf8 ()Z 
.const [200] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [201] = Utf8 keepsRecordBoundaries 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [204] = Utf8 getDescription 
.const [205] = Utf8 ()Ljava/lang/String; 
.const [206] = Utf8 de/esolutions/fw/util/transport/aggregate/AggregateTransport 
.const [207] = Class [206] 
.const [208] = Utf8 java/lang/Object 
.const [209] = Class [208] 
.const [210] = Utf8 de/esolutions/fw/util/transport/ITransport 
.const [211] = Class [210] 
.const [212] = Utf8 transport 
.const [213] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [214] = Utf8 decoder 
.const [215] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateDecoder; 
.const [216] = Utf8 encoder 
.const [217] = Utf8 Lde/esolutions/fw/util/transport/aggregate/AggregateEncoder; 
.const [218] = Utf8 maxPacketSize 
.const [219] = Utf8 I 
.const [220] = Utf8 isOpen 
.const [221] = Utf8 Z 
.const [222] = Utf8 Code 
.const [223] = Utf8 <init> 
.const [224] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;)V 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/esolutions/fw/util/transport/ITransport;I)V 
.const [227] = Utf8 flush 
.const [228] = Utf8 ()V 
.const [229] = Utf8 send 
.const [230] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [231] = Utf8 sendSync 
.const [232] = Utf8 (Lde/esolutions/fw/util/transport/IWriter;)V 
.const [233] = Utf8 recv 
.const [234] = Utf8 ()Lde/esolutions/fw/util/transport/IReadable; 
.const [235] = Utf8 'open' 
.const [236] = Utf8 ()V 
.const [237] = Utf8 isOpen 
.const [238] = Utf8 ()Z 
.const [239] = Utf8 close 
.const [240] = Utf8 (Z)V 
.const [241] = Utf8 maxMsgSize 
.const [242] = Utf8 ()I 
.const [243] = Utf8 isReliable 
.const [244] = Utf8 ()Z 
.const [245] = Utf8 detectsPeerReset 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 keepsRecordBoundaries 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 getDescription 
.const [250] = Utf8 ()Ljava/lang/String; 
.const [251] = Utf8 setDebug 
.const [252] = Utf8 (Lde/esolutions/fw/util/transport/debug/ITransportDebug;)V 
.end class 
