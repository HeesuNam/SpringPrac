package com.hw.prac2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 기본생성자를 대신 생성
@Entity // 테이블임을 나타냄
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Course(CourseRequestDTO requestDto) {
        this.title = requestDto.getTilte();
        this.tutor = requestDto.getTutor();
    }

    public void update(CourseRequestDTO course) {
        this.title = course.getTilte();
        this.tutor = course.getTutor();
    }

}