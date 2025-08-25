# MyBooks - Despliegue en Render

## Cambios realizados para migrar de H2 a MongoDB

### 1. Dependencias actualizadas en pom.xml:
- Removida: `spring-boot-starter-data-jpa` y `h2`
- Agregadas: `spring-boot-starter-data-mongodb` y `spring-boot-starter-actuator`

### 2. Entidades convertidas a MongoDB:
- `@Entity` → `@Document(collection = "nombre_coleccion")`
- `@GeneratedValue(strategy = GenerationType.SEQUENCE)` → Removido
- IDs cambiados de `Long` a `String`
- Relaciones `@ManyToOne` → `@DBRef`

### 3. Repositorios actualizados:
- `JpaRepository<Entity, Long>` → `MongoRepository<Entity, String>`

### 4. Servicios y Controladores:
- Parámetros de ID cambiados de `Long` a `String`
- Métodos `.getReferenceById()` → `.findById().orElse()`

### 5. Configuración de MongoDB:
```properties
spring.data.mongodb.uri=${MONGODB_URI:mongodb+srv://...}
spring.data.mongodb.database=${MONGODB_DATABASE:MyBookDB}
```

## Instrucciones de despliegue en Render

### 1. Preparación del código:
```bash
git add .
git commit -m "Migración de H2 a MongoDB para despliegue en Render"
git push origin main
```

### 2. Crear nuevo Web Service en Render:
1. Ve a [render.com](https://render.com) y crea una cuenta
2. Click en "New" → "Web Service"
3. Conecta tu repositorio de GitHub
4. Configura el servicio:
   - **Name**: `mybooks-api`
   - **Branch**: `main`
   - **Runtime**: `Java`
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/MyBooks-0.0.1-SNAPSHOT.jar`

### 3. Variables de entorno:
Agrega las siguientes variables de entorno en Render:
```
MONGODB_URI=mongodb+srv://ettorepw:Diosesfiel1%2B@bibliotecadejunior.y2xvybm.mongodb.net/MyBookDB?retryWrites=true&w=majority&maxPoolSize=10&serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&socketTimeoutMS=0
MONGODB_DATABASE=MyBookDB
PORT=10000
```

### 4. Configuración adicional:
- **Health Check Path**: `/actuator/health`
- **Plan**: Free (para comenzar)

### 5. CORS configurado para:
- Producción: `https://mybookssoft.netlify.app`
- Desarrollo: `http://localhost:3000`, `http://localhost:5173`

### 6. Base de datos:
La aplicación está configurada para conectarse a MongoDB Atlas con la URL proporcionada. Asegúrate de que:
- La base de datos `MyBookDB` esté creada en MongoDB Atlas
- Las credenciales sean correctas
- La IP de Render esté en la whitelist de MongoDB Atlas (o usar 0.0.0.0/0 para permitir todas)

## Endpoints de la API:
- `GET /api/books` - Listar todos los libros
- `POST /api/books` - Crear nuevo libro
- `GET /api/books/{id}` - Obtener libro por ID
- `PUT /api/books/{id}` - Actualizar libro
- `DELETE /api/books/{id}` - Eliminar libro

Similar para `/api/authors`, `/api/categories`, `/api/publisher`

## Health Check:
- `GET /actuator/health` - Estado de la aplicación

## Notas importantes:
1. Los IDs ahora son strings generados automáticamente por MongoDB
2. Las relaciones se manejan mediante `@DBRef`
3. La aplicación puede tardar unos minutos en iniciar en el plan gratuito de Render
4. Render puede suspender la aplicación por inactividad (plan gratuito)
