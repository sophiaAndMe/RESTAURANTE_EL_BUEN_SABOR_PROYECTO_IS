@echo off
TITLE Orquestador El Buen Sabor
echo ==========================================
echo    INICIANDO RESTAURANTE EL BUEN SABOR
echo ==========================================

:: 1. Levantar Bases de Datos en Docker (Segundo plano)
echo [1/5] Iniciando Bases de Datos (Docker)...
docker-compose up -d reservas-db usuarios-db

:: Esperamos 10 segundos para asegurarnos que las BD esten listas
echo Esperando 10 segundos a que las BD arranquen...
timeout /t 10 /nobreak >nul

:: 2. Discovery Server (Necesita arrancar primero)
echo [2/5] Lanzando Discovery Server...
start "Discovery Server" cmd /k "cd discovery && mvnw spring-boot:run"

:: Esperamos 15 segundos a que Eureka este listo antes de lanzar los demas
echo Esperando 15 segundos a que Eureka despierte...
timeout /t 15 /nobreak >nul

:: 3. Microservicio Reservas (Conectado a MySQL Docker)
echo [3/5] Lanzando Reservas Service...
start "Reservas Service" cmd /k "cd reservas && mvnw spring-boot:run -Dspring.datasource.url=jdbc:mysql://localhost:3307/elbuensabor_db"

:: 4. Microservicio Usuarios (Conectado a Postgres Docker)
echo [4/5] Lanzando Usuarios Service...
start "Usuarios Service" cmd /k "cd usuario && mvnw spring-boot:run -Dspring.datasource.url=jdbc:postgresql://localhost:5532/elbuensabor_db"

:: 5. Gateway (La puerta de entrada)
echo [5/5] Lanzando Gateway...
start "Gateway Server" cmd /k "cd gateway && mvnw spring-boot:run"

echo ==========================================
echo      TODO EL SISTEMA ESTA ARRANCANDO
echo ==========================================
echo.
echo - Las bases de datos corren en Docker (ocultas).
echo - Se han abierto 4 ventanas nuevas para los servicios.
echo - No cierres esas ventanas o apagaras el servidor.
echo.
pause