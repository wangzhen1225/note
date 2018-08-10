### HTTPS原理

#### 1. 什么是HTTPS

> 超文本传输安全协议（英语：Hypertext Transfer Protocol Secure，缩写：HTTPS，常称为HTTP over TLS，HTTP over SSL或HTTP Secure）是一种透过计算机网络进行安全通信的传输协议。HTTPS经由HTTP进行通信，但利用SSL/TLS来加密数据包。HTTPS开发的主要目的，是提供对网站服务器的身份认证，保护交换数据的隐私与完整性。
>
> ​																	— 摘自维基百科

简单概括上述描述就是 HTTPS = HTTP + Secure,安全的HTTP。

#### 2. HTTP与HTTPS比较

​	<img src="https://ws2.sinaimg.cn/large/006tKfTcgy1fu00q0d6maj30ji0cwgn9.jpg">

<img src="https://ws3.sinaimg.cn/large/006tKfTcgy1fu01czwebkj30z80giaci.jpg">

<img src="https://ws2.sinaimg.cn/large/006tKfTcgy1fu01gozatbj310y0tmdlu.jpg">

从上可以看出，https在http的基础上增加了一层SSL or TLS层，该层可以有效的进行通信双方的安全验证，加密传输。

#### 3. 中间人攻击

> 在密码学和计算机安全领域中，中间人攻击（英语：Man-in-the-middle attack，缩写：MITM）是指攻击者与通讯的两端分别创建独立的联系，并交换其所收到的数据，使通讯的两端认为他们正在通过一个私密的连接与对方直接对话，但事实上整个会话都被攻击者完全控制。在中间人攻击中，攻击者可以拦截通讯双方的通话并插入新的内容。在许多情况下这是很简单的（例如，在一个未加密的Wi-Fi 无线接入点的接受范围内的中间人攻击者，可以将自己作为一个中间人插入这个网络）。
>
> 一个中间人攻击能成功的前提条件是攻击者能将自己伪装成每一个参与会话的终端，并且不被其他终端识破。中间人攻击是一个（缺乏）相互认证的攻击。大多数的加密协议都专门加入了一些特殊的认证方法以阻止中间人攻击。例如，SSL协议可以验证参与通讯的一方或双方使用的证书是否是由权威的受信任的数字证书认证机构颁发，并且能执行双向身份认证。
>
> ​														                    — 摘自维基百科

图示:

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fu04x8hk1oj316e0my0ug.jpg)



#### 4. HTTPS工作原理（TLS/SSL 握手）

a. 客户端请求https网站

b. https网站返回服务器证书

> 证书 = 服务器pubic key + CA private key (数字签名)
>
> 数字签名 = hash(服务器public key)

c. 客户端对服务器返回的证书做信任有效校验

> 信任: 检查该证书是否由系统内置的已经信任的证书机构颁发
>
> > 客户端对服务器返回的证书里面的public key 做 hash 运算得到 result1.
> >
> > 客户端取出服务器端证书的签发者在系统里面的CA public key,解密被加密的数字签名，得到结果result2.
> >
> > 比较result1 与 result2的值，如果一致,则该服务器证书是可以被信任的。否则，提示用户.
> >
> > ps: 因为 数字签名是被 CA的private key加密的，如果能够使用 该 CA的public key解密,就说明该证书的确是由该受信任的CA颁发的。再结合 result1 与 result2的值比较，就可以判断数据在传输的过程中是否被修改。
>
> 有效: 检查该证书的生效时间是否有效,证书上的域名是否等于当前访问的域名

d. 随机生成一个加密用字符串,使用服务器的public key进行加密传输。

e. 服务器使用自己的private key 解密客户端传输过来的数据，获的客户端的加密秘钥。然后随机生成一个加密用	字符串,使用客户端的加密秘钥加密传输【服务器端获得了客户端的对称加密秘钥】

f. 客户端使用上阶段的秘钥解密服务器传回的内容，解密获得服务器端的对称加密秘钥【客户端获得了服务器端的对称加密秘钥】

g. 双方协商出来了各自使用的对称加密秘钥之后，就可以传送应用层数据了







