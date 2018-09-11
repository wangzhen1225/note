### Centos 7.5 下安装FTP

##### 一. 安装vsftpd(very secure FTP daemon) 软件

```
yum install -y vsftpd
```

##### 二. 修改默认配置文件

```
vi /etc/vsftpd/vsftpd.conf
```

*修改配置如下:*

> 1. 不允许使用匿名登录
>
>    ```
>    anonymous_enable=NO
>    ```
>
> 2. 允许使用本地帐户进行FTP用户登录验证
>
>    ```
>    local_enable=YES
>    ```
>
> 3. 使用户不能离开主目录
>
>    ```
>    chroot_local_user=YES
>    chroot_list_enable=YES
>    chroot_list_file=/etc/vsftpd/chroot_list
>
>    通过搭配能实现以下几种效果： 
>      ①当chroot_list_enable=YES，chroot_local_user=YES时，在/etc/vsftpd.chroot_list文件中列出的用户，可以切换到其他目录；未在文件中列出的用户，不能切换到其他目录。 
>
>     ②当chroot_list_enable=YES，chroot_local_user=NO时， 
>    在/etc/vsftpd.chroot_list文件中列出的用户，不能切换到其他目录；未在文件中列出的用户，可以切换到其他目录。 
>
>     ③当chroot_list_enable=NO， 
>    chroot_local_user=YES时，所有的用户均不能切换到其他目录。 
>
>     ④当chroot_list_enable=NO， 
>    chroot_local_user=NO时，所有的用户均可以切换到其他目录
>    ```
>
> 4. 创建chroot_list文件，根据需求添加用户
>
>    ```
>    vim /etc/vsftpd/chroot_list
>    ```
>
> 5. 设定支持ASCII模式的上传和下载功能
>
>    ```
>    ascii_upload_enable=YES
>    ascii_download_enable=YES
>
>    FTP传输模式分为2种，一种是ASCLL模式通常用于传输文本类文件，例如：.txt,.html,.md等等
>    另外一种是 BIN模式，通常用于传输二进制数据图片，视频等，例如：.png,.mp4,.zip等
>    ```
>
> 6. 配置文件vsftpd.conf最后添加
>
>    ```
>    allow_writeable_chroot=YES
>
>    不添加会报错
>    500 OOPS: vsftpd: refusing to run with writable root inside chroot()
>    ```



##### 三. 新建FTP用户

```
useradd -d /mnt/ftp -g ftp -s /sbin/nologin ftpuser

-d：指定用户登录时的起始目录
-g：用户组
-s /sbin/nologin 指定用户只能用于FTP登录，拒绝用户登录系统

修改该FTP用户密码
passwd ftpuser

修改FTP目录权限(其他人增加读权限)
chmod o+r /mnt/ftp 
```



##### 四. 设置开机启动

``` systemctl enable vsftpd.service
systemctl enable vsftpd.service
```

