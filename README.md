# Proje hakkında

Turkcell grup şirketi Atmosware'de 22 Temmuz 2024 - 15 Ağustos 2024 tarihleri arasında zorunlu yaz stajımı yapmış bulunmaktayım.
Staj sürecinde yaptığım bu Rent A Car projesi benim ilk back-end projem.
Bu projeyle birlikte backende dair her şeyi neredeyse sıfırdan öğrendim.
Spring Framework-Spring Boot temellerini attım,
Spring Data JPA, ORM kullanımı, CRUD işlemleri hakkında bilgilendim,
Swagger kullanarak API'lerin belgelenmesi ve test edilmesini öğrendim,
Java dilinde bildiğimi sandığım ama aslında yanlış bildiğim ya da hiç bilmediğim kısımları öğrendim, pekiştirdim.

# Projede Kullanılanlar

### One to many - Many to one
One-to-Many ve Many-to-One ilişkileri, veritabanı modellemesinde oldukça yaygın kullanılan kavramlardır. Bu ilişkiler, veritabanı tabloları arasında anlamlı ve düzenli bir veri akışını sağlar.
One-to-Many bir kayıttan birçok kayda işaret ederken,
Many-to-One birçok kaydın bir kayda işaret ettiğini belirtir. Bu ilişki türleri, projelerde veri bütünlüğünü ve organizasyonunu korumak için kritik öneme sahiptir.

### Controller'da kullanılan Mapping kavramları
Mapping kavramları, HTTP isteklerini belirli kontrolör metodlarına yönlendirmek için kullanılır. Bu, uygulamanın farklı URL'ler ve HTTP metodları aracılığıyla çeşitli işlemleri gerçekleştirmesini sağlar. Her bir mapping tipi, RESTful web servislerinde belirli bir HTTP metodunu (GET, POST, PUT, DELETE) temsil eder ve buna göre ilgili işlevi yerine getirir.

1. @RequestMapping:

Bu anotasyon, bir URL'yi ve HTTP metodunu bir kontrolör metoduna eşler. Hem sınıf hem de metod seviyesinde kullanılabilir.

2. @GetMapping:

@RequestMapping anotasyonunun bir varyantıdır ve özellikle GET istekleri için kullanılır.

3. @PostMapping:

POST istekleri için kullanılır. Genellikle yeni bir kaynak oluşturmak için kullanılır.

4. @PutMapping:

PUT istekleri için kullanılır. Var olan bir kaynağı güncellemek için kullanılır.

5. @DeleteMapping:

DELETE istekleri için kullanılır. Var olan bir kaynağı silmek için kullanılır.

## Swagger Entegrasyonu
Bu projede, geliştirilen RESTful API'lerin belgelenmesi ve test edilmesi için Swagger kullanılmıştır. Swagger, API'lerin nasıl çalıştığını anlamayı kolaylaştıran bir kullanıcı arayüzü sağlar ve geliştiricilere API'leri test etme olanağı sunar.Proje çalıştırıldığında, Swagger arayüzüne genellikle şu URL üzerinden erişebilirsiniz: 
http://localhost:8080/swagger-ui/index.html  
Bu sayfa üzerinden API'lerinize ait tüm uç noktalara erişebilir ve işlemleri test edebilirsiniz.
















