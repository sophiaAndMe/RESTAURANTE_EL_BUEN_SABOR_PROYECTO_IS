@echo off
echo ==========================================
echo      APAGANDO SISTEMA EL BUEN SABOR
echo ==========================================

echo [1/2] Deteniendo Bases de Datos...
docker-compose stop

echo [2/2] Cerrando procesos Java (Forzado)...
taskkill /F /IM java.exe

echo.
echo Sistema apagado correctamente.
pause