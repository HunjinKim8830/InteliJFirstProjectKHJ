package org.jinblog.git_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.Date;

@Data
@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {
    @Column(name="postNo")
    @Id
    private int postNo;
    @Column
    private String category;
    @Column
    private String title;
    @Lob
    private Clob content;
    @Column
    private String id;
    @Column
    private Date postDate;
    @Column
    private Date updateDate;

}
