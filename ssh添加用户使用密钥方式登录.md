#### ssh添加用户使用密钥方式登录

```
1.useradd git
2.passwd git [可选]
3.su git
4.cd /home/git/
5.ssh-keygen [生成.ssh 目录]
6.vim .ssh/authorized_keys [将客户端公钥填入]

更改权限，否则没法使用秘钥登录

7.chmod 755 .ssh/
8.chmod 644 .ssh/authorized_keys

以下为可选项 在root下执行
9.vim /etc/ssh/sshd_config
  PermitRootLogin no #禁止root通过ssh登录
  PermitEmptyPasswords no #禁止密码为空的帐号登录
  PasswordAuthentication no #禁止使用密码登录
  
重启ssh
10. systemctl restart sshd
```

