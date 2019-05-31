### SSR 服务端部署



#### 安装 SSR服务端软件

```
yum -y install wget

wget -N --no-check-certificate https://raw.githubusercontent.com/ToyoDAdoubi/doubi/master/ssr.sh && chmod +x ssr.sh && bash ssr.sh

```



#### 安装一键加速内核

参考：[一键安装最新内核并开启 BBR 脚本、Google TCP拥堵算法](https://teddysun.com/489.html)

```
wget --no-check-certificate https://github.com/teddysun/across/raw/master/bbr.sh && chmod +x bbr.sh && ./bbr.sh

```

