.version 50 0 
.class public super [127] 
.super [129] 

.method public annotation [131] : [132] 
    .attribute [130] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [133] : [134] 
    .attribute [130] .code stack 2 locals 4 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [20] 0 
L17:    iload_2 
L18:    ifne L57 
L21:    aload_1 
L22:    invokevirtual [15] 
L25:    astore_3 
L26:    aload_0 
L27:    aload_3 
L28:    invokestatic [2] 
L31:    aload_1 
L32:    invokevirtual [16] 
L35:    istore 4 
L37:    aload_0 
L38:    iload 4 
L40:    invokeinterface [21] 0 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    astore 5 
L51:    aload_0 
L52:    aload 5 
L54:    invokestatic [3] 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [135] : [136] 
    .attribute [130] .code stack 3 locals 2 
L0:     aload_1 
L1:     ifnonnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     istore_2 
L10:    aload_0 
L11:    iload_2 
L12:    invokeinterface [20] 0 
L17:    iload_2 
L18:    ifne L50 
L21:    aload_0 
L22:    aload_1 
L23:    arraylength 
L24:    invokeinterface [21] 0 
L29:    iconst_0 
L30:    istore_3 
L31:    iload_3 
L32:    aload_1 
L33:    arraylength 
L34:    if_icmpge L50 
L37:    aload_0 
L38:    aload_1 
L39:    iload_3 
L40:    aaload 
L41:    invokestatic [4] 
L44:    iinc 3 1 
L47:    goto L31 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [137] : [138] 
    .attribute [130] .code stack 2 locals 5 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [22] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L57 
L13:    new [23] 
L16:    dup 
L17:    invokespecial [19] 
L20:    astore_1 
L21:    aload_0 
L22:    invokestatic [6] 
L25:    astore_3 
L26:    aload_1 
L27:    aload_3 
L28:    putfield [24] 
L31:    aload_0 
L32:    invokeinterface [25] 0 
L37:    istore 4 
L39:    aload_1 
L40:    iload 4 
L42:    putfield [26] 
L45:    aload_0 
L46:    invokestatic [7] 
L49:    astore 5 
L51:    aload_1 
L52:    aload 5 
L54:    putfield [27] 
L57:    aload_1 
L58:    areturn 
L59:    nop 
L60:    
    .end code 
.end method 

.method public static [139] : [140] 
    .attribute [130] .code stack 3 locals 4 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     invokeinterface [22] 0 
L8:     istore_2 
L9:     iload_2 
L10:    ifne L48 
L13:    aload_0 
L14:    invokeinterface [25] 0 
L19:    istore_3 
L20:    iload_3 
L21:    anewarray [5] 
L24:    astore_1 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    iload_3 
L31:    if_icmpge L48 
L34:    aload_1 
L35:    iload 4 
L37:    aload_0 
L38:    invokestatic [8] 
L41:    aastore 
L42:    iinc 4 1 
L45:    goto L28 
L48:    aload_1 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Method [30] [31] 
.const [4] = Method [32] [33] 
.const [5] = Class [34] 
.const [6] = Method [35] [36] 
.const [7] = Method [37] [38] 
.const [8] = Method [39] [40] 
.const [9] = Class [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Method [47] [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = InterfaceMethod [57] [58] 
.const [21] = InterfaceMethod [59] [60] 
.const [22] = InterfaceMethod [61] [62] 
.const [23] = Class [63] 
.const [24] = Field [64] [65] 
.const [25] = InterfaceMethod [66] [67] 
.const [26] = Field [68] [69] 
.const [27] = Field [70] [71] 
.const [28] = Class [72] 
.const [29] = NameAndType [73] [74] 
.const [30] = Class [75] 
.const [31] = NameAndType [76] [77] 
.const [32] = Class [78] 
.const [33] = NameAndType [79] [80] 
.const [34] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [35] = Class [81] 
.const [36] = NameAndType [82] [83] 
.const [37] = Class [84] 
.const [38] = NameAndType [85] [86] 
.const [39] = Class [87] 
.const [40] = NameAndType [88] [89] 
.const [41] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherInfoSerializer 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [44] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [45] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherDataSerializer 
.const [46] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [47] = Class [90] 
.const [48] = NameAndType [91] [92] 
.const [49] = Class [93] 
.const [50] = NameAndType [94] [95] 
.const [51] = Class [96] 
.const [52] = NameAndType [97] [98] 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [64] = Class [114] 
.const [65] = NameAndType [115] [116] 
.const [66] = Class [117] 
.const [67] = NameAndType [118] [119] 
.const [68] = Class [120] 
.const [69] = NameAndType [121] [122] 
.const [70] = Class [123] 
.const [71] = NameAndType [124] [125] 
.const [72] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [73] = Utf8 putOptionalDateTime 
.const [74] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/global/DateTime;)V 
.const [75] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherDataSerializer 
.const [76] = Utf8 putOptionalWeatherDataVarArray 
.const [77] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/tpegservices/WeatherData;)V 
.const [78] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherInfoSerializer 
.const [79] = Utf8 putOptionalWeatherInfo 
.const [80] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/tpegservices/WeatherInfo;)V 
.const [81] = Utf8 de/esolutions/fw/comm/dsi/global/impl/DateTimeSerializer 
.const [82] = Utf8 getOptionalDateTime 
.const [83] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/global/DateTime; 
.const [84] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherDataSerializer 
.const [85] = Utf8 getOptionalWeatherDataVarArray 
.const [86] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/tpegservices/WeatherData; 
.const [87] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherInfoSerializer 
.const [88] = Utf8 getOptionalWeatherInfo 
.const [89] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/tpegservices/WeatherInfo; 
.const [90] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [91] = Utf8 getDateTime 
.const [92] = Utf8 ()Lorg/dsi/ifc/global/DateTime; 
.const [93] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [94] = Utf8 getWeatherInfoInterval 
.const [95] = Utf8 ()I 
.const [96] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [97] = Utf8 getWeatherDataList 
.const [98] = Utf8 ()[Lorg/dsi/ifc/tpegservices/WeatherData; 
.const [99] = Utf8 java/lang/Object 
.const [100] = Utf8 <init> 
.const [101] = Utf8 ()V 
.const [102] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [106] = Utf8 putBool 
.const [107] = Utf8 (Z)V 
.const [108] = Utf8 de/esolutions/fw/util/serializer/ISerializer 
.const [109] = Utf8 putInt32 
.const [110] = Utf8 (I)V 
.const [111] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [112] = Utf8 getBool 
.const [113] = Utf8 ()Z 
.const [114] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [115] = Utf8 dateTime 
.const [116] = Utf8 Lorg/dsi/ifc/global/DateTime; 
.const [117] = Utf8 de/esolutions/fw/util/serializer/IDeserializer 
.const [118] = Utf8 getInt32 
.const [119] = Utf8 ()I 
.const [120] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [121] = Utf8 weatherInfoInterval 
.const [122] = Utf8 I 
.const [123] = Utf8 org/dsi/ifc/tpegservices/WeatherInfo 
.const [124] = Utf8 weatherDataList 
.const [125] = Utf8 [Lorg/dsi/ifc/tpegservices/WeatherData; 
.const [126] = Utf8 de/esolutions/fw/comm/dsi/tpegservices/impl/WeatherInfoSerializer 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Object 
.const [129] = Class [128] 
.const [130] = Utf8 Code 
.const [131] = Utf8 <init> 
.const [132] = Utf8 ()V 
.const [133] = Utf8 putOptionalWeatherInfo 
.const [134] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;Lorg/dsi/ifc/tpegservices/WeatherInfo;)V 
.const [135] = Utf8 putOptionalWeatherInfoVarArray 
.const [136] = Utf8 (Lde/esolutions/fw/util/serializer/ISerializer;[Lorg/dsi/ifc/tpegservices/WeatherInfo;)V 
.const [137] = Utf8 getOptionalWeatherInfo 
.const [138] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)Lorg/dsi/ifc/tpegservices/WeatherInfo; 
.const [139] = Utf8 getOptionalWeatherInfoVarArray 
.const [140] = Utf8 (Lde/esolutions/fw/util/serializer/IDeserializer;)[Lorg/dsi/ifc/tpegservices/WeatherInfo; 
.end class 
