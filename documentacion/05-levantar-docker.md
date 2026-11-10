# Levantamiento con Docker Compose

Esta guía explica cómo ejecutar todo el sistema (MySQL + Backend + Frontend) usando Docker Compose.

## Prerrequisitos

| Herramienta | Versión |
|-------------|---------|
| Docker | 29+ |
| Docker Compose | v2.40+ |

## Estructura de Servicios

```yaml
services:
  mysql:      # MySQL 8.0 → puerto 3311 (host) / 3306 (contenedor)
  backend:    # Spring Boot → puerto 8080
  frontend:   # React + Nginx → puerto 3000 (host) / 80 (contenedor)
```

## Comandos

Desde el directorio `d:/desarrollo/repo/sistema-medico-modular-sinapprunner-backend/`:

```bash
# Levantar todos los servicios (construye imágenes si es necesario)
docker compose up --build

# Levantar en segundo plano (modo detached)
docker compose up -d --build

# Ver logs en tiempo real
docker compose logs -f

# Detener y eliminar contenedores, redes y volúmenes
docker compose down -v

# Solo detener (sin eliminar volúmenes)
docker compose stop
```

## Puertos Expuestos

| Servicio | Puerto Host | Puerto Contenedor | Acceso |
|----------|-------------|-------------------|--------|
| MySQL | 3311 | 3306 | `mysql -h localhost -P 3311 -u root -p` |
| Backend | 8080 | 8080 | `http://localhost:8080` |
| Frontend | 3000 | 80 | `http://localhost:3000` |

## Variables de Entorno

Puedes crear un archivo `.env` en el mismo directorio que `docker-compose.yml`:

```env
DB_PASSWORD=root
DB_USER=root
JWT_SECRET=cambiame-en-produccion-minimo-256-bits-para-hs256-algoritmo
CORS_ORIGINS=http://localhost:5173,http://localhost:3000
```

## Flujo de Inicialización

1. **MySQL** inicia y se marca como healthy
2. **Backend** espera a que MySQL esté healthy, luego inicia y ejecuta el `DataSeeder` (crea usuario admin)
3. **Frontend** espera a que el backend esté disponible, luego inicia Nginx

## Usuario Admin por Defecto

Al iniciar por primera vez, el sistema crea automáticamente:

| Campo | Valor |
|-------|-------|
| Usuario | `admin` |
| Contraseña | `admin123` |
| Rol | `ADMIN` |

---
