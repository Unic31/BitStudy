package mycar.data;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
//자동으로 minicar라는 테이블이 mysql에 생성됨
@Table(name="minicar")
@Data
public class MyCarDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //시퀀스컬럼이 됨
    private Long num;

    @Column(name="carname",length = 100)
    private String carname;
    @Column(name = "carprice")
    private int carprice;
    @Column(name = "carcolor")
    private String carcolor;
    @Column(name = "carphoto")
    private String carphoto;

    //날짜는 수정시 컬럼 제외
    @Column(name = "writeday",updatable = false)
    @CreationTimestamp
    private Timestamp writeday;
}
