### 脚本如下
1. 下载nginx
2. 下载openssl
3. 配置参数
4. 编译
5. 备份并替换
6. 升级

```
wget http://nginx.org/download/nginx-1.14.0.tar.gz
wget http://www.openssl.org/source/openssl-1.0.0d.tar.gz

./configure --prefix=/usr/local/nginx --add-module=/software/nginx_upstream_check_module-master --with-openssl=/software/openssl-1.0.0d --with-http_ssl_module
make

mv /usr/local/nginx/sbin/nginx /usr/local/nginx/sbin/nginx.old

cp nginx /usr/local/nginx/sbin/

make upgrade
```

#### 主要操作截图
- 配置参数
![](https://ws4.sinaimg.cn/large/0069RVTdgy1fu4d4ttettj31kw041tem.jpg)
 


- 编译
![](https://ws4.sinaimg.cn/large/0069RVTdgy1fu4d6qi5ytj30uo0fsdnx.jpg)


- 检查编译结果
![](https://ws2.sinaimg.cn/large/0069RVTdgy1fu4d9a1bx1j31kw0cwqei.jpg)


- 备份并替换
![](https://ws4.sinaimg.cn/large/0069RVTdgy1fu4dcj1zyqj30pu042wg8.jpg)


- 升级
![](https://ws4.sinaimg.cn/large/0069RVTdgy1fu4ddggwd1j30vy076ae3.jpg)


- 检查是否成功
![](https://ws2.sinaimg.cn/large/0069RVTdgy1fu4delq6p8j31kw03k42a.jpg)


