package org.jinblog.git_test.repository;

import org.jinblog.git_test.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String > {
}
