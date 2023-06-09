package org.jinblog.git_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity // VO라는걸 알려주는거
@Table(name="member") //어느 테이블에서 정보를 연동시킬지
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Column(name="id")
    @Id
    private String id;
    @Column
    private String password;
    @Column
    private String tel;
    @Column
    private String name;
    @Column
    private String nickname;

    public MemberEntity(String id, String name, String nickname) {
        super();
        this.id=id;
        this.name=name;
        this.nickname=nickname;
    }
}
