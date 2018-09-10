#### 1. 对于untracked文件的忽略
> 将文件添加到.gitignore即可

#### 2. 对于已经add的，提交到index的文件
> a.使用命令 git rm --cached files ,删除暂存区上的文件
>   b.将文件添加到 .gitignore 即可

#### 3. 对于已经commit的文件 or tracked的文件
> 使用命令 git update-index --assume-unchanged  files
>   告诉git 不去检查文件的改动

  

## 引申
对于项目上的配置文件如何忽略。

```
因为会存在这样的一种场景，就是项目上有一些配置文件，比如数据库连接配置，每个开发人员clone下来的时候都是会去修改此文件的。虽然使用上述3的方法的确可以忽略自己修改的配置文件，但是比较好的做法是:

项目提供一个模板文件*.datasource.conf.example,然后每个开发人员clone下来之后复制一份命名为*.datasource.conf,最后使用上述1中的方法添加到 .gitignore中去。

```



