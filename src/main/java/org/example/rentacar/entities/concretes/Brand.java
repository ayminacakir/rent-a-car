package org.example.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model>models; //List<Model> ifadesi,liste veri yapısını temsil eder. Bu liste, Model türünde nesneler içerir.Brand sınıfında models adlı bir alan tanımlar.
}


/* @OneToMany(mappedBy = "brand")
    private List<Model>models =>  bunun açıklaması aşağıda:

brands Tablosu:
id	name
1	Toyota
2	Ford
models Tablosu:
id	name	brand_id
1	Camry	1
2	Corolla	1
3	Mustang	2
Bu kod, nesneler arası ilişkileri ve veritabanı tabloları arasındaki ilişkileri net bir şekilde tanımlar.
Brand sınıfında tanımlanan models alanı, bir markanın sahip olduğu tüm modellerin listesini tutar ve bu liste, Model sınıfında brand alanıyla ilişkilidir.
 */