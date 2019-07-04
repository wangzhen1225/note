## 统一认证SSO单点登录







```shell
server {
    listen       80;
    #server_name  localhost;

    #charset koi8-r;
    #access_log  /var/log/nginx/host.access.log  main;

    location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    }

    location /hls {
      	if ($request_uri ~ bim_sso){
             rewrite '^\/hls\/modules\/bim_sso\/(user|org)\/(.*)$'     
             /hls/modules/bim_sso/$1/$2.svc break;
             
             rewrite '^\/hls\/modules\/bim_sso\/(.*)$'   /hls/modules/bim_sso/$1.svc break;
        }

        proxy_pass http://local_tomcat_pool ;
      	proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;

    }

}
```

