# Cloud enterprise Platform Configurationserver
1. Create a bare git repo in user home of the host
2. docker run -itd --hostname platform.git.com --publish 443:443 --publish 80:80 --publish 4022:22  --name gitlab --restart always --volume /srv/gitlab/config:/etc/gitlab --volume /srv/gitlab/logs:/var/log/gitlab --volume /srv/gitlab/data:/var/opt/gitlab gitlab/gitlab-ce:latest
3. docker run -itd --hostname platform.configuration.com -p 9000:9000 --restart always  --name platform-configuration   platform/configuration
