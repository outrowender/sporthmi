.version 50 0 
.class super [55] 
.super [57] 
.field private [58] [59] 
.field private [60] [61] 

.method public [63] : [64] 
    .attribute [62] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [12] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [13] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [65] : [66] 
    .attribute [62] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [62] .code stack 1 locals 0 
        .catch [6] from L0 to L10 using L10 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokevirtual [9] 
L7:     goto L11 
L10:    pop 
L11:    aload_0 
L12:    getfield [8] 
L15:    invokevirtual [10] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [62] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [10] 
L7:     pop 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Class [18] 
.const [7] = Field [19] [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = Field [31] [32] 
.const [14] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [15] = Utf8 java/lang/Object 
.const [16] = Utf8 java/net/Socket 
.const [17] = Utf8 java/util/TimerTask 
.const [18] = Utf8 java/io/IOException 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Class [36] 
.const [22] = NameAndType [37] [38] 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [34] = Utf8 socket 
.const [35] = Utf8 Ljava/net/Socket; 
.const [36] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [37] = Utf8 timerTask 
.const [38] = Utf8 Ljava/util/TimerTask; 
.const [39] = Utf8 java/net/Socket 
.const [40] = Utf8 close 
.const [41] = Utf8 ()V 
.const [42] = Utf8 java/util/TimerTask 
.const [43] = Utf8 cancel 
.const [44] = Utf8 ()Z 
.const [45] = Utf8 java/lang/Object 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [49] = Utf8 socket 
.const [50] = Utf8 Ljava/net/Socket; 
.const [51] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [52] = Utf8 timerTask 
.const [53] = Utf8 Ljava/util/TimerTask; 
.const [54] = Utf8 com/ibm/oti/net/www/protocol/http/HttpURLConnection$CacheEntry 
.const [55] = Class [54] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Class [56] 
.const [58] = Utf8 socket 
.const [59] = Utf8 Ljava/net/Socket; 
.const [60] = Utf8 timerTask 
.const [61] = Utf8 Ljava/util/TimerTask; 
.const [62] = Utf8 Code 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Ljava/net/Socket;Ljava/util/TimerTask;)V 
.const [65] = Utf8 getSocket 
.const [66] = Utf8 ()Ljava/net/Socket; 
.const [67] = Utf8 closeSocket 
.const [68] = Utf8 ()V 
.const [69] = Utf8 cancelTimerTask 
.const [70] = Utf8 ()V 
.end class 
