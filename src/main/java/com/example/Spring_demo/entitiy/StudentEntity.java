package com.example.Spring_demo.entitiy;

 import jakarta.persistence.*;
 import lombok.AccessLevel;
 import lombok.Getter;
 import lombok.NoArgsConstructor;
 import lombok.Setter;
 import lombok.experimental.FieldDefaults;
 import org.hibernate.annotations.CreationTimestamp;
 import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter  //Lambok
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
 @Table( name ="student")   // hansi table baglandigni gosterir

public class   StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
            @SequenceGenerator(name ="my_sequance", sequenceName ="my_sequence ") // ilk olaraq db de my_sequence yaratmaliyiq, databazade bir columu saxliyir ardicil sekilde reqem verir i++ kimi
    String id;

    @Column(name = "name", nullable = false)  //db deki kolmu kodaki filde la elaqelendirir
    String name;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "age" )
    String age;
    @Column(name = "sudentCode" , unique = true, nullable = false  )
    String studentCode;

     @CreationTimestamp
     @Column(name = "create at" , nullable = false)
     String createAt;

     @UpdateTimestamp
     @Column(name = "update at"   )
     String updateAt;

//     public StudentEntity(){    @@NoArgsConstructor evvez edir
//
//    }
//
//    public String getId() { return id;    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//
//     public String getCreateAt() {
//         return createAt;
//     }
//
//     public void setCreateAt(String createAt) {
//         this.createAt = createAt;
//     }
//
//     public String getUpdateAt() {
//         return updateAt;
//     }
//
//     public void setUpdateAt(String updateAt) {
//         this.updateAt = updateAt;
//     }
//
//     public String getStudentCode() {
//         return studentCode;
//     }
//
//     public void setStudentCode(String studentCode) {
//         this.studentCode = studentCode;
//     }
 }
