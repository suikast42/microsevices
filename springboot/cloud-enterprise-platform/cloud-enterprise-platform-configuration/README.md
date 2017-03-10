# Cloud enterprise Platform Configurationserver over File System Backend 
1. Create ${user.home}/cloudenterprise/platform/configurations
  The configfiles must be stored subfolder as {appname}/{profile}/appname.<properties|yml> 
2. docker run -itd --hostname platform.configuration -p 9000:9000 --restart always --name platform-configuration --volume /c/Users/vuru:/root  platform/configuration
