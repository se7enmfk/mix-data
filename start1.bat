@echo off
SET NGINX_DIR=C:\ftx-nginx\
set main_path=mix
set nginx_config_path=mix-nginx
set port=84
set project_path=mix-web
rd %NGINX_DIR%\webapps\%main_path% /s /q
xcopy .\%project_path%\%nginx_config_path%.conf %NGINX_DIR%\conf\conf.d\ /h /d /y
echo d | xcopy .\%project_path%\dist %NGINX_DIR%\webapps\%main_path% /S /h /c /y /Q
cd /D "%NGINX_DIR%"
tasklist | findstr /i "nginx.exe"
echo "nginx is running, stopping..."
rem nginx -s stop
TASKKILL /F /IM nginx.exe /T
echo "stop ok"
start "" "nginx.exe"
start iexplore "http://localhost:%port%"
rem start chrome "http://localhost:%port%"
pause
