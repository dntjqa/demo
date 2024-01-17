package com.thc.sprapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // 각 테이블의 컬럼에 접근하기 위해 설정
@ToString(callSuper = true) // 테이블 상세 내용 출력
@Table(indexes = {
        @Index(columnList = "title")
}) //테이블 인덱스 등 세부 내용 설정을 위한 부분
@Entity
public class Tbboard extends AuditingFields {
    /*
    @Id // PK로 사용될 것을 정하는 코드
    @GeneratedValue(strategy = GenerationType.UUID) //PK를 자동생성하기 위한 방법 정하기
    private String id; // 인덱스
    */

    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    protected Tbboard(){} //생성자 못쓰게 하기 위해 protected 사용!
    private Tbboard(String title, String content) {
        this.title = title;
        this.content = content;
    } //생성자 못쓰게 하기 위해 private로 사용! => 밑에 of로만 생성하도록 유도
    public static Tbboard of(String title, String content) {
        return new Tbboard(title, content);
    }
    public static Tbboard of(String title) {
        return new Tbboard(title, "");
    }
}
