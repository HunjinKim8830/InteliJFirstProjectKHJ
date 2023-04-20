package org.jinblog.git_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "authority")
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityEntity implements Serializable {
    @Column(name="id")
    @Id
    private String id;
    @Column
    private String role;
}
