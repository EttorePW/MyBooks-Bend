# 📚 MyBooks Backend - Sistema de Gestión de Biblioteca Personal

API REST robusta para gestión de bibliotecas personales desarrollada con Spring Boot 3.5.3. Utiliza H2 Database para almacenamiento y está optimizada para deployment en Railway.

## 🌟 Características

- ✅ **CRUD completo de libros** - Gestión completa de biblioteca personal
- ✅ **Gestión de autores** - Crear y mantener catálogo de autores
- ✅ **Gestión de editoriales** - Administrar información de publishers
- ✅ **Sistema de categorías** - Clasificación por géneros literarios
- ✅ **Estados de lectura** - Seguimiento de libros leídos/por leer
- ✅ **API REST documentada** - Swagger/OpenAPI 3 integrado
- ✅ **Base de datos H2** - Archivo local (desarrollo) / Memoria (producción)
- ✅ **Deploy en Railway** - Configuración optimizada
- ✅ **CORS configurado** - Listo para frontend web

## 🚀 Tecnologías

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.5.3** - Framework principal
- **Spring Data JPA** - ORM para base de datos
- **H2 Database** - Base de datos embebida
- **Swagger/OpenAPI 3** - Documentación automática de API
- **Lombok** - Reducción de boilerplate code
- **Maven** - Gestión de dependencias y build
- **Railway** - Plataforma de deployment

## 🛠️ Configuración Local

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+ (o usar el wrapper incluido)

### Instalación y Ejecución

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/EttorePW/MyBooks-Bend.git
   cd MyBooks-Bend
   ```

2. **Ejecuta la aplicación**:
   ```bash
   # Usando Maven wrapper
   ./mvnw spring-boot:run
   
   # O compilar y ejecutar JAR
   ./mvnw clean package -DskipTests=true
   java -jar target/MyBooks-0.0.1-SNAPSHOT.jar
   ```

3. **Verifica que funciona**:
   - API: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui/index.html
   - H2 Console: http://localhost:8080/h2-console

## 📖 API Endpoints

### Swagger UI
- **URL**: `http://localhost:8080/swagger-ui/index.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

### Base de Datos (Desarrollo)
- **H2 Console**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:file:./data/MyBooksDB`

### Endpoints Principales

#### Libros
```http
GET    /api/books          # Obtener todos los libros
GET    /api/books/{id}     # Obtener libro por ID
POST   /api/books          # Crear nuevo libro
PUT    /api/books/{id}     # Actualizar libro
DELETE /api/books/{id}     # Eliminar libro
```

#### Autores
```http
GET    /api/authors          # Obtener todos los autores
POST   /api/authors          # Crear nuevo autor
```

#### Editoriales
```http
GET    /api/publishers          # Obtener todas las editoriales
POST   /api/publishers          # Crear nueva editorial
```

## 🚀 Deployment en Railway

### Configuración Automática
El proyecto incluye configuración optimizada para Railway:
- **`nixpacks.toml`** - Configuración de build con Java 17
- **`Procfile`** - Comando de inicio alternativo
- **`application-railway.properties`** - Configuración para producción

### Deployment
1. **Conecta tu repositorio** en Railway
2. **Variables de entorno** (opcionales, para mayor seguridad):
   ```
   SPRING_PROFILES_ACTIVE=railway
   ```
3. **Deploy automático** - Railway detecta cambios en main branch

### URLs de Producción
- **API Base**: `https://tu-mybooks.railway.app`
- **Swagger UI**: `https://tu-mybooks.railway.app/swagger-ui/index.html`

## 🧪 Testing

### Ejecutar Tests
```bash
./mvnw test

# Tests específicos
./mvnw test -Dtest=BookControllerTest

# Con coverage
./mvnw test jacoco:report
```

### Testing Manual
```bash
# Health check
curl https://tu-mybooks.railway.app/actuator/health

# Obtener libros
curl https://tu-mybooks.railway.app/api/books

# Crear libro
curl -X POST https://tu-mybooks.railway.app/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Mi Libro","author":"Autor","publisher":"Editorial","description":"Descripción","category":"Categoría","place":"Estante A","hasFinished":false}'
```

### Variables de Entorno
| Variable | Descripción | Default | Requerido |
|----------|-------------|---------|-----------|
| `PORT` | Puerto del servidor | 8080 | ❌ (Railway lo asigna) |
| `DATABASE_URL` | Connection URL | jdbc:h2:mem:mybooksdb | ❌ |
| `H2_CONSOLE_ENABLED` | Habilitar consola H2 | false | ❌ |
| `SPRING_PROFILES_ACTIVE` | Perfil activo de Spring | railway | ❌ |

### Configuración Avanzada
```properties
# application-railway.properties
server.port=${PORT}
spring.datasource.url=jdbc:h2:mem:mybooksdb
spring.h2.console.enabled=${H2_CONSOLE_ENABLED:false}
```

## 🤝 Contribuciones

1. Fork el proyecto  
2. Crea una rama feature (`git checkout -b feature/AmazingFeature`)  
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)  
4. Push a la rama (`git push origin feature/AmazingFeature`)  
5. Abre un Pull Request

### Guías de Contribución
- Seguir convenciones de Spring Boot  
- Añadir tests para nuevas funcionalidades  
- Documentar cambios en la API  
- Mantener compatibilidad con versiones anteriores

## ⚙️ Estructura del Proyecto

```
MyBooks-Bend/
├── .mvn/                          # Maven wrapper config
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── buchverwaltungssoftware/mybooks/
│   │   │       ├── MyBooksApplication.java    # Clase principal
│   │   │       ├── config/                    # Configuraciones
│   │   │       ├── controller/                # REST Controllers
│   │   │       ├── model/                     # Entidades JPA
│   │   │       ├── repository/                # Repositorios
│   │   │       ├── service/                   # Lógica de negocio
│   │   │       └── dtos/                      # Data Transfer Objects
│   │   └── resources/
│   │       ├── application.properties         # Configuración principal
│   │       └── application-railway.properties # Configuración Railway
│   └── test/                                  # Tests unitarios
├── target/                                    # Build artifacts
├── nixpacks.toml                              # Configuración Railway
├── Procfile                                   # Comando de inicio (backup)
├── pom.xml                                    # Dependencias Maven
└── README.md                                  # Documentación principal
```

## 📝 Notas Importantes

- ⚠️ **Datos en Railway**: Se pierden en cada redeploy (H2 en memoria)
- 🔒 **Seguridad**: H2 Console deshabilitada en producción
- 📊 **Scalabilidad**: Para producción real, considerar migrar a PostgreSQL/MySQL
- 🔧 **Logs**: Configurados para nivel INFO en producción

## 📈 Mejoras Futuras

- 🔐 **Autenticación JWT** - Sistema de usuarios y roles
- 📊 **Métricas avanzadas** - Prometheus/Grafana integration
- 🔄 **Cache Redis** - Para mejorar performance
- 📋 **Paginación** - Para listas grandes de libros
- 🔍 **Búsqueda full-text** - Consulta de texto completo en H2
- 📧 **Notificaciones** - Email/SMS para nuevos lanzamientos
- 🏗️ **Arquitectura hexagonal** - Mejor separación de capas
- 🧪 **Test coverage 100%** - Tests exhaustivos
- 📱 **WebSockets** - Updates en tiempo real

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver [LICENSE](LICENSE) para detalles.

## ✨ Agradecimientos

- **Spring Team** - Por el excelente framework  
- **H2 Database** - Por una base de datos embebida potente  
- **Railway** - Por la plataforma de deployment sencilla  
- **OpenAPI** - Por la documentación automática  
- **Comunidad Open Source** - Por inspiración y recursos

## 👨‍💻 Autor

**EttoreJunior**
- GitHub: [@EttorePW](https://github.com/EttorePW)
- Frontend: [MyBooks-fend](https://github.com/EttorePW/MyBooks-fend)

---

### 📊 Estado del Proyecto

| Aspecto | Estado | Notas |
|---------|--------|-------|
| **Build** | ✅ Funcionando | Maven build exitoso |
| **Tests** | ⚠️ Básicos | Necesita más cobertura |
| **Deployment** | ✅ Railway | Auto-deploy configurado |
| **API Docs** | ✅ Swagger | Documentación completa |
| **Database** | ✅ H2 (Desarrollo/Producción) | Sin persistencia en producción |

---

**Versión**: 0.0.1-SNAPSHOT  
**Última actualización**: Julio 2025  
**Java**: 17  
**Spring Boot**: 3.5.3
