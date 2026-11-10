# Levantamiento Nativo (Frontend + Backend)

Esta guía explica cómo ejecutar el sistema localmente sin Docker, en entorno de desarrollo.

## Prerrequisitos

| Herramienta | Versión Mínima |
|-------------|----------------|
| Java (JDK) | 21 |
| Maven | 3.9+ |
| Node.js | 20+ |
| npm | 10+ |
| MySQL | 8.0 |

---

## Parte A: Backend (Spring Boot)

### 1. Configurar la base de datos MySQL

```bash
# Crear la base de datos
mysql -u root -p
CREATE DATABASE sistema_turnos;
EXIT;
```

### 2. Configurar variables de entorno

Crea un archivo `.env` o exporta las variables antes de ejecutar:

```bash
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=sistema_turnos
export DB_USER=root
export DB_PASSWORD=root
export JWT_SECRET=cambiame-en-produccion-minimo-256-bits-para-hs256-algoritmo
export CORS_ORIGINS=http://localhost:5173
```

### 3. Ejecutar el backend

Desde la raíz del proyecto backend:

```bash
cd d:/desarrollo/repo/sistema-medico-modular-sinapprunner-backend

# Compilar y ejecutar con Maven
./mvnw spring-boot:run -pl app-runner -am
```

O si prefieres compilar primero y luego ejecutar el JAR:

```bash
./mvnw clean package -DskipTests -pl app-runner -am
java -jar app-runner/target/*.jar
```

El backend estará disponible en: **http://localhost:8080**

---

## Parte B: Frontend (React + Vite)

### 1. Instalar dependencias

```bash
cd d:/desarrollo/repo/sistema-medico-modular-sinapprunner-frontend
npm install
```

### 2. Ejecutar en modo desarrollo

```bash
npm run dev
```

El frontend estará disponible en: **http://localhost:5173**

Vite tiene configurado un proxy que redirige `/api` → `http://localhost:8080`, por lo que las peticiones API funcionan automáticamente.

### 3. Construir para producción

```bash
npm run build
```

Los archivos estáticos se generan en `dist/` y pueden ser servidos por cualquier servidor web (Nginx, Apache, etc.).

---

## Flujo de Trabajo Completo

1. Iniciar MySQL en puerto 3306
2. Ejecutar el backend (puerto 8080)
3. Ejecutar el frontend (puerto 5173)
4. Abrir el navegador en `http://localhost:5173`

---

## Solución de Problemas

| Problema | Solución |
|----------|----------|
| Puerto 8080 en uso | Cambiar `server.port` en `application.yml` |
| Puerto 5173 en uso | Vite asignará automáticamente otro puerto |
| Error de conexión a BD | Verificar que MySQL esté corriendo y las credenciales sean correctas |
| CORS error | Asegurar que `CORS_ORIGINS` incluya `http://localhost:5173` |

---
